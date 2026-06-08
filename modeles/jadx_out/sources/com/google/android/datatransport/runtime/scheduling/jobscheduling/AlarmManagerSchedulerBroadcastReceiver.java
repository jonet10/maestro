package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.google.gson.internal.a;
import g5.h0;
import o.d;
import r.j;
import r.r;
import x.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2425a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        r.b(context);
        if (queryParameter == null) {
            a.i("Null backendName");
            return;
        }
        d b7 = b0.a.b(intValue);
        byte[] decode = queryParameter2 != null ? Base64.decode(queryParameter2, 0) : null;
        g gVar = r.a().f8852d;
        gVar.f11032e.execute(new x.d(gVar, new j(queryParameter, decode, b7), i, new h0(2)));
    }
}
