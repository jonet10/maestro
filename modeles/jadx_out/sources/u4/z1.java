package u4;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import c4.w6;
import com.uptodown.UptodownApp;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.MainActivity;
import java.util.Iterator;
import x4.u2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z1 extends Fragment {

    /* renamed from: n, reason: collision with root package name */
    public String f10684n;

    /* renamed from: o, reason: collision with root package name */
    public e4.q0 f10685o;

    /* renamed from: t, reason: collision with root package name */
    public final ActivityResultLauncher f10690t;

    /* renamed from: a, reason: collision with root package name */
    public final p6.m f10680a = new p6.m(new w6(this, 28));

    /* renamed from: b, reason: collision with root package name */
    public final p6.f f10681b = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.y.a(d2.class), new o9.a(new y1(this, 0), 6), null);

    /* renamed from: l, reason: collision with root package name */
    public final p6.f f10682l = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.y.a(a1.class), new o9.a(new y1(this, 1), 7), null);

    /* renamed from: m, reason: collision with root package name */
    public x4.j f10683m = new x4.j(0, (String) null, 7);

    /* renamed from: p, reason: collision with root package name */
    public final p1 f10686p = new p1(this);

    /* renamed from: q, reason: collision with root package name */
    public final p1 f10687q = new p1(this);

    /* renamed from: r, reason: collision with root package name */
    public final o1 f10688r = new o1(this);

    /* renamed from: s, reason: collision with root package name */
    public final o1 f10689s = new o1(this);

    public z1() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new androidx.core.view.inputmethod.a(this, 28));
        registerForActivityResult.getClass();
        this.f10690t = registerForActivityResult;
    }

    public final t4.x0 a() {
        return (t4.x0) this.f10680a.getValue();
    }

    public final void b() {
        if (getContext() != null) {
            d2 d10 = d();
            Context requireContext = requireContext();
            requireContext.getClass();
            x4.j jVar = this.f10683m;
            d10.getClass();
            jVar.getClass();
            o7.a0 viewModelScope = ViewModelKt.getViewModelScope(d10);
            v7.e eVar = o7.m0.f8288a;
            o7.c0.s(viewModelScope, v7.d.f10884a, null, new c2(d10, requireContext, jVar, null, 0), 2);
        }
    }

    public final int c(String str) {
        e4.q0 q0Var;
        int i = -1;
        if (str != null && str.length() != 0 && (q0Var = this.f10685o) != null) {
            q0Var.getClass();
            Iterator it = q0Var.f4666l.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                int i10 = i6 + 1;
                Object obj = ((e4.o0) it.next()).f4648a;
                if (obj instanceof x4.g) {
                    obj.getClass();
                    String str2 = ((x4.g) obj).F;
                    if (str2 != null && kotlin.jvm.internal.l.a(str2, str)) {
                        i = i6;
                    }
                }
                i6 = i10;
            }
        }
        return i;
    }

    public final d2 d() {
        return (d2) this.f10681b.getValue();
    }

    public final void g(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(lifecycleScope, t7.n.f10348a, null, new s4.e0(this, str, null, 8), 2);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            x4.j jVar = (x4.j) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) bundle.getParcelable("category", x4.j.class) : bundle.getParcelable("category"));
            if (jVar != null) {
                this.f10683m = jVar;
            }
        }
        x4.j jVar2 = this.f10683m;
        if (jVar2.f11224a == 0) {
            jVar2.f11224a = -1;
        }
        a().f10233o.setNavigationIcon(ContextCompat.getDrawable(requireContext(), 2131230922));
        a().f10233o.setNavigationContentDescription(getString(2131951735));
        final int i = 1;
        a().f10233o.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: u4.n1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ z1 f10556b;

            {
                this.f10556b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentManager supportFragmentManager;
                int i6 = i;
                z1 z1Var = this.f10556b;
                switch (i6) {
                    case 0:
                        float f = UptodownApp.I;
                        if (b4.d.t()) {
                            Context requireContext = z1Var.requireContext();
                            requireContext.getClass();
                            if (u2.h(requireContext) == null) {
                                Intent intent = new Intent(z1Var.requireContext(), (Class<?>) LoginActivity.class);
                                ActivityResultLauncher activityResultLauncher = z1Var.f10690t;
                                FragmentActivity requireActivity = z1Var.requireActivity();
                                requireActivity.getClass();
                                activityResultLauncher.launch(intent, b4.d.b(requireActivity));
                                break;
                            } else if (z1Var.d().f10461d.getValue() instanceof j5.r) {
                                Object value = z1Var.d().f10461d.getValue();
                                value.getClass();
                                if (!((Boolean) ((j5.r) value).f6707a).booleanValue()) {
                                    d2 d10 = z1Var.d();
                                    Context requireContext2 = z1Var.requireContext();
                                    requireContext2.getClass();
                                    int i10 = z1Var.f10683m.f11224a;
                                    d10.getClass();
                                    o7.a0 viewModelScope = ViewModelKt.getViewModelScope(d10);
                                    v7.e eVar = o7.m0.f8288a;
                                    o7.c0.s(viewModelScope, v7.d.f10884a, null, new b2(requireContext2, i10, d10, null, 0), 2);
                                    break;
                                } else {
                                    d2 d11 = z1Var.d();
                                    Context requireContext3 = z1Var.requireContext();
                                    requireContext3.getClass();
                                    int i11 = z1Var.f10683m.f11224a;
                                    d11.getClass();
                                    o7.a0 viewModelScope2 = ViewModelKt.getViewModelScope(d11);
                                    v7.e eVar2 = o7.m0.f8288a;
                                    o7.c0.s(viewModelScope2, v7.d.f10884a, null, new b2(requireContext3, i11, d11, null, 2), 2);
                                    break;
                                }
                            }
                        }
                        break;
                    case 1:
                        if (!(z1Var.getActivity() instanceof MainActivity)) {
                            FragmentActivity activity = z1Var.getActivity();
                            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                                supportFragmentManager.popBackStack();
                                break;
                            }
                        } else {
                            FragmentActivity activity2 = z1Var.getActivity();
                            activity2.getClass();
                            ((MainActivity) activity2).h1();
                            break;
                        }
                        break;
                    default:
                        float f10 = UptodownApp.I;
                        if (b4.d.t()) {
                            z1Var.a().f10235q.setVisibility(8);
                            z1Var.a().f10231m.setVisibility(0);
                            z1Var.a().f10234p.setVisibility(8);
                            z1Var.b();
                            break;
                        }
                        break;
                }
            }
        });
        a().f10236r.setTypeface(f4.c.f4882w);
        a().f10235q.setTypeface(f4.c.f4882w);
        final int i6 = 2;
        a().f10235q.setOnClickListener(new View.OnClickListener(this) { // from class: u4.n1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ z1 f10556b;

            {
                this.f10556b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentManager supportFragmentManager;
                int i62 = i6;
                z1 z1Var = this.f10556b;
                switch (i62) {
                    case 0:
                        float f = UptodownApp.I;
                        if (b4.d.t()) {
                            Context requireContext = z1Var.requireContext();
                            requireContext.getClass();
                            if (u2.h(requireContext) == null) {
                                Intent intent = new Intent(z1Var.requireContext(), (Class<?>) LoginActivity.class);
                                ActivityResultLauncher activityResultLauncher = z1Var.f10690t;
                                FragmentActivity requireActivity = z1Var.requireActivity();
                                requireActivity.getClass();
                                activityResultLauncher.launch(intent, b4.d.b(requireActivity));
                                break;
                            } else if (z1Var.d().f10461d.getValue() instanceof j5.r) {
                                Object value = z1Var.d().f10461d.getValue();
                                value.getClass();
                                if (!((Boolean) ((j5.r) value).f6707a).booleanValue()) {
                                    d2 d10 = z1Var.d();
                                    Context requireContext2 = z1Var.requireContext();
                                    requireContext2.getClass();
                                    int i10 = z1Var.f10683m.f11224a;
                                    d10.getClass();
                                    o7.a0 viewModelScope = ViewModelKt.getViewModelScope(d10);
                                    v7.e eVar = o7.m0.f8288a;
                                    o7.c0.s(viewModelScope, v7.d.f10884a, null, new b2(requireContext2, i10, d10, null, 0), 2);
                                    break;
                                } else {
                                    d2 d11 = z1Var.d();
                                    Context requireContext3 = z1Var.requireContext();
                                    requireContext3.getClass();
                                    int i11 = z1Var.f10683m.f11224a;
                                    d11.getClass();
                                    o7.a0 viewModelScope2 = ViewModelKt.getViewModelScope(d11);
                                    v7.e eVar2 = o7.m0.f8288a;
                                    o7.c0.s(viewModelScope2, v7.d.f10884a, null, new b2(requireContext3, i11, d11, null, 2), 2);
                                    break;
                                }
                            }
                        }
                        break;
                    case 1:
                        if (!(z1Var.getActivity() instanceof MainActivity)) {
                            FragmentActivity activity = z1Var.getActivity();
                            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                                supportFragmentManager.popBackStack();
                                break;
                            }
                        } else {
                            FragmentActivity activity2 = z1Var.getActivity();
                            activity2.getClass();
                            ((MainActivity) activity2).h1();
                            break;
                        }
                        break;
                    default:
                        float f10 = UptodownApp.I;
                        if (b4.d.t()) {
                            z1Var.a().f10235q.setVisibility(8);
                            z1Var.a().f10231m.setVisibility(0);
                            z1Var.a().f10234p.setVisibility(8);
                            z1Var.b();
                            break;
                        }
                        break;
                }
            }
        });
        a().f10234p.setTypeface(f4.c.f4883x);
        a().f10234p.setVisibility(8);
        t6.c cVar = null;
        a().f10232n.setItemAnimator(null);
        final int i10 = 0;
        a().f10232n.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        if (this.f10683m.f11224a != -1) {
            a().f10232n.setPadding(0, 0, 0, 0);
        }
        a().f10232n.addOnScrollListener(new q1(this));
        String str = this.f10683m.f11226l;
        int i11 = 4;
        if (str != null && str.length() != 0) {
            a().f10236r.setVisibility(4);
        }
        if (this.f10683m.f11227m) {
            a().f10229b.setVisibility(0);
            a().f10229b.setOnClickListener(new View.OnClickListener(this) { // from class: u4.n1

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ z1 f10556b;

                {
                    this.f10556b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FragmentManager supportFragmentManager;
                    int i62 = i10;
                    z1 z1Var = this.f10556b;
                    switch (i62) {
                        case 0:
                            float f = UptodownApp.I;
                            if (b4.d.t()) {
                                Context requireContext = z1Var.requireContext();
                                requireContext.getClass();
                                if (u2.h(requireContext) == null) {
                                    Intent intent = new Intent(z1Var.requireContext(), (Class<?>) LoginActivity.class);
                                    ActivityResultLauncher activityResultLauncher = z1Var.f10690t;
                                    FragmentActivity requireActivity = z1Var.requireActivity();
                                    requireActivity.getClass();
                                    activityResultLauncher.launch(intent, b4.d.b(requireActivity));
                                    break;
                                } else if (z1Var.d().f10461d.getValue() instanceof j5.r) {
                                    Object value = z1Var.d().f10461d.getValue();
                                    value.getClass();
                                    if (!((Boolean) ((j5.r) value).f6707a).booleanValue()) {
                                        d2 d10 = z1Var.d();
                                        Context requireContext2 = z1Var.requireContext();
                                        requireContext2.getClass();
                                        int i102 = z1Var.f10683m.f11224a;
                                        d10.getClass();
                                        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(d10);
                                        v7.e eVar = o7.m0.f8288a;
                                        o7.c0.s(viewModelScope, v7.d.f10884a, null, new b2(requireContext2, i102, d10, null, 0), 2);
                                        break;
                                    } else {
                                        d2 d11 = z1Var.d();
                                        Context requireContext3 = z1Var.requireContext();
                                        requireContext3.getClass();
                                        int i112 = z1Var.f10683m.f11224a;
                                        d11.getClass();
                                        o7.a0 viewModelScope2 = ViewModelKt.getViewModelScope(d11);
                                        v7.e eVar2 = o7.m0.f8288a;
                                        o7.c0.s(viewModelScope2, v7.d.f10884a, null, new b2(requireContext3, i112, d11, null, 2), 2);
                                        break;
                                    }
                                }
                            }
                            break;
                        case 1:
                            if (!(z1Var.getActivity() instanceof MainActivity)) {
                                FragmentActivity activity = z1Var.getActivity();
                                if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                                    supportFragmentManager.popBackStack();
                                    break;
                                }
                            } else {
                                FragmentActivity activity2 = z1Var.getActivity();
                                activity2.getClass();
                                ((MainActivity) activity2).h1();
                                break;
                            }
                            break;
                        default:
                            float f10 = UptodownApp.I;
                            if (b4.d.t()) {
                                z1Var.a().f10235q.setVisibility(8);
                                z1Var.a().f10231m.setVisibility(0);
                                z1Var.a().f10234p.setVisibility(8);
                                z1Var.b();
                                break;
                            }
                            break;
                    }
                }
            });
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        p7.c cVar2 = t7.n.f10348a;
        o7.c0.s(lifecycleScope, cVar2, null, new s1(this, cVar, i11), 2);
        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new s1(this, cVar, 5), 2);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        RelativeLayout relativeLayout = a().f10228a;
        relativeLayout.getClass();
        return relativeLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f10685o == null) {
            b();
            return;
        }
        if (a().f10232n.getAdapter() == null) {
            a().f10232n.setAdapter(this.f10685o);
            return;
        }
        e4.q0 q0Var = this.f10685o;
        if (q0Var != null) {
            q0Var.notifyDataSetChanged();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        bundle.putParcelable("category", this.f10683m);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        viewLifecycleOwner.getClass();
        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new t1(this, null), 3);
    }
}
