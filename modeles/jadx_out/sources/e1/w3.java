package e1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w3 extends h0 {

    /* renamed from: l, reason: collision with root package name */
    public final v3 f4358l;

    /* renamed from: m, reason: collision with root package name */
    public i0 f4359m;

    /* renamed from: n, reason: collision with root package name */
    public volatile Boolean f4360n;

    /* renamed from: o, reason: collision with root package name */
    public final s3 f4361o;

    /* renamed from: p, reason: collision with root package name */
    public ScheduledExecutorService f4362p;

    /* renamed from: q, reason: collision with root package name */
    public final s0 f4363q;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f4364r;

    /* renamed from: s, reason: collision with root package name */
    public final s3 f4365s;

    public w3(t1 t1Var) {
        super(t1Var);
        this.f4364r = new ArrayList();
        this.f4363q = new s0(t1Var.f4269t);
        this.f4358l = new v3(this);
        this.f4361o = new s3(this, t1Var, 0);
        this.f4365s = new s3(this, t1Var, 1);
    }

    @Override // e1.h0
    public final boolean j() {
        return false;
    }

    public final void k(AtomicReference atomicReference) {
        g();
        h();
        u(new x1(this, atomicReference, w(false)));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(android.os.Bundle r8) {
        /*
            r7 = this;
            r7.g()
            r7.h()
            e1.t r4 = new e1.t
            r4.<init>(r8)
            r7.s()
            e1.t1 r0 = r7.f3875a
            e1.g r1 = r0.f4262m
            r2 = 0
            e1.e0 r3 = e1.f0.f3919c1
            boolean r1 = r1.q(r2, r3)
            r2 = 0
            if (r1 == 0) goto L55
            e1.p0 r0 = r0.o()
            e1.t1 r1 = r0.f3875a
            e1.a5 r3 = r1.f4267r
            e1.w0 r1 = r1.f4264o
            e1.t1.k(r3)
            byte[] r3 = e1.a5.L(r4)
            if (r3 != 0) goto L3b
            e1.t1.m(r1)
            e1.u0 r0 = r1.f4340p
            java.lang.String r1 = "Null default event parameters; not writing to database"
            r0.b(r1)
        L39:
            r0 = r2
            goto L50
        L3b:
            int r5 = r3.length
            r6 = 131072(0x20000, float:1.83671E-40)
            if (r5 <= r6) goto L4b
            e1.t1.m(r1)
            e1.u0 r0 = r1.f4340p
            java.lang.String r1 = "Default event parameters too long for local database. Sending directly to service"
            r0.b(r1)
            goto L39
        L4b:
            r1 = 4
            boolean r0 = r0.n(r1, r3)
        L50:
            if (r0 == 0) goto L55
            r0 = 1
            r3 = r0
            goto L56
        L55:
            r3 = r2
        L56:
            e1.c5 r2 = r7.w(r2)
            e1.r2 r0 = new e1.r2
            r1 = r7
            r5 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r7.u(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.w3.l(android.os.Bundle):void");
    }

    public final void m() {
        g();
        h();
        if (x()) {
            return;
        }
        if (n()) {
            this.f4358l.b();
            return;
        }
        t1 t1Var = this.f3875a;
        if (t1Var.f4262m.j()) {
            return;
        }
        List<ResolveInfo> queryIntentServices = t1Var.f4259a.getPackageManager().queryIntentServices(new Intent().setClassName(t1Var.f4259a, "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.b("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(t1Var.f4259a, "com.google.android.gms.measurement.AppMeasurementService"));
        v3 v3Var = this.f4358l;
        w3 w3Var = v3Var.f4330l;
        w3Var.g();
        Context context = w3Var.f3875a.f4259a;
        o0.a b7 = o0.a.b();
        synchronized (v3Var) {
            try {
                boolean z9 = v3Var.f4328a;
                w3 w3Var2 = v3Var.f4330l;
                if (z9) {
                    w0 w0Var2 = w3Var2.f3875a.f4264o;
                    t1.m(w0Var2);
                    w0Var2.f4346w.b("Connection attempt already in progress");
                } else {
                    w0 w0Var3 = w3Var2.f3875a.f4264o;
                    t1.m(w0Var3);
                    w0Var3.f4346w.b("Using local app measurement service");
                    v3Var.f4328a = true;
                    b7.a(context, intent, w3Var2.f4358l, 129);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n() {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.w3.n():boolean");
    }

    public final void o() {
        g();
        h();
        v3 v3Var = this.f4358l;
        if (v3Var.f4329b != null && (v3Var.f4329b.g() || v3Var.f4329b.d())) {
            v3Var.f4329b.o();
        }
        v3Var.f4329b = null;
        try {
            o0.a.b().c(this.f3875a.f4259a, v3Var);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f4359m = null;
    }

    public final boolean p() {
        g();
        h();
        if (!n()) {
            return true;
        }
        a5 a5Var = this.f3875a.f4267r;
        t1.k(a5Var);
        return a5Var.N() >= ((Integer) f0.K0.a(null)).intValue();
    }

    public final boolean q() {
        g();
        h();
        if (!n()) {
            return true;
        }
        a5 a5Var = this.f3875a.f4267r;
        t1.k(a5Var);
        return a5Var.N() >= 241200;
    }

    public final void r(ComponentName componentName) {
        g();
        if (this.f4359m != null) {
            this.f4359m = null;
            w0 w0Var = this.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4346w.c(componentName, "Disconnected from device MeasurementService");
            g();
            m();
        }
    }

    public final void s() {
        this.f3875a.getClass();
    }

    public final void t() {
        g();
        s0 s0Var = this.f4363q;
        ((p0.a) s0Var.f4243b).getClass();
        s0Var.f4242a = SystemClock.elapsedRealtime();
        this.f3875a.getClass();
        this.f4361o.b(((Long) f0.Z.a(null)).longValue());
    }

    public final void u(Runnable runnable) {
        g();
        if (x()) {
            runnable.run();
            return;
        }
        ArrayList arrayList = this.f4364r;
        long size = arrayList.size();
        t1 t1Var = this.f3875a;
        t1Var.getClass();
        if (size >= 1000) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.b("Discarding data. Max runnable queue size reached");
        } else {
            arrayList.add(runnable);
            this.f4365s.b(60000L);
            m();
        }
    }

    public final void v() {
        g();
        t1 t1Var = this.f3875a;
        w0 w0Var = t1Var.f4264o;
        t1.m(w0Var);
        u0 u0Var = w0Var.f4346w;
        ArrayList arrayList = this.f4364r;
        u0Var.c(Integer.valueOf(arrayList.size()), "Processing queued up service tasks");
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            try {
                ((Runnable) obj).run();
            } catch (RuntimeException e10) {
                w0 w0Var2 = t1Var.f4264o;
                t1.m(w0Var2);
                w0Var2.f4339o.c(e10, "Task exception while flushing queue");
            }
        }
        arrayList.clear();
        this.f4365s.c();
    }

    public final c5 w(boolean z9) {
        long abs;
        Pair pair;
        t1 t1Var = this.f3875a;
        t1Var.getClass();
        n0 r9 = t1Var.r();
        String str = null;
        if (z9) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            t1 t1Var2 = w0Var.f3875a;
            g1 g1Var = t1Var2.f4263n;
            t1.k(g1Var);
            if (g1Var.f3983n != null) {
                g1 g1Var2 = t1Var2.f4263n;
                t1.k(g1Var2);
                f1 f1Var = g1Var2.f3983n;
                g1 g1Var3 = (g1) f1Var.f3971e;
                g1Var3.g();
                g1Var3.g();
                long j = ((g1) f1Var.f3971e).k().getLong((String) f1Var.f3968b, 0L);
                if (j == 0) {
                    f1Var.b();
                    abs = 0;
                } else {
                    g1Var3.f3875a.f4269t.getClass();
                    abs = Math.abs(j - System.currentTimeMillis());
                }
                long j6 = f1Var.f3967a;
                if (abs >= j6) {
                    if (abs > j6 + j6) {
                        f1Var.b();
                    } else {
                        String string = g1Var3.k().getString((String) f1Var.f3970d, null);
                        long j10 = g1Var3.k().getLong((String) f1Var.f3969c, 0L);
                        f1Var.b();
                        pair = (string == null || j10 <= 0) ? g1.I : new Pair(string, Long.valueOf(j10));
                        if (pair != null && pair != g1.I) {
                            String valueOf = String.valueOf(pair.second);
                            String str2 = (String) pair.first;
                            str = a4.x.o(new StringBuilder(valueOf.length() + 1 + String.valueOf(str2).length()), valueOf, ":", str2);
                        }
                    }
                }
                pair = null;
                if (pair != null) {
                    String valueOf2 = String.valueOf(pair.second);
                    String str22 = (String) pair.first;
                    str = a4.x.o(new StringBuilder(valueOf2.length() + 1 + String.valueOf(str22).length()), valueOf2, ":", str22);
                }
            }
        }
        return r9.k(str);
    }

    public final boolean x() {
        g();
        h();
        return this.f4359m != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x049c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x049c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x043a A[Catch: all -> 0x0476, TRY_ENTER, TryCatch #55 {all -> 0x0476, blocks: (B:213:0x0466, B:236:0x043a, B:238:0x0440, B:239:0x0443, B:227:0x0487, B:355:0x0371, B:359:0x037b, B:360:0x038c), top: B:212:0x0466 }] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x049c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x02d2 A[Catch: all -> 0x01fa, SQLiteException -> 0x02ac, SQLiteDatabaseLockedException -> 0x02b1, SQLiteFullException -> 0x02b5, TryCatch #58 {all -> 0x01fa, blocks: (B:183:0x01d5, B:186:0x01e9, B:188:0x01ee, B:197:0x0212, B:198:0x0215, B:195:0x020e, B:246:0x021b, B:249:0x022f, B:251:0x0247, B:254:0x0250, B:255:0x0253, B:257:0x0241, B:260:0x0257, B:263:0x026b, B:265:0x0283, B:270:0x028d, B:271:0x0290, B:268:0x027d, B:281:0x0294, B:289:0x02a8, B:291:0x02d2, B:302:0x02dc, B:303:0x02df, B:300:0x02cc, B:276:0x02ee, B:278:0x02f9, B:352:0x035c), top: B:182:0x01d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x063e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(e1.i0 r67, l0.a r68, e1.c5 r69) {
        /*
            Method dump skipped, instructions count: 1770
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.w3.y(e1.i0, l0.a, e1.c5):void");
    }

    public final void z(e eVar) {
        boolean n10;
        g();
        h();
        t1 t1Var = this.f3875a;
        t1Var.getClass();
        p0 o10 = t1Var.o();
        t1 t1Var2 = o10.f3875a;
        t1.k(t1Var2.f4267r);
        byte[] L = a5.L(eVar);
        if (L.length > 131072) {
            w0 w0Var = t1Var2.f4264o;
            t1.m(w0Var);
            w0Var.f4340p.b("Conditional user property too long for local database. Sending directly to service");
            n10 = false;
        } else {
            n10 = o10.n(2, L);
        }
        u(new q3(this, w(true), n10, new e(eVar)));
    }
}
