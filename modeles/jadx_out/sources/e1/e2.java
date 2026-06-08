package e1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class e2 extends d2 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f3903b;

    public e2(t1 t1Var) {
        super(t1Var);
        this.f3875a.J++;
    }

    public abstract boolean h();

    public final void i() {
        if (this.f3903b) {
            return;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Not initialized");
    }

    public final void j() {
        if (this.f3903b) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Can't initialize twice");
        } else {
            if (h()) {
                return;
            }
            this.f3875a.L.incrementAndGet();
            this.f3903b = true;
        }
    }
}
