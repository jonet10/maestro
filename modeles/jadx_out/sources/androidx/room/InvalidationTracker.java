package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.support.AutoCloser;
import androidx.sqlite.SQLiteConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;
import k7.k;
import kotlin.jvm.internal.l;
import p6.i;
import p6.x;
import q6.a0;
import r7.h;
import r7.w;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class InvalidationTracker {
    public static final Companion Companion = new Companion(null);
    private AutoCloser autoCloser;
    private final RoomDatabase database;
    private final TriggerBasedInvalidationTracker implementation;
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;
    private Intent multiInstanceInvalidationIntent;
    private final Map<Observer, ObserverWrapper> observerMap;
    private final ReentrantLock observerMapLock;
    private final d7.a onRefreshCompleted;
    private final d7.a onRefreshScheduled;
    private final Map<String, String> shadowTablesMap;
    private final String[] tableNames;
    private final Object trackerLock;
    private final Map<String, Set<String>> viewTables;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class MultiInstanceClientInitState {
        private final Context context;
        private final String name;
        private final Intent serviceIntent;

        public MultiInstanceClientInitState(Context context, String str, Intent intent) {
            context.getClass();
            str.getClass();
            intent.getClass();
            this.context = context;
            this.name = str;
            this.serviceIntent = intent;
        }

        public static /* synthetic */ MultiInstanceClientInitState copy$default(MultiInstanceClientInitState multiInstanceClientInitState, Context context, String str, Intent intent, int i, Object obj) {
            if ((i & 1) != 0) {
                context = multiInstanceClientInitState.context;
            }
            if ((i & 2) != 0) {
                str = multiInstanceClientInitState.name;
            }
            if ((i & 4) != 0) {
                intent = multiInstanceClientInitState.serviceIntent;
            }
            return multiInstanceClientInitState.copy(context, str, intent);
        }

        public final Context component1() {
            return this.context;
        }

        public final String component2() {
            return this.name;
        }

        public final Intent component3() {
            return this.serviceIntent;
        }

        public final MultiInstanceClientInitState copy(Context context, String str, Intent intent) {
            context.getClass();
            str.getClass();
            intent.getClass();
            return new MultiInstanceClientInitState(context, str, intent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MultiInstanceClientInitState)) {
                return false;
            }
            MultiInstanceClientInitState multiInstanceClientInitState = (MultiInstanceClientInitState) obj;
            return l.a(this.context, multiInstanceClientInitState.context) && l.a(this.name, multiInstanceClientInitState.name) && l.a(this.serviceIntent, multiInstanceClientInitState.serviceIntent);
        }

        public final Context getContext() {
            return this.context;
        }

        public final String getName() {
            return this.name;
        }

        public final Intent getServiceIntent() {
            return this.serviceIntent;
        }

        public int hashCode() {
            return this.serviceIntent.hashCode() + androidx.lifecycle.l.o(this.context.hashCode() * 31, 31, this.name);
        }

        public String toString() {
            return "MultiInstanceClientInitState(context=" + this.context + ", name=" + this.name + ", serviceIntent=" + this.serviceIntent + ')';
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        roomDatabase.getClass();
        map.getClass();
        map2.getClass();
        strArr.getClass();
        this.database = roomDatabase;
        this.shadowTablesMap = map;
        this.viewTables = map2;
        this.tableNames = strArr;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = new TriggerBasedInvalidationTracker(roomDatabase, map, map2, strArr, roomDatabase.getUseTempTrackingTable$room_runtime_release(), new InvalidationTracker$implementation$1(this));
        this.implementation = triggerBasedInvalidationTracker;
        this.observerMap = new LinkedHashMap();
        this.observerMapLock = new ReentrantLock();
        final int i = 0;
        this.onRefreshScheduled = new d7.a(this) { // from class: androidx.room.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InvalidationTracker f485b;

            {
                this.f485b = this;
            }

            @Override // d7.a
            public final Object invoke() {
                x onRefreshScheduled$lambda$0;
                x onRefreshCompleted$lambda$1;
                boolean _init_$lambda$2;
                switch (i) {
                    case 0:
                        onRefreshScheduled$lambda$0 = InvalidationTracker.onRefreshScheduled$lambda$0(this.f485b);
                        return onRefreshScheduled$lambda$0;
                    case 1:
                        onRefreshCompleted$lambda$1 = InvalidationTracker.onRefreshCompleted$lambda$1(this.f485b);
                        return onRefreshCompleted$lambda$1;
                    default:
                        _init_$lambda$2 = InvalidationTracker._init_$lambda$2(this.f485b);
                        return Boolean.valueOf(_init_$lambda$2);
                }
            }
        };
        final int i6 = 1;
        this.onRefreshCompleted = new d7.a(this) { // from class: androidx.room.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InvalidationTracker f485b;

            {
                this.f485b = this;
            }

            @Override // d7.a
            public final Object invoke() {
                x onRefreshScheduled$lambda$0;
                x onRefreshCompleted$lambda$1;
                boolean _init_$lambda$2;
                switch (i6) {
                    case 0:
                        onRefreshScheduled$lambda$0 = InvalidationTracker.onRefreshScheduled$lambda$0(this.f485b);
                        return onRefreshScheduled$lambda$0;
                    case 1:
                        onRefreshCompleted$lambda$1 = InvalidationTracker.onRefreshCompleted$lambda$1(this.f485b);
                        return onRefreshCompleted$lambda$1;
                    default:
                        _init_$lambda$2 = InvalidationTracker._init_$lambda$2(this.f485b);
                        return Boolean.valueOf(_init_$lambda$2);
                }
            }
        };
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(roomDatabase);
        this.trackerLock = new Object();
        final int i10 = 2;
        triggerBasedInvalidationTracker.setOnAllowRefresh$room_runtime_release(new d7.a(this) { // from class: androidx.room.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ InvalidationTracker f485b;

            {
                this.f485b = this;
            }

            @Override // d7.a
            public final Object invoke() {
                x onRefreshScheduled$lambda$0;
                x onRefreshCompleted$lambda$1;
                boolean _init_$lambda$2;
                switch (i10) {
                    case 0:
                        onRefreshScheduled$lambda$0 = InvalidationTracker.onRefreshScheduled$lambda$0(this.f485b);
                        return onRefreshScheduled$lambda$0;
                    case 1:
                        onRefreshCompleted$lambda$1 = InvalidationTracker.onRefreshCompleted$lambda$1(this.f485b);
                        return onRefreshCompleted$lambda$1;
                    default:
                        _init_$lambda$2 = InvalidationTracker._init_$lambda$2(this.f485b);
                        return Boolean.valueOf(_init_$lambda$2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$2(InvalidationTracker invalidationTracker) {
        return !invalidationTracker.database.inCompatibilityMode$room_runtime_release() || invalidationTracker.database.isOpenInternal();
    }

    private final boolean addObserverOnly(Observer observer) {
        i validateTableNames$room_runtime_release = this.implementation.validateTableNames$room_runtime_release(observer.getTables$room_runtime_release());
        String[] strArr = (String[]) validateTableNames$room_runtime_release.f8441a;
        int[] iArr = (int[]) validateTableNames$room_runtime_release.f8442b;
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, iArr, strArr);
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            boolean containsKey = this.observerMap.containsKey(observer);
            Map<Observer, ObserverWrapper> map = this.observerMap;
            ObserverWrapper put = containsKey ? (ObserverWrapper) a0.g0(map, observer) : map.put(observer, observerWrapper);
            reentrantLock.unlock();
            return put == null && this.implementation.onObserverAdded$room_runtime_release(iArr);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static /* synthetic */ h createFlow$default(InvalidationTracker invalidationTracker, String[] strArr, boolean z9, int i, Object obj) {
        if (obj != null) {
            a3.b.r("Super calls with default arguments not supported in this target, function: createFlow");
            return null;
        }
        if ((i & 2) != 0) {
            z9 = true;
        }
        return invalidationTracker.createFlow(strArr, z9);
    }

    private final List<Observer> getAllObservers() {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            return q6.l.G0(this.observerMap.keySet());
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyInvalidatedObservers(Set<Integer> set) {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            List G0 = q6.l.G0(this.observerMap.values());
            reentrantLock.unlock();
            Iterator it = G0.iterator();
            while (it.hasNext()) {
                ((ObserverWrapper) it.next()).notifyByTableIds$room_runtime_release(set);
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAutoCloseCallback() {
        synchronized (this.trackerLock) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
                if (multiInstanceInvalidationClient != null) {
                    List<Observer> allObservers = getAllObservers();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : allObservers) {
                        if (!((Observer) obj).isRemote$room_runtime_release()) {
                            arrayList.add(obj);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        multiInstanceInvalidationClient.stop();
                    }
                }
                this.implementation.resetSync$room_runtime_release();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x onRefreshCompleted$lambda$1(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser = invalidationTracker.autoCloser;
        if (autoCloser != null) {
            autoCloser.decrementCountAndScheduleClose();
        }
        return x.f8463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x onRefreshScheduled$lambda$0(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser = invalidationTracker.autoCloser;
        if (autoCloser != null) {
            autoCloser.incrementCountAndEnsureDbIsOpen();
        }
        return x.f8463a;
    }

    private final boolean removeObserverOnly(Observer observer) {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            ObserverWrapper remove = this.observerMap.remove(observer);
            return remove != null && this.implementation.onObserverRemoved$room_runtime_release(remove.getTableIds$room_runtime_release());
        } finally {
            reentrantLock.unlock();
        }
    }

    @WorkerThread
    public void addObserver(Observer observer) {
        observer.getClass();
        if (addObserverOnly(observer)) {
            RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new InvalidationTracker$addObserver$1(this, null));
        }
    }

    public final void addRemoteObserver$room_runtime_release(Observer observer) {
        observer.getClass();
        if (observer.isRemote$room_runtime_release()) {
            addObserverOnly(observer);
        } else {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("isRemote was false of observer argument");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @WorkerThread
    public void addWeakObserver(Observer observer) {
        observer.getClass();
        addObserver(new WeakObserver(this, observer));
    }

    public final h createFlow(String[] strArr, boolean z9) {
        strArr.getClass();
        i validateTableNames$room_runtime_release = this.implementation.validateTableNames$room_runtime_release(strArr);
        String[] strArr2 = (String[]) validateTableNames$room_runtime_release.f8441a;
        h createFlow$room_runtime_release = this.implementation.createFlow$room_runtime_release(strArr2, (int[]) validateTableNames$room_runtime_release.f8442b, z9);
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
        h createFlow = multiInstanceInvalidationClient != null ? multiInstanceInvalidationClient.createFlow(strArr2) : null;
        if (createFlow == null) {
            return createFlow$room_runtime_release;
        }
        h[] hVarArr = {createFlow$room_runtime_release, createFlow};
        int i = w.f9071a;
        return new r7.d(new k(hVarArr, 1), t6.i.f10314a, -2, q7.a.f8729a, 2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] strArr, boolean z9, Callable<T> callable) {
        strArr.getClass();
        callable.getClass();
        this.implementation.validateTableNames$room_runtime_release(strArr);
        return this.invalidationLiveDataContainer.create(strArr, z9, callable);
    }

    public final RoomDatabase getDatabase$room_runtime_release() {
        return this.database;
    }

    public final String[] getTableNames$room_runtime_release() {
        return this.tableNames;
    }

    public final void initMultiInstanceInvalidation$room_runtime_release(Context context, String str, Intent intent) {
        context.getClass();
        str.getClass();
        intent.getClass();
        this.multiInstanceInvalidationIntent = intent;
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, str, this);
    }

    public final void internalInit$room_runtime_release(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        this.implementation.configureConnection(sQLiteConnection);
        synchronized (this.trackerLock) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
                if (multiInstanceInvalidationClient != null) {
                    Intent intent = this.multiInstanceInvalidationIntent;
                    if (intent == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    multiInstanceInvalidationClient.start(intent);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void notifyObserversByTableNames$room_runtime_release(Set<String> set) {
        set.getClass();
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            List<ObserverWrapper> G0 = q6.l.G0(this.observerMap.values());
            reentrantLock.unlock();
            for (ObserverWrapper observerWrapper : G0) {
                if (!observerWrapper.getObserver$room_runtime_release().isRemote$room_runtime_release()) {
                    observerWrapper.notifyByTableNames$room_runtime_release(set);
                }
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Object refresh(String[] strArr, t6.c cVar) {
        return this.implementation.refreshInvalidation$room_runtime_release(strArr, this.onRefreshScheduled, this.onRefreshCompleted, cVar);
    }

    public final void refreshAsync() {
        this.implementation.refreshInvalidationAsync$room_runtime_release(this.onRefreshScheduled, this.onRefreshCompleted);
    }

    public void refreshVersionsAsync() {
        this.implementation.refreshInvalidationAsync$room_runtime_release(this.onRefreshScheduled, this.onRefreshCompleted);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @WorkerThread
    public void refreshVersionsSync() {
        RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new InvalidationTracker$refreshVersionsSync$1(this, null));
    }

    @WorkerThread
    public void removeObserver(Observer observer) {
        observer.getClass();
        if (removeObserverOnly(observer)) {
            RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new InvalidationTracker$removeObserver$1(this, null));
        }
    }

    public final void setAutoCloser$room_runtime_release(AutoCloser autoCloser) {
        autoCloser.getClass();
        this.autoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new InvalidationTracker$setAutoCloser$1(this));
    }

    public final void stop$room_runtime_release() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.stop();
        }
    }

    public final Object sync$room_runtime_release(t6.c cVar) {
        boolean inCompatibilityMode$room_runtime_release = this.database.inCompatibilityMode$room_runtime_release();
        x xVar = x.f8463a;
        if (inCompatibilityMode$room_runtime_release && !this.database.isOpenInternal()) {
            return xVar;
        }
        Object syncTriggers$room_runtime_release = this.implementation.syncTriggers$room_runtime_release(cVar);
        return syncTriggers$room_runtime_release == u6.a.f10762a ? syncTriggers$room_runtime_release : xVar;
    }

    @WorkerThread
    public final void syncBlocking$room_runtime_release() {
        RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new InvalidationTracker$syncBlocking$1(this, null));
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] strArr, Callable<T> callable) {
        strArr.getClass();
        callable.getClass();
        return createLiveData(strArr, false, (Callable) callable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final <T> LiveData<T> createLiveData(String[] strArr, boolean z9, d7.l lVar) {
        strArr.getClass();
        lVar.getClass();
        this.implementation.validateTableNames$room_runtime_release(strArr);
        return this.invalidationLiveDataContainer.create(strArr, z9, lVar);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class Observer {
        private final String[] tables;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public Observer(java.lang.String r3, java.lang.String... r4) {
            /*
                r2 = this;
                r3.getClass()
                r4.getClass()
                java.util.ArrayList r0 = new java.util.ArrayList
                r1 = 2
                r0.<init>(r1)
                r0.add(r3)
                int r3 = r4.length
                if (r3 <= 0) goto L1e
                int r3 = r0.size()
                int r1 = r4.length
                int r3 = r3 + r1
                r0.ensureCapacity(r3)
                java.util.Collections.addAll(r0, r4)
            L1e:
                int r3 = r0.size()
                java.lang.String[] r3 = new java.lang.String[r3]
                java.lang.Object[] r3 = r0.toArray(r3)
                java.lang.String[] r3 = (java.lang.String[]) r3
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker.Observer.<init>(java.lang.String, java.lang.String[]):void");
        }

        public final String[] getTables$room_runtime_release() {
            return this.tables;
        }

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(Set<String> set);

        public Observer(String[] strArr) {
            strArr.getClass();
            this.tables = strArr;
        }
    }

    public final h createFlow(String... strArr) {
        strArr.getClass();
        return createFlow$default(this, strArr, false, 2, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public InvalidationTracker(androidx.room.RoomDatabase r2, java.lang.String... r3) {
        /*
            r1 = this;
            r2.getClass()
            r3.getClass()
            int r0 = r3.length
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r0)
            java.lang.String[] r3 = (java.lang.String[]) r3
            q6.u r0 = q6.u.f8725a
            r1.<init>(r2, r0, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker.<init>(androidx.room.RoomDatabase, java.lang.String[]):void");
    }
}
