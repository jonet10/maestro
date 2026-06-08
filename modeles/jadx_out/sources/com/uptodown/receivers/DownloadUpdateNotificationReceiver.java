package com.uptodown.receivers;

import a5.c;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import b4.d;
import com.uptodown.UptodownApp;
import java.util.Iterator;
import x4.q2;
import x4.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class DownloadUpdateNotificationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int intExtra;
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode == -1881097171) {
                if (action.equals("RESUME")) {
                    c.f();
                    return;
                }
                return;
            }
            if (hashCode == 75902422) {
                if (action.equals("PAUSE")) {
                    c.e();
                    return;
                }
                return;
            }
            if (hashCode == 1980572282 && action.equals("CANCEL") && (intExtra = intent.getIntExtra("notificationID", -1)) == 262 && context != null) {
                float f = UptodownApp.I;
                synchronized (UptodownApp.f3294h0) {
                    UptodownApp.f3295i0 = null;
                }
                Iterator it = d.h().iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    q2 q2Var = (q2) next;
                    float f10 = UptodownApp.I;
                    d.v(q2Var);
                    r a8 = q2Var.a(context);
                    if (a8 != null) {
                        a8.d();
                    }
                }
                Object systemService = context.getSystemService("notification");
                systemService.getClass();
                ((NotificationManager) systemService).cancel(intExtra);
            }
        }
    }
}
