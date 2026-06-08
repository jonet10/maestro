package t2;

import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.Log;
import androidx.browser.trusted.sharing.ShareTarget;
import b2.t1;
import j1.p;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import k0.y;
import m8.q;
import org.json.JSONException;
import org.json.JSONObject;
import s1.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c implements d {

    /* renamed from: m, reason: collision with root package name */
    public static final Object f9541m = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final n1.f f9542a;

    /* renamed from: b, reason: collision with root package name */
    public final v2.c f9543b;

    /* renamed from: c, reason: collision with root package name */
    public final q f9544c;

    /* renamed from: d, reason: collision with root package name */
    public final j f9545d;

    /* renamed from: e, reason: collision with root package name */
    public final m f9546e;
    public final h f;
    public final Object g;
    public final ExecutorService h;
    public final t1.i i;
    public String j;

    /* renamed from: k, reason: collision with root package name */
    public final HashSet f9547k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f9548l;

    static {
        new AtomicInteger(1);
    }

    public c(n1.f fVar, s2.b bVar, ExecutorService executorService, t1.i iVar) {
        fVar.a();
        v2.c cVar = new v2.c(fVar.f7908a, bVar);
        q qVar = new q(fVar);
        if (q1.a.f8634l == null) {
            q1.a.f8634l = new q1.a(12);
        }
        q1.a aVar = q1.a.f8634l;
        if (j.f9555c == null) {
            j.f9555c = new j(aVar);
        }
        j jVar = j.f9555c;
        m mVar = new m(new s1.c(fVar, 2));
        h hVar = new h();
        this.g = new Object();
        this.f9547k = new HashSet();
        this.f9548l = new ArrayList();
        this.f9542a = fVar;
        this.f9543b = cVar;
        this.f9544c = qVar;
        this.f9545d = jVar;
        this.f9546e = mVar;
        this.f = hVar;
        this.h = executorService;
        this.i = iVar;
    }

    public final void a(i iVar) {
        synchronized (this.g) {
            this.f9548l.add(iVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        r3 = h(r2);
        r4 = r6.f9544c;
        r2 = r2.a();
        r2.f10399a = r3;
        r2.f10400b = 3;
        r2 = r2.a();
        r4.l(r2);
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            r6 = this;
            java.lang.Object r0 = t2.c.f9541m
            monitor-enter(r0)
            n1.f r1 = r6.f9542a     // Catch: java.lang.Throwable -> L3f
            r1.a()     // Catch: java.lang.Throwable -> L3f
            android.content.Context r1 = r1.f7908a     // Catch: java.lang.Throwable -> L3f
            m8.q r1 = m8.q.b(r1)     // Catch: java.lang.Throwable -> L3f
            m8.q r2 = r6.f9544c     // Catch: java.lang.Throwable -> L37
            u2.b r2 = r2.o()     // Catch: java.lang.Throwable -> L37
            int r3 = r2.f10405b     // Catch: java.lang.Throwable -> L37
            r4 = 2
            r5 = 1
            if (r3 == r4) goto L1e
            if (r3 != r5) goto L1d
            goto L1e
        L1d:
            r5 = 0
        L1e:
            if (r5 == 0) goto L39
            java.lang.String r3 = r6.h(r2)     // Catch: java.lang.Throwable -> L37
            m8.q r4 = r6.f9544c     // Catch: java.lang.Throwable -> L37
            u2.a r2 = r2.a()     // Catch: java.lang.Throwable -> L37
            r2.f10399a = r3     // Catch: java.lang.Throwable -> L37
            r3 = 3
            r2.f10400b = r3     // Catch: java.lang.Throwable -> L37
            u2.b r2 = r2.a()     // Catch: java.lang.Throwable -> L37
            r4.l(r2)     // Catch: java.lang.Throwable -> L37
            goto L39
        L37:
            r2 = move-exception
            goto L51
        L39:
            if (r1 == 0) goto L41
            r1.r()     // Catch: java.lang.Throwable -> L3f
            goto L41
        L3f:
            r1 = move-exception
            goto L57
        L41:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3f
            r6.k(r2)
            t1.i r0 = r6.i
            t2.b r1 = new t2.b
            r2 = 2
            r1.<init>(r6, r2)
            r0.execute(r1)
            return
        L51:
            if (r1 == 0) goto L56
            r1.r()     // Catch: java.lang.Throwable -> L3f
        L56:
            throw r2     // Catch: java.lang.Throwable -> L3f
        L57:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3f
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.c.b():void");
    }

    public final u2.b c(u2.b bVar) {
        HttpURLConnection httpURLConnection;
        int responseCode;
        String str;
        v2.b bVar2;
        n1.f fVar = this.f9542a;
        fVar.a();
        String str2 = fVar.f7910c.f7918a;
        String str3 = bVar.f10404a;
        fVar.a();
        String str4 = fVar.f7910c.g;
        String str5 = bVar.f10407d;
        v2.c cVar = this.f9543b;
        p.b bVar3 = cVar.f10805c;
        if (!bVar3.b()) {
            throw new e("Firebase Installations Service is unavailable. Please try again later.");
        }
        URL a8 = v2.c.a("projects/" + str4 + "/installations/" + str3 + "/authTokens:generate");
        for (int i = 0; i <= 1; i++) {
            TrafficStats.setThreadStatsTag(32771);
            HttpURLConnection c9 = cVar.c(a8, str2);
            try {
                try {
                    c9.setRequestMethod(ShareTarget.METHOD_POST);
                    c9.addRequestProperty("Authorization", "FIS_v2 " + str5);
                    c9.setDoOutput(true);
                    v2.c.h(c9);
                    responseCode = c9.getResponseCode();
                    bVar3.d(responseCode);
                } catch (IOException | AssertionError unused) {
                    httpURLConnection = c9;
                }
                if (responseCode >= 200 && responseCode < 300) {
                    bVar2 = v2.c.f(c9);
                    c9.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    str = null;
                } else {
                    v2.c.b(c9, null, str2, str4);
                    httpURLConnection = c9;
                    try {
                        try {
                        } catch (Throwable th) {
                            th = th;
                            httpURLConnection.disconnect();
                            TrafficStats.clearThreadStatsTag();
                            throw th;
                        }
                    } catch (IOException | AssertionError unused2) {
                    }
                    if (responseCode == 401 || responseCode == 404) {
                        if (((byte) (0 | 1)) != 1) {
                            throw new IllegalStateException("Missing required properties: tokenExpirationTimestamp");
                        }
                        str = null;
                        v2.b bVar4 = new v2.b(null, 3, 0L);
                        httpURLConnection.disconnect();
                        TrafficStats.clearThreadStatsTag();
                        bVar2 = bVar4;
                    } else {
                        if (responseCode == 429) {
                            throw new e("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                        }
                        if (responseCode < 500 || responseCode >= 600) {
                            Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                            if (((byte) (0 | 1)) != 1) {
                                throw new IllegalStateException("Missing required properties: tokenExpirationTimestamp");
                            }
                            v2.b bVar5 = new v2.b(null, 2, 0L);
                            httpURLConnection.disconnect();
                            TrafficStats.clearThreadStatsTag();
                            bVar2 = bVar5;
                            str = null;
                        }
                        httpURLConnection.disconnect();
                        TrafficStats.clearThreadStatsTag();
                    }
                }
                int c10 = c.j.c(bVar2.f10800c);
                if (c10 != 0) {
                    if (c10 == 1) {
                        u2.a a10 = bVar.a();
                        a10.g = "BAD CONFIG";
                        a10.f10400b = 5;
                        return a10.a();
                    }
                    if (c10 != 2) {
                        throw new e("Firebase Installations Service is unavailable. Please try again later.");
                    }
                    l(str);
                    u2.a a11 = bVar.a();
                    a11.f10400b = 2;
                    return a11.a();
                }
                String str6 = bVar2.f10798a;
                long j = bVar2.f10799b;
                this.f9545d.f9556a.getClass();
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                u2.a a12 = bVar.a();
                a12.f10401c = str6;
                a12.f10403e = j;
                byte b7 = (byte) (a12.h | 1);
                a12.f = currentTimeMillis;
                a12.h = (byte) (b7 | 2);
                return a12.a();
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = c9;
            }
        }
        throw new e("Firebase Installations Service is unavailable. Please try again later.");
    }

    public final p d() {
        String str;
        g();
        synchronized (this) {
            str = this.j;
        }
        if (str != null) {
            return t1.x(str);
        }
        j1.i iVar = new j1.i();
        a(new g(iVar));
        p pVar = iVar.f6539a;
        this.h.execute(new b(this, 0));
        return pVar;
    }

    public final p e() {
        g();
        j1.i iVar = new j1.i();
        a(new f(this.f9545d, iVar));
        this.h.execute(new b(this, 1));
        return iVar.f6539a;
    }

    /* JADX WARN: Finally extract failed */
    public final void f(u2.b bVar) {
        synchronized (f9541m) {
            try {
                n1.f fVar = this.f9542a;
                fVar.a();
                q b7 = q.b(fVar.f7908a);
                try {
                    this.f9544c.l(bVar);
                    if (b7 != null) {
                        b7.r();
                    }
                } catch (Throwable th) {
                    if (b7 != null) {
                        b7.r();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void g() {
        n1.f fVar = this.f9542a;
        fVar.a();
        y.e(fVar.f7910c.f7919b, "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        fVar.a();
        y.e(fVar.f7910c.g, "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        fVar.a();
        y.e(fVar.f7910c.f7918a, "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        fVar.a();
        String str = fVar.f7910c.f7919b;
        Pattern pattern = j.f9554b;
        y.a("Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.", str.contains(":"));
        fVar.a();
        y.a("Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.", j.f9554b.matcher(fVar.f7910c.f7918a).matches());
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001c, code lost:
    
        if ("[DEFAULT]".equals(r0.f7909b) != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String h(u2.b r3) {
        /*
            r2 = this;
            n1.f r0 = r2.f9542a
            r0.a()
            java.lang.String r0 = r0.f7909b
            java.lang.String r1 = "CHIME_ANDROID_SDK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1e
            n1.f r0 = r2.f9542a
            java.lang.String r1 = "[DEFAULT]"
            r0.a()
            java.lang.String r0 = r0.f7909b
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L50
        L1e:
            int r3 = r3.f10405b
            r0 = 1
            if (r3 != r0) goto L50
            s1.m r3 = r2.f9546e
            java.lang.Object r3 = r3.get()
            u2.c r3 = (u2.c) r3
            android.content.SharedPreferences r0 = r3.f10410a
            monitor-enter(r0)
            java.lang.String r1 = r3.a()     // Catch: java.lang.Throwable -> L36
            if (r1 == 0) goto L38
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
            goto L3d
        L36:
            r3 = move-exception
            goto L4e
        L38:
            java.lang.String r1 = r3.b()     // Catch: java.lang.Throwable -> L36
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
        L3d:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L4d
            t2.h r3 = r2.f
            r3.getClass()
            java.lang.String r3 = t2.h.a()
            return r3
        L4d:
            return r1
        L4e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
            throw r3
        L50:
            t2.h r3 = r2.f
            r3.getClass()
            java.lang.String r3 = t2.h.a()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.c.h(u2.b):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [v2.c] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [v2.a] */
    public final u2.b i(u2.b bVar) {
        int responseCode;
        String str = bVar.f10404a;
        String str2 = null;
        if (str != null && str.length() == 11) {
            u2.c cVar = (u2.c) this.f9546e.get();
            synchronized (cVar.f10410a) {
                try {
                    String[] strArr = u2.c.f10409c;
                    int i = 0;
                    while (true) {
                        if (i < 4) {
                            String str3 = strArr[i];
                            String string = cVar.f10410a.getString("|T|" + cVar.f10411b + "|" + str3, null);
                            if (string == null || string.isEmpty()) {
                                i++;
                            } else if (string.startsWith("{")) {
                                try {
                                    str2 = new JSONObject(string).getString("token");
                                } catch (JSONException unused) {
                                }
                            } else {
                                str2 = string;
                            }
                        }
                    }
                } finally {
                }
            }
        }
        v2.c cVar2 = this.f9543b;
        n1.f fVar = this.f9542a;
        fVar.a();
        String str4 = fVar.f7910c.f7918a;
        String str5 = bVar.f10404a;
        n1.f fVar2 = this.f9542a;
        fVar2.a();
        String str6 = fVar2.f7910c.g;
        n1.f fVar3 = this.f9542a;
        fVar3.a();
        String str7 = fVar3.f7910c.f7919b;
        p.b bVar2 = cVar2.f10805c;
        if (!bVar2.b()) {
            throw new e("Firebase Installations Service is unavailable. Please try again later.");
        }
        URL a8 = v2.c.a("projects/" + str6 + "/installations");
        int i6 = 0;
        v2.a aVar = cVar2;
        while (i6 <= 1) {
            TrafficStats.setThreadStatsTag(32769);
            HttpURLConnection c9 = aVar.c(a8, str4);
            try {
                try {
                    c9.setRequestMethod(ShareTarget.METHOD_POST);
                    c9.setDoOutput(true);
                    if (str2 != null) {
                        c9.addRequestProperty("x-goog-fis-android-iid-migration-auth", str2);
                    }
                    v2.c.g(c9, str5, str7);
                    responseCode = c9.getResponseCode();
                    bVar2.d(responseCode);
                } finally {
                    c9.disconnect();
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (IOException | AssertionError unused2) {
            }
            if (responseCode >= 200 && responseCode < 300) {
                v2.a e10 = v2.c.e(c9);
                c9.disconnect();
                TrafficStats.clearThreadStatsTag();
                aVar = e10;
            } else {
                try {
                    v2.c.b(c9, str7, str4, str6);
                } catch (IOException | AssertionError unused3) {
                    c9.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    i6++;
                    aVar = aVar;
                }
                if (responseCode == 429) {
                    throw new e("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                }
                if (responseCode < 500 || responseCode >= 600) {
                    Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                    v2.a aVar2 = new v2.a(null, null, null, null, 2);
                    c9.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    aVar = aVar2;
                } else {
                    c9.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    i6++;
                    aVar = aVar;
                }
            }
            int c10 = c.j.c(aVar.f10797e);
            if (c10 != 0) {
                if (c10 != 1) {
                    throw new e("Firebase Installations Service is unavailable. Please try again later.");
                }
                u2.a a10 = bVar.a();
                a10.g = "BAD CONFIG";
                a10.f10400b = 5;
                return a10.a();
            }
            String str8 = aVar.f10794b;
            String str9 = aVar.f10795c;
            this.f9545d.f9556a.getClass();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            v2.b bVar3 = aVar.f10796d;
            String str10 = bVar3.f10798a;
            long j = bVar3.f10799b;
            u2.a a11 = bVar.a();
            a11.f10399a = str8;
            a11.f10400b = 4;
            a11.f10401c = str10;
            a11.f10402d = str9;
            a11.f10403e = j;
            byte b7 = (byte) (a11.h | 1);
            a11.f = currentTimeMillis;
            a11.h = (byte) (b7 | 2);
            return a11.a();
        }
        throw new e("Firebase Installations Service is unavailable. Please try again later.");
    }

    public final void j(Exception exc) {
        synchronized (this.g) {
            try {
                Iterator it = this.f9548l.iterator();
                while (it.hasNext()) {
                    if (((i) it.next()).a(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k(u2.b bVar) {
        synchronized (this.g) {
            try {
                Iterator it = this.f9548l.iterator();
                while (it.hasNext()) {
                    if (((i) it.next()).b(bVar)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void l(String str) {
        this.j = str;
    }

    public final synchronized void m(u2.b bVar, u2.b bVar2) {
        try {
            if (this.f9547k.size() != 0 && !TextUtils.equals(bVar.f10404a, bVar2.f10404a)) {
                Iterator it = this.f9547k.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            }
        } finally {
        }
    }
}
