package androidx.work.impl.background.systemjob;

import android.app.job.JobScheduler;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(34)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class JobScheduler34 {
    public static final JobScheduler34 INSTANCE = new JobScheduler34();

    private JobScheduler34() {
    }

    public final JobScheduler forNamespace(JobScheduler jobScheduler) {
        jobScheduler.getClass();
        JobScheduler forNamespace = jobScheduler.forNamespace(JobSchedulerExtKt.WORKMANAGER_NAMESPACE);
        forNamespace.getClass();
        return forNamespace;
    }
}
