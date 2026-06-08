package x4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j2 {

    /* renamed from: a, reason: collision with root package name */
    public final k2 f11244a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11245b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11246c;

    public j2(k2 k2Var, int i, int i6) {
        k2Var.getClass();
        this.f11244a = k2Var;
        this.f11245b = i;
        this.f11246c = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j2)) {
            return false;
        }
        j2 j2Var = (j2) obj;
        return kotlin.jvm.internal.l.a(this.f11244a, j2Var.f11244a) && this.f11245b == j2Var.f11245b && this.f11246c == j2Var.f11246c;
    }

    public final int hashCode() {
        return (((this.f11244a.hashCode() * 31) + this.f11245b) * 31) + this.f11246c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ReviewLikeData(review=");
        sb.append(this.f11244a);
        sb.append(", success=");
        sb.append(this.f11245b);
        sb.append(", statusCode=");
        return androidx.lifecycle.l.x(sb, ")", this.f11246c);
    }
}
