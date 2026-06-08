package x;

import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f11011a;

    /* renamed from: b, reason: collision with root package name */
    public final long f11012b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f11013c;

    public b(long j, long j6, Set set) {
        this.f11011a = j;
        this.f11012b = j6;
        this.f11013c = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f11011a == bVar.f11011a && this.f11012b == bVar.f11012b && this.f11013c.equals(bVar.f11013c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f11011a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j6 = this.f11012b;
        return ((i ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ this.f11013c.hashCode();
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f11011a + ", maxAllowedDelay=" + this.f11012b + ", flags=" + this.f11013c + "}";
    }
}
