package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public Double f723a;

    /* renamed from: b, reason: collision with root package name */
    public int f724b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f725c;

    /* renamed from: d, reason: collision with root package name */
    public int f726d;

    /* renamed from: e, reason: collision with root package name */
    public long f727e;
    public long f;
    public byte g;

    public final b1 a() {
        if (this.g == 31) {
            return new b1(this.f723a, this.f724b, this.f725c, this.f726d, this.f727e, this.f);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.g & 1) == 0) {
            sb.append(" batteryVelocity");
        }
        if ((this.g & 2) == 0) {
            sb.append(" proximityOn");
        }
        if ((this.g & 4) == 0) {
            sb.append(" orientation");
        }
        if ((this.g & 8) == 0) {
            sb.append(" ramUsed");
        }
        if ((this.g & 16) == 0) {
            sb.append(" diskUsed");
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i(k0.k.h("Missing required properties:", sb));
        return null;
    }
}
