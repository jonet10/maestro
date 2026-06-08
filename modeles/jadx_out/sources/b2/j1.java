package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j1 extends l2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f837a;

    public j1(String str) {
        this.f837a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l2)) {
            return false;
        }
        return this.f837a.equals(((j1) ((l2) obj)).f837a);
    }

    public final int hashCode() {
        return this.f837a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return a4.x.n(new StringBuilder("User{identifier="), this.f837a, "}");
    }
}
