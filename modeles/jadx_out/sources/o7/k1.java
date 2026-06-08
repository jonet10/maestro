package o7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k1 extends i1 {

    /* renamed from: n, reason: collision with root package name */
    public final m1 f8273n;

    /* renamed from: o, reason: collision with root package name */
    public final l1 f8274o;

    /* renamed from: p, reason: collision with root package name */
    public final p f8275p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f8276q;

    public k1(m1 m1Var, l1 l1Var, p pVar, Object obj) {
        this.f8273n = m1Var;
        this.f8274o = l1Var;
        this.f8275p = pVar;
        this.f8276q = obj;
    }

    @Override // o7.i1
    public final boolean j() {
        return false;
    }

    @Override // o7.i1
    public final void k(Throwable th) {
        p pVar = this.f8275p;
        p T = m1.T(pVar);
        m1 m1Var = this.f8273n;
        l1 l1Var = this.f8274o;
        Object obj = this.f8276q;
        if (T == null || !m1Var.c0(l1Var, T, obj)) {
            l1Var.f8286a.d(new t7.h(2), 2);
            p T2 = m1.T(pVar);
            if (T2 == null || !m1Var.c0(l1Var, T2, obj)) {
                m1Var.t(m1Var.E(l1Var, obj));
            }
        }
    }
}
