package j$.util;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class c0 {

    /* renamed from: c, reason: collision with root package name */
    public static final c0 f5975c = new c0();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5976a;

    /* renamed from: b, reason: collision with root package name */
    public final double f5977b;

    public c0() {
        this.f5976a = false;
        this.f5977b = Double.NaN;
    }

    public c0(double d10) {
        this.f5976a = true;
        this.f5977b = d10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        boolean z9 = c0Var.f5976a;
        boolean z10 = this.f5976a;
        return (z10 && z9) ? Double.compare(this.f5977b, c0Var.f5977b) == 0 : z10 == z9;
    }

    public final int hashCode() {
        if (!this.f5976a) {
            return 0;
        }
        long doubleToLongBits = Double.doubleToLongBits(this.f5977b);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public final String toString() {
        if (this.f5976a) {
            return "OptionalDouble[" + this.f5977b + "]";
        }
        return "OptionalDouble.empty";
    }
}
