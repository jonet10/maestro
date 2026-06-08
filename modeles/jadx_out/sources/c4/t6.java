package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t6 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2122a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2123b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2124c;

    public t6(int i, String str, boolean z9) {
        this.f2122a = i;
        this.f2123b = z9;
        this.f2124c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t6)) {
            return false;
        }
        t6 t6Var = (t6) obj;
        return this.f2122a == t6Var.f2122a && this.f2123b == t6Var.f2123b && kotlin.jvm.internal.l.a(this.f2124c, t6Var.f2124c);
    }

    public final int hashCode() {
        int i = ((this.f2122a * 31) + (this.f2123b ? 1231 : 1237)) * 31;
        String str = this.f2124c;
        return i + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PasswordEditData(success=");
        sb.append(this.f2122a);
        sb.append(", error=");
        sb.append(this.f2123b);
        sb.append(", regErrors=");
        return a4.x.n(sb, this.f2124c, ")");
    }
}
