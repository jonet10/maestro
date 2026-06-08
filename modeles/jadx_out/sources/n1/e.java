package n1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends BroadcastReceiver {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference f7904b = new AtomicReference();

    /* renamed from: a, reason: collision with root package name */
    public final Context f7905a;

    public e(Context context) {
        this.f7905a = context;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        synchronized (f.f7906k) {
            try {
                Iterator it = f.f7907l.values().iterator();
                while (it.hasNext()) {
                    ((f) it.next()).e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f7905a.unregisterReceiver(this);
    }
}
