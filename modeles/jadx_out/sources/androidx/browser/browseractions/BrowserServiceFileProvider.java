package androidx.browser.browseractions;

import a4.x;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.content.FileProvider;
import androidx.core.util.AtomicFile;
import androidx.lifecycle.l;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import m1.b;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY})
@Deprecated
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class BrowserServiceFileProvider extends FileProvider {
    private static final String AUTHORITY_SUFFIX = ".image_provider";
    private static final String CLIP_DATA_LABEL = "image_provider_uris";
    private static final String CONTENT_SCHEME = "content";
    private static final String FILE_EXTENSION = ".png";
    private static final String FILE_SUB_DIR = "image_provider";
    private static final String FILE_SUB_DIR_NAME = "image_provider_images/";
    private static final String LAST_CLEANUP_TIME_KEY = "last_cleanup_time";
    private static final String TAG = "BrowserServiceFP";
    static Object sFileCleanupLock = new Object();

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class FileCleanupTask extends AsyncTask<Void, Void, Void> {
        private final Context mAppContext;
        private static final long IMAGE_RETENTION_DURATION = 604800000;
        private static final long CLEANUP_REQUIRED_TIME_SPAN = 604800000;
        private static final long DELETION_FAILED_REATTEMPT_DURATION = 86400000;

        public FileCleanupTask(Context context) {
            this.mAppContext = context.getApplicationContext();
        }

        private static boolean isImageFile(File file) {
            return file.getName().endsWith("..png");
        }

        private static boolean shouldCleanUp(SharedPreferences sharedPreferences) {
            return System.currentTimeMillis() > sharedPreferences.getLong(BrowserServiceFileProvider.LAST_CLEANUP_TIME_KEY, System.currentTimeMillis()) + CLEANUP_REQUIRED_TIME_SPAN;
        }

        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            SharedPreferences sharedPreferences = this.mAppContext.getSharedPreferences(this.mAppContext.getPackageName() + BrowserServiceFileProvider.AUTHORITY_SUFFIX, 0);
            if (!shouldCleanUp(sharedPreferences)) {
                return null;
            }
            synchronized (BrowserServiceFileProvider.sFileCleanupLock) {
                try {
                    File file = new File(this.mAppContext.getFilesDir(), BrowserServiceFileProvider.FILE_SUB_DIR);
                    if (!file.exists()) {
                        return null;
                    }
                    File[] listFiles = file.listFiles();
                    long currentTimeMillis = System.currentTimeMillis() - IMAGE_RETENTION_DURATION;
                    boolean z9 = true;
                    for (File file2 : listFiles) {
                        if (isImageFile(file2) && file2.lastModified() < currentTimeMillis && !file2.delete()) {
                            Log.e(BrowserServiceFileProvider.TAG, "Fail to delete image: " + file2.getAbsoluteFile());
                            z9 = false;
                        }
                    }
                    long currentTimeMillis2 = z9 ? System.currentTimeMillis() : (System.currentTimeMillis() - CLEANUP_REQUIRED_TIME_SPAN) + DELETION_FAILED_REATTEMPT_DURATION;
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putLong(BrowserServiceFileProvider.LAST_CLEANUP_TIME_KEY, currentTimeMillis2);
                    edit.apply();
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static Uri generateUri(Context context, String str) {
        return new Uri.Builder().scheme(CONTENT_SCHEME).authority(context.getPackageName() + AUTHORITY_SUFFIX).path(l.w(FILE_SUB_DIR_NAME, str, FILE_EXTENSION)).build();
    }

    public static void grantReadPermission(@NonNull Intent intent, @Nullable List<Uri> list, @NonNull Context context) {
        if (list == null || list.size() == 0) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        intent.addFlags(1);
        ClipData newUri = ClipData.newUri(contentResolver, CLIP_DATA_LABEL, list.get(0));
        for (int i = 1; i < list.size(); i++) {
            newUri.addItem(new ClipData.Item(list.get(i)));
        }
        intent.setClipData(newUri);
    }

    @NonNull
    public static b loadBitmap(@NonNull final ContentResolver contentResolver, @NonNull final Uri uri) {
        final ResolvableFuture create = ResolvableFuture.create();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: androidx.browser.browseractions.BrowserServiceFileProvider.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
                    if (openFileDescriptor == null) {
                        create.setException(new FileNotFoundException());
                        return;
                    }
                    Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor());
                    openFileDescriptor.close();
                    ResolvableFuture resolvableFuture = create;
                    if (decodeFileDescriptor == null) {
                        resolvableFuture.setException(new IOException("File could not be decoded."));
                    } else {
                        resolvableFuture.set(decodeFileDescriptor);
                    }
                } catch (IOException e10) {
                    create.setException(e10);
                }
            }
        });
        return create;
    }

    @NonNull
    @UiThread
    public static ResolvableFuture<Uri> saveBitmap(@NonNull Context context, @NonNull Bitmap bitmap, @NonNull String str, int i) {
        StringBuilder u7 = x.u(str, "_");
        u7.append(Integer.toString(i));
        String sb = u7.toString();
        Uri generateUri = generateUri(context, sb);
        ResolvableFuture<Uri> create = ResolvableFuture.create();
        new FileSaveTask(context, sb, bitmap, generateUri, create).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        return create;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class FileSaveTask extends AsyncTask<String, Void, Void> {
        private final Context mAppContext;
        private final Bitmap mBitmap;
        private final Uri mFileUri;
        private final String mFilename;
        private final ResolvableFuture<Uri> mResultFuture;

        public FileSaveTask(Context context, String str, Bitmap bitmap, Uri uri, ResolvableFuture<Uri> resolvableFuture) {
            this.mAppContext = context.getApplicationContext();
            this.mFilename = str;
            this.mBitmap = bitmap;
            this.mFileUri = uri;
            this.mResultFuture = resolvableFuture;
        }

        private void saveFileBlocking(File file) {
            FileOutputStream fileOutputStream;
            AtomicFile atomicFile = new AtomicFile(file);
            try {
                fileOutputStream = atomicFile.startWrite();
            } catch (IOException e10) {
                e = e10;
                fileOutputStream = null;
            }
            try {
                this.mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
                atomicFile.finishWrite(fileOutputStream);
                this.mResultFuture.set(this.mFileUri);
            } catch (IOException e11) {
                e = e11;
                atomicFile.failWrite(fileOutputStream);
                this.mResultFuture.setException(e);
            }
        }

        private void saveFileIfNeededBlocking() {
            File file = new File(this.mAppContext.getFilesDir(), BrowserServiceFileProvider.FILE_SUB_DIR);
            synchronized (BrowserServiceFileProvider.sFileCleanupLock) {
                try {
                    if (!file.exists() && !file.mkdir()) {
                        this.mResultFuture.setException(new IOException("Could not create file directory."));
                        return;
                    }
                    File file2 = new File(file, this.mFilename + BrowserServiceFileProvider.FILE_EXTENSION);
                    if (file2.exists()) {
                        this.mResultFuture.set(this.mFileUri);
                    } else {
                        saveFileBlocking(file2);
                    }
                    file2.setLastModified(System.currentTimeMillis());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Void r32) {
            new FileCleanupTask(this.mAppContext).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }

        @Override // android.os.AsyncTask
        public Void doInBackground(String... strArr) {
            saveFileIfNeededBlocking();
            return null;
        }
    }
}
