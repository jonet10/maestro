package b2;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public int f748a;

    /* renamed from: b, reason: collision with root package name */
    public String f749b;

    /* renamed from: c, reason: collision with root package name */
    public int f750c;

    /* renamed from: d, reason: collision with root package name */
    public int f751d;

    /* renamed from: e, reason: collision with root package name */
    public long f752e;
    public long f;
    public long g;
    public String h;
    public List i;
    public byte j;

    public final d0 a() {
        String str;
        if (this.j == 63 && (str = this.f749b) != null) {
            return new d0(this.f748a, str, this.f750c, this.f751d, this.f752e, this.f, this.g, this.h, this.i);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.j & 1) == 0) {
            sb.append(" pid");
        }
        if (this.f749b == null) {
            sb.append(" processName");
        }
        if ((this.j & 2) == 0) {
            sb.append(" reasonCode");
        }
        if ((this.j & 4) == 0) {
            sb.append(" importance");
        }
        if ((this.j & 8) == 0) {
            sb.append(" pss");
        }
        if ((this.j & 16) == 0) {
            sb.append(" rss");
        }
        if ((this.j & 32) == 0) {
            sb.append(" timestamp");
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i(k0.k.h("Missing required properties:", sb));
        return null;
    }
}
