package x4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t0 extends u0 {

    /* renamed from: a, reason: collision with root package name */
    public final r f11395a;

    public t0(r rVar) {
        this.f11395a = rVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t0) && kotlin.jvm.internal.l.a(this.f11395a, ((t0) obj).f11395a);
    }

    public final int hashCode() {
        r rVar = this.f11395a;
        if (rVar == null) {
            return 0;
        }
        return rVar.hashCode();
    }

    public final String toString() {
        return "UpdateDownloadStarted(d=" + this.f11395a + ")";
    }
}
