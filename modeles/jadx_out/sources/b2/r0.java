package b2;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r0 extends b2 {

    /* renamed from: a, reason: collision with root package name */
    public final List f921a;

    /* renamed from: b, reason: collision with root package name */
    public final x1 f922b;

    /* renamed from: c, reason: collision with root package name */
    public final p1 f923c;

    /* renamed from: d, reason: collision with root package name */
    public final u0 f924d;

    /* renamed from: e, reason: collision with root package name */
    public final List f925e;

    public r0(List list, t0 t0Var, p1 p1Var, u0 u0Var, List list2) {
        this.f921a = list;
        this.f922b = t0Var;
        this.f923c = p1Var;
        this.f924d = u0Var;
        this.f925e = list2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b2)) {
            return false;
        }
        b2 b2Var = (b2) obj;
        List list = this.f921a;
        if (list == null) {
            if (((r0) b2Var).f921a != null) {
                return false;
            }
        } else if (!list.equals(((r0) b2Var).f921a)) {
            return false;
        }
        x1 x1Var = this.f922b;
        if (x1Var == null) {
            if (((r0) b2Var).f922b != null) {
                return false;
            }
        } else if (!x1Var.equals(((r0) b2Var).f922b)) {
            return false;
        }
        p1 p1Var = this.f923c;
        if (p1Var == null) {
            if (((r0) b2Var).f923c != null) {
                return false;
            }
        } else if (!p1Var.equals(((r0) b2Var).f923c)) {
            return false;
        }
        r0 r0Var = (r0) b2Var;
        return this.f924d.equals(r0Var.f924d) && this.f925e.equals(r0Var.f925e);
    }

    public final int hashCode() {
        List list = this.f921a;
        int hashCode = ((list == null ? 0 : list.hashCode()) ^ 1000003) * 1000003;
        x1 x1Var = this.f922b;
        int hashCode2 = (hashCode ^ (x1Var == null ? 0 : x1Var.hashCode())) * 1000003;
        p1 p1Var = this.f923c;
        return (((((p1Var != null ? p1Var.hashCode() : 0) ^ hashCode2) * 1000003) ^ this.f924d.hashCode()) * 1000003) ^ this.f925e.hashCode();
    }

    public final String toString() {
        return "Execution{threads=" + this.f921a + ", exception=" + this.f922b + ", appExitInfo=" + this.f923c + ", signal=" + this.f924d + ", binaries=" + this.f925e + "}";
    }
}
