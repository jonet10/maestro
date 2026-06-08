package o7;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class w0 extends r0 implements h0 {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8322n = AtomicReferenceFieldUpdater.newUpdater(w0.class, Object.class, "_queue$volatile");

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8323o = AtomicReferenceFieldUpdater.newUpdater(w0.class, Object.class, "_delayed$volatile");

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f8324p = AtomicIntegerFieldUpdater.newUpdater(w0.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    @Override // o7.r0
    public final long B() {
        Runnable runnable;
        u0 u0Var;
        f8.w wVar = c0.f8245c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8322n;
        if (!C()) {
            E();
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(this);
                if (obj == null) {
                    break;
                }
                if (!(obj instanceof t7.m)) {
                    if (obj != wVar) {
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        runnable = (Runnable) obj;
                        break loop0;
                    }
                    break;
                }
                t7.m mVar = (t7.m) obj;
                Object d10 = mVar.d();
                if (d10 != t7.m.g) {
                    runnable = (Runnable) d10;
                    break;
                }
                t7.m c9 = mVar.c();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c9) && atomicReferenceFieldUpdater.get(this) == obj) {
                }
            }
            runnable = null;
            if (runnable != null) {
                runnable.run();
                return 0L;
            }
            q6.i iVar = this.f8304l;
            if (((iVar == null || iVar.isEmpty()) ? Long.MAX_VALUE : 0L) != 0) {
                Object obj2 = atomicReferenceFieldUpdater.get(this);
                if (obj2 != null) {
                    if (obj2 instanceof t7.m) {
                        long j = t7.m.f.get((t7.m) obj2);
                        if (((int) (1073741823 & j)) != ((int) ((j & 1152921503533105152L) >> 30))) {
                            return 0L;
                        }
                    } else if (obj2 == wVar) {
                        return LocationRequestCompat.PASSIVE_INTERVAL;
                    }
                }
                v0 v0Var = (v0) f8323o.get(this);
                if (v0Var != null) {
                    synchronized (v0Var) {
                        u0[] u0VarArr = v0Var.f10363a;
                        u0Var = u0VarArr != null ? u0VarArr[0] : null;
                    }
                    if (u0Var != null) {
                        long nanoTime = u0Var.f8316a - System.nanoTime();
                        if (nanoTime >= 0) {
                            return nanoTime;
                        }
                    }
                }
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
        }
        return 0L;
    }

    public void D(Runnable runnable) {
        E();
        if (!F(runnable)) {
            d0.f8250q.D(runnable);
            return;
        }
        Thread G = G();
        if (Thread.currentThread() != G) {
            LockSupport.unpark(G);
        }
    }

    public final void E() {
        u0 u0Var;
        v0 v0Var = (v0) f8323o.get(this);
        if (v0Var == null || t7.x.f10362b.get(v0Var) == 0) {
            return;
        }
        long nanoTime = System.nanoTime();
        do {
            synchronized (v0Var) {
                try {
                    u0[] u0VarArr = v0Var.f10363a;
                    u0 u0Var2 = u0VarArr != null ? u0VarArr[0] : null;
                    if (u0Var2 != null) {
                        u0Var = ((nanoTime - u0Var2.f8316a) > 0L ? 1 : ((nanoTime - u0Var2.f8316a) == 0L ? 0 : -1)) >= 0 ? F(u0Var2) : false ? v0Var.c(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (u0Var != null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean F(java.lang.Runnable r7) {
        /*
            r6 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = o7.w0.f8322n
            java.lang.Object r1 = r0.get(r6)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = o7.w0.f8324p
            int r2 = r2.get(r6)
            r3 = 0
            if (r2 == 0) goto L10
            return r3
        L10:
            r2 = 1
            if (r1 != 0) goto L22
        L13:
            r1 = 0
            boolean r1 = r0.compareAndSet(r6, r1, r7)
            if (r1 == 0) goto L1b
            goto L62
        L1b:
            java.lang.Object r1 = r0.get(r6)
            if (r1 == 0) goto L13
            goto L0
        L22:
            boolean r4 = r1 instanceof t7.m
            if (r4 == 0) goto L47
            r4 = r1
            t7.m r4 = (t7.m) r4
            int r5 = r4.a(r7)
            if (r5 == 0) goto L62
            if (r5 == r2) goto L35
            r0 = 2
            if (r5 == r0) goto L4b
            goto L0
        L35:
            t7.m r3 = r4.c()
        L39:
            boolean r2 = r0.compareAndSet(r6, r1, r3)
            if (r2 == 0) goto L40
            goto L0
        L40:
            java.lang.Object r2 = r0.get(r6)
            if (r2 == r1) goto L39
            goto L0
        L47:
            f8.w r4 = o7.c0.f8245c
            if (r1 != r4) goto L4c
        L4b:
            return r3
        L4c:
            t7.m r3 = new t7.m
            r4 = 8
            r3.<init>(r4, r2)
            r4 = r1
            java.lang.Runnable r4 = (java.lang.Runnable) r4
            r3.a(r4)
            r3.a(r7)
        L5c:
            boolean r4 = r0.compareAndSet(r6, r1, r3)
            if (r4 == 0) goto L63
        L62:
            return r2
        L63:
            java.lang.Object r4 = r0.get(r6)
            if (r4 == r1) goto L5c
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.w0.F(java.lang.Runnable):boolean");
    }

    public abstract Thread G();

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        if ((t7.x.f10362b.get(r0) == 0) == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean H() {
        /*
            r7 = this;
            q6.i r0 = r7.f8304l
            r1 = 1
            if (r0 == 0) goto La
            boolean r0 = r0.isEmpty()
            goto Lb
        La:
            r0 = r1
        Lb:
            r2 = 0
            if (r0 != 0) goto Lf
            goto L54
        Lf:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = o7.w0.f8323o
            java.lang.Object r0 = r0.get(r7)
            o7.v0 r0 = (o7.v0) r0
            if (r0 == 0) goto L27
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = t7.x.f10362b
            int r0 = r3.get(r0)
            if (r0 != 0) goto L23
            r0 = r1
            goto L24
        L23:
            r0 = r2
        L24:
            if (r0 != 0) goto L27
            goto L54
        L27:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = o7.w0.f8322n
            java.lang.Object r0 = r0.get(r7)
            if (r0 != 0) goto L30
            goto L53
        L30:
            boolean r3 = r0 instanceof t7.m
            if (r3 == 0) goto L4f
            t7.m r0 = (t7.m) r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = t7.m.f
            long r3 = r3.get(r0)
            r5 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r5 = r5 & r3
            int r0 = (int) r5
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r3 = r3 & r5
            r5 = 30
            long r3 = r3 >> r5
            int r3 = (int) r3
            if (r0 != r3) goto L4e
            return r1
        L4e:
            return r2
        L4f:
            f8.w r3 = o7.c0.f8245c
            if (r0 != r3) goto L54
        L53:
            return r1
        L54:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.w0.H():boolean");
    }

    public void I(long j, u0 u0Var) {
        d0.f8250q.J(j, u0Var);
    }

    public final void J(long j, u0 u0Var) {
        int c9;
        Thread G;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8323o;
        if (f8324p.get(this) != 0) {
            c9 = 1;
        } else {
            v0 v0Var = (v0) atomicReferenceFieldUpdater.get(this);
            if (v0Var == null) {
                v0 v0Var2 = new v0();
                v0Var2.f8320c = j;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, v0Var2) && atomicReferenceFieldUpdater.get(this) == null) {
                }
                Object obj = atomicReferenceFieldUpdater.get(this);
                obj.getClass();
                v0Var = (v0) obj;
            }
            c9 = u0Var.c(j, v0Var, this);
        }
        if (c9 != 0) {
            if (c9 == 1) {
                I(j, u0Var);
                return;
            } else {
                if (c9 == 2) {
                    return;
                }
                androidx.privacysandbox.ads.adservices.customaudience.a.i("unexpected result");
                return;
            }
        }
        v0 v0Var3 = (v0) atomicReferenceFieldUpdater.get(this);
        if (v0Var3 != null) {
            synchronized (v0Var3) {
                u0[] u0VarArr = v0Var3.f10363a;
                r2 = u0VarArr != null ? u0VarArr[0] : null;
            }
        }
        if (r2 != u0Var || Thread.currentThread() == (G = G())) {
            return;
        }
        LockSupport.unpark(G);
    }

    @Override // o7.w
    public final void dispatch(t6.h hVar, Runnable runnable) {
        D(runnable);
    }

    public o0 e(long j, x1 x1Var, t6.h hVar) {
        return e0.f8257a.e(j, x1Var, hVar);
    }

    @Override // o7.h0
    public final void i(long j, l lVar) {
        long j6 = j > 0 ? j >= 9223372036854L ? LocationRequestCompat.PASSIVE_INTERVAL : 1000000 * j : 0L;
        if (j6 < 4611686018427387903L) {
            long nanoTime = System.nanoTime();
            s0 s0Var = new s0(this, j6 + nanoTime, lVar);
            J(nanoTime, s0Var);
            lVar.v(new h(s0Var, 2));
        }
    }

    @Override // o7.r0
    public void shutdown() {
        u0 c9;
        v1.f8321a.set(null);
        f8324p.set(this, 1);
        f8.w wVar = c0.f8245c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8322n;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != null) {
                if (!(obj instanceof t7.m)) {
                    if (obj != wVar) {
                        t7.m mVar = new t7.m(8, true);
                        mVar.a((Runnable) obj);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, mVar)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((t7.m) obj).b();
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, wVar)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                    break;
                }
            }
            break loop0;
        }
        while (B() <= 0) {
        }
        long nanoTime = System.nanoTime();
        while (true) {
            v0 v0Var = (v0) f8323o.get(this);
            if (v0Var == null) {
                return;
            }
            synchronized (v0Var) {
                c9 = t7.x.f10362b.get(v0Var) > 0 ? v0Var.c(0) : null;
            }
            if (c9 == null) {
                return;
            } else {
                I(nanoTime, c9);
            }
        }
    }
}
