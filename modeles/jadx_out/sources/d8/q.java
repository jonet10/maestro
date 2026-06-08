package d8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final q f3693c = new q(r.f3700a);

    @Override // d8.a
    public final int e(Object obj) {
        double[] dArr = (double[]) obj;
        dArr.getClass();
        return dArr.length;
    }

    @Override // d8.o, d8.a
    public final void h(c8.c cVar, int i, Object obj) {
        p pVar = (p) obj;
        pVar.getClass();
        double decodeDoubleElement = cVar.decodeDoubleElement(this.f3710b, i);
        pVar.b(pVar.d() + 1);
        double[] dArr = pVar.f3687a;
        int i6 = pVar.f3688b;
        pVar.f3688b = i6 + 1;
        dArr[i6] = decodeDoubleElement;
    }

    @Override // d8.a
    public final Object i(Object obj) {
        double[] dArr = (double[]) obj;
        dArr.getClass();
        p pVar = new p();
        pVar.f3687a = dArr;
        pVar.f3688b = dArr.length;
        pVar.b(10);
        return pVar;
    }

    @Override // d8.t0
    public final Object l() {
        return new double[0];
    }

    @Override // d8.t0
    public final void m(c8.d dVar, Object obj, int i) {
        double[] dArr = (double[]) obj;
        dVar.getClass();
        dArr.getClass();
        for (int i6 = 0; i6 < i; i6++) {
            dVar.encodeDoubleElement(this.f3710b, i6, dArr[i6]);
        }
    }
}
