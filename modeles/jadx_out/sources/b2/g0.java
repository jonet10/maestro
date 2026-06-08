package b2;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g0 extends s1 {

    /* renamed from: a, reason: collision with root package name */
    public final List f794a;

    /* renamed from: b, reason: collision with root package name */
    public final String f795b;

    public g0(String str, List list) {
        this.f794a = list;
        this.f795b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s1)) {
            return false;
        }
        g0 g0Var = (g0) ((s1) obj);
        if (!this.f794a.equals(g0Var.f794a)) {
            return false;
        }
        String str = g0Var.f795b;
        String str2 = this.f795b;
        return str2 == null ? str == null : str2.equals(str);
    }

    public final int hashCode() {
        int hashCode = (this.f794a.hashCode() ^ 1000003) * 1000003;
        String str = this.f795b;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FilesPayload{files=");
        sb.append(this.f794a);
        sb.append(", orgId=");
        return a4.x.n(sb, this.f795b, "}");
    }
}
