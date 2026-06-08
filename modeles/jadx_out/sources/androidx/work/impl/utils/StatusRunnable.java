package androidx.work.impl.utils;

import androidx.work.ListenableFutureKt;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import c4.ma;
import d7.l;
import java.util.List;
import java.util.UUID;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class StatusRunnable {
    public static final m1.b forStringIds(WorkDatabase workDatabase, TaskExecutor taskExecutor, List<String> list) {
        workDatabase.getClass();
        taskExecutor.getClass();
        list.getClass();
        return loadStatusFuture(workDatabase, taskExecutor, new androidx.room.b(list, 8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List forStringIds$lambda$0(List list, WorkDatabase workDatabase) {
        workDatabase.getClass();
        List<WorkInfo> apply = WorkSpec.WORK_INFO_MAPPER.apply(workDatabase.workSpecDao().getWorkStatusPojoForIds(list));
        apply.getClass();
        return apply;
    }

    public static final m1.b forTag(WorkDatabase workDatabase, TaskExecutor taskExecutor, String str) {
        workDatabase.getClass();
        taskExecutor.getClass();
        str.getClass();
        return loadStatusFuture(workDatabase, taskExecutor, new ma(str, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List forTag$lambda$2(String str, WorkDatabase workDatabase) {
        workDatabase.getClass();
        List<WorkInfo> apply = WorkSpec.WORK_INFO_MAPPER.apply(workDatabase.workSpecDao().getWorkStatusPojoForTag(str));
        apply.getClass();
        return apply;
    }

    public static final m1.b forUUID(WorkDatabase workDatabase, TaskExecutor taskExecutor, UUID uuid) {
        workDatabase.getClass();
        taskExecutor.getClass();
        uuid.getClass();
        return loadStatusFuture(workDatabase, taskExecutor, new androidx.room.b(uuid, 6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WorkInfo forUUID$lambda$1(UUID uuid, WorkDatabase workDatabase) {
        workDatabase.getClass();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        String uuid2 = uuid.toString();
        uuid2.getClass();
        WorkSpec.WorkInfoPojo workStatusPojoForId = workSpecDao.getWorkStatusPojoForId(uuid2);
        if (workStatusPojoForId != null) {
            return workStatusPojoForId.toWorkInfo();
        }
        return null;
    }

    public static final m1.b forUniqueWork(WorkDatabase workDatabase, TaskExecutor taskExecutor, String str) {
        workDatabase.getClass();
        taskExecutor.getClass();
        str.getClass();
        return loadStatusFuture(workDatabase, taskExecutor, new androidx.room.support.e(str, 28));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List forUniqueWork$lambda$3(String str, WorkDatabase workDatabase) {
        workDatabase.getClass();
        List<WorkInfo> apply = WorkSpec.WORK_INFO_MAPPER.apply(workDatabase.workSpecDao().getWorkStatusPojoForName(str));
        apply.getClass();
        return apply;
    }

    public static final m1.b forWorkQuerySpec(WorkDatabase workDatabase, TaskExecutor taskExecutor, WorkQuery workQuery) {
        workDatabase.getClass();
        taskExecutor.getClass();
        workQuery.getClass();
        return loadStatusFuture(workDatabase, taskExecutor, new androidx.room.b(workQuery, 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List forWorkQuerySpec$lambda$4(WorkQuery workQuery, WorkDatabase workDatabase) {
        workDatabase.getClass();
        List<WorkInfo> apply = WorkSpec.WORK_INFO_MAPPER.apply(workDatabase.rawWorkInfoDao().getWorkInfoPojos(RawQueries.toRawQuery(workQuery)));
        apply.getClass();
        return apply;
    }

    private static final <T> m1.b loadStatusFuture(WorkDatabase workDatabase, TaskExecutor taskExecutor, l lVar) {
        SerialExecutor serialTaskExecutor = taskExecutor.getSerialTaskExecutor();
        serialTaskExecutor.getClass();
        return ListenableFutureKt.executeAsync(serialTaskExecutor, "loadStatusFuture", new c(1, lVar, workDatabase));
    }
}
