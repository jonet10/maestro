package androidx.room;

import d7.p;
import o7.a0;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.TriggerBasedInvalidationTracker$createFlow$1", f = "InvalidationTracker.kt", l = {233, 233, 237}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TriggerBasedInvalidationTracker$createFlow$1 extends i implements p {
    final /* synthetic */ boolean $emitInitialState;
    final /* synthetic */ String[] $resolvedTableNames;
    final /* synthetic */ int[] $tableIds;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @v6.e(c = "androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1", f = "InvalidationTracker.kt", l = {233}, m = "invokeSuspend")
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        int label;
        final /* synthetic */ TriggerBasedInvalidationTracker this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, t6.c cVar) {
            super(2, cVar);
            this.this$0 = triggerBasedInvalidationTracker;
        }

        @Override // v6.a
        public final t6.c create(Object obj, t6.c cVar) {
            return new AnonymousClass1(this.this$0, cVar);
        }

        @Override // d7.p
        public final Object invoke(a0 a0Var, t6.c cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
        }

        @Override // v6.a
        public final Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i == 0) {
                p6.a.e(obj);
                TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = this.this$0;
                this.label = 1;
                Object syncTriggers$room_runtime_release = triggerBasedInvalidationTracker.syncTriggers$room_runtime_release(this);
                u6.a aVar = u6.a.f10762a;
                if (syncTriggers$room_runtime_release == aVar) {
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

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements r7.i {
        final /* synthetic */ r7.i $$this$flow;
        final /* synthetic */ kotlin.jvm.internal.x $currentVersions;
        final /* synthetic */ boolean $emitInitialState;
        final /* synthetic */ String[] $resolvedTableNames;
        final /* synthetic */ int[] $tableIds;

        public AnonymousClass2(kotlin.jvm.internal.x xVar, boolean z9, r7.i iVar, String[] strArr, int[] iArr) {
            this.$currentVersions = xVar;
            this.$emitInitialState = z9;
            this.$$this$flow = iVar;
            this.$resolvedTableNames = strArr;
            this.$tableIds = iArr;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        
            if (r14.emit(r1, r0) == r4) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00a3, code lost:
        
            return r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00a1, code lost:
        
            if (r14.emit(r1, r0) == r4) goto L37;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
        @Override // r7.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(int[] r13, t6.c r14) {
            /*
                r12 = this;
                boolean r0 = r14 instanceof androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1
                if (r0 == 0) goto L13
                r0 = r14
                androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1
                r0.<init>(r12, r14)
            L18:
                java.lang.Object r14 = r0.result
                int r1 = r0.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L39
                if (r1 == r3) goto L2c
                if (r1 != r2) goto L25
                goto L2c
            L25:
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                androidx.privacysandbox.ads.adservices.customaudience.a.i(r13)
                r13 = 0
                return r13
            L2c:
                java.lang.Object r13 = r0.L$1
                int[] r13 = (int[]) r13
                java.lang.Object r0 = r0.L$0
                androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2 r0 = (androidx.room.TriggerBasedInvalidationTracker$createFlow$1.AnonymousClass2) r0
                p6.a.e(r14)
                goto La5
            L39:
                p6.a.e(r14)
                kotlin.jvm.internal.x r14 = r12.$currentVersions
                java.lang.Object r1 = r14.f7024a
                u6.a r4 = u6.a.f10762a
                if (r1 != 0) goto L5d
                boolean r14 = r12.$emitInitialState
                if (r14 == 0) goto La4
                r7.i r14 = r12.$$this$flow
                java.lang.String[] r1 = r12.$resolvedTableNames
                java.util.Set r1 = q6.j.n0(r1)
                r0.L$0 = r12
                r0.L$1 = r13
                r0.label = r3
                java.lang.Object r14 = r14.emit(r1, r0)
                if (r14 != r4) goto La4
                goto La3
            L5d:
                java.lang.String[] r1 = r12.$resolvedTableNames
                int[] r3 = r12.$tableIds
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                int r6 = r1.length
                r7 = 0
                r8 = r7
            L69:
                if (r7 >= r6) goto L8b
                r9 = r1[r7]
                int r10 = r8 + 1
                java.lang.Object r11 = r14.f7024a
                if (r11 == 0) goto L84
                int[] r11 = (int[]) r11
                r8 = r3[r8]
                r11 = r11[r8]
                r8 = r13[r8]
                if (r11 == r8) goto L80
                r5.add(r9)
            L80:
                int r7 = r7 + 1
                r8 = r10
                goto L69
            L84:
                java.lang.String r13 = "Required value was null."
                androidx.privacysandbox.ads.adservices.customaudience.a.i(r13)
                r13 = 0
                return r13
            L8b:
                boolean r14 = r5.isEmpty()
                if (r14 != 0) goto La4
                r7.i r14 = r12.$$this$flow
                java.util.Set r1 = q6.l.J0(r5)
                r0.L$0 = r12
                r0.L$1 = r13
                r0.label = r2
                java.lang.Object r14 = r14.emit(r1, r0)
                if (r14 != r4) goto La4
            La3:
                return r4
            La4:
                r0 = r12
            La5:
                kotlin.jvm.internal.x r14 = r0.$currentVersions
                r14.f7024a = r13
                p6.x r13 = p6.x.f8463a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$createFlow$1.AnonymousClass2.emit(int[], t6.c):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$createFlow$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, int[] iArr, boolean z9, String[] strArr, t6.c cVar) {
        super(2, cVar);
        this.this$0 = triggerBasedInvalidationTracker;
        this.$tableIds = iArr;
        this.$emitInitialState = z9;
        this.$resolvedTableNames = strArr;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        TriggerBasedInvalidationTracker$createFlow$1 triggerBasedInvalidationTracker$createFlow$1 = new TriggerBasedInvalidationTracker$createFlow$1(this.this$0, this.$tableIds, this.$emitInitialState, this.$resolvedTableNames, cVar);
        triggerBasedInvalidationTracker$createFlow$1.L$0 = obj;
        return triggerBasedInvalidationTracker$createFlow$1;
    }

    @Override // d7.p
    public final Object invoke(r7.i iVar, t6.c cVar) {
        return ((TriggerBasedInvalidationTracker$createFlow$1) create(iVar, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x008f, code lost:
    
        if (r14.collect(r6, r13) != r5) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
    
        if (o7.c0.C(r4, (t6.h) r14, r13) == r5) goto L28;
     */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            int r0 = r13.label
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            u6.a r5 = u6.a.f10762a
            if (r0 == 0) goto L30
            if (r0 == r4) goto L28
            if (r0 == r3) goto L20
            if (r0 == r2) goto L17
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r14)
            r14 = 0
            return r14
        L17:
            p6.a.e(r14)     // Catch: java.lang.Throwable -> L1c
            goto L92
        L1c:
            r0 = move-exception
            r14 = r0
            goto L98
        L20:
            java.lang.Object r0 = r13.L$0
            r7.i r0 = (r7.i) r0
            p6.a.e(r14)
            goto L6e
        L28:
            java.lang.Object r0 = r13.L$0
            r7.i r0 = (r7.i) r0
            p6.a.e(r14)
            goto L5a
        L30:
            p6.a.e(r14)
            java.lang.Object r14 = r13.L$0
            r7.i r14 = (r7.i) r14
            androidx.room.TriggerBasedInvalidationTracker r0 = r13.this$0
            androidx.room.ObservedTableStates r0 = androidx.room.TriggerBasedInvalidationTracker.access$getObservedTableStates$p(r0)
            int[] r6 = r13.$tableIds
            boolean r0 = r0.onObserverAdded$room_runtime_release(r6)
            if (r0 == 0) goto L70
            androidx.room.TriggerBasedInvalidationTracker r0 = r13.this$0
            androidx.room.RoomDatabase r0 = androidx.room.TriggerBasedInvalidationTracker.access$getDatabase$p(r0)
            r13.L$0 = r14
            r13.label = r4
            r4 = 0
            java.lang.Object r0 = androidx.room.util.DBUtil.getCoroutineContext(r0, r4, r13)
            if (r0 != r5) goto L57
            goto L91
        L57:
            r12 = r0
            r0 = r14
            r14 = r12
        L5a:
            t6.h r14 = (t6.h) r14
            androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1 r4 = new androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1
            androidx.room.TriggerBasedInvalidationTracker r6 = r13.this$0
            r4.<init>(r6, r1)
            r13.L$0 = r0
            r13.label = r3
            java.lang.Object r14 = o7.c0.C(r4, r14, r13)
            if (r14 != r5) goto L6e
            goto L91
        L6e:
            r9 = r0
            goto L71
        L70:
            r9 = r14
        L71:
            kotlin.jvm.internal.x r7 = new kotlin.jvm.internal.x     // Catch: java.lang.Throwable -> L1c
            r7.<init>()     // Catch: java.lang.Throwable -> L1c
            androidx.room.TriggerBasedInvalidationTracker r14 = r13.this$0     // Catch: java.lang.Throwable -> L1c
            androidx.room.ObservedTableVersions r14 = androidx.room.TriggerBasedInvalidationTracker.access$getObservedTableVersions$p(r14)     // Catch: java.lang.Throwable -> L1c
            androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2 r6 = new androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2     // Catch: java.lang.Throwable -> L1c
            boolean r8 = r13.$emitInitialState     // Catch: java.lang.Throwable -> L1c
            java.lang.String[] r10 = r13.$resolvedTableNames     // Catch: java.lang.Throwable -> L1c
            int[] r11 = r13.$tableIds     // Catch: java.lang.Throwable -> L1c
            r6.<init>(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L1c
            r13.L$0 = r1     // Catch: java.lang.Throwable -> L1c
            r13.label = r2     // Catch: java.lang.Throwable -> L1c
            java.lang.Object r14 = r14.collect(r6, r13)     // Catch: java.lang.Throwable -> L1c
            if (r14 != r5) goto L92
        L91:
            return r5
        L92:
            a1.b r14 = new a1.b     // Catch: java.lang.Throwable -> L1c
            r14.<init>()     // Catch: java.lang.Throwable -> L1c
            throw r14     // Catch: java.lang.Throwable -> L1c
        L98:
            androidx.room.TriggerBasedInvalidationTracker r0 = r13.this$0
            androidx.room.ObservedTableStates r0 = androidx.room.TriggerBasedInvalidationTracker.access$getObservedTableStates$p(r0)
            int[] r1 = r13.$tableIds
            r0.onObserverRemoved$room_runtime_release(r1)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$createFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
