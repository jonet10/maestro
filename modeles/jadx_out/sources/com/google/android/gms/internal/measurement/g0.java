package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f2590a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f2591b;

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 6
            java.lang.String r3 = "JobSchedulerCompat"
            r4 = 0
            r5 = 24
            if (r1 < r5) goto L33
            java.lang.Class<android.app.job.JobScheduler> r1 = android.app.job.JobScheduler.class
            java.lang.String r6 = "scheduleAsPackage"
            r7 = 4
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch: java.lang.NoSuchMethodException -> L28
            java.lang.Class<android.app.job.JobInfo> r8 = android.app.job.JobInfo.class
            r9 = 0
            r7[r9] = r8     // Catch: java.lang.NoSuchMethodException -> L28
            r8 = 1
            r7[r8] = r0     // Catch: java.lang.NoSuchMethodException -> L28
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch: java.lang.NoSuchMethodException -> L28
            r9 = 2
            r7[r9] = r8     // Catch: java.lang.NoSuchMethodException -> L28
            r8 = 3
            r7[r8] = r0     // Catch: java.lang.NoSuchMethodException -> L28
            java.lang.reflect.Method r0 = r1.getDeclaredMethod(r6, r7)     // Catch: java.lang.NoSuchMethodException -> L28
            goto L34
        L28:
            boolean r0 = android.util.Log.isLoggable(r3, r2)
            if (r0 == 0) goto L33
            java.lang.String r0 = "No scheduleAsPackage method available, falling back to schedule"
            android.util.Log.e(r3, r0)
        L33:
            r0 = r4
        L34:
            com.google.android.gms.internal.measurement.g0.f2590a = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r5) goto L4e
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.String r1 = "myUserId"
            java.lang.reflect.Method r4 = r0.getDeclaredMethod(r1, r4)     // Catch: java.lang.NoSuchMethodException -> L43
            goto L4e
        L43:
            boolean r0 = android.util.Log.isLoggable(r3, r2)
            if (r0 == 0) goto L4e
            java.lang.String r0 = "No myUserId method available"
            android.util.Log.e(r3, r0)
        L4e:
            com.google.android.gms.internal.measurement.g0.f2591b = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.g0.<clinit>():void");
    }
}
