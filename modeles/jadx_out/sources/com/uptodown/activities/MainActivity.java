package com.uptodown.activities;

import a.a;
import a4.d0;
import a4.g0;
import a4.x;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.browser.trusted.c;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import b4.d;
import b5.j;
import b5.m;
import c4.a3;
import c4.b;
import c4.b3;
import c4.c3;
import c4.f3;
import c4.g3;
import c4.m3;
import c4.n3;
import c4.p3;
import c4.q3;
import c4.r3;
import c4.s;
import c4.t2;
import c4.y2;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.z3;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.uptodown.UptodownApp;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.gcm.MyFirebaseMessagingService;
import com.uptodown.tv.ui.activity.TvMainActivity;
import com.uptodown.views.ScrollableTextView;
import j5.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k0.k;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.w;
import l7.u;
import o7.c0;
import o7.m0;
import q6.l;
import t4.h0;
import t7.n;
import u4.f0;
import u4.f1;
import u4.g1;
import u4.m1;
import u4.w0;
import u4.z1;
import v7.e;
import x4.e3;
import x4.g;
import x4.l0;
import x4.r;
import x4.r1;
import x4.u0;
import x4.u2;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class MainActivity extends t2 {
    public static int G0;
    public final ActivityResultLauncher A0;
    public final ActivityResultLauncher B0;
    public final ActivityResultLauncher C0;
    public final ActivityResultLauncher D0;
    public final b E0;
    public final ActivityResultLauncher F0;
    public RelativeLayout S;
    public int T;
    public boolean V;
    public RelativeLayout W;
    public RelativeLayout X;
    public AppBarLayout Y;
    public SwitchCompat Z;
    public SwitchCompat a0;

    /* renamed from: b0, reason: collision with root package name */
    public long f3304b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f3305c0;

    /* renamed from: d0, reason: collision with root package name */
    public g f3306d0;

    /* renamed from: e0, reason: collision with root package name */
    public g f3307e0;

    /* renamed from: g0, reason: collision with root package name */
    public int f3309g0;

    /* renamed from: h0, reason: collision with root package name */
    public ViewPager2 f3310h0;

    /* renamed from: i0, reason: collision with root package name */
    public RelativeLayout f3311i0;

    /* renamed from: j0, reason: collision with root package name */
    public RelativeLayout f3312j0;

    /* renamed from: k0, reason: collision with root package name */
    public ProgressBar f3313k0;

    /* renamed from: l0, reason: collision with root package name */
    public TabLayout f3314l0;

    /* renamed from: m0, reason: collision with root package name */
    public g1 f3315m0;
    public w0 n0;

    /* renamed from: o0, reason: collision with root package name */
    public m1 f3316o0;

    /* renamed from: p0, reason: collision with root package name */
    public f1 f3317p0;

    /* renamed from: t0, reason: collision with root package name */
    public FrameLayout f3321t0;

    /* renamed from: u0, reason: collision with root package name */
    public h0 f3322u0;

    /* renamed from: v0, reason: collision with root package name */
    public FrameLayout f3323v0;

    /* renamed from: w0, reason: collision with root package name */
    public ImageView f3324w0;

    /* renamed from: x0, reason: collision with root package name */
    public ImageView f3325x0;

    /* renamed from: y0, reason: collision with root package name */
    public b3 f3326y0;

    /* renamed from: z0, reason: collision with root package name */
    public c f3327z0;
    public final ArrayList U = new ArrayList();

    /* renamed from: f0, reason: collision with root package name */
    public final Handler f3308f0 = new Handler(Looper.getMainLooper());

    /* renamed from: q0, reason: collision with root package name */
    public final ArrayList f3318q0 = new ArrayList();

    /* renamed from: r0, reason: collision with root package name */
    public final ArrayList f3319r0 = new ArrayList();

    /* renamed from: s0, reason: collision with root package name */
    public long f3320s0 = -1;

    public MainActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a3(0, this));
        registerForActivityResult.getClass();
        this.A0 = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a3(1, this));
        registerForActivityResult2.getClass();
        this.B0 = registerForActivityResult2;
        ActivityResultLauncher registerForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a3(2, this));
        registerForActivityResult3.getClass();
        this.C0 = registerForActivityResult3;
        ActivityResultLauncher registerForActivityResult4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a3(3, this));
        registerForActivityResult4.getClass();
        this.D0 = registerForActivityResult4;
        this.E0 = new b(this, 3);
        ActivityResultLauncher registerForActivityResult5 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a3(4, this));
        registerForActivityResult5.getClass();
        this.F0 = registerForActivityResult5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x010c, code lost:
    
        if (o7.c0.C(r1, r13, r0) == r6) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x010e, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0067, code lost:
    
        if (r13 != r6) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0054, code lost:
    
        if (r13 == r6) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object H0(com.uptodown.activities.MainActivity r12, v6.c r13) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MainActivity.H0(com.uptodown.activities.MainActivity, v6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object I0(com.uptodown.activities.MainActivity r9, v6.c r10) {
        /*
            boolean r0 = r10 instanceof c4.k3
            if (r0 == 0) goto L13
            r0 = r10
            c4.k3 r0 = (c4.k3) r0
            int r1 = r0.f1785m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1785m = r1
            goto L18
        L13:
            c4.k3 r0 = new c4.k3
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f1783b
            int r1 = r0.f1785m
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 != r3) goto L28
            com.uptodown.activities.MainActivity r0 = r0.f1782a
            p6.a.e(r10)
            goto L4f
        L28:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r9)
            return r2
        L2e:
            p6.a.e(r10)
            e1.c0 r10 = j5.g.D
            j5.g r10 = r10.l(r9)
            v7.e r1 = o7.m0.f8288a
            v7.d r1 = v7.d.f10884a
            c4.g r4 = new c4.g
            r5 = 3
            r4.<init>(r10, r2, r5)
            r0.f1782a = r9
            r0.f1785m = r3
            java.lang.Object r10 = o7.c0.C(r4, r1, r0)
            u6.a r0 = u6.a.f10762a
            if (r10 != r0) goto L4e
            return r0
        L4e:
            r0 = r9
        L4f:
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            r0.getClass()
            r10.getClass()
            r0.J = r10
            r10 = 0
            r0 = r10
        L5b:
            java.util.ArrayList r1 = r9.J
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L86
            r1 = 2
            if (r0 >= r1) goto L86
            java.util.ArrayList r4 = r9.J
            java.lang.Object r4 = r4.remove(r10)
            r4.getClass()
            x4.x1 r4 = (x4.x1) r4
            androidx.lifecycle.LifecycleCoroutineScope r5 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r9)
            v7.e r6 = o7.m0.f8288a
            p7.c r6 = t7.n.f10348a
            b.n r7 = new b.n
            r8 = 11
            r7.<init>(r9, r4, r2, r8)
            o7.c0.s(r5, r6, r2, r7, r1)
            int r0 = r0 + 1
            goto L5b
        L86:
            if (r0 <= 0) goto L89
            goto L8a
        L89:
            r3 = r10
        L8a:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r3)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MainActivity.I0(com.uptodown.activities.MainActivity, v6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object J0(com.uptodown.activities.MainActivity r6, v6.c r7) {
        /*
            boolean r0 = r7 instanceof c4.l3
            if (r0 == 0) goto L13
            r0 = r7
            c4.l3 r0 = (c4.l3) r0
            int r1 = r0.f1822m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1822m = r1
            goto L18
        L13:
            c4.l3 r0 = new c4.l3
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f1820b
            int r1 = r0.f1822m
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 != r3) goto L28
            java.util.ArrayList r0 = r0.f1819a
            p6.a.e(r7)
            goto L4b
        L28:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            return r2
        L2e:
            java.util.ArrayList r7 = a4.x.w(r7)
            v7.e r1 = o7.m0.f8288a
            v7.d r1 = v7.d.f10884a
            b.n r4 = new b.n
            r5 = 13
            r4.<init>(r6, r7, r2, r5)
            r0.f1819a = r7
            r0.f1822m = r3
            java.lang.Object r0 = o7.c0.C(r4, r1, r0)
            u6.a r1 = u6.a.f10762a
            if (r0 != r1) goto L4a
            return r1
        L4a:
            r0 = r7
        L4b:
            boolean r7 = r0.isEmpty()
            if (r7 != 0) goto L80
            int r7 = r0.size()
            if (r7 != r3) goto L7a
            x4.k r7 = com.uptodown.UptodownApp.f3293g0
            r1 = 0
            if (r7 != 0) goto L6d
            x4.k r7 = new x4.k
            r7.<init>()
            com.uptodown.UptodownApp.f3293g0 = r7
            java.lang.Object r2 = r0.get(r1)
            x4.g r2 = (x4.g) r2
            java.lang.String r2 = r2.F
            r7.f11249c = r2
        L6d:
            java.lang.Object r7 = r0.get(r1)
            r7.getClass()
            x4.g r7 = (x4.g) r7
            r6.w1(r7)
            goto L7d
        L7a:
            r6.p1(r0)
        L7d:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            return r6
        L80:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MainActivity.J0(com.uptodown.activities.MainActivity, v6.c):java.lang.Object");
    }

    public static final boolean K0(MainActivity mainActivity) {
        TextView textView = (TextView) mainActivity.findViewById(2131364367);
        return (textView == null || textView.getVisibility() != 0) && !mainActivity.Z0();
    }

    public static final void L0(MainActivity mainActivity, String str) {
        Bundle e10 = k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
        android.support.v4.media.g gVar = mainActivity.E;
        if (gVar != null) {
            gVar.E(e10, "tab_clicked");
        }
    }

    public static final void M0(MainActivity mainActivity, g gVar) {
        int i;
        ArrayList arrayList = mainActivity.U;
        if (mainActivity.W != null && mainActivity.T == 0 && arrayList.size() == 1 && ((e3) arrayList.get(mainActivity.T)).f11141a == 1 && !mainActivity.Z0()) {
            mainActivity.f3307e0 = gVar;
            mainActivity.f3306d0 = gVar;
            mainActivity.O0(mainActivity.d1(gVar), 2);
            String g = x.g(((e3) arrayList.get(mainActivity.T)).f11141a, "wizard_step_", "_shown");
            SharedPreferences sharedPreferences = mainActivity.getSharedPreferences("SettingsPreferences", 0);
            sharedPreferences.getClass();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(g, true);
            edit.apply();
            int i6 = mainActivity.T;
            if (i6 < 0 || i6 >= mainActivity.U.size() - 1) {
                i = -1;
            } else {
                i = mainActivity.T + 1;
                mainActivity.T = i;
            }
            if (i >= 0 && i < arrayList.size()) {
                Object obj = arrayList.get(i);
                obj.getClass();
                mainActivity.o1((e3) obj);
                if (((e3) arrayList.get(mainActivity.T)).f11141a == 2 && ((e3) arrayList.get(0)).f11141a == 1) {
                    ((e3) arrayList.get(0)).a().removeAllViews();
                    arrayList.remove(0);
                    mainActivity.T = 0;
                }
            }
            RelativeLayout relativeLayout = mainActivity.W;
            relativeLayout.getClass();
            relativeLayout.setVisibility(0);
        } else if (mainActivity.b1()) {
            mainActivity.f3307e0 = gVar;
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(gVar);
            mainActivity.p1(arrayList2);
        }
        RelativeLayout relativeLayout2 = mainActivity.X;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
    }

    public static final void N0(MainActivity mainActivity) {
        ArrayList arrayList = mainActivity.U;
        if (mainActivity.W != null && mainActivity.T == 0 && arrayList.size() == 1 && ((e3) arrayList.get(mainActivity.T)).f11141a == 1 && !mainActivity.Z0()) {
            RelativeLayout relativeLayout = mainActivity.W;
            relativeLayout.getClass();
            relativeLayout.setVisibility(0);
            TextView textView = (TextView) mainActivity.findViewById(2131363611);
            if (textView != null) {
                textView.setBackground(ContextCompat.getDrawable(mainActivity, 2131231182));
            }
            if (textView != null) {
                textView.setEnabled(true);
            }
            ProgressBar progressBar = (ProgressBar) mainActivity.findViewById(2131363025);
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            mainActivity.O0(mainActivity.f1(), 4);
            mainActivity.O0(mainActivity.e1(), 5);
        }
        RelativeLayout relativeLayout2 = mainActivity.X;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
    }

    @Override // c4.t2
    public final void B0() {
        if (this.W != null) {
            ArrayList arrayList = this.U;
            int size = arrayList.size();
            int i = this.T;
            if (size > i && ((e3) arrayList.get(i)).f11141a == 5) {
                Q0();
                u1();
                return;
            }
        }
        f1 f1Var = this.f3317p0;
        if (f1Var != null) {
            f1Var.onResume();
        }
    }

    public final void G0() {
        if (!z3.p(this, "gdpr_requested", false)) {
            z3.M(this, "gdpr_requested", true);
            z3.M(this, "gdpr_analytics_allowed", true);
            z3.M(this, "gdpr_crashlytics_allowed", true);
            z3.M(this, "gdpr_tracking_allowed", true);
            float f = UptodownApp.I;
            d.F(this);
            this.E = new android.support.v4.media.g(this, 20);
        }
        this.E = new android.support.v4.media.g(this, 20);
        if (!z3.p(this, "gdpr_tracking_allowed", false)) {
            j5.c.a(this.F, this);
            return;
        }
        this.f3309g0 = 0;
        b3 b3Var = new b3(1, this);
        this.f3326y0 = b3Var;
        this.f3308f0.postDelayed(b3Var, 2000L);
    }

    public final void O0(RelativeLayout relativeLayout, int i) {
        e3 e3Var = new e3();
        e3Var.f11141a = i;
        e3Var.f11142b = relativeLayout;
        this.U.add(e3Var);
    }

    public final void P0() {
        int i;
        if (this.V) {
            return;
        }
        ArrayList arrayList = this.U;
        if (arrayList.isEmpty() || (i = this.T) < 0) {
            return;
        }
        RelativeLayout a8 = ((e3) arrayList.get(i)).a();
        f3 f3Var = new f3(0, this);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, 2130772029);
        float f = UptodownApp.I;
        boolean z9 = true;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (!z9) {
            f3Var.onAnimationEnd(loadAnimation);
            return;
        }
        float f10 = UptodownApp.I;
        loadAnimation.setAnimationListener(f3Var);
        a8.startAnimation(loadAnimation);
    }

    public final void Q0() {
        int i = this.T;
        ArrayList arrayList = this.U;
        String g = x.g(((e3) arrayList.get(i)).f11141a, "wizard_step_", "_shown");
        SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
        sharedPreferences.getClass();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        boolean z9 = true;
        z9 = true;
        edit.putBoolean(g, true);
        edit.apply();
        RelativeLayout a8 = ((e3) arrayList.get(this.T)).a();
        f3 f3Var = new f3(z9 ? 1 : 0, this);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, 2130772033);
        float f = UptodownApp.I;
        try {
            SharedPreferences sharedPreferences2 = getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences2.contains("animations")) {
                z9 = sharedPreferences2.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (!z9) {
            f3Var.onAnimationEnd(loadAnimation);
            return;
        }
        float f10 = UptodownApp.I;
        loadAnimation.setAnimationListener(f3Var);
        a8.startAnimation(loadAnimation);
    }

    public final void R0(g gVar, boolean z9) {
        f0 f0Var = new f0();
        Bundle bundle = new Bundle();
        if (gVar != null) {
            bundle.putParcelable("appInfo", gVar);
        }
        f0Var.setArguments(bundle);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.getClass();
        if (((CoordinatorLayout) findViewById(2131363229)) == null) {
            String string = getString(2131951998);
            string.getClass();
            A(string);
            return;
        }
        try {
            beginTransaction.replace(2131363229, f0Var);
            beginTransaction.addToBackStack(null);
            if (z9) {
                beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            }
            if (isFinishing() || getSupportFragmentManager().isDestroyed()) {
                return;
            }
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e10) {
            e10.printStackTrace();
            String string2 = getString(2131951998);
            string2.getClass();
            A(string2);
        }
    }

    public final void S0(int i) {
        TabLayout tabLayout = this.f3314l0;
        tabLayout.getClass();
        if (i < tabLayout.getTabCount()) {
            TabLayout tabLayout2 = this.f3314l0;
            tabLayout2.getClass();
            if (tabLayout2.getSelectedTabPosition() != i) {
                TabLayout tabLayout3 = this.f3314l0;
                tabLayout3.getClass();
                TabLayout.Tab tabAt = tabLayout3.getTabAt(i);
                if (tabAt != null) {
                    tabAt.select();
                }
            }
        }
    }

    public final void T0() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f3304b0 > 60000) {
            this.f3304b0 = currentTimeMillis;
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            e eVar = m0.f8288a;
            c0.s(lifecycleScope, v7.d.f10884a, null, new g3(this, null, 0), 2);
        }
    }

    public final void U0() {
        h0 h0Var;
        FrameLayout frameLayout = this.f3321t0;
        if (frameLayout == null || frameLayout.getChildCount() == 0 || (h0Var = this.f3322u0) == null) {
            return;
        }
        h0Var.getClass();
        RelativeLayout relativeLayout = h0Var.f9841b;
        relativeLayout.getClass();
        f3 f3Var = new f3(2, this);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, 2130772034);
        float f = UptodownApp.I;
        boolean z9 = true;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (!z9) {
            f3Var.onAnimationEnd(loadAnimation);
            return;
        }
        float f10 = UptodownApp.I;
        loadAnimation.setAnimationListener(f3Var);
        relativeLayout.startAnimation(loadAnimation);
    }

    public final void V0() {
        AlertDialog alertDialog;
        if (isFinishing()) {
            return;
        }
        AlertDialog alertDialog2 = this.F;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        d0 k5 = d0.k(getLayoutInflater());
        TextView textView = (TextView) k5.f83m;
        TextView textView2 = (TextView) k5.f85o;
        TextView textView3 = (TextView) k5.f84n;
        textView3.setTypeface(f4.c.f4883x);
        textView3.setText(getString(2131952404));
        textView2.setTypeface(f4.c.f4882w);
        textView2.setOnClickListener(new s(2, this));
        textView.setTypeface(f4.c.f4882w);
        textView.setOnClickListener(new s(7, this));
        builder.setView((LinearLayout) k5.f81b);
        builder.setCancelable(true);
        this.F = builder.create();
        if (isFinishing() || (alertDialog = this.F) == null) {
            return;
        }
        Window window = alertDialog.getWindow();
        if (window != null) {
            x.y(window, 0);
        }
        AlertDialog alertDialog3 = this.F;
        alertDialog3.getClass();
        alertDialog3.show();
    }

    public final Fragment W0() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            fragments.getClass();
            return (Fragment) l.y0(fragments);
        }
        ArrayList arrayList = this.f3318q0;
        if (arrayList.isEmpty()) {
            return null;
        }
        return (Fragment) l.y0(arrayList);
    }

    public final void X0() {
        FrameLayout frameLayout = this.f3323v0;
        if (frameLayout == null || frameLayout.getChildCount() == 0) {
            return;
        }
        FrameLayout frameLayout2 = this.f3323v0;
        frameLayout2.getClass();
        f3 f3Var = new f3(3, this);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, 2130772023);
        float f = UptodownApp.I;
        boolean z9 = true;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (!z9) {
            f3Var.onAnimationEnd(loadAnimation);
            return;
        }
        float f10 = UptodownApp.I;
        loadAnimation.setAnimationListener(f3Var);
        frameLayout2.startAnimation(loadAnimation);
    }

    public final void Y0() {
        U0();
        X0();
    }

    public final boolean Z0() {
        TextView textView = (TextView) findViewById(2131364021);
        return textView != null && textView.getVisibility() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a1() {
        /*
            Method dump skipped, instructions count: 486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MainActivity.a1():boolean");
    }

    @Override // c4.k0
    public final void b0(x4.d0 d0Var) {
        d0Var.getClass();
        r a8 = d0Var.a();
        if (a8 != null) {
            int c9 = d0Var.c();
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            e eVar = m0.f8288a;
            c0.s(lifecycleScope, n.f10348a, null, new b.n(c9, this, a8, (t6.c) null), 2);
        }
    }

    public final boolean b1() {
        RelativeLayout relativeLayout = this.X;
        if (relativeLayout != null) {
            relativeLayout.getClass();
            if (relativeLayout.getVisibility() == 0) {
                return true;
            }
        }
        RelativeLayout relativeLayout2 = this.W;
        if (relativeLayout2 == null) {
            return false;
        }
        relativeLayout2.getClass();
        if (relativeLayout2.getVisibility() != 0) {
            return false;
        }
        RelativeLayout relativeLayout3 = this.W;
        relativeLayout3.getClass();
        return relativeLayout3.getChildCount() != 0;
    }

    public final RelativeLayout c1() {
        View inflate = LayoutInflater.from(this).inflate(2131558889, (ViewGroup) this.W, false);
        inflate.getClass();
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        ((TextView) relativeLayout.findViewById(2131364608)).setTypeface(f4.c.f4883x);
        ((TextView) relativeLayout.findViewById(2131363650)).setTypeface(f4.c.f4882w);
        ((TextView) relativeLayout.findViewById(2131363727)).setTypeface(f4.c.f4883x);
        TextView textView = (TextView) relativeLayout.findViewById(2131364066);
        textView.setTypeface(f4.c.f4882w);
        textView.setOnClickListener(new c3(0, this));
        return relativeLayout;
    }

    @Override // c4.k0
    public final void d0(u0 u0Var) {
        n5.d dVar;
        n5.d dVar2;
        u0Var.getClass();
        if (u0Var instanceof l0) {
            t1();
        }
        if (u0Var.a() == null || (dVar = this.L) == null) {
            return;
        }
        dVar.getClass();
        String str = dVar.f8069a.F;
        r a8 = u0Var.a();
        a8.getClass();
        if (!u.m0(str, a8.f11355b, true) || (dVar2 = this.L) == null) {
            return;
        }
        r a10 = u0Var.a();
        a10.getClass();
        dVar2.i(a10, u0Var.c(), this);
    }

    public final RelativeLayout d1(g gVar) {
        int i = 0;
        View inflate = LayoutInflater.from(this).inflate(2131558890, (ViewGroup) this.W, false);
        inflate.getClass();
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        ImageView imageView = (ImageView) relativeLayout.findViewById(2131362366);
        ImageView imageView2 = (ImageView) relativeLayout.findViewById(2131362432);
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(2131363188);
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(2131362700);
        a4.l0 e10 = g0.d().e(gVar.h());
        float f = UptodownApp.I;
        e10.h(d.x(this));
        e10.e(imageView2, null);
        g0.d().e(gVar.e()).e(imageView, new m(relativeLayout2, linearLayout, this, 3));
        TextView textView = (TextView) relativeLayout.findViewById(2131364036);
        textView.setTypeface(f4.c.f4883x);
        int i6 = f.f6670l;
        String string = getString(2131952810, gVar.f11159b);
        string.getClass();
        Typeface typeface = f4.c.f4882w;
        typeface.getClass();
        Spanned fromHtml = HtmlCompat.fromHtml(string, 0);
        fromHtml.getClass();
        SpannableString spannableString = new SpannableString(fromHtml);
        kotlin.jvm.internal.b d10 = a0.d((StyleSpan[]) spannableString.getSpans(0, spannableString.length(), StyleSpan.class));
        while (d10.hasNext()) {
            StyleSpan styleSpan = (StyleSpan) d10.next();
            if (styleSpan.getStyle() == 1) {
                int spanStart = spannableString.getSpanStart(styleSpan);
                int spanEnd = spannableString.getSpanEnd(styleSpan);
                spannableString.removeSpan(styleSpan);
                spannableString.setSpan(new f(typeface, i), spanStart, spanEnd, 33);
            }
        }
        textView.setText(spannableString);
        ((TextView) relativeLayout.findViewById(2131363651)).setTypeface(f4.c.f4882w);
        ((TextView) relativeLayout.findViewById(2131364609)).setTypeface(f4.c.f4883x);
        ((TextView) relativeLayout.findViewById(2131364356)).setTypeface(f4.c.f4882w);
        ((TextView) relativeLayout.findViewById(2131364356)).setOnClickListener(new s(5, this));
        ((TextView) relativeLayout.findViewById(2131364183)).setTypeface(f4.c.f4882w);
        ((TextView) relativeLayout.findViewById(2131364183)).setOnClickListener(new s(6, this));
        TextView textView2 = (TextView) relativeLayout.findViewById(2131363609);
        textView2.setTypeface(f4.c.f4882w);
        textView2.setOnClickListener(new y2(this, gVar, textView2, relativeLayout, 0));
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "detected");
        bundle.putString("source", "wizard");
        x4.k kVar = UptodownApp.f3293g0;
        if (kVar == null || kVar.f11251e <= 0) {
            bundle.putString(TypedValues.TransitionType.S_FROM, "downloadFile");
        } else {
            bundle.putString(TypedValues.TransitionType.S_FROM, "fingerprint");
        }
        bundle.putString("appId", String.valueOf(gVar.f11158a));
        bundle.putString("fileId", String.valueOf(gVar.J));
        new android.support.v4.media.g(this, 20).E(bundle, "deeplink");
        return relativeLayout;
    }

    @Override // c4.k0
    public final void e0(String str) {
        n5.d dVar;
        n5.d dVar2 = this.L;
        if (dVar2 != null) {
            dVar2.getClass();
            if (!u.m0(dVar2.f8069a.F, str, true) || (dVar = this.L) == null) {
                return;
            }
            dVar.b(this);
        }
    }

    public final RelativeLayout e1() {
        View inflate = LayoutInflater.from(this).inflate(2131558893, (ViewGroup) this.W, false);
        inflate.getClass();
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(2131363193);
        if (relativeLayout2 != null) {
            ((TextView) relativeLayout2.findViewById(2131364401)).setTypeface(f4.c.f4882w);
        }
        ((TextView) relativeLayout.findViewById(2131364429)).setTypeface(f4.c.f4882w);
        RelativeLayout relativeLayout3 = (RelativeLayout) relativeLayout.findViewById(2131363214);
        float f = UptodownApp.I;
        ((TextView) relativeLayout.findViewById(2131363979)).setTypeface(f4.c.f4882w);
        relativeLayout3.setOnClickListener(new s(9, this));
        TextView textView = (TextView) relativeLayout.findViewById(2131363976);
        textView.setTypeface(f4.c.f4882w);
        textView.setOnClickListener(new s(10, this));
        ((TextView) relativeLayout.findViewById(2131363973)).setTypeface(f4.c.f4883x);
        ((TextView) relativeLayout.findViewById(2131363973)).setOnClickListener(new s(11, this));
        return relativeLayout;
    }

    @Override // c4.k0
    public final void f0(String str, String str2) {
        n5.d dVar;
        if (str != null) {
            Fragment W0 = W0();
            if (W0 instanceof f0) {
                ((f0) W0).v0(str);
            }
            n5.d dVar2 = this.L;
            if (dVar2 == null || !u.m0(dVar2.f8069a.F, str, true) || (dVar = this.L) == null) {
                return;
            }
            dVar.b(this);
        }
    }

    public final RelativeLayout f1() {
        View inflate = LayoutInflater.from(this).inflate(2131558894, (ViewGroup) this.W, false);
        inflate.getClass();
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(2131363194);
        if (relativeLayout2 != null) {
            ((TextView) relativeLayout2.findViewById(2131364401)).setTypeface(f4.c.f4882w);
        }
        ((TextView) relativeLayout.findViewById(2131364430)).setTypeface(f4.c.f4882w);
        RelativeLayout relativeLayout3 = (RelativeLayout) relativeLayout.findViewById(2131363235);
        if (Build.VERSION.SDK_INT >= 33) {
            ((TextView) relativeLayout.findViewById(2131364100)).setTypeface(f4.c.f4882w);
            ((TextView) relativeLayout.findViewById(2131364099)).setTypeface(f4.c.f4883x);
            SwitchCompat switchCompat = (SwitchCompat) relativeLayout.findViewById(2131363377);
            this.a0 = switchCompat;
            switchCompat.getClass();
            switchCompat.setChecked(ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0);
            SwitchCompat switchCompat2 = this.a0;
            switchCompat2.getClass();
            switchCompat2.setClickable(false);
            relativeLayout3.setOnClickListener(new s(19, this));
        } else if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(8);
        }
        RelativeLayout relativeLayout4 = (RelativeLayout) relativeLayout.findViewById(2131363276);
        ((ScrollableTextView) relativeLayout.findViewById(2131364490)).setTypeface(f4.c.f4882w);
        ((TextView) relativeLayout.findViewById(2131364488)).setTypeface(f4.c.f4882w);
        TextView textView = (TextView) relativeLayout.findViewById(2131364489);
        textView.setText(getString(2131952274, getString(2131951718)));
        textView.setTypeface(f4.c.f4883x);
        SwitchCompat switchCompat3 = (SwitchCompat) relativeLayout.findViewById(2131363379);
        this.Z = switchCompat3;
        switchCompat3.getClass();
        switchCompat3.setChecked(m());
        SwitchCompat switchCompat4 = this.Z;
        switchCompat4.getClass();
        switchCompat4.setClickable(false);
        relativeLayout4.setOnClickListener(new s(21, this));
        relativeLayout3.getClass();
        if (relativeLayout3.getVisibility() == 8) {
            relativeLayout.findViewById(2131364644).setVisibility(4);
        }
        TextView textView2 = (TextView) relativeLayout.findViewById(2131364067);
        textView2.setTypeface(f4.c.f4882w);
        textView2.setOnClickListener(new s(22, this));
        TextView textView3 = (TextView) relativeLayout.findViewById(2131363672);
        textView3.setTypeface(f4.c.f4882w);
        textView3.setOnClickListener(new s(23, this));
        return relativeLayout;
    }

    public final RelativeLayout g1() {
        View inflate = LayoutInflater.from(this).inflate(2131558896, (ViewGroup) this.W, false);
        inflate.getClass();
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        ((TextView) relativeLayout.findViewById(2131364610)).setTypeface(f4.c.f4883x);
        ((TextView) relativeLayout.findViewById(2131363652)).setTypeface(f4.c.f4882w);
        ((TextView) relativeLayout.findViewById(2131364319)).setTypeface(f4.c.f4883x);
        ((TextView) relativeLayout.findViewById(2131364357)).setTypeface(f4.c.f4882w);
        ((RelativeLayout) relativeLayout.findViewById(2131363270)).setOnClickListener(new s(26, this));
        ((TextView) relativeLayout.findViewById(2131364184)).setTypeface(f4.c.f4882w);
        ((RelativeLayout) relativeLayout.findViewById(2131363245)).setOnClickListener(new s(27, this));
        TextView textView = (TextView) relativeLayout.findViewById(2131363611);
        textView.setTypeface(f4.c.f4882w);
        textView.setEnabled(false);
        textView.setOnClickListener(new s(29, this));
        ProgressBar progressBar = (ProgressBar) relativeLayout.findViewById(2131363025);
        if (!this.f3305c0) {
            progressBar.setVisibility(0);
            return relativeLayout;
        }
        textView.setBackground(ContextCompat.getDrawable(this, 2131231182));
        textView.setEnabled(true);
        progressBar.setVisibility(8);
        return relativeLayout;
    }

    public final void h1() {
        RelativeLayout relativeLayout;
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate((String) null, 1);
        }
        RelativeLayout relativeLayout2 = this.f3312j0;
        if (relativeLayout2 != null && relativeLayout2.getVisibility() == 0 && (relativeLayout = this.f3312j0) != null) {
            relativeLayout.setVisibility(8);
        }
        TabLayout tabLayout = this.f3314l0;
        if (tabLayout == null || tabLayout.getSelectedTabPosition() != 3) {
            q1();
        }
    }

    @Override // c4.k0
    public final void i0(long j) {
        if (T()) {
            Y0();
            if (j <= 0) {
                k0();
                return;
            }
            if (this.f3320s0 == -1) {
                this.f3320s0 = j;
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
                e eVar = m0.f8288a;
                c0.s(lifecycleScope, n.f10348a, null, new n3(this, j, null, 0), 2);
            }
        }
    }

    public final void i1() {
        if (b1()) {
            return;
        }
        TabLayout tabLayout = this.f3314l0;
        boolean z9 = tabLayout != null && tabLayout.getSelectedTabPosition() == 0;
        boolean z10 = getSupportFragmentManager().getBackStackEntryCount() == 0;
        ViewPager2 viewPager2 = this.f3310h0;
        boolean z11 = viewPager2 != null && viewPager2.getCurrentItem() == 0;
        if (z9 && z10 && z11 && z3.f2928c) {
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            e eVar = m0.f8288a;
            c0.s(lifecycleScope, n.f10348a, null, new b.n(this, null, 17), 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j1() {
        /*
            r6 = this;
            boolean r0 = r6.b1()
            if (r0 != 0) goto L8
            goto La8
        L8:
            java.util.ArrayList r0 = r6.U
            java.util.Iterator r0 = r0.iterator()
            r0.getClass()
        L11:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L28
            java.lang.Object r1 = r0.next()
            r1.getClass()
            x4.e3 r1 = (x4.e3) r1
            android.widget.RelativeLayout r1 = r1.a()
            r1.removeAllViews()
            goto L11
        L28:
            android.widget.RelativeLayout r0 = r6.W
            r1 = 8
            if (r0 == 0) goto L31
            r0.setVisibility(r1)
        L31:
            android.widget.RelativeLayout r0 = r6.W
            if (r0 == 0) goto L38
            r0.removeAllViews()
        L38:
            android.widget.RelativeLayout r0 = r6.X
            if (r0 == 0) goto L3f
            r0.setVisibility(r1)
        L3f:
            r0 = 4
            boolean r0 = com.google.android.gms.internal.measurement.z3.C(r0, r6)
            r1 = 5
            boolean r1 = com.google.android.gms.internal.measurement.z3.C(r1, r6)
            if (r0 == 0) goto L53
            if (r1 == 0) goto L53
            r0 = 1
            java.lang.String r1 = "wizard_completed"
            com.google.android.gms.internal.measurement.z3.M(r6, r1, r0)
        L53:
            x4.g r0 = r6.f3307e0
            r1 = 0
            r6.f3307e0 = r1
            if (r0 == 0) goto La9
            boolean r2 = r0.k()
            if (r2 == 0) goto L6a
            boolean r2 = r0.j()
            if (r2 == 0) goto L6a
            r6.w1(r0)
            return
        L6a:
            r6.Y0()
            java.lang.String r2 = "is_device_tracking_registered"
            r3 = 0
            java.lang.String r4 = "SettingsPreferences"
            android.content.SharedPreferences r4 = r6.getSharedPreferences(r4, r3)     // Catch: java.lang.Exception -> L81
            boolean r5 = r4.contains(r2)     // Catch: java.lang.Exception -> L81
            if (r5 == 0) goto L81
            boolean r2 = r4.getBoolean(r2, r3)     // Catch: java.lang.Exception -> L81
            goto L82
        L81:
            r2 = r3
        L82:
            if (r2 == 0) goto L96
            androidx.lifecycle.LifecycleCoroutineScope r2 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r6)
            v7.e r4 = o7.m0.f8288a
            p7.c r4 = t7.n.f10348a
            c4.h3 r5 = new c4.h3
            r5.<init>(r6, r0, r1, r3)
            r0 = 2
            o7.c0.s(r2, r4, r1, r5, r0)
            goto La8
        L96:
            r6.f3309g0 = r3
            androidx.browser.trusted.c r1 = new androidx.browser.trusted.c
            r2 = 10
            r1.<init>(r2, r6, r0)
            r6.f3327z0 = r1
            android.os.Handler r0 = r6.f3308f0
            r2 = 2000(0x7d0, double:9.88E-321)
            r0.postDelayed(r1, r2)
        La8:
            return
        La9:
            r6.i1()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MainActivity.j1():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k1() {
        /*
            r5 = this;
            r5.j1()
            boolean r0 = r5.a1()
            if (r0 != 0) goto Lbe
            boolean r0 = r5.isFinishing()
            if (r0 != 0) goto Lb5
            android.widget.RelativeLayout r0 = r5.W
            if (r0 == 0) goto Lb5
            java.lang.String r0 = "wizard_completed"
            r1 = 0
            java.lang.String r2 = "SettingsPreferences"
            android.content.SharedPreferences r2 = r5.getSharedPreferences(r2, r1)     // Catch: java.lang.Exception -> L27
            boolean r3 = r2.contains(r0)     // Catch: java.lang.Exception -> L27
            if (r3 == 0) goto L27
            boolean r0 = r2.getBoolean(r0, r1)     // Catch: java.lang.Exception -> L27
            goto L28
        L27:
            r0 = r1
        L28:
            if (r0 != 0) goto Lb5
            android.widget.RelativeLayout r0 = r5.W
            r0.getClass()
            r0.setVisibility(r1)
            android.widget.RelativeLayout r0 = r5.W
            r0.getClass()
            c4.e r1 = new c4.e
            r2 = 8
            r1.<init>(r2)
            r0.setOnClickListener(r1)
            java.util.ArrayList r0 = r5.U
            java.util.Iterator r1 = r0.iterator()
            r1.getClass()
        L4a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L92
            java.lang.Object r2 = r1.next()
            r2.getClass()
            x4.e3 r2 = (x4.e3) r2
            int r3 = r2.f11141a
            r4 = 1
            if (r3 == r4) goto L8b
            r4 = 2
            if (r3 == r4) goto L80
            r4 = 3
            if (r3 == r4) goto L79
            r4 = 4
            if (r3 == r4) goto L72
            r4 = 5
            if (r3 == r4) goto L6b
            goto L4a
        L6b:
            android.widget.RelativeLayout r3 = r5.e1()
            r2.f11142b = r3
            goto L4a
        L72:
            android.widget.RelativeLayout r3 = r5.f1()
            r2.f11142b = r3
            goto L4a
        L79:
            android.widget.RelativeLayout r3 = r5.c1()
            r2.f11142b = r3
            goto L4a
        L80:
            x4.g r3 = r5.f3306d0
            if (r3 == 0) goto L4a
            android.widget.RelativeLayout r3 = r5.d1(r3)
            r2.f11142b = r3
            goto L4a
        L8b:
            android.widget.RelativeLayout r3 = r5.g1()
            r2.f11142b = r3
            goto L4a
        L92:
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto Lb1
            int r1 = r5.T
            if (r1 < 0) goto Lb1
            int r2 = r0.size()
            if (r1 >= r2) goto Lb1
            int r1 = r5.T
            java.lang.Object r0 = r0.get(r1)
            r0.getClass()
            x4.e3 r0 = (x4.e3) r0
            r5.o1(r0)
            goto Lb8
        Lb1:
            r5.j1()
            goto Lb8
        Lb5:
            r5.j1()
        Lb8:
            r5.l1()
            r5.t1()
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MainActivity.k1():void");
    }

    public final void l1() {
        RelativeLayout relativeLayout = this.S;
        if (relativeLayout != null) {
            relativeLayout.getClass();
            f3 f3Var = new f3(4, this);
            Animation loadAnimation = AnimationUtils.loadAnimation(this, 2130771998);
            float f = UptodownApp.I;
            boolean z9 = true;
            try {
                SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains("animations")) {
                    z9 = sharedPreferences.getBoolean("animations", true);
                }
            } catch (Exception unused) {
            }
            if (!z9) {
                f3Var.onAnimationEnd(loadAnimation);
                return;
            }
            float f10 = UptodownApp.I;
            loadAnimation.setAnimationListener(f3Var);
            relativeLayout.startAnimation(loadAnimation);
        }
    }

    public final void m1() {
        ProgressBar progressBar = this.f3313k0;
        if (progressBar == null || progressBar.getVisibility() == 0) {
            return;
        }
        ProgressBar progressBar2 = this.f3313k0;
        progressBar2.getClass();
        progressBar2.setVisibility(0);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = m0.f8288a;
        c0.s(lifecycleScope, v7.d.f10884a, null, new g3(this, null, 5), 2);
        m1 m1Var = this.f3316o0;
        if (m1Var != null) {
            m1Var.c();
        }
        g1 g1Var = this.f3315m0;
        if (g1Var != null) {
            g1Var.f10675p = false;
            g1Var.c();
        }
        w0 w0Var = this.n0;
        if (w0Var != null) {
            w0Var.f10675p = false;
            w0Var.c();
        }
    }

    @Override // g4.h
    public final void n() {
        SwitchCompat switchCompat = this.a0;
        if (switchCompat != null) {
            switchCompat.setChecked(false);
        }
        v1();
    }

    public final void n1() {
        long currentTimeMillis = (System.currentTimeMillis() - 86400000) + 3600000;
        SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
        sharedPreferences.getClass();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong("getLastTimePendingDialogShown", currentTimeMillis);
        edit.apply();
    }

    @Override // g4.h
    public final void o() {
        SwitchCompat switchCompat = this.a0;
        if (switchCompat != null) {
            switchCompat.setChecked(true);
        }
        v1();
    }

    public final void o1(e3 e3Var) {
        String str;
        g gVar;
        RelativeLayout relativeLayout = this.W;
        relativeLayout.getClass();
        relativeLayout.removeAllViews();
        RelativeLayout relativeLayout2 = this.W;
        relativeLayout2.getClass();
        relativeLayout2.addView(e3Var.a());
        switch (e3Var.f11141a) {
            case 1:
                str = "welcome";
                break;
            case 2:
                str = "deeplink";
                break;
            case 3:
                str = "continue";
                break;
            case 4:
                str = "permissions";
                break;
            case 5:
                str = "login";
                break;
            case 6:
                str = "kill";
                break;
            default:
                str = "null";
                break;
        }
        Bundle e10 = k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
        if (str.equals("deeplink") && (gVar = this.f3306d0) != null) {
            long j = gVar.f11158a;
            if (j > 0) {
                e10.putString("appId", String.valueOf(j));
            }
        }
        android.support.v4.media.g gVar2 = this.E;
        if (gVar2 != null) {
            gVar2.E(e10, "wizard");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c4.t2, c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        ViewPager2 viewPager2;
        Bundle extras;
        Bundle extras2;
        Bundle extras3;
        super.onCreate(bundle);
        setContentView(2131558687);
        float f = UptodownApp.I;
        if (d.n(this)) {
            startActivity(new Intent(this, (Class<?>) TvMainActivity.class));
            finish();
            return;
        }
        this.f3321t0 = (FrameLayout) findViewById(2131362189);
        this.f3323v0 = (FrameLayout) findViewById(2131362191);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131363264);
        this.S = relativeLayout;
        relativeLayout.getClass();
        int i = 8;
        relativeLayout.setOnClickListener(new c4.e(8));
        this.M = (RelativeLayout) findViewById(2131361921);
        if (UptodownApp.f3292f0) {
            RelativeLayout relativeLayout2 = this.S;
            relativeLayout2.getClass();
            relativeLayout2.setVisibility(8);
        }
        this.W = (RelativeLayout) findViewById(2131363303);
        this.X = (RelativeLayout) findViewById(2131363304);
        R();
        this.Y = (AppBarLayout) findViewById(2131361812);
        ((ImageView) findViewById(2131362248)).setOnClickListener(new s(20, this));
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(2131363230);
        ((TextView) findViewById(2131363984)).setTypeface(f4.c.f4883x);
        relativeLayout3.setOnClickListener(new s(28, this));
        int i6 = 6;
        ((ImageView) findViewById(2131362249)).setOnClickListener(new c3(i6, this));
        u1();
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new g3(this, 0 == true ? 1 : 0, 3), 3);
        String y9 = z3.y(this, "app_id_after_kill");
        int i10 = 2;
        int i11 = 4;
        int i12 = 1;
        int i13 = 0;
        if (y9 != null) {
            g gVar = new g();
            gVar.f11158a = Long.parseLong(y9);
            x0(gVar);
            z3.R(this, "app_id_after_kill", null);
        } else if (!z3.p(this, "wizard_completed", false)) {
            z3.Q(System.currentTimeMillis(), this, "last_sign_in_request_timestamp");
            RelativeLayout relativeLayout4 = this.X;
            relativeLayout4.getClass();
            relativeLayout4.setOnClickListener(new c4.e(8));
            RelativeLayout relativeLayout5 = this.X;
            relativeLayout5.getClass();
            relativeLayout5.setVisibility(0);
            RelativeLayout relativeLayout6 = this.W;
            relativeLayout6.getClass();
            relativeLayout6.setVisibility(8);
            RelativeLayout relativeLayout7 = this.W;
            relativeLayout7.getClass();
            relativeLayout7.setOnClickListener(new c4.e(8));
            if (z3.C(1, this) && z3.p(this, "gdpr_requested", false)) {
                RelativeLayout relativeLayout8 = this.W;
                relativeLayout8.getClass();
                relativeLayout8.setVisibility(0);
                O0(c1(), 3);
                if (!z3.C(4, this)) {
                    O0(f1(), 4);
                }
                if (!z3.C(5, this)) {
                    if (u2.h(this) != null) {
                        z3.M(this, "wizard_step_5_shown", true);
                    } else {
                        O0(e1(), 5);
                    }
                }
            } else {
                O0(g1(), 1);
            }
            this.T = 0;
            Object obj = this.U.get(0);
            obj.getClass();
            o1((e3) obj);
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            e eVar = m0.f8288a;
            c0.s(lifecycleScope, v7.d.f10884a, null, new g3(this, objArr == true ? 1 : 0, i10), 2);
        }
        runOnUiThread(new b3(2, this));
        d.F(this);
        if (!z3.p(this, "is_in_eea_checked", false)) {
            c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new g3(this, objArr7 == true ? 1 : 0, i11), 3);
        }
        if (getIntent() != null) {
            Intent intent = getIntent();
            intent.getClass();
            if ((intent.getFlags() & 1048576) != 1048576) {
                Uri data = getIntent().getData();
                if (data != null) {
                    String uri = data.toString();
                    uri.getClass();
                    String b7 = n4.d.b(data, this);
                    ActivityResultLauncher activityResultLauncher = this.F0;
                    if (b7 != null && u.k0(b7, ".apk", false)) {
                        String C = a.C(b7);
                        if (C != null) {
                            x4.k kVar = new x4.k();
                            kVar.f11249c = C;
                            LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(this);
                            e eVar2 = m0.f8288a;
                            c0.s(lifecycleScope2, n.f10348a, null, new j(this, C, kVar, objArr6 == true ? 1 : 0, 1), 2);
                        } else {
                            Intent intent2 = new Intent(getApplicationContext(), (Class<?>) InstallerActivity.class);
                            intent2.setData(data);
                            activityResultLauncher.launch(intent2);
                        }
                    } else if (b7 != null && (u.k0(b7, ".xapk", true) || u.k0(b7, ".apks", true) || u.k0(b7, ".apkm", true) || u.k0(b7, ".zip", true))) {
                        Intent intent3 = new Intent(getApplicationContext(), (Class<?>) InstallerActivity.class);
                        intent3.setData(data);
                        activityResultLauncher.launch(intent3);
                    } else if (u.p0(uri, "https://dw.uptodown.com/dwn/", false)) {
                        c0.s(LifecycleOwnerKt.getLifecycleScope(this), v7.d.f10884a, null, new m3(this, uri, objArr5 == true ? 1 : 0, i13), 2);
                    } else if (l7.m.q0(uri, "preregister-available", false)) {
                        String queryParameter = data.getQueryParameter("appID");
                        if (queryParameter != null && queryParameter.length() != 0) {
                            try {
                                String queryParameter2 = data.getQueryParameter("appID");
                                queryParameter2.getClass();
                                i0(Long.parseLong(queryParameter2));
                            } catch (NumberFormatException e10) {
                                e10.printStackTrace();
                            }
                        }
                    } else if (!d.n(this)) {
                        c0.s(LifecycleOwnerKt.getLifecycleScope(this), v7.d.f10884a, null, new m3(this, j5.c.d(data), objArr4 == true ? 1 : 0, i12), 2);
                    }
                }
                Intent intent4 = getIntent();
                String string = (intent4 == null || (extras3 = intent4.getExtras()) == null) ? null : extras3.getString("action");
                if (string != null) {
                    int i14 = MyFirebaseMessagingService.f3405r;
                    if (string.equalsIgnoreCase("notificationApp")) {
                        Intent intent5 = getIntent();
                        String string2 = (intent5 == null || (extras2 = intent5.getExtras()) == null) ? null : extras2.getString("appId");
                        if (string2 != null) {
                            w wVar = new w();
                            wVar.f7023a = -1L;
                            try {
                                wVar.f7023a = Long.parseLong(string2);
                            } catch (NumberFormatException e11) {
                                e11.printStackTrace();
                            }
                            if (wVar.f7023a > 0) {
                                Bundle extras4 = getIntent().getExtras();
                                String string3 = extras4 != null ? extras4.getString("packageName") : null;
                                long j = wVar.f7023a;
                                long currentTimeMillis = System.currentTimeMillis();
                                z3.Q(j, this, "fcm_app_id");
                                z3.R(this, "fcm_packagename", string3);
                                z3.O(this, -1, "fcm_download_id");
                                z3.Q(currentTimeMillis, this, "fcm_received_timestamp");
                                z3.Q(0L, this, "fcm_shown_timestamp");
                                c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new b.n((Object) this, (Object) wVar, (t6.c) (objArr3 == true ? 1 : 0), 14), 2);
                            }
                        }
                    } else if (string.equalsIgnoreCase("campaign")) {
                        Intent intent6 = getIntent();
                        String string4 = (intent6 == null || (extras = intent6.getExtras()) == null) ? null : extras.getString("campaign");
                        if (string4 != null && string4.equalsIgnoreCase("BlackFriday")) {
                            w0();
                        }
                    }
                } else {
                    r1 A = i5.A(this);
                    if (A != null && A.f11375e <= 0) {
                        c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new b.n((Object) this, (Object) A, (t6.c) (objArr2 == true ? 1 : 0), 15), 2);
                    }
                }
            }
        }
        getOnBackPressedDispatcher().addCallback(this, this.E0);
        this.K = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a3(i6, this));
        ViewPager2 viewPager22 = (ViewPager2) findViewById(2131364654);
        this.f3310h0 = viewPager22;
        if (viewPager22 != null) {
            viewPager22.setOffscreenPageLimit(4);
        }
        ViewPager2 viewPager23 = this.f3310h0;
        if (viewPager23 != null) {
            viewPager23.setUserInputEnabled(false);
        }
        this.f3314l0 = (TabLayout) findViewById(2131363488);
        this.f3312j0 = (RelativeLayout) findViewById(2131363110);
        ImageView imageView = (ImageView) findViewById(2131362305);
        this.f3324w0 = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new c3(i, this));
        }
        ImageView imageView2 = this.f3324w0;
        if (imageView2 != null) {
            ViewParent parent = imageView2.getParent();
            View view = parent instanceof View ? (View) parent : null;
            if (view != null) {
                view.post(new c(11, imageView2, this));
            }
        }
        this.f3325x0 = (ImageView) findViewById(2131362311);
        q3 q3Var = new q3(this, getSupportFragmentManager(), getLifecycle());
        ViewPager2 viewPager24 = this.f3310h0;
        if (viewPager24 != null) {
            viewPager24.setAdapter(q3Var);
        }
        if (UptodownApp.f3292f0) {
            ViewPager2 viewPager25 = this.f3310h0;
            if (viewPager25 != null) {
                viewPager25.setCurrentItem(G0, false);
            }
            UptodownApp.f3292f0 = false;
            if (G0 == 3) {
                AppBarLayout appBarLayout = this.Y;
                appBarLayout.getClass();
                appBarLayout.setVisibility(0);
                AppBarLayout appBarLayout2 = this.Y;
                appBarLayout2.getClass();
                appBarLayout2.setExpanded(false, false);
            }
        }
        TabLayout tabLayout = this.f3314l0;
        if (tabLayout == null || (viewPager2 = this.f3310h0) == null) {
            return;
        }
        new TabLayoutMediator(tabLayout, viewPager2, new a3(5, this)).attach();
        TabLayout tabLayout2 = this.f3314l0;
        tabLayout2.getClass();
        tabLayout2.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new p3(this));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b3 b3Var = this.f3326y0;
        Handler handler = this.f3308f0;
        if (b3Var != null) {
            handler.removeCallbacks(b3Var);
        }
        c cVar = this.f3327z0;
        if (cVar != null) {
            handler.removeCallbacks(cVar);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        keyEvent.getClass();
        return super.onKeyDown(i, keyEvent);
    }

    @Override // c4.k0, g4.s0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (a1()) {
            return;
        }
        t1();
        Object systemService = getSystemService("notification");
        systemService.getClass();
        ((NotificationManager) systemService).cancel(258);
        RelativeLayout relativeLayout = this.f3311i0;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        m1();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        super.onSaveInstanceState(new Bundle());
    }

    public final void p1(ArrayList arrayList) {
        AlertDialog alertDialog;
        if (arrayList.isEmpty() || b1()) {
            return;
        }
        AlertDialog alertDialog2 = this.F;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(2131558467, (ViewGroup) null, false);
        int i = 2131362635;
        if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362635)) != null) {
            i = 2131362639;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362639);
            if (linearLayout != null) {
                i = 2131363002;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(inflate, 2131363002);
                if (progressBar != null) {
                    i = 2131363692;
                    TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363692);
                    if (textView != null) {
                        i = 2131363835;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363835);
                        if (textView2 != null) {
                            i = 2131364376;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364376);
                            if (textView3 != null) {
                                RelativeLayout relativeLayout = (RelativeLayout) inflate;
                                textView3.setTypeface(f4.c.f4882w);
                                textView.setTypeface(f4.c.f4882w);
                                textView.setOnClickListener(new s(16, this));
                                textView2.setTypeface(f4.c.f4882w);
                                textView2.setOnClickListener(new c.e(8, this, arrayList));
                                Iterator it = arrayList.iterator();
                                it.getClass();
                                while (it.hasNext()) {
                                    Object next = it.next();
                                    next.getClass();
                                    g gVar = (g) next;
                                    progressBar.setVisibility(8);
                                    View inflate2 = getLayoutInflater().inflate(2131558466, (ViewGroup) null, false);
                                    int i6 = 2131362375;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate2, 2131362375);
                                    if (imageView != null) {
                                        i6 = 2131364037;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364037);
                                        if (textView4 != null) {
                                            a4.l0 e10 = g0.d().e(gVar.i());
                                            float f = UptodownApp.I;
                                            e10.g(d.f(this));
                                            e10.h(d.x(this));
                                            e10.e(imageView, null);
                                            textView4.setTypeface(f4.c.f4883x);
                                            textView4.setText(gVar.f11159b);
                                            linearLayout.addView((RelativeLayout) inflate2);
                                            Bundle bundle = new Bundle();
                                            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "detected");
                                            bundle.putString("source", "dialog");
                                            x4.k kVar = UptodownApp.f3293g0;
                                            if (kVar != null && kVar.f11251e > 0) {
                                                String str = gVar.F;
                                                kVar.getClass();
                                                if (kotlin.jvm.internal.l.a(str, kVar.f11249c)) {
                                                    bundle.putString(TypedValues.TransitionType.S_FROM, "fingerprint");
                                                    bundle.putString("appId", String.valueOf(gVar.f11158a));
                                                    bundle.putString("fileId", String.valueOf(gVar.J));
                                                    new android.support.v4.media.g(this, 20).E(bundle, "deeplink");
                                                }
                                            }
                                            bundle.putString(TypedValues.TransitionType.S_FROM, "downloadFile");
                                            bundle.putString("appId", String.valueOf(gVar.f11158a));
                                            bundle.putString("fileId", String.valueOf(gVar.J));
                                            new android.support.v4.media.g(this, 20).E(bundle, "deeplink");
                                        }
                                    }
                                    com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate2.getResources().getResourceName(i6)));
                                    return;
                                }
                                builder.setView(relativeLayout);
                                builder.setCancelable(true);
                                this.F = builder.create();
                                if (isFinishing() || (alertDialog = this.F) == null) {
                                    return;
                                }
                                Window window = alertDialog.getWindow();
                                if (window != null) {
                                    x.y(window, 0);
                                }
                                AlertDialog alertDialog3 = this.F;
                                alertDialog3.getClass();
                                alertDialog3.show();
                                SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
                                sharedPreferences.getClass();
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.putBoolean("welcome_popup_shown", true);
                                edit.apply();
                                return;
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    public final void q1() {
        AppBarLayout appBarLayout = this.Y;
        appBarLayout.getClass();
        appBarLayout.setVisibility(0);
        AppBarLayout appBarLayout2 = this.Y;
        appBarLayout2.getClass();
        appBarLayout2.setExpanded(true, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean r1() {
        /*
            Method dump skipped, instructions count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MainActivity.r1():boolean");
    }

    @Override // c4.k0, g4.h
    public final void s() {
        O();
    }

    public final void s1() {
        String str = null;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("url_526")) {
                str = sharedPreferences.getString("url_526", null);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (str == null) {
            str = "https://uptodown-android.uptodown.com/android";
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    @Override // g4.h
    public final void t() {
        O();
    }

    public final void t1() {
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new g3(this, null, 7), 3);
    }

    @Override // c4.k0, g4.h
    public final void u() {
        T0();
    }

    public final void u1() {
        ImageView imageView = (ImageView) findViewById(2131362249);
        w2 h = u2.h(this);
        if (isFinishing() || h == null || !h.d()) {
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        } else if (imageView != null) {
            imageView.setVisibility(8);
        }
        t1();
    }

    @Override // g4.h
    public final void v() {
        T0();
    }

    @Override // c4.k0
    public final void v0(long j) {
        String valueOf = String.valueOf(j);
        SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
        sharedPreferences.getClass();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("app_id_after_kill", valueOf);
        edit.apply();
        View rootView = getWindow().getDecorView().getRootView();
        int width = rootView.getWidth();
        int height = rootView.getHeight();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap createBitmap = Bitmap.createBitmap(width, height, config);
        rootView.draw(new Canvas(createBitmap));
        float applyDimension = TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics());
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, rootView.getWidth() / 2, rootView.getHeight() / 2, true);
        int i = (int) applyDimension;
        Bitmap createBitmap2 = Bitmap.createBitmap(createScaledBitmap.getWidth(), createScaledBitmap.getHeight(), config);
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, createScaledBitmap.getWidth(), createScaledBitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f = i;
        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(createScaledBitmap, rect, rect, paint);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131363303);
        this.W = relativeLayout;
        relativeLayout.getClass();
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = this.W;
        relativeLayout2.getClass();
        relativeLayout2.setOnClickListener(new c4.e(8));
        RelativeLayout relativeLayout3 = this.W;
        relativeLayout3.getClass();
        relativeLayout3.removeAllViews();
        View inflate = LayoutInflater.from(this).inflate(2131558892, (ViewGroup) this.W, false);
        inflate.getClass();
        RelativeLayout relativeLayout4 = (RelativeLayout) inflate;
        ((TextView) relativeLayout4.findViewById(2131364427)).setTypeface(f4.c.f4882w);
        TextView textView = (TextView) relativeLayout4.findViewById(2131364318);
        textView.setTypeface(f4.c.f4883x);
        textView.setText(getString(2131951876, getString(2131951718)));
        ((TextView) relativeLayout4.findViewById(2131364317)).setTypeface(f4.c.f4882w);
        TextView textView2 = (TextView) relativeLayout4.findViewById(2131363610);
        textView2.setTypeface(f4.c.f4883x);
        textView2.setEnabled(true);
        textView2.setOnClickListener(new c3(7, this));
        e3 e3Var = new e3();
        e3Var.f11141a = 6;
        e3Var.f11142b = relativeLayout4;
        o1(e3Var);
        ImageView imageView = (ImageView) relativeLayout4.findViewById(2131362514);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, 2130772038);
        loadAnimation.setStartOffset(500L);
        loadAnimation.setFillAfter(true);
        ImageView imageView2 = (ImageView) relativeLayout4.findViewById(2131362467);
        imageView2.setImageBitmap(createBitmap2);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, 2130772037);
        loadAnimation2.setFillAfter(true);
        loadAnimation2.setStartOffset(500L);
        loadAnimation2.setAnimationListener(new r3(imageView, loadAnimation, imageView2));
        imageView.startAnimation(loadAnimation);
        imageView2.startAnimation(loadAnimation2);
    }

    public final void v1() {
        if (this.W == null || this.T < 0) {
            return;
        }
        ArrayList arrayList = this.U;
        int size = arrayList.size();
        int i = this.T;
        if (size > i && ((e3) arrayList.get(i)).f11141a == 4 && m()) {
            if (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0) {
                TextView textView = (TextView) findViewById(2131364067);
                if (textView != null) {
                    textView.setBackground(ContextCompat.getDrawable(this, 2131231182));
                }
                if (textView != null) {
                    textView.setTextColor(ContextCompat.getColor(this, 2131100786));
                }
            }
        }
    }

    @Override // g4.h
    public final void w() {
        SwitchCompat switchCompat = this.Z;
        if (switchCompat != null) {
            switchCompat.setChecked(m());
        }
        v1();
    }

    public final void w1(g gVar) {
        K(gVar.O, new androidx.work.impl.utils.c(3, gVar, this), new androidx.lifecycle.k(9));
    }

    @Override // c4.k0
    public final void x0(g gVar) {
        gVar.getClass();
        if (T()) {
            Fragment W0 = W0();
            RelativeLayout relativeLayout = this.f3312j0;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(new c4.e(8));
            }
            RelativeLayout relativeLayout2 = this.f3312j0;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
            }
            if (!(W0 instanceof f0)) {
                R0(gVar, false);
            } else if (((f0) W0).B().f11158a != gVar.f11158a) {
                R0(gVar, true);
            }
            AppBarLayout appBarLayout = this.Y;
            appBarLayout.getClass();
            appBarLayout.setVisibility(8);
        }
    }

    public final void x1(x4.j jVar) {
        jVar.getClass();
        if (T()) {
            int i = jVar.f11224a;
            if (i == 523) {
                S0(1);
            } else if (i == 831) {
                S0(2);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.getClass();
            String str = jVar.f11225b;
            str.getClass();
            w0 w0Var = new w0(str);
            jVar.getClass();
            Bundle bundle = new Bundle();
            bundle.putInt("id", jVar.f11224a);
            bundle.putString("name", jVar.f11225b);
            bundle.putString("description", jVar.f11226l);
            bundle.putBoolean("isFloating", jVar.f11227m);
            bundle.putInt("parentCategoryId", jVar.f11229o);
            bundle.putInt("isGame", jVar.f11230p);
            bundle.putBoolean("isLeaf", jVar.f11228n);
            w0Var.setArguments(bundle);
            beginTransaction.add(2131362180, w0Var);
            beginTransaction.addToBackStack("appsCategory");
            if (isFinishing() || getSupportFragmentManager().isDestroyed()) {
                return;
            }
            try {
                beginTransaction.commitAllowingStateLoss();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public final void y1(x4.j jVar) {
        jVar.getClass();
        if (T()) {
            Y0();
            z1 z1Var = new z1();
            z1Var.f10683m = jVar;
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.getClass();
            if (((CoordinatorLayout) findViewById(2131363229)) == null) {
                String string = getString(2131951998);
                string.getClass();
                A(string);
                return;
            }
            try {
                float f = UptodownApp.I;
                d.C(beginTransaction, this);
                beginTransaction.add(2131363229, z1Var);
                beginTransaction.addToBackStack(z1Var.f10683m.f11225b);
                if (W0() instanceof z1) {
                    beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                }
                if (isFinishing() || getSupportFragmentManager().isDestroyed()) {
                    return;
                }
                try {
                    beginTransaction.commitAllowingStateLoss();
                } catch (Exception e10) {
                    e10.printStackTrace();
                    String string2 = getString(2131951998);
                    string2.getClass();
                    A(string2);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                String string3 = getString(2131951998);
                string3.getClass();
                A(string3);
            }
        }
    }

    @Override // c4.t2
    public final w2 z0() {
        w2 h = u2.h(this);
        if ((h != null ? h.f11431a : null) == null || !u2.g(this)) {
            return null;
        }
        return h;
    }

    @Override // c4.t2
    public final void E0() {
    }

    @Override // c4.t2
    public final void F0() {
    }

    @Override // c4.t2
    public final void y0() {
    }

    @Override // c4.t2
    public final void C0(w2 w2Var) {
    }

    @Override // c4.t2
    public final void D0(w2 w2Var, String str) {
    }
}
