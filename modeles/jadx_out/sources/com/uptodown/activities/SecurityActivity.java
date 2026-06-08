package com.uptodown.activities;

import a3.d;
import android.app.NotificationManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import c4.ea;
import c4.ha;
import c4.ia;
import c4.ja;
import c4.w4;
import c4.w6;
import com.google.android.gms.internal.measurement.i5;
import com.uptodown.UptodownApp;
import e4.n0;
import f0.i;
import f4.c;
import j5.a;
import j5.r;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.y;
import l5.f;
import o7.c0;
import p6.m;
import r7.o0;
import t4.w0;
import t7.n;
import x4.e;
import x4.w1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class SecurityActivity extends w4 {

    /* renamed from: g0, reason: collision with root package name */
    public static final /* synthetic */ int f3349g0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    public n0 f3351c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f3352d0;
    public final String Z = "SecurityActivity";
    public final m a0 = new m(new w6(this, 7));

    /* renamed from: b0, reason: collision with root package name */
    public final ViewModelLazy f3350b0 = new ViewModelLazy(y.a(ja.class), new ia(this, 0), new ha(this), new ia(this, 1));

    /* renamed from: e0, reason: collision with root package name */
    public final d f3353e0 = new d(this, 16);

    /* renamed from: f0, reason: collision with root package name */
    public final i f3354f0 = new i(this, 14);

    @Override // c4.w4
    public final String F0() {
        return this.Z;
    }

    public final w0 N0() {
        return (w0) this.a0.getValue();
    }

    public final void O0() {
        if (this.f3352d0) {
            return;
        }
        this.f3352d0 = true;
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ea(this, null, 0), 3);
    }

    public final void P0() {
        ja jaVar = (ja) this.f3350b0.getValue();
        jaVar.getClass();
        ArrayList arrayList = new ArrayList();
        ArrayList i = a.i(this);
        ArrayList arrayList2 = UptodownApp.f3297k0;
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                w1 w1Var = (w1) next;
                Iterator it2 = i.iterator();
                it2.getClass();
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    next2.getClass();
                    e eVar = (e) next2;
                    if (l.a(w1Var.f11429b, eVar.B)) {
                        eVar.D = w1Var;
                        arrayList.add(eVar);
                    }
                }
            }
        }
        i5.J(arrayList, this);
        o0 o0Var = jaVar.f1767a;
        r rVar = new r(arrayList);
        o0Var.getClass();
        o0Var.g(null, rVar);
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = N0().f10210a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        if (drawable != null) {
            N0().f10214n.setNavigationIcon(drawable);
            N0().f10214n.setNavigationContentDescription(getString(2131951735));
        }
        w0 N0 = N0();
        Toolbar toolbar = N0.f10214n;
        TextView textView = N0.f10215o;
        RecyclerView recyclerView = N0.f10213m;
        toolbar.setNavigationOnClickListener(new c4.d(this, 13));
        N0.f10218r.setTypeface(c.f4882w);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) recyclerView.getItemAnimator();
        simpleItemAnimator.getClass();
        simpleItemAnimator.setSupportsChangeAnimations(false);
        recyclerView.addItemDecoration(new f((int) getResources().getDimension(2131166251), 0));
        N0.f10211b.setOnClickListener(new c4.e(22));
        N0.f10217q.setTypeface(c.f4882w);
        N0.f10216p.setTypeface(c.f4883x);
        textView.setTypeface(c.f4882w);
        textView.setOnClickListener(new c.e(18, this, N0));
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new ea(this, null, 1), 2);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        keyEvent.getClass();
        if (i != 82) {
            return super.onKeyDown(i, keyEvent);
        }
        N0().f10214n.showOverflowMenu();
        return true;
    }

    @Override // c4.k0, g4.s0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        O0();
        Object systemService = getSystemService("notification");
        systemService.getClass();
        ((NotificationManager) systemService).cancel(258);
    }
}
