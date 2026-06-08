package com.uptodown.activities;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.inputmethod.a;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import b4.d;
import c4.ca;
import c4.k0;
import c4.k2;
import c4.m9;
import c4.p6;
import c4.p9;
import c4.q9;
import c4.r9;
import c4.s9;
import c4.u9;
import c4.w6;
import c4.w9;
import c4.x9;
import c4.y9;
import com.uptodown.UptodownApp;
import com.uptodown.activities.SearchActivity;
import com.uptodown.views.InstantAutoCompleteTextView;
import e4.l0;
import e4.m0;
import kotlin.jvm.internal.y;
import l5.f;
import l7.u;
import o7.c0;
import o7.s1;
import p6.m;
import t6.c;
import t7.n;
import u4.z1;
import v7.e;
import x4.d0;
import x4.j;
import x4.u0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class SearchActivity extends k0 {
    public static final /* synthetic */ int Y = 0;
    public s1 Q;
    public l0 R;
    public m0 S;
    public p9 T;
    public final ActivityResultLauncher X;
    public final m O = new m(new w6(this, 6));
    public final ViewModelLazy P = new ViewModelLazy(y.a(ca.class), new y9(this, 0), new x9(this), new y9(this, 1));
    public final q9 U = new q9(this);
    public final r9 V = new r9(this);
    public final r9 W = new r9(this);

    public SearchActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 11));
        registerForActivityResult.getClass();
        this.X = registerForActivityResult;
    }

    public static final String y0(SearchActivity searchActivity, String str) {
        str.getClass();
        return u.o0(str, "/", "", false);
    }

    public final ca A0() {
        return (ca) this.P.getValue();
    }

    public final void B0() {
        Object systemService = getSystemService("input_method");
        systemService.getClass();
        ((InputMethodManager) systemService).hideSoftInputFromWindow(((InstantAutoCompleteTextView) z0().f10137b.f11756l).getWindowToken(), 0);
        ((InstantAutoCompleteTextView) z0().f10137b.f11756l).clearFocus();
    }

    public final void C0(int i, String str) {
        s1 s1Var = this.Q;
        if (s1Var != null) {
            s1Var.c(null);
        }
        this.Q = c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new c4.m(i, this, str, (c) null), 3);
    }

    public final void D0(String str) {
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        e eVar = o7.m0.f8288a;
        c0.s(lifecycleScope, n.f10348a, null, new w9(2, this, str, null), 2);
    }

    public final void E0(j jVar) {
        jVar.getClass();
        if (T()) {
            B0();
            z1 z1Var = new z1();
            z1Var.f10683m = jVar;
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.getClass();
            float f = UptodownApp.I;
            d.C(beginTransaction, this);
            beginTransaction.add(2131362181, z1Var, (String) null).addToBackStack(String.valueOf(jVar.f11224a)).commit();
        }
    }

    @Override // c4.k0
    public final void b0(d0 d0Var) {
        d0Var.getClass();
        D0(d0Var.b());
    }

    @Override // c4.k0
    public final void d0(u0 u0Var) {
        u0Var.getClass();
        D0(u0Var.b());
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String stringExtra;
        super.onCreate(bundle);
        RelativeLayout relativeLayout = z0().f10136a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        ImageView imageView = (ImageView) findViewById(2131362309);
        int i = 0;
        if (imageView != null) {
            imageView.setOnClickListener(new m9(this, i));
        }
        int i6 = 1;
        ((ImageView) z0().f10137b.f11757m).setOnClickListener(new m9(this, i6));
        int i10 = 2;
        ((ImageView) z0().f10137b.f11758n).setOnClickListener(new m9(this, i10));
        ((InstantAutoCompleteTextView) z0().f10137b.f11756l).requestFocus();
        ((InstantAutoCompleteTextView) z0().f10137b.f11756l).setTypeface(f4.c.f4883x);
        ((InstantAutoCompleteTextView) z0().f10137b.f11756l).setOnEditorActionListener(new k2(this, i10));
        this.T = new p9(this, this);
        ((InstantAutoCompleteTextView) z0().f10137b.f11756l).setAdapter(this.T);
        ((InstantAutoCompleteTextView) z0().f10137b.f11756l).setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: c4.n9
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j) {
                int i12 = SearchActivity.Y;
                adapterView.getClass();
                float f = UptodownApp.I;
                if (b4.d.t()) {
                    Object itemAtPosition = adapterView.getItemAtPosition(i11);
                    itemAtPosition.getClass();
                    String str = ((x4.z1) itemAtPosition).f11479a;
                    if (str != null) {
                        SearchActivity.this.C0(0, str);
                    }
                }
            }
        });
        ((InstantAutoCompleteTextView) z0().f10137b.f11756l).addTextChangedListener(new p6(this, i10));
        z0().f10140n.setTypeface(f4.c.f4882w);
        z0().f10140n.setOnClickListener(new m9(this, 3));
        z0().f10141o.setTypeface(f4.c.f4882w);
        z0().f10141o.setOnClickListener(new m9(this, 4));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        z0().f10139m.setLayoutManager(linearLayoutManager);
        c cVar = null;
        z0().f10139m.setItemAnimator(null);
        int dimension = (int) getResources().getDimension(2131166251);
        z0().f10139m.addItemDecoration(new f(dimension, dimension));
        z0().f10139m.addOnScrollListener(new s9(linearLayoutManager, this));
        hideKeyboardOnScroll(z0().f10139m);
        z0().f10138l.setOnClickListener(new c4.e(21));
        z0().f10142p.setTypeface(f4.c.f4883x);
        p9 p9Var = this.T;
        p9Var.getClass();
        p9Var.getFilter().filter(((InstantAutoCompleteTextView) z0().f10137b.f11756l).getText().toString());
        Intent intent = getIntent();
        if (intent != null && "android.intent.action.SEARCH".equals(intent.getAction()) && (stringExtra = intent.getStringExtra("query")) != null) {
            C0(0, stringExtra);
        }
        showKeyboard((InstantAutoCompleteTextView) z0().f10137b.f11756l);
        z0().f10138l.setVisibility(8);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        p7.c cVar2 = n.f10348a;
        c0.s(lifecycleScope, cVar2, null, new u9(this, cVar, i), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new u9(this, cVar, i6), 2);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        menu.getClass();
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.getClass();
        menuInflater.inflate(2131689476, menu);
        Object systemService = getSystemService("search");
        systemService.getClass();
        SearchManager searchManager = (SearchManager) systemService;
        SearchView searchView = (SearchView) menu.findItem(2131361892).getActionView();
        if (searchView == null) {
            return true;
        }
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        String stringExtra;
        intent.getClass();
        super.onNewIntent(intent);
        if (!"android.intent.action.SEARCH".equals(intent.getAction()) || (stringExtra = intent.getStringExtra("query")) == null) {
            return;
        }
        C0(0, stringExtra);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        B0();
    }

    @Override // c4.k0, g4.s0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        l0 l0Var = this.R;
        if (l0Var != null) {
            l0Var.notifyDataSetChanged();
        }
        m0 m0Var = this.S;
        if (m0Var != null) {
            m0Var.notifyDataSetChanged();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onSearchRequested() {
        startSearch(null, false, new Bundle(), false);
        return true;
    }

    public final t4.u0 z0() {
        return (t4.u0) this.O.getValue();
    }
}
