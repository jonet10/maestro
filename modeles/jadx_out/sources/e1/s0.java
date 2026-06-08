package e1;

import android.content.Context;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class s0 implements j1.e {

    /* renamed from: a, reason: collision with root package name */
    public long f4242a;

    /* renamed from: b, reason: collision with root package name */
    public Object f4243b;

    public s0(Context context, long j) {
        context.getClass();
        this.f4243b = context;
        this.f4242a = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(t6.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof s4.u
            if (r0 == 0) goto L13
            r0 = r6
            s4.u r0 = (s4.u) r0
            int r1 = r0.f9299l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9299l = r1
            goto L18
        L13:
            s4.u r0 = new s4.u
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f9297a
            int r1 = r0.f9299l
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
            r4 = 21
            r1.<init>(r5, r2, r4)
            r0.f9299l = r3
            java.lang.Object r6 = o7.c0.C(r1, r6, r0)
            u6.a r0 = u6.a.f10762a
            if (r6 != r0) goto L45
            return r0
        L45:
            p6.k r6 = (p6.k) r6
            java.lang.Object r6 = r6.f8444a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.s0.a(t6.c):java.lang.Object");
    }

    @Override // j1.e
    public /* synthetic */ void i(Exception exc) {
        b5.m mVar = (b5.m) this.f4243b;
        ((AtomicLong) mVar.f1063m).set(this.f4242a);
    }

    public s0(p0.a aVar) {
        k0.y.g(aVar);
        this.f4243b = aVar;
    }
}
