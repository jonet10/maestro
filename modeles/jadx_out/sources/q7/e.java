package q7;

import a4.x;
import androidx.core.location.LocationRequestCompat;
import f8.w;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import o7.c0;
import o7.c2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class e implements i {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f8742b = AtomicLongFieldUpdater.newUpdater(e.class, "sendersAndCloseStatus$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f8743l = AtomicLongFieldUpdater.newUpdater(e.class, "receivers$volatile");

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f8744m = AtomicLongFieldUpdater.newUpdater(e.class, "bufferEnd$volatile");

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f8745n = AtomicLongFieldUpdater.newUpdater(e.class, "completedExpandBuffersAndPauseFlag$volatile");

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8746o = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "sendSegment$volatile");

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8747p = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "receiveSegment$volatile");

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8748q = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "bufferEndSegment$volatile");

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8749r = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_closeCause$volatile");

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8750s = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f8751a;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    public e(int i) {
        this.f8751a = i;
        if (i < 0) {
            s1.o.o(x.g(i, "Invalid channel capacity: ", ", should be >=0"));
            throw null;
        }
        m mVar = g.f8753a;
        this.bufferEnd$volatile = i != 0 ? i != Integer.MAX_VALUE ? i : LocationRequestCompat.PASSIVE_INTERVAL : 0L;
        this.completedExpandBuffersAndPauseFlag$volatile = f8744m.get(this);
        m mVar2 = new m(0L, null, this, 3);
        this.sendSegment$volatile = mVar2;
        this.receiveSegment$volatile = mVar2;
        if (z()) {
            mVar2 = g.f8753a;
            mVar2.getClass();
        }
        this.bufferEndSegment$volatile = mVar2;
        this._closeCause$volatile = g.f8766s;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object C(q7.e r13, v6.c r14) {
        /*
            boolean r0 = r14 instanceof q7.c
            if (r0 == 0) goto L14
            r0 = r14
            q7.c r0 = (q7.c) r0
            int r1 = r0.f8738l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f8738l = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            q7.c r0 = new q7.c
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.f8736a
            int r0 = r6.f8738l
            r1 = 1
            if (r0 == 0) goto L32
            if (r0 != r1) goto L2b
            p6.a.e(r14)
            q7.l r14 = (q7.l) r14
            java.lang.Object r13 = r14.f8772a
            return r13
        L2b:
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r13)
            r13 = 0
            return r13
        L32:
            p6.a.e(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = q7.e.f8747p
            java.lang.Object r14 = r14.get(r13)
            q7.m r14 = (q7.m) r14
        L3d:
            boolean r0 = r13.w()
            if (r0 == 0) goto L4d
            java.lang.Throwable r13 = r13.q()
            q7.j r14 = new q7.j
            r14.<init>(r13)
            return r14
        L4d:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = q7.e.f8743l
            long r4 = r0.getAndIncrement(r13)
            int r0 = q7.g.f8754b
            long r2 = (long) r0
            long r7 = r4 / r2
            long r2 = r4 % r2
            int r3 = (int) r2
            long r9 = r14.f10355c
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 == 0) goto L6a
            q7.m r0 = r13.o(r7, r14)
            if (r0 != 0) goto L68
            goto L3d
        L68:
            r2 = r0
            goto L6b
        L6a:
            r2 = r14
        L6b:
            r12 = 0
            r7 = r13
            r8 = r2
            r9 = r3
            r10 = r4
            java.lang.Object r13 = r7.H(r8, r9, r10, r12)
            f8.w r14 = q7.g.f8760m
            if (r13 == r14) goto L9f
            f8.w r14 = q7.g.f8762o
            if (r13 != r14) goto L8a
            long r13 = r7.t()
            int r13 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r13 >= 0) goto L87
            r2.b()
        L87:
            r14 = r2
            r13 = r7
            goto L3d
        L8a:
            f8.w r14 = q7.g.f8761n
            if (r13 != r14) goto L9b
            r6.f8738l = r1
            r1 = r7
            java.lang.Object r13 = r1.D(r2, r3, r4, r6)
            u6.a r14 = u6.a.f10762a
            if (r13 != r14) goto L9a
            return r14
        L9a:
            return r13
        L9b:
            r2.b()
            return r13
        L9f:
            java.lang.String r13 = "unexpected"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r13)
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.e.C(q7.e, v6.c):java.lang.Object");
    }

    public static boolean G(Object obj) {
        if (obj instanceof o7.j) {
            return g.a((o7.j) obj, p6.x.f8463a, null);
        }
        if (obj instanceof x7.d) {
            com.google.gson.internal.a.o();
            return false;
        }
        com.google.gson.internal.a.m(obj, "Unexpected waiter: ");
        return false;
    }

    public static final m b(e eVar, long j, m mVar) {
        Object b7;
        e eVar2;
        m mVar2 = g.f8753a;
        f fVar = f.f8752a;
        loop0: while (true) {
            b7 = t7.a.b(mVar, j, fVar);
            if (!t7.a.e(b7)) {
                t7.s c9 = t7.a.c(b7);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8746o;
                    t7.s sVar = (t7.s) atomicReferenceFieldUpdater.get(eVar);
                    if (sVar.f10355c >= c9.f10355c) {
                        break loop0;
                    }
                    if (!c9.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(eVar, sVar, c9)) {
                        if (atomicReferenceFieldUpdater.get(eVar) != sVar) {
                            if (c9.f()) {
                                c9.e();
                            }
                        }
                    }
                    if (sVar.f()) {
                        sVar.e();
                    }
                }
            } else {
                break;
            }
        }
        boolean e10 = t7.a.e(b7);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8743l;
        if (e10) {
            eVar.x();
            if (mVar.f10355c * g.f8754b < atomicLongFieldUpdater.get(eVar)) {
                mVar.b();
                return null;
            }
        } else {
            m mVar3 = (m) t7.a.c(b7);
            long j6 = mVar3.f10355c;
            if (j6 <= j) {
                return mVar3;
            }
            long j10 = g.f8754b * j6;
            while (true) {
                long j11 = f8742b.get(eVar);
                long j12 = 1152921504606846975L & j11;
                if (j12 >= j10) {
                    eVar2 = eVar;
                    break;
                }
                eVar2 = eVar;
                if (f8742b.compareAndSet(eVar2, j11, (((int) (j11 >> 60)) << 60) + j12)) {
                    break;
                }
                eVar = eVar2;
            }
            if (j6 * g.f8754b < atomicLongFieldUpdater.get(eVar2)) {
                mVar3.b();
            }
        }
        return null;
    }

    public static final void d(e eVar, Object obj, o7.l lVar) {
        lVar.resumeWith(new p6.j(eVar.s()));
    }

    public static final int f(e eVar, m mVar, int i, Object obj, long j, Object obj2, boolean z9) {
        mVar.n(i, obj);
        if (z9) {
            return eVar.I(mVar, i, obj, j, obj2, z9);
        }
        Object l10 = mVar.l(i);
        if (l10 == null) {
            if (eVar.g(j)) {
                if (mVar.k(i, null, g.f8756d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (mVar.k(i, null, obj2)) {
                    return 2;
                }
            }
        } else if (l10 instanceof c2) {
            mVar.n(i, null);
            if (eVar.F(l10, obj)) {
                mVar.o(i, g.i);
                return 0;
            }
            w wVar = g.f8758k;
            if (mVar.f.getAndSet((i * 2) + 1, wVar) == wVar) {
                return 5;
            }
            mVar.m(i, true);
            return 5;
        }
        return eVar.I(mVar, i, obj, j, obj2, z9);
    }

    public static void u(e eVar) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8745n;
        if ((atomicLongFieldUpdater.addAndGet(eVar, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(eVar) & 4611686018427387904L) != 0) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(long r5, q7.m r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f10355c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            t7.b r0 = r7.c()
            q7.m r0 = (q7.m) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.d()
            if (r5 == 0) goto L22
            t7.b r5 = r7.c()
            q7.m r5 = (q7.m) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = q7.e.f8748q
            java.lang.Object r6 = r5.get(r4)
            t7.s r6 = (t7.s) r6
            long r0 = r6.f10355c
            long r2 = r7.f10355c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.j()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L4a
            boolean r5 = r6.f()
            if (r5 == 0) goto L49
            r6.e()
        L49:
            return
        L4a:
            java.lang.Object r0 = r5.get(r4)
            if (r0 == r6) goto L3a
            boolean r5 = r7.f()
            if (r5 == 0) goto L22
            r7.e()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.e.A(long, q7.m):void");
    }

    public final Object B(Object obj, t6.c cVar) {
        o7.l lVar = new o7.l(1, d0.b.I(cVar));
        lVar.s();
        lVar.resumeWith(new p6.j(s()));
        Object r9 = lVar.r();
        return r9 == u6.a.f10762a ? r9 : p6.x.f8463a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D(q7.m r14, int r15, long r16, v6.c r18) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.e.D(q7.m, int, long, v6.c):java.lang.Object");
    }

    public final void E(c2 c2Var, boolean z9) {
        if (c2Var instanceof o7.j) {
            ((t6.c) c2Var).resumeWith(new p6.j(z9 ? r() : s()));
            return;
        }
        if (c2Var instanceof t) {
            ((t) c2Var).f8780a.resumeWith(new l(new j(q())));
            return;
        }
        if (!(c2Var instanceof b)) {
            if (c2Var instanceof x7.d) {
                ((x7.d) c2Var).c(this, g.f8759l);
                return;
            } else {
                com.google.gson.internal.a.m(c2Var, "Unexpected waiter: ");
                return;
            }
        }
        b bVar = (b) c2Var;
        o7.l lVar = bVar.f8734b;
        lVar.getClass();
        bVar.f8734b = null;
        bVar.f8733a = g.f8759l;
        Throwable q9 = bVar.f8735l.q();
        if (q9 == null) {
            lVar.resumeWith(Boolean.FALSE);
        } else {
            lVar.resumeWith(new p6.j(q9));
        }
    }

    public final boolean F(Object obj, Object obj2) {
        if (obj instanceof x7.d) {
            return ((x7.d) obj).c(this, obj2);
        }
        if (obj instanceof t) {
            return g.a(((t) obj).f8780a, new l(obj2), null);
        }
        if (!(obj instanceof b)) {
            if (obj instanceof o7.j) {
                return g.a((o7.j) obj, obj2, null);
            }
            com.google.gson.internal.a.m(obj, "Unexpected receiver type: ");
            return false;
        }
        b bVar = (b) obj;
        o7.l lVar = bVar.f8734b;
        lVar.getClass();
        bVar.f8734b = null;
        bVar.f8733a = obj2;
        return g.a(lVar, Boolean.TRUE, null);
    }

    public final Object H(m mVar, int i, long j, Object obj) {
        Object l10 = mVar.l(i);
        AtomicReferenceArray atomicReferenceArray = mVar.f;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8742b;
        if (l10 == null) {
            if (j >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return g.f8761n;
                }
                if (mVar.k(i, l10, obj)) {
                    n();
                    return g.f8760m;
                }
            }
        } else if (l10 == g.f8756d && mVar.k(i, l10, g.i)) {
            n();
            Object obj2 = atomicReferenceArray.get(i * 2);
            mVar.n(i, null);
            return obj2;
        }
        while (true) {
            Object l11 = mVar.l(i);
            if (l11 == null || l11 == g.f8757e) {
                if (j < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (mVar.k(i, l11, g.h)) {
                        n();
                        return g.f8762o;
                    }
                } else {
                    if (obj == null) {
                        return g.f8761n;
                    }
                    if (mVar.k(i, l11, obj)) {
                        n();
                        return g.f8760m;
                    }
                }
            } else if (l11 != g.f8756d) {
                w wVar = g.j;
                if (l11 == wVar) {
                    return g.f8762o;
                }
                if (l11 == g.h) {
                    return g.f8762o;
                }
                if (l11 == g.f8759l) {
                    n();
                    return g.f8762o;
                }
                if (l11 != g.g && mVar.k(i, l11, g.f)) {
                    boolean z9 = l11 instanceof v;
                    if (z9) {
                        l11 = ((v) l11).f8781a;
                    }
                    if (G(l11)) {
                        mVar.o(i, g.i);
                        n();
                        Object obj3 = atomicReferenceArray.get(i * 2);
                        mVar.n(i, null);
                        return obj3;
                    }
                    mVar.o(i, wVar);
                    mVar.i();
                    if (z9) {
                        n();
                    }
                    return g.f8762o;
                }
            } else if (mVar.k(i, l11, g.i)) {
                n();
                Object obj4 = atomicReferenceArray.get(i * 2);
                mVar.n(i, null);
                return obj4;
            }
        }
    }

    public final int I(m mVar, int i, Object obj, long j, Object obj2, boolean z9) {
        while (true) {
            Object l10 = mVar.l(i);
            if (l10 == null) {
                if (!g(j) || z9) {
                    if (z9) {
                        if (mVar.k(i, null, g.j)) {
                            mVar.i();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (mVar.k(i, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (mVar.k(i, null, g.f8756d)) {
                    break;
                }
            } else {
                if (l10 != g.f8757e) {
                    w wVar = g.f8758k;
                    if (l10 == wVar) {
                        mVar.n(i, null);
                        return 5;
                    }
                    if (l10 == g.h) {
                        mVar.n(i, null);
                        return 5;
                    }
                    if (l10 == g.f8759l) {
                        mVar.n(i, null);
                        x();
                        return 4;
                    }
                    mVar.n(i, null);
                    if (l10 instanceof v) {
                        l10 = ((v) l10).f8781a;
                    }
                    if (F(l10, obj)) {
                        mVar.o(i, g.i);
                        return 0;
                    }
                    if (mVar.f.getAndSet((i * 2) + 1, wVar) != wVar) {
                        mVar.m(i, true);
                    }
                    return 5;
                }
                if (mVar.k(i, l10, g.f8756d)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void J(long j) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        e eVar = this;
        if (eVar.z()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = f8744m;
            if (atomicLongFieldUpdater.get(eVar) > j) {
                break;
            } else {
                eVar = this;
            }
        }
        int i = g.f8755c;
        int i6 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f8745n;
            if (i6 < i) {
                long j6 = atomicLongFieldUpdater.get(eVar);
                if (j6 == (4611686018427387903L & atomicLongFieldUpdater2.get(eVar)) && j6 == atomicLongFieldUpdater.get(eVar)) {
                    return;
                } else {
                    i6++;
                }
            } else {
                while (true) {
                    long j10 = atomicLongFieldUpdater2.get(eVar);
                    if (atomicLongFieldUpdater2.compareAndSet(eVar, j10, (j10 & 4611686018427387903L) + 4611686018427387904L)) {
                        break;
                    } else {
                        eVar = this;
                    }
                }
                while (true) {
                    long j11 = atomicLongFieldUpdater.get(eVar);
                    long j12 = atomicLongFieldUpdater2.get(eVar);
                    long j13 = j12 & 4611686018427387903L;
                    boolean z9 = (j12 & 4611686018427387904L) != 0;
                    if (j11 == j13 && j11 == atomicLongFieldUpdater.get(eVar)) {
                        break;
                    }
                    if (z9) {
                        eVar = this;
                    } else {
                        eVar = this;
                        atomicLongFieldUpdater2.compareAndSet(eVar, j12, 4611686018427387904L + j13);
                    }
                }
                while (true) {
                    long j14 = atomicLongFieldUpdater2.get(eVar);
                    if (atomicLongFieldUpdater2.compareAndSet(eVar, j14, j14 & 4611686018427387903L)) {
                        return;
                    } else {
                        eVar = this;
                    }
                }
            }
        }
    }

    @Override // q7.i
    public final Object a() {
        m mVar;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8743l;
        long j = atomicLongFieldUpdater.get(this);
        long j6 = f8742b.get(this);
        if (v(j6, true)) {
            return new j(q());
        }
        long j10 = j6 & 1152921504606846975L;
        k kVar = l.f8771b;
        if (j >= j10) {
            return kVar;
        }
        Object obj = g.f8758k;
        m mVar2 = (m) f8747p.get(this);
        while (!w()) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j11 = g.f8754b;
            long j12 = andIncrement / j11;
            int i = (int) (andIncrement % j11);
            if (mVar2.f10355c != j12) {
                m o10 = o(j12, mVar2);
                if (o10 == null) {
                    continue;
                } else {
                    mVar = o10;
                }
            } else {
                mVar = mVar2;
            }
            Object H = H(mVar, i, andIncrement, obj);
            m mVar3 = mVar;
            if (H == g.f8760m) {
                c2 c2Var = obj instanceof c2 ? (c2) obj : null;
                if (c2Var != null) {
                    c2Var.a(mVar3, i);
                }
                J(andIncrement);
                mVar3.i();
                return kVar;
            }
            if (H != g.f8762o) {
                if (H != g.f8761n) {
                    mVar3.b();
                    return H;
                }
                androidx.privacysandbox.ads.adservices.customaudience.a.i("unexpected");
                return null;
            }
            if (andIncrement < t()) {
                mVar3.b();
            }
            mVar2 = mVar3;
        }
        return new j(q());
    }

    @Override // q7.i
    public final void c(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        h(true, cancellationException);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0177, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00c2, code lost:
    
        d(r1, r4, r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0163 A[RETURN] */
    @Override // q7.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(java.lang.Object r23, t6.c r24) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.e.e(java.lang.Object, t6.c):java.lang.Object");
    }

    public final boolean g(long j) {
        return j < f8744m.get(this) || j < f8743l.get(this) + ((long) this.f8751a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c A[LOOP:2: B:17:0x003c->B:39:?, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e A[LOOP:3: B:22:0x006e->B:30:?, LOOP_LABEL: LOOP:3: B:22:0x006e->B:30:?, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004c A[LOOP:5: B:40:0x004c->B:48:?, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x002f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(boolean r13, java.lang.Throwable r14) {
        /*
            r12 = this;
            r0 = 60
            r1 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = q7.e.f8742b
            r9 = 1
            if (r13 == 0) goto L24
        Lc:
            long r5 = r3.get(r12)
            long r7 = r5 >> r0
            int r4 = (int) r7
            if (r4 != 0) goto L24
            long r7 = r5 & r1
            q7.m r4 = q7.g.f8753a
            long r10 = (long) r9
            long r10 = r10 << r0
            long r7 = r7 + r10
            r4 = r12
            boolean r5 = r3.compareAndSet(r4, r5, r7)
            if (r5 == 0) goto Lc
            goto L25
        L24:
            r4 = r12
        L25:
            f8.w r5 = q7.g.f8766s
        L27:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = q7.e.f8749r
            boolean r7 = r6.compareAndSet(r12, r5, r14)
            if (r7 == 0) goto L31
            r10 = r9
            goto L39
        L31:
            java.lang.Object r6 = r6.get(r12)
            if (r6 == r5) goto L27
            r14 = 0
            r10 = r14
        L39:
            r11 = 3
            if (r13 == 0) goto L4c
        L3c:
            long r5 = r3.get(r12)
            long r13 = r5 & r1
            long r7 = (long) r11
            long r7 = r7 << r0
            long r7 = r7 + r13
            boolean r13 = r3.compareAndSet(r4, r5, r7)
            if (r13 == 0) goto L3c
            goto L69
        L4c:
            long r5 = r3.get(r12)
            long r13 = r5 >> r0
            int r13 = (int) r13
            if (r13 == 0) goto L5e
            if (r13 == r9) goto L58
            goto L69
        L58:
            long r13 = r5 & r1
            long r7 = (long) r11
        L5b:
            long r7 = r7 << r0
            long r7 = r7 + r13
            goto L63
        L5e:
            long r13 = r5 & r1
            r7 = 2
            long r7 = (long) r7
            goto L5b
        L63:
            boolean r13 = r3.compareAndSet(r4, r5, r7)
            if (r13 == 0) goto L4c
        L69:
            r12.x()
            if (r10 == 0) goto L98
        L6e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r13 = q7.e.f8750s
            java.lang.Object r14 = r13.get(r12)
            if (r14 != 0) goto L79
            f8.w r0 = q7.g.f8764q
            goto L7b
        L79:
            f8.w r0 = q7.g.f8765r
        L7b:
            boolean r1 = r13.compareAndSet(r12, r14, r0)
            if (r1 == 0) goto L91
            if (r14 != 0) goto L84
            goto L98
        L84:
            kotlin.jvm.internal.a0.b(r9, r14)
            d7.l r14 = (d7.l) r14
            java.lang.Throwable r13 = r12.q()
            r14.invoke(r13)
            return r10
        L91:
            java.lang.Object r1 = r13.get(r12)
            if (r1 == r14) goto L7b
            goto L6e
        L98:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.e.h(boolean, java.lang.Throwable):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x008d, code lost:
    
        r1 = (q7.m) ((t7.b) t7.b.f10321b.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final q7.m i(long r13) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.e.i(long):q7.m");
    }

    @Override // q7.i
    public final b iterator() {
        return new b(this);
    }

    public final void j(long j) {
        m mVar = (m) f8747p.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f8743l;
            long j6 = atomicLongFieldUpdater.get(this);
            if (j < Math.max(this.f8751a + j6, f8744m.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j6, 1 + j6)) {
                long j10 = g.f8754b;
                long j11 = j6 / j10;
                int i = (int) (j6 % j10);
                if (mVar.f10355c != j11) {
                    m o10 = o(j11, mVar);
                    if (o10 != null) {
                        mVar = o10;
                    }
                }
                m mVar2 = mVar;
                if (H(mVar2, i, j6, null) != g.f8762o) {
                    mVar2.b();
                } else if (j6 < t()) {
                    mVar2.b();
                }
                mVar = mVar2;
            }
        }
    }

    @Override // q7.i
    public final Object k(s7.g gVar) {
        return C(this, gVar);
    }

    @Override // q7.i
    public final Object l(t6.c cVar) {
        m mVar;
        Throwable th;
        m mVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8747p;
        m mVar3 = (m) atomicReferenceFieldUpdater.get(this);
        while (!w()) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f8743l;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j = g.f8754b;
            long j6 = andIncrement / j;
            int i = (int) (andIncrement % j);
            if (mVar3.f10355c != j6) {
                m o10 = o(j6, mVar3);
                if (o10 == null) {
                    continue;
                } else {
                    mVar = o10;
                }
            } else {
                mVar = mVar3;
            }
            Object H = H(mVar, i, andIncrement, null);
            w wVar = g.f8760m;
            if (H == wVar) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("unexpected");
                return null;
            }
            w wVar2 = g.f8762o;
            if (H == wVar2) {
                if (andIncrement < t()) {
                    mVar.b();
                }
                mVar3 = mVar;
            } else {
                if (H != g.f8761n) {
                    mVar.b();
                    return H;
                }
                o7.l p10 = c0.p(d0.b.I(cVar));
                e eVar = this;
                try {
                    Object H2 = eVar.H(mVar, i, andIncrement, p10);
                    if (H2 == wVar) {
                        p10.a(mVar, i);
                    } else {
                        if (H2 == wVar2) {
                            if (andIncrement < t()) {
                                mVar.b();
                            }
                            m mVar4 = (m) atomicReferenceFieldUpdater.get(this);
                            while (true) {
                                if (w()) {
                                    p10.resumeWith(new p6.j(r()));
                                    break;
                                }
                                o7.l lVar = p10;
                                try {
                                    long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(this);
                                    long j10 = g.f8754b;
                                    long j11 = andIncrement2 / j10;
                                    int i6 = (int) (andIncrement2 % j10);
                                    if (mVar4.f10355c != j11) {
                                        try {
                                            m o11 = o(j11, mVar4);
                                            if (o11 == null) {
                                                p10 = lVar;
                                            } else {
                                                mVar2 = o11;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            p10 = lVar;
                                            p10.z();
                                            throw th;
                                        }
                                    } else {
                                        mVar2 = mVar4;
                                    }
                                    H2 = eVar.H(mVar2, i6, andIncrement2, lVar);
                                    m mVar5 = mVar2;
                                    p10 = lVar;
                                    if (H2 == g.f8760m) {
                                        p10.a(mVar5, i6);
                                        break;
                                    }
                                    if (H2 == g.f8762o) {
                                        if (andIncrement2 < t()) {
                                            mVar5.b();
                                        }
                                        eVar = this;
                                        mVar4 = mVar5;
                                    } else {
                                        if (H2 == g.f8761n) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        mVar5.b();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    p10 = lVar;
                                    th = th;
                                    p10.z();
                                    throw th;
                                }
                            }
                        } else {
                            mVar.b();
                        }
                        p10.g(H2, null);
                    }
                    return p10.r();
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
        Throwable r9 = r();
        int i10 = t7.t.f10356a;
        throw r9;
    }

    @Override // q7.u
    public final boolean m(Throwable th) {
        return h(false, th);
    }

    public final void n() {
        Object b7;
        if (z()) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8748q;
        m mVar = (m) atomicReferenceFieldUpdater.get(this);
        loop0: while (true) {
            long andIncrement = f8744m.getAndIncrement(this);
            long j = andIncrement / g.f8754b;
            if (t() <= andIncrement) {
                if (mVar.f10355c < j && mVar.c() != null) {
                    A(j, mVar);
                }
                u(this);
                return;
            }
            if (mVar.f10355c != j) {
                f fVar = f.f8752a;
                while (true) {
                    b7 = t7.a.b(mVar, j, fVar);
                    if (!t7.a.e(b7)) {
                        t7.s c9 = t7.a.c(b7);
                        while (true) {
                            t7.s sVar = (t7.s) atomicReferenceFieldUpdater.get(this);
                            if (sVar.f10355c >= c9.f10355c) {
                                break;
                            }
                            if (!c9.j()) {
                                break;
                            }
                            while (!atomicReferenceFieldUpdater.compareAndSet(this, sVar, c9)) {
                                if (atomicReferenceFieldUpdater.get(this) != sVar) {
                                    if (c9.f()) {
                                        c9.e();
                                    }
                                }
                            }
                            if (sVar.f()) {
                                sVar.e();
                            }
                        }
                    } else {
                        break;
                    }
                }
                m mVar2 = null;
                if (t7.a.e(b7)) {
                    x();
                    A(j, mVar);
                    u(this);
                } else {
                    m mVar3 = (m) t7.a.c(b7);
                    long j6 = mVar3.f10355c;
                    if (j6 > j) {
                        long j10 = j6 * g.f8754b;
                        if (f8744m.compareAndSet(this, 1 + andIncrement, j10)) {
                            AtomicLongFieldUpdater atomicLongFieldUpdater = f8745n;
                            if ((atomicLongFieldUpdater.addAndGet(this, j10 - andIncrement) & 4611686018427387904L) != 0) {
                                while ((atomicLongFieldUpdater.get(this) & 4611686018427387904L) != 0) {
                                }
                            }
                        } else {
                            u(this);
                        }
                    } else {
                        mVar2 = mVar3;
                    }
                }
                if (mVar2 == null) {
                    continue;
                } else {
                    mVar = mVar2;
                }
            }
            int i = (int) (andIncrement % g.f8754b);
            Object l10 = mVar.l(i);
            boolean z9 = l10 instanceof c2;
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f8743l;
            if (!z9 || andIncrement < atomicLongFieldUpdater2.get(this) || !mVar.k(i, l10, g.g)) {
                while (true) {
                    Object l11 = mVar.l(i);
                    if (!(l11 instanceof c2)) {
                        if (l11 != g.j) {
                            if (l11 != null) {
                                if (l11 == g.f8756d || l11 == g.h || l11 == g.i || l11 == g.f8758k || l11 == g.f8759l) {
                                    break loop0;
                                } else if (l11 != g.f) {
                                    com.google.gson.internal.a.m(l11, "Unexpected cell state: ");
                                    return;
                                }
                            } else if (mVar.k(i, l11, g.f8757e)) {
                                break loop0;
                            }
                        } else {
                            break;
                        }
                    } else if (andIncrement < atomicLongFieldUpdater2.get(this)) {
                        if (mVar.k(i, l11, new v((c2) l11))) {
                            break loop0;
                        }
                    } else if (mVar.k(i, l11, g.g)) {
                        if (G(l11)) {
                            mVar.o(i, g.f8756d);
                            break;
                        } else {
                            mVar.o(i, g.j);
                            mVar.i();
                        }
                    }
                }
            } else if (G(l10)) {
                mVar.o(i, g.f8756d);
                break;
            } else {
                mVar.o(i, g.j);
                mVar.i();
                u(this);
            }
        }
        u(this);
    }

    public final m o(long j, m mVar) {
        Object b7;
        long j6;
        m mVar2 = g.f8753a;
        f fVar = f.f8752a;
        loop0: while (true) {
            b7 = t7.a.b(mVar, j, fVar);
            if (!t7.a.e(b7)) {
                t7.s c9 = t7.a.c(b7);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8747p;
                    t7.s sVar = (t7.s) atomicReferenceFieldUpdater.get(this);
                    if (sVar.f10355c >= c9.f10355c) {
                        break loop0;
                    }
                    if (!c9.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, sVar, c9)) {
                        if (atomicReferenceFieldUpdater.get(this) != sVar) {
                            if (c9.f()) {
                                c9.e();
                            }
                        }
                    }
                    if (sVar.f()) {
                        sVar.e();
                    }
                }
            } else {
                break;
            }
        }
        if (t7.a.e(b7)) {
            x();
            if (mVar.f10355c * g.f8754b < t()) {
                mVar.b();
                return null;
            }
        } else {
            m mVar3 = (m) t7.a.c(b7);
            long j10 = mVar3.f10355c;
            if (!z() && j <= f8744m.get(this) / g.f8754b) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f8748q;
                    t7.s sVar2 = (t7.s) atomicReferenceFieldUpdater2.get(this);
                    if (sVar2.f10355c >= j10 || !mVar3.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, sVar2, mVar3)) {
                        if (atomicReferenceFieldUpdater2.get(this) != sVar2) {
                            if (mVar3.f()) {
                                mVar3.e();
                            }
                        }
                    }
                    if (sVar2.f()) {
                        sVar2.e();
                    }
                }
            }
            if (j10 <= j) {
                return mVar3;
            }
            long j11 = j10 * g.f8754b;
            do {
                j6 = f8743l.get(this);
                if (j6 >= j11) {
                    break;
                }
            } while (!f8743l.compareAndSet(this, j6, j11));
            if (j10 * g.f8754b < t()) {
                mVar3.b();
            }
        }
        return null;
    }

    @Override // q7.u
    public Object p(Object obj) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8742b;
        boolean z9 = false;
        long j = 1152921504606846975L;
        boolean z10 = v(atomicLongFieldUpdater.get(this), false) ? false : !g(r1 & 1152921504606846975L);
        k kVar = l.f8771b;
        if (z10) {
            return kVar;
        }
        Object obj2 = g.j;
        m mVar = (m) f8746o.get(this);
        while (true) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j6 = andIncrement & j;
            boolean v = v(andIncrement, z9);
            int i = g.f8754b;
            long j10 = i;
            long j11 = j6 / j10;
            int i6 = (int) (j6 % j10);
            if (mVar.f10355c != j11) {
                m b7 = b(this, j11, mVar);
                if (b7 != null) {
                    mVar = b7;
                } else {
                    if (v) {
                        return new j(s());
                    }
                    z9 = false;
                    j = 1152921504606846975L;
                }
            }
            int f = f(this, mVar, i6, obj, j6, obj2, v);
            p6.x xVar = p6.x.f8463a;
            if (f == 0) {
                mVar.b();
                return xVar;
            }
            if (f == 1) {
                return xVar;
            }
            if (f == 2) {
                if (v) {
                    mVar.i();
                    return new j(s());
                }
                c2 c2Var = obj2 instanceof c2 ? (c2) obj2 : null;
                if (c2Var != null) {
                    c2Var.a(mVar, i6 + i);
                }
                mVar.i();
                return kVar;
            }
            if (f == 3) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("unexpected");
                return null;
            }
            if (f == 4) {
                if (j6 < f8743l.get(this)) {
                    mVar.b();
                }
                return new j(s());
            }
            if (f == 5) {
                mVar.b();
            }
            z9 = false;
            j = 1152921504606846975L;
        }
    }

    public final Throwable q() {
        return (Throwable) f8749r.get(this);
    }

    public final Throwable r() {
        Throwable q9 = q();
        return q9 == null ? new n("Channel was closed") : q9;
    }

    public final Throwable s() {
        Throwable q9 = q();
        return q9 == null ? new j1.b("Channel was closed") : q9;
    }

    public final long t() {
        return f8742b.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x01b9, code lost:
    
        r16 = r7;
        r3 = (q7.m) r3.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01c2, code lost:
    
        if (r3 != null) goto L96;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.e.toString():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x00a2, code lost:
    
        r0 = (q7.m) ((t7.b) t7.b.f10321b.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean v(long r14, boolean r16) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.e.v(long, boolean):boolean");
    }

    public final boolean w() {
        return v(f8742b.get(this), true);
    }

    public final boolean x() {
        return v(f8742b.get(this), false);
    }

    public boolean y() {
        return false;
    }

    public final boolean z() {
        long j = f8744m.get(this);
        return j == 0 || j == LocationRequestCompat.PASSIVE_INTERVAL;
    }
}
