package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v2 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2194a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2195b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2196c;

    public v2(int i, String str, String str2) {
        this.f2194a = i;
        this.f2195b = str;
        this.f2196c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v2)) {
            return false;
        }
        v2 v2Var = (v2) obj;
        return this.f2194a == v2Var.f2194a && kotlin.jvm.internal.l.a(this.f2195b, v2Var.f2195b) && kotlin.jvm.internal.l.a(this.f2196c, v2Var.f2196c);
    }

    public final int hashCode() {
        int i = this.f2194a * 31;
        String str = this.f2195b;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f2196c;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SignUpData(success=");
        sb.append(this.f2194a);
        sb.append(", signUpMessage=");
        sb.append(this.f2195b);
        sb.append(", regErrors=");
        return a4.x.n(sb, this.f2196c, ")");
    }
}
