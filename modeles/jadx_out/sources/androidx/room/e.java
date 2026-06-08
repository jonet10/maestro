package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import d7.l;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class e implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f486a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomDatabase f487b;

    public /* synthetic */ e(RoomDatabase roomDatabase, int i) {
        this.f486a = i;
        this.f487b = roomDatabase;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        x endTransaction$lambda$9;
        SupportSQLiteOpenHelper createConnectionManager$lambda$1;
        x beginTransaction$lambda$8;
        switch (this.f486a) {
            case 0:
                endTransaction$lambda$9 = RoomDatabase.endTransaction$lambda$9(this.f487b, (SupportSQLiteDatabase) obj);
                return endTransaction$lambda$9;
            case 1:
                createConnectionManager$lambda$1 = RoomDatabase.createConnectionManager$lambda$1(this.f487b, (DatabaseConfiguration) obj);
                return createConnectionManager$lambda$1;
            default:
                beginTransaction$lambda$8 = RoomDatabase.beginTransaction$lambda$8(this.f487b, (SupportSQLiteDatabase) obj);
                return beginTransaction$lambda$8;
        }
    }
}
