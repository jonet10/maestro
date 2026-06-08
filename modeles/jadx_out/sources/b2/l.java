package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l implements l2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final l f851a = new l();

    /* renamed from: b, reason: collision with root package name */
    public static final l2.c f852b = l2.c.a("baseAddress");

    /* renamed from: c, reason: collision with root package name */
    public static final l2.c f853c = l2.c.a("size");

    /* renamed from: d, reason: collision with root package name */
    public static final l2.c f854d = l2.c.a("name");

    /* renamed from: e, reason: collision with root package name */
    public static final l2.c f855e = l2.c.a("uuid");

    @Override // l2.a
    public final void a(Object obj, Object obj2) {
        l2.e eVar = (l2.e) obj2;
        s0 s0Var = (s0) ((w1) obj);
        eVar.f(f852b, s0Var.f931a);
        eVar.f(f853c, s0Var.f932b);
        eVar.a(f854d, s0Var.f933c);
        String str = s0Var.f934d;
        eVar.a(f855e, str != null ? str.getBytes(n2.f887a) : null);
    }
}
