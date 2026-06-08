package j0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessaging;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6520a = 1;

    /* renamed from: b, reason: collision with root package name */
    public Object f6521b;

    /* renamed from: c, reason: collision with root package name */
    public Object f6522c;

    public p(y3.a aVar, y3.a aVar2) {
        this.f6521b = aVar;
        this.f6522c = aVar2;
    }

    public void a() {
        if (Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3))) {
            Log.d("FirebaseMessaging", "Connectivity change received registered");
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        y2.t tVar = (y2.t) this.f6522c;
        if (tVar != null) {
            Context context = tVar.f11761l.f3086b;
            this.f6521b = context;
            context.registerReceiver(this, intentFilter);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo;
        NetworkCapabilities networkCapabilities;
        switch (this.f6520a) {
            case 0:
                Uri data = intent.getData();
                if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
                    Object obj = ((android.support.v4.media.g) this.f6522c).f248l;
                    throw null;
                }
                return;
            case 1:
                y2.t tVar = (y2.t) this.f6522c;
                if (tVar != null && tVar.a()) {
                    if (Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3))) {
                        Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                    }
                    y2.t tVar2 = (y2.t) this.f6522c;
                    tVar2.f11761l.getClass();
                    FirebaseMessaging.b(tVar2, 0L);
                    Context context2 = (Context) this.f6521b;
                    if (context2 != null) {
                        context2.unregisterReceiver(this);
                    }
                    this.f6522c = null;
                    return;
                }
                return;
            default:
                context.getClass();
                intent.getClass();
                Object systemService = context.getSystemService("connectivity");
                systemService.getClass();
                ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                if (Build.VERSION.SDK_INT < 24 ? (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected() : (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null || !(networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3))) {
                    ((y3.a) this.f6522c).invoke();
                    return;
                } else {
                    ((y3.a) this.f6521b).invoke();
                    return;
                }
        }
    }

    public p(android.support.v4.media.g gVar) {
        this.f6522c = gVar;
    }

    public /* synthetic */ p() {
    }
}
