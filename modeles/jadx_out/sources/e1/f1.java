package e1;

import android.content.SharedPreferences;
import java.io.Serializable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f1 {

    /* renamed from: a, reason: collision with root package name */
    public long f3967a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3968b;

    /* renamed from: c, reason: collision with root package name */
    public Serializable f3969c;

    /* renamed from: d, reason: collision with root package name */
    public Serializable f3970d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ f2 f3971e;

    public /* synthetic */ f1(g1 g1Var, long j) {
        this.f3971e = g1Var;
        k0.y.d("health_monitor");
        k0.y.b(j > 0);
        this.f3968b = "health_monitor:start";
        this.f3969c = "health_monitor:count";
        this.f3970d = "health_monitor:value";
        this.f3967a = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007e, code lost:
    
        if (r2 < java.lang.Math.max(0, ((java.lang.Integer) e1.f0.j.a(null)).intValue())) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0097, code lost:
    
        if (r2 >= java.lang.Math.max(0, ((java.lang.Integer) e1.f0.j.a(null)).intValue())) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(long r11, com.google.android.gms.internal.measurement.b3 r13) {
        /*
            r10 = this;
            java.io.Serializable r0 = r10.f3970d
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            if (r0 != 0) goto Ld
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r10.f3970d = r0
        Ld:
            java.io.Serializable r0 = r10.f3969c
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            if (r0 != 0) goto L1a
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r10.f3969c = r0
        L1a:
            java.io.Serializable r0 = r10.f3970d
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 != 0) goto L45
            java.io.Serializable r0 = r10.f3970d
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.b3 r0 = (com.google.android.gms.internal.measurement.b3) r0
            long r2 = r0.t()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r6 = 60
            long r2 = r2 / r6
            long r2 = r2 / r6
            long r8 = r13.t()
            long r8 = r8 / r4
            long r8 = r8 / r6
            long r8 = r8 / r6
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 != 0) goto Lcc
        L45:
            long r2 = r10.f3967a
            int r0 = r13.j()
            long r4 = (long) r0
            long r2 = r2 + r4
            e1.f2 r0 = r10.f3971e
            e1.u4 r0 = (e1.u4) r0
            e1.g r4 = r0.e0()
            e1.e0 r5 = e1.f0.f3924e1
            r6 = 0
            boolean r4 = r4.q(r6, r5)
            if (r4 == 0) goto L81
            java.io.Serializable r4 = r10.f3970d
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L9a
            r0.e0()
            e1.e0 r4 = e1.f0.j
            java.lang.Object r4 = r4.a(r6)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            int r4 = java.lang.Math.max(r1, r4)
            long r4 = (long) r4
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 >= 0) goto Lcc
            goto L9a
        L81:
            r0.e0()
            e1.e0 r4 = e1.f0.j
            java.lang.Object r4 = r4.a(r6)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            int r4 = java.lang.Math.max(r1, r4)
            long r4 = (long) r4
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L9a
            goto Lcc
        L9a:
            r10.f3967a = r2
            java.io.Serializable r2 = r10.f3970d
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r2.add(r13)
            java.io.Serializable r13 = r10.f3969c
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            r13.add(r11)
            java.io.Serializable r11 = r10.f3970d
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            int r11 = r11.size()
            r0.e0()
            e1.e0 r12 = e1.f0.f3935k
            java.lang.Object r12 = r12.a(r6)
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            r13 = 1
            int r12 = java.lang.Math.max(r13, r12)
            if (r11 < r12) goto Lcd
        Lcc:
            return r1
        Lcd:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.f1.a(long, com.google.android.gms.internal.measurement.b3):boolean");
    }

    public void b() {
        g1 g1Var = (g1) this.f3971e;
        g1Var.g();
        g1Var.f3875a.f4269t.getClass();
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = g1Var.k().edit();
        edit.remove((String) this.f3969c);
        edit.remove((String) this.f3970d);
        edit.putLong((String) this.f3968b, currentTimeMillis);
        edit.apply();
    }

    public /* synthetic */ f1(u4 u4Var) {
        this.f3971e = u4Var;
    }
}
