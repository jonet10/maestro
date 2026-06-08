package b2;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v0 extends a2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f958a;

    /* renamed from: b, reason: collision with root package name */
    public final int f959b;

    /* renamed from: c, reason: collision with root package name */
    public final List f960c;

    public v0(String str, int i, List list) {
        this.f958a = str;
        this.f959b = i;
        this.f960c = list;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a2) {
            v0 v0Var = (v0) ((a2) obj);
            if (this.f958a.equals(v0Var.f958a) && this.f959b == v0Var.f959b && this.f960c.equals(v0Var.f960c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f958a.hashCode() ^ 1000003) * 1000003) ^ this.f959b) * 1000003) ^ this.f960c.hashCode();
    }

    public final String toString() {
        return "Thread{name=" + this.f958a + ", importance=" + this.f959b + ", frames=" + this.f960c + "}";
    }
}
