package com.uptodown.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import j5.d;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class AuthenticatorService extends Service {
    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        intent.getClass();
        IBinder iBinder = new d(this).getIBinder();
        iBinder.getClass();
        return iBinder;
    }
}
