package u4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f10515a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10516b;

    public k0(String str, boolean z9) {
        this.f10515a = str;
        this.f10516b = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return kotlin.jvm.internal.l.a(this.f10515a, k0Var.f10515a) && this.f10516b == k0Var.f10516b;
    }

    public final int hashCode() {
        String str = this.f10515a;
        return ((str == null ? 0 : str.hashCode()) * 31) + (this.f10516b ? 1231 : 1237);
    }

    public final String toString() {
        return "PreRegisterStatusData(buttonText=" + this.f10515a + ", isPreRegister=" + this.f10516b + ")";
    }
}
