package c3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e implements l2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final e f1228a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final l2.c f1229b = l2.c.a("performance");

    /* renamed from: c, reason: collision with root package name */
    public static final l2.c f1230c = l2.c.a("crashlytics");

    /* renamed from: d, reason: collision with root package name */
    public static final l2.c f1231d = l2.c.a("sessionSamplingRate");

    @Override // l2.a
    public final void a(Object obj, Object obj2) {
        k kVar = (k) obj;
        l2.e eVar = (l2.e) obj2;
        eVar.a(f1229b, kVar.f1278a);
        eVar.a(f1230c, kVar.f1279b);
        eVar.g(f1231d, kVar.f1280c);
    }
}
