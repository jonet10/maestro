package androidx.work.impl.utils;

import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.l;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkRequest;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.impl.workers.ConstraintTrackingWorkerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import q6.m;
import q6.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class EnqueueUtilsKt {
    public static final String ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME = "androidx.work.multiprocess.RemoteListenableDelegatingWorker.ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME";
    public static final String ARGUMENT_SERVICE_CLASS_NAME = "androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_CLASS_NAME";
    public static final String ARGUMENT_SERVICE_PACKAGE_NAME = "androidx.work.impl.workers.RemoteListenableWorker.ARGUMENT_PACKAGE_NAME";
    public static final String REMOTE_DELEGATING_LISTENABLE_WORKER_CLASS_NAME = "androidx.work.multiprocess.RemoteListenableDelegatingWorker";

    public static final void checkContentUriTriggerWorkerLimits(WorkDatabase workDatabase, Configuration configuration, WorkContinuationImpl workContinuationImpl) {
        int i;
        workDatabase.getClass();
        configuration.getClass();
        workContinuationImpl.getClass();
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        ArrayList e02 = m.e0(workContinuationImpl);
        int i6 = 0;
        while (!e02.isEmpty()) {
            WorkContinuationImpl workContinuationImpl2 = (WorkContinuationImpl) r.n0(e02);
            List<? extends WorkRequest> work = workContinuationImpl2.getWork();
            work.getClass();
            List<? extends WorkRequest> list = work;
            if ((list instanceof Collection) && list.isEmpty()) {
                i = 0;
            } else {
                Iterator<T> it = list.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (((WorkRequest) it.next()).getWorkSpec().constraints.hasContentUriTriggers() && (i = i + 1) < 0) {
                        m.g0();
                        throw null;
                    }
                }
            }
            i6 += i;
            List<WorkContinuationImpl> parents = workContinuationImpl2.getParents();
            if (parents != null) {
                e02.addAll(parents);
            }
        }
        if (i6 == 0) {
            return;
        }
        int countNonFinishedContentUriTriggerWorkers = workDatabase.workSpecDao().countNonFinishedContentUriTriggerWorkers();
        int contentUriTriggerWorkersLimit = configuration.getContentUriTriggerWorkersLimit();
        if (countNonFinishedContentUriTriggerWorkers + i6 <= contentUriTriggerWorkersLimit) {
            return;
        }
        StringBuilder sb = new StringBuilder("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: ");
        sb.append(contentUriTriggerWorkersLimit);
        sb.append(";\nalready enqueued count: ");
        sb.append(countNonFinishedContentUriTriggerWorkers);
        sb.append(";\ncurrent enqueue operation count: ");
        com.google.gson.internal.a.p(l.x(sb, ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed.", i6));
    }

    public static final WorkSpec tryDelegateConstrainedWorkSpec(WorkSpec workSpec) {
        workSpec.getClass();
        Constraints constraints = workSpec.constraints;
        String str = workSpec.workerClassName;
        if (kotlin.jvm.internal.l.a(str, ConstraintTrackingWorker.class.getName()) || !(constraints.requiresBatteryNotLow() || constraints.requiresStorageNotLow())) {
            return workSpec;
        }
        return WorkSpec.copy$default(workSpec, null, null, ConstraintTrackingWorker.class.getName(), null, new Data.Builder().putAll(workSpec.input).putString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME, str).build(), null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, null, null, 33554411, null);
    }

    @VisibleForTesting
    public static final WorkSpec tryDelegateRemoteListenableWorker(WorkSpec workSpec) {
        workSpec.getClass();
        boolean hasKeyWithValueOfType = workSpec.input.hasKeyWithValueOfType(ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME, String.class);
        boolean hasKeyWithValueOfType2 = workSpec.input.hasKeyWithValueOfType(ARGUMENT_SERVICE_PACKAGE_NAME, String.class);
        boolean hasKeyWithValueOfType3 = workSpec.input.hasKeyWithValueOfType(ARGUMENT_SERVICE_CLASS_NAME, String.class);
        if (hasKeyWithValueOfType || !hasKeyWithValueOfType2 || !hasKeyWithValueOfType3) {
            return workSpec;
        }
        return WorkSpec.copy$default(workSpec, null, null, REMOTE_DELEGATING_LISTENABLE_WORKER_CLASS_NAME, null, new Data.Builder().putAll(workSpec.input).putString(ARGUMENT_REMOTE_LISTENABLE_WORKER_NAME, workSpec.workerClassName).build(), null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, null, null, 33554411, null);
    }

    public static final WorkSpec wrapWorkSpecIfNeeded(List<? extends Scheduler> list, WorkSpec workSpec) {
        list.getClass();
        workSpec.getClass();
        WorkSpec tryDelegateRemoteListenableWorker = tryDelegateRemoteListenableWorker(workSpec);
        return Build.VERSION.SDK_INT <= 25 ? tryDelegateConstrainedWorkSpec(tryDelegateRemoteListenableWorker) : tryDelegateRemoteListenableWorker;
    }
}
