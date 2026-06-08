package u4;

import androidx.fragment.app.FragmentActivity;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.views.FullWidthImageView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x implements w4.f, a4.i, w4.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10655a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f10656b;

    public /* synthetic */ x(f0 f0Var, int i) {
        this.f10655a = i;
        this.f10656b = f0Var;
    }

    @Override // w4.f
    public void b(long j) {
        f0 f0Var = this.f10656b;
        if (f0Var.getActivity() != null) {
            FragmentActivity activity = f0Var.getActivity();
            activity.getClass();
            if (((c4.k0) activity).T()) {
                if (f0Var.getActivity() instanceof MainActivity) {
                    FragmentActivity activity2 = f0Var.getActivity();
                    activity2.getClass();
                    ((MainActivity) activity2).i0(j);
                } else if (f0Var.getActivity() instanceof AppDetailActivity) {
                    FragmentActivity activity3 = f0Var.getActivity();
                    activity3.getClass();
                    ((AppDetailActivity) activity3).i0(j);
                }
            }
        }
    }

    @Override // w4.f
    public void c(x4.j jVar) {
        this.f10656b.Q(jVar);
    }

    @Override // w4.a
    public void e(x4.g gVar) {
        int i = this.f10655a;
        gVar.getClass();
        switch (i) {
            case 2:
                f0.l(this.f10656b, gVar);
                break;
            case 3:
                f0.l(this.f10656b, gVar);
                break;
            default:
                f0.l(this.f10656b, gVar);
                break;
        }
    }

    @Override // w4.a
    public void f(x4.g gVar) {
        switch (this.f10655a) {
            case 2:
                gVar.getClass();
                break;
            case 3:
                gVar.getClass();
                break;
            default:
                gVar.getClass();
                break;
        }
    }

    @Override // a4.i
    public void h(Exception exc) {
        exc.getClass();
    }

    @Override // a4.i
    public void onSuccess() {
        f0 f0Var = this.f10656b;
        t4.b bVar = f0Var.f10473b;
        bVar.getClass();
        ((FullWidthImageView) bVar.R.f7781l).setVisibility(0);
        if (!((Boolean) f0Var.G().P.getValue()).booleanValue()) {
            t4.b bVar2 = f0Var.f10473b;
            bVar2.getClass();
            bVar2.f9613m.setTitle(f0Var.B().f11159b);
            t4.b bVar3 = f0Var.f10473b;
            bVar3.getClass();
            bVar3.f9600b.setExpanded(false, false);
        }
        String e10 = f0Var.B().e();
        if (e10 == null || e10.length() == 0) {
            return;
        }
        f0Var.A();
        FragmentActivity activity = f0Var.getActivity();
        if (activity != null) {
            f0Var.t0(activity);
        }
    }
}
