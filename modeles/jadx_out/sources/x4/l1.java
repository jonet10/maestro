package x4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l1 extends m1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f11274a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11275b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11276c;

    public l1(String str, String str2, String str3) {
        this.f11274a = str;
        this.f11275b = str2;
        this.f11276c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l1)) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return kotlin.jvm.internal.l.a(this.f11274a, l1Var.f11274a) && kotlin.jvm.internal.l.a(this.f11275b, l1Var.f11275b) && kotlin.jvm.internal.l.a(this.f11276c, l1Var.f11276c);
    }

    public final int hashCode() {
        String str = this.f11274a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f11275b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f11276c;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Failed(packageName=");
        sb.append(this.f11274a);
        sb.append(", appName=");
        sb.append(this.f11275b);
        sb.append(", errorMessage=");
        return a4.x.n(sb, this.f11276c, ")");
    }
}
