package x4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c0 extends d0 {

    /* renamed from: a, reason: collision with root package name */
    public final r f11075a;

    public c0(r rVar) {
        rVar.getClass();
        this.f11075a = rVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c0) && kotlin.jvm.internal.l.a(this.f11075a, ((c0) obj).f11075a);
    }

    public final int hashCode() {
        return this.f11075a.hashCode();
    }

    public final String toString() {
        return "Started(d=" + this.f11075a + ")";
    }
}
