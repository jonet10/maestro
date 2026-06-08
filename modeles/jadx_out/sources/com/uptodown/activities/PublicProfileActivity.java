package com.uptodown.activities;

import a4.g0;
import a4.l0;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.view.inputmethod.a;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b4.d;
import c4.j7;
import c4.k0;
import c4.k7;
import c4.l7;
import c4.o7;
import c4.r7;
import c4.s7;
import c4.t7;
import c4.v7;
import c4.w6;
import c4.y7;
import com.google.android.gms.internal.measurement.i5;
import com.uptodown.UptodownApp;
import com.uptodown.util.views.UsernameTextView;
import j5.c;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.x;
import kotlin.jvm.internal.y;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import t7.n;
import v7.e;
import x4.u2;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class PublicProfileActivity extends k0 {
    public static final /* synthetic */ int R = 0;
    public final m O = new m(new w6(this, 2));
    public final ViewModelLazy P = new ViewModelLazy(y.a(y7.class), new t7(this, 0), new s7(this), new t7(this, 1));
    public final ActivityResultLauncher Q;

    public PublicProfileActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 8));
        registerForActivityResult.getClass();
        this.Q = registerForActivityResult;
    }

    public final void A0(int i, String str, String str2) {
        if (T()) {
            Intent intent = new Intent(this, (Class<?>) FollowListActivity.class);
            intent.putExtra(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, i);
            intent.putExtra("username", str);
            intent.putExtra("userID", str2);
            float f = UptodownApp.I;
            startActivity(intent, d.a(this));
        }
    }

    public final void B0(w2 w2Var) {
        int i = UsernameTextView.f3452s;
        i5.g(y0().C, w2Var.d(), w2Var.f11436o);
        y0().C.setText(w2Var.f11434m);
        w2 h = u2.h(this);
        if (l.a(w2Var.f11431a, h != null ? h.f11431a : null)) {
            y0().G.setText(getString(2131952368));
        } else {
            y0().G.setText(w2Var.f11434m);
        }
        y0().D.setText(w2Var.f11442u);
        String str = w2Var.f11437p;
        if (str != null && str.length() != 0 && y0().f9962b.getDrawable() == null) {
            l0 e10 = g0.d().e(w2Var.f11437p);
            e10.f136c = true;
            e10.e(y0().f9962b, null);
        }
        String a8 = w2Var.a();
        if (a8 != null && a8.length() != 0) {
            l0 e11 = g0.d().e(u2.e(w2Var.f11433l));
            float f = UptodownApp.I;
            e11.h(d.y(this));
            e11.e(y0().f9963l, null);
            y0().f9963l.setBackground(ContextCompat.getDrawable(this, 2131231186));
        }
        if (w2Var.d()) {
            ImageView imageView = y0().f9963l;
            int dimension = (int) imageView.getContext().getResources().getDimension(2131165270);
            imageView.setForeground(ContextCompat.getDrawable(imageView.getContext(), 2131231271));
            imageView.setPadding(dimension, dimension, dimension, dimension);
            y0().f9964m.setVisibility(0);
        }
        y0().B.setText(c.c(w2Var.f11441t));
        y0().F.setText(String.valueOf(w2Var.f11438q));
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        x xVar = new x();
        if (getIntent() != null && (extras = getIntent().getExtras()) != null && extras.containsKey("user")) {
            xVar.f7024a = extras.getParcelable("user");
        }
        Object obj = xVar.f7024a;
        int i = 1;
        int i6 = 0;
        int i10 = 2;
        t6.c cVar = null;
        if (obj != null) {
            w2 w2Var = (w2) obj;
            RelativeLayout relativeLayout = y0().f9961a;
            relativeLayout.getClass();
            setContentView(relativeLayout);
            y0().f9972u.setNavigationIcon(ContextCompat.getDrawable(this, 2131231302));
            y0().f9972u.setNavigationContentDescription(getString(2131951735));
            y0().f9972u.setNavigationOnClickListener(new j7(this, i6));
            y0().f9971t.getViewTreeObserver().addOnScrollChangedListener(new k7(this, i6));
            y0().G.setTypeface(f4.c.f4882w);
            y0().C.setTypeface(f4.c.f4882w);
            y0().D.setTypeface(f4.c.f4883x);
            y0().v.setTypeface(f4.c.f4882w);
            y0().f9974x.setTypeface(f4.c.f4882w);
            y0().A.setTypeface(f4.c.f4883x);
            y0().B.setTypeface(f4.c.f4882w);
            y0().E.setTypeface(f4.c.f4883x);
            y0().F.setTypeface(f4.c.f4882w);
            y0().f9975y.setTypeface(f4.c.f4883x);
            y0().f9976z.setTypeface(f4.c.f4882w);
            ((TextView) y0().f9969r.f4472q).setTypeface(f4.c.f4882w);
            ((TextView) y0().f9969r.f4470o).setTypeface(f4.c.f4882w);
            ((TextView) y0().f9969r.f4471p).setTypeface(f4.c.f4883x);
            ((TextView) y0().H.f4472q).setTypeface(f4.c.f4882w);
            ((TextView) y0().H.f4470o).setTypeface(f4.c.f4882w);
            ((TextView) y0().H.f4471p).setTypeface(f4.c.f4883x);
            ((TextView) y0().f9970s.f4472q).setTypeface(f4.c.f4882w);
            ((TextView) y0().f9970s.f4470o).setTypeface(f4.c.f4882w);
            ((TextView) y0().f9970s.f4471p).setTypeface(f4.c.f4883x);
            B0(w2Var);
            ((RecyclerView) y0().f9969r.f4469n).setLayoutManager(new LinearLayoutManager(this, 0, false));
            ((RecyclerView) y0().f9969r.f4469n).setItemAnimator(null);
            ((RecyclerView) y0().f9970s.f4469n).setLayoutManager(new LinearLayoutManager(this, 0, false));
            y0().f9965n.setOnClickListener(new l7(this, w2Var, i6));
            y0().f9966o.setOnClickListener(new l7(this, w2Var, i));
            y0().f9967p.setOnClickListener(new l7(this, w2Var, i10));
            w2 h = u2.h(this);
            if (l.a(w2Var.f11431a, h != null ? h.f11431a : null)) {
                ((RecyclerView) y0().H.f4469n).setLayoutManager(new LinearLayoutManager(this, 0, false));
                ((RecyclerView) y0().H.f4469n).setItemAnimator(null);
                ((TextView) y0().H.f4472q).setText(getString(2131952373));
                ((TextView) y0().H.f4472q).setText(getString(2131952373));
                ((TextView) y0().f9969r.f4472q).setText(getString(2131952370));
                ((TextView) y0().f9970s.f4471p).setText(getString(2131952369));
                ((TextView) y0().f9970s.f4472q).setText(getString(2131952503));
                y0().v.setVisibility(0);
                y0().v.setOnClickListener(new l7(h, this));
                y0().f9963l.setOnClickListener(new l7(this, w2Var, 4));
                y0().f9973w.setTypeface(f4.c.f4882w);
                y0().f9973w.setVisibility(0);
                y0().f9973w.setOnClickListener(new j7(this, i));
                y0().f9974x.setVisibility(8);
            } else {
                y0().v.setVisibility(8);
                y0().f9974x.setOnClickListener(new l7(this, w2Var, 5));
                ((TextView) y0().f9969r.f4472q).setText(getString(2131952517));
                ((TextView) y0().f9970s.f4472q).setText(getString(2131952502));
            }
            y7 z02 = z0();
            String valueOf = String.valueOf(((w2) xVar.f7024a).f11431a);
            w2 w2Var2 = (w2) xVar.f7024a;
            int i11 = w2Var2.f11439r;
            int i12 = w2Var2.f11440s;
            z02.getClass();
            a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
            e eVar = m0.f8288a;
            c0.s(viewModelScope, v7.d.f10884a, null, new v7(z02, i12, this, valueOf, i11, null), 2);
        }
        w2 h6 = u2.h(this);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        p7.c cVar2 = n.f10348a;
        c0.s(lifecycleScope, cVar2, null, new o7(this, xVar, h6, cVar, 0), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new o7(this, xVar, h6, cVar, 1), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new r7(this, cVar, i6), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new r7(this, cVar, i), 2);
    }

    public final t4.l0 y0() {
        return (t4.l0) this.O.getValue();
    }

    public final y7 z0() {
        return (y7) this.P.getValue();
    }
}
