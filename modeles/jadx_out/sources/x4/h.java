package x4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f11207a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11208b;

    public h(String str, String str2) {
        this.f11207a = str;
        this.f11208b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f11207a.equals(hVar.f11207a) && this.f11208b.equals(hVar.f11208b);
    }

    public final int hashCode() {
        return this.f11208b.hashCode() + (this.f11207a.hashCode() * 31);
    }

    public final String toString() {
        return "{packagename='" + this.f11207a + "', installerPackagename='" + this.f11208b + "'}";
    }
}
