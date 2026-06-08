package androidx.room.support;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import o7.a0;
import o7.c0;
import q6.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class QueryInterceptorStatement implements SupportSQLiteStatement {
    private final List<Object> bindArgsCache;
    private final SupportSQLiteStatement delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final a0 queryCallbackScope;
    private final String sqlStatement;

    public QueryInterceptorStatement(SupportSQLiteStatement supportSQLiteStatement, String str, a0 a0Var, RoomDatabase.QueryCallback queryCallback) {
        supportSQLiteStatement.getClass();
        str.getClass();
        a0Var.getClass();
        queryCallback.getClass();
        this.delegate = supportSQLiteStatement;
        this.sqlStatement = str;
        this.queryCallbackScope = a0Var;
        this.queryCallback = queryCallback;
        this.bindArgsCache = new ArrayList();
    }

    private final void saveArgsToCache(int i, Object obj) {
        int i6 = i - 1;
        if (i6 >= this.bindArgsCache.size()) {
            int size = (i6 - this.bindArgsCache.size()) + 1;
            for (int i10 = 0; i10 < size; i10++) {
                this.bindArgsCache.add(null);
            }
        }
        this.bindArgsCache.set(i6, obj);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i, byte[] bArr) {
        bArr.getClass();
        saveArgsToCache(i, bArr);
        this.delegate.bindBlob(i, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i, double d10) {
        saveArgsToCache(i, Double.valueOf(d10));
        this.delegate.bindDouble(i, d10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i, long j) {
        saveArgsToCache(i, Long.valueOf(j));
        this.delegate.bindLong(i, j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i) {
        saveArgsToCache(i, null);
        this.delegate.bindNull(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i, String str) {
        str.getClass();
        saveArgsToCache(i, str);
        this.delegate.bindString(i, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.bindArgsCache.clear();
        this.delegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        c0.s(this.queryCallbackScope, null, null, new QueryInterceptorStatement$execute$1(this, l.G0(this.bindArgsCache), null), 3);
        this.delegate.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        c0.s(this.queryCallbackScope, null, null, new QueryInterceptorStatement$executeInsert$1(this, l.G0(this.bindArgsCache), null), 3);
        return this.delegate.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        c0.s(this.queryCallbackScope, null, null, new QueryInterceptorStatement$executeUpdateDelete$1(this, l.G0(this.bindArgsCache), null), 3);
        return this.delegate.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        c0.s(this.queryCallbackScope, null, null, new QueryInterceptorStatement$simpleQueryForLong$1(this, l.G0(this.bindArgsCache), null), 3);
        return this.delegate.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        c0.s(this.queryCallbackScope, null, null, new QueryInterceptorStatement$simpleQueryForString$1(this, l.G0(this.bindArgsCache), null), 3);
        return this.delegate.simpleQueryForString();
    }
}
