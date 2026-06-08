package e1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class p4 extends l4 {

    /* renamed from: l, reason: collision with root package name */
    public boolean f4192l;

    public p4(u4 u4Var) {
        super(u4Var);
        this.f4092b.A++;
    }

    public final void h() {
        if (this.f4192l) {
            return;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Not initialized");
    }

    public final void i() {
        if (this.f4192l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Can't initialize twice");
            return;
        }
        j();
        this.f4092b.B++;
        this.f4192l = true;
    }

    public abstract void j();
}
