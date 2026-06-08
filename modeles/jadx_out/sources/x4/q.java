package x4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final long f11334a;

    /* renamed from: b, reason: collision with root package name */
    public final long f11335b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11336c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11337d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f11338e;
    public final int f;

    public q(long j, long j6, int i, boolean z9, boolean z10, int i6) {
        this.f11334a = j;
        this.f11335b = j6;
        this.f11336c = i;
        this.f11337d = z9;
        this.f11338e = z10;
        this.f = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f11334a == qVar.f11334a && this.f11335b == qVar.f11335b && this.f11336c == qVar.f11336c && this.f11337d == qVar.f11337d && this.f11338e == qVar.f11338e && this.f == qVar.f;
    }

    public final int hashCode() {
        long j = this.f11334a;
        long j6 = this.f11335b;
        return (((((((((((int) (j ^ (j >>> 32))) * 31) + ((int) ((j6 >>> 32) ^ j6))) * 31) + this.f11336c) * 31) + (this.f11337d ? 1231 : 1237)) * 31) + (this.f11338e ? 1231 : 1237)) * 31) + this.f;
    }

    public final String toString() {
        return "DeviceStatus(id=" + this.f11334a + ", timestamp=" + this.f11335b + ", batteryLevel=" + this.f11336c + ", isCharging=" + this.f11337d + ", isWifiConnected=" + this.f11338e + ", uploadSpeedKbps=" + this.f + ")";
    }
}
