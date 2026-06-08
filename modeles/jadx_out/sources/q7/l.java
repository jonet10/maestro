package q7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l {

    /* renamed from: b, reason: collision with root package name */
    public static final k f8771b = new k();

    /* renamed from: a, reason: collision with root package name */
    public final Object f8772a;

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            return kotlin.jvm.internal.l.a(this.f8772a, ((l) obj).f8772a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f8772a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f8772a;
        if (obj instanceof j) {
            return ((j) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
