package com.uptodown.receivers;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import b4.d;
import com.uptodown.UptodownApp;
import f4.c;
import j5.o;
import l7.u;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class BootDeviceReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (intent.getAction() == null || !u.m0(intent.getAction(), "android.intent.action.BOOT_COMPLETED", true) || context == null) {
                    return;
                }
                float f = UptodownApp.I;
                d.B(context);
                Activity activity = c.f4875o;
                o.l(f.e(context));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }
}
