package androidx.work.impl;

import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import com.google.android.material.card.MaterialCardViewHelper;
import d7.p;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.work.impl.WorkerWrapper$runWorker$result$1", f = "WorkerWrapper.kt", l = {MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION, 311}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkerWrapper$runWorker$result$1 extends v6.i implements p {
    final /* synthetic */ ForegroundUpdater $foregroundUpdater;
    final /* synthetic */ ListenableWorker $worker;
    int label;
    final /* synthetic */ WorkerWrapper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerWrapper$runWorker$result$1(WorkerWrapper workerWrapper, ListenableWorker listenableWorker, ForegroundUpdater foregroundUpdater, t6.c cVar) {
        super(2, cVar);
        this.this$0 = workerWrapper;
        this.$worker = listenableWorker;
        this.$foregroundUpdater = foregroundUpdater;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new WorkerWrapper$runWorker$result$1(this.this$0, this.$worker, this.$foregroundUpdater, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((WorkerWrapper$runWorker$result$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
    
        if (androidx.work.impl.utils.WorkForegroundKt.workForeground(r4, r5, r6, r7, r8, r9) == r3) goto L16;
     */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            int r0 = r10.label
            r1 = 2
            r2 = 1
            u6.a r3 = u6.a.f10762a
            if (r0 == 0) goto L1c
            if (r0 == r2) goto L17
            if (r0 != r1) goto L10
            p6.a.e(r11)
            return r11
        L10:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r11)
            r11 = 0
            return r11
        L17:
            p6.a.e(r11)
            r9 = r10
            goto L3f
        L1c:
            p6.a.e(r11)
            androidx.work.impl.WorkerWrapper r11 = r10.this$0
            android.content.Context r4 = androidx.work.impl.WorkerWrapper.access$getAppContext$p(r11)
            androidx.work.impl.WorkerWrapper r11 = r10.this$0
            androidx.work.impl.model.WorkSpec r5 = r11.getWorkSpec()
            androidx.work.ListenableWorker r6 = r10.$worker
            androidx.work.ForegroundUpdater r7 = r10.$foregroundUpdater
            androidx.work.impl.WorkerWrapper r11 = r10.this$0
            androidx.work.impl.utils.taskexecutor.TaskExecutor r8 = androidx.work.impl.WorkerWrapper.access$getWorkTaskExecutor$p(r11)
            r10.label = r2
            r9 = r10
            java.lang.Object r11 = androidx.work.impl.utils.WorkForegroundKt.workForeground(r4, r5, r6, r7, r8, r9)
            if (r11 != r3) goto L3f
            goto L73
        L3f:
            java.lang.String r11 = androidx.work.impl.WorkerWrapperKt.access$getTAG$p()
            androidx.work.impl.WorkerWrapper r0 = r9.this$0
            androidx.work.Logger r2 = androidx.work.Logger.get()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Starting work for "
            r4.<init>(r5)
            androidx.work.impl.model.WorkSpec r0 = r0.getWorkSpec()
            java.lang.String r0 = r0.workerClassName
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r2.debug(r11, r0)
            androidx.work.ListenableWorker r11 = r9.$worker
            m1.b r11 = r11.startWork()
            r11.getClass()
            androidx.work.ListenableWorker r0 = r9.$worker
            r9.label = r1
            java.lang.Object r11 = androidx.work.impl.WorkerWrapperKt.awaitWithin(r11, r0, r10)
            if (r11 != r3) goto L74
        L73:
            return r3
        L74:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkerWrapper$runWorker$result$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
