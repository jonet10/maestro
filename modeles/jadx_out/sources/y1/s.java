package y1;

import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final g5.g f11674a;

    /* renamed from: b, reason: collision with root package name */
    public final g2.e f11675b;

    /* renamed from: c, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f11676c;

    /* renamed from: d, reason: collision with root package name */
    public final v1.b f11677d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f11678e = new AtomicBoolean(false);

    public s(g5.g gVar, g2.e eVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, v1.b bVar) {
        this.f11674a = gVar;
        this.f11675b = eVar;
        this.f11676c = uncaughtExceptionHandler;
        this.f11677d = bVar;
    }

    public final boolean a(Thread thread, Throwable th) {
        if (thread == null) {
            Log.e("FirebaseCrashlytics", "Crashlytics will not record uncaught exception; null thread", null);
            return false;
        }
        if (th == null) {
            Log.e("FirebaseCrashlytics", "Crashlytics will not record uncaught exception; null throwable", null);
            return false;
        }
        if (!this.f11677d.b()) {
            return true;
        }
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Crashlytics will not record uncaught exception; native crash exists for session.", null);
        }
        return false;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f11676c;
        AtomicBoolean atomicBoolean = this.f11678e;
        atomicBoolean.set(true);
        try {
            try {
                if (a(thread, th)) {
                    this.f11674a.y(this.f11675b, thread, th);
                } else if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "Uncaught exception will not be recorded by Crashlytics.", null);
                }
                if (uncaughtExceptionHandler != null) {
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", "Completed exception processing. Invoking default exception handler.", null);
                    }
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                } else {
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", "Completed exception processing, but no default exception handler.", null);
                    }
                    System.exit(1);
                }
                atomicBoolean.set(false);
            } catch (Exception e10) {
                v1.c cVar = v1.c.f10791a;
                if (cVar.a(6)) {
                    Log.e("FirebaseCrashlytics", "An error occurred in the uncaught exception handler", e10);
                }
                if (uncaughtExceptionHandler != null) {
                    cVar.b("Completed exception processing. Invoking default exception handler.");
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                } else {
                    cVar.b("Completed exception processing, but no default exception handler.");
                    System.exit(1);
                }
                atomicBoolean.set(false);
            }
        } catch (Throwable th2) {
            if (uncaughtExceptionHandler != null) {
                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "Completed exception processing. Invoking default exception handler.", null);
                }
                uncaughtExceptionHandler.uncaughtException(thread, th);
            } else {
                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", "Completed exception processing, but no default exception handler.", null);
                }
                System.exit(1);
            }
            atomicBoolean.set(false);
            throw th2;
        }
    }
}
