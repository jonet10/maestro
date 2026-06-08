package com.google.firebase.messaging;

import a2.t;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import b2.t1;
import com.google.firebase.messaging.FirebaseMessaging;
import e1.x2;
import g0.h;
import g0.n;
import g4.v;
import g5.g;
import j1.p;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k0.y;
import n1.f;
import p2.c;
import q0.a;
import s1.e;
import s2.b;
import s4.s;
import t2.d;
import x4.h2;
import y2.a0;
import y2.j;
import y2.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class FirebaseMessaging {
    public static g j;

    /* renamed from: k, reason: collision with root package name */
    public static b f3083k = new e(1);

    /* renamed from: l, reason: collision with root package name */
    public static ScheduledThreadPoolExecutor f3084l;

    /* renamed from: a, reason: collision with root package name */
    public final f f3085a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f3086b;

    /* renamed from: c, reason: collision with root package name */
    public final v f3087c;

    /* renamed from: d, reason: collision with root package name */
    public final j f3088d;

    /* renamed from: e, reason: collision with root package name */
    public final t f3089e;
    public final ScheduledThreadPoolExecutor f;
    public final ThreadPoolExecutor g;
    public final s h;
    public boolean i;

    public FirebaseMessaging(f fVar, b bVar, b bVar2, d dVar, b bVar3, c cVar) {
        fVar.a();
        Context context = fVar.f7908a;
        final s sVar = new s(context);
        final v vVar = new v(fVar, sVar, bVar, bVar2, dVar);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new a("Firebase-Messaging-Task"));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new a("Firebase-Messaging-Init"));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("Firebase-Messaging-File-Io"));
        this.i = false;
        f3083k = bVar3;
        this.f3085a = fVar;
        this.f3089e = new t(this, cVar);
        fVar.a();
        final Context context2 = fVar.f7908a;
        this.f3086b = context2;
        x2 x2Var = new x2();
        this.h = sVar;
        this.f3087c = vVar;
        this.f3088d = new j(newSingleThreadExecutor);
        this.f = scheduledThreadPoolExecutor;
        this.g = threadPoolExecutor;
        fVar.a();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(x2Var);
        } else {
            Log.w("FirebaseMessaging", "Context " + context + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        final int i = 0;
        scheduledThreadPoolExecutor.execute(new Runnable(this) { // from class: y2.k

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FirebaseMessaging f11741b;

            {
                this.f11741b = this;
            }

            private final void a() {
                FirebaseMessaging firebaseMessaging = this.f11741b;
                if (firebaseMessaging.f3089e.i() && firebaseMessaging.i(firebaseMessaging.d())) {
                    synchronized (firebaseMessaging) {
                        if (!firebaseMessaging.i) {
                            firebaseMessaging.h(0L);
                        }
                    }
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                j1.p w2;
                int i6;
                switch (i) {
                    case 0:
                        a();
                        return;
                    default:
                        FirebaseMessaging firebaseMessaging = this.f11741b;
                        final Context context3 = firebaseMessaging.f3086b;
                        p.a(context3);
                        g4.v vVar2 = firebaseMessaging.f3087c;
                        final boolean g = firebaseMessaging.g();
                        if (Build.VERSION.SDK_INT >= 29) {
                            SharedPreferences e10 = a0.e(context3);
                            if (!e10.contains("proxy_retention") || e10.getBoolean("proxy_retention", false) != g) {
                                g0.b bVar4 = (g0.b) vVar2.f5277m;
                                if (bVar4.f5070c.a() >= 241100000) {
                                    Bundle bundle = new Bundle();
                                    bundle.putBoolean("proxy_retention", g);
                                    g0.n a8 = g0.n.a(bVar4.f5069b);
                                    synchronized (a8) {
                                        i6 = a8.f5101d;
                                        a8.f5101d = i6 + 1;
                                    }
                                    w2 = a8.b(new g0.l(i6, 4, bundle, 0));
                                } else {
                                    w2 = t1.w(new IOException("SERVICE_NOT_AVAILABLE"));
                                }
                                w2.c(new androidx.arch.core.executor.a(2), new j1.f() { // from class: y2.q
                                    @Override // j1.f
                                    public final void c(Object obj) {
                                        SharedPreferences.Editor edit = a0.e(context3).edit();
                                        edit.putBoolean("proxy_retention", g);
                                        edit.apply();
                                    }
                                });
                            }
                        }
                        if (firebaseMessaging.g()) {
                            firebaseMessaging.e();
                            return;
                        }
                        return;
                }
            }
        });
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new a("Firebase-Messaging-Topics-Io"));
        t1.q(scheduledThreadPoolExecutor2, new Callable() { // from class: y2.w
            @Override // java.util.concurrent.Callable
            public final Object call() {
                v vVar2;
                Context context3 = context2;
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor3 = scheduledThreadPoolExecutor2;
                FirebaseMessaging firebaseMessaging = this;
                s4.s sVar2 = sVar;
                g4.v vVar3 = vVar;
                synchronized (v.class) {
                    try {
                        WeakReference weakReference = v.f11767d;
                        vVar2 = weakReference != null ? (v) weakReference.get() : null;
                        if (vVar2 == null) {
                            v vVar4 = new v(context3.getSharedPreferences("com.google.android.gms.appid", 0), scheduledThreadPoolExecutor3);
                            vVar4.b();
                            v.f11767d = new WeakReference(vVar4);
                            vVar2 = vVar4;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return new x(firebaseMessaging, sVar2, vVar2, vVar3, context3, scheduledThreadPoolExecutor3);
            }
        }).c(scheduledThreadPoolExecutor, new l(this, 0));
        final int i6 = 1;
        scheduledThreadPoolExecutor.execute(new Runnable(this) { // from class: y2.k

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FirebaseMessaging f11741b;

            {
                this.f11741b = this;
            }

            private final void a() {
                FirebaseMessaging firebaseMessaging = this.f11741b;
                if (firebaseMessaging.f3089e.i() && firebaseMessaging.i(firebaseMessaging.d())) {
                    synchronized (firebaseMessaging) {
                        if (!firebaseMessaging.i) {
                            firebaseMessaging.h(0L);
                        }
                    }
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                j1.p w2;
                int i62;
                switch (i6) {
                    case 0:
                        a();
                        return;
                    default:
                        FirebaseMessaging firebaseMessaging = this.f11741b;
                        final Context context3 = firebaseMessaging.f3086b;
                        p.a(context3);
                        g4.v vVar2 = firebaseMessaging.f3087c;
                        final boolean g = firebaseMessaging.g();
                        if (Build.VERSION.SDK_INT >= 29) {
                            SharedPreferences e10 = a0.e(context3);
                            if (!e10.contains("proxy_retention") || e10.getBoolean("proxy_retention", false) != g) {
                                g0.b bVar4 = (g0.b) vVar2.f5277m;
                                if (bVar4.f5070c.a() >= 241100000) {
                                    Bundle bundle = new Bundle();
                                    bundle.putBoolean("proxy_retention", g);
                                    g0.n a8 = g0.n.a(bVar4.f5069b);
                                    synchronized (a8) {
                                        i62 = a8.f5101d;
                                        a8.f5101d = i62 + 1;
                                    }
                                    w2 = a8.b(new g0.l(i62, 4, bundle, 0));
                                } else {
                                    w2 = t1.w(new IOException("SERVICE_NOT_AVAILABLE"));
                                }
                                w2.c(new androidx.arch.core.executor.a(2), new j1.f() { // from class: y2.q
                                    @Override // j1.f
                                    public final void c(Object obj) {
                                        SharedPreferences.Editor edit = a0.e(context3).edit();
                                        edit.putBoolean("proxy_retention", g);
                                        edit.apply();
                                    }
                                });
                            }
                        }
                        if (firebaseMessaging.g()) {
                            firebaseMessaging.e();
                            return;
                        }
                        return;
                }
            }
        });
    }

    public static void b(Runnable runnable, long j6) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (f3084l == null) {
                    f3084l = new ScheduledThreadPoolExecutor(1, new a("TAG"));
                }
                f3084l.schedule(runnable, j6, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized g c(Context context) {
        g gVar;
        synchronized (FirebaseMessaging.class) {
            try {
                if (j == null) {
                    j = new g(context);
                }
                gVar = j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    @NonNull
    @Keep
    public static synchronized FirebaseMessaging getInstance(@NonNull f fVar) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) fVar.b(FirebaseMessaging.class);
            y.h(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String a() {
        p pVar;
        h2 d10 = d();
        if (!i(d10)) {
            return d10.f11211a;
        }
        String d11 = s.d(this.f3085a);
        j jVar = this.f3088d;
        synchronized (jVar) {
            pVar = (p) ((ArrayMap) jVar.f11739b).get(d11);
            if (pVar == null) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Making new request for: " + d11);
                }
                v vVar = this.f3087c;
                pVar = vVar.d(vVar.k(s.d((f) vVar.f5275b), "*", new Bundle())).j(this.g, new androidx.transition.a(this, d11, d10, 7)).e((Executor) jVar.f11738a, new a3.e(jVar, d11));
                ((ArrayMap) jVar.f11739b).put(d11, pVar);
            } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Joining ongoing request for: " + d11);
            }
        }
        try {
            return (String) t1.j(pVar);
        } catch (InterruptedException | ExecutionException e10) {
            throw new IOException(e10);
        }
    }

    public final h2 d() {
        h2 d10;
        g c9 = c(this.f3086b);
        f fVar = this.f3085a;
        fVar.a();
        String d11 = "[DEFAULT]".equals(fVar.f7909b) ? "" : fVar.d();
        String d12 = s.d(this.f3085a);
        synchronized (c9) {
            d10 = h2.d(((SharedPreferences) c9.f5315b).getString(d11 + "|T|" + d12 + "|*", null));
        }
        return d10;
    }

    public final void e() {
        p w2;
        int i;
        g0.b bVar = (g0.b) this.f3087c.f5277m;
        if (bVar.f5070c.a() >= 241100000) {
            n a8 = n.a(bVar.f5069b);
            Bundle bundle = Bundle.EMPTY;
            synchronized (a8) {
                i = a8.f5101d;
                a8.f5101d = i + 1;
            }
            w2 = a8.b(new g0.l(i, 5, bundle, 1)).d(h.f5081l, g0.d.f5075l);
        } else {
            w2 = t1.w(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        w2.c(this.f, new l(this, 1));
    }

    public final synchronized void f(boolean z9) {
        this.i = z9;
    }

    public final boolean g() {
        Context context = this.f3086b;
        y2.p.a(context);
        if (!y2.p.b(context)) {
            return false;
        }
        if (this.f3085a.b(p1.a.class) != null) {
            return true;
        }
        return a0.d() && f3083k != null;
    }

    public final synchronized void h(long j6) {
        b(new y2.t(this, Math.min(Math.max(30L, 2 * j6), 28800L)), j6);
        this.i = true;
    }

    public final boolean i(h2 h2Var) {
        if (h2Var != null) {
            return System.currentTimeMillis() > h2Var.f11213c + 604800000 || !this.h.b().equals((String) h2Var.f11212b);
        }
        return true;
    }
}
