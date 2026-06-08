package e1;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q1 extends e2 {

    /* renamed from: t, reason: collision with root package name */
    public static final AtomicLong f4202t = new AtomicLong(Long.MIN_VALUE);

    /* renamed from: l, reason: collision with root package name */
    public p1 f4203l;

    /* renamed from: m, reason: collision with root package name */
    public p1 f4204m;

    /* renamed from: n, reason: collision with root package name */
    public final PriorityBlockingQueue f4205n;

    /* renamed from: o, reason: collision with root package name */
    public final LinkedBlockingQueue f4206o;

    /* renamed from: p, reason: collision with root package name */
    public final n1 f4207p;

    /* renamed from: q, reason: collision with root package name */
    public final n1 f4208q;

    /* renamed from: r, reason: collision with root package name */
    public final Object f4209r;

    /* renamed from: s, reason: collision with root package name */
    public final Semaphore f4210s;

    public q1(t1 t1Var) {
        super(t1Var);
        this.f4209r = new Object();
        this.f4210s = new Semaphore(2);
        this.f4205n = new PriorityBlockingQueue();
        this.f4206o = new LinkedBlockingQueue();
        this.f4207p = new n1(this, "Thread death: Uncaught exception on worker thread");
        this.f4208q = new n1(this, "Thread death: Uncaught exception on network thread");
    }

    @Override // e1.d2
    public final void g() {
        if (Thread.currentThread() == this.f4203l) {
            return;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Call expected from worker thread");
    }

    @Override // e1.e2
    public final boolean h() {
        return false;
    }

    public final void k() {
        if (Thread.currentThread() == this.f4204m) {
            return;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Call expected from network thread");
    }

    public final void l() {
        if (Thread.currentThread() != this.f4203l) {
            return;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Call not expected from worker thread");
    }

    public final boolean m() {
        return Thread.currentThread() == this.f4203l;
    }

    public final o1 n(Callable callable) {
        i();
        o1 o1Var = new o1(this, callable, false);
        if (Thread.currentThread() != this.f4203l) {
            t(o1Var);
            return o1Var;
        }
        if (!this.f4205n.isEmpty()) {
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4342r.b("Callable skipped the worker queue.");
        }
        o1Var.run();
        return o1Var;
    }

    public final o1 o(Callable callable) {
        i();
        o1 o1Var = new o1(this, callable, true);
        if (Thread.currentThread() == this.f4203l) {
            o1Var.run();
            return o1Var;
        }
        t(o1Var);
        return o1Var;
    }

    public final void p(Runnable runnable) {
        i();
        k0.y.g(runnable);
        t(new o1(this, runnable, false, "Task exception on worker thread"));
    }

    public final Object q(AtomicReference atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            q1 q1Var = this.f3875a.f4265p;
            t1.m(q1Var);
            q1Var.p(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                w0 w0Var = this.f3875a.f4264o;
                t1.m(w0Var);
                u0 u0Var = w0Var.f4342r;
                StringBuilder sb = new StringBuilder(str.length() + 24);
                sb.append("Interrupted waiting for ");
                sb.append(str);
                u0Var.b(sb.toString());
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            w0 w0Var2 = this.f3875a.f4264o;
            t1.m(w0Var2);
            w0Var2.f4342r.b("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    public final void r(Runnable runnable) {
        i();
        t(new o1(this, runnable, true, "Task exception on worker thread"));
    }

    public final void s(Runnable runnable) {
        i();
        o1 o1Var = new o1(this, runnable, false, "Task exception on network thread");
        synchronized (this.f4209r) {
            try {
                LinkedBlockingQueue linkedBlockingQueue = this.f4206o;
                linkedBlockingQueue.add(o1Var);
                p1 p1Var = this.f4204m;
                if (p1Var == null) {
                    p1 p1Var2 = new p1(this, "Measurement Network", linkedBlockingQueue);
                    this.f4204m = p1Var2;
                    p1Var2.setUncaughtExceptionHandler(this.f4208q);
                    this.f4204m.start();
                } else {
                    p1Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void t(o1 o1Var) {
        synchronized (this.f4209r) {
            try {
                PriorityBlockingQueue priorityBlockingQueue = this.f4205n;
                priorityBlockingQueue.add(o1Var);
                p1 p1Var = this.f4203l;
                if (p1Var == null) {
                    p1 p1Var2 = new p1(this, "Measurement Worker", priorityBlockingQueue);
                    this.f4203l = p1Var2;
                    p1Var2.setUncaughtExceptionHandler(this.f4207p);
                    this.f4203l.start();
                } else {
                    p1Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
