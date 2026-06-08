package k0;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.work.PeriodicWorkRequest;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k0 {
    public static final Object g = new Object();
    public static k0 h;
    public static HandlerThread i;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f6900a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Context f6901b;

    /* renamed from: c, reason: collision with root package name */
    public volatile a4.c0 f6902c;

    /* renamed from: d, reason: collision with root package name */
    public final o0.a f6903d;

    /* renamed from: e, reason: collision with root package name */
    public final long f6904e;
    public final long f;

    public k0(Context context, Looper looper) {
        j0 j0Var = new j0(this);
        this.f6901b = context.getApplicationContext();
        a4.c0 c0Var = new a4.c0(looper, j0Var, 6);
        Looper.getMainLooper();
        this.f6902c = c0Var;
        this.f6903d = o0.a.b();
        this.f6904e = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        this.f = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    }

    public static k0 a(Context context) {
        synchronized (g) {
            try {
                if (h == null) {
                    h = new k0(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return h;
    }

    public static HandlerThread b() {
        synchronized (g) {
            try {
                HandlerThread handlerThread = i;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                i = handlerThread2;
                handlerThread2.start();
                return i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final h0.b c(h0 h0Var, d0 d0Var, String str, Executor executor) {
        h0.b bVar;
        HashMap hashMap = this.f6900a;
        synchronized (hashMap) {
            try {
                i0 i0Var = (i0) hashMap.get(h0Var);
                if (executor == null) {
                    executor = null;
                }
                if (i0Var == null) {
                    i0Var = new i0(this, h0Var);
                    i0Var.f6883a.put(d0Var, d0Var);
                    bVar = i0Var.a(str, executor);
                    hashMap.put(h0Var, i0Var);
                } else {
                    this.f6902c.removeMessages(0, h0Var);
                    if (i0Var.f6883a.containsKey(d0Var)) {
                        String h0Var2 = h0Var.toString();
                        StringBuilder sb = new StringBuilder(h0Var2.length() + 81);
                        sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                        sb.append(h0Var2);
                        throw new IllegalStateException(sb.toString());
                    }
                    i0Var.f6883a.put(d0Var, d0Var);
                    int i6 = i0Var.f6884b;
                    if (i6 == 1) {
                        d0Var.onServiceConnected(i0Var.f6888o, i0Var.f6886m);
                    } else if (i6 == 2) {
                        bVar = i0Var.a(str, executor);
                    }
                    bVar = null;
                }
                if (i0Var.f6885l) {
                    return h0.b.f5393o;
                }
                if (bVar == null) {
                    bVar = new h0.b(null, null, -1);
                }
                return bVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(String str, ServiceConnection serviceConnection, boolean z9) {
        h0 h0Var = new h0(str, z9);
        y.h(serviceConnection, "ServiceConnection must not be null");
        HashMap hashMap = this.f6900a;
        synchronized (hashMap) {
            try {
                i0 i0Var = (i0) hashMap.get(h0Var);
                if (i0Var == null) {
                    String h0Var2 = h0Var.toString();
                    StringBuilder sb = new StringBuilder(h0Var2.length() + 50);
                    sb.append("Nonexistent connection status for service config: ");
                    sb.append(h0Var2);
                    throw new IllegalStateException(sb.toString());
                }
                if (!i0Var.f6883a.containsKey(serviceConnection)) {
                    String h0Var3 = h0Var.toString();
                    StringBuilder sb2 = new StringBuilder(h0Var3.length() + 76);
                    sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                    sb2.append(h0Var3);
                    throw new IllegalStateException(sb2.toString());
                }
                i0Var.f6883a.remove(serviceConnection);
                if (i0Var.f6883a.isEmpty()) {
                    this.f6902c.sendMessageDelayed(this.f6902c.obtainMessage(0, h0Var), this.f6904e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
