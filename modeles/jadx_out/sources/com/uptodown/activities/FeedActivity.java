package com.uptodown.activities;

import a3.d;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.g;
import c4.e;
import c4.k0;
import c4.o0;
import c4.q0;
import c4.r0;
import c4.s0;
import c4.t0;
import e4.c;
import kotlin.jvm.internal.y;
import o7.c0;
import p6.m;
import t4.j;
import t7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class FeedActivity extends k0 {
    public static final /* synthetic */ int S = 0;
    public c Q;
    public final m O = new m(new g(this, 13));
    public final ViewModelLazy P = new ViewModelLazy(y.a(t0.class), new s0(this, 0), new r0(this), new s0(this, 1));
    public final d R = new d(this, 5);

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = y0().f9896a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        y0().f9899m.setNavigationIcon(ContextCompat.getDrawable(this, 2131230922));
        y0().f9899m.setNavigationContentDescription(getString(2131951735));
        y0().f9899m.setNavigationOnClickListener(new c4.d(this, 2));
        y0().f9901o.setTypeface(f4.c.f4882w);
        y0().f9900n.setTypeface(f4.c.f4883x);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        y0().f9898l.setLayoutManager(linearLayoutManager);
        y0().f9898l.addOnScrollListener(new o0(linearLayoutManager, this));
        y0().f9897b.setOnClickListener(new e(2));
        z0().a(this);
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        p7.c cVar = n.f10348a;
        t6.c cVar2 = null;
        c0.s(lifecycleScope, cVar, null, new q0(this, cVar2, 0), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), cVar, null, new q0(this, cVar2, 1), 2);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new q0(this, cVar2, 2), 3);
    }

    public final j y0() {
        return (j) this.O.getValue();
    }

    public final t0 z0() {
        return (t0) this.P.getValue();
    }
}
