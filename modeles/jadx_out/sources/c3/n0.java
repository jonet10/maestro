package c3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n0 {
    public static final m0 Companion = new m0();

    /* renamed from: a, reason: collision with root package name */
    public final String f1290a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1291b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1292c;

    /* renamed from: d, reason: collision with root package name */
    public final long f1293d;

    public /* synthetic */ n0(int i, int i6, long j, String str, String str2) {
        if (15 != (i & 15)) {
            d8.o0.e(l0.f1284a.getDescriptor(), i, 15);
            throw null;
        }
        this.f1290a = str;
        this.f1291b = str2;
        this.f1292c = i6;
        this.f1293d = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return kotlin.jvm.internal.l.a(this.f1290a, n0Var.f1290a) && kotlin.jvm.internal.l.a(this.f1291b, n0Var.f1291b) && this.f1292c == n0Var.f1292c && this.f1293d == n0Var.f1293d;
    }

    public final int hashCode() {
        int o10 = (androidx.lifecycle.l.o(this.f1290a.hashCode() * 31, 31, this.f1291b) + this.f1292c) * 31;
        long j = this.f1293d;
        return o10 + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "SessionDetails(sessionId=" + this.f1290a + ", firstSessionId=" + this.f1291b + ", sessionIndex=" + this.f1292c + ", sessionStartTimestampUs=" + this.f1293d + ')';
    }

    public n0(long j, String str, String str2, int i) {
        this.f1290a = str;
        this.f1291b = str2;
        this.f1292c = i;
        this.f1293d = j;
    }
}
