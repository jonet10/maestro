package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class JobScheduler21 {
    public static final JobScheduler21 INSTANCE = new JobScheduler21();

    private JobScheduler21() {
    }

    public final List<JobInfo> getAllPendingJobs(JobScheduler jobScheduler) {
        jobScheduler.getClass();
        List<JobInfo> allPendingJobs = jobScheduler.getAllPendingJobs();
        allPendingJobs.getClass();
        return allPendingJobs;
    }
}
