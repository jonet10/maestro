package androidx.room;

import d7.l;
import d7.p;
import o7.a0;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1", f = "RoomDatabase.android.kt", l = {1984}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 extends i implements p {
    final /* synthetic */ l $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(l lVar, t6.c cVar) {
        super(2, cVar);
        this.$block = lVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(this.$block, cVar);
        roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1.L$0 = obj;
        return roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1;
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.room.TransactionElement] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        TransactionElement transactionElement = this.label;
        try {
            if (transactionElement == 0) {
                p6.a.e(obj);
                t6.f fVar = ((a0) this.L$0).getCoroutineContext().get(TransactionElement.Key);
                fVar.getClass();
                TransactionElement transactionElement2 = (TransactionElement) fVar;
                transactionElement2.acquire();
                l lVar = this.$block;
                this.L$0 = transactionElement2;
                this.label = 1;
                obj = lVar.invoke(this);
                u6.a aVar = u6.a.f10762a;
                transactionElement = transactionElement2;
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (transactionElement != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                TransactionElement transactionElement3 = (TransactionElement) this.L$0;
                p6.a.e(obj);
                transactionElement = transactionElement3;
            }
            return obj;
        } finally {
            transactionElement.release();
        }
    }
}
