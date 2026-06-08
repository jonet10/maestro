package x4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r0 extends u0 {

    /* renamed from: a, reason: collision with root package name */
    public final r f11370a;

    public r0(r rVar) {
        this.f11370a = rVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r0) && kotlin.jvm.internal.l.a(this.f11370a, ((r0) obj).f11370a);
    }

    public final int hashCode() {
        r rVar = this.f11370a;
        if (rVar == null) {
            return 0;
        }
        return rVar.hashCode();
    }

    public final String toString() {
        return "UpdateDownloadFailed(d=" + this.f11370a + ")";
    }
}
