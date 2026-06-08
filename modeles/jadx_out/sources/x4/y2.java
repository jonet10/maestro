package x4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y2 {

    /* renamed from: a, reason: collision with root package name */
    public final String f11472a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11473b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11474c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11475d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11476e;

    public y2(String str, String str2, long j, String str3, int i) {
        this.f11472a = str;
        this.f11473b = str2;
        this.f11474c = j;
        this.f11475d = str3;
        this.f11476e = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y2)) {
            return false;
        }
        y2 y2Var = (y2) obj;
        return kotlin.jvm.internal.l.a(this.f11472a, y2Var.f11472a) && kotlin.jvm.internal.l.a(this.f11473b, y2Var.f11473b) && this.f11474c == y2Var.f11474c && kotlin.jvm.internal.l.a(this.f11475d, y2Var.f11475d) && this.f11476e == y2Var.f11476e;
    }

    public final int hashCode() {
        String str = this.f11472a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f11473b;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        long j = this.f11474c;
        int i = (((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str3 = this.f11475d;
        return ((i + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f11476e;
    }

    public final String toString() {
        return "UserDeviceApp(name=" + this.f11472a + ", packagename=" + this.f11473b + ", lastUpdate=" + this.f11474c + ", icon=" + this.f11475d + ", appAvailable=" + this.f11476e + ")";
    }
}
