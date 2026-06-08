package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y0 {

    /* renamed from: a, reason: collision with root package name */
    public String f981a;

    /* renamed from: b, reason: collision with root package name */
    public int f982b;

    /* renamed from: c, reason: collision with root package name */
    public int f983c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f984d;

    /* renamed from: e, reason: collision with root package name */
    public byte f985e;

    public final z0 a() {
        String str;
        if (this.f985e == 7 && (str = this.f981a) != null) {
            return new z0(str, this.f982b, this.f983c, this.f984d);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f981a == null) {
            sb.append(" processName");
        }
        if ((this.f985e & 1) == 0) {
            sb.append(" pid");
        }
        if ((this.f985e & 2) == 0) {
            sb.append(" importance");
        }
        if ((this.f985e & 4) == 0) {
            sb.append(" defaultProcess");
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i(k0.k.h("Missing required properties:", sb));
        return null;
    }
}
