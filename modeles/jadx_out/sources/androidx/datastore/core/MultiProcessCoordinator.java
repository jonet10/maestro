package androidx.datastore.core;

import d7.p;
import java.io.File;
import kotlin.jvm.internal.g;
import o7.c0;
import p6.f;
import p6.m;
import s1.o;
import t6.c;
import t6.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MultiProcessCoordinator implements InterProcessCoordinator {
    public static final Companion Companion = new Companion(null);
    private static final String DEADLOCK_ERROR_MESSAGE = "Resource deadlock would occur";
    private static final long INITIAL_WAIT_MILLIS = 10;
    private static final long MAX_WAIT_MILLIS = 60000;
    private final String LOCK_ERROR_MESSAGE;
    private final String LOCK_SUFFIX;
    private final String VERSION_SUFFIX;
    private final h context;
    private final File file;
    private final x7.a inMemoryMutex;
    private final f lazySharedCounter;
    private final f lockFile$delegate;
    private final r7.h updateNotifications;

    public MultiProcessCoordinator(h hVar, File file) {
        hVar.getClass();
        file.getClass();
        this.context = hVar;
        this.file = file;
        this.updateNotifications = MulticastFileObserver.Companion.observe(file);
        this.LOCK_SUFFIX = ".lock";
        this.VERSION_SUFFIX = ".version";
        this.LOCK_ERROR_MESSAGE = "fcntl failed: EAGAIN";
        this.inMemoryMutex = x7.h.a();
        this.lockFile$delegate = new m(new MultiProcessCoordinator$lockFile$2(this));
        this.lazySharedCounter = new m(new MultiProcessCoordinator$lazySharedCounter$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createIfNotExists(File file) {
        createParentDirectories(file);
        if (file.exists()) {
            return;
        }
        file.createNewFile();
    }

    private final void createParentDirectories(File file) {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (parentFile.isDirectory()) {
                return;
            }
            o.k(file, "Unable to create parent directories of ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File fileWithSuffix(String str) {
        return new File(this.file.getAbsolutePath() + str);
    }

    private final File getLockFile() {
        return (File) this.lockFile$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedCounter getSharedCounter() {
        return (SharedCounter) this.lazySharedCounter.getValue();
    }

    private final <T> Object withLazyCounter(p pVar, c cVar) {
        if (this.lazySharedCounter.isInitialized()) {
            return pVar.invoke(getSharedCounter(), cVar);
        }
        return c0.C(new MultiProcessCoordinator$withLazyCounter$2(pVar, this, null), this.context, cVar);
    }

    public final File getFile() {
        return this.file;
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public r7.h getUpdateNotifications() {
        return this.updateNotifications;
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object getVersion(c cVar) {
        if (this.lazySharedCounter.isInitialized()) {
            return new Integer(getSharedCounter().getValue());
        }
        return c0.C(new MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(this, null), this.context, cVar);
    }

    @Override // androidx.datastore.core.InterProcessCoordinator
    public Object incrementAndGetVersion(c cVar) {
        if (this.lazySharedCounter.isInitialized()) {
            return new Integer(getSharedCounter().incrementAndGetValue());
        }
        return c0.C(new MultiProcessCoordinator$incrementAndGetVersion$$inlined$withLazyCounter$1(this, null), this.context, cVar);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b7 A[Catch: all -> 0x00bb, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x00bb, blocks: (B:16:0x00b7, B:30:0x00d4, B:31:0x00d7), top: B:7:0x0022, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d4 A[Catch: all -> 0x00bb, TRY_ENTER, TryCatch #4 {all -> 0x00bb, blocks: (B:16:0x00b7, B:30:0x00d4, B:31:0x00d7), top: B:7:0x0022, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [x7.a] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.Closeable] */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> java.lang.Object lock(d7.l r9, t6.c r10) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.lock(d7.l, t6.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e1 A[Catch: all -> 0x00e5, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x00e5, blocks: (B:15:0x00e1, B:24:0x00fc, B:25:0x00ff), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00fc A[Catch: all -> 0x00e5, TRY_ENTER, TryCatch #3 {all -> 0x00e5, blocks: (B:15:0x00e1, B:24:0x00fc, B:25:0x00ff), top: B:7:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /* JADX WARN: Type inference failed for: r2v0, types: [d7.p] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.datastore.core.MultiProcessCoordinator$tryLock$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [x7.a] */
    /* JADX WARN: Type inference failed for: r3v6 */
    @Override // androidx.datastore.core.InterProcessCoordinator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> java.lang.Object tryLock(d7.p r19, t6.c r20) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.tryLock(d7.p, t6.c):java.lang.Object");
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0075 -> B:10:0x0078). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object getExclusiveFileLockWithRetryIfDeadlock(java.io.FileOutputStream r12, t6.c r13) {
            /*
                r11 = this;
                boolean r0 = r13 instanceof androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1
                if (r0 == 0) goto L13
                r0 = r13
                androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 r0 = (androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1 r0 = new androidx.datastore.core.MultiProcessCoordinator$Companion$getExclusiveFileLockWithRetryIfDeadlock$1
                r0.<init>(r11, r13)
            L18:
                java.lang.Object r13 = r0.result
                int r1 = r0.label
                r2 = 1
                if (r1 == 0) goto L33
                if (r1 != r2) goto L2c
                long r3 = r0.J$0
                java.lang.Object r12 = r0.L$0
                java.io.FileOutputStream r12 = (java.io.FileOutputStream) r12
                p6.a.e(r13)
                r13 = r0
                goto L78
            L2c:
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                androidx.privacysandbox.ads.adservices.customaudience.a.i(r12)
                r12 = 0
                return r12
            L33:
                p6.a.e(r13)
                long r3 = androidx.datastore.core.MultiProcessCoordinator.access$getINITIAL_WAIT_MILLIS$cp()
                r13 = r0
            L3b:
                long r0 = androidx.datastore.core.MultiProcessCoordinator.access$getMAX_WAIT_MILLIS$cp()
                int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r0 > 0) goto L7d
                java.nio.channels.FileChannel r5 = r12.getChannel()     // Catch: java.io.IOException -> L57
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r10 = 0
                r6 = 0
                java.nio.channels.FileLock r0 = r5.lock(r6, r8, r10)     // Catch: java.io.IOException -> L57
                r0.getClass()     // Catch: java.io.IOException -> L57
                return r0
            L57:
                r0 = move-exception
                java.lang.String r1 = r0.getMessage()
                if (r1 == 0) goto L7c
                java.lang.String r5 = androidx.datastore.core.MultiProcessCoordinator.access$getDEADLOCK_ERROR_MESSAGE$cp()
                r6 = 0
                boolean r1 = l7.m.q0(r1, r5, r6)
                if (r1 != r2) goto L7c
                r13.L$0 = r12
                r13.J$0 = r3
                r13.label = r2
                java.lang.Object r0 = o7.c0.j(r3, r13)
                u6.a r1 = u6.a.f10762a
                if (r0 != r1) goto L78
                return r1
            L78:
                r0 = 2
                long r0 = (long) r0
                long r3 = r3 * r0
                goto L3b
            L7c:
                throw r0
            L7d:
                java.nio.channels.FileChannel r5 = r12.getChannel()
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r10 = 0
                r6 = 0
                java.nio.channels.FileLock r12 = r5.lock(r6, r8, r10)
                r12.getClass()
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MultiProcessCoordinator.Companion.getExclusiveFileLockWithRetryIfDeadlock(java.io.FileOutputStream, t6.c):java.lang.Object");
        }

        private Companion() {
        }
    }
}
