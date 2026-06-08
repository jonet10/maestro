package androidx.work.impl.workers;

import v6.c;
import v6.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.work.impl.workers.ConstraintTrackingWorker", f = "ConstraintTrackingWorker.kt", l = {125}, m = "runWorker")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ConstraintTrackingWorker$runWorker$1 extends c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConstraintTrackingWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker$runWorker$1(ConstraintTrackingWorker constraintTrackingWorker, t6.c cVar) {
        super(cVar);
        this.this$0 = constraintTrackingWorker;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object runWorker;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        runWorker = this.this$0.runWorker(null, null, null, this);
        return runWorker;
    }
}
