package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r5 {

    /* renamed from: a, reason: collision with root package name */
    public final x4.x2 f2048a;

    public r5(x4.x2 x2Var) {
        this.f2048a = x2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r5) && this.f2048a.equals(((r5) obj).f2048a);
    }

    public final int hashCode() {
        return this.f2048a.hashCode();
    }

    public final String toString() {
        return "UserStatsData(userDataStats=" + this.f2048a + ")";
    }
}
