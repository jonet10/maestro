package i9;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f5706a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5707b;

    public a(long j, String str) {
        this.f5706a = str;
        this.f5707b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f5706a.equals(aVar.f5706a) && this.f5707b == aVar.f5707b;
    }

    public final int hashCode() {
        int hashCode = this.f5706a.hashCode() * 31;
        long j = this.f5707b;
        return ((int) (j ^ (j >>> 32))) + hashCode;
    }

    public final String toString() {
        return "ApiResponse(body=" + this.f5706a + ", timestamp=" + this.f5707b + ')';
    }
}
