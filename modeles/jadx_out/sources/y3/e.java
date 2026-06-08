package y3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends w3.a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f11801a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11802b;

    /* renamed from: c, reason: collision with root package name */
    public v3.c f11803c;

    /* renamed from: d, reason: collision with root package name */
    public String f11804d;

    /* renamed from: e, reason: collision with root package name */
    public float f11805e;

    @Override // w3.a
    public final void a(v3.e eVar, float f) {
        eVar.getClass();
        this.f11805e = f;
    }

    @Override // w3.a
    public final void b(v3.e eVar, v3.c cVar) {
        eVar.getClass();
        if (cVar == v3.c.f10827l) {
            this.f11803c = cVar;
        }
    }

    @Override // w3.a
    public final void d(v3.e eVar, v3.d dVar) {
        eVar.getClass();
        int ordinal = dVar.ordinal();
        if (ordinal != 2) {
            if (ordinal == 3) {
                this.f11802b = true;
                return;
            } else if (ordinal != 4) {
                return;
            }
        }
        this.f11802b = false;
    }

    @Override // w3.a
    public final void f(v3.e eVar, String str) {
        eVar.getClass();
        this.f11804d = str;
    }
}
