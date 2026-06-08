package q;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class n extends y {

    /* renamed from: a, reason: collision with root package name */
    public final l f8606a;

    public n(l lVar) {
        this.f8606a = lVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        Object obj2 = x.f8625a;
        if (obj2.equals(obj2)) {
            return this.f8606a.equals(((n) yVar).f8606a);
        }
        return false;
    }

    public final int hashCode() {
        return ((x.f8625a.hashCode() ^ 1000003) * 1000003) ^ this.f8606a.hashCode();
    }

    public final String toString() {
        return "ClientInfo{clientType=" + x.f8625a + ", androidClientInfo=" + this.f8606a + "}";
    }
}
