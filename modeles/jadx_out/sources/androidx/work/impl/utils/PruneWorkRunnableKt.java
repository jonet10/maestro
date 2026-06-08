package androidx.work.impl.utils;

import androidx.room.g;
import androidx.work.Configuration;
import androidx.work.Operation;
import androidx.work.OperationKt;
import androidx.work.Tracer;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PruneWorkRunnableKt {
    public static final Operation pruneWork(WorkDatabase workDatabase, Configuration configuration, TaskExecutor taskExecutor) {
        workDatabase.getClass();
        configuration.getClass();
        taskExecutor.getClass();
        Tracer tracer = configuration.getTracer();
        SerialExecutor serialTaskExecutor = taskExecutor.getSerialTaskExecutor();
        serialTaskExecutor.getClass();
        return OperationKt.launchOperation(tracer, "PruneWork", serialTaskExecutor, new g(workDatabase, 6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x pruneWork$lambda$0(WorkDatabase workDatabase) {
        workDatabase.workSpecDao().pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();
        return x.f8463a;
    }
}
