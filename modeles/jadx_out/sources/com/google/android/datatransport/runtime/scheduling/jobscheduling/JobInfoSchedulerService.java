package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.browser.trusted.c;
import com.google.gson.internal.a;
import o.d;
import r.j;
import r.r;
import x.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class JobInfoSchedulerService extends JobService {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2426a = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        int i6 = jobParameters.getExtras().getInt("attemptNumber");
        r.b(getApplicationContext());
        if (string == null) {
            a.i("Null backendName");
            return false;
        }
        d b7 = b0.a.b(i);
        byte[] decode = string2 != null ? Base64.decode(string2, 0) : null;
        g gVar = r.a().f8852d;
        gVar.f11032e.execute(new x.d(gVar, new j(string, decode, b7), i6, new c(28, this, jobParameters)));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
