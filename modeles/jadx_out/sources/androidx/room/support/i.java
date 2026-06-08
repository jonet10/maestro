package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import d7.l;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class i implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f507a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f508b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f509l;

    public /* synthetic */ i(int i, Object obj, Object obj2) {
        this.f507a = i;
        this.f508b = obj;
        this.f509l = obj2;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        Object executeWithRefCount$lambda$5;
        x execSQL$lambda$8;
        switch (this.f507a) {
            case 0:
                executeWithRefCount$lambda$5 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.executeWithRefCount$lambda$5((AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement) this.f508b, (l) this.f509l, (SupportSQLiteDatabase) obj);
                return executeWithRefCount$lambda$5;
            default:
                execSQL$lambda$8 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.execSQL$lambda$8((String) this.f508b, (Object[]) this.f509l, (SupportSQLiteDatabase) obj);
                return execSQL$lambda$8;
        }
    }
}
