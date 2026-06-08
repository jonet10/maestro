package com.google.firebase.messaging;

import a3.e;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.work.impl.c;
import g0.b;
import g5.g;
import j1.i;
import j1.p;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import q0.a;
import y2.a0;
import y2.b0;
import y2.r;
import y2.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class FirebaseMessagingService extends Service {

    /* renamed from: p, reason: collision with root package name */
    public static final ArrayDeque f3090p = new ArrayDeque(10);

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f3091a;

    /* renamed from: b, reason: collision with root package name */
    public b0 f3092b;

    /* renamed from: l, reason: collision with root package name */
    public final Object f3093l;

    /* renamed from: m, reason: collision with root package name */
    public int f3094m;

    /* renamed from: n, reason: collision with root package name */
    public int f3095n;

    /* renamed from: o, reason: collision with root package name */
    public b f3096o;

    public FirebaseMessagingService() {
        a aVar = new a("Firebase-Messaging-Intent-Handle");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), aVar);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f3091a = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.f3093l = new Object();
        this.f3095n = 0;
    }

    public final void a(Intent intent) {
        if (intent != null) {
            a0.c(intent);
        }
        synchronized (this.f3093l) {
            try {
                int i = this.f3095n - 1;
                this.f3095n = i;
                if (i == 0) {
                    stopSelfResult(this.f3094m);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.content.Intent r11) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.b(android.content.Intent):void");
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "Service received bind request");
            }
            if (this.f3092b == null) {
                this.f3092b = new b0(new g(this, 19));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f3092b;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f3091a.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i6) {
        synchronized (this.f3093l) {
            this.f3094m = i6;
            this.f3095n++;
        }
        Intent intent2 = (Intent) ((ArrayDeque) s.t().f11758n).poll();
        if (intent2 == null) {
            a(intent);
            return 2;
        }
        i iVar = new i();
        this.f3091a.execute(new c(this, intent2, iVar, 4));
        p pVar = iVar.f6539a;
        if (pVar.h()) {
            a(intent);
            return 2;
        }
        pVar.a(new androidx.arch.core.executor.a(2), new e(9, this, intent));
        return 3;
    }

    public void c(r rVar) {
    }

    public void d(String str) {
    }
}
