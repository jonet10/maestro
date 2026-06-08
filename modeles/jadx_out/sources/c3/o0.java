package c3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public final v0 f1296a;

    /* renamed from: b, reason: collision with root package name */
    public final b f1297b;

    public o0(v0 v0Var, b bVar) {
        this.f1296a = v0Var;
        this.f1297b = bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return this.f1296a.equals(o0Var.f1296a) && this.f1297b.equals(o0Var.f1297b);
    }

    public final int hashCode() {
        return this.f1297b.hashCode() + ((this.f1296a.hashCode() + (n.SESSION_START.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "SessionEvent(eventType=" + n.SESSION_START + ", sessionData=" + this.f1296a + ", applicationInfo=" + this.f1297b + ')';
    }
}
