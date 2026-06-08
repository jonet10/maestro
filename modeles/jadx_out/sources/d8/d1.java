package d8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d1 extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final d1 f3632c = new d1(e1.f3638a);

    @Override // d8.a
    public final int e(Object obj) {
        return ((p6.p) obj).f8455a.length;
    }

    @Override // d8.o, d8.a
    public final void h(c8.c cVar, int i, Object obj) {
        c1 c1Var = (c1) obj;
        c1Var.getClass();
        byte decodeByte = cVar.decodeInlineElement(this.f3710b, i).decodeByte();
        c1Var.b(c1Var.d() + 1);
        byte[] bArr = c1Var.f3626a;
        int i6 = c1Var.f3627b;
        c1Var.f3627b = i6 + 1;
        bArr[i6] = decodeByte;
    }

    @Override // d8.a
    public final Object i(Object obj) {
        byte[] bArr = ((p6.p) obj).f8455a;
        c1 c1Var = new c1();
        c1Var.f3626a = bArr;
        c1Var.f3627b = bArr.length;
        c1Var.b(10);
        return c1Var;
    }

    @Override // d8.t0
    public final Object l() {
        return new p6.p(new byte[0]);
    }

    @Override // d8.t0
    public final void m(c8.d dVar, Object obj, int i) {
        byte[] bArr = ((p6.p) obj).f8455a;
        dVar.getClass();
        for (int i6 = 0; i6 < i; i6++) {
            dVar.encodeInlineElement(this.f3710b, i6).encodeByte(bArr[i6]);
        }
    }
}
