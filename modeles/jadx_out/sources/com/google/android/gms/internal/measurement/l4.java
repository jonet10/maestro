package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class l4 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile k1.b f2695a = k1.a.f6940a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f2696b = new Object();

    /* JADX WARN: Can't wrap try/catch for region: R(11:18|(8:20|(1:22)(1:31)|23|(1:25)|27|28|29|30)|32|33|34|35|(1:37)|27|28|29|30) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
    
        if ("com.google.android.gms".equals(r0.packageName) != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(android.content.Context r5, android.net.Uri r6) {
        /*
            java.lang.String r0 = "com.google.android.gms.phenotype"
            java.lang.String r6 = r6.getAuthority()
            boolean r0 = r0.equals(r6)
            r1 = 0
            if (r0 != 0) goto L1d
            java.lang.String r5 = java.lang.String.valueOf(r6)
            java.lang.String r6 = " is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."
            java.lang.String r0 = "PhenotypeClientHelper"
            java.lang.String r5 = r5.concat(r6)
            android.util.Log.e(r0, r5)
            return r1
        L1d:
            k1.b r6 = com.google.android.gms.internal.measurement.l4.f2695a
            boolean r6 = r6.b()
            if (r6 == 0) goto L32
            k1.b r5 = com.google.android.gms.internal.measurement.l4.f2695a
            java.lang.Object r5 = r5.a()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        L32:
            java.lang.Object r6 = com.google.android.gms.internal.measurement.l4.f2696b
            monitor-enter(r6)
            k1.b r0 = com.google.android.gms.internal.measurement.l4.f2695a     // Catch: java.lang.Throwable -> L4b
            boolean r0 = r0.b()     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L4d
            k1.b r5 = com.google.android.gms.internal.measurement.l4.f2695a     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r5 = r5.a()     // Catch: java.lang.Throwable -> L4b
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch: java.lang.Throwable -> L4b
            boolean r5 = r5.booleanValue()     // Catch: java.lang.Throwable -> L4b
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L4b
            return r5
        L4b:
            r5 = move-exception
            goto La3
        L4d:
            java.lang.String r0 = "com.google.android.gms"
            java.lang.String r2 = r5.getPackageName()     // Catch: java.lang.Throwable -> L4b
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> L4b
            if (r0 != 0) goto L79
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r2 = "com.google.android.gms.phenotype"
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L4b
            r4 = 29
            if (r3 >= r4) goto L67
            r3 = r1
            goto L69
        L67:
            r3 = 268435456(0x10000000, float:2.524355E-29)
        L69:
            android.content.pm.ProviderInfo r0 = r0.resolveContentProvider(r2, r3)     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L8a
            java.lang.String r2 = "com.google.android.gms"
            java.lang.String r0 = r0.packageName     // Catch: java.lang.Throwable -> L4b
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L8a
        L79:
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r0 = "com.google.android.gms"
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo(r0, r1)     // Catch: java.lang.Throwable -> L4b android.content.pm.PackageManager.NameNotFoundException -> L8a
            int r5 = r5.flags     // Catch: java.lang.Throwable -> L4b
            r5 = r5 & 129(0x81, float:1.81E-43)
            if (r5 == 0) goto L8a
            r1 = 1
        L8a:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L4b
            k1.c r0 = new k1.c     // Catch: java.lang.Throwable -> L4b
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L4b
            com.google.android.gms.internal.measurement.l4.f2695a = r0     // Catch: java.lang.Throwable -> L4b
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L4b
            k1.b r5 = com.google.android.gms.internal.measurement.l4.f2695a
            java.lang.Object r5 = r5.a()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        La3:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L4b
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.l4.a(android.content.Context, android.net.Uri):boolean");
    }
}
