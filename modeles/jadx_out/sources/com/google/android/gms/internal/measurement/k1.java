package com.google.android.gms.internal.measurement;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k1 {
    public static volatile k1 g;

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f2679a;

    /* renamed from: b, reason: collision with root package name */
    public final f0.i f2680b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2681c;

    /* renamed from: d, reason: collision with root package name */
    public int f2682d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2683e;
    public volatile k0 f;

    public k1(Context context, Bundle bundle) {
        f1 f1Var = new f1(this);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f1Var);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f2679a = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.f2680b = new f0.i(this, 19);
        this.f2681c = new ArrayList();
        int i = 0;
        try {
            if (e1.k2.b(context, e1.k2.a(context)) != null) {
                try {
                    Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, k1.class.getClassLoader());
                } catch (ClassNotFoundException unused) {
                    this.f2683e = true;
                    Log.w("FA", "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Add Google Analytics for Firebase to resume data collection.");
                    return;
                }
            }
        } catch (IllegalStateException unused2) {
        }
        a(new z0(this, context, bundle, i));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w("FA", "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new j1(this));
        }
    }

    public static k1 c(Context context, Bundle bundle) {
        k0.y.g(context);
        if (g == null) {
            synchronized (k1.class) {
                try {
                    if (g == null) {
                        g = new k1(context, bundle);
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public final void a(g1 g1Var) {
        this.f2679a.execute(g1Var);
    }

    public final void b(Exception exc, boolean z9, boolean z10) {
        this.f2683e |= z9;
        if (z9) {
            Log.w("FA", "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z10) {
            a(new x0(this, exc));
        }
        Log.w("FA", "Error with data collection. Data lost.", exc);
    }
}
