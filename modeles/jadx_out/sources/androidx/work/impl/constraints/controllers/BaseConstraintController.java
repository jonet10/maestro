package androidx.work.impl.constraints.controllers;

import androidx.work.Constraints;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import r7.h;
import r7.k0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class BaseConstraintController<T> implements ConstraintController {
    private final ConstraintTracker<T> tracker;

    public BaseConstraintController(ConstraintTracker<T> constraintTracker) {
        constraintTracker.getClass();
        this.tracker = constraintTracker;
    }

    public abstract int getReason();

    public boolean isConstrained(T t9) {
        return false;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean isCurrentlyConstrained(WorkSpec workSpec) {
        workSpec.getClass();
        return hasConstraint(workSpec) && isConstrained(this.tracker.readSystemState());
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public h track(Constraints constraints) {
        constraints.getClass();
        return k0.e(new BaseConstraintController$track$1(this, null));
    }

    public static /* synthetic */ void getReason$annotations() {
    }
}
