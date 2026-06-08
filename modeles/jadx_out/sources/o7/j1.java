package o7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j1 extends l {

    /* renamed from: r, reason: collision with root package name */
    public final m1 f8269r;

    public j1(t6.c cVar, m1 m1Var) {
        super(1, cVar);
        this.f8269r = m1Var;
    }

    @Override // o7.l
    public final Throwable p(m1 m1Var) {
        Throwable d10;
        m1 m1Var2 = this.f8269r;
        m1Var2.getClass();
        Object obj = m1.f8289a.get(m1Var2);
        return (!(obj instanceof l1) || (d10 = ((l1) obj).d()) == null) ? obj instanceof u ? ((u) obj).f8315a : m1Var.j() : d10;
    }

    @Override // o7.l
    public final String y() {
        return "AwaitContinuation";
    }
}
