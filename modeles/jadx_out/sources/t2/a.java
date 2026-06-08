package t2;

import a4.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f9536a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9537b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9538c;

    public a(String str, long j, long j6) {
        this.f9536a = str;
        this.f9537b = j;
        this.f9538c = j6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f9536a.equals(aVar.f9536a) && this.f9537b == aVar.f9537b && this.f9538c == aVar.f9538c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f9536a.hashCode() ^ 1000003) * 1000003;
        long j = this.f9537b;
        long j6 = this.f9538c;
        return ((hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallationTokenResult{token=");
        sb.append(this.f9536a);
        sb.append(", tokenExpirationTimestamp=");
        sb.append(this.f9537b);
        sb.append(", tokenCreationTimestamp=");
        return x.l(sb, this.f9538c, "}");
    }
}
