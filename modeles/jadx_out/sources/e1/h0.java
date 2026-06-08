package e1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class h0 extends b0 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f4014b;

    public h0(t1 t1Var) {
        super(t1Var);
        this.f3875a.J++;
    }

    public final void h() {
        if (this.f4014b) {
            return;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Not initialized");
    }

    public final void i() {
        if (this.f4014b) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Can't initialize twice");
        } else {
            if (j()) {
                return;
            }
            this.f3875a.L.incrementAndGet();
            this.f4014b = true;
        }
    }

    public abstract boolean j();
}
