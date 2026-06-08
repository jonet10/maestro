package androidx.room;

import androidx.annotation.MainThread;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import java.util.concurrent.atomic.AtomicBoolean;
import o7.c0;
import t6.h;
import t6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class RoomTrackingLiveData<T> extends LiveData<T> {
    private final AtomicBoolean computing;
    private final InvalidationLiveDataContainer container;
    private final RoomDatabase database;
    private final boolean inTransaction;
    private final AtomicBoolean invalid;
    private final h launchContext;
    private final InvalidationTracker.Observer observer;
    private final AtomicBoolean registeredObserver;

    private RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z9, String[] strArr) {
        this.database = roomDatabase;
        this.container = invalidationLiveDataContainer;
        this.inTransaction = z9;
        this.observer = new RoomTrackingLiveData$observer$1(strArr, this);
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.registeredObserver = new AtomicBoolean(false);
        this.launchContext = roomDatabase.inCompatibilityMode$room_runtime_release() ? z9 ? roomDatabase.getTransactionContext$room_runtime_release() : roomDatabase.getQueryContext() : i.f10314a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void invalidated() {
        boolean hasActiveObservers = hasActiveObservers();
        if (this.invalid.compareAndSet(false, true) && hasActiveObservers) {
            c0.s(this.database.getCoroutineScope(), this.launchContext, null, new RoomTrackingLiveData$invalidated$1(this, null), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0064 A[Catch: all -> 0x002f, Exception -> 0x0031, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0031, blocks: (B:11:0x0028, B:16:0x0064), top: B:10:0x0028, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0080 A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #1 {all -> 0x002f, blocks: (B:11:0x0028, B:14:0x005c, B:16:0x0064, B:26:0x0080, B:39:0x0076, B:40:0x007d), top: B:10:0x0028, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0059 -> B:13:0x005c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x008f -> B:25:0x0091). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refresh(t6.c r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.room.RoomTrackingLiveData$refresh$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.room.RoomTrackingLiveData$refresh$1 r0 = (androidx.room.RoomTrackingLiveData$refresh$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.RoomTrackingLiveData$refresh$1 r0 = new androidx.room.RoomTrackingLiveData$refresh$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L3a
            if (r1 != r3) goto L33
            int r1 = r0.I$0
            java.lang.Object r4 = r0.L$0
            androidx.room.RoomTrackingLiveData r4 = (androidx.room.RoomTrackingLiveData) r4
            p6.a.e(r8)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r6 = r1
            r1 = r8
            r8 = r6
            goto L5c
        L2f:
            r8 = move-exception
            goto L89
        L31:
            r8 = move-exception
            goto L76
        L33:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r8)
            r8 = 0
            return r8
        L3a:
            p6.a.e(r8)
            java.util.concurrent.atomic.AtomicBoolean r8 = r7.registeredObserver
            boolean r8 = r8.compareAndSet(r2, r3)
            if (r8 == 0) goto L50
            androidx.room.RoomDatabase r8 = r7.database
            androidx.room.InvalidationTracker r8 = r8.getInvalidationTracker()
            androidx.room.InvalidationTracker$Observer r1 = r7.observer
            r8.addWeakObserver(r1)
        L50:
            r8 = r7
        L51:
            java.util.concurrent.atomic.AtomicBoolean r1 = r8.computing
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L8f
            r1 = 0
            r4 = r8
            r8 = r2
        L5c:
            java.util.concurrent.atomic.AtomicBoolean r5 = r4.invalid     // Catch: java.lang.Throwable -> L2f
            boolean r5 = r5.compareAndSet(r3, r2)     // Catch: java.lang.Throwable -> L2f
            if (r5 == 0) goto L7e
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r0.label = r3     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            java.lang.Object r8 = r4.compute(r0)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            u6.a r1 = u6.a.f10762a
            if (r8 != r1) goto L73
            return r1
        L73:
            r1 = r8
            r8 = r3
            goto L5c
        L76:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L2f
            java.lang.String r1 = "Exception while computing database live data."
            r0.<init>(r1, r8)     // Catch: java.lang.Throwable -> L2f
            throw r0     // Catch: java.lang.Throwable -> L2f
        L7e:
            if (r8 == 0) goto L83
            r4.postValue(r1)     // Catch: java.lang.Throwable -> L2f
        L83:
            java.util.concurrent.atomic.AtomicBoolean r1 = r4.computing
            r1.set(r2)
            goto L91
        L89:
            java.util.concurrent.atomic.AtomicBoolean r0 = r4.computing
            r0.set(r2)
            throw r8
        L8f:
            r4 = r8
            r8 = r2
        L91:
            if (r8 == 0) goto L9e
            java.util.concurrent.atomic.AtomicBoolean r8 = r4.invalid
            boolean r8 = r8.get()
            if (r8 != 0) goto L9c
            goto L9e
        L9c:
            r8 = r4
            goto L51
        L9e:
            p6.x r8 = p6.x.f8463a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomTrackingLiveData.refresh(t6.c):java.lang.Object");
    }

    public abstract Object compute(t6.c cVar);

    public final RoomDatabase getDatabase() {
        return this.database;
    }

    public final boolean getInTransaction() {
        return this.inTransaction;
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        this.container.onActive(this);
        c0.s(this.database.getCoroutineScope(), this.launchContext, null, new RoomTrackingLiveData$onActive$1(this, null), 2);
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        this.container.onInactive(this);
    }

    public /* synthetic */ RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z9, String[] strArr, kotlin.jvm.internal.g gVar) {
        this(roomDatabase, invalidationLiveDataContainer, z9, strArr);
    }
}
