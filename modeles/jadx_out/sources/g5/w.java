package g5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import c4.ya;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class w implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5361a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x4.e f5362b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ TvMyAppsFragment f5363l;

    public /* synthetic */ w(TvMyAppsFragment tvMyAppsFragment, x4.e eVar, int i) {
        this.f5361a = i;
        this.f5363l = tvMyAppsFragment;
        this.f5362b = eVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f5361a;
        x4.e eVar = this.f5362b;
        TvMyAppsFragment tvMyAppsFragment = this.f5363l;
        switch (i) {
            case 0:
                try {
                    if (eVar.f11123l != null) {
                        PackageManager packageManager = tvMyAppsFragment.requireContext().getPackageManager();
                        String str = eVar.f11123l;
                        str.getClass();
                        Intent leanbackLaunchIntentForPackage = packageManager.getLeanbackLaunchIntentForPackage(str);
                        if (leanbackLaunchIntentForPackage == null) {
                            PackageManager packageManager2 = tvMyAppsFragment.requireContext().getPackageManager();
                            String str2 = eVar.f11123l;
                            str2.getClass();
                            leanbackLaunchIntentForPackage = packageManager2.getLaunchIntentForPackage(str2);
                        }
                        if (leanbackLaunchIntentForPackage != null) {
                            tvMyAppsFragment.startActivity(leanbackLaunchIntentForPackage);
                        }
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                AlertDialog alertDialog = tvMyAppsFragment.f3433l;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                    break;
                }
                break;
            case 1:
                if (eVar.f11123l != null) {
                    Context requireContext = tvMyAppsFragment.requireContext();
                    requireContext.getClass();
                    String str3 = eVar.f11123l;
                    str3.getClass();
                    Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str3)));
                    intent.addFlags(268435456);
                    requireContext.startActivity(intent);
                }
                AlertDialog alertDialog2 = tvMyAppsFragment.f3433l;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                    break;
                }
                break;
            case 2:
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(tvMyAppsFragment);
                v7.e eVar2 = o7.m0.f8288a;
                o7.c0.s(lifecycleScope, t7.n.f10348a, null, new ya(tvMyAppsFragment, eVar, (t6.c) null, 12), 2);
                AlertDialog alertDialog3 = tvMyAppsFragment.f3433l;
                if (alertDialog3 != null) {
                    alertDialog3.dismiss();
                    break;
                }
                break;
            default:
                AlertDialog alertDialog4 = tvMyAppsFragment.f3433l;
                if (alertDialog4 != null) {
                    alertDialog4.dismiss();
                }
                e1.c0 c0Var = j5.g.D;
                Context requireContext2 = tvMyAppsFragment.requireContext();
                requireContext2.getClass();
                j5.g l10 = c0Var.l(requireContext2);
                l10.b();
                if (eVar.v == 0) {
                    eVar.v = 1;
                    eVar.f11127p = x4.d.f11088b;
                    String str4 = eVar.f11123l;
                    str4.getClass();
                    l10.s(str4);
                    Context requireContext3 = tvMyAppsFragment.requireContext();
                    requireContext3.getClass();
                    a.a.r(requireContext3);
                } else {
                    eVar.v = 0;
                }
                l10.m0(eVar);
                l10.c();
                break;
        }
    }

    public /* synthetic */ w(x4.e eVar, TvMyAppsFragment tvMyAppsFragment, int i) {
        this.f5361a = i;
        this.f5362b = eVar;
        this.f5363l = tvMyAppsFragment;
    }
}
