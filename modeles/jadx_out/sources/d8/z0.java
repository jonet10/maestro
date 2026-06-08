package d8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z0 extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final z0 f3726c = new z0(a1.f3618a);

    @Override // d8.a
    public final int e(Object obj) {
        short[] sArr = (short[]) obj;
        sArr.getClass();
        return sArr.length;
    }

    @Override // d8.o, d8.a
    public final void h(c8.c cVar, int i, Object obj) {
        y0 y0Var = (y0) obj;
        y0Var.getClass();
        short decodeShortElement = cVar.decodeShortElement(this.f3710b, i);
        y0Var.b(y0Var.d() + 1);
        short[] sArr = y0Var.f3723a;
        int i6 = y0Var.f3724b;
        y0Var.f3724b = i6 + 1;
        sArr[i6] = decodeShortElement;
    }

    @Override // d8.a
    public final Object i(Object obj) {
        short[] sArr = (short[]) obj;
        sArr.getClass();
        y0 y0Var = new y0();
        y0Var.f3723a = sArr;
        y0Var.f3724b = sArr.length;
        y0Var.b(10);
        return y0Var;
    }

    @Override // d8.t0
    public final Object l() {
        return new short[0];
    }

    @Override // d8.t0
    public final void m(c8.d dVar, Object obj, int i) {
        short[] sArr = (short[]) obj;
        dVar.getClass();
        sArr.getClass();
        for (int i6 = 0; i6 < i; i6++) {
            dVar.encodeShortElement(this.f3710b, i6, sArr[i6]);
        }
    }
}
