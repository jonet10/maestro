package v2;

import c.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f10793a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10794b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10795c;

    /* renamed from: d, reason: collision with root package name */
    public final b f10796d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10797e;

    public a(String str, String str2, String str3, b bVar, int i) {
        this.f10793a = str;
        this.f10794b = str2;
        this.f10795c = str3;
        this.f10796d = bVar;
        this.f10797e = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        String str = aVar.f10793a;
        String str2 = this.f10793a;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        String str3 = aVar.f10794b;
        String str4 = this.f10794b;
        if (str4 == null) {
            if (str3 != null) {
                return false;
            }
        } else if (!str4.equals(str3)) {
            return false;
        }
        String str5 = aVar.f10795c;
        String str6 = this.f10795c;
        if (str6 == null) {
            if (str5 != null) {
                return false;
            }
        } else if (!str6.equals(str5)) {
            return false;
        }
        b bVar = aVar.f10796d;
        b bVar2 = this.f10796d;
        if (bVar2 == null) {
            if (bVar != null) {
                return false;
            }
        } else if (!bVar2.equals(bVar)) {
            return false;
        }
        int i = aVar.f10797e;
        int i6 = this.f10797e;
        return i6 == 0 ? i == 0 : j.a(i6, i);
    }

    public final int hashCode() {
        String str = this.f10793a;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f10794b;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f10795c;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        b bVar = this.f10796d;
        int hashCode4 = (hashCode3 ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
        int i = this.f10797e;
        return (i != 0 ? j.c(i) : 0) ^ hashCode4;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallationResponse{uri=");
        sb.append(this.f10793a);
        sb.append(", fid=");
        sb.append(this.f10794b);
        sb.append(", refreshToken=");
        sb.append(this.f10795c);
        sb.append(", authToken=");
        sb.append(this.f10796d);
        sb.append(", responseCode=");
        int i = this.f10797e;
        sb.append(i != 1 ? i != 2 ? "null" : "BAD_CONFIG" : "OK");
        sb.append("}");
        return sb.toString();
    }
}
