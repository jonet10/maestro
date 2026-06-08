package com.uptodown.activities;

import a2.s;
import android.content.Intent;
import android.content.SharedPreferences;
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
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c4.j0;
import c4.pd;
import c4.sc;
import c4.sd;
import c4.td;
import c4.ud;
import c4.vd;
import c4.w4;
import com.uptodown.UptodownApp;
import com.uptodown.activities.WishlistActivity;
import e4.e1;
import f0.i;
import java.io.File;
import kotlin.jvm.internal.y;
import l5.f;
import o7.c0;
import o7.m0;
import p6.m;
import t4.k1;
import t6.c;
import t7.n;
import v7.e;
import x4.d0;
import x4.u0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class WishlistActivity extends w4 {

    /* renamed from: g0, reason: collision with root package name */
    public static final /* synthetic */ int f3367g0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    public e1 f3369c0;

    /* renamed from: e0, reason: collision with root package name */
    public final ActivityResultLauncher f3371e0;

    /* renamed from: f0, reason: collision with root package name */
    public final ActivityResultLauncher f3372f0;
    public final String Z = "WishlistActivity";
    public final m a0 = new m(new pd(this, 0));

    /* renamed from: b0, reason: collision with root package name */
    public final ViewModelLazy f3368b0 = new ViewModelLazy(y.a(vd.class), new ud(this, 0), new td(this), new ud(this, 1));

    /* renamed from: d0, reason: collision with root package name */
    public final i f3370d0 = new i(this, 17);

    public WishlistActivity() {
        final int i = 0;
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: c4.qd

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ WishlistActivity f2030b;

            {
                this.f2030b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                int i6 = i;
                WishlistActivity wishlistActivity = this.f2030b;
                t6.c cVar = null;
                int i10 = 2;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i6) {
                    case 0:
                        int i11 = WishlistActivity.f3367g0;
                        if (activityResult.getResultCode() == -1) {
                            Intent data = activityResult.getData();
                            if (kotlin.jvm.internal.l.a(data != null ? Boolean.valueOf(data.getBooleanExtra("wishlistChanged", false)) : null, Boolean.TRUE)) {
                                wishlistActivity.f3369c0 = null;
                                vd O0 = wishlistActivity.O0();
                                O0.getClass();
                                O0.f2237c = false;
                                O0.f2239e = 0;
                                O0.a(wishlistActivity);
                                wishlistActivity.setResult(2);
                                break;
                            }
                        }
                        break;
                    default:
                        int i12 = WishlistActivity.f3367g0;
                        if (activityResult.getResultCode() == 1) {
                            wishlistActivity.P0();
                            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(wishlistActivity);
                            lifecycleScope.getClass();
                            float f = UptodownApp.I;
                            b4.d.A(wishlistActivity);
                            b4.d.z(wishlistActivity);
                            v7.e eVar = o7.m0.f8288a;
                            o7.c0.s(lifecycleScope, v7.d.f10884a, null, new a6(wishlistActivity, cVar, i10), 2);
                            break;
                        }
                        break;
                }
            }
        });
        registerForActivityResult.getClass();
        this.f3371e0 = registerForActivityResult;
        final int i6 = 1;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: c4.qd

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ WishlistActivity f2030b;

            {
                this.f2030b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                int i62 = i6;
                WishlistActivity wishlistActivity = this.f2030b;
                t6.c cVar = null;
                int i10 = 2;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i62) {
                    case 0:
                        int i11 = WishlistActivity.f3367g0;
                        if (activityResult.getResultCode() == -1) {
                            Intent data = activityResult.getData();
                            if (kotlin.jvm.internal.l.a(data != null ? Boolean.valueOf(data.getBooleanExtra("wishlistChanged", false)) : null, Boolean.TRUE)) {
                                wishlistActivity.f3369c0 = null;
                                vd O0 = wishlistActivity.O0();
                                O0.getClass();
                                O0.f2237c = false;
                                O0.f2239e = 0;
                                O0.a(wishlistActivity);
                                wishlistActivity.setResult(2);
                                break;
                            }
                        }
                        break;
                    default:
                        int i12 = WishlistActivity.f3367g0;
                        if (activityResult.getResultCode() == 1) {
                            wishlistActivity.P0();
                            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(wishlistActivity);
                            lifecycleScope.getClass();
                            float f = UptodownApp.I;
                            b4.d.A(wishlistActivity);
                            b4.d.z(wishlistActivity);
                            v7.e eVar = o7.m0.f8288a;
                            o7.c0.s(lifecycleScope, v7.d.f10884a, null, new a6(wishlistActivity, cVar, i10), 2);
                            break;
                        }
                        break;
                }
            }
        });
        registerForActivityResult2.getClass();
        this.f3372f0 = registerForActivityResult2;
    }

    @Override // c4.w4
    public final String F0() {
        return this.Z;
    }

    public final k1 N0() {
        return (k1) this.a0.getValue();
    }

    public final vd O0() {
        return (vd) this.f3368b0.getValue();
    }

    public final void P0() {
        String str;
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2 = getSharedPreferences("SharedPreferencesUser", 0);
        try {
            sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (sharedPreferences.contains("UTOKEN")) {
            str = sharedPreferences.getString("UTOKEN", null);
            if (str == null || sharedPreferences2.getString("is_turbo", null) != null) {
                O0().a(this);
            } else {
                new Handler(Looper.getMainLooper()).postDelayed(new s(this, 8), 500L);
                return;
            }
        }
        str = null;
        if (str == null) {
        }
        O0().a(this);
    }

    public final void Q0(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = m0.f8288a;
        c0.s(lifecycleScope, n.f10348a, null, new sc(this, str, null, 2), 2);
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
        e1 e1Var = this.f3369c0;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // c4.k0
    public final void f0(String str, String str2) {
        e1 e1Var = this.f3369c0;
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
            e eVar = m0.f8288a;
            c0.s(lifecycleScope, n.f10348a, null, new j0(this, j, str, (c) null, 6), 2);
        }
    }

    @Override // c4.k0
    public final void n0() {
        e1 e1Var = this.f3369c0;
        if (e1Var != null) {
            e1Var.b();
        }
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = N0().f9948a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        k1 N0 = N0();
        if (drawable != null) {
            N0.f9951m.setNavigationIcon(drawable);
            N0.f9951m.setNavigationContentDescription(getString(2131951735));
        }
        Toolbar toolbar = N0.f9951m;
        TextView textView = N0.f9952n;
        RecyclerView recyclerView = N0.f9950l;
        final int i = 0;
        toolbar.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: c4.rd

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ WishlistActivity f2061b;

            {
                this.f2061b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i6 = i;
                WishlistActivity wishlistActivity = this.f2061b;
                switch (i6) {
                    case 0:
                        int i10 = WishlistActivity.f3367g0;
                        wishlistActivity.finish();
                        break;
                    default:
                        int i11 = WishlistActivity.f3367g0;
                        wishlistActivity.setResult(1);
                        wishlistActivity.finish();
                        break;
                }
            }
        });
        N0.f9954p.setTypeface(f4.c.f4882w);
        final int i6 = 1;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        int dimension = (int) getResources().getDimension(2131166251);
        N0().f9950l.addItemDecoration(new f(dimension, dimension));
        recyclerView.setItemAnimator(defaultItemAnimator);
        N0.f9953o.setTypeface(f4.c.f4883x);
        textView.setTypeface(f4.c.f4882w);
        textView.setOnClickListener(new View.OnClickListener(this) { // from class: c4.rd

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ WishlistActivity f2061b;

            {
                this.f2061b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = i6;
                WishlistActivity wishlistActivity = this.f2061b;
                switch (i62) {
                    case 0:
                        int i10 = WishlistActivity.f3367g0;
                        wishlistActivity.finish();
                        break;
                    default:
                        int i11 = WishlistActivity.f3367g0;
                        wishlistActivity.setResult(1);
                        wishlistActivity.finish();
                        break;
                }
            }
        });
        N0.f9949b.setOnClickListener(new c4.e(25));
        recyclerView.addOnScrollListener(new sd(linearLayoutManager, this));
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new b.s(this, (c) null, 19), 2);
        P0();
    }

    @Override // c4.k0
    public final void p0(File file) {
        e1 e1Var = this.f3369c0;
        if (e1Var != null) {
            e1Var.b();
        }
        e1 e1Var2 = this.f3369c0;
        if (e1Var2 != null) {
            e1Var2.a(this, file);
        }
    }

    @Override // c4.k0
    public final void q0(File file) {
        file.getClass();
        e1 e1Var = this.f3369c0;
        if (e1Var != null) {
            e1Var.a(this, file);
        }
    }

    @Override // c4.k0
    public final void r0(File file) {
        e1 e1Var = this.f3369c0;
        if (e1Var != null) {
            e1Var.c(this, file);
        }
    }
}
