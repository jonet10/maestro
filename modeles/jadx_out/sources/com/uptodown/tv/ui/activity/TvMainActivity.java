package com.uptodown.tv.ui.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b2.t1;
import b4.d;
import com.uptodown.UptodownApp;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.tv.ui.activity.TvMainActivity;
import f5.a;
import g5.k;
import g5.t;
import j5.g;
import java.io.File;
import java.util.List;
import q6.l;
import x4.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class TvMainActivity extends a {

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f3407p = 0;

    /* renamed from: l, reason: collision with root package name */
    public AlertDialog f3408l;

    /* renamed from: m, reason: collision with root package name */
    public t f3409m;

    /* renamed from: n, reason: collision with root package name */
    public final ActivityResultLauncher f3410n;

    /* renamed from: o, reason: collision with root package name */
    public final ActivityResultLauncher f3411o;

    public TvMainActivity() {
        final int i = 0;
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: f5.c

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TvMainActivity f4895b;

            {
                this.f4895b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Bundle extras;
                int i6 = i;
                boolean z9 = false;
                TvMainActivity tvMainActivity = this.f4895b;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i6) {
                    case 0:
                        int i10 = TvMainActivity.f3407p;
                        if (activityResult.getResultCode() == 10) {
                            Intent data = activityResult.getData();
                            String string = (data == null || (extras = data.getExtras()) == null) ? null : extras.getString("realPath");
                            if (string != null && string.length() != 0) {
                                boolean f = j5.a.f(tvMainActivity);
                                File file = new File(string);
                                String absolutePath = file.getAbsolutePath();
                                absolutePath.getClass();
                                Intent intent = new Intent(tvMainActivity, (Class<?>) InstallerActivity.class);
                                intent.putExtra("realPath", absolutePath);
                                intent.putExtra("requireUserAction", f);
                                intent.putExtra("backgroundInstallation", false);
                                intent.addFlags(268435456);
                                tvMainActivity.startActivity(intent);
                                g l10 = g.D.l(tvMainActivity);
                                l10.b();
                                String name = file.getName();
                                name.getClass();
                                r G = l10.G(name);
                                l10.c();
                                Bundle bundle = new Bundle();
                                if ((G != null ? G.f11355b : null) != null) {
                                    String str = G.f11355b;
                                    str.getClass();
                                    t1.i(tvMainActivity, str, bundle, false);
                                    bundle.putString("packagename", G.f11355b);
                                }
                                if (G != null) {
                                    long j = G.f11361q;
                                    if (j > 0) {
                                        bundle.putString("appId", String.valueOf(j));
                                    }
                                }
                                bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "start");
                                android.support.v4.media.g gVar = tvMainActivity.f4892a;
                                if (gVar != null) {
                                    gVar.E(bundle, "install");
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        int i11 = TvMainActivity.f3407p;
                        try {
                            SharedPreferences sharedPreferences = tvMainActivity.getSharedPreferences("SettingsPreferences", 0);
                            if (sharedPreferences.contains("gdpr_tracking_allowed")) {
                                z9 = sharedPreferences.getBoolean("gdpr_tracking_allowed", false);
                            }
                        } catch (Exception unused) {
                        }
                        if (z9) {
                            float f10 = UptodownApp.I;
                            d.F(tvMainActivity);
                            break;
                        }
                        break;
                }
            }
        });
        registerForActivityResult.getClass();
        this.f3410n = registerForActivityResult;
        final int i6 = 1;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: f5.c

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TvMainActivity f4895b;

            {
                this.f4895b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Bundle extras;
                int i62 = i6;
                boolean z9 = false;
                TvMainActivity tvMainActivity = this.f4895b;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i62) {
                    case 0:
                        int i10 = TvMainActivity.f3407p;
                        if (activityResult.getResultCode() == 10) {
                            Intent data = activityResult.getData();
                            String string = (data == null || (extras = data.getExtras()) == null) ? null : extras.getString("realPath");
                            if (string != null && string.length() != 0) {
                                boolean f = j5.a.f(tvMainActivity);
                                File file = new File(string);
                                String absolutePath = file.getAbsolutePath();
                                absolutePath.getClass();
                                Intent intent = new Intent(tvMainActivity, (Class<?>) InstallerActivity.class);
                                intent.putExtra("realPath", absolutePath);
                                intent.putExtra("requireUserAction", f);
                                intent.putExtra("backgroundInstallation", false);
                                intent.addFlags(268435456);
                                tvMainActivity.startActivity(intent);
                                g l10 = g.D.l(tvMainActivity);
                                l10.b();
                                String name = file.getName();
                                name.getClass();
                                r G = l10.G(name);
                                l10.c();
                                Bundle bundle = new Bundle();
                                if ((G != null ? G.f11355b : null) != null) {
                                    String str = G.f11355b;
                                    str.getClass();
                                    t1.i(tvMainActivity, str, bundle, false);
                                    bundle.putString("packagename", G.f11355b);
                                }
                                if (G != null) {
                                    long j = G.f11361q;
                                    if (j > 0) {
                                        bundle.putString("appId", String.valueOf(j));
                                    }
                                }
                                bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "start");
                                android.support.v4.media.g gVar = tvMainActivity.f4892a;
                                if (gVar != null) {
                                    gVar.E(bundle, "install");
                                    break;
                                }
                            }
                        }
                        break;
                    default:
                        int i11 = TvMainActivity.f3407p;
                        try {
                            SharedPreferences sharedPreferences = tvMainActivity.getSharedPreferences("SettingsPreferences", 0);
                            if (sharedPreferences.contains("gdpr_tracking_allowed")) {
                                z9 = sharedPreferences.getBoolean("gdpr_tracking_allowed", false);
                            }
                        } catch (Exception unused) {
                        }
                        if (z9) {
                            float f10 = UptodownApp.I;
                            d.F(tvMainActivity);
                            break;
                        }
                        break;
                }
            }
        });
        registerForActivityResult2.getClass();
        this.f3411o = registerForActivityResult2;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        fragments.getClass();
        if (l.y0(fragments) instanceof k) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003e  */
    @Override // f5.a, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r6) {
        /*
            r5 = this;
            super.onCreate(r6)
            r6 = 2131558831(0x7f0d01af, float:1.8742989E38)
            r5.setContentView(r6)
            g5.t r6 = new g5.t
            r6.<init>()
            r5.f3409m = r6
            androidx.fragment.app.FragmentManager r6 = r5.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r6 = r6.beginTransaction()
            g5.t r0 = r5.f3409m
            r1 = 0
            if (r0 == 0) goto Lc5
            r2 = 2131362197(0x7f0a0195, float:1.8344168E38)
            androidx.fragment.app.FragmentTransaction r6 = r6.replace(r2, r0)
            r6.commit()
            java.lang.String r6 = "gdpr_tracking_allowed"
            r0 = 0
            java.lang.String r2 = "SettingsPreferences"
            android.content.SharedPreferences r2 = r5.getSharedPreferences(r2, r0)     // Catch: java.lang.Exception -> L3b
            boolean r3 = r2.contains(r6)     // Catch: java.lang.Exception -> L3b
            if (r3 == 0) goto L3b
            boolean r6 = r2.getBoolean(r6, r0)     // Catch: java.lang.Exception -> L3b
            goto L3c
        L3b:
            r6 = r0
        L3c:
            if (r6 == 0) goto L43
            float r6 = com.uptodown.UptodownApp.I
            b4.d.F(r5)
        L43:
            androidx.leanback.app.BackgroundManager r6 = androidx.leanback.app.BackgroundManager.getInstance(r5)
            r2 = 2131231285(0x7f080235, float:1.8078647E38)
            android.graphics.drawable.Drawable r2 = androidx.core.content.ContextCompat.getDrawable(r5, r2)
            if (r6 == 0) goto L53
            r6.setDrawable(r2)
        L53:
            android.content.Intent r6 = r5.getIntent()
            if (r6 == 0) goto Lc4
            int r2 = r6.getFlags()
            r3 = 1048576(0x100000, float:1.469368E-39)
            r2 = r2 & r3
            if (r2 != r3) goto L63
            goto Lc4
        L63:
            android.net.Uri r6 = r6.getData()
            if (r6 == 0) goto Lc4
            java.lang.String r2 = n4.d.b(r6, r5)
            if (r2 == 0) goto Lb0
            java.lang.String r3 = ".xapk"
            r4 = 1
            boolean r3 = l7.u.k0(r2, r3, r4)
            if (r3 != 0) goto L92
            java.lang.String r3 = ".apks"
            boolean r3 = l7.u.k0(r2, r3, r4)
            if (r3 != 0) goto L92
            java.lang.String r3 = ".apkm"
            boolean r3 = l7.u.k0(r2, r3, r4)
            if (r3 != 0) goto L92
            java.lang.String r3 = ".zip"
            boolean r3 = l7.u.k0(r2, r3, r4)
            if (r3 == 0) goto L91
            goto L92
        L91:
            r4 = r0
        L92:
            if (r4 != 0) goto L9c
            java.lang.String r3 = ".apk"
            boolean r0 = l7.u.k0(r2, r3, r0)
            if (r0 == 0) goto Lb0
        L9c:
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r1 = r5.getApplicationContext()
            java.lang.Class<com.uptodown.core.activities.InstallerActivity> r2 = com.uptodown.core.activities.InstallerActivity.class
            r0.<init>(r1, r2)
            r0.setData(r6)
            androidx.activity.result.ActivityResultLauncher r6 = r5.f3410n
            r6.launch(r0)
            return
        Lb0:
            java.lang.String r6 = j5.c.d(r6)
            androidx.lifecycle.LifecycleCoroutineScope r0 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r5)
            v7.d r2 = v7.d.f10884a
            c4.ya r3 = new c4.ya
            r4 = 4
            r3.<init>(r5, r6, r1, r4)
            r6 = 2
            o7.c0.s(r0, r2, r1, r3, r6)
        Lc4:
            return
        Lc5:
            java.lang.String r6 = "tvMainFragment"
            kotlin.jvm.internal.l.i(r6)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.tv.ui.activity.TvMainActivity.onCreate(android.os.Bundle):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onResume() {
        /*
            r6 = this;
            super.onResume()
            java.lang.String r0 = "SettingsPreferences"
            android.app.AlertDialog r1 = r6.f3408l
            if (r1 == 0) goto Lc
            r1.dismiss()
        Lc:
            java.lang.String r1 = "is_in_eea"
            r2 = 1
            r3 = 0
            android.content.SharedPreferences r4 = r6.getSharedPreferences(r0, r3)     // Catch: java.lang.Exception -> L1f
            boolean r5 = r4.contains(r1)     // Catch: java.lang.Exception -> L1f
            if (r5 == 0) goto L1f
            boolean r1 = r4.getBoolean(r1, r2)     // Catch: java.lang.Exception -> L1f
            goto L20
        L1f:
            r1 = r2
        L20:
            if (r1 == 0) goto L6e
            java.lang.String r1 = "gdpr_tracking_allowed"
            android.content.SharedPreferences r0 = r6.getSharedPreferences(r0, r3)     // Catch: java.lang.Exception -> L32
            boolean r4 = r0.contains(r1)     // Catch: java.lang.Exception -> L32
            if (r4 == 0) goto L32
            boolean r3 = r0.getBoolean(r1, r3)     // Catch: java.lang.Exception -> L32
        L32:
            if (r3 != 0) goto L6e
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            r0.<init>(r6)
            r1 = 2131952663(0x7f130417, float:1.9541775E38)
            java.lang.String r1 = r6.getString(r1)
            r0.setMessage(r1)
            d4.p r1 = new d4.p
            r1.<init>(r6, r2)
            r3 = 2131952044(0x7f1301ac, float:1.954052E38)
            r0.setPositiveButton(r3, r1)
            f5.b r1 = new f5.b
            r1.<init>(r2)
            r3 = 17039360(0x1040000, float:2.424457E-38)
            r0.setNegativeButton(r3, r1)
            r0.setCancelable(r2)
            android.app.AlertDialog r0 = r0.create()
            r6.f3408l = r0
            boolean r0 = r6.isFinishing()
            if (r0 != 0) goto L6e
            android.app.AlertDialog r0 = r6.f3408l
            if (r0 == 0) goto L6e
            r0.show()
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.tv.ui.activity.TvMainActivity.onResume():void");
    }
}
