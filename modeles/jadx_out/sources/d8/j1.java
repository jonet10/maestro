package d8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j1 extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final j1 f3663c = new j1(k1.f3665a);

    @Override // d8.a
    public final int e(Object obj) {
        return ((p6.t) obj).f8459a.length;
    }

    @Override // d8.o, d8.a
    public final void h(c8.c cVar, int i, Object obj) {
        i1 i1Var = (i1) obj;
        i1Var.getClass();
        long decodeLong = cVar.decodeInlineElement(this.f3710b, i).decodeLong();
        i1Var.b(i1Var.d() + 1);
        long[] jArr = i1Var.f3657a;
        int i6 = i1Var.f3658b;
        i1Var.f3658b = i6 + 1;
        jArr[i6] = decodeLong;
    }

    @Override // d8.a
    public final Object i(Object obj) {
        long[] jArr = ((p6.t) obj).f8459a;
        i1 i1Var = new i1();
        i1Var.f3657a = jArr;
        i1Var.f3658b = jArr.length;
        i1Var.b(10);
        return i1Var;
    }

    @Override // d8.t0
    public final Object l() {
        return new p6.t(new long[0]);
    }

    @Override // d8.t0
    public final void m(c8.d dVar, Object obj, int i) {
        long[] jArr = ((p6.t) obj).f8459a;
        dVar.getClass();
        for (int i6 = 0; i6 < i; i6++) {
            dVar.encodeInlineElement(this.f3710b, i6).encodeLong(jArr[i6]);
        }
    }
}
