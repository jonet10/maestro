package s8;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q implements Closeable {
    public static final ThreadPoolExecutor D;
    public final x A;
    public final o B;
    public final LinkedHashSet C;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9427a;

    /* renamed from: b, reason: collision with root package name */
    public final m f9428b;

    /* renamed from: m, reason: collision with root package name */
    public final String f9430m;

    /* renamed from: n, reason: collision with root package name */
    public int f9431n;

    /* renamed from: o, reason: collision with root package name */
    public int f9432o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9433p;

    /* renamed from: q, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f9434q;

    /* renamed from: r, reason: collision with root package name */
    public final ThreadPoolExecutor f9435r;

    /* renamed from: s, reason: collision with root package name */
    public final z f9436s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f9437t;
    public long v;

    /* renamed from: w, reason: collision with root package name */
    public final f8.q f9439w;

    /* renamed from: x, reason: collision with root package name */
    public final f8.q f9440x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f9441y;

    /* renamed from: z, reason: collision with root package name */
    public final Socket f9442z;

    /* renamed from: l, reason: collision with root package name */
    public final LinkedHashMap f9429l = new LinkedHashMap();

    /* renamed from: u, reason: collision with root package name */
    public long f9438u = 0;

    static {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        byte[] bArr = n8.c.f8114a;
        D = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, synchronousQueue, new n8.b("OkHttp Http2Connection", true));
    }

    public q(g8.g gVar) {
        f8.q qVar = new f8.q(3);
        this.f9439w = qVar;
        f8.q qVar2 = new f8.q(3);
        this.f9440x = qVar2;
        this.f9441y = false;
        this.C = new LinkedHashSet();
        this.f9436s = z.f9482a;
        boolean z9 = gVar.f5381a;
        this.f9427a = z9;
        this.f9428b = (m) gVar.f5386o;
        int i = z9 ? 1 : 2;
        this.f9432o = i;
        if (z9) {
            this.f9432o = i + 2;
        }
        if (z9) {
            qVar.h(7, 16777216);
        }
        String str = (String) gVar.f5383l;
        this.f9430m = str;
        byte[] bArr = n8.c.f8114a;
        Locale locale = Locale.US;
        this.f9434q = new ScheduledThreadPoolExecutor(1, new n8.b(androidx.lifecycle.l.w("OkHttp ", str, " Writer"), false));
        this.f9435r = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new n8.b(androidx.lifecycle.l.w("OkHttp ", str, " Push Observer"), true));
        qVar2.h(7, 65535);
        qVar2.h(5, 16384);
        this.v = qVar2.c();
        this.f9442z = (Socket) gVar.f5382b;
        this.A = new x((w8.z) gVar.f5385n, z9);
        this.B = new o(this, new s((w8.a0) gVar.f5384m, z9));
    }

    public final void b(int i, int i6) {
        w[] wVarArr = null;
        try {
            h(i);
            e = null;
        } catch (IOException e10) {
            e = e10;
        }
        synchronized (this) {
            try {
                if (!this.f9429l.isEmpty()) {
                    wVarArr = (w[]) this.f9429l.values().toArray(new w[this.f9429l.size()]);
                    this.f9429l.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (wVarArr != null) {
            for (w wVar : wVarArr) {
                try {
                    wVar.c(i6);
                } catch (IOException e11) {
                    if (e != null) {
                        e = e11;
                    }
                }
            }
        }
        try {
            this.A.close();
        } catch (IOException e12) {
            if (e == null) {
                e = e12;
            }
        }
        try {
            this.f9442z.close();
        } catch (IOException e13) {
            e = e13;
        }
        this.f9434q.shutdown();
        this.f9435r.shutdown();
        if (e != null) {
            throw e;
        }
    }

    public final void c() {
        try {
            b(2, 2);
        } catch (IOException unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        b(1, 6);
    }

    public final synchronized w d(int i) {
        return (w) this.f9429l.get(Integer.valueOf(i));
    }

    public final synchronized int e() {
        f8.q qVar;
        qVar = this.f9440x;
        return (qVar.f4964b & 16) != 0 ? ((int[]) qVar.f4965c)[4] : Integer.MAX_VALUE;
    }

    public final synchronized w f(int i) {
        w wVar;
        wVar = (w) this.f9429l.remove(Integer.valueOf(i));
        notifyAll();
        return wVar;
    }

    public final void flush() {
        this.A.flush();
    }

    public final void h(int i) {
        synchronized (this.A) {
            synchronized (this) {
                if (this.f9433p) {
                    return;
                }
                this.f9433p = true;
                this.A.e(this.f9431n, i, n8.c.f8114a);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.A.f9475m);
        r6 = r2;
        r8.v -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(int r9, boolean r10, w8.h r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            s8.x r12 = r8.A
            r12.c(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L5e
            monitor-enter(r8)
        L12:
            long r4 = r8.v     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L32
            java.util.LinkedHashMap r2 = r8.f9429l     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            if (r2 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            goto L12
        L28:
            r9 = move-exception
            goto L5c
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            throw r9     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
        L32:
            long r4 = java.lang.Math.min(r12, r4)     // Catch: java.lang.Throwable -> L28
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L28
            s8.x r4 = r8.A     // Catch: java.lang.Throwable -> L28
            int r4 = r4.f9475m     // Catch: java.lang.Throwable -> L28
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.v     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.v = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            s8.x r4 = r8.A
            if (r10 == 0) goto L51
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = r3
        L52:
            r4.c(r5, r9, r11, r2)
            goto Ld
        L56:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L28
            r9.<init>()     // Catch: java.lang.Throwable -> L28
            throw r9     // Catch: java.lang.Throwable -> L28
        L5c:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            throw r9
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.q.i(int, boolean, w8.h, long):void");
    }

    public final void j(int i, int i6) {
        try {
            this.f9434q.execute(new h(this, new Object[]{this.f9430m, Integer.valueOf(i)}, i, i6));
        } catch (RejectedExecutionException unused) {
        }
    }

    public final void n(int i, long j) {
        try {
            this.f9434q.execute(new i(this, new Object[]{this.f9430m, Integer.valueOf(i)}, i, j));
        } catch (RejectedExecutionException unused) {
        }
    }
}
