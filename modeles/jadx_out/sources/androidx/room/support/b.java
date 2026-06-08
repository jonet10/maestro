package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.model.WorkSpecDao_Impl;
import d7.l;
import java.util.List;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class b implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f491a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f492b;

    public /* synthetic */ b(int i, int i6) {
        this.f491a = i6;
        this.f492b = i;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        x maxSqlCacheSize$lambda$11;
        x _set_version_$lambda$1;
        boolean needUpgrade$lambda$9;
        List allEligibleWorkSpecsForScheduling$lambda$29;
        List eligibleWorkForScheduling$lambda$25;
        switch (this.f491a) {
            case 0:
                maxSqlCacheSize$lambda$11 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.setMaxSqlCacheSize$lambda$11(this.f492b, (SupportSQLiteDatabase) obj);
                return maxSqlCacheSize$lambda$11;
            case 1:
                _set_version_$lambda$1 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase._set_version_$lambda$1(this.f492b, (SupportSQLiteDatabase) obj);
                return _set_version_$lambda$1;
            case 2:
                needUpgrade$lambda$9 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.needUpgrade$lambda$9(this.f492b, (SupportSQLiteDatabase) obj);
                return Boolean.valueOf(needUpgrade$lambda$9);
            case 3:
                allEligibleWorkSpecsForScheduling$lambda$29 = WorkSpecDao_Impl.getAllEligibleWorkSpecsForScheduling$lambda$29("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", this.f492b, (SQLiteConnection) obj);
                return allEligibleWorkSpecsForScheduling$lambda$29;
            case 4:
                eligibleWorkForScheduling$lambda$25 = WorkSpecDao_Impl.getEligibleWorkForScheduling$lambda$25("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))", this.f492b, (SQLiteConnection) obj);
                return eligibleWorkForScheduling$lambda$25;
            default:
                ((Integer) obj).intValue();
                throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.f492b + '.');
        }
    }
}
