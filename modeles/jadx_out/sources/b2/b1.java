package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b1 extends e2 {

    /* renamed from: a, reason: collision with root package name */
    public final Double f740a;

    /* renamed from: b, reason: collision with root package name */
    public final int f741b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f742c;

    /* renamed from: d, reason: collision with root package name */
    public final int f743d;

    /* renamed from: e, reason: collision with root package name */
    public final long f744e;
    public final long f;

    public b1(Double d10, int i, boolean z9, int i6, long j, long j6) {
        this.f740a = d10;
        this.f741b = i;
        this.f742c = z9;
        this.f743d = i6;
        this.f744e = j;
        this.f = j6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e2) {
            e2 e2Var = (e2) obj;
            Double d10 = this.f740a;
            if (d10 != null ? d10.equals(((b1) e2Var).f740a) : ((b1) e2Var).f740a == null) {
                b1 b1Var = (b1) e2Var;
                if (this.f741b == b1Var.f741b && this.f742c == b1Var.f742c && this.f743d == b1Var.f743d && this.f744e == b1Var.f744e && this.f == b1Var.f) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Double d10 = this.f740a;
        int hashCode = ((((((((d10 == null ? 0 : d10.hashCode()) ^ 1000003) * 1000003) ^ this.f741b) * 1000003) ^ (this.f742c ? 1231 : 1237)) * 1000003) ^ this.f743d) * 1000003;
        long j = this.f744e;
        long j6 = this.f;
        return ((hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Device{batteryLevel=");
        sb.append(this.f740a);
        sb.append(", batteryVelocity=");
        sb.append(this.f741b);
        sb.append(", proximityOn=");
        sb.append(this.f742c);
        sb.append(", orientation=");
        sb.append(this.f743d);
        sb.append(", ramUsed=");
        sb.append(this.f744e);
        sb.append(", diskUsed=");
        return a4.x.l(sb, this.f, "}");
    }
}
