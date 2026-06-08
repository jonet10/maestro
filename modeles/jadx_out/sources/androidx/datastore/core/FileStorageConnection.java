package androidx.datastore.core;

import java.io.File;
import s1.o;
import x7.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FileStorageConnection<T> implements StorageConnection<T> {
    private final java.util.concurrent.atomic.AtomicBoolean closed;
    private final InterProcessCoordinator coordinator;
    private final File file;
    private final d7.a onClose;
    private final Serializer<T> serializer;
    private final x7.a transactionMutex;

    public FileStorageConnection(File file, Serializer<T> serializer, InterProcessCoordinator interProcessCoordinator, d7.a aVar) {
        file.getClass();
        serializer.getClass();
        interProcessCoordinator.getClass();
        aVar.getClass();
        this.file = file;
        this.serializer = serializer;
        this.coordinator = interProcessCoordinator;
        this.onClose = aVar;
        this.closed = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.transactionMutex = h.a();
    }

    private final void checkNotClosed() {
        if (this.closed.get()) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("StorageConnection has already been disposed.");
        }
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

    @Override // androidx.datastore.core.Closeable
    public void close() {
        this.closed.set(true);
        this.onClose.invoke();
    }

    @Override // androidx.datastore.core.StorageConnection
    public InterProcessCoordinator getCoordinator() {
        return this.coordinator;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(2:3|(8:5|6|7|(1:(3:10|11|12)(2:32|33))(7:34|35|36|38|39|40|(1:42)(1:43))|14|15|16|(2:(1:19)|20)(1:22)))|53|6|7|(0)(0)|14|15|16|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006c, code lost:
    
        r1 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0077 A[Catch: all -> 0x0078, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0078, blocks: (B:22:0x0077, B:28:0x0087, B:31:0x0084, B:27:0x007f), top: B:7:0x001e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15, types: [androidx.datastore.core.FileStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.FileStorageConnection$readScope$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.FileStorageConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r7v0, types: [d7.q] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <R> java.lang.Object readScope(d7.q r7, t6.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.datastore.core.FileStorageConnection$readScope$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.datastore.core.FileStorageConnection$readScope$1 r0 = (androidx.datastore.core.FileStorageConnection$readScope$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.FileStorageConnection$readScope$1 r0 = new androidx.datastore.core.FileStorageConnection$readScope$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L39
            if (r1 != r2) goto L32
            boolean r7 = r0.Z$0
            java.lang.Object r1 = r0.L$1
            androidx.datastore.core.Closeable r1 = (androidx.datastore.core.Closeable) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.FileStorageConnection r0 = (androidx.datastore.core.FileStorageConnection) r0
            p6.a.e(r8)     // Catch: java.lang.Throwable -> L30
            goto L67
        L30:
            r8 = move-exception
            goto L7f
        L32:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r7)
            r7 = 0
            return r7
        L39:
            p6.a.e(r8)
            r6.checkNotClosed()
            x7.a r8 = r6.transactionMutex
            boolean r8 = r8.tryLock(r3)
            androidx.datastore.core.FileReadScope r1 = new androidx.datastore.core.FileReadScope     // Catch: java.lang.Throwable -> L88
            java.io.File r4 = r6.file     // Catch: java.lang.Throwable -> L88
            androidx.datastore.core.Serializer<T> r5 = r6.serializer     // Catch: java.lang.Throwable -> L88
            r1.<init>(r4, r5)     // Catch: java.lang.Throwable -> L88
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.Throwable -> L7a
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L7a
            r0.L$1 = r1     // Catch: java.lang.Throwable -> L7a
            r0.Z$0 = r8     // Catch: java.lang.Throwable -> L7a
            r0.label = r2     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r7 = r7.invoke(r1, r4, r0)     // Catch: java.lang.Throwable -> L7a
            u6.a r0 = u6.a.f10762a
            if (r7 != r0) goto L63
            return r0
        L63:
            r0 = r8
            r8 = r7
            r7 = r0
            r0 = r6
        L67:
            r1.close()     // Catch: java.lang.Throwable -> L6c
            r1 = r3
            goto L6d
        L6c:
            r1 = move-exception
        L6d:
            if (r1 != 0) goto L77
            if (r7 == 0) goto L76
            x7.a r7 = r0.transactionMutex
            r7.unlock(r3)
        L76:
            return r8
        L77:
            throw r1     // Catch: java.lang.Throwable -> L78
        L78:
            r8 = move-exception
            goto L8d
        L7a:
            r7 = move-exception
            r0 = r8
            r8 = r7
            r7 = r0
            r0 = r6
        L7f:
            r1.close()     // Catch: java.lang.Throwable -> L83
            goto L87
        L83:
            r1 = move-exception
            p6.a.a(r8, r1)     // Catch: java.lang.Throwable -> L78
        L87:
            throw r8     // Catch: java.lang.Throwable -> L78
        L88:
            r7 = move-exception
            r0 = r8
            r8 = r7
            r7 = r0
            r0 = r6
        L8d:
            if (r7 == 0) goto L94
            x7.a r7 = r0.transactionMutex
            r7.unlock(r3)
        L94:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileStorageConnection.readScope(d7.q, t6.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b6 A[Catch: all -> 0x00e6, IOException -> 0x00e9, TRY_ENTER, TryCatch #8 {IOException -> 0x00e9, all -> 0x00e6, blocks: (B:18:0x00b6, B:20:0x00bc, B:23:0x00c5, B:24:0x00e5, B:28:0x00f2, B:35:0x00ff, B:38:0x00fc), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f2 A[Catch: all -> 0x00e6, IOException -> 0x00e9, TRY_ENTER, TRY_LEAVE, TryCatch #8 {IOException -> 0x00e9, all -> 0x00e6, blocks: (B:18:0x00b6, B:20:0x00bc, B:23:0x00c5, B:24:0x00e5, B:28:0x00f2, B:35:0x00ff, B:38:0x00fc), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4, types: [x7.a] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.File, java.lang.Object] */
    @Override // androidx.datastore.core.StorageConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object writeScope(d7.p r10, t6.c r11) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.FileStorageConnection.writeScope(d7.p, t6.c):java.lang.Object");
    }
}
