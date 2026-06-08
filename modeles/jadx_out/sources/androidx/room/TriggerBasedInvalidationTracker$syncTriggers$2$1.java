package androidx.room;

import androidx.room.ObservedTableStates;
import d7.p;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1", f = "InvalidationTracker.kt", l = {301, 309}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TriggerBasedInvalidationTracker$syncTriggers$2$1 extends i implements p {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @v6.e(c = "androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1", f = "InvalidationTracker.kt", l = {313, 314}, m = "invokeSuspend")
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ Transactor $connection;
        final /* synthetic */ ObservedTableStates.ObserveOp[] $tablesToSync;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ TriggerBasedInvalidationTracker this$0;

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        /* renamed from: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ObservedTableStates.ObserveOp.values().length];
                try {
                    iArr[ObservedTableStates.ObserveOp.NO_OP.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ObservedTableStates.ObserveOp.ADD.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ObservedTableStates.ObserveOp.REMOVE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ObservedTableStates.ObserveOp[] observeOpArr, TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Transactor transactor, t6.c cVar) {
            super(2, cVar);
            this.$tablesToSync = observeOpArr;
            this.this$0 = triggerBasedInvalidationTracker;
            this.$connection = transactor;
        }

        @Override // v6.a
        public final t6.c create(Object obj, t6.c cVar) {
            return new AnonymousClass1(this.$tablesToSync, this.this$0, this.$connection, cVar);
        }

        @Override // d7.p
        public final Object invoke(TransactionScope<x> transactionScope, t6.c cVar) {
            return ((AnonymousClass1) create(transactionScope, cVar)).invokeSuspend(x.f8463a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
        
            if (r4 == r9) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0065, code lost:
        
            r5 = r12;
            r4 = r8;
         */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0081 -> B:11:0x0082). Please report as a decompilation issue!!! */
        @Override // v6.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                int r0 = r11.label
                r1 = 2
                r2 = 1
                if (r0 == 0) goto L27
                if (r0 == r2) goto La
                if (r0 != r1) goto L20
            La:
                int r0 = r11.I$2
                int r3 = r11.I$1
                int r4 = r11.I$0
                java.lang.Object r5 = r11.L$2
                androidx.room.Transactor r5 = (androidx.room.Transactor) r5
                java.lang.Object r6 = r11.L$1
                androidx.room.TriggerBasedInvalidationTracker r6 = (androidx.room.TriggerBasedInvalidationTracker) r6
                java.lang.Object r7 = r11.L$0
                androidx.room.ObservedTableStates$ObserveOp[] r7 = (androidx.room.ObservedTableStates.ObserveOp[]) r7
                p6.a.e(r12)
                goto L65
            L20:
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                androidx.privacysandbox.ads.adservices.customaudience.a.i(r12)
            L25:
                r12 = 0
                return r12
            L27:
                p6.a.e(r12)
                androidx.room.ObservedTableStates$ObserveOp[] r12 = r11.$tablesToSync
                androidx.room.TriggerBasedInvalidationTracker r0 = r11.this$0
                androidx.room.Transactor r3 = r11.$connection
                int r4 = r12.length
                r5 = 0
                r7 = r12
                r6 = r0
                r12 = r3
                r0 = r4
                r3 = r5
            L37:
                if (r3 >= r0) goto L84
                r4 = r7[r3]
                int r8 = r5 + 1
                int[] r9 = androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1.AnonymousClass1.WhenMappings.$EnumSwitchMapping$0
                int r4 = r4.ordinal()
                r4 = r9[r4]
                if (r4 == r2) goto L81
                u6.a r9 = u6.a.f10762a
                if (r4 == r1) goto L6c
                r10 = 3
                if (r4 != r10) goto L68
                r11.L$0 = r7
                r11.L$1 = r6
                r11.L$2 = r12
                r11.I$0 = r8
                r11.I$1 = r3
                r11.I$2 = r0
                r11.label = r1
                java.lang.Object r4 = androidx.room.TriggerBasedInvalidationTracker.access$stopTrackingTable(r6, r12, r5, r11)
                if (r4 != r9) goto L63
                goto L80
            L63:
                r5 = r12
                r4 = r8
            L65:
                r12 = r5
                r5 = r4
                goto L82
            L68:
                com.google.gson.internal.a.b()
                goto L25
            L6c:
                r11.L$0 = r7
                r11.L$1 = r6
                r11.L$2 = r12
                r11.I$0 = r8
                r11.I$1 = r3
                r11.I$2 = r0
                r11.label = r2
                java.lang.Object r4 = androidx.room.TriggerBasedInvalidationTracker.access$startTrackingTable(r6, r12, r5, r11)
                if (r4 != r9) goto L63
            L80:
                return r9
            L81:
                r5 = r8
            L82:
                int r3 = r3 + r2
                goto L37
            L84:
                p6.x r12 = p6.x.f8463a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$syncTriggers$2$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, t6.c cVar) {
        super(2, cVar);
        this.this$0 = triggerBasedInvalidationTracker;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        TriggerBasedInvalidationTracker$syncTriggers$2$1 triggerBasedInvalidationTracker$syncTriggers$2$1 = new TriggerBasedInvalidationTracker$syncTriggers$2$1(this.this$0, cVar);
        triggerBasedInvalidationTracker$syncTriggers$2$1.L$0 = obj;
        return triggerBasedInvalidationTracker$syncTriggers$2$1;
    }

    @Override // d7.p
    public final Object invoke(Transactor transactor, t6.c cVar) {
        return ((TriggerBasedInvalidationTracker$syncTriggers$2$1) create(transactor, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        if (r9 == r4) goto L20;
     */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            int r0 = r8.label
            p6.x r1 = p6.x.f8463a
            r2 = 2
            r3 = 1
            u6.a r4 = u6.a.f10762a
            if (r0 == 0) goto L21
            if (r0 == r3) goto L19
            if (r0 != r2) goto L12
            p6.a.e(r9)
            goto L5e
        L12:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r9)
            r9 = 0
            return r9
        L19:
            java.lang.Object r0 = r8.L$0
            androidx.room.Transactor r0 = (androidx.room.Transactor) r0
            p6.a.e(r9)
            goto L34
        L21:
            p6.a.e(r9)
            java.lang.Object r9 = r8.L$0
            r0 = r9
            androidx.room.Transactor r0 = (androidx.room.Transactor) r0
            r8.L$0 = r0
            r8.label = r3
            java.lang.Object r9 = r0.inTransaction(r8)
            if (r9 != r4) goto L34
            goto L5d
        L34:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L3d
            return r1
        L3d:
            androidx.room.TriggerBasedInvalidationTracker r9 = r8.this$0
            androidx.room.ObservedTableStates r9 = androidx.room.TriggerBasedInvalidationTracker.access$getObservedTableStates$p(r9)
            androidx.room.ObservedTableStates$ObserveOp[] r9 = r9.getTablesToSync$room_runtime_release()
            if (r9 == 0) goto L5e
            androidx.room.Transactor$SQLiteTransactionType r3 = androidx.room.Transactor.SQLiteTransactionType.IMMEDIATE
            androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1 r5 = new androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1
            androidx.room.TriggerBasedInvalidationTracker r6 = r8.this$0
            r7 = 0
            r5.<init>(r9, r6, r0, r7)
            r8.L$0 = r7
            r8.label = r2
            java.lang.Object r9 = r0.withTransaction(r3, r5, r8)
            if (r9 != r4) goto L5e
        L5d:
            return r4
        L5e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
