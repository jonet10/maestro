package k1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends b {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6941a;

    public c(Object obj) {
        this.f6941a = obj;
    }

    @Override // k1.b
    public final Object a() {
        return this.f6941a;
    }

    @Override // k1.b
    public final boolean b() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f6941a.equals(((c) obj).f6941a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6941a.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f6941a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 13);
        sb.append("Optional.of(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
