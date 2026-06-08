package androidx.room.util;

import android.os.Build;
import androidx.sqlite.SQLiteStatement;
import l7.u;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final /* synthetic */ class SQLiteStatementUtil__StatementUtil_androidKt {
    public static final int columnIndexOf(SQLiteStatement sQLiteStatement, String str) {
        sQLiteStatement.getClass();
        str.getClass();
        int columnIndexOfCommon = SQLiteStatementUtil.columnIndexOfCommon(sQLiteStatement, str);
        if (columnIndexOfCommon >= 0) {
            return columnIndexOfCommon;
        }
        int columnIndexOfCommon2 = SQLiteStatementUtil.columnIndexOfCommon(sQLiteStatement, "`" + str + '`');
        return columnIndexOfCommon2 >= 0 ? columnIndexOfCommon2 : findColumnIndexBySuffix$SQLiteStatementUtil__StatementUtil_androidKt(sQLiteStatement, str);
    }

    private static final int findColumnIndexBySuffix$SQLiteStatementUtil__StatementUtil_androidKt(SQLiteStatement sQLiteStatement, String str) {
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        int columnCount = sQLiteStatement.getColumnCount();
        String concat = ".".concat(str);
        String str2 = "." + str + '`';
        for (int i = 0; i < columnCount; i++) {
            String columnName = sQLiteStatement.getColumnName(i);
            if (columnName.length() >= str.length() + 2 && (u.k0(columnName, concat, false) || (columnName.charAt(0) == '`' && u.k0(columnName, str2, false)))) {
                return i;
            }
        }
        return -1;
    }
}
