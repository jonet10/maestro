package s4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final long f9176a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9177b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9178c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9179d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f9180e;

    public c(long j, long j6, String str, long j10, boolean z9) {
        this.f9176a = j;
        this.f9177b = j6;
        this.f9178c = str;
        this.f9179d = j10;
        this.f9180e = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f9176a == cVar.f9176a && this.f9177b == cVar.f9177b && kotlin.jvm.internal.l.a(this.f9178c, cVar.f9178c) && this.f9179d == cVar.f9179d && this.f9180e == cVar.f9180e;
    }

    public final int hashCode() {
        long j = this.f9176a;
        long j6 = this.f9177b;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        String str = this.f9178c;
        int hashCode = str == null ? 0 : str.hashCode();
        long j10 = this.f9179d;
        return ((((i + hashCode) * 31) + ((int) ((j10 >>> 32) ^ j10))) * 31) + (this.f9180e ? 1231 : 1237);
    }

    public final String toString() {
        return "UrlDownloadAppInfo(appID=" + this.f9176a + ", fileID=" + this.f9177b + ", sha256=" + this.f9178c + ", versionCode=" + this.f9179d + ", isDeepLink=" + this.f9180e + ")";
    }
}
