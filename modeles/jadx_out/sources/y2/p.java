package y2;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.util.Log;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class p {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r8) {
        /*
            android.content.SharedPreferences r0 = y2.a0.e(r8)
            r1 = 0
            java.lang.String r2 = "proxy_notification_initialized"
            boolean r0 = r0.getBoolean(r2, r1)
            if (r0 == 0) goto Lf
            goto La2
        Lf:
            java.lang.String r0 = "firebase_messaging_notification_delegation_enabled"
            r1 = 1
            android.content.Context r3 = r8.getApplicationContext()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L39
            android.content.pm.PackageManager r4 = r3.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L39
            if (r4 == 0) goto L39
            java.lang.String r3 = r3.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L39
            r5 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r3 = r4.getApplicationInfo(r3, r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L39
            if (r3 == 0) goto L39
            android.os.Bundle r4 = r3.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L39
            if (r4 == 0) goto L39
            boolean r4 = r4.containsKey(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L39
            if (r4 == 0) goto L39
            android.os.Bundle r3 = r3.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L39
            boolean r0 = r3.getBoolean(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L39
            goto L3a
        L39:
            r0 = r1
        L3a:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 29
            r5 = 0
            if (r3 < r4) goto L9f
            j1.p r3 = new j1.p
            r3.<init>()
            java.lang.String r4 = "error configuring notification delegate for package "
            int r6 = android.os.Binder.getCallingUid()     // Catch: java.lang.Throwable -> L72
            android.content.pm.ApplicationInfo r7 = r8.getApplicationInfo()     // Catch: java.lang.Throwable -> L72
            int r7 = r7.uid     // Catch: java.lang.Throwable -> L72
            if (r6 != r7) goto L85
            android.content.SharedPreferences r4 = y2.a0.e(r8)     // Catch: java.lang.Throwable -> L72
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch: java.lang.Throwable -> L72
            r4.putBoolean(r2, r1)     // Catch: java.lang.Throwable -> L72
            r4.apply()     // Catch: java.lang.Throwable -> L72
            java.lang.Class<android.app.NotificationManager> r1 = android.app.NotificationManager.class
            java.lang.Object r8 = r8.getSystemService(r1)     // Catch: java.lang.Throwable -> L72
            android.app.NotificationManager r8 = (android.app.NotificationManager) r8     // Catch: java.lang.Throwable -> L72
            java.lang.String r1 = "com.google.android.gms"
            if (r0 == 0) goto L74
            r8.setNotificationDelegate(r1)     // Catch: java.lang.Throwable -> L72
            goto L81
        L72:
            r8 = move-exception
            goto L9b
        L74:
            java.lang.String r0 = r8.getNotificationDelegate()     // Catch: java.lang.Throwable -> L72
            boolean r0 = r1.equals(r0)     // Catch: java.lang.Throwable -> L72
            if (r0 == 0) goto L81
            r8.setNotificationDelegate(r5)     // Catch: java.lang.Throwable -> L72
        L81:
            r3.l(r5)
            goto La2
        L85:
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L72
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L72
            java.lang.String r8 = r8.getPackageName()     // Catch: java.lang.Throwable -> L72
            r1.append(r8)     // Catch: java.lang.Throwable -> L72
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> L72
            android.util.Log.e(r0, r8)     // Catch: java.lang.Throwable -> L72
            goto L81
        L9b:
            r3.l(r5)
            throw r8
        L9f:
            b2.t1.x(r5)
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.p.a(android.content.Context):void");
    }

    public static boolean b(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            if (Binder.getCallingUid() != context.getApplicationInfo().uid) {
                Log.e("FirebaseMessaging", "error retrieving notification delegate for package " + context.getPackageName());
                return false;
            }
            if ("com.google.android.gms".equals(((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationDelegate())) {
                if (!Log.isLoggable("FirebaseMessaging", 3)) {
                    return true;
                }
                Log.d("FirebaseMessaging", "GMS core is set for proxying");
                return true;
            }
        } else if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Platform doesn't support proxying.");
        }
        return false;
    }
}
