package com.google.android.gms.measurement;

import a3.d;
import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import e1.t1;
import e1.u0;
import e1.w0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public d f2948a;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f2948a == null) {
            this.f2948a = new d(this, 23);
        }
        d dVar = this.f2948a;
        dVar.getClass();
        w0 w0Var = t1.s(context, null, null).f4264o;
        t1.m(w0Var);
        u0 u0Var = w0Var.f4346w;
        u0 u0Var2 = w0Var.f4342r;
        if (intent == null) {
            u0Var2.b("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        u0Var.c(action, "Local receiver got");
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                u0Var2.b("Install Referrer Broadcasts are deprecated");
            }
        } else {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            u0Var.b("Starting wakeful intent.");
            ((AppMeasurementReceiver) dVar.f63b).getClass();
            WakefulBroadcastReceiver.startWakefulService(context, className);
        }
    }
}
