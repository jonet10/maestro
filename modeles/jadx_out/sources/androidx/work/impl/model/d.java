package androidx.work.impl.model;

import androidx.room.AmbiguousColumnResolver;
import androidx.sqlite.SQLiteConnection;
import d7.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class d implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f608a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Serializable f609b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f610l;

    public /* synthetic */ d(int i, String str) {
        this.f608a = 2;
        this.f610l = i;
        this.f609b = str;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        x removeSystemIdInfo$lambda$3;
        SystemIdInfo systemIdInfo$lambda$1;
        x stopReason$lambda$51;
        x resetWorkSpecNextScheduleTimeOverride$lambda$46;
        x resolve$lambda$16$lambda$15;
        switch (this.f608a) {
            case 0:
                removeSystemIdInfo$lambda$3 = SystemIdInfoDao_Impl.removeSystemIdInfo$lambda$3("DELETE FROM SystemIdInfo where work_spec_id=? AND generation=?", (String) this.f609b, this.f610l, (SQLiteConnection) obj);
                return removeSystemIdInfo$lambda$3;
            case 1:
                systemIdInfo$lambda$1 = SystemIdInfoDao_Impl.getSystemIdInfo$lambda$1("SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?", (String) this.f609b, this.f610l, (SQLiteConnection) obj);
                return systemIdInfo$lambda$1;
            case 2:
                stopReason$lambda$51 = WorkSpecDao_Impl.setStopReason$lambda$51("UPDATE workspec SET stop_reason=? WHERE id=?", this.f610l, (String) this.f609b, (SQLiteConnection) obj);
                return stopReason$lambda$51;
            case 3:
                resetWorkSpecNextScheduleTimeOverride$lambda$46 = WorkSpecDao_Impl.resetWorkSpecNextScheduleTimeOverride$lambda$46("UPDATE workspec SET next_schedule_time_override=9223372036854775807 WHERE (id=? AND next_schedule_time_override_generation=?)", (String) this.f609b, this.f610l, (SQLiteConnection) obj);
                return resetWorkSpecNextScheduleTimeOverride$lambda$46;
            default:
                resolve$lambda$16$lambda$15 = AmbiguousColumnResolver.resolve$lambda$16$lambda$15((ArrayList) this.f609b, this.f610l, (List) obj);
                return resolve$lambda$16$lambda$15;
        }
    }

    public /* synthetic */ d(Serializable serializable, int i, int i6) {
        this.f608a = i6;
        this.f609b = serializable;
        this.f610l = i;
    }
}
