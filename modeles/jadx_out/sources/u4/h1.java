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
public final class h1 implements w4.a, w4.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m1 f10501a;

    public /* synthetic */ h1(m1 m1Var) {
        this.f10501a = m1Var;
    }

    @Override // w4.e
    public void a(x4.j jVar) {
        jVar.getClass();
        float f = UptodownApp.I;
        if (b4.d.t()) {
            int i = jVar.f11224a;
            m1 m1Var = this.f10501a;
            if (i == 523) {
                FragmentActivity activity = m1Var.getActivity();
                activity.getClass();
                ((MainActivity) activity).S0(1);
            } else {
                FragmentActivity activity2 = m1Var.getActivity();
                activity2.getClass();
                ((MainActivity) activity2).x1(jVar);
            }
        }
    }

    @Override // w4.c
    public void d(x4.g gVar) {
        gVar.getClass();
        float f = UptodownApp.I;
        if (b4.d.t()) {
            m1 m1Var = this.f10501a;
            if (m1Var.getActivity() == null || !(m1Var.getActivity() instanceof MainActivity)) {
                return;
            }
            if (!gVar.m()) {
                FragmentActivity activity = m1Var.getActivity();
                activity.getClass();
                ((MainActivity) activity).i0(gVar.f11158a);
            } else {
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(m1Var);
                v7.e eVar = o7.m0.f8288a;
                o7.c0.s(lifecycleScope, t7.n.f10348a, null, new d0(m1Var, gVar, null, 3), 2);
            }
        }
    }

    @Override // w4.a
    public void e(x4.g gVar) {
        gVar.getClass();
        m1 m1Var = this.f10501a;
        if (m1Var.getActivity() instanceof MainActivity) {
            FragmentActivity activity = m1Var.getActivity();
            activity.getClass();
            RelativeLayout relativeLayout = ((MainActivity) activity).f3312j0;
            if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
                FragmentActivity activity2 = m1Var.getActivity();
                activity2.getClass();
                ((c4.k0) activity2).t0(gVar, new androidx.work.impl.utils.c(15, m1Var, gVar));
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
            x4.j jVar = p2Var.f11329a;
            int i = jVar.f11224a;
            m1 m1Var = this.f10501a;
            if (i == -3 || i == -2) {
                FragmentActivity activity = m1Var.getActivity();
                activity.getClass();
                ((MainActivity) activity).y1(p2Var.f11329a);
                return;
            }
            if (i == -1) {
                FragmentActivity activity2 = m1Var.getActivity();
                activity2.getClass();
                ((MainActivity) activity2).y1(p2Var.f11329a);
                return;
            }
            if (i == 523) {
                FragmentActivity activity3 = m1Var.getActivity();
                activity3.getClass();
                ((MainActivity) activity3).S0(1);
            } else if (jVar.f11227m || jVar.f11228n) {
                FragmentActivity activity4 = m1Var.getActivity();
                activity4.getClass();
                ((MainActivity) activity4).y1(p2Var.f11329a);
            } else {
                FragmentActivity activity5 = m1Var.getActivity();
                activity5.getClass();
                ((MainActivity) activity5).S0(2);
                FragmentActivity activity6 = m1Var.getActivity();
                activity6.getClass();
                ((MainActivity) activity6).x1(p2Var.f11329a);
            }
        }
    }
}
