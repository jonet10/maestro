package y1;

import android.os.Looper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final ExecutorService f11698a;

    static {
        v vVar = new v(new AtomicLong(1L));
        ThreadPoolExecutor.DiscardPolicy discardPolicy = new ThreadPoolExecutor.DiscardPolicy();
        ExecutorService unconfigurableExecutorService = Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), vVar, discardPolicy));
        Runtime.getRuntime().addShutdownHook(new Thread(new u(unconfigurableExecutorService, 1), "Crashlytics Shutdown Hook for awaitEvenIfOnMainThread task continuation executor"));
        f11698a = unconfigurableExecutorService;
    }

    public static void a(j1.p pVar) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        pVar.d(f11698a, new v4.a(countDownLatch, 5));
        Looper mainLooper = Looper.getMainLooper();
        Looper myLooper = Looper.myLooper();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (mainLooper == myLooper) {
            countDownLatch.await(3000L, timeUnit);
        } else {
            countDownLatch.await(4000L, timeUnit);
        }
        if (pVar.i()) {
            pVar.g();
        } else {
            if (pVar.f6563d) {
                throw new CancellationException("Task is already canceled");
            }
            if (!pVar.h()) {
                throw new TimeoutException();
            }
            throw new IllegalStateException(pVar.f());
        }
    }
}
