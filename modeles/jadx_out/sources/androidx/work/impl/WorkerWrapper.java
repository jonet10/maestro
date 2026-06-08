package androidx.work.impl;

import a4.x;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Clock;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.ListenableFutureKt;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;
import o7.c0;
import o7.m1;
import o7.s;
import q6.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkerWrapper {
    private final Context appContext;
    private final ListenableWorker builderWorker;
    private final Clock clock;
    private final Configuration configuration;
    private final DependencyDao dependencyDao;
    private final ForegroundProcessor foregroundProcessor;
    private final WorkerParameters.RuntimeExtras runtimeExtras;
    private final List<String> tags;
    private final WorkDatabase workDatabase;
    private final String workDescription;
    private final WorkSpec workSpec;
    private final WorkSpecDao workSpecDao;
    private final String workSpecId;
    private final TaskExecutor workTaskExecutor;
    private final s workerJob;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Builder {
        private final Context appContext;
        private final Configuration configuration;
        private final ForegroundProcessor foregroundProcessor;
        private WorkerParameters.RuntimeExtras runtimeExtras;
        private final List<String> tags;
        private final WorkDatabase workDatabase;
        private final WorkSpec workSpec;
        private final TaskExecutor workTaskExecutor;
        private ListenableWorker worker;

        @SuppressLint({"LambdaLast"})
        public Builder(Context context, Configuration configuration, TaskExecutor taskExecutor, ForegroundProcessor foregroundProcessor, WorkDatabase workDatabase, WorkSpec workSpec, List<String> list) {
            context.getClass();
            configuration.getClass();
            taskExecutor.getClass();
            foregroundProcessor.getClass();
            workDatabase.getClass();
            workSpec.getClass();
            list.getClass();
            this.configuration = configuration;
            this.workTaskExecutor = taskExecutor;
            this.foregroundProcessor = foregroundProcessor;
            this.workDatabase = workDatabase;
            this.workSpec = workSpec;
            this.tags = list;
            Context applicationContext = context.getApplicationContext();
            applicationContext.getClass();
            this.appContext = applicationContext;
            this.runtimeExtras = new WorkerParameters.RuntimeExtras();
        }

        public final WorkerWrapper build() {
            return new WorkerWrapper(this);
        }

        public final Context getAppContext() {
            return this.appContext;
        }

        public final Configuration getConfiguration() {
            return this.configuration;
        }

        public final ForegroundProcessor getForegroundProcessor() {
            return this.foregroundProcessor;
        }

        public final WorkerParameters.RuntimeExtras getRuntimeExtras() {
            return this.runtimeExtras;
        }

        public final List<String> getTags() {
            return this.tags;
        }

        public final WorkDatabase getWorkDatabase() {
            return this.workDatabase;
        }

        public final WorkSpec getWorkSpec() {
            return this.workSpec;
        }

        public final TaskExecutor getWorkTaskExecutor() {
            return this.workTaskExecutor;
        }

        public final ListenableWorker getWorker() {
            return this.worker;
        }

        public final void setRuntimeExtras(WorkerParameters.RuntimeExtras runtimeExtras) {
            runtimeExtras.getClass();
            this.runtimeExtras = runtimeExtras;
        }

        public final void setWorker(ListenableWorker listenableWorker) {
            this.worker = listenableWorker;
        }

        public final Builder withRuntimeExtras(WorkerParameters.RuntimeExtras runtimeExtras) {
            if (runtimeExtras != null) {
                this.runtimeExtras = runtimeExtras;
            }
            return this;
        }

        @VisibleForTesting
        public final Builder withWorker(ListenableWorker listenableWorker) {
            listenableWorker.getClass();
            this.worker = listenableWorker;
            return this;
        }
    }

    public WorkerWrapper(Builder builder) {
        builder.getClass();
        WorkSpec workSpec = builder.getWorkSpec();
        this.workSpec = workSpec;
        this.appContext = builder.getAppContext();
        this.workSpecId = workSpec.id;
        this.runtimeExtras = builder.getRuntimeExtras();
        this.builderWorker = builder.getWorker();
        this.workTaskExecutor = builder.getWorkTaskExecutor();
        Configuration configuration = builder.getConfiguration();
        this.configuration = configuration;
        this.clock = configuration.getClock();
        this.foregroundProcessor = builder.getForegroundProcessor();
        WorkDatabase workDatabase = builder.getWorkDatabase();
        this.workDatabase = workDatabase;
        this.workSpecDao = workDatabase.workSpecDao();
        this.dependencyDao = workDatabase.dependencyDao();
        List<String> tags = builder.getTags();
        this.tags = tags;
        this.workDescription = createWorkDescription(tags);
        this.workerJob = c0.c();
    }

    private final String createWorkDescription(List<String> list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.workSpecId);
        sb.append(", tags={ ");
        return x.n(sb, q6.l.x0(list, ",", null, null, null, 62), " } ]");
    }

    private final boolean handleResult(ListenableWorker.Result result) {
        String str;
        String str2;
        String str3;
        if (result instanceof ListenableWorker.Result.Success) {
            str3 = WorkerWrapperKt.TAG;
            Logger.get().info(str3, "Worker result SUCCESS for " + this.workDescription);
            return this.workSpec.isPeriodic() ? resetPeriodic() : setSucceeded(result);
        }
        if (result instanceof ListenableWorker.Result.Retry) {
            str2 = WorkerWrapperKt.TAG;
            Logger.get().info(str2, "Worker result RETRY for " + this.workDescription);
            return reschedule(-256);
        }
        str = WorkerWrapperKt.TAG;
        Logger.get().info(str, "Worker result FAILURE for " + this.workDescription);
        if (this.workSpec.isPeriodic()) {
            return resetPeriodic();
        }
        if (result == null) {
            result = new ListenableWorker.Result.Failure();
        }
        return setFailed(result);
    }

    private final void iterativelyFailWorkAndDependents(String str) {
        ArrayList e02 = q6.m.e0(str);
        while (!e02.isEmpty()) {
            String str2 = (String) r.n0(e02);
            if (this.workSpecDao.getState(str2) != WorkInfo.State.CANCELLED) {
                this.workSpecDao.setState(WorkInfo.State.FAILED, str2);
            }
            e02.addAll(this.dependencyDao.getDependentWorkIds(str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onWorkFinished(ListenableWorker.Result result) {
        WorkInfo.State state = this.workSpecDao.getState(this.workSpecId);
        this.workDatabase.workProgressDao().delete(this.workSpecId);
        if (state == null) {
            return false;
        }
        if (state == WorkInfo.State.RUNNING) {
            return handleResult(result);
        }
        if (state.isFinished()) {
            return false;
        }
        return reschedule(WorkInfo.STOP_REASON_UNKNOWN);
    }

    private final boolean reschedule(int i) {
        this.workSpecDao.setState(WorkInfo.State.ENQUEUED, this.workSpecId);
        this.workSpecDao.setLastEnqueueTime(this.workSpecId, this.clock.currentTimeMillis());
        this.workSpecDao.resetWorkSpecNextScheduleTimeOverride(this.workSpecId, this.workSpec.getNextScheduleTimeOverrideGeneration());
        this.workSpecDao.markWorkSpecScheduled(this.workSpecId, -1L);
        this.workSpecDao.setStopReason(this.workSpecId, i);
        return true;
    }

    private final boolean resetPeriodic() {
        this.workSpecDao.setLastEnqueueTime(this.workSpecId, this.clock.currentTimeMillis());
        this.workSpecDao.setState(WorkInfo.State.ENQUEUED, this.workSpecId);
        this.workSpecDao.resetWorkSpecRunAttemptCount(this.workSpecId);
        this.workSpecDao.resetWorkSpecNextScheduleTimeOverride(this.workSpecId, this.workSpec.getNextScheduleTimeOverrideGeneration());
        this.workSpecDao.incrementPeriodCount(this.workSpecId);
        this.workSpecDao.markWorkSpecScheduled(this.workSpecId, -1L);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean resetWorkerStatus(int i) {
        String str;
        String str2;
        String str3;
        if (kotlin.jvm.internal.l.a(this.workSpec.getBackOffOnSystemInterruptions(), Boolean.TRUE)) {
            str3 = WorkerWrapperKt.TAG;
            Logger.get().debug(str3, "Worker " + this.workSpec.workerClassName + " was interrupted. Backing off.");
            reschedule(i);
            return true;
        }
        WorkInfo.State state = this.workSpecDao.getState(this.workSpecId);
        if (state == null || state.isFinished()) {
            str = WorkerWrapperKt.TAG;
            Logger.get().debug(str, "Status for " + this.workSpecId + " is " + state + " ; not doing any work");
            return false;
        }
        str2 = WorkerWrapperKt.TAG;
        Logger.get().debug(str2, "Status for " + this.workSpecId + " is " + state + "; not doing any work and rescheduling for later execution");
        this.workSpecDao.setState(WorkInfo.State.ENQUEUED, this.workSpecId);
        this.workSpecDao.setStopReason(this.workSpecId, i);
        this.workSpecDao.markWorkSpecScheduled(this.workSpecId, -1L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runWorker(t6.c r22) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkerWrapper.runWorker(t6.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean runWorker$lambda$1(WorkerWrapper workerWrapper) {
        String str;
        String str2;
        WorkSpec workSpec = workerWrapper.workSpec;
        if (workSpec.state != WorkInfo.State.ENQUEUED) {
            str2 = WorkerWrapperKt.TAG;
            Logger.get().debug(str2, workerWrapper.workSpec.workerClassName + " is not in ENQUEUED state. Nothing more to do");
            return Boolean.TRUE;
        }
        if ((!workSpec.isPeriodic() && !workerWrapper.workSpec.isBackedOff()) || workerWrapper.clock.currentTimeMillis() >= workerWrapper.workSpec.calculateNextRunTime()) {
            return Boolean.FALSE;
        }
        Logger logger = Logger.get();
        str = WorkerWrapperKt.TAG;
        logger.debug(str, "Delaying execution for " + workerWrapper.workSpec.workerClassName + " because it is being executed before schedule.");
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final p6.x runWorker$lambda$4(ListenableWorker listenableWorker, boolean z9, String str, WorkerWrapper workerWrapper, Throwable th) {
        if (th instanceof WorkerStoppedException) {
            listenableWorker.stop(((WorkerStoppedException) th).getReason());
        }
        if (z9 && str != null) {
            workerWrapper.configuration.getTracer().endAsyncSection(str, workerWrapper.workSpec.hashCode());
        }
        return p6.x.f8463a;
    }

    private final boolean setSucceeded(ListenableWorker.Result result) {
        String str;
        this.workSpecDao.setState(WorkInfo.State.SUCCEEDED, this.workSpecId);
        result.getClass();
        Data outputData = ((ListenableWorker.Result.Success) result).getOutputData();
        outputData.getClass();
        this.workSpecDao.setOutput(this.workSpecId, outputData);
        long currentTimeMillis = this.clock.currentTimeMillis();
        for (String str2 : this.dependencyDao.getDependentWorkIds(this.workSpecId)) {
            if (this.workSpecDao.getState(str2) == WorkInfo.State.BLOCKED && this.dependencyDao.hasCompletedAllPrerequisites(str2)) {
                str = WorkerWrapperKt.TAG;
                Logger.get().info(str, "Setting status to enqueued for " + str2);
                this.workSpecDao.setState(WorkInfo.State.ENQUEUED, str2);
                this.workSpecDao.setLastEnqueueTime(str2, currentTimeMillis);
            }
        }
        return false;
    }

    private final boolean trySetRunning() {
        Object runInTransaction = this.workDatabase.runInTransaction(new k(this, 1));
        runInTransaction.getClass();
        return ((Boolean) runInTransaction).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean trySetRunning$lambda$13(WorkerWrapper workerWrapper) {
        boolean z9;
        if (workerWrapper.workSpecDao.getState(workerWrapper.workSpecId) == WorkInfo.State.ENQUEUED) {
            workerWrapper.workSpecDao.setState(WorkInfo.State.RUNNING, workerWrapper.workSpecId);
            workerWrapper.workSpecDao.incrementWorkSpecRunAttemptCount(workerWrapper.workSpecId);
            workerWrapper.workSpecDao.setStopReason(workerWrapper.workSpecId, -256);
            z9 = true;
        } else {
            z9 = false;
        }
        return Boolean.valueOf(z9);
    }

    public final WorkGenerationalId getWorkGenerationalId() {
        return WorkSpecKt.generationalId(this.workSpec);
    }

    public final WorkSpec getWorkSpec() {
        return this.workSpec;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void interrupt(int i) {
        ((m1) this.workerJob).y(new WorkerStoppedException(i));
    }

    public final m1.b launch() {
        return ListenableFutureKt.launchFuture$default(this.workTaskExecutor.getTaskCoroutineDispatcher().plus(c0.c()), null, new WorkerWrapper$launch$1(this, null), 2, null);
    }

    @VisibleForTesting
    public final boolean setFailed(ListenableWorker.Result result) {
        result.getClass();
        iterativelyFailWorkAndDependents(this.workSpecId);
        Data outputData = ((ListenableWorker.Result.Failure) result).getOutputData();
        outputData.getClass();
        this.workSpecDao.resetWorkSpecNextScheduleTimeOverride(this.workSpecId, this.workSpec.getNextScheduleTimeOverrideGeneration());
        this.workSpecDao.setOutput(this.workSpecId, outputData);
        return false;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class Resolution {

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        public static final class Finished extends Resolution {
            private final ListenableWorker.Result result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Finished(ListenableWorker.Result result) {
                super(null);
                result.getClass();
                this.result = result;
            }

            public final ListenableWorker.Result getResult() {
                return this.result;
            }
        }

        public /* synthetic */ Resolution(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Resolution() {
        }

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        public static final class ResetWorkerStatus extends Resolution {
            private final int reason;

            public /* synthetic */ ResetWorkerStatus(int i, int i6, kotlin.jvm.internal.g gVar) {
                this((i6 & 1) != 0 ? -256 : i);
            }

            public final int getReason() {
                return this.reason;
            }

            public ResetWorkerStatus(int i) {
                super(null);
                this.reason = i;
            }

            public ResetWorkerStatus() {
                this(0, 1, null);
            }
        }

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        public static final class Failed extends Resolution {
            private final ListenableWorker.Result result;

            public /* synthetic */ Failed(ListenableWorker.Result result, int i, kotlin.jvm.internal.g gVar) {
                this((i & 1) != 0 ? new ListenableWorker.Result.Failure() : result);
            }

            public final ListenableWorker.Result getResult() {
                return this.result;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failed(ListenableWorker.Result result) {
                super(null);
                result.getClass();
                this.result = result;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Failed() {
                this(null, 1, 0 == true ? 1 : 0);
            }
        }
    }
}
