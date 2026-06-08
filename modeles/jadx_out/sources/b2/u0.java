package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u0 extends y1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f950a;

    /* renamed from: b, reason: collision with root package name */
    public final String f951b;

    /* renamed from: c, reason: collision with root package name */
    public final long f952c;

    public u0(long j, String str, String str2) {
        this.f950a = str;
        this.f951b = str2;
        this.f952c = j;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof y1) {
            u0 u0Var = (u0) ((y1) obj);
            if (this.f950a.equals(u0Var.f950a) && this.f951b.equals(u0Var.f951b) && this.f952c == u0Var.f952c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((this.f950a.hashCode() ^ 1000003) * 1000003) ^ this.f951b.hashCode()) * 1000003;
        long j = this.f952c;
        return hashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Signal{name=");
        sb.append(this.f950a);
        sb.append(", code=");
        sb.append(this.f951b);
        sb.append(", address=");
        return a4.x.l(sb, this.f952c, "}");
    }
}
