package z1;

import android.util.Log;
import b2.t1;
import java.util.concurrent.ExecutorService;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e {

    /* renamed from: d, reason: collision with root package name */
    public static final d f11907d = new d();

    /* renamed from: a, reason: collision with root package name */
    public final b f11908a;

    /* renamed from: b, reason: collision with root package name */
    public final b f11909b;

    /* renamed from: c, reason: collision with root package name */
    public final b f11910c;

    public e(ExecutorService executorService, ExecutorService executorService2) {
        executorService.getClass();
        executorService2.getClass();
        this.f11908a = new b(executorService);
        this.f11909b = new b(executorService);
        t1.x(null);
        this.f11910c = new b(executorService2);
    }

    public static final void a() {
        if (((Boolean) new c(0, f11907d, d.class, "isBackgroundThread", "isBackgroundThread()Z", 0, 0).invoke()).booleanValue()) {
            return;
        }
        String str = "Must be called on a background thread, was called on " + Thread.currentThread().getName() + '.';
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }

    public static final void b() {
        if (((Boolean) new c(0, f11907d, d.class, "isBlockingThread", "isBlockingThread()Z", 0, 1).invoke()).booleanValue()) {
            return;
        }
        String str = "Must be called on a blocking thread, was called on " + Thread.currentThread().getName() + '.';
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }
}
