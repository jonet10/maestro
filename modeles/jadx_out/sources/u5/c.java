package u5;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f10708a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10709b;

    public c(String str, String str2) {
        this.f10708a = str;
        this.f10709b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kotlin.jvm.internal.l.a(this.f10708a, cVar.f10708a) && this.f10709b.equals(cVar.f10709b);
    }

    public final int hashCode() {
        String str = this.f10708a;
        return this.f10709b.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public final String toString() {
        return "GPPEncodingResult(gppString=" + ((Object) this.f10708a) + ", tcString=" + ((Object) this.f10709b) + ')';
    }
}
