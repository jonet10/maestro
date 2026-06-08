package j$.util;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class b0 {

    /* renamed from: b, reason: collision with root package name */
    public static final b0 f5971b = new b0();

    /* renamed from: a, reason: collision with root package name */
    public final Object f5972a;

    public b0() {
        this.f5972a = null;
    }

    public b0(Object obj) {
        this.f5972a = Objects.requireNonNull(obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b0) {
            return Objects.equals(this.f5972a, ((b0) obj).f5972a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f5972a);
    }

    public final String toString() {
        Object obj = this.f5972a;
        return obj != null ? String.format("Optional[%s]", obj) : "Optional.empty";
    }
}
