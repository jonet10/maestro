package androidx.room;

import d7.l;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2", f = "RoomDatabase.android.kt", l = {1970}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2 extends i implements l {
    final /* synthetic */ l $block;
    final /* synthetic */ RoomDatabase $this_withTransaction;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2(RoomDatabase roomDatabase, l lVar, t6.c cVar) {
        super(1, cVar);
        this.$this_withTransaction = roomDatabase;
        this.$block = lVar;
    }

    @Override // v6.a
    public final t6.c create(t6.c cVar) {
        return new RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2(this.$this_withTransaction, this.$block, cVar);
    }

    @Override // d7.l
    public final Object invoke(t6.c cVar) {
        return ((RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2) create(cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        try {
            if (i == 0) {
                p6.a.e(obj);
                this.$this_withTransaction.beginTransaction();
                l lVar = this.$block;
                this.label = 1;
                obj = lVar.invoke(this);
                u6.a aVar = u6.a.f10762a;
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
            }
            this.$this_withTransaction.setTransactionSuccessful();
            return obj;
        } finally {
            this.$this_withTransaction.endTransaction();
        }
    }
}
