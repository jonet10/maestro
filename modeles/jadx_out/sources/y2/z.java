package y2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public static final Object f11783o = new Object();

    /* renamed from: p, reason: collision with root package name */
    public static Boolean f11784p;

    /* renamed from: q, reason: collision with root package name */
    public static Boolean f11785q;

    /* renamed from: a, reason: collision with root package name */
    public final Context f11786a;

    /* renamed from: b, reason: collision with root package name */
    public final s4.s f11787b;

    /* renamed from: l, reason: collision with root package name */
    public final PowerManager.WakeLock f11788l;

    /* renamed from: m, reason: collision with root package name */
    public final x f11789m;

    /* renamed from: n, reason: collision with root package name */
    public final long f11790n;

    public z(x xVar, Context context, s4.s sVar, long j) {
        this.f11789m = xVar;
        this.f11786a = context;
        this.f11790n = j;
        this.f11787b = sVar;
        this.f11788l = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    public static boolean a(Context context) {
        boolean booleanValue;
        synchronized (f11783o) {
            try {
                Boolean bool = f11785q;
                Boolean valueOf = Boolean.valueOf(bool == null ? b(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
                f11785q = valueOf;
                booleanValue = valueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    public static boolean b(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z9 = context.checkCallingOrSelfPermission(str) == 0;
        if (!z9 && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return z9;
    }

    public static boolean c(Context context) {
        boolean booleanValue;
        synchronized (f11783o) {
            try {
                Boolean bool = f11784p;
                Boolean valueOf = Boolean.valueOf(bool == null ? b(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
                f11784p = valueOf;
                booleanValue = valueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    public final synchronized boolean d() {
        boolean z9;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f11786a.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null) {
                z9 = activeNetworkInfo.isConnected();
            }
        } catch (Throwable th) {
            throw th;
        }
        return z9;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.f11789m;
        Context context = this.f11786a;
        boolean c9 = c(context);
        PowerManager.WakeLock wakeLock = this.f11788l;
        if (c9) {
            wakeLock.acquire(180000L);
        }
        try {
            try {
                try {
                    xVar.f(true);
                    if (!this.f11787b.f()) {
                        xVar.f(false);
                        if (c(context)) {
                            try {
                                wakeLock.release();
                                return;
                            } catch (RuntimeException unused) {
                                Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                                return;
                            }
                        }
                        return;
                    }
                    if (!a(context) || d()) {
                        if (xVar.g()) {
                            xVar.f(false);
                        } else {
                            xVar.h(this.f11790n);
                        }
                        if (c(context)) {
                            wakeLock.release();
                            return;
                        }
                        return;
                    }
                    new y(this, this).a();
                    if (c(context)) {
                        try {
                            wakeLock.release();
                        } catch (RuntimeException unused2) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        }
                    }
                } catch (RuntimeException unused3) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            } catch (IOException e10) {
                Log.e("FirebaseMessaging", "Failed to sync topics. Won't retry sync. " + e10.getMessage());
                xVar.f(false);
                if (c(context)) {
                    wakeLock.release();
                }
            }
        } catch (Throwable th) {
            if (c(context)) {
                try {
                    wakeLock.release();
                } catch (RuntimeException unused4) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
            throw th;
        }
    }
}
