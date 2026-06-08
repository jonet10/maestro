package o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8121a;

    /* renamed from: b, reason: collision with root package name */
    public final d f8122b;

    /* renamed from: c, reason: collision with root package name */
    public final b f8123c;

    public a(Object obj, d dVar, b bVar) {
        this.f8121a = obj;
        this.f8122b = dVar;
        this.f8123c = bVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f8121a.equals(aVar.f8121a) || !this.f8122b.equals(aVar.f8122b)) {
            return false;
        }
        b bVar = aVar.f8123c;
        b bVar2 = this.f8123c;
        return bVar2 == null ? bVar == null : bVar2.equals(bVar);
    }

    public final int hashCode() {
        int hashCode = ((((1000003 * 1000003) ^ this.f8121a.hashCode()) * 1000003) ^ this.f8122b.hashCode()) * 1000003;
        b bVar = this.f8123c;
        return (hashCode ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.f8121a + ", priority=" + this.f8122b + ", productData=" + this.f8123c + ", eventContext=null}";
    }
}
