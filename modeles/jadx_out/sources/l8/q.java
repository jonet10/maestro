package l8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final String f7254a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7255b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7256c;

    public q(String str, String str2, String str3) {
        this.f7254a = str;
        this.f7255b = str2;
        this.f7256c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return kotlin.jvm.internal.l.a(this.f7254a, qVar.f7254a) && kotlin.jvm.internal.l.a(this.f7255b, qVar.f7255b) && kotlin.jvm.internal.l.a(this.f7256c, qVar.f7256c);
    }

    public final int hashCode() {
        String str = this.f7254a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f7255b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f7256c;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        return "TranslationUrls(common=" + ((Object) this.f7254a) + ", theme=" + ((Object) this.f7255b) + ", all=" + ((Object) this.f7256c) + ')';
    }
}
