package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.g;
import q6.v;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;
    public static final Companion Companion = new Companion(null);
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    public final Set<Index> indices;
    public final String name;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @Retention(RetentionPolicy.SOURCE)
    public @interface CreatedFrom {
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class ForeignKey {
        public final List<String> columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List<String> referenceColumnNames;
        public final String referenceTable;

        public ForeignKey(String str, String str2, String str3, List<String> list, List<String> list2) {
            str.getClass();
            str2.getClass();
            str3.getClass();
            list.getClass();
            list2.getClass();
            this.referenceTable = str;
            this.onDelete = str2;
            this.onUpdate = str3;
            this.columnNames = list;
            this.referenceColumnNames = list2;
        }

        public boolean equals(Object obj) {
            return TableInfoKt.equalsCommon(this, obj);
        }

        public int hashCode() {
            return TableInfoKt.hashCodeCommon(this);
        }

        public String toString() {
            return TableInfoKt.toStringCommon(this);
        }
    }

    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set, Set<Index> set2) {
        str.getClass();
        map.getClass();
        set.getClass();
        this.name = str;
        this.columns = map;
        this.foreignKeys = set;
        this.indices = set2;
    }

    public static final TableInfo read(SQLiteConnection sQLiteConnection, String str) {
        return Companion.read(sQLiteConnection, str);
    }

    public boolean equals(Object obj) {
        return TableInfoKt.equalsCommon(this, obj);
    }

    public int hashCode() {
        return TableInfoKt.hashCodeCommon(this);
    }

    public String toString() {
        return TableInfoKt.toStringCommon(this);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class Column {
        public static final Companion Companion = new Companion(null);
        public final int affinity;
        public final int createdFrom;
        public final String defaultValue;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        public Column(String str, String str2, boolean z9, int i, String str3, int i6) {
            str.getClass();
            str2.getClass();
            this.name = str;
            this.type = str2;
            this.notNull = z9;
            this.primaryKeyPosition = i;
            this.defaultValue = str3;
            this.createdFrom = i6;
            this.affinity = SchemaInfoUtilKt.findAffinity(str2);
        }

        public static final boolean defaultValueEquals(String str, String str2) {
            return Companion.defaultValueEquals(str, str2);
        }

        public boolean equals(Object obj) {
            return TableInfoKt.equalsCommon(this, obj);
        }

        public int hashCode() {
            return TableInfoKt.hashCodeCommon(this);
        }

        public final boolean isPrimaryKey() {
            return this.primaryKeyPosition > 0;
        }

        public String toString() {
            return TableInfoKt.toStringCommon(this);
        }

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final boolean defaultValueEquals(String str, String str2) {
                str.getClass();
                return TableInfoKt.defaultValueEqualsCommon(str, str2);
            }

            private Companion() {
            }
        }

        @ColumnInfo.SQLiteTypeAffinity
        public static /* synthetic */ void getAffinity$annotations() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Column(String str, String str2, boolean z9, int i) {
            this(str, str2, z9, i, null, 0);
            str.getClass();
            str2.getClass();
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class Index {
        public static final Companion Companion = new Companion(null);
        public static final String DEFAULT_PREFIX = "index_";
        public final List<String> columns;
        public final String name;
        public List<String> orders;
        public final boolean unique;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r4v4, types: [java.util.ArrayList] */
        public Index(String str, boolean z9, List<String> list, List<String> list2) {
            str.getClass();
            list.getClass();
            list2.getClass();
            this.name = str;
            this.unique = z9;
            this.columns = list;
            this.orders = list2;
            List<String> list3 = list2;
            if (list3.isEmpty()) {
                int size = list.size();
                list3 = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    list3.add("ASC");
                }
            }
            this.orders = (List) list3;
        }

        public boolean equals(Object obj) {
            return TableInfoKt.equalsCommon(this, obj);
        }

        public int hashCode() {
            return TableInfoKt.hashCodeCommon(this);
        }

        public String toString() {
            return TableInfoKt.toStringCommon(this);
        }

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public Index(java.lang.String r5, boolean r6, java.util.List<java.lang.String> r7) {
            /*
                r4 = this;
                r5.getClass()
                r7.getClass()
                int r0 = r7.size()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r0)
                r2 = 0
            L10:
                if (r2 >= r0) goto L1a
                java.lang.String r3 = "ASC"
                r1.add(r3)
                int r2 = r2 + 1
                goto L10
            L1a:
                r4.<init>(r5, r6, r7, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.TableInfo.Index.<init>(java.lang.String, boolean, java.util.List):void");
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final TableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            supportSQLiteDatabase.getClass();
            str.getClass();
            return read(new SupportSQLiteConnection(supportSQLiteDatabase), str);
        }

        private Companion() {
        }

        public final TableInfo read(SQLiteConnection sQLiteConnection, String str) {
            sQLiteConnection.getClass();
            str.getClass();
            return SchemaInfoUtilKt.readTableInfo(sQLiteConnection, str);
        }
    }

    public static final TableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public /* synthetic */ TableInfo(String str, Map map, Set set, Set set2, int i, g gVar) {
        this(str, map, set, (i & 8) != 0 ? null : set2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set) {
        this(str, map, set, v.f8726a);
        str.getClass();
        map.getClass();
        set.getClass();
    }
}
