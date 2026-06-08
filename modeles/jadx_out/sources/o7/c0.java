package o7;

import androidx.core.location.LocationRequestCompat;
import androidx.room.coroutines.ConnectionPoolImpl$acquireWithTimeout$2;
import com.google.android.gms.internal.measurement.i5;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final f8.w f8243a = new f8.w("RESUME_TOKEN");

    /* renamed from: b, reason: collision with root package name */
    public static final f8.w f8244b = new f8.w("REMOVED_TASK");

    /* renamed from: c, reason: collision with root package name */
    public static final f8.w f8245c = new f8.w("CLOSED_EMPTY");

    /* renamed from: d, reason: collision with root package name */
    public static final f8.w f8246d = new f8.w("COMPLETING_ALREADY");

    /* renamed from: e, reason: collision with root package name */
    public static final f8.w f8247e = new f8.w("COMPLETING_WAITING_CHILDREN");
    public static final f8.w f = new f8.w("COMPLETING_RETRY");
    public static final f8.w g = new f8.w("TOO_LATE_TO_CANCEL");
    public static final f8.w h = new f8.w("SEALED");
    public static final q0 i = new q0(false);
    public static final q0 j = new q0(true);

    public static final Object A(Object obj) {
        b1 b1Var;
        c1 c1Var = obj instanceof c1 ? (c1) obj : null;
        return (c1Var == null || (b1Var = c1Var.f8248a) == null) ? obj : b1Var;
    }

    public static final a2 B(t6.c cVar, t6.h hVar, Object obj) {
        a2 a2Var = null;
        if ((cVar instanceof v6.d) && hVar.get(b2.f8238a) != null) {
            v6.d dVar = (v6.d) cVar;
            while (true) {
                if ((dVar instanceof j0) || (dVar = dVar.getCallerFrame()) == null) {
                    break;
                }
                if (dVar instanceof a2) {
                    a2Var = (a2) dVar;
                    break;
                }
            }
            if (a2Var != null) {
                a2Var.h0(hVar, obj);
            }
        }
        return a2Var;
    }

    public static final Object C(d7.p pVar, t6.h hVar, t6.c cVar) {
        t6.h context = cVar.getContext();
        t6.h plus = !((Boolean) hVar.fold(Boolean.FALSE, new c4.j1(9))).booleanValue() ? context.plus(hVar) : l(context, hVar, false);
        k(plus);
        if (plus == context) {
            t7.r rVar = new t7.r(cVar, plus);
            return t0.f.J(rVar, rVar, pVar);
        }
        t6.d dVar = t6.d.f10313a;
        if (kotlin.jvm.internal.l.a(plus.get(dVar), context.get(dVar))) {
            a2 a2Var = new a2(cVar, plus);
            t6.h hVar2 = a2Var.f8229l;
            Object l10 = t7.a.l(hVar2, null);
            try {
                return t0.f.J(a2Var, a2Var, pVar);
            } finally {
                t7.a.g(hVar2, l10);
            }
        }
        j0 j0Var = new j0(cVar, plus);
        try {
            t7.a.h(p6.x.f8463a, d0.b.I(d0.b.B(pVar, j0Var, j0Var)));
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = j0.f8268n;
            do {
                int i6 = atomicIntegerFieldUpdater.get(j0Var);
                if (i6 != 0) {
                    if (i6 != 2) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("Already suspended");
                        return null;
                    }
                    Object A = A(m1.f8289a.get(j0Var));
                    if (A instanceof u) {
                        throw ((u) A).f8315a;
                    }
                    return A;
                }
            } while (!atomicIntegerFieldUpdater.compareAndSet(j0Var, 0, 1));
            return u6.a.f10762a;
        } catch (Throwable th) {
            j0Var.resumeWith(new p6.j(th));
            throw th;
        }
    }

    public static final Object D(long j6, ConnectionPoolImpl$acquireWithTimeout$2 connectionPoolImpl$acquireWithTimeout$2, t6.c cVar) {
        long j10;
        int i6 = m7.a.f7657m;
        boolean z9 = j6 > 0;
        if (z9) {
            long f10 = m7.a.f(j6, i5.O(999999L, m7.c.NANOSECONDS));
            j10 = ((((int) f10) & 1) != 1 || m7.a.e(f10)) ? m7.a.g(f10, m7.c.MILLISECONDS) : f10 >> 1;
        } else {
            if (z9) {
                com.google.gson.internal.a.b();
                return null;
            }
            j10 = 0;
        }
        if (j10 > 0) {
            return y(new x1(j10, cVar), connectionPoolImpl$acquireWithTimeout$2);
        }
        throw new w1("Timed out immediately", null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object E(long r5, d7.p r7, v6.c r8) {
        /*
            boolean r0 = r8 instanceof o7.y1
            if (r0 == 0) goto L13
            r0 = r8
            o7.y1 r0 = (o7.y1) r0
            int r1 = r0.f8332l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8332l = r1
            goto L18
        L13:
            o7.y1 r0 = new o7.y1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f8331b
            int r1 = r0.f8332l
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            kotlin.jvm.internal.x r5 = r0.f8330a
            p6.a.e(r8)     // Catch: o7.w1 -> L27
            return r8
        L27:
            r6 = move-exception
            goto L56
        L29:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            r5 = 0
            return r5
        L30:
            p6.a.e(r8)
            r3 = 0
            int r8 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r8 > 0) goto L3a
            goto L5c
        L3a:
            kotlin.jvm.internal.x r8 = new kotlin.jvm.internal.x
            r8.<init>()
            r0.f8330a = r8     // Catch: o7.w1 -> L54
            r0.f8332l = r2     // Catch: o7.w1 -> L54
            o7.x1 r1 = new o7.x1     // Catch: o7.w1 -> L54
            r1.<init>(r5, r0)     // Catch: o7.w1 -> L54
            r8.f7024a = r1     // Catch: o7.w1 -> L54
            java.lang.Object r5 = y(r1, r7)     // Catch: o7.w1 -> L54
            u6.a r6 = u6.a.f10762a
            if (r5 != r6) goto L53
            return r6
        L53:
            return r5
        L54:
            r6 = move-exception
            r5 = r8
        L56:
            o7.e1 r7 = r6.f8325a
            java.lang.Object r5 = r5.f7024a
            if (r7 != r5) goto L5e
        L5c:
            r5 = 0
            return r5
        L5e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.c0.E(long, d7.p, v6.c):java.lang.Object");
    }

    public static r a() {
        r rVar = new r(true);
        rVar.M(null);
        return rVar;
    }

    public static final t7.c b(t6.h hVar) {
        if (hVar.get(x.f8327b) == null) {
            hVar = hVar.plus(c());
        }
        return new t7.c(hVar);
    }

    public static g1 c() {
        return new g1(null);
    }

    public static u1 d() {
        return new u1(null);
    }

    public static g0 e(a0 a0Var, d7.p pVar) {
        g0 g0Var = new g0(t(a0Var, t6.i.f10314a), true);
        g0Var.f0(b0.f8233a, g0Var, pVar);
        return g0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object f(f0[] f0VarArr, v6.i iVar) {
        if (f0VarArr.length == 0) {
            return q6.t.f8724a;
        }
        e eVar = new e(f0VarArr);
        l lVar = new l(1, d0.b.I(iVar));
        lVar.s();
        int length = f0VarArr.length;
        c[] cVarArr = new c[length];
        for (int i6 = 0; i6 < length; i6++) {
            p1 p1Var = f0VarArr[i6];
            ((m1) p1Var).start();
            c cVar = new c(eVar, lVar);
            cVar.f8241o = r(p1Var, true, cVar);
            cVarArr[i6] = cVar;
        }
        d dVar = new d(cVarArr);
        for (int i10 = 0; i10 < length; i10++) {
            c cVar2 = cVarArr[i10];
            cVar2.getClass();
            c.f8239q.set(cVar2, dVar);
        }
        if (l.f8278p.get(lVar) instanceof r1) {
            lVar.v(dVar);
        } else {
            dVar.b();
        }
        return lVar.r();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void g(v6.c r4) {
        /*
            boolean r0 = r4 instanceof o7.i0
            if (r0 == 0) goto L13
            r0 = r4
            o7.i0 r0 = (o7.i0) r0
            int r1 = r0.f8266b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8266b = r1
            goto L18
        L13:
            o7.i0 r0 = new o7.i0
            r0.<init>(r4)
        L18:
            java.lang.Object r4 = r0.f8265a
            int r1 = r0.f8266b
            r2 = 1
            if (r1 == 0) goto L2b
            if (r1 == r2) goto L27
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r4)
            return
        L27:
            p6.a.e(r4)
            goto L45
        L2b:
            p6.a.e(r4)
            r0.f8266b = r2
            o7.l r4 = new o7.l
            t6.c r0 = d0.b.I(r0)
            r4.<init>(r2, r0)
            r4.s()
            java.lang.Object r4 = r4.r()
            u6.a r0 = u6.a.f10762a
            if (r4 != r0) goto L45
            return
        L45:
            a1.b r4 = new a1.b
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.c0.g(v6.c):void");
    }

    public static void h(a0 a0Var) {
        e1 e1Var = (e1) a0Var.getCoroutineContext().get(x.f8327b);
        if (e1Var != null) {
            e1Var.c(null);
        } else {
            com.google.gson.internal.a.m(a0Var, "Scope cannot be cancelled because it does not have a job: ");
        }
    }

    public static final Object i(d7.p pVar, t6.c cVar) {
        t7.r rVar = new t7.r(cVar, cVar.getContext());
        return t0.f.J(rVar, rVar, pVar);
    }

    public static final Object j(long j6, t6.c cVar) {
        if (j6 > 0) {
            l lVar = new l(1, d0.b.I(cVar));
            lVar.s();
            if (j6 < LocationRequestCompat.PASSIVE_INTERVAL) {
                n(lVar.f8281n).i(j6, lVar);
            }
            Object r9 = lVar.r();
            if (r9 == u6.a.f10762a) {
                return r9;
            }
        }
        return p6.x.f8463a;
    }

    public static final void k(t6.h hVar) {
        e1 e1Var = (e1) hVar.get(x.f8327b);
        if (e1Var != null && !e1Var.b()) {
            throw e1Var.j();
        }
    }

    public static final t6.h l(t6.h hVar, t6.h hVar2, boolean z9) {
        Boolean bool = Boolean.FALSE;
        boolean booleanValue = ((Boolean) hVar.fold(bool, new c4.j1(9))).booleanValue();
        boolean booleanValue2 = ((Boolean) hVar2.fold(bool, new c4.j1(9))).booleanValue();
        if (!booleanValue && !booleanValue2) {
            return hVar.plus(hVar2);
        }
        c4.j1 j1Var = new c4.j1(10);
        t6.i iVar = t6.i.f10314a;
        t6.h hVar3 = (t6.h) hVar.fold(iVar, j1Var);
        Object obj = hVar2;
        if (booleanValue2) {
            obj = hVar2.fold(iVar, new c4.j1(11));
        }
        return hVar3.plus((t6.h) obj);
    }

    public static final w m(Executor executor) {
        l0 l0Var = executor instanceof l0 ? (l0) executor : null;
        return l0Var != null ? l0Var.f8282a : new y0(executor);
    }

    public static final h0 n(t6.h hVar) {
        t6.f fVar = hVar.get(t6.d.f10313a);
        h0 h0Var = fVar instanceof h0 ? (h0) fVar : null;
        return h0Var == null ? e0.f8257a : h0Var;
    }

    public static final String o(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final l p(t6.c cVar) {
        l lVar;
        l lVar2;
        if (!(cVar instanceof t7.f)) {
            return new l(1, cVar);
        }
        t7.f fVar = (t7.f) cVar;
        f8.w wVar = t7.a.f10317c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = t7.f.f10325q;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(fVar);
            lVar = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(fVar, wVar);
                lVar2 = null;
                break;
            }
            if (obj instanceof l) {
                while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, wVar)) {
                    if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                        break;
                    }
                }
                lVar2 = (l) obj;
                break loop0;
            }
            if (obj != wVar && !(obj instanceof Throwable)) {
                com.google.gson.internal.a.m(obj, "Inconsistent state ");
                return null;
            }
        }
        if (lVar2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = l.f8278p;
            Object obj2 = atomicReferenceFieldUpdater2.get(lVar2);
            if (!(obj2 instanceof t) || ((t) obj2).f8310d == null) {
                l.f8277o.set(lVar2, 536870911);
                atomicReferenceFieldUpdater2.set(lVar2, b.f8232a);
                lVar = lVar2;
            } else {
                lVar2.m();
            }
            if (lVar != null) {
                return lVar;
            }
        }
        return new l(2, cVar);
    }

    public static final void q(Throwable th, t6.h hVar) {
        try {
            y yVar = (y) hVar.get(x.f8326a);
            if (yVar != null) {
                yVar.n(th);
            } else {
                t7.a.d(th, hVar);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                p6.a.a(runtimeException, th);
                th = runtimeException;
            }
            t7.a.d(th, hVar);
        }
    }

    public static final o0 r(e1 e1Var, boolean z9, i1 i1Var) {
        return e1Var instanceof m1 ? ((m1) e1Var).N(z9, i1Var) : e1Var.u(i1Var.j(), z9, new h1(1, i1Var, i1.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0));
    }

    public static s1 s(a0 a0Var, t6.h hVar, b0 b0Var, d7.p pVar, int i6) {
        if ((i6 & 1) != 0) {
            hVar = t6.i.f10314a;
        }
        if ((i6 & 2) != 0) {
            b0Var = b0.f8233a;
        }
        t6.h t9 = t(a0Var, hVar);
        b0Var.getClass();
        s1 n1Var = b0Var == b0.f8234b ? new n1(t9, pVar) : new s1(t9, true);
        n1Var.f0(b0Var, n1Var, pVar);
        return n1Var;
    }

    public static final t6.h t(a0 a0Var, t6.h hVar) {
        t6.h l10 = l(a0Var.getCoroutineContext(), hVar, true);
        v7.e eVar = m0.f8288a;
        return (l10 == eVar || l10.get(t6.d.f10313a) != null) ? l10 : l10.plus(eVar);
    }

    public static final Object u(Object obj) {
        return obj instanceof u ? p6.a.b(((u) obj).f8315a) : obj;
    }

    public static final void v(l lVar, t6.c cVar, boolean z9) {
        Object obj = l.f8278p.get(lVar);
        Throwable d10 = lVar.d(obj);
        Object jVar = d10 != null ? new p6.j(d10) : lVar.e(obj);
        if (!z9) {
            cVar.resumeWith(jVar);
            return;
        }
        cVar.getClass();
        t7.f fVar = (t7.f) cVar;
        t6.c cVar2 = fVar.f10327n;
        Object obj2 = fVar.f10329p;
        t6.h context = cVar2.getContext();
        Object l10 = t7.a.l(context, obj2);
        a2 B = l10 != t7.a.f10318d ? B(cVar2, context, l10) : null;
        try {
            cVar2.resumeWith(jVar);
            if (B == null || B.g0()) {
                t7.a.g(context, l10);
            }
        } catch (Throwable th) {
            if (B == null || B.g0()) {
                t7.a.g(context, l10);
            }
            throw th;
        }
    }

    public static final Object w(t6.h hVar, d7.p pVar) {
        r0 r0Var;
        t6.h l10;
        Thread currentThread = Thread.currentThread();
        t6.g gVar = t6.d.f10313a;
        t6.e eVar = (t6.e) hVar.get(gVar);
        t6.i iVar = t6.i.f10314a;
        if (eVar == null) {
            r0Var = v1.a();
            l10 = l(iVar, hVar.plus(r0Var), true);
            v7.e eVar2 = m0.f8288a;
            if (l10 != eVar2 && l10.get(gVar) == null) {
                l10 = l10.plus(eVar2);
            }
        } else {
            if (eVar instanceof r0) {
            }
            r0Var = (r0) v1.f8321a.get();
            l10 = l(iVar, hVar, true);
            v7.e eVar3 = m0.f8288a;
            if (l10 != eVar3 && l10.get(gVar) == null) {
                l10 = l10.plus(eVar3);
            }
        }
        f fVar = new f(l10, currentThread, r0Var);
        fVar.f0(b0.f8233a, fVar, pVar);
        r0 r0Var2 = fVar.f8259n;
        if (r0Var2 != null) {
            int i6 = r0.f8301m;
            r0Var2.A(false);
        }
        while (!Thread.interrupted()) {
            try {
                long B = r0Var2 != null ? r0Var2.B() : LocationRequestCompat.PASSIVE_INTERVAL;
                if (fVar.O()) {
                    if (r0Var2 != null) {
                        int i10 = r0.f8301m;
                        r0Var2.y(false);
                    }
                    Object A = A(m1.f8289a.get(fVar));
                    u uVar = A instanceof u ? (u) A : null;
                    if (uVar == null) {
                        return A;
                    }
                    throw uVar.f8315a;
                }
                LockSupport.parkNanos(fVar, B);
            } catch (Throwable th) {
                if (r0Var2 != null) {
                    int i11 = r0.f8301m;
                    r0Var2.y(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        fVar.x(interruptedException);
        throw interruptedException;
    }

    public static final Object y(x1 x1Var, d7.p pVar) {
        Object uVar;
        Object R;
        r(x1Var, true, new p0(n(x1Var.f10353m.getContext()).e(x1Var.f8328n, x1Var, x1Var.f8229l), 0));
        try {
            if (pVar instanceof v6.a) {
                kotlin.jvm.internal.a0.b(2, pVar);
                uVar = pVar.invoke(x1Var, x1Var);
            } else {
                uVar = d0.b.Q(pVar, x1Var, x1Var);
            }
        } catch (Throwable th) {
            uVar = new u(false, th);
        }
        u6.a aVar = u6.a.f10762a;
        if (uVar == aVar || (R = x1Var.R(uVar)) == f8247e) {
            return aVar;
        }
        if (R instanceof u) {
            Throwable th2 = ((u) R).f8315a;
            if (!(th2 instanceof w1)) {
                throw th2;
            }
            if (((w1) th2).f8325a != x1Var) {
                throw th2;
            }
            if (uVar instanceof u) {
                throw ((u) uVar).f8315a;
            }
        } else {
            uVar = A(R);
        }
        return uVar;
    }

    public static final String z(t6.c cVar) {
        Object jVar;
        if (cVar instanceof t7.f) {
            return ((t7.f) cVar).toString();
        }
        try {
            jVar = cVar + '@' + o(cVar);
        } catch (Throwable th) {
            jVar = new p6.j(th);
        }
        if (p6.k.a(jVar) != null) {
            jVar = cVar.getClass().getName() + '@' + o(cVar);
        }
        return (String) jVar;
    }
}
