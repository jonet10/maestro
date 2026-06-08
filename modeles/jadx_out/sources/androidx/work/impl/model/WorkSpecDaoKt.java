package androidx.work.impl.model;

import java.util.UUID;
import o7.w;
import p6.x;
import r7.k0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkSpecDaoKt {
    private static final String WORK_INFO_BY_IDS = "SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (:ids)";
    private static final String WORK_INFO_BY_NAME = "SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=:name)";
    private static final String WORK_INFO_BY_TAG = "SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=:tag)";
    private static final String WORK_INFO_COLUMNS = "id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason";

    public static final r7.h dedup(final r7.h hVar, w wVar) {
        hVar.getClass();
        wVar.getClass();
        return k0.l(k0.h(new r7.h() { // from class: androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1

            /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
            /* renamed from: androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements r7.i {
                final /* synthetic */ r7.i $this_unsafeFlow;

                @v6.e(c = "androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2", f = "WorkSpecDao.kt", l = {50}, m = "emit")
                /* renamed from: androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends v6.c {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(t6.c cVar) {
                        super(cVar);
                    }

                    @Override // v6.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(r7.i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
                @Override // r7.i
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, t6.c r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1 r0 = (androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1 r0 = new androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        int r1 = r0.label
                        r2 = 1
                        if (r1 == 0) goto L2c
                        if (r1 != r2) goto L25
                        p6.a.e(r6)
                        goto L63
                    L25:
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
                        r5 = 0
                        return r5
                    L2c:
                        p6.a.e(r6)
                        r7.i r6 = r4.$this_unsafeFlow
                        java.util.List r5 = (java.util.List) r5
                        java.lang.Iterable r5 = (java.lang.Iterable) r5
                        java.util.ArrayList r1 = new java.util.ArrayList
                        r3 = 10
                        int r3 = q6.n.i0(r5, r3)
                        r1.<init>(r3)
                        java.util.Iterator r5 = r5.iterator()
                    L44:
                        boolean r3 = r5.hasNext()
                        if (r3 == 0) goto L58
                        java.lang.Object r3 = r5.next()
                        androidx.work.impl.model.WorkSpec$WorkInfoPojo r3 = (androidx.work.impl.model.WorkSpec.WorkInfoPojo) r3
                        androidx.work.WorkInfo r3 = r3.toWorkInfo()
                        r1.add(r3)
                        goto L44
                    L58:
                        r0.label = r2
                        java.lang.Object r5 = r6.emit(r1, r0)
                        u6.a r6 = u6.a.f10762a
                        if (r5 != r6) goto L63
                        return r6
                    L63:
                        p6.x r5 = p6.x.f8463a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, t6.c):java.lang.Object");
                }
            }

            @Override // r7.h
            public Object collect(r7.i iVar, t6.c cVar) {
                Object collect = r7.h.this.collect(new AnonymousClass2(iVar), cVar);
                return collect == u6.a.f10762a ? collect : x.f8463a;
            }
        }), wVar);
    }

    public static final r7.h getWorkStatusPojoFlowDataForIds(WorkSpecDao workSpecDao, UUID uuid) {
        workSpecDao.getClass();
        uuid.getClass();
        final r7.h workStatusPojoFlowDataForIds = workSpecDao.getWorkStatusPojoFlowDataForIds(a.a.H(String.valueOf(uuid)));
        return k0.h(new r7.h() { // from class: androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1

            /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
            /* renamed from: androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements r7.i {
                final /* synthetic */ r7.i $this_unsafeFlow;

                @v6.e(c = "androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2", f = "WorkSpecDao.kt", l = {50}, m = "emit")
                /* renamed from: androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends v6.c {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(t6.c cVar) {
                        super(cVar);
                    }

                    @Override // v6.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(r7.i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
                @Override // r7.i
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, t6.c r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1 r0 = (androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1 r0 = new androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        int r1 = r0.label
                        r2 = 1
                        if (r1 == 0) goto L2c
                        if (r1 != r2) goto L25
                        p6.a.e(r6)
                        goto L4c
                    L25:
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
                        r5 = 0
                        return r5
                    L2c:
                        p6.a.e(r6)
                        r7.i r6 = r4.$this_unsafeFlow
                        java.util.List r5 = (java.util.List) r5
                        java.lang.Object r5 = q6.l.r0(r5)
                        androidx.work.impl.model.WorkSpec$WorkInfoPojo r5 = (androidx.work.impl.model.WorkSpec.WorkInfoPojo) r5
                        if (r5 == 0) goto L40
                        androidx.work.WorkInfo r5 = r5.toWorkInfo()
                        goto L41
                    L40:
                        r5 = 0
                    L41:
                        r0.label = r2
                        java.lang.Object r5 = r6.emit(r5, r0)
                        u6.a r6 = u6.a.f10762a
                        if (r5 != r6) goto L4c
                        return r6
                    L4c:
                        p6.x r5 = p6.x.f8463a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, t6.c):java.lang.Object");
                }
            }

            @Override // r7.h
            public Object collect(r7.i iVar, t6.c cVar) {
                Object collect = r7.h.this.collect(new AnonymousClass2(iVar), cVar);
                return collect == u6.a.f10762a ? collect : x.f8463a;
            }
        });
    }

    public static final r7.h getWorkStatusPojoFlowForName(WorkSpecDao workSpecDao, w wVar, String str) {
        workSpecDao.getClass();
        wVar.getClass();
        str.getClass();
        return dedup(workSpecDao.getWorkStatusPojoFlowForName(str), wVar);
    }

    public static final r7.h getWorkStatusPojoFlowForTag(WorkSpecDao workSpecDao, w wVar, String str) {
        workSpecDao.getClass();
        wVar.getClass();
        str.getClass();
        return dedup(workSpecDao.getWorkStatusPojoFlowForTag(str), wVar);
    }
}
