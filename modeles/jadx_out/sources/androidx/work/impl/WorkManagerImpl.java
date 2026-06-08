package androidx.work.impl;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.work.Configuration;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableFutureKt;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.TracerKt;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.RawWorkInfoDaoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDaoKt;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.LiveDataUtils;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.PruneWorkRunnableKt;
import androidx.work.impl.utils.RawQueries;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.multiprocess.RemoteWorkManager;
import j$.util.Objects;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class WorkManagerImpl extends WorkManager {
    public static final int CONTENT_URI_TRIGGER_API_LEVEL = 24;
    public static final String REMOTE_WORK_MANAGER_CLIENT = "androidx.work.multiprocess.RemoteWorkManagerClient";
    private Configuration mConfiguration;
    private Context mContext;
    private boolean mForceStopRunnableCompleted = false;
    private PreferenceUtils mPreferenceUtils;
    private Processor mProcessor;
    private volatile RemoteWorkManager mRemoteWorkManager;
    private BroadcastReceiver.PendingResult mRescheduleReceiverResult;
    private List<Scheduler> mSchedulers;
    private final Trackers mTrackers;
    private WorkDatabase mWorkDatabase;
    private final a0 mWorkManagerScope;
    private TaskExecutor mWorkTaskExecutor;
    private static final String TAG = Logger.tagWithPrefix("WorkManagerImpl");
    private static WorkManagerImpl sDelegatedInstance = null;
    private static WorkManagerImpl sDefaultInstance = null;
    private static final Object sLock = new Object();

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        public static boolean isDeviceProtectedStorage(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, List<Scheduler> list, Processor processor, Trackers trackers) {
        Context applicationContext = context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 24 && Api24Impl.isDeviceProtectedStorage(applicationContext)) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Cannot initialize WorkManager in direct boot mode");
            throw null;
        }
        Logger.setLogger(new Logger.LogcatLogger(configuration.getMinimumLoggingLevel()));
        this.mContext = applicationContext;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mProcessor = processor;
        this.mTrackers = trackers;
        this.mConfiguration = configuration;
        this.mSchedulers = list;
        a0 createWorkManagerScope = WorkManagerImplExtKt.createWorkManagerScope(taskExecutor);
        this.mWorkManagerScope = createWorkManagerScope;
        this.mPreferenceUtils = new PreferenceUtils(this.mWorkDatabase);
        Schedulers.registerRescheduling(list, this.mProcessor, taskExecutor.getSerialTaskExecutor(), this.mWorkDatabase, configuration);
        this.mWorkTaskExecutor.executeOnTaskThread(new ForceStopRunnable(applicationContext, this));
        UnfinishedWorkListenerKt.maybeLaunchUnfinishedWorkListener(createWorkManagerScope, this.mContext, configuration, workDatabase);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static WorkManagerImpl getInstance(Context context) {
        WorkManagerImpl workManagerImpl;
        synchronized (sLock) {
            try {
                workManagerImpl = getInstance();
                if (workManagerImpl == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (!(applicationContext instanceof Configuration.Provider)) {
                        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                    }
                    initialize(applicationContext, ((Configuration.Provider) applicationContext).getWorkManagerConfiguration());
                    workManagerImpl = getInstance(applicationContext);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return workManagerImpl;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0018, code lost:
    
        r3 = r3.getApplicationContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (androidx.work.impl.WorkManagerImpl.sDefaultInstance != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        androidx.work.impl.WorkManagerImpl.sDefaultInstance = androidx.work.impl.WorkManagerImplExtKt.createWorkManager(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        androidx.work.impl.WorkManagerImpl.sDelegatedInstance = androidx.work.impl.WorkManagerImpl.sDefaultInstance;
     */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void initialize(android.content.Context r3, androidx.work.Configuration r4) {
        /*
            java.lang.Object r0 = androidx.work.impl.WorkManagerImpl.sLock
            monitor-enter(r0)
            androidx.work.impl.WorkManagerImpl r1 = androidx.work.impl.WorkManagerImpl.sDelegatedInstance     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L16
            androidx.work.impl.WorkManagerImpl r2 = androidx.work.impl.WorkManagerImpl.sDefaultInstance     // Catch: java.lang.Throwable -> L14
            if (r2 != 0) goto Lc
            goto L16
        Lc:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L14
            java.lang.String r4 = "WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information."
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L14
            throw r3     // Catch: java.lang.Throwable -> L14
        L14:
            r3 = move-exception
            goto L2c
        L16:
            if (r1 != 0) goto L2a
            android.content.Context r3 = r3.getApplicationContext()     // Catch: java.lang.Throwable -> L14
            androidx.work.impl.WorkManagerImpl r1 = androidx.work.impl.WorkManagerImpl.sDefaultInstance     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L26
            androidx.work.impl.WorkManagerImpl r3 = androidx.work.impl.WorkManagerImplExtKt.createWorkManager(r3, r4)     // Catch: java.lang.Throwable -> L14
            androidx.work.impl.WorkManagerImpl.sDefaultInstance = r3     // Catch: java.lang.Throwable -> L14
        L26:
            androidx.work.impl.WorkManagerImpl r3 = androidx.work.impl.WorkManagerImpl.sDefaultInstance     // Catch: java.lang.Throwable -> L14
            androidx.work.impl.WorkManagerImpl.sDelegatedInstance = r3     // Catch: java.lang.Throwable -> L14
        L2a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return
        L2c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.WorkManagerImpl.initialize(android.content.Context, androidx.work.Configuration):void");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean isInitialized() {
        return getInstance() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ x lambda$rescheduleEligibleWork$0() {
        SystemJobScheduler.cancelAllInAllNamespaces(getApplicationContext());
        getWorkDatabase().workSpecDao().resetScheduledState();
        Schedulers.schedule(getConfiguration(), getWorkDatabase(), getSchedulers());
        return x.f8463a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setDelegate(WorkManagerImpl workManagerImpl) {
        synchronized (sLock) {
            sDelegatedInstance = workManagerImpl;
        }
    }

    private void tryInitializeMultiProcessSupport() {
        try {
            this.mRemoteWorkManager = (RemoteWorkManager) Class.forName(REMOTE_WORK_MANAGER_CLIENT).getConstructor(Context.class, WorkManagerImpl.class).newInstance(this.mContext, this);
        } catch (Throwable th) {
            Logger.get().debug(TAG, "Unable to initialize multi-process support", th);
        }
    }

    @Override // androidx.work.WorkManager
    public WorkContinuation beginUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, str, existingWorkPolicy, list);
        }
        com.google.gson.internal.a.p("beginUniqueWork needs at least one OneTimeWorkRequest.");
        return null;
    }

    @Override // androidx.work.WorkManager
    public WorkContinuation beginWith(List<OneTimeWorkRequest> list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, list);
        }
        com.google.gson.internal.a.p("beginWith needs at least one OneTimeWorkRequest.");
        return null;
    }

    @Override // androidx.work.WorkManager
    public Operation cancelAllWork() {
        return CancelWorkRunnable.forAll(this);
    }

    @Override // androidx.work.WorkManager
    public Operation cancelAllWorkByTag(String str) {
        return CancelWorkRunnable.forTag(str, this);
    }

    @Override // androidx.work.WorkManager
    public Operation cancelUniqueWork(String str) {
        return CancelWorkRunnable.forName(str, this);
    }

    @Override // androidx.work.WorkManager
    public Operation cancelWorkById(UUID uuid) {
        return CancelWorkRunnable.forId(uuid, this);
    }

    public void closeDatabase() {
        WorkManagerImplExtKt.close(this);
    }

    @Override // androidx.work.WorkManager
    public PendingIntent createCancelPendingIntent(UUID uuid) {
        return PendingIntent.getService(this.mContext, 0, SystemForegroundDispatcher.createCancelWorkIntent(this.mContext, uuid.toString()), Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728);
    }

    public WorkContinuationImpl createWorkContinuationForUniquePeriodicWork(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest) {
        return new WorkContinuationImpl(this, str, existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.KEEP ? ExistingWorkPolicy.KEEP : ExistingWorkPolicy.REPLACE, Collections.singletonList(periodicWorkRequest));
    }

    @Override // androidx.work.WorkManager
    public Operation enqueue(List<? extends WorkRequest> list) {
        if (!list.isEmpty()) {
            return new WorkContinuationImpl(this, list).enqueue();
        }
        com.google.gson.internal.a.p("enqueue needs at least one WorkRequest.");
        return null;
    }

    @Override // androidx.work.WorkManager
    public Operation enqueueUniquePeriodicWork(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest) {
        return existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.UPDATE ? WorkerUpdater.enqueueUniquelyNamedPeriodic(this, str, periodicWorkRequest) : createWorkContinuationForUniquePeriodicWork(str, existingPeriodicWorkPolicy, periodicWorkRequest).enqueue();
    }

    @Override // androidx.work.WorkManager
    public Operation enqueueUniqueWork(String str, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list) {
        return new WorkContinuationImpl(this, str, existingWorkPolicy, list).enqueue();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Context getApplicationContext() {
        return this.mContext;
    }

    @Override // androidx.work.WorkManager
    public Configuration getConfiguration() {
        return this.mConfiguration;
    }

    @Override // androidx.work.WorkManager
    public m1.b getLastCancelAllTimeMillis() {
        PreferenceUtils preferenceUtils = this.mPreferenceUtils;
        SerialExecutor serialTaskExecutor = this.mWorkTaskExecutor.getSerialTaskExecutor();
        Objects.requireNonNull(preferenceUtils);
        return ListenableFutureKt.executeAsync(serialTaskExecutor, "getLastCancelAllTimeMillis", new androidx.room.g(preferenceUtils, 5));
    }

    @Override // androidx.work.WorkManager
    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return this.mPreferenceUtils.getLastCancelAllTimeMillisLiveData();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PreferenceUtils getPreferenceUtils() {
        return this.mPreferenceUtils;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Processor getProcessor() {
        return this.mProcessor;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteWorkManager getRemoteWorkManager() {
        if (this.mRemoteWorkManager == null) {
            synchronized (sLock) {
                try {
                    if (this.mRemoteWorkManager == null) {
                        tryInitializeMultiProcessSupport();
                        if (this.mRemoteWorkManager == null && !TextUtils.isEmpty(this.mConfiguration.getDefaultProcessName())) {
                            throw new IllegalStateException("Invalid multiprocess configuration. Define an `implementation` dependency on :work:work-multiprocess library");
                        }
                    }
                } finally {
                }
            }
        }
        return this.mRemoteWorkManager;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<Scheduler> getSchedulers() {
        return this.mSchedulers;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Trackers getTrackers() {
        return this.mTrackers;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkDatabase getWorkDatabase() {
        return this.mWorkDatabase;
    }

    @Override // androidx.work.WorkManager
    public m1.b getWorkInfoById(UUID uuid) {
        return StatusRunnable.forUUID(this.mWorkDatabase, this.mWorkTaskExecutor, uuid);
    }

    @Override // androidx.work.WorkManager
    public r7.h getWorkInfoByIdFlow(UUID uuid) {
        return WorkSpecDaoKt.getWorkStatusPojoFlowDataForIds(getWorkDatabase().workSpecDao(), uuid);
    }

    @Override // androidx.work.WorkManager
    public LiveData<WorkInfo> getWorkInfoByIdLiveData(UUID uuid) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(Collections.singletonList(uuid.toString())), new Function<List<WorkSpec.WorkInfoPojo>, WorkInfo>() { // from class: androidx.work.impl.WorkManagerImpl.1
            @Override // androidx.arch.core.util.Function
            public WorkInfo apply(List<WorkSpec.WorkInfoPojo> list) {
                if (list == null || list.size() <= 0) {
                    return null;
                }
                return list.get(0).toWorkInfo();
            }
        }, this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    public m1.b getWorkInfos(WorkQuery workQuery) {
        return StatusRunnable.forWorkQuerySpec(this.mWorkDatabase, this.mWorkTaskExecutor, workQuery);
    }

    public LiveData<List<WorkInfo>> getWorkInfosById(List<String> list) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(list), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    public m1.b getWorkInfosByTag(String str) {
        return StatusRunnable.forTag(this.mWorkDatabase, this.mWorkTaskExecutor, str);
    }

    @Override // androidx.work.WorkManager
    public r7.h getWorkInfosByTagFlow(String str) {
        return WorkSpecDaoKt.getWorkStatusPojoFlowForTag(this.mWorkDatabase.workSpecDao(), this.mWorkTaskExecutor.getTaskCoroutineDispatcher(), str);
    }

    @Override // androidx.work.WorkManager
    public LiveData<List<WorkInfo>> getWorkInfosByTagLiveData(String str) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForTag(str), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    public r7.h getWorkInfosFlow(WorkQuery workQuery) {
        return RawWorkInfoDaoKt.getWorkInfoPojosFlow(this.mWorkDatabase.rawWorkInfoDao(), this.mWorkTaskExecutor.getTaskCoroutineDispatcher(), RawQueries.toRawQuery(workQuery));
    }

    @Override // androidx.work.WorkManager
    public m1.b getWorkInfosForUniqueWork(String str) {
        return StatusRunnable.forUniqueWork(this.mWorkDatabase, this.mWorkTaskExecutor, str);
    }

    @Override // androidx.work.WorkManager
    public r7.h getWorkInfosForUniqueWorkFlow(String str) {
        return WorkSpecDaoKt.getWorkStatusPojoFlowForName(this.mWorkDatabase.workSpecDao(), this.mWorkTaskExecutor.getTaskCoroutineDispatcher(), str);
    }

    @Override // androidx.work.WorkManager
    public LiveData<List<WorkInfo>> getWorkInfosForUniqueWorkLiveData(String str) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForName(str), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    public LiveData<List<WorkInfo>> getWorkInfosLiveData(WorkQuery workQuery) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.rawWorkInfoDao().getWorkInfoPojosLiveData(RawQueries.toRawQuery(workQuery)), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    public a0 getWorkManagerScope() {
        return this.mWorkManagerScope;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TaskExecutor getWorkTaskExecutor() {
        return this.mWorkTaskExecutor;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onForceStopRunnableCompleted() {
        synchronized (sLock) {
            try {
                this.mForceStopRunnableCompleted = true;
                BroadcastReceiver.PendingResult pendingResult = this.mRescheduleReceiverResult;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.mRescheduleReceiverResult = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.work.WorkManager
    public Operation pruneWork() {
        return PruneWorkRunnableKt.pruneWork(this.mWorkDatabase, this.mConfiguration, this.mWorkTaskExecutor);
    }

    public void rescheduleEligibleWork() {
        TracerKt.traced(getConfiguration().getTracer(), "ReschedulingWork", new g(this, 0));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setReschedulePendingResult(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (sLock) {
            try {
                BroadcastReceiver.PendingResult pendingResult2 = this.mRescheduleReceiverResult;
                if (pendingResult2 != null) {
                    pendingResult2.finish();
                }
                this.mRescheduleReceiverResult = pendingResult;
                if (this.mForceStopRunnableCompleted) {
                    pendingResult.finish();
                    this.mRescheduleReceiverResult = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void stopForegroundWork(WorkGenerationalId workGenerationalId, int i) {
        this.mWorkTaskExecutor.executeOnTaskThread(new StopWorkRunnable(this.mProcessor, new StartStopToken(workGenerationalId), true, i));
    }

    @Override // androidx.work.WorkManager
    public m1.b updateWork(WorkRequest workRequest) {
        return WorkerUpdater.updateWorkImpl(this, workRequest);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Deprecated
    public static WorkManagerImpl getInstance() {
        synchronized (sLock) {
            try {
                WorkManagerImpl workManagerImpl = sDelegatedInstance;
                if (workManagerImpl != null) {
                    return workManagerImpl;
                }
                return sDefaultInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
