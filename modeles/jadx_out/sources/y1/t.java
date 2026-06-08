package y1;

import android.content.SharedPreferences;
import android.util.Log;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f11679a;

    /* renamed from: b, reason: collision with root package name */
    public final n1.f f11680b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f11681c;

    /* renamed from: d, reason: collision with root package name */
    public j1.i f11682d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11683e;
    public boolean f;
    public Boolean g;
    public final j1.i h;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public t(n1.f r8) {
        /*
            r7 = this;
            r7.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r7.f11681c = r0
            j1.i r1 = new j1.i
            r1.<init>()
            r7.f11682d = r1
            r1 = 0
            r7.f11683e = r1
            r7.f = r1
            j1.i r2 = new j1.i
            r2.<init>()
            r7.h = r2
            r8.a()
            android.content.Context r2 = r8.f7908a
            r7.f11680b = r8
            java.lang.String r8 = "com.google.firebase.crashlytics"
            android.content.SharedPreferences r8 = r2.getSharedPreferences(r8, r1)
            r7.f11679a = r8
            java.lang.String r3 = "firebase_crashlytics_collection_enabled"
            boolean r4 = r8.contains(r3)
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L41
            r7.f = r1
            boolean r8 = r8.getBoolean(r3, r6)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            goto L42
        L41:
            r8 = r5
        L42:
            if (r8 != 0) goto L88
            java.lang.String r8 = "firebase_crashlytics_collection_enabled"
            android.content.pm.PackageManager r3 = r2.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            if (r3 == 0) goto L75
            java.lang.String r2 = r2.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            r4 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r2 = r3.getApplicationInfo(r2, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            if (r2 == 0) goto L75
            android.os.Bundle r3 = r2.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            if (r3 == 0) goto L75
            boolean r3 = r3.containsKey(r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            if (r3 == 0) goto L75
            android.os.Bundle r2 = r2.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            boolean r8 = r2.getBoolean(r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L6d
            goto L76
        L6d:
            r8 = move-exception
            java.lang.String r2 = "Could not read data collection permission from manifest"
            java.lang.String r3 = "FirebaseCrashlytics"
            android.util.Log.e(r3, r2, r8)
        L75:
            r8 = r5
        L76:
            if (r8 != 0) goto L7c
            r7.f = r1
            r8 = r5
            goto L88
        L7c:
            r7.f = r6
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r8 = r1.equals(r8)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
        L88:
            r7.g = r8
            monitor-enter(r0)
            boolean r8 = r7.a()     // Catch: java.lang.Throwable -> L99
            if (r8 == 0) goto L9b
            j1.i r8 = r7.f11682d     // Catch: java.lang.Throwable -> L99
            r8.c(r5)     // Catch: java.lang.Throwable -> L99
            r7.f11683e = r6     // Catch: java.lang.Throwable -> L99
            goto L9b
        L99:
            r8 = move-exception
            goto L9d
        L9b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L99
            return
        L9d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L99
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.t.<init>(n1.f):void");
    }

    public final synchronized boolean a() {
        boolean z9;
        Boolean bool = this.g;
        if (bool != null) {
            z9 = bool.booleanValue();
        } else {
            try {
                z9 = this.f11680b.h();
            } catch (IllegalStateException unused) {
                z9 = false;
            }
        }
        b(z9);
        return z9;
    }

    public final void b(boolean z9) {
        String str = "Crashlytics automatic data collection " + (z9 ? "ENABLED" : "DISABLED") + " by " + (this.g == null ? "global Firebase setting" : this.f ? "firebase_crashlytics_collection_enabled manifest flag" : "API") + ".";
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }
}
