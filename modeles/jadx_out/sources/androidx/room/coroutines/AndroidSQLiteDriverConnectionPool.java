package androidx.room.coroutines;

import androidx.room.g;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.driver.AndroidSQLiteConnection;
import d7.p;
import p6.f;
import p6.m;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AndroidSQLiteDriverConnectionPool implements ConnectionPool {
    private final f androidConnection$delegate;
    private final SQLiteDriver driver;
    private final String fileName;

    public AndroidSQLiteDriverConnectionPool(SQLiteDriver sQLiteDriver, String str) {
        sQLiteDriver.getClass();
        str.getClass();
        this.driver = sQLiteDriver;
        this.fileName = str;
        this.androidConnection$delegate = new m(new g(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AndroidSQLiteDriverPooledConnection androidConnection_delegate$lambda$0(AndroidSQLiteDriverConnectionPool androidSQLiteDriverConnectionPool) {
        SQLiteConnection open = androidSQLiteDriverConnectionPool.driver.open(androidSQLiteDriverConnectionPool.fileName);
        open.getClass();
        return new AndroidSQLiteDriverPooledConnection((AndroidSQLiteConnection) open);
    }

    private final AndroidSQLiteDriverPooledConnection getAndroidConnection() {
        return (AndroidSQLiteDriverPooledConnection) this.androidConnection$delegate.getValue();
    }

    @Override // androidx.room.coroutines.ConnectionPool, java.lang.AutoCloseable
    public void close() {
        getAndroidConnection().getDelegate().close();
    }

    @Override // androidx.room.coroutines.ConnectionPool
    public <R> Object useConnection(boolean z9, p pVar, c cVar) {
        return pVar.invoke(getAndroidConnection(), cVar);
    }
}
