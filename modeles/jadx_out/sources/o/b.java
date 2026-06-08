package o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f8124a;

    public b(Integer num) {
        this.f8124a = num;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            return this.f8124a.equals(((b) obj).f8124a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f8124a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "ProductData{productId=" + this.f8124a + "}";
    }
}
