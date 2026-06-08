package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> m1.b future(Executor executor, d7.a aVar) {
        m1.b future = CallbackToFutureAdapter.getFuture(new a3.e(2, executor, aVar));
        future.getClass();
        return future;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x future$lambda$2(Executor executor, d7.a aVar, CallbackToFutureAdapter.Completer completer) {
        completer.getClass();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        completer.addCancellationListener(new a(atomicBoolean, 1), DirectExecutor.INSTANCE);
        executor.execute(new b(atomicBoolean, completer, aVar, 1));
        return x.f8463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void future$lambda$2$lambda$1(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, d7.a aVar) {
        if (atomicBoolean.get()) {
            return;
        }
        try {
            completer.set(aVar.invoke());
        } catch (Throwable th) {
            completer.setException(th);
        }
    }
}
