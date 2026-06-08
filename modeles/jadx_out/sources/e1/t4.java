package e1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t4 {

    /* renamed from: a, reason: collision with root package name */
    public final u4 f4286a;

    /* renamed from: b, reason: collision with root package name */
    public int f4287b = 1;

    /* renamed from: c, reason: collision with root package name */
    public long f4288c = a();

    public t4(u4 u4Var) {
        this.f4286a = u4Var;
    }

    public final long a() {
        u4 u4Var = this.f4286a;
        k0.y.g(u4Var);
        long longValue = ((Long) f0.v.a(null)).longValue();
        long longValue2 = ((Long) f0.f3959w.a(null)).longValue();
        for (int i = 1; i < this.f4287b; i++) {
            longValue += longValue;
            if (longValue >= longValue2) {
                break;
            }
        }
        u4Var.f().getClass();
        return Math.min(longValue, longValue2) + System.currentTimeMillis();
    }
}
