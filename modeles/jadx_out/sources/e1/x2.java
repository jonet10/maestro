package e1;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.nsd.NsdManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import j$.util.Objects;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x2 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4396a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4397b;

    public x2() {
        this.f4396a = 2;
        this.f4397b = new ArrayDeque(10);
    }

    public void a(Intent intent) {
        ArrayDeque arrayDeque = (ArrayDeque) this.f4397b;
        Bundle bundle = null;
        try {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String string = extras.getString("google.message_id");
                if (string == null) {
                    string = extras.getString("message_id");
                }
                if (!TextUtils.isEmpty(string)) {
                    if (arrayDeque.contains(string)) {
                        return;
                    } else {
                        arrayDeque.add(string);
                    }
                }
                bundle = extras.getBundle("gcm.n.analytics_data");
            }
        } catch (RuntimeException e10) {
            Log.w("FirebaseMessaging", "Failed trying to get analytics data from Intent extras.", e10);
        }
        if (bundle == null ? false : "1".equals(bundle.getString("google.c.a.e"))) {
            if (bundle != null) {
                if ("1".equals(bundle.getString("google.c.a.tc"))) {
                    p1.a aVar = (p1.a) n1.f.c().b(p1.a.class);
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                    }
                    if (aVar != null) {
                        String string2 = bundle.getString("google.c.a.c_id");
                        p1.b bVar = (p1.b) aVar;
                        if (!q1.b.f8638c.contains("fcm")) {
                            com.google.android.gms.internal.measurement.k1 k1Var = (com.google.android.gms.internal.measurement.k1) bVar.f8417a.f4811b;
                            k1Var.a(new com.google.android.gms.internal.measurement.x0(k1Var, string2, 0));
                        }
                        Bundle f = k0.k.f("source", "Firebase", "medium", "notification");
                        f.putString("campaign", string2);
                        bVar.a("fcm", "_cmp", f);
                    } else {
                        Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                    }
                } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
                }
            }
            y2.a0.g(bundle, "_no");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047 A[Catch: all -> 0x0026, RuntimeException -> 0x0029, TryCatch #1 {RuntimeException -> 0x0029, blocks: (B:3:0x0005, B:5:0x0017, B:7:0x001d, B:12:0x0047, B:15:0x004e, B:17:0x0061, B:19:0x0069, B:24:0x0079, B:28:0x0086, B:36:0x002c, B:38:0x0033, B:40:0x003f), top: B:2:0x0005, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j(com.google.android.gms.internal.measurement.w0 r9, android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f4397b
            r1 = r0
            e1.b3 r1 = (e1.b3) r1
            e1.t1 r0 = r1.f3875a     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            e1.w0 r2 = r0.f4264o     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            e1.t1.m(r2)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            e1.u0 r2 = r2.f4346w     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            java.lang.String r3 = "onActivityCreated"
            r2.b(r3)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            android.content.Intent r2 = r9.f2884l     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r2 == 0) goto L95
            android.net.Uri r3 = r2.getData()     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r3 == 0) goto L2c
            boolean r4 = r3.isHierarchical()     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r4 != 0) goto L24
            goto L2c
        L24:
            r5 = r3
            goto L45
        L26:
            r0 = move-exception
            goto Lb1
        L29:
            r0 = move-exception
            goto La0
        L2c:
            android.os.Bundle r3 = r2.getExtras()     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            r4 = 0
            if (r3 == 0) goto L44
            java.lang.String r5 = "com.android.vending.referral_url"
            java.lang.String r3 = r3.getString(r5)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r5 != 0) goto L44
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            goto L24
        L44:
            r5 = r4
        L45:
            if (r5 == 0) goto L95
            boolean r3 = r5.isHierarchical()     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r3 != 0) goto L4e
            goto L95
        L4e:
            e1.a5 r3 = r0.f4267r     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            e1.t1.k(r3)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            java.lang.String r3 = "android.intent.extra.REFERRER_NAME"
            java.lang.String r2 = r2.getStringExtra(r3)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            java.lang.String r3 = "android-app://com.google.android.googlequicksearchbox/https/www.google.com"
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r3 != 0) goto L76
            java.lang.String r3 = "https://www.google.com"
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r3 != 0) goto L76
            java.lang.String r3 = "android-app://com.google.appcrawler"
            boolean r2 = r3.equals(r2)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r2 == 0) goto L72
            goto L76
        L72:
            java.lang.String r2 = "auto"
        L74:
            r6 = r2
            goto L79
        L76:
            java.lang.String r2 = "gs"
            goto L74
        L79:
            java.lang.String r2 = "referrer"
            java.lang.String r7 = r5.getQueryParameter(r2)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r10 != 0) goto L84
            r2 = 1
        L82:
            r4 = r2
            goto L86
        L84:
            r2 = 0
            goto L82
        L86:
            e1.q1 r0 = r0.f4265p     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            e1.t1.m(r0)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            e1.r2 r2 = new e1.r2     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            r3 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            r0.p(r2)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            goto Lae
        L95:
            e1.t1 r0 = r1.f3875a
        L97:
            e1.m3 r0 = r0.f4270u
            e1.t1.l(r0)
            r0.o(r9, r10)
            return
        La0:
            e1.t1 r2 = r1.f3875a     // Catch: java.lang.Throwable -> L26
            e1.w0 r2 = r2.f4264o     // Catch: java.lang.Throwable -> L26
            e1.t1.m(r2)     // Catch: java.lang.Throwable -> L26
            e1.u0 r2 = r2.f4339o     // Catch: java.lang.Throwable -> L26
            java.lang.String r3 = "Throwable caught in onActivityCreated"
            r2.c(r0, r3)     // Catch: java.lang.Throwable -> L26
        Lae:
            e1.t1 r0 = r1.f3875a
            goto L97
        Lb1:
            e1.t1 r1 = r1.f3875a
            e1.m3 r1 = r1.f4270u
            e1.t1.l(r1)
            r1.o(r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.x2.j(com.google.android.gms.internal.measurement.w0, android.os.Bundle):void");
    }

    public void k(com.google.android.gms.internal.measurement.w0 w0Var) {
        m3 m3Var = ((b3) this.f4397b).f3875a.f4270u;
        t1.l(m3Var);
        synchronized (m3Var.f4129u) {
            try {
                if (Objects.equals(m3Var.f4124p, w0Var)) {
                    m3Var.f4124p = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (m3Var.f3875a.f4262m.u()) {
            m3Var.f4123o.remove(Integer.valueOf(w0Var.f2882a));
        }
    }

    public void l(com.google.android.gms.internal.measurement.w0 w0Var) {
        t1 t1Var = ((b3) this.f4397b).f3875a;
        m3 m3Var = t1Var.f4270u;
        t1.l(m3Var);
        synchronized (m3Var.f4129u) {
            m3Var.f4128t = false;
            m3Var.f4125q = true;
        }
        t1 t1Var2 = m3Var.f3875a;
        t1Var2.f4269t.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (t1Var2.f4262m.u()) {
            j3 l10 = m3Var.l(w0Var);
            m3Var.f4121m = m3Var.f4120l;
            m3Var.f4120l = null;
            q1 q1Var = t1Var2.f4265p;
            t1.m(q1Var);
            q1Var.p(new a(m3Var, l10, elapsedRealtime));
        } else {
            m3Var.f4120l = null;
            q1 q1Var2 = t1Var2.f4265p;
            t1.m(q1Var2);
            q1Var2.p(new w(m3Var, elapsedRealtime));
        }
        f4 f4Var = t1Var.f4266q;
        t1.l(f4Var);
        t1 t1Var3 = f4Var.f3875a;
        t1Var3.f4269t.getClass();
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        q1 q1Var3 = t1Var3.f4265p;
        t1.m(q1Var3);
        q1Var3.p(new b4(f4Var, elapsedRealtime2, 1));
    }

    public void m(com.google.android.gms.internal.measurement.w0 w0Var) {
        t1 t1Var = ((b3) this.f4397b).f3875a;
        f4 f4Var = t1Var.f4266q;
        t1.l(f4Var);
        t1 t1Var2 = f4Var.f3875a;
        t1Var2.f4269t.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        q1 q1Var = t1Var2.f4265p;
        t1.m(q1Var);
        q1Var.p(new b4(f4Var, elapsedRealtime, 0));
        m3 m3Var = t1Var.f4270u;
        t1.l(m3Var);
        Object obj = m3Var.f4129u;
        synchronized (obj) {
            m3Var.f4128t = true;
            if (!Objects.equals(w0Var, m3Var.f4124p)) {
                synchronized (obj) {
                    m3Var.f4124p = w0Var;
                    m3Var.f4125q = false;
                    t1 t1Var3 = m3Var.f3875a;
                    if (t1Var3.f4262m.u()) {
                        m3Var.f4126r = null;
                        q1 q1Var2 = t1Var3.f4265p;
                        t1.m(q1Var2);
                        q1Var2.p(new l3(m3Var, 1));
                    }
                }
            }
        }
        t1 t1Var4 = m3Var.f3875a;
        if (!t1Var4.f4262m.u()) {
            m3Var.f4120l = m3Var.f4126r;
            q1 q1Var3 = t1Var4.f4265p;
            t1.m(q1Var3);
            q1Var3.p(new l3(m3Var, 0));
            return;
        }
        m3Var.p(w0Var.f2883b, m3Var.l(w0Var), false);
        y yVar = m3Var.f3875a.f4271w;
        t1.j(yVar);
        t1 t1Var5 = yVar.f3875a;
        t1Var5.f4269t.getClass();
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        q1 q1Var4 = t1Var5.f4265p;
        t1.m(q1Var4);
        q1Var4.p(new w(yVar, elapsedRealtime2));
    }

    public void n(com.google.android.gms.internal.measurement.w0 w0Var, Bundle bundle) {
        j3 j3Var;
        m3 m3Var = ((b3) this.f4397b).f3875a.f4270u;
        t1.l(m3Var);
        if (!m3Var.f3875a.f4262m.u() || bundle == null || (j3Var = (j3) m3Var.f4123o.get(Integer.valueOf(w0Var.f2882a))) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", j3Var.f4059c);
        bundle2.putString("name", j3Var.f4057a);
        bundle2.putString("referrer_name", j3Var.f4058b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        switch (this.f4396a) {
            case 0:
                j(com.google.android.gms.internal.measurement.w0.c(activity), bundle);
                break;
            case 1:
                activity.getClass();
                if (activity instanceof g4.s0) {
                    int i = f4.c.f4879s + 1;
                    f4.c.f4879s = i;
                    if (i == 1) {
                        ((f4.c) this.f4397b).a(activity);
                        break;
                    }
                }
                break;
            default:
                Intent intent = activity.getIntent();
                if (intent != null) {
                    if (Build.VERSION.SDK_INT > 25) {
                        a(intent);
                        break;
                    } else {
                        new Handler(Looper.getMainLooper()).post(new y1.n(2, this, intent));
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        NsdManager nsdManager;
        switch (this.f4396a) {
            case 0:
                k(com.google.android.gms.internal.measurement.w0.c(activity));
                break;
            case 1:
                activity.getClass();
                if (activity instanceof g4.s0) {
                    int i = f4.c.f4879s;
                    if (i > 0) {
                        f4.c.f4879s = i - 1;
                    }
                    if (f4.c.f4879s == 0) {
                        f4.c cVar = (f4.c) this.f4397b;
                        try {
                            m4.g gVar = f4.c.f4884y;
                            if (gVar != null && (nsdManager = gVar.f7291b) != null) {
                                nsdManager.unregisterService(cVar.f4890n);
                            }
                        } catch (Exception unused) {
                        }
                        m4.b bVar = f4.c.f4885z;
                        if (bVar != null) {
                            bVar.e();
                        }
                        m4.g gVar2 = f4.c.f4884y;
                        if (gVar2 != null) {
                            gVar2.c();
                        }
                        f4.c.f4884y = null;
                        f4.c.f4885z = null;
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        switch (this.f4396a) {
            case 0:
                l(com.google.android.gms.internal.measurement.w0.c(activity));
                break;
            case 1:
                activity.getClass();
                f4.c.f4875o = null;
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        switch (this.f4396a) {
            case 0:
                m(com.google.android.gms.internal.measurement.w0.c(activity));
                break;
            case 1:
                activity.getClass();
                f4.c.f4875o = activity;
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        switch (this.f4396a) {
            case 0:
                n(com.google.android.gms.internal.measurement.w0.c(activity), bundle);
                break;
            case 1:
                activity.getClass();
                bundle.getClass();
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        switch (this.f4396a) {
            case 1:
                activity.getClass();
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        switch (this.f4396a) {
            case 1:
                activity.getClass();
                break;
        }
    }

    public /* synthetic */ x2(Object obj, int i) {
        this.f4396a = i;
        this.f4397b = obj;
    }

    private final void b(Activity activity) {
    }

    private final void c(Activity activity) {
    }

    private final void d(Activity activity) {
    }

    private final void f(Activity activity) {
    }

    private final void g(Activity activity) {
    }

    private final void h(Activity activity) {
    }

    private final void i(Activity activity) {
    }

    private final void e(Activity activity, Bundle bundle) {
    }
}
