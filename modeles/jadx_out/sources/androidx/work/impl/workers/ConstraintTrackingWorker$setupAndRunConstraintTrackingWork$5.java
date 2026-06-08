package androidx.work.impl.workers;

import androidx.work.ListenableWorker;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import d7.p;
import o7.a0;
import p6.a;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.work.impl.workers.ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$5", f = "ConstraintTrackingWorker.kt", l = {98}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$5 extends i implements p {
    final /* synthetic */ ListenableWorker $delegate;
    final /* synthetic */ WorkConstraintsTracker $workConstraintsTracker;
    final /* synthetic */ WorkSpec $workSpec;
    int label;
    final /* synthetic */ ConstraintTrackingWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$5(ConstraintTrackingWorker constraintTrackingWorker, ListenableWorker listenableWorker, WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, c cVar) {
        super(2, cVar);
        this.this$0 = constraintTrackingWorker;
        this.$delegate = listenableWorker;
        this.$workConstraintsTracker = workConstraintsTracker;
        this.$workSpec = workSpec;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$5(this.this$0, this.$delegate, this.$workConstraintsTracker, this.$workSpec, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((ConstraintTrackingWorker$setupAndRunConstraintTrackingWork$5) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object runWorker;
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
        ListenableWorker listenableWorker = this.$delegate;
        WorkConstraintsTracker workConstraintsTracker = this.$workConstraintsTracker;
        WorkSpec workSpec = this.$workSpec;
        this.label = 1;
        runWorker = constraintTrackingWorker.runWorker(listenableWorker, workConstraintsTracker, workSpec, this);
        u6.a aVar = u6.a.f10762a;
        return runWorker == aVar ? aVar : runWorker;
    }
}
