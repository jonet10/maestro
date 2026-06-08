package m8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public a0 f7683a;

    /* renamed from: b, reason: collision with root package name */
    public y f7684b;

    /* renamed from: d, reason: collision with root package name */
    public String f7686d;

    /* renamed from: e, reason: collision with root package name */
    public r f7687e;
    public e0 g;
    public c0 h;
    public c0 i;
    public c0 j;

    /* renamed from: k, reason: collision with root package name */
    public long f7688k;

    /* renamed from: l, reason: collision with root package name */
    public long f7689l;

    /* renamed from: c, reason: collision with root package name */
    public int f7685c = -1;
    public g5.f f = new g5.f(9);

    public static void b(String str, c0 c0Var) {
        if (c0Var.f7698p != null) {
            com.google.gson.internal.a.p(str.concat(".body != null"));
            return;
        }
        if (c0Var.f7699q != null) {
            com.google.gson.internal.a.p(str.concat(".networkResponse != null"));
        } else if (c0Var.f7700r != null) {
            com.google.gson.internal.a.p(str.concat(".cacheResponse != null"));
        } else {
            if (c0Var.f7701s == null) {
                return;
            }
            com.google.gson.internal.a.p(str.concat(".priorResponse != null"));
        }
    }

    public final c0 a() {
        if (this.f7683a == null) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("request == null");
            return null;
        }
        if (this.f7684b == null) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("protocol == null");
            return null;
        }
        if (this.f7685c < 0) {
            com.google.gson.internal.a.f(this.f7685c, "code < 0: ");
            return null;
        }
        if (this.f7686d != null) {
            return new c0(this);
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("message == null");
        return null;
    }
}
