package androidx.work.impl;

import androidx.room.migration.Migration;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkDatabase_AutoMigration_23_24_Impl extends Migration {
    public WorkDatabase_AutoMigration_23_24_Impl() {
        super(23, 24);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SQLiteConnection sQLiteConnection) {
        sQLiteConnection.getClass();
        SQLite.execSQL(sQLiteConnection, "ALTER TABLE `WorkSpec` ADD COLUMN `backoff_on_system_interruptions` INTEGER DEFAULT NULL");
    }
}
