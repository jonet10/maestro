package f2;

import a4.d0;
import android.os.SystemClock;
import android.util.Log;
import g2.d;
import j1.i;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import m8.q;
import o.g;
import y1.z;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final double f4826a;

    /* renamed from: b, reason: collision with root package name */
    public final double f4827b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4828c;

    /* renamed from: d, reason: collision with root package name */
    public final long f4829d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4830e;
    public final ArrayBlockingQueue f;
    public final ThreadPoolExecutor g;
    public final d0 h;
    public final q i;
    public int j;

    /* renamed from: k, reason: collision with root package name */
    public long f4831k;

    public c(d0 d0Var, d dVar, q qVar) {
        double d10 = dVar.f5115d;
        double d11 = dVar.f5116e;
        this.f4826a = d10;
        this.f4827b = d11;
        this.f4828c = dVar.f * 1000;
        this.h = d0Var;
        this.i = qVar;
        this.f4829d = SystemClock.elapsedRealtime();
        int i = (int) d10;
        this.f4830e = i;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i);
        this.f = arrayBlockingQueue;
        this.g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.j = 0;
        this.f4831k = 0L;
    }

    public final int a() {
        if (this.f4831k == 0) {
            this.f4831k = System.currentTimeMillis();
        }
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.f4831k) / this.f4828c);
        int size = this.f.size();
        int i = this.j;
        int min = size == this.f4830e ? Math.min(100, i + currentTimeMillis) : Math.max(0, i - currentTimeMillis);
        if (this.j != min) {
            this.j = min;
            this.f4831k = System.currentTimeMillis();
        }
        return min;
    }

    public final void b(final y1.b bVar, final i iVar) {
        String str = "Sending report through Google DataTransport: " + bVar.f11605b;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
        final boolean z9 = SystemClock.elapsedRealtime() - this.f4829d < 2000;
        this.h.o(new o.a(bVar.f11604a, o.d.f8128l, null), new g() { // from class: f2.b
            @Override // o.g
            public final void a(Exception exc) {
                i iVar2 = iVar;
                if (exc != null) {
                    iVar2.b(exc);
                    return;
                }
                if (z9) {
                    boolean z10 = true;
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    new Thread(new androidx.browser.trusted.c(12, c.this, countDownLatch)).start();
                    ExecutorService executorService = z.f11698a;
                    boolean z11 = false;
                    try {
                        long j = 2000000000;
                        long nanoTime = System.nanoTime() + 2000000000;
                        while (true) {
                            try {
                                try {
                                    countDownLatch.await(j, TimeUnit.NANOSECONDS);
                                    break;
                                } catch (InterruptedException unused) {
                                    j = nanoTime - System.nanoTime();
                                    z11 = true;
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (z10) {
                                    Thread.currentThread().interrupt();
                                }
                                throw th;
                            }
                        }
                        if (z11) {
                            Thread.currentThread().interrupt();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z10 = z11;
                    }
                }
                iVar2.c(bVar);
            }
        });
    }
}
