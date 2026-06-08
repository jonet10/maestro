package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e9 {

    /* renamed from: a, reason: collision with root package name */
    public final int f1561a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1562b;

    public e9(int i, int i6) {
        this.f1561a = i;
        this.f1562b = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e9)) {
            return false;
        }
        e9 e9Var = (e9) obj;
        return this.f1561a == e9Var.f1561a && this.f1562b == e9Var.f1562b;
    }

    public final int hashCode() {
        return (this.f1561a * 31) + this.f1562b;
    }

    public final String toString() {
        return "SendReviewData(success=" + this.f1561a + ", statusCode=" + this.f1562b + ")";
    }
}
