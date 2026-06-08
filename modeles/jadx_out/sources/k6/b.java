package k6;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f6980a;

    /* renamed from: b, reason: collision with root package name */
    public final a f6981b;

    public b(Integer num, a aVar) {
        this.f6980a = num;
        this.f6981b = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f6980a.equals(bVar.f6980a) && this.f6981b.equals(bVar.f6981b);
    }

    public final int hashCode() {
        return this.f6981b.hashCode() + (this.f6980a.hashCode() * 31);
    }

    public final String toString() {
        return "GBCPurpose(id=" + this.f6980a + ", banner=" + this.f6981b + ')';
    }
}
