package j$.util;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class d0 {

    /* renamed from: c, reason: collision with root package name */
    public static final d0 f6032c = new d0();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6033a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6034b;

    public d0() {
        this.f6033a = false;
        this.f6034b = 0;
    }

    public d0(int i) {
        this.f6033a = true;
        this.f6034b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        boolean z9 = d0Var.f6033a;
        boolean z10 = this.f6033a;
        return (z10 && z9) ? this.f6034b == d0Var.f6034b : z10 == z9;
    }

    public final int hashCode() {
        if (this.f6033a) {
            return this.f6034b;
        }
        return 0;
    }

    public final String toString() {
        if (this.f6033a) {
            return "OptionalInt[" + this.f6034b + "]";
        }
        return "OptionalInt.empty";
    }
}
