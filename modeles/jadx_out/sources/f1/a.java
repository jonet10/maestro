package f1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.util.Log;
import g0.m;
import h0.f;
import h0.g;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import k0.y;
import m8.q;
import t0.b;
import t0.e;
import z0.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final f f4813a = f.f5409b;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f4814b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static Method f4815c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f4816d = false;

    public static void a(Context context) {
        Context context2;
        Context context3;
        y.h(context, "Context must not be null");
        f4813a.getClass();
        AtomicBoolean atomicBoolean = g.f5410a;
        f fVar = f.f5409b;
        int b7 = fVar.b(context, 11925000);
        if (b7 != 0) {
            Intent a8 = fVar.a(context, b7, "e");
            StringBuilder sb = new StringBuilder(String.valueOf(b7).length() + 46);
            sb.append("GooglePlayServices not available due to error ");
            sb.append(b7);
            Log.e("GooglePlayServicesUtil", sb.toString());
            if (a8 != null) {
                throw new m("Google Play Services not available");
            }
            throw new m();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (f4814b) {
            Context context4 = null;
            if (!f4816d) {
                try {
                    context3 = e.c(context, e.f9491d, "com.google.android.gms.providerinstaller.dynamite").f9497a;
                } catch (b e10) {
                    Log.w("ProviderInstaller", "Failed to load providerinstaller module: ".concat(String.valueOf(e10.getMessage())));
                    context3 = null;
                }
                if (context3 != null) {
                    b(context3, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
                    return;
                }
            }
            boolean z9 = f4816d;
            try {
                context2 = context.createPackageContext("com.google.android.gms", 3);
            } catch (PackageManager.NameNotFoundException unused) {
                context2 = null;
            }
            if (context2 != null) {
                f4816d = true;
                if (!z9) {
                    try {
                        long uptimeMillis2 = SystemClock.uptimeMillis();
                        ClassLoader classLoader = context2.getClassLoader();
                        int i = 27;
                        q qVar = new q(i, Context.class, context);
                        Class cls = Long.TYPE;
                        a.a.Z(classLoader.loadClass("com.google.android.gms.common.security.ProviderInstallerImpl"), "reportRequestStats2", qVar, new h(i, cls, Long.valueOf(uptimeMillis)), new h(i, cls, Long.valueOf(uptimeMillis2)));
                    } catch (Exception e11) {
                        Log.w("ProviderInstaller", "Failed to report request stats: ".concat(e11.toString()));
                    }
                }
                context4 = context2;
            }
            if (context4 != null) {
                b(context4, "com.google.android.gms.common.security.ProviderInstallerImpl");
            } else {
                Log.e("ProviderInstaller", "Failed to get remote context");
                throw new m();
            }
        }
    }

    public static void b(Context context, String str) {
        try {
            if (f4815c == null) {
                f4815c = context.getClassLoader().loadClass(str).getMethod("insertProvider", Context.class);
            }
            f4815c.invoke(null, context);
        } catch (Exception e10) {
            Throwable cause = e10.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(cause == null ? e10.toString() : cause.toString())));
            }
            throw new m();
        }
    }
}
