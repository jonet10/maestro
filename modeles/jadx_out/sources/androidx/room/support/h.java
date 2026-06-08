package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import d7.l;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class h implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f506a;

    public /* synthetic */ h(int i) {
        this.f506a = i;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        long simpleQueryForLong$lambda$3;
        String simpleQueryForString$lambda$4;
        int executeUpdateDelete$lambda$1;
        long executeInsert$lambda$2;
        x execute$lambda$0;
        Object pokeOpen$lambda$0;
        switch (this.f506a) {
            case 0:
                simpleQueryForLong$lambda$3 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.simpleQueryForLong$lambda$3((SupportSQLiteStatement) obj);
                return Long.valueOf(simpleQueryForLong$lambda$3);
            case 1:
                simpleQueryForString$lambda$4 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.simpleQueryForString$lambda$4((SupportSQLiteStatement) obj);
                return simpleQueryForString$lambda$4;
            case 2:
                executeUpdateDelete$lambda$1 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.executeUpdateDelete$lambda$1((SupportSQLiteStatement) obj);
                return Integer.valueOf(executeUpdateDelete$lambda$1);
            case 3:
                executeInsert$lambda$2 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.executeInsert$lambda$2((SupportSQLiteStatement) obj);
                return Long.valueOf(executeInsert$lambda$2);
            case 4:
                execute$lambda$0 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.execute$lambda$0((SupportSQLiteStatement) obj);
                return execute$lambda$0;
            default:
                pokeOpen$lambda$0 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.pokeOpen$lambda$0((SupportSQLiteDatabase) obj);
                return pokeOpen$lambda$0;
        }
    }
}
