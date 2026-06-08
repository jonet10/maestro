package androidx.room;

import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.lifecycle.k;
import androidx.lifecycle.viewmodel.CreationExtrasKt;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.serialization.SavedStateConfigurationKt;
import androidx.savedstate.serialization.SavedStateConfiguration_androidKt;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.work.Data;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.PreferenceUtils;
import b8.j;
import com.uptodown.activities.MainActivity;
import d7.l;
import f3.h;
import f8.b0;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l7.i;
import o7.w;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class f implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f488a;

    public /* synthetic */ f(int i) {
        this.f488a = i;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        x _init_$lambda$0;
        boolean execSQL$lambda$0;
        Set checkInvalidatedTables$lambda$14;
        z7.b DEFAULT_SERIALIZERS_MODULE$lambda$1$lambda$0;
        z7.b defaultSerializersModuleOnPlatform$lambda$1$lambda$0;
        CharSequence string$lambda$7$lambda$6;
        CharSequence areAllConstraintsMet$lambda$5;
        List workSpecIds$lambda$2;
        x deleteAll$lambda$3;
        List allUnfinishedWork$lambda$21;
        int countNonFinishedContentUriTriggerWorkers$lambda$36;
        x pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast$lambda$49;
        boolean hasUnfinishedWorkFlow$lambda$22;
        int resetScheduledState$lambda$48;
        List scheduledWork$lambda$31;
        List allWorkSpecIds$lambda$5;
        List allWorkSpecIdsLiveData$lambda$6;
        List runningWork$lambda$33;
        List eligibleWorkForSchedulingWithContentUris$lambda$27;
        Long lambda$getLastCancelAllTimeMillisLiveData$0;
        x CreationExtras$lambda$0;
        switch (this.f488a) {
            case 0:
                _init_$lambda$0 = RoomRawQuery._init_$lambda$0((SQLiteStatement) obj);
                return _init_$lambda$0;
            case 1:
                execSQL$lambda$0 = TransactorKt.execSQL$lambda$0((SQLiteStatement) obj);
                return Boolean.valueOf(execSQL$lambda$0);
            case 2:
                checkInvalidatedTables$lambda$14 = TriggerBasedInvalidationTracker.checkInvalidatedTables$lambda$14((SQLiteStatement) obj);
                return checkInvalidatedTables$lambda$14;
            case 3:
                DEFAULT_SERIALIZERS_MODULE$lambda$1$lambda$0 = SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE$lambda$1$lambda$0((List) obj);
                return DEFAULT_SERIALIZERS_MODULE$lambda$1$lambda$0;
            case 4:
                defaultSerializersModuleOnPlatform$lambda$1$lambda$0 = SavedStateConfiguration_androidKt.getDefaultSerializersModuleOnPlatform$lambda$1$lambda$0((List) obj);
                return defaultSerializersModuleOnPlatform$lambda$1$lambda$0;
            case 5:
                string$lambda$7$lambda$6 = Data.toString$lambda$7$lambda$6((Map.Entry) obj);
                return string$lambda$7$lambda$6;
            case 6:
                areAllConstraintsMet$lambda$5 = WorkConstraintsTracker.areAllConstraintsMet$lambda$5((ConstraintController) obj);
                return areAllConstraintsMet$lambda$5;
            case 7:
                workSpecIds$lambda$2 = SystemIdInfoDao_Impl.getWorkSpecIds$lambda$2("SELECT DISTINCT work_spec_id FROM SystemIdInfo", (SQLiteConnection) obj);
                return workSpecIds$lambda$2;
            case 8:
                deleteAll$lambda$3 = WorkProgressDao_Impl.deleteAll$lambda$3("DELETE FROM WorkProgress", (SQLiteConnection) obj);
                return deleteAll$lambda$3;
            case 9:
                allUnfinishedWork$lambda$21 = WorkSpecDao_Impl.getAllUnfinishedWork$lambda$21("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", (SQLiteConnection) obj);
                return allUnfinishedWork$lambda$21;
            case 10:
                countNonFinishedContentUriTriggerWorkers$lambda$36 = WorkSpecDao_Impl.countNonFinishedContentUriTriggerWorkers$lambda$36("Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)", (SQLiteConnection) obj);
                return Integer.valueOf(countNonFinishedContentUriTriggerWorkers$lambda$36);
            case 11:
                pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast$lambda$49 = WorkSpecDao_Impl.pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast$lambda$49("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))", (SQLiteConnection) obj);
                return pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast$lambda$49;
            case 12:
                hasUnfinishedWorkFlow$lambda$22 = WorkSpecDao_Impl.hasUnfinishedWorkFlow$lambda$22("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", (SQLiteConnection) obj);
                return Boolean.valueOf(hasUnfinishedWorkFlow$lambda$22);
            case 13:
                resetScheduledState$lambda$48 = WorkSpecDao_Impl.resetScheduledState$lambda$48("UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)", (SQLiteConnection) obj);
                return Integer.valueOf(resetScheduledState$lambda$48);
            case 14:
                scheduledWork$lambda$31 = WorkSpecDao_Impl.getScheduledWork$lambda$31("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", (SQLiteConnection) obj);
                return scheduledWork$lambda$31;
            case 15:
                allWorkSpecIds$lambda$5 = WorkSpecDao_Impl.getAllWorkSpecIds$lambda$5("SELECT id FROM workspec", (SQLiteConnection) obj);
                return allWorkSpecIds$lambda$5;
            case 16:
                allWorkSpecIdsLiveData$lambda$6 = WorkSpecDao_Impl.getAllWorkSpecIdsLiveData$lambda$6("SELECT id FROM workspec", (SQLiteConnection) obj);
                return allWorkSpecIdsLiveData$lambda$6;
            case 17:
                runningWork$lambda$33 = WorkSpecDao_Impl.getRunningWork$lambda$33("SELECT * FROM workspec WHERE state=1", (SQLiteConnection) obj);
                return runningWork$lambda$33;
            case 18:
                eligibleWorkForSchedulingWithContentUris$lambda$27 = WorkSpecDao_Impl.getEligibleWorkForSchedulingWithContentUris$lambda$27("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time", (SQLiteConnection) obj);
                return eligibleWorkForSchedulingWithContentUris$lambda$27;
            case 19:
                lambda$getLastCancelAllTimeMillisLiveData$0 = PreferenceUtils.lambda$getLastCancelAllTimeMillisLiveData$0((Long) obj);
                return lambda$getLastCancelAllTimeMillisLiveData$0;
            case 20:
                CorruptionException corruptionException = (CorruptionException) obj;
                corruptionException.getClass();
                Log.w("FirebaseSessions", "CorruptionException in session configs DataStore", corruptionException);
                return h.f4852b;
            case 21:
                return (CharSequence) ((l7.h) ((i) obj).a()).get(1);
            case 22:
                i iVar = (i) obj;
                int i = MainActivity.G0;
                iVar.getClass();
                return (CharSequence) ((l7.h) iVar.a()).get(1);
            case 23:
                i iVar2 = (i) obj;
                int i6 = MainActivity.G0;
                iVar2.getClass();
                return (CharSequence) ((l7.h) iVar2.a()).get(1);
            case 24:
                b8.a aVar = (b8.a) obj;
                aVar.getClass();
                b8.a.a(aVar, "JsonPrimitive", new j(new k(13)));
                b8.a.a(aVar, "JsonNull", new j(new k(14)));
                b8.a.a(aVar, "JsonLiteral", new j(new k(15)));
                b8.a.a(aVar, "JsonObject", new j(new k(16)));
                b8.a.a(aVar, "JsonArray", new j(new k(17)));
                return x.f8463a;
            case 25:
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                String str = (String) entry.getKey();
                e8.k kVar = (e8.k) entry.getValue();
                StringBuilder sb = new StringBuilder();
                b0.a(str, sb);
                sb.append(':');
                sb.append(kVar);
                return sb.toString();
            case 26:
                CreationExtras$lambda$0 = CreationExtrasKt.CreationExtras$lambda$0((MutableCreationExtras) obj);
                return CreationExtras$lambda$0;
            case 27:
                Byte b7 = (Byte) obj;
                b7.byteValue();
                return String.format("%02x", Arrays.copyOf(new Object[]{b7}, 1));
            case 28:
                return Boolean.valueOf(obj == null);
            default:
                t6.f fVar = (t6.f) obj;
                if (fVar instanceof w) {
                    return (w) fVar;
                }
                return null;
        }
    }
}
