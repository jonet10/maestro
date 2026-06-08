package com.uptodown.activities;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.room.g;
import c4.i;
import c4.j;
import c4.w4;
import com.google.android.gms.internal.measurement.z3;
import java.util.ArrayList;
import l4.a;
import l7.u;
import o7.c0;
import o7.m0;
import p6.m;
import t0.f;
import t6.c;
import t7.n;
import x4.e;
import x4.o0;
import x4.p0;
import x4.u0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class AppInstalledDetailsActivity extends w4 {

    /* renamed from: e0, reason: collision with root package name */
    public static final /* synthetic */ int f3300e0 = 0;
    public final String Z = "AppInstalledDetailsActivity";
    public final m a0 = new m(new g(this, 10));

    /* renamed from: b0, reason: collision with root package name */
    public e f3301b0;

    /* renamed from: c0, reason: collision with root package name */
    public x4.g f3302c0;

    /* renamed from: d0, reason: collision with root package name */
    public ArrayList f3303d0;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        if (o7.c0.C(r1, r7, r0) != r5) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
    
        if (o7.c0.C(r1, r7, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object N0(com.uptodown.activities.AppInstalledDetailsActivity r6, v6.c r7) {
        /*
            boolean r0 = r7 instanceof c4.l
            if (r0 == 0) goto L13
            r0 = r7
            c4.l r0 = (c4.l) r0
            int r1 = r0.f1810l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1810l = r1
            goto L18
        L13:
            c4.l r0 = new c4.l
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f1808a
            int r1 = r0.f1810l
            r2 = 0
            r3 = 2
            r4 = 1
            u6.a r5 = u6.a.f10762a
            if (r1 == 0) goto L35
            if (r1 == r4) goto L31
            if (r1 != r3) goto L2b
            p6.a.e(r7)
            goto L5c
        L2b:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            return r2
        L31:
            p6.a.e(r7)
            goto L4a
        L35:
            p6.a.e(r7)
            v7.e r7 = o7.m0.f8288a
            v7.d r7 = v7.d.f10884a
            c4.k r1 = new c4.k
            r1.<init>(r6, r2, r4)
            r0.f1810l = r4
            java.lang.Object r7 = o7.c0.C(r1, r7, r0)
            if (r7 != r5) goto L4a
            goto L5b
        L4a:
            v7.e r7 = o7.m0.f8288a
            p7.c r7 = t7.n.f10348a
            c4.k r1 = new c4.k
            r1.<init>(r6, r2, r3)
            r0.f1810l = r3
            java.lang.Object r6 = o7.c0.C(r1, r7, r0)
            if (r6 != r5) goto L5c
        L5b:
            return r5
        L5c:
            p6.x r6 = p6.x.f8463a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.AppInstalledDetailsActivity.N0(com.uptodown.activities.AppInstalledDetailsActivity, v6.c):java.lang.Object");
    }

    public static final void O0(AppInstalledDetailsActivity appInstalledDetailsActivity) {
        f.s(appInstalledDetailsActivity.R0().f9743s, appInstalledDetailsActivity.R0().f9719b);
        appInstalledDetailsActivity.R0().f9737p.setVisibility(8);
        appInstalledDetailsActivity.R0().f9729k0.setVisibility(8);
        appInstalledDetailsActivity.R0().C.setVisibility(8);
        appInstalledDetailsActivity.R0().f9736o0.setVisibility(0);
    }

    public static final void P0(AppInstalledDetailsActivity appInstalledDetailsActivity, String str) {
        f.s(appInstalledDetailsActivity.R0().f9743s, appInstalledDetailsActivity.R0().f9719b);
        appInstalledDetailsActivity.R0().V.setVisibility(0);
        appInstalledDetailsActivity.R0().f9736o0.setVisibility(0);
        appInstalledDetailsActivity.R0().f9737p.setVisibility(8);
        appInstalledDetailsActivity.R0().K.setVisibility(8);
        z3.J(appInstalledDetailsActivity.R0().f9729k0);
        appInstalledDetailsActivity.R0().f9729k0.setVisibility(0);
        appInstalledDetailsActivity.R0().f9729k0.setOnClickListener(new c.e(1, appInstalledDetailsActivity, str));
    }

    @Override // c4.w4
    public final String F0() {
        return this.Z;
    }

    public final void Q0() {
        if (this.f3302c0 == null) {
            e eVar = this.f3301b0;
            eVar.getClass();
            if (eVar.F > 0) {
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
                v7.e eVar2 = m0.f8288a;
                c0.s(lifecycleScope, n.f10348a, null, new j(this, null, 1), 2);
            }
        }
    }

    public final t4.e R0() {
        return (t4.e) this.a0.getValue();
    }

    public final void S0() {
        f.I(R0().f9743s, R0().f9719b);
        R0().f9743s.setIndeterminate(true);
        R0().f9737p.setVisibility(0);
        R0().f9736o0.setVisibility(0);
        R0().V.setVisibility(8);
        R0().f9729k0.setVisibility(8);
        R0().K.setVisibility(8);
        R0().C.setVisibility(0);
    }

    public final void T0() {
        f.I(R0().f9743s, R0().f9719b);
        R0().f9737p.setVisibility(0);
        R0().f9736o0.setVisibility(8);
        R0().V.setVisibility(0);
        R0().K.setOnClickListener(new i(this, 1));
        R0().f9729k0.setVisibility(8);
        R0().K.setVisibility(0);
    }

    @Override // c4.k0
    public final void d0(u0 u0Var) {
        u0Var.getClass();
        if ((u0Var instanceof o0) || (u0Var instanceof p0)) {
            String string = getString(2131952001);
            string.getClass();
            A(string);
        } else {
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            v7.e eVar = m0.f8288a;
            c0.s(lifecycleScope, n.f10348a, null, new b.n(this, u0Var, (c) null, 9), 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x064e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x067a  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0616  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x06c9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x036d A[Catch: Exception -> 0x037a, TryCatch #2 {Exception -> 0x037a, blocks: (B:75:0x0367, B:77:0x036d, B:81:0x037c), top: B:74:0x0367 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x037c A[Catch: Exception -> 0x037a, TRY_LEAVE, TryCatch #2 {Exception -> 0x037a, blocks: (B:75:0x0367, B:77:0x036d, B:81:0x037c), top: B:74:0x0367 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0405  */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2, types: [o7.b0, t6.c, t6.h] */
    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r19) {
        /*
            Method dump skipped, instructions count: 1756
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.AppInstalledDetailsActivity.onCreate(android.os.Bundle):void");
    }

    @Override // c4.k0, g4.s0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.f3301b0 != null) {
            a c9 = f4.a.f4869a.c();
            c cVar = null;
            String str = c9 != null ? c9.f7095a : null;
            e eVar = this.f3301b0;
            eVar.getClass();
            if (!u.m0(str, eVar.f11123l, true)) {
                c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new j(this, cVar, 4), 3);
            } else {
                R0().f9743s.setIndeterminate(true);
                f.I(R0().f9743s, R0().f9719b);
            }
        }
    }
}
