package y3;

import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Handler;
import android.os.Looper;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f11795a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f11796b;

    public c(d dVar) {
        this.f11796b = dVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        network.getClass();
        this.f11795a.post(new b(this.f11796b, 0));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        network.getClass();
        this.f11795a.post(new b(this.f11796b, 1));
    }
}
