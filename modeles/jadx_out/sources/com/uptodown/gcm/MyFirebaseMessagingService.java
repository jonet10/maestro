package com.uptodown.gcm;

import a.a;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.messaging.FirebaseMessagingService;
import java.util.Map;
import o7.c0;
import o7.m0;
import t7.c;
import u4.d0;
import v7.d;
import v7.e;
import y2.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class MyFirebaseMessagingService extends FirebaseMessagingService {

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f3405r = 0;

    /* renamed from: q, reason: collision with root package name */
    public final c f3406q = c0.b(a.L(c0.d(), m0.f8288a));

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void c(r rVar) {
        Map c9 = rVar.c();
        c9.getClass();
        if (c9.isEmpty()) {
            return;
        }
        e eVar = m0.f8288a;
        c0.s(this.f3406q, d.f10884a, null, new d0(rVar, this, null, 4), 2);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void d(String str) {
        str.getClass();
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("SettingsPreferences", 0);
        sharedPreferences.getClass();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("fcmToken", str);
        edit.apply();
        Context applicationContext2 = getApplicationContext();
        applicationContext2.getClass();
        SharedPreferences sharedPreferences2 = applicationContext2.getSharedPreferences("SettingsPreferences", 0);
        sharedPreferences2.getClass();
        SharedPreferences.Editor edit2 = sharedPreferences2.edit();
        edit2.putBoolean("fcmTokenSent", false);
        edit2.apply();
        e eVar = m0.f8288a;
        c0.s(this.f3406q, d.f10884a, null, new d0(this, str, null, 5), 2);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        c0.h(this.f3406q);
    }
}
