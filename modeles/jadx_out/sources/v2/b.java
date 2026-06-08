package v2;

import c.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f10798a;

    /* renamed from: b, reason: collision with root package name */
    public final long f10799b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10800c;

    public b(String str, int i, long j) {
        this.f10798a = str;
        this.f10799b = j;
        this.f10800c = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        String str = bVar.f10798a;
        String str2 = this.f10798a;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (this.f10799b != bVar.f10799b) {
            return false;
        }
        int i = bVar.f10800c;
        int i6 = this.f10800c;
        return i6 == 0 ? i == 0 : j.a(i6, i);
    }

    public final int hashCode() {
        String str = this.f10798a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f10799b;
        int i = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        int i6 = this.f10800c;
        return (i6 != 0 ? j.c(i6) : 0) ^ i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TokenResult{token=");
        sb.append(this.f10798a);
        sb.append(", tokenExpirationTimestamp=");
        sb.append(this.f10799b);
        sb.append(", responseCode=");
        int i = this.f10800c;
        sb.append(i != 1 ? i != 2 ? i != 3 ? "null" : "AUTH_ERROR" : "BAD_CONFIG" : "OK");
        sb.append("}");
        return sb.toString();
    }
}
