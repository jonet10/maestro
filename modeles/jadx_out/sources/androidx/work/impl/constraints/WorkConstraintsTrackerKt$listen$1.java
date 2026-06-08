package androidx.work.impl.constraints;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.impl.model.WorkSpec;
import d7.p;
import o7.a0;
import p6.x;
import r7.h;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1", f = "WorkConstraintsTracker.kt", l = {ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkConstraintsTrackerKt$listen$1 extends i implements p {
    final /* synthetic */ OnConstraintsStateChangedListener $listener;
    final /* synthetic */ WorkSpec $spec;
    final /* synthetic */ WorkConstraintsTracker $this_listen;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkConstraintsTrackerKt$listen$1(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, OnConstraintsStateChangedListener onConstraintsStateChangedListener, t6.c cVar) {
        super(2, cVar);
        this.$this_listen = workConstraintsTracker;
        this.$spec = workSpec;
        this.$listener = onConstraintsStateChangedListener;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new WorkConstraintsTrackerKt$listen$1(this.$this_listen, this.$spec, this.$listener, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((WorkConstraintsTrackerKt$listen$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            h track = this.$this_listen.track(this.$spec);
            final OnConstraintsStateChangedListener onConstraintsStateChangedListener = this.$listener;
            final WorkSpec workSpec = this.$spec;
            r7.i iVar = new r7.i() { // from class: androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1.1
                @Override // r7.i
                public final Object emit(ConstraintsState constraintsState, t6.c cVar) {
                    OnConstraintsStateChangedListener.this.onConstraintsStateChanged(workSpec, constraintsState);
                    return x.f8463a;
                }
            };
            this.label = 1;
            Object collect = track.collect(iVar, this);
            u6.a aVar = u6.a.f10762a;
            if (collect == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return x.f8463a;
    }
}
