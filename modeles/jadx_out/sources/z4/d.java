package z4;

import a4.f;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b2.t1;
import c4.e3;
import c4.f5;
import c4.ya;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.Updates;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import g4.e0;
import j5.g;
import k0.k;
import o7.c0;
import o7.m0;
import t7.n;
import x4.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends ResultReceiver {

    /* renamed from: a, reason: collision with root package name */
    public Context f11962a;

    public final void a(String str, String str2, String str3, String str4) {
        Context context = this.f11962a;
        if (context == null) {
            return;
        }
        Bundle f = k.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str2, "installType", str3);
        if (str4 != null) {
            f.putString("error", str4);
        }
        if (str != null) {
            f.putString("packagename", str);
            g l10 = g.D.l(context);
            l10.b();
            boolean z9 = false;
            if (l10.Y(str) != null) {
                f.putInt("update", 1);
            } else {
                f.putInt("update", 0);
            }
            r K = l10.K(str);
            if (K != null) {
                long j = K.f11361q;
                if (j > 0) {
                    f.putString("appId", String.valueOf(j));
                }
            }
            l10.c();
            if (K != null && K.A == 1) {
                z9 = true;
            }
            t1.i(context, str, f, z9);
            f.putString("updateOrigin", a5.e.a(str));
            a5.e.f205a.remove(str);
        }
        new android.support.v4.media.g(context, 20).E(f, "install");
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        t6.c cVar = null;
        String string = bundle != null ? bundle.getString("packageName") : null;
        String string2 = bundle != null ? bundle.getString("errorMsg") : null;
        if (i == 352) {
            a(string, "success", "system", null);
        } else if (i != 353) {
            switch (i) {
                case 302:
                    a(string, "success", "root", null);
                    break;
                case 303:
                    a(string, "failed", "root", string2);
                    break;
                case 304:
                    a(string, "failed", "root", "INVALID_VERSIONCODE");
                    break;
            }
        } else {
            a(string, "failed", "system", string2);
        }
        Activity activity = f4.c.f4875o;
        if (activity != null) {
            int i6 = 2;
            if (activity instanceof Updates) {
                if (string != null) {
                    Updates updates = (Updates) activity;
                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(updates);
                    v7.e eVar = m0.f8288a;
                    c0.s(lifecycleScope, n.f10348a, null, new ya(updates, string, i, cVar, 0), 2);
                    return;
                }
                return;
            }
            if (activity instanceof MyApps) {
                if (string != null) {
                    MyApps myApps = (MyApps) activity;
                    LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(myApps);
                    v7.e eVar2 = m0.f8288a;
                    c0.s(lifecycleScope2, n.f10348a, null, new b.n(myApps, string, i, cVar, 19), 2);
                    return;
                }
                return;
            }
            if (activity instanceof AppDetailActivity) {
                if (string != null) {
                    AppDetailActivity appDetailActivity = (AppDetailActivity) activity;
                    appDetailActivity.runOnUiThread(new f(appDetailActivity, string, i));
                    return;
                }
                return;
            }
            int i10 = 0;
            if (activity instanceof MyDownloads) {
                MyDownloads myDownloads = (MyDownloads) activity;
                myDownloads.runOnUiThread(new f5(myDownloads, i, i10));
                return;
            }
            if (activity instanceof OldVersionsActivity) {
                OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) activity;
                oldVersionsActivity.runOnUiThread(new e3(i, 1, oldVersionsActivity, string));
                return;
            }
            if (activity instanceof InstallerActivity) {
                if (i != 351) {
                    ((InstallerActivity) activity).finish();
                    return;
                } else {
                    InstallerActivity installerActivity = (InstallerActivity) activity;
                    installerActivity.runOnUiThread(new e0(installerActivity, i10));
                    return;
                }
            }
            if (activity instanceof TvAppDetailActivity) {
                if (string != null) {
                    TvAppDetailActivity tvAppDetailActivity = (TvAppDetailActivity) activity;
                    tvAppDetailActivity.runOnUiThread(new e3(i, i6, tvAppDetailActivity, string));
                    return;
                }
                return;
            }
            if (!(activity instanceof MainActivity) || string == null) {
                return;
            }
            MainActivity mainActivity = (MainActivity) activity;
            mainActivity.runOnUiThread(new e3(mainActivity, i, string, i10));
        }
    }
}
