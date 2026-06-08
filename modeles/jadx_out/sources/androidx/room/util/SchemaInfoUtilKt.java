package androidx.room.util;

import a.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.ColumnInfo;
import androidx.room.util.TableInfo;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.google.android.gms.internal.measurement.z3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.l;
import l7.m;
import l7.u;
import q6.i;
import q6.n;
import q6.r;
import q6.v;
import r6.c;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SchemaInfoUtilKt {
    private static final String[] FTS_OPTIONS = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};

    @ColumnInfo.SQLiteTypeAffinity
    public static final int findAffinity(String str) {
        if (str == null) {
            return 5;
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        upperCase.getClass();
        if (m.q0(upperCase, "INT", false)) {
            return 3;
        }
        if (m.q0(upperCase, "CHAR", false) || m.q0(upperCase, "CLOB", false) || m.q0(upperCase, "TEXT", false)) {
            return 2;
        }
        if (m.q0(upperCase, "BLOB", false)) {
            return 5;
        }
        return (m.q0(upperCase, "REAL", false) || m.q0(upperCase, "FLOA", false) || m.q0(upperCase, "DOUB", false)) ? 4 : 1;
    }

    public static final Set<String> parseFtsOptions(String str) {
        str.getClass();
        if (str.length() == 0) {
            return v.f8726a;
        }
        String substring = str.substring(m.x0('(', 0, 6, str) + 1, str.lastIndexOf(41, m.u0(str)));
        ArrayList arrayList = new ArrayList();
        i iVar = new i();
        int i = -1;
        int i6 = 0;
        int i10 = 0;
        while (i6 < substring.length()) {
            char charAt = substring.charAt(i6);
            int i11 = i10 + 1;
            if (charAt != '\"' && charAt != '\'') {
                if (charAt != ',') {
                    if (charAt != '[') {
                        if (charAt != ']') {
                            if (charAt != '`') {
                            }
                        } else if (!iVar.isEmpty()) {
                            Character ch = (Character) (iVar.isEmpty() ? null : iVar.f8721b[iVar.f8720a]);
                            if (ch != null && ch.charValue() == '[') {
                                r.n0(iVar);
                            }
                        }
                    } else if (iVar.isEmpty()) {
                        iVar.addFirst(Character.valueOf(charAt));
                    }
                } else if (iVar.isEmpty()) {
                    String substring2 = substring.substring(i + 1, i10);
                    int length = substring2.length() - 1;
                    int i12 = 0;
                    boolean z9 = false;
                    while (i12 <= length) {
                        boolean z10 = l.c(substring2.charAt(!z9 ? i12 : length), 32) <= 0;
                        if (z9) {
                            if (!z10) {
                                break;
                            }
                            length--;
                        } else if (z10) {
                            i12++;
                        } else {
                            z9 = true;
                        }
                    }
                    arrayList.add(substring2.subSequence(i12, length + 1).toString());
                    i = i10;
                }
                i6++;
                i10 = i11;
            }
            if (iVar.isEmpty()) {
                iVar.addFirst(Character.valueOf(charAt));
            } else {
                Character ch2 = (Character) (iVar.isEmpty() ? null : iVar.f8721b[iVar.f8720a]);
                if (ch2 != null && ch2.charValue() == charAt) {
                    r.n0(iVar);
                }
            }
            i6++;
            i10 = i11;
        }
        arrayList.add(m.K0(substring.substring(i + 1)).toString());
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i13 = 0;
        while (i13 < size) {
            Object obj = arrayList.get(i13);
            i13++;
            String str2 = (String) obj;
            String[] strArr = FTS_OPTIONS;
            int length2 = strArr.length;
            int i14 = 0;
            while (true) {
                if (i14 >= length2) {
                    break;
                }
                if (u.p0(str2, strArr[i14], false)) {
                    arrayList2.add(obj);
                    break;
                }
                i14++;
            }
        }
        return q6.l.J0(arrayList2);
    }

    private static final Map<String, TableInfo.Column> readColumns(SQLiteConnection sQLiteConnection, String str) {
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA table_info(`" + str + "`)");
        try {
            if (!prepare.step()) {
                q6.u uVar = q6.u.f8725a;
                f.g(prepare, null);
                return uVar;
            }
            int columnIndexOf = SQLiteStatementUtil.columnIndexOf(prepare, "name");
            int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(prepare, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(prepare, "notnull");
            int columnIndexOf4 = SQLiteStatementUtil.columnIndexOf(prepare, "pk");
            int columnIndexOf5 = SQLiteStatementUtil.columnIndexOf(prepare, "dflt_value");
            r6.f fVar = new r6.f();
            do {
                String text = prepare.getText(columnIndexOf);
                fVar.put(text, new TableInfo.Column(text, prepare.getText(columnIndexOf2), prepare.getLong(columnIndexOf3) != 0, (int) prepare.getLong(columnIndexOf4), prepare.isNull(columnIndexOf5) ? null : prepare.getText(columnIndexOf5), 2));
            } while (prepare.step());
            r6.f c9 = fVar.c();
            f.g(prepare, null);
            return c9;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                f.g(prepare, th);
                throw th2;
            }
        }
    }

    private static final List<ForeignKeyWithSequence> readForeignKeyFieldMappings(SQLiteStatement sQLiteStatement) {
        int columnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "id");
        int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "seq");
        int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, TypedValues.TransitionType.S_FROM);
        int columnIndexOf4 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, TypedValues.TransitionType.S_TO);
        c t9 = a.t();
        while (sQLiteStatement.step()) {
            t9.add(new ForeignKeyWithSequence((int) sQLiteStatement.getLong(columnIndexOf), (int) sQLiteStatement.getLong(columnIndexOf2), sQLiteStatement.getText(columnIndexOf3), sQLiteStatement.getText(columnIndexOf4)));
        }
        return q6.l.B0(a.m(t9));
    }

    private static final Set<TableInfo.ForeignKey> readForeignKeys(SQLiteConnection sQLiteConnection, String str) {
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndexOf = SQLiteStatementUtil.columnIndexOf(prepare, "id");
            int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(prepare, "seq");
            int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(prepare, "table");
            int columnIndexOf4 = SQLiteStatementUtil.columnIndexOf(prepare, "on_delete");
            int columnIndexOf5 = SQLiteStatementUtil.columnIndexOf(prepare, "on_update");
            List<ForeignKeyWithSequence> readForeignKeyFieldMappings = readForeignKeyFieldMappings(prepare);
            prepare.reset();
            r6.i iVar = new r6.i();
            while (prepare.step()) {
                if (prepare.getLong(columnIndexOf2) == 0) {
                    int i = (int) prepare.getLong(columnIndexOf);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : readForeignKeyFieldMappings) {
                        if (((ForeignKeyWithSequence) obj).getId() == i) {
                            arrayList3.add(obj);
                        }
                    }
                    int size = arrayList3.size();
                    int i6 = 0;
                    while (i6 < size) {
                        Object obj2 = arrayList3.get(i6);
                        i6++;
                        ForeignKeyWithSequence foreignKeyWithSequence = (ForeignKeyWithSequence) obj2;
                        arrayList.add(foreignKeyWithSequence.getFrom());
                        arrayList2.add(foreignKeyWithSequence.getTo());
                    }
                    iVar.add(new TableInfo.ForeignKey(prepare.getText(columnIndexOf3), prepare.getText(columnIndexOf4), prepare.getText(columnIndexOf5), arrayList, arrayList2));
                }
            }
            r6.i g = z3.g(iVar);
            f.g(prepare, null);
            return g;
        } finally {
        }
    }

    public static final Set<String> readFtsColumns(SQLiteConnection sQLiteConnection, String str) {
        sQLiteConnection.getClass();
        str.getClass();
        r6.i iVar = new r6.i();
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA table_info(`" + str + "`)");
        try {
            if (prepare.step()) {
                int columnIndexOf = SQLiteStatementUtil.columnIndexOf(prepare, "name");
                do {
                    iVar.add(prepare.getText(columnIndexOf));
                } while (prepare.step());
            }
            f.g(prepare, null);
            return z3.g(iVar);
        } finally {
        }
    }

    public static final Set<String> readFtsOptions(SQLiteConnection sQLiteConnection, String str) {
        sQLiteConnection.getClass();
        str.getClass();
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * FROM sqlite_master WHERE `name` = '" + str + '\'');
        try {
            String text = prepare.step() ? prepare.getText(SQLiteStatementUtil.columnIndexOf(prepare, "sql")) : "";
            f.g(prepare, null);
            return parseFtsOptions(text);
        } finally {
        }
    }

    private static final TableInfo.Index readIndex(SQLiteConnection sQLiteConnection, String str, boolean z9) {
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndexOf = SQLiteStatementUtil.columnIndexOf(prepare, "seqno");
            int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(prepare, "cid");
            int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(prepare, "name");
            int columnIndexOf4 = SQLiteStatementUtil.columnIndexOf(prepare, "desc");
            if (columnIndexOf != -1 && columnIndexOf2 != -1 && columnIndexOf3 != -1 && columnIndexOf4 != -1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                while (prepare.step()) {
                    if (((int) prepare.getLong(columnIndexOf2)) >= 0) {
                        int i = (int) prepare.getLong(columnIndexOf);
                        String text = prepare.getText(columnIndexOf3);
                        String str2 = prepare.getLong(columnIndexOf4) > 0 ? "DESC" : "ASC";
                        linkedHashMap.put(Integer.valueOf(i), text);
                        linkedHashMap2.put(Integer.valueOf(i), str2);
                    }
                }
                List C0 = q6.l.C0(linkedHashMap.entrySet(), new Comparator() { // from class: androidx.room.util.SchemaInfoUtilKt$readIndex$lambda$13$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t9, T t10) {
                        return f.l((Integer) ((Map.Entry) t9).getKey(), (Integer) ((Map.Entry) t10).getKey());
                    }
                });
                ArrayList arrayList = new ArrayList(n.i0(C0, 10));
                Iterator it = C0.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Map.Entry) it.next()).getValue());
                }
                List G0 = q6.l.G0(arrayList);
                List C02 = q6.l.C0(linkedHashMap2.entrySet(), new Comparator() { // from class: androidx.room.util.SchemaInfoUtilKt$readIndex$lambda$13$$inlined$sortedBy$2
                    @Override // java.util.Comparator
                    public final int compare(T t9, T t10) {
                        return f.l((Integer) ((Map.Entry) t9).getKey(), (Integer) ((Map.Entry) t10).getKey());
                    }
                });
                ArrayList arrayList2 = new ArrayList(n.i0(C02, 10));
                Iterator it2 = C02.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((String) ((Map.Entry) it2.next()).getValue());
                }
                TableInfo.Index index = new TableInfo.Index(str, z9, G0, q6.l.G0(arrayList2));
                f.g(prepare, null);
                return index;
            }
            f.g(prepare, null);
            return null;
        } finally {
        }
    }

    private static final Set<TableInfo.Index> readIndices(SQLiteConnection sQLiteConnection, String str) {
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndexOf = SQLiteStatementUtil.columnIndexOf(prepare, "name");
            int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(prepare, "origin");
            int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(prepare, "unique");
            if (columnIndexOf != -1 && columnIndexOf2 != -1 && columnIndexOf3 != -1) {
                r6.i iVar = new r6.i();
                while (prepare.step()) {
                    if ("c".equals(prepare.getText(columnIndexOf2))) {
                        TableInfo.Index readIndex = readIndex(sQLiteConnection, prepare.getText(columnIndexOf), prepare.getLong(columnIndexOf3) == 1);
                        if (readIndex == null) {
                            f.g(prepare, null);
                            return null;
                        }
                        iVar.add(readIndex);
                    }
                }
                r6.i g = z3.g(iVar);
                f.g(prepare, null);
                return g;
            }
            f.g(prepare, null);
            return null;
        } finally {
        }
    }

    public static final TableInfo readTableInfo(SQLiteConnection sQLiteConnection, String str) {
        sQLiteConnection.getClass();
        str.getClass();
        return new TableInfo(str, readColumns(sQLiteConnection, str), readForeignKeys(sQLiteConnection, str), readIndices(sQLiteConnection, str));
    }

    public static final ViewInfo readViewInfo(SQLiteConnection sQLiteConnection, String str) {
        sQLiteConnection.getClass();
        str.getClass();
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + str + '\'');
        try {
            ViewInfo viewInfo = prepare.step() ? new ViewInfo(prepare.getText(0), prepare.getText(1)) : new ViewInfo(str, null);
            f.g(prepare, null);
            return viewInfo;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                f.g(prepare, th);
                throw th2;
            }
        }
    }
}
