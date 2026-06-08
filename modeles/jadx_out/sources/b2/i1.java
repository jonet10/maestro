package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i1 extends k2 {

    /* renamed from: a, reason: collision with root package name */
    public final int f818a;

    /* renamed from: b, reason: collision with root package name */
    public final String f819b;

    /* renamed from: c, reason: collision with root package name */
    public final String f820c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f821d;

    public i1(String str, String str2, boolean z9, int i) {
        this.f818a = i;
        this.f819b = str;
        this.f820c = str2;
        this.f821d = z9;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k2) {
            i1 i1Var = (i1) ((k2) obj);
            if (this.f818a == i1Var.f818a && this.f819b.equals(i1Var.f819b) && this.f820c.equals(i1Var.f820c) && this.f821d == i1Var.f821d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f818a ^ 1000003) * 1000003) ^ this.f819b.hashCode()) * 1000003) ^ this.f820c.hashCode()) * 1000003) ^ (this.f821d ? 1231 : 1237);
    }

    public final String toString() {
        return "OperatingSystem{platform=" + this.f818a + ", version=" + this.f819b + ", buildVersion=" + this.f820c + ", jailbroken=" + this.f821d + "}";
    }
}
