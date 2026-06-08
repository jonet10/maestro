package x4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c2 {

    /* renamed from: a, reason: collision with root package name */
    public final d2 f11080a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11081b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11082c;

    public c2(d2 d2Var, int i, int i6) {
        d2Var.getClass();
        this.f11080a = d2Var;
        this.f11081b = i;
        this.f11082c = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c2)) {
            return false;
        }
        c2 c2Var = (c2) obj;
        return kotlin.jvm.internal.l.a(this.f11080a, c2Var.f11080a) && this.f11081b == c2Var.f11081b && this.f11082c == c2Var.f11082c;
    }

    public final int hashCode() {
        return (((this.f11080a.hashCode() * 31) + this.f11081b) * 31) + this.f11082c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ReplyLikeData(reply=");
        sb.append(this.f11080a);
        sb.append(", success=");
        sb.append(this.f11081b);
        sb.append(", statusCode=");
        return androidx.lifecycle.l.x(sb, ")", this.f11082c);
    }
}
