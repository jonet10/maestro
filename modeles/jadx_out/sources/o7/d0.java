package o7;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d0 extends w0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: q, reason: collision with root package name */
    public static final d0 f8250q;

    /* renamed from: r, reason: collision with root package name */
    public static final long f8251r;

    static {
        Long l10;
        d0 d0Var = new d0();
        f8250q = d0Var;
        d0Var.A(false);
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f8251r = TimeUnit.MILLISECONDS.toNanos(l10.longValue());
    }

    @Override // o7.w0
    public final void D(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.D(runnable);
    }

    @Override // o7.w0
    public final Thread G() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setContextClassLoader(f8250q.getClass().getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // o7.w0
    public final void I(long j, u0 u0Var) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final synchronized void K() {
        int i = debugStatus;
        if (i == 2 || i == 3) {
            debugStatus = 3;
            w0.f8322n.set(this, null);
            w0.f8323o.set(this, null);
            notifyAll();
        }
    }

    @Override // o7.w0, o7.h0
    public final o0 e(long j, x1 x1Var, t6.h hVar) {
        long j6 = j > 0 ? j >= 9223372036854L ? LocationRequestCompat.PASSIVE_INTERVAL : 1000000 * j : 0L;
        if (j6 >= 4611686018427387903L) {
            return q1.f8300a;
        }
        long nanoTime = System.nanoTime();
        t0 t0Var = new t0(j6 + nanoTime, x1Var);
        J(nanoTime, t0Var);
        return t0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean H;
        v1.f8321a.set(this);
        try {
            synchronized (this) {
                int i = debugStatus;
                if (i == 2 || i == 3) {
                    if (H) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long B = B();
                    if (B == LocationRequestCompat.PASSIVE_INTERVAL) {
                        long nanoTime = System.nanoTime();
                        if (j == LocationRequestCompat.PASSIVE_INTERVAL) {
                            j = f8251r + nanoTime;
                        }
                        long j6 = j - nanoTime;
                        if (j6 <= 0) {
                            _thread = null;
                            K();
                            if (H()) {
                                return;
                            }
                            G();
                            return;
                        }
                        if (B > j6) {
                            B = j6;
                        }
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (B > 0) {
                        int i6 = debugStatus;
                        if (i6 == 2 || i6 == 3) {
                            _thread = null;
                            K();
                            if (H()) {
                                return;
                            }
                            G();
                            return;
                        }
                        LockSupport.parkNanos(this, B);
                    }
                }
            }
        } finally {
            _thread = null;
            K();
            if (!H()) {
                G();
            }
        }
    }

    @Override // o7.w0, o7.r0
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // o7.w
    public final String toString() {
        return "DefaultExecutor";
    }
}
