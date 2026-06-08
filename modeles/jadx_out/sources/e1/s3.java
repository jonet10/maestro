package e1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s3 extends n {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4248e;
    public final /* synthetic */ w3 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s3(w3 w3Var, t1 t1Var, int i) {
        super(t1Var);
        this.f4248e = i;
        this.f = w3Var;
    }

    @Override // e1.n
    public final void a() {
        switch (this.f4248e) {
            case 0:
                w3 w3Var = this.f;
                w3Var.g();
                if (w3Var.x()) {
                    w0 w0Var = w3Var.f3875a.f4264o;
                    t1.m(w0Var);
                    w0Var.f4346w.b("Inactivity, disconnecting from the service");
                    w3Var.o();
                    break;
                }
                break;
            default:
                w0 w0Var2 = this.f.f3875a.f4264o;
                t1.m(w0Var2);
                w0Var2.f4342r.b("Tasks have been queued for a long time");
                break;
        }
    }
}
