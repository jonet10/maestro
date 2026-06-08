package x;

import java.util.HashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final q2.e f11009a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f11010b;

    public a(q2.e eVar, HashMap hashMap) {
        this.f11009a = eVar;
        this.f11010b = hashMap;
    }

    public final long a(o.d dVar, long j, int i) {
        long f = j - this.f11009a.f();
        b bVar = (b) this.f11010b.get(dVar);
        long j6 = bVar.f11011a;
        return Math.min(Math.max((long) (Math.pow(3.0d, i - 1) * j6 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j6 > 1 ? j6 : 2L) * r12))), f), bVar.f11012b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f11009a.equals(aVar.f11009a) && this.f11010b.equals(aVar.f11010b);
    }

    public final int hashCode() {
        return ((this.f11009a.hashCode() ^ 1000003) * 1000003) ^ this.f11010b.hashCode();
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f11009a + ", values=" + this.f11010b + "}";
    }
}
