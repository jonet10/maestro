package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.impl.model.WorkSpec;
import d7.p;
import o7.a0;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.work.impl.utils.WorkForegroundKt$workForeground$2", f = "WorkForeground.kt", l = {42, 50}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkForegroundKt$workForeground$2 extends i implements p {
    final /* synthetic */ Context $context;
    final /* synthetic */ ForegroundUpdater $foregroundUpdater;
    final /* synthetic */ WorkSpec $spec;
    final /* synthetic */ ListenableWorker $worker;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkForegroundKt$workForeground$2(ListenableWorker listenableWorker, WorkSpec workSpec, ForegroundUpdater foregroundUpdater, Context context, t6.c cVar) {
        super(2, cVar);
        this.$worker = listenableWorker;
        this.$spec = workSpec;
        this.$foregroundUpdater = foregroundUpdater;
        this.$context = context;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new WorkForegroundKt$workForeground$2(this.$worker, this.$spec, this.$foregroundUpdater, this.$context, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((WorkForegroundKt$workForeground$2) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        if (r8 == r3) goto L19;
     */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            int r0 = r7.label
            r1 = 2
            r2 = 1
            u6.a r3 = u6.a.f10762a
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            if (r0 != r1) goto L10
            p6.a.e(r8)
            return r8
        L10:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r8)
        L15:
            r8 = 0
            return r8
        L17:
            p6.a.e(r8)
            goto L32
        L1b:
            p6.a.e(r8)
            androidx.work.ListenableWorker r8 = r7.$worker
            m1.b r8 = r8.getForegroundInfoAsync()
            r8.getClass()
            androidx.work.ListenableWorker r0 = r7.$worker
            r7.label = r2
            java.lang.Object r8 = androidx.work.impl.WorkerWrapperKt.awaitWithin(r8, r0, r7)
            if (r8 != r3) goto L32
            goto L6c
        L32:
            androidx.work.ForegroundInfo r8 = (androidx.work.ForegroundInfo) r8
            if (r8 == 0) goto L6e
            java.lang.String r0 = androidx.work.impl.utils.WorkForegroundKt.access$getTAG$p()
            androidx.work.impl.model.WorkSpec r2 = r7.$spec
            androidx.work.Logger r4 = androidx.work.Logger.get()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Updating notification for "
            r5.<init>(r6)
            java.lang.String r2 = r2.workerClassName
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r4.debug(r0, r2)
            androidx.work.ForegroundUpdater r0 = r7.$foregroundUpdater
            android.content.Context r2 = r7.$context
            androidx.work.ListenableWorker r4 = r7.$worker
            java.util.UUID r4 = r4.getId()
            m1.b r8 = r0.setForegroundAsync(r2, r4, r8)
            r8.getClass()
            r7.label = r1
            java.lang.Object r8 = androidx.concurrent.futures.ListenableFutureKt.await(r8, r7)
            if (r8 != r3) goto L6d
        L6c:
            return r3
        L6d:
            return r8
        L6e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "Worker was marked important ("
            r8.<init>(r0)
            androidx.work.impl.model.WorkSpec r0 = r7.$spec
            java.lang.String r0 = r0.workerClassName
            java.lang.String r1 = ") but did not provide ForegroundInfo"
            java.lang.String r8 = a4.x.n(r8, r0, r1)
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r8)
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.WorkForegroundKt$workForeground$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
