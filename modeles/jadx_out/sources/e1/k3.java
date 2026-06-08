package e1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j3 f4078a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j3 f4079b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f4080l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f4081m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ m3 f4082n;

    public k3(m3 m3Var, j3 j3Var, j3 j3Var2, long j, boolean z9) {
        this.f4078a = j3Var;
        this.f4079b = j3Var2;
        this.f4080l = j;
        this.f4081m = z9;
        this.f4082n = m3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4082n.q(this.f4078a, this.f4079b, this.f4080l, this.f4081m, null);
    }
}
