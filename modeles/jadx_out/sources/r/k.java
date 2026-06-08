package r;

import a4.d0;
import android.content.Context;
import c3.k0;
import t4.n0;
import y2.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public Context f8834a;

    public l a() {
        Context context = this.f8834a;
        if (context == null) {
            throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
        }
        l lVar = new l();
        lVar.f8835a = t.a.a(n.f8843a);
        g5.f fVar = new g5.f(context, 13);
        lVar.f8836b = fVar;
        lVar.f8837l = t.a.a(new m8.q(6, fVar, new g5.g(fVar, 11)));
        g5.f fVar2 = lVar.f8836b;
        lVar.f8838m = new k0(fVar2, 1);
        m6.a a8 = t.a.a(new m8.q(22, lVar.f8838m, t.a.a(new g5.g(fVar2, 16))));
        lVar.f8839n = a8;
        q1.a aVar = new q1.a(10);
        g5.f fVar3 = lVar.f8836b;
        n0 n0Var = new n0(fVar3, a8, aVar);
        m6.a aVar2 = lVar.f8835a;
        m6.a aVar3 = lVar.f8837l;
        lVar.f8840o = t.a.a(new b5.m(new d0(aVar2, aVar3, n0Var, a8, a8, 12), new e2.d(fVar3, aVar3, a8, n0Var, aVar2, a8, a8, 11), new s(aVar2, a8, n0Var, a8, 21), 20));
        return lVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(x4.x1 r6, v6.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof s4.c0
            if (r0 == 0) goto L13
            r0 = r7
            s4.c0 r0 = (s4.c0) r0
            int r1 = r0.f9183l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9183l = r1
            goto L18
        L13:
            s4.c0 r0 = new s4.c0
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f9181a
            int r1 = r0.f9183l
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2c
            if (r1 != r3) goto L26
            p6.a.e(r7)
            goto L45
        L26:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            return r2
        L2c:
            p6.a.e(r7)
            v7.e r7 = o7.m0.f8288a
            v7.d r7 = v7.d.f10884a
            c4.ya r1 = new c4.ya
            r4 = 25
            r1.<init>(r5, r6, r2, r4)
            r0.f9183l = r3
            java.lang.Object r7 = o7.c0.C(r1, r7, r0)
            u6.a r6 = u6.a.f10762a
            if (r7 != r6) goto L45
            return r6
        L45:
            p6.k r7 = (p6.k) r7
            java.lang.Object r6 = r7.f8444a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: r.k.b(x4.x1, v6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(v6.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof s4.b
            if (r0 == 0) goto L13
            r0 = r6
            s4.b r0 = (s4.b) r0
            int r1 = r0.f9172l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9172l = r1
            goto L18
        L13:
            s4.b r0 = new s4.b
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f9170a
            int r1 = r0.f9172l
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2c
            if (r1 != r3) goto L26
            p6.a.e(r6)
            goto L45
        L26:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            return r2
        L2c:
            p6.a.e(r6)
            v7.e r6 = o7.m0.f8288a
            v7.d r6 = v7.d.f10884a
            c4.g r1 = new c4.g
            r4 = 17
            r1.<init>(r5, r2, r4)
            r0.f9172l = r3
            java.lang.Object r6 = o7.c0.C(r1, r6, r0)
            u6.a r0 = u6.a.f10762a
            if (r6 != r0) goto L45
            return r0
        L45:
            p6.k r6 = (p6.k) r6
            java.lang.Object r6 = r6.f8444a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: r.k.c(v6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(x4.g r6, v6.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof s4.d0
            if (r0 == 0) goto L13
            r0 = r7
            s4.d0 r0 = (s4.d0) r0
            int r1 = r0.f9189l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9189l = r1
            goto L18
        L13:
            s4.d0 r0 = new s4.d0
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f9187a
            int r1 = r0.f9189l
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2c
            if (r1 != r3) goto L26
            p6.a.e(r7)
            goto L44
        L26:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            return r2
        L2c:
            p6.a.e(r7)
            v7.e r7 = o7.m0.f8288a
            v7.d r7 = v7.d.f10884a
            s4.e0 r1 = new s4.e0
            r4 = 0
            r1.<init>(r6, r5, r2, r4)
            r0.f9189l = r3
            java.lang.Object r7 = o7.c0.C(r1, r7, r0)
            u6.a r6 = u6.a.f10762a
            if (r7 != r6) goto L44
            return r6
        L44:
            p6.k r7 = (p6.k) r7
            java.lang.Object r6 = r7.f8444a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: r.k.d(x4.g, v6.c):java.lang.Object");
    }
}
