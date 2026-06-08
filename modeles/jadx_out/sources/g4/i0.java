package g4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i0 implements k4.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5193a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a4.d0 f5194b;

    public /* synthetic */ i0(a4.d0 d0Var, int i) {
        this.f5193a = i;
        this.f5194b = d0Var;
    }

    @Override // k4.b
    public final void a(int i) {
        switch (this.f5193a) {
            case 0:
                ((l4.n) ((ArrayList) this.f5194b.f82l).get(i)).f7121b = !((l4.n) ((ArrayList) r0.f82l).get(i)).f7121b;
                break;
            default:
                ((l4.n) ((ArrayList) this.f5194b.f85o).get(i)).f7121b = !((l4.n) ((ArrayList) r0.f85o).get(i)).f7121b;
                break;
        }
    }
}
