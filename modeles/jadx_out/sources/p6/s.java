package p6;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final long f8458a;

    public /* synthetic */ s(long j) {
        this.f8458a = j;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return kotlin.jvm.internal.l.d(this.f8458a ^ Long.MIN_VALUE, ((s) obj).f8458a ^ Long.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof s) {
            return this.f8458a == ((s) obj).f8458a;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f8458a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        long j = this.f8458a;
        if (j >= 0) {
            d0.b.v(10);
            String l10 = Long.toString(j, 10);
            l10.getClass();
            return l10;
        }
        long j6 = 10;
        long j10 = ((j >>> 1) / j6) << 1;
        long j11 = j - (j10 * j6);
        if (j11 >= j6) {
            j11 -= j6;
            j10++;
        }
        d0.b.v(10);
        String l11 = Long.toString(j10, 10);
        l11.getClass();
        d0.b.v(10);
        String l12 = Long.toString(j11, 10);
        l12.getClass();
        return l11.concat(l12);
    }
}
