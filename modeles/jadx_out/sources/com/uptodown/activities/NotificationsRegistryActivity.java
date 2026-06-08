package com.uptodown.activities;

import a3.d;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.inputmethod.a;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.g;
import c4.b6;
import c4.k0;
import c4.t5;
import c4.u5;
import c4.v5;
import c4.w5;
import c4.z5;
import com.uptodown.UptodownApp;
import e4.q;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.y;
import l5.f;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.m;
import t4.b0;
import t6.c;
import t7.n;
import v7.e;
import x4.s1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class NotificationsRegistryActivity extends k0 {
    public static final /* synthetic */ int T = 0;
    public q R;
    public final m O = new m(new g(this, 26));
    public final ViewModelLazy P = new ViewModelLazy(y.a(b6.class), new w5(this, 0), new v5(this), new w5(this, 1));
    public boolean Q = true;
    public final d S = new d(this, 10);

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void y0(NotificationsRegistryActivity notificationsRegistryActivity, int i, int i6) {
        q qVar = notificationsRegistryActivity.R;
        if (qVar == null || qVar.f4657a.size() <= i) {
            return;
        }
        q qVar2 = notificationsRegistryActivity.R;
        qVar2.getClass();
        Object obj = qVar2.f4657a.get(i);
        obj.getClass();
        s1 s1Var = (s1) obj;
        String str = s1Var.f11388e;
        if (str != null) {
            List G0 = l7.m.G0(str, new String[]{";"});
            if (G0.size() > i6) {
                String str2 = (String) G0.get(i6);
                String str3 = s1Var.f;
                switch (str2.hashCode()) {
                    case -1569440520:
                        if (str2.equals("positive_apps")) {
                            Intent intent = new Intent(notificationsRegistryActivity, (Class<?>) SecurityActivity.class);
                            float f = UptodownApp.I;
                            notificationsRegistryActivity.startActivity(intent, b4.d.a(notificationsRegistryActivity));
                            return;
                        }
                        break;
                    case -1335458389:
                        if (str2.equals("delete")) {
                            if (str3 == null) {
                                String string = notificationsRegistryActivity.getString(2131952275);
                                string.getClass();
                                notificationsRegistryActivity.A(string);
                                return;
                            } else {
                                File file = new File(str3);
                                String string2 = notificationsRegistryActivity.getString(2131951933, file.getName());
                                string2.getClass();
                                notificationsRegistryActivity.H(string2, new t5(i, file, 0, notificationsRegistryActivity));
                                return;
                            }
                        }
                        break;
                    case -504325460:
                        if (str2.equals("open_app")) {
                            if (str3 == null) {
                                String string3 = notificationsRegistryActivity.getString(2131952275);
                                string3.getClass();
                                notificationsRegistryActivity.A(string3);
                                return;
                            }
                            try {
                                Intent launchIntentForPackage = notificationsRegistryActivity.getPackageManager().getLaunchIntentForPackage(str3);
                                if (launchIntentForPackage != null) {
                                    notificationsRegistryActivity.startActivity(launchIntentForPackage);
                                    return;
                                }
                                String string4 = notificationsRegistryActivity.getString(2131951694);
                                string4.getClass();
                                notificationsRegistryActivity.A(string4);
                                return;
                            } catch (Exception e10) {
                                e10.printStackTrace();
                                String string5 = notificationsRegistryActivity.getString(2131951694);
                                string5.getClass();
                                notificationsRegistryActivity.A(string5);
                                return;
                            }
                        }
                        break;
                    case -234430262:
                        if (str2.equals("updates")) {
                            Intent intent2 = new Intent(notificationsRegistryActivity, (Class<?>) Updates.class);
                            float f10 = UptodownApp.I;
                            notificationsRegistryActivity.startActivity(intent2, b4.d.a(notificationsRegistryActivity));
                            return;
                        }
                        break;
                    case 1085191854:
                        if (str2.equals("update_uptodown")) {
                            if (str3 == null) {
                                String string6 = notificationsRegistryActivity.getString(2131952275);
                                string6.getClass();
                                notificationsRegistryActivity.A(string6);
                                return;
                            }
                            File file2 = new File(str3);
                            if (file2.exists()) {
                                float f11 = UptodownApp.I;
                                b4.d.r(notificationsRegistryActivity, file2);
                                return;
                            } else {
                                String string7 = notificationsRegistryActivity.getString(2131952085);
                                string7.getClass();
                                notificationsRegistryActivity.A(string7);
                                return;
                            }
                        }
                        break;
                    case 1117687366:
                        if (str2.equals("preregister")) {
                            if (str3 != null) {
                                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(notificationsRegistryActivity);
                                e eVar = m0.f8288a;
                                c0.s(lifecycleScope, n.f10348a, null, new b.n(notificationsRegistryActivity, str3, (c) null, 22), 2);
                                return;
                            } else {
                                String string8 = notificationsRegistryActivity.getString(2131952275);
                                string8.getClass();
                                notificationsRegistryActivity.A(string8);
                                return;
                            }
                        }
                        break;
                    case 1312704747:
                        if (str2.equals("downloads")) {
                            Intent intent3 = new Intent(notificationsRegistryActivity, (Class<?>) MyDownloads.class);
                            float f12 = UptodownApp.I;
                            notificationsRegistryActivity.startActivity(intent3, b4.d.a(notificationsRegistryActivity));
                            return;
                        }
                        break;
                    case 1957569947:
                        if (str2.equals("install")) {
                            if (str3 == null) {
                                String string9 = notificationsRegistryActivity.getString(2131952275);
                                string9.getClass();
                                notificationsRegistryActivity.A(string9);
                                return;
                            }
                            File file3 = new File(str3);
                            if (file3.exists()) {
                                float f13 = UptodownApp.I;
                                b4.d.r(notificationsRegistryActivity, file3);
                                return;
                            } else {
                                String string10 = notificationsRegistryActivity.getString(2131952085);
                                string10.getClass();
                                notificationsRegistryActivity.A(string10);
                                return;
                            }
                        }
                        break;
                }
                String string11 = notificationsRegistryActivity.getString(2131952275);
                string11.getClass();
                notificationsRegistryActivity.A(string11);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
    
        if (o7.c0.C(r1, r8, r0) != r5) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0061, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
    
        if (o7.c0.C(r1, r8, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object z0(com.uptodown.activities.NotificationsRegistryActivity r6, int r7, v6.c r8) {
        /*
            boolean r0 = r8 instanceof c4.x5
            if (r0 == 0) goto L13
            r0 = r8
            c4.x5 r0 = (c4.x5) r0
            int r1 = r0.f2304m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2304m = r1
            goto L18
        L13:
            c4.x5 r0 = new c4.x5
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f2302b
            int r1 = r0.f2304m
            r2 = 0
            r3 = 2
            r4 = 1
            u6.a r5 = u6.a.f10762a
            if (r1 == 0) goto L37
            if (r1 == r4) goto L31
            if (r1 != r3) goto L2b
            p6.a.e(r8)
            goto L62
        L2b:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            return r2
        L31:
            int r7 = r0.f2301a
            p6.a.e(r8)
            goto L4e
        L37:
            p6.a.e(r8)
            v7.e r8 = o7.m0.f8288a
            v7.d r8 = v7.d.f10884a
            c4.u5 r1 = new c4.u5
            r1.<init>(r6, r7, r2, r4)
            r0.f2301a = r7
            r0.f2304m = r4
            java.lang.Object r8 = o7.c0.C(r1, r8, r0)
            if (r8 != r5) goto L4e
            goto L61
        L4e:
            v7.e r8 = o7.m0.f8288a
            p7.c r8 = t7.n.f10348a
            c4.u5 r1 = new c4.u5
            r1.<init>(r6, r7, r2, r3)
            r0.f2301a = r7
            r0.f2304m = r3
            java.lang.Object r6 = o7.c0.C(r1, r8, r0)
            if (r6 != r5) goto L62
        L61:
            return r5
        L62:
            p6.x r6 = p6.x.f8463a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.NotificationsRegistryActivity.z0(com.uptodown.activities.NotificationsRegistryActivity, int, v6.c):java.lang.Object");
    }

    public final b0 A0() {
        return (b0) this.O.getValue();
    }

    public final b6 B0() {
        return (b6) this.P.getValue();
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = A0().f9639a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        if (drawable != null) {
            A0().f9642m.setNavigationIcon(drawable);
            A0().f9642m.setNavigationContentDescription(getString(2131951735));
        }
        A0().f9642m.setNavigationOnClickListener(new c4.d(this, 9));
        A0().f9642m.inflateMenu(2131689474);
        A0().f9642m.setOverflowIcon(ContextCompat.getDrawable(this, 2131231365));
        A0().f9642m.setOnMenuItemClickListener(new a(this, 6));
        A0().f9644o.setTypeface(f4.c.f4882w);
        A0().f9643n.setTypeface(f4.c.f4883x);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        int dimension = (int) getResources().getDimension(2131166251);
        A0().f9641l.addItemDecoration(new f(dimension, dimension));
        A0().f9641l.setLayoutManager(linearLayoutManager);
        A0().f9641l.setItemAnimator(new DefaultItemAnimator());
        A0().f9640b.setOnClickListener(new c4.e(14));
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new u5(this, null), 2);
    }

    @Override // c4.k0, g4.s0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.Q) {
            b6 B0 = B0();
            B0.getClass();
            a0 viewModelScope = ViewModelKt.getViewModelScope(B0);
            e eVar = m0.f8288a;
            c0.s(viewModelScope, v7.d.f10884a, null, new z5(this, B0, null, 1), 2);
        }
    }
}
