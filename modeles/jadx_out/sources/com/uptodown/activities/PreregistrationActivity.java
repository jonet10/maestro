package com.uptodown.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.inputmethod.a;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.s;
import c4.a7;
import c4.b7;
import c4.c7;
import c4.e;
import c4.e7;
import c4.k0;
import c4.z6;
import com.uptodown.UptodownApp;
import e4.d0;
import f0.i;
import f4.c;
import kotlin.jvm.internal.y;
import l5.f;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import t4.j0;
import t7.n;
import u4.z1;
import v7.d;
import x4.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class PreregistrationActivity extends k0 {
    public static final /* synthetic */ int T = 0;
    public d0 Q;
    public final ActivityResultLauncher S;
    public final ViewModelLazy O = new ViewModelLazy(y.a(e7.class), new c7(this, 0), new b7(this), new c7(this, 1));
    public final m P = new m(new z6(this, 0));
    public final i R = new i(this, 10);

    public PreregistrationActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 7));
        registerForActivityResult.getClass();
        this.S = registerForActivityResult;
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = y0().f9902a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        j0 y02 = y0();
        if (drawable != null) {
            y02.f9906n.setNavigationIcon(drawable);
            y02.f9906n.setNavigationContentDescription(getString(2131951735));
        }
        Toolbar toolbar = y02.f9906n;
        RecyclerView recyclerView = y02.f9905m;
        TextView textView = y02.f9907o;
        toolbar.setNavigationOnClickListener(new a7(this, 0));
        y02.f9909q.setTypeface(c.f4882w);
        textView.setTypeface(c.f4882w);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        int dimension = (int) getResources().getDimension(2131166251);
        y0().f9905m.addItemDecoration(new f(dimension, dimension));
        y02.f9908p.setTypeface(c.f4883x);
        y02.f9904l.setOnClickListener(new e(17));
        textView.setOnClickListener(new a7(this, 1));
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new s(this, (t6.c) null, 13), 2);
    }

    @Override // c4.k0, g4.s0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        e7 e7Var = (e7) this.O.getValue();
        e7Var.getClass();
        a0 viewModelScope = ViewModelKt.getViewModelScope(e7Var);
        v7.e eVar = m0.f8288a;
        c0.s(viewModelScope, d.f10884a, null, new b.f(e7Var, false, this, (t6.c) null), 2);
    }

    public final j0 y0() {
        return (j0) this.P.getValue();
    }

    public final void z0(j jVar) {
        jVar.getClass();
        z1 z1Var = new z1();
        z1Var.f10683m = jVar;
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        float f = UptodownApp.I;
        beginTransaction.getClass();
        b4.d.C(beginTransaction, this);
        beginTransaction.add(y0().f9903b.getId(), z1Var, (String) null).addToBackStack(String.valueOf(jVar.f11224a)).commit();
    }
}
