package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f0 extends q1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f785a;

    /* renamed from: b, reason: collision with root package name */
    public final String f786b;

    public f0(String str, String str2) {
        this.f785a = str;
        this.f786b = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q1)) {
            return false;
        }
        f0 f0Var = (f0) ((q1) obj);
        return this.f785a.equals(f0Var.f785a) && this.f786b.equals(f0Var.f786b);
    }

    public final int hashCode() {
        return ((this.f785a.hashCode() ^ 1000003) * 1000003) ^ this.f786b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CustomAttribute{key=");
        sb.append(this.f785a);
        sb.append(", value=");
        return a4.x.n(sb, this.f786b, "}");
    }
}
