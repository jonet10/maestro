package com.uptodown.activities;

import a4.g0;
import a4.l0;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.inputmethod.a;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.room.g;
import c4.a2;
import c4.b2;
import c4.c2;
import c4.f2;
import c4.g2;
import c4.h2;
import c4.k0;
import c4.y1;
import com.uptodown.UptodownApp;
import e2.d;
import j5.p;
import java.util.ArrayList;
import kotlin.jvm.internal.y;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import r7.o0;
import t4.t;
import t6.c;
import t7.n;
import u4.z1;
import v7.e;
import x4.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ListsActivity extends k0 {
    public static final /* synthetic */ int S = 0;
    public final m O = new m(new g(this, 20));
    public final ViewModelLazy P = new ViewModelLazy(y.a(h2.class), new c2(this, 0), new b2(this), new c2(this, 1));
    public boolean Q;
    public final ActivityResultLauncher R;

    public ListsActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 2));
        registerForActivityResult.getClass();
        this.R = registerForActivityResult;
    }

    public static final void y0(ListsActivity listsActivity, d dVar) {
        ((ImageView) dVar.f4467l).setImageResource(2131231474);
        LinearLayout linearLayout = (LinearLayout) dVar.f4468m;
        if (linearLayout.getChildCount() > 1) {
            linearLayout.removeViews(1, linearLayout.getChildCount() - 1);
        }
        ((RelativeLayout) dVar.f4470o).setVisibility(4);
        ((ProgressBar) dVar.f4469n).setVisibility(0);
    }

    public final t A0() {
        return (t) this.O.getValue();
    }

    public final h2 B0() {
        return (h2) this.P.getValue();
    }

    public final String C0(int i) {
        if (i == 1) {
            String string = getString(2131951722);
            string.getClass();
            return string;
        }
        String string2 = getString(2131951721, String.valueOf(i));
        string2.getClass();
        return string2;
    }

    public final void D0() {
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
                h2 B0 = B0();
                B0.getClass();
                B0.f1664c = false;
                o0 o0Var = B0.f1662a;
                o0Var.getClass();
                p pVar = p.f6705a;
                o0Var.g(null, pVar);
                B0.f = false;
                o0 o0Var2 = B0.f1665d;
                o0Var2.getClass();
                o0Var2.g(null, pVar);
                B0.i = false;
                o0 o0Var3 = B0.g;
                o0Var3.getClass();
                o0Var3.g(null, pVar);
                B0.f1668l = false;
                o0 o0Var4 = B0.j;
                o0Var4.getClass();
                o0Var4.g(null, pVar);
                c0.s(ViewModelKt.getViewModelScope(B0), null, null, new f2(this, B0, null, 0), 3);
                c0.s(ViewModelKt.getViewModelScope(B0), null, null, new f2(this, B0, null, 1), 3);
                ArrayList arrayList = new ArrayList();
                a0 viewModelScope = ViewModelKt.getViewModelScope(B0);
                e eVar = m0.f8288a;
                v7.d dVar = v7.d.f10884a;
                c0.s(viewModelScope, dVar, null, new g2(this, B0, arrayList, (c) null), 2);
                c0.s(ViewModelKt.getViewModelScope(B0), dVar, null, new g2(this, new ArrayList(), B0, (c) null), 2);
            }
            return;
        }
        str = null;
        if (str == null) {
        }
        h2 B02 = B0();
        B02.getClass();
        B02.f1664c = false;
        o0 o0Var5 = B02.f1662a;
        o0Var5.getClass();
        p pVar2 = p.f6705a;
        o0Var5.g(null, pVar2);
        B02.f = false;
        o0 o0Var22 = B02.f1665d;
        o0Var22.getClass();
        o0Var22.g(null, pVar2);
        B02.i = false;
        o0 o0Var32 = B02.g;
        o0Var32.getClass();
        o0Var32.g(null, pVar2);
        B02.f1668l = false;
        o0 o0Var42 = B02.j;
        o0Var42.getClass();
        o0Var42.g(null, pVar2);
        c0.s(ViewModelKt.getViewModelScope(B02), null, null, new f2(this, B02, null, 0), 3);
        c0.s(ViewModelKt.getViewModelScope(B02), null, null, new f2(this, B02, null, 1), 3);
        ArrayList arrayList2 = new ArrayList();
        a0 viewModelScope2 = ViewModelKt.getViewModelScope(B02);
        e eVar2 = m0.f8288a;
        v7.d dVar2 = v7.d.f10884a;
        c0.s(viewModelScope2, dVar2, null, new g2(this, B02, arrayList2, (c) null), 2);
        c0.s(ViewModelKt.getViewModelScope(B02), dVar2, null, new g2(this, new ArrayList(), B02, (c) null), 2);
    }

    public final void E0(j jVar) {
        jVar.getClass();
        if (T()) {
            z1 z1Var = new z1();
            z1Var.f10683m = jVar;
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            float f = UptodownApp.I;
            beginTransaction.getClass();
            b4.d.C(beginTransaction, this);
            beginTransaction.add(2131362185, z1Var, (String) null).addToBackStack(String.valueOf(jVar.f11224a)).commit();
            getSupportFragmentManager().addOnBackStackChangedListener(new androidx.preference.a(this, 1));
        }
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = A0().f10116a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        t A0 = A0();
        if (drawable != null) {
            A0.f10122p.setNavigationIcon(drawable);
            A0.f10122p.setNavigationContentDescription(getString(2131951735));
        }
        Toolbar toolbar = A0.f10122p;
        d dVar = A0.f10118l;
        TextView textView = (TextView) dVar.f4472q;
        d dVar2 = A0.f10119m;
        TextView textView2 = (TextView) dVar2.f4472q;
        d dVar3 = A0.f10120n;
        TextView textView3 = (TextView) dVar3.f4472q;
        int i = 0;
        toolbar.setNavigationOnClickListener(new y1(this, i));
        A0.f10123q.setTypeface(f4.c.f4882w);
        textView3.setTypeface(f4.c.f4882w);
        ((TextView) dVar3.f4471p).setTypeface(f4.c.f4883x);
        textView3.setText(getString(2131952373));
        textView2.setTypeface(f4.c.f4882w);
        ((TextView) dVar2.f4471p).setTypeface(f4.c.f4883x);
        textView2.setText(getString(2131952370));
        textView.setTypeface(f4.c.f4882w);
        ((TextView) dVar.f4471p).setTypeface(f4.c.f4883x);
        textView.setText(getString(2131952367));
        A0.f10121o.setOnClickListener(new c4.e(6));
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        p7.c cVar = n.f10348a;
        c cVar2 = null;
        c0.s(lifecycleScope, cVar, null, new a2(this, cVar2, i), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new a2(this, cVar2, 1), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new a2(this, cVar2, 2), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new a2(this, cVar2, 3), 2);
        D0();
    }

    public final void z0(String str, LinearLayout linearLayout, int i) {
        ImageView imageView = new ImageView(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131165366);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.setMargins((int) getResources().getDimension(2131165633), 0, 0, 0);
        imageView.setLayoutParams(layoutParams);
        imageView.setContentDescription(null);
        imageView.setElevation(getResources().getDimension(2131165277));
        imageView.setImageDrawable(ContextCompat.getDrawable(this, 2131231362));
        imageView.setElevation(-i);
        l0 e10 = g0.d().e(str);
        float f = UptodownApp.I;
        Context context = imageView.getContext();
        context.getClass();
        e10.g(b4.d.f(context));
        e10.h(b4.d.x(this));
        e10.e(imageView, null);
        linearLayout.addView(imageView);
    }
}
