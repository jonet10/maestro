package x4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o1 extends p1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f11306a;

    public o1(String str) {
        this.f11306a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof o1) && kotlin.jvm.internal.l.a(this.f11306a, ((o1) obj).f11306a);
    }

    public final int hashCode() {
        String str = this.f11306a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return androidx.lifecycle.l.w("Installing(packageName=", this.f11306a, ")");
    }
}
