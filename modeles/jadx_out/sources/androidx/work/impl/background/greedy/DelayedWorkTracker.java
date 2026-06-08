package androidx.work.impl.background.greedy;

import androidx.annotation.RestrictTo;
import androidx.work.Clock;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class DelayedWorkTracker {
    static final String TAG = Logger.tagWithPrefix("DelayedWorkTracker");
    private final Clock mClock;
    final Scheduler mImmediateScheduler;
    private final RunnableScheduler mRunnableScheduler;
    private final Map<String, Runnable> mRunnables = new HashMap();

    public DelayedWorkTracker(Scheduler scheduler, RunnableScheduler runnableScheduler, Clock clock) {
        this.mImmediateScheduler = scheduler;
        this.mRunnableScheduler = runnableScheduler;
        this.mClock = clock;
    }

    public void schedule(final WorkSpec workSpec, long j) {
        Runnable remove = this.mRunnables.remove(workSpec.id);
        if (remove != null) {
            this.mRunnableScheduler.cancel(remove);
        }
        Runnable runnable = new Runnable() { // from class: androidx.work.impl.background.greedy.DelayedWorkTracker.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.get().debug(DelayedWorkTracker.TAG, "Scheduling work " + workSpec.id);
                DelayedWorkTracker.this.mImmediateScheduler.schedule(workSpec);
            }
        };
        this.mRunnables.put(workSpec.id, runnable);
        this.mRunnableScheduler.scheduleWithDelay(j - this.mClock.currentTimeMillis(), runnable);
    }

    public void unschedule(String str) {
        Runnable remove = this.mRunnables.remove(str);
        if (remove != null) {
            this.mRunnableScheduler.cancel(remove);
        }
    }
}
