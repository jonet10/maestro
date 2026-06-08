package e1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4353a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j2 f4354b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f4355l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f4356m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ b3 f4357n;

    public /* synthetic */ w2(b3 b3Var, j2 j2Var, long j, boolean z9, int i) {
        this.f4353a = i;
        this.f4354b = j2Var;
        this.f4355l = j;
        this.f4356m = z9;
        this.f4357n = b3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4353a) {
            case 0:
                b3 b3Var = this.f4357n;
                j2 j2Var = this.f4354b;
                b3Var.k(j2Var);
                b3Var.w(j2Var, this.f4355l, this.f4356m);
                break;
            default:
                b3 b3Var2 = this.f4357n;
                j2 j2Var2 = this.f4354b;
                b3Var2.k(j2Var2);
                b3Var2.w(j2Var2, this.f4355l, this.f4356m);
                break;
        }
    }
}
