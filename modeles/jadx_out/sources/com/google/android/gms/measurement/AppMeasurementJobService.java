package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.internal.measurement.k1;
import com.google.android.gms.internal.measurement.x0;
import e1.u4;
import e1.w0;
import e1.x1;
import e1.z3;
import f0.i;
import j$.util.Objects;
import k0.y;
import m1.a;
import q2.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class AppMeasurementJobService extends JobService implements z3 {

    /* renamed from: a, reason: collision with root package name */
    public i f2947a;

    @Override // e1.z3
    public final boolean a(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // e1.z3
    public final void c(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    public final i d() {
        if (this.f2947a == null) {
            this.f2947a = new i(this, 22);
        }
        return this.f2947a;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Log.v("FA", ((Service) d().f4811b).getClass().getSimpleName().concat(" is starting up."));
    }

    @Override // android.app.Service
    public final void onDestroy() {
        Log.v("FA", ((Service) d().f4811b).getClass().getSimpleName().concat(" is shutting down."));
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        d();
        if (intent == null) {
            Log.e("FA", "onRebind called with null intent");
        } else {
            Log.v("FA", "onRebind called. action: ".concat(String.valueOf(intent.getAction())));
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        JobParameters jobParameters2;
        i d10 = d();
        Service service = (Service) d10.f4811b;
        String string = jobParameters.getExtras().getString("action");
        Log.v("FA", "onStartJob received action: ".concat(String.valueOf(string)));
        if (Objects.equals(string, "com.google.android.gms.measurement.UPLOAD")) {
            y.g(string);
            u4 C = u4.C(service);
            w0 a8 = C.a();
            e eVar = C.f4316u.f4261l;
            a8.f4346w.c(string, "Local AppMeasurementJobService called. action");
            jobParameters2 = jobParameters;
            C.b().p(new a(d10, C, new x1(d10, a8, jobParameters2, 8, false)));
        } else {
            jobParameters2 = jobParameters;
        }
        if (!Objects.equals(string, "com.google.android.gms.measurement.SCION_UPLOAD")) {
            return true;
        }
        y.g(string);
        k1 c9 = k1.c(service, null);
        a aVar = new a(16, d10, jobParameters2);
        c9.getClass();
        c9.a(new x0(c9, aVar, 3));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        d();
        if (intent == null) {
            Log.e("FA", "onUnbind called with null intent");
            return true;
        }
        Log.v("FA", "onUnbind called for intent. action: ".concat(String.valueOf(intent.getAction())));
        return true;
    }

    @Override // e1.z3
    public final void b(Intent intent) {
    }
}
