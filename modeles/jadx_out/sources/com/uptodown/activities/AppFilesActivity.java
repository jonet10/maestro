package com.uptodown.activities;

import a3.d;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.g;
import b.s;
import c4.k0;
import f4.c;
import j$.util.concurrent.ConcurrentHashMap;
import j5.t;
import n4.l;
import o7.c0;
import p6.m;
import x4.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class AppFilesActivity extends k0 {
    public static final /* synthetic */ int S = 0;
    public e Q;
    public final LifecycleCoroutineScope O = LifecycleOwnerKt.getLifecycleScope(this);
    public final m P = new m(new g(this, 9));
    public final d R = new d(this, 4);

    /* JADX WARN: Code restructure failed: missing block: B:19:0x007f, code lost:
    
        if (o7.c0.C(r3, r10, r0) == r6) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
    
        if (o7.c0.C(r4, r10, r0) != r6) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object y0(com.uptodown.activities.AppFilesActivity r9, v6.c r10) {
        /*
            boolean r0 = r10 instanceof c4.f
            if (r0 == 0) goto L13
            r0 = r10
            c4.f r0 = (c4.f) r0
            int r1 = r0.f1577m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1577m = r1
            goto L18
        L13:
            c4.f r0 = new c4.f
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f1575b
            int r1 = r0.f1577m
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            u6.a r6 = u6.a.f10762a
            if (r1 == 0) goto L40
            if (r1 == r4) goto L3a
            if (r1 == r3) goto L34
            if (r1 != r2) goto L2e
            p6.a.e(r10)
            goto L82
        L2e:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r9)
            return r5
        L34:
            java.util.ArrayList r1 = r0.f1574a
            p6.a.e(r10)
            goto L6e
        L3a:
            java.util.ArrayList r1 = r0.f1574a
            p6.a.e(r10)
            goto L5a
        L40:
            java.util.ArrayList r10 = a4.x.w(r10)
            v7.e r1 = o7.m0.f8288a
            p7.c r1 = t7.n.f10348a
            c4.g r7 = new c4.g
            r8 = 0
            r7.<init>(r9, r5, r8)
            r0.f1574a = r10
            r0.f1577m = r4
            java.lang.Object r1 = o7.c0.C(r7, r1, r0)
            if (r1 != r6) goto L59
            goto L81
        L59:
            r1 = r10
        L5a:
            v7.e r10 = o7.m0.f8288a
            v7.d r10 = v7.d.f10884a
            b6.a r4 = new b6.a
            r4.<init>(r9, r1, r5, r3)
            r0.f1574a = r1
            r0.f1577m = r3
            java.lang.Object r10 = o7.c0.C(r4, r10, r0)
            if (r10 != r6) goto L6e
            goto L81
        L6e:
            v7.e r10 = o7.m0.f8288a
            p7.c r10 = t7.n.f10348a
            c4.h r3 = new c4.h
            r3.<init>(r9, r1, r5)
            r0.f1574a = r5
            r0.f1577m = r2
            java.lang.Object r9 = o7.c0.C(r3, r10, r0)
            if (r9 != r6) goto L82
        L81:
            return r6
        L82:
            p6.x r9 = p6.x.f8463a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.AppFilesActivity.y0(com.uptodown.activities.AppFilesActivity, v6.c):java.lang.Object");
    }

    public final void A0() {
        ConcurrentHashMap concurrentHashMap = t.f6708a;
        e eVar = this.Q;
        eVar.getClass();
        z0().f9678b.setImageDrawable(t.b(this, eVar.f11123l));
        TextView textView = z0().f9682o;
        e eVar2 = this.Q;
        eVar2.getClass();
        textView.setText(eVar2.f11122b);
        z0().f9682o.setTypeface(c.f4882w);
        TextView textView2 = z0().f9683p;
        e eVar3 = this.Q;
        eVar3.getClass();
        textView2.setText(eVar3.f11125n);
        z0().f9683p.setTypeface(c.f4883x);
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        try {
            RelativeLayout relativeLayout = z0().f9677a;
            relativeLayout.getClass();
            setContentView(relativeLayout);
            Intent intent = getIntent();
            if (intent != null && (extras = intent.getExtras()) != null && extras.containsKey("appInstalled")) {
                this.Q = (e) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("appInstalled", e.class) : extras.getParcelable("appInstalled"));
            }
            t4.d z02 = z0();
            TextView textView = z02.f9685r;
            RecyclerView recyclerView = z02.f9680m;
            Toolbar toolbar = z02.f9681n;
            textView.setTypeface(c.f4882w);
            Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
            if (drawable != null) {
                toolbar.setNavigationIcon(drawable);
                toolbar.setNavigationContentDescription(getString(2131951735));
            }
            toolbar.setNavigationOnClickListener(new c4.d(this, 0));
            z02.f9684q.setTypeface(c.f4883x);
            z02.f9679l.setOnClickListener(new c4.e(0));
            recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.addItemDecoration(new l((int) getResources().getDimension(2131166251)));
            if (this.Q != null) {
                A0();
                c0.s(this.O, null, null, new s(this, (t6.c) null, 3), 3);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final t4.d z0() {
        return (t4.d) this.P.getValue();
    }
}
