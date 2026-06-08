package androidx.work.impl;

import androidx.work.Logger;
import androidx.work.impl.WorkerWrapper;
import d7.p;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import o7.a0;
import o7.c0;
import o7.s;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.work.impl.WorkerWrapper$launch$1", f = "WorkerWrapper.kt", l = {98}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkerWrapper$launch$1 extends v6.i implements p {
    int label;
    final /* synthetic */ WorkerWrapper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerWrapper$launch$1(WorkerWrapper workerWrapper, t6.c cVar) {
        super(2, cVar);
        this.this$0 = workerWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean invokeSuspend$lambda$1(WorkerWrapper.Resolution resolution, WorkerWrapper workerWrapper) {
        boolean resetWorkerStatus;
        if (resolution instanceof WorkerWrapper.Resolution.Finished) {
            resetWorkerStatus = workerWrapper.onWorkFinished(((WorkerWrapper.Resolution.Finished) resolution).getResult());
        } else if (resolution instanceof WorkerWrapper.Resolution.Failed) {
            workerWrapper.setFailed(((WorkerWrapper.Resolution.Failed) resolution).getResult());
            resetWorkerStatus = false;
        } else {
            if (!(resolution instanceof WorkerWrapper.Resolution.ResetWorkerStatus)) {
                com.google.gson.internal.a.b();
                return null;
            }
            resetWorkerStatus = workerWrapper.resetWorkerStatus(((WorkerWrapper.Resolution.ResetWorkerStatus) resolution).getReason());
        }
        return Boolean.valueOf(resetWorkerStatus);
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new WorkerWrapper$launch$1(this.this$0, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((WorkerWrapper$launch$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        String str;
        final WorkerWrapper.Resolution failed;
        WorkDatabase workDatabase;
        s sVar;
        int i = this.label;
        try {
            if (i == 0) {
                p6.a.e(obj);
                sVar = this.this$0.workerJob;
                WorkerWrapper$launch$1$resolution$1 workerWrapper$launch$1$resolution$1 = new WorkerWrapper$launch$1$resolution$1(this.this$0, null);
                this.label = 1;
                obj = c0.C(workerWrapper$launch$1$resolution$1, sVar, this);
                u6.a aVar = u6.a.f10762a;
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
            }
            failed = (WorkerWrapper.Resolution) obj;
        } catch (WorkerStoppedException e10) {
            failed = new WorkerWrapper.Resolution.ResetWorkerStatus(e10.getReason());
        } catch (CancellationException unused) {
            failed = new WorkerWrapper.Resolution.Failed(null, 1, null);
        } catch (Throwable th) {
            str = WorkerWrapperKt.TAG;
            Logger.get().error(str, "Unexpected error in WorkerWrapper", th);
            failed = new WorkerWrapper.Resolution.Failed(null, 1, null);
        }
        workDatabase = this.this$0.workDatabase;
        final WorkerWrapper workerWrapper = this.this$0;
        Object runInTransaction = workDatabase.runInTransaction((Callable<Object>) new Callable() { // from class: androidx.work.impl.m
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean invokeSuspend$lambda$1;
                invokeSuspend$lambda$1 = WorkerWrapper$launch$1.invokeSuspend$lambda$1(WorkerWrapper.Resolution.this, workerWrapper);
                return invokeSuspend$lambda$1;
            }
        });
        runInTransaction.getClass();
        return runInTransaction;
    }
}
