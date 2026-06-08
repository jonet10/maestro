package y1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f11607a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11608b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11609c;

    public c(String str, String str2, String str3) {
        if (str == null) {
            com.google.gson.internal.a.i("Null crashlyticsInstallId");
            throw null;
        }
        this.f11607a = str;
        this.f11608b = str2;
        this.f11609c = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f11607a.equals(cVar.f11607a)) {
                String str = cVar.f11608b;
                String str2 = this.f11608b;
                if (str2 != null ? str2.equals(str) : str == null) {
                    String str3 = cVar.f11609c;
                    String str4 = this.f11609c;
                    if (str4 != null ? str4.equals(str3) : str3 == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f11607a.hashCode() ^ 1000003) * 1000003;
        String str = this.f11608b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f11609c;
        return hashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallIds{crashlyticsInstallId=");
        sb.append(this.f11607a);
        sb.append(", firebaseInstallationId=");
        sb.append(this.f11608b);
        sb.append(", firebaseAuthenticationToken=");
        return a4.x.n(sb, this.f11609c, "}");
    }
}
