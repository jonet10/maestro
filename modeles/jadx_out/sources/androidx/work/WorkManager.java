package androidx.work;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.work.impl.WorkManagerImpl;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.g;
import r7.h;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@SuppressLint({"AddedAbstractMethod"})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class WorkManager {
    public static final Companion Companion = new Companion(null);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class UpdateResult {
        private static final /* synthetic */ w6.a $ENTRIES;
        private static final /* synthetic */ UpdateResult[] $VALUES;
        public static final UpdateResult NOT_APPLIED = new UpdateResult("NOT_APPLIED", 0);
        public static final UpdateResult APPLIED_IMMEDIATELY = new UpdateResult("APPLIED_IMMEDIATELY", 1);
        public static final UpdateResult APPLIED_FOR_NEXT_RUN = new UpdateResult("APPLIED_FOR_NEXT_RUN", 2);

        private static final /* synthetic */ UpdateResult[] $values() {
            return new UpdateResult[]{NOT_APPLIED, APPLIED_IMMEDIATELY, APPLIED_FOR_NEXT_RUN};
        }

        static {
            UpdateResult[] $values = $values();
            $VALUES = $values;
            $ENTRIES = f.u($values);
        }

        private UpdateResult(String str, int i) {
        }

        public static w6.a getEntries() {
            return $ENTRIES;
        }

        public static UpdateResult valueOf(String str) {
            return (UpdateResult) Enum.valueOf(UpdateResult.class, str);
        }

        public static UpdateResult[] values() {
            return (UpdateResult[]) $VALUES.clone();
        }
    }

    public static WorkManager getInstance() {
        return Companion.getInstance();
    }

    public static void initialize(Context context, Configuration configuration) {
        Companion.initialize(context, configuration);
    }

    public static boolean isInitialized() {
        return Companion.isInitialized();
    }

    public final WorkContinuation beginUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest oneTimeWorkRequest) {
        str.getClass();
        existingWorkPolicy.getClass();
        oneTimeWorkRequest.getClass();
        return beginUniqueWork(str, existingWorkPolicy, a.a.H(oneTimeWorkRequest));
    }

    public abstract WorkContinuation beginUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list);

    public final WorkContinuation beginWith(OneTimeWorkRequest oneTimeWorkRequest) {
        oneTimeWorkRequest.getClass();
        return beginWith(a.a.H(oneTimeWorkRequest));
    }

    public abstract WorkContinuation beginWith(List<OneTimeWorkRequest> list);

    public abstract Operation cancelAllWork();

    public abstract Operation cancelAllWorkByTag(String str);

    public abstract Operation cancelUniqueWork(String str);

    public abstract Operation cancelWorkById(UUID uuid);

    public abstract PendingIntent createCancelPendingIntent(UUID uuid);

    public final Operation enqueue(WorkRequest workRequest) {
        workRequest.getClass();
        return enqueue(a.a.H(workRequest));
    }

    public abstract Operation enqueue(List<? extends WorkRequest> list);

    public abstract Operation enqueueUniquePeriodicWork(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest);

    public Operation enqueueUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest oneTimeWorkRequest) {
        str.getClass();
        existingWorkPolicy.getClass();
        oneTimeWorkRequest.getClass();
        return enqueueUniqueWork(str, existingWorkPolicy, a.a.H(oneTimeWorkRequest));
    }

    public abstract Operation enqueueUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list);

    public abstract Configuration getConfiguration();

    public abstract m1.b getLastCancelAllTimeMillis();

    public abstract LiveData<Long> getLastCancelAllTimeMillisLiveData();

    public abstract m1.b getWorkInfoById(UUID uuid);

    public abstract h getWorkInfoByIdFlow(UUID uuid);

    public abstract LiveData<WorkInfo> getWorkInfoByIdLiveData(UUID uuid);

    public abstract m1.b getWorkInfos(WorkQuery workQuery);

    public abstract m1.b getWorkInfosByTag(String str);

    public abstract h getWorkInfosByTagFlow(String str);

    public abstract LiveData<List<WorkInfo>> getWorkInfosByTagLiveData(String str);

    public abstract h getWorkInfosFlow(WorkQuery workQuery);

    public abstract m1.b getWorkInfosForUniqueWork(String str);

    public abstract h getWorkInfosForUniqueWorkFlow(String str);

    public abstract LiveData<List<WorkInfo>> getWorkInfosForUniqueWorkLiveData(String str);

    public abstract LiveData<List<WorkInfo>> getWorkInfosLiveData(WorkQuery workQuery);

    public abstract Operation pruneWork();

    public abstract m1.b updateWork(WorkRequest workRequest);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public WorkManager getInstance() {
            WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance();
            if (workManagerImpl != null) {
                return workManagerImpl;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("WorkManager is not initialized properly.  The most likely cause is that you disabled WorkManagerInitializer in your manifest but forgot to call WorkManager#initialize in your Application#onCreate or a ContentProvider.");
            return null;
        }

        public void initialize(Context context, Configuration configuration) {
            context.getClass();
            configuration.getClass();
            WorkManagerImpl.initialize(context, configuration);
        }

        public boolean isInitialized() {
            return WorkManagerImpl.isInitialized();
        }

        private Companion() {
        }

        public WorkManager getInstance(Context context) {
            context.getClass();
            WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(context);
            workManagerImpl.getClass();
            return workManagerImpl;
        }
    }

    public static WorkManager getInstance(Context context) {
        return Companion.getInstance(context);
    }
}
