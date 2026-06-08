package x4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j1 extends m1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f11243a;

    public j1(String str) {
        this.f11243a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j1) && kotlin.jvm.internal.l.a(this.f11243a, ((j1) obj).f11243a);
    }

    public final int hashCode() {
        String str = this.f11243a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return androidx.lifecycle.l.w("AppUpdated(packageName=", this.f11243a, ")");
    }
}
