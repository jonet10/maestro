package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Trackers {
    private final ConstraintTracker<Boolean> batteryChargingTracker;
    private final BatteryNotLowTracker batteryNotLowTracker;
    private final Context context;
    private final ConstraintTracker<NetworkState> networkStateTracker;
    private final ConstraintTracker<Boolean> storageNotLowTracker;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ Trackers(android.content.Context r8, androidx.work.impl.utils.taskexecutor.TaskExecutor r9, androidx.work.impl.constraints.trackers.ConstraintTracker r10, androidx.work.impl.constraints.trackers.BatteryNotLowTracker r11, androidx.work.impl.constraints.trackers.ConstraintTracker r12, androidx.work.impl.constraints.trackers.ConstraintTracker r13, int r14, kotlin.jvm.internal.g r15) {
        /*
            r7 = this;
            r15 = r14 & 4
            if (r15 == 0) goto L10
            androidx.work.impl.constraints.trackers.BatteryChargingTracker r10 = new androidx.work.impl.constraints.trackers.BatteryChargingTracker
            android.content.Context r15 = r8.getApplicationContext()
            r15.getClass()
            r10.<init>(r15, r9)
        L10:
            r3 = r10
            r10 = r14 & 8
            if (r10 == 0) goto L21
            androidx.work.impl.constraints.trackers.BatteryNotLowTracker r11 = new androidx.work.impl.constraints.trackers.BatteryNotLowTracker
            android.content.Context r10 = r8.getApplicationContext()
            r10.getClass()
            r11.<init>(r10, r9)
        L21:
            r4 = r11
            r10 = r14 & 16
            if (r10 == 0) goto L31
            android.content.Context r10 = r8.getApplicationContext()
            r10.getClass()
            androidx.work.impl.constraints.trackers.ConstraintTracker r12 = androidx.work.impl.constraints.trackers.NetworkStateTrackerKt.NetworkStateTracker(r10, r9)
        L31:
            r5 = r12
            r10 = r14 & 32
            if (r10 == 0) goto L42
            androidx.work.impl.constraints.trackers.StorageNotLowTracker r13 = new androidx.work.impl.constraints.trackers.StorageNotLowTracker
            android.content.Context r10 = r8.getApplicationContext()
            r10.getClass()
            r13.<init>(r10, r9)
        L42:
            r0 = r7
            r1 = r8
            r2 = r9
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.trackers.Trackers.<init>(android.content.Context, androidx.work.impl.utils.taskexecutor.TaskExecutor, androidx.work.impl.constraints.trackers.ConstraintTracker, androidx.work.impl.constraints.trackers.BatteryNotLowTracker, androidx.work.impl.constraints.trackers.ConstraintTracker, androidx.work.impl.constraints.trackers.ConstraintTracker, int, kotlin.jvm.internal.g):void");
    }

    public final ConstraintTracker<Boolean> getBatteryChargingTracker() {
        return this.batteryChargingTracker;
    }

    public final BatteryNotLowTracker getBatteryNotLowTracker() {
        return this.batteryNotLowTracker;
    }

    public final Context getContext() {
        return this.context;
    }

    public final ConstraintTracker<NetworkState> getNetworkStateTracker() {
        return this.networkStateTracker;
    }

    public final ConstraintTracker<Boolean> getStorageNotLowTracker() {
        return this.storageNotLowTracker;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker) {
        this(context, taskExecutor, constraintTracker, null, null, null, 56, null);
        context.getClass();
        taskExecutor.getClass();
        constraintTracker.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker, BatteryNotLowTracker batteryNotLowTracker) {
        this(context, taskExecutor, constraintTracker, batteryNotLowTracker, null, null, 48, null);
        context.getClass();
        taskExecutor.getClass();
        constraintTracker.getClass();
        batteryNotLowTracker.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker, BatteryNotLowTracker batteryNotLowTracker, ConstraintTracker<NetworkState> constraintTracker2) {
        this(context, taskExecutor, constraintTracker, batteryNotLowTracker, constraintTracker2, null, 32, null);
        context.getClass();
        taskExecutor.getClass();
        constraintTracker.getClass();
        batteryNotLowTracker.getClass();
        constraintTracker2.getClass();
    }

    public Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker, BatteryNotLowTracker batteryNotLowTracker, ConstraintTracker<NetworkState> constraintTracker2, ConstraintTracker<Boolean> constraintTracker3) {
        context.getClass();
        taskExecutor.getClass();
        constraintTracker.getClass();
        batteryNotLowTracker.getClass();
        constraintTracker2.getClass();
        constraintTracker3.getClass();
        this.context = context;
        this.batteryChargingTracker = constraintTracker;
        this.batteryNotLowTracker = batteryNotLowTracker;
        this.networkStateTracker = constraintTracker2;
        this.storageNotLowTracker = constraintTracker3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Trackers(Context context, TaskExecutor taskExecutor) {
        this(context, taskExecutor, null, null, null, null, 60, null);
        context.getClass();
        taskExecutor.getClass();
    }
}
