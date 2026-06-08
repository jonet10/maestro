package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ViewInfo {
    public static final Companion Companion = new Companion(null);
    public final String name;
    public final String sql;

    public ViewInfo(String str, String str2) {
        str.getClass();
        this.name = str;
        this.sql = str2;
    }

    public static final ViewInfo read(SQLiteConnection sQLiteConnection, String str) {
        return Companion.read(sQLiteConnection, str);
    }

    public boolean equals(Object obj) {
        return ViewInfoKt.equalsCommon(this, obj);
    }

    public int hashCode() {
        return ViewInfoKt.hashCodeCommon(this);
    }

    public String toString() {
        return ViewInfoKt.toStringCommon(this);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final ViewInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            supportSQLiteDatabase.getClass();
            str.getClass();
            return read(new SupportSQLiteConnection(supportSQLiteDatabase), str);
        }

        private Companion() {
        }

        public final ViewInfo read(SQLiteConnection sQLiteConnection, String str) {
            sQLiteConnection.getClass();
            str.getClass();
            return SchemaInfoUtilKt.readViewInfo(sQLiteConnection, str);
        }
    }

    public static final ViewInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }
}
