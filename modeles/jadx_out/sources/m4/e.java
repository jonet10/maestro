package m4;

import android.net.nsd.NsdManager$ServiceInfoCallback;
import android.net.nsd.NsdServiceInfo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e implements NsdManager$ServiceInfoCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f7288a;

    public e(g gVar) {
        this.f7288a = gVar;
    }

    public final void onServiceUpdated(NsdServiceInfo nsdServiceInfo) {
        nsdServiceInfo.getClass();
        g.a(this.f7288a, nsdServiceInfo);
    }

    public final void onServiceInfoCallbackUnregistered() {
    }

    public final void onServiceLost() {
    }

    public final void onServiceInfoCallbackRegistrationFailed(int i) {
    }
}
