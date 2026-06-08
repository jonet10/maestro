package u4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10510a;

    public j0(boolean z9) {
        this.f10510a = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j0) && this.f10510a == ((j0) obj).f10510a;
    }

    public final int hashCode() {
        return 38161 + (this.f10510a ? 1231 : 1237);
    }

    public final String toString() {
        return "PreRegisterActionData(succeed=true, isAddPreRegisterAction=" + this.f10510a + ")";
    }
}
