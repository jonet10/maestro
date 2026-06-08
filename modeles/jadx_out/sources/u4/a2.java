package u4;

import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a2 {

    /* renamed from: a, reason: collision with root package name */
    public final p2 f10423a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10424b;

    public a2(p2 p2Var, boolean z9) {
        this.f10423a = p2Var;
        this.f10424b = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a2)) {
            return false;
        }
        a2 a2Var = (a2) obj;
        return this.f10423a.equals(a2Var.f10423a) && this.f10424b == a2Var.f10424b;
    }

    public final int hashCode() {
        return (this.f10423a.hashCode() * 31) + (this.f10424b ? 1231 : 1237);
    }

    public final String toString() {
        return "TopByCategoryData(topByCategory=" + this.f10423a + ", firstRequest=" + this.f10424b + ")";
    }
}
