package n4;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.system.StructStatVfs;
import androidx.documentfile.provider.DocumentFile;
import java.io.File;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class d {
    public static File a(Context context) {
        File externalStorageDirectory;
        context.getClass();
        h4.a aVar = new h4.a(context);
        if (aVar.d()) {
            File[] externalFilesDirs = context.getExternalFilesDirs(null);
            if (externalFilesDirs.length > 1) {
                externalStorageDirectory = externalFilesDirs[1];
            } else {
                File externalStorageDirectory2 = Environment.getExternalStorageDirectory();
                aVar.g();
                aVar.f();
                externalStorageDirectory = externalStorageDirectory2;
            }
        } else {
            externalStorageDirectory = Environment.getExternalStorageDirectory();
        }
        if (externalStorageDirectory == null) {
            return context.getExternalFilesDir(null);
        }
        File file = new File(externalStorageDirectory.getAbsolutePath() + "/" + context.getResources().getString(2131951718) + "/Backups");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(android.net.Uri r8, androidx.fragment.app.FragmentActivity r9) {
        /*
            r1 = 0
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            r3 = r8
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
            if (r8 == 0) goto L27
            java.lang.String r9 = "_display_name"
            int r9 = r8.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
            r8.moveToFirst()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
            java.lang.String r1 = r8.getString(r9)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
            r8.close()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
            goto L27
        L21:
            r0 = move-exception
        L22:
            r8 = r0
            goto L65
        L24:
            r0 = move-exception
        L25:
            r8 = r0
            goto L48
        L27:
            if (r1 != 0) goto L41
            java.lang.String r8 = r3.getPath()
            if (r8 == 0) goto L41
            java.lang.String r8 = r3.getPath()
            r8.getClass()
            boolean r8 = e(r8)
            if (r8 == 0) goto L41
            java.lang.String r8 = r3.getLastPathSegment()
            return r8
        L41:
            return r1
        L42:
            r0 = move-exception
            r3 = r8
            goto L22
        L45:
            r0 = move-exception
            r3 = r8
            goto L25
        L48:
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L21
            if (r1 != 0) goto L64
            java.lang.String r8 = r3.getPath()
            if (r8 == 0) goto L64
            java.lang.String r8 = r3.getPath()
            r8.getClass()
            boolean r8 = e(r8)
            if (r8 == 0) goto L64
            java.lang.String r1 = r3.getLastPathSegment()
        L64:
            return r1
        L65:
            if (r1 != 0) goto L7d
            java.lang.String r9 = r3.getPath()
            if (r9 == 0) goto L7d
            java.lang.String r9 = r3.getPath()
            r9.getClass()
            boolean r9 = e(r9)
            if (r9 == 0) goto L7d
            r3.getLastPathSegment()
        L7d:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.d.b(android.net.Uri, androidx.fragment.app.FragmentActivity):java.lang.String");
    }

    public static long c(Context context, DocumentFile documentFile) {
        context.getClass();
        documentFile.getClass();
        Uri uri = documentFile.getUri();
        uri.getClass();
        long j = 0;
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            if (openFileDescriptor == null) {
                return 0L;
            }
            StructStatVfs fstatvfs = Os.fstatvfs(openFileDescriptor.getFileDescriptor());
            j = fstatvfs.f_bsize * fstatvfs.f_bavail;
            openFileDescriptor.close();
            return j;
        } catch (Exception e10) {
            e10.printStackTrace();
            return j;
        }
    }

    public static long d(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
    }

    public static boolean e(String str) {
        return l7.u.k0(str, ".apk", true) || l7.u.k0(str, ".xapk", true) || l7.u.k0(str, ".apks", true) || l7.u.k0(str, ".apkm", true) || l7.u.k0(str, ".zip", true);
    }
}
