package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class wc {

    /* renamed from: a, reason: collision with root package name */
    public final int f2279a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2280b;

    public wc(int i, int i6) {
        this.f2279a = i;
        this.f2280b = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wc)) {
            return false;
        }
        wc wcVar = (wc) obj;
        return this.f2279a == wcVar.f2279a && this.f2280b == wcVar.f2280b;
    }

    public final int hashCode() {
        return (this.f2279a * 31) + this.f2280b;
    }

    public final String toString() {
        return "UserNotifiersData(downloadsCount=" + this.f2279a + ", updatesCount=" + this.f2280b + ")";
    }
}
