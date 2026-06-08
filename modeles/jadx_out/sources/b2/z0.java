package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z0 extends c2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f988a;

    /* renamed from: b, reason: collision with root package name */
    public final int f989b;

    /* renamed from: c, reason: collision with root package name */
    public final int f990c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f991d;

    public z0(String str, int i, int i6, boolean z9) {
        this.f988a = str;
        this.f989b = i;
        this.f990c = i6;
        this.f991d = z9;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c2) {
            z0 z0Var = (z0) ((c2) obj);
            if (this.f988a.equals(z0Var.f988a) && this.f989b == z0Var.f989b && this.f990c == z0Var.f990c && this.f991d == z0Var.f991d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f988a.hashCode() ^ 1000003) * 1000003) ^ this.f989b) * 1000003) ^ this.f990c) * 1000003) ^ (this.f991d ? 1231 : 1237);
    }

    public final String toString() {
        return "ProcessDetails{processName=" + this.f988a + ", pid=" + this.f989b + ", importance=" + this.f990c + ", defaultProcess=" + this.f991d + "}";
    }
}
