package e1;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4283a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0 f4284b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ v3 f4285l;

    public /* synthetic */ t3(v3 v3Var, i0 i0Var, int i) {
        this.f4283a = i;
        this.f4284b = i0Var;
        this.f4285l = v3Var;
    }

    private final void a() {
        v3 v3Var = this.f4285l;
        synchronized (v3Var) {
            try {
                v3Var.f4328a = false;
                w3 w3Var = v3Var.f4330l;
                if (!w3Var.x()) {
                    w0 w0Var = w3Var.f3875a.f4264o;
                    t1.m(w0Var);
                    w0Var.f4346w.b("Connected to service");
                    i0 i0Var = this.f4284b;
                    w3Var.g();
                    w3Var.f4359m = i0Var;
                    w3Var.t();
                    w3Var.v();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4283a) {
            case 0:
                a();
                return;
            default:
                v3 v3Var = this.f4285l;
                synchronized (v3Var) {
                    try {
                        v3Var.f4328a = false;
                        w3 w3Var = v3Var.f4330l;
                        if (!w3Var.x()) {
                            w0 w0Var = w3Var.f3875a.f4264o;
                            t1.m(w0Var);
                            w0Var.v.b("Connected to remote service");
                            i0 i0Var = this.f4284b;
                            w3Var.g();
                            w3Var.f4359m = i0Var;
                            w3Var.t();
                            w3Var.v();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                w3 w3Var2 = this.f4285l.f4330l;
                ScheduledExecutorService scheduledExecutorService = w3Var2.f4362p;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                    w3Var2.f4362p = null;
                    return;
                }
                return;
        }
    }
}
