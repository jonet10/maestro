package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class jc {

    /* renamed from: a, reason: collision with root package name */
    public final x4.z2 f1773a;

    public jc(x4.z2 z2Var) {
        this.f1773a = z2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof jc) && this.f1773a.equals(((jc) obj).f1773a);
    }

    public final int hashCode() {
        return this.f1773a.hashCode();
    }

    public final String toString() {
        return "UserDeviceData(userDevice=" + this.f1773a + ")";
    }
}
