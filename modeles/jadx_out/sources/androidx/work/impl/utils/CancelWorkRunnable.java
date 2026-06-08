package androidx.work.impl.utils;

import androidx.work.Operation;
import androidx.work.OperationKt;
import androidx.work.Tracer;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.g;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import p6.x;
import q6.m;
import q6.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CancelWorkRunnable {
    private static final void cancel(WorkManagerImpl workManagerImpl, String str) {
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.getClass();
        iterativelyCancelWorkAndDependents(workDatabase, str);
        Processor processor = workManagerImpl.getProcessor();
        processor.getClass();
        processor.stopAndCancelWork(str, 1);
        Iterator<Scheduler> it = workManagerImpl.getSchedulers().iterator();
        while (it.hasNext()) {
            it.next().cancel(str);
        }
    }

    public static final Operation forAll(WorkManagerImpl workManagerImpl) {
        workManagerImpl.getClass();
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        serialTaskExecutor.getClass();
        return OperationKt.launchOperation(tracer, "CancelAllWork", serialTaskExecutor, new g(workManagerImpl, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x forAll$lambda$7(WorkManagerImpl workManagerImpl) {
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.getClass();
        workDatabase.runInTransaction(new androidx.browser.trusted.c(9, workDatabase, workManagerImpl));
        return x.f8463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forAll$lambda$7$lambda$6(WorkDatabase workDatabase, WorkManagerImpl workManagerImpl) {
        Iterator<String> it = workDatabase.workSpecDao().getAllUnfinishedWork().iterator();
        while (it.hasNext()) {
            cancel(workManagerImpl, it.next());
        }
        new PreferenceUtils(workDatabase).setLastCancelAllTimeMillis(workManagerImpl.getConfiguration().getClock().currentTimeMillis());
    }

    public static final Operation forId(UUID uuid, WorkManagerImpl workManagerImpl) {
        uuid.getClass();
        workManagerImpl.getClass();
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        serialTaskExecutor.getClass();
        return OperationKt.launchOperation(tracer, "CancelWorkById", serialTaskExecutor, new c(0, workManagerImpl, uuid));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x forId$lambda$1(WorkManagerImpl workManagerImpl, UUID uuid) {
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.getClass();
        workDatabase.runInTransaction(new androidx.browser.trusted.c(8, workManagerImpl, uuid));
        reschedulePendingWorkers(workManagerImpl);
        return x.f8463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forId$lambda$1$lambda$0(WorkManagerImpl workManagerImpl, UUID uuid) {
        String uuid2 = uuid.toString();
        uuid2.getClass();
        cancel(workManagerImpl, uuid2);
    }

    public static final Operation forName(String str, WorkManagerImpl workManagerImpl) {
        str.getClass();
        workManagerImpl.getClass();
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        String concat = "CancelWorkByName_".concat(str);
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        serialTaskExecutor.getClass();
        return OperationKt.launchOperation(tracer, concat, serialTaskExecutor, new b(str, workManagerImpl));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x forName$lambda$4(String str, WorkManagerImpl workManagerImpl) {
        forNameInline(str, workManagerImpl);
        reschedulePendingWorkers(workManagerImpl);
        return x.f8463a;
    }

    public static final void forNameInline(String str, WorkManagerImpl workManagerImpl) {
        str.getClass();
        workManagerImpl.getClass();
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.getClass();
        workDatabase.runInTransaction(new a(workDatabase, str, workManagerImpl, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forNameInline$lambda$5(WorkDatabase workDatabase, String str, WorkManagerImpl workManagerImpl) {
        Iterator<String> it = workDatabase.workSpecDao().getUnfinishedWorkWithName(str).iterator();
        while (it.hasNext()) {
            cancel(workManagerImpl, it.next());
        }
    }

    public static final Operation forTag(String str, WorkManagerImpl workManagerImpl) {
        str.getClass();
        workManagerImpl.getClass();
        Tracer tracer = workManagerImpl.getConfiguration().getTracer();
        String concat = "CancelWorkByTag_".concat(str);
        SerialExecutor serialTaskExecutor = workManagerImpl.getWorkTaskExecutor().getSerialTaskExecutor();
        serialTaskExecutor.getClass();
        return OperationKt.launchOperation(tracer, concat, serialTaskExecutor, new b(workManagerImpl, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x forTag$lambda$3(WorkManagerImpl workManagerImpl, String str) {
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.getClass();
        workDatabase.runInTransaction(new a(workDatabase, str, workManagerImpl, 1));
        reschedulePendingWorkers(workManagerImpl);
        return x.f8463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forTag$lambda$3$lambda$2(WorkDatabase workDatabase, String str, WorkManagerImpl workManagerImpl) {
        Iterator<String> it = workDatabase.workSpecDao().getUnfinishedWorkWithTag(str).iterator();
        while (it.hasNext()) {
            cancel(workManagerImpl, it.next());
        }
    }

    private static final void iterativelyCancelWorkAndDependents(WorkDatabase workDatabase, String str) {
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        DependencyDao dependencyDao = workDatabase.dependencyDao();
        ArrayList e02 = m.e0(str);
        while (!e02.isEmpty()) {
            String str2 = (String) r.n0(e02);
            WorkInfo.State state = workSpecDao.getState(str2);
            if (state != WorkInfo.State.SUCCEEDED && state != WorkInfo.State.FAILED) {
                workSpecDao.setCancelledState(str2);
            }
            e02.addAll(dependencyDao.getDependentWorkIds(str2));
        }
    }

    private static final void reschedulePendingWorkers(WorkManagerImpl workManagerImpl) {
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }
}
