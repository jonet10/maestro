package m4;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final b4.g f7290a;

    /* renamed from: b, reason: collision with root package name */
    public final NsdManager f7291b;

    /* renamed from: c, reason: collision with root package name */
    public f f7292c;

    /* renamed from: d, reason: collision with root package name */
    public e f7293d;

    /* renamed from: e, reason: collision with root package name */
    public d f7294e;
    public NsdServiceInfo f;
    public final ArrayList g;

    public g(Context context, b4.g gVar) {
        context.getClass();
        gVar.getClass();
        this.f7290a = gVar;
        Object systemService = context.getSystemService("servicediscovery");
        systemService.getClass();
        this.f7291b = (NsdManager) systemService;
        this.g = new ArrayList();
    }

    public static final void a(g gVar, NsdServiceInfo nsdServiceInfo) {
        String serviceName = nsdServiceInfo.getServiceName();
        String str = f4.c.f4880t;
        if (str == null) {
            l.i("myNsdServiceName");
            throw null;
        }
        if (l.a(serviceName, str)) {
            return;
        }
        gVar.f = nsdServiceInfo;
        gVar.f7290a.getClass();
        b bVar = f4.c.f4885z;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void b() {
        if (this.f7294e == null) {
            d dVar = new d(this);
            this.f7294e = dVar;
            try {
                this.f7291b.discoverServices("_nsduptodown._tcp.", 1, dVar);
            } catch (IllegalArgumentException e10) {
                e10.printStackTrace();
                UptodownApp uptodownApp = this.f7290a.f1004a;
            }
        }
    }

    public final void c() {
        e eVar;
        d dVar = this.f7294e;
        NsdManager nsdManager = this.f7291b;
        if (dVar != null) {
            try {
                nsdManager.stopServiceDiscovery(dVar);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            this.f7294e = null;
        }
        if (Build.VERSION.SDK_INT >= 34 && (eVar = this.f7293d) != null) {
            try {
                nsdManager.unregisterServiceInfoCallback(eVar);
            } catch (IllegalArgumentException unused) {
            }
        }
        this.g.clear();
        this.f = null;
    }

    public final void d(NsdServiceInfo nsdServiceInfo) {
        e eVar;
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            if (this.f7293d == null) {
                this.f7293d = new e(this);
            }
        } else if (this.f7292c == null) {
            this.f7292c = new f(this);
        }
        NsdManager nsdManager = this.f7291b;
        if (i < 34) {
            nsdManager.resolveService(nsdServiceInfo, this.f7292c);
            return;
        }
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        if (newSingleThreadScheduledExecutor == null || (eVar = this.f7293d) == null) {
            return;
        }
        nsdManager.registerServiceInfoCallback(nsdServiceInfo, newSingleThreadScheduledExecutor, eVar);
    }
}
