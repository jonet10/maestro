package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class lc {

    /* renamed from: a, reason: collision with root package name */
    public final int f1840a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1841b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1842c;

    public lc(int i, String str, String str2) {
        this.f1840a = i;
        this.f1841b = str;
        this.f1842c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lc)) {
            return false;
        }
        lc lcVar = (lc) obj;
        return this.f1840a == lcVar.f1840a && kotlin.jvm.internal.l.a(this.f1841b, lcVar.f1841b) && kotlin.jvm.internal.l.a(this.f1842c, lcVar.f1842c);
    }

    public final int hashCode() {
        int i = this.f1840a * 31;
        String str = this.f1841b;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f1842c;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserDeviceUnlinkActionData(success=");
        sb.append(this.f1840a);
        sb.append(", msg=");
        sb.append(this.f1841b);
        sb.append(", identifier=");
        return a4.x.n(sb, this.f1842c, ")");
    }
}
