package androidx.work.impl;

import java.util.concurrent.ExecutionException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class ToContinuation<T> implements Runnable {
    private final o7.j continuation;
    private final m1.b futureToObserve;

    public ToContinuation(m1.b bVar, o7.j jVar) {
        bVar.getClass();
        jVar.getClass();
        this.futureToObserve = bVar;
        this.continuation = jVar;
    }

    public final o7.j getContinuation() {
        return this.continuation;
    }

    public final m1.b getFutureToObserve() {
        return this.futureToObserve;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable nonNullCause;
        Object uninterruptibly;
        boolean isCancelled = this.futureToObserve.isCancelled();
        o7.j jVar = this.continuation;
        if (isCancelled) {
            jVar.o(null);
            return;
        }
        try {
            uninterruptibly = WorkerWrapperKt.getUninterruptibly(this.futureToObserve);
            jVar.resumeWith(uninterruptibly);
        } catch (ExecutionException e10) {
            o7.j jVar2 = this.continuation;
            nonNullCause = WorkerWrapperKt.nonNullCause(e10);
            jVar2.resumeWith(p6.a.b(nonNullCause));
        }
    }
}
