package com.uptodown.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.g;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import c4.a1;
import c4.b1;
import c4.e;
import c4.k0;
import c4.u0;
import c4.w0;
import c4.x0;
import c4.y0;
import e4.d;
import f0.i;
import kotlin.jvm.internal.y;
import l5.f;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import t4.l;
import t6.c;
import t7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class FollowListActivity extends k0 {
    public static final /* synthetic */ int S = 0;
    public d Q;
    public final m O = new m(new g(this, 14));
    public final ViewModelLazy P = new ViewModelLazy(y.a(b1.class), new y0(this, 0), new x0(this), new y0(this, 1));
    public final i R = new i(this, 6);

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        String str2;
        int i;
        Bundle extras;
        super.onCreate(bundle);
        Intent intent = getIntent();
        c cVar = null;
        int i6 = 0;
        if (intent == null || (extras = intent.getExtras()) == null) {
            str = null;
            str2 = null;
            i = 0;
        } else {
            i = extras.containsKey(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY) ? extras.getInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY) : 0;
            String string = extras.containsKey("userID") ? extras.getString("userID") : null;
            if (extras.containsKey("username")) {
                str = extras.getString("username");
                str2 = string;
            } else {
                str2 = string;
                str = null;
            }
        }
        int i10 = 1;
        if (str2 != null && str2.length() != 0 && str != null && str.length() != 0) {
            RelativeLayout relativeLayout = y0().f9955a;
            relativeLayout.getClass();
            setContentView(relativeLayout);
            y0().f9958m.setNavigationIcon(ContextCompat.getDrawable(this, 2131230922));
            y0().f9958m.setNavigationContentDescription(getString(2131951735));
            y0().f9958m.setNavigationOnClickListener(new c4.d(this, 3));
            y0().f9960o.setTypeface(f4.c.f4882w);
            y0().f9959n.setTypeface(f4.c.f4883x);
            if (i == 1) {
                y0().f9960o.setText(getString(2131952744, str));
            } else if (i == 2) {
                y0().f9960o.setText(getString(2131952743, str));
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
            int dimension = (int) getResources().getDimension(2131166251);
            y0().f9957l.addItemDecoration(new f(dimension, dimension));
            y0().f9957l.setLayoutManager(linearLayoutManager);
            y0().f9957l.addOnScrollListener(new u0(linearLayoutManager, this, i, str2));
            y0().f9956b.setOnClickListener(new e(3));
            if (i == 1) {
                b1 z02 = z0();
                z02.getClass();
                a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
                v7.e eVar = m0.f8288a;
                c0.s(viewModelScope, v7.d.f10884a, null, new a1(z02, this, str2, cVar, 0), 2);
            } else if (i == 2) {
                b1 z03 = z0();
                z03.getClass();
                a0 viewModelScope2 = ViewModelKt.getViewModelScope(z03);
                v7.e eVar2 = m0.f8288a;
                c0.s(viewModelScope2, v7.d.f10884a, null, new a1(z03, this, str2, cVar, 1), 2);
            }
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            p7.c cVar2 = n.f10348a;
            c0.s(lifecycleScope, cVar2, null, new w0(this, cVar, i6), 2);
            c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar2, null, new w0(this, cVar, i10), 2);
        }
        LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(this);
        p7.c cVar22 = n.f10348a;
        c0.s(lifecycleScope2, cVar22, null, new w0(this, cVar, i6), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar22, null, new w0(this, cVar, i10), 2);
    }

    public final l y0() {
        return (l) this.O.getValue();
    }

    public final b1 z0() {
        return (b1) this.P.getValue();
    }
}
