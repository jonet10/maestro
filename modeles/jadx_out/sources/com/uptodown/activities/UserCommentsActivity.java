package com.uptodown.activities;

import a3.d;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import b6.a;
import c4.bc;
import c4.k0;
import c4.vb;
import c4.w6;
import c4.xb;
import c4.yb;
import c4.zb;
import e4.b1;
import kotlin.jvm.internal.y;
import l5.i;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import t6.c;
import t7.n;
import v7.e;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class UserCommentsActivity extends k0 {
    public static final /* synthetic */ int S = 0;
    public b1 Q;
    public final m O = new m(new w6(this, 10));
    public final ViewModelLazy P = new ViewModelLazy(y.a(bc.class), new zb(this, 0), new yb(this), new zb(this, 1));
    public final d R = new d(this, 17);

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        RelativeLayout relativeLayout = y0().f9645a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        c cVar = null;
        ((w2) z0().f1437e.getValue()).f11431a = (getIntent() == null || (extras = getIntent().getExtras()) == null || !extras.containsKey("userID")) ? null : extras.getString("userID");
        y0().f9648m.setNavigationIcon(ContextCompat.getDrawable(this, 2131230922));
        y0().f9648m.setNavigationContentDescription(getString(2131951735));
        y0().f9648m.setNavigationOnClickListener(new c4.d(this, 14));
        y0().f9650o.setTypeface(f4.c.f4882w);
        int dimension = (int) getResources().getDimension(2131166251);
        int i = 1;
        int i6 = 0;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        y0().f9647l.addItemDecoration(new i(dimension, dimension, dimension, dimension));
        y0().f9647l.setLayoutManager(linearLayoutManager);
        y0().f9647l.setItemAnimator(null);
        y0().f9647l.addOnScrollListener(new vb(linearLayoutManager, this));
        String str = ((w2) z0().f1437e.getValue()).f11431a;
        if (str != null && str.length() != 0) {
            bc z02 = z0();
            z02.getClass();
            a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
            e eVar = m0.f8288a;
            c0.s(viewModelScope, v7.d.f10884a, null, new a(z02, this, cVar, 27), 2);
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        p7.c cVar2 = n.f10348a;
        c0.s(lifecycleScope, cVar2, null, new xb(this, cVar, i6), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new xb(this, cVar, i), 2);
    }

    public final t4.b1 y0() {
        return (t4.b1) this.O.getValue();
    }

    public final bc z0() {
        return (bc) this.P.getValue();
    }
}
