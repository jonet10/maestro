package androidx.room.support;

import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class QueryInterceptorProgram implements SupportSQLiteProgram {
    private final List<Object> bindArgsCache = new ArrayList();

    private final void saveArgsToCache(int i, Object obj) {
        int size;
        int i6 = i - 1;
        if (i6 >= this.bindArgsCache.size() && (size = this.bindArgsCache.size()) <= i6) {
            while (true) {
                this.bindArgsCache.add(null);
                if (size == i6) {
                    break;
                } else {
                    size++;
                }
            }
        }
        this.bindArgsCache.set(i6, obj);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i, byte[] bArr) {
        bArr.getClass();
        saveArgsToCache(i, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i, double d10) {
        saveArgsToCache(i, Double.valueOf(d10));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i, long j) {
        saveArgsToCache(i, Long.valueOf(j));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i) {
        saveArgsToCache(i, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i, String str) {
        str.getClass();
        saveArgsToCache(i, str);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.bindArgsCache.clear();
    }

    public final List<Object> getBindArgsCache$room_runtime_release() {
        return this.bindArgsCache;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
