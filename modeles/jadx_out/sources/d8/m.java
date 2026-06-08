package d8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final m f3673c = new m(n.f3677a);

    @Override // d8.a
    public final int e(Object obj) {
        char[] cArr = (char[]) obj;
        cArr.getClass();
        return cArr.length;
    }

    @Override // d8.o, d8.a
    public final void h(c8.c cVar, int i, Object obj) {
        l lVar = (l) obj;
        lVar.getClass();
        char decodeCharElement = cVar.decodeCharElement(this.f3710b, i);
        lVar.b(lVar.d() + 1);
        char[] cArr = lVar.f3667a;
        int i6 = lVar.f3668b;
        lVar.f3668b = i6 + 1;
        cArr[i6] = decodeCharElement;
    }

    @Override // d8.a
    public final Object i(Object obj) {
        char[] cArr = (char[]) obj;
        cArr.getClass();
        l lVar = new l();
        lVar.f3667a = cArr;
        lVar.f3668b = cArr.length;
        lVar.b(10);
        return lVar;
    }

    @Override // d8.t0
    public final Object l() {
        return new char[0];
    }

    @Override // d8.t0
    public final void m(c8.d dVar, Object obj, int i) {
        char[] cArr = (char[]) obj;
        dVar.getClass();
        cArr.getClass();
        for (int i6 = 0; i6 < i; i6++) {
            dVar.encodeCharElement(this.f3710b, i6, cArr[i6]);
        }
    }
}
