package androidx.work.impl.workers;

import v6.c;
import v6.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.work.impl.workers.ConstraintTrackingWorkerKt", f = "ConstraintTrackingWorker.kt", l = {160}, m = "awaitConstraintsNotMet")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ConstraintTrackingWorkerKt$awaitConstraintsNotMet$1 extends c {
    int label;
    /* synthetic */ Object result;

    public ConstraintTrackingWorkerKt$awaitConstraintsNotMet$1(t6.c cVar) {
        super(cVar);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object awaitConstraintsNotMet;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        awaitConstraintsNotMet = ConstraintTrackingWorkerKt.awaitConstraintsNotMet(null, null, this);
        return awaitConstraintsNotMet;
    }
}
