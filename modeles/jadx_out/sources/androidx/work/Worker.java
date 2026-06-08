package androidx.work;

import android.content.Context;
import androidx.annotation.WorkerThread;
import androidx.work.ListenableWorker;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class Worker extends ListenableWorker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
    }

    @WorkerThread
    public abstract ListenableWorker.Result doWork();

    @WorkerThread
    public ForegroundInfo getForegroundInfo() {
        throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for `getForegroundInfo()`");
    }

    @Override // androidx.work.ListenableWorker
    public m1.b getForegroundInfoAsync() {
        m1.b future;
        Executor backgroundExecutor = getBackgroundExecutor();
        backgroundExecutor.getClass();
        future = WorkerKt.future(backgroundExecutor, new e(this, 1));
        return future;
    }

    @Override // androidx.work.ListenableWorker
    public final m1.b startWork() {
        m1.b future;
        Executor backgroundExecutor = getBackgroundExecutor();
        backgroundExecutor.getClass();
        future = WorkerKt.future(backgroundExecutor, new e(this, 0));
        return future;
    }
}
