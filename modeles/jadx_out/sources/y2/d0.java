package y2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11719a;

    /* renamed from: b, reason: collision with root package name */
    public final Intent f11720b;

    /* renamed from: l, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f11721l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayDeque f11722m;

    /* renamed from: n, reason: collision with root package name */
    public b0 f11723n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f11724o;

    public d0(Context context) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new q0.a("Firebase-FirebaseInstanceIdServiceConnection"));
        scheduledThreadPoolExecutor.setKeepAliveTime(40L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f11722m = new ArrayDeque();
        this.f11724o = false;
        Context applicationContext = context.getApplicationContext();
        this.f11719a = applicationContext;
        this.f11720b = new Intent("com.google.firebase.MESSAGING_EVENT").setPackage(applicationContext.getPackageName());
        this.f11721l = scheduledThreadPoolExecutor;
    }

    public final synchronized void a() {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "flush queue called");
            }
            while (!this.f11722m.isEmpty()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "found intent to be delivered");
                }
                b0 b0Var = this.f11723n;
                if (b0Var == null || !b0Var.isBinderAlive()) {
                    c();
                    return;
                }
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
                }
                this.f11723n.a((c0) this.f11722m.poll());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized j1.p b(Intent intent) {
        c0 c0Var;
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
            }
            c0Var = new c0(intent);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f11721l;
            c0Var.f11716b.f6539a.a(scheduledThreadPoolExecutor, new v4.a(scheduledThreadPoolExecutor.schedule(new a2.s(c0Var, 19), 20L, TimeUnit.SECONDS), 8));
            this.f11722m.add(c0Var);
            a();
        } catch (Throwable th) {
            throw th;
        }
        return c0Var.f11716b.f6539a;
    }

    public final void c() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder("binder is dead. start connection? ");
            sb.append(!this.f11724o);
            Log.d("FirebaseMessaging", sb.toString());
        }
        if (this.f11724o) {
            return;
        }
        this.f11724o = true;
        try {
        } catch (SecurityException e10) {
            Log.e("FirebaseMessaging", "Exception while binding the service", e10);
        }
        if (o0.a.b().a(this.f11719a, this.f11720b, this, 65)) {
            return;
        }
        Log.e("FirebaseMessaging", "binding to the service failed");
        this.f11724o = false;
        while (true) {
            ArrayDeque arrayDeque = this.f11722m;
            if (arrayDeque.isEmpty()) {
                return;
            } else {
                ((c0) arrayDeque.poll()).f11716b.c(null);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "onServiceConnected: " + componentName);
            }
            this.f11724o = false;
            if (iBinder instanceof b0) {
                this.f11723n = (b0) iBinder;
                a();
                return;
            }
            Log.e("FirebaseMessaging", "Invalid service connection: " + iBinder);
            ArrayDeque arrayDeque = this.f11722m;
            while (!arrayDeque.isEmpty()) {
                ((c0) arrayDeque.poll()).f11716b.c(null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceDisconnected: " + componentName);
        }
        a();
    }
}
