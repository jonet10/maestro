package d8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g1 extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final g1 f3648c = new g1(h1.f3652a);

    @Override // d8.a
    public final int e(Object obj) {
        return ((p6.r) obj).f8457a.length;
    }

    @Override // d8.o, d8.a
    public final void h(c8.c cVar, int i, Object obj) {
        f1 f1Var = (f1) obj;
        f1Var.getClass();
        int decodeInt = cVar.decodeInlineElement(this.f3710b, i).decodeInt();
        f1Var.b(f1Var.d() + 1);
        int[] iArr = f1Var.f3642a;
        int i6 = f1Var.f3643b;
        f1Var.f3643b = i6 + 1;
        iArr[i6] = decodeInt;
    }

    @Override // d8.a
    public final Object i(Object obj) {
        int[] iArr = ((p6.r) obj).f8457a;
        f1 f1Var = new f1();
        f1Var.f3642a = iArr;
        f1Var.f3643b = iArr.length;
        f1Var.b(10);
        return f1Var;
    }

    @Override // d8.t0
    public final Object l() {
        return new p6.r(new int[0]);
    }

    @Override // d8.t0
    public final void m(c8.d dVar, Object obj, int i) {
        int[] iArr = ((p6.r) obj).f8457a;
        dVar.getClass();
        for (int i6 = 0; i6 < i; i6++) {
            dVar.encodeInlineElement(this.f3710b, i6).encodeInt(iArr[i6]);
        }
    }
}
