package e1;

import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4090a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m3 f4091b;

    public l3(m3 m3Var, int i) {
        this.f4090a = i;
        switch (i) {
            case 1:
                Objects.requireNonNull(m3Var);
                this.f4091b = m3Var;
                break;
            default:
                Objects.requireNonNull(m3Var);
                this.f4091b = m3Var;
                break;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4090a) {
            case 0:
                m3 m3Var = this.f4091b;
                m3Var.f4122n = m3Var.f4127s;
                break;
            default:
                this.f4091b.f4127s = null;
                break;
        }
    }
}
