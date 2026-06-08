package b2;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public String f810a;

    /* renamed from: b, reason: collision with root package name */
    public String f811b;

    /* renamed from: c, reason: collision with root package name */
    public String f812c;

    /* renamed from: d, reason: collision with root package name */
    public long f813d;

    /* renamed from: e, reason: collision with root package name */
    public Long f814e;
    public boolean f;
    public u1 g;
    public l2 h;
    public k2 i;
    public v1 j;

    /* renamed from: k, reason: collision with root package name */
    public List f815k;

    /* renamed from: l, reason: collision with root package name */
    public int f816l;

    /* renamed from: m, reason: collision with root package name */
    public byte f817m;

    public final j0 a() {
        String str;
        String str2;
        u1 u1Var;
        if (this.f817m == 7 && (str = this.f810a) != null && (str2 = this.f811b) != null && (u1Var = this.g) != null) {
            return new j0(str, str2, this.f812c, this.f813d, this.f814e, this.f, u1Var, this.h, this.i, this.j, this.f815k, this.f816l);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f810a == null) {
            sb.append(" generator");
        }
        if (this.f811b == null) {
            sb.append(" identifier");
        }
        if ((this.f817m & 1) == 0) {
            sb.append(" startedAt");
        }
        if ((this.f817m & 2) == 0) {
            sb.append(" crashed");
        }
        if (this.g == null) {
            sb.append(" app");
        }
        if ((this.f817m & 4) == 0) {
            sb.append(" generatorType");
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i(k0.k.h("Missing required properties:", sb));
        return null;
    }
}
