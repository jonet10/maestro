package androidx.datastore.core;

import androidx.datastore.core.Message;
import androidx.datastore.core.UpdatingDataContextElement;
import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import d7.p;
import java.util.List;
import kotlin.jvm.internal.g;
import o7.a0;
import o7.c0;
import o7.e1;
import p6.f;
import p6.m;
import q6.l;
import q6.t;
import r7.f0;
import r7.h;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreImpl<T> implements DataStore<T> {
    private static final String BUG_MESSAGE = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542";
    public static final Companion Companion = new Companion(null);
    private int collectorCounter;
    private e1 collectorJob;
    private final x7.a collectorMutex;
    private final f coordinator$delegate;
    private final CorruptionHandler<T> corruptionHandler;
    private final h data;
    private final DataStoreInMemoryCache<T> inMemoryCache;
    private final DataStoreImpl<T>.InitDataStore readAndInit;
    private final a0 scope;
    private final Storage<T> storage;
    private final f storageConnectionDelegate;
    private final SimpleActor<Message.Update<T>> writeActor;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public final class InitDataStore extends RunOnce {
        private List<? extends p> initTasks;
        final /* synthetic */ DataStoreImpl<T> this$0;

        public InitDataStore(DataStoreImpl dataStoreImpl, List<? extends p> list) {
            list.getClass();
            this.this$0 = dataStoreImpl;
            this.initTasks = l.G0(list);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        @Override // androidx.datastore.core.RunOnce
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object doRun(t6.c r7) {
            /*
                r6 = this;
                boolean r0 = r7 instanceof androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1
                if (r0 == 0) goto L13
                r0 = r7
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1 r0 = (androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1 r0 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$1
                r0.<init>(r6, r7)
            L18:
                java.lang.Object r7 = r0.result
                int r1 = r0.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L3b
                if (r1 == r3) goto L33
                if (r1 != r2) goto L2c
                java.lang.Object r0 = r0.L$0
                androidx.datastore.core.DataStoreImpl$InitDataStore r0 = (androidx.datastore.core.DataStoreImpl.InitDataStore) r0
                p6.a.e(r7)
                goto L68
            L2c:
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                androidx.privacysandbox.ads.adservices.customaudience.a.i(r7)
                r7 = 0
                return r7
            L33:
                java.lang.Object r0 = r0.L$0
                androidx.datastore.core.DataStoreImpl$InitDataStore r0 = (androidx.datastore.core.DataStoreImpl.InitDataStore) r0
                p6.a.e(r7)
                goto L7a
            L3b:
                p6.a.e(r7)
                java.util.List<? extends d7.p> r7 = r6.initTasks
                u6.a r1 = u6.a.f10762a
                if (r7 == 0) goto L6b
                r7.getClass()
                boolean r7 = r7.isEmpty()
                if (r7 == 0) goto L4e
                goto L6b
            L4e:
                androidx.datastore.core.DataStoreImpl<T> r7 = r6.this$0
                androidx.datastore.core.InterProcessCoordinator r7 = androidx.datastore.core.DataStoreImpl.access$getCoordinator(r7)
                androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1 r3 = new androidx.datastore.core.DataStoreImpl$InitDataStore$doRun$initData$1
                androidx.datastore.core.DataStoreImpl<T> r4 = r6.this$0
                r5 = 0
                r3.<init>(r4, r6, r5)
                r0.L$0 = r6
                r0.label = r2
                java.lang.Object r7 = r7.lock(r3, r0)
                if (r7 != r1) goto L67
                goto L78
            L67:
                r0 = r6
            L68:
                androidx.datastore.core.Data r7 = (androidx.datastore.core.Data) r7
                goto L7c
            L6b:
                androidx.datastore.core.DataStoreImpl<T> r7 = r6.this$0
                r0.L$0 = r6
                r0.label = r3
                r2 = 0
                java.lang.Object r7 = androidx.datastore.core.DataStoreImpl.access$readDataOrHandleCorruption(r7, r2, r0)
                if (r7 != r1) goto L79
            L78:
                return r1
            L79:
                r0 = r6
            L7a:
                androidx.datastore.core.Data r7 = (androidx.datastore.core.Data) r7
            L7c:
                androidx.datastore.core.DataStoreImpl<T> r0 = r0.this$0
                androidx.datastore.core.DataStoreInMemoryCache r0 = androidx.datastore.core.DataStoreImpl.access$getInMemoryCache$p(r0)
                r0.tryUpdate(r7)
                p6.x r7 = p6.x.f8463a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.InitDataStore.doRun(t6.c):java.lang.Object");
        }
    }

    public DataStoreImpl(Storage<T> storage, List<? extends p> list, CorruptionHandler<T> corruptionHandler, a0 a0Var) {
        storage.getClass();
        list.getClass();
        corruptionHandler.getClass();
        a0Var.getClass();
        this.storage = storage;
        this.corruptionHandler = corruptionHandler;
        this.scope = a0Var;
        this.data = new f0(new DataStoreImpl$data$1(this, null));
        this.collectorMutex = x7.h.a();
        this.inMemoryCache = new DataStoreInMemoryCache<>();
        this.readAndInit = new InitDataStore(this, list);
        this.storageConnectionDelegate = new m(new DataStoreImpl$storageConnectionDelegate$1(this));
        this.coordinator$delegate = new m(new DataStoreImpl$coordinator$2(this));
        this.writeActor = new SimpleActor<>(a0Var, new DataStoreImpl$writeActor$1(this), DataStoreImpl$writeActor$2.INSTANCE, new DataStoreImpl$writeActor$3(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0052 A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:11:0x004a, B:13:0x0052, B:15:0x0056, B:16:0x005c), top: B:10:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object decrementCollector(t6.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.DataStoreImpl$decrementCollector$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.datastore.core.DataStoreImpl$decrementCollector$1 r0 = (androidx.datastore.core.DataStoreImpl$decrementCollector$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.DataStoreImpl$decrementCollector$1 r0 = new androidx.datastore.core.DataStoreImpl$decrementCollector$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2e
            java.lang.Object r1 = r0.L$1
            x7.a r1 = (x7.a) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            p6.a.e(r5)
            goto L4a
        L2e:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            r5 = 0
            return r5
        L35:
            p6.a.e(r5)
            x7.a r1 = r4.collectorMutex
            r0.L$0 = r4
            r0.L$1 = r1
            r0.label = r2
            java.lang.Object r5 = r1.lock(r3, r0)
            u6.a r0 = u6.a.f10762a
            if (r5 != r0) goto L49
            return r0
        L49:
            r0 = r4
        L4a:
            int r5 = r0.collectorCounter     // Catch: java.lang.Throwable -> L5a
            int r5 = r5 + (-1)
            r0.collectorCounter = r5     // Catch: java.lang.Throwable -> L5a
            if (r5 != 0) goto L5e
            o7.e1 r5 = r0.collectorJob     // Catch: java.lang.Throwable -> L5a
            if (r5 == 0) goto L5c
            r5.c(r3)     // Catch: java.lang.Throwable -> L5a
            goto L5c
        L5a:
            r5 = move-exception
            goto L64
        L5c:
            r0.collectorJob = r3     // Catch: java.lang.Throwable -> L5a
        L5e:
            r1.unlock(r3)
            p6.x r5 = p6.x.f8463a
            return r5
        L64:
            r1.unlock(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.decrementCollector(t6.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> Object doWithWriteFileLock(boolean z9, d7.l lVar, c cVar) {
        return z9 ? lVar.invoke(cVar) : getCoordinator().lock(new DataStoreImpl$doWithWriteFileLock$3(lVar, null), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterProcessCoordinator getCoordinator() {
        return (InterProcessCoordinator) this.coordinator$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00af, code lost:
    
        if (r9 != r5) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0023 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleUpdate(androidx.datastore.core.Message.Update<T> r9, t6.c r10) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.handleUpdate(androidx.datastore.core.Message$Update, t6.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0051 A[Catch: all -> 0x0060, TRY_LEAVE, TryCatch #0 {all -> 0x0060, blocks: (B:11:0x004a, B:13:0x0051), top: B:10:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object incrementCollector(t6.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.DataStoreImpl$incrementCollector$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.core.DataStoreImpl$incrementCollector$1 r0 = (androidx.datastore.core.DataStoreImpl$incrementCollector$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.DataStoreImpl$incrementCollector$1 r0 = new androidx.datastore.core.DataStoreImpl$incrementCollector$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2e
            java.lang.Object r1 = r0.L$1
            x7.a r1 = (x7.a) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            p6.a.e(r6)
            goto L4a
        L2e:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            r6 = 0
            return r6
        L35:
            p6.a.e(r6)
            x7.a r1 = r5.collectorMutex
            r0.L$0 = r5
            r0.L$1 = r1
            r0.label = r2
            java.lang.Object r6 = r1.lock(r3, r0)
            u6.a r0 = u6.a.f10762a
            if (r6 != r0) goto L49
            return r0
        L49:
            r0 = r5
        L4a:
            int r6 = r0.collectorCounter     // Catch: java.lang.Throwable -> L60
            int r6 = r6 + r2
            r0.collectorCounter = r6     // Catch: java.lang.Throwable -> L60
            if (r6 != r2) goto L62
            o7.a0 r6 = r0.scope     // Catch: java.lang.Throwable -> L60
            androidx.datastore.core.DataStoreImpl$incrementCollector$2$1 r2 = new androidx.datastore.core.DataStoreImpl$incrementCollector$2$1     // Catch: java.lang.Throwable -> L60
            r2.<init>(r0, r3)     // Catch: java.lang.Throwable -> L60
            r4 = 3
            o7.s1 r6 = o7.c0.s(r6, r3, r3, r2, r4)     // Catch: java.lang.Throwable -> L60
            r0.collectorJob = r6     // Catch: java.lang.Throwable -> L60
            goto L62
        L60:
            r6 = move-exception
            goto L68
        L62:
            r1.unlock(r3)
            p6.x r6 = p6.x.f8463a
            return r6
        L68:
            r1.unlock(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.incrementCollector(t6.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        if (r3.runIfNeeded(r0) != r4) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readAndInitOrPropagateAndThrowFailure(t6.c r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.DataStoreImpl$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 2
            r3 = 1
            u6.a r4 = u6.a.f10762a
            if (r1 == 0) goto L41
            if (r1 == r3) goto L39
            if (r1 != r2) goto L32
            int r1 = r0.I$0
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.DataStoreImpl r0 = (androidx.datastore.core.DataStoreImpl) r0
            p6.a.e(r7)     // Catch: java.lang.Throwable -> L30
            goto L69
        L30:
            r7 = move-exception
            goto L71
        L32:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r7)
            r7 = 0
            return r7
        L39:
            java.lang.Object r1 = r0.L$0
            androidx.datastore.core.DataStoreImpl r1 = (androidx.datastore.core.DataStoreImpl) r1
            p6.a.e(r7)
            goto L54
        L41:
            p6.a.e(r7)
            androidx.datastore.core.InterProcessCoordinator r7 = r6.getCoordinator()
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.getVersion(r0)
            if (r7 != r4) goto L53
            goto L68
        L53:
            r1 = r6
        L54:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            androidx.datastore.core.DataStoreImpl<T>$InitDataStore r3 = r1.readAndInit     // Catch: java.lang.Throwable -> L6c
            r0.L$0 = r1     // Catch: java.lang.Throwable -> L6c
            r0.I$0 = r7     // Catch: java.lang.Throwable -> L6c
            r0.label = r2     // Catch: java.lang.Throwable -> L6c
            java.lang.Object r7 = r3.runIfNeeded(r0)     // Catch: java.lang.Throwable -> L6c
            if (r7 != r4) goto L69
        L68:
            return r4
        L69:
            p6.x r7 = p6.x.f8463a
            return r7
        L6c:
            r0 = move-exception
            r5 = r1
            r1 = r7
            r7 = r0
            r0 = r5
        L71:
            androidx.datastore.core.DataStoreInMemoryCache<T> r0 = r0.inMemoryCache
            androidx.datastore.core.ReadException r2 = new androidx.datastore.core.ReadException
            r2.<init>(r7, r1)
            r0.tryUpdate(r2)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readAndInitOrPropagateAndThrowFailure(t6.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a4, code lost:
    
        if (r11 == r5) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bd, code lost:
    
        if (r11 == r5) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readDataAndUpdateCache(boolean r10, t6.c r11) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readDataAndUpdateCache(boolean, t6.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readDataFromFileOrDefault(c cVar) {
        return StorageConnectionKt.readData(getStorageConnection$datastore_core_release(), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:0|1|(2:3|(4:5|6|7|8))|83|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0060, code lost:
    
        r11 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0061, code lost:
    
        r7 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readDataOrHandleCorruption(boolean r10, t6.c r11) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.readDataOrHandleCorruption(boolean, t6.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readState(boolean z9, c cVar) {
        return c0.C(new DataStoreImpl$readState$2(this, z9, null), this.scope.getCoroutineContext(), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object transformAndWrite(p pVar, t6.h hVar, c cVar) {
        return getCoordinator().lock(new DataStoreImpl$transformAndWrite$2(this, hVar, pVar, null), cVar);
    }

    @Override // androidx.datastore.core.DataStore
    public h getData() {
        return this.data;
    }

    public final StorageConnection<T> getStorageConnection$datastore_core_release() {
        return (StorageConnection) this.storageConnectionDelegate.getValue();
    }

    @Override // androidx.datastore.core.DataStore
    public Object updateData(p pVar, c cVar) {
        UpdatingDataContextElement updatingDataContextElement = (UpdatingDataContextElement) cVar.getContext().get(UpdatingDataContextElement.Companion.Key.INSTANCE);
        if (updatingDataContextElement != null) {
            updatingDataContextElement.checkNotUpdating(this);
        }
        return c0.C(new DataStoreImpl$updateData$2(this, pVar, null), new UpdatingDataContextElement(updatingDataContextElement, this), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeData$datastore_core_release(T r10, boolean r11, t6.c r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof androidx.datastore.core.DataStoreImpl$writeData$1
            if (r0 == 0) goto L13
            r0 = r12
            androidx.datastore.core.DataStoreImpl$writeData$1 r0 = (androidx.datastore.core.DataStoreImpl$writeData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.DataStoreImpl$writeData$1 r0 = new androidx.datastore.core.DataStoreImpl$writeData$1
            r0.<init>(r9, r12)
        L18:
            java.lang.Object r12 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            java.lang.Object r10 = r0.L$0
            kotlin.jvm.internal.v r10 = (kotlin.jvm.internal.v) r10
            p6.a.e(r12)
            goto L53
        L29:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r10)
            r10 = 0
            return r10
        L30:
            p6.a.e(r12)
            kotlin.jvm.internal.v r4 = new kotlin.jvm.internal.v
            r4.<init>()
            androidx.datastore.core.StorageConnection r12 = r9.getStorageConnection$datastore_core_release()
            androidx.datastore.core.DataStoreImpl$writeData$2 r3 = new androidx.datastore.core.DataStoreImpl$writeData$2
            r8 = 0
            r5 = r9
            r6 = r10
            r7 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r0.L$0 = r4
            r0.label = r2
            java.lang.Object r10 = r12.writeScope(r3, r0)
            u6.a r11 = u6.a.f10762a
            if (r10 != r11) goto L52
            return r11
        L52:
            r10 = r4
        L53:
            int r10 = r10.f7022a
            java.lang.Integer r11 = new java.lang.Integer
            r11.<init>(r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl.writeData$datastore_core_release(java.lang.Object, boolean, t6.c):java.lang.Object");
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ DataStoreImpl(Storage storage, List list, CorruptionHandler corruptionHandler, a0 a0Var, int i, g gVar) {
        this(storage, (i & 2) != 0 ? t.f8724a : list, (i & 4) != 0 ? new NoOpCorruptionHandler() : corruptionHandler, (i & 8) != 0 ? c0.b(Actual_jvmKt.ioDispatcher().plus(c0.d())) : a0Var);
    }
}
