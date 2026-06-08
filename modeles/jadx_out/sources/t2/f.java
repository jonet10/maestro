package t2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f implements i {

    /* renamed from: a, reason: collision with root package name */
    public final j f9549a;

    /* renamed from: b, reason: collision with root package name */
    public final j1.i f9550b;

    public f(j jVar, j1.i iVar) {
        this.f9549a = jVar;
        this.f9550b = iVar;
    }

    @Override // t2.i
    public final boolean a(Exception exc) {
        this.f9550b.b(exc);
        return true;
    }

    @Override // t2.i
    public final boolean b(u2.b bVar) {
        if (bVar.f10405b != 4 || this.f9549a.a(bVar)) {
            return false;
        }
        String str = bVar.f10406c;
        if (str == null) {
            com.google.gson.internal.a.i("Null token");
            return false;
        }
        this.f9550b.a(new a(str, bVar.f10408e, bVar.f));
        return true;
    }
}
