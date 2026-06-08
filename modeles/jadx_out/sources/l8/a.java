package l8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7178a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7179b;

    public a(boolean z9, boolean z10) {
        this.f7178a = z9;
        this.f7179b = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f7178a == aVar.f7178a && this.f7179b == aVar.f7179b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        boolean z9 = this.f7178a;
        int i = z9;
        if (z9 != 0) {
            i = 1;
        }
        int i6 = i * 31;
        boolean z10 = this.f7179b;
        return i6 + (z10 ? 1 : z10 ? 1 : 0);
    }

    public final String toString() {
        return "ActionButtonSettings(action1Enabled=" + this.f7178a + ", action2Enabled=" + this.f7179b + ')';
    }
}
