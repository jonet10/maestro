package androidx.room.coroutines;

import android.database.SQLException;
import androidx.lifecycle.l;
import androidx.room.TransactionScope;
import androidx.room.Transactor;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import d7.p;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import q6.i;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class PooledConnectionImpl implements Transactor, RawConnectionAccessor {
    private final AtomicBoolean _isRecycled;
    private final ConnectionWithLock delegate;
    private final boolean isReadOnly;
    private final i transactionStack;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public final class StatementWrapper implements SQLiteStatement {
        private final SQLiteStatement delegate;
        final /* synthetic */ PooledConnectionImpl this$0;
        private final long threadId;

        public StatementWrapper(PooledConnectionImpl pooledConnectionImpl, SQLiteStatement sQLiteStatement) {
            sQLiteStatement.getClass();
            this.this$0 = pooledConnectionImpl;
            this.delegate = sQLiteStatement;
            this.threadId = ThreadLocal_jvmAndroidKt.currentThreadId();
        }

        private final <R> R withStateCheck(d7.a aVar) {
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return (R) aVar.invoke();
            }
            throw l.p(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindBlob */
        public void mo88bindBlob(int i, byte[] bArr) {
            bArr.getClass();
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId != ThreadLocal_jvmAndroidKt.currentThreadId()) {
                throw l.p(21, "Attempted to use statement on a different thread");
            }
            this.delegate.mo88bindBlob(i, bArr);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindBoolean(int i, boolean z9) {
            mo90bindLong(i, z9 ? 1L : 0L);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindDouble */
        public void mo89bindDouble(int i, double d10) {
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId != ThreadLocal_jvmAndroidKt.currentThreadId()) {
                throw l.p(21, "Attempted to use statement on a different thread");
            }
            this.delegate.mo89bindDouble(i, d10);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindFloat(int i, float f) {
            mo89bindDouble(i, f);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final void bindInt(int i, int i6) {
            mo90bindLong(i, i6);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindLong */
        public void mo90bindLong(int i, long j) {
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId != ThreadLocal_jvmAndroidKt.currentThreadId()) {
                throw l.p(21, "Attempted to use statement on a different thread");
            }
            this.delegate.mo90bindLong(i, j);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindNull */
        public void mo91bindNull(int i) {
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId != ThreadLocal_jvmAndroidKt.currentThreadId()) {
                throw l.p(21, "Attempted to use statement on a different thread");
            }
            this.delegate.mo91bindNull(i);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: bindText */
        public void mo92bindText(int i, String str) {
            str.getClass();
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId != ThreadLocal_jvmAndroidKt.currentThreadId()) {
                throw l.p(21, "Attempted to use statement on a different thread");
            }
            this.delegate.mo92bindText(i, str);
        }

        @Override // androidx.sqlite.SQLiteStatement
        /* renamed from: clearBindings */
        public void mo93clearBindings() {
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId != ThreadLocal_jvmAndroidKt.currentThreadId()) {
                throw l.p(21, "Attempted to use statement on a different thread");
            }
            this.delegate.mo93clearBindings();
        }

        @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
        public void close() {
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId != ThreadLocal_jvmAndroidKt.currentThreadId()) {
                throw l.p(21, "Attempted to use statement on a different thread");
            }
            this.delegate.close();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public byte[] getBlob(int i) {
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getBlob(i);
            }
            throw l.p(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final /* synthetic */ boolean getBoolean(int i) {
            return l.c(this, i);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnCount() {
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getColumnCount();
            }
            throw l.p(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getColumnName(int i) {
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getColumnName(i);
            }
            throw l.p(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final /* synthetic */ List getColumnNames() {
            return l.d(this);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public int getColumnType(int i) {
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getColumnType(i);
            }
            throw l.p(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public double getDouble(int i) {
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getDouble(i);
            }
            throw l.p(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final float getFloat(int i) {
            return (float) getDouble(i);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public final int getInt(int i) {
            return (int) getLong(i);
        }

        @Override // androidx.sqlite.SQLiteStatement
        public long getLong(int i) {
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getLong(i);
            }
            throw l.p(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public String getText(int i) {
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.getText(i);
            }
            throw l.p(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean isNull(int i) {
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.isNull(i);
            }
            throw l.p(21, "Attempted to use statement on a different thread");
        }

        @Override // androidx.sqlite.SQLiteStatement
        public void reset() {
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId != ThreadLocal_jvmAndroidKt.currentThreadId()) {
                throw l.p(21, "Attempted to use statement on a different thread");
            }
            this.delegate.reset();
        }

        @Override // androidx.sqlite.SQLiteStatement
        public boolean step() {
            if (this.this$0.isRecycled()) {
                throw l.p(21, "Statement is recycled");
            }
            if (this.threadId == ThreadLocal_jvmAndroidKt.currentThreadId()) {
                return this.delegate.step();
            }
            throw l.p(21, "Attempted to use statement on a different thread");
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public final class TransactionImpl<T> implements TransactionScope<T>, RawConnectionAccessor {
        public TransactionImpl() {
        }

        @Override // androidx.room.coroutines.RawConnectionAccessor
        public SQLiteConnection getRawConnection() {
            return PooledConnectionImpl.this.getRawConnection();
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0083 A[Catch: all -> 0x00a1, TRY_LEAVE, TryCatch #0 {all -> 0x00a1, blocks: (B:11:0x0079, B:13:0x0083, B:17:0x00a3, B:18:0x00aa), top: B:10:0x0079 }] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00a3 A[Catch: all -> 0x00a1, TRY_ENTER, TryCatch #0 {all -> 0x00a1, blocks: (B:11:0x0079, B:13:0x0083, B:17:0x00a3, B:18:0x00aa), top: B:10:0x0079 }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        @Override // androidx.room.TransactionScope
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object rollback(T r7, t6.c r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1
                if (r0 == 0) goto L13
                r0 = r8
                androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$TransactionImpl$rollback$1
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.result
                int r1 = r0.label
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L37
                if (r1 != r2) goto L30
                java.lang.Object r7 = r0.L$2
                x7.a r7 = (x7.a) r7
                java.lang.Object r1 = r0.L$1
                androidx.room.coroutines.PooledConnectionImpl r1 = (androidx.room.coroutines.PooledConnectionImpl) r1
                java.lang.Object r0 = r0.L$0
                p6.a.e(r8)
                goto L79
            L30:
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                androidx.privacysandbox.ads.adservices.customaudience.a.i(r7)
            L35:
                r7 = 0
                return r7
            L37:
                p6.a.e(r8)
                androidx.room.coroutines.PooledConnectionImpl r1 = androidx.room.coroutines.PooledConnectionImpl.this
                boolean r8 = androidx.room.coroutines.PooledConnectionImpl.access$isRecycled(r1)
                r4 = 21
                if (r8 != 0) goto Lbc
                t6.h r8 = r0.getContext()
                androidx.room.coroutines.ConnectionElement$Key r5 = androidx.room.coroutines.ConnectionElement.Key
                t6.f r8 = r8.get(r5)
                androidx.room.coroutines.ConnectionElement r8 = (androidx.room.coroutines.ConnectionElement) r8
                if (r8 == 0) goto Lb5
                androidx.room.coroutines.PooledConnectionImpl r8 = r8.getConnectionWrapper()
                if (r8 != r1) goto Lb5
                q6.i r8 = androidx.room.coroutines.PooledConnectionImpl.access$getTransactionStack$p(r1)
                boolean r8 = r8.isEmpty()
                if (r8 != 0) goto Laf
                androidx.room.coroutines.ConnectionWithLock r8 = r1.getDelegate()
                r0.L$0 = r7
                r0.L$1 = r1
                r0.L$2 = r8
                r0.label = r2
                java.lang.Object r0 = r8.lock(r3, r0)
                u6.a r4 = u6.a.f10762a
                if (r0 != r4) goto L77
                return r4
            L77:
                r0 = r7
                r7 = r8
            L79:
                q6.i r8 = androidx.room.coroutines.PooledConnectionImpl.access$getTransactionStack$p(r1)     // Catch: java.lang.Throwable -> La1
                boolean r1 = r8.isEmpty()     // Catch: java.lang.Throwable -> La1
                if (r1 != 0) goto La3
                java.lang.Object[] r1 = r8.f8721b     // Catch: java.lang.Throwable -> La1
                int r4 = r8.f8720a     // Catch: java.lang.Throwable -> La1
                int r5 = r8.c()     // Catch: java.lang.Throwable -> La1
                int r5 = r5 - r2
                int r5 = r5 + r4
                int r8 = r8.m(r5)     // Catch: java.lang.Throwable -> La1
                r8 = r1[r8]     // Catch: java.lang.Throwable -> La1
                androidx.room.coroutines.PooledConnectionImpl$TransactionItem r8 = (androidx.room.coroutines.PooledConnectionImpl.TransactionItem) r8     // Catch: java.lang.Throwable -> La1
                r8.setShouldRollback(r2)     // Catch: java.lang.Throwable -> La1
                r7.unlock(r3)
                androidx.room.coroutines.ConnectionPool$RollbackException r7 = new androidx.room.coroutines.ConnectionPool$RollbackException
                r7.<init>(r0)
                throw r7
            La1:
                r8 = move-exception
                goto Lab
            La3:
                java.util.NoSuchElementException r8 = new java.util.NoSuchElementException     // Catch: java.lang.Throwable -> La1
                java.lang.String r0 = "ArrayDeque is empty."
                r8.<init>(r0)     // Catch: java.lang.Throwable -> La1
                throw r8     // Catch: java.lang.Throwable -> La1
            Lab:
                r7.unlock(r3)
                throw r8
            Laf:
                java.lang.String r7 = "Not in a transaction"
                androidx.privacysandbox.ads.adservices.customaudience.a.i(r7)
                goto L35
            Lb5:
                java.lang.String r7 = "Attempted to use connection on a different coroutine"
                a1.b r7 = androidx.lifecycle.l.p(r4, r7)
                throw r7
            Lbc:
                java.lang.String r7 = "Connection is recycled"
                a1.b r7 = androidx.lifecycle.l.p(r4, r7)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.TransactionImpl.rollback(java.lang.Object, t6.c):java.lang.Object");
        }

        @Override // androidx.room.PooledConnection
        public <R> Object usePrepared(String str, d7.l lVar, c cVar) {
            return PooledConnectionImpl.this.usePrepared(str, lVar, cVar);
        }

        @Override // androidx.room.TransactionScope
        public <R> Object withNestedTransaction(p pVar, c cVar) {
            PooledConnectionImpl pooledConnectionImpl = PooledConnectionImpl.this;
            if (pooledConnectionImpl.isRecycled()) {
                throw l.p(21, "Connection is recycled");
            }
            ConnectionElement connectionElement = (ConnectionElement) cVar.getContext().get(ConnectionElement.Key);
            if (connectionElement == null || connectionElement.getConnectionWrapper() != pooledConnectionImpl) {
                throw l.p(21, "Attempted to use connection on a different coroutine");
            }
            return pooledConnectionImpl.transaction(null, pVar, cVar);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class TransactionItem {
        private final int id;
        private boolean shouldRollback;

        public TransactionItem(int i, boolean z9) {
            this.id = i;
            this.shouldRollback = z9;
        }

        public final int getId() {
            return this.id;
        }

        public final boolean getShouldRollback() {
            return this.shouldRollback;
        }

        public final void setShouldRollback(boolean z9) {
            this.shouldRollback = z9;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Transactor.SQLiteTransactionType.values().length];
            try {
                iArr[Transactor.SQLiteTransactionType.DEFERRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.IMMEDIATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.EXCLUSIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PooledConnectionImpl(ConnectionWithLock connectionWithLock, boolean z9) {
        connectionWithLock.getClass();
        this.delegate = connectionWithLock;
        this.isReadOnly = z9;
        this.transactionStack = new i();
        this._isRecycled = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062 A[Catch: all -> 0x007a, TryCatch #0 {all -> 0x007a, blocks: (B:11:0x0054, B:13:0x0062, B:19:0x0072, B:20:0x00a8, B:24:0x007c, B:25:0x0081, B:26:0x0082, B:27:0x008a, B:28:0x0092), top: B:10:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092 A[Catch: all -> 0x007a, TryCatch #0 {all -> 0x007a, blocks: (B:11:0x0054, B:13:0x0062, B:19:0x0072, B:20:0x00a8, B:24:0x007c, B:25:0x0081, B:26:0x0082, B:27:0x008a, B:28:0x0092), top: B:10:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Type inference failed for: r7v15, types: [x7.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object beginTransaction(androidx.room.Transactor.SQLiteTransactionType r7, t6.c r8) {
        /*
            r6 = this;
            java.lang.String r0 = "SAVEPOINT '"
            boolean r1 = r8 instanceof androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1
            if (r1 == 0) goto L15
            r1 = r8
            androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1 r1 = (androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1 r1 = new androidx.room.coroutines.PooledConnectionImpl$beginTransaction$1
            r1.<init>(r6, r8)
        L1a:
            java.lang.Object r8 = r1.result
            int r2 = r1.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L36
            java.lang.Object r7 = r1.L$2
            x7.a r7 = (x7.a) r7
            java.lang.Object r2 = r1.L$1
            androidx.room.Transactor$SQLiteTransactionType r2 = (androidx.room.Transactor.SQLiteTransactionType) r2
            java.lang.Object r1 = r1.L$0
            androidx.room.coroutines.PooledConnectionImpl r1 = (androidx.room.coroutines.PooledConnectionImpl) r1
            p6.a.e(r8)
            r8 = r7
            r7 = r2
            goto L54
        L36:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r7)
            r7 = 0
            return r7
        L3d:
            p6.a.e(r8)
            androidx.room.coroutines.ConnectionWithLock r8 = r6.delegate
            r1.L$0 = r6
            r1.L$1 = r7
            r1.L$2 = r8
            r1.label = r3
            java.lang.Object r1 = r8.lock(r4, r1)
            u6.a r2 = u6.a.f10762a
            if (r1 != r2) goto L53
            return r2
        L53:
            r1 = r6
        L54:
            q6.i r2 = r1.transactionStack     // Catch: java.lang.Throwable -> L7a
            int r2 = r2.c()     // Catch: java.lang.Throwable -> L7a
            q6.i r5 = r1.transactionStack     // Catch: java.lang.Throwable -> L7a
            boolean r5 = r5.isEmpty()     // Catch: java.lang.Throwable -> L7a
            if (r5 == 0) goto L92
            int[] r0 = androidx.room.coroutines.PooledConnectionImpl.WhenMappings.$EnumSwitchMapping$0     // Catch: java.lang.Throwable -> L7a
            int r7 = r7.ordinal()     // Catch: java.lang.Throwable -> L7a
            r7 = r0[r7]     // Catch: java.lang.Throwable -> L7a
            if (r7 == r3) goto L8a
            r0 = 2
            if (r7 == r0) goto L82
            r0 = 3
            if (r7 != r0) goto L7c
            androidx.room.coroutines.ConnectionWithLock r7 = r1.delegate     // Catch: java.lang.Throwable -> L7a
            java.lang.String r0 = "BEGIN EXCLUSIVE TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r7, r0)     // Catch: java.lang.Throwable -> L7a
            goto La8
        L7a:
            r7 = move-exception
            goto Lb9
        L7c:
            a1.b r7 = new a1.b     // Catch: java.lang.Throwable -> L7a
            r7.<init>()     // Catch: java.lang.Throwable -> L7a
            throw r7     // Catch: java.lang.Throwable -> L7a
        L82:
            androidx.room.coroutines.ConnectionWithLock r7 = r1.delegate     // Catch: java.lang.Throwable -> L7a
            java.lang.String r0 = "BEGIN IMMEDIATE TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r7, r0)     // Catch: java.lang.Throwable -> L7a
            goto La8
        L8a:
            androidx.room.coroutines.ConnectionWithLock r7 = r1.delegate     // Catch: java.lang.Throwable -> L7a
            java.lang.String r0 = "BEGIN DEFERRED TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r7, r0)     // Catch: java.lang.Throwable -> L7a
            goto La8
        L92:
            androidx.room.coroutines.ConnectionWithLock r7 = r1.delegate     // Catch: java.lang.Throwable -> L7a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7a
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L7a
            r3.append(r2)     // Catch: java.lang.Throwable -> L7a
            r0 = 39
            r3.append(r0)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L7a
            androidx.sqlite.SQLite.execSQL(r7, r0)     // Catch: java.lang.Throwable -> L7a
        La8:
            q6.i r7 = r1.transactionStack     // Catch: java.lang.Throwable -> L7a
            androidx.room.coroutines.PooledConnectionImpl$TransactionItem r0 = new androidx.room.coroutines.PooledConnectionImpl$TransactionItem     // Catch: java.lang.Throwable -> L7a
            r1 = 0
            r0.<init>(r2, r1)     // Catch: java.lang.Throwable -> L7a
            r7.addLast(r0)     // Catch: java.lang.Throwable -> L7a
            p6.x r7 = p6.x.f8463a     // Catch: java.lang.Throwable -> L7a
            r8.unlock(r4)
            return r7
        Lb9:
            r8.unlock(r4)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.beginTransaction(androidx.room.Transactor$SQLiteTransactionType, t6.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005a A[Catch: all -> 0x007c, TryCatch #0 {all -> 0x007c, blocks: (B:11:0x0052, B:13:0x005a, B:15:0x0066, B:17:0x006c, B:20:0x0076, B:21:0x00bb, B:25:0x007e, B:26:0x0095, B:29:0x009f, B:30:0x00a5, B:31:0x00c1, B:32:0x00c8), top: B:10:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c1 A[Catch: all -> 0x007c, TRY_ENTER, TryCatch #0 {all -> 0x007c, blocks: (B:11:0x0052, B:13:0x005a, B:15:0x0066, B:17:0x006c, B:20:0x0076, B:21:0x00bb, B:25:0x007e, B:26:0x0095, B:29:0x009f, B:30:0x00a5, B:31:0x00c1, B:32:0x00c8), top: B:10:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object endTransaction(boolean r7, t6.c r8) {
        /*
            r6 = this;
            java.lang.String r0 = "ROLLBACK TRANSACTION TO SAVEPOINT '"
            java.lang.String r1 = "RELEASE SAVEPOINT '"
            boolean r2 = r8 instanceof androidx.room.coroutines.PooledConnectionImpl$endTransaction$1
            if (r2 == 0) goto L17
            r2 = r8
            androidx.room.coroutines.PooledConnectionImpl$endTransaction$1 r2 = (androidx.room.coroutines.PooledConnectionImpl$endTransaction$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            androidx.room.coroutines.PooledConnectionImpl$endTransaction$1 r2 = new androidx.room.coroutines.PooledConnectionImpl$endTransaction$1
            r2.<init>(r6, r8)
        L1c:
            java.lang.Object r8 = r2.result
            int r3 = r2.label
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L3b
            if (r3 != r4) goto L34
            boolean r7 = r2.Z$0
            java.lang.Object r3 = r2.L$1
            x7.a r3 = (x7.a) r3
            java.lang.Object r2 = r2.L$0
            androidx.room.coroutines.PooledConnectionImpl r2 = (androidx.room.coroutines.PooledConnectionImpl) r2
            p6.a.e(r8)
            goto L52
        L34:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r7)
            r7 = 0
            return r7
        L3b:
            p6.a.e(r8)
            androidx.room.coroutines.ConnectionWithLock r3 = r6.delegate
            r2.L$0 = r6
            r2.L$1 = r3
            r2.Z$0 = r7
            r2.label = r4
            java.lang.Object r8 = r3.lock(r5, r2)
            u6.a r2 = u6.a.f10762a
            if (r8 != r2) goto L51
            return r2
        L51:
            r2 = r6
        L52:
            q6.i r8 = r2.transactionStack     // Catch: java.lang.Throwable -> L7c
            boolean r8 = r8.isEmpty()     // Catch: java.lang.Throwable -> L7c
            if (r8 != 0) goto Lc1
            q6.i r8 = r2.transactionStack     // Catch: java.lang.Throwable -> L7c
            java.lang.Object r8 = q6.r.n0(r8)     // Catch: java.lang.Throwable -> L7c
            androidx.room.coroutines.PooledConnectionImpl$TransactionItem r8 = (androidx.room.coroutines.PooledConnectionImpl.TransactionItem) r8     // Catch: java.lang.Throwable -> L7c
            r4 = 39
            if (r7 == 0) goto L95
            boolean r7 = r8.getShouldRollback()     // Catch: java.lang.Throwable -> L7c
            if (r7 != 0) goto L95
            q6.i r7 = r2.transactionStack     // Catch: java.lang.Throwable -> L7c
            boolean r7 = r7.isEmpty()     // Catch: java.lang.Throwable -> L7c
            androidx.room.coroutines.ConnectionWithLock r0 = r2.delegate
            if (r7 == 0) goto L7e
            java.lang.String r7 = "END TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r0, r7)     // Catch: java.lang.Throwable -> L7c
            goto Lbb
        L7c:
            r7 = move-exception
            goto Lc9
        L7e:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            r7.<init>(r1)     // Catch: java.lang.Throwable -> L7c
            int r8 = r8.getId()     // Catch: java.lang.Throwable -> L7c
            r7.append(r8)     // Catch: java.lang.Throwable -> L7c
            r7.append(r4)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L7c
            androidx.sqlite.SQLite.execSQL(r0, r7)     // Catch: java.lang.Throwable -> L7c
            goto Lbb
        L95:
            q6.i r7 = r2.transactionStack     // Catch: java.lang.Throwable -> L7c
            boolean r7 = r7.isEmpty()     // Catch: java.lang.Throwable -> L7c
            androidx.room.coroutines.ConnectionWithLock r1 = r2.delegate
            if (r7 == 0) goto La5
            java.lang.String r7 = "ROLLBACK TRANSACTION"
            androidx.sqlite.SQLite.execSQL(r1, r7)     // Catch: java.lang.Throwable -> L7c
            goto Lbb
        La5:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L7c
            int r8 = r8.getId()     // Catch: java.lang.Throwable -> L7c
            r7.append(r8)     // Catch: java.lang.Throwable -> L7c
            r7.append(r4)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L7c
            androidx.sqlite.SQLite.execSQL(r1, r7)     // Catch: java.lang.Throwable -> L7c
        Lbb:
            p6.x r7 = p6.x.f8463a     // Catch: java.lang.Throwable -> L7c
            r3.unlock(r5)
            return r7
        Lc1:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L7c
            java.lang.String r8 = "Not in a transaction"
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L7c
            throw r7     // Catch: java.lang.Throwable -> L7c
        Lc9:
            r3.unlock(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.endTransaction(boolean, t6.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRecycled() {
        return this._isRecycled.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(2:3|(7:5|6|(1:(1:(1:(1:(1:(2:13|14)(4:16|17|18|19))(2:25|26))(2:27|28))(6:29|30|31|(1:33)|34|(1:37)(1:36)))(1:60))(5:68|(1:70)|71|(1:73)|37)|61|62|(4:64|(0)|34|(0))|37))|74|6|(0)(0)|61|62|(0)|37|(2:(1:56)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00af, code lost:
    
        r12 = r12.getResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b5, code lost:
    
        r0.L$0 = r12;
        r0.L$1 = null;
        r0.label = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00bf, code lost:
    
        if (r13.endTransaction(false, r0) == r9) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c2, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c5, code lost:
    
        throw r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c6, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c7, code lost:
    
        r8 = r12;
        r12 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c9, code lost:
    
        r0.L$0 = r8;
        r0.L$1 = r12;
        r0.label = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d3, code lost:
    
        if (r13.endTransaction(false, r0) != r9) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d6, code lost:
    
        r14 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d7, code lost:
    
        r13 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00a7, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00a8, code lost:
    
        r13 = r12;
        r12 = r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00af A[Catch: all -> 0x00c3, TRY_LEAVE, TryCatch #2 {all -> 0x00c3, blocks: (B:41:0x00ab, B:43:0x00af), top: B:40:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <R> java.lang.Object transaction(androidx.room.Transactor.SQLiteTransactionType r12, d7.p r13, t6.c r14) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.transaction(androidx.room.Transactor$SQLiteTransactionType, d7.p, t6.c):java.lang.Object");
    }

    private final <R> Object withStateCheck(d7.a aVar, c cVar) {
        if (isRecycled()) {
            throw l.p(21, "Connection is recycled");
        }
        throw null;
    }

    public final ConnectionWithLock getDelegate() {
        return this.delegate;
    }

    @Override // androidx.room.coroutines.RawConnectionAccessor
    public SQLiteConnection getRawConnection() {
        return this.delegate;
    }

    @Override // androidx.room.Transactor
    public Object inTransaction(c cVar) {
        if (isRecycled()) {
            throw l.p(21, "Connection is recycled");
        }
        ConnectionElement connectionElement = (ConnectionElement) cVar.getContext().get(ConnectionElement.Key);
        if (connectionElement == null || connectionElement.getConnectionWrapper() != this) {
            throw l.p(21, "Attempted to use connection on a different coroutine");
        }
        return Boolean.valueOf(!this.transactionStack.isEmpty());
    }

    public final boolean isReadOnly() {
        return this.isReadOnly;
    }

    public final void markRecycled() {
        if (this._isRecycled.compareAndSet(false, true)) {
            try {
                SQLite.execSQL(this.delegate, "ROLLBACK TRANSACTION");
            } catch (SQLException unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Type inference failed for: r6v13, types: [x7.a] */
    @Override // androidx.room.PooledConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <R> java.lang.Object usePrepared(java.lang.String r6, d7.l r7, t6.c r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.room.coroutines.PooledConnectionImpl$usePrepared$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.room.coroutines.PooledConnectionImpl$usePrepared$1 r0 = (androidx.room.coroutines.PooledConnectionImpl$usePrepared$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.PooledConnectionImpl$usePrepared$1 r0 = new androidx.room.coroutines.PooledConnectionImpl$usePrepared$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L3f
            if (r1 != r2) goto L38
            java.lang.Object r6 = r0.L$3
            x7.a r6 = (x7.a) r6
            java.lang.Object r7 = r0.L$2
            d7.l r7 = (d7.l) r7
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            androidx.room.coroutines.PooledConnectionImpl r0 = (androidx.room.coroutines.PooledConnectionImpl) r0
            p6.a.e(r8)
            r8 = r6
            r6 = r1
            goto L74
        L38:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            r6 = 0
            return r6
        L3f:
            p6.a.e(r8)
            boolean r8 = access$isRecycled(r5)
            r1 = 21
            if (r8 != 0) goto L9e
            t6.h r8 = r0.getContext()
            androidx.room.coroutines.ConnectionElement$Key r4 = androidx.room.coroutines.ConnectionElement.Key
            t6.f r8 = r8.get(r4)
            androidx.room.coroutines.ConnectionElement r8 = (androidx.room.coroutines.ConnectionElement) r8
            if (r8 == 0) goto L97
            androidx.room.coroutines.PooledConnectionImpl r8 = r8.getConnectionWrapper()
            if (r8 != r5) goto L97
            androidx.room.coroutines.ConnectionWithLock r8 = r5.delegate
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.L$3 = r8
            r0.label = r2
            java.lang.Object r0 = r8.lock(r3, r0)
            u6.a r1 = u6.a.f10762a
            if (r0 != r1) goto L73
            return r1
        L73:
            r0 = r5
        L74:
            androidx.room.coroutines.PooledConnectionImpl$StatementWrapper r1 = new androidx.room.coroutines.PooledConnectionImpl$StatementWrapper     // Catch: java.lang.Throwable -> L8a
            androidx.room.coroutines.ConnectionWithLock r2 = r0.delegate     // Catch: java.lang.Throwable -> L8a
            androidx.sqlite.SQLiteStatement r6 = r2.prepare(r6)     // Catch: java.lang.Throwable -> L8a
            r1.<init>(r0, r6)     // Catch: java.lang.Throwable -> L8a
            java.lang.Object r6 = r7.invoke(r1)     // Catch: java.lang.Throwable -> L8c
            t0.f.g(r1, r3)     // Catch: java.lang.Throwable -> L8a
            r8.unlock(r3)
            return r6
        L8a:
            r6 = move-exception
            goto L93
        L8c:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> L8e
        L8e:
            r7 = move-exception
            t0.f.g(r1, r6)     // Catch: java.lang.Throwable -> L8a
            throw r7     // Catch: java.lang.Throwable -> L8a
        L93:
            r8.unlock(r3)
            throw r6
        L97:
            java.lang.String r6 = "Attempted to use connection on a different coroutine"
            a1.b r6 = androidx.lifecycle.l.p(r1, r6)
            throw r6
        L9e:
            java.lang.String r6 = "Connection is recycled"
            a1.b r6 = androidx.lifecycle.l.p(r1, r6)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PooledConnectionImpl.usePrepared(java.lang.String, d7.l, t6.c):java.lang.Object");
    }

    @Override // androidx.room.Transactor
    public <R> Object withTransaction(Transactor.SQLiteTransactionType sQLiteTransactionType, p pVar, c cVar) {
        if (isRecycled()) {
            throw l.p(21, "Connection is recycled");
        }
        ConnectionElement connectionElement = (ConnectionElement) cVar.getContext().get(ConnectionElement.Key);
        if (connectionElement == null || connectionElement.getConnectionWrapper() != this) {
            throw l.p(21, "Attempted to use connection on a different coroutine");
        }
        return transaction(sQLiteTransactionType, pVar, cVar);
    }
}
