package u4;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import c4.w6;
import java.util.ArrayList;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends Fragment {

    /* renamed from: b, reason: collision with root package name */
    public x4.c f10447b;

    /* renamed from: l, reason: collision with root package name */
    public e4.q0 f10448l;

    /* renamed from: a, reason: collision with root package name */
    public final p6.m f10446a = new p6.m(new w6(this, 23));

    /* renamed from: m, reason: collision with root package name */
    public final c f10449m = new c(this);

    /* renamed from: n, reason: collision with root package name */
    public final g5.g f10450n = new g5.g(this, 13);

    public final void a(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(lifecycleScope, t7.n.f10348a, null, new s4.e0(str, this, null, 1), 2);
    }

    public final t4.x0 b() {
        return (t4.x0) this.f10446a.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x4.c cVar = this.f10447b;
        if (cVar == null) {
            kotlin.jvm.internal.l.i("alternatives");
            throw null;
        }
        if (getActivity() == null || requireActivity().isFinishing()) {
            return;
        }
        p2 p2Var = new p2(null, null, 7);
        ArrayList arrayList = cVar.f11073c;
        arrayList.getClass();
        p2Var.f11330b = arrayList;
        String str = cVar.f11071a;
        String str2 = cVar.f11072b;
        p2Var.f11329a = new x4.j(-4, str, str2);
        e4.q0 q0Var = new e4.q0(this.f10449m, this.f10450n, new c(this), null, str2, null, null, str, true, null, null);
        this.f10448l = q0Var;
        q0Var.a(p2Var);
        b().f10232n.setAdapter(this.f10448l);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        int i = 0;
        b().f10233o.setVisibility(0);
        Drawable drawable = ContextCompat.getDrawable(requireContext(), 2131230922);
        if (drawable != null) {
            b().f10233o.setNavigationIcon(drawable);
            b().f10233o.setNavigationContentDescription(getString(2131951735));
        }
        b().f10233o.setNavigationOnClickListener(new a(this, i));
        b().f10234p.setTypeface(f4.c.f4883x);
        b().f10234p.setVisibility(8);
        b().f10232n.setItemAnimator(null);
        b().f10232n.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        if (b().f10232n.getItemDecorationCount() == 0) {
            b().f10232n.addItemDecoration(new l5.k());
        }
        b().f10232n.setPadding(0, 0, 0, 0);
        RelativeLayout relativeLayout = b().f10228a;
        relativeLayout.getClass();
        return relativeLayout;
    }
}
