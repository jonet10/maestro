package u4;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import c4.w6;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m1 extends Fragment {

    /* renamed from: b, reason: collision with root package name */
    public e4.h f10538b;

    /* renamed from: n, reason: collision with root package name */
    public p2 f10541n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f10542o;

    /* renamed from: p, reason: collision with root package name */
    public p2 f10543p;

    /* renamed from: r, reason: collision with root package name */
    public boolean f10545r;

    /* renamed from: a, reason: collision with root package name */
    public final p6.m f10537a = new p6.m(new w6(this, 27));

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f10539l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f10540m = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public boolean f10544q = true;

    /* renamed from: s, reason: collision with root package name */
    public boolean f10546s = true;

    /* renamed from: t, reason: collision with root package name */
    public final h1 f10547t = new h1(this);

    /* renamed from: u, reason: collision with root package name */
    public final h1 f10548u = new h1(this);
    public final i1 v = new i1(this);

    /* renamed from: w, reason: collision with root package name */
    public final i1 f10549w = new i1(this);

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
    
        if (o7.c0.C(r7, r9, r0) == r6) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(u4.m1 r8, v6.c r9) {
        /*
            boolean r0 = r9 instanceof u4.k1
            if (r0 == 0) goto L13
            r0 = r9
            u4.k1 r0 = (u4.k1) r0
            int r1 = r0.f10520m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10520m = r1
            goto L18
        L13:
            u4.k1 r0 = new u4.k1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f10518b
            int r1 = r0.f10520m
            p6.x r2 = p6.x.f8463a
            r3 = 2
            r4 = 0
            r5 = 1
            u6.a r6 = u6.a.f10762a
            if (r1 == 0) goto L39
            if (r1 == r5) goto L33
            if (r1 != r3) goto L2d
            p6.a.e(r9)
            return r2
        L2d:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r8)
            return r4
        L33:
            java.util.ArrayList r1 = r0.f10517a
            p6.a.e(r9)
            goto L5d
        L39:
            p6.a.e(r9)
            android.content.Context r9 = r8.getContext()
            if (r9 == 0) goto L71
            r8.f10545r = r5
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            v7.e r9 = o7.m0.f8288a
            v7.d r9 = v7.d.f10884a
            u4.l1 r7 = new u4.l1
            r7.<init>(r8, r1, r4)
            r0.f10517a = r1
            r0.f10520m = r5
            java.lang.Object r9 = o7.c0.C(r7, r9, r0)
            if (r9 != r6) goto L5d
            goto L70
        L5d:
            v7.e r9 = o7.m0.f8288a
            p7.c r9 = t7.n.f10348a
            u4.l1 r5 = new u4.l1
            r5.<init>(r1, r8, r4)
            r0.f10517a = r4
            r0.f10520m = r3
            java.lang.Object r8 = o7.c0.C(r5, r9, r0)
            if (r8 != r6) goto L71
        L70:
            return r6
        L71:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.m1.a(u4.m1, v6.c):java.lang.Object");
    }

    public final t4.p b() {
        return (t4.p) this.f10537a.getValue();
    }

    public final void c() {
        if (getContext() != null) {
            Context requireContext = requireContext();
            requireContext.getClass();
            new s4.s(requireContext, this.f10549w, LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    public final void d(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(lifecycleScope, t7.n.f10348a, null, new s4.e0(str, this, null, 6), 2);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10544q = true;
        this.f10538b = new e4.h(this.f10547t, this.f10548u, this.v, m1.class.getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        b().f10041n.setTypeface(f4.c.f4883x);
        b().f10042o.setTypeface(f4.c.f4882w);
        b().f10042o.setOnClickListener(new m5.u0(this, 9));
        b().f10040m.setItemAnimator(null);
        b().f10040m.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        b().f10040m.addItemDecoration(new l5.h((int) getResources().getDimension(2131166251)));
        b().f10040m.addOnScrollListener(new j1(this));
        c();
        FrameLayout frameLayout = b().f10037a;
        frameLayout.getClass();
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        float f = UptodownApp.I;
        v3.e eVar = UptodownApp.Z;
        if (eVar != null) {
            ((z3.g) eVar).e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        v3.e eVar;
        super.onResume();
        float f = UptodownApp.I;
        v3.e eVar2 = UptodownApp.a0;
        if (eVar2 != null) {
            ((z3.g) eVar2).e();
        }
        if (getContext() != null) {
            Context requireContext = requireContext();
            requireContext.getClass();
            if (!b4.d.e(requireContext) || (eVar = UptodownApp.Z) == null) {
                return;
            }
            ((z3.g) eVar).f();
        }
    }
}
