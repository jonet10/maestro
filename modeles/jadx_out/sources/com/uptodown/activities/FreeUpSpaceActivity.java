package com.uptodown.activities;

import a3.d;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.SimpleItemAnimator;
import b5.l;
import c4.e1;
import c4.g1;
import c4.h1;
import c4.k0;
import c4.l1;
import c4.m1;
import e4.e;
import f4.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.y;
import l5.f;
import l7.u;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import p6.x;
import t7.n;
import u6.a;
import v6.i;
import x4.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class FreeUpSpaceActivity extends k0 {
    public static final /* synthetic */ int T = 0;
    public e Q;
    public g R;
    public final m O = new m(new androidx.room.g(this, 15));
    public final ViewModelLazy P = new ViewModelLazy(y.a(m1.class), new h1(this, 0), new g1(this), new h1(this, 1));
    public final d S = new d(this, 6);

    public static final int y0(FreeUpSpaceActivity freeUpSpaceActivity, String str) {
        e eVar = freeUpSpaceActivity.Q;
        ArrayList a8 = eVar != null ? eVar.a() : null;
        if (a8 == null || a8.isEmpty()) {
            return -1;
        }
        e eVar2 = freeUpSpaceActivity.Q;
        ArrayList a10 = eVar2 != null ? eVar2.a() : null;
        a10.getClass();
        Iterator it = a10.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i6 = i + 1;
            if (u.m0(((x4.e) it.next()).f11123l, str, true)) {
                return i;
            }
            i = i6;
        }
        return -1;
    }

    public final t4.m A0() {
        return (t4.m) this.O.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B0() {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.FreeUpSpaceActivity.B0():void");
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        Intent intent = getIntent();
        int i = 1;
        if (intent != null && (extras = intent.getExtras()) != null && extras.containsKey("appInfo")) {
            Intent intent2 = getIntent();
            intent2.getClass();
            Bundle extras2 = intent2.getExtras();
            extras2.getClass();
            this.R = (g) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras2.getParcelable("appInfo", g.class) : extras2.getParcelable("appInfo"));
        }
        RelativeLayout relativeLayout = A0().f9993a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        if (drawable != null) {
            A0().f9997n.setNavigationIcon(drawable);
            A0().f9997n.setNavigationContentDescription(getString(2131951735));
        }
        A0().f9997n.setNavigationOnClickListener(new c4.d(this, 4));
        A0().f9998o.setTypeface(c.f4882w);
        ((TextView) A0().f9994b.f5276l).setTypeface(c.f4883x);
        ((TextView) A0().f9994b.f5277m).setTypeface(c.f4883x);
        ((TextView) A0().f9994b.f5275b).setTypeface(c.f4882w);
        ((TextView) A0().f9994b.f5275b).setVisibility(8);
        B0();
        int dimension = (int) getResources().getDimension(2131166251);
        A0().f9996m.addItemDecoration(new f(dimension, dimension));
        A0().f9996m.setLayoutManager(new LinearLayoutManager(this, 1, false));
        A0().f9996m.setItemAnimator(new DefaultItemAnimator());
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) A0().f9996m.getItemAnimator();
        simpleItemAnimator.getClass();
        simpleItemAnimator.setSupportsChangeAnimations(false);
        A0().f9995l.setOnClickListener(new c4.e(4));
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new e1(this, null, i), 3);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        keyEvent.getClass();
        if (i != 82) {
            return super.onKeyDown(i, keyEvent);
        }
        A0().f9997n.showOverflowMenu();
        return true;
    }

    @Override // c4.k0, g4.s0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        m1 m1Var = (m1) this.P.getValue();
        m1Var.getClass();
        a0 viewModelScope = ViewModelKt.getViewModelScope(m1Var);
        v7.e eVar = m0.f8288a;
        c0.s(viewModelScope, v7.d.f10884a, null, new l1(true, m1Var, this, null, 0), 2);
        Object systemService = getSystemService("notification");
        systemService.getClass();
        ((NotificationManager) systemService).cancel(258);
    }

    public final Object z0(String str, String str2, i iVar) {
        v7.e eVar = m0.f8288a;
        Object C = c0.C(new l(this, str2, str, (t6.c) null, 4), n.f10348a, iVar);
        return C == a.f10762a ? C : x.f8463a;
    }
}
