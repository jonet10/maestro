package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class gd {

    /* renamed from: a, reason: collision with root package name */
    public final int f1652a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1653b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1654c;

    public gd(int i, String str, boolean z9) {
        this.f1652a = i;
        this.f1653b = z9;
        this.f1654c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gd)) {
            return false;
        }
        gd gdVar = (gd) obj;
        return this.f1652a == gdVar.f1652a && this.f1653b == gdVar.f1653b && kotlin.jvm.internal.l.a(this.f1654c, gdVar.f1654c);
    }

    public final int hashCode() {
        int i = ((this.f1652a * 31) + (this.f1653b ? 1231 : 1237)) * 31;
        String str = this.f1654c;
        return i + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UsernameEditData(success=");
        sb.append(this.f1652a);
        sb.append(", error=");
        sb.append(this.f1653b);
        sb.append(", regErrors=");
        return a4.x.n(sb, this.f1654c, ")");
    }
}
