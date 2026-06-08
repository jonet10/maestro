package q;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class q extends c0 {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f8610a;

    public q(Integer num) {
        this.f8610a = num;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        Integer num = this.f8610a;
        q qVar = (q) ((c0) obj);
        return num == null ? qVar.f8610a == null : num.equals(qVar.f8610a);
    }

    public final int hashCode() {
        Integer num = this.f8610a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public final String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.f8610a + "}";
    }
}
