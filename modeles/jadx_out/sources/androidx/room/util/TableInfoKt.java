package androidx.room.util;

import androidx.room.util.TableInfo;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import kotlin.jvm.internal.l;
import l7.m;
import l7.n;
import l7.u;
import p6.x;
import q6.t;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TableInfoKt {
    private static final boolean containsSurroundingParenthesis(String str) {
        if (str.length() == 0) {
            return false;
        }
        int i = 0;
        int i6 = 0;
        int i10 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            int i11 = i10 + 1;
            if (i10 == 0 && charAt != '(') {
                return false;
            }
            if (charAt == '(') {
                i6++;
            } else if (charAt == ')' && i6 - 1 == 0 && i10 != str.length() - 1) {
                return false;
            }
            i++;
            i10 = i11;
        }
        return i6 == 0;
    }

    public static final boolean defaultValueEqualsCommon(String str, String str2) {
        str.getClass();
        if (str.equals(str2)) {
            return true;
        }
        if (containsSurroundingParenthesis(str)) {
            return l.a(m.K0(str.substring(1, str.length() - 1)).toString(), str2);
        }
        return false;
    }

    public static final boolean equalsCommon(TableInfo.Column column, Object obj) {
        column.getClass();
        if (column == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.Column)) {
            return false;
        }
        TableInfo.Column column2 = (TableInfo.Column) obj;
        if (column.isPrimaryKey() != column2.isPrimaryKey() || !l.a(column.name, column2.name) || column.notNull != column2.notNull) {
            return false;
        }
        String str = column.defaultValue;
        String str2 = column2.defaultValue;
        if (column.createdFrom == 1 && column2.createdFrom == 2 && str != null && !defaultValueEqualsCommon(str, str2)) {
            return false;
        }
        if (column.createdFrom == 2 && column2.createdFrom == 1 && str2 != null && !defaultValueEqualsCommon(str2, str)) {
            return false;
        }
        int i = column.createdFrom;
        return (i == 0 || i != column2.createdFrom || (str == null ? str2 == null : defaultValueEqualsCommon(str, str2))) && column.affinity == column2.affinity;
    }

    public static final String formatString(Collection<?> collection) {
        collection.getClass();
        return !collection.isEmpty() ? n.c0(q6.l.x0(collection, ",\n", "\n", "\n", null, 56)).concat("},") : " }";
    }

    public static final int hashCodeCommon(TableInfo.Index index) {
        index.getClass();
        return index.orders.hashCode() + ((index.columns.hashCode() + ((((u.p0(index.name, TableInfo.Index.DEFAULT_PREFIX, false) ? -1184239155 : index.name.hashCode()) * 31) + (index.unique ? 1 : 0)) * 31)) * 31);
    }

    private static final void joinToStringEndWithIndent(Collection<?> collection) {
        n.c0(q6.l.x0(collection, ",", null, null, null, 62));
        n.c0(" }");
    }

    private static final void joinToStringMiddleWithIndent(Collection<?> collection) {
        n.c0(q6.l.x0(collection, ",", null, null, null, 62));
        n.c0("},");
    }

    public static final String toStringCommon(TableInfo tableInfo) {
        tableInfo.getClass();
        StringBuilder sb = new StringBuilder("\n            |TableInfo {\n            |    name = '");
        sb.append(tableInfo.name);
        sb.append("',\n            |    columns = {");
        sb.append(formatString(q6.l.C0(tableInfo.columns.values(), new Comparator() { // from class: androidx.room.util.TableInfoKt$toStringCommon$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t9, T t10) {
                return f.l(((TableInfo.Column) t9).name, ((TableInfo.Column) t10).name);
            }
        })));
        sb.append("\n            |    foreignKeys = {");
        sb.append(formatString(tableInfo.foreignKeys));
        sb.append("\n            |    indices = {");
        Set<TableInfo.Index> set = tableInfo.indices;
        sb.append(formatString(set != null ? q6.l.C0(set, new Comparator() { // from class: androidx.room.util.TableInfoKt$toStringCommon$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t9, T t10) {
                return f.l(((TableInfo.Index) t9).name, ((TableInfo.Index) t10).name);
            }
        }) : t.f8724a));
        sb.append("\n            |}\n        ");
        return n.e0(sb.toString());
    }

    public static final int hashCodeCommon(TableInfo.Column column) {
        column.getClass();
        return (((((column.name.hashCode() * 31) + column.affinity) * 31) + (column.notNull ? 1231 : 1237)) * 31) + column.primaryKeyPosition;
    }

    public static final int hashCodeCommon(TableInfo.ForeignKey foreignKey) {
        foreignKey.getClass();
        return foreignKey.referenceColumnNames.hashCode() + ((foreignKey.columnNames.hashCode() + androidx.lifecycle.l.o(androidx.lifecycle.l.o(foreignKey.referenceTable.hashCode() * 31, 31, foreignKey.onDelete), 31, foreignKey.onUpdate)) * 31);
    }

    public static final int hashCodeCommon(TableInfo tableInfo) {
        tableInfo.getClass();
        return tableInfo.foreignKeys.hashCode() + ((tableInfo.columns.hashCode() + (tableInfo.name.hashCode() * 31)) * 31);
    }

    public static final String toStringCommon(TableInfo.Column column) {
        column.getClass();
        StringBuilder sb = new StringBuilder("\n            |Column {\n            |   name = '");
        sb.append(column.name);
        sb.append("',\n            |   type = '");
        sb.append(column.type);
        sb.append("',\n            |   affinity = '");
        sb.append(column.affinity);
        sb.append("',\n            |   notNull = '");
        sb.append(column.notNull);
        sb.append("',\n            |   primaryKeyPosition = '");
        sb.append(column.primaryKeyPosition);
        sb.append("',\n            |   defaultValue = '");
        String str = column.defaultValue;
        if (str == null) {
            str = "undefined";
        }
        sb.append(str);
        sb.append("'\n            |}\n        ");
        return n.c0(n.e0(sb.toString()));
    }

    public static final boolean equalsCommon(TableInfo tableInfo, Object obj) {
        Set<TableInfo.Index> set;
        tableInfo.getClass();
        if (tableInfo == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo2 = (TableInfo) obj;
        if (!l.a(tableInfo.name, tableInfo2.name) || !l.a(tableInfo.columns, tableInfo2.columns) || !l.a(tableInfo.foreignKeys, tableInfo2.foreignKeys)) {
            return false;
        }
        Set<TableInfo.Index> set2 = tableInfo.indices;
        if (set2 == null || (set = tableInfo2.indices) == null) {
            return true;
        }
        return l.a(set2, set);
    }

    public static final boolean equalsCommon(TableInfo.ForeignKey foreignKey, Object obj) {
        foreignKey.getClass();
        if (foreignKey == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.ForeignKey)) {
            return false;
        }
        TableInfo.ForeignKey foreignKey2 = (TableInfo.ForeignKey) obj;
        if (l.a(foreignKey.referenceTable, foreignKey2.referenceTable) && l.a(foreignKey.onDelete, foreignKey2.onDelete) && l.a(foreignKey.onUpdate, foreignKey2.onUpdate) && l.a(foreignKey.columnNames, foreignKey2.columnNames)) {
            return l.a(foreignKey.referenceColumnNames, foreignKey2.referenceColumnNames);
        }
        return false;
    }

    public static final boolean equalsCommon(TableInfo.Index index, Object obj) {
        index.getClass();
        if (index == obj) {
            return true;
        }
        if (obj instanceof TableInfo.Index) {
            TableInfo.Index index2 = (TableInfo.Index) obj;
            if (index.unique == index2.unique && l.a(index.columns, index2.columns) && l.a(index.orders, index2.orders)) {
                if (u.p0(index.name, TableInfo.Index.DEFAULT_PREFIX, false)) {
                    return u.p0(index2.name, TableInfo.Index.DEFAULT_PREFIX, false);
                }
                return l.a(index.name, index2.name);
            }
        }
        return false;
    }

    public static final String toStringCommon(TableInfo.ForeignKey foreignKey) {
        foreignKey.getClass();
        StringBuilder sb = new StringBuilder("\n            |ForeignKey {\n            |   referenceTable = '");
        sb.append(foreignKey.referenceTable);
        sb.append("',\n            |   onDelete = '");
        sb.append(foreignKey.onDelete);
        sb.append("',\n            |   onUpdate = '");
        sb.append(foreignKey.onUpdate);
        sb.append("',\n            |   columnNames = {");
        joinToStringMiddleWithIndent(q6.l.B0(foreignKey.columnNames));
        x xVar = x.f8463a;
        sb.append(xVar);
        sb.append("\n            |   referenceColumnNames = {");
        joinToStringEndWithIndent(q6.l.B0(foreignKey.referenceColumnNames));
        sb.append(xVar);
        sb.append("\n            |}\n        ");
        return n.c0(n.e0(sb.toString()));
    }

    public static final String toStringCommon(TableInfo.Index index) {
        index.getClass();
        StringBuilder sb = new StringBuilder("\n            |Index {\n            |   name = '");
        sb.append(index.name);
        sb.append("',\n            |   unique = '");
        sb.append(index.unique);
        sb.append("',\n            |   columns = {");
        joinToStringMiddleWithIndent(index.columns);
        x xVar = x.f8463a;
        sb.append(xVar);
        sb.append("\n            |   orders = {");
        joinToStringEndWithIndent(index.orders);
        sb.append(xVar);
        sb.append("\n            |}\n        ");
        return n.c0(n.e0(sb.toString()));
    }
}
