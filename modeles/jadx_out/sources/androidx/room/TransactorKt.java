package androidx.room;

import androidx.room.Transactor;
import androidx.sqlite.SQLiteStatement;
import d7.p;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TransactorKt {
    public static final <R> Object deferredTransaction(Transactor transactor, p pVar, t6.c cVar) {
        return transactor.withTransaction(Transactor.SQLiteTransactionType.DEFERRED, pVar, cVar);
    }

    public static final <R> Object exclusiveTransaction(Transactor transactor, p pVar, t6.c cVar) {
        return transactor.withTransaction(Transactor.SQLiteTransactionType.EXCLUSIVE, pVar, cVar);
    }

    public static final Object execSQL(PooledConnection pooledConnection, String str, t6.c cVar) {
        Object usePrepared = pooledConnection.usePrepared(str, new f(1), cVar);
        return usePrepared == u6.a.f10762a ? usePrepared : x.f8463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean execSQL$lambda$0(SQLiteStatement sQLiteStatement) {
        sQLiteStatement.getClass();
        return sQLiteStatement.step();
    }

    public static final <R> Object immediateTransaction(Transactor transactor, p pVar, t6.c cVar) {
        return transactor.withTransaction(Transactor.SQLiteTransactionType.IMMEDIATE, pVar, cVar);
    }
}
