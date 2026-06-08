package com.uptodown.receivers;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.workers.MyAppUpdatedWorker;
import f4.c;
import kotlin.jvm.internal.l;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class MyAppUpdatedReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        context.getClass();
        intent.getClass();
        Activity activity = c.f4875o;
        Context e10 = f.e(context);
        if (l.a(intent.getAction(), "android.intent.action.MY_PACKAGE_REPLACED")) {
            z3.R(context, "device_status", null);
            z3.R(e10, "last_notification_timestamp", "0");
            z3.M(e10, "settings_utd_sended", false);
            z3.M(e10, "is_status_code_526", false);
            z3.R(e10, "url_526", null);
            Object systemService = e10.getSystemService("notification");
            systemService.getClass();
            ((NotificationManager) systemService).cancel(259);
            WorkManager.Companion.getInstance(e10).enqueue(new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) MyAppUpdatedWorker.class).addTag("MyAppUpdatedWorker").build());
        }
    }
}
