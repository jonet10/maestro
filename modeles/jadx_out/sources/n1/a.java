package n1;

import a4.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f7896a;

    /* renamed from: b, reason: collision with root package name */
    public final long f7897b;

    /* renamed from: c, reason: collision with root package name */
    public final long f7898c;

    public a(long j, long j6, long j10) {
        this.f7896a = j;
        this.f7897b = j6;
        this.f7898c = j10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f7896a == aVar.f7896a && this.f7897b == aVar.f7897b && this.f7898c == aVar.f7898c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f7896a;
        long j6 = this.f7897b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003;
        long j10 = this.f7898c;
        return i ^ ((int) ((j10 >>> 32) ^ j10));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("StartupTime{epochMillis=");
        sb.append(this.f7896a);
        sb.append(", elapsedRealtime=");
        sb.append(this.f7897b);
        sb.append(", uptimeMillis=");
        return x.l(sb, this.f7898c, "}");
    }
}
