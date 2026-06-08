package z4;

import a4.f;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import c4.d3;
import c4.g;
import c4.ga;
import c4.j3;
import c4.j4;
import c4.ta;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.RollbackActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import com.uptodown.tv.ui.activity.TvMyAppsActivity;
import g5.h0;
import java.util.ArrayList;
import o7.c0;
import o7.m0;
import q6.l;
import t7.n;
import u4.f0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends ResultReceiver {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        int i6 = 1;
        if (i == 602) {
            new Handler(Looper.getMainLooper()).postDelayed(new h0(1), 1000L);
            return;
        }
        Activity activity = f4.c.f4875o;
        if (activity != null) {
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            if (activity instanceof Updates) {
                if (i == 600) {
                    Updates updates = (Updates) activity;
                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(updates);
                    v7.e eVar = m0.f8288a;
                    c0.s(lifecycleScope, n.f10348a, null, new g(updates, objArr4 == true ? 1 : 0, 7), 2);
                    return;
                }
                if (i != 601) {
                    return;
                }
                r3 = bundle != null ? bundle.getInt("newUpdatesAvailableCount") : 0;
                Updates updates2 = (Updates) activity;
                LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(updates2);
                v7.e eVar2 = m0.f8288a;
                c0.s(lifecycleScope2, n.f10348a, null, new ta(updates2, r3, (t6.c) null), 2);
                return;
            }
            if (activity instanceof MyApps) {
                if (i == 601) {
                    LifecycleCoroutineScope lifecycleScope3 = LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) activity);
                    v7.e eVar3 = m0.f8288a;
                    c0.s(lifecycleScope3, n.f10348a, null, new j4((MyApps) activity, objArr3 == true ? 1 : 0, i6), 2);
                    return;
                }
                return;
            }
            if (activity instanceof SecurityActivity) {
                if (i == 601) {
                    SecurityActivity securityActivity = (SecurityActivity) activity;
                    LifecycleCoroutineScope lifecycleScope4 = LifecycleOwnerKt.getLifecycleScope(securityActivity);
                    v7.e eVar4 = m0.f8288a;
                    c0.s(lifecycleScope4, n.f10348a, null, new ga(securityActivity, objArr2 == true ? 1 : 0, i6), 2);
                    return;
                }
                return;
            }
            if (activity instanceof TvMyAppsActivity) {
                if (i == 601) {
                    TvMyAppsActivity tvMyAppsActivity = (TvMyAppsActivity) activity;
                    tvMyAppsActivity.runOnUiThread(new f(tvMyAppsActivity, 12));
                    return;
                }
                return;
            }
            if (activity instanceof MainActivity) {
                if (i != 603) {
                    if (i != 604) {
                        return;
                    }
                    MainActivity mainActivity = (MainActivity) activity;
                    mainActivity.runOnUiThread(new d3(r3, mainActivity));
                    return;
                }
                MainActivity mainActivity2 = (MainActivity) activity;
                LifecycleCoroutineScope lifecycleScope5 = LifecycleOwnerKt.getLifecycleScope(mainActivity2);
                v7.e eVar5 = m0.f8288a;
                c0.s(lifecycleScope5, n.f10348a, null, new j3(mainActivity2, objArr == true ? 1 : 0, 6), 2);
                return;
            }
            if (activity instanceof AppDetailActivity) {
                if (i == 603) {
                    ArrayList arrayList = ((AppDetailActivity) activity).S;
                    f0 f0Var = arrayList.isEmpty() ? null : (f0) l.y0(arrayList);
                    if (f0Var != null) {
                        f0Var.D();
                        return;
                    }
                    return;
                }
                return;
            }
            if (activity instanceof WishlistActivity) {
                if (i == 601) {
                    ((WishlistActivity) activity).Q0(null);
                    return;
                }
                return;
            }
            if (activity instanceof RecommendedActivity) {
                if (i == 601) {
                    ((RecommendedActivity) activity).Q0(null);
                    return;
                }
                return;
            }
            if (activity instanceof PublicListActivity) {
                if (i == 601) {
                    ((PublicListActivity) activity).P0(null);
                }
            } else {
                if (activity instanceof RollbackActivity) {
                    if (i == 601) {
                        RollbackActivity rollbackActivity = (RollbackActivity) activity;
                        rollbackActivity.runOnUiThread(new f(rollbackActivity, 3));
                        return;
                    }
                    return;
                }
                if ((activity instanceof TvAppDetailActivity) && i == 603) {
                    TvAppDetailActivity tvAppDetailActivity = (TvAppDetailActivity) activity;
                    tvAppDetailActivity.runOnUiThread(new f(tvAppDetailActivity, 11));
                }
            }
        }
    }
}
