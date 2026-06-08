package j5;

import android.app.Activity;
import android.app.AlertDialog;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import c4.b0;
import c4.d3;
import c4.k0;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.Updates;
import o7.c0;
import o7.m0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ android.support.v4.media.g f6704a;

    public n(android.support.v4.media.g gVar) {
        this.f6704a = gVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        MainActivity mainActivity;
        RelativeLayout relativeLayout;
        network.getClass();
        if (z3.f2928c) {
            return;
        }
        int i = 1;
        z3.f2928c = true;
        Activity activity = f4.c.f4875o;
        if (activity != null) {
            float f = UptodownApp.I;
            b4.d.d((UptodownApp) this.f6704a.f247b);
            if (activity instanceof k0) {
                k0 k0Var = (k0) activity;
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(k0Var);
                v7.e eVar = m0.f8288a;
                c0.s(lifecycleScope, v7.d.f10884a, null, new b0(k0Var, null), 2);
            }
            if ((activity instanceof MainActivity) && (relativeLayout = (mainActivity = (MainActivity) activity).f3311i0) != null && relativeLayout.getVisibility() == 0) {
                mainActivity.runOnUiThread(new d3(i, mainActivity));
            }
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Updates updates;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        UptodownApp uptodownApp = (UptodownApp) this.f6704a.f247b;
        network.getClass();
        networkCapabilities.getClass();
        super.onCapabilitiesChanged(network, networkCapabilities);
        boolean z9 = true;
        boolean hasTransport = networkCapabilities.hasTransport(1);
        boolean z10 = z3.f;
        int linkDownstreamBandwidthKbps = networkCapabilities.getLinkDownstreamBandwidthKbps();
        int i = z3.f2929d;
        int i6 = z3.f2930e;
        z3.f = hasTransport;
        z3.f2929d = networkCapabilities.getLinkDownstreamBandwidthKbps();
        z3.f2930e = networkCapabilities.getLinkUpstreamBandwidthKbps();
        if (i == 0 || i6 == 0) {
            float f = UptodownApp.I;
            b4.d.d(uptodownApp);
            return;
        }
        if (z10 == hasTransport) {
            if (4300 >= linkDownstreamBandwidthKbps ? i <= 4300 : i >= 4300) {
                z9 = false;
            }
            if (z3.f || !z9) {
                return;
            }
            float f10 = UptodownApp.I;
            b4.d.d(uptodownApp);
            return;
        }
        float f11 = UptodownApp.I;
        b4.d.d(uptodownApp);
        if (z3.f) {
            b4.d.F(uptodownApp);
            Activity activity = f4.c.f4875o;
            if (activity != null && (activity instanceof Updates) && (alertDialog = (updates = (Updates) activity).F) != null && alertDialog.isShowing() && z3.f) {
                AlertDialog alertDialog3 = updates.F;
                if ((alertDialog3 != null ? (TextView) alertDialog3.findViewById(2131364385) : null) == null || (alertDialog2 = updates.F) == null) {
                    return;
                }
                alertDialog2.dismiss();
            }
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        network.getClass();
        z3.f2928c = false;
        z3.f = false;
    }
}
