package o7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n1 extends s1 {

    /* renamed from: m, reason: collision with root package name */
    public final t6.c f8294m;

    public n1(t6.h hVar, d7.p pVar) {
        super(hVar, false);
        this.f8294m = d0.b.B(pVar, this, this);
    }

    @Override // o7.m1
    public final void W() {
        try {
            t7.a.h(p6.x.f8463a, d0.b.I(this.f8294m));
        } catch (Throwable th) {
            resumeWith(new p6.j(th));
            throw th;
        }
    }
}
