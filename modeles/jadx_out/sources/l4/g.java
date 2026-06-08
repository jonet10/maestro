package l4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends m {

    /* renamed from: a, reason: collision with root package name */
    public final a f7114a;

    public g(a aVar) {
        this.f7114a = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && kotlin.jvm.internal.l.a(this.f7114a, ((g) obj).f7114a);
    }

    public final int hashCode() {
        a aVar = this.f7114a;
        if (aVar == null) {
            return 0;
        }
        return aVar.hashCode();
    }

    public final String toString() {
        return "InstallSuccess(appInstalling=" + this.f7114a + ")";
    }
}
