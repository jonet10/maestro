package d8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b0 extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final b0 f3620c = new b0(c0.f3624a);

    @Override // d8.a
    public final int e(Object obj) {
        int[] iArr = (int[]) obj;
        iArr.getClass();
        return iArr.length;
    }

    @Override // d8.o, d8.a
    public final void h(c8.c cVar, int i, Object obj) {
        a0 a0Var = (a0) obj;
        a0Var.getClass();
        int decodeIntElement = cVar.decodeIntElement(this.f3710b, i);
        a0Var.b(a0Var.d() + 1);
        int[] iArr = a0Var.f3616a;
        int i6 = a0Var.f3617b;
        a0Var.f3617b = i6 + 1;
        iArr[i6] = decodeIntElement;
    }

    @Override // d8.a
    public final Object i(Object obj) {
        int[] iArr = (int[]) obj;
        iArr.getClass();
        a0 a0Var = new a0();
        a0Var.f3616a = iArr;
        a0Var.f3617b = iArr.length;
        a0Var.b(10);
        return a0Var;
    }

    @Override // d8.t0
    public final Object l() {
        return new int[0];
    }

    @Override // d8.t0
    public final void m(c8.d dVar, Object obj, int i) {
        int[] iArr = (int[]) obj;
        dVar.getClass();
        iArr.getClass();
        for (int i6 = 0; i6 < i; i6++) {
            dVar.encodeIntElement(this.f3710b, i6, iArr[i6]);
        }
    }
}
