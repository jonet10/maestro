package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x0 extends z1 {

    /* renamed from: a, reason: collision with root package name */
    public final long f971a;

    /* renamed from: b, reason: collision with root package name */
    public final String f972b;

    /* renamed from: c, reason: collision with root package name */
    public final String f973c;

    /* renamed from: d, reason: collision with root package name */
    public final long f974d;

    /* renamed from: e, reason: collision with root package name */
    public final int f975e;

    public x0(long j, String str, String str2, long j6, int i) {
        this.f971a = j;
        this.f972b = str;
        this.f973c = str2;
        this.f974d = j6;
        this.f975e = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z1) {
            x0 x0Var = (x0) ((z1) obj);
            if (this.f971a == x0Var.f971a && this.f972b.equals(x0Var.f972b)) {
                String str = x0Var.f973c;
                String str2 = this.f973c;
                if (str2 != null ? str2.equals(str) : str == null) {
                    if (this.f974d == x0Var.f974d && this.f975e == x0Var.f975e) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f971a;
        int hashCode = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f972b.hashCode()) * 1000003;
        String str = this.f973c;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j6 = this.f974d;
        return ((hashCode2 ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ this.f975e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Frame{pc=");
        sb.append(this.f971a);
        sb.append(", symbol=");
        sb.append(this.f972b);
        sb.append(", file=");
        sb.append(this.f973c);
        sb.append(", offset=");
        sb.append(this.f974d);
        sb.append(", importance=");
        return androidx.lifecycle.l.x(sb, "}", this.f975e);
    }
}
