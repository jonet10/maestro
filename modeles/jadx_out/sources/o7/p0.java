package o7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p0 extends i1 {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f8296n;

    /* renamed from: o, reason: collision with root package name */
    public final Object f8297o;

    public /* synthetic */ p0(Object obj, int i) {
        this.f8296n = i;
        this.f8297o = obj;
    }

    @Override // o7.i1
    public final boolean j() {
        switch (this.f8296n) {
        }
        return false;
    }

    @Override // o7.i1
    public final void k(Throwable th) {
        switch (this.f8296n) {
            case 0:
                ((o0) this.f8297o).dispose();
                break;
            case 1:
                ((d7.l) this.f8297o).invoke(th);
                break;
            default:
                Object obj = m1.f8289a.get(i());
                boolean z9 = obj instanceof u;
                j1 j1Var = (j1) this.f8297o;
                if (!z9) {
                    j1Var.resumeWith(c0.A(obj));
                    break;
                } else {
                    j1Var.resumeWith(p6.a.b(((u) obj).f8315a));
                    break;
                }
        }
    }
}
