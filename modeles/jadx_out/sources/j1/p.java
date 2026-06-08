package j1;

import com.google.android.gms.internal.measurement.i4;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6560a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final i4 f6561b = new i4(2);

    /* renamed from: c, reason: collision with root package name */
    public boolean f6562c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f6563d;

    /* renamed from: e, reason: collision with root package name */
    public Object f6564e;
    public Exception f;

    public final void a(Executor executor, d dVar) {
        this.f6561b.e(new m(executor, dVar));
        p();
    }

    public final void b(Executor executor, e eVar) {
        this.f6561b.e(new m(executor, eVar));
        p();
    }

    public final void c(Executor executor, f fVar) {
        this.f6561b.e(new m(executor, fVar));
        p();
    }

    public final p d(Executor executor, a aVar) {
        p pVar = new p();
        this.f6561b.e(new l(executor, aVar, pVar, 0));
        p();
        return pVar;
    }

    public final p e(Executor executor, a aVar) {
        p pVar = new p();
        this.f6561b.e(new l(executor, aVar, pVar, 1));
        p();
        return pVar;
    }

    public final Exception f() {
        Exception exc;
        synchronized (this.f6560a) {
            exc = this.f;
        }
        return exc;
    }

    public final Object g() {
        Object obj;
        synchronized (this.f6560a) {
            try {
                y.i(this.f6562c, "Task is not yet complete");
                if (this.f6563d) {
                    throw new CancellationException("Task is already canceled.");
                }
                Exception exc = this.f;
                if (exc != null) {
                    throw new g(exc);
                }
                obj = this.f6564e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public final boolean h() {
        boolean z9;
        synchronized (this.f6560a) {
            z9 = this.f6562c;
        }
        return z9;
    }

    public final boolean i() {
        boolean z9;
        synchronized (this.f6560a) {
            try {
                z9 = false;
                if (this.f6562c && !this.f6563d && this.f == null) {
                    z9 = true;
                }
            } finally {
            }
        }
        return z9;
    }

    public final p j(Executor executor, h hVar) {
        p pVar = new p();
        this.f6561b.e(new m(executor, hVar, pVar));
        p();
        return pVar;
    }

    public final void k(Object obj) {
        synchronized (this.f6560a) {
            o();
            this.f6562c = true;
            this.f6564e = obj;
        }
        this.f6561b.g(this);
    }

    public final boolean l(Object obj) {
        synchronized (this.f6560a) {
            try {
                if (this.f6562c) {
                    return false;
                }
                this.f6562c = true;
                this.f6564e = obj;
                this.f6561b.g(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m(Exception exc) {
        y.h(exc, "Exception must not be null");
        synchronized (this.f6560a) {
            o();
            this.f6562c = true;
            this.f = exc;
        }
        this.f6561b.g(this);
    }

    public final void n() {
        synchronized (this.f6560a) {
            try {
                if (this.f6562c) {
                    return;
                }
                this.f6562c = true;
                this.f6563d = true;
                this.f6561b.g(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o() {
        if (this.f6562c) {
            if (!h()) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            Exception f = f();
        }
    }

    public final void p() {
        synchronized (this.f6560a) {
            try {
                if (this.f6562c) {
                    this.f6561b.g(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
