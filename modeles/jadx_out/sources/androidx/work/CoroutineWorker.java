package androidx.work;

import android.content.Context;
import kotlin.jvm.internal.l;
import o7.c0;
import o7.m0;
import o7.w;
import p6.x;
import t6.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {
    private final w coroutineContext;
    private final WorkerParameters params;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class DeprecatedDispatcher extends w {
        public static final DeprecatedDispatcher INSTANCE = new DeprecatedDispatcher();
        private static final w dispatcher = m0.f8288a;

        private DeprecatedDispatcher() {
        }

        @Override // o7.w
        public void dispatch(h hVar, Runnable runnable) {
            hVar.getClass();
            runnable.getClass();
            dispatcher.dispatch(hVar, runnable);
        }

        public final w getDispatcher() {
            return dispatcher;
        }

        @Override // o7.w
        public boolean isDispatchNeeded(h hVar) {
            hVar.getClass();
            return dispatcher.isDispatchNeeded(hVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.params = workerParameters;
        this.coroutineContext = DeprecatedDispatcher.INSTANCE;
    }

    public static /* synthetic */ Object getForegroundInfo$suspendImpl(CoroutineWorker coroutineWorker, t6.c cVar) {
        throw new IllegalStateException("Not implemented");
    }

    public abstract Object doWork(t6.c cVar);

    public w getCoroutineContext() {
        return this.coroutineContext;
    }

    public Object getForegroundInfo(t6.c cVar) {
        return getForegroundInfo$suspendImpl(this, cVar);
    }

    @Override // androidx.work.ListenableWorker
    public final m1.b getForegroundInfoAsync() {
        return ListenableFutureKt.launchFuture$default(getCoroutineContext().plus(c0.c()), null, new CoroutineWorker$getForegroundInfoAsync$1(this, null), 2, null);
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
    }

    public final Object setForeground(ForegroundInfo foregroundInfo, t6.c cVar) {
        m1.b foregroundAsync = setForegroundAsync(foregroundInfo);
        foregroundAsync.getClass();
        Object await = androidx.concurrent.futures.ListenableFutureKt.await(foregroundAsync, cVar);
        return await == u6.a.f10762a ? await : x.f8463a;
    }

    public final Object setProgress(Data data, t6.c cVar) {
        m1.b progressAsync = setProgressAsync(data);
        progressAsync.getClass();
        Object await = androidx.concurrent.futures.ListenableFutureKt.await(progressAsync, cVar);
        return await == u6.a.f10762a ? await : x.f8463a;
    }

    @Override // androidx.work.ListenableWorker
    public final m1.b startWork() {
        h coroutineContext = !l.a(getCoroutineContext(), DeprecatedDispatcher.INSTANCE) ? getCoroutineContext() : this.params.getWorkerContext();
        coroutineContext.getClass();
        return ListenableFutureKt.launchFuture$default(coroutineContext.plus(c0.c()), null, new CoroutineWorker$startWork$1(this, null), 2, null);
    }

    public static /* synthetic */ void getCoroutineContext$annotations() {
    }
}
