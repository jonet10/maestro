package androidx.room.support;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.model.WorkSpecDao_Impl;
import d7.l;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class c implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f493a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f494b;

    public /* synthetic */ c(int i, long j) {
        this.f493a = i;
        this.f494b = j;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        long maximumSize$lambda$2;
        Object _set_pageSize_$lambda$3;
        List recentlyCompletedWork$lambda$35;
        switch (this.f493a) {
            case 0:
                maximumSize$lambda$2 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.setMaximumSize$lambda$2(this.f494b, (SupportSQLiteDatabase) obj);
                return Long.valueOf(maximumSize$lambda$2);
            case 1:
                _set_pageSize_$lambda$3 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase._set_pageSize_$lambda$3(this.f494b, (SupportSQLiteDatabase) obj);
                return _set_pageSize_$lambda$3;
            case 2:
                recentlyCompletedWork$lambda$35 = WorkSpecDao_Impl.getRecentlyCompletedWork$lambda$35("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", this.f494b, (SQLiteConnection) obj);
                return recentlyCompletedWork$lambda$35;
            default:
                ((MutablePreferences) obj).set(q2.i.f8673b, Long.valueOf(this.f494b));
                return null;
        }
    }
}
