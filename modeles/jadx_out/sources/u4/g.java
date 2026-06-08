package u4;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class g implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10492a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f10493b;

    public /* synthetic */ g(f0 f0Var, int i) {
        this.f10492a = i;
        this.f10493b = f0Var;
    }

    @Override // d7.a
    public final Object invoke() {
        switch (this.f10492a) {
            case 0:
                this.f10493b.y();
                break;
            case 1:
                f0 f0Var = this.f10493b;
                FragmentActivity requireActivity = f0Var.requireActivity();
                requireActivity.getClass();
                f0Var.p(requireActivity);
                Context requireContext = f0Var.requireContext();
                requireContext.getClass();
                f0Var.p0(requireContext);
                break;
            case 2:
                this.f10493b.y();
                break;
            default:
                f0 f0Var2 = this.f10493b;
                FragmentActivity requireActivity2 = f0Var2.requireActivity();
                requireActivity2.getClass();
                f0Var2.p(requireActivity2);
                Context requireContext2 = f0Var2.requireContext();
                requireContext2.getClass();
                f0Var2.p0(requireContext2);
                break;
        }
        return p6.x.f8463a;
    }
}
