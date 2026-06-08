package p6;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final int f8456a;

    public /* synthetic */ q(int i) {
        this.f8456a = i;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return kotlin.jvm.internal.l.c(this.f8456a ^ Integer.MIN_VALUE, ((q) obj).f8456a ^ Integer.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof q) {
            return this.f8456a == ((q) obj).f8456a;
        }
        return false;
    }

    public final int hashCode() {
        return this.f8456a;
    }

    public final String toString() {
        return String.valueOf(this.f8456a & 4294967295L);
    }
}
