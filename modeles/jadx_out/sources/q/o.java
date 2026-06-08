package q;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class o extends a0 {

    /* renamed from: a, reason: collision with root package name */
    public final r f8607a;

    public o(r rVar) {
        z zVar = z.f8627a;
        this.f8607a = rVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        if (!this.f8607a.equals(((o) ((a0) obj)).f8607a)) {
            return false;
        }
        Object obj2 = z.f8627a;
        return obj2.equals(obj2);
    }

    public final int hashCode() {
        return ((this.f8607a.hashCode() ^ 1000003) * 1000003) ^ z.f8627a.hashCode();
    }

    public final String toString() {
        return "ComplianceData{privacyContext=" + this.f8607a + ", productIdOrigin=" + z.f8627a + "}";
    }
}
