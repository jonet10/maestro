package com.uptodown.activities;

import android.content.Intent;
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
import androidx.room.g;
import androidx.work.Constraints;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import b.s;
import b4.d;
import c4.k0;
import c4.p5;
import c4.q5;
import c4.s5;
import com.uptodown.UptodownApp;
import com.uptodown.workers.SendUserUsageStatsWorker;
import j5.u;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.y;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import t4.z;
import t6.c;
import t7.n;
import v7.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class MyStatsActivity extends k0 {
    public static final /* synthetic */ int R = 0;
    public final m O = new m(new g(this, 25));
    public final ViewModelLazy P = new ViewModelLazy(y.a(s5.class), new q5(this, 0), new p5(this), new q5(this, 1));
    public final ActivityResultLauncher Q;

    public MyStatsActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 5));
        registerForActivityResult.getClass();
        this.Q = registerForActivityResult;
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = y0().f10257a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        c cVar = null;
        if (u.b(this)) {
            float f = UptodownApp.I;
            if (!d.p(this, "SendUserUsageStatsWorker")) {
                WorkManager.Companion.getInstance(this).enqueue(new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) SendUserUsageStatsWorker.class, 24L, TimeUnit.HOURS).addTag("SendUserUsageStatsWorker").setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
            }
            z0();
            s5 s5Var = (s5) this.P.getValue();
            s5Var.getClass();
            a0 viewModelScope = ViewModelKt.getViewModelScope(s5Var);
            e eVar = m0.f8288a;
            c0.s(viewModelScope, v7.d.f10884a, null, new b6.a(s5Var, this, cVar, 16), 2);
        } else {
            this.Q.launch(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
        }
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new s(this, cVar, 8), 2);
    }

    public final z y0() {
        return (z) this.O.getValue();
    }

    public final void z0() {
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        if (drawable != null) {
            y0().f10261n.setNavigationIcon(drawable);
            y0().f10261n.setNavigationContentDescription(getString(2131951735));
        }
        y0().f10261n.setNavigationOnClickListener(new c4.d(this, 8));
        y0().E.setTypeface(f4.c.f4882w);
        y0().F.setTypeface(f4.c.f4882w);
        y0().G.setTypeface(f4.c.f4882w);
        y0().f10263p.setTypeface(f4.c.f4883x);
        y0().f10264q.setTypeface(f4.c.f4882w);
        y0().H.setTypeface(f4.c.f4883x);
        y0().I.setTypeface(f4.c.f4882w);
        y0().f10262o.setTypeface(f4.c.f4883x);
        y0().B.setTypeface(f4.c.f4882w);
        y0().C.setTypeface(f4.c.f4882w);
        y0().f10267t.setTypeface(f4.c.f4882w);
        y0().f10268u.setTypeface(f4.c.f4882w);
        y0().f10272z.setTypeface(f4.c.f4882w);
        y0().A.setTypeface(f4.c.f4882w);
        y0().f10265r.setTypeface(f4.c.f4882w);
        y0().f10266s.setTypeface(f4.c.f4882w);
        y0().f10270x.setTypeface(f4.c.f4882w);
        y0().f10271y.setTypeface(f4.c.f4882w);
        y0().v.setTypeface(f4.c.f4882w);
        y0().f10269w.setTypeface(f4.c.f4882w);
        y0().J.setTypeface(f4.c.f4882w);
        y0().D.setTypeface(f4.c.f4882w);
        y0().f10259l.setOnClickListener(new c4.e(13));
    }
}
