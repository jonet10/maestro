package u4;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.viewbinding.ViewBindings;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.z3;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.activities.ReviewsActivity;
import com.uptodown.activities.VirusTotalReport;
import com.uptodown.util.views.MaxHeightRecyclerView;
import com.uptodown.util.views.UsernameTextView;
import com.uptodown.views.FullWidthImageView;
import e1.v4;
import eightbitlab.com.blurview.BlurView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import x4.k2;
import x4.q2;
import x4.u2;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f0 extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public x4.g f10472a;

    /* renamed from: b, reason: collision with root package name */
    public t4.b f10473b;

    /* renamed from: n, reason: collision with root package name */
    public android.support.v4.media.g f10476n;

    /* renamed from: o, reason: collision with root package name */
    public AlertDialog f10477o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f10478p;

    /* renamed from: q, reason: collision with root package name */
    public Menu f10479q;

    /* renamed from: r, reason: collision with root package name */
    public e4.u0 f10480r;

    /* renamed from: s, reason: collision with root package name */
    public e4.u0 f10481s;
    public final x v;

    /* renamed from: w, reason: collision with root package name */
    public final s f10484w;

    /* renamed from: x, reason: collision with root package name */
    public final ActivityResultLauncher f10485x;

    /* renamed from: y, reason: collision with root package name */
    public final ActivityResultLauncher f10486y;

    /* renamed from: l, reason: collision with root package name */
    public final p6.f f10474l = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.y.a(v0.class), new o9.a(new c0(this, 0), 2), null);

    /* renamed from: m, reason: collision with root package name */
    public final p6.f f10475m = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.y.a(a1.class), new o9.a(new c0(this, 1), 3), null);

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList f10482t = new ArrayList();

    /* renamed from: u, reason: collision with root package name */
    public final double f10483u = 0.9d;

    public f0() {
        int i = 0;
        this.v = new x(this, i);
        this.f10484w = new s(this, i);
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new i(this, 3));
        registerForActivityResult.getClass();
        this.f10485x = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new i(this, 0));
        registerForActivityResult2.getClass();
        this.f10486y = registerForActivityResult2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
    
        if (o7.c0.C(r1, r8, r0) != r5) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
    
        if (o7.c0.C(r1, r8, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(u4.f0 r7, v6.c r8) {
        /*
            boolean r0 = r8 instanceof u4.t
            if (r0 == 0) goto L13
            r0 = r8
            u4.t r0 = (u4.t) r0
            int r1 = r0.f10605l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10605l = r1
            goto L18
        L13:
            u4.t r0 = new u4.t
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f10603a
            int r1 = r0.f10605l
            r2 = 0
            r3 = 2
            r4 = 1
            u6.a r5 = u6.a.f10762a
            if (r1 == 0) goto L35
            if (r1 == r4) goto L31
            if (r1 != r3) goto L2b
            p6.a.e(r8)
            goto L5d
        L2b:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r7)
            return r2
        L31:
            p6.a.e(r8)
            goto L4b
        L35:
            p6.a.e(r8)
            v7.e r8 = o7.m0.f8288a
            v7.d r8 = v7.d.f10884a
            u4.u r1 = new u4.u
            r6 = 0
            r1.<init>(r7, r2, r6)
            r0.f10605l = r4
            java.lang.Object r8 = o7.c0.C(r1, r8, r0)
            if (r8 != r5) goto L4b
            goto L5c
        L4b:
            v7.e r8 = o7.m0.f8288a
            p7.c r8 = t7.n.f10348a
            u4.u r1 = new u4.u
            r1.<init>(r7, r2, r4)
            r0.f10605l = r3
            java.lang.Object r7 = o7.c0.C(r1, r8, r0)
            if (r7 != r5) goto L5d
        L5c:
            return r5
        L5d:
            p6.x r7 = p6.x.f8463a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.f0.a(u4.f0, v6.c):java.lang.Object");
    }

    public static final void b(f0 f0Var, int i) {
        if (f0Var.B().A0) {
            return;
        }
        f0Var.B().A0 = true;
        Bundle bundle = new Bundle();
        bundle.putString("appId", String.valueOf(f0Var.B().f11158a));
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "noCompatibleFile");
        bundle.putInt("installed", i);
        android.support.v4.media.g gVar = f0Var.f10476n;
        if (gVar != null) {
            gVar.E(bundle, "app_details");
        }
    }

    public static final void c(f0 f0Var, x4.g gVar) {
        if (f0Var.getActivity() != null) {
            FragmentActivity activity = f0Var.getActivity();
            activity.getClass();
            if (((c4.k0) activity).T()) {
                if (f0Var.getActivity() instanceof MainActivity) {
                    FragmentActivity activity2 = f0Var.getActivity();
                    activity2.getClass();
                    ((MainActivity) activity2).i0(gVar.f11158a);
                } else if (f0Var.getActivity() instanceof AppDetailActivity) {
                    FragmentActivity activity3 = f0Var.getActivity();
                    activity3.getClass();
                    ((AppDetailActivity) activity3).i0(gVar.f11158a);
                }
            }
        }
    }

    public static final void d(f0 f0Var, ArrayList arrayList) {
        if (f0Var.getContext() == null || arrayList == null || arrayList.isEmpty()) {
            t4.b bVar = f0Var.f10473b;
            bVar.getClass();
            bVar.W.setVisibility(8);
            return;
        }
        e4.u0 u0Var = new e4.u0(new s(f0Var, 3), new x(f0Var, 3));
        f0Var.f10480r = u0Var;
        u0Var.a(arrayList);
        t4.b bVar2 = f0Var.f10473b;
        bVar2.getClass();
        bVar2.f9602c0.setAdapter(f0Var.f10480r);
        t4.b bVar3 = f0Var.f10473b;
        bVar3.getClass();
        bVar3.f9602c0.setNestedScrollingEnabled(false);
        t4.b bVar4 = f0Var.f10473b;
        bVar4.getClass();
        bVar4.f9602c0.setItemAnimator(null);
        t4.b bVar5 = f0Var.f10473b;
        bVar5.getClass();
        bVar5.f9602c0.setLayoutManager(new LinearLayoutManager(f0Var.getContext(), 0, false));
        t4.b bVar6 = f0Var.f10473b;
        bVar6.getClass();
        bVar6.W.setVisibility(0);
    }

    public static final void g(f0 f0Var, View view, Context context) {
        ViewTreeObserver viewTreeObserver;
        float f = UptodownApp.I;
        boolean z9 = true;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (!z9 || (viewTreeObserver = view.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnPreDrawListener(new b0(view, f0Var));
    }

    public static final void h(f0 f0Var, int i, String str) {
        Menu menu = f0Var.f10479q;
        if (menu != null) {
            menu.findItem(i).setTitle(str);
        }
    }

    public static final void i(f0 f0Var, String str) {
        f0Var.J();
        t4.b bVar = f0Var.f10473b;
        bVar.getClass();
        bVar.T.C.setText(str);
        t4.b bVar2 = f0Var.f10473b;
        bVar2.getClass();
        bVar2.L.f9873w.setText(str);
    }

    public static final void j(f0 f0Var) {
        t4.b bVar = f0Var.f10473b;
        bVar.getClass();
        bVar.T.f9656o.setVisibility(0);
        t4.b bVar2 = f0Var.f10473b;
        bVar2.getClass();
        bVar2.T.f9654m.setVisibility(8);
        t4.b bVar3 = f0Var.f10473b;
        bVar3.getClass();
        ((RelativeLayout) bVar3.P.v).setVisibility(0);
        t4.b bVar4 = f0Var.f10473b;
        bVar4.getClass();
        bVar4.P.f9809s.setVisibility(0);
        t4.b bVar5 = f0Var.f10473b;
        bVar5.getClass();
        bVar5.P.f9802l.setVisibility(8);
        t4.b bVar6 = f0Var.f10473b;
        bVar6.getClass();
        ((RelativeLayout) bVar6.P.f9812w).setVisibility(8);
        t4.b bVar7 = f0Var.f10473b;
        bVar7.getClass();
        bVar7.P.f9811u.setVisibility(8);
        t4.b bVar8 = f0Var.f10473b;
        bVar8.getClass();
        bVar8.L.f9869r.setVisibility(0);
        t4.b bVar9 = f0Var.f10473b;
        bVar9.getClass();
        bVar9.L.f9875y.setVisibility(8);
        t4.b bVar10 = f0Var.f10473b;
        bVar10.getClass();
        bVar10.L.f9868q.setVisibility(8);
        t4.b bVar11 = f0Var.f10473b;
        bVar11.getClass();
        bVar11.L.f9867p.setVisibility(8);
        t4.b bVar12 = f0Var.f10473b;
        bVar12.getClass();
        bVar12.L.f9872u.setVisibility(8);
        Context requireContext = f0Var.requireContext();
        requireContext.getClass();
        if (u2.h(requireContext) == null) {
            t4.b bVar13 = f0Var.f10473b;
            bVar13.getClass();
            TextView textView = bVar13.P.f9809s;
            String string = f0Var.getString(2131952477);
            string.getClass();
            textView.setText(string);
            z3.J(textView);
            t4.b bVar14 = f0Var.f10473b;
            bVar14.getClass();
            ((RelativeLayout) bVar14.P.v).setBackground(ContextCompat.getDrawable(f0Var.requireContext(), 2131231146));
            t4.b bVar15 = f0Var.f10473b;
            bVar15.getClass();
            bVar15.L.f9876z.setText(f0Var.getString(2131952477));
            t4.b bVar16 = f0Var.f10473b;
            bVar16.getClass();
            bVar16.L.f9864m.setVisibility(0);
            t4.b bVar17 = f0Var.f10473b;
            bVar17.getClass();
            TextView textView2 = bVar17.P.f9809s;
            int i = 1;
            textView2.setOnClickListener(new k(f0Var, textView2, i));
            t4.b bVar18 = f0Var.f10473b;
            bVar18.getClass();
            RelativeLayout relativeLayout = bVar18.L.f9869r;
            relativeLayout.setOnClickListener(new k(f0Var, relativeLayout, i));
        } else {
            f0Var.q();
        }
        t4.b bVar19 = f0Var.f10473b;
        bVar19.getClass();
        bVar19.T.f9656o.setVisibility(0);
        t4.b bVar20 = f0Var.f10473b;
        bVar20.getClass();
        bVar20.T.f9654m.setVisibility(8);
        t4.b bVar21 = f0Var.f10473b;
        bVar21.getClass();
        bVar21.T.f9664x.setVisibility(8);
        t4.b bVar22 = f0Var.f10473b;
        bVar22.getClass();
        ((RelativeLayout) bVar22.P.f9814y).setVisibility(8);
        t4.b bVar23 = f0Var.f10473b;
        bVar23.getClass();
        bVar23.B.setVisibility(8);
        f0Var.I(2131361855);
        f0Var.I(2131361897);
        f0Var.I(2131361876);
    }

    public static final void k(f0 f0Var, int i) {
        f0Var.J();
        t4.b bVar = f0Var.f10473b;
        bVar.getClass();
        bVar.T.C.setText(f0Var.getString(2131952703, Integer.valueOf(i)));
        t4.b bVar2 = f0Var.f10473b;
        bVar2.getClass();
        bVar2.L.f9873w.setText(f0Var.getString(2131952703, Integer.valueOf(i)));
    }

    public static final void l(f0 f0Var, x4.g gVar) {
        if ((f0Var.getActivity() instanceof MainActivity) || (f0Var.getActivity() instanceof AppDetailActivity)) {
            FragmentActivity activity = f0Var.getActivity();
            activity.getClass();
            ((c4.k0) activity).t0(gVar, new androidx.work.impl.utils.c(13, gVar, f0Var));
        }
    }

    public static final void m(f0 f0Var, k2 k2Var, int i) {
        int dimension = (int) f0Var.getResources().getDimension(2131166251);
        t4.b bVar = f0Var.f10473b;
        bVar.getClass();
        if (bVar.C.getChildCount() > i) {
            t4.b bVar2 = f0Var.f10473b;
            bVar2.getClass();
            bVar2.C.removeViewAt(i);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, dimension, 0, 0);
        boolean b7 = k2Var.b();
        t4.b bVar3 = f0Var.f10473b;
        if (b7) {
            bVar3.getClass();
            LinearLayout linearLayout = bVar3.C;
            Context requireContext = f0Var.requireContext();
            requireContext.getClass();
            linearLayout.addView(f0Var.Y(layoutParams, k2Var, requireContext), i);
            return;
        }
        bVar3.getClass();
        LinearLayout linearLayout2 = bVar3.C;
        Context requireContext2 = f0Var.requireContext();
        requireContext2.getClass();
        linearLayout2.addView(f0Var.X(layoutParams, k2Var, requireContext2), i);
    }

    public final void A() {
        if (getContext() == null || UptodownApp.T <= 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, UptodownApp.T);
        t4.b bVar = this.f10473b;
        bVar.getClass();
        ((FullWidthImageView) bVar.R.f7781l).setLayoutParams(layoutParams);
        t4.b bVar2 = this.f10473b;
        bVar2.getClass();
        bVar2.f9613m.setScrimVisibleHeightTrigger((int) (UptodownApp.T * 0.4d));
    }

    public final x4.g B() {
        x4.g gVar = this.f10472a;
        if (gVar != null) {
            return gVar;
        }
        kotlin.jvm.internal.l.i("appInfo");
        throw null;
    }

    public final a1 C() {
        return (a1) this.f10475m.getValue();
    }

    public final void D() {
        if (B().f11158a > 0) {
            W();
            return;
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(lifecycleScope, t7.n.f10348a, null, new w(this, null, 3), 2);
    }

    public final void E() {
        if (getContext() != null) {
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            v7.e eVar = o7.m0.f8288a;
            o7.c0.s(lifecycleScope, t7.n.f10348a, null, new w(this, null, 4), 2);
            v0 G = G();
            Context requireContext = requireContext();
            requireContext.getClass();
            long j = B().f11158a;
            G.getClass();
            o7.c0.s(ViewModelKt.getViewModelScope(G), v7.d.f10884a, null, new n0(2, j, requireContext, null, G), 2);
        }
    }

    public final long F() {
        try {
            String str = B().f11177p;
            if (str != null && str.length() != 0) {
                String str2 = B().f11177p;
                str2.getClass();
                return Long.parseLong(str2);
            }
            return 0L;
        } catch (NumberFormatException e10) {
            e10.printStackTrace();
            return 0L;
        }
    }

    public final v0 G() {
        return (v0) this.f10474l.getValue();
    }

    public final boolean H() {
        File externalFilesDir;
        FragmentActivity activity = getActivity();
        activity.getClass();
        if (((c4.k0) activity).l() && getContext() != null) {
            Context requireContext = requireContext();
            requireContext.getClass();
            h4.a aVar = new h4.a(requireContext);
            if (aVar.d()) {
                File[] externalFilesDirs = requireContext.getExternalFilesDirs(null);
                if (externalFilesDirs.length > 1) {
                    externalFilesDir = externalFilesDirs[1];
                } else {
                    externalFilesDir = requireContext.getExternalFilesDir(null);
                    aVar.g();
                    aVar.f();
                }
            } else {
                externalFilesDir = requireContext.getExternalFilesDir(null);
            }
            File file = new File(externalFilesDir, "Apps");
            if (!file.exists()) {
                file.mkdirs();
            }
            requireContext().getClass();
            if (a.a.F(r0, file) < F() * 2.25d) {
                return false;
            }
        }
        return true;
    }

    public final void I(int i) {
        Menu menu = this.f10479q;
        if (menu != null) {
            menu.getClass();
            menu.findItem(i).setVisible(false);
        }
    }

    public final void J() {
        r0();
        t4.b bVar = this.f10473b;
        bVar.getClass();
        ProgressBar progressBar = bVar.T.f9659r;
        t4.b bVar2 = this.f10473b;
        bVar2.getClass();
        t0.f.I(progressBar, bVar2.T.f9652b);
        r7.o0 o0Var = G().I;
        o0Var.getClass();
        o0Var.g(null, -1);
        t4.b bVar3 = this.f10473b;
        bVar3.getClass();
        ((RelativeLayout) bVar3.P.f9812w).setVisibility(8);
        t4.b bVar4 = this.f10473b;
        bVar4.getClass();
        bVar4.P.f9811u.setVisibility(8);
        t4.b bVar5 = this.f10473b;
        bVar5.getClass();
        ((RelativeLayout) bVar5.P.v).setVisibility(8);
        t4.b bVar6 = this.f10473b;
        bVar6.getClass();
        ((RelativeLayout) bVar6.P.f9813x).setVisibility(0);
        t4.b bVar7 = this.f10473b;
        bVar7.getClass();
        bVar7.T.f9659r.setIndeterminate(true);
        t4.b bVar8 = this.f10473b;
        bVar8.getClass();
        bVar8.T.C.setText(getString(2131952625));
        t4.b bVar9 = this.f10473b;
        bVar9.getClass();
        bVar9.L.f9872u.setVisibility(8);
        t4.b bVar10 = this.f10473b;
        bVar10.getClass();
        bVar10.L.f9862b.setVisibility(4);
        t4.b bVar11 = this.f10473b;
        bVar11.getClass();
        bVar11.L.f9874x.setText("");
        t4.b bVar12 = this.f10473b;
        bVar12.getClass();
        bVar12.L.f9865n.setIndeterminate(true);
        t4.b bVar13 = this.f10473b;
        bVar13.getClass();
        bVar13.L.v.setText("");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:23|24|25|(19:27|(1:29)|30|31|32|(13:34|(1:36)|37|(1:39)(1:84)|40|(5:44|(3:77|78|(3:80|(1:48)(1:76)|(7:50|51|(2:53|(1:(2:56|(2:58|(2:60|(2:62|(1:64))(1:65))(1:66))(1:67))(1:68))(1:69))|70|(1:72)|73|74)))|46|(0)(0)|(0))|83|51|(0)|70|(0)|73|74)|86|(0)|37|(0)(0)|40|(6:42|44|(0)|46|(0)(0)|(0))|83|51|(0)|70|(0)|73|74)|89|(0)|30|31|32|(0)|86|(0)|37|(0)(0)|40|(0)|83|51|(0)|70|(0)|73|74) */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0380 A[Catch: Exception -> 0x0385, TRY_LEAVE, TryCatch #2 {Exception -> 0x0385, blocks: (B:32:0x0376, B:34:0x0380), top: B:31:0x0376 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x07b7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x07d4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x07d9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0804  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x093c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x07d6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x07c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x071a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K(final androidx.fragment.app.FragmentActivity r19) {
        /*
            Method dump skipped, instructions count: 2479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.f0.K(androidx.fragment.app.FragmentActivity):void");
    }

    public final boolean L() {
        long j = B().f11158a;
        return a5.b.c(j) || a5.c.b(j);
    }

    public final void M(File file) {
        boolean z9;
        Context requireContext = requireContext();
        requireContext.getClass();
        boolean z10 = false;
        try {
            SharedPreferences sharedPreferences = requireContext.getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences.contains("show_installation_details")) {
                z10 = sharedPreferences.getBoolean("show_installation_details", false);
            }
        } catch (Exception unused) {
        }
        if (z10) {
            if (getActivity() == null || requireActivity().isFinishing()) {
                return;
            }
            FragmentActivity activity = getActivity();
            activity.getClass();
            int i = c4.k0.N;
            ((c4.k0) activity).V(file, null);
            return;
        }
        s sVar = new s(this, 1);
        if (getActivity() instanceof MainActivity) {
            FragmentActivity activity2 = getActivity();
            activity2.getClass();
            z9 = ((MainActivity) activity2).m();
        } else if (getActivity() instanceof AppDetailActivity) {
            FragmentActivity activity3 = getActivity();
            activity3.getClass();
            z9 = ((AppDetailActivity) activity3).m();
        } else {
            z9 = true;
        }
        String name = file.getName();
        name.getClass();
        if (!l7.u.k0(name, ".xapk", true) && !l7.u.k0(name, ".apks", true) && !l7.u.k0(name, ".apkm", true) && !l7.u.k0(name, ".zip", true)) {
            float f = UptodownApp.I;
            FragmentActivity requireActivity = requireActivity();
            requireActivity.getClass();
            b4.d.q(requireActivity, B().f11161c0, file);
            return;
        }
        Context requireContext2 = requireContext();
        requireContext2.getClass();
        String absolutePath = file.getAbsolutePath();
        absolutePath.getClass();
        new a2.t(requireContext2, absolutePath, sVar, z9);
    }

    public final void N(k2 k2Var) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        t6.c cVar = null;
        o7.c0.s(lifecycleScope, t7.n.f10348a, null, new y(this, k2Var, cVar, 0), 2);
        v0 G = G();
        Context requireContext = requireContext();
        requireContext.getClass();
        G.getClass();
        o7.c0.s(ViewModelKt.getViewModelScope(G), v7.d.f10884a, null, new b6.g(G, k2Var, requireContext, cVar, 24), 2);
    }

    public final void O(String str) {
        Bundle e10 = k0.k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
        e10.putString("packagename", B().F);
        if (B().f11158a >= 0) {
            e10.putString("appId", String.valueOf(B().f11158a));
        }
        if (B().J >= 0) {
            e10.putString("fileId", String.valueOf(B().J));
        }
        float f = UptodownApp.I;
        if (b4.d.k(B().F)) {
            e10.putInt("deeplink", 1);
        } else {
            e10.putInt("deeplink", 0);
        }
        android.support.v4.media.g gVar = this.f10476n;
        if (gVar != null) {
            gVar.E(e10, "warning");
        }
    }

    public final void P() {
        String str;
        if (getActivity() == null || requireActivity().isFinishing() || (str = B().F) == null || str.length() == 0 || l7.u.m0(B().F, requireActivity().getPackageName(), true)) {
            return;
        }
        PackageManager packageManager = requireActivity().getPackageManager();
        String str2 = B().F;
        str2.getClass();
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str2);
        if (launchIntentForPackage != null) {
            try {
                startActivity(launchIntentForPackage);
            } catch (ActivityNotFoundException unused) {
                String string = getString(2131952004, B().f11159b);
                string.getClass();
                v(string);
            } catch (SecurityException unused2) {
                String string2 = getString(2131952004, B().f11159b);
                string2.getClass();
                v(string2);
            }
        }
    }

    public final void Q(x4.j jVar) {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            activity.getClass();
            if (((c4.k0) activity).T()) {
                if (getActivity() instanceof MainActivity) {
                    FragmentActivity activity2 = getActivity();
                    activity2.getClass();
                    ((MainActivity) activity2).y1(jVar);
                } else if (getActivity() instanceof AppDetailActivity) {
                    FragmentActivity activity3 = getActivity();
                    activity3.getClass();
                    ((AppDetailActivity) activity3).A0(jVar);
                }
            }
        }
    }

    public final void R() {
        if (getActivity() == null || requireActivity().isFinishing()) {
            return;
        }
        Intent intent = new Intent(requireActivity(), (Class<?>) LoginActivity.class);
        float f = UptodownApp.I;
        FragmentActivity requireActivity = requireActivity();
        requireActivity.getClass();
        this.f10485x.launch(intent, b4.d.b(requireActivity));
    }

    public final void S(k2 k2Var) {
        if (requireActivity().isFinishing()) {
            return;
        }
        FragmentActivity activity = getActivity();
        activity.getClass();
        if (((c4.k0) activity).T()) {
            Intent intent = new Intent(requireActivity(), (Class<?>) RepliesActivity.class);
            intent.putExtra("review", k2Var);
            intent.putExtra("appId", B().f11158a);
            intent.putExtra("appName", B().f11159b);
            intent.putExtra("appIconUrl", B().f11187u);
            float f = UptodownApp.I;
            FragmentActivity requireActivity = requireActivity();
            requireActivity.getClass();
            startActivity(intent, b4.d.a(requireActivity));
        }
    }

    public final void T() {
        if (requireActivity().isFinishing()) {
            return;
        }
        FragmentActivity activity = getActivity();
        activity.getClass();
        if (((c4.k0) activity).T()) {
            Intent intent = new Intent(requireActivity(), (Class<?>) ReviewsActivity.class);
            intent.putExtra("appInfo", B());
            intent.putExtra("myReview", (Parcelable) G().v.getValue());
            float f = UptodownApp.I;
            FragmentActivity requireActivity = requireActivity();
            requireActivity.getClass();
            startActivity(intent, b4.d.a(requireActivity));
        }
    }

    public final void U(k2 k2Var) {
        float f = UptodownApp.I;
        if (b4.d.t()) {
            FragmentActivity activity = getActivity();
            activity.getClass();
            if (((c4.k0) activity).T()) {
                o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new y(this, k2Var, null, 1), 3);
            }
        }
    }

    public final void V() {
        if (getActivity() == null || requireActivity().isFinishing()) {
            return;
        }
        if (B().Z == null) {
            r7.o0 o0Var = G().T;
            Boolean bool = Boolean.TRUE;
            o0Var.getClass();
            o0Var.g(null, bool);
            o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new w(this, null, 18), 3);
            return;
        }
        Intent intent = new Intent(requireActivity(), (Class<?>) VirusTotalReport.class);
        intent.putExtra("appInfo", B());
        intent.putExtra("appReportVT", B().Z);
        float f = UptodownApp.I;
        FragmentActivity requireActivity = requireActivity();
        requireActivity.getClass();
        startActivity(intent, b4.d.a(requireActivity));
    }

    public final void W() {
        String str;
        String str2;
        Context requireContext = requireContext();
        requireContext.getClass();
        String str3 = B().f11187u;
        t6.c cVar = null;
        if (str3 == null || str3.length() == 0) {
            t4.b bVar = this.f10473b;
            bVar.getClass();
            bVar.T.f9652b.setImageDrawable(ContextCompat.getDrawable(requireContext, 2131231296));
            t4.b bVar2 = this.f10473b;
            bVar2.getClass();
            ((ImageView) bVar2.H.f8822q).setImageDrawable(ContextCompat.getDrawable(requireContext, 2131231296));
        } else {
            a4.l0 e10 = a4.g0.d().e(B().h());
            float f = UptodownApp.I;
            e10.g(b4.d.f(requireContext));
            e10.h(b4.d.x(requireContext));
            t4.b bVar3 = this.f10473b;
            bVar3.getClass();
            e10.e(bVar3.T.f9652b, new m8.q(18, this, requireContext));
            a4.l0 e11 = a4.g0.d().e(B().i());
            e11.g(b4.d.f(requireContext));
            e11.h(b4.d.x(requireContext));
            t4.b bVar4 = this.f10473b;
            bVar4.getClass();
            e11.e((ImageView) bVar4.H.f8822q, null);
        }
        String str4 = B().f11187u;
        if ((str4 == null || str4.length() == 0) && ((str = B().v) == null || str.length() == 0)) {
            s0(requireContext);
        }
        String str5 = B().f11159b;
        if (str5 != null && str5.length() != 0) {
            t4.b bVar5 = this.f10473b;
            bVar5.getClass();
            bVar5.T.A.setText(B().f11159b);
            t4.b bVar6 = this.f10473b;
            bVar6.getClass();
            bVar6.F0.setText(requireContext.getString(2131952605, B().f11159b));
        }
        String str6 = B().f11170l;
        if (str6 != null && str6.length() != 0) {
            t4.b bVar7 = this.f10473b;
            bVar7.getClass();
            bVar7.T.G.setText(B().f11170l);
            t4.b bVar8 = this.f10473b;
            bVar8.getClass();
            bVar8.T.G.setVisibility(0);
        }
        String str7 = B().f11164f0;
        if (str7 != null && str7.length() != 0) {
            t4.b bVar9 = this.f10473b;
            bVar9.getClass();
            bVar9.T.B.setText(B().f11164f0);
            t4.b bVar10 = this.f10473b;
            bVar10.getClass();
            bVar10.T.B.setVisibility(0);
        }
        String str8 = B().f11190w;
        if (str8 != null && str8.length() != 0) {
            t4.b bVar11 = this.f10473b;
            bVar11.getClass();
            bVar11.T.f9661t.setText(B().f11190w);
        }
        if (B().f11162d0 == 1) {
            t4.b bVar12 = this.f10473b;
            bVar12.getClass();
            bVar12.T.f9662u.setVisibility(0);
        }
        int i = 8;
        if (B().G0 != null) {
            x4.y1 y1Var = B().G0;
            y1Var.getClass();
            if (y1Var.f11467a != null) {
                t4.b bVar13 = this.f10473b;
                bVar13.getClass();
                bVar13.T.v.setVisibility(0);
                t4.b bVar14 = this.f10473b;
                bVar14.getClass();
                TextView textView = bVar14.T.v;
                x4.y1 y1Var2 = B().G0;
                y1Var2.getClass();
                textView.setText(y1Var2.f11467a);
                t4.b bVar15 = this.f10473b;
                bVar15.getClass();
                bVar15.T.v.setOnClickListener(new e(this, i));
            }
        }
        String str9 = B().f11175o;
        x xVar = this.v;
        if (str9 == null || str9.length() == 0) {
            t4.b bVar16 = this.f10473b;
            bVar16.getClass();
            bVar16.E0.setVisibility(8);
        } else {
            t4.b bVar17 = this.f10473b;
            bVar17.getClass();
            bVar17.E0.setVisibility(0);
            t4.b bVar18 = this.f10473b;
            bVar18.getClass();
            bVar18.E0.setOnTouchListener(new l5.e());
            t4.b bVar19 = this.f10473b;
            bVar19.getClass();
            TextView textView2 = bVar19.E0;
            String str10 = B().f11175o;
            str10.getClass();
            Context requireContext2 = requireContext();
            requireContext2.getClass();
            textView2.setText(a.a.M(str10, requireContext2, xVar));
        }
        String str11 = B().f11192x;
        if (str11 == null || str11.length() == 0) {
            t4.b bVar20 = this.f10473b;
            bVar20.getClass();
            bVar20.N.setVisibility(8);
        } else {
            t4.b bVar21 = this.f10473b;
            bVar21.getClass();
            bVar21.f9609j0.setOnTouchListener(new l5.e());
            if (getResources().getConfiguration().getLayoutDirection() == 1) {
                t4.b bVar22 = this.f10473b;
                bVar22.getClass();
                bVar22.f9609j0.setTextDirection(2);
            }
            t4.b bVar23 = this.f10473b;
            bVar23.getClass();
            TextView textView3 = bVar23.f9609j0;
            String str12 = B().f11192x;
            str12.getClass();
            Context requireContext3 = requireContext();
            requireContext3.getClass();
            textView3.setText(a.a.M(str12, requireContext3, xVar));
            t4.b bVar24 = this.f10473b;
            bVar24.getClass();
            bVar24.N.setVisibility(0);
            String str13 = B().f11178p0;
            if (str13 == null || str13.length() == 0) {
                String str14 = B().f11171l0;
                if (str14 != null && str14.length() != 0) {
                    t4.b bVar25 = this.f10473b;
                    bVar25.getClass();
                    TextView textView4 = bVar25.f9614m0;
                    String str15 = B().f11171l0;
                    str15.getClass();
                    Context requireContext4 = requireContext();
                    requireContext4.getClass();
                    textView4.setText(a.a.M(str15, requireContext4, xVar));
                    String str16 = B().n0;
                    if (str16 == null || str16.length() == 0) {
                        t4.b bVar26 = this.f10473b;
                        bVar26.getClass();
                        bVar26.f9612l0.setVisibility(8);
                    } else {
                        t4.b bVar27 = this.f10473b;
                        bVar27.getClass();
                        bVar27.f9612l0.setText(B().n0);
                    }
                    String str17 = B().f11173m0;
                    if (str17 == null || str17.length() == 0) {
                        t4.b bVar28 = this.f10473b;
                        bVar28.getClass();
                        bVar28.f9618p.setVisibility(8);
                    } else {
                        a4.l0 e12 = a4.g0.d().e(B().f11173m0);
                        float f10 = UptodownApp.I;
                        Context requireContext5 = requireContext();
                        requireContext5.getClass();
                        e12.g(b4.d.f(requireContext5));
                        Context requireContext6 = requireContext();
                        requireContext6.getClass();
                        e12.h(b4.d.x(requireContext6));
                        t4.b bVar29 = this.f10473b;
                        bVar29.getClass();
                        e12.e(bVar29.f9618p, null);
                    }
                    int i6 = B().f11180q0;
                    t4.b bVar30 = this.f10473b;
                    if (i6 == 1) {
                        bVar30.getClass();
                        bVar30.n0.setVisibility(0);
                    } else {
                        bVar30.getClass();
                        bVar30.n0.setVisibility(8);
                    }
                }
            } else {
                t4.b bVar31 = this.f10473b;
                bVar31.getClass();
                bVar31.f9614m0.setText(B().f11178p0);
                t4.b bVar32 = this.f10473b;
                bVar32.getClass();
                bVar32.n0.setVisibility(8);
                t4.b bVar33 = this.f10473b;
                bVar33.getClass();
                bVar33.f9618p.setVisibility(8);
            }
        }
        String str18 = B().f11174n;
        if (str18 == null || str18.length() == 0) {
            I(2131361893);
            I(2131361887);
        } else {
            n0(2131361893);
            n0(2131361887);
        }
        String str19 = B().f11177p;
        if (str19 == null || str19.length() == 0) {
            I(2131361855);
            t4.b bVar34 = this.f10473b;
            bVar34.getClass();
            ((RelativeLayout) bVar34.P.f9814y).setVisibility(8);
        } else {
            n0(2131361855);
            t4.b bVar35 = this.f10473b;
            bVar35.getClass();
            ((RelativeLayout) bVar35.P.f9814y).setVisibility(0);
        }
        String str20 = B().f11163e0;
        if (str20 == null || str20.length() == 0) {
            t4.b bVar36 = this.f10473b;
            bVar36.getClass();
            bVar36.V.setVisibility(8);
        } else {
            t4.b bVar37 = this.f10473b;
            bVar37.getClass();
            bVar37.V.setVisibility(0);
            t4.b bVar38 = this.f10473b;
            bVar38.getClass();
            bVar38.B0.setText(B().f11163e0);
        }
        int i10 = B().f11194y;
        t4.b bVar39 = this.f10473b;
        if (i10 == 0) {
            bVar39.getClass();
            bVar39.T.f9660s.setVisibility(8);
            t4.b bVar40 = this.f10473b;
            bVar40.getClass();
            bVar40.T.H.setVisibility(8);
            t4.b bVar41 = this.f10473b;
            bVar41.getClass();
            bVar41.T.f9653l.setWeightSum(2.0f);
        } else {
            bVar39.getClass();
            bVar39.T.E.setVisibility(0);
            t4.b bVar42 = this.f10473b;
            bVar42.getClass();
            bVar42.T.E.setText(String.valueOf(B().f11194y / 10.0d));
            int i11 = B().f11196z;
            t4.b bVar43 = this.f10473b;
            if (i11 == 1) {
                bVar43.getClass();
                bVar43.T.D.setText(getString(2131952547));
            } else {
                bVar43.getClass();
                TextView textView5 = bVar43.T.D;
                String string = getString(2131952546);
                string.getClass();
                textView5.setText(String.format(string, Arrays.copyOf(new Object[]{i5.D(B().f11196z)}, 1)));
            }
        }
        if (!B().l() || (str2 = B().f11160b0) == null || str2.length() == 0) {
            t4.b bVar44 = this.f10473b;
            bVar44.getClass();
            bVar44.T.f9663w.setText(i5.D(B().f11181r));
            t4.b bVar45 = this.f10473b;
            bVar45.getClass();
            bVar45.T.f9664x.setText(getString(2131952250));
            String str21 = B().F;
            if (str21 == null || str21.length() == 0) {
                t4.b bVar46 = this.f10473b;
                bVar46.getClass();
                bVar46.f9635y.setVisibility(8);
            } else {
                t4.b bVar47 = this.f10473b;
                bVar47.getClass();
                bVar47.f9623r0.setText(B().F);
            }
            String str22 = B().f11177p;
            if (str22 == null || str22.length() == 0) {
                t4.b bVar48 = this.f10473b;
                bVar48.getClass();
                bVar48.A.setVisibility(8);
            } else {
                t4.b bVar49 = this.f10473b;
                bVar49.getClass();
                TextView textView6 = bVar49.f9630v0;
                long F = F();
                Context requireContext7 = requireContext();
                requireContext7.getClass();
                textView6.setText(i5.H(requireContext7, F));
            }
            String str23 = B().O;
            if (str23 == null || str23.length() == 0) {
                t4.b bVar50 = this.f10473b;
                bVar50.getClass();
                bVar50.f9637z.setVisibility(8);
            } else {
                String str24 = B().O;
                str24.getClass();
                Integer h02 = l7.t.h0(str24);
                t4.b bVar51 = this.f10473b;
                if (h02 != null) {
                    bVar51.getClass();
                    bVar51.f9627t0.setText(getString(2131952462, B().O));
                } else {
                    bVar51.getClass();
                    bVar51.f9627t0.setText(B().O);
                }
            }
        } else {
            t4.b bVar52 = this.f10473b;
            bVar52.getClass();
            bVar52.T.f9663w.setText(B().f11160b0);
            t4.b bVar53 = this.f10473b;
            bVar53.getClass();
            bVar53.M.setVisibility(8);
        }
        String str25 = B().f11185t;
        if (str25 == null || str25.length() == 0 || B().l()) {
            t4.b bVar54 = this.f10473b;
            bVar54.getClass();
            bVar54.T.f9657p.setVisibility(8);
            t4.b bVar55 = this.f10473b;
            bVar55.getClass();
            bVar55.T.I.setVisibility(8);
        } else {
            t4.b bVar56 = this.f10473b;
            bVar56.getClass();
            bVar56.T.f9665y.setText(B().f11185t);
        }
        t4.b bVar57 = this.f10473b;
        bVar57.getClass();
        ((TextView) bVar57.D.f8823r).setText(String.valueOf(B().f11194y / 10.0d));
        int i12 = B().f11196z;
        t4.b bVar58 = this.f10473b;
        if (i12 == 1) {
            bVar58.getClass();
            ((TextView) bVar58.D.f8824s).setText(getString(2131951798));
        } else {
            bVar58.getClass();
            TextView textView7 = (TextView) bVar58.D.f8824s;
            String string2 = getString(2131952546);
            string2.getClass();
            textView7.setText(String.format(string2, Arrays.copyOf(new Object[]{i5.D(B().f11196z)}, 1)));
        }
        t4.b bVar59 = this.f10473b;
        bVar59.getClass();
        ((TextView) bVar59.D.f8824s).setOnClickListener(new e(this, 14));
        String str26 = B().f11161c0;
        if (str26 == null || str26.length() == 0) {
            t4.b bVar60 = this.f10473b;
            bVar60.getClass();
            bVar60.Y.f10125b.setVisibility(8);
        } else {
            t4.b bVar61 = this.f10473b;
            bVar61.getClass();
            bVar61.Y.f10128n.setText(B().f11161c0);
            t4.b bVar62 = this.f10473b;
            bVar62.getClass();
            bVar62.Y.f10128n.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: u4.n
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    f0 f0Var = f0.this;
                    t4.b bVar63 = f0Var.f10473b;
                    bVar63.getClass();
                    if (b2.t1.E(bVar63.Y.f10128n)) {
                        return;
                    }
                    t4.b bVar64 = f0Var.f10473b;
                    bVar64.getClass();
                    if (bVar64.Y.f10128n.getMaxLines() <= 6) {
                        t4.b bVar65 = f0Var.f10473b;
                        bVar65.getClass();
                        bVar65.Y.f10126l.setVisibility(8);
                        t4.b bVar66 = f0Var.f10473b;
                        bVar66.getClass();
                        bVar66.Y.f10129o.setVisibility(8);
                    }
                }
            });
            t4.b bVar63 = this.f10473b;
            bVar63.getClass();
            bVar63.Y.f10125b.setVisibility(0);
        }
        String str27 = B().J0;
        if (str27 == null || str27.length() == 0) {
            t4.b bVar64 = this.f10473b;
            bVar64.getClass();
            bVar64.S.setVisibility(8);
        } else {
            t4.b bVar65 = this.f10473b;
            bVar65.getClass();
            bVar65.S.setVisibility(0);
            t4.b bVar66 = this.f10473b;
            bVar66.getClass();
            bVar66.f9621q0.setText(getString(2131952100, B().f11159b));
            t4.b bVar67 = this.f10473b;
            bVar67.getClass();
            bVar67.f9619p0.setText(B().J0);
        }
        String str28 = B().Q;
        if (str28 == null || str28.length() == 0) {
            String str29 = B().R;
            if (str29 != null && str29.length() != 0) {
                t4.b bVar68 = this.f10473b;
                bVar68.getClass();
                bVar68.I0.setText(B().R);
            }
        } else {
            t4.b bVar69 = this.f10473b;
            bVar69.getClass();
            bVar69.I0.setText(B().Q);
        }
        x4.r1 A = i5.A(requireContext);
        if (A != null && A.f11371a == B().f11158a && A.f11375e <= 0) {
            A.f11375e = System.currentTimeMillis();
            A.a(requireContext);
        }
        if (kotlin.jvm.internal.l.a(B().F, requireContext().getPackageName()) || kotlin.jvm.internal.l.a(B().F, "com.uptodown.installer")) {
            t4.b bVar70 = this.f10473b;
            bVar70.getClass();
            bVar70.v.setVisibility(8);
        }
        ArrayList arrayList = B().D0;
        if (arrayList != null && !arrayList.isEmpty()) {
            t4.b bVar71 = this.f10473b;
            bVar71.getClass();
            if (bVar71.F.getVisibility() == 8) {
                t4.b bVar72 = this.f10473b;
                bVar72.getClass();
                bVar72.F.setVisibility(0);
                t4.b bVar73 = this.f10473b;
                bVar73.getClass();
                bVar73.H0.setTypeface(f4.c.f4882w);
                t4.b bVar74 = this.f10473b;
                bVar74.getClass();
                bVar74.G0.setTypeface(f4.c.f4883x);
                ArrayList arrayList2 = B().D0;
                arrayList2.getClass();
                Iterator it = arrayList2.iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    String str30 = (String) next;
                    if (str30.length() > 0) {
                        View inflate = getLayoutInflater().inflate(2131558854, (ViewGroup) null, false);
                        int i13 = 2131362541;
                        if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362541)) != null) {
                            i13 = 2131364521;
                            TextView textView8 = (TextView) ViewBindings.findChildViewById(inflate, 2131364521);
                            if (textView8 != null) {
                                View view = (LinearLayout) inflate;
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                                layoutParams.setMargins(0, (int) getResources().getDimension(2131166251), 0, 0);
                                view.setLayoutParams(layoutParams);
                                textView8.setTypeface(f4.c.f4883x);
                                textView8.setText(str30);
                                t4.b bVar75 = this.f10473b;
                                bVar75.getClass();
                                bVar75.G.addView(view);
                            }
                        }
                        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i13)));
                        return;
                    }
                }
            }
        }
        String str31 = B().f11177p;
        if (str31 != null && str31.length() != 0 && getActivity() != null && !requireActivity().isFinishing() && B().Z == null) {
            o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new w(this, cVar, 19), 3);
        }
        Context requireContext8 = requireContext();
        requireContext8.getClass();
        p0(requireContext8);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        p7.c cVar2 = t7.n.f10348a;
        o7.c0.s(lifecycleScope, cVar2, null, new w(this, cVar, 23), 2);
        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new w(this, cVar, 20), 2);
        r7.o0 o0Var = G().N;
        Boolean bool = Boolean.TRUE;
        o0Var.getClass();
        o0Var.g(null, bool);
        if (((Number) G().Q.getValue()).intValue() > 0) {
            w0();
        }
        z();
    }

    public final RelativeLayout X(LinearLayout.LayoutParams layoutParams, k2 k2Var, Context context) {
        int i;
        CharSequence charSequence;
        t4.p0 a8 = t4.p0.a(getLayoutInflater().inflate(2131558803, (ViewGroup) null, false));
        TextView textView = a8.f10056x;
        LinearLayout linearLayout = a8.f10053t;
        ImageView imageView = a8.f10045l;
        TextView textView2 = a8.f10058z;
        TextView textView3 = a8.f10055w;
        LinearLayout linearLayout2 = a8.f10054u;
        ImageView imageView2 = a8.f10046m;
        TextView textView4 = a8.f10057y;
        TextView textView5 = a8.v;
        UsernameTextView usernameTextView = a8.B;
        RelativeLayout relativeLayout = a8.f10043a;
        relativeLayout.setLayoutParams(layoutParams);
        a8.f10048o.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
        ImageView imageView3 = a8.f10049p;
        imageView3.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
        ImageView imageView4 = a8.f10050q;
        imageView4.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
        ImageView imageView5 = a8.f10051r;
        imageView5.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
        ImageView imageView6 = a8.f10052s;
        imageView6.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
        if (k2Var.f11264p >= 2) {
            i = 2131231441;
            imageView3.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
        } else {
            i = 2131231441;
        }
        int i6 = 3;
        if (k2Var.f11264p >= 3) {
            imageView4.setImageDrawable(ContextCompat.getDrawable(context, i));
        }
        int i10 = 4;
        if (k2Var.f11264p >= 4) {
            imageView5.setImageDrawable(ContextCompat.getDrawable(context, i));
        }
        int i11 = 5;
        if (k2Var.f11264p == 5) {
            imageView6.setImageDrawable(ContextCompat.getDrawable(context, i));
        }
        usernameTextView.setTypeface(f4.c.f4882w);
        textView3.setTypeface(f4.c.f4883x);
        textView5.setTypeface(f4.c.f4883x);
        textView4.setTypeface(f4.c.f4883x);
        textView2.setTypeface(f4.c.f4883x);
        String e10 = u2.e(k2Var.f11261m);
        if (e10 == null || e10.length() == 0) {
            charSequence = null;
        } else {
            a4.l0 e11 = a4.g0.d().e(u2.e(k2Var.f11261m));
            float f = UptodownApp.I;
            e11.h(b4.d.x(context));
            charSequence = null;
            e11.e(imageView, null);
        }
        String str = k2Var.f11259b;
        if (str != null && str.length() != 0) {
            imageView.setOnClickListener(new j(this, k2Var, i10));
            usernameTextView.setOnClickListener(new j(this, k2Var, i11));
        }
        String str2 = k2Var.f11260l;
        if (str2 != null && str2.length() != 0) {
            usernameTextView.setText(k2Var.f11260l);
            int i12 = UsernameTextView.f3452s;
            i5.g(usernameTextView, k2Var.b(), k2Var.f11270w);
        }
        String str3 = k2Var.f11266r;
        if (str3 != null && str3.length() != 0) {
            textView3.setText(k2Var.f11266r);
        }
        int i13 = k2Var.f11265q;
        if (i13 > 0) {
            textView2.setText(String.valueOf(i13));
        }
        Context requireContext = requireContext();
        requireContext.getClass();
        w2 h = u2.h(requireContext);
        int i14 = 6;
        if (kotlin.jvm.internal.l.a(h != null ? h.f11431a : charSequence, k2Var.f11259b)) {
            imageView2.setVisibility(8);
        } else {
            k0.k.l(this, k2Var.f11271x == 1 ? 2131231341 : 2131231340, imageView2);
            imageView2.setOnClickListener(new j(this, k2Var, i14));
        }
        String str4 = k2Var.f11263o;
        if (str4 == null || str4.length() == 0) {
            textView5.setVisibility(8);
            linearLayout2.setVisibility(8);
            linearLayout.setVisibility(8);
        } else {
            textView4.setFocusable(true);
            Spanned a10 = k2Var.a();
            if (a10 != null) {
                charSequence = l7.m.K0(a10);
            }
            textView5.setText(charSequence);
            textView5.getViewTreeObserver().addOnPreDrawListener(new e4.h1(a8, i6));
            a8.A.setOnClickListener(new f(a8, this, i14));
            linearLayout2.setOnClickListener(new j(this, k2Var, 7));
            linearLayout2.setFocusable(true);
            textView.setTypeface(f4.c.f4883x);
            textView.setText(String.valueOf(k2Var.f11267s));
            if (j5.t.f6709b.contains(Long.valueOf(k2Var.f11258a))) {
                k0.k.l(this, 2131231344, a8.f10047n);
            }
            linearLayout.setOnClickListener(new c4.t(this, a8, k2Var, 19));
        }
        textView4.setFocusable(true);
        return relativeLayout;
    }

    public final RelativeLayout Y(LinearLayout.LayoutParams layoutParams, k2 k2Var, Context context) {
        int i;
        CharSequence charSequence;
        t4.q0 a8 = t4.q0.a(getLayoutInflater().inflate(2131558805, (ViewGroup) null, false));
        ImageView imageView = a8.f10072t;
        LinearLayout linearLayout = a8.f10073u;
        TextView textView = a8.f10076y;
        TextView textView2 = a8.A;
        TextView textView3 = a8.f10075x;
        LinearLayout linearLayout2 = a8.v;
        ImageView imageView2 = a8.f10065m;
        ImageView imageView3 = a8.f10064l;
        TextView textView4 = a8.f10077z;
        TextView textView5 = a8.f10074w;
        UsernameTextView usernameTextView = a8.C;
        RelativeLayout relativeLayout = a8.f10062a;
        relativeLayout.setLayoutParams(layoutParams);
        a8.f10067o.setImageDrawable(ContextCompat.getDrawable(context, 2131231442));
        ImageView imageView4 = a8.f10068p;
        imageView4.setImageDrawable(ContextCompat.getDrawable(context, 2131231440));
        ImageView imageView5 = a8.f10069q;
        imageView5.setImageDrawable(ContextCompat.getDrawable(context, 2131231440));
        ImageView imageView6 = a8.f10070r;
        imageView6.setImageDrawable(ContextCompat.getDrawable(context, 2131231440));
        ImageView imageView7 = a8.f10071s;
        imageView7.setImageDrawable(ContextCompat.getDrawable(context, 2131231440));
        if (k2Var.f11264p >= 2) {
            i = 2131231442;
            imageView4.setImageDrawable(ContextCompat.getDrawable(context, 2131231442));
        } else {
            i = 2131231442;
        }
        int i6 = 3;
        if (k2Var.f11264p >= 3) {
            imageView5.setImageDrawable(ContextCompat.getDrawable(context, i));
        }
        int i10 = 4;
        if (k2Var.f11264p >= 4) {
            imageView6.setImageDrawable(ContextCompat.getDrawable(context, i));
        }
        if (k2Var.f11264p == 5) {
            imageView7.setImageDrawable(ContextCompat.getDrawable(context, i));
        }
        usernameTextView.setTypeface(f4.c.f4882w);
        textView3.setTypeface(f4.c.f4883x);
        textView5.setTypeface(f4.c.f4883x);
        textView4.setTypeface(f4.c.f4883x);
        textView2.setTypeface(f4.c.f4883x);
        if (u2.e(k2Var.f11261m) != null) {
            a4.l0 e10 = a4.g0.d().e(u2.e(k2Var.f11261m));
            float f = UptodownApp.I;
            e10.h(b4.d.x(context));
            charSequence = null;
            e10.e(imageView3, null);
        } else {
            charSequence = null;
        }
        String str = k2Var.f11259b;
        int i11 = 1;
        if (str != null && str.length() != 0) {
            imageView3.setOnClickListener(new j(this, k2Var, 0));
            usernameTextView.setOnClickListener(new j(this, k2Var, i11));
        }
        String str2 = k2Var.f11260l;
        if (str2 != null) {
            usernameTextView.setText(str2);
            int i12 = UsernameTextView.f3452s;
            i5.g(usernameTextView, k2Var.b(), k2Var.f11270w);
        }
        String str3 = k2Var.f11266r;
        if (str3 != null) {
            textView3.setText(str3);
        }
        int i13 = k2Var.f11265q;
        if (i13 > 0) {
            textView2.setText(String.valueOf(i13));
        }
        Context requireContext = requireContext();
        requireContext.getClass();
        w2 h = u2.h(requireContext);
        if (kotlin.jvm.internal.l.a(h != null ? h.f11431a : charSequence, k2Var.f11259b)) {
            imageView2.setVisibility(8);
        } else {
            k0.k.l(this, k2Var.f11271x == 1 ? 2131231341 : 2131231340, imageView2);
            imageView2.setOnClickListener(new j(this, k2Var, 2));
        }
        if (k2Var.f11263o != null) {
            textView4.setFocusable(true);
            Spanned a10 = k2Var.a();
            if (a10 != null) {
                charSequence = l7.m.K0(a10);
            }
            textView5.setText(charSequence);
            textView5.getViewTreeObserver().addOnPreDrawListener(new e4.h1(a8, i10));
            a8.B.setOnClickListener(new f(a8, this, i10));
            linearLayout2.setOnClickListener(new j(this, k2Var, i6));
            linearLayout2.setFocusable(true);
            textView.setTypeface(f4.c.f4883x);
            textView.setText(String.valueOf(k2Var.f11267s));
            if (j5.t.f6709b.contains(Long.valueOf(k2Var.f11258a))) {
                k0.k.l(this, 2131231344, a8.f10066n);
            }
            linearLayout.setOnClickListener(new c4.t(this, a8, k2Var, 18));
        } else {
            textView5.setVisibility(8);
            linearLayout2.setVisibility(8);
            linearLayout.setVisibility(8);
        }
        imageView.setOnClickListener(new e(this, 7));
        imageView.setVisibility(0);
        int dimension = (int) imageView3.getContext().getResources().getDimension(2131165270);
        imageView3.setForeground(ContextCompat.getDrawable(imageView3.getContext(), 2131231271));
        imageView3.setPadding(dimension, dimension, dimension, dimension);
        textView4.setFocusable(true);
        return relativeLayout;
    }

    public final void Z(String str) {
        int intValue = ((Number) G().S.getValue()).intValue();
        if (1 > intValue || intValue >= 6) {
            FragmentActivity activity = getActivity();
            activity.getClass();
            String string = getString(2131952006);
            string.getClass();
            ((c4.k0) activity).A(string);
            return;
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(lifecycleScope, t7.n.f10348a, null, new w(this, null, 21), 2);
        v0 G = G();
        Context requireContext = requireContext();
        requireContext.getClass();
        int intValue2 = ((Number) G().S.getValue()).intValue();
        long j = B().f11158a;
        G.getClass();
        str.getClass();
        o7.c0.s(ViewModelKt.getViewModelScope(G), v7.d.f10884a, null, new t0(requireContext, str, intValue2, j, G, null), 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a0() {
        /*
            r5 = this;
            t4.b r0 = r5.f10473b
            r0.getClass()
            android.widget.FrameLayout r0 = r0.f9615n
            int r0 = r0.getChildCount()
            r1 = 0
            if (r0 != 0) goto L7d
            x4.g r0 = r5.B()
            java.lang.String r0 = r0.F
            android.content.Context r2 = r5.getContext()
            r3 = 0
            if (r0 == 0) goto L28
            if (r2 == 0) goto L28
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            if (r2 == 0) goto L28
            android.content.pm.PackageInfo r0 = n4.i.e(r2, r0, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L28
            goto L29
        L28:
            r0 = r3
        L29:
            if (r0 == 0) goto L36
            android.content.Context r0 = r5.requireContext()
            r0.getClass()
            r5.h0(r0)
            goto L43
        L36:
            r0 = 2131951692(0x7f13004c, float:1.9539806E38)
            java.lang.String r0 = r5.getString(r0)
            r0.getClass()
            r5.b0(r0)
        L43:
            android.view.LayoutInflater r0 = r5.getLayoutInflater()
            r2 = 2131558455(0x7f0d0037, float:1.8742226E38)
            android.view.View r0 = r0.inflate(r2, r3, r1)
            r2 = 2131363717(0x7f0a0785, float:1.834725E38)
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r2)
            android.widget.TextView r3 = (android.widget.TextView) r3
            if (r3 == 0) goto L6b
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            android.graphics.Typeface r2 = f4.c.f4883x
            r3.setTypeface(r2)
            t4.b r2 = r5.f10473b
            r2.getClass()
            android.widget.FrameLayout r2 = r2.f9615n
            r2.addView(r0)
            goto L7d
        L6b:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r2)
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r0 = r1.concat(r0)
            com.google.gson.internal.a.i(r0)
            return
        L7d:
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r0.<init>(r2)
            u4.l r2 = new u4.l
            r2.<init>(r5, r1)
            r3 = 5000(0x1388, double:2.4703E-320)
            r0.postDelayed(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.f0.a0():void");
    }

    public final void b0(String str) {
        t4.b bVar = this.f10473b;
        bVar.getClass();
        bVar.T.f9656o.setVisibility(0);
        t4.b bVar2 = this.f10473b;
        bVar2.getClass();
        bVar2.T.f9654m.setVisibility(8);
        t4.b bVar3 = this.f10473b;
        bVar3.getClass();
        bVar3.P.f9807q.setVisibility(0);
        t4.b bVar4 = this.f10473b;
        bVar4.getClass();
        ((RelativeLayout) bVar4.P.v).setVisibility(8);
        t4.b bVar5 = this.f10473b;
        bVar5.getClass();
        ((RelativeLayout) bVar5.P.f9812w).setVisibility(8);
        t4.b bVar6 = this.f10473b;
        bVar6.getClass();
        bVar6.P.f9811u.setVisibility(8);
        t4.b bVar7 = this.f10473b;
        bVar7.getClass();
        bVar7.L.f9866o.setVisibility(0);
        t4.b bVar8 = this.f10473b;
        bVar8.getClass();
        bVar8.L.f9875y.setVisibility(8);
        t4.b bVar9 = this.f10473b;
        bVar9.getClass();
        bVar9.L.f9867p.setVisibility(8);
        t4.b bVar10 = this.f10473b;
        bVar10.getClass();
        bVar10.L.f9872u.setVisibility(8);
        r7.o0 o0Var = G().I;
        o0Var.getClass();
        o0Var.g(null, -1);
        t4.b bVar11 = this.f10473b;
        bVar11.getClass();
        ((RelativeLayout) bVar11.P.f9814y).setVisibility(8);
        t4.b bVar12 = this.f10473b;
        bVar12.getClass();
        bVar12.T.f9654m.setVisibility(8);
        t4.b bVar13 = this.f10473b;
        bVar13.getClass();
        bVar13.P.f9808r.setText(str);
        t4.b bVar14 = this.f10473b;
        bVar14.getClass();
        bVar14.L.f9870s.setText(str);
        t4.b bVar15 = this.f10473b;
        bVar15.getClass();
        bVar15.L.f9875y.setOnClickListener(null);
        t4.b bVar16 = this.f10473b;
        bVar16.getClass();
        bVar16.L.f9866o.setOnClickListener(new e(this, 29));
        t4.b bVar17 = this.f10473b;
        bVar17.getClass();
        bVar17.P.f9807q.setOnClickListener(new p(this, 0));
        I(2131361855);
        I(2131361897);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c0(android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.f0.c0(android.content.Context):void");
    }

    public final void d0(x4.r rVar) {
        r0();
        t4.b bVar = this.f10473b;
        bVar.getClass();
        ProgressBar progressBar = bVar.T.f9659r;
        t4.b bVar2 = this.f10473b;
        bVar2.getClass();
        t0.f.I(progressBar, bVar2.T.f9652b);
        t4.b bVar3 = this.f10473b;
        bVar3.getClass();
        TextView textView = bVar3.P.f9809s;
        String string = getString(2131952425);
        string.getClass();
        textView.setText(string);
        z3.K(textView);
        t4.b bVar4 = this.f10473b;
        bVar4.getClass();
        ((RelativeLayout) bVar4.P.v).setBackground(ContextCompat.getDrawable(requireContext(), 2131231156));
        t4.b bVar5 = this.f10473b;
        bVar5.getClass();
        ((RelativeLayout) bVar5.P.f9812w).setVisibility(8);
        t4.b bVar6 = this.f10473b;
        bVar6.getClass();
        bVar6.L.f9863l.setVisibility(8);
        r7.o0 o0Var = G().I;
        int i = 5;
        o0Var.getClass();
        o0Var.g(null, 5);
        if (rVar == null && getContext() != null) {
            e1.c0 c0Var = j5.g.D;
            Context requireContext = requireContext();
            requireContext.getClass();
            j5.g l10 = c0Var.l(requireContext);
            l10.b();
            String str = B().F;
            str.getClass();
            x4.r L = l10.L(B().K, str);
            l10.c();
            rVar = L;
        }
        t4.b bVar7 = this.f10473b;
        if (rVar == null) {
            bVar7.getClass();
            bVar7.T.f9659r.setIndeterminate(true);
            t4.b bVar8 = this.f10473b;
            bVar8.getClass();
            bVar8.L.f9865n.setIndeterminate(true);
            return;
        }
        bVar7.getClass();
        bVar7.P.f9809s.setOnClickListener(new p(this, i));
        t4.b bVar9 = this.f10473b;
        bVar9.getClass();
        bVar9.L.f9862b.setVisibility(0);
        boolean L2 = L();
        t4.b bVar10 = this.f10473b;
        if (L2) {
            bVar10.getClass();
            TextView textView2 = bVar10.P.f9811u;
            String string2 = getString(2131951655);
            string2.getClass();
            textView2.setText(string2);
            z3.K(textView2);
            String valueOf = String.valueOf(rVar.i());
            if (isAdded() && getContext() != null) {
                valueOf = a4.x.C(valueOf, requireContext().getString(2131952466));
            }
            t4.b bVar11 = this.f10473b;
            bVar11.getClass();
            bVar11.T.f9659r.setIndeterminate(false);
            t4.b bVar12 = this.f10473b;
            bVar12.getClass();
            bVar12.T.f9659r.setProgress(rVar.i());
            if (rVar.k() > 0) {
                t4.b bVar13 = this.f10473b;
                bVar13.getClass();
                TextView textView3 = bVar13.T.C;
                Integer valueOf2 = Integer.valueOf(rVar.i());
                long k5 = rVar.k();
                Context requireContext2 = requireContext();
                requireContext2.getClass();
                textView3.setText(getString(2131952467, valueOf2, i5.H(requireContext2, k5)));
            }
            t4.b bVar14 = this.f10473b;
            bVar14.getClass();
            bVar14.L.f9865n.setIndeterminate(false);
            t4.b bVar15 = this.f10473b;
            bVar15.getClass();
            bVar15.L.v.setVisibility(0);
            t4.b bVar16 = this.f10473b;
            bVar16.getClass();
            bVar16.L.f9871t.setVisibility(8);
            t4.b bVar17 = this.f10473b;
            bVar17.getClass();
            bVar17.L.v.setText(valueOf);
            t4.b bVar18 = this.f10473b;
            bVar18.getClass();
            TextView textView4 = bVar18.L.f9873w;
            long j = rVar.j();
            Context requireContext3 = requireContext();
            requireContext3.getClass();
            textView4.setText(i5.H(requireContext3, j));
            t4.b bVar19 = this.f10473b;
            bVar19.getClass();
            bVar19.L.f9865n.setProgress(rVar.i());
        } else {
            bVar10.getClass();
            bVar10.T.C.setText(getString(2131952625));
            t4.b bVar20 = this.f10473b;
            bVar20.getClass();
            bVar20.T.f9659r.setIndeterminate(true);
            t4.b bVar21 = this.f10473b;
            bVar21.getClass();
            bVar21.L.f9865n.setIndeterminate(true);
            t4.b bVar22 = this.f10473b;
            bVar22.getClass();
            bVar22.L.f9871t.setVisibility(0);
            t4.b bVar23 = this.f10473b;
            bVar23.getClass();
            bVar23.L.v.setVisibility(8);
        }
        t4.b bVar24 = this.f10473b;
        bVar24.getClass();
        TextView textView5 = bVar24.L.f9874x;
        long k10 = rVar.k();
        Context requireContext4 = requireContext();
        requireContext4.getClass();
        textView5.setText(String.format("/%s", Arrays.copyOf(new Object[]{i5.H(requireContext4, k10)}, 1)));
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0388  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e0() {
        /*
            Method dump skipped, instructions count: 987
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.f0.e0():void");
    }

    public final void f0() {
        q0();
        t4.b bVar = this.f10473b;
        bVar.getClass();
        ProgressBar progressBar = bVar.T.f9659r;
        t4.b bVar2 = this.f10473b;
        bVar2.getClass();
        t0.f.s(progressBar, bVar2.T.f9652b);
        t4.b bVar3 = this.f10473b;
        bVar3.getClass();
        bVar3.T.f9656o.setVisibility(0);
        t4.b bVar4 = this.f10473b;
        bVar4.getClass();
        bVar4.T.f9654m.setVisibility(8);
        if (UptodownApp.f3291e0 && B().k()) {
            t4.b bVar5 = this.f10473b;
            bVar5.getClass();
            bVar5.P.f9802l.setVisibility(0);
            t4.b bVar6 = this.f10473b;
            bVar6.getClass();
            bVar6.P.f9803m.setVisibility(0);
        } else {
            t4.b bVar7 = this.f10473b;
            bVar7.getClass();
            bVar7.P.f9802l.setVisibility(8);
            t4.b bVar8 = this.f10473b;
            bVar8.getClass();
            bVar8.P.f9803m.setVisibility(8);
        }
        t4.b bVar9 = this.f10473b;
        bVar9.getClass();
        bVar9.P.f9809s.setOnClickListener(new p(this, 16));
        r7.o0 o0Var = G().I;
        o0Var.getClass();
        o0Var.g(null, 3);
        t4.b bVar10 = this.f10473b;
        bVar10.getClass();
        TextView textView = bVar10.P.f9809s;
        String string = getString(2131952428);
        string.getClass();
        textView.setText(string);
        z3.J(textView);
        t4.b bVar11 = this.f10473b;
        bVar11.getClass();
        ((RelativeLayout) bVar11.P.v).setBackground(ContextCompat.getDrawable(requireContext(), 2131231146));
        t4.b bVar12 = this.f10473b;
        bVar12.getClass();
        TextView textView2 = bVar12.L.f9875y;
        String string2 = getString(2131952428);
        string2.getClass();
        textView2.setText(string2);
        z3.J(textView2);
        I(2131361857);
        I(2131361897);
    }

    public final void g0(Context context, x4.r rVar) {
        File externalFilesDir;
        long j;
        Context requireContext = requireContext();
        requireContext.getClass();
        h4.a aVar = new h4.a(requireContext);
        if (aVar.d()) {
            File[] externalFilesDirs = requireContext.getExternalFilesDirs(null);
            if (externalFilesDirs.length > 1) {
                externalFilesDir = externalFilesDirs[1];
            } else {
                externalFilesDir = requireContext.getExternalFilesDir(null);
                aVar.g();
                aVar.f();
            }
        } else {
            externalFilesDir = requireContext.getExternalFilesDir(null);
        }
        File file = new File(externalFilesDir, "Apps");
        if (!file.exists()) {
            file.mkdirs();
        }
        Context requireContext2 = requireContext();
        requireContext2.getClass();
        long F = a.a.F(requireContext2, file);
        try {
            j = file.getTotalSpace();
        } catch (SecurityException unused) {
            j = 0;
        }
        if (j > 0) {
            Context requireContext3 = requireContext();
            requireContext3.getClass();
            String H = i5.H(requireContext3, ((long) (F() * 2.25d)) - F);
            long j6 = ((j - F) * 100) / j;
            t4.b bVar = this.f10473b;
            bVar.getClass();
            ((TextView) bVar.M0.f5276l).setTypeface(f4.c.f4883x);
            t4.b bVar2 = this.f10473b;
            bVar2.getClass();
            ((ProgressBar) bVar2.M0.f5279o).setProgress((int) j6);
            t4.b bVar3 = this.f10473b;
            bVar3.getClass();
            ((TextView) bVar3.M0.f5277m).setTypeface(f4.c.f4883x);
            t4.b bVar4 = this.f10473b;
            bVar4.getClass();
            ((TextView) bVar4.M0.f5277m).setText(context.getString(2131952392, H));
            t4.b bVar5 = this.f10473b;
            bVar5.getClass();
            ((TextView) bVar5.M0.f5275b).setTypeface(f4.c.f4882w);
            t4.b bVar6 = this.f10473b;
            bVar6.getClass();
            ((TextView) bVar6.M0.f5275b).setOnClickListener(new p(this, 19));
            t4.b bVar7 = this.f10473b;
            bVar7.getClass();
            ((RelativeLayout) bVar7.M0.f5278n).setVisibility(0);
        }
        if (rVar == null || !rVar.c()) {
            c0(context);
        } else {
            f0();
        }
    }

    public final void h0(Context context) {
        String string;
        t4.b bVar = this.f10473b;
        bVar.getClass();
        bVar.T.f9656o.setVisibility(0);
        t4.b bVar2 = this.f10473b;
        bVar2.getClass();
        bVar2.T.f9654m.setVisibility(8);
        t4.b bVar3 = this.f10473b;
        bVar3.getClass();
        ((RelativeLayout) bVar3.P.v).setVisibility(8);
        t4.b bVar4 = this.f10473b;
        bVar4.getClass();
        bVar4.P.f9807q.setVisibility(8);
        t4.b bVar5 = this.f10473b;
        bVar5.getClass();
        bVar5.P.f9809s.setVisibility(8);
        t4.b bVar6 = this.f10473b;
        bVar6.getClass();
        bVar6.P.f9802l.setVisibility(8);
        t4.b bVar7 = this.f10473b;
        bVar7.getClass();
        ((RelativeLayout) bVar7.P.f9812w).setVisibility(0);
        t4.b bVar8 = this.f10473b;
        bVar8.getClass();
        bVar8.P.f9811u.setVisibility(8);
        t4.b bVar9 = this.f10473b;
        bVar9.getClass();
        bVar9.L.f9875y.setVisibility(8);
        t4.b bVar10 = this.f10473b;
        bVar10.getClass();
        bVar10.L.f9867p.setVisibility(8);
        t4.b bVar11 = this.f10473b;
        bVar11.getClass();
        bVar11.L.f9872u.setVisibility(0);
        t4.b bVar12 = this.f10473b;
        bVar12.getClass();
        ProgressBar progressBar = bVar12.T.f9659r;
        t4.b bVar13 = this.f10473b;
        bVar13.getClass();
        t0.f.s(progressBar, bVar13.T.f9652b);
        r7.o0 o0Var = G().I;
        o0Var.getClass();
        o0Var.g(null, 0);
        x4.j jVar = B().G;
        if (jVar == null || jVar.f11230p != 1) {
            string = context.getString(2131952419);
            string.getClass();
        } else {
            string = context.getString(2131951695);
            string.getClass();
        }
        t4.b bVar14 = this.f10473b;
        bVar14.getClass();
        bVar14.L.f9872u.setText(string);
        t4.b bVar15 = this.f10473b;
        bVar15.getClass();
        bVar15.P.f9810t.setText(string);
        n0(2131361897);
        n0(2131361857);
        String str = B().F;
        if (str == null || str.length() == 0 || !l7.u.m0(requireActivity().getPackageName(), B().F, true)) {
            return;
        }
        t4.b bVar16 = this.f10473b;
        bVar16.getClass();
        bVar16.P.f9804n.setVisibility(8);
        t4.b bVar17 = this.f10473b;
        bVar17.getClass();
        ((RelativeLayout) bVar17.P.f9812w).setVisibility(8);
        t4.b bVar18 = this.f10473b;
        bVar18.getClass();
        ((RelativeLayout) bVar18.P.f9814y).setVisibility(8);
        t4.b bVar19 = this.f10473b;
        bVar19.getClass();
        bVar19.P.f9806p.setVisibility(8);
        t4.b bVar20 = this.f10473b;
        bVar20.getClass();
        bVar20.L.f9872u.setVisibility(8);
        if (728 < B().f11172m) {
            q2 q2Var = (q2) G().D.getValue();
            x4.r a8 = q2Var != null ? q2Var.a(context) : null;
            if (a8 == null && B().J > 0) {
                j5.g l10 = j5.g.D.l(context);
                l10.b();
                x4.r I = l10.I(String.valueOf(B().J));
                l10.c();
                a8 = I;
            }
            if (a8 != null && a8.c()) {
                k0();
                return;
            }
            r7.o0 o0Var2 = G().D;
            String packageName = requireActivity().getPackageName();
            packageName.getClass();
            q2 q2Var2 = new q2(packageName);
            o0Var2.getClass();
            o0Var2.g(null, q2Var2);
            c0(context);
        }
    }

    public final void i0(x4.r rVar) {
        d0(rVar);
        t4.b bVar = this.f10473b;
        bVar.getClass();
        TextView textView = bVar.P.f9809s;
        String string = getString(2131952425);
        string.getClass();
        textView.setText(string);
        z3.K(textView);
        t4.b bVar2 = this.f10473b;
        bVar2.getClass();
        ((RelativeLayout) bVar2.P.v).setBackground(ContextCompat.getDrawable(requireContext(), 2131231156));
        t4.b bVar3 = this.f10473b;
        bVar3.getClass();
        TextView textView2 = bVar3.P.f9811u;
        String string2 = getString(2131952713);
        string2.getClass();
        textView2.setText(string2);
        z3.J(textView2);
        t4.b bVar4 = this.f10473b;
        bVar4.getClass();
        bVar4.L.f9862b.setVisibility(8);
        t4.b bVar5 = this.f10473b;
        bVar5.getClass();
        bVar5.L.f9863l.setVisibility(0);
    }

    public final void j0(q2 q2Var) {
        r0();
        t4.b bVar = this.f10473b;
        bVar.getClass();
        ProgressBar progressBar = bVar.T.f9659r;
        t4.b bVar2 = this.f10473b;
        bVar2.getClass();
        t0.f.I(progressBar, bVar2.T.f9652b);
        r7.o0 o0Var = G().I;
        o0Var.getClass();
        o0Var.g(null, 5);
        Context requireContext = requireContext();
        requireContext.getClass();
        x4.r a8 = q2Var.a(requireContext);
        t4.b bVar3 = this.f10473b;
        if (a8 == null) {
            bVar3.getClass();
            bVar3.T.f9659r.setIndeterminate(true);
            t4.b bVar4 = this.f10473b;
            bVar4.getClass();
            bVar4.L.f9865n.setIndeterminate(true);
            return;
        }
        bVar3.getClass();
        bVar3.T.f9656o.setVisibility(8);
        t4.b bVar5 = this.f10473b;
        bVar5.getClass();
        bVar5.T.f9654m.setVisibility(0);
        t4.b bVar6 = this.f10473b;
        bVar6.getClass();
        ((RelativeLayout) bVar6.P.f9812w).setVisibility(8);
        t4.b bVar7 = this.f10473b;
        bVar7.getClass();
        ((RelativeLayout) bVar7.P.f9812w).setVisibility(8);
        t4.b bVar8 = this.f10473b;
        bVar8.getClass();
        TextView textView = bVar8.P.f9809s;
        String string = getString(2131952425);
        string.getClass();
        textView.setText(string);
        z3.K(textView);
        t4.b bVar9 = this.f10473b;
        bVar9.getClass();
        ((RelativeLayout) bVar9.P.v).setBackground(ContextCompat.getDrawable(requireContext(), 2131231156));
        t4.b bVar10 = this.f10473b;
        bVar10.getClass();
        bVar10.P.f9809s.setOnClickListener(new e(this, 0));
        boolean d10 = a5.b.d();
        t4.b bVar11 = this.f10473b;
        if (d10) {
            bVar11.getClass();
            TextView textView2 = bVar11.P.f9811u;
            String string2 = getString(2131952713);
            string2.getClass();
            textView2.setText(string2);
            z3.J(textView2);
        } else {
            bVar11.getClass();
            TextView textView3 = bVar11.P.f9811u;
            String string3 = getString(2131951655);
            string3.getClass();
            textView3.setText(string3);
            z3.K(textView3);
        }
        int i = a8.i();
        t4.b bVar12 = this.f10473b;
        if (i > 0) {
            bVar12.getClass();
            bVar12.T.f9659r.setIndeterminate(false);
            t4.b bVar13 = this.f10473b;
            bVar13.getClass();
            bVar13.T.f9659r.setProgress(a8.i());
            t4.b bVar14 = this.f10473b;
            bVar14.getClass();
            bVar14.L.f9865n.setIndeterminate(false);
        } else {
            bVar12.getClass();
            bVar12.T.f9659r.setIndeterminate(true);
            t4.b bVar15 = this.f10473b;
            bVar15.getClass();
            bVar15.L.f9865n.setIndeterminate(true);
        }
        t4.b bVar16 = this.f10473b;
        bVar16.getClass();
        TextView textView4 = bVar16.T.C;
        Integer valueOf = Integer.valueOf(a8.i());
        long k5 = a8.k();
        Context requireContext2 = requireContext();
        requireContext2.getClass();
        textView4.setText(getString(2131952467, valueOf, i5.H(requireContext2, k5)));
        t4.b bVar17 = this.f10473b;
        bVar17.getClass();
        bVar17.L.f9862b.setVisibility(0);
        t4.b bVar18 = this.f10473b;
        bVar18.getClass();
        TextView textView5 = bVar18.L.f9873w;
        long k10 = (a8.k() * a8.i()) / 100;
        Context requireContext3 = requireContext();
        requireContext3.getClass();
        textView5.setText(i5.H(requireContext3, k10));
        t4.b bVar19 = this.f10473b;
        bVar19.getClass();
        bVar19.L.f9865n.setProgress(a8.i());
        t4.b bVar20 = this.f10473b;
        bVar20.getClass();
        bVar20.L.f9871t.setVisibility(8);
        t4.b bVar21 = this.f10473b;
        bVar21.getClass();
        bVar21.L.v.setVisibility(0);
        t4.b bVar22 = this.f10473b;
        bVar22.getClass();
        bVar22.L.v.setText(a8.i() + getString(2131952466));
        t4.b bVar23 = this.f10473b;
        bVar23.getClass();
        TextView textView6 = bVar23.L.f9874x;
        long k11 = a8.k();
        Context requireContext4 = requireContext();
        requireContext4.getClass();
        textView6.setText(String.format("/%s", Arrays.copyOf(new Object[]{i5.H(requireContext4, k11)}, 1)));
    }

    public final void k0() {
        q0();
        t4.b bVar = this.f10473b;
        bVar.getClass();
        ProgressBar progressBar = bVar.T.f9659r;
        t4.b bVar2 = this.f10473b;
        bVar2.getClass();
        t0.f.s(progressBar, bVar2.T.f9652b);
        if (UptodownApp.f3291e0 && B().k()) {
            t4.b bVar3 = this.f10473b;
            bVar3.getClass();
            bVar3.P.f9802l.setVisibility(0);
            t4.b bVar4 = this.f10473b;
            bVar4.getClass();
            bVar4.P.f9803m.setVisibility(0);
        } else {
            t4.b bVar5 = this.f10473b;
            bVar5.getClass();
            bVar5.P.f9802l.setVisibility(8);
            t4.b bVar6 = this.f10473b;
            bVar6.getClass();
            bVar6.P.f9803m.setVisibility(8);
        }
        r7.o0 o0Var = G().I;
        o0Var.getClass();
        o0Var.g(null, 2);
        t4.b bVar7 = this.f10473b;
        bVar7.getClass();
        TextView textView = bVar7.P.f9809s;
        String string = getString(2131952714);
        string.getClass();
        textView.setText(string);
        z3.J(textView);
        t4.b bVar8 = this.f10473b;
        bVar8.getClass();
        ((RelativeLayout) bVar8.P.v).setBackground(ContextCompat.getDrawable(requireContext(), 2131231146));
        t4.b bVar9 = this.f10473b;
        bVar9.getClass();
        bVar9.P.f9809s.setOnClickListener(new e(this, 28));
        t4.b bVar10 = this.f10473b;
        bVar10.getClass();
        bVar10.L.f9875y.setText(getString(2131952714));
        t4.b bVar11 = this.f10473b;
        bVar11.getClass();
        TextView textView2 = bVar11.L.f9875y;
        String string2 = getString(2131952714);
        string2.getClass();
        textView2.setText(string2);
        z3.J(textView2);
        n0(2131361857);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l0(android.graphics.Rect r8) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.f0.l0(android.graphics.Rect):void");
    }

    public final void m0(AlertDialog.Builder builder) {
        FragmentActivity activity = getActivity();
        activity.getClass();
        if (((c4.k0) activity).F != null) {
            FragmentActivity activity2 = getActivity();
            activity2.getClass();
            AlertDialog alertDialog = ((c4.k0) activity2).F;
            alertDialog.getClass();
            if (alertDialog.isShowing()) {
                return;
            }
        }
        FragmentActivity activity3 = getActivity();
        activity3.getClass();
        ((c4.k0) activity3).F = builder.create();
        if (getActivity() == null || !isAdded() || requireActivity().isFinishing()) {
            return;
        }
        FragmentActivity activity4 = getActivity();
        activity4.getClass();
        if (((c4.k0) activity4).F != null) {
            FragmentActivity activity5 = getActivity();
            activity5.getClass();
            AlertDialog alertDialog2 = ((c4.k0) activity5).F;
            alertDialog2.getClass();
            Window window = alertDialog2.getWindow();
            if (window != null) {
                a4.x.y(window, 0);
            }
            FragmentActivity activity6 = getActivity();
            activity6.getClass();
            AlertDialog alertDialog3 = ((c4.k0) activity6).F;
            alertDialog3.getClass();
            alertDialog3.show();
        }
    }

    public final void n() {
        if (getContext() != null) {
            FragmentActivity activity = getActivity();
            activity.getClass();
            if (((c4.k0) activity).T()) {
                Context requireContext = requireContext();
                requireContext.getClass();
                if (u2.h(requireContext) == null) {
                    R();
                    return;
                }
                if (B().C0 == 1) {
                    v0 G = G();
                    Context requireContext2 = requireContext();
                    requireContext2.getClass();
                    long j = B().f11158a;
                    G.getClass();
                    o7.a0 viewModelScope = ViewModelKt.getViewModelScope(G);
                    v7.e eVar = o7.m0.f8288a;
                    o7.c0.s(viewModelScope, v7.d.f10884a, null, new r0(1, j, requireContext2, null, G), 2);
                } else {
                    v0 G2 = G();
                    Context requireContext3 = requireContext();
                    requireContext3.getClass();
                    long j6 = B().f11158a;
                    G2.getClass();
                    o7.a0 viewModelScope2 = ViewModelKt.getViewModelScope(G2);
                    v7.e eVar2 = o7.m0.f8288a;
                    o7.c0.s(viewModelScope2, v7.d.f10884a, null, new r0(0, j6, requireContext3, null, G2), 2);
                }
                if (getActivity() instanceof AppDetailActivity) {
                    FragmentActivity activity2 = getActivity();
                    activity2.getClass();
                    r7.o0 o0Var = ((AppDetailActivity) activity2).Q;
                    Boolean bool = Boolean.TRUE;
                    o0Var.getClass();
                    o0Var.g(null, bool);
                }
            }
        }
    }

    public final void n0(int i) {
        Menu menu = this.f10479q;
        if (menu != null) {
            menu.getClass();
            menu.findItem(i).setVisible(true);
        }
    }

    public final void o() {
        if (getContext() != null) {
            FragmentActivity activity = getActivity();
            activity.getClass();
            if (((c4.k0) activity).T()) {
                Context requireContext = requireContext();
                requireContext.getClass();
                if (u2.h(requireContext) == null) {
                    R();
                    return;
                }
                if (B().B0 == 1) {
                    v0 G = G();
                    Context requireContext2 = requireContext();
                    requireContext2.getClass();
                    long j = B().f11158a;
                    G.getClass();
                    o7.a0 viewModelScope = ViewModelKt.getViewModelScope(G);
                    v7.e eVar = o7.m0.f8288a;
                    o7.c0.s(viewModelScope, v7.d.f10884a, null, new r0(3, j, requireContext2, null, G), 2);
                } else {
                    v0 G2 = G();
                    Context requireContext3 = requireContext();
                    requireContext3.getClass();
                    long j6 = B().f11158a;
                    G2.getClass();
                    o7.a0 viewModelScope2 = ViewModelKt.getViewModelScope(G2);
                    v7.e eVar2 = o7.m0.f8288a;
                    o7.c0.s(viewModelScope2, v7.d.f10884a, null, new r0(2, j6, requireContext3, null, G2), 2);
                }
                if (getActivity() instanceof AppDetailActivity) {
                    FragmentActivity activity2 = getActivity();
                    activity2.getClass();
                    r7.o0 o0Var = ((AppDetailActivity) activity2).P;
                    Boolean bool = Boolean.TRUE;
                    o0Var.getClass();
                    o0Var.g(null, bool);
                }
            }
        }
    }

    public final void o0(ArrayList arrayList) {
        FragmentActivity activity = getActivity();
        activity.getClass();
        if (((c4.k0) activity).T()) {
            final int i = 0;
            View inflate = getLayoutInflater().inflate(2131558800, (ViewGroup) null, false);
            int i6 = 2131362328;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362328);
            if (imageView != null) {
                i6 = 2131363249;
                if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131363249)) != null) {
                    i6 = 2131363305;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363305);
                    if (relativeLayout != null) {
                        i6 = 2131363345;
                        MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) ViewBindings.findChildViewById(inflate, 2131363345);
                        if (maxHeightRecyclerView != null) {
                            i6 = 2131364223;
                            TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131364223);
                            if (textView != null) {
                                i6 = 2131364411;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364411);
                                if (textView2 != null) {
                                    i6 = 2131364629;
                                    View findChildViewById = ViewBindings.findChildViewById(inflate, 2131364629);
                                    if (findChildViewById != null) {
                                        RelativeLayout relativeLayout2 = (RelativeLayout) inflate;
                                        final t4.n0 n0Var = new t4.n0(relativeLayout2, imageView, relativeLayout, maxHeightRecyclerView, textView, textView2, findChildViewById);
                                        t4.b bVar = this.f10473b;
                                        bVar.getClass();
                                        bVar.f9616o.addView(relativeLayout2);
                                        t4.b bVar2 = this.f10473b;
                                        bVar2.getClass();
                                        bVar2.f9616o.setVisibility(0);
                                        textView2.setTypeface(f4.c.f4882w);
                                        textView.setTypeface(f4.c.f4882w);
                                        kotlin.jvm.internal.u uVar = new kotlin.jvm.internal.u();
                                        ArrayList arrayList2 = new ArrayList();
                                        e4.f1 f1Var = new e4.f1(arrayList, new t4.n0(arrayList, arrayList2, uVar));
                                        boolean z9 = true;
                                        z9 = true;
                                        maxHeightRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
                                        maxHeightRecyclerView.setItemAnimator(null);
                                        maxHeightRecyclerView.setAdapter(f1Var);
                                        textView.setOnClickListener(new g4.f0(arrayList, this, arrayList2, uVar, n0Var));
                                        imageView.setOnClickListener(new View.OnClickListener(this) { // from class: u4.r

                                            /* renamed from: b, reason: collision with root package name */
                                            public final /* synthetic */ f0 f10584b;

                                            {
                                                this.f10584b = this;
                                            }

                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view) {
                                                switch (i) {
                                                    case 0:
                                                        this.f10584b.r(n0Var);
                                                        break;
                                                    default:
                                                        this.f10584b.r(n0Var);
                                                        break;
                                                }
                                            }
                                        });
                                        final int i10 = z9 ? 1 : 0;
                                        findChildViewById.setOnClickListener(new View.OnClickListener(this) { // from class: u4.r

                                            /* renamed from: b, reason: collision with root package name */
                                            public final /* synthetic */ f0 f10584b;

                                            {
                                                this.f10584b = this;
                                            }

                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view) {
                                                switch (i10) {
                                                    case 0:
                                                        this.f10584b.r(n0Var);
                                                        break;
                                                    default:
                                                        this.f10584b.r(n0Var);
                                                        break;
                                                }
                                            }
                                        });
                                        FragmentActivity requireActivity = requireActivity();
                                        requireActivity.getClass();
                                        new v4(requireActivity, 1).g(findChildViewById, 1.0f);
                                        FragmentActivity requireActivity2 = requireActivity();
                                        requireActivity2.getClass();
                                        float f = UptodownApp.I;
                                        try {
                                            SharedPreferences sharedPreferences = requireActivity2.getSharedPreferences("SettingsPreferences", 0);
                                            if (sharedPreferences.contains("animations")) {
                                                z9 = sharedPreferences.getBoolean("animations", true);
                                            }
                                        } catch (Exception unused) {
                                        }
                                        if (!z9) {
                                            relativeLayout.setVisibility(0);
                                            return;
                                        }
                                        float f10 = UptodownApp.I;
                                        relativeLayout.startAnimation(AnimationUtils.loadAnimation(requireActivity2, 2130772030));
                                        relativeLayout.setVisibility(0);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i6)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            super.onCreate(r9)
            u4.v0 r9 = r8.G()
            r7.o0 r9 = r9.N
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r9.getClass()
            r5 = 0
            r9.g(r5, r0)
            android.support.v4.media.g r9 = new android.support.v4.media.g
            androidx.fragment.app.FragmentActivity r0 = r8.requireActivity()
            r1 = 20
            r9.<init>(r0, r1)
            r8.f10476n = r9
            v3.e r9 = com.uptodown.UptodownApp.Z
            if (r9 == 0) goto L28
            z3.g r9 = (z3.g) r9
            r9.e()
        L28:
            v3.e r9 = com.uptodown.UptodownApp.a0
            if (r9 == 0) goto L31
            z3.g r9 = (z3.g) r9
            r9.e()
        L31:
            android.os.Bundle r9 = r8.getArguments()
            if (r9 == 0) goto L6b
            u4.v0 r0 = r8.G()
            r7.o0 r0 = r0.G
            java.lang.String r1 = "appId"
            long r1 = r9.getLong(r1)
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r0.getClass()
            r0.g(r5, r1)
            java.lang.String r0 = "appInfo"
            boolean r1 = r9.containsKey(r0)
            if (r1 == 0) goto L6b
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 34
            if (r1 < r2) goto L64
            java.lang.Class<x4.g> r1 = x4.g.class
            java.lang.Object r9 = r9.getParcelable(r0, r1)
            android.os.Parcelable r9 = (android.os.Parcelable) r9
            goto L68
        L64:
            android.os.Parcelable r9 = r9.getParcelable(r0)
        L68:
            x4.g r9 = (x4.g) r9
            goto L6c
        L6b:
            r9 = r5
        L6c:
            r0 = 2
            if (r9 == 0) goto L96
            r8.f10472a = r9
            u4.v0 r4 = r8.G()
            android.content.Context r2 = r8.requireContext()
            r2.getClass()
            x4.g r3 = r8.B()
            r4.getClass()
            o7.a0 r9 = androidx.lifecycle.ViewModelKt.getViewModelScope(r4)
            v7.e r1 = o7.m0.f8288a
            v7.d r7 = v7.d.f10884a
            b5.l r1 = new b5.l
            r6 = 22
            r1.<init>(r2, r3, r4, r5, r6)
            o7.c0.s(r9, r7, r5, r1, r0)
            goto Lc5
        L96:
            androidx.fragment.app.FragmentActivity r9 = r8.getActivity()
            if (r9 == 0) goto Lc5
            androidx.fragment.app.FragmentActivity r9 = r8.getActivity()
            boolean r9 = r9 instanceof com.uptodown.activities.MainActivity
            if (r9 == 0) goto Lb1
            androidx.fragment.app.FragmentActivity r9 = r8.getActivity()
            r9.getClass()
            com.uptodown.activities.MainActivity r9 = (com.uptodown.activities.MainActivity) r9
            r9.h1()
            goto Lc5
        Lb1:
            androidx.fragment.app.FragmentActivity r9 = r8.getActivity()
            boolean r9 = r9 instanceof com.uptodown.activities.AppDetailActivity
            if (r9 == 0) goto Lc5
            androidx.fragment.app.FragmentActivity r9 = r8.getActivity()
            r9.getClass()
            com.uptodown.activities.AppDetailActivity r9 = (com.uptodown.activities.AppDetailActivity) r9
            r9.finish()
        Lc5:
            x4.g r9 = r8.B()
            boolean r9 = r9.l()
            if (r9 == 0) goto Le1
            androidx.lifecycle.LifecycleCoroutineScope r9 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r8)
            v7.e r1 = o7.m0.f8288a
            p7.c r1 = t7.n.f10348a
            u4.w r2 = new u4.w
            r3 = 10
            r2.<init>(r8, r5, r3)
            o7.c0.s(r9, r1, r5, r2, r0)
        Le1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.f0.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        layoutInflater.getClass();
        if (getActivity() == null) {
            return super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        View inflate = layoutInflater.inflate(2131558430, viewGroup, false);
        int i = 2131361920;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(inflate, 2131361920);
        if (appBarLayout != null) {
            i = 2131361994;
            BlurView blurView = (BlurView) ViewBindings.findChildViewById(inflate, 2131361994);
            if (blurView != null) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
                i = 2131362065;
                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) ViewBindings.findChildViewById(inflate, 2131362065);
                if (collapsingToolbarLayout != null) {
                    i = 2131362182;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(inflate, 2131362182);
                    if (frameLayout != null) {
                        i = 2131362188;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(inflate, 2131362188);
                        if (frameLayout2 != null) {
                            i = 2131362287;
                            if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362287)) != null) {
                                i = 2131362349;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362349);
                                if (imageView != null) {
                                    i = 2131362436;
                                    if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362436)) != null) {
                                        i = 2131362437;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362437);
                                        if (imageView2 != null) {
                                            i = 2131362456;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362456);
                                            if (imageView3 != null) {
                                                i = 2131362463;
                                                if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362463)) != null) {
                                                    i = 2131362557;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362557);
                                                    if (imageView4 != null) {
                                                        i = 2131362618;
                                                        if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362618)) != null) {
                                                            i = 2131362627;
                                                            view = null;
                                                            View findChildViewById = ViewBindings.findChildViewById(inflate, 2131362627);
                                                            if (findChildViewById != null) {
                                                                LinearLayout linearLayout = (LinearLayout) findChildViewById;
                                                                TextView textView = (TextView) ViewBindings.findChildViewById(findChildViewById, 2131363866);
                                                                if (textView == null) {
                                                                    com.google.gson.internal.a.i("Missing required view with ID: ".concat(findChildViewById.getResources().getResourceName(2131363866)));
                                                                    return null;
                                                                }
                                                                t4.q qVar = new t4.q(linearLayout, textView, 0);
                                                                i = 2131362632;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362632);
                                                                if (linearLayout2 != null) {
                                                                    i = 2131362644;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362644);
                                                                    if (linearLayout3 != null) {
                                                                        i = 2131362655;
                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362655);
                                                                        if (linearLayout4 != null) {
                                                                            i = 2131362656;
                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362656);
                                                                            if (linearLayout5 != null) {
                                                                                i = 2131362686;
                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362686);
                                                                                if (linearLayout6 != null) {
                                                                                    i = 2131362687;
                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362687);
                                                                                    if (linearLayout7 != null) {
                                                                                        i = 2131362688;
                                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362688);
                                                                                        if (linearLayout8 != null) {
                                                                                            i = 2131362696;
                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362696);
                                                                                            if (linearLayout9 != null) {
                                                                                                i = 2131362725;
                                                                                                LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362725);
                                                                                                if (linearLayout10 != null) {
                                                                                                    i = 2131362726;
                                                                                                    View findChildViewById2 = ViewBindings.findChildViewById(inflate, 2131362726);
                                                                                                    if (findChildViewById2 != null) {
                                                                                                        LinearLayout linearLayout11 = (LinearLayout) findChildViewById2;
                                                                                                        int i6 = 2131362727;
                                                                                                        if (((LinearLayout) ViewBindings.findChildViewById(findChildViewById2, 2131362727)) != null) {
                                                                                                            i6 = 2131363457;
                                                                                                            View findChildViewById3 = ViewBindings.findChildViewById(findChildViewById2, 2131363457);
                                                                                                            if (findChildViewById3 != null) {
                                                                                                                i6 = 2131363458;
                                                                                                                View findChildViewById4 = ViewBindings.findChildViewById(findChildViewById2, 2131363458);
                                                                                                                if (findChildViewById4 != null) {
                                                                                                                    i6 = 2131363459;
                                                                                                                    View findChildViewById5 = ViewBindings.findChildViewById(findChildViewById2, 2131363459);
                                                                                                                    if (findChildViewById5 != null) {
                                                                                                                        i6 = 2131363460;
                                                                                                                        View findChildViewById6 = ViewBindings.findChildViewById(findChildViewById2, 2131363460);
                                                                                                                        if (findChildViewById6 != null) {
                                                                                                                            i6 = 2131363461;
                                                                                                                            View findChildViewById7 = ViewBindings.findChildViewById(findChildViewById2, 2131363461);
                                                                                                                            if (findChildViewById7 != null) {
                                                                                                                                i6 = 2131363462;
                                                                                                                                View findChildViewById8 = ViewBindings.findChildViewById(findChildViewById2, 2131363462);
                                                                                                                                if (findChildViewById8 != null) {
                                                                                                                                    i6 = 2131363710;
                                                                                                                                    if (((TextView) ViewBindings.findChildViewById(findChildViewById2, 2131363710)) != null) {
                                                                                                                                        i6 = 2131363711;
                                                                                                                                        if (((TextView) ViewBindings.findChildViewById(findChildViewById2, 2131363711)) != null) {
                                                                                                                                            i6 = 2131363712;
                                                                                                                                            if (((TextView) ViewBindings.findChildViewById(findChildViewById2, 2131363712)) != null) {
                                                                                                                                                i6 = 2131363713;
                                                                                                                                                if (((TextView) ViewBindings.findChildViewById(findChildViewById2, 2131363713)) != null) {
                                                                                                                                                    i6 = 2131363714;
                                                                                                                                                    if (((TextView) ViewBindings.findChildViewById(findChildViewById2, 2131363714)) != null) {
                                                                                                                                                        i6 = 2131364243;
                                                                                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(findChildViewById2, 2131364243);
                                                                                                                                                        if (textView2 != null) {
                                                                                                                                                            i6 = 2131364245;
                                                                                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(findChildViewById2, 2131364245);
                                                                                                                                                            if (textView3 != null) {
                                                                                                                                                                i6 = 2131364251;
                                                                                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(findChildViewById2, 2131364251);
                                                                                                                                                                if (textView4 != null) {
                                                                                                                                                                    r.h hVar = new r.h(linearLayout11, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7, findChildViewById8, textView2, textView3, textView4, 1);
                                                                                                                                                                    i = 2131362741;
                                                                                                                                                                    LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362741);
                                                                                                                                                                    if (linearLayout12 != null) {
                                                                                                                                                                        i = 2131362766;
                                                                                                                                                                        LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362766);
                                                                                                                                                                        if (linearLayout13 != null) {
                                                                                                                                                                            i = 2131362767;
                                                                                                                                                                            LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362767);
                                                                                                                                                                            if (linearLayout14 != null) {
                                                                                                                                                                                i = 2131362769;
                                                                                                                                                                                View findChildViewById9 = ViewBindings.findChildViewById(inflate, 2131362769);
                                                                                                                                                                                if (findChildViewById9 != null) {
                                                                                                                                                                                    int i10 = 2131362488;
                                                                                                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(findChildViewById9, 2131362488);
                                                                                                                                                                                    if (imageView5 != null) {
                                                                                                                                                                                        i10 = 2131362494;
                                                                                                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(findChildViewById9, 2131362494);
                                                                                                                                                                                        if (imageView6 != null) {
                                                                                                                                                                                            i10 = 2131362500;
                                                                                                                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(findChildViewById9, 2131362500);
                                                                                                                                                                                            if (imageView7 != null) {
                                                                                                                                                                                                i10 = 2131362506;
                                                                                                                                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(findChildViewById9, 2131362506);
                                                                                                                                                                                                if (imageView8 != null) {
                                                                                                                                                                                                    i10 = 2131362512;
                                                                                                                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(findChildViewById9, 2131362512);
                                                                                                                                                                                                    if (imageView9 != null) {
                                                                                                                                                                                                        i10 = 2131362542;
                                                                                                                                                                                                        ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(findChildViewById9, 2131362542);
                                                                                                                                                                                                        if (imageView10 != null) {
                                                                                                                                                                                                            i10 = 2131362784;
                                                                                                                                                                                                            LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(findChildViewById9, 2131362784);
                                                                                                                                                                                                            if (linearLayout15 != null) {
                                                                                                                                                                                                                i10 = 2131364616;
                                                                                                                                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(findChildViewById9, 2131364616);
                                                                                                                                                                                                                if (textView5 != null) {
                                                                                                                                                                                                                    i10 = 2131364617;
                                                                                                                                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(findChildViewById9, 2131364617);
                                                                                                                                                                                                                    if (textView6 != null) {
                                                                                                                                                                                                                        r.h hVar2 = new r.h((LinearLayout) findChildViewById9, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, linearLayout15, textView5, textView6, 3);
                                                                                                                                                                                                                        i = 2131363119;
                                                                                                                                                                                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363119);
                                                                                                                                                                                                                        if (relativeLayout != null) {
                                                                                                                                                                                                                            i = 2131363126;
                                                                                                                                                                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363126);
                                                                                                                                                                                                                            if (relativeLayout2 != null) {
                                                                                                                                                                                                                                i = 2131363127;
                                                                                                                                                                                                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363127);
                                                                                                                                                                                                                                if (relativeLayout3 != null) {
                                                                                                                                                                                                                                    i = 2131363130;
                                                                                                                                                                                                                                    View findChildViewById10 = ViewBindings.findChildViewById(inflate, 2131363130);
                                                                                                                                                                                                                                    if (findChildViewById10 != null) {
                                                                                                                                                                                                                                        int i11 = 2131362316;
                                                                                                                                                                                                                                        ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(findChildViewById10, 2131362316);
                                                                                                                                                                                                                                        if (imageView11 != null) {
                                                                                                                                                                                                                                            i11 = 2131362339;
                                                                                                                                                                                                                                            if (((ImageView) ViewBindings.findChildViewById(findChildViewById10, 2131362339)) != null) {
                                                                                                                                                                                                                                                int i12 = 2131362465;
                                                                                                                                                                                                                                                ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(findChildViewById10, 2131362465);
                                                                                                                                                                                                                                                if (imageView12 != null) {
                                                                                                                                                                                                                                                    i12 = 2131362513;
                                                                                                                                                                                                                                                    ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(findChildViewById10, 2131362513);
                                                                                                                                                                                                                                                    if (imageView13 != null) {
                                                                                                                                                                                                                                                        i12 = 2131362997;
                                                                                                                                                                                                                                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(findChildViewById10, 2131362997);
                                                                                                                                                                                                                                                        if (progressBar != null) {
                                                                                                                                                                                                                                                            int i13 = 2131363160;
                                                                                                                                                                                                                                                            LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(findChildViewById10, 2131363160);
                                                                                                                                                                                                                                                            if (linearLayout16 != null) {
                                                                                                                                                                                                                                                                i12 = 2131363265;
                                                                                                                                                                                                                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(findChildViewById10, 2131363265);
                                                                                                                                                                                                                                                                if (relativeLayout4 != null) {
                                                                                                                                                                                                                                                                    i13 = 2131363266;
                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(findChildViewById10, 2131363266);
                                                                                                                                                                                                                                                                    if (relativeLayout5 != null) {
                                                                                                                                                                                                                                                                        i12 = 2131363268;
                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(findChildViewById10, 2131363268);
                                                                                                                                                                                                                                                                        if (relativeLayout6 != null) {
                                                                                                                                                                                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(findChildViewById10, 2131363753);
                                                                                                                                                                                                                                                                            if (textView7 != null) {
                                                                                                                                                                                                                                                                                i12 = 2131363854;
                                                                                                                                                                                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(findChildViewById10, 2131363854);
                                                                                                                                                                                                                                                                                if (textView8 != null) {
                                                                                                                                                                                                                                                                                    i12 = 2131364123;
                                                                                                                                                                                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(findChildViewById10, 2131364123);
                                                                                                                                                                                                                                                                                    if (textView9 != null) {
                                                                                                                                                                                                                                                                                        i12 = 2131364161;
                                                                                                                                                                                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(findChildViewById10, 2131364161);
                                                                                                                                                                                                                                                                                        if (textView10 != null) {
                                                                                                                                                                                                                                                                                            i12 = 2131364303;
                                                                                                                                                                                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(findChildViewById10, 2131364303);
                                                                                                                                                                                                                                                                                            if (textView11 != null) {
                                                                                                                                                                                                                                                                                                i12 = 2131364313;
                                                                                                                                                                                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(findChildViewById10, 2131364313);
                                                                                                                                                                                                                                                                                                if (textView12 != null) {
                                                                                                                                                                                                                                                                                                    i12 = 2131364334;
                                                                                                                                                                                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(findChildViewById10, 2131364334);
                                                                                                                                                                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                                                                                                                                                                        i12 = 2131364339;
                                                                                                                                                                                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(findChildViewById10, 2131364339);
                                                                                                                                                                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                                                                                                                                                                            t4.i iVar = new t4.i((RelativeLayout) findChildViewById10, imageView11, imageView12, imageView13, progressBar, linearLayout16, relativeLayout4, relativeLayout5, relativeLayout6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
                                                                                                                                                                                                                                                                                                            int i14 = 2131363142;
                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363142);
                                                                                                                                                                                                                                                                                                            if (relativeLayout7 != null) {
                                                                                                                                                                                                                                                                                                                i14 = 2131363144;
                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363144);
                                                                                                                                                                                                                                                                                                                if (relativeLayout8 != null) {
                                                                                                                                                                                                                                                                                                                    i14 = 2131363149;
                                                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363149);
                                                                                                                                                                                                                                                                                                                    if (relativeLayout9 != null) {
                                                                                                                                                                                                                                                                                                                        i14 = 2131363166;
                                                                                                                                                                                                                                                                                                                        View findChildViewById11 = ViewBindings.findChildViewById(inflate, 2131363166);
                                                                                                                                                                                                                                                                                                                        if (findChildViewById11 != null) {
                                                                                                                                                                                                                                                                                                                            if (((ImageView) ViewBindings.findChildViewById(findChildViewById11, 2131362339)) != null) {
                                                                                                                                                                                                                                                                                                                                i11 = 2131362346;
                                                                                                                                                                                                                                                                                                                                ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(findChildViewById11, 2131362346);
                                                                                                                                                                                                                                                                                                                                if (imageView14 != null) {
                                                                                                                                                                                                                                                                                                                                    i11 = 2131362440;
                                                                                                                                                                                                                                                                                                                                    ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(findChildViewById11, 2131362440);
                                                                                                                                                                                                                                                                                                                                    if (imageView15 != null) {
                                                                                                                                                                                                                                                                                                                                        i11 = 2131362532;
                                                                                                                                                                                                                                                                                                                                        ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(findChildViewById11, 2131362532);
                                                                                                                                                                                                                                                                                                                                        if (imageView16 != null) {
                                                                                                                                                                                                                                                                                                                                            i11 = 2131362548;
                                                                                                                                                                                                                                                                                                                                            ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(findChildViewById11, 2131362548);
                                                                                                                                                                                                                                                                                                                                            if (imageView17 != null) {
                                                                                                                                                                                                                                                                                                                                                i11 = 2131362555;
                                                                                                                                                                                                                                                                                                                                                ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(findChildViewById11, 2131362555);
                                                                                                                                                                                                                                                                                                                                                if (imageView18 != null) {
                                                                                                                                                                                                                                                                                                                                                    i11 = 2131363024;
                                                                                                                                                                                                                                                                                                                                                    ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(findChildViewById11, 2131363024);
                                                                                                                                                                                                                                                                                                                                                    if (progressBar2 != null) {
                                                                                                                                                                                                                                                                                                                                                        int i15 = 2131363160;
                                                                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout17 = (LinearLayout) ViewBindings.findChildViewById(findChildViewById11, 2131363160);
                                                                                                                                                                                                                                                                                                                                                        if (linearLayout17 != null) {
                                                                                                                                                                                                                                                                                                                                                            i11 = 2131363167;
                                                                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(findChildViewById11, 2131363167);
                                                                                                                                                                                                                                                                                                                                                            if (relativeLayout10 != null) {
                                                                                                                                                                                                                                                                                                                                                                i11 = 2131363237;
                                                                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(findChildViewById11, 2131363237);
                                                                                                                                                                                                                                                                                                                                                                if (relativeLayout11 != null) {
                                                                                                                                                                                                                                                                                                                                                                    i15 = 2131363266;
                                                                                                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(findChildViewById11, 2131363266);
                                                                                                                                                                                                                                                                                                                                                                    if (relativeLayout12 != null) {
                                                                                                                                                                                                                                                                                                                                                                        i11 = 2131363297;
                                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(findChildViewById11, 2131363297);
                                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout13 != null) {
                                                                                                                                                                                                                                                                                                                                                                            i15 = 2131363753;
                                                                                                                                                                                                                                                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(findChildViewById11, 2131363753);
                                                                                                                                                                                                                                                                                                                                                                            if (textView15 != null) {
                                                                                                                                                                                                                                                                                                                                                                                i11 = 2131363834;
                                                                                                                                                                                                                                                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(findChildViewById11, 2131363834);
                                                                                                                                                                                                                                                                                                                                                                                if (textView16 != null) {
                                                                                                                                                                                                                                                                                                                                                                                    i11 = 2131364118;
                                                                                                                                                                                                                                                                                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(findChildViewById11, 2131364118);
                                                                                                                                                                                                                                                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                                                                                                                                                                                                                                                        i11 = 2131364150;
                                                                                                                                                                                                                                                                                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(findChildViewById11, 2131364150);
                                                                                                                                                                                                                                                                                                                                                                                        if (textView18 != null) {
                                                                                                                                                                                                                                                                                                                                                                                            t4.g gVar = new t4.g((RelativeLayout) findChildViewById11, imageView14, imageView15, imageView16, imageView17, imageView18, progressBar2, linearLayout17, relativeLayout10, relativeLayout11, relativeLayout12, relativeLayout13, textView15, textView16, textView17, textView18);
                                                                                                                                                                                                                                                                                                                                                                                            i = 2131363172;
                                                                                                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363172);
                                                                                                                                                                                                                                                                                                                                                                                            if (relativeLayout14 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                i = 2131363187;
                                                                                                                                                                                                                                                                                                                                                                                                View findChildViewById12 = ViewBindings.findChildViewById(inflate, 2131363187);
                                                                                                                                                                                                                                                                                                                                                                                                if (findChildViewById12 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    FullWidthImageView fullWidthImageView = (FullWidthImageView) ViewBindings.findChildViewById(findChildViewById12, 2131362354);
                                                                                                                                                                                                                                                                                                                                                                                                    if (fullWidthImageView == null) {
                                                                                                                                                                                                                                                                                                                                                                                                        com.google.gson.internal.a.i("Missing required view with ID: ".concat(findChildViewById12.getResources().getResourceName(2131362354)));
                                                                                                                                                                                                                                                                                                                                                                                                        return null;
                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                    m8.q qVar2 = new m8.q(9, (RelativeLayout) findChildViewById12, fullWidthImageView);
                                                                                                                                                                                                                                                                                                                                                                                                    i14 = 2131363205;
                                                                                                                                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363205);
                                                                                                                                                                                                                                                                                                                                                                                                    if (relativeLayout15 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        i14 = 2131363228;
                                                                                                                                                                                                                                                                                                                                                                                                        View findChildViewById13 = ViewBindings.findChildViewById(inflate, 2131363228);
                                                                                                                                                                                                                                                                                                                                                                                                        if (findChildViewById13 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                            int i16 = 2131362414;
                                                                                                                                                                                                                                                                                                                                                                                                            ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(findChildViewById13, 2131362414);
                                                                                                                                                                                                                                                                                                                                                                                                            if (imageView19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                i16 = 2131362619;
                                                                                                                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout18 = (LinearLayout) ViewBindings.findChildViewById(findChildViewById13, 2131362619);
                                                                                                                                                                                                                                                                                                                                                                                                                if (linearLayout18 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                    i16 = 2131362648;
                                                                                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout19 = (LinearLayout) ViewBindings.findChildViewById(findChildViewById13, 2131362648);
                                                                                                                                                                                                                                                                                                                                                                                                                    if (linearLayout19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                        i16 = 2131362649;
                                                                                                                                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout20 = (LinearLayout) ViewBindings.findChildViewById(findChildViewById13, 2131362649);
                                                                                                                                                                                                                                                                                                                                                                                                                        if (linearLayout20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                            i16 = 2131362667;
                                                                                                                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout21 = (LinearLayout) ViewBindings.findChildViewById(findChildViewById13, 2131362667);
                                                                                                                                                                                                                                                                                                                                                                                                                            if (linearLayout21 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                i16 = 2131362677;
                                                                                                                                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout22 = (LinearLayout) ViewBindings.findChildViewById(findChildViewById13, 2131362677);
                                                                                                                                                                                                                                                                                                                                                                                                                                if (linearLayout22 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                    i16 = 2131362772;
                                                                                                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout23 = (LinearLayout) ViewBindings.findChildViewById(findChildViewById13, 2131362772);
                                                                                                                                                                                                                                                                                                                                                                                                                                    if (linearLayout23 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                        i16 = 2131363005;
                                                                                                                                                                                                                                                                                                                                                                                                                                        ProgressBar progressBar3 = (ProgressBar) ViewBindings.findChildViewById(findChildViewById13, 2131363005);
                                                                                                                                                                                                                                                                                                                                                                                                                                        if (progressBar3 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                            i16 = 2131363184;
                                                                                                                                                                                                                                                                                                                                                                                                                                            if (((RelativeLayout) ViewBindings.findChildViewById(findChildViewById13, 2131363184)) != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                i16 = 2131363216;
                                                                                                                                                                                                                                                                                                                                                                                                                                                if (((RelativeLayout) ViewBindings.findChildViewById(findChildViewById13, 2131363216)) != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                    i16 = 2131363288;
                                                                                                                                                                                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout16 = (RelativeLayout) ViewBindings.findChildViewById(findChildViewById13, 2131363288);
                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (relativeLayout16 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                        i16 = 2131363660;
                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(findChildViewById13, 2131363660);
                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                            i16 = 2131363665;
                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(findChildViewById13, 2131363665);
                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                i16 = 2131363676;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView21 = (TextView) ViewBindings.findChildViewById(findChildViewById13, 2131363676);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView21 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i16 = 2131363839;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView22 = (TextView) ViewBindings.findChildViewById(findChildViewById13, 2131363839);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView22 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i16 = 2131363842;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView23 = (TextView) ViewBindings.findChildViewById(findChildViewById13, 2131363842);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView23 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i16 = 2131363945;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView24 = (TextView) ViewBindings.findChildViewById(findChildViewById13, 2131363945);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView24 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i16 = 2131363948;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView25 = (TextView) ViewBindings.findChildViewById(findChildViewById13, 2131363948);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView25 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i16 = 2131364027;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView26 = (TextView) ViewBindings.findChildViewById(findChildViewById13, 2131364027);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView26 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i16 = 2131364167;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView27 = (TextView) ViewBindings.findChildViewById(findChildViewById13, 2131364167);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView27 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i16 = 2131364186;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView28 = (TextView) ViewBindings.findChildViewById(findChildViewById13, 2131364186);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView28 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i16 = 2131364246;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView29 = (TextView) ViewBindings.findChildViewById(findChildViewById13, 2131364246);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView29 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i16 = 2131364536;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView30 = (TextView) ViewBindings.findChildViewById(findChildViewById13, 2131364536);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView30 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i16 = 2131364541;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView31 = (TextView) ViewBindings.findChildViewById(findChildViewById13, 2131364541);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView31 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i16 = 2131364558;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView32 = (TextView) ViewBindings.findChildViewById(findChildViewById13, 2131364558);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView32 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i16 = 2131364641;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                View findChildViewById14 = ViewBindings.findChildViewById(findChildViewById13, 2131364641);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (findChildViewById14 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i16 = 2131364642;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    View findChildViewById15 = ViewBindings.findChildViewById(findChildViewById13, 2131364642);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (findChildViewById15 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        t4.c cVar = new t4.c((RelativeLayout) findChildViewById13, imageView19, linearLayout18, linearLayout19, linearLayout20, linearLayout21, linearLayout22, linearLayout23, progressBar3, relativeLayout16, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30, textView31, textView32, findChildViewById14, findChildViewById15);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i14 = 2131363247;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout17 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363247);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout17 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i14 = 2131363252;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout18 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363252);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (relativeLayout18 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i14 = 2131363260;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout19 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363260);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (relativeLayout19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i14 = 2131363292;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout20 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363292);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (relativeLayout20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i14 = 2131363301;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        View findChildViewById16 = ViewBindings.findChildViewById(inflate, 2131363301);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (findChildViewById16 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            int i17 = 2131364210;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView33 = (TextView) ViewBindings.findChildViewById(findChildViewById16, 2131364210);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView33 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i17 = 2131364611;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView34 = (TextView) ViewBindings.findChildViewById(findChildViewById16, 2131364611);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView34 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i17 = 2131364612;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView35 = (TextView) ViewBindings.findChildViewById(findChildViewById16, 2131364612);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView35 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i17 = 2131364643;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        View findChildViewById17 = ViewBindings.findChildViewById(findChildViewById16, 2131364643);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (findChildViewById17 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            t4.t0 t0Var = new t4.t0((RelativeLayout) findChildViewById16, textView33, textView34, textView35, findChildViewById17);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i14 = 2131363302;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout21 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363302);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (relativeLayout21 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i14 = 2131363339;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(inflate, 2131363339);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (recyclerView != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i14 = 2131363348;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(inflate, 2131363348);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (recyclerView2 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i14 = 2131363351;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(inflate, 2131363351);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (recyclerView3 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i14 = 2131363365;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(inflate, 2131363365);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (switchCompat != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i14 = 2131363422;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                View findChildViewById18 = ViewBindings.findChildViewById(inflate, 2131363422);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (findChildViewById18 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i14 = 2131363478;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(inflate, 2131363478);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (nestedScrollView != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i14 = 2131363533;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(inflate, 2131363533);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (toolbar != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i14 = 2131363601;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView36 = (TextView) ViewBindings.findChildViewById(inflate, 2131363601);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView36 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i14 = 2131363667;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView37 = (TextView) ViewBindings.findChildViewById(inflate, 2131363667);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView37 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i14 = 2131363763;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView38 = (TextView) ViewBindings.findChildViewById(inflate, 2131363763);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView38 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i14 = 2131363833;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView39 = (TextView) ViewBindings.findChildViewById(inflate, 2131363833);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView39 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i14 = 2131363850;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView40 = (TextView) ViewBindings.findChildViewById(inflate, 2131363850);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView40 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i14 = 2131363851;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView41 = (TextView) ViewBindings.findChildViewById(inflate, 2131363851);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView41 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i14 = 2131363852;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView42 = (TextView) ViewBindings.findChildViewById(inflate, 2131363852);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView42 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i14 = 2131363880;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView43 = (TextView) ViewBindings.findChildViewById(inflate, 2131363880);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView43 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i14 = 2131363919;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView44 = (TextView) ViewBindings.findChildViewById(inflate, 2131363919);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView44 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i14 = 2131363920;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView45 = (TextView) ViewBindings.findChildViewById(inflate, 2131363920);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView45 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i14 = 2131364003;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView46 = (TextView) ViewBindings.findChildViewById(inflate, 2131364003);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView46 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i14 = 2131364004;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView47 = (TextView) ViewBindings.findChildViewById(inflate, 2131364004);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView47 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i14 = 2131364005;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView48 = (TextView) ViewBindings.findChildViewById(inflate, 2131364005);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView48 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i14 = 2131364006;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView49 = (TextView) ViewBindings.findChildViewById(inflate, 2131364006);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView49 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i14 = 2131364007;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView50 = (TextView) ViewBindings.findChildViewById(inflate, 2131364007);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView50 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i14 = 2131364008;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView51 = (TextView) ViewBindings.findChildViewById(inflate, 2131364008);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView51 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i14 = 2131364117;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView52 = (TextView) ViewBindings.findChildViewById(inflate, 2131364117);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView52 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i14 = 2131364199;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView53 = (TextView) ViewBindings.findChildViewById(inflate, 2131364199);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView53 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i14 = 2131364208;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView54 = (TextView) ViewBindings.findChildViewById(inflate, 2131364208);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView54 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i14 = 2131364212;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView55 = (TextView) ViewBindings.findChildViewById(inflate, 2131364212);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView55 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i14 = 2131364225;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (((TextView) ViewBindings.findChildViewById(inflate, 2131364225)) != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i14 = 2131364236;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView56 = (TextView) ViewBindings.findChildViewById(inflate, 2131364236);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView56 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i14 = 2131364244;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView57 = (TextView) ViewBindings.findChildViewById(inflate, 2131364244);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView57 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i14 = 2131364250;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView58 = (TextView) ViewBindings.findChildViewById(inflate, 2131364250);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView58 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i14 = 2131364286;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView59 = (TextView) ViewBindings.findChildViewById(inflate, 2131364286);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView59 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i14 = 2131364297;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView60 = (TextView) ViewBindings.findChildViewById(inflate, 2131364297);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView60 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i14 = 2131364522;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView61 = (TextView) ViewBindings.findChildViewById(inflate, 2131364522);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView61 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i14 = 2131364523;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView62 = (TextView) ViewBindings.findChildViewById(inflate, 2131364523);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView62 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i14 = 2131364575;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView63 = (TextView) ViewBindings.findChildViewById(inflate, 2131364575);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView63 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i14 = 2131364576;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView64 = (TextView) ViewBindings.findChildViewById(inflate, 2131364576);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (textView64 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i14 = 2131364577;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView65 = (TextView) ViewBindings.findChildViewById(inflate, 2131364577);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView65 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i14 = 2131364614;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView66 = (TextView) ViewBindings.findChildViewById(inflate, 2131364614);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView66 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i14 = 2131364664;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            View findChildViewById19 = ViewBindings.findChildViewById(inflate, 2131364664);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (findChildViewById19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                this.f10473b = new t4.b(coordinatorLayout, appBarLayout, blurView, collapsingToolbarLayout, frameLayout, frameLayout2, imageView, imageView2, imageView3, imageView4, qVar, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, hVar, linearLayout12, linearLayout13, linearLayout14, hVar2, relativeLayout, relativeLayout2, relativeLayout3, iVar, relativeLayout7, relativeLayout8, relativeLayout9, gVar, relativeLayout14, qVar2, relativeLayout15, cVar, relativeLayout17, relativeLayout18, relativeLayout19, relativeLayout20, t0Var, relativeLayout21, recyclerView, recyclerView2, recyclerView3, switchCompat, findChildViewById18, nestedScrollView, toolbar, textView36, textView37, textView38, textView39, textView40, textView41, textView42, textView43, textView44, textView45, textView46, textView47, textView48, textView49, textView50, textView51, textView52, textView53, textView54, textView55, textView56, textView57, textView58, textView59, textView60, textView61, textView62, textView63, textView64, textView65, textView66, g4.v.a(findChildViewById19));
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                FragmentActivity requireActivity = requireActivity();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                requireActivity.getClass();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                K(requireActivity);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                t4.b bVar = this.f10473b;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                bVar.getClass();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                return bVar.f9599a;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            com.google.gson.internal.a.i("Missing required view with ID: ".concat(findChildViewById16.getResources().getResourceName(i17)));
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            return null;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                            com.google.gson.internal.a.i("Missing required view with ID: ".concat(findChildViewById13.getResources().getResourceName(i16)));
                                                                                                                                                                                                                                                                                                                                                                                                            return null;
                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                        i11 = i15;
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                            com.google.gson.internal.a.i("Missing required view with ID: ".concat(findChildViewById11.getResources().getResourceName(i11)));
                                                                                                                                                                                                                                                                                                                            return null;
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                            i = i14;
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                                i11 = 2131363753;
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            i11 = i13;
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                i11 = i12;
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        com.google.gson.internal.a.i("Missing required view with ID: ".concat(findChildViewById10.getResources().getResourceName(i11)));
                                                                                                                                                                                                                                        return null;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                    com.google.gson.internal.a.i("Missing required view with ID: ".concat(findChildViewById9.getResources().getResourceName(i10)));
                                                                                                                                                                                    return null;
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        com.google.gson.internal.a.i("Missing required view with ID: ".concat(findChildViewById2.getResources().getResourceName(i6)));
                                                                                                        return null;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
                                                            return view;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        view = null;
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        r7.o0 o0Var = G().L;
        Boolean valueOf = Boolean.valueOf(!((Boolean) G().L.getValue()).booleanValue());
        o0Var.getClass();
        o0Var.g(null, valueOf);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        p7.c cVar = t7.n.f10348a;
        t6.c cVar2 = null;
        o7.c0.s(lifecycleScope, cVar, null, new w(this, cVar2, 11), 2);
        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new w(this, cVar2, 12), 2);
        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new w(this, cVar2, 13), 2);
        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new w(this, cVar2, 14), 2);
        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new w(this, cVar2, 15), 2);
        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new w(this, cVar2, 16), 2);
        if (((Boolean) G().M.getValue()).booleanValue()) {
            r7.o0 o0Var = G().M;
            Boolean bool = Boolean.FALSE;
            o0Var.getClass();
            o0Var.g(null, bool);
        } else {
            Rect rect = new Rect();
            t4.b bVar = this.f10473b;
            bVar.getClass();
            bVar.f9605f0.getHitRect(rect);
            l0(rect);
            Context requireContext = requireContext();
            requireContext.getClass();
            p0(requireContext);
        }
        String str = B().f11177p;
        if (str == null || str.length() == 0 || H()) {
            t4.b bVar2 = this.f10473b;
            bVar2.getClass();
            ((RelativeLayout) bVar2.M0.f5278n).setVisibility(8);
        } else {
            Context requireContext2 = requireContext();
            requireContext2.getClass();
            g0(requireContext2, null);
        }
        z();
        t4.b bVar3 = this.f10473b;
        bVar3.getClass();
        if (bVar3.f9605f0.getScrollY() > 0) {
            Context requireContext3 = requireContext();
            requireContext3.getClass();
            s0(requireContext3);
            String e10 = B().e();
            if (e10 == null || e10.length() == 0) {
                t4.b bVar4 = this.f10473b;
                bVar4.getClass();
                bVar4.f9613m.setTitle("");
            }
        }
        e4.u0 u0Var = this.f10480r;
        if (u0Var != null) {
            u0Var.notifyDataSetChanged();
        }
        e4.u0 u0Var2 = this.f10481s;
        if (u0Var2 != null) {
            u0Var2.notifyDataSetChanged();
        }
        ArrayList arrayList = this.f10482t;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((e4.u0) obj).notifyDataSetChanged();
        }
        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), t7.n.f10348a, null, new w(this, cVar2, 17), 2);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        viewLifecycleOwner.getClass();
        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new z(this, null), 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p(Context context) {
        Object[] objArr = 0;
        if (!L()) {
            r7.o0 o0Var = a5.b.f193a;
            if (!a5.b.e(B().f11158a)) {
                r7.o0 o0Var2 = a5.c.f197a;
                if (!a5.c.c(B().f11158a)) {
                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
                    v7.e eVar = o7.m0.f8288a;
                    o7.c0.s(lifecycleScope, v7.d.f10884a, null, new s4.e0(context, this, objArr == true ? 1 : 0, 3), 2);
                    return;
                }
            }
        }
        String str = B().F;
        str.getClass();
        x4.r b7 = a5.b.b();
        if (kotlin.jvm.internal.l.a(b7 != null ? b7.f11355b : null, str)) {
            a5.b.f();
        } else {
            a5.c.d();
        }
        Object systemService = context.getSystemService("notification");
        systemService.getClass();
        ((NotificationManager) systemService).cancel(261);
    }

    public final void p0(Context context) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(lifecycleScope, v7.d.f10884a, null, new d0(this, context, null, 0), 2);
    }

    public final void q() {
        if (B().l()) {
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            v7.e eVar = o7.m0.f8288a;
            o7.c0.s(lifecycleScope, t7.n.f10348a, null, new w(this, null, 0), 2);
            v0 G = G();
            Context requireContext = requireContext();
            requireContext.getClass();
            long j = B().f11158a;
            G.getClass();
            o7.c0.s(ViewModelKt.getViewModelScope(G), v7.d.f10884a, null, new n0(1, j, requireContext, null, G), 2);
        }
    }

    public final void q0() {
        t4.b bVar = this.f10473b;
        bVar.getClass();
        bVar.T.f9656o.setVisibility(0);
        t4.b bVar2 = this.f10473b;
        bVar2.getClass();
        bVar2.T.f9654m.setVisibility(8);
        t4.b bVar3 = this.f10473b;
        bVar3.getClass();
        ((RelativeLayout) bVar3.P.v).setVisibility(0);
        t4.b bVar4 = this.f10473b;
        bVar4.getClass();
        bVar4.P.f9809s.setVisibility(0);
        t4.b bVar5 = this.f10473b;
        bVar5.getClass();
        ((RelativeLayout) bVar5.P.f9812w).setVisibility(8);
        t4.b bVar6 = this.f10473b;
        bVar6.getClass();
        bVar6.P.f9811u.setVisibility(8);
        t4.b bVar7 = this.f10473b;
        bVar7.getClass();
        bVar7.P.f9807q.setVisibility(8);
        t4.b bVar8 = this.f10473b;
        bVar8.getClass();
        bVar8.L.f9875y.setVisibility(0);
        t4.b bVar9 = this.f10473b;
        bVar9.getClass();
        bVar9.L.f9867p.setVisibility(8);
        t4.b bVar10 = this.f10473b;
        bVar10.getClass();
        bVar10.L.f9872u.setVisibility(8);
    }

    public final void r(t4.n0 n0Var) {
        boolean z9 = true;
        z9 = true;
        if (G().U.compareAndSet(false, true)) {
            FragmentActivity requireActivity = requireActivity();
            requireActivity.getClass();
            new v4(requireActivity, 1).g((View) n0Var.f10015l, 0.0f);
            FragmentActivity requireActivity2 = requireActivity();
            requireActivity2.getClass();
            RelativeLayout relativeLayout = (RelativeLayout) n0Var.f10014b;
            n5.c cVar = new n5.c(this, z9 ? 1 : 0);
            Animation loadAnimation = AnimationUtils.loadAnimation(requireActivity2, 2130772034);
            float f = UptodownApp.I;
            try {
                SharedPreferences sharedPreferences = requireActivity2.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains("animations")) {
                    z9 = sharedPreferences.getBoolean("animations", true);
                }
            } catch (Exception unused) {
            }
            if (!z9) {
                cVar.onAnimationEnd(loadAnimation);
                return;
            }
            float f10 = UptodownApp.I;
            loadAnimation.setAnimationListener(cVar);
            relativeLayout.startAnimation(loadAnimation);
        }
    }

    public final void r0() {
        t4.b bVar = this.f10473b;
        bVar.getClass();
        bVar.T.f9656o.setVisibility(8);
        t4.b bVar2 = this.f10473b;
        bVar2.getClass();
        bVar2.T.f9654m.setVisibility(0);
        t4.b bVar3 = this.f10473b;
        bVar3.getClass();
        ((RelativeLayout) bVar3.P.v).setVisibility(0);
        t4.b bVar4 = this.f10473b;
        bVar4.getClass();
        bVar4.P.f9809s.setVisibility(0);
        t4.b bVar5 = this.f10473b;
        bVar5.getClass();
        bVar5.P.f9802l.setVisibility(8);
        t4.b bVar6 = this.f10473b;
        bVar6.getClass();
        ((RelativeLayout) bVar6.P.f9812w).setVisibility(8);
        t4.b bVar7 = this.f10473b;
        bVar7.getClass();
        bVar7.L.f9868q.setVisibility(8);
        t4.b bVar8 = this.f10473b;
        bVar8.getClass();
        bVar8.L.f9875y.setVisibility(8);
        t4.b bVar9 = this.f10473b;
        bVar9.getClass();
        bVar9.L.f9867p.setVisibility(0);
        t4.b bVar10 = this.f10473b;
        bVar10.getClass();
        bVar10.L.f9872u.setVisibility(8);
    }

    public final void s() {
        if (getActivity() == null || requireActivity().isFinishing()) {
            return;
        }
        FragmentActivity activity = getActivity();
        activity.getClass();
        ((c4.k0) activity).Q();
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        a4.d0 k5 = a4.d0.k(getLayoutInflater());
        TextView textView = (TextView) k5.f84n;
        TextView textView2 = (TextView) k5.f85o;
        textView.setTypeface(f4.c.f4883x);
        textView.setText(getString(2131951666));
        ((TextView) k5.f83m).setVisibility(8);
        textView2.setText(getString(2131952047));
        textView2.setTypeface(f4.c.f4882w);
        textView2.setOnClickListener(new p(this, 24));
        builder.setView((LinearLayout) k5.f81b);
        builder.setCancelable(false);
        FragmentActivity activity2 = getActivity();
        activity2.getClass();
        ((c4.k0) activity2).F = builder.create();
        FragmentActivity activity3 = getActivity();
        activity3.getClass();
        ((c4.k0) activity3).u0();
    }

    public final void s0(Context context) {
        t4.b bVar = this.f10473b;
        bVar.getClass();
        bVar.f9606g0.setBackgroundColor(ContextCompat.getColor(context, 2131100798));
        if ((context.getResources().getConfiguration().uiMode & 48) == 16) {
            int color = ContextCompat.getColor(context, 2131100500);
            Menu menu = this.f10479q;
            menu.getClass();
            Drawable icon = menu.findItem(2131361892).getIcon();
            if (icon != null) {
                DrawableCompat.setTint(icon, color);
            }
            Drawable drawable = ContextCompat.getDrawable(context, 2131230922);
            if (drawable != null) {
                t4.b bVar2 = this.f10473b;
                bVar2.getClass();
                bVar2.f9606g0.setNavigationIcon(drawable);
            }
            Drawable drawable2 = ContextCompat.getDrawable(context, 2131230944);
            if (drawable2 != null) {
                t4.b bVar3 = this.f10473b;
                bVar3.getClass();
                bVar3.f9606g0.setOverflowIcon(drawable2);
            }
        }
    }

    public final void t() {
        FragmentActivity activity = getActivity();
        activity.getClass();
        AlertDialog alertDialog = ((c4.k0) activity).F;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        kotlin.jvm.internal.u uVar = new kotlin.jvm.internal.u();
        if (L()) {
            uVar.f7021a = a5.b.d() || (a5.c.f197a.getValue() instanceof x4.y0);
            if (a5.b.b() != null) {
                a5.b.g();
            } else if (a5.c.a() != null) {
                a5.c.e();
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        a4.d0 k5 = a4.d0.k(getLayoutInflater());
        TextView textView = (TextView) k5.f84n;
        TextView textView2 = (TextView) k5.f85o;
        TextView textView3 = (TextView) k5.f83m;
        if (getActivity() != null && !requireActivity().isFinishing()) {
            textView.setTypeface(f4.c.f4883x);
            textView.setText(requireContext().getString(2131951965));
            textView3.setTypeface(f4.c.f4882w);
            textView3.setText(requireContext().getString(2131951931));
            textView3.setOnClickListener(new f(uVar, this, 9));
            textView2.setTypeface(f4.c.f4882w);
            textView2.setText(requireContext().getString(2131951930));
            textView2.setOnClickListener(new p(this, 20));
        }
        builder.setView((LinearLayout) k5.f81b);
        builder.setCancelable(false);
        m0(builder);
    }

    public final void t0(FragmentActivity fragmentActivity) {
        t4.b bVar = this.f10473b;
        bVar.getClass();
        bVar.f9606g0.setBackgroundColor(ContextCompat.getColor(fragmentActivity, 2131100798));
        int color = ContextCompat.getColor(fragmentActivity, 2131100824);
        Menu menu = this.f10479q;
        menu.getClass();
        Drawable icon = menu.findItem(2131361892).getIcon();
        if (icon != null) {
            DrawableCompat.setTint(icon, color);
        }
        Drawable drawable = ContextCompat.getDrawable(fragmentActivity, 2131231302);
        if (drawable != null) {
            t4.b bVar2 = this.f10473b;
            bVar2.getClass();
            bVar2.f9606g0.setNavigationIcon(drawable);
        }
        Drawable drawable2 = ContextCompat.getDrawable(fragmentActivity, 2131231364);
        if (drawable2 != null) {
            t4.b bVar3 = this.f10473b;
            bVar3.getClass();
            bVar3.f9606g0.setOverflowIcon(drawable2);
        }
    }

    public final void u(String str) {
        ArrayList arrayList;
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            activity.getClass();
            AlertDialog alertDialog = ((c4.k0) activity).F;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        }
        if (getContext() != null) {
            ArrayList arrayList2 = new ArrayList();
            String str2 = B().F;
            if (str2 != null && str2.length() != 0 && (arrayList = B().U) != null && !arrayList.isEmpty()) {
                ArrayList arrayList3 = B().U;
                arrayList3.getClass();
                Context requireContext = requireContext();
                requireContext.getClass();
                arrayList2 = x4.p.c(requireContext, arrayList3);
            }
            if (!arrayList2.isEmpty()) {
                Iterator it = arrayList2.iterator();
                it.getClass();
                String str3 = "";
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    String str4 = (String) next;
                    if (str4.equals(q6.l.y0(arrayList2))) {
                        str3 = a4.x.k(str3, "- ", str4);
                    } else {
                        str3 = str3 + "- " + str4 + "\n";
                    }
                }
                str = a4.x.k(str, "\n\n", str3);
            }
            a4.d0 k5 = a4.d0.k(getLayoutInflater());
            TextView textView = (TextView) k5.f83m;
            TextView textView2 = (TextView) k5.f85o;
            TextView textView3 = (TextView) k5.f84n;
            CheckBox checkBox = (CheckBox) k5.f82l;
            textView3.setTypeface(f4.c.f4883x);
            textView3.setText(str);
            checkBox.setVisibility(0);
            checkBox.setTypeface(f4.c.f4883x);
            checkBox.setOnCheckedChangeListener(new h(this, 0));
            textView2.setTypeface(f4.c.f4882w);
            textView2.setOnClickListener(new e(this, 3));
            textView.setTypeface(f4.c.f4882w);
            textView.setOnClickListener(new f(k5, this, 1));
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setView((LinearLayout) k5.f81b);
            builder.setCancelable(false);
            m0(builder);
        }
    }

    public final void u0(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(lifecycleScope, t7.n.f10348a, null, new e0(str, this, null, 0), 2);
    }

    public final void v(String str) {
        if (getActivity() == null || !isAdded() || requireActivity().isFinishing()) {
            return;
        }
        FragmentActivity activity = getActivity();
        activity.getClass();
        AlertDialog alertDialog = ((c4.k0) activity).F;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        a4.d0 k5 = a4.d0.k(getLayoutInflater());
        TextView textView = (TextView) k5.f85o;
        TextView textView2 = (TextView) k5.f84n;
        textView2.setTypeface(f4.c.f4883x);
        textView2.setText(str);
        ((TextView) k5.f83m).setVisibility(8);
        textView.setTypeface(f4.c.f4882w);
        textView.setOnClickListener(new p(this, 4));
        builder.setView((LinearLayout) k5.f81b);
        builder.setCancelable(false);
        m0(builder);
    }

    public final void v0(String str) {
        str.getClass();
        if (getContext() == null || B().F == null || !l7.u.m0(B().F, str, true)) {
            return;
        }
        Context requireContext = requireContext();
        requireContext.getClass();
        p0(requireContext);
        if (getActivity() == null || requireActivity().isFinishing() || !(getActivity() instanceof c4.k0)) {
            return;
        }
        FragmentActivity activity = getActivity();
        activity.getClass();
        String string = getString(2131952081, B().f11159b);
        string.getClass();
        ((c4.k0) activity).A(string);
    }

    public final void w(d7.a aVar) {
        FragmentActivity activity = getActivity();
        activity.getClass();
        AlertDialog alertDialog = ((c4.k0) activity).F;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (getContext() != null) {
            a4.d0 k5 = a4.d0.k(getLayoutInflater());
            TextView textView = (TextView) k5.f84n;
            TextView textView2 = (TextView) k5.f83m;
            TextView textView3 = (TextView) k5.f85o;
            textView.setTypeface(f4.c.f4883x);
            textView.setText(getString(2131952540, B().f11159b));
            textView3.setTypeface(f4.c.f4882w);
            textView3.setText(getString(2131952713));
            textView3.setOnClickListener(new f(aVar, this, 2));
            textView2.setTypeface(f4.c.f4882w);
            z3.K(textView2);
            textView2.setOnClickListener(new e(this, 5));
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setView((LinearLayout) k5.f81b);
            builder.setCancelable(false);
            m0(builder);
        }
    }

    public final void w0() {
        try {
            if (B().f11196z <= 0 || ((Number) G().Q.getValue()).intValue() <= 0) {
                t4.b bVar = this.f10473b;
                bVar.getClass();
                ((LinearLayout) bVar.D.f8816b).setVisibility(8);
                t4.b bVar2 = this.f10473b;
                bVar2.getClass();
                ((TextView) bVar2.D.f8825t).setVisibility(8);
                return;
            }
            int dimension = (int) getResources().getDimension(2131166251);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((((Number) G().Q.getValue()).intValue() * B().E) / B().f11196z, dimension);
            t4.b bVar3 = this.f10473b;
            bVar3.getClass();
            ((View) bVar3.D.f8821p).setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((((Number) G().Q.getValue()).intValue() * B().D) / B().f11196z, dimension);
            t4.b bVar4 = this.f10473b;
            bVar4.getClass();
            ((View) bVar4.D.f8820o).setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((((Number) G().Q.getValue()).intValue() * B().C) / B().f11196z, dimension);
            t4.b bVar5 = this.f10473b;
            bVar5.getClass();
            ((View) bVar5.D.f8819n).setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((((Number) G().Q.getValue()).intValue() * B().B) / B().f11196z, dimension);
            t4.b bVar6 = this.f10473b;
            bVar6.getClass();
            ((View) bVar6.D.f8818m).setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((((Number) G().Q.getValue()).intValue() * B().A) / B().f11196z, dimension);
            t4.b bVar7 = this.f10473b;
            bVar7.getClass();
            ((View) bVar7.D.f8817l).setLayoutParams(layoutParams5);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void x(Context context) {
        int i;
        FragmentActivity activity = getActivity();
        activity.getClass();
        AlertDialog alertDialog = ((c4.k0) activity).F;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        final Drawable drawable = ContextCompat.getDrawable(context, 2131231441);
        final Drawable drawable2 = ContextCompat.getDrawable(context, 2131231439);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View inflate = getLayoutInflater().inflate(2131558529, (ViewGroup) null, false);
        LinearLayout linearLayout = (LinearLayout) inflate;
        int i6 = 2131362158;
        EditText editText = (EditText) ViewBindings.findChildViewById(inflate, 2131362158);
        if (editText != null) {
            i6 = 2131362300;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362300);
            if (imageView != null) {
                i6 = 2131362484;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362484);
                if (imageView2 != null) {
                    i6 = 2131362490;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362490);
                    if (imageView3 != null) {
                        i6 = 2131362496;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362496);
                        if (imageView4 != null) {
                            i6 = 2131362502;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362502);
                            if (imageView5 != null) {
                                i6 = 2131362508;
                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362508);
                                if (imageView6 != null) {
                                    i6 = 2131363640;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363640);
                                    if (textView != null) {
                                        i6 = 2131363688;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363688);
                                        if (textView2 != null) {
                                            i6 = 2131364110;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364110);
                                            if (textView3 != null) {
                                                final e2.d dVar = new e2.d(linearLayout, editText, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, textView, textView2, textView3);
                                                String i10 = B().i();
                                                if (i10 == null || i10.length() == 0) {
                                                    imageView.setImageDrawable(ContextCompat.getDrawable(context, 2131231296));
                                                } else {
                                                    a4.l0 e10 = a4.g0.d().e(B().i());
                                                    float f = UptodownApp.I;
                                                    e10.h(b4.d.x(context));
                                                    e10.e(imageView, null);
                                                }
                                                textView.setTypeface(f4.c.f4882w);
                                                textView.setText(B().f11159b);
                                                editText.setText((CharSequence) G().H.getValue());
                                                int intValue = ((Number) G().S.getValue()).intValue();
                                                int i11 = 1;
                                                if (intValue == 1) {
                                                    imageView2.setImageDrawable(drawable);
                                                    imageView3.setImageDrawable(drawable2);
                                                    imageView4.setImageDrawable(drawable2);
                                                    imageView5.setImageDrawable(drawable2);
                                                    imageView6.setImageDrawable(drawable2);
                                                } else if (intValue == 2) {
                                                    imageView2.setImageDrawable(drawable);
                                                    imageView3.setImageDrawable(drawable);
                                                    imageView4.setImageDrawable(drawable2);
                                                    imageView5.setImageDrawable(drawable2);
                                                    imageView6.setImageDrawable(drawable2);
                                                } else if (intValue == 3) {
                                                    imageView2.setImageDrawable(drawable);
                                                    imageView3.setImageDrawable(drawable);
                                                    imageView4.setImageDrawable(drawable);
                                                    imageView5.setImageDrawable(drawable2);
                                                    imageView6.setImageDrawable(drawable2);
                                                } else if (intValue == 4) {
                                                    imageView2.setImageDrawable(drawable);
                                                    imageView3.setImageDrawable(drawable);
                                                    imageView4.setImageDrawable(drawable);
                                                    imageView5.setImageDrawable(drawable);
                                                    imageView6.setImageDrawable(drawable2);
                                                } else if (intValue != 5) {
                                                    imageView2.setImageDrawable(drawable2);
                                                    imageView3.setImageDrawable(drawable2);
                                                    imageView4.setImageDrawable(drawable2);
                                                    imageView5.setImageDrawable(drawable2);
                                                    imageView6.setImageDrawable(drawable2);
                                                } else {
                                                    imageView2.setImageDrawable(drawable);
                                                    imageView3.setImageDrawable(drawable);
                                                    imageView4.setImageDrawable(drawable);
                                                    imageView5.setImageDrawable(drawable);
                                                    imageView6.setImageDrawable(drawable);
                                                }
                                                final int i12 = 0;
                                                imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: u4.q

                                                    /* renamed from: b, reason: collision with root package name */
                                                    public final /* synthetic */ f0 f10573b;

                                                    {
                                                        this.f10573b = this;
                                                    }

                                                    @Override // android.view.View.OnClickListener
                                                    public final void onClick(View view) {
                                                        int i13 = i12;
                                                        Drawable drawable3 = drawable2;
                                                        Drawable drawable4 = drawable;
                                                        e2.d dVar2 = dVar;
                                                        f0 f0Var = this.f10573b;
                                                        switch (i13) {
                                                            case 0:
                                                                float f10 = UptodownApp.I;
                                                                if (b4.d.t()) {
                                                                    r7.o0 o0Var = f0Var.G().S;
                                                                    o0Var.getClass();
                                                                    o0Var.g(null, 1);
                                                                    ((ImageView) dVar2.f4468m).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4469n).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4470o).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4471p).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4472q).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            case 1:
                                                                float f11 = UptodownApp.I;
                                                                if (b4.d.t()) {
                                                                    r7.o0 o0Var2 = f0Var.G().S;
                                                                    o0Var2.getClass();
                                                                    o0Var2.g(null, 2);
                                                                    ((ImageView) dVar2.f4468m).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4469n).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4470o).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4471p).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4472q).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            case 2:
                                                                float f12 = UptodownApp.I;
                                                                if (b4.d.t()) {
                                                                    r7.o0 o0Var3 = f0Var.G().S;
                                                                    o0Var3.getClass();
                                                                    o0Var3.g(null, 3);
                                                                    ((ImageView) dVar2.f4468m).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4469n).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4470o).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4471p).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4472q).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                float f13 = UptodownApp.I;
                                                                if (b4.d.t()) {
                                                                    r7.o0 o0Var4 = f0Var.G().S;
                                                                    o0Var4.getClass();
                                                                    o0Var4.g(null, 4);
                                                                    ((ImageView) dVar2.f4468m).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4469n).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4470o).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4471p).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4472q).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                        }
                                                    }
                                                });
                                                final int i13 = 1;
                                                imageView3.setOnClickListener(new View.OnClickListener(this) { // from class: u4.q

                                                    /* renamed from: b, reason: collision with root package name */
                                                    public final /* synthetic */ f0 f10573b;

                                                    {
                                                        this.f10573b = this;
                                                    }

                                                    @Override // android.view.View.OnClickListener
                                                    public final void onClick(View view) {
                                                        int i132 = i13;
                                                        Drawable drawable3 = drawable2;
                                                        Drawable drawable4 = drawable;
                                                        e2.d dVar2 = dVar;
                                                        f0 f0Var = this.f10573b;
                                                        switch (i132) {
                                                            case 0:
                                                                float f10 = UptodownApp.I;
                                                                if (b4.d.t()) {
                                                                    r7.o0 o0Var = f0Var.G().S;
                                                                    o0Var.getClass();
                                                                    o0Var.g(null, 1);
                                                                    ((ImageView) dVar2.f4468m).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4469n).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4470o).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4471p).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4472q).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            case 1:
                                                                float f11 = UptodownApp.I;
                                                                if (b4.d.t()) {
                                                                    r7.o0 o0Var2 = f0Var.G().S;
                                                                    o0Var2.getClass();
                                                                    o0Var2.g(null, 2);
                                                                    ((ImageView) dVar2.f4468m).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4469n).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4470o).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4471p).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4472q).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            case 2:
                                                                float f12 = UptodownApp.I;
                                                                if (b4.d.t()) {
                                                                    r7.o0 o0Var3 = f0Var.G().S;
                                                                    o0Var3.getClass();
                                                                    o0Var3.g(null, 3);
                                                                    ((ImageView) dVar2.f4468m).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4469n).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4470o).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4471p).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4472q).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                float f13 = UptodownApp.I;
                                                                if (b4.d.t()) {
                                                                    r7.o0 o0Var4 = f0Var.G().S;
                                                                    o0Var4.getClass();
                                                                    o0Var4.g(null, 4);
                                                                    ((ImageView) dVar2.f4468m).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4469n).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4470o).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4471p).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4472q).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                        }
                                                    }
                                                });
                                                final int i14 = 2;
                                                imageView4.setOnClickListener(new View.OnClickListener(this) { // from class: u4.q

                                                    /* renamed from: b, reason: collision with root package name */
                                                    public final /* synthetic */ f0 f10573b;

                                                    {
                                                        this.f10573b = this;
                                                    }

                                                    @Override // android.view.View.OnClickListener
                                                    public final void onClick(View view) {
                                                        int i132 = i14;
                                                        Drawable drawable3 = drawable2;
                                                        Drawable drawable4 = drawable;
                                                        e2.d dVar2 = dVar;
                                                        f0 f0Var = this.f10573b;
                                                        switch (i132) {
                                                            case 0:
                                                                float f10 = UptodownApp.I;
                                                                if (b4.d.t()) {
                                                                    r7.o0 o0Var = f0Var.G().S;
                                                                    o0Var.getClass();
                                                                    o0Var.g(null, 1);
                                                                    ((ImageView) dVar2.f4468m).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4469n).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4470o).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4471p).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4472q).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            case 1:
                                                                float f11 = UptodownApp.I;
                                                                if (b4.d.t()) {
                                                                    r7.o0 o0Var2 = f0Var.G().S;
                                                                    o0Var2.getClass();
                                                                    o0Var2.g(null, 2);
                                                                    ((ImageView) dVar2.f4468m).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4469n).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4470o).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4471p).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4472q).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            case 2:
                                                                float f12 = UptodownApp.I;
                                                                if (b4.d.t()) {
                                                                    r7.o0 o0Var3 = f0Var.G().S;
                                                                    o0Var3.getClass();
                                                                    o0Var3.g(null, 3);
                                                                    ((ImageView) dVar2.f4468m).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4469n).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4470o).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4471p).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4472q).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                float f13 = UptodownApp.I;
                                                                if (b4.d.t()) {
                                                                    r7.o0 o0Var4 = f0Var.G().S;
                                                                    o0Var4.getClass();
                                                                    o0Var4.g(null, 4);
                                                                    ((ImageView) dVar2.f4468m).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4469n).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4470o).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4471p).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4472q).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                        }
                                                    }
                                                });
                                                final int i15 = 3;
                                                imageView5.setOnClickListener(new View.OnClickListener(this) { // from class: u4.q

                                                    /* renamed from: b, reason: collision with root package name */
                                                    public final /* synthetic */ f0 f10573b;

                                                    {
                                                        this.f10573b = this;
                                                    }

                                                    @Override // android.view.View.OnClickListener
                                                    public final void onClick(View view) {
                                                        int i132 = i15;
                                                        Drawable drawable3 = drawable2;
                                                        Drawable drawable4 = drawable;
                                                        e2.d dVar2 = dVar;
                                                        f0 f0Var = this.f10573b;
                                                        switch (i132) {
                                                            case 0:
                                                                float f10 = UptodownApp.I;
                                                                if (b4.d.t()) {
                                                                    r7.o0 o0Var = f0Var.G().S;
                                                                    o0Var.getClass();
                                                                    o0Var.g(null, 1);
                                                                    ((ImageView) dVar2.f4468m).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4469n).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4470o).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4471p).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4472q).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            case 1:
                                                                float f11 = UptodownApp.I;
                                                                if (b4.d.t()) {
                                                                    r7.o0 o0Var2 = f0Var.G().S;
                                                                    o0Var2.getClass();
                                                                    o0Var2.g(null, 2);
                                                                    ((ImageView) dVar2.f4468m).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4469n).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4470o).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4471p).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4472q).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            case 2:
                                                                float f12 = UptodownApp.I;
                                                                if (b4.d.t()) {
                                                                    r7.o0 o0Var3 = f0Var.G().S;
                                                                    o0Var3.getClass();
                                                                    o0Var3.g(null, 3);
                                                                    ((ImageView) dVar2.f4468m).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4469n).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4470o).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4471p).setImageDrawable(drawable3);
                                                                    ((ImageView) dVar2.f4472q).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                float f13 = UptodownApp.I;
                                                                if (b4.d.t()) {
                                                                    r7.o0 o0Var4 = f0Var.G().S;
                                                                    o0Var4.getClass();
                                                                    o0Var4.g(null, 4);
                                                                    ((ImageView) dVar2.f4468m).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4469n).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4470o).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4471p).setImageDrawable(drawable4);
                                                                    ((ImageView) dVar2.f4472q).setImageDrawable(drawable3);
                                                                    break;
                                                                }
                                                                break;
                                                        }
                                                    }
                                                });
                                                imageView6.setOnClickListener(new c4.t(this, dVar, drawable, 20));
                                                editText.setTypeface(f4.c.f4883x);
                                                if (G().v.getValue() != null) {
                                                    Object value = G().v.getValue();
                                                    value.getClass();
                                                    String str = ((k2) value).f11263o;
                                                    if (str != null && str.length() != 0) {
                                                        Object value2 = G().v.getValue();
                                                        value2.getClass();
                                                        editText.setText(String.valueOf(((k2) value2).f11263o));
                                                    }
                                                    Object value3 = G().v.getValue();
                                                    value3.getClass();
                                                    if (((k2) value3).f11264p >= 1) {
                                                        i = 2131231441;
                                                        k0.k.l(this, 2131231441, imageView2);
                                                    } else {
                                                        i = 2131231441;
                                                    }
                                                    Object value4 = G().v.getValue();
                                                    value4.getClass();
                                                    if (((k2) value4).f11264p >= 2) {
                                                        k0.k.l(this, i, imageView3);
                                                    }
                                                    Object value5 = G().v.getValue();
                                                    value5.getClass();
                                                    if (((k2) value5).f11264p >= 3) {
                                                        k0.k.l(this, i, imageView4);
                                                    }
                                                    Object value6 = G().v.getValue();
                                                    value6.getClass();
                                                    if (((k2) value6).f11264p >= 4) {
                                                        k0.k.l(this, i, imageView5);
                                                    }
                                                    Object value7 = G().v.getValue();
                                                    value7.getClass();
                                                    if (((k2) value7).f11264p == 5) {
                                                        k0.k.l(this, i, imageView6);
                                                    }
                                                }
                                                textView3.setTypeface(f4.c.f4882w);
                                                textView3.setOnClickListener(new c4.t(this, context, dVar, 21));
                                                textView2.setTypeface(f4.c.f4882w);
                                                textView2.setOnClickListener(new f(8, this, dVar));
                                                builder.setView(linearLayout);
                                                FragmentActivity activity2 = getActivity();
                                                activity2.getClass();
                                                AlertDialog alertDialog2 = ((c4.k0) activity2).F;
                                                if (alertDialog2 != null) {
                                                    alertDialog2.setOnDismissListener(new c4.v4(this, context, i11));
                                                }
                                                m0(builder);
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i6)));
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x0280  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y() {
        /*
            Method dump skipped, instructions count: 708
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.f0.y():void");
    }

    public final void z() {
        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new w(this, null, 2), 3);
    }
}
