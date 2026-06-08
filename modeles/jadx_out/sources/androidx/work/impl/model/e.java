package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import androidx.work.impl.model.WorkSpec;
import d7.l;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class e implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f611a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f612b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f613l;

    public /* synthetic */ e(String str, WorkSpecDao_Impl workSpecDao_Impl, int i) {
        this.f611a = i;
        this.f612b = str;
        this.f613l = workSpecDao_Impl;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        List workStatusPojoFlowForTag$lambda$13;
        List workStatusPojoForTag$lambda$12;
        List workStatusPojoLiveDataForName$lambda$16;
        List workStatusPojoForName$lambda$15;
        List workStatusPojoFlowForName$lambda$17;
        WorkSpec.WorkInfoPojo workStatusPojoForId$lambda$8;
        List workStatusPojoLiveDataForTag$lambda$14;
        switch (this.f611a) {
            case 0:
                workStatusPojoFlowForTag$lambda$13 = WorkSpecDao_Impl.getWorkStatusPojoFlowForTag$lambda$13("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", this.f612b, this.f613l, (SQLiteConnection) obj);
                return workStatusPojoFlowForTag$lambda$13;
            case 1:
                workStatusPojoForTag$lambda$12 = WorkSpecDao_Impl.getWorkStatusPojoForTag$lambda$12("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", this.f612b, this.f613l, (SQLiteConnection) obj);
                return workStatusPojoForTag$lambda$12;
            case 2:
                workStatusPojoLiveDataForName$lambda$16 = WorkSpecDao_Impl.getWorkStatusPojoLiveDataForName$lambda$16("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", this.f612b, this.f613l, (SQLiteConnection) obj);
                return workStatusPojoLiveDataForName$lambda$16;
            case 3:
                workStatusPojoForName$lambda$15 = WorkSpecDao_Impl.getWorkStatusPojoForName$lambda$15("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", this.f612b, this.f613l, (SQLiteConnection) obj);
                return workStatusPojoForName$lambda$15;
            case 4:
                workStatusPojoFlowForName$lambda$17 = WorkSpecDao_Impl.getWorkStatusPojoFlowForName$lambda$17("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", this.f612b, this.f613l, (SQLiteConnection) obj);
                return workStatusPojoFlowForName$lambda$17;
            case 5:
                workStatusPojoForId$lambda$8 = WorkSpecDao_Impl.getWorkStatusPojoForId$lambda$8("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id=?", this.f612b, this.f613l, (SQLiteConnection) obj);
                return workStatusPojoForId$lambda$8;
            default:
                workStatusPojoLiveDataForTag$lambda$14 = WorkSpecDao_Impl.getWorkStatusPojoLiveDataForTag$lambda$14("SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", this.f612b, this.f613l, (SQLiteConnection) obj);
                return workStatusPojoLiveDataForTag$lambda$14;
        }
    }
}
