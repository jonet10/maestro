package g0;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5083a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f5084b;

    public /* synthetic */ i(k kVar, int i) {
        this.f5083a = i;
        this.f5084b = kVar;
    }

    private final void a() {
        k kVar = this.f5084b;
        synchronized (kVar) {
            if (kVar.f5086a == 1) {
                kVar.a("Timed out while binding");
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5083a) {
            case 0:
                break;
            case 1:
                a();
                return;
            default:
                this.f5084b.a("Service disconnected");
                return;
        }
        while (true) {
            k kVar = this.f5084b;
            synchronized (kVar) {
                try {
                    if (kVar.f5086a != 2) {
                        return;
                    }
                    if (kVar.f5089m.isEmpty()) {
                        kVar.c();
                        return;
                    }
                    l lVar = (l) kVar.f5089m.poll();
                    kVar.f5090n.put(lVar.f5092a, lVar);
                    kVar.f5091o.f5099b.schedule(new m1.a(19, kVar, lVar), 30L, TimeUnit.SECONDS);
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        Log.d("MessengerIpcClient", "Sending ".concat(String.valueOf(lVar)));
                    }
                    n nVar = kVar.f5091o;
                    Messenger messenger = kVar.f5087b;
                    int i = lVar.f5094c;
                    Context context = nVar.f5098a;
                    Message obtain = Message.obtain();
                    obtain.what = i;
                    obtain.arg1 = lVar.f5092a;
                    obtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", lVar.a());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", lVar.f5095d);
                    obtain.setData(bundle);
                    try {
                        android.support.v4.media.g gVar = kVar.f5088l;
                        Messenger messenger2 = (Messenger) gVar.f247b;
                        if (messenger2 != null) {
                            messenger2.send(obtain);
                        } else {
                            g gVar2 = (g) gVar.f248l;
                            if (gVar2 == null) {
                                throw new IllegalStateException("Both messengers are null");
                            }
                            Messenger messenger3 = gVar2.f5079a;
                            messenger3.getClass();
                            messenger3.send(obtain);
                        }
                    } catch (RemoteException e10) {
                        kVar.a(e10.getMessage());
                    }
                } finally {
                }
            }
        }
    }
}
