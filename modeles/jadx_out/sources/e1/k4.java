package e1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k4 extends p4 {

    /* renamed from: m, reason: collision with root package name */
    public final AlarmManager f4083m;

    /* renamed from: n, reason: collision with root package name */
    public d4 f4084n;

    /* renamed from: o, reason: collision with root package name */
    public Integer f4085o;

    public k4(u4 u4Var) {
        super(u4Var);
        this.f4083m = (AlarmManager) this.f3875a.f4259a.getSystemService(NotificationCompat.CATEGORY_ALARM);
    }

    @Override // e1.p4
    public final void j() {
        AlarmManager alarmManager = this.f4083m;
        if (alarmManager != null) {
            alarmManager.cancel(o());
        }
        if (Build.VERSION.SDK_INT >= 24) {
            m();
        }
    }

    public final void k() {
        h();
        w0 w0Var = this.f3875a.f4264o;
        t1.m(w0Var);
        w0Var.f4346w.b("Unscheduling upload");
        AlarmManager alarmManager = this.f4083m;
        if (alarmManager != null) {
            alarmManager.cancel(o());
        }
        l().c();
        if (Build.VERSION.SDK_INT >= 24) {
            m();
        }
    }

    public final n l() {
        if (this.f4084n == null) {
            this.f4084n = new d4(this, this.f4092b.f4316u, 1);
        }
        return this.f4084n;
    }

    public final void m() {
        JobScheduler jobScheduler = (JobScheduler) this.f3875a.f4259a.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(n());
        }
    }

    public final int n() {
        if (this.f4085o == null) {
            this.f4085o = Integer.valueOf("measurement".concat(String.valueOf(this.f3875a.f4259a.getPackageName())).hashCode());
        }
        return this.f4085o.intValue();
    }

    public final PendingIntent o() {
        Context context = this.f3875a.f4259a;
        return PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.f0.f2569a);
    }
}
