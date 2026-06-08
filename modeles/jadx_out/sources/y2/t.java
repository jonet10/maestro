package y2;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final long f11759a;

    /* renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f11760b;

    /* renamed from: l, reason: collision with root package name */
    public final FirebaseMessaging f11761l;

    /* renamed from: m, reason: collision with root package name */
    public final ThreadPoolExecutor f11762m = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new q0.a("firebase-iid-executor"));

    public t(FirebaseMessaging firebaseMessaging, long j) {
        this.f11761l = firebaseMessaging;
        this.f11759a = j;
        PowerManager.WakeLock newWakeLock = ((PowerManager) firebaseMessaging.f3086b.getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f11760b = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    public final boolean a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f11761l.f3086b.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final boolean b() {
        try {
            if (this.f11761l.a() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            if (!Log.isLoggable("FirebaseMessaging", 3)) {
                return true;
            }
            Log.d("FirebaseMessaging", "Token successfully retrieved");
            return true;
        } catch (IOException e10) {
            String message = e10.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                if (e10.getMessage() != null) {
                    throw e10;
                }
                Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            Log.w("FirebaseMessaging", "Token retrieval failed: " + e10.getMessage() + ". Will retry token retrieval");
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        PowerManager.WakeLock wakeLock = this.f11760b;
        s t9 = s.t();
        FirebaseMessaging firebaseMessaging = this.f11761l;
        if (t9.v(firebaseMessaging.f3086b)) {
            wakeLock.acquire();
        }
        try {
            try {
                synchronized (firebaseMessaging) {
                    firebaseMessaging.i = true;
                }
                if (!firebaseMessaging.h.f()) {
                    firebaseMessaging.f(false);
                    if (s.t().v(firebaseMessaging.f3086b)) {
                        wakeLock.release();
                        return;
                    }
                    return;
                }
                if (!s.t().u(firebaseMessaging.f3086b) || a()) {
                    if (b()) {
                        firebaseMessaging.f(false);
                    } else {
                        firebaseMessaging.h(this.f11759a);
                    }
                    if (s.t().v(firebaseMessaging.f3086b)) {
                        wakeLock.release();
                        return;
                    }
                    return;
                }
                j0.p pVar = new j0.p();
                pVar.f6522c = this;
                pVar.a();
                if (s.t().v(firebaseMessaging.f3086b)) {
                    wakeLock.release();
                }
            } catch (IOException e10) {
                Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + e10.getMessage() + ". Won't retry the operation.");
                firebaseMessaging.f(false);
                if (s.t().v(firebaseMessaging.f3086b)) {
                    wakeLock.release();
                }
            }
        } catch (Throwable th) {
            if (s.t().v(firebaseMessaging.f3086b)) {
                wakeLock.release();
            }
            throw th;
        }
    }
}
