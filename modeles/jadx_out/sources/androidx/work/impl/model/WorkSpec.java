package androidx.work.impl.model;

import a4.x;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.core.location.LocationRequestCompat;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.OverwritingInputMerger;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.l;
import q6.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Entity(indices = {@Index({"schedule_requested_at"}), @Index({"last_enqueue_time"})})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkSpec {
    public static final Companion Companion = new Companion(null);
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1;
    private static final String TAG;
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER;

    @ColumnInfo(name = "backoff_on_system_interruptions")
    private Boolean backOffOnSystemInterruptions;

    @ColumnInfo(name = "backoff_delay_duration")
    public long backoffDelayDuration;

    @ColumnInfo(name = "backoff_policy")
    public BackoffPolicy backoffPolicy;

    @Embedded
    public Constraints constraints;

    @ColumnInfo(name = "run_in_foreground")
    public boolean expedited;

    @ColumnInfo(name = "flex_duration")
    public long flexDuration;

    @ColumnInfo(defaultValue = "0")
    private final int generation;

    @PrimaryKey
    @ColumnInfo(name = "id")
    public final String id;

    @ColumnInfo(name = "initial_delay")
    public long initialDelay;

    @ColumnInfo(name = "input")
    public Data input;

    @ColumnInfo(name = "input_merger_class_name")
    public String inputMergerClassName;

    @ColumnInfo(name = "interval_duration")
    public long intervalDuration;

    @ColumnInfo(defaultValue = "-1", name = "last_enqueue_time")
    public long lastEnqueueTime;

    @ColumnInfo(name = "minimum_retention_duration")
    public long minimumRetentionDuration;

    @ColumnInfo(defaultValue = "9223372036854775807", name = "next_schedule_time_override")
    private long nextScheduleTimeOverride;

    @ColumnInfo(defaultValue = "0", name = "next_schedule_time_override_generation")
    private int nextScheduleTimeOverrideGeneration;

    @ColumnInfo(name = "out_of_quota_policy")
    public OutOfQuotaPolicy outOfQuotaPolicy;

    @ColumnInfo(name = "output")
    public Data output;

    @ColumnInfo(defaultValue = "0", name = "period_count")
    private int periodCount;

    @ColumnInfo(name = "run_attempt_count")
    public int runAttemptCount;

    @ColumnInfo(name = "schedule_requested_at")
    public long scheduleRequestedAt;

    @ColumnInfo(name = "state")
    public WorkInfo.State state;

    @ColumnInfo(defaultValue = "-256", name = "stop_reason")
    private final int stopReason;

    @ColumnInfo(name = "trace_tag")
    private String traceTag;

    @ColumnInfo(name = "worker_class_name")
    public String workerClassName;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class IdAndState {

        @ColumnInfo(name = "id")
        public String id;

        @ColumnInfo(name = "state")
        public WorkInfo.State state;

        public IdAndState(String str, WorkInfo.State state) {
            str.getClass();
            state.getClass();
            this.id = str;
            this.state = state;
        }

        public static /* synthetic */ IdAndState copy$default(IdAndState idAndState, String str, WorkInfo.State state, int i, Object obj) {
            if ((i & 1) != 0) {
                str = idAndState.id;
            }
            if ((i & 2) != 0) {
                state = idAndState.state;
            }
            return idAndState.copy(str, state);
        }

        public final String component1() {
            return this.id;
        }

        public final WorkInfo.State component2() {
            return this.state;
        }

        public final IdAndState copy(String str, WorkInfo.State state) {
            str.getClass();
            state.getClass();
            return new IdAndState(str, state);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            return l.a(this.id, idAndState.id) && this.state == idAndState.state;
        }

        public int hashCode() {
            return this.state.hashCode() + (this.id.hashCode() * 31);
        }

        public String toString() {
            return "IdAndState(id=" + this.id + ", state=" + this.state + ')';
        }
    }

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkSpec");
        tagWithPrefix.getClass();
        TAG = tagWithPrefix;
        WORK_INFO_MAPPER = new androidx.privacysandbox.ads.adservices.customaudience.a(24);
    }

    public /* synthetic */ WorkSpec(String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j, long j6, long j10, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j11, long j12, long j13, long j14, boolean z9, OutOfQuotaPolicy outOfQuotaPolicy, int i6, int i10, long j15, int i11, int i12, String str4, Boolean bool, int i13, kotlin.jvm.internal.g gVar) {
        this(str, (i13 & 2) != 0 ? WorkInfo.State.ENQUEUED : state, str2, (i13 & 8) != 0 ? OverwritingInputMerger.class.getName() : str3, (i13 & 16) != 0 ? Data.EMPTY : data, (i13 & 32) != 0 ? Data.EMPTY : data2, (i13 & 64) != 0 ? 0L : j, (i13 & 128) != 0 ? 0L : j6, (i13 & 256) != 0 ? 0L : j10, (i13 & 512) != 0 ? Constraints.NONE : constraints, (i13 & 1024) != 0 ? 0 : i, (i13 & 2048) != 0 ? BackoffPolicy.EXPONENTIAL : backoffPolicy, (i13 & 4096) != 0 ? WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS : j11, (i13 & 8192) != 0 ? -1L : j12, (i13 & 16384) == 0 ? j13 : 0L, (32768 & i13) != 0 ? -1L : j14, (65536 & i13) != 0 ? false : z9, (131072 & i13) != 0 ? OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST : outOfQuotaPolicy, (262144 & i13) != 0 ? 0 : i6, (524288 & i13) != 0 ? 0 : i10, (1048576 & i13) != 0 ? Long.MAX_VALUE : j15, (2097152 & i13) != 0 ? 0 : i11, (4194304 & i13) != 0 ? -256 : i12, (8388608 & i13) != 0 ? null : str4, (i13 & 16777216) != 0 ? Boolean.FALSE : bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List WORK_INFO_MAPPER$lambda$1(List list) {
        if (list == null) {
            return null;
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(n.i0(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((WorkInfoPojo) it.next()).toWorkInfo());
        }
        return arrayList;
    }

    public static /* synthetic */ WorkSpec copy$default(WorkSpec workSpec, String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j, long j6, long j10, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j11, long j12, long j13, long j14, boolean z9, OutOfQuotaPolicy outOfQuotaPolicy, int i6, int i10, long j15, int i11, int i12, String str4, Boolean bool, int i13, Object obj) {
        Boolean bool2;
        String str5;
        long j16;
        long j17;
        long j18;
        long j19;
        OutOfQuotaPolicy outOfQuotaPolicy2;
        int i14;
        int i15;
        long j20;
        int i16;
        WorkInfo.State state2;
        int i17;
        boolean z10;
        String str6;
        String str7;
        Data data3;
        Data data4;
        long j21;
        long j22;
        long j23;
        Constraints constraints2;
        int i18;
        BackoffPolicy backoffPolicy2;
        String str8 = (i13 & 1) != 0 ? workSpec.id : str;
        WorkInfo.State state3 = (i13 & 2) != 0 ? workSpec.state : state;
        String str9 = (i13 & 4) != 0 ? workSpec.workerClassName : str2;
        String str10 = (i13 & 8) != 0 ? workSpec.inputMergerClassName : str3;
        Data data5 = (i13 & 16) != 0 ? workSpec.input : data;
        Data data6 = (i13 & 32) != 0 ? workSpec.output : data2;
        long j24 = (i13 & 64) != 0 ? workSpec.initialDelay : j;
        long j25 = (i13 & 128) != 0 ? workSpec.intervalDuration : j6;
        long j26 = (i13 & 256) != 0 ? workSpec.flexDuration : j10;
        Constraints constraints3 = (i13 & 512) != 0 ? workSpec.constraints : constraints;
        int i19 = (i13 & 1024) != 0 ? workSpec.runAttemptCount : i;
        String str11 = str8;
        BackoffPolicy backoffPolicy3 = (i13 & 2048) != 0 ? workSpec.backoffPolicy : backoffPolicy;
        WorkInfo.State state4 = state3;
        long j27 = (i13 & 4096) != 0 ? workSpec.backoffDelayDuration : j11;
        long j28 = (i13 & 8192) != 0 ? workSpec.lastEnqueueTime : j12;
        long j29 = (i13 & 16384) != 0 ? workSpec.minimumRetentionDuration : j13;
        long j30 = (i13 & 32768) != 0 ? workSpec.scheduleRequestedAt : j14;
        boolean z11 = (i13 & 65536) != 0 ? workSpec.expedited : z9;
        long j31 = j30;
        OutOfQuotaPolicy outOfQuotaPolicy3 = (i13 & 131072) != 0 ? workSpec.outOfQuotaPolicy : outOfQuotaPolicy;
        int i20 = (i13 & 262144) != 0 ? workSpec.periodCount : i6;
        OutOfQuotaPolicy outOfQuotaPolicy4 = outOfQuotaPolicy3;
        int i21 = (i13 & 524288) != 0 ? workSpec.generation : i10;
        int i22 = i20;
        long j32 = (i13 & 1048576) != 0 ? workSpec.nextScheduleTimeOverride : j15;
        int i23 = (i13 & 2097152) != 0 ? workSpec.nextScheduleTimeOverrideGeneration : i11;
        int i24 = (i13 & 4194304) != 0 ? workSpec.stopReason : i12;
        int i25 = i23;
        String str12 = (i13 & 8388608) != 0 ? workSpec.traceTag : str4;
        if ((i13 & 16777216) != 0) {
            str5 = str12;
            bool2 = workSpec.backOffOnSystemInterruptions;
            j17 = j28;
            j18 = j29;
            j19 = j31;
            outOfQuotaPolicy2 = outOfQuotaPolicy4;
            i14 = i22;
            i15 = i21;
            j20 = j32;
            i16 = i25;
            i17 = i24;
            z10 = z11;
            str7 = str10;
            data3 = data5;
            data4 = data6;
            j21 = j24;
            j22 = j25;
            j23 = j26;
            constraints2 = constraints3;
            i18 = i19;
            backoffPolicy2 = backoffPolicy3;
            j16 = j27;
            state2 = state4;
            str6 = str9;
        } else {
            bool2 = bool;
            str5 = str12;
            j16 = j27;
            j17 = j28;
            j18 = j29;
            j19 = j31;
            outOfQuotaPolicy2 = outOfQuotaPolicy4;
            i14 = i22;
            i15 = i21;
            j20 = j32;
            i16 = i25;
            state2 = state4;
            i17 = i24;
            z10 = z11;
            str6 = str9;
            str7 = str10;
            data3 = data5;
            data4 = data6;
            j21 = j24;
            j22 = j25;
            j23 = j26;
            constraints2 = constraints3;
            i18 = i19;
            backoffPolicy2 = backoffPolicy3;
        }
        return workSpec.copy(str11, state2, str6, str7, data3, data4, j21, j22, j23, constraints2, i18, backoffPolicy2, j16, j17, j18, j19, z10, outOfQuotaPolicy2, i14, i15, j20, i16, i17, str5, bool2);
    }

    public final long calculateNextRunTime() {
        return Companion.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride);
    }

    public final String component1() {
        return this.id;
    }

    public final Constraints component10() {
        return this.constraints;
    }

    public final int component11() {
        return this.runAttemptCount;
    }

    public final BackoffPolicy component12() {
        return this.backoffPolicy;
    }

    public final long component13() {
        return this.backoffDelayDuration;
    }

    public final long component14() {
        return this.lastEnqueueTime;
    }

    public final long component15() {
        return this.minimumRetentionDuration;
    }

    public final long component16() {
        return this.scheduleRequestedAt;
    }

    public final boolean component17() {
        return this.expedited;
    }

    public final OutOfQuotaPolicy component18() {
        return this.outOfQuotaPolicy;
    }

    public final int component19() {
        return this.periodCount;
    }

    public final WorkInfo.State component2() {
        return this.state;
    }

    public final int component20() {
        return this.generation;
    }

    public final long component21() {
        return this.nextScheduleTimeOverride;
    }

    public final int component22() {
        return this.nextScheduleTimeOverrideGeneration;
    }

    public final int component23() {
        return this.stopReason;
    }

    public final String component24() {
        return this.traceTag;
    }

    public final Boolean component25() {
        return this.backOffOnSystemInterruptions;
    }

    public final String component3() {
        return this.workerClassName;
    }

    public final String component4() {
        return this.inputMergerClassName;
    }

    public final Data component5() {
        return this.input;
    }

    public final Data component6() {
        return this.output;
    }

    public final long component7() {
        return this.initialDelay;
    }

    public final long component8() {
        return this.intervalDuration;
    }

    public final long component9() {
        return this.flexDuration;
    }

    public final WorkSpec copy(String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j, long j6, long j10, Constraints constraints, @IntRange(from = 0) int i, BackoffPolicy backoffPolicy, long j11, long j12, long j13, long j14, boolean z9, OutOfQuotaPolicy outOfQuotaPolicy, int i6, int i10, long j15, int i11, int i12, String str4, Boolean bool) {
        str.getClass();
        state.getClass();
        str2.getClass();
        str3.getClass();
        data.getClass();
        data2.getClass();
        constraints.getClass();
        backoffPolicy.getClass();
        outOfQuotaPolicy.getClass();
        return new WorkSpec(str, state, str2, str3, data, data2, j, j6, j10, constraints, i, backoffPolicy, j11, j12, j13, j14, z9, outOfQuotaPolicy, i6, i10, j15, i11, i12, str4, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        return l.a(this.id, workSpec.id) && this.state == workSpec.state && l.a(this.workerClassName, workSpec.workerClassName) && l.a(this.inputMergerClassName, workSpec.inputMergerClassName) && l.a(this.input, workSpec.input) && l.a(this.output, workSpec.output) && this.initialDelay == workSpec.initialDelay && this.intervalDuration == workSpec.intervalDuration && this.flexDuration == workSpec.flexDuration && l.a(this.constraints, workSpec.constraints) && this.runAttemptCount == workSpec.runAttemptCount && this.backoffPolicy == workSpec.backoffPolicy && this.backoffDelayDuration == workSpec.backoffDelayDuration && this.lastEnqueueTime == workSpec.lastEnqueueTime && this.minimumRetentionDuration == workSpec.minimumRetentionDuration && this.scheduleRequestedAt == workSpec.scheduleRequestedAt && this.expedited == workSpec.expedited && this.outOfQuotaPolicy == workSpec.outOfQuotaPolicy && this.periodCount == workSpec.periodCount && this.generation == workSpec.generation && this.nextScheduleTimeOverride == workSpec.nextScheduleTimeOverride && this.nextScheduleTimeOverrideGeneration == workSpec.nextScheduleTimeOverrideGeneration && this.stopReason == workSpec.stopReason && l.a(this.traceTag, workSpec.traceTag) && l.a(this.backOffOnSystemInterruptions, workSpec.backOffOnSystemInterruptions);
    }

    public final Boolean getBackOffOnSystemInterruptions() {
        return this.backOffOnSystemInterruptions;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final long getNextScheduleTimeOverride() {
        return this.nextScheduleTimeOverride;
    }

    public final int getNextScheduleTimeOverrideGeneration() {
        return this.nextScheduleTimeOverrideGeneration;
    }

    public final int getPeriodCount() {
        return this.periodCount;
    }

    public final int getStopReason() {
        return this.stopReason;
    }

    public final String getTraceTag() {
        return this.traceTag;
    }

    public final boolean hasConstraints() {
        return !l.a(Constraints.NONE, this.constraints);
    }

    public int hashCode() {
        int hashCode = (this.output.hashCode() + ((this.input.hashCode() + androidx.lifecycle.l.o(androidx.lifecycle.l.o((this.state.hashCode() + (this.id.hashCode() * 31)) * 31, 31, this.workerClassName), 31, this.inputMergerClassName)) * 31)) * 31;
        long j = this.initialDelay;
        int i = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j6 = this.intervalDuration;
        int i6 = (i + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j10 = this.flexDuration;
        int hashCode2 = (this.backoffPolicy.hashCode() + ((((this.constraints.hashCode() + ((i6 + ((int) (j10 ^ (j10 >>> 32)))) * 31)) * 31) + this.runAttemptCount) * 31)) * 31;
        long j11 = this.backoffDelayDuration;
        int i10 = (hashCode2 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.lastEnqueueTime;
        int i11 = (i10 + ((int) (j12 ^ (j12 >>> 32)))) * 31;
        long j13 = this.minimumRetentionDuration;
        int i12 = (i11 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
        long j14 = this.scheduleRequestedAt;
        int hashCode3 = (((((this.outOfQuotaPolicy.hashCode() + ((((i12 + ((int) (j14 ^ (j14 >>> 32)))) * 31) + (this.expedited ? 1231 : 1237)) * 31)) * 31) + this.periodCount) * 31) + this.generation) * 31;
        long j15 = this.nextScheduleTimeOverride;
        int i13 = (((((hashCode3 + ((int) ((j15 >>> 32) ^ j15))) * 31) + this.nextScheduleTimeOverrideGeneration) * 31) + this.stopReason) * 31;
        String str = this.traceTag;
        int hashCode4 = (i13 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.backOffOnSystemInterruptions;
        return hashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public final boolean isBackedOff() {
        return this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
    }

    public final boolean isPeriodic() {
        return this.intervalDuration != 0;
    }

    public final void setBackOffOnSystemInterruptions(Boolean bool) {
        this.backOffOnSystemInterruptions = bool;
    }

    public final void setBackoffDelayDuration(long j) {
        if (j > WorkRequest.MAX_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value");
        }
        if (j < WorkRequest.MIN_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration less than minimum value");
        }
        this.backoffDelayDuration = t0.f.k(j, WorkRequest.MIN_BACKOFF_MILLIS, WorkRequest.MAX_BACKOFF_MILLIS);
    }

    public final void setNextScheduleTimeOverride(long j) {
        this.nextScheduleTimeOverride = j;
    }

    public final void setNextScheduleTimeOverrideGeneration(int i) {
        this.nextScheduleTimeOverrideGeneration = i;
    }

    public final void setPeriodCount(int i) {
        this.periodCount = i;
    }

    public final void setPeriodic(long j, long j6) {
        long j10 = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
        if (j < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        if (j >= PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            j10 = j;
        }
        this.intervalDuration = j10;
        if (j6 < PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            Logger.get().warning(TAG, "Flex duration lesser than minimum allowed value; Changed to 300000");
        }
        if (j6 > this.intervalDuration) {
            Logger.get().warning(TAG, "Flex duration greater than interval duration; Changed to " + j);
        }
        this.flexDuration = t0.f.k(j6, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS, this.intervalDuration);
    }

    public final void setTraceTag(String str) {
        this.traceTag = str;
    }

    public String toString() {
        return x.m(new StringBuilder("{WorkSpec: "), this.id, '}');
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class WorkInfoPojo {

        @ColumnInfo(name = "backoff_delay_duration")
        private long backoffDelayDuration;

        @ColumnInfo(name = "backoff_policy")
        private BackoffPolicy backoffPolicy;

        @Embedded
        private final Constraints constraints;

        @ColumnInfo(name = "flex_duration")
        private final long flexDuration;

        @ColumnInfo(name = "generation")
        private final int generation;

        @ColumnInfo(name = "id")
        private final String id;

        @ColumnInfo(name = "initial_delay")
        private final long initialDelay;

        @ColumnInfo(name = "interval_duration")
        private final long intervalDuration;

        @ColumnInfo(name = "last_enqueue_time")
        private long lastEnqueueTime;

        @ColumnInfo(name = "next_schedule_time_override")
        private final long nextScheduleTimeOverride;

        @ColumnInfo(name = "output")
        private final Data output;

        @ColumnInfo(defaultValue = "0", name = "period_count")
        private int periodCount;

        @Relation(entity = WorkProgress.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"progress"})
        private final List<Data> progress;

        @ColumnInfo(name = "run_attempt_count")
        private final int runAttemptCount;

        @ColumnInfo(name = "state")
        private final WorkInfo.State state;

        @ColumnInfo(name = "stop_reason")
        private final int stopReason;

        @Relation(entity = WorkTag.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"tag"})
        private final List<String> tags;

        public /* synthetic */ WorkInfoPojo(String str, WorkInfo.State state, Data data, long j, long j6, long j10, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j11, long j12, int i6, int i10, long j13, int i11, List list, List list2, int i12, kotlin.jvm.internal.g gVar) {
            this(str, state, data, (i12 & 8) != 0 ? 0L : j, (i12 & 16) != 0 ? 0L : j6, (i12 & 32) != 0 ? 0L : j10, constraints, i, (i12 & 256) != 0 ? BackoffPolicy.EXPONENTIAL : backoffPolicy, (i12 & 512) != 0 ? 30000L : j11, (i12 & 1024) != 0 ? 0L : j12, (i12 & 2048) != 0 ? 0 : i6, i10, j13, i11, list, list2);
        }

        private final long calculateNextRunTimeMillis() {
            return this.state == WorkInfo.State.ENQUEUED ? WorkSpec.Companion.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride) : LocationRequestCompat.PASSIVE_INTERVAL;
        }

        public static /* synthetic */ WorkInfoPojo copy$default(WorkInfoPojo workInfoPojo, String str, WorkInfo.State state, Data data, long j, long j6, long j10, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j11, long j12, int i6, int i10, long j13, int i11, List list, List list2, int i12, Object obj) {
            String str2 = (i12 & 1) != 0 ? workInfoPojo.id : str;
            WorkInfo.State state2 = (i12 & 2) != 0 ? workInfoPojo.state : state;
            return workInfoPojo.copy(str2, state2, (i12 & 4) != 0 ? workInfoPojo.output : data, (i12 & 8) != 0 ? workInfoPojo.initialDelay : j, (i12 & 16) != 0 ? workInfoPojo.intervalDuration : j6, (i12 & 32) != 0 ? workInfoPojo.flexDuration : j10, (i12 & 64) != 0 ? workInfoPojo.constraints : constraints, (i12 & 128) != 0 ? workInfoPojo.runAttemptCount : i, (i12 & 256) != 0 ? workInfoPojo.backoffPolicy : backoffPolicy, (i12 & 512) != 0 ? workInfoPojo.backoffDelayDuration : j11, (i12 & 1024) != 0 ? workInfoPojo.lastEnqueueTime : j12, (i12 & 2048) != 0 ? workInfoPojo.periodCount : i6, (i12 & 4096) != 0 ? workInfoPojo.generation : i10, (i12 & 8192) != 0 ? workInfoPojo.nextScheduleTimeOverride : j13, (i12 & 16384) != 0 ? workInfoPojo.stopReason : i11, (32768 & i12) != 0 ? workInfoPojo.tags : list, (i12 & 65536) != 0 ? workInfoPojo.progress : list2);
        }

        private final WorkInfo.PeriodicityInfo getPeriodicityOrNull() {
            long j = this.intervalDuration;
            if (j != 0) {
                return new WorkInfo.PeriodicityInfo(j, this.flexDuration);
            }
            return null;
        }

        public final String component1() {
            return this.id;
        }

        public final long component10() {
            return this.backoffDelayDuration;
        }

        public final long component11() {
            return this.lastEnqueueTime;
        }

        public final int component12() {
            return this.periodCount;
        }

        public final int component13() {
            return this.generation;
        }

        public final long component14() {
            return this.nextScheduleTimeOverride;
        }

        public final int component15() {
            return this.stopReason;
        }

        public final List<String> component16() {
            return this.tags;
        }

        public final List<Data> component17() {
            return this.progress;
        }

        public final WorkInfo.State component2() {
            return this.state;
        }

        public final Data component3() {
            return this.output;
        }

        public final long component4() {
            return this.initialDelay;
        }

        public final long component5() {
            return this.intervalDuration;
        }

        public final long component6() {
            return this.flexDuration;
        }

        public final Constraints component7() {
            return this.constraints;
        }

        public final int component8() {
            return this.runAttemptCount;
        }

        public final BackoffPolicy component9() {
            return this.backoffPolicy;
        }

        public final WorkInfoPojo copy(String str, WorkInfo.State state, Data data, long j, long j6, long j10, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j11, long j12, int i6, int i10, long j13, int i11, List<String> list, List<Data> list2) {
            str.getClass();
            state.getClass();
            data.getClass();
            constraints.getClass();
            backoffPolicy.getClass();
            list.getClass();
            list2.getClass();
            return new WorkInfoPojo(str, state, data, j, j6, j10, constraints, i, backoffPolicy, j11, j12, i6, i10, j13, i11, list, list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) obj;
            return l.a(this.id, workInfoPojo.id) && this.state == workInfoPojo.state && l.a(this.output, workInfoPojo.output) && this.initialDelay == workInfoPojo.initialDelay && this.intervalDuration == workInfoPojo.intervalDuration && this.flexDuration == workInfoPojo.flexDuration && l.a(this.constraints, workInfoPojo.constraints) && this.runAttemptCount == workInfoPojo.runAttemptCount && this.backoffPolicy == workInfoPojo.backoffPolicy && this.backoffDelayDuration == workInfoPojo.backoffDelayDuration && this.lastEnqueueTime == workInfoPojo.lastEnqueueTime && this.periodCount == workInfoPojo.periodCount && this.generation == workInfoPojo.generation && this.nextScheduleTimeOverride == workInfoPojo.nextScheduleTimeOverride && this.stopReason == workInfoPojo.stopReason && l.a(this.tags, workInfoPojo.tags) && l.a(this.progress, workInfoPojo.progress);
        }

        public final long getBackoffDelayDuration() {
            return this.backoffDelayDuration;
        }

        public final BackoffPolicy getBackoffPolicy() {
            return this.backoffPolicy;
        }

        public final Constraints getConstraints() {
            return this.constraints;
        }

        public final long getFlexDuration() {
            return this.flexDuration;
        }

        public final int getGeneration() {
            return this.generation;
        }

        public final String getId() {
            return this.id;
        }

        public final long getInitialDelay() {
            return this.initialDelay;
        }

        public final long getIntervalDuration() {
            return this.intervalDuration;
        }

        public final long getLastEnqueueTime() {
            return this.lastEnqueueTime;
        }

        public final long getNextScheduleTimeOverride() {
            return this.nextScheduleTimeOverride;
        }

        public final Data getOutput() {
            return this.output;
        }

        public final int getPeriodCount() {
            return this.periodCount;
        }

        public final List<Data> getProgress() {
            return this.progress;
        }

        public final int getRunAttemptCount() {
            return this.runAttemptCount;
        }

        public final WorkInfo.State getState() {
            return this.state;
        }

        public final int getStopReason() {
            return this.stopReason;
        }

        public final List<String> getTags() {
            return this.tags;
        }

        public int hashCode() {
            int hashCode = (this.output.hashCode() + ((this.state.hashCode() + (this.id.hashCode() * 31)) * 31)) * 31;
            long j = this.initialDelay;
            int i = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
            long j6 = this.intervalDuration;
            int i6 = (i + ((int) (j6 ^ (j6 >>> 32)))) * 31;
            long j10 = this.flexDuration;
            int hashCode2 = (this.backoffPolicy.hashCode() + ((((this.constraints.hashCode() + ((i6 + ((int) (j10 ^ (j10 >>> 32)))) * 31)) * 31) + this.runAttemptCount) * 31)) * 31;
            long j11 = this.backoffDelayDuration;
            int i10 = (hashCode2 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.lastEnqueueTime;
            int i11 = (((((i10 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + this.periodCount) * 31) + this.generation) * 31;
            long j13 = this.nextScheduleTimeOverride;
            return this.progress.hashCode() + ((this.tags.hashCode() + ((((i11 + ((int) (j13 ^ (j13 >>> 32)))) * 31) + this.stopReason) * 31)) * 31);
        }

        public final boolean isBackedOff() {
            return this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
        }

        public final boolean isPeriodic() {
            return this.intervalDuration != 0;
        }

        public final void setBackoffDelayDuration(long j) {
            this.backoffDelayDuration = j;
        }

        public final void setBackoffPolicy(BackoffPolicy backoffPolicy) {
            backoffPolicy.getClass();
            this.backoffPolicy = backoffPolicy;
        }

        public final void setLastEnqueueTime(long j) {
            this.lastEnqueueTime = j;
        }

        public final void setPeriodCount(int i) {
            this.periodCount = i;
        }

        public String toString() {
            return "WorkInfoPojo(id=" + this.id + ", state=" + this.state + ", output=" + this.output + ", initialDelay=" + this.initialDelay + ", intervalDuration=" + this.intervalDuration + ", flexDuration=" + this.flexDuration + ", constraints=" + this.constraints + ", runAttemptCount=" + this.runAttemptCount + ", backoffPolicy=" + this.backoffPolicy + ", backoffDelayDuration=" + this.backoffDelayDuration + ", lastEnqueueTime=" + this.lastEnqueueTime + ", periodCount=" + this.periodCount + ", generation=" + this.generation + ", nextScheduleTimeOverride=" + this.nextScheduleTimeOverride + ", stopReason=" + this.stopReason + ", tags=" + this.tags + ", progress=" + this.progress + ')';
        }

        public final WorkInfo toWorkInfo() {
            Data data = !this.progress.isEmpty() ? this.progress.get(0) : Data.EMPTY;
            UUID fromString = UUID.fromString(this.id);
            fromString.getClass();
            return new WorkInfo(fromString, this.state, new HashSet(this.tags), this.output, data, this.runAttemptCount, this.generation, this.constraints, this.initialDelay, getPeriodicityOrNull(), calculateNextRunTimeMillis(), this.stopReason);
        }

        public WorkInfoPojo(String str, WorkInfo.State state, Data data, long j, long j6, long j10, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j11, long j12, int i6, int i10, long j13, int i11, List<String> list, List<Data> list2) {
            str.getClass();
            state.getClass();
            data.getClass();
            constraints.getClass();
            backoffPolicy.getClass();
            list.getClass();
            list2.getClass();
            this.id = str;
            this.state = state;
            this.output = data;
            this.initialDelay = j;
            this.intervalDuration = j6;
            this.flexDuration = j10;
            this.constraints = constraints;
            this.runAttemptCount = i;
            this.backoffPolicy = backoffPolicy;
            this.backoffDelayDuration = j11;
            this.lastEnqueueTime = j12;
            this.periodCount = i6;
            this.generation = i10;
            this.nextScheduleTimeOverride = j13;
            this.stopReason = i11;
            this.tags = list;
            this.progress = list2;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final long calculateNextRunTime(boolean z9, int i, BackoffPolicy backoffPolicy, long j, long j6, int i6, boolean z10, long j10, long j11, long j12, long j13) {
            backoffPolicy.getClass();
            if (j13 != LocationRequestCompat.PASSIVE_INTERVAL && z10) {
                if (i6 != 0) {
                    long j14 = j6 + PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
                    if (j13 < j14) {
                        return j14;
                    }
                }
                return j13;
            }
            if (z9) {
                long scalb = backoffPolicy == BackoffPolicy.LINEAR ? j * i : (long) Math.scalb(j, i - 1);
                if (scalb > WorkRequest.MAX_BACKOFF_MILLIS) {
                    scalb = 18000000;
                }
                return j6 + scalb;
            }
            if (!z10) {
                return j6 == -1 ? LocationRequestCompat.PASSIVE_INTERVAL : j6 + j10;
            }
            long j15 = i6 == 0 ? j6 + j10 : j6 + j12;
            return (j11 == j12 || i6 != 0) ? j15 : (j12 - j11) + j15;
        }

        private Companion() {
        }
    }

    public WorkSpec(String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j, long j6, long j10, Constraints constraints, @IntRange(from = 0) int i, BackoffPolicy backoffPolicy, long j11, long j12, long j13, long j14, boolean z9, OutOfQuotaPolicy outOfQuotaPolicy, int i6, int i10, long j15, int i11, int i12, String str4, Boolean bool) {
        str.getClass();
        state.getClass();
        str2.getClass();
        str3.getClass();
        data.getClass();
        data2.getClass();
        constraints.getClass();
        backoffPolicy.getClass();
        outOfQuotaPolicy.getClass();
        this.id = str;
        this.state = state;
        this.workerClassName = str2;
        this.inputMergerClassName = str3;
        this.input = data;
        this.output = data2;
        this.initialDelay = j;
        this.intervalDuration = j6;
        this.flexDuration = j10;
        this.constraints = constraints;
        this.runAttemptCount = i;
        this.backoffPolicy = backoffPolicy;
        this.backoffDelayDuration = j11;
        this.lastEnqueueTime = j12;
        this.minimumRetentionDuration = j13;
        this.scheduleRequestedAt = j14;
        this.expedited = z9;
        this.outOfQuotaPolicy = outOfQuotaPolicy;
        this.periodCount = i6;
        this.generation = i10;
        this.nextScheduleTimeOverride = j15;
        this.nextScheduleTimeOverrideGeneration = i11;
        this.stopReason = i12;
        this.traceTag = str4;
        this.backOffOnSystemInterruptions = bool;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkSpec(String str, String str2) {
        this(str, null, str2, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, null, null, 33554426, null);
        str.getClass();
        str2.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkSpec(String str, WorkSpec workSpec) {
        this(str, workSpec.state, workSpec.workerClassName, workSpec.inputMergerClassName, new Data(workSpec.input), new Data(workSpec.output), workSpec.initialDelay, workSpec.intervalDuration, workSpec.flexDuration, new Constraints(workSpec.constraints), workSpec.runAttemptCount, workSpec.backoffPolicy, workSpec.backoffDelayDuration, workSpec.lastEnqueueTime, workSpec.minimumRetentionDuration, workSpec.scheduleRequestedAt, workSpec.expedited, workSpec.outOfQuotaPolicy, workSpec.periodCount, 0, workSpec.nextScheduleTimeOverride, workSpec.nextScheduleTimeOverrideGeneration, workSpec.stopReason, workSpec.traceTag, workSpec.backOffOnSystemInterruptions, 524288, null);
        str.getClass();
        workSpec.getClass();
    }

    public final void setPeriodic(long j) {
        if (j < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        long j6 = j < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS ? 900000L : j;
        if (j < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            j = 900000;
        }
        setPeriodic(j6, j);
    }
}
