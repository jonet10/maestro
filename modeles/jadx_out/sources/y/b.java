package y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f11579a;

    /* renamed from: b, reason: collision with root package name */
    public final r.j f11580b;

    /* renamed from: c, reason: collision with root package name */
    public final r.i f11581c;

    public b(long j, r.j jVar, r.i iVar) {
        this.f11579a = j;
        this.f11580b = jVar;
        this.f11581c = iVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f11579a == bVar.f11579a && this.f11580b.equals(bVar.f11580b) && this.f11581c.equals(bVar.f11581c);
    }

    public final int hashCode() {
        long j = this.f11579a;
        return ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f11580b.hashCode()) * 1000003) ^ this.f11581c.hashCode();
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f11579a + ", transportContext=" + this.f11580b + ", event=" + this.f11581c + "}";
    }
}
