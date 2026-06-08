package e1;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v3 implements ServiceConnection, k0.b, k0.c {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f4328a;

    /* renamed from: b, reason: collision with root package name */
    public volatile r0 f4329b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ w3 f4330l;

    public v3(w3 w3Var) {
        this.f4330l = w3Var;
    }

    @Override // k0.c
    public final void a(h0.b bVar) {
        w3 w3Var = this.f4330l;
        q1 q1Var = w3Var.f3875a.f4265p;
        t1.m(q1Var);
        q1Var.l();
        w0 w0Var = w3Var.f3875a.f4264o;
        if (w0Var == null || !w0Var.f3903b) {
            w0Var = null;
        }
        if (w0Var != null) {
            w0Var.f4346w.c(bVar, "Service connection failed");
        }
        synchronized (this) {
            this.f4328a = false;
            this.f4329b = null;
        }
        q1 q1Var2 = this.f4330l.f3875a.f4265p;
        t1.m(q1Var2);
        q1Var2.p(new m1.a(this, bVar, 14, false));
    }

    public final void b() {
        w3 w3Var = this.f4330l;
        w3Var.g();
        Context context = w3Var.f3875a.f4259a;
        synchronized (this) {
            try {
                try {
                    if (this.f4328a) {
                        w0 w0Var = this.f4330l.f3875a.f4264o;
                        t1.m(w0Var);
                        w0Var.f4346w.b("Connection attempt already in progress");
                    } else {
                        if (this.f4329b != null && (this.f4329b.d() || this.f4329b.g())) {
                            w0 w0Var2 = this.f4330l.f3875a.f4264o;
                            t1.m(w0Var2);
                            w0Var2.f4346w.b("Already awaiting connection attempt");
                            return;
                        }
                        this.f4329b = new r0(context, Looper.getMainLooper(), k0.k0.a(context), h0.f.f5409b, 93, this, this, null);
                        w0 w0Var3 = this.f4330l.f3875a.f4264o;
                        t1.m(w0Var3);
                        w0Var3.f4346w.b("Connecting to remote service");
                        this.f4328a = true;
                        k0.y.g(this.f4329b);
                        this.f4329b.m();
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // k0.b
    public final void c(int i) {
        t1 t1Var = this.f4330l.f3875a;
        q1 q1Var = t1Var.f4265p;
        t1.m(q1Var);
        q1Var.l();
        w0 w0Var = t1Var.f4264o;
        t1.m(w0Var);
        w0Var.v.b("Service connection suspended");
        q1 q1Var2 = t1Var.f4265p;
        t1.m(q1Var2);
        q1Var2.p(new a4.f(this, 5));
    }

    @Override // k0.b
    public final void d() {
        q1 q1Var = this.f4330l.f3875a.f4265p;
        t1.m(q1Var);
        q1Var.l();
        synchronized (this) {
            try {
                k0.y.g(this.f4329b);
                i0 i0Var = (i0) this.f4329b.t();
                q1 q1Var2 = this.f4330l.f3875a.f4265p;
                t1.m(q1Var2);
                q1Var2.p(new t3(this, i0Var, 1));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f4329b = null;
                this.f4328a = false;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        q1 q1Var = this.f4330l.f3875a.f4265p;
        t1.m(q1Var);
        q1Var.l();
        synchronized (this) {
            if (iBinder == null) {
                this.f4328a = false;
                w0 w0Var = this.f4330l.f3875a.f4264o;
                t1.m(w0Var);
                w0Var.f4339o.b("Service connected with null binder");
                return;
            }
            i0 i0Var = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    i0Var = queryLocalInterface instanceof i0 ? (i0) queryLocalInterface : new g0(iBinder);
                    w0 w0Var2 = this.f4330l.f3875a.f4264o;
                    t1.m(w0Var2);
                    w0Var2.f4346w.b("Bound to IMeasurementService interface");
                } else {
                    w0 w0Var3 = this.f4330l.f3875a.f4264o;
                    t1.m(w0Var3);
                    w0Var3.f4339o.c(interfaceDescriptor, "Got binder with a wrong descriptor");
                }
            } catch (RemoteException unused) {
                w0 w0Var4 = this.f4330l.f3875a.f4264o;
                t1.m(w0Var4);
                w0Var4.f4339o.b("Service connect failed to get IMeasurementService");
            }
            if (i0Var == null) {
                this.f4328a = false;
                try {
                    o0.a b7 = o0.a.b();
                    w3 w3Var = this.f4330l;
                    b7.c(w3Var.f3875a.f4259a, w3Var.f4358l);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                q1 q1Var2 = this.f4330l.f3875a.f4265p;
                t1.m(q1Var2);
                q1Var2.p(new t3(this, i0Var, 0));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        t1 t1Var = this.f4330l.f3875a;
        q1 q1Var = t1Var.f4265p;
        t1.m(q1Var);
        q1Var.l();
        w0 w0Var = t1Var.f4264o;
        t1.m(w0Var);
        w0Var.v.b("Service disconnected");
        q1 q1Var2 = t1Var.f4265p;
        t1.m(q1Var2);
        q1Var2.p(new m1.a(this, componentName, 13, false));
    }
}
