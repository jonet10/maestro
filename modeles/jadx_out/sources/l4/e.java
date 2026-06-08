package l4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends m {

    /* renamed from: a, reason: collision with root package name */
    public final a f7110a;

    public e(a aVar) {
        this.f7110a = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && kotlin.jvm.internal.l.a(this.f7110a, ((e) obj).f7110a);
    }

    public final int hashCode() {
        a aVar = this.f7110a;
        if (aVar == null) {
            return 0;
        }
        return aVar.hashCode();
    }

    public final String toString() {
        return "InstallCanceled(appInstalling=" + this.f7110a + ")";
    }
}
