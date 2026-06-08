package d8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final f f3640c = new f(g.f3644a);

    @Override // d8.a
    public final int e(Object obj) {
        boolean[] zArr = (boolean[]) obj;
        zArr.getClass();
        return zArr.length;
    }

    @Override // d8.o, d8.a
    public final void h(c8.c cVar, int i, Object obj) {
        e eVar = (e) obj;
        eVar.getClass();
        boolean decodeBooleanElement = cVar.decodeBooleanElement(this.f3710b, i);
        eVar.b(eVar.d() + 1);
        boolean[] zArr = eVar.f3633a;
        int i6 = eVar.f3634b;
        eVar.f3634b = i6 + 1;
        zArr[i6] = decodeBooleanElement;
    }

    @Override // d8.a
    public final Object i(Object obj) {
        boolean[] zArr = (boolean[]) obj;
        zArr.getClass();
        e eVar = new e();
        eVar.f3633a = zArr;
        eVar.f3634b = zArr.length;
        eVar.b(10);
        return eVar;
    }

    @Override // d8.t0
    public final Object l() {
        return new boolean[0];
    }

    @Override // d8.t0
    public final void m(c8.d dVar, Object obj, int i) {
        boolean[] zArr = (boolean[]) obj;
        dVar.getClass();
        zArr.getClass();
        for (int i6 = 0; i6 < i; i6++) {
            dVar.encodeBooleanElement(this.f3710b, i6, zArr[i6]);
        }
    }
}
