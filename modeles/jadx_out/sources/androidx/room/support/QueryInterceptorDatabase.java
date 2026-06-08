package androidx.room.support;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.List;
import java.util.Locale;
import o7.a0;
import o7.c0;
import q6.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {
    private final SupportSQLiteDatabase delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final a0 queryCallbackScope;

    public QueryInterceptorDatabase(SupportSQLiteDatabase supportSQLiteDatabase, a0 a0Var, RoomDatabase.QueryCallback queryCallback) {
        supportSQLiteDatabase.getClass();
        a0Var.getClass();
        queryCallback.getClass();
        this.delegate = supportSQLiteDatabase;
        this.queryCallbackScope = a0Var;
        this.queryCallback = queryCallback;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        c0.s(this.queryCallbackScope, null, null, new QueryInterceptorDatabase$beginTransaction$1(this, null), 3);
        this.delegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        c0.s(this.queryCallbackScope, null, null, new QueryInterceptorDatabase$beginTransactionNonExclusive$1(this, null), 3);
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionReadOnly() {
        this.delegate.beginTransactionReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        sQLiteTransactionListener.getClass();
        c0.s(this.queryCallbackScope, null, null, new QueryInterceptorDatabase$beginTransactionWithListener$1(this, null), 3);
        this.delegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        sQLiteTransactionListener.getClass();
        c0.s(this.queryCallbackScope, null, null, new QueryInterceptorDatabase$beginTransactionWithListenerNonExclusive$1(this, null), 3);
        this.delegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerReadOnly(SQLiteTransactionListener sQLiteTransactionListener) {
        sQLiteTransactionListener.getClass();
        this.delegate.beginTransactionWithListenerReadOnly(sQLiteTransactionListener);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String str) {
        str.getClass();
        return new QueryInterceptorStatement(this.delegate.compileStatement(str), str, this.queryCallbackScope, this.queryCallback);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String str, String str2, Object[] objArr) {
        str.getClass();
        return this.delegate.delete(str, str2, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        c0.s(this.queryCallbackScope, null, null, new QueryInterceptorDatabase$endTransaction$1(this, null), 3);
        this.delegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execPerConnectionSQL(String str, @SuppressLint({"ArrayReturn"}) Object[] objArr) {
        str.getClass();
        this.delegate.execPerConnectionSQL(str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String str, Object[] objArr) {
        str.getClass();
        objArr.getClass();
        c0.s(this.queryCallbackScope, null, null, new QueryInterceptorDatabase$execSQL$2(this, str, j.m0(objArr), null), 3);
        this.delegate.execSQL(str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String getPath() {
        return this.delegate.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.delegate.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String str, int i, ContentValues contentValues) {
        str.getClass();
        contentValues.getClass();
        return this.delegate.insert(str, i, contentValues);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isExecPerConnectionSQLSupported() {
        return this.delegate.isExecPerConnectionSQLSupported();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int i) {
        return this.delegate.needUpgrade(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        supportSQLiteQuery.getClass();
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        c0.s(this.queryCallbackScope, null, null, new QueryInterceptorDatabase$query$3(this, supportSQLiteQuery, queryInterceptorProgram, null), 3);
        return this.delegate.query(supportSQLiteQuery);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean z9) {
        this.delegate.setForeignKeyConstraintsEnabled(z9);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale locale) {
        locale.getClass();
        this.delegate.setLocale(locale);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int i) {
        this.delegate.setMaxSqlCacheSize(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long j) {
        return this.delegate.setMaximumSize(j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long j) {
        this.delegate.setPageSize(j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        c0.s(this.queryCallbackScope, null, null, new QueryInterceptorDatabase$setTransactionSuccessful$1(this, null), 3);
        this.delegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int i) {
        this.delegate.setVersion(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String str, int i, ContentValues contentValues, String str2, Object[] objArr) {
        str.getClass();
        contentValues.getClass();
        return this.delegate.update(str, i, contentValues, str2, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long j) {
        return this.delegate.yieldIfContendedSafely(j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String str) {
        str.getClass();
        c0.s(this.queryCallbackScope, null, null, new QueryInterceptorDatabase$execSQL$1(this, str, null), 3);
        this.delegate.execSQL(str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String str, Object[] objArr) {
        str.getClass();
        objArr.getClass();
        c0.s(this.queryCallbackScope, null, null, new QueryInterceptorDatabase$query$2(this, str, j.m0(objArr), null), 3);
        return this.delegate.query(str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String str) {
        str.getClass();
        c0.s(this.queryCallbackScope, null, null, new QueryInterceptorDatabase$query$1(this, str, null), 3);
        return this.delegate.query(str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        supportSQLiteQuery.getClass();
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        c0.s(this.queryCallbackScope, null, null, new QueryInterceptorDatabase$query$4(this, supportSQLiteQuery, queryInterceptorProgram, null), 3);
        return this.delegate.query(supportSQLiteQuery);
    }
}
