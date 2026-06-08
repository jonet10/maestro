package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p0 extends j2 {

    /* renamed from: a, reason: collision with root package name */
    public final long f901a;

    /* renamed from: b, reason: collision with root package name */
    public final String f902b;

    /* renamed from: c, reason: collision with root package name */
    public final d2 f903c;

    /* renamed from: d, reason: collision with root package name */
    public final e2 f904d;

    /* renamed from: e, reason: collision with root package name */
    public final f2 f905e;
    public final i2 f;

    public p0(long j, String str, d2 d2Var, e2 e2Var, f2 f2Var, i2 i2Var) {
        this.f901a = j;
        this.f902b = str;
        this.f903c = d2Var;
        this.f904d = e2Var;
        this.f905e = f2Var;
        this.f = i2Var;
    }

    public final o0 a() {
        o0 o0Var = new o0();
        o0Var.f892a = this.f901a;
        o0Var.f893b = this.f902b;
        o0Var.f894c = this.f903c;
        o0Var.f895d = this.f904d;
        o0Var.f896e = this.f905e;
        o0Var.f = this.f;
        o0Var.g = (byte) 1;
        return o0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j2) {
            p0 p0Var = (p0) ((j2) obj);
            if (this.f901a == p0Var.f901a && this.f902b.equals(p0Var.f902b) && this.f903c.equals(p0Var.f903c) && this.f904d.equals(p0Var.f904d)) {
                f2 f2Var = p0Var.f905e;
                f2 f2Var2 = this.f905e;
                if (f2Var2 != null ? f2Var2.equals(f2Var) : f2Var == null) {
                    i2 i2Var = p0Var.f;
                    i2 i2Var2 = this.f;
                    if (i2Var2 != null ? i2Var2.equals(i2Var) : i2Var == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f901a;
        int hashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f902b.hashCode()) * 1000003) ^ this.f903c.hashCode()) * 1000003) ^ this.f904d.hashCode()) * 1000003;
        f2 f2Var = this.f905e;
        int hashCode2 = (hashCode ^ (f2Var == null ? 0 : f2Var.hashCode())) * 1000003;
        i2 i2Var = this.f;
        return hashCode2 ^ (i2Var != null ? i2Var.hashCode() : 0);
    }

    public final String toString() {
        return "Event{timestamp=" + this.f901a + ", type=" + this.f902b + ", app=" + this.f903c + ", device=" + this.f904d + ", log=" + this.f905e + ", rollouts=" + this.f + "}";
    }
}
