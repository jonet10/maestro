package androidx.room.support;

import android.content.Context;
import android.util.Log;
import androidx.room.DatabaseConfiguration;
import androidx.room.DelegatingOpenHelper;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.sqlite.util.ProcessLock;
import com.google.android.gms.internal.measurement.z3;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PrePackagedCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    private final Context context;
    private final String copyFromAssetPath;
    private final File copyFromFile;
    private final Callable<InputStream> copyFromInputStream;
    private DatabaseConfiguration databaseConfiguration;
    private final int databaseVersion;
    private final SupportSQLiteOpenHelper delegate;
    private boolean verified;

    public PrePackagedCopyOpenHelper(Context context, String str, File file, Callable<InputStream> callable, int i, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        context.getClass();
        supportSQLiteOpenHelper.getClass();
        this.context = context;
        this.copyFromAssetPath = str;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.databaseVersion = i;
        this.delegate = supportSQLiteOpenHelper;
    }

    private final void copyDatabaseFile(File file, boolean z9) throws IOException {
        ReadableByteChannel newChannel;
        if (this.copyFromAssetPath != null) {
            newChannel = Channels.newChannel(this.context.getAssets().open(this.copyFromAssetPath));
        } else if (this.copyFromFile != null) {
            newChannel = new FileInputStream(this.copyFromFile).getChannel();
        } else {
            Callable<InputStream> callable = this.copyFromInputStream;
            if (callable == null) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
                return;
            } else {
                try {
                    newChannel = Channels.newChannel(callable.call());
                } catch (Exception e10) {
                    throw new IOException("inputStreamCallable exception on call", e10);
                }
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.context.getCacheDir());
        createTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(createTempFile).getChannel();
        channel.getClass();
        FileUtil.copy(newChannel, channel);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            androidx.core.content.pm.a.k(file.getAbsolutePath(), "Failed to create directories for ");
            return;
        }
        dispatchOnOpenPrepackagedDatabase(createTempFile, z9);
        if (createTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    private final SupportSQLiteOpenHelper createFrameworkOpenHelper(File file) {
        try {
            final int readVersion = DBUtil.readVersion(file);
            FrameworkSQLiteOpenHelperFactory frameworkSQLiteOpenHelperFactory = new FrameworkSQLiteOpenHelperFactory();
            SupportSQLiteOpenHelper.Configuration.Builder name = SupportSQLiteOpenHelper.Configuration.Companion.builder(this.context).name(file.getAbsolutePath());
            final int i = readVersion >= 1 ? readVersion : 1;
            return frameworkSQLiteOpenHelperFactory.create(name.callback(new SupportSQLiteOpenHelper.Callback(i) { // from class: androidx.room.support.PrePackagedCopyOpenHelper$createFrameworkOpenHelper$configuration$1
                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                    supportSQLiteDatabase.getClass();
                }

                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                    supportSQLiteDatabase.getClass();
                    int i6 = readVersion;
                    if (i6 < 1) {
                        supportSQLiteDatabase.setVersion(i6);
                    }
                }

                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i6, int i10) {
                    supportSQLiteDatabase.getClass();
                }
            }).build());
        } catch (IOException e10) {
            androidx.privacysandbox.ads.adservices.customaudience.a.m("Malformed database file, unable to read version.", e10);
            return null;
        }
    }

    private final void dispatchOnOpenPrepackagedDatabase(File file, boolean z9) {
        DatabaseConfiguration databaseConfiguration = this.databaseConfiguration;
        if (databaseConfiguration == null) {
            l.i("databaseConfiguration");
            throw null;
        }
        if (databaseConfiguration.prepackagedDatabaseCallback == null) {
            return;
        }
        SupportSQLiteOpenHelper createFrameworkOpenHelper = createFrameworkOpenHelper(file);
        try {
            SupportSQLiteDatabase writableDatabase = z9 ? createFrameworkOpenHelper.getWritableDatabase() : createFrameworkOpenHelper.getReadableDatabase();
            DatabaseConfiguration databaseConfiguration2 = this.databaseConfiguration;
            if (databaseConfiguration2 == null) {
                l.i("databaseConfiguration");
                throw null;
            }
            RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback = databaseConfiguration2.prepackagedDatabaseCallback;
            prepackagedDatabaseCallback.getClass();
            prepackagedDatabaseCallback.onOpenPrepackagedDatabase(writableDatabase);
            z3.k(createFrameworkOpenHelper, null);
        } finally {
        }
    }

    private final void verifyDatabaseFile(boolean z9) {
        String databaseName = getDatabaseName();
        if (databaseName == null) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Required value was null.");
            return;
        }
        File databasePath = this.context.getDatabasePath(databaseName);
        DatabaseConfiguration databaseConfiguration = this.databaseConfiguration;
        if (databaseConfiguration == null) {
            l.i("databaseConfiguration");
            throw null;
        }
        ProcessLock processLock = new ProcessLock(databaseName, this.context.getFilesDir(), databaseConfiguration.multiInstanceInvalidation);
        try {
            ProcessLock.lock$default(processLock, false, 1, null);
            if (!databasePath.exists()) {
                try {
                    copyDatabaseFile(databasePath, z9);
                    processLock.unlock();
                    return;
                } catch (IOException e10) {
                    throw new RuntimeException("Unable to copy database file.", e10);
                }
            }
            try {
                int readVersion = DBUtil.readVersion(databasePath);
                int i = this.databaseVersion;
                if (readVersion == i) {
                    processLock.unlock();
                    return;
                }
                DatabaseConfiguration databaseConfiguration2 = this.databaseConfiguration;
                if (databaseConfiguration2 == null) {
                    l.i("databaseConfiguration");
                    throw null;
                }
                if (databaseConfiguration2.isMigrationRequired(readVersion, i)) {
                    processLock.unlock();
                    return;
                }
                if (this.context.deleteDatabase(databaseName)) {
                    try {
                        copyDatabaseFile(databasePath, z9);
                    } catch (IOException e11) {
                        Log.w(Room.LOG_TAG, "Unable to copy database file.", e11);
                    }
                } else {
                    Log.w(Room.LOG_TAG, "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                }
                processLock.unlock();
                return;
            } catch (IOException e12) {
                Log.w(Room.LOG_TAG, "Unable to read database version.", e12);
                processLock.unlock();
                return;
            }
        } catch (Throwable th) {
            processLock.unlock();
            throw th;
        }
        processLock.unlock();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        getDelegate().close();
        this.verified = false;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return getDelegate().getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        if (!this.verified) {
            verifyDatabaseFile(false);
            this.verified = true;
        }
        return getDelegate().getReadableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        if (!this.verified) {
            verifyDatabaseFile(true);
            this.verified = true;
        }
        return getDelegate().getWritableDatabase();
    }

    public final void setDatabaseConfiguration(DatabaseConfiguration databaseConfiguration) {
        databaseConfiguration.getClass();
        this.databaseConfiguration = databaseConfiguration;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z9) {
        getDelegate().setWriteAheadLoggingEnabled(z9);
    }
}
