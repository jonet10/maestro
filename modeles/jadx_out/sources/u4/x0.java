package u4;

import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x0 implements w4.a, w4.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z0 f10657a;

    public /* synthetic */ x0(z0 z0Var) {
        this.f10657a = z0Var;
    }

    @Override // w4.e
    public void a(x4.j jVar) {
        jVar.getClass();
        float f = UptodownApp.I;
        if (b4.d.t()) {
            this.f10657a.j(jVar);
        }
    }

    @Override // w4.c
    public void d(x4.g gVar) {
        gVar.getClass();
        float f = UptodownApp.I;
        if (b4.d.t()) {
            z0 z0Var = this.f10657a;
            FragmentActivity activity = z0Var.getActivity();
            activity.getClass();
            if (((c4.k0) activity).T() && z0Var.getActivity() != null && (z0Var.getActivity() instanceof MainActivity)) {
                if (gVar.m()) {
                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(z0Var);
                    v7.e eVar = o7.m0.f8288a;
                    o7.c0.s(lifecycleScope, t7.n.f10348a, null, new d0(z0Var, gVar, null, 2), 2);
                } else {
                    FragmentActivity activity2 = z0Var.getActivity();
                    activity2.getClass();
                    ((MainActivity) activity2).i0(gVar.f11158a);
                }
            }
        }
    }

    @Override // w4.a
    public void e(x4.g gVar) {
        gVar.getClass();
        z0 z0Var = this.f10657a;
        if (z0Var.getActivity() instanceof MainActivity) {
            FragmentActivity activity = z0Var.getActivity();
            activity.getClass();
            RelativeLayout relativeLayout = ((MainActivity) activity).f3312j0;
            if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
                FragmentActivity activity2 = z0Var.getActivity();
                activity2.getClass();
                ((c4.k0) activity2).t0(gVar, new androidx.work.impl.utils.c(14, z0Var, gVar));
            }
        }
    }

    @Override // w4.a
    public void f(x4.g gVar) {
        gVar.getClass();
    }

    @Override // w4.j
    public void h(p2 p2Var) {
        p2Var.getClass();
        float f = UptodownApp.I;
        if (b4.d.t()) {
            z0 z0Var = this.f10657a;
            FragmentActivity activity = z0Var.getActivity();
            activity.getClass();
            if (((c4.k0) activity).T()) {
                if (kotlin.jvm.internal.l.a(p2Var.f11329a.f11225b, z0Var.getString(2131952657))) {
                    p2Var.f11329a.f11225b = z0Var.b();
                }
                z0Var.k(p2Var);
            }
        }
    }
}
