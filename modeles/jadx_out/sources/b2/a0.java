package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public String f715a;

    /* renamed from: b, reason: collision with root package name */
    public String f716b;

    /* renamed from: c, reason: collision with root package name */
    public int f717c;

    /* renamed from: d, reason: collision with root package name */
    public String f718d;

    /* renamed from: e, reason: collision with root package name */
    public String f719e;
    public String f;
    public String g;
    public String h;
    public String i;
    public m2 j;

    /* renamed from: k, reason: collision with root package name */
    public s1 f720k;

    /* renamed from: l, reason: collision with root package name */
    public p1 f721l;

    /* renamed from: m, reason: collision with root package name */
    public byte f722m;

    public final b0 a() {
        if (this.f722m == 1 && this.f715a != null && this.f716b != null && this.f718d != null && this.h != null && this.i != null) {
            return new b0(this.f715a, this.f716b, this.f717c, this.f718d, this.f719e, this.f, this.g, this.h, this.i, this.j, this.f720k, this.f721l);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f715a == null) {
            sb.append(" sdkVersion");
        }
        if (this.f716b == null) {
            sb.append(" gmpAppId");
        }
        if ((1 & this.f722m) == 0) {
            sb.append(" platform");
        }
        if (this.f718d == null) {
            sb.append(" installationUuid");
        }
        if (this.h == null) {
            sb.append(" buildVersion");
        }
        if (this.i == null) {
            sb.append(" displayVersion");
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i(k0.k.h("Missing required properties:", sb));
        return null;
    }
}
