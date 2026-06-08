package j5;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r extends s {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6707a;

    public r(Object obj) {
        this.f6707a = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r) && kotlin.jvm.internal.l.a(this.f6707a, ((r) obj).f6707a);
    }

    public final int hashCode() {
        Object obj = this.f6707a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        return "Success(data=" + this.f6707a + ")";
    }
}
