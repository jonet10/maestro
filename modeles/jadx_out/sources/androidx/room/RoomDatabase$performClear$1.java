package androidx.room;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import d7.p;
import kotlin.jvm.internal.l;
import o7.a0;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.RoomDatabase$performClear$1", f = "RoomDatabase.android.kt", l = {TypedValues.PositionType.TYPE_DRAWPATH}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RoomDatabase$performClear$1 extends i implements p {
    final /* synthetic */ boolean $hasForeignKeys;
    final /* synthetic */ String[] $tableNames;
    int label;
    final /* synthetic */ RoomDatabase this$0;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @v6.e(c = "androidx.room.RoomDatabase$performClear$1$1", f = "RoomDatabase.android.kt", l = {TypedValues.PositionType.TYPE_PERCENT_WIDTH, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, TypedValues.PositionType.TYPE_PERCENT_X, 512, InputDeviceCompat.SOURCE_DPAD, 514}, m = "invokeSuspend")
    /* renamed from: androidx.room.RoomDatabase$performClear$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ boolean $hasForeignKeys;
        final /* synthetic */ String[] $tableNames;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RoomDatabase this$0;

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        @v6.e(c = "androidx.room.RoomDatabase$performClear$1$1$1", f = "RoomDatabase.android.kt", l = {TypedValues.PositionType.TYPE_CURVE_FIT, TypedValues.PositionType.TYPE_POSITION_TYPE}, m = "invokeSuspend")
        /* renamed from: androidx.room.RoomDatabase$performClear$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00111 extends i implements p {
            final /* synthetic */ boolean $hasForeignKeys;
            final /* synthetic */ String[] $tableNames;
            int I$0;
            int I$1;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00111(boolean z9, String[] strArr, t6.c cVar) {
                super(2, cVar);
                this.$hasForeignKeys = z9;
                this.$tableNames = strArr;
            }

            @Override // v6.a
            public final t6.c create(Object obj, t6.c cVar) {
                C00111 c00111 = new C00111(this.$hasForeignKeys, this.$tableNames, cVar);
                c00111.L$0 = obj;
                return c00111;
            }

            @Override // d7.p
            public final Object invoke(TransactionScope<x> transactionScope, t6.c cVar) {
                return ((C00111) create(transactionScope, cVar)).invokeSuspend(x.f8463a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:10:0x0073, code lost:
            
                return r3;
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
            
                if (androidx.room.TransactorKt.execSQL(r0, "PRAGMA defer_foreign_keys = TRUE", r9) == r3) goto L19;
             */
            /* JADX WARN: Code restructure failed: missing block: B:9:0x0071, code lost:
            
                if (androidx.room.TransactorKt.execSQL(r6, r10, r9) == r3) goto L19;
             */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0076  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x004e  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0071 -> B:6:0x0074). Please report as a decompilation issue!!! */
            @Override // v6.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                /*
                    r9 = this;
                    int r0 = r9.label
                    r1 = 2
                    r2 = 1
                    u6.a r3 = u6.a.f10762a
                    if (r0 == 0) goto L2b
                    if (r0 == r2) goto L23
                    if (r0 != r1) goto L1c
                    int r0 = r9.I$1
                    int r4 = r9.I$0
                    java.lang.Object r5 = r9.L$1
                    java.lang.String[] r5 = (java.lang.String[]) r5
                    java.lang.Object r6 = r9.L$0
                    androidx.room.TransactionScope r6 = (androidx.room.TransactionScope) r6
                    p6.a.e(r10)
                    goto L74
                L1c:
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    androidx.privacysandbox.ads.adservices.customaudience.a.i(r10)
                    r10 = 0
                    return r10
                L23:
                    java.lang.Object r0 = r9.L$0
                    androidx.room.TransactionScope r0 = (androidx.room.TransactionScope) r0
                    p6.a.e(r10)
                    goto L44
                L2b:
                    p6.a.e(r10)
                    java.lang.Object r10 = r9.L$0
                    r0 = r10
                    androidx.room.TransactionScope r0 = (androidx.room.TransactionScope) r0
                    boolean r10 = r9.$hasForeignKeys
                    if (r10 == 0) goto L44
                    r9.L$0 = r0
                    r9.label = r2
                    java.lang.String r10 = "PRAGMA defer_foreign_keys = TRUE"
                    java.lang.Object r10 = androidx.room.TransactorKt.execSQL(r0, r10, r9)
                    if (r10 != r3) goto L44
                    goto L73
                L44:
                    java.lang.String[] r10 = r9.$tableNames
                    int r4 = r10.length
                    r5 = 0
                    r6 = r0
                    r0 = r4
                    r4 = r5
                    r5 = r10
                L4c:
                    if (r4 >= r0) goto L76
                    r10 = r5[r4]
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    java.lang.String r8 = "DELETE FROM `"
                    r7.<init>(r8)
                    r7.append(r10)
                    r10 = 96
                    r7.append(r10)
                    java.lang.String r10 = r7.toString()
                    r9.L$0 = r6
                    r9.L$1 = r5
                    r9.I$0 = r4
                    r9.I$1 = r0
                    r9.label = r1
                    java.lang.Object r10 = androidx.room.TransactorKt.execSQL(r6, r10, r9)
                    if (r10 != r3) goto L74
                L73:
                    return r3
                L74:
                    int r4 = r4 + r2
                    goto L4c
                L76:
                    p6.x r10 = p6.x.f8463a
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase$performClear$1.AnonymousClass1.C00111.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(RoomDatabase roomDatabase, boolean z9, String[] strArr, t6.c cVar) {
            super(2, cVar);
            this.this$0 = roomDatabase;
            this.$hasForeignKeys = z9;
            this.$tableNames = strArr;
        }

        @Override // v6.a
        public final t6.c create(Object obj, t6.c cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$hasForeignKeys, this.$tableNames, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // d7.p
        public final Object invoke(Transactor transactor, t6.c cVar) {
            return ((AnonymousClass1) create(transactor, cVar)).invokeSuspend(x.f8463a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x00b2, code lost:
        
            if (androidx.room.TransactorKt.execSQL(r0, "VACUUM", r7) == r2) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x00a4, code lost:
        
            if (androidx.room.TransactorKt.execSQL(r0, "PRAGMA wal_checkpoint(FULL)", r7) == r2) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x008e, code lost:
        
            if (r8 == r2) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
        
            if (r0.withTransaction(r8, r3, r7) == r2) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x006b, code lost:
        
            if (r8.sync$room_runtime_release(r7) == r2) goto L34;
         */
        /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
        @Override // v6.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                int r0 = r7.label
                r1 = 0
                u6.a r2 = u6.a.f10762a
                switch(r0) {
                    case 0: goto L3e;
                    case 1: goto L36;
                    case 2: goto L2e;
                    case 3: goto L26;
                    case 4: goto L1d;
                    case 5: goto L14;
                    case 6: goto Lf;
                    default: goto L8;
                }
            L8:
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                androidx.privacysandbox.ads.adservices.customaudience.a.i(r8)
                r8 = 0
                return r8
            Lf:
                p6.a.e(r8)
                goto Lb5
            L14:
                java.lang.Object r0 = r7.L$0
                androidx.room.Transactor r0 = (androidx.room.Transactor) r0
                p6.a.e(r8)
                goto La7
            L1d:
                java.lang.Object r0 = r7.L$0
                androidx.room.Transactor r0 = (androidx.room.Transactor) r0
                p6.a.e(r8)
                goto L91
            L26:
                java.lang.Object r0 = r7.L$0
                androidx.room.Transactor r0 = (androidx.room.Transactor) r0
                p6.a.e(r8)
                goto L85
            L2e:
                java.lang.Object r0 = r7.L$0
                androidx.room.Transactor r0 = (androidx.room.Transactor) r0
                p6.a.e(r8)
                goto L6e
            L36:
                java.lang.Object r0 = r7.L$0
                androidx.room.Transactor r0 = (androidx.room.Transactor) r0
                p6.a.e(r8)
                goto L54
            L3e:
                p6.a.e(r8)
                java.lang.Object r8 = r7.L$0
                androidx.room.Transactor r8 = (androidx.room.Transactor) r8
                r7.L$0 = r8
                r0 = 1
                r7.label = r0
                java.lang.Object r0 = r8.inTransaction(r7)
                if (r0 != r2) goto L51
                goto Lb4
            L51:
                r6 = r0
                r0 = r8
                r8 = r6
            L54:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 != 0) goto L6e
                androidx.room.RoomDatabase r8 = r7.this$0
                androidx.room.InvalidationTracker r8 = r8.getInvalidationTracker()
                r7.L$0 = r0
                r3 = 2
                r7.label = r3
                java.lang.Object r8 = r8.sync$room_runtime_release(r7)
                if (r8 != r2) goto L6e
                goto Lb4
            L6e:
                androidx.room.Transactor$SQLiteTransactionType r8 = androidx.room.Transactor.SQLiteTransactionType.IMMEDIATE
                androidx.room.RoomDatabase$performClear$1$1$1 r3 = new androidx.room.RoomDatabase$performClear$1$1$1
                boolean r4 = r7.$hasForeignKeys
                java.lang.String[] r5 = r7.$tableNames
                r3.<init>(r4, r5, r1)
                r7.L$0 = r0
                r4 = 3
                r7.label = r4
                java.lang.Object r8 = r0.withTransaction(r8, r3, r7)
                if (r8 != r2) goto L85
                goto Lb4
            L85:
                r7.L$0 = r0
                r8 = 4
                r7.label = r8
                java.lang.Object r8 = r0.inTransaction(r7)
                if (r8 != r2) goto L91
                goto Lb4
            L91:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 != 0) goto Lbe
                r7.L$0 = r0
                r8 = 5
                r7.label = r8
                java.lang.String r8 = "PRAGMA wal_checkpoint(FULL)"
                java.lang.Object r8 = androidx.room.TransactorKt.execSQL(r0, r8, r7)
                if (r8 != r2) goto La7
                goto Lb4
            La7:
                r7.L$0 = r1
                r8 = 6
                r7.label = r8
                java.lang.String r8 = "VACUUM"
                java.lang.Object r8 = androidx.room.TransactorKt.execSQL(r0, r8, r7)
                if (r8 != r2) goto Lb5
            Lb4:
                return r2
            Lb5:
                androidx.room.RoomDatabase r8 = r7.this$0
                androidx.room.InvalidationTracker r8 = r8.getInvalidationTracker()
                r8.refreshAsync()
            Lbe:
                p6.x r8 = p6.x.f8463a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase$performClear$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomDatabase$performClear$1(RoomDatabase roomDatabase, boolean z9, String[] strArr, t6.c cVar) {
        super(2, cVar);
        this.this$0 = roomDatabase;
        this.$hasForeignKeys = z9;
        this.$tableNames = strArr;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new RoomDatabase$performClear$1(this.this$0, this.$hasForeignKeys, this.$tableNames, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((RoomDatabase$performClear$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        RoomConnectionManager roomConnectionManager;
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            roomConnectionManager = this.this$0.connectionManager;
            if (roomConnectionManager == null) {
                l.i("connectionManager");
                throw null;
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$hasForeignKeys, this.$tableNames, null);
            this.label = 1;
            Object useConnection = roomConnectionManager.useConnection(false, anonymousClass1, this);
            u6.a aVar = u6.a.f10762a;
            if (useConnection == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return x.f8463a;
    }
}
