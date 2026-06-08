package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public int f866a;

    /* renamed from: b, reason: collision with root package name */
    public String f867b;

    /* renamed from: c, reason: collision with root package name */
    public int f868c;

    /* renamed from: d, reason: collision with root package name */
    public long f869d;

    /* renamed from: e, reason: collision with root package name */
    public long f870e;
    public boolean f;
    public int g;
    public String h;
    public String i;
    public byte j;

    public final n0 a() {
        String str;
        String str2;
        String str3;
        if (this.j == 63 && (str = this.f867b) != null && (str2 = this.h) != null && (str3 = this.i) != null) {
            return new n0(this.f866a, str, this.f868c, this.f869d, this.f870e, this.f, this.g, str2, str3);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.j & 1) == 0) {
            sb.append(" arch");
        }
        if (this.f867b == null) {
            sb.append(" model");
        }
        if ((this.j & 2) == 0) {
            sb.append(" cores");
        }
        if ((this.j & 4) == 0) {
            sb.append(" ram");
        }
        if ((this.j & 8) == 0) {
            sb.append(" diskSpace");
        }
        if ((this.j & 16) == 0) {
            sb.append(" simulator");
        }
        if ((this.j & 32) == 0) {
            sb.append(" state");
        }
        if (this.h == null) {
            sb.append(" manufacturer");
        }
        if (this.i == null) {
            sb.append(" modelClass");
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i(k0.k.h("Missing required properties:", sb));
        return null;
    }
}
