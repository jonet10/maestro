package q;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class r extends d0 {

    /* renamed from: a, reason: collision with root package name */
    public final q f8611a;

    public r(q qVar) {
        this.f8611a = qVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        return this.f8611a.equals(((r) ((d0) obj)).f8611a);
    }

    public final int hashCode() {
        return this.f8611a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "ExternalPrivacyContext{prequest=" + this.f8611a + "}";
    }
}
