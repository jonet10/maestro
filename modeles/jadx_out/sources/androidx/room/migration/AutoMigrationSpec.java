package androidx.room.migration;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface AutoMigrationSpec {
    void onPostMigrate(SQLiteConnection sQLiteConnection);

    void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase);
}
