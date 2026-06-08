package androidx.room.coroutines;

import a1.b;
import androidx.room.concurrent.ThreadLocal_jvmAndroidKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import com.google.android.gms.internal.measurement.i5;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.x;
import m7.c;
import o7.c0;
import p6.i;
import t6.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ConnectionPoolImpl implements ConnectionPool {
    private final AtomicBoolean _isClosed;
    private final SQLiteDriver driver;
    private final Pool readers;
    private final ThreadLocal<PooledConnectionImpl> threadLocal;
    private long timeout;
    private final Pool writers;

    public ConnectionPoolImpl(final SQLiteDriver sQLiteDriver, final String str, int i, int i6) {
        sQLiteDriver.getClass();
        str.getClass();
        this.threadLocal = new ThreadLocal<>();
        final int i10 = 0;
        this._isClosed = new AtomicBoolean(false);
        int i11 = m7.a.f7657m;
        this.timeout = i5.N(30, c.SECONDS);
        if (i <= 0) {
            com.google.gson.internal.a.p("Maximum number of readers must be greater than 0");
            throw null;
        }
        if (i6 <= 0) {
            com.google.gson.internal.a.p("Maximum number of writers must be greater than 0");
            throw null;
        }
        this.driver = sQLiteDriver;
        this.readers = new Pool(i, new d7.a() { // from class: androidx.room.coroutines.a
            @Override // d7.a
            public final Object invoke() {
                SQLiteConnection _init_$lambda$4;
                SQLiteConnection open;
                SQLiteConnection open2;
                switch (i10) {
                    case 0:
                        _init_$lambda$4 = ConnectionPoolImpl._init_$lambda$4(sQLiteDriver, str);
                        return _init_$lambda$4;
                    case 1:
                        open = sQLiteDriver.open(str);
                        return open;
                    default:
                        open2 = sQLiteDriver.open(str);
                        return open2;
                }
            }
        });
        final int i12 = 1;
        this.writers = new Pool(i6, new d7.a() { // from class: androidx.room.coroutines.a
            @Override // d7.a
            public final Object invoke() {
                SQLiteConnection _init_$lambda$4;
                SQLiteConnection open;
                SQLiteConnection open2;
                switch (i12) {
                    case 0:
                        _init_$lambda$4 = ConnectionPoolImpl._init_$lambda$4(sQLiteDriver, str);
                        return _init_$lambda$4;
                    case 1:
                        open = sQLiteDriver.open(str);
                        return open;
                    default:
                        open2 = sQLiteDriver.open(str);
                        return open2;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SQLiteConnection _init_$lambda$4(SQLiteDriver sQLiteDriver, String str) {
        SQLiteConnection open = sQLiteDriver.open(str);
        SQLite.execSQL(open, "PRAGMA query_only = 1");
        return open;
    }

    private final Object acquireWithTimeout(Pool pool, t6.c cVar) {
        Object obj;
        x xVar = new x();
        try {
            obj = null;
            c0.D(this.timeout, new ConnectionPoolImpl$acquireWithTimeout$2(xVar, pool, null), cVar);
        } catch (Throwable th) {
            obj = th;
        }
        return new i(xVar.f7024a, obj);
    }

    private final h createConnectionContext(PooledConnectionImpl pooledConnectionImpl) {
        return new ConnectionElement(pooledConnectionImpl).plus(ThreadLocal_jvmAndroidKt.asContextElement(this.threadLocal, pooledConnectionImpl));
    }

    private final boolean isClosed() {
        return this._isClosed.get();
    }

    private final Void throwTimeoutException(boolean z9) {
        String str = z9 ? "reader" : "writer";
        StringBuilder sb = new StringBuilder();
        sb.append("Timed out attempting to acquire a " + str + " connection.");
        sb.append("\n\nWriter pool:\n");
        this.writers.dump(sb);
        sb.append("Reader pool:");
        sb.append('\n');
        this.readers.dump(sb);
        SQLite.throwSQLiteException(5, sb.toString());
        throw new b();
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        if (this._isClosed.compareAndSet(false, true)) {
            this.readers.close();
            this.writers.close();
        }
    }

    /* renamed from: getTimeout-UwyO8pc$room_runtime_release, reason: not valid java name */
    public final long m86getTimeoutUwyO8pc$room_runtime_release() {
        return this.timeout;
    }

    /* renamed from: setTimeout-LRDsOJo$room_runtime_release, reason: not valid java name */
    public final void m87setTimeoutLRDsOJo$room_runtime_release(long j) {
        this.timeout = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x017f A[Catch: all -> 0x0190, TRY_LEAVE, TryCatch #0 {all -> 0x0190, blocks: (B:16:0x0179, B:18:0x017f), top: B:15:0x0179 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0137 A[Catch: all -> 0x014b, TryCatch #6 {all -> 0x014b, blocks: (B:48:0x0131, B:50:0x0137, B:54:0x0147, B:55:0x0150, B:59:0x015a, B:63:0x0191, B:64:0x0198, B:65:0x0199, B:66:0x019a, B:67:0x01a2), top: B:47:0x0131 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x019a A[Catch: all -> 0x014b, TryCatch #6 {all -> 0x014b, blocks: (B:48:0x0131, B:50:0x0137, B:54:0x0147, B:55:0x0150, B:59:0x015a, B:63:0x0191, B:64:0x0198, B:65:0x0199, B:66:0x019a, B:67:0x01a2), top: B:47:0x0131 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    @Override // androidx.room.coroutines.ConnectionPool
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <R> java.lang.Object useConnection(boolean r18, d7.p r19, t6.c r20) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.ConnectionPoolImpl.useConnection(boolean, d7.p, t6.c):java.lang.Object");
    }

    public ConnectionPoolImpl(final SQLiteDriver sQLiteDriver, final String str) {
        sQLiteDriver.getClass();
        str.getClass();
        this.threadLocal = new ThreadLocal<>();
        this._isClosed = new AtomicBoolean(false);
        int i = m7.a.f7657m;
        this.timeout = i5.N(30, c.SECONDS);
        this.driver = sQLiteDriver;
        final int i6 = 2;
        Pool pool = new Pool(1, new d7.a() { // from class: androidx.room.coroutines.a
            @Override // d7.a
            public final Object invoke() {
                SQLiteConnection _init_$lambda$4;
                SQLiteConnection open;
                SQLiteConnection open2;
                switch (i6) {
                    case 0:
                        _init_$lambda$4 = ConnectionPoolImpl._init_$lambda$4(sQLiteDriver, str);
                        return _init_$lambda$4;
                    case 1:
                        open = sQLiteDriver.open(str);
                        return open;
                    default:
                        open2 = sQLiteDriver.open(str);
                        return open2;
                }
            }
        });
        this.readers = pool;
        this.writers = pool;
    }
}
