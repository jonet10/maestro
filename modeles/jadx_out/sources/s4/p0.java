package s4;

import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p0 {

    /* renamed from: b, reason: collision with root package name */
    public static final x7.g f9260b = x7.h.a();

    /* renamed from: a, reason: collision with root package name */
    public final Context f9261a;

    public p0(Context context) {
        context.getClass();
        this.f9261a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0062 A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:11:0x004c, B:13:0x0062, B:14:0x0069), top: B:10:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(s4.p0 r11, v6.c r12) {
        /*
            java.lang.String r0 = "last_events_timestamp"
            android.content.Context r1 = r11.f9261a
            boolean r2 = r12 instanceof s4.o0
            if (r2 == 0) goto L17
            r2 = r12
            s4.o0 r2 = (s4.o0) r2
            int r3 = r2.f9256m
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.f9256m = r3
            goto L1c
        L17:
            s4.o0 r2 = new s4.o0
            r2.<init>(r11, r12)
        L1c:
            java.lang.Object r11 = r2.f9254b
            int r12 = r2.f9256m
            r3 = 1
            r4 = 0
            if (r12 == 0) goto L33
            if (r12 != r3) goto L2c
            x7.g r12 = r2.f9253a
            p6.a.e(r11)
            goto L4c
        L2c:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r11)
            r11 = 0
            return r11
        L33:
            p6.a.e(r11)
            boolean r11 = com.google.android.gms.internal.measurement.z3.f2928c
            if (r11 != 0) goto L3d
            java.lang.Boolean r11 = java.lang.Boolean.FALSE
            return r11
        L3d:
            x7.g r12 = s4.p0.f9260b
            r2.f9253a = r12
            r2.f9256m = r3
            java.lang.Object r11 = r12.lock(r4, r2)
            u6.a r2 = u6.a.f10762a
            if (r11 != r2) goto L4c
            return r2
        L4c:
            r1.getClass()     // Catch: java.lang.Throwable -> L66
            r5 = 0
            long r5 = com.google.android.gms.internal.measurement.z3.t(r5, r1, r0)     // Catch: java.lang.Throwable -> L66
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L66
            long r5 = r7 - r5
            r9 = 300000(0x493e0, double:1.482197E-318)
            int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r11 <= 0) goto L68
            com.google.android.gms.internal.measurement.z3.Q(r7, r1, r0)     // Catch: java.lang.Throwable -> L66
            goto L69
        L66:
            r11 = move-exception
            goto L71
        L68:
            r3 = 0
        L69:
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r3)     // Catch: java.lang.Throwable -> L66
            r12.unlock(r4)
            return r11
        L71:
            r12.unlock(r4)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.p0.a(s4.p0, v6.c):java.lang.Object");
    }
}
