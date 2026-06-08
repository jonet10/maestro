package o7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z extends t6.a {

    /* renamed from: b, reason: collision with root package name */
    public static final x f8333b = new x();

    /* renamed from: a, reason: collision with root package name */
    public final String f8334a;

    public z() {
        super(f8333b);
        this.f8334a = "Room Invalidation Tracker Refresh";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof z) && kotlin.jvm.internal.l.a(this.f8334a, ((z) obj).f8334a);
    }

    public final int hashCode() {
        return this.f8334a.hashCode();
    }

    public final String toString() {
        return a4.x.m(new StringBuilder("CoroutineName("), this.f8334a, ')');
    }
}
