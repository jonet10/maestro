package androidx.work.impl.workers;

import androidx.privacysandbox.ads.adservices.customaudience.a;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.model.WorkSpec;
import d7.p;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2", f = "ConstraintTrackingWorker.kt", l = {}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2 extends i implements p {
    final /* synthetic */ WorkSpec $workSpec;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2(WorkSpec workSpec, c cVar) {
        super(2, cVar);
        this.$workSpec = workSpec;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2(this.$workSpec, cVar);
    }

    @Override // d7.p
    public final Object invoke(ConstraintsState constraintsState, c cVar) {
        return ((ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2) create(constraintsState, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        String str;
        if (this.label != 0) {
            a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        str = ConstraintTrackingWorkerKt.TAG;
        WorkSpec workSpec = this.$workSpec;
        Logger.get().debug(str, "Constraints changed for " + workSpec);
        return x.f8463a;
    }
}
