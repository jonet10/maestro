package androidx.room.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.RoomDatabase;
import androidx.room.Transactor;
import d7.p;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.room.util.DBUtil__DBUtilKt$internalPerform$2", f = "DBUtil.kt", l = {56, 57, 59, 60, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DBUtil__DBUtilKt$internalPerform$2 extends i implements p {
    final /* synthetic */ p $block;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ boolean $isReadOnly;
    final /* synthetic */ RoomDatabase $this_internalPerform;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBUtil__DBUtilKt$internalPerform$2(boolean z9, boolean z10, RoomDatabase roomDatabase, p pVar, c cVar) {
        super(2, cVar);
        this.$inTransaction = z9;
        this.$isReadOnly = z10;
        this.$this_internalPerform = roomDatabase;
        this.$block = pVar;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        DBUtil__DBUtilKt$internalPerform$2 dBUtil__DBUtilKt$internalPerform$2 = new DBUtil__DBUtilKt$internalPerform$2(this.$inTransaction, this.$isReadOnly, this.$this_internalPerform, this.$block, cVar);
        dBUtil__DBUtilKt$internalPerform$2.L$0 = obj;
        return dBUtil__DBUtilKt$internalPerform$2;
    }

    @Override // d7.p
    public final Object invoke(Transactor transactor, c cVar) {
        return ((DBUtil__DBUtilKt$internalPerform$2) create(transactor, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a2, code lost:
    
        if (r9 == r6) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0088, code lost:
    
        if (r9.sync$room_runtime_release(r8) == r6) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00bf  */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtilKt$internalPerform$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        Transactor transactor = (Transactor) this.L$0;
        if (!this.$inTransaction) {
            return this.$block.invoke(transactor, this);
        }
        boolean z9 = this.$isReadOnly;
        Transactor.SQLiteTransactionType sQLiteTransactionType = z9 ? Transactor.SQLiteTransactionType.DEFERRED : Transactor.SQLiteTransactionType.IMMEDIATE;
        if (!z9 && !((Boolean) transactor.inTransaction(this)).booleanValue()) {
            this.$this_internalPerform.getInvalidationTracker().sync$room_runtime_release(this);
        }
        Object withTransaction = transactor.withTransaction(sQLiteTransactionType, new DBUtil__DBUtilKt$internalPerform$2$result$1(this.$block, null), this);
        if (!this.$isReadOnly && !((Boolean) transactor.inTransaction(this)).booleanValue()) {
            this.$this_internalPerform.getInvalidationTracker().refreshAsync();
        }
        return withTransaction;
    }
}
