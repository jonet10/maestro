package androidx.work.impl.workers;

import d7.p;
import o7.a0;
import p6.a;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.work.impl.workers.ConstraintTrackingWorker$doWork$2", f = "ConstraintTrackingWorker.kt", l = {58}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ConstraintTrackingWorker$doWork$2 extends i implements p {
    int label;
    final /* synthetic */ ConstraintTrackingWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker$doWork$2(ConstraintTrackingWorker constraintTrackingWorker, c cVar) {
        super(2, cVar);
        this.this$0 = constraintTrackingWorker;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new ConstraintTrackingWorker$doWork$2(this.this$0, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((ConstraintTrackingWorker$doWork$2) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                a.e(obj);
                return obj;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        a.e(obj);
        ConstraintTrackingWorker constraintTrackingWorker = this.this$0;
        this.label = 1;
        obj2 = constraintTrackingWorker.setupAndRunConstraintTrackingWork(this);
        u6.a aVar = u6.a.f10762a;
        return obj2 == aVar ? aVar : obj2;
    }
}
