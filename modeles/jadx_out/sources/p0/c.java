package p0;

import android.os.Build;
import android.os.Process;
import com.google.android.gms.internal.measurement.z3;
import m8.q;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f8409a;

    /* renamed from: b, reason: collision with root package name */
    public static int f8410b;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f8411c;

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        if (r2 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a() {
        /*
            java.lang.String r0 = p0.c.f8409a
            if (r0 != 0) goto L75
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L11
            java.lang.String r0 = android.app.Application.getProcessName()
            p0.c.f8409a = r0
            goto L75
        L11:
            int r0 = p0.c.f8410b
            if (r0 != 0) goto L1b
            int r0 = android.os.Process.myPid()
            p0.c.f8410b = r0
        L1b:
            java.lang.String r1 = "/cmdline"
            java.lang.String r2 = "/proc/"
            r3 = 0
            if (r0 > 0) goto L23
            goto L73
        L23:
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            int r4 = r4.length()     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            int r4 = r4 + 14
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            r5.append(r2)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            r5.append(r0)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            r5.append(r1)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L64
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L64
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L64
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L64
            android.os.StrictMode.setThreadPolicy(r1)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L70
            k0.y.g(r0)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L70
            java.lang.String r3 = r0.trim()     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L70
        L5b:
            r2.close()     // Catch: java.io.IOException -> L73
            goto L73
        L5f:
            r0 = move-exception
            r3 = r2
            goto L69
        L62:
            r0 = move-exception
            goto L69
        L64:
            r0 = move-exception
            android.os.StrictMode.setThreadPolicy(r1)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            throw r0     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
        L69:
            if (r3 == 0) goto L6e
            r3.close()     // Catch: java.io.IOException -> L6e
        L6e:
            throw r0
        L6f:
            r2 = r3
        L70:
            if (r2 == 0) goto L73
            goto L5b
        L73:
            p0.c.f8409a = r3
        L75:
            java.lang.String r0 = p0.c.f8409a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.c.a():java.lang.String");
    }

    public static boolean b() {
        Boolean bool = f8411c;
        if (bool == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                bool = Boolean.valueOf(Process.isIsolated());
            } else {
                try {
                    Object Z = a.a.Z(Process.class, "isIsolated", new q[0]);
                    Object[] objArr = new Object[0];
                    if (Z == null) {
                        throw new a1.b(z3.V("expected a non-null reference", objArr));
                    }
                    bool = (Boolean) Z;
                } catch (ReflectiveOperationException unused) {
                    bool = Boolean.FALSE;
                }
            }
            f8411c = bool;
        }
        return bool.booleanValue();
    }
}
