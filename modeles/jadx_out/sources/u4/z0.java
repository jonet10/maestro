package u4;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class z0<VB extends ViewBinding> extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public x4.j f10669a;

    /* renamed from: b, reason: collision with root package name */
    public e4.h f10670b;

    /* renamed from: n, reason: collision with root package name */
    public p2 f10673n;

    /* renamed from: o, reason: collision with root package name */
    public p2 f10674o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10675p;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f10671l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f10672m = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public final x0 f10676q = new x0(this);

    /* renamed from: r, reason: collision with root package name */
    public final x0 f10677r = new x0(this);

    /* renamed from: s, reason: collision with root package name */
    public final y0 f10678s = new y0(this);

    /* renamed from: t, reason: collision with root package name */
    public final y0 f10679t = new y0(this);

    public abstract ViewBinding a();

    public abstract String b();

    public final void c() {
        if (this.f10675p) {
            d().setVisibility(8);
            return;
        }
        this.f10675p = true;
        Context requireContext = requireContext();
        requireContext.getClass();
        x4.j jVar = this.f10669a;
        jVar.getClass();
        y2.s sVar = new y2.s(requireContext, this.f10679t, jVar);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        lifecycleScope.getClass();
        o7.c0.s(lifecycleScope, null, null, new p9.c(sVar, (t6.c) null, 4), 3);
    }

    public abstract View d();

    public abstract TextView g();

    public abstract RecyclerView h();

    public abstract TextView i();

    public abstract void j(x4.j jVar);

    public abstract void k(p2 p2Var);

    public abstract void l(String str);

    public final void m(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(lifecycleScope, t7.n.f10348a, null, new s4.e0(str, this, null, 5), 2);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            x4.j jVar = new x4.j(0, (String) null, 7);
            this.f10669a = jVar;
            jVar.c(arguments);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        g().setTypeface(f4.c.f4883x);
        i().setTypeface(f4.c.f4882w);
        i().setOnClickListener(new m5.u0(this, 8));
        h().setItemAnimator(null);
        h().setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        h().addItemDecoration(new l5.h((int) getResources().getDimension(2131166251)));
        d().setVisibility(0);
        View root = a().getRoot();
        root.getClass();
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        float f = UptodownApp.I;
        v3.e eVar = UptodownApp.a0;
        if (eVar != null) {
            ((z3.g) eVar).e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        v3.e eVar;
        super.onResume();
        float f = UptodownApp.I;
        v3.e eVar2 = UptodownApp.Z;
        if (eVar2 != null) {
            ((z3.g) eVar2).e();
        }
        if (getContext() != null) {
            Context requireContext = requireContext();
            requireContext.getClass();
            if (b4.d.e(requireContext) && (eVar = UptodownApp.a0) != null) {
                ((z3.g) eVar).f();
            }
        }
        c();
    }
}
