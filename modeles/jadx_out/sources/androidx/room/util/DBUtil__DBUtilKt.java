package androidx.room.util;

import a.a;
import a4.x;
import android.database.SQLException;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import d7.p;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import l7.u;
import r6.c;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final /* synthetic */ class DBUtil__DBUtilKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void dropFtsSyncTriggers(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        c t9 = a.t();
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (prepare.step()) {
            try {
                t9.add(prepare.getText(0));
            } finally {
            }
        }
        f.g(prepare, null);
        ListIterator listIterator = a.m(t9).listIterator(0);
        while (true) {
            r6.a aVar = (r6.a) listIterator;
            if (!aVar.hasNext()) {
                return;
            }
            String str = (String) aVar.next();
            if (u.p0(str, "room_fts_content_sync_", false)) {
                SQLite.execSQL(sQLiteConnection, "DROP TRIGGER IF EXISTS ".concat(str));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void foreignKeyCheck(SQLiteConnection sQLiteConnection, String str) {
        sQLiteConnection.getClass();
        str.getClass();
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA foreign_key_check(`" + str + "`)");
        try {
            if (prepare.step()) {
                throw new SQLException(processForeignKeyCheckFailure$DBUtil__DBUtilKt(prepare));
            }
            f.g(prepare, null);
        } finally {
        }
    }

    public static final <R> Object internalPerform(RoomDatabase roomDatabase, boolean z9, boolean z10, p pVar, t6.c cVar) {
        return roomDatabase.useConnection$room_runtime_release(z9, new DBUtil__DBUtilKt$internalPerform$2(z10, z9, roomDatabase, pVar, null), cVar);
    }

    private static final String processForeignKeyCheckFailure$DBUtil__DBUtilKt(SQLiteStatement sQLiteStatement) {
        StringBuilder sb = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        do {
            if (i == 0) {
                sb.append("Foreign key violation(s) detected in '");
                sb.append(sQLiteStatement.getText(0));
                sb.append("'.\n");
            }
            String text = sQLiteStatement.getText(3);
            if (!linkedHashMap.containsKey(text)) {
                linkedHashMap.put(text, sQLiteStatement.getText(2));
            }
            i++;
        } while (sQLiteStatement.step());
        sb.append("Number of different violations discovered: ");
        sb.append(linkedHashMap.keySet().size());
        sb.append("\nNumber of rows in violation: ");
        sb.append(i);
        sb.append("\nViolation(s) detected in the following constraint(s):\n");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            x.B(sb, "\tParent Table = ", (String) entry.getValue(), ", Foreign Key Constraint Index = ", (String) entry.getKey());
            sb.append("\n");
        }
        return sb.toString();
    }
}
