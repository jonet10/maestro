package com.uptodown.activities;

import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import b.s;
import b6.a;
import c4.d;
import c4.f7;
import c4.g7;
import c4.h7;
import c4.i7;
import c4.w4;
import c4.w6;
import e4.e1;
import f0.i;
import kotlin.jvm.internal.y;
import l5.f;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import r7.o0;
import t4.k0;
import t6.c;
import t7.n;
import v7.e;
import x4.d0;
import x4.u0;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class PublicListActivity extends w4 {

    /* renamed from: e0, reason: collision with root package name */
    public static final /* synthetic */ int f3334e0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    public e1 f3336c0;
    public final String Z = "PublicListActivity";
    public final m a0 = new m(new w6(this, 1));

    /* renamed from: b0, reason: collision with root package name */
    public final ViewModelLazy f3335b0 = new ViewModelLazy(y.a(i7.class), new h7(this, 0), new g7(this), new h7(this, 1));

    /* renamed from: d0, reason: collision with root package name */
    public final i f3337d0 = new i(this, 11);

    @Override // c4.w4
    public final String F0() {
        return this.Z;
    }

    public final k0 N0() {
        return (k0) this.a0.getValue();
    }

    public final i7 O0() {
        return (i7) this.f3335b0.getValue();
    }

    public final void P0(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = m0.f8288a;
        c0.s(lifecycleScope, n.f10348a, null, new a(this, str, null, 23), 2);
    }

    @Override // c4.k0
    public final void b0(d0 d0Var) {
        d0Var.getClass();
        P0(d0Var.b());
    }

    @Override // c4.k0
    public final void d0(u0 u0Var) {
        u0Var.getClass();
        P0(u0Var.b());
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        Bundle extras;
        super.onCreate(bundle);
        c cVar = null;
        w2 w2Var = (getIntent() == null || (extras = getIntent().getExtras()) == null || !extras.containsKey("user")) ? null : (w2) extras.getParcelable("user");
        if (w2Var != null && (str = w2Var.f11431a) != null && str.length() != 0) {
            RelativeLayout relativeLayout = N0().f9942a;
            relativeLayout.getClass();
            setContentView(relativeLayout);
            N0().f9945m.setNavigationIcon(ContextCompat.getDrawable(this, 2131230922));
            N0().f9945m.setNavigationContentDescription(getString(2131951735));
            N0().f9945m.setNavigationOnClickListener(new d(this, 12));
            N0().f9947o.setTypeface(f4.c.f4882w);
            N0().f9946n.setTypeface(f4.c.f4883x);
            N0().f9947o.setText(getString(2131952746, w2Var.f11434m));
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
            N0().f9944l.setLayoutManager(linearLayoutManager);
            N0().f9944l.setItemAnimator(new DefaultItemAnimator());
            DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
            defaultItemAnimator.setSupportsChangeAnimations(false);
            int dimension = (int) getResources().getDimension(2131166251);
            N0().f9944l.addItemDecoration(new f(dimension, dimension));
            N0().f9944l.setItemAnimator(defaultItemAnimator);
            N0().f9944l.addOnScrollListener(new f7(linearLayoutManager, this));
            o0 o0Var = O0().f1722c;
            String str2 = w2Var.f11431a;
            str2.getClass();
            o0Var.getClass();
            o0Var.g(null, str2);
            i7 O0 = O0();
            O0.getClass();
            a0 viewModelScope = ViewModelKt.getViewModelScope(O0);
            e eVar = m0.f8288a;
            c0.s(viewModelScope, v7.d.f10884a, null, new b.n(O0, this, cVar, 24), 2);
        }
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new s(this, cVar, 14), 2);
    }
}
