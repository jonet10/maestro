package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import d7.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(SQLiteDatabase sQLiteDatabase, boolean z9, l lVar) {
        if (z9) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T t9 = (T) lVar.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return t9;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z9, l lVar, int i, Object obj) {
        if ((i & 1) != 0) {
            z9 = true;
        }
        if (z9) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object invoke = lVar.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
