package n5;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final float f8081a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8082b;

    public e(float f, int i) {
        this.f8081a = f;
        this.f8082b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Float.compare(this.f8081a, eVar.f8081a) == 0 && this.f8082b == eVar.f8082b;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f8081a) * 31) + this.f8082b;
    }

    public final String toString() {
        return "ChartData(value=" + this.f8081a + ", color=" + this.f8082b + ")";
    }
}
