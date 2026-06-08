package g0;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import j1.p;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {
    public static int h;
    public static PendingIntent i;
    public static final Pattern j = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");

    /* renamed from: b, reason: collision with root package name */
    public final Context f5069b;

    /* renamed from: c, reason: collision with root package name */
    public final o f5070c;

    /* renamed from: d, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f5071d;
    public Messenger f;
    public g g;

    /* renamed from: a, reason: collision with root package name */
    public final SimpleArrayMap f5068a = new SimpleArrayMap();

    /* renamed from: e, reason: collision with root package name */
    public final Messenger f5072e = new Messenger(new e(this, Looper.getMainLooper()));

    public b(Context context) {
        this.f5069b = context;
        this.f5070c = new o(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f5071d = scheduledThreadPoolExecutor;
    }

    public static synchronized String b() {
        String num;
        synchronized (b.class) {
            int i6 = h;
            h = i6 + 1;
            num = Integer.toString(i6);
        }
        return num;
    }

    public static synchronized void c(Context context, Intent intent) {
        synchronized (b.class) {
            try {
                if (i == null) {
                    Intent intent2 = new Intent();
                    intent2.setPackage("com.google.example.invalidpackage");
                    i = PendingIntent.getBroadcast(context, 0, intent2, y0.a.f11598a);
                }
                intent.putExtra("app", i);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final p a(Bundle bundle) {
        String b7 = b();
        j1.i iVar = new j1.i();
        synchronized (this.f5068a) {
            this.f5068a.put(b7, iVar);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.f5070c.b() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        c(this.f5069b, intent);
        intent.putExtra("kid", "|ID|" + b7 + "|");
        if (Log.isLoggable("Rpc", 3)) {
            Log.d("Rpc", "Sending ".concat(String.valueOf(intent.getExtras())));
        }
        intent.putExtra("google.messenger", this.f5072e);
        if (this.f != null || this.g != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                Messenger messenger = this.f;
                if (messenger != null) {
                    messenger.send(obtain);
                } else {
                    Messenger messenger2 = this.g.f5079a;
                    messenger2.getClass();
                    messenger2.send(obtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
            }
            iVar.f6539a.a(h.f5081l, new b5.m(this, b7, this.f5071d.schedule(new a4.f(iVar, 13), 30L, TimeUnit.SECONDS), 13));
            return iVar.f6539a;
        }
        int b10 = this.f5070c.b();
        Context context = this.f5069b;
        if (b10 == 2) {
            context.sendBroadcast(intent);
        } else {
            context.startService(intent);
        }
        iVar.f6539a.a(h.f5081l, new b5.m(this, b7, this.f5071d.schedule(new a4.f(iVar, 13), 30L, TimeUnit.SECONDS), 13));
        return iVar.f6539a;
    }

    public final void d(Bundle bundle, String str) {
        synchronized (this.f5068a) {
            try {
                j1.i iVar = (j1.i) this.f5068a.remove(str);
                if (iVar != null) {
                    iVar.a(bundle);
                    return;
                }
                Log.w("Rpc", "Missing callback for " + str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
