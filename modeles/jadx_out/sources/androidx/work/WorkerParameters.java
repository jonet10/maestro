package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import t6.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkerParameters {
    private Executor mBackgroundExecutor;
    private ForegroundUpdater mForegroundUpdater;
    private int mGeneration;
    private UUID mId;
    private Data mInputData;
    private ProgressUpdater mProgressUpdater;
    private int mRunAttemptCount;
    private RuntimeExtras mRuntimeExtras;
    private Set<String> mTags;
    private TaskExecutor mWorkTaskExecutor;
    private h mWorkerContext;
    private WorkerFactory mWorkerFactory;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class RuntimeExtras {

        @RequiresApi(28)
        public Network network;
        public List<String> triggeredContentAuthorities;
        public List<Uri> triggeredContentUris;

        public RuntimeExtras() {
            List list = Collections.EMPTY_LIST;
            this.triggeredContentAuthorities = list;
            this.triggeredContentUris = list;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkerParameters(UUID uuid, Data data, Collection<String> collection, RuntimeExtras runtimeExtras, @IntRange(from = 0) int i, @IntRange(from = 0) int i6, Executor executor, h hVar, TaskExecutor taskExecutor, WorkerFactory workerFactory, ProgressUpdater progressUpdater, ForegroundUpdater foregroundUpdater) {
        this.mId = uuid;
        this.mInputData = data;
        this.mTags = new HashSet(collection);
        this.mRuntimeExtras = runtimeExtras;
        this.mRunAttemptCount = i;
        this.mGeneration = i6;
        this.mBackgroundExecutor = executor;
        this.mWorkerContext = hVar;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkerFactory = workerFactory;
        this.mProgressUpdater = progressUpdater;
        this.mForegroundUpdater = foregroundUpdater;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Executor getBackgroundExecutor() {
        return this.mBackgroundExecutor;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ForegroundUpdater getForegroundUpdater() {
        return this.mForegroundUpdater;
    }

    @IntRange(from = 0)
    public int getGeneration() {
        return this.mGeneration;
    }

    public UUID getId() {
        return this.mId;
    }

    public Data getInputData() {
        return this.mInputData;
    }

    @RequiresApi(28)
    public Network getNetwork() {
        return this.mRuntimeExtras.network;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ProgressUpdater getProgressUpdater() {
        return this.mProgressUpdater;
    }

    @IntRange(from = 0)
    public int getRunAttemptCount() {
        return this.mRunAttemptCount;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RuntimeExtras getRuntimeExtras() {
        return this.mRuntimeExtras;
    }

    public Set<String> getTags() {
        return this.mTags;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TaskExecutor getTaskExecutor() {
        return this.mWorkTaskExecutor;
    }

    @RequiresApi(24)
    public List<String> getTriggeredContentAuthorities() {
        return this.mRuntimeExtras.triggeredContentAuthorities;
    }

    @RequiresApi(24)
    public List<Uri> getTriggeredContentUris() {
        return this.mRuntimeExtras.triggeredContentUris;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public h getWorkerContext() {
        return this.mWorkerContext;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkerFactory getWorkerFactory() {
        return this.mWorkerFactory;
    }
}
