package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s0 extends w1 {

    /* renamed from: a, reason: collision with root package name */
    public final long f931a;

    /* renamed from: b, reason: collision with root package name */
    public final long f932b;

    /* renamed from: c, reason: collision with root package name */
    public final String f933c;

    /* renamed from: d, reason: collision with root package name */
    public final String f934d;

    public s0(long j, long j6, String str, String str2) {
        this.f931a = j;
        this.f932b = j6;
        this.f933c = str;
        this.f934d = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w1) {
            s0 s0Var = (s0) ((w1) obj);
            if (this.f931a == s0Var.f931a && this.f932b == s0Var.f932b && this.f933c.equals(s0Var.f933c)) {
                String str = s0Var.f934d;
                String str2 = this.f934d;
                if (str2 != null ? str2.equals(str) : str == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f931a;
        long j6 = this.f932b;
        int hashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ this.f933c.hashCode()) * 1000003;
        String str = this.f934d;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BinaryImage{baseAddress=");
        sb.append(this.f931a);
        sb.append(", size=");
        sb.append(this.f932b);
        sb.append(", name=");
        sb.append(this.f933c);
        sb.append(", uuid=");
        return a4.x.n(sb, this.f934d, "}");
    }
}
