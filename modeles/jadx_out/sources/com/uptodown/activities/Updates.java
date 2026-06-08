package com.uptodown.activities;

import a5.d;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.l;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import c4.b;
import c4.db;
import c4.e;
import c4.eb;
import c4.ka;
import c4.la;
import c4.ma;
import c4.n4;
import c4.oa;
import c4.ra;
import c4.w;
import c4.w4;
import c4.wa;
import c4.xa;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadUpdatesWorker;
import e4.v0;
import e4.x0;
import j5.a;
import j5.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.y;
import l7.u;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import r7.o0;
import t4.y0;
import t7.n;
import x4.d0;
import x4.j0;
import x4.o1;
import x4.p0;
import x4.q2;
import x4.r;
import x4.u0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class Updates extends w4 {
    public static final /* synthetic */ int n0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    public ArrayList f3355b0;

    /* renamed from: c0, reason: collision with root package name */
    public x0 f3356c0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f3358e0;

    /* renamed from: f0, reason: collision with root package name */
    public String f3359f0;

    /* renamed from: l0, reason: collision with root package name */
    public final ActivityResultLauncher f3365l0;

    /* renamed from: m0, reason: collision with root package name */
    public final b f3366m0;
    public final m Z = new m(new ka(this, 0));
    public final ViewModelLazy a0 = new ViewModelLazy(y.a(eb.class), new xa(this, 0), new wa(this), new xa(this, 1));

    /* renamed from: d0, reason: collision with root package name */
    public ArrayList f3357d0 = new ArrayList();

    /* renamed from: g0, reason: collision with root package name */
    public final String f3360g0 = "panel_actualizaciones_individual";

    /* renamed from: h0, reason: collision with root package name */
    public final oa f3361h0 = new oa(this, 1);

    /* renamed from: i0, reason: collision with root package name */
    public final oa f3362i0 = new oa(this, 0);

    /* renamed from: j0, reason: collision with root package name */
    public final ra f3363j0 = new ra(this);

    /* renamed from: k0, reason: collision with root package name */
    public final ra f3364k0 = new ra(this);

    public Updates() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new la(this));
        registerForActivityResult.getClass();
        this.f3365l0 = registerForActivityResult;
        this.f3366m0 = new b(this, 5);
    }

    public static final void N0(Updates updates, String str) {
        q2 Y;
        if (updates.f3357d0.isEmpty()) {
            return;
        }
        g l10 = g.D.l(updates);
        l10.b();
        r rVar = null;
        if (str != null && (Y = l10.Y(str)) != null) {
            rVar = Y.a(updates);
        }
        l10.c();
        updates.T0().f10250o.setOnClickListener(new e(23));
        updates.T0().f10255t.setText(updates.getString(2131951943, String.valueOf(updates.f3357d0.size() - 1)));
        if (rVar != null) {
            updates.T0().f10247l.setIndeterminate(false);
            updates.T0().f10247l.setProgress(rVar.i());
        }
    }

    @Override // c4.w4
    public final void A0(String str, ArrayList arrayList) {
        str.getClass();
        String string = getString(2131952292);
        string.getClass();
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = m0.f8288a;
        c0.s(lifecycleScope, n.f10348a, null, new w(this, str, string, arrayList, null, 6), 2);
    }

    @Override // c4.w4
    public final String F0() {
        return this.f3360g0;
    }

    @Override // c4.w4
    public final void H0() {
        P0();
        a1();
    }

    @Override // c4.w4
    public final void J0() {
        X0(false);
    }

    @Override // c4.w4
    public final void K0() {
        X0(false);
    }

    public final void O0(int i) {
        if (W0(i)) {
            x0 x0Var = this.f3356c0;
            x0Var.getClass();
            Object obj = x0Var.a().get(i);
            obj.getClass();
            x4.e eVar = ((v0) obj).f4708a;
            Q0(eVar.f11123l);
            G0(eVar);
            x0 x0Var2 = this.f3356c0;
            if (x0Var2 != null) {
                x0Var2.notifyItemChanged(i);
            }
        }
    }

    public final void P0() {
        x0 x0Var = this.f3356c0;
        if (x0Var != null) {
            x0Var.h = false;
        }
        float f = UptodownApp.I;
        synchronized (UptodownApp.f3294h0) {
            UptodownApp.f3295i0 = null;
        }
        V0();
        x0 x0Var2 = this.f3356c0;
        Integer valueOf = x0Var2 != null ? Integer.valueOf(x0Var2.a().size()) : null;
        if (valueOf != null && valueOf.intValue() > 0) {
            int intValue = valueOf.intValue();
            for (int i = 0; i < intValue; i++) {
                O0(i);
            }
        }
        this.f3357d0 = new ArrayList();
    }

    public final void Q0(String str) {
        if (str != null) {
            Iterator it = this.f3357d0.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                int i6 = i + 1;
                if (u.m0(((x4.e) it.next()).f11123l, str, true)) {
                    break;
                } else {
                    i = i6;
                }
            }
            if (i >= 0) {
                this.f3357d0.remove(i);
            }
        }
    }

    public final void R0() {
        File g;
        if (!z3.f2928c) {
            P0();
            return;
        }
        if (!this.f3357d0.isEmpty()) {
            o0 o0Var = d.f201a;
            if (!(o0Var.getValue() instanceof o1)) {
                float f = UptodownApp.I;
                if (!b4.d.p(this, "GenerateQueueWorker") && !b4.d.p(this, "downloadApkWorker")) {
                    Object obj = this.f3357d0.get(0);
                    obj.getClass();
                    e1.c0 c0Var = g.D;
                    g l10 = c0Var.l(this);
                    l10.b();
                    String str = ((x4.e) obj).f11123l;
                    str.getClass();
                    q2 Y = l10.Y(str);
                    r a8 = Y != null ? Y.a(this) : null;
                    l10.c();
                    Z0(this.f3357d0.size() - 1);
                    if (a8 == null || !a8.c()) {
                        boolean z9 = this.f3358e0;
                        if (b4.d.p(this, "DownloadUpdatesWorker")) {
                            return;
                        }
                        WorkManager.Companion.getInstance(this).enqueue(((OneTimeWorkRequest.Builder) l.t(DownloadUpdatesWorker.class, "DownloadUpdatesWorker")).setInputData(new Data.Builder().putBoolean("downloadAnyway", z9).build()).build());
                        return;
                    }
                    if (o0Var.getValue() instanceof o1) {
                        a1();
                        return;
                    }
                    if (this.f3357d0.isEmpty()) {
                        a1();
                        return;
                    }
                    Object remove = this.f3357d0.remove(0);
                    remove.getClass();
                    Context applicationContext = getApplicationContext();
                    applicationContext.getClass();
                    g l11 = c0Var.l(applicationContext);
                    l11.b();
                    String str2 = ((x4.e) remove).f11123l;
                    str2.getClass();
                    q2 Y2 = l11.Y(str2);
                    r a10 = Y2 != null ? Y2.a(this) : null;
                    l11.c();
                    Z0(this.f3357d0.size());
                    if (a10 == null || !a10.c() || (g = a10.g()) == null) {
                        R0();
                        return;
                    }
                    if (Y2.f11349p == 1) {
                        S(Y2, g);
                    } else {
                        W(g, null);
                    }
                    if (this.f3357d0.isEmpty()) {
                        if (b4.d.p(this, "DownloadUpdatesWorker")) {
                            a1();
                            return;
                        } else {
                            V0();
                            return;
                        }
                    }
                    return;
                }
            }
        }
        x0 x0Var = this.f3356c0;
        if (x0Var != null) {
            x0Var.h = false;
        }
        a1();
    }

    public final int S0(String str) {
        x0 x0Var;
        if (str == null || (x0Var = this.f3356c0) == null) {
            return -1;
        }
        ArrayList a8 = x0Var.a();
        Iterator it = a8.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i6 = i + 1;
            if (it.next() instanceof v0) {
                Object obj = a8.get(i);
                obj.getClass();
                if (u.m0(((v0) obj).f4708a.f11123l, str, true)) {
                    return i;
                }
            }
            i = i6;
        }
        return -1;
    }

    public final y0 T0() {
        return (y0) this.Z.getValue();
    }

    public final eb U0() {
        return (eb) this.a0.getValue();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:3|(2:4|5)|(9:7|(1:9)|10|11|12|(1:14)|(1:17)(1:21)|18|19)|24|(0)|10|11|12|(0)|(0)(0)|18|19) */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0066 A[Catch: Exception -> 0x006a, TRY_LEAVE, TryCatch #0 {Exception -> 0x006a, blocks: (B:12:0x005c, B:14:0x0066), top: B:11:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V0() {
        /*
            r11 = this;
            java.lang.String r0 = "SettingsPreferences"
            java.lang.String r1 = "animations"
            t4.y0 r2 = r11.T0()
            android.widget.TextView r2 = r2.f10256u
            r3 = 0
            r2.setVisibility(r3)
            t4.y0 r2 = r11.T0()
            android.widget.RelativeLayout r2 = r2.f10250o
            r4 = 8
            r2.setVisibility(r4)
            t4.y0 r2 = r11.T0()
            android.widget.RelativeLayout r2 = r2.f10248m
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L85
            t4.y0 r2 = r11.T0()
            android.widget.RelativeLayout r2 = r2.f10248m
            c4.qa r5 = new c4.qa
            r5.<init>(r11, r3)
            r6 = 2130772034(0x7f010042, float:1.7147175E38)
            android.view.animation.Animation r7 = android.view.animation.AnimationUtils.loadAnimation(r11, r6)
            float r8 = com.uptodown.UptodownApp.I
            r8 = 1
            android.content.SharedPreferences r9 = r11.getSharedPreferences(r0, r3)     // Catch: java.lang.Exception -> L49
            boolean r10 = r9.contains(r1)     // Catch: java.lang.Exception -> L49
            if (r10 == 0) goto L49
            boolean r9 = r9.getBoolean(r1, r8)     // Catch: java.lang.Exception -> L49
            goto L4a
        L49:
            r9 = r8
        L4a:
            if (r9 == 0) goto L54
            float r9 = com.uptodown.UptodownApp.I
            r7.setAnimationListener(r5)
            r2.startAnimation(r7)
        L54:
            t4.y0 r2 = r11.T0()
            android.widget.RelativeLayout r2 = r2.f10249n
            float r5 = com.uptodown.UptodownApp.I
            android.content.SharedPreferences r0 = r11.getSharedPreferences(r0, r3)     // Catch: java.lang.Exception -> L6a
            boolean r3 = r0.contains(r1)     // Catch: java.lang.Exception -> L6a
            if (r3 == 0) goto L6a
            boolean r8 = r0.getBoolean(r1, r8)     // Catch: java.lang.Exception -> L6a
        L6a:
            if (r8 == 0) goto L79
            float r0 = com.uptodown.UptodownApp.I
            android.view.animation.Animation r0 = android.view.animation.AnimationUtils.loadAnimation(r11, r6)
            r2.startAnimation(r0)
            r2.setVisibility(r4)
            goto L7c
        L79:
            r2.setVisibility(r4)
        L7c:
            t4.y0 r0 = r11.T0()
            android.widget.RelativeLayout r0 = r0.f10248m
            r0.setVisibility(r4)
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.Updates.V0():void");
    }

    public final boolean W0(int i) {
        x0 x0Var = this.f3356c0;
        if (x0Var == null || i < 0) {
            return false;
        }
        x0Var.getClass();
        if (i >= x0Var.getItemCount()) {
            return false;
        }
        x0 x0Var2 = this.f3356c0;
        ArrayList a8 = x0Var2 != null ? x0Var2.a() : null;
        if (a8 == null || a8.isEmpty()) {
            return false;
        }
        x0 x0Var3 = this.f3356c0;
        ArrayList a10 = x0Var3 != null ? x0Var3.a() : null;
        a10.getClass();
        if (a10.size() <= i) {
            return false;
        }
        x0 x0Var4 = this.f3356c0;
        ArrayList a11 = x0Var4 != null ? x0Var4.a() : null;
        a11.getClass();
        return a11.get(i) instanceof v0;
    }

    public final void X0(boolean z9) {
        eb U0 = U0();
        U0.getClass();
        a0 viewModelScope = ViewModelKt.getViewModelScope(U0);
        v7.e eVar = m0.f8288a;
        c0.s(viewModelScope, v7.d.f10884a, null, new db(z9, U0, this, null), 2);
    }

    @Override // c4.k0
    public final void Y(String str) {
        this.f3359f0 = null;
        X0(false);
    }

    public final void Y0() {
        float f = UptodownApp.I;
        int i = 0;
        if (b4.d.p(this, "downloadApkWorker")) {
            x0 x0Var = this.f3356c0;
            if (x0Var != null) {
                x0Var.h = false;
                return;
            }
            return;
        }
        this.f3357d0 = new ArrayList();
        ArrayList arrayList = this.f3355b0;
        arrayList.getClass();
        Iterator it = arrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            this.f3357d0.add(((v0) next).f4708a);
        }
        Iterator it2 = this.f3357d0.iterator();
        it2.getClass();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            next2.getClass();
            x4.e eVar = (x4.e) next2;
            String str = eVar.f11123l;
            if (str != null) {
                a5.e.b(str, "panel_actualizaciones_actualizar_todo");
            }
            w4.D0(eVar);
        }
        x0 x0Var2 = this.f3356c0;
        if (x0Var2 != null) {
            x0Var2.h = true;
            Iterator it3 = x0Var2.a().iterator();
            int i6 = 0;
            int i10 = -1;
            while (it3.hasNext()) {
                int i11 = i + 1;
                if (it3.next() instanceof v0) {
                    if (i10 == -1) {
                        i10 = i;
                    } else {
                        i6++;
                    }
                } else if (i10 != -1) {
                    break;
                }
                i = i11;
            }
            if (i10 >= 0) {
                x0Var2.notifyItemRangeChanged(i10, i6);
            } else {
                x0Var2.notifyDataSetChanged();
            }
        }
        a1();
        R0();
    }

    @Override // c4.k0
    public final void Z(String str) {
        Q0(str);
        X0(false);
    }

    public final void Z0(int i) {
        if (!this.f3357d0.isEmpty() || i >= 0) {
            T0().f10255t.setText(getString(2131951943, String.valueOf(i)));
            T0().f10247l.setIndeterminate(true);
        }
    }

    @Override // c4.k0
    public final void a0(String str) {
        this.f3359f0 = null;
        Q0(str);
        x0 x0Var = this.f3356c0;
        if (x0Var != null && str != null) {
            Iterator it = x0Var.a().iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                int i6 = i + 1;
                Object next = it.next();
                if ((next instanceof v0) && u.m0(((v0) next).f4709b.f11344b, str, true)) {
                    break;
                } else {
                    i = i6;
                }
            }
            x0 x0Var2 = this.f3356c0;
            if (x0Var2 != null && i >= 0 && i < x0Var2.a().size()) {
                Object remove = x0Var2.a().remove(i);
                remove.getClass();
                x4.e eVar = ((v0) remove).f4708a;
                eVar.f11127p = x4.d.f11088b;
                x0Var2.notifyItemRemoved(i);
                int indexOf = x0Var2.a().indexOf("title_recent_updates") + 1;
                x0Var2.a().add(indexOf, eVar);
                x0Var2.notifyItemInserted(indexOf);
            }
        }
        X0(false);
        R0();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:13|(2:14|15)|(9:17|(1:19)(1:33)|20|21|22|(1:24)|(1:27)(1:31)|28|29)|35|(0)(0)|20|21|22|(0)|(0)(0)|28|29) */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab A[Catch: Exception -> 0x00af, TRY_LEAVE, TryCatch #0 {Exception -> 0x00af, blocks: (B:22:0x00a1, B:24:0x00ab), top: B:21:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a1() {
        /*
            r10 = this;
            java.util.ArrayList r0 = r10.f3355b0
            if (r0 == 0) goto Lcb
            int r0 = r0.size()
            r1 = 1
            if (r0 <= r1) goto Lcb
            java.lang.String r0 = "SettingsPreferences"
            java.lang.String r2 = "animations"
            java.util.ArrayList r3 = r10.f3357d0
            boolean r3 = r3.isEmpty()
            r4 = 8
            r5 = 0
            if (r3 != 0) goto L2d
            t4.y0 r3 = r10.T0()
            android.widget.TextView r3 = r3.f10256u
            r3.setVisibility(r4)
            t4.y0 r3 = r10.T0()
            android.widget.RelativeLayout r3 = r3.f10250o
            r3.setVisibility(r5)
            goto L3f
        L2d:
            t4.y0 r3 = r10.T0()
            android.widget.TextView r3 = r3.f10256u
            r3.setVisibility(r5)
            t4.y0 r3 = r10.T0()
            android.widget.RelativeLayout r3 = r3.f10250o
            r3.setVisibility(r4)
        L3f:
            boolean r3 = com.google.android.gms.internal.measurement.z3.f2928c
            if (r3 != 0) goto L50
            t4.y0 r3 = r10.T0()
            android.widget.TextView r3 = r3.f10256u
            r6 = 1053609165(0x3ecccccd, float:0.4)
            r3.setAlpha(r6)
            goto L5b
        L50:
            t4.y0 r3 = r10.T0()
            android.widget.TextView r3 = r3.f10256u
            r6 = 1065353216(0x3f800000, float:1.0)
            r3.setAlpha(r6)
        L5b:
            t4.y0 r3 = r10.T0()
            android.widget.RelativeLayout r3 = r3.f10248m
            int r3 = r3.getVisibility()
            if (r3 != r4) goto Lca
            t4.y0 r3 = r10.T0()
            android.widget.RelativeLayout r3 = r3.f10248m
            c4.qa r4 = new c4.qa
            r4.<init>(r10, r1)
            r6 = 2130772030(0x7f01003e, float:1.7147167E38)
            android.view.animation.Animation r7 = android.view.animation.AnimationUtils.loadAnimation(r10, r6)
            float r8 = com.uptodown.UptodownApp.I
            android.content.SharedPreferences r8 = r10.getSharedPreferences(r0, r5)     // Catch: java.lang.Exception -> L8a
            boolean r9 = r8.contains(r2)     // Catch: java.lang.Exception -> L8a
            if (r9 == 0) goto L8a
            boolean r8 = r8.getBoolean(r2, r1)     // Catch: java.lang.Exception -> L8a
            goto L8b
        L8a:
            r8 = r1
        L8b:
            if (r8 == 0) goto L96
            float r8 = com.uptodown.UptodownApp.I
            r7.setAnimationListener(r4)
            r3.startAnimation(r7)
            goto L99
        L96:
            r4.onAnimationEnd(r7)
        L99:
            t4.y0 r3 = r10.T0()
            android.widget.RelativeLayout r3 = r3.f10249n
            float r4 = com.uptodown.UptodownApp.I
            android.content.SharedPreferences r0 = r10.getSharedPreferences(r0, r5)     // Catch: java.lang.Exception -> Laf
            boolean r4 = r0.contains(r2)     // Catch: java.lang.Exception -> Laf
            if (r4 == 0) goto Laf
            boolean r1 = r0.getBoolean(r2, r1)     // Catch: java.lang.Exception -> Laf
        Laf:
            if (r1 == 0) goto Lbe
            float r0 = com.uptodown.UptodownApp.I
            android.view.animation.Animation r0 = android.view.animation.AnimationUtils.loadAnimation(r10, r6)
            r3.startAnimation(r0)
            r3.setVisibility(r5)
            goto Lc1
        Lbe:
            r3.setVisibility(r5)
        Lc1:
            t4.y0 r0 = r10.T0()
            android.widget.RelativeLayout r0 = r0.f10248m
            r0.setVisibility(r5)
        Lca:
            return
        Lcb:
            r10.V0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.Updates.a1():void");
    }

    @Override // c4.k0
    public final void b0(d0 d0Var) {
        d0Var.getClass();
        int c9 = d0Var.c();
        String b7 = d0Var.b();
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = m0.f8288a;
        c0.s(lifecycleScope, n.f10348a, null, new n4(c9, null, this, b7, null, 1), 2);
    }

    @Override // c4.k0
    public final void d0(u0 u0Var) {
        Bundle bundle;
        u0Var.getClass();
        int c9 = u0Var.c();
        String b7 = u0Var.b();
        if (u0Var instanceof p0) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelableArrayList("apps_parcelable", ((p0) u0Var).f11328a);
            bundle = bundle2;
        } else {
            bundle = null;
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
        v7.e eVar = m0.f8288a;
        c0.s(lifecycleScope, n.f10348a, null, new n4(c9, bundle, this, b7, null, 1), 2);
    }

    @Override // c4.k0
    public final void e0(String str) {
        if (str != null) {
            int S0 = S0(str);
            if (W0(S0)) {
                x0 x0Var = this.f3356c0;
                x0Var.getClass();
                Object obj = x0Var.a().get(S0);
                obj.getClass();
                x4.e eVar = ((v0) obj).f4708a;
                Q0(eVar.f11123l);
                G0(eVar);
                x0 x0Var2 = this.f3356c0;
                if (x0Var2 != null) {
                    x0Var2.notifyItemChanged(S0);
                }
            }
        }
        x0 x0Var3 = this.f3356c0;
        if (x0Var3 != null) {
            x0Var3.g = -1;
        }
        R0();
    }

    @Override // c4.k0
    public final void f0(String str, String str2) {
        String str3;
        x4.e eVar;
        String str4;
        this.f3359f0 = null;
        ArrayList arrayList = this.f3355b0;
        if (arrayList != null) {
            q6.r.m0(arrayList, new ma(str, 0));
        }
        x0 x0Var = this.f3356c0;
        int i = -1;
        if (x0Var != null) {
            x0Var.g = -1;
        }
        if (x0Var != null && str != null && str.length() != 0) {
            int i6 = 0;
            for (Object obj : x0Var.a()) {
                int i10 = i6 + 1;
                if (((obj instanceof x4.e) && (str4 = (eVar = (x4.e) obj).f11123l) != null && str4.length() != 0 && u.m0(eVar.f11123l, str, true)) || ((obj instanceof v0) && u.m0(((v0) obj).f4709b.f11344b, str, true))) {
                    i = i6;
                    break;
                }
                i6 = i10;
            }
            if (i >= 0) {
                g l10 = g.D.l(this);
                l10.b();
                q2 Y = l10.Y(str);
                l10.c();
                if (Y == null || !Y.c()) {
                    x0Var.notifyItemChanged(i);
                } else {
                    x0Var.a().remove(i);
                    x0Var.notifyItemRemoved(i);
                }
            }
        }
        R0();
        x4.e h = a.h(this, str);
        if (h == null || (str3 = h.f11122b) == null || str3.length() == 0) {
            return;
        }
        String string = getString(2131952081, h.f11122b);
        string.getClass();
        A(string);
    }

    @Override // c4.k0
    public final void g0() {
        String str = this.f3359f0;
        this.f3359f0 = null;
        if (str != null) {
            Q0(str);
        }
        x0 x0Var = this.f3356c0;
        if (x0Var != null) {
            x0Var.notifyDataSetChanged();
        }
        R0();
    }

    @Override // c4.k0
    public final void h0(String str) {
        this.f3359f0 = str;
        x0 x0Var = this.f3356c0;
        if (x0Var != null) {
            x0Var.notifyDataSetChanged();
        }
    }

    @Override // c4.k0
    public final void n0() {
        x0 x0Var = this.f3356c0;
        if (x0Var != null) {
            x0Var.g = -1;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:0|1|(1:3)|4|(1:6)|7|8|9|(12:11|12|13|14|(7:16|17|18|19|(1:21)|23|24)|28|17|18|19|(0)|23|24)|31|12|13|14|(0)|28|17|18|19|(0)|23|24) */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009d A[Catch: Exception -> 0x00a2, TRY_LEAVE, TryCatch #2 {Exception -> 0x00a2, blocks: (B:14:0x0093, B:16:0x009d), top: B:13:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01a0 A[Catch: Exception -> 0x01a3, TRY_LEAVE, TryCatch #1 {Exception -> 0x01a3, blocks: (B:19:0x0196, B:21:0x01a0), top: B:18:0x0196 }] */
    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r8) {
        /*
            Method dump skipped, instructions count: 460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.Updates.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (a5.b.d()) {
            WorkManager.Companion.getInstance(this).cancelAllWorkByTag("DownloadUpdatesWorker");
            float f = UptodownApp.I;
            synchronized (UptodownApp.f3294h0) {
                UptodownApp.f3295i0 = null;
            }
        }
    }

    @Override // c4.k0, g4.s0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        x0 x0Var = this.f3356c0;
        if (x0Var != null) {
            x0Var.notifyDataSetChanged();
        }
        Object systemService = getSystemService("notification");
        systemService.getClass();
        ((NotificationManager) systemService).cancel(258);
        R0();
    }

    @Override // c4.k0
    public final void p0(File file) {
        x0 x0Var = this.f3356c0;
        if (x0Var != null) {
            x0Var.g = -1;
        }
        if (x0Var != null) {
            x0Var.b(this, file);
        }
    }

    @Override // c4.k0
    public final void q0(File file) {
        file.getClass();
        x0 x0Var = this.f3356c0;
        if (x0Var != null) {
            x0Var.b(this, file);
        }
    }

    @Override // c4.k0
    public final void r0(File file) {
        x4.e eVar;
        String str;
        x0 x0Var = this.f3356c0;
        if (x0Var != null) {
            g l10 = g.D.l(this);
            l10.b();
            int i = 0;
            for (Object obj : x0Var.a()) {
                int i6 = i + 1;
                if ((obj instanceof x4.e) && (str = (eVar = (x4.e) obj).f11123l) != null && str.length() != 0) {
                    String str2 = eVar.f11123l;
                    str2.getClass();
                    q2 Y = l10.Y(str2);
                    r a8 = Y != null ? Y.a(this) : null;
                    if (a8 != null && a8.F.size() > 0) {
                        Iterator it = a8.F.iterator();
                        it.getClass();
                        while (true) {
                            if (it.hasNext()) {
                                Object next = it.next();
                                next.getClass();
                                if (u.m0(((j0) next).f11240q, file.getAbsolutePath(), true)) {
                                    x0Var.g = i;
                                    break;
                                }
                            }
                        }
                    }
                } else if (obj instanceof v0) {
                    q2 q2Var = ((v0) obj).f4709b;
                    r rVar = q2Var.f11352s;
                    if ((rVar != null ? rVar.F : null) != null) {
                        rVar.getClass();
                        if (rVar.F.size() > 0) {
                            r rVar2 = q2Var.f11352s;
                            rVar2.getClass();
                            Iterator it2 = rVar2.F.iterator();
                            it2.getClass();
                            while (true) {
                                if (it2.hasNext()) {
                                    Object next2 = it2.next();
                                    next2.getClass();
                                    if (u.m0(((j0) next2).f11240q, file.getAbsolutePath(), true)) {
                                        x0Var.g = i;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                i = i6;
            }
            l10.c();
            int i10 = x0Var.g;
            if (i10 >= 0) {
                x0Var.notifyItemChanged(i10);
            }
        }
    }

    @Override // c4.k0
    public final boolean s0() {
        return false;
    }
}
