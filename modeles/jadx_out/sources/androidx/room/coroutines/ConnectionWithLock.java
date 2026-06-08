package androidx.room.coroutines;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import kotlin.jvm.internal.g;
import t6.c;
import t6.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class ConnectionWithLock implements SQLiteConnection, x7.a {
    private h acquireCoroutineContext;
    private Throwable acquireThrowable;
    private final SQLiteConnection delegate;
    private final x7.a lock;

    public ConnectionWithLock(SQLiteConnection sQLiteConnection, x7.a aVar) {
        sQLiteConnection.getClass();
        aVar.getClass();
        this.delegate = sQLiteConnection;
        this.lock = aVar;
    }

    @Override // androidx.sqlite.SQLiteConnection, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0107 A[LOOP:0: B:19:0x0101->B:21:0x0107, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dump(java.lang.StringBuilder r7) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.ConnectionWithLock.dump(java.lang.StringBuilder):void");
    }

    @Override // x7.a
    public w7.a getOnLock() {
        return this.lock.getOnLock();
    }

    @Override // x7.a
    public boolean holdsLock(Object obj) {
        obj.getClass();
        return this.lock.holdsLock(obj);
    }

    @Override // x7.a
    public boolean isLocked() {
        return this.lock.isLocked();
    }

    @Override // x7.a
    public Object lock(Object obj, c cVar) {
        return this.lock.lock(obj, cVar);
    }

    public final ConnectionWithLock markAcquired(h hVar) {
        hVar.getClass();
        this.acquireCoroutineContext = hVar;
        this.acquireThrowable = new Throwable();
        return this;
    }

    public final ConnectionWithLock markReleased() {
        this.acquireCoroutineContext = null;
        this.acquireThrowable = null;
        return this;
    }

    @Override // androidx.sqlite.SQLiteConnection
    public SQLiteStatement prepare(String str) {
        str.getClass();
        return this.delegate.prepare(str);
    }

    public String toString() {
        return this.delegate.toString();
    }

    @Override // x7.a
    public boolean tryLock(Object obj) {
        return this.lock.tryLock(obj);
    }

    @Override // x7.a
    public void unlock(Object obj) {
        this.lock.unlock(obj);
    }

    public /* synthetic */ ConnectionWithLock(SQLiteConnection sQLiteConnection, x7.a aVar, int i, g gVar) {
        this(sQLiteConnection, (i & 2) != 0 ? x7.h.a() : aVar);
    }
}
