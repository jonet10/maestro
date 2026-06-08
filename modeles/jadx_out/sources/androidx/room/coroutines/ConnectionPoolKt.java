package androidx.room.coroutines;

import androidx.sqlite.SQLiteDriver;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ConnectionPoolKt {
    public static final ConnectionPool newConnectionPool(SQLiteDriver sQLiteDriver, String str, int i, int i6) {
        sQLiteDriver.getClass();
        str.getClass();
        return new ConnectionPoolImpl(sQLiteDriver, str, i, i6);
    }

    public static final ConnectionPool newSingleConnectionPool(SQLiteDriver sQLiteDriver, String str) {
        sQLiteDriver.getClass();
        str.getClass();
        return new ConnectionPoolImpl(sQLiteDriver, str);
    }
}
