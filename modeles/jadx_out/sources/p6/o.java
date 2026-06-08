package p6;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final byte f8454a;

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return kotlin.jvm.internal.l.c(this.f8454a & 255, ((o) obj).f8454a & 255);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o) {
            return this.f8454a == ((o) obj).f8454a;
        }
        return false;
    }

    public final int hashCode() {
        return this.f8454a;
    }

    public final String toString() {
        return String.valueOf(this.f8454a & 255);
    }
}
