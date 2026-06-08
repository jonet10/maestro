package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h1 {

    /* renamed from: a, reason: collision with root package name */
    public int f800a;

    /* renamed from: b, reason: collision with root package name */
    public String f801b;

    /* renamed from: c, reason: collision with root package name */
    public String f802c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f803d;

    /* renamed from: e, reason: collision with root package name */
    public byte f804e;

    public final i1 a() {
        String str;
        String str2;
        if (this.f804e == 3 && (str = this.f801b) != null && (str2 = this.f802c) != null) {
            return new i1(str, str2, this.f803d, this.f800a);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f804e & 1) == 0) {
            sb.append(" platform");
        }
        if (this.f801b == null) {
            sb.append(" version");
        }
        if (this.f802c == null) {
            sb.append(" buildVersion");
        }
        if ((this.f804e & 2) == 0) {
            sb.append(" jailbroken");
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i(k0.k.h("Missing required properties:", sb));
        return null;
    }
}
