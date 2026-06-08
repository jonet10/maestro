package v7;

import a4.x;
import f8.w;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import o7.c0;
import s1.o;
import t7.q;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c implements Executor, Closeable {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f10873q = AtomicLongFieldUpdater.newUpdater(c.class, "parkedWorkersStack$volatile");

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f10874r = AtomicLongFieldUpdater.newUpdater(c.class, "controlState$volatile");

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10875s = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isTerminated$volatile");

    /* renamed from: t, reason: collision with root package name */
    public static final w f10876t = new w("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f10877a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10878b;
    private volatile /* synthetic */ long controlState$volatile;

    /* renamed from: l, reason: collision with root package name */
    public final long f10879l;

    /* renamed from: m, reason: collision with root package name */
    public final String f10880m;

    /* renamed from: n, reason: collision with root package name */
    public final f f10881n;

    /* renamed from: o, reason: collision with root package name */
    public final f f10882o;

    /* renamed from: p, reason: collision with root package name */
    public final q f10883p;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    public c(int i, int i6, long j, String str) {
        this.f10877a = i;
        this.f10878b = i6;
        this.f10879l = j;
        this.f10880m = str;
        if (i < 1) {
            o.o(x.g(i, "Core pool size ", " should be at least 1"));
            throw null;
        }
        if (i6 < i) {
            o.e(i6, i, " should be greater than or equals to core pool size ", "Max pool size ");
            throw null;
        }
        if (i6 > 2097150) {
            o.o(x.g(i6, "Max pool size ", " should not exceed maximal supported number of threads 2097150"));
            throw null;
        }
        if (j <= 0) {
            o.o(k0.k.g(j, "Idle worker keep alive time ", " must be positive"));
            throw null;
        }
        this.f10881n = new f();
        this.f10882o = new f();
        this.f10883p = new q((i + 1) * 2);
        this.controlState$volatile = i << 42;
        this._isTerminated$volatile = 0;
    }

    public static /* synthetic */ void d(c cVar, Runnable runnable, int i) {
        cVar.c(runnable, false, (i & 4) == 0);
    }

    public final int b() {
        synchronized (this.f10883p) {
            try {
                if (f10875s.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f10874r;
                long j = atomicLongFieldUpdater.get(this);
                int i = (int) (j & 2097151);
                int i6 = i - ((int) ((j & 4398044413952L) >> 21));
                if (i6 < 0) {
                    i6 = 0;
                }
                if (i6 >= this.f10877a) {
                    return 0;
                }
                if (i >= this.f10878b) {
                    return 0;
                }
                int i10 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i10 <= 0 || this.f10883p.b(i10) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                a aVar = new a(this, i10);
                this.f10883p.c(i10, aVar);
                if (i10 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i11 = i6 + 1;
                aVar.start();
                return i11;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(Runnable runnable, boolean z9, boolean z10) {
        h iVar;
        b bVar;
        j.f.getClass();
        long nanoTime = System.nanoTime();
        if (runnable instanceof h) {
            iVar = (h) runnable;
            iVar.f10889a = nanoTime;
            iVar.f10890b = z9;
        } else {
            iVar = new i(runnable, nanoTime, z9);
        }
        boolean z11 = iVar.f10890b;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f10874r;
        long addAndGet = z11 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread currentThread = Thread.currentThread();
        a aVar = currentThread instanceof a ? (a) currentThread : null;
        if (aVar == null || !aVar.f10866q.equals(this)) {
            aVar = null;
        }
        if (aVar != null && (bVar = aVar.f10861l) != b.f10871n && (iVar.f10890b || bVar != b.f10868b)) {
            aVar.f10865p = true;
            l lVar = aVar.f10859a;
            if (z10) {
                iVar = lVar.a(iVar);
            } else {
                lVar.getClass();
                h hVar = (h) l.f10898b.getAndSet(lVar, iVar);
                iVar = hVar == null ? null : lVar.a(hVar);
            }
        }
        if (iVar != null) {
            if (!(iVar.f10890b ? this.f10882o.a(iVar) : this.f10881n.a(iVar))) {
                throw new RejectedExecutionException(x.n(new StringBuilder(), this.f10880m, " was terminated"));
            }
        }
        boolean z12 = z10 && aVar != null;
        if (z11) {
            if (z12 || h() || f(addAndGet)) {
                return;
            }
            h();
            return;
        }
        if (z12 || h() || f(atomicLongFieldUpdater.get(this))) {
            return;
        }
        h();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0088, code lost:
    
        if (r1 == null) goto L39;
     */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = v7.c.f10875s
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof v7.a
            r3 = 0
            if (r1 == 0) goto L17
            v7.a r0 = (v7.a) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            v7.c r1 = r0.f10866q
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            t7.q r1 = r8.f10883p
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = v7.c.f10874r     // Catch: java.lang.Throwable -> Lc3
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc3
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r1)
            if (r2 > r4) goto L78
            r1 = r2
        L36:
            t7.q r5 = r8.f10883p
            java.lang.Object r5 = r5.b(r1)
            r5.getClass()
            v7.a r5 = (v7.a) r5
            if (r5 == r0) goto L73
        L43:
            java.lang.Thread$State r6 = r5.getState()
            java.lang.Thread$State r7 = java.lang.Thread.State.TERMINATED
            if (r6 == r7) goto L54
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r6 = 10000(0x2710, double:4.9407E-320)
            r5.join(r6)
            goto L43
        L54:
            v7.l r5 = r5.f10859a
            v7.f r6 = r8.f10882o
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = v7.l.f10898b
            java.lang.Object r7 = r7.getAndSet(r5, r3)
            v7.h r7 = (v7.h) r7
            if (r7 == 0) goto L68
            r6.a(r7)
        L68:
            v7.h r7 = r5.b()
            if (r7 != 0) goto L6f
            goto L73
        L6f:
            r6.a(r7)
            goto L68
        L73:
            if (r1 == r4) goto L78
            int r1 = r1 + 1
            goto L36
        L78:
            v7.f r1 = r8.f10882o
            r1.b()
            v7.f r1 = r8.f10881n
            r1.b()
        L82:
            if (r0 == 0) goto L8a
            v7.h r1 = r0.a(r2)
            if (r1 != 0) goto Lb2
        L8a:
            v7.f r1 = r8.f10881n
            java.lang.Object r1 = r1.d()
            v7.h r1 = (v7.h) r1
            if (r1 != 0) goto Lb2
            v7.f r1 = r8.f10882o
            java.lang.Object r1 = r1.d()
            v7.h r1 = (v7.h) r1
            if (r1 != 0) goto Lb2
            if (r0 == 0) goto La5
            v7.b r1 = v7.b.f10871n
            r0.h(r1)
        La5:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = v7.c.f10873q
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = v7.c.f10874r
            r0.set(r8, r1)
            return
        Lb2:
            r1.run()     // Catch: java.lang.Throwable -> Lb6
            goto L82
        Lb6:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L82
        Lc3:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v7.c.close():void");
    }

    public final void e(a aVar, int i, int i6) {
        while (true) {
            long j = f10873q.get(this);
            int i10 = (int) (2097151 & j);
            long j6 = (2097152 + j) & (-2097152);
            if (i10 == i) {
                if (i6 == 0) {
                    Object c9 = aVar.c();
                    while (true) {
                        if (c9 == f10876t) {
                            i10 = -1;
                            break;
                        }
                        if (c9 == null) {
                            i10 = 0;
                            break;
                        }
                        a aVar2 = (a) c9;
                        int b7 = aVar2.b();
                        if (b7 != 0) {
                            i10 = b7;
                            break;
                        }
                        c9 = aVar2.c();
                    }
                } else {
                    i10 = i6;
                }
            }
            if (i10 >= 0) {
                if (f10873q.compareAndSet(this, j, i10 | j6)) {
                    return;
                }
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        d(this, runnable, 6);
    }

    public final boolean f(long j) {
        int i = ((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i6 = this.f10877a;
        if (i < i6) {
            int b7 = b();
            if (b7 == 1 && i6 > 1) {
                b();
            }
            if (b7 > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        w wVar;
        int i;
        while (true) {
            long j = f10873q.get(this);
            a aVar = (a) this.f10883p.b((int) (2097151 & j));
            if (aVar == null) {
                aVar = null;
            } else {
                long j6 = (2097152 + j) & (-2097152);
                Object c9 = aVar.c();
                while (true) {
                    wVar = f10876t;
                    if (c9 == wVar) {
                        i = -1;
                        break;
                    }
                    if (c9 == null) {
                        i = 0;
                        break;
                    }
                    a aVar2 = (a) c9;
                    i = aVar2.b();
                    if (i != 0) {
                        break;
                    }
                    c9 = aVar2.c();
                }
                if (i >= 0) {
                    if (f10873q.compareAndSet(this, j, i | j6)) {
                        aVar.g(wVar);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.f10858r.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        q qVar = this.f10883p;
        int a8 = qVar.a();
        int i = 0;
        int i6 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 1; i13 < a8; i13++) {
            a aVar = (a) qVar.b(i13);
            if (aVar != null) {
                l lVar = aVar.f10859a;
                lVar.getClass();
                int i14 = l.f10898b.get(lVar) != null ? (l.f10899c.get(lVar) - l.f10900d.get(lVar)) + 1 : l.f10899c.get(lVar) - l.f10900d.get(lVar);
                int ordinal = aVar.f10861l.ordinal();
                if (ordinal == 0) {
                    i++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i14);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (ordinal == 1) {
                    i6++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i14);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (ordinal == 2) {
                    i10++;
                } else if (ordinal == 3) {
                    i11++;
                    if (i14 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i14);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (ordinal != 4) {
                        com.google.gson.internal.a.b();
                        return null;
                    }
                    i12++;
                }
            }
        }
        long j = f10874r.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f10880m);
        sb4.append('@');
        sb4.append(c0.o(this));
        sb4.append("[Pool Size {core = ");
        int i15 = this.f10877a;
        sb4.append(i15);
        sb4.append(", max = ");
        sb4.append(this.f10878b);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i);
        sb4.append(", blocking = ");
        sb4.append(i6);
        sb4.append(", parked = ");
        sb4.append(i10);
        sb4.append(", dormant = ");
        sb4.append(i11);
        sb4.append(", terminated = ");
        sb4.append(i12);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f10881n.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f10882o.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i15 - ((int) ((j & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
