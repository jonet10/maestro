package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.R;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import d7.t;
import java.util.List;
import o7.a0;
import o7.c0;
import o7.w;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkManagerImplExtKt {
    public static final void close(WorkManagerImpl workManagerImpl) {
        workManagerImpl.getClass();
        c0.w(t6.i.f10314a, new WorkManagerImplExtKt$close$1(workManagerImpl, null));
        workManagerImpl.getWorkDatabase().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Scheduler> createSchedulers(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        Scheduler createBestAvailableBackgroundScheduler = Schedulers.createBestAvailableBackgroundScheduler(context, workDatabase, configuration);
        createBestAvailableBackgroundScheduler.getClass();
        return q6.m.d0(createBestAvailableBackgroundScheduler, new GreedyScheduler(context, configuration, trackers, processor, new WorkLauncherImpl(processor, taskExecutor), taskExecutor));
    }

    public static final WorkManagerImpl createTestWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor) {
        context.getClass();
        configuration.getClass();
        taskExecutor.getClass();
        WorkDatabase.Companion companion = WorkDatabase.Companion;
        SerialExecutor serialTaskExecutor = taskExecutor.getSerialTaskExecutor();
        serialTaskExecutor.getClass();
        return createWorkManager$default(context, configuration, taskExecutor, companion.create(context, serialTaskExecutor, configuration.getClock(), true), null, null, null, 112, null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor, t tVar) {
        context.getClass();
        configuration.getClass();
        taskExecutor.getClass();
        workDatabase.getClass();
        trackers.getClass();
        processor.getClass();
        tVar.getClass();
        return new WorkManagerImpl(context.getApplicationContext(), configuration, taskExecutor, workDatabase, (List) tVar.invoke(context, configuration, taskExecutor, workDatabase, trackers, processor), processor, trackers);
    }

    public static /* synthetic */ WorkManagerImpl createWorkManager$default(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor, t tVar, int i, Object obj) {
        Trackers trackers2;
        if ((i & 4) != 0) {
            taskExecutor = new WorkManagerTaskExecutor(configuration.getTaskExecutor());
        }
        TaskExecutor taskExecutor2 = taskExecutor;
        if ((i & 8) != 0) {
            WorkDatabase.Companion companion = WorkDatabase.Companion;
            Context applicationContext = context.getApplicationContext();
            applicationContext.getClass();
            SerialExecutor serialTaskExecutor = taskExecutor2.getSerialTaskExecutor();
            serialTaskExecutor.getClass();
            workDatabase = companion.create(applicationContext, serialTaskExecutor, configuration.getClock(), context.getResources().getBoolean(R.bool.workmanager_test_configuration));
        }
        if ((i & 16) != 0) {
            Context applicationContext2 = context.getApplicationContext();
            applicationContext2.getClass();
            trackers2 = new Trackers(applicationContext2, taskExecutor2, null, null, null, null, 60, null);
        } else {
            trackers2 = trackers;
        }
        return createWorkManager(context, configuration, taskExecutor2, workDatabase, trackers2, (i & 32) != 0 ? new Processor(context.getApplicationContext(), configuration, taskExecutor2, workDatabase) : processor, (i & 64) != 0 ? WorkManagerImplExtKt$WorkManagerImpl$1.INSTANCE : tVar);
    }

    public static final a0 createWorkManagerScope(TaskExecutor taskExecutor) {
        taskExecutor.getClass();
        w taskCoroutineDispatcher = taskExecutor.getTaskCoroutineDispatcher();
        taskCoroutineDispatcher.getClass();
        return c0.b(taskCoroutineDispatcher);
    }

    public static final t schedulers(final Scheduler... schedulerArr) {
        schedulerArr.getClass();
        return new t() { // from class: androidx.work.impl.h
            @Override // d7.t
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                List schedulers$lambda$0;
                schedulers$lambda$0 = WorkManagerImplExtKt.schedulers$lambda$0(schedulerArr, (Context) obj, (Configuration) obj2, (TaskExecutor) obj3, (WorkDatabase) obj4, (Trackers) obj5, (Processor) obj6);
                return schedulers$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List schedulers$lambda$0(Scheduler[] schedulerArr, Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        context.getClass();
        configuration.getClass();
        taskExecutor.getClass();
        workDatabase.getClass();
        trackers.getClass();
        processor.getClass();
        return q6.j.m0(schedulerArr);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor) {
        context.getClass();
        configuration.getClass();
        taskExecutor.getClass();
        return createWorkManager$default(context, configuration, taskExecutor, null, null, null, null, 120, null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase) {
        context.getClass();
        configuration.getClass();
        taskExecutor.getClass();
        workDatabase.getClass();
        return createWorkManager$default(context, configuration, taskExecutor, workDatabase, null, null, null, 112, null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers) {
        context.getClass();
        configuration.getClass();
        taskExecutor.getClass();
        workDatabase.getClass();
        trackers.getClass();
        return createWorkManager$default(context, configuration, taskExecutor, workDatabase, trackers, null, null, 96, null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        context.getClass();
        configuration.getClass();
        taskExecutor.getClass();
        workDatabase.getClass();
        trackers.getClass();
        processor.getClass();
        return createWorkManager$default(context, configuration, taskExecutor, workDatabase, trackers, processor, null, 64, null);
    }

    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration) {
        context.getClass();
        configuration.getClass();
        return createWorkManager$default(context, configuration, null, null, null, null, null, 124, null);
    }
}
