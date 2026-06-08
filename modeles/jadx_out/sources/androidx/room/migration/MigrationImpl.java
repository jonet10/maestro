package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;
import d7.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class MigrationImpl extends Migration {
    private final l migrateCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MigrationImpl(int i, int i6, l lVar) {
        super(i, i6);
        lVar.getClass();
        this.migrateCallback = lVar;
    }

    public final l getMigrateCallback() {
        return this.migrateCallback;
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.getClass();
        this.migrateCallback.invoke(supportSQLiteDatabase);
    }
}
