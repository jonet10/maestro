package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DiagnosticsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        String str;
        String str2;
        String workSpecRows;
        String str3;
        String str4;
        String workSpecRows2;
        String str5;
        String str6;
        String workSpecRows3;
        WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(getApplicationContext());
        workManagerImpl.getClass();
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.getClass();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkNameDao workNameDao = workDatabase.workNameDao();
        WorkTagDao workTagDao = workDatabase.workTagDao();
        SystemIdInfoDao systemIdInfoDao = workDatabase.systemIdInfoDao();
        List<WorkSpec> recentlyCompletedWork = workSpecDao.getRecentlyCompletedWork(workManagerImpl.getConfiguration().getClock().currentTimeMillis() - 86400000);
        List<WorkSpec> runningWork = workSpecDao.getRunningWork();
        List<WorkSpec> allEligibleWorkSpecsForScheduling = workSpecDao.getAllEligibleWorkSpecsForScheduling(200);
        if (!recentlyCompletedWork.isEmpty()) {
            Logger logger = Logger.get();
            str5 = DiagnosticsWorkerKt.TAG;
            logger.info(str5, "Recently completed work:\n\n");
            Logger logger2 = Logger.get();
            str6 = DiagnosticsWorkerKt.TAG;
            workSpecRows3 = DiagnosticsWorkerKt.workSpecRows(workNameDao, workTagDao, systemIdInfoDao, recentlyCompletedWork);
            logger2.info(str6, workSpecRows3);
        }
        if (!runningWork.isEmpty()) {
            Logger logger3 = Logger.get();
            str3 = DiagnosticsWorkerKt.TAG;
            logger3.info(str3, "Running work:\n\n");
            Logger logger4 = Logger.get();
            str4 = DiagnosticsWorkerKt.TAG;
            workSpecRows2 = DiagnosticsWorkerKt.workSpecRows(workNameDao, workTagDao, systemIdInfoDao, runningWork);
            logger4.info(str4, workSpecRows2);
        }
        if (!allEligibleWorkSpecsForScheduling.isEmpty()) {
            Logger logger5 = Logger.get();
            str = DiagnosticsWorkerKt.TAG;
            logger5.info(str, "Enqueued work:\n\n");
            Logger logger6 = Logger.get();
            str2 = DiagnosticsWorkerKt.TAG;
            workSpecRows = DiagnosticsWorkerKt.workSpecRows(workNameDao, workTagDao, systemIdInfoDao, allEligibleWorkSpecsForScheduling);
            logger6.info(str2, workSpecRows);
        }
        ListenableWorker.Result success = ListenableWorker.Result.success();
        success.getClass();
        return success;
    }
}
