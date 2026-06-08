package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class kc {

    /* renamed from: a, reason: collision with root package name */
    public final int f1802a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1803b;

    /* renamed from: c, reason: collision with root package name */
    public final long f1804c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1805d;

    public kc(long j, String str, String str2, int i) {
        this.f1802a = i;
        this.f1803b = str;
        this.f1804c = j;
        this.f1805d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kc)) {
            return false;
        }
        kc kcVar = (kc) obj;
        return this.f1802a == kcVar.f1802a && kotlin.jvm.internal.l.a(this.f1803b, kcVar.f1803b) && this.f1804c == kcVar.f1804c && this.f1805d.equals(kcVar.f1805d);
    }

    public final int hashCode() {
        int i = this.f1802a * 31;
        String str = this.f1803b;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f1804c;
        return this.f1805d.hashCode() + ((((i + hashCode) * 31) + ((int) (j ^ (j >>> 32)))) * 31);
    }

    public final String toString() {
        return "UserDeviceRenameActionData(success=" + this.f1802a + ", msg=" + this.f1803b + ", deviceID=" + this.f1804c + ", newName=" + this.f1805d + ")";
    }
}
