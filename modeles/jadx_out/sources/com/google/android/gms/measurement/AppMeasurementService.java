package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import e1.c2;
import e1.t1;
import e1.u4;
import e1.w0;
import e1.z3;
import f0.i;
import m1.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class AppMeasurementService extends Service implements z3 {

    /* renamed from: a, reason: collision with root package name */
    public i f2949a;

    @Override // e1.z3
    public final boolean a(int i) {
        return stopSelfResult(i);
    }

    @Override // e1.z3
    public final void b(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    @Override // e1.z3
    public final void c(JobParameters jobParameters) {
        throw new UnsupportedOperationException();
    }

    public final i d() {
        if (this.f2949a == null) {
            this.f2949a = new i(this, 22);
        }
        return this.f2949a;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        i d10 = d();
        d10.getClass();
        if (intent == null) {
            Log.e("FA", "onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new c2(u4.C((Service) d10.f4811b));
        }
        Log.w("FA", "onBind received unknown action: ".concat(String.valueOf(action)));
        return null;
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

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i, final int i6) {
        final i d10 = d();
        if (intent == null) {
            d10.getClass();
            Log.w("FA", "AppMeasurementService started with null intent");
            return 2;
        }
        Service service = (Service) d10.f4811b;
        final w0 w0Var = t1.s(service, null, null).f4264o;
        t1.m(w0Var);
        String action = intent.getAction();
        w0Var.f4346w.d(Integer.valueOf(i6), "Local AppMeasurementService called. startId, action", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            return 2;
        }
        Runnable runnable = new Runnable() { // from class: e1.a4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                Service service2 = (Service) f0.i.this.f4811b;
                z3 z3Var = (z3) service2;
                int i10 = i6;
                if (z3Var.a(i10)) {
                    w0Var.f4346w.c(Integer.valueOf(i10), "Local AppMeasurementService processed last upload request. StartId");
                    w0 w0Var2 = t1.s(service2, null, null).f4264o;
                    t1.m(w0Var2);
                    w0Var2.f4346w.b("Completed wakeful intent.");
                    z3Var.b(intent);
                }
            }
        };
        u4 C = u4.C(service);
        C.b().p(new a(d10, C, runnable));
        return 2;
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
}
