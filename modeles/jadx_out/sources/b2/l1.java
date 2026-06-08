package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f856a;

    /* renamed from: b, reason: collision with root package name */
    public final String f857b;

    /* renamed from: c, reason: collision with root package name */
    public final String f858c;

    /* renamed from: d, reason: collision with root package name */
    public final String f859d;

    /* renamed from: e, reason: collision with root package name */
    public final int f860e;
    public final m8.q f;

    public l1(String str, String str2, String str3, String str4, int i, m8.q qVar) {
        if (str == null) {
            com.google.gson.internal.a.i("Null appIdentifier");
            throw null;
        }
        this.f856a = str;
        if (str2 == null) {
            com.google.gson.internal.a.i("Null versionCode");
            throw null;
        }
        this.f857b = str2;
        if (str3 == null) {
            com.google.gson.internal.a.i("Null versionName");
            throw null;
        }
        this.f858c = str3;
        if (str4 == null) {
            com.google.gson.internal.a.i("Null installUuid");
            throw null;
        }
        this.f859d = str4;
        this.f860e = i;
        this.f = qVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l1)) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return this.f856a.equals(l1Var.f856a) && this.f857b.equals(l1Var.f857b) && this.f858c.equals(l1Var.f858c) && this.f859d.equals(l1Var.f859d) && this.f860e == l1Var.f860e && this.f.equals(l1Var.f);
    }

    public final int hashCode() {
        return ((((((((((this.f856a.hashCode() ^ 1000003) * 1000003) ^ this.f857b.hashCode()) * 1000003) ^ this.f858c.hashCode()) * 1000003) ^ this.f859d.hashCode()) * 1000003) ^ this.f860e) * 1000003) ^ this.f.hashCode();
    }

    public final String toString() {
        return "AppData{appIdentifier=" + this.f856a + ", versionCode=" + this.f857b + ", versionName=" + this.f858c + ", installUuid=" + this.f859d + ", deliveryMechanism=" + this.f860e + ", developmentPlatformProvider=" + this.f + "}";
    }
}
