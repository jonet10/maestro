package j$.util;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class e0 {

    /* renamed from: c, reason: collision with root package name */
    public static final e0 f6039c = new e0();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6040a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6041b;

    public e0() {
        this.f6040a = false;
        this.f6041b = 0L;
    }

    public e0(long j) {
        this.f6040a = true;
        this.f6041b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        boolean z9 = e0Var.f6040a;
        boolean z10 = this.f6040a;
        return (z10 && z9) ? this.f6041b == e0Var.f6041b : z10 == z9;
    }

    public final int hashCode() {
        if (!this.f6040a) {
            return 0;
        }
        long j = this.f6041b;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        if (this.f6040a) {
            return "OptionalLong[" + this.f6041b + "]";
        }
        return "OptionalLong.empty";
    }
}
