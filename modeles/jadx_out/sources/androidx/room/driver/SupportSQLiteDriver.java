package androidx.room.driver;

import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SupportSQLiteDriver implements SQLiteDriver {
    private final SupportSQLiteOpenHelper openHelper;

    public SupportSQLiteDriver(SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        supportSQLiteOpenHelper.getClass();
        this.openHelper = supportSQLiteOpenHelper;
    }

    public final SupportSQLiteOpenHelper getOpenHelper() {
        return this.openHelper;
    }

    @Override // androidx.sqlite.SQLiteDriver
    public SupportSQLiteConnection open(String str) {
        str.getClass();
        return new SupportSQLiteConnection(this.openHelper.getWritableDatabase());
    }
}
