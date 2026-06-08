package androidx.sqlite.driver;

import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.l;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AndroidSQLiteConnection implements SQLiteConnection {
    private final SQLiteDatabase db;

    public AndroidSQLiteConnection(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.getClass();
        this.db = sQLiteDatabase;
    }

    @Override // androidx.sqlite.SQLiteConnection, java.lang.AutoCloseable
    public void close() {
        this.db.close();
    }

    public final SQLiteDatabase getDb() {
        return this.db;
    }

    @Override // androidx.sqlite.SQLiteConnection
    public SQLiteStatement prepare(String str) {
        str.getClass();
        if (this.db.isOpen()) {
            return AndroidSQLiteStatement.Companion.create(this.db, str);
        }
        throw l.p(21, "connection is closed");
    }
}
