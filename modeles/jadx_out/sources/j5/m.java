package j5;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m extends t0.f {

    /* renamed from: c, reason: collision with root package name */
    public final String f6703c;

    public m(String str) {
        this.f6703c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m) && this.f6703c.equals(((m) obj).f6703c);
    }

    public final int hashCode() {
        return this.f6703c.hashCode();
    }

    public final String toString() {
        return androidx.lifecycle.l.w("HashMismatch(calculatedHash=", this.f6703c, ")");
    }
}
