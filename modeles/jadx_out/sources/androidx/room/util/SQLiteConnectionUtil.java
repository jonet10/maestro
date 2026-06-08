package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SQLiteConnectionUtil {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final long getLastInsertedRowId(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        if (getTotalChangedRows(sQLiteConnection) == 0) {
            return -1L;
        }
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT last_insert_rowid()");
        try {
            prepare.step();
            long j = prepare.getLong(0);
            f.g(prepare, null);
            return j;
        } finally {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int getTotalChangedRows(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT changes()");
        try {
            prepare.step();
            int i = (int) prepare.getLong(0);
            f.g(prepare, null);
            return i;
        } finally {
        }
    }
}
