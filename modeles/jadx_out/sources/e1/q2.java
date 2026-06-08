package e1;

import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4211a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4212b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f4213l;

    public q2(b3 b3Var, boolean z9) {
        this.f4212b = z9;
        Objects.requireNonNull(b3Var);
        this.f4213l = b3Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:
    
        if (r3 != r4) goto L32;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r9 = this;
            int r0 = r9.f4211a
            switch(r0) {
                case 0: goto L38;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r9.f4213l
            android.support.v4.media.g r0 = (android.support.v4.media.g) r0
            boolean r1 = r9.f4212b
            if (r1 == 0) goto L10
            java.lang.String r2 = "OK"
            goto L12
        L10:
            java.lang.String r2 = "KO"
        L12:
            boolean r2 = android.support.v4.media.g.b(r0, r2)
            if (r2 == 0) goto L37
            java.lang.Object r0 = r0.f248l
            m4.b r0 = (m4.b) r0
            if (r1 == 0) goto L32
            e2.d r0 = r0.f7281b
            r0.getClass()
            java.lang.Thread r1 = new java.lang.Thread
            m4.c r2 = new m4.c
            r3 = 1
            r2.<init>(r0, r3)
            r1.<init>(r2)
            r1.start()
            goto L37
        L32:
            e2.d r0 = r0.f7281b
            r0.p()
        L37:
            return
        L38:
            java.lang.Object r0 = r9.f4213l
            e1.b3 r0 = (e1.b3) r0
            e1.t1 r1 = r0.f3875a
            boolean r2 = r1.d()
            java.lang.Boolean r3 = r1.H
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L52
            java.lang.Boolean r3 = r1.H
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L52
            r3 = r5
            goto L53
        L52:
            r3 = r4
        L53:
            boolean r6 = r9.f4212b
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
            r1.H = r7
            if (r3 != r6) goto L6d
            e1.w0 r3 = r1.f4264o
            e1.t1.m(r3)
            e1.u0 r3 = r3.f4346w
            java.lang.String r7 = "Default data collection state already set to"
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r6)
            r3.c(r8, r7)
        L6d:
            boolean r3 = r1.d()
            if (r3 == r2) goto L86
            boolean r3 = r1.d()
            java.lang.Boolean r7 = r1.H
            if (r7 == 0) goto L84
            java.lang.Boolean r7 = r1.H
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L84
            r4 = r5
        L84:
            if (r3 == r4) goto L9a
        L86:
            e1.w0 r1 = r1.f4264o
            e1.t1.m(r1)
            e1.u0 r1 = r1.f4344t
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r6)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r4 = "Default data collection is different than actual status"
            r1.d(r3, r4, r2)
        L9a:
            r0.y()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.q2.run():void");
    }

    public q2(android.support.v4.media.g gVar, boolean z9) {
        this.f4213l = gVar;
        this.f4212b = z9;
    }
}
