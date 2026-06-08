package c3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u0 implements e3.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1329a;

    /* renamed from: b, reason: collision with root package name */
    public final m6.a f1330b;

    /* renamed from: l, reason: collision with root package name */
    public final e3.c f1331l;

    public /* synthetic */ u0(e3.c cVar, e3.c cVar2, int i) {
        this.f1329a = i;
        this.f1330b = cVar;
        this.f1331l = cVar2;
    }

    @Override // m6.a
    public final Object get() {
        switch (this.f1329a) {
            case 0:
                return new t0((h1) this.f1330b.get(), (i1) this.f1331l.get());
            default:
                return new f3.j((f3.o) this.f1330b.get(), (f3.o) this.f1331l.get());
        }
    }
}
