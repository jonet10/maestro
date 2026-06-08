package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import d7.l;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class h implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f621a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f622b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f623l;

    public /* synthetic */ h(String str, int i, long j) {
        this.f621a = i;
        this.f622b = j;
        this.f623l = str;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        x nextScheduleTimeOverride$lambda$45;
        int markWorkSpecScheduled$lambda$47;
        x lastEnqueueTime$lambda$42;
        switch (this.f621a) {
            case 0:
                nextScheduleTimeOverride$lambda$45 = WorkSpecDao_Impl.setNextScheduleTimeOverride$lambda$45("UPDATE workspec SET next_schedule_time_override=? WHERE id=?", this.f622b, this.f623l, (SQLiteConnection) obj);
                return nextScheduleTimeOverride$lambda$45;
            case 1:
                markWorkSpecScheduled$lambda$47 = WorkSpecDao_Impl.markWorkSpecScheduled$lambda$47("UPDATE workspec SET schedule_requested_at=? WHERE id=?", this.f622b, this.f623l, (SQLiteConnection) obj);
                return Integer.valueOf(markWorkSpecScheduled$lambda$47);
            default:
                lastEnqueueTime$lambda$42 = WorkSpecDao_Impl.setLastEnqueueTime$lambda$42("UPDATE workspec SET last_enqueue_time=? WHERE id=?", this.f622b, this.f623l, (SQLiteConnection) obj);
                return lastEnqueueTime$lambda$42;
        }
    }
}
