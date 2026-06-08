package com.uptodown.activities;

import a2.s;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b6.a;
import c4.c8;
import c4.e8;
import c4.f8;
import c4.g8;
import c4.i8;
import c4.j0;
import c4.w4;
import c4.z7;
import com.uptodown.UptodownApp;
import com.uptodown.activities.RecommendedActivity;
import e4.e1;
import f0.i;
import java.io.File;
import kotlin.jvm.internal.y;
import l5.f;
import o7.c0;
import p6.m;
import t4.m0;
import t6.c;
import t7.n;
import v7.e;
import x4.d0;
import x4.u0;
import x4.u2;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class RecommendedActivity extends w4 {

    /* renamed from: g0, reason: collision with root package name */
    public static final /* synthetic */ int f3338g0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    public e1 f3340c0;

    /* renamed from: e0, reason: collision with root package name */
    public final ActivityResultLauncher f3342e0;

    /* renamed from: f0, reason: collision with root package name */
    public final ActivityResultLauncher f3343f0;
    public final String Z = "RecommendedActivity";
    public final m a0 = new m(new z7(this, 1));

    /* renamed from: b0, reason: collision with root package name */
    public final ViewModelLazy f3339b0 = new ViewModelLazy(y.a(i8.class), new g8(this, 0), new f8(this), new g8(this, 1));

    /* renamed from: d0, reason: collision with root package name */
    public final i f3341d0 = new i(this, 12);

    public RecommendedActivity() {
        final int i = 0;
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: c4.a8

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RecommendedActivity f1384b;

            {
                this.f1384b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                int i6 = i;
                t6.c cVar = null;
                RecommendedActivity recommendedActivity = this.f1384b;
                int i10 = 2;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i6) {
                    case 0:
                        int i11 = RecommendedActivity.f3338g0;
                        if (activityResult.getResultCode() == 1) {
                            recommendedActivity.P0();
                            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(recommendedActivity);
                            lifecycleScope.getClass();
                            float f = UptodownApp.I;
                            b4.d.A(recommendedActivity);
                            b4.d.z(recommendedActivity);
                            v7.e eVar = o7.m0.f8288a;
                            o7.c0.s(lifecycleScope, v7.d.f10884a, null, new a6(recommendedActivity, cVar, i10), 2);
                            break;
                        }
                        break;
                    default:
                        int i12 = RecommendedActivity.f3338g0;
                        if (activityResult.getResultCode() == -1) {
                            Intent data = activityResult.getData();
                            if (kotlin.jvm.internal.l.a(data != null ? Boolean.valueOf(data.getBooleanExtra("recommendedAppsChanged", false)) : null, Boolean.TRUE)) {
                                recommendedActivity.f3340c0 = null;
                                i8 O0 = recommendedActivity.O0();
                                O0.getClass();
                                O0.f1729e = false;
                                O0.g = 0;
                                O0.a(recommendedActivity);
                                recommendedActivity.setResult(2);
                                break;
                            }
                        }
                        break;
                }
            }
        });
        registerForActivityResult.getClass();
        this.f3342e0 = registerForActivityResult;
        final int i6 = 1;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: c4.a8

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RecommendedActivity f1384b;

            {
                this.f1384b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                int i62 = i6;
                t6.c cVar = null;
                RecommendedActivity recommendedActivity = this.f1384b;
                int i10 = 2;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i62) {
                    case 0:
                        int i11 = RecommendedActivity.f3338g0;
                        if (activityResult.getResultCode() == 1) {
                            recommendedActivity.P0();
                            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(recommendedActivity);
                            lifecycleScope.getClass();
                            float f = UptodownApp.I;
                            b4.d.A(recommendedActivity);
                            b4.d.z(recommendedActivity);
                            v7.e eVar = o7.m0.f8288a;
                            o7.c0.s(lifecycleScope, v7.d.f10884a, null, new a6(recommendedActivity, cVar, i10), 2);
                            break;
                        }
                        break;
                    default:
                        int i12 = RecommendedActivity.f3338g0;
                        if (activityResult.getResultCode() == -1) {
                            Intent data = activityResult.getData();
                            if (kotlin.jvm.internal.l.a(data != null ? Boolean.valueOf(data.getBooleanExtra("recommendedAppsChanged", false)) : null, Boolean.TRUE)) {
                                recommendedActivity.f3340c0 = null;
                                i8 O0 = recommendedActivity.O0();
                                O0.getClass();
                                O0.f1729e = false;
                                O0.g = 0;
                                O0.a(recommendedActivity);
                                recommendedActivity.setResult(2);
                                break;
                            }
                        }
                        break;
                }
            }
        });
        registerForActivityResult2.getClass();
        this.f3343f0 = registerForActivityResult2;
    }

    @Override // c4.w4
    public final String F0() {
        return this.Z;
    }

    public final m0 N0() {
        return (m0) this.a0.getValue();
    }

    public final i8 O0() {
        return (i8) this.f3339b0.getValue();
    }

    public final void P0() {
        String str;
        w2 h = u2.h(this);
        if (h == null || (str = h.f11431a) == null || str.length() == 0) {
            new Handler(Looper.getMainLooper()).postDelayed(new s(this, 7), 500L);
        } else {
            O0().a(this);
        }
    }

    public final void Q0(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = o7.m0.f8288a;
        c0.s(lifecycleScope, n.f10348a, null, new a(this, str, null, 24), 2);
    }

    @Override // c4.k0
    public final void b0(d0 d0Var) {
        d0Var.getClass();
        Q0(d0Var.b());
    }

    @Override // c4.k0
    public final void d0(u0 u0Var) {
        u0Var.getClass();
        Q0(u0Var.b());
    }

    @Override // c4.k0
    public final void e0(String str) {
        e1 e1Var = this.f3340c0;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // c4.k0
    public final void f0(String str, String str2) {
        e1 e1Var = this.f3340c0;
        if (e1Var != null) {
            e1Var.b();
        }
        if (str2 == null || str2.length() == 0) {
            return;
        }
        String string = getString(2131952081, str2);
        string.getClass();
        A(string);
    }

    @Override // c4.k0
    public final void j0(long j, String str) {
        if (T()) {
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            e eVar = o7.m0.f8288a;
            c0.s(lifecycleScope, n.f10348a, null, new j0(this, j, str, (c) null, 2), 2);
        }
    }

    @Override // c4.k0
    public final void n0() {
        e1 e1Var = this.f3340c0;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = N0().f9999a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        m0 N0 = N0();
        if (drawable != null) {
            N0.f10003n.setNavigationIcon(drawable);
            N0.f10003n.setNavigationContentDescription(getString(2131951735));
        }
        Toolbar toolbar = N0.f10003n;
        TextView textView = N0.f10004o;
        RecyclerView recyclerView = N0.f10001l;
        final int i = 0;
        toolbar.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: c4.b8

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RecommendedActivity f1424b;

            {
                this.f1424b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i6 = i;
                RecommendedActivity recommendedActivity = this.f1424b;
                switch (i6) {
                    case 0:
                        int i10 = RecommendedActivity.f3338g0;
                        recommendedActivity.finish();
                        break;
                    case 1:
                        int i11 = RecommendedActivity.f3338g0;
                        recommendedActivity.setResult(1);
                        recommendedActivity.finish();
                        break;
                    default:
                        int i12 = RecommendedActivity.f3338g0;
                        recommendedActivity.N0().f10002m.setChecked(true ^ recommendedActivity.N0().f10002m.isChecked());
                        float f = UptodownApp.I;
                        if (b4.d.t() && recommendedActivity.T()) {
                            i8 O0 = recommendedActivity.O0();
                            O0.getClass();
                            o7.c0.s(ViewModelKt.getViewModelScope(O0), null, null, new h8(O0, recommendedActivity, null, 0), 3);
                            break;
                        }
                        break;
                }
            }
        });
        N0.f10007r.setTypeface(f4.c.f4882w);
        final int i6 = 1;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        int dimension = (int) getResources().getDimension(2131166251);
        recyclerView.addItemDecoration(new f(dimension, dimension));
        recyclerView.setItemAnimator(defaultItemAnimator);
        N0.f10005p.setTypeface(f4.c.f4883x);
        N0.f10006q.setTypeface(f4.c.f4883x);
        textView.setTypeface(f4.c.f4883x);
        textView.setOnClickListener(new View.OnClickListener(this) { // from class: c4.b8

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RecommendedActivity f1424b;

            {
                this.f1424b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = i6;
                RecommendedActivity recommendedActivity = this.f1424b;
                switch (i62) {
                    case 0:
                        int i10 = RecommendedActivity.f3338g0;
                        recommendedActivity.finish();
                        break;
                    case 1:
                        int i11 = RecommendedActivity.f3338g0;
                        recommendedActivity.setResult(1);
                        recommendedActivity.finish();
                        break;
                    default:
                        int i12 = RecommendedActivity.f3338g0;
                        recommendedActivity.N0().f10002m.setChecked(true ^ recommendedActivity.N0().f10002m.isChecked());
                        float f = UptodownApp.I;
                        if (b4.d.t() && recommendedActivity.T()) {
                            i8 O0 = recommendedActivity.O0();
                            O0.getClass();
                            o7.c0.s(ViewModelKt.getViewModelScope(O0), null, null, new h8(O0, recommendedActivity, null, 0), 3);
                            break;
                        }
                        break;
                }
            }
        });
        final int i10 = 2;
        N0().f10002m.setOnClickListener(new View.OnClickListener(this) { // from class: c4.b8

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ RecommendedActivity f1424b;

            {
                this.f1424b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = i10;
                RecommendedActivity recommendedActivity = this.f1424b;
                switch (i62) {
                    case 0:
                        int i102 = RecommendedActivity.f3338g0;
                        recommendedActivity.finish();
                        break;
                    case 1:
                        int i11 = RecommendedActivity.f3338g0;
                        recommendedActivity.setResult(1);
                        recommendedActivity.finish();
                        break;
                    default:
                        int i12 = RecommendedActivity.f3338g0;
                        recommendedActivity.N0().f10002m.setChecked(true ^ recommendedActivity.N0().f10002m.isChecked());
                        float f = UptodownApp.I;
                        if (b4.d.t() && recommendedActivity.T()) {
                            i8 O0 = recommendedActivity.O0();
                            O0.getClass();
                            o7.c0.s(ViewModelKt.getViewModelScope(O0), null, null, new h8(O0, recommendedActivity, null, 0), 3);
                            break;
                        }
                        break;
                }
            }
        });
        N0.f10000b.setOnClickListener(new c4.e(18));
        recyclerView.addOnScrollListener(new c8(linearLayoutManager, this));
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        p7.c cVar = n.f10348a;
        c cVar2 = null;
        c0.s(lifecycleScope, cVar, null, new e8(this, cVar2, i), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new e8(this, cVar2, i6), 2);
        P0();
    }

    @Override // c4.k0
    public final void p0(File file) {
        e1 e1Var = this.f3340c0;
        if (e1Var != null) {
            e1Var.b();
        }
        e1 e1Var2 = this.f3340c0;
        if (e1Var2 != null) {
            e1Var2.a(this, file);
        }
    }

    @Override // c4.k0
    public final void q0(File file) {
        file.getClass();
        e1 e1Var = this.f3340c0;
        if (e1Var != null) {
            e1Var.a(this, file);
        }
    }

    @Override // c4.k0
    public final void r0(File file) {
        e1 e1Var = this.f3340c0;
        if (e1Var != null) {
            e1Var.c(this, file);
        }
    }
}
