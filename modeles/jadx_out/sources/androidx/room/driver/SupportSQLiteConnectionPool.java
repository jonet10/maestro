package androidx.room.driver;

import androidx.room.coroutines.ConnectionPool;
import d7.p;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SupportSQLiteConnectionPool implements ConnectionPool {
    private final SupportSQLiteDriver supportDriver;

    public SupportSQLiteConnectionPool(SupportSQLiteDriver supportSQLiteDriver) {
        supportSQLiteDriver.getClass();
        this.supportDriver = supportSQLiteDriver;
    }

    private final SupportSQLitePooledConnection getSupportConnection() {
        String databaseName = this.supportDriver.getOpenHelper().getDatabaseName();
        if (databaseName == null) {
            databaseName = ":memory:";
        }
        return new SupportSQLitePooledConnection(this.supportDriver.open(databaseName));
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        this.supportDriver.getOpenHelper().close();
    }

    public final SupportSQLiteDriver getSupportDriver$room_runtime_release() {
        return this.supportDriver;
    }

    @Override // androidx.room.coroutines.ConnectionPool
    public <R> Object useConnection(boolean z9, p pVar, c cVar) {
        return pVar.invoke(getSupportConnection(), cVar);
    }
}
