package q;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class v extends i0 {

    /* renamed from: a, reason: collision with root package name */
    public final h0 f8623a;

    /* renamed from: b, reason: collision with root package name */
    public final g0 f8624b;

    public v(h0 h0Var, g0 g0Var) {
        this.f8623a = h0Var;
        this.f8624b = g0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i0) {
            i0 i0Var = (i0) obj;
            h0 h0Var = this.f8623a;
            if (h0Var != null ? h0Var.equals(((v) i0Var).f8623a) : ((v) i0Var).f8623a == null) {
                g0 g0Var = this.f8624b;
                if (g0Var != null ? g0Var.equals(((v) i0Var).f8624b) : ((v) i0Var).f8624b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        h0 h0Var = this.f8623a;
        int hashCode = ((h0Var == null ? 0 : h0Var.hashCode()) ^ 1000003) * 1000003;
        g0 g0Var = this.f8624b;
        return (g0Var != null ? g0Var.hashCode() : 0) ^ hashCode;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f8623a + ", mobileSubtype=" + this.f8624b + "}";
    }
}
