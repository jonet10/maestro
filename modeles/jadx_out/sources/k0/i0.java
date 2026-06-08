package k0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f6883a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public int f6884b = 2;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6885l;

    /* renamed from: m, reason: collision with root package name */
    public IBinder f6886m;

    /* renamed from: n, reason: collision with root package name */
    public final h0 f6887n;

    /* renamed from: o, reason: collision with root package name */
    public ComponentName f6888o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ k0 f6889p;

    public i0(k0 k0Var, h0 h0Var) {
        this.f6889p = k0Var;
        this.f6887n = h0Var;
    }

    public final h0.b a(String str, Executor executor) {
        try {
            Intent a8 = a0.a(this.f6889p.f6901b, this.f6887n);
            this.f6884b = 3;
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            if (Build.VERSION.SDK_INT >= 31) {
                StrictMode.setVmPolicy(p0.f.a(new StrictMode.VmPolicy.Builder(vmPolicy)).build());
            }
            try {
                k0 k0Var = this.f6889p;
                o0.a aVar = k0Var.f6903d;
                Context context = k0Var.f6901b;
                h0 h0Var = this.f6887n;
                try {
                    boolean d10 = aVar.d(context, str, a8, this, 4225, executor);
                    this.f6885l = d10;
                    if (d10) {
                        k0Var.f6902c.sendMessageDelayed(k0Var.f6902c.obtainMessage(1, h0Var), k0Var.f);
                        h0.b bVar = h0.b.f5393o;
                        StrictMode.setVmPolicy(vmPolicy);
                        return bVar;
                    }
                    this.f6884b = 2;
                    try {
                        k0Var.f6903d.c(k0Var.f6901b, this);
                    } catch (IllegalArgumentException unused) {
                    }
                    h0.b bVar2 = new h0.b(null, null, 16);
                    StrictMode.setVmPolicy(vmPolicy);
                    return bVar2;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    StrictMode.setVmPolicy(vmPolicy);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (z e10) {
            return e10.f6939a;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        k0 k0Var = this.f6889p;
        synchronized (k0Var.f6900a) {
            try {
                k0Var.f6902c.removeMessages(1, this.f6887n);
                this.f6886m = iBinder;
                this.f6888o = componentName;
                Iterator it = this.f6883a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f6884b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        k0 k0Var = this.f6889p;
        synchronized (k0Var.f6900a) {
            try {
                k0Var.f6902c.removeMessages(1, this.f6887n);
                this.f6886m = null;
                this.f6888o = componentName;
                Iterator it = this.f6883a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f6884b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
