package m4;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d implements NsdManager.DiscoveryListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f7287a;

    public d(g gVar) {
        this.f7287a = gVar;
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onDiscoveryStarted(String str) {
        str.getClass();
        this.f7287a.f7290a.f1004a.f4887b.set(true);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onDiscoveryStopped(String str) {
        str.getClass();
        UptodownApp uptodownApp = this.f7287a.f7290a.f1004a;
        uptodownApp.f4887b.set(false);
        if (uptodownApp.f4888l.get() || !uptodownApp.f4886a.compareAndSet(true, false)) {
            return;
        }
        Context applicationContext = uptodownApp.getApplicationContext();
        applicationContext.getClass();
        uptodownApp.a(applicationContext);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onServiceFound(NsdServiceInfo nsdServiceInfo) {
        nsdServiceInfo.getClass();
        String serviceName = nsdServiceInfo.getServiceName();
        if (!l.a(nsdServiceInfo.getServiceType(), "_nsduptodown._tcp.") || serviceName == null || serviceName.length() == 0) {
            return;
        }
        String str = f4.c.f4880t;
        if (str == null) {
            l.i("myNsdServiceName");
            throw null;
        }
        if (serviceName.equalsIgnoreCase(str)) {
            return;
        }
        this.f7287a.g.add(nsdServiceInfo);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onServiceLost(NsdServiceInfo nsdServiceInfo) {
        nsdServiceInfo.getClass();
        ArrayList arrayList = this.f7287a.g;
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            it.getClass();
            int i = 0;
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                if (l.a(((NsdServiceInfo) next).getServiceName(), nsdServiceInfo.getServiceName())) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < arrayList.size()) {
                arrayList.remove(i);
            }
        }
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onStartDiscoveryFailed(String str, int i) {
        str.getClass();
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onStopDiscoveryFailed(String str, int i) {
        str.getClass();
    }
}
