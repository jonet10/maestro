package o7;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class l extends k0 implements j, v6.d, c2 {

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f8277o = AtomicIntegerFieldUpdater.newUpdater(l.class, "_decisionAndIndex$volatile");

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8278p = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_state$volatile");

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8279q = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: m, reason: collision with root package name */
    public final t6.c f8280m;

    /* renamed from: n, reason: collision with root package name */
    public final t6.h f8281n;

    public l(int i, t6.c cVar) {
        super(i);
        this.f8280m = cVar;
        this.f8281n = cVar.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = b.f8232a;
    }

    public static Object D(r1 r1Var, Object obj, int i, d7.q qVar) {
        if (obj instanceof u) {
            return obj;
        }
        if (i != 1 && i != 2) {
            return obj;
        }
        if (qVar != null || (r1Var instanceof i)) {
            return new t(obj, r1Var instanceof i ? (i) r1Var : null, qVar, (Throwable) null, 16);
        }
        return obj;
    }

    public static void x(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public final void A(d7.l lVar, Object obj) {
        B(obj, this.f8272l, new k(lVar, 0));
    }

    public final void B(Object obj, int i, d7.q qVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8278p;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof r1) {
                Object D = D((r1) obj2, obj, i, qVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, D)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!w()) {
                    m();
                }
                n(i);
                return;
            }
            if (obj2 instanceof m) {
                m mVar = (m) obj2;
                if (m.f8287c.compareAndSet(mVar, 0, 1)) {
                    if (qVar != null) {
                        k(qVar, mVar.f8315a, obj);
                        return;
                    }
                    return;
                }
            }
            com.google.gson.internal.a.m(obj, "Already resumed, but proposed with update ");
            return;
        }
    }

    public final void C(w wVar) {
        t6.c cVar = this.f8280m;
        t7.f fVar = cVar instanceof t7.f ? (t7.f) cVar : null;
        B(p6.x.f8463a, (fVar != null ? fVar.f10326m : null) == wVar ? 4 : this.f8272l, null);
    }

    public final f8.w E(Object obj, d7.q qVar) {
        f8.w wVar = c0.f8243a;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8278p;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof r1)) {
                return null;
            }
            Object D = D((r1) obj2, obj, this.f8272l, qVar);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, D)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    break;
                }
            }
            if (!w()) {
                m();
            }
            return wVar;
        }
    }

    @Override // o7.c2
    public final void a(t7.s sVar, int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i6;
        do {
            atomicIntegerFieldUpdater = f8277o;
            i6 = atomicIntegerFieldUpdater.get(this);
            if ((i6 & 536870911) != 536870911) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("invokeOnCancellation should be called at most once");
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, ((i6 >> 29) << 29) + i));
        v(sVar);
    }

    @Override // o7.k0
    public final void b(CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8278p;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof r1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("Not completed");
                return;
            }
            if (obj instanceof u) {
                return;
            }
            if (!(obj instanceof t)) {
                cancellationException2 = cancellationException;
                t tVar = new t(obj, (i) null, (d7.q) null, cancellationException2, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, tVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            t tVar2 = (t) obj;
            if (tVar2.f8311e != null) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("Must be called at most once");
                return;
            }
            t a8 = t.a(tVar2, null, cancellationException, 15);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, a8)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    cancellationException2 = cancellationException;
                }
            }
            i iVar = tVar2.f8308b;
            if (iVar != null) {
                j(iVar, cancellationException);
            }
            d7.q qVar = tVar2.f8309c;
            if (qVar != null) {
                k(qVar, cancellationException, tVar2.f8307a);
                return;
            }
            return;
            cancellationException = cancellationException2;
        }
    }

    @Override // o7.k0
    public final t6.c c() {
        return this.f8280m;
    }

    @Override // o7.k0
    public final Throwable d(Object obj) {
        Throwable d10 = super.d(obj);
        if (d10 != null) {
            return d10;
        }
        return null;
    }

    @Override // o7.k0
    public final Object e(Object obj) {
        return obj instanceof t ? ((t) obj).f8307a : obj;
    }

    @Override // o7.j
    public final void g(Object obj, d7.q qVar) {
        B(obj, this.f8272l, qVar);
    }

    @Override // v6.d
    public final v6.d getCallerFrame() {
        t6.c cVar = this.f8280m;
        if (cVar instanceof v6.d) {
            return (v6.d) cVar;
        }
        return null;
    }

    @Override // t6.c
    public final t6.h getContext() {
        return this.f8281n;
    }

    @Override // o7.k0
    public final Object h() {
        return f8278p.get(this);
    }

    @Override // o7.j
    public final f8.w i(Object obj, d7.q qVar) {
        return E(obj, qVar);
    }

    public final void j(i iVar, Throwable th) {
        try {
            iVar.a(th);
        } catch (Throwable th2) {
            c0.q(new a1.b("Exception in invokeOnCancellation handler for " + this, th2), this.f8281n);
        }
    }

    public final void k(d7.q qVar, Throwable th, Object obj) {
        t6.h hVar = this.f8281n;
        try {
            qVar.invoke(th, obj, hVar);
        } catch (Throwable th2) {
            c0.q(new a1.b("Exception in resume onCancellation handler for " + this, th2), hVar);
        }
    }

    public final void l(t7.s sVar, Throwable th) {
        t6.h hVar = this.f8281n;
        int i = f8277o.get(this) & 536870911;
        if (i == 536870911) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("The index for Segment.onCancellation(..) is broken");
            return;
        }
        try {
            sVar.h(i, hVar);
        } catch (Throwable th2) {
            c0.q(new a1.b("Exception in invokeOnCancellation handler for " + this, th2), hVar);
        }
    }

    public final void m() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8279q;
        o0 o0Var = (o0) atomicReferenceFieldUpdater.get(this);
        if (o0Var == null) {
            return;
        }
        o0Var.dispose();
        atomicReferenceFieldUpdater.set(this, q1.f8300a);
    }

    public final void n(int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i6;
        do {
            atomicIntegerFieldUpdater = f8277o;
            i6 = atomicIntegerFieldUpdater.get(this);
            int i10 = i6 >> 29;
            if (i10 != 0) {
                if (i10 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("Already resumed");
                    return;
                }
                boolean z9 = i == 4;
                t6.c cVar = this.f8280m;
                if (!z9 && (cVar instanceof t7.f)) {
                    boolean z10 = i == 1 || i == 2;
                    int i11 = this.f8272l;
                    if (z10 == (i11 == 1 || i11 == 2)) {
                        t7.f fVar = (t7.f) cVar;
                        w wVar = fVar.f10326m;
                        t6.h context = fVar.f10327n.getContext();
                        if (wVar.isDispatchNeeded(context)) {
                            wVar.dispatch(context, this);
                            return;
                        }
                        r0 a8 = v1.a();
                        if (a8.f8302a >= 4294967296L) {
                            a8.z(this);
                            return;
                        }
                        a8.A(true);
                        try {
                            c0.v(this, cVar, true);
                            do {
                            } while (a8.C());
                        } finally {
                            try {
                                return;
                            } finally {
                            }
                        }
                        return;
                    }
                }
                c0.v(this, cVar, z9);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, BasicMeasure.EXACTLY + (536870911 & i6)));
    }

    @Override // o7.j
    public final boolean o(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8278p;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof r1)) {
                return false;
            }
            m mVar = new m(this, th, (obj instanceof i) || (obj instanceof t7.s));
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, mVar)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            r1 r1Var = (r1) obj;
            if (r1Var instanceof i) {
                j((i) obj, th);
            } else if (r1Var instanceof t7.s) {
                l((t7.s) obj, th);
            }
            if (!w()) {
                m();
            }
            n(this.f8272l);
            return true;
        }
    }

    public Throwable p(m1 m1Var) {
        return m1Var.j();
    }

    @Override // o7.j
    public final void q(Object obj) {
        n(this.f8272l);
    }

    public final Object r() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        e1 e1Var;
        boolean w2 = w();
        do {
            atomicIntegerFieldUpdater = f8277o;
            i = atomicIntegerFieldUpdater.get(this);
            int i6 = i >> 29;
            if (i6 != 0) {
                if (i6 != 2) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("Already suspended");
                    return null;
                }
                if (w2) {
                    z();
                }
                Object obj = f8278p.get(this);
                if (obj instanceof u) {
                    throw ((u) obj).f8315a;
                }
                int i10 = this.f8272l;
                if ((i10 != 1 && i10 != 2) || (e1Var = (e1) this.f8281n.get(x.f8327b)) == null || e1Var.b()) {
                    return e(obj);
                }
                CancellationException j = e1Var.j();
                b(j);
                throw j;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 536870912 + (536870911 & i)));
        if (((o0) f8279q.get(this)) == null) {
            t();
        }
        if (w2) {
            z();
        }
        return u6.a.f10762a;
    }

    @Override // t6.c
    public final void resumeWith(Object obj) {
        Throwable a8 = p6.k.a(obj);
        if (a8 != null) {
            obj = new u(false, a8);
        }
        B(obj, this.f8272l, null);
    }

    public final void s() {
        o0 t9 = t();
        if (t9 == null || (f8278p.get(this) instanceof r1)) {
            return;
        }
        t9.dispose();
        f8279q.set(this, q1.f8300a);
    }

    public final o0 t() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        e1 e1Var = (e1) this.f8281n.get(x.f8327b);
        if (e1Var == null) {
            return null;
        }
        o0 r9 = c0.r(e1Var, true, new n(this, 0));
        do {
            atomicReferenceFieldUpdater = f8279q;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, r9)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return r9;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(y());
        sb.append('(');
        sb.append(c0.z(this.f8280m));
        sb.append("){");
        Object obj = f8278p.get(this);
        sb.append(obj instanceof r1 ? "Active" : obj instanceof m ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(c0.o(this));
        return sb.toString();
    }

    public final void u(d7.l lVar) {
        v(new h(lVar, 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00aa, code lost:
    
        x(r8, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ad, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(o7.r1 r8) {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = o7.l.f8278p
            java.lang.Object r2 = r0.get(r7)
            boolean r1 = r2 instanceof o7.b
            if (r1 == 0) goto L19
        La:
            boolean r1 = r0.compareAndSet(r7, r2, r8)
            if (r1 == 0) goto L12
            goto La1
        L12:
            java.lang.Object r1 = r0.get(r7)
            if (r1 == r2) goto La
            goto L0
        L19:
            boolean r1 = r2 instanceof o7.i
            r3 = 0
            if (r1 != 0) goto Laa
            boolean r1 = r2 instanceof t7.s
            if (r1 != 0) goto Laa
            boolean r1 = r2 instanceof o7.u
            if (r1 == 0) goto L50
            r0 = r2
            o7.u r0 = (o7.u) r0
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = o7.u.f8314b
            r4 = 0
            r5 = 1
            boolean r1 = r1.compareAndSet(r0, r4, r5)
            if (r1 == 0) goto L4c
            boolean r1 = r2 instanceof o7.m
            if (r1 == 0) goto La1
            java.lang.Throwable r0 = r0.f8315a
            boolean r1 = r8 instanceof o7.i
            if (r1 == 0) goto L43
            o7.i r8 = (o7.i) r8
            r7.j(r8, r0)
            return
        L43:
            r8.getClass()
            t7.s r8 = (t7.s) r8
            r7.l(r8, r0)
            return
        L4c:
            x(r8, r2)
            throw r3
        L50:
            boolean r1 = r2 instanceof o7.t
            if (r1 == 0) goto L87
            r1 = r2
            o7.t r1 = (o7.t) r1
            o7.i r4 = r1.f8308b
            if (r4 != 0) goto L83
            boolean r4 = r8 instanceof t7.s
            if (r4 == 0) goto L60
            return
        L60:
            r8.getClass()
            r4 = r8
            o7.i r4 = (o7.i) r4
            java.lang.Throwable r5 = r1.f8311e
            if (r5 == 0) goto L6e
            r7.j(r4, r5)
            return
        L6e:
            r5 = 29
            o7.t r1 = o7.t.a(r1, r4, r3, r5)
        L74:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto L7b
            goto La1
        L7b:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto L74
            goto L0
        L83:
            x(r8, r2)
            throw r3
        L87:
            boolean r1 = r8 instanceof t7.s
            if (r1 == 0) goto L8c
            return
        L8c:
            r8.getClass()
            r3 = r8
            o7.i r3 = (o7.i) r3
            o7.t r1 = new o7.t
            r5 = 0
            r6 = 28
            r4 = 0
            r1.<init>(r2, r3, r4, r5, r6)
        L9b:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto La2
        La1:
            return
        La2:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto L9b
            goto L0
        Laa:
            x(r8, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.l.v(o7.r1):void");
    }

    public final boolean w() {
        if (this.f8272l == 2) {
            return t7.f.f10325q.get((t7.f) this.f8280m) != null;
        }
        return false;
    }

    public String y() {
        return "CancellableContinuation";
    }

    public final void z() {
        t6.c cVar = this.f8280m;
        Throwable th = null;
        t7.f fVar = cVar instanceof t7.f ? (t7.f) cVar : null;
        if (fVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = t7.f.f10325q;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(fVar);
                f8.w wVar = t7.a.f10317c;
                if (obj == wVar) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(fVar, wVar, this)) {
                        if (atomicReferenceFieldUpdater.get(fVar) != wVar) {
                            break;
                        }
                    }
                    break loop0;
                } else {
                    if (!(obj instanceof Throwable)) {
                        com.google.gson.internal.a.m(obj, "Inconsistent state ");
                        return;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                            com.google.gson.internal.a.p("Failed requirement.");
                            return;
                        }
                    }
                    th = (Throwable) obj;
                }
            }
            if (th == null) {
                return;
            }
            m();
            o(th);
        }
    }
}
