package androidx.room.coroutines;

import androidx.collection.CircularArray;
import androidx.sqlite.SQLiteConnection;
import java.util.concurrent.locks.ReentrantLock;
import r6.c;
import x7.i;
import x7.l;
import x7.m;
import x7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class Pool {
    private final CircularArray<ConnectionWithLock> availableConnections;
    private final int capacity;
    private final d7.a connectionFactory;
    private final i connectionPermits;
    private final ConnectionWithLock[] connections;
    private boolean isClosed;
    private final ReentrantLock lock;
    private int size;

    public Pool(int i, d7.a aVar) {
        aVar.getClass();
        this.capacity = i;
        this.connectionFactory = aVar;
        this.lock = new ReentrantLock();
        this.connections = new ConnectionWithLock[i];
        int i6 = n.f11539a;
        this.connectionPermits = new m(i, 0);
        this.availableConnections = new CircularArray<>(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void tryOpenNewConnectionLocked() {
        if (this.size >= this.capacity) {
            return;
        }
        ConnectionWithLock connectionWithLock = new ConnectionWithLock((SQLiteConnection) this.connectionFactory.invoke(), null, 2, 0 == true ? 1 : 0);
        ConnectionWithLock[] connectionWithLockArr = this.connections;
        int i = this.size;
        this.size = i + 1;
        connectionWithLockArr[i] = connectionWithLock;
        this.availableConnections.addLast(connectionWithLock);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0067, code lost:
    
        r0.g(r3, r6.f11538b);
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008b A[Catch: all -> 0x0097, TryCatch #2 {all -> 0x0097, blocks: (B:13:0x0087, B:15:0x008b, B:17:0x0093, B:18:0x0099, B:22:0x00a7, B:23:0x00b3), top: B:12:0x0087, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a7 A[Catch: all -> 0x0097, TRY_ENTER, TryCatch #2 {all -> 0x0097, blocks: (B:13:0x0087, B:15:0x008b, B:17:0x0093, B:18:0x0099, B:22:0x00a7, B:23:0x00b3), top: B:12:0x0087, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object acquire(t6.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.room.coroutines.Pool$acquire$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.room.coroutines.Pool$acquire$1 r0 = (androidx.room.coroutines.Pool$acquire$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.Pool$acquire$1 r0 = new androidx.room.coroutines.Pool$acquire$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            java.lang.Object r0 = r0.L$0
            androidx.room.coroutines.Pool r0 = (androidx.room.coroutines.Pool) r0
            p6.a.e(r6)
            goto L82
        L29:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            r6 = 0
            return r6
        L30:
            p6.a.e(r6)
            x7.i r6 = r5.connectionPermits
            r0.L$0 = r5
            r0.label = r2
            x7.l r6 = (x7.l) r6
            r6.getClass()
            int r1 = r6.f11537a
        L40:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = x7.l.f11536p
            int r2 = r2.getAndDecrement(r6)
            if (r2 > r1) goto L40
            p6.x r3 = p6.x.f8463a
            u6.a r4 = u6.a.f10762a
            if (r2 <= 0) goto L4f
            goto L7e
        L4f:
            t6.c r0 = d0.b.I(r0)
            o7.l r0 = o7.c0.p(r0)
            boolean r2 = r6.a(r0)     // Catch: java.lang.Throwable -> Lc0
            if (r2 != 0) goto L73
        L5d:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = x7.l.f11536p     // Catch: java.lang.Throwable -> Lc0
            int r2 = r2.getAndDecrement(r6)     // Catch: java.lang.Throwable -> Lc0
            if (r2 > r1) goto L5d
            if (r2 <= 0) goto L6d
            o7.k r6 = r6.f11538b     // Catch: java.lang.Throwable -> Lc0
            r0.g(r3, r6)     // Catch: java.lang.Throwable -> Lc0
            goto L73
        L6d:
            boolean r2 = r6.a(r0)     // Catch: java.lang.Throwable -> Lc0
            if (r2 == 0) goto L5d
        L73:
            java.lang.Object r6 = r0.r()
            if (r6 != r4) goto L7a
            goto L7b
        L7a:
            r6 = r3
        L7b:
            if (r6 != r4) goto L7e
            r3 = r6
        L7e:
            if (r3 != r4) goto L81
            return r4
        L81:
            r0 = r5
        L82:
            java.util.concurrent.locks.ReentrantLock r6 = r0.lock     // Catch: java.lang.Throwable -> La5
            r6.lock()     // Catch: java.lang.Throwable -> La5
            boolean r1 = r0.isClosed     // Catch: java.lang.Throwable -> L97
            if (r1 != 0) goto La7
            androidx.collection.CircularArray<androidx.room.coroutines.ConnectionWithLock> r1 = r0.availableConnections     // Catch: java.lang.Throwable -> L97
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L97
            if (r1 == 0) goto L99
            r0.tryOpenNewConnectionLocked()     // Catch: java.lang.Throwable -> L97
            goto L99
        L97:
            r1 = move-exception
            goto Lb4
        L99:
            androidx.collection.CircularArray<androidx.room.coroutines.ConnectionWithLock> r1 = r0.availableConnections     // Catch: java.lang.Throwable -> L97
            java.lang.Object r1 = r1.popFirst()     // Catch: java.lang.Throwable -> L97
            androidx.room.coroutines.ConnectionWithLock r1 = (androidx.room.coroutines.ConnectionWithLock) r1     // Catch: java.lang.Throwable -> L97
            r6.unlock()     // Catch: java.lang.Throwable -> La5
            return r1
        La5:
            r6 = move-exception
            goto Lb8
        La7:
            java.lang.String r1 = "Connection pool is closed"
            r2 = 21
            androidx.sqlite.SQLite.throwSQLiteException(r2, r1)     // Catch: java.lang.Throwable -> L97
            a1.b r1 = new a1.b     // Catch: java.lang.Throwable -> L97
            r1.<init>()     // Catch: java.lang.Throwable -> L97
            throw r1     // Catch: java.lang.Throwable -> L97
        Lb4:
            r6.unlock()     // Catch: java.lang.Throwable -> La5
            throw r1     // Catch: java.lang.Throwable -> La5
        Lb8:
            x7.i r0 = r0.connectionPermits
            x7.l r0 = (x7.l) r0
            r0.b()
            throw r6
        Lc0:
            r6 = move-exception
            r0.z()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.Pool.acquire(t6.c):java.lang.Object");
    }

    public final void close() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.isClosed = true;
            for (ConnectionWithLock connectionWithLock : this.connections) {
                if (connectionWithLock != null) {
                    connectionWithLock.close();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void dump(StringBuilder sb) {
        sb.getClass();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            c t9 = a.a.t();
            int size = this.availableConnections.size();
            for (int i = 0; i < size; i++) {
                t9.add(this.availableConnections.get(i));
            }
            c m10 = a.a.m(t9);
            sb.append('\t' + toString() + " (");
            sb.append("capacity=" + this.capacity + ", ");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("permits=");
            l lVar = (l) this.connectionPermits;
            lVar.getClass();
            sb2.append(Math.max(l.f11536p.get(lVar), 0));
            sb2.append(", ");
            sb.append(sb2.toString());
            sb.append("queue=(size=" + m10.c() + ")[" + q6.l.x0(m10, null, null, null, null, 63) + "], ");
            sb.append(")");
            sb.append('\n');
            ConnectionWithLock[] connectionWithLockArr = this.connections;
            int length = connectionWithLockArr.length;
            int i6 = 0;
            for (int i10 = 0; i10 < length; i10++) {
                ConnectionWithLock connectionWithLock = connectionWithLockArr[i10];
                i6++;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("\t\t[");
                sb3.append(i6);
                sb3.append("] - ");
                sb3.append(connectionWithLock != null ? connectionWithLock.toString() : null);
                sb.append(sb3.toString());
                sb.append('\n');
                if (connectionWithLock != null) {
                    connectionWithLock.dump(sb);
                }
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final d7.a getConnectionFactory() {
        return this.connectionFactory;
    }

    public final void recycle(ConnectionWithLock connectionWithLock) {
        connectionWithLock.getClass();
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.availableConnections.addLast(connectionWithLock);
            reentrantLock.unlock();
            ((l) this.connectionPermits).b();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
