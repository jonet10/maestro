package u4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10523a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10524b;

    public l0(boolean z9, int i) {
        this.f10523a = z9;
        this.f10524b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return this.f10523a == l0Var.f10523a && this.f10524b == l0Var.f10524b;
    }

    public final int hashCode() {
        return ((this.f10523a ? 1231 : 1237) * 31) + this.f10524b;
    }

    public final String toString() {
        return "SendReviewActionData(succeed=" + this.f10523a + ", statusCode=" + this.f10524b + ")";
    }
}
