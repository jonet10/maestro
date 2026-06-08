package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl;
import androidx.work.impl.utils.StatusRunnable;
import d7.l;
import java.util.List;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class e implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f500a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f501b;

    public /* synthetic */ e(String str, int i) {
        this.f500a = i;
        this.f501b = str;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        x execSQL$lambda$7;
        List dependentWorkIds$lambda$3;
        boolean hasDependents$lambda$4;
        boolean hasCompletedAllPrerequisites$lambda$1;
        List prerequisites$lambda$2;
        Long observableLongValue$lambda$2;
        Long longValue$lambda$1;
        x removeSystemIdInfo$lambda$4;
        List workSpecIdsWithName$lambda$1;
        List namesForWorkSpecId$lambda$2;
        Data progressForWorkSpecId$lambda$1;
        x delete$lambda$2;
        x delete$lambda$37;
        List workSpecIdAndStatesForName$lambda$4;
        List unfinishedWorkWithName$lambda$20;
        int resetWorkSpecRunAttemptCount$lambda$44;
        x incrementPeriodCount$lambda$40;
        WorkSpec workSpec$lambda$3;
        List inputsFromPrerequisites$lambda$18;
        x incrementGeneration$lambda$50;
        int cancelledState$lambda$39;
        List unfinishedWorkWithTag$lambda$19;
        int incrementWorkSpecRunAttemptCount$lambda$43;
        WorkInfo.State state$lambda$7;
        Long scheduleRequestedAtLiveData$lambda$23;
        x deleteByWorkSpecId$lambda$3;
        List tagsForWorkSpecId$lambda$2;
        List workSpecIdsWithTag$lambda$1;
        List forUniqueWork$lambda$3;
        switch (this.f500a) {
            case 0:
                execSQL$lambda$7 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.execSQL$lambda$7(this.f501b, (SupportSQLiteDatabase) obj);
                return execSQL$lambda$7;
            case 1:
                dependentWorkIds$lambda$3 = DependencyDao_Impl.getDependentWorkIds$lambda$3("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", this.f501b, (SQLiteConnection) obj);
                return dependentWorkIds$lambda$3;
            case 2:
                hasDependents$lambda$4 = DependencyDao_Impl.hasDependents$lambda$4("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", this.f501b, (SQLiteConnection) obj);
                return Boolean.valueOf(hasDependents$lambda$4);
            case 3:
                hasCompletedAllPrerequisites$lambda$1 = DependencyDao_Impl.hasCompletedAllPrerequisites$lambda$1("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", this.f501b, (SQLiteConnection) obj);
                return Boolean.valueOf(hasCompletedAllPrerequisites$lambda$1);
            case 4:
                prerequisites$lambda$2 = DependencyDao_Impl.getPrerequisites$lambda$2("SELECT prerequisite_id FROM dependency WHERE work_spec_id=?", this.f501b, (SQLiteConnection) obj);
                return prerequisites$lambda$2;
            case 5:
                observableLongValue$lambda$2 = PreferenceDao_Impl.getObservableLongValue$lambda$2("SELECT long_value FROM Preference where `key`=?", this.f501b, (SQLiteConnection) obj);
                return observableLongValue$lambda$2;
            case 6:
                longValue$lambda$1 = PreferenceDao_Impl.getLongValue$lambda$1("SELECT long_value FROM Preference where `key`=?", this.f501b, (SQLiteConnection) obj);
                return longValue$lambda$1;
            case 7:
                removeSystemIdInfo$lambda$4 = SystemIdInfoDao_Impl.removeSystemIdInfo$lambda$4("DELETE FROM SystemIdInfo where work_spec_id=?", this.f501b, (SQLiteConnection) obj);
                return removeSystemIdInfo$lambda$4;
            case 8:
                workSpecIdsWithName$lambda$1 = WorkNameDao_Impl.getWorkSpecIdsWithName$lambda$1("SELECT work_spec_id FROM workname WHERE name=?", this.f501b, (SQLiteConnection) obj);
                return workSpecIdsWithName$lambda$1;
            case 9:
                namesForWorkSpecId$lambda$2 = WorkNameDao_Impl.getNamesForWorkSpecId$lambda$2("SELECT name FROM workname WHERE work_spec_id=?", this.f501b, (SQLiteConnection) obj);
                return namesForWorkSpecId$lambda$2;
            case 10:
                progressForWorkSpecId$lambda$1 = WorkProgressDao_Impl.getProgressForWorkSpecId$lambda$1("SELECT progress FROM WorkProgress WHERE work_spec_id=?", this.f501b, (SQLiteConnection) obj);
                return progressForWorkSpecId$lambda$1;
            case 11:
                delete$lambda$2 = WorkProgressDao_Impl.delete$lambda$2("DELETE from WorkProgress where work_spec_id=?", this.f501b, (SQLiteConnection) obj);
                return delete$lambda$2;
            case 12:
                delete$lambda$37 = WorkSpecDao_Impl.delete$lambda$37("DELETE FROM workspec WHERE id=?", this.f501b, (SQLiteConnection) obj);
                return delete$lambda$37;
            case 13:
                workSpecIdAndStatesForName$lambda$4 = WorkSpecDao_Impl.getWorkSpecIdAndStatesForName$lambda$4("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", this.f501b, (SQLiteConnection) obj);
                return workSpecIdAndStatesForName$lambda$4;
            case 14:
                unfinishedWorkWithName$lambda$20 = WorkSpecDao_Impl.getUnfinishedWorkWithName$lambda$20("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", this.f501b, (SQLiteConnection) obj);
                return unfinishedWorkWithName$lambda$20;
            case 15:
                resetWorkSpecRunAttemptCount$lambda$44 = WorkSpecDao_Impl.resetWorkSpecRunAttemptCount$lambda$44("UPDATE workspec SET run_attempt_count=0 WHERE id=?", this.f501b, (SQLiteConnection) obj);
                return Integer.valueOf(resetWorkSpecRunAttemptCount$lambda$44);
            case 16:
                incrementPeriodCount$lambda$40 = WorkSpecDao_Impl.incrementPeriodCount$lambda$40("UPDATE workspec SET period_count=period_count+1 WHERE id=?", this.f501b, (SQLiteConnection) obj);
                return incrementPeriodCount$lambda$40;
            case 17:
                workSpec$lambda$3 = WorkSpecDao_Impl.getWorkSpec$lambda$3("SELECT * FROM workspec WHERE id=?", this.f501b, (SQLiteConnection) obj);
                return workSpec$lambda$3;
            case 18:
                inputsFromPrerequisites$lambda$18 = WorkSpecDao_Impl.getInputsFromPrerequisites$lambda$18("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", this.f501b, (SQLiteConnection) obj);
                return inputsFromPrerequisites$lambda$18;
            case 19:
                incrementGeneration$lambda$50 = WorkSpecDao_Impl.incrementGeneration$lambda$50("UPDATE workspec SET generation=generation+1 WHERE id=?", this.f501b, (SQLiteConnection) obj);
                return incrementGeneration$lambda$50;
            case 20:
                cancelledState$lambda$39 = WorkSpecDao_Impl.setCancelledState$lambda$39("UPDATE workspec SET stop_reason = CASE WHEN state=1 THEN 1 ELSE -256 END, state=5 WHERE id=?", this.f501b, (SQLiteConnection) obj);
                return Integer.valueOf(cancelledState$lambda$39);
            case 21:
                unfinishedWorkWithTag$lambda$19 = WorkSpecDao_Impl.getUnfinishedWorkWithTag$lambda$19("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", this.f501b, (SQLiteConnection) obj);
                return unfinishedWorkWithTag$lambda$19;
            case 22:
                incrementWorkSpecRunAttemptCount$lambda$43 = WorkSpecDao_Impl.incrementWorkSpecRunAttemptCount$lambda$43("UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?", this.f501b, (SQLiteConnection) obj);
                return Integer.valueOf(incrementWorkSpecRunAttemptCount$lambda$43);
            case 23:
                state$lambda$7 = WorkSpecDao_Impl.getState$lambda$7("SELECT state FROM workspec WHERE id=?", this.f501b, (SQLiteConnection) obj);
                return state$lambda$7;
            case 24:
                scheduleRequestedAtLiveData$lambda$23 = WorkSpecDao_Impl.getScheduleRequestedAtLiveData$lambda$23("SELECT schedule_requested_at FROM workspec WHERE id=?", this.f501b, (SQLiteConnection) obj);
                return scheduleRequestedAtLiveData$lambda$23;
            case 25:
                deleteByWorkSpecId$lambda$3 = WorkTagDao_Impl.deleteByWorkSpecId$lambda$3("DELETE FROM worktag WHERE work_spec_id=?", this.f501b, (SQLiteConnection) obj);
                return deleteByWorkSpecId$lambda$3;
            case 26:
                tagsForWorkSpecId$lambda$2 = WorkTagDao_Impl.getTagsForWorkSpecId$lambda$2("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", this.f501b, (SQLiteConnection) obj);
                return tagsForWorkSpecId$lambda$2;
            case 27:
                workSpecIdsWithTag$lambda$1 = WorkTagDao_Impl.getWorkSpecIdsWithTag$lambda$1("SELECT work_spec_id FROM worktag WHERE tag=?", this.f501b, (SQLiteConnection) obj);
                return workSpecIdsWithTag$lambda$1;
            default:
                forUniqueWork$lambda$3 = StatusRunnable.forUniqueWork$lambda$3(this.f501b, (WorkDatabase) obj);
                return forUniqueWork$lambda$3;
        }
    }
}
