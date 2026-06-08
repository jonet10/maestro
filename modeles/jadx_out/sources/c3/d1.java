package c3;

import android.util.Log;
import androidx.datastore.core.DataStore;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d1 {

    /* renamed from: a, reason: collision with root package name */
    public final f3.j f1222a;

    /* renamed from: b, reason: collision with root package name */
    public final t0 f1223b;

    /* renamed from: c, reason: collision with root package name */
    public final s0 f1224c;

    /* renamed from: d, reason: collision with root package name */
    public final h1 f1225d;

    /* renamed from: e, reason: collision with root package name */
    public final DataStore f1226e;
    public final d0 f;
    public final t6.h g;
    public i0 h;
    public boolean i;
    public boolean j;

    /* renamed from: k, reason: collision with root package name */
    public String f1227k;

    public d1(f3.j jVar, t0 t0Var, s0 s0Var, h1 h1Var, DataStore dataStore, d0 d0Var, t6.h hVar) {
        jVar.getClass();
        t0Var.getClass();
        s0Var.getClass();
        h1Var.getClass();
        dataStore.getClass();
        d0Var.getClass();
        hVar.getClass();
        this.f1222a = jVar;
        this.f1223b = t0Var;
        this.f1224c = s0Var;
        this.f1225d = h1Var;
        this.f1226e = dataStore;
        this.f = d0Var;
        this.g = hVar;
        this.f1227k = "";
        o7.c0.s(o7.c0.b(hVar), null, null, new z0(this, null, 0), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(c3.d1 r4, java.lang.String r5, c3.a1 r6, t6.c r7) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.d1.a(c3.d1, java.lang.String, c3.a1, t6.c):java.lang.Object");
    }

    public final void b() {
        this.i = false;
        if (this.h == null) {
            Log.d("FirebaseSessions", "App backgrounded, but local SessionData not initialized");
            return;
        }
        Log.d("FirebaseSessions", "App backgrounded on " + this.f.a());
        o7.c0.s(o7.c0.b(this.g), null, null, new z0(this, null, 1), 3);
    }

    public final void c() {
        this.i = true;
        i0 i0Var = this.h;
        if (i0Var == null) {
            this.j = true;
            Log.d("FirebaseSessions", "App foregrounded, but local SessionData not initialized");
            return;
        }
        t6.c cVar = null;
        if (i0Var == null) {
            kotlin.jvm.internal.l.i("localSessionData");
            throw null;
        }
        Log.d("FirebaseSessions", "App foregrounded on " + this.f.a());
        if (e(i0Var) || d(i0Var)) {
            o7.c0.s(o7.c0.b(this.g), null, null, new b.n(this, i0Var, cVar, 6), 3);
        }
    }

    public final boolean d(i0 i0Var) {
        Map map = i0Var.f1270c;
        boolean z9 = true;
        d0 d0Var = this.f;
        if (map == null) {
            Log.d("FirebaseSessions", "No process data for " + d0Var.a());
            return true;
        }
        d0Var.getClass();
        b0 b0Var = (b0) map.get(d0Var.a());
        if (b0Var != null && b0Var.f1195a == d0Var.f1219c && kotlin.jvm.internal.l.a(b0Var.f1196b, (String) d0Var.f1220d.getValue())) {
            z9 = false;
        }
        if (z9) {
            Log.d("FirebaseSessions", "Process " + d0Var.a() + " is stale");
        }
        return z9;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
    
        if (m7.a.e(r9) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0037, code lost:
    
        if (m7.a.e(r9) == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(c3.i0 r12) {
        /*
            r11 = this;
            c3.g1 r0 = r12.f1269b
            c3.n0 r12 = r12.f1268a
            java.lang.String r1 = "Session "
            java.lang.String r2 = "FirebaseSessions"
            r3 = 0
            if (r0 == 0) goto L77
            c3.h1 r4 = r11.f1225d
            r4.getClass()
            c3.g1 r4 = c3.h1.a()
            int r5 = m7.a.f7657m
            long r4 = r4.f1247a
            long r6 = r0.f1247a
            long r4 = r4 - r6
            m7.c r0 = m7.c.MILLISECONDS
            long r4 = com.google.android.gms.internal.measurement.i5.O(r4, r0)
            f3.j r0 = r11.f1222a
            f3.o r6 = r0.f4857a
            m7.a r6 = r6.b()
            r7 = 0
            if (r6 == 0) goto L3a
            long r9 = r6.f7658a
            int r6 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r6 <= 0) goto L3a
            boolean r6 = m7.a.e(r9)
            if (r6 != 0) goto L3a
            goto L57
        L3a:
            f3.o r0 = r0.f4858b
            m7.a r0 = r0.b()
            if (r0 == 0) goto L4f
            long r9 = r0.f7658a
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 <= 0) goto L4f
            boolean r0 = m7.a.e(r9)
            if (r0 != 0) goto L4f
            goto L57
        L4f:
            r0 = 30
            m7.c r6 = m7.c.MINUTES
            long r9 = com.google.android.gms.internal.measurement.i5.N(r0, r6)
        L57:
            int r0 = m7.a.c(r4, r9)
            if (r0 <= 0) goto L5e
            r3 = 1
        L5e:
            if (r3 == 0) goto L76
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r1)
            java.lang.String r12 = r12.f1290a
            r0.append(r12)
            java.lang.String r12 = " is expired"
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            android.util.Log.d(r2, r12)
        L76:
            return r3
        L77:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r1)
            java.lang.String r12 = r12.f1290a
            r0.append(r12)
            java.lang.String r12 = " has not backgrounded yet"
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            android.util.Log.d(r2, r12)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.d1.e(c3.i0):boolean");
    }
}
