package y2;

import androidx.core.app.NotificationCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements l2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f11699a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final l2.c f11700b = new l2.c("projectNumber", k0.k.j(k0.k.i(o2.e.class, new o2.a(1))));

    /* renamed from: c, reason: collision with root package name */
    public static final l2.c f11701c = new l2.c("messageId", k0.k.j(k0.k.i(o2.e.class, new o2.a(2))));

    /* renamed from: d, reason: collision with root package name */
    public static final l2.c f11702d = new l2.c("instanceId", k0.k.j(k0.k.i(o2.e.class, new o2.a(3))));

    /* renamed from: e, reason: collision with root package name */
    public static final l2.c f11703e = new l2.c("messageType", k0.k.j(k0.k.i(o2.e.class, new o2.a(4))));
    public static final l2.c f = new l2.c("sdkPlatform", k0.k.j(k0.k.i(o2.e.class, new o2.a(5))));
    public static final l2.c g = new l2.c("packageName", k0.k.j(k0.k.i(o2.e.class, new o2.a(6))));
    public static final l2.c h = new l2.c("collapseKey", k0.k.j(k0.k.i(o2.e.class, new o2.a(7))));
    public static final l2.c i = new l2.c("priority", k0.k.j(k0.k.i(o2.e.class, new o2.a(8))));
    public static final l2.c j = new l2.c("ttl", k0.k.j(k0.k.i(o2.e.class, new o2.a(9))));

    /* renamed from: k, reason: collision with root package name */
    public static final l2.c f11704k = new l2.c("topic", k0.k.j(k0.k.i(o2.e.class, new o2.a(10))));

    /* renamed from: l, reason: collision with root package name */
    public static final l2.c f11705l = new l2.c("bulkId", k0.k.j(k0.k.i(o2.e.class, new o2.a(11))));

    /* renamed from: m, reason: collision with root package name */
    public static final l2.c f11706m = new l2.c(NotificationCompat.CATEGORY_EVENT, k0.k.j(k0.k.i(o2.e.class, new o2.a(12))));

    /* renamed from: n, reason: collision with root package name */
    public static final l2.c f11707n = new l2.c("analyticsLabel", k0.k.j(k0.k.i(o2.e.class, new o2.a(13))));

    /* renamed from: o, reason: collision with root package name */
    public static final l2.c f11708o = new l2.c("campaignId", k0.k.j(k0.k.i(o2.e.class, new o2.a(14))));

    /* renamed from: p, reason: collision with root package name */
    public static final l2.c f11709p = new l2.c("composerLabel", k0.k.j(k0.k.i(o2.e.class, new o2.a(15))));

    @Override // l2.a
    public final void a(Object obj, Object obj2) {
        z2.d dVar = (z2.d) obj;
        l2.e eVar = (l2.e) obj2;
        eVar.f(f11700b, dVar.f11921a);
        eVar.a(f11701c, dVar.f11922b);
        eVar.a(f11702d, dVar.f11923c);
        eVar.a(f11703e, dVar.f11924d);
        eVar.a(f, z2.c.ANDROID);
        eVar.a(g, dVar.f11925e);
        eVar.a(h, dVar.f);
        eVar.e(i, dVar.g);
        eVar.e(j, dVar.h);
        eVar.a(f11704k, dVar.i);
        eVar.f(f11705l, 0L);
        eVar.a(f11706m, z2.a.MESSAGE_DELIVERED);
        eVar.a(f11707n, dVar.j);
        eVar.f(f11708o, 0L);
        eVar.a(f11709p, dVar.f11926k);
    }
}
