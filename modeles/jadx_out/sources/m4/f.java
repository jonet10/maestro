package m4;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f implements NsdManager.ResolveListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f7289a;

    public f(g gVar) {
        this.f7289a = gVar;
    }

    @Override // android.net.nsd.NsdManager.ResolveListener
    public final void onResolveFailed(NsdServiceInfo nsdServiceInfo, int i) {
        nsdServiceInfo.getClass();
    }

    @Override // android.net.nsd.NsdManager.ResolveListener
    public final void onServiceResolved(NsdServiceInfo nsdServiceInfo) {
        nsdServiceInfo.getClass();
        g.a(this.f7289a, nsdServiceInfo);
    }
}
