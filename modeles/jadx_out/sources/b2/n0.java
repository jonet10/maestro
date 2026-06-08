package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n0 extends v1 {

    /* renamed from: a, reason: collision with root package name */
    public final int f881a;

    /* renamed from: b, reason: collision with root package name */
    public final String f882b;

    /* renamed from: c, reason: collision with root package name */
    public final int f883c;

    /* renamed from: d, reason: collision with root package name */
    public final long f884d;

    /* renamed from: e, reason: collision with root package name */
    public final long f885e;
    public final boolean f;
    public final int g;
    public final String h;
    public final String i;

    public n0(int i, String str, int i6, long j, long j6, boolean z9, int i10, String str2, String str3) {
        this.f881a = i;
        this.f882b = str;
        this.f883c = i6;
        this.f884d = j;
        this.f885e = j6;
        this.f = z9;
        this.g = i10;
        this.h = str2;
        this.i = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v1) {
            n0 n0Var = (n0) ((v1) obj);
            if (this.f881a == n0Var.f881a && this.f882b.equals(n0Var.f882b) && this.f883c == n0Var.f883c && this.f884d == n0Var.f884d && this.f885e == n0Var.f885e && this.f == n0Var.f && this.g == n0Var.g && this.h.equals(n0Var.h) && this.i.equals(n0Var.i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((((this.f881a ^ 1000003) * 1000003) ^ this.f882b.hashCode()) * 1000003) ^ this.f883c) * 1000003;
        long j = this.f884d;
        int i = (hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j6 = this.f885e;
        return ((((((((i ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ (this.f ? 1231 : 1237)) * 1000003) ^ this.g) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.i.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Device{arch=");
        sb.append(this.f881a);
        sb.append(", model=");
        sb.append(this.f882b);
        sb.append(", cores=");
        sb.append(this.f883c);
        sb.append(", ram=");
        sb.append(this.f884d);
        sb.append(", diskSpace=");
        sb.append(this.f885e);
        sb.append(", simulator=");
        sb.append(this.f);
        sb.append(", state=");
        sb.append(this.g);
        sb.append(", manufacturer=");
        sb.append(this.h);
        sb.append(", modelClass=");
        return a4.x.n(sb, this.i, "}");
    }
}
