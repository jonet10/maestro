package d8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v extends t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final v f3715c = new v(w.f3717a);

    @Override // d8.a
    public final int e(Object obj) {
        float[] fArr = (float[]) obj;
        fArr.getClass();
        return fArr.length;
    }

    @Override // d8.o, d8.a
    public final void h(c8.c cVar, int i, Object obj) {
        u uVar = (u) obj;
        uVar.getClass();
        float decodeFloatElement = cVar.decodeFloatElement(this.f3710b, i);
        uVar.b(uVar.d() + 1);
        float[] fArr = uVar.f3711a;
        int i6 = uVar.f3712b;
        uVar.f3712b = i6 + 1;
        fArr[i6] = decodeFloatElement;
    }

    @Override // d8.a
    public final Object i(Object obj) {
        float[] fArr = (float[]) obj;
        fArr.getClass();
        u uVar = new u();
        uVar.f3711a = fArr;
        uVar.f3712b = fArr.length;
        uVar.b(10);
        return uVar;
    }

    @Override // d8.t0
    public final Object l() {
        return new float[0];
    }

    @Override // d8.t0
    public final void m(c8.d dVar, Object obj, int i) {
        float[] fArr = (float[]) obj;
        dVar.getClass();
        fArr.getClass();
        for (int i6 = 0; i6 < i; i6++) {
            dVar.encodeFloatElement(this.f3710b, i6, fArr[i6]);
        }
    }
}
