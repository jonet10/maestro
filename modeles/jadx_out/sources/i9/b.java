package i9;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ConnectivityManager f5708a;

    public b(ConnectivityManager connectivityManager) {
        this.f5708a = connectivityManager;
    }

    public final boolean a() {
        ConnectivityManager connectivityManager = this.f5708a;
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        return (networkCapabilities != null && networkCapabilities.hasCapability(12)) && (networkCapabilities != null && networkCapabilities.hasCapability(16));
    }
}
