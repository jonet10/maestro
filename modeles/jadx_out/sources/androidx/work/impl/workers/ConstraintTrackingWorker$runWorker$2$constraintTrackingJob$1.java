package androidx.work.impl.workers;

import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import d7.p;
import java.util.concurrent.atomic.AtomicInteger;
import m1.b;
import o7.a0;
import p6.a;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.work.impl.workers.ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1", f = "ConstraintTrackingWorker.kt", l = {129}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1 extends i implements p {
    final /* synthetic */ AtomicInteger $atomicReason;
    final /* synthetic */ b $future;
    final /* synthetic */ WorkConstraintsTracker $workConstraintsTracker;
    final /* synthetic */ WorkSpec $workSpec;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, AtomicInteger atomicInteger, b bVar, c cVar) {
        super(2, cVar);
        this.$workConstraintsTracker = workConstraintsTracker;
        this.$workSpec = workSpec;
        this.$atomicReason = atomicInteger;
        this.$future = bVar;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1(this.$workConstraintsTracker, this.$workSpec, this.$atomicReason, this.$future, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((ConstraintTrackingWorker$runWorker$2$constraintTrackingJob$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            a.e(obj);
            WorkConstraintsTracker workConstraintsTracker = this.$workConstraintsTracker;
            WorkSpec workSpec = this.$workSpec;
            this.label = 1;
            obj = ConstraintTrackingWorkerKt.awaitConstraintsNotMet(workConstraintsTracker, workSpec, this);
            u6.a aVar = u6.a.f10762a;
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            a.e(obj);
        }
        this.$atomicReason.set(((Number) obj).intValue());
        this.$future.cancel(true);
        return x.f8463a;
    }
}
