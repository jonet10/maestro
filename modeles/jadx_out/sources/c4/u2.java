package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u2 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2150a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2151b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2152c;

    public u2(int i, String str, String str2) {
        this.f2150a = i;
        this.f2151b = str;
        this.f2152c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u2)) {
            return false;
        }
        u2 u2Var = (u2) obj;
        return this.f2150a == u2Var.f2150a && kotlin.jvm.internal.l.a(this.f2151b, u2Var.f2151b) && kotlin.jvm.internal.l.a(this.f2152c, u2Var.f2152c);
    }

    public final int hashCode() {
        int i = this.f2150a * 31;
        String str = this.f2151b;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f2152c;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LoginData(loginResult=");
        sb.append(this.f2150a);
        sb.append(", loginMessage=");
        sb.append(this.f2151b);
        sb.append(", regErrors=");
        return a4.x.n(sb, this.f2152c, ")");
    }
}
