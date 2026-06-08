package androidx.room.util;

import a.a;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.EnvironmentCompat;
import d7.l;
import l7.u;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CursorUtil {
    public static final Cursor copyAndClose(Cursor cursor) {
        cursor.getClass();
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                int columnCount = cursor.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    int type = cursor.getType(i);
                    if (type == 0) {
                        objArr[i] = null;
                    } else if (type == 1) {
                        objArr[i] = Long.valueOf(cursor.getLong(i));
                    } else if (type == 2) {
                        objArr[i] = Double.valueOf(cursor.getDouble(i));
                    } else if (type == 3) {
                        objArr[i] = cursor.getString(i);
                    } else {
                        if (type != 4) {
                            throw new IllegalStateException();
                        }
                        objArr[i] = cursor.getBlob(i);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            cursor.close();
            return matrixCursor;
        } finally {
        }
    }

    @VisibleForTesting
    public static final int findColumnIndexBySuffix(String[] strArr, String str) {
        strArr.getClass();
        str.getClass();
        String concat = ".".concat(str);
        String str2 = "." + str + '`';
        int length = strArr.length;
        int i = 0;
        int i6 = 0;
        while (i < length) {
            String str3 = strArr[i];
            int i10 = i6 + 1;
            if (str3.length() >= str.length() + 2 && (u.k0(str3, concat, false) || (str3.charAt(0) == '`' && u.k0(str3, str2, false)))) {
                return i6;
            }
            i++;
            i6 = i10;
        }
        return -1;
    }

    public static final int getColumnIndex(Cursor cursor, String str) {
        cursor.getClass();
        str.getClass();
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex("`" + str + '`');
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(cursor, str);
    }

    public static final int getColumnIndexOrThrow(Cursor cursor, String str) {
        String str2;
        cursor.getClass();
        str.getClass();
        int columnIndex = getColumnIndex(cursor, str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            columnNames.getClass();
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) "");
            int i = 0;
            for (String str3 : columnNames) {
                i++;
                if (i > 1) {
                    sb.append((CharSequence) ", ");
                }
                a.i(sb, str3, null);
            }
            sb.append((CharSequence) "");
            str2 = sb.toString();
        } catch (Exception e10) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e10);
            str2 = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.t("column '", str, "' does not exist. Available columns: ", str2);
        return 0;
    }

    public static final <R> R useCursor(Cursor cursor, l lVar) {
        cursor.getClass();
        lVar.getClass();
        try {
            R r9 = (R) lVar.invoke(cursor);
            cursor.close();
            return r9;
        } finally {
        }
    }

    public static final Cursor wrapMappedColumns(final Cursor cursor, final String[] strArr, final int[] iArr) {
        cursor.getClass();
        strArr.getClass();
        iArr.getClass();
        if (strArr.length == iArr.length) {
            return new CursorWrapper(cursor) { // from class: androidx.room.util.CursorUtil$wrapMappedColumns$2
                @Override // android.database.CursorWrapper, android.database.Cursor
                public int getColumnIndex(String str) {
                    str.getClass();
                    String[] strArr2 = strArr;
                    int[] iArr2 = iArr;
                    int length = strArr2.length;
                    int i = 0;
                    int i6 = 0;
                    while (i < length) {
                        int i10 = i6 + 1;
                        if (u.m0(strArr2[i], str, true)) {
                            return iArr2[i6];
                        }
                        i++;
                        i6 = i10;
                    }
                    return super.getColumnIndex(str);
                }
            };
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Expected columnNames.length == mapping.length");
        return null;
    }

    private static final int findColumnIndexBySuffix(Cursor cursor, String str) {
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        String[] columnNames = cursor.getColumnNames();
        columnNames.getClass();
        return findColumnIndexBySuffix(columnNames, str);
    }
}
