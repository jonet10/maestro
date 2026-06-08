package com.uptodown.core.activities;

import a2.t;
import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.LifecycleOwnerKt;
import b6.g;
import c4.b;
import c4.ya;
import com.uptodown.core.activities.InstallerActivity;
import f0.i;
import f4.c;
import g4.a0;
import g4.f0;
import g4.h;
import g4.h0;
import g4.k0;
import g4.l0;
import h4.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import l4.l;
import l7.m;
import l7.u;
import m8.q;
import n4.d;
import o7.c0;
import o7.m0;
import o7.s1;
import q6.r;
import t0.f;
import v7.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class InstallerActivity extends h {

    /* renamed from: j0, reason: collision with root package name */
    public static final /* synthetic */ int f3394j0 = 0;
    public TextView A;
    public ImageView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public LinearLayout F;
    public TextView G;
    public TextView H;
    public TextView I;
    public TextView J;
    public TextView K;
    public TextView L;
    public TextView M;
    public TextView N;
    public ImageView O;
    public ImageView P;
    public String Q;
    public ArrayList R;
    public String S;
    public Uri T;
    public AlertDialog U;
    public AlertDialog V;
    public ArrayList W;
    public s1 X;
    public i Y;
    public boolean Z;
    public LinearLayout a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f3395b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f3396c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f3397d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f3398e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f3399f0;

    /* renamed from: g0, reason: collision with root package name */
    public final b f3400g0 = new b(this, 9);

    /* renamed from: h0, reason: collision with root package name */
    public final h0 f3401h0 = new h0(this);

    /* renamed from: i0, reason: collision with root package name */
    public final h0 f3402i0 = new h0(this);

    /* renamed from: y, reason: collision with root package name */
    public ProgressBar f3403y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f3404z;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0067, code lost:
    
        if (o7.c0.C(r1, r10, r0) != r5) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
    
        if (o7.c0.C(r1, r10, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object C(com.uptodown.core.activities.InstallerActivity r7, android.net.Uri r8, java.lang.String r9, v6.c r10) {
        /*
            boolean r0 = r10 instanceof g4.m0
            if (r0 == 0) goto L13
            r0 = r10
            g4.m0 r0 = (g4.m0) r0
            int r1 = r0.f5224n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5224n = r1
            goto L18
        L13:
            g4.m0 r0 = new g4.m0
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f5222l
            int r1 = r0.f5224n
            r2 = 2
            r3 = 1
            r4 = 0
            u6.a r5 = u6.a.f10762a
            if (r1 == 0) goto L39
            if (r1 == r3) goto L31
            if (r1 != r2) goto L2b
            p6.a.e(r10)
            goto L6a
        L2b:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r7)
            return r4
        L31:
            java.lang.String r9 = r0.f5221b
            android.net.Uri r8 = r0.f5220a
            p6.a.e(r10)
            goto L54
        L39:
            p6.a.e(r10)
            v7.e r10 = o7.m0.f8288a
            p7.c r10 = t7.n.f10348a
            c4.g r1 = new c4.g
            r6 = 11
            r1.<init>(r7, r4, r6)
            r0.f5220a = r8
            r0.f5221b = r9
            r0.f5224n = r3
            java.lang.Object r10 = o7.c0.C(r1, r10, r0)
            if (r10 != r5) goto L54
            goto L69
        L54:
            v7.e r10 = o7.m0.f8288a
            v7.d r10 = v7.d.f10884a
            g4.l0 r1 = new g4.l0
            r1.<init>(r9, r7, r8, r4)
            r0.f5220a = r4
            r0.f5221b = r4
            r0.f5224n = r2
            java.lang.Object r7 = o7.c0.C(r1, r10, r0)
            if (r7 != r5) goto L6a
        L69:
            return r5
        L6a:
            p6.x r7 = p6.x.f8463a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.InstallerActivity.C(com.uptodown.core.activities.InstallerActivity, android.net.Uri, java.lang.String, v6.c):java.lang.Object");
    }

    public final void D() {
        Activity activity = c.f4875o;
        f.f(this, null);
        ArrayList arrayList = this.R;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            it.getClass();
            while (it.hasNext()) {
                File file = (File) it.next();
                if (file != null && file.exists()) {
                    file.delete();
                }
            }
        }
        finish();
    }

    public final void E() {
        TextView textView;
        InstallerActivity installerActivity;
        String str;
        ImageView imageView;
        setContentView(2131558583);
        try {
            this.Z = false;
            Intent intent = getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                this.T = data;
                if (data != null) {
                    this.Q = d.b(data, this);
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    if (extras.containsKey("realPath")) {
                        this.S = extras.getString("realPath");
                    }
                    if (extras.containsKey("newFeatures")) {
                        this.f3396c0 = extras.getString("newFeatures");
                    }
                    if (extras.containsKey("requireUserAction")) {
                        this.f3397d0 = extras.getBoolean("requireUserAction");
                    }
                    if (extras.containsKey("notificationId")) {
                        int i = extras.getInt("notificationId");
                        Object systemService = getSystemService("notification");
                        systemService.getClass();
                        ((NotificationManager) systemService).cancel(i);
                    }
                    if (extras.containsKey("backgroundInstallation")) {
                        this.f3398e0 = extras.getBoolean("backgroundInstallation");
                    }
                }
            }
            this.a0 = (LinearLayout) findViewById(2131362675);
            ImageView imageView2 = (ImageView) findViewById(2131362367);
            this.P = imageView2;
            imageView2.getClass();
            imageView2.setOnClickListener(new a0(this, 5));
            this.O = (ImageView) findViewById(2131362412);
            TextView textView2 = (TextView) findViewById(2131363643);
            this.E = textView2;
            if (textView2 != null) {
                textView2.setTypeface(c.f4882w);
            }
            String str2 = this.Q;
            if (str2 != null) {
                TextView textView3 = this.G;
                if (textView3 != null) {
                    textView3.setText(str2);
                }
                String str3 = this.Q;
                str3.getClass();
                if (u.k0(str3, ".apk", false)) {
                    ImageView imageView3 = this.O;
                    if (imageView3 != null) {
                        imageView3.setImageResource(2131230918);
                    }
                } else {
                    String str4 = this.Q;
                    str4.getClass();
                    if (u.k0(str4, ".xapk", false) && (imageView = this.O) != null) {
                        imageView.setImageResource(2131230965);
                    }
                }
            } else {
                String str5 = this.S;
                if (str5 != null && (textView = this.G) != null) {
                    str5.getClass();
                    textView.setText(str5.substring(m.A0("/", str5, 6) + 1));
                }
            }
            this.F = (LinearLayout) findViewById(2131362670);
            TextView textView4 = (TextView) findViewById(2131363873);
            if (textView4 != null) {
                textView4.setTypeface(c.f4883x);
            }
            TextView textView5 = (TextView) findViewById(2131363872);
            this.G = textView5;
            if (textView5 != null) {
                textView5.setTypeface(c.f4882w);
            }
            TextView textView6 = (TextView) findViewById(2131364309);
            if (textView6 != null) {
                textView6.setTypeface(c.f4883x);
            }
            TextView textView7 = (TextView) findViewById(2131364307);
            this.H = textView7;
            if (textView7 != null) {
                textView7.setTypeface(c.f4882w);
            }
            TextView textView8 = (TextView) findViewById(2131364569);
            if (textView8 != null) {
                textView8.setTypeface(c.f4883x);
            }
            TextView textView9 = (TextView) findViewById(2131364568);
            this.I = textView9;
            if (textView9 != null) {
                textView9.setTypeface(c.f4882w);
            }
            ProgressBar progressBar = (ProgressBar) findViewById(2131363000);
            this.f3403y = progressBar;
            progressBar.getClass();
            progressBar.setInterpolator(new AccelerateDecelerateInterpolator());
            TextView textView10 = (TextView) findViewById(2131364016);
            this.f3404z = textView10;
            if (textView10 != null) {
                textView10.setTypeface(c.f4883x);
            }
            TextView textView11 = (TextView) findViewById(2131364018);
            this.L = textView11;
            if (textView11 != null) {
                textView11.setTypeface(c.f4883x);
            }
            TextView textView12 = (TextView) findViewById(2131363911);
            this.M = textView12;
            if (textView12 != null) {
                textView12.setTypeface(c.f4882w);
            }
            TextView textView13 = this.M;
            if (textView13 != null) {
                textView13.setVisibility(8);
            }
            TextView textView14 = this.M;
            if (textView14 != null) {
                textView14.setOnClickListener(new a0(this, 6));
            }
            TextView textView15 = (TextView) findViewById(2131363699);
            this.N = textView15;
            if (textView15 != null) {
                textView15.setTypeface(c.f4882w);
            }
            TextView textView16 = this.N;
            if (textView16 != null) {
                textView16.setVisibility(8);
            }
            TextView textView17 = this.N;
            if (textView17 != null) {
                textView17.setOnClickListener(new a0(this, 7));
            }
            String str6 = this.f3396c0;
            if (str6 == null || str6.length() == 0) {
                installerActivity = this;
            } else {
                TextView textView18 = this.f3404z;
                textView18.getClass();
                textView18.setVisibility(8);
                kotlin.jvm.internal.u uVar = new kotlin.jvm.internal.u();
                LinearLayout linearLayout = (LinearLayout) findViewById(2131362738);
                LinearLayout linearLayout2 = (LinearLayout) findViewById(2131362774);
                TextView textView19 = (TextView) findViewById(2131364572);
                ImageView imageView4 = (ImageView) findViewById(2131362547);
                textView19.setTypeface(c.f4882w);
                TextView textView20 = (TextView) findViewById(2131364573);
                textView20.setTypeface(c.f4883x);
                textView20.setText(this.f3396c0);
                textView20.setVisibility(8);
                linearLayout2.setVisibility(0);
                installerActivity = this;
                try {
                    linearLayout.setOnClickListener(new f0(uVar, textView19, installerActivity, imageView4, textView20));
                } catch (Exception e10) {
                    e = e10;
                    e.printStackTrace();
                    return;
                }
            }
            installerActivity.Y = new i(this, 28);
            installerActivity.W = J();
            if (installerActivity.T == null || (str = installerActivity.Q) == null || !(u.k0(str, ".apk", true) || u.k0(str, ".xapk", true) || u.k0(str, ".apks", true) || u.k0(str, ".apkm", true) || u.k0(str, ".zip", true))) {
                L(installerActivity.S);
                return;
            }
            Uri uri = installerActivity.T;
            uri.getClass();
            String str7 = installerActivity.Q;
            str7.getClass();
            e eVar = m0.f8288a;
            c0.s(c0.b(v7.d.f10884a), null, null, new l0(this, uri, str7, (t6.c) null), 3);
        } catch (Exception e11) {
            e = e11;
        }
    }

    public final void F(File file) {
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        n4.h hVar = new n4.h(applicationContext);
        hVar.f7969b = this.f3397d0;
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        e eVar = m0.f8288a;
        c0.s(c0.b(v7.d.f10884a), null, null, new ya(hVar, arrayList, (t6.c) null, 21), 3);
    }

    public final void G(Activity activity, final File file) {
        a aVar = new a(activity);
        final int i = 0;
        boolean c9 = aVar.c("device_rooted", false);
        boolean c10 = aVar.c("system_app", false);
        if (!this.Z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(file);
            if (I(arrayList)) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(file);
                N(arrayList2);
                return;
            }
        }
        if (!c9 && !c10) {
            F(file);
            return;
        }
        final int i6 = 1;
        if (!aVar.c("user_asked_for_show_permissions", false)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(2131952803));
            builder.setMessage(2131952270);
            builder.setCancelable(false);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(this) { // from class: g4.d0

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ InstallerActivity f5152b;

                {
                    this.f5152b = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    int i11 = i;
                    File file2 = file;
                    InstallerActivity installerActivity = this.f5152b;
                    switch (i11) {
                        case 0:
                            int i12 = InstallerActivity.f3394j0;
                            h4.a aVar2 = new h4.a(installerActivity);
                            aVar2.i(true);
                            aVar2.e("install_apk_as_root_system", true);
                            installerActivity.G(installerActivity, file2);
                            break;
                        default:
                            int i13 = InstallerActivity.f3394j0;
                            h4.a aVar3 = new h4.a(installerActivity);
                            aVar3.i(true);
                            aVar3.e("install_apk_as_root_system", false);
                            installerActivity.G(installerActivity, file2);
                            break;
                    }
                }
            });
            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener(this) { // from class: g4.d0

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ InstallerActivity f5152b;

                {
                    this.f5152b = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    int i11 = i6;
                    File file2 = file;
                    InstallerActivity installerActivity = this.f5152b;
                    switch (i11) {
                        case 0:
                            int i12 = InstallerActivity.f3394j0;
                            h4.a aVar2 = new h4.a(installerActivity);
                            aVar2.i(true);
                            aVar2.e("install_apk_as_root_system", true);
                            installerActivity.G(installerActivity, file2);
                            break;
                        default:
                            int i13 = InstallerActivity.f3394j0;
                            h4.a aVar3 = new h4.a(installerActivity);
                            aVar3.i(true);
                            aVar3.e("install_apk_as_root_system", false);
                            installerActivity.G(installerActivity, file2);
                            break;
                    }
                }
            });
            builder.create().show();
            return;
        }
        if (!aVar.c("install_apk_as_root_system", false)) {
            F(file);
            return;
        }
        t6.c cVar = null;
        if (aVar.c("device_rooted", false)) {
            String absolutePath = file.getAbsolutePath();
            absolutePath.getClass();
            c0.s(c0.b(m0.f8288a), null, null, new g(absolutePath, activity, this.f3402i0, cVar, 19), 3);
            return;
        }
        if (aVar.c("system_app", false)) {
            q qVar = new q(i6, activity, this.f3401h0);
            e eVar = m0.f8288a;
            c0.s(c0.b(v7.d.f10884a), null, null, new ya(qVar, file, cVar, 22), 3);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:0|1|(2:2|3)|(20:5|6|7|8|(3:10|11|(6:18|(6:26|27|28|(2:30|(2:32|33))|35|(0))|21|(1:23)|24|25)(2:15|16))|38|11|(1:13)|18|(0)|26|27|28|(0)|35|(0)|21|(0)|24|25)|41|6|7|8|(0)|38|11|(0)|18|(0)|26|27|28|(0)|35|(0)|21|(0)|24|25) */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024 A[Catch: Exception -> 0x0029, TRY_LEAVE, TryCatch #1 {Exception -> 0x0029, blocks: (B:8:0x001a, B:10:0x0024), top: B:7:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0049 A[Catch: Exception -> 0x004e, TRY_LEAVE, TryCatch #0 {Exception -> 0x004e, blocks: (B:28:0x003f, B:30:0x0049), top: B:27:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H(android.app.Activity r7, java.util.ArrayList r8) {
        /*
            r6 = this;
            java.lang.String r0 = "CoreSettings"
            r7.getClass()
            java.lang.String r1 = "device_rooted"
            r2 = 0
            android.content.SharedPreferences r3 = r7.getSharedPreferences(r0, r2)     // Catch: java.lang.Exception -> L17
            boolean r4 = r3.contains(r1)     // Catch: java.lang.Exception -> L17
            if (r4 == 0) goto L17
            boolean r1 = r3.getBoolean(r1, r2)     // Catch: java.lang.Exception -> L17
            goto L18
        L17:
            r1 = r2
        L18:
            java.lang.String r3 = "system_app"
            android.content.SharedPreferences r4 = r7.getSharedPreferences(r0, r2)     // Catch: java.lang.Exception -> L29
            boolean r5 = r4.contains(r3)     // Catch: java.lang.Exception -> L29
            if (r5 == 0) goto L29
            boolean r3 = r4.getBoolean(r3, r2)     // Catch: java.lang.Exception -> L29
            goto L2a
        L29:
            r3 = r2
        L2a:
            boolean r4 = r6.Z
            if (r4 != 0) goto L38
            boolean r4 = r6.I(r8)
            if (r4 == 0) goto L38
            r6.N(r8)
            return
        L38:
            r4 = 1
            if (r1 != 0) goto L3d
            if (r3 == 0) goto L86
        L3d:
            java.lang.String r1 = "user_asked_for_show_permissions"
            android.content.SharedPreferences r0 = r7.getSharedPreferences(r0, r2)     // Catch: java.lang.Exception -> L4e
            boolean r3 = r0.contains(r1)     // Catch: java.lang.Exception -> L4e
            if (r3 == 0) goto L4e
            boolean r0 = r0.getBoolean(r1, r2)     // Catch: java.lang.Exception -> L4e
            goto L4f
        L4e:
            r0 = r2
        L4f:
            if (r0 != 0) goto L86
            androidx.appcompat.app.AlertDialog$Builder r7 = new androidx.appcompat.app.AlertDialog$Builder
            r7.<init>(r6)
            r0 = 2131952803(0x7f1304a3, float:1.954206E38)
            java.lang.String r0 = r6.getString(r0)
            r7.setTitle(r0)
            r0 = 2131952270(0x7f13028e, float:1.9540978E38)
            r7.setMessage(r0)
            r7.setCancelable(r2)
            g4.c0 r0 = new g4.c0
            r0.<init>(r6, r8, r2)
            r1 = 17039370(0x104000a, float:2.42446E-38)
            r7.setPositiveButton(r1, r0)
            g4.c0 r0 = new g4.c0
            r0.<init>(r6, r8, r4)
            r8 = 17039360(0x1040000, float:2.424457E-38)
            r7.setNegativeButton(r8, r0)
            androidx.appcompat.app.AlertDialog r7 = r7.create()
            r7.show()
            return
        L86:
            boolean r0 = r6.f3398e0
            if (r0 != 0) goto L92
            g4.e0 r0 = new g4.e0
            r0.<init>(r6, r4)
            r6.runOnUiThread(r0)
        L92:
            n4.h r0 = new n4.h
            r0.<init>(r7)
            boolean r7 = r6.f3397d0
            r0.k(r8, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.InstallerActivity.H(android.app.Activity, java.util.ArrayList):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean I(java.util.ArrayList r8) {
        /*
            r7 = this;
            r0 = 0
            java.lang.String r1 = "warn_installed"
            r2 = 1
            java.lang.String r3 = "CoreSettings"
            android.content.SharedPreferences r3 = r7.getSharedPreferences(r3, r0)     // Catch: java.lang.Exception -> L15
            boolean r4 = r3.contains(r1)     // Catch: java.lang.Exception -> L15
            if (r4 == 0) goto L15
            boolean r1 = r3.getBoolean(r1, r2)     // Catch: java.lang.Exception -> L15
            goto L16
        L15:
            r1 = r2
        L16:
            if (r1 == 0) goto L6a
            int r1 = r8.size()     // Catch: java.lang.Exception -> L6a
            if (r1 != r2) goto L6a
            java.lang.Object r1 = r8.get(r0)     // Catch: java.lang.Exception -> L6a
            java.io.File r1 = (java.io.File) r1     // Catch: java.lang.Exception -> L6a
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Exception -> L6a
            r1.getClass()     // Catch: java.lang.Exception -> L6a
            java.lang.String r3 = ".apk"
            boolean r1 = l7.u.k0(r1, r3, r0)     // Catch: java.lang.Exception -> L6a
            if (r1 == 0) goto L6a
            android.content.pm.PackageManager r1 = r7.getPackageManager()     // Catch: java.lang.Exception -> L6a
            r1.getClass()     // Catch: java.lang.Exception -> L6a
            java.lang.Object r8 = r8.get(r0)     // Catch: java.lang.Exception -> L6a
            java.io.File r8 = (java.io.File) r8     // Catch: java.lang.Exception -> L6a
            java.lang.String r8 = r8.getAbsolutePath()     // Catch: java.lang.Exception -> L6a
            r8.getClass()     // Catch: java.lang.Exception -> L6a
            android.content.pm.PackageInfo r8 = n4.i.d(r1, r8, r0)     // Catch: java.lang.Exception -> L6a
            if (r8 == 0) goto L6a
            android.content.pm.PackageManager r1 = r7.getPackageManager()     // Catch: java.lang.Exception -> L6a
            r1.getClass()     // Catch: java.lang.Exception -> L6a
            java.lang.String r3 = r8.packageName     // Catch: java.lang.Exception -> L6a
            r3.getClass()     // Catch: java.lang.Exception -> L6a
            android.content.pm.PackageInfo r1 = n4.i.e(r1, r3, r0)     // Catch: java.lang.Exception -> L6a
            long r3 = n4.d.d(r1)     // Catch: java.lang.Exception -> L6a
            long r5 = n4.d.d(r8)     // Catch: java.lang.Exception -> L6a
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L6a
            return r2
        L6a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.InstallerActivity.I(java.util.ArrayList):boolean");
    }

    public final ArrayList J() {
        String string = getString(2131951718);
        string.getClass();
        ArrayList arrayList = new ArrayList();
        try {
            String[] stringArray = getResources().getStringArray(2130903046);
            stringArray.getClass();
            for (String str : stringArray) {
                str.getClass();
                if (str.length() > 0) {
                    if (m.q0(str, "%s", false)) {
                        arrayList.add(u.o0(str, "%s", string, false));
                    } else {
                        arrayList.add(str);
                    }
                }
            }
            String[] stringArray2 = getResources().getStringArray(2130903047);
            stringArray2.getClass();
            for (String str2 : stringArray2) {
                str2.getClass();
                if (str2.length() > 0) {
                    if (m.q0(str2, "%s", false)) {
                        arrayList.add(u.o0(str2, "%s", string, false));
                    } else {
                        arrayList.add(str2);
                    }
                }
            }
            return arrayList;
        } catch (Resources.NotFoundException e10) {
            e10.printStackTrace();
            return arrayList;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0255, code lost:
    
        if (r3.equals("arm64_v8a") == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02c9, code lost:
    
        r0 = new l4.n();
        r0.f7120a = r6;
        r0.f7122c = r3;
        r0.f7124e = r3;
        r0.f = r15;
        ((java.util.ArrayList) r5.f82l).add(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x025f, code lost:
    
        if (r3.equals("armeabi_v7a") == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0269, code lost:
    
        if (r3.equals("xhdpi") == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x031b, code lost:
    
        r0 = new l4.n();
        r0.f7120a = r6;
        r0.f7122c = r3;
        r0.f7124e = r3;
        r0.f7121b = r3.equalsIgnoreCase(r7);
        r0.f7123d = true;
        r0.f = r15;
        ((java.util.ArrayList) r5.f83m).add(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0273, code lost:
    
        if (r3.equals("tvdpi") == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x027d, code lost:
    
        if (r3.equals("mips") == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0287, code lost:
    
        if (r3.equals("mdpi") == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0290, code lost:
    
        if (r3.equals("ldpi") == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0299, code lost:
    
        if (r3.equals("hdpi") == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02a2, code lost:
    
        if (r3.equals("x86") != false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02ab, code lost:
    
        if (r3.equals("armeabi") == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02b4, code lost:
    
        if (r3.equals("xxhdpi") == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x02bd, code lost:
    
        if (r3.equals("x86_64") == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02c6, code lost:
    
        if (r3.equals("mips64") == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02e5, code lost:
    
        if (r3.equals("xxxhdpi") == false) goto L133;
     */
    /* JADX WARN: Removed duplicated region for block: B:288:0x08a3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x017b A[Catch: Exception -> 0x0198, TryCatch #2 {Exception -> 0x0198, blocks: (B:59:0x0155, B:69:0x017b, B:72:0x019a, B:74:0x01a3, B:76:0x01ad, B:81:0x0175, B:63:0x015b, B:65:0x015f, B:67:0x0165), top: B:58:0x0155, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019a A[Catch: Exception -> 0x0198, TryCatch #2 {Exception -> 0x0198, blocks: (B:59:0x0155, B:69:0x017b, B:72:0x019a, B:74:0x01a3, B:76:0x01ad, B:81:0x0175, B:63:0x015b, B:65:0x015f, B:67:0x0165), top: B:58:0x0155, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K(java.io.File r20, java.util.ArrayList r21) {
        /*
            Method dump skipped, instructions count: 2276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.InstallerActivity.K(java.io.File, java.util.ArrayList):void");
    }

    public final void L(String str) {
        if (str == null || !new File(str).exists()) {
            String string = getString(2131952085);
            string.getClass();
            A(string);
            finish();
            return;
        }
        if (new File(str).isDirectory()) {
            ArrayList arrayList = new ArrayList();
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null) {
                r.l0(arrayList, listFiles);
                K(null, arrayList);
                return;
            }
            return;
        }
        if (u.k0(str, ".xapk", true) || u.k0(str, ".apks", true) || u.k0(str, ".apkm", true) || u.k0(str, ".zip", true)) {
            i iVar = this.Y;
            iVar.getClass();
            new t(this, str, iVar, m());
        } else {
            if (u.k0(str, ".apk", false)) {
                G(this, new File(str));
                return;
            }
            String string2 = getString(2131952085);
            string2.getClass();
            A(string2);
            finish();
        }
    }

    public final void M(String str) {
        str.getClass();
        TextView textView = this.L;
        if (textView != null) {
            textView.setText(str);
        }
        ProgressBar progressBar = this.f3403y;
        if (progressBar != null) {
            progressBar.setIndeterminate(false);
        }
        getWindow().clearFlags(128);
        s1 s1Var = this.X;
        if (s1Var != null) {
            s1Var.c(null);
        }
        TextView textView2 = this.f3404z;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = this.N;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        TextView textView4 = this.N;
        if (textView4 != null) {
            textView4.setOnClickListener(new a0(this, 4));
        }
        A(str);
    }

    public final void N(ArrayList arrayList) {
        android.app.AlertDialog alertDialog;
        android.app.AlertDialog alertDialog2 = this.V;
        if (alertDialog2 != null && alertDialog2.isShowing()) {
            android.app.AlertDialog alertDialog3 = this.V;
            alertDialog3.getClass();
            alertDialog3.dismiss();
        }
        View inflate = getLayoutInflater().inflate(2131558509, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(2131364017)).setTypeface(c.f4883x);
        CheckBox checkBox = (CheckBox) inflate.findViewById(2131362005);
        checkBox.setTypeface(c.f4883x);
        TextView textView = (TextView) inflate.findViewById(2131363907);
        textView.setTypeface(c.f4882w);
        textView.setOnClickListener(new c4.t(this, checkBox, arrayList, 12));
        TextView textView2 = (TextView) inflate.findViewById(2131363688);
        textView2.setTypeface(c.f4882w);
        textView2.setOnClickListener(new a0(this, 1));
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        builder.setCancelable(false);
        android.app.AlertDialog create = builder.create();
        this.V = create;
        Window window = create != null ? create.getWindow() : null;
        window.getClass();
        window.setBackgroundDrawable(new ColorDrawable(0));
        if (isFinishing() || (alertDialog = this.V) == null) {
            return;
        }
        alertDialog.show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        if (o7.c0.C(r4, r12, r0) != r10) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0071, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
    
        if (o7.c0.C(r4, r13, r0) == r10) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object O(int r12, v6.c r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof g4.o0
            if (r0 == 0) goto L13
            r0 = r13
            g4.o0 r0 = (g4.o0) r0
            int r1 = r0.f5237n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5237n = r1
            goto L18
        L13:
            g4.o0 r0 = new g4.o0
            r0.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r0.f5235l
            int r1 = r0.f5237n
            r2 = 2
            r3 = 1
            r8 = 0
            u6.a r10 = u6.a.f10762a
            if (r1 == 0) goto L3c
            if (r1 == r3) goto L32
            if (r1 != r2) goto L2b
            p6.a.e(r13)
            goto L72
        L2b:
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r12)
            r12 = 0
            return r12
        L32:
            int r12 = r0.f5233a
            kotlin.jvm.internal.x r1 = r0.f5234b
            p6.a.e(r13)
        L39:
            r6 = r12
            r7 = r1
            goto L5a
        L3c:
            p6.a.e(r13)
            kotlin.jvm.internal.x r1 = new kotlin.jvm.internal.x
            r1.<init>()
            v7.e r13 = o7.m0.f8288a
            v7.d r13 = v7.d.f10884a
            g4.n0 r4 = new g4.n0
            r4.<init>(r11, r1, r8, r3)
            r0.f5234b = r1
            r0.f5233a = r12
            r0.f5237n = r3
            java.lang.Object r13 = o7.c0.C(r4, r13, r0)
            if (r13 != r10) goto L39
            goto L71
        L5a:
            v7.e r12 = o7.m0.f8288a
            p7.c r12 = t7.n.f10348a
            c4.ya r4 = new c4.ya
            r9 = 6
            r5 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f5234b = r8
            r0.f5233a = r6
            r0.f5237n = r2
            java.lang.Object r12 = o7.c0.C(r4, r12, r0)
            if (r12 != r10) goto L72
        L71:
            return r10
        L72:
            p6.x r12 = p6.x.f8463a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.core.activities.InstallerActivity.O(int, v6.c):java.lang.Object");
    }

    @Override // g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        TextView textView;
        super.onCreate(bundle);
        f4.a aVar = f4.a.f4869a;
        int i = 1;
        t6.c cVar = null;
        if (aVar.c() == null && c.v == null) {
            E();
        } else {
            setContentView(2131558584);
            this.f3395b0 = true;
            f4.a.f4872d.n(l.f7119a);
            TextView textView2 = (TextView) findViewById(2131363896);
            this.A = textView2;
            textView2.getClass();
            textView2.setTypeface(c.f4882w);
            this.B = (ImageView) findViewById(2131362293);
            TextView textView3 = (TextView) findViewById(2131363655);
            this.C = textView3;
            textView3.getClass();
            textView3.setTypeface(c.f4882w);
            TextView textView4 = (TextView) findViewById(2131363654);
            this.D = textView4;
            textView4.getClass();
            textView4.setTypeface(c.f4883x);
            TextView textView5 = (TextView) findViewById(2131363913);
            this.J = textView5;
            textView5.getClass();
            textView5.setTypeface(c.f4883x);
            TextView textView6 = (TextView) findViewById(2131363699);
            this.N = textView6;
            textView6.getClass();
            textView6.setTypeface(c.f4882w);
            TextView textView7 = this.N;
            textView7.getClass();
            textView7.setOnClickListener(new a0(this, 0));
            TextView textView8 = (TextView) findViewById(2131363911);
            this.M = textView8;
            textView8.getClass();
            textView8.setTypeface(c.f4882w);
            TextView textView9 = this.M;
            textView9.getClass();
            textView9.setOnClickListener(new a0(this, 3));
            this.f3403y = (ProgressBar) findViewById(2131363000);
            TextView textView10 = (TextView) findViewById(2131363912);
            this.K = textView10;
            textView10.getClass();
            textView10.setTypeface(c.f4883x);
            l4.a c9 = aVar.c();
            String str = c9 != null ? c9.f7097c : null;
            if (str != null && (textView = this.K) != null) {
                textView.setText(str);
            }
        }
        getOnBackPressedDispatcher().addCallback(this, this.f3400g0);
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new k0(this, cVar, i), 3);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        s1 s1Var = this.X;
        if (s1Var != null) {
            s1Var.c(null);
        }
        getWindow().clearFlags(128);
    }

    @Override // g4.h
    public final void w() {
        i iVar;
        if (!m() || new File("/Android/obb").canRead() || (iVar = this.Y) == null) {
            return;
        }
        iVar.t();
    }

    @Override // g4.h
    public final void p() {
    }

    @Override // g4.h
    public final void q() {
    }

    @Override // g4.h
    public final void r() {
    }

    @Override // g4.h
    public final void s() {
    }

    @Override // g4.h
    public final void u() {
    }
}
