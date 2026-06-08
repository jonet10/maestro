package com.uptodown.receivers;

import a5.b;
import a5.c;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import j5.g;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.l;
import x4.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class DownloadNotificationReceiver extends BroadcastReceiver {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int intExtra;
        String str;
        int intExtra2;
        r b7;
        String str2;
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            switch (action.hashCode()) {
                case -1919974852:
                    if (action.equals("CANCEL_ALL") && (intExtra = intent.getIntExtra("notificationID", -1)) == 261 && context != null) {
                        r b10 = b.b();
                        ArrayList arrayList = new ArrayList();
                        g l10 = g.D.l(context);
                        l10.b();
                        Iterator it = l10.P().iterator();
                        it.getClass();
                        while (it.hasNext()) {
                            Object next = it.next();
                            next.getClass();
                            r rVar = (r) next;
                            if (rVar.m()) {
                                arrayList.add(rVar);
                            }
                        }
                        l10.c();
                        if (b10 != null && (str = b10.f11355b) != null && str.length() != 0) {
                            String str3 = b10.f11355b;
                            str3.getClass();
                            r b11 = b.b();
                            if (l.a(b11 != null ? b11.f11355b : null, str3)) {
                                b.f();
                            } else {
                                c.d();
                            }
                            b10.s(context);
                        }
                        if (!arrayList.isEmpty()) {
                            int size = arrayList.size();
                            int i = 0;
                            while (i < size) {
                                Object obj = arrayList.get(i);
                                i++;
                                ((r) obj).s(context);
                            }
                        }
                        Object systemService = context.getSystemService("notification");
                        systemService.getClass();
                        ((NotificationManager) systemService).cancel(intExtra);
                        break;
                    }
                    break;
                case -1881097171:
                    if (action.equals("RESUME")) {
                        b.h();
                        break;
                    }
                    break;
                case 75902422:
                    if (action.equals("PAUSE")) {
                        b.g();
                        break;
                    }
                    break;
                case 1980572282:
                    if (action.equals("CANCEL") && (intExtra2 = intent.getIntExtra("notificationID", -1)) == 261 && (b7 = b.b()) != null && (str2 = b7.f11355b) != null && str2.length() != 0) {
                        String str4 = b7.f11355b;
                        str4.getClass();
                        r b12 = b.b();
                        if (l.a(b12 != null ? b12.f11355b : null, str4)) {
                            b.f();
                        } else {
                            c.d();
                        }
                        if (context != null) {
                            b7.s(context);
                            ArrayList arrayList2 = new ArrayList();
                            g l11 = g.D.l(context);
                            l11.b();
                            Iterator it2 = l11.P().iterator();
                            it2.getClass();
                            while (it2.hasNext()) {
                                Object next2 = it2.next();
                                next2.getClass();
                                r rVar2 = (r) next2;
                                if (rVar2.m()) {
                                    arrayList2.add(rVar2);
                                }
                            }
                            l11.c();
                            if (arrayList2.isEmpty()) {
                                Object systemService2 = context.getSystemService("notification");
                                systemService2.getClass();
                                ((NotificationManager) systemService2).cancel(intExtra2);
                                break;
                            }
                        }
                    }
                    break;
            }
        }
    }
}
