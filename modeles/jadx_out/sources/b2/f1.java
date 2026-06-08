package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f1 extends g2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f787a;

    /* renamed from: b, reason: collision with root package name */
    public final String f788b;

    public f1(String str, String str2) {
        this.f787a = str;
        this.f788b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g2) {
            f1 f1Var = (f1) ((g2) obj);
            if (this.f787a.equals(f1Var.f787a) && this.f788b.equals(f1Var.f788b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f787a.hashCode() ^ 1000003) * 1000003) ^ this.f788b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RolloutVariant{rolloutId=");
        sb.append(this.f787a);
        sb.append(", variantId=");
        return a4.x.n(sb, this.f788b, "}");
    }
}
