package x4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b0 extends d0 {

    /* renamed from: a, reason: collision with root package name */
    public final r f11056a;

    public b0(r rVar) {
        rVar.getClass();
        this.f11056a = rVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b0) && kotlin.jvm.internal.l.a(this.f11056a, ((b0) obj).f11056a);
    }

    public final int hashCode() {
        return this.f11056a.hashCode();
    }

    public final String toString() {
        return "ProgressUpdate(d=" + this.f11056a + ")";
    }
}
