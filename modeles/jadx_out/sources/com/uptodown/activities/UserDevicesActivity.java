package com.uptodown.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.view.inputmethod.a;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import b.s;
import c4.d;
import c4.k0;
import c4.pc;
import c4.qc;
import c4.sc;
import c4.tc;
import c4.w6;
import f4.c;
import kotlin.jvm.internal.y;
import l5.f;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import t4.e1;
import t7.n;
import v7.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class UserDevicesActivity extends k0 {
    public static final /* synthetic */ int R = 0;
    public final m O = new m(new w6(this, 12));
    public final ViewModelLazy P = new ViewModelLazy(y.a(tc.class), new qc(this, 0), new pc(this), new qc(this, 1));
    public final ActivityResultLauncher Q;

    public UserDevicesActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 12));
        registerForActivityResult.getClass();
        this.Q = registerForActivityResult;
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = y0().f9763a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        if (drawable != null) {
            y0().f9767n.setNavigationIcon(drawable);
            y0().f9767n.setNavigationContentDescription(getString(2131951735));
        }
        y0().f9767n.setNavigationOnClickListener(new d(this, 15));
        y0().f9770q.setTypeface(c.f4882w);
        y0().f9769p.setTypeface(c.f4883x);
        y0().f9768o.setTypeface(c.f4883x);
        y0().f9766m.setLayoutManager(new LinearLayoutManager(this, 1, false));
        y0().f9766m.setItemAnimator(new DefaultItemAnimator());
        int dimension = (int) getResources().getDimension(2131166251);
        y0().f9766m.addItemDecoration(new f(dimension, dimension));
        t6.c cVar = null;
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new s(this, cVar, 16), 2);
        tc tcVar = (tc) this.P.getValue();
        tcVar.getClass();
        a0 viewModelScope = ViewModelKt.getViewModelScope(tcVar);
        e eVar = m0.f8288a;
        c0.s(viewModelScope, v7.d.f10884a, null, new sc(this, tcVar, cVar, 0), 2);
    }

    public final e1 y0() {
        return (e1) this.O.getValue();
    }
}
