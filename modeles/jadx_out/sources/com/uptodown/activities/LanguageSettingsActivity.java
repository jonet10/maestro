package com.uptodown.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.g;
import b.s;
import c4.d;
import c4.e;
import c4.k0;
import e4.o;
import f0.i;
import f4.c;
import o7.c0;
import p6.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class LanguageSettingsActivity extends k0 {
    public static final /* synthetic */ int S = 0;
    public o O;
    public final i P = new i(this, 7);
    public final m Q = new m(new g(this, 19));
    public final LifecycleCoroutineScope R = LifecycleOwnerKt.getLifecycleScope(this);

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0073, code lost:
    
        if (o7.c0.C(r1, r9, r0) == r6) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0075, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
    
        if (o7.c0.C(r1, r9, r0) != r6) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
    
        if (o7.c0.C(r1, r9, r0) == r6) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object y0(com.uptodown.activities.LanguageSettingsActivity r8, v6.c r9) {
        /*
            boolean r0 = r9 instanceof c4.v1
            if (r0 == 0) goto L13
            r0 = r9
            c4.v1 r0 = (c4.v1) r0
            int r1 = r0.f2193l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2193l = r1
            goto L18
        L13:
            c4.v1 r0 = new c4.v1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f2191a
            int r1 = r0.f2193l
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            u6.a r6 = u6.a.f10762a
            if (r1 == 0) goto L3c
            if (r1 == r4) goto L38
            if (r1 == r3) goto L34
            if (r1 != r2) goto L2e
            p6.a.e(r9)
            goto L76
        L2e:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r8)
            return r5
        L34:
            p6.a.e(r9)
            goto L64
        L38:
            p6.a.e(r9)
            goto L52
        L3c:
            p6.a.e(r9)
            v7.e r9 = o7.m0.f8288a
            p7.c r9 = t7.n.f10348a
            c4.w1 r1 = new c4.w1
            r7 = 0
            r1.<init>(r8, r5, r7)
            r0.f2193l = r4
            java.lang.Object r9 = o7.c0.C(r1, r9, r0)
            if (r9 != r6) goto L52
            goto L75
        L52:
            v7.e r9 = o7.m0.f8288a
            v7.d r9 = v7.d.f10884a
            c4.w1 r1 = new c4.w1
            r1.<init>(r8, r5, r4)
            r0.f2193l = r3
            java.lang.Object r9 = o7.c0.C(r1, r9, r0)
            if (r9 != r6) goto L64
            goto L75
        L64:
            v7.e r9 = o7.m0.f8288a
            p7.c r9 = t7.n.f10348a
            c4.x1 r1 = new c4.x1
            r1.<init>(r8, r5)
            r0.f2193l = r2
            java.lang.Object r8 = o7.c0.C(r1, r9, r0)
            if (r8 != r6) goto L76
        L75:
            return r6
        L76:
            p6.x r8 = p6.x.f8463a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.LanguageSettingsActivity.y0(com.uptodown.activities.LanguageSettingsActivity, v6.c):java.lang.Object");
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = z0().f10103a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        if (drawable != null) {
            z0().f10106m.setNavigationIcon(drawable);
            z0().f10106m.setNavigationContentDescription(getString(2131951735));
        }
        z0().f10107n.setTypeface(c.f4882w);
        int i = 5;
        z0().f10106m.setNavigationOnClickListener(new d(this, i));
        z0().f10104b.setOnClickListener(new e(5));
        z0().f10105l.setLayoutManager(new LinearLayoutManager(this, 1, false));
        z0().f10105l.setItemAnimator(new DefaultItemAnimator());
        c0.s(this.R, null, null, new s(this, (t6.c) null, i), 3);
    }

    public final t4.s z0() {
        return (t4.s) this.Q.getValue();
    }
}
