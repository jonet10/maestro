package b2;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t0 extends x1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f940a;

    /* renamed from: b, reason: collision with root package name */
    public final String f941b;

    /* renamed from: c, reason: collision with root package name */
    public final List f942c;

    /* renamed from: d, reason: collision with root package name */
    public final x1 f943d;

    /* renamed from: e, reason: collision with root package name */
    public final int f944e;

    public t0(String str, String str2, List list, x1 x1Var, int i) {
        this.f940a = str;
        this.f941b = str2;
        this.f942c = list;
        this.f943d = x1Var;
        this.f944e = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x1) {
            t0 t0Var = (t0) ((x1) obj);
            if (this.f940a.equals(t0Var.f940a)) {
                String str = t0Var.f941b;
                String str2 = this.f941b;
                if (str2 != null ? str2.equals(str) : str == null) {
                    if (this.f942c.equals(t0Var.f942c)) {
                        x1 x1Var = t0Var.f943d;
                        x1 x1Var2 = this.f943d;
                        if (x1Var2 != null ? x1Var2.equals(x1Var) : x1Var == null) {
                            if (this.f944e == t0Var.f944e) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f940a.hashCode() ^ 1000003) * 1000003;
        String str = this.f941b;
        int hashCode2 = (((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f942c.hashCode()) * 1000003;
        x1 x1Var = this.f943d;
        return ((hashCode2 ^ (x1Var != null ? x1Var.hashCode() : 0)) * 1000003) ^ this.f944e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Exception{type=");
        sb.append(this.f940a);
        sb.append(", reason=");
        sb.append(this.f941b);
        sb.append(", frames=");
        sb.append(this.f942c);
        sb.append(", causedBy=");
        sb.append(this.f943d);
        sb.append(", overflowCount=");
        return androidx.lifecycle.l.x(sb, "}", this.f944e);
    }
}
