package e1;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.os.PersistableBundle;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g3 extends h0 {

    /* renamed from: l, reason: collision with root package name */
    public JobScheduler f4001l;

    @Override // e1.h0
    public final boolean j() {
        return true;
    }

    public final void k(long j) {
        h();
        g();
        JobScheduler jobScheduler = this.f4001l;
        t1 t1Var = this.f3875a;
        if (jobScheduler != null && jobScheduler.getPendingJob("measurement-client".concat(String.valueOf(t1Var.f4259a.getPackageName())).hashCode()) != null) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4346w.b("[sgtm] There's an existing pending job, skip this schedule.");
            return;
        }
        int l10 = l();
        if (l10 != 2) {
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4346w.c(androidx.lifecycle.l.F(l10), "[sgtm] Not eligible for Scion upload");
            return;
        }
        w0 w0Var3 = t1Var.f4264o;
        t1.m(w0Var3);
        w0Var3.f4346w.c(Long.valueOf(j), "[sgtm] Scheduling Scion upload, millis");
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.SCION_UPLOAD");
        JobInfo build = new JobInfo.Builder("measurement-client".concat(String.valueOf(t1Var.f4259a.getPackageName())).hashCode(), new ComponentName(t1Var.f4259a, "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(j).setOverrideDeadline(j + j).setExtras(persistableBundle).build();
        JobScheduler jobScheduler2 = this.f4001l;
        k0.y.g(jobScheduler2);
        int schedule = jobScheduler2.schedule(build);
        w0 w0Var4 = t1Var.f4264o;
        t1.m(w0Var4);
        w0Var4.f4346w.c(schedule == 1 ? "SUCCESS" : "FAILURE", "[sgtm] Scion upload job scheduled with result");
    }

    public final int l() {
        h();
        g();
        if (this.f4001l == null) {
            return 7;
        }
        t1 t1Var = this.f3875a;
        Boolean s6 = t1Var.f4262m.s("google_analytics_sgtm_upload_enabled");
        if (!(s6 == null ? false : s6.booleanValue())) {
            return 8;
        }
        if (t1Var.r().f4148s < 119000) {
            return 6;
        }
        if (!a5.A(t1Var.f4259a, "com.google.android.gms.measurement.AppMeasurementJobService")) {
            return 3;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return !t1Var.p().n() ? 5 : 2;
        }
        return 4;
    }
}
