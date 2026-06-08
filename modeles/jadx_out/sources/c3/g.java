package c3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements l2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final g f1242a = new g();

    /* renamed from: b, reason: collision with root package name */
    public static final l2.c f1243b = l2.c.a("eventType");

    /* renamed from: c, reason: collision with root package name */
    public static final l2.c f1244c = l2.c.a("sessionData");

    /* renamed from: d, reason: collision with root package name */
    public static final l2.c f1245d = l2.c.a("applicationInfo");

    @Override // l2.a
    public final void a(Object obj, Object obj2) {
        o0 o0Var = (o0) obj;
        l2.e eVar = (l2.e) obj2;
        o0Var.getClass();
        eVar.a(f1243b, n.SESSION_START);
        eVar.a(f1244c, o0Var.f1296a);
        eVar.a(f1245d, o0Var.f1297b);
    }
}
