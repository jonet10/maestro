package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements SQLiteDatabase.CursorFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f511a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f512b;

    public /* synthetic */ a(Object obj, int i) {
        this.f511a = i;
        this.f512b = obj;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        Cursor query$lambda$2;
        Cursor query$lambda$1;
        switch (this.f511a) {
            case 0:
                query$lambda$2 = FrameworkSQLiteDatabase.query$lambda$2((SupportSQLiteQuery) this.f512b, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                return query$lambda$2;
            default:
                query$lambda$1 = FrameworkSQLiteDatabase.query$lambda$1((b) this.f512b, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                return query$lambda$1;
        }
    }
}
