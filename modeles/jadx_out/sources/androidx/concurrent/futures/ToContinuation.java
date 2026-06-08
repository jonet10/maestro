package androidx.concurrent.futures;

import java.util.concurrent.ExecutionException;
import m1.b;
import o7.j;
import p6.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class ToContinuation<T> implements Runnable {
    private final j continuation;
    private final b futureToObserve;

    public ToContinuation(b bVar, j jVar) {
        bVar.getClass();
        jVar.getClass();
        this.futureToObserve = bVar;
        this.continuation = jVar;
    }

    public final j getContinuation() {
        return this.continuation;
    }

    public final b getFutureToObserve() {
        return this.futureToObserve;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable nonNullCause;
        boolean isCancelled = this.futureToObserve.isCancelled();
        j jVar = this.continuation;
        if (isCancelled) {
            jVar.o(null);
            return;
        }
        try {
            jVar.resumeWith(AbstractResolvableFuture.getUninterruptibly(this.futureToObserve));
        } catch (ExecutionException e10) {
            j jVar2 = this.continuation;
            nonNullCause = ListenableFutureKt.nonNullCause(e10);
            jVar2.resumeWith(a.b(nonNullCause));
        }
    }
}
