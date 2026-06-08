package u4;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.ListsActivity;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.PreregistrationActivity;
import com.uptodown.activities.SearchActivity;
import x4.u2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o1 implements w4.a, w4.e, w4.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z1 f10564a;

    public /* synthetic */ o1(z1 z1Var) {
        this.f10564a = z1Var;
    }

    @Override // w4.e
    public void a(x4.j jVar) {
        jVar.getClass();
        z1 z1Var = this.f10564a;
        FragmentActivity activity = z1Var.getActivity();
        if (activity instanceof AppDetailActivity) {
            FragmentActivity activity2 = z1Var.getActivity();
            activity2.getClass();
            ((AppDetailActivity) activity2).A0(jVar);
            return;
        }
        if (activity instanceof ListsActivity) {
            FragmentActivity activity3 = z1Var.getActivity();
            activity3.getClass();
            ((ListsActivity) activity3).E0(jVar);
            return;
        }
        if (activity instanceof MainActivity) {
            FragmentActivity activity4 = z1Var.getActivity();
            activity4.getClass();
            ((MainActivity) activity4).y1(jVar);
            return;
        }
        if (activity instanceof MoreInfo) {
            FragmentActivity activity5 = z1Var.getActivity();
            activity5.getClass();
            ((MoreInfo) activity5).C0(jVar);
        } else if (activity instanceof PreregistrationActivity) {
            FragmentActivity activity6 = z1Var.getActivity();
            activity6.getClass();
            ((PreregistrationActivity) activity6).z0(jVar);
        } else if (activity instanceof SearchActivity) {
            FragmentActivity activity7 = z1Var.getActivity();
            activity7.getClass();
            ((SearchActivity) activity7).E0(jVar);
        }
    }

    @Override // w4.d
    public void b(x4.g gVar) {
        gVar.getClass();
        float f = UptodownApp.I;
        if (b4.d.t()) {
            z1 z1Var = this.f10564a;
            int i = 2;
            t6.c cVar = null;
            if (z1Var.f10683m.f11224a != 1090) {
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(z1Var);
                v7.e eVar = o7.m0.f8288a;
                o7.c0.s(lifecycleScope, t7.n.f10348a, null, new v1(z1Var, gVar, cVar, i), 2);
            } else if (z1Var.getContext() != null) {
                Context requireContext = z1Var.requireContext();
                requireContext.getClass();
                if (u2.h(requireContext) != null) {
                    LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(z1Var);
                    v7.e eVar2 = o7.m0.f8288a;
                    o7.c0.s(lifecycleScope2, v7.d.f10884a, null, new v1(z1Var, gVar, cVar, 1), 2);
                } else {
                    Intent intent = new Intent(z1Var.requireContext(), (Class<?>) LoginActivity.class);
                    FragmentActivity requireActivity = z1Var.requireActivity();
                    requireActivity.getClass();
                    z1Var.startActivity(intent, b4.d.a(requireActivity));
                }
            }
        }
    }

    @Override // w4.d
    public void d(x4.g gVar, int i) {
        gVar.getClass();
        float f = UptodownApp.I;
        if (b4.d.t()) {
            long j = gVar.f11158a;
            String str = gVar.F;
            z1 z1Var = this.f10564a;
            Context requireContext = z1Var.requireContext();
            requireContext.getClass();
            d0.b.t(j, requireContext, str);
            e4.q0 q0Var = z1Var.f10685o;
            if (q0Var != null) {
                q0Var.notifyItemChanged(i);
            }
        }
    }

    @Override // w4.a
    public void e(x4.g gVar) {
        gVar.getClass();
        z1 z1Var = this.f10564a;
        if ((z1Var.getActivity() instanceof MainActivity) || (z1Var.getActivity() instanceof AppDetailActivity)) {
            FragmentActivity activity = z1Var.getActivity();
            activity.getClass();
            ((c4.k0) activity).t0(gVar, new androidx.work.impl.utils.c(16, z1Var, gVar));
        }
    }

    @Override // w4.a
    public void f(x4.g gVar) {
        gVar.getClass();
    }
}
