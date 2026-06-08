package s1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final r f9132a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9133b;

    public h(r rVar, boolean z9) {
        this.f9132a = rVar;
        this.f9133b = z9;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (hVar.f9132a.equals(this.f9132a) && hVar.f9133b == this.f9133b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f9132a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f9133b).hashCode();
    }
}
