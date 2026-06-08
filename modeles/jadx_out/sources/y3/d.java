package y3;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import j0.p;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11797a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f11798b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public p f11799c;

    /* renamed from: d, reason: collision with root package name */
    public c f11800d;

    public d(Context context) {
        this.f11797a = context;
    }

    public final void a() {
        int i = Build.VERSION.SDK_INT;
        Context context = this.f11797a;
        if (i < 24) {
            p pVar = new p(new a(this, 0), new a(this, 1));
            this.f11799c = pVar;
            context.registerReceiver(pVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } else {
            c cVar = new c(this);
            this.f11800d = cVar;
            Object systemService = context.getSystemService("connectivity");
            systemService.getClass();
            ((ConnectivityManager) systemService).registerDefaultNetworkCallback(cVar);
        }
    }
}
