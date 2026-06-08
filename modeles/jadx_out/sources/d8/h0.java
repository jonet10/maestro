package d8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h0 extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final h0 f3651c = new h0(i0.f3655a);

    @Override // d8.a
    public final int e(Object obj) {
        long[] jArr = (long[]) obj;
        jArr.getClass();
        return jArr.length;
    }

    @Override // d8.o, d8.a
    public final void h(c8.c cVar, int i, Object obj) {
        g0 g0Var = (g0) obj;
        g0Var.getClass();
        long decodeLongElement = cVar.decodeLongElement(this.f3710b, i);
        g0Var.b(g0Var.d() + 1);
        long[] jArr = g0Var.f3646a;
        int i6 = g0Var.f3647b;
        g0Var.f3647b = i6 + 1;
        jArr[i6] = decodeLongElement;
    }

    @Override // d8.a
    public final Object i(Object obj) {
        long[] jArr = (long[]) obj;
        jArr.getClass();
        g0 g0Var = new g0();
        g0Var.f3646a = jArr;
        g0Var.f3647b = jArr.length;
        g0Var.b(10);
        return g0Var;
    }

    @Override // d8.t0
    public final Object l() {
        return new long[0];
    }

    @Override // d8.t0
    public final void m(c8.d dVar, Object obj, int i) {
        long[] jArr = (long[]) obj;
        dVar.getClass();
        jArr.getClass();
        for (int i6 = 0; i6 < i; i6++) {
            dVar.encodeLongElement(this.f3710b, i6, jArr[i6]);
        }
    }
}
