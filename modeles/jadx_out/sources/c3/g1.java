package c3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g1 {
    public static final f1 Companion = new f1();

    /* renamed from: a, reason: collision with root package name */
    public final long f1247a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1248b;

    /* renamed from: c, reason: collision with root package name */
    public final long f1249c;

    public /* synthetic */ g1(int i, long j, long j6, long j10) {
        if (1 != (i & 1)) {
            d8.o0.e(e1.f1236a.getDescriptor(), i, 1);
            throw null;
        }
        this.f1247a = j;
        this.f1248b = (i & 2) == 0 ? 1000 * j : j6;
        if ((i & 4) == 0) {
            this.f1249c = j / 1000;
        } else {
            this.f1249c = j10;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g1) && this.f1247a == ((g1) obj).f1247a;
    }

    public final int hashCode() {
        long j = this.f1247a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "Time(ms=" + this.f1247a + ')';
    }

    public g1(long j) {
        this.f1247a = j;
        long j6 = 1000;
        this.f1248b = j * j6;
        this.f1249c = j / j6;
    }
}
