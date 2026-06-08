package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.core.content.pm.a;
import androidx.sqlite.SQLiteStatement;
import java.util.ArrayList;
import q6.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final /* synthetic */ class SQLiteStatementUtil__StatementUtilKt {
    public static final int columnIndexOfCommon(SQLiteStatement sQLiteStatement, String str) {
        sQLiteStatement.getClass();
        str.getClass();
        if (sQLiteStatement instanceof MappedColumnsSQLiteStatementWrapper) {
            return ((MappedColumnsSQLiteStatementWrapper) sQLiteStatement).getColumnIndex(str);
        }
        int columnCount = sQLiteStatement.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            if (str.equals(sQLiteStatement.getColumnName(i))) {
                return i;
            }
        }
        return -1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int getColumnIndex(SQLiteStatement sQLiteStatement, String str) {
        sQLiteStatement.getClass();
        str.getClass();
        return SQLiteStatementUtil.columnIndexOf(sQLiteStatement, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int getColumnIndexOrThrow(SQLiteStatement sQLiteStatement, String str) {
        sQLiteStatement.getClass();
        str.getClass();
        int columnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, str);
        if (columnIndexOf >= 0) {
            return columnIndexOf;
        }
        int columnCount = sQLiteStatement.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i = 0; i < columnCount; i++) {
            arrayList.add(sQLiteStatement.getColumnName(i));
        }
        a.g(93, str, "' does not exist. Available columns: [", l.x0(arrayList, null, null, null, null, 63), "Column '");
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final SQLiteStatement wrapMappedColumns(SQLiteStatement sQLiteStatement, String[] strArr, int[] iArr) {
        sQLiteStatement.getClass();
        strArr.getClass();
        iArr.getClass();
        return new MappedColumnsSQLiteStatementWrapper(sQLiteStatement, strArr, iArr);
    }
}
