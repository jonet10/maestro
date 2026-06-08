package b2;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q0 extends d2 {

    /* renamed from: a, reason: collision with root package name */
    public final r0 f911a;

    /* renamed from: b, reason: collision with root package name */
    public final List f912b;

    /* renamed from: c, reason: collision with root package name */
    public final List f913c;

    /* renamed from: d, reason: collision with root package name */
    public final Boolean f914d;

    /* renamed from: e, reason: collision with root package name */
    public final c2 f915e;
    public final List f;
    public final int g;

    public q0(r0 r0Var, List list, List list2, Boolean bool, c2 c2Var, List list3, int i) {
        this.f911a = r0Var;
        this.f912b = list;
        this.f913c = list2;
        this.f914d = bool;
        this.f915e = c2Var;
        this.f = list3;
        this.g = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d2)) {
            return false;
        }
        q0 q0Var = (q0) ((d2) obj);
        if (!this.f911a.equals(q0Var.f911a)) {
            return false;
        }
        List list = q0Var.f912b;
        List list2 = this.f912b;
        if (list2 == null) {
            if (list != null) {
                return false;
            }
        } else if (!list2.equals(list)) {
            return false;
        }
        List list3 = q0Var.f913c;
        List list4 = this.f913c;
        if (list4 == null) {
            if (list3 != null) {
                return false;
            }
        } else if (!list4.equals(list3)) {
            return false;
        }
        Boolean bool = q0Var.f914d;
        Boolean bool2 = this.f914d;
        if (bool2 == null) {
            if (bool != null) {
                return false;
            }
        } else if (!bool2.equals(bool)) {
            return false;
        }
        c2 c2Var = q0Var.f915e;
        c2 c2Var2 = this.f915e;
        if (c2Var2 == null) {
            if (c2Var != null) {
                return false;
            }
        } else if (!c2Var2.equals(c2Var)) {
            return false;
        }
        List list5 = q0Var.f;
        List list6 = this.f;
        if (list6 == null) {
            if (list5 != null) {
                return false;
            }
        } else if (!list6.equals(list5)) {
            return false;
        }
        return this.g == q0Var.g;
    }

    public final int hashCode() {
        int hashCode = (this.f911a.hashCode() ^ 1000003) * 1000003;
        List list = this.f912b;
        int hashCode2 = (hashCode ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List list2 = this.f913c;
        int hashCode3 = (hashCode2 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        Boolean bool = this.f914d;
        int hashCode4 = (hashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        c2 c2Var = this.f915e;
        int hashCode5 = (hashCode4 ^ (c2Var == null ? 0 : c2Var.hashCode())) * 1000003;
        List list3 = this.f;
        return ((hashCode5 ^ (list3 != null ? list3.hashCode() : 0)) * 1000003) ^ this.g;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Application{execution=");
        sb.append(this.f911a);
        sb.append(", customAttributes=");
        sb.append(this.f912b);
        sb.append(", internalKeys=");
        sb.append(this.f913c);
        sb.append(", background=");
        sb.append(this.f914d);
        sb.append(", currentProcessDetails=");
        sb.append(this.f915e);
        sb.append(", appProcessDetails=");
        sb.append(this.f);
        sb.append(", uiOrientation=");
        return androidx.lifecycle.l.x(sb, "}", this.g);
    }
}
