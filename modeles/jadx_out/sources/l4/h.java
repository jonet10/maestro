package l4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends m {

    /* renamed from: a, reason: collision with root package name */
    public final a f7115a;

    public h(a aVar) {
        this.f7115a = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && this.f7115a.equals(((h) obj).f7115a);
    }

    public final int hashCode() {
        return this.f7115a.hashCode();
    }

    public final String toString() {
        return "InstallTimeout(appInstalling=" + this.f7115a + ")";
    }
}
