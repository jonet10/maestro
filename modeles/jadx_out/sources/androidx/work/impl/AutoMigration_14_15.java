package androidx.work.impl;

import android.content.ContentValues;
import androidx.room.RenameColumn;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RenameColumn(fromColumnName = "period_start_time", tableName = "WorkSpec", toColumnName = "last_enqueue_time")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AutoMigration_14_15 implements AutoMigrationSpec {
    @Override // androidx.room.migration.AutoMigrationSpec
    public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.getClass();
        supportSQLiteDatabase.execSQL("UPDATE workspec SET period_count = 1 WHERE last_enqueue_time <> 0 AND interval_duration <> 0");
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("last_enqueue_time", Long.valueOf(System.currentTimeMillis()));
        supportSQLiteDatabase.update("WorkSpec", 3, contentValues, "last_enqueue_time = 0 AND interval_duration <> 0 ", new Object[0]);
    }

    @Override // androidx.room.migration.AutoMigrationSpec
    public final void onPostMigrate(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        if (sQLiteConnection instanceof SupportSQLiteConnection) {
            onPostMigrate(((SupportSQLiteConnection) sQLiteConnection).getDb());
        }
    }
}
