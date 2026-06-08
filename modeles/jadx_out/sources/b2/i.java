package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i implements l2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final i f805a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static final l2.c f806b = l2.c.a("arch");

    /* renamed from: c, reason: collision with root package name */
    public static final l2.c f807c = l2.c.a("model");

    /* renamed from: d, reason: collision with root package name */
    public static final l2.c f808d = l2.c.a("cores");

    /* renamed from: e, reason: collision with root package name */
    public static final l2.c f809e = l2.c.a("ram");
    public static final l2.c f = l2.c.a("diskSpace");
    public static final l2.c g = l2.c.a("simulator");
    public static final l2.c h = l2.c.a("state");
    public static final l2.c i = l2.c.a("manufacturer");
    public static final l2.c j = l2.c.a("modelClass");

    @Override // l2.a
    public final void a(Object obj, Object obj2) {
        l2.e eVar = (l2.e) obj2;
        n0 n0Var = (n0) ((v1) obj);
        eVar.e(f806b, n0Var.f881a);
        eVar.a(f807c, n0Var.f882b);
        eVar.e(f808d, n0Var.f883c);
        eVar.f(f809e, n0Var.f884d);
        eVar.f(f, n0Var.f885e);
        eVar.d(g, n0Var.f);
        eVar.e(h, n0Var.g);
        eVar.a(i, n0Var.h);
        eVar.a(j, n0Var.i);
    }
}
