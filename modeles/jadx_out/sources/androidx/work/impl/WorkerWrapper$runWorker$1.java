package androidx.work.impl;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.work.impl.WorkerWrapper", f = "WorkerWrapper.kt", l = {299}, m = "runWorker")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkerWrapper$runWorker$1 extends v6.c {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WorkerWrapper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerWrapper$runWorker$1(WorkerWrapper workerWrapper, t6.c cVar) {
        super(cVar);
        this.this$0 = workerWrapper;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object runWorker;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        runWorker = this.this$0.runWorker(this);
        return runWorker;
    }
}
