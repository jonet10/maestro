package t2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements i {

    /* renamed from: a, reason: collision with root package name */
    public final j1.i f9551a;

    public g(j1.i iVar) {
        this.f9551a = iVar;
    }

    @Override // t2.i
    public final boolean a(Exception exc) {
        return false;
    }

    @Override // t2.i
    public final boolean b(u2.b bVar) {
        int i = bVar.f10405b;
        if (i != 3 && i != 4 && i != 5) {
            return false;
        }
        this.f9551a.c(bVar.f10404a);
        return true;
    }
}
