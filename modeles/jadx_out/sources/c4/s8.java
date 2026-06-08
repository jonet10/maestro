package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s8 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2085a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2086b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2087c;

    /* renamed from: d, reason: collision with root package name */
    public final long f2088d;

    /* renamed from: e, reason: collision with root package name */
    public final String f2089e;

    public s8(int i, int i6, long j, String str, String str2) {
        this.f2085a = i;
        this.f2086b = i6;
        this.f2087c = str;
        this.f2088d = j;
        this.f2089e = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s8)) {
            return false;
        }
        s8 s8Var = (s8) obj;
        return this.f2085a == s8Var.f2085a && this.f2086b == s8Var.f2086b && this.f2087c.equals(s8Var.f2087c) && this.f2088d == s8Var.f2088d && kotlin.jvm.internal.l.a(this.f2089e, s8Var.f2089e);
    }

    public final int hashCode() {
        int o10 = androidx.lifecycle.l.o(((this.f2085a * 31) + this.f2086b) * 31, 31, this.f2087c);
        long j = this.f2088d;
        int i = (o10 + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.f2089e;
        return i + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SendReplyData(success=");
        sb.append(this.f2085a);
        sb.append(", statusCode=");
        sb.append(this.f2086b);
        sb.append(", text=");
        sb.append(this.f2087c);
        sb.append(", reviewID=");
        sb.append(this.f2088d);
        return a4.x.o(sb, ", msg=", this.f2089e, ")");
    }
}
