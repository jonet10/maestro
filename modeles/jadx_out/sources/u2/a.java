package u2;

import k0.k;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f10399a;

    /* renamed from: b, reason: collision with root package name */
    public int f10400b;

    /* renamed from: c, reason: collision with root package name */
    public String f10401c;

    /* renamed from: d, reason: collision with root package name */
    public String f10402d;

    /* renamed from: e, reason: collision with root package name */
    public long f10403e;
    public long f;
    public String g;
    public byte h;

    public final b a() {
        if (this.h == 3 && this.f10400b != 0) {
            return new b(this.f10399a, this.f10400b, this.f10401c, this.f10402d, this.f10403e, this.f, this.g);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f10400b == 0) {
            sb.append(" registrationStatus");
        }
        if ((this.h & 1) == 0) {
            sb.append(" expiresInSecs");
        }
        if ((this.h & 2) == 0) {
            sb.append(" tokenCreationEpochInSecs");
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i(k.h("Missing required properties:", sb));
        return null;
    }
}
