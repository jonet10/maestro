package androidx.work.impl;

import d7.p;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.work.impl.WorkerWrapper$launch$1$resolution$1", f = "WorkerWrapper.kt", l = {98}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkerWrapper$launch$1$resolution$1 extends v6.i implements p {
    int label;
    final /* synthetic */ WorkerWrapper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerWrapper$launch$1$resolution$1(WorkerWrapper workerWrapper, t6.c cVar) {
        super(2, cVar);
        this.this$0 = workerWrapper;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new WorkerWrapper$launch$1$resolution$1(this.this$0, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((WorkerWrapper$launch$1$resolution$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object runWorker;
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                p6.a.e(obj);
                return obj;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        WorkerWrapper workerWrapper = this.this$0;
        this.label = 1;
        runWorker = workerWrapper.runWorker(this);
        u6.a aVar = u6.a.f10762a;
        return runWorker == aVar ? aVar : runWorker;
    }
}
