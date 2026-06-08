package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s implements l2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final s f926a = new s();

    /* renamed from: b, reason: collision with root package name */
    public static final l2.c f927b = l2.c.a("batteryLevel");

    /* renamed from: c, reason: collision with root package name */
    public static final l2.c f928c = l2.c.a("batteryVelocity");

    /* renamed from: d, reason: collision with root package name */
    public static final l2.c f929d = l2.c.a("proximityOn");

    /* renamed from: e, reason: collision with root package name */
    public static final l2.c f930e = l2.c.a("orientation");
    public static final l2.c f = l2.c.a("ramUsed");
    public static final l2.c g = l2.c.a("diskUsed");

    @Override // l2.a
    public final void a(Object obj, Object obj2) {
        l2.e eVar = (l2.e) obj2;
        b1 b1Var = (b1) ((e2) obj);
        eVar.a(f927b, b1Var.f740a);
        eVar.e(f928c, b1Var.f741b);
        eVar.d(f929d, b1Var.f742c);
        eVar.e(f930e, b1Var.f743d);
        eVar.f(f, b1Var.f744e);
        eVar.f(g, b1Var.f);
    }
}
