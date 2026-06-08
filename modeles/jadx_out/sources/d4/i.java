package d4;

import a4.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f3571a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3572b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3573c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3574d;

    /* renamed from: e, reason: collision with root package name */
    public final long f3575e;
    public final long f;
    public final long g;
    public final long h;
    public final int i;

    public i(String str, boolean z9, String str2, String str3, long j, long j6, long j10, long j11, int i) {
        this.f3571a = str;
        this.f3572b = z9;
        this.f3573c = str2;
        this.f3574d = str3;
        this.f3575e = j;
        this.f = j6;
        this.g = j10;
        this.h = j11;
        this.i = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f3571a.equals(iVar.f3571a) && this.f3572b == iVar.f3572b && this.f3573c.equals(iVar.f3573c) && this.f3574d.equals(iVar.f3574d) && this.f3575e == iVar.f3575e && this.f == iVar.f && this.g == iVar.g && this.h == iVar.h && this.i == iVar.i;
    }

    public final int hashCode() {
        int o10 = androidx.lifecycle.l.o(androidx.lifecycle.l.o(((this.f3571a.hashCode() * 31) + (this.f3572b ? 1231 : 1237)) * 31, 31, this.f3573c), 31, this.f3574d);
        long j = this.f3575e;
        int i = (o10 + ((int) (j ^ (j >>> 32)))) * 31;
        long j6 = this.f;
        int i6 = (i + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j10 = this.g;
        int i10 = (i6 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.h;
        return ((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ConnectionData(updates=");
        sb.append(this.f3571a);
        sb.append(", autoplayVideos=");
        sb.append(this.f3572b);
        sb.append(", imageQuality=");
        x.B(sb, this.f3573c, ", sync=", this.f3574d, ", imagesUsage=");
        sb.append(this.f3575e);
        sb.append(", metadataUsage=");
        sb.append(this.f);
        sb.append(", downloadsUsage=");
        sb.append(this.g);
        sb.append(", updatesUsage=");
        sb.append(this.h);
        sb.append(", billingCycleDay=");
        return androidx.lifecycle.l.x(sb, ")", this.i);
    }
}
