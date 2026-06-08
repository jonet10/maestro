package x4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n2 {

    /* renamed from: a, reason: collision with root package name */
    public final long f11295a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11296b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11297c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11298d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11299e;

    public n2(long j, String str, String str2, String str3, String str4) {
        this.f11295a = j;
        this.f11296b = str;
        this.f11297c = str2;
        this.f11298d = str3;
        this.f11299e = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n2)) {
            return false;
        }
        n2 n2Var = (n2) obj;
        return this.f11295a == n2Var.f11295a && kotlin.jvm.internal.l.a(this.f11296b, n2Var.f11296b) && kotlin.jvm.internal.l.a(this.f11297c, n2Var.f11297c) && kotlin.jvm.internal.l.a(this.f11298d, n2Var.f11298d) && kotlin.jvm.internal.l.a(this.f11299e, n2Var.f11299e);
    }

    public final int hashCode() {
        long j = this.f11295a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.f11296b;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f11297c;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f11298d;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f11299e;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SystemMessage(id=");
        sb.append(this.f11295a);
        sb.append(", title=");
        sb.append(this.f11296b);
        a4.x.B(sb, ", body=", this.f11297c, ", url=", this.f11298d);
        return a4.x.o(sb, ", actionButtonText=", this.f11299e, ")");
    }
}
