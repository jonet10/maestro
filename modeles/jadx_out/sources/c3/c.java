package c3;

import android.os.Build;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c implements l2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final c f1200a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final l2.c f1201b = l2.c.a("packageName");

    /* renamed from: c, reason: collision with root package name */
    public static final l2.c f1202c = l2.c.a("versionName");

    /* renamed from: d, reason: collision with root package name */
    public static final l2.c f1203d = l2.c.a("appBuildVersion");

    /* renamed from: e, reason: collision with root package name */
    public static final l2.c f1204e = l2.c.a("deviceManufacturer");
    public static final l2.c f = l2.c.a("currentProcessDetails");
    public static final l2.c g = l2.c.a("appProcessDetails");

    @Override // l2.a
    public final void a(Object obj, Object obj2) {
        a aVar = (a) obj;
        l2.e eVar = (l2.e) obj2;
        eVar.a(f1201b, aVar.f1185a);
        eVar.a(f1202c, aVar.f1186b);
        eVar.a(f1203d, aVar.f1187c);
        eVar.a(f1204e, Build.MANUFACTURER);
        eVar.a(f, aVar.f1188d);
        eVar.a(g, aVar.f1189e);
    }
}
