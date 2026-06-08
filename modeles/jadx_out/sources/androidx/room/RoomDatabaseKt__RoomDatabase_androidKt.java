package androidx.room;

import d7.p;
import java.util.Arrays;
import java.util.concurrent.RejectedExecutionException;
import o7.a0;
import o7.c0;
import o7.j;
import o7.l;
import p6.x;
import t6.h;
import t7.v;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final /* synthetic */ class RoomDatabaseKt__RoomDatabase_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final h createTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt(RoomDatabase roomDatabase, t6.e eVar) {
        TransactionElement transactionElement = new TransactionElement(eVar);
        return eVar.plus(transactionElement).plus(new v(roomDatabase.getSuspendingTransactionId(), Integer.valueOf(System.identityHashCode(transactionElement))));
    }

    public static final r7.h invalidationTrackerFlow(RoomDatabase roomDatabase, String[] strArr, boolean z9) {
        roomDatabase.getClass();
        strArr.getClass();
        return roomDatabase.getInvalidationTracker().createFlow((String[]) Arrays.copyOf(strArr, strArr.length), z9);
    }

    public static /* synthetic */ r7.h invalidationTrackerFlow$default(RoomDatabase roomDatabase, String[] strArr, boolean z9, int i, Object obj) {
        if ((i & 2) != 0) {
            z9 = true;
        }
        return RoomDatabaseKt.invalidationTrackerFlow(roomDatabase, strArr, z9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <R> Object startTransactionCoroutine$RoomDatabaseKt__RoomDatabase_androidKt(final RoomDatabase roomDatabase, final h hVar, final p pVar, t6.c cVar) {
        final l lVar = new l(1, d0.b.I(cVar));
        lVar.s();
        try {
            roomDatabase.getTransactionExecutor().execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1

                /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
                @v6.e(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1$1", f = "RoomDatabase.android.kt", l = {2017}, m = "invokeSuspend")
                /* renamed from: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1$1, reason: invalid class name */
                public static final class AnonymousClass1 extends i implements p {
                    final /* synthetic */ j $continuation;
                    final /* synthetic */ RoomDatabase $this_startTransactionCoroutine;
                    final /* synthetic */ p $transactionBlock;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(RoomDatabase roomDatabase, j jVar, p pVar, t6.c cVar) {
                        super(2, cVar);
                        this.$this_startTransactionCoroutine = roomDatabase;
                        this.$continuation = jVar;
                        this.$transactionBlock = pVar;
                    }

                    @Override // v6.a
                    public final t6.c create(Object obj, t6.c cVar) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_startTransactionCoroutine, this.$continuation, this.$transactionBlock, cVar);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // d7.p
                    public final Object invoke(a0 a0Var, t6.c cVar) {
                        return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
                    }

                    @Override // v6.a
                    public final Object invokeSuspend(Object obj) {
                        h createTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt;
                        t6.c cVar;
                        int i = this.label;
                        if (i == 0) {
                            p6.a.e(obj);
                            t6.f fVar = ((a0) this.L$0).getCoroutineContext().get(t6.d.f10313a);
                            fVar.getClass();
                            createTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt = RoomDatabaseKt__RoomDatabase_androidKt.createTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt(this.$this_startTransactionCoroutine, (t6.e) fVar);
                            cVar = this.$continuation;
                            p pVar = this.$transactionBlock;
                            this.L$0 = cVar;
                            this.label = 1;
                            obj = c0.C(pVar, createTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt, this);
                            u6.a aVar = u6.a.f10762a;
                            if (obj == aVar) {
                                return aVar;
                            }
                        } else {
                            if (i != 1) {
                                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            cVar = (t6.c) this.L$0;
                            p6.a.e(obj);
                        }
                        cVar.resumeWith(obj);
                        return x.f8463a;
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        c0.w(h.this.minusKey(t6.d.f10313a), new AnonymousClass1(roomDatabase, lVar, pVar, null));
                    } catch (Throwable th) {
                        lVar.o(th);
                    }
                }
            });
        } catch (RejectedExecutionException e10) {
            lVar.o(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e10));
        }
        return lVar.r();
    }

    public static final <R> Object withTransaction(RoomDatabase roomDatabase, d7.l lVar, t6.c cVar) {
        return RoomDatabaseKt.withTransactionContext(roomDatabase, new RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2(roomDatabase, lVar, null), cVar);
    }

    public static final <R> Object withTransactionContext(RoomDatabase roomDatabase, d7.l lVar, t6.c cVar) {
        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(lVar, null);
        TransactionElement transactionElement = (TransactionElement) cVar.getContext().get(TransactionElement.Key);
        t6.e transactionDispatcher$room_runtime_release = transactionElement != null ? transactionElement.getTransactionDispatcher$room_runtime_release() : null;
        return transactionDispatcher$room_runtime_release != null ? c0.C(roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, transactionDispatcher$room_runtime_release, cVar) : startTransactionCoroutine$RoomDatabaseKt__RoomDatabase_androidKt(roomDatabase, cVar.getContext(), roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, cVar);
    }
}
