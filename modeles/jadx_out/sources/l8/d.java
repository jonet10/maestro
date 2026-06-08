package l8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f7183a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f7184b;

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f7185c;

    /* renamed from: d, reason: collision with root package name */
    public final Boolean f7186d;

    public d(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        this.f7183a = bool;
        this.f7184b = bool2;
        this.f7185c = bool3;
        this.f7186d = bool4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f7183a.equals(dVar.f7183a) && this.f7184b.equals(dVar.f7184b) && this.f7185c.equals(dVar.f7185c) && this.f7186d.equals(dVar.f7186d);
    }

    public final int hashCode() {
        return this.f7186d.hashCode() + ((this.f7185c.hashCode() + ((this.f7184b.hashCode() + (this.f7183a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Features(visitEvents=" + this.f7183a + ", advancedCustomizations=" + this.f7184b + ", consentOrPay=" + this.f7185c + ", themeCustomizations=" + this.f7186d + ')';
    }
}
