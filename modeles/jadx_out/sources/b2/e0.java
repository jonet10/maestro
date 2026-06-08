package b2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e0 extends o1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f775a;

    /* renamed from: b, reason: collision with root package name */
    public final String f776b;

    /* renamed from: c, reason: collision with root package name */
    public final String f777c;

    public e0(String str, String str2, String str3) {
        this.f775a = str;
        this.f776b = str2;
        this.f777c = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o1) {
            e0 e0Var = (e0) ((o1) obj);
            if (this.f775a.equals(e0Var.f775a) && this.f776b.equals(e0Var.f776b) && this.f777c.equals(e0Var.f777c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f775a.hashCode() ^ 1000003) * 1000003) ^ this.f776b.hashCode()) * 1000003) ^ this.f777c.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BuildIdMappingForArch{arch=");
        sb.append(this.f775a);
        sb.append(", libraryName=");
        sb.append(this.f776b);
        sb.append(", buildId=");
        return a4.x.n(sb, this.f777c, "}");
    }
}
