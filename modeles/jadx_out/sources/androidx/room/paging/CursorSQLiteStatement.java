package androidx.room.paging;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.l;
import androidx.sqlite.SQLiteStatement;
import java.util.List;
import kotlin.jvm.internal.g;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CursorSQLiteStatement implements SQLiteStatement {
    public static final Companion Companion = new Companion(null);
    private final Cursor cursor;

    public CursorSQLiteStatement(Cursor cursor) {
        cursor.getClass();
        this.cursor = cursor;
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindBlob, reason: merged with bridge method [inline-methods] */
    public Void mo88bindBlob(int i, byte[] bArr) {
        bArr.getClass();
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final void bindBoolean(int i, boolean z9) {
        mo90bindLong(i, z9 ? 1L : 0L);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindDouble, reason: merged with bridge method [inline-methods] */
    public Void mo89bindDouble(int i, double d10) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final void bindFloat(int i, float f) {
        mo89bindDouble(i, f);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final void bindInt(int i, int i6) {
        mo90bindLong(i, i6);
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindLong, reason: merged with bridge method [inline-methods] */
    public Void mo90bindLong(int i, long j) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindNull, reason: merged with bridge method [inline-methods] */
    public Void mo91bindNull(int i) {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: bindText, reason: merged with bridge method [inline-methods] */
    public Void mo92bindText(int i, String str) {
        str.getClass();
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement
    /* renamed from: clearBindings, reason: merged with bridge method [inline-methods] */
    public Void mo93clearBindings() {
        throw new IllegalStateException("Only get*() calls are allowed on a Cursor backed SQLiteStatement");
    }

    @Override // androidx.sqlite.SQLiteStatement, java.lang.AutoCloseable
    public void close() {
        this.cursor.close();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public byte[] getBlob(int i) {
        byte[] blob = this.cursor.getBlob(i);
        blob.getClass();
        return blob;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final /* synthetic */ boolean getBoolean(int i) {
        return l.c(this, i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnCount() {
        return this.cursor.getColumnCount();
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String getColumnName(int i) {
        String columnName = this.cursor.getColumnName(i);
        columnName.getClass();
        return columnName;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final /* synthetic */ List getColumnNames() {
        return l.d(this);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public int getColumnType(int i) {
        return Companion.getDataType(this.cursor, i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public double getDouble(int i) {
        return this.cursor.getDouble(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final float getFloat(int i) {
        return (float) getDouble(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public final int getInt(int i) {
        return (int) getLong(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public long getLong(int i) {
        return this.cursor.getLong(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public String getText(int i) {
        String string = this.cursor.getString(i);
        string.getClass();
        return string;
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean isNull(int i) {
        return this.cursor.isNull(i);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public void reset() {
        this.cursor.moveToPosition(-1);
    }

    @Override // androidx.sqlite.SQLiteStatement
    public boolean step() {
        return this.cursor.moveToNext();
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getDataType(Cursor cursor, int i) {
            int type = cursor.getType(i);
            int type2 = cursor.getType(i);
            if (type2 == 0) {
                return 5;
            }
            int i6 = 1;
            if (type2 != 1) {
                i6 = 2;
                if (type2 != 2) {
                    i6 = 3;
                    if (type2 != 3) {
                        if (type2 == 4) {
                            return 4;
                        }
                        o.h(type, "Unknown field type: ");
                        return 0;
                    }
                }
            }
            return i6;
        }

        private Companion() {
        }
    }
}
