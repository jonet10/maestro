package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b0 extends n2 {

    /* renamed from: b, reason: collision with root package name */
    public final String f733b;

    /* renamed from: c, reason: collision with root package name */
    public final String f734c;

    /* renamed from: d, reason: collision with root package name */
    public final int f735d;

    /* renamed from: e, reason: collision with root package name */
    public final String f736e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    /* renamed from: k, reason: collision with root package name */
    public final m2 f737k;

    /* renamed from: l, reason: collision with root package name */
    public final s1 f738l;

    /* renamed from: m, reason: collision with root package name */
    public final p1 f739m;

    public b0(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, String str8, m2 m2Var, s1 s1Var, p1 p1Var) {
        this.f733b = str;
        this.f734c = str2;
        this.f735d = i;
        this.f736e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = str7;
        this.j = str8;
        this.f737k = m2Var;
        this.f738l = s1Var;
        this.f739m = p1Var;
    }

    public final a0 a() {
        a0 a0Var = new a0();
        a0Var.f715a = this.f733b;
        a0Var.f716b = this.f734c;
        a0Var.f717c = this.f735d;
        a0Var.f718d = this.f736e;
        a0Var.f719e = this.f;
        a0Var.f = this.g;
        a0Var.g = this.h;
        a0Var.h = this.i;
        a0Var.i = this.j;
        a0Var.j = this.f737k;
        a0Var.f720k = this.f738l;
        a0Var.f721l = this.f739m;
        a0Var.f722m = (byte) 1;
        return a0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n2) {
            b0 b0Var = (b0) ((n2) obj);
            if (this.f733b.equals(b0Var.f733b) && this.f734c.equals(b0Var.f734c) && this.f735d == b0Var.f735d && this.f736e.equals(b0Var.f736e)) {
                String str = b0Var.f;
                String str2 = this.f;
                if (str2 != null ? str2.equals(str) : str == null) {
                    String str3 = b0Var.g;
                    String str4 = this.g;
                    if (str4 != null ? str4.equals(str3) : str3 == null) {
                        String str5 = b0Var.h;
                        String str6 = this.h;
                        if (str6 != null ? str6.equals(str5) : str5 == null) {
                            if (this.i.equals(b0Var.i) && this.j.equals(b0Var.j)) {
                                m2 m2Var = b0Var.f737k;
                                m2 m2Var2 = this.f737k;
                                if (m2Var2 != null ? m2Var2.equals(m2Var) : m2Var == null) {
                                    s1 s1Var = b0Var.f738l;
                                    s1 s1Var2 = this.f738l;
                                    if (s1Var2 != null ? s1Var2.equals(s1Var) : s1Var == null) {
                                        p1 p1Var = b0Var.f739m;
                                        p1 p1Var2 = this.f739m;
                                        if (p1Var2 != null ? p1Var2.equals(p1Var) : p1Var == null) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((((((this.f733b.hashCode() ^ 1000003) * 1000003) ^ this.f734c.hashCode()) * 1000003) ^ this.f735d) * 1000003) ^ this.f736e.hashCode()) * 1000003;
        String str = this.f;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.g;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.h;
        int hashCode4 = (((((hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.j.hashCode()) * 1000003;
        m2 m2Var = this.f737k;
        int hashCode5 = (hashCode4 ^ (m2Var == null ? 0 : m2Var.hashCode())) * 1000003;
        s1 s1Var = this.f738l;
        int hashCode6 = (hashCode5 ^ (s1Var == null ? 0 : s1Var.hashCode())) * 1000003;
        p1 p1Var = this.f739m;
        return hashCode6 ^ (p1Var != null ? p1Var.hashCode() : 0);
    }

    public final String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f733b + ", gmpAppId=" + this.f734c + ", platform=" + this.f735d + ", installationUuid=" + this.f736e + ", firebaseInstallationId=" + this.f + ", firebaseAuthenticationToken=" + this.g + ", appQualitySessionId=" + this.h + ", buildVersion=" + this.i + ", displayVersion=" + this.j + ", session=" + this.f737k + ", ndkPayload=" + this.f738l + ", appExitInfo=" + this.f739m + "}";
    }
}
