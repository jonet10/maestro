package c3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h implements l2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final h f1250a = new h();

    /* renamed from: b, reason: collision with root package name */
    public static final l2.c f1251b = l2.c.a("sessionId");

    /* renamed from: c, reason: collision with root package name */
    public static final l2.c f1252c = l2.c.a("firstSessionId");

    /* renamed from: d, reason: collision with root package name */
    public static final l2.c f1253d = l2.c.a("sessionIndex");

    /* renamed from: e, reason: collision with root package name */
    public static final l2.c f1254e = l2.c.a("eventTimestampUs");
    public static final l2.c f = l2.c.a("dataCollectionStatus");
    public static final l2.c g = l2.c.a("firebaseInstallationId");
    public static final l2.c h = l2.c.a("firebaseAuthenticationToken");

    @Override // l2.a
    public final void a(Object obj, Object obj2) {
        v0 v0Var = (v0) obj;
        l2.e eVar = (l2.e) obj2;
        eVar.a(f1251b, v0Var.f1332a);
        eVar.a(f1252c, v0Var.f1333b);
        eVar.e(f1253d, v0Var.f1334c);
        eVar.f(f1254e, v0Var.f1335d);
        eVar.a(f, v0Var.f1336e);
        eVar.a(g, v0Var.f);
        eVar.a(h, v0Var.g);
    }
}
