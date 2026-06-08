package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k1 {

    /* renamed from: a, reason: collision with root package name */
    public final l1 f848a;

    /* renamed from: b, reason: collision with root package name */
    public final n1 f849b;

    /* renamed from: c, reason: collision with root package name */
    public final m1 f850c;

    public k1(l1 l1Var, n1 n1Var, m1 m1Var) {
        this.f848a = l1Var;
        this.f849b = n1Var;
        this.f850c = m1Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k1)) {
            return false;
        }
        k1 k1Var = (k1) obj;
        return this.f848a.equals(k1Var.f848a) && this.f849b.equals(k1Var.f849b) && this.f850c.equals(k1Var.f850c);
    }

    public final int hashCode() {
        return ((((this.f848a.hashCode() ^ 1000003) * 1000003) ^ this.f849b.hashCode()) * 1000003) ^ this.f850c.hashCode();
    }

    public final String toString() {
        return "StaticSessionData{appData=" + this.f848a + ", osData=" + this.f849b + ", deviceData=" + this.f850c + "}";
    }
}
