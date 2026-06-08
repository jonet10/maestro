package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c1 extends f2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f753a;

    public c1(String str) {
        this.f753a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f2)) {
            return false;
        }
        return this.f753a.equals(((c1) ((f2) obj)).f753a);
    }

    public final int hashCode() {
        return this.f753a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return a4.x.n(new StringBuilder("Log{content="), this.f753a, "}");
    }
}
