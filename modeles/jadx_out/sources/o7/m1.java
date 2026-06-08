package o7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class m1 implements e1 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8289a = AtomicReferenceFieldUpdater.newUpdater(m1.class, Object.class, "_state$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8290b = AtomicReferenceFieldUpdater.newUpdater(m1.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    public m1(boolean z9) {
        this._state$volatile = z9 ? c0.j : c0.i;
    }

    public static p T(t7.j jVar) {
        while (jVar.h()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = t7.j.f10339b;
            t7.j e10 = jVar.e();
            if (e10 == null) {
                Object obj = atomicReferenceFieldUpdater.get(jVar);
                while (true) {
                    jVar = (t7.j) obj;
                    if (!jVar.h()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(jVar);
                }
            } else {
                jVar = e10;
            }
        }
        while (true) {
            jVar = jVar.g();
            if (!jVar.h()) {
                if (jVar instanceof p) {
                    return (p) jVar;
                }
                if (jVar instanceof o1) {
                    return null;
                }
            }
        }
    }

    public static String a0(Object obj) {
        if (!(obj instanceof l1)) {
            return obj instanceof b1 ? ((b1) obj).b() ? "Active" : "New" : obj instanceof u ? "Cancelled" : "Completed";
        }
        l1 l1Var = (l1) obj;
        return l1Var.e() ? "Cancelling" : l1.f8283b.get(l1Var) != 0 ? "Completing" : "Active";
    }

    public String A() {
        return "Job was cancelled";
    }

    public boolean B(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return x(th) && H();
    }

    public final void C(b1 b1Var, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8290b;
        o oVar = (o) atomicReferenceFieldUpdater.get(this);
        if (oVar != null) {
            oVar.dispose();
            atomicReferenceFieldUpdater.set(this, q1.f8300a);
        }
        a1.b bVar = null;
        u uVar = obj instanceof u ? (u) obj : null;
        Throwable th = uVar != null ? uVar.f8315a : null;
        if (b1Var instanceof i1) {
            try {
                ((i1) b1Var).k(th);
                return;
            } catch (Throwable th2) {
                L(new a1.b("Exception in completion handler " + b1Var + " for " + this, th2));
                return;
            }
        }
        o1 c9 = b1Var.c();
        if (c9 != null) {
            c9.d(new t7.h(1), 1);
            Object obj2 = t7.j.f10338a.get(c9);
            obj2.getClass();
            for (t7.j jVar = (t7.j) obj2; !jVar.equals(c9); jVar = jVar.g()) {
                if (jVar instanceof i1) {
                    try {
                        ((i1) jVar).k(th);
                    } catch (Throwable th3) {
                        if (bVar != null) {
                            p6.a.a(bVar, th3);
                        } else {
                            bVar = new a1.b("Exception in completion handler " + jVar + " for " + this, th3);
                        }
                    }
                }
            }
            if (bVar != null) {
                L(bVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Throwable] */
    public final Throwable D(Object obj) {
        CancellationException cancellationException;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        m1 m1Var = (m1) obj;
        Object obj2 = f8289a.get(m1Var);
        if (obj2 instanceof l1) {
            cancellationException = ((l1) obj2).d();
        } else if (obj2 instanceof u) {
            cancellationException = ((u) obj2).f8315a;
        } else {
            if (obj2 instanceof b1) {
                com.google.gson.internal.a.m(obj2, "Cannot be cancelling child in this state: ");
                return null;
            }
            cancellationException = null;
        }
        CancellationException cancellationException2 = cancellationException instanceof CancellationException ? cancellationException : null;
        return cancellationException2 == null ? new f1("Parent job is ".concat(a0(obj2)), cancellationException, m1Var) : cancellationException2;
    }

    public final Object E(l1 l1Var, Object obj) {
        Throwable G;
        u uVar = obj instanceof u ? (u) obj : null;
        Throwable th = uVar != null ? uVar.f8315a : null;
        synchronized (l1Var) {
            l1Var.e();
            ArrayList f = l1Var.f(th);
            G = G(l1Var, f);
            if (G != null && f.size() > 1) {
                Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(f.size()));
                int size = f.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = f.get(i);
                    i++;
                    Throwable th2 = (Throwable) obj2;
                    if (th2 != G && th2 != G && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                        p6.a.a(G, th2);
                    }
                }
            }
        }
        if (G != null && G != th) {
            obj = new u(false, G);
        }
        if (G != null && (z(G) || K(G))) {
            obj.getClass();
            u.f8314b.compareAndSet((u) obj, 0, 1);
        }
        V(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8289a;
        Object c1Var = obj instanceof b1 ? new c1((b1) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, l1Var, c1Var) && atomicReferenceFieldUpdater.get(this) == l1Var) {
        }
        C(l1Var, obj);
        return obj;
    }

    public final Object F() {
        Object obj = f8289a.get(this);
        if (obj instanceof b1) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("This job has not completed yet");
            return null;
        }
        if (obj instanceof u) {
            throw ((u) obj).f8315a;
        }
        return c0.A(obj);
    }

    public final Throwable G(l1 l1Var, ArrayList arrayList) {
        Object obj;
        Object obj2 = null;
        if (arrayList.isEmpty()) {
            if (l1Var.e()) {
                return new f1(A(), null, this);
            }
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i6);
            i6++;
            if (!(((Throwable) obj) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) arrayList.get(0);
        if (th2 instanceof w1) {
            int size2 = arrayList.size();
            while (true) {
                if (i >= size2) {
                    break;
                }
                Object obj3 = arrayList.get(i);
                i++;
                Throwable th3 = (Throwable) obj3;
                if (th3 != th2 && (th3 instanceof w1)) {
                    obj2 = obj3;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean H() {
        return true;
    }

    public boolean I() {
        return this instanceof r;
    }

    public final o1 J(b1 b1Var) {
        o1 c9 = b1Var.c();
        if (c9 != null) {
            return c9;
        }
        if (b1Var instanceof q0) {
            return new o1();
        }
        if (b1Var instanceof i1) {
            Y((i1) b1Var);
            return null;
        }
        com.google.gson.internal.a.m(b1Var, "State should have list: ");
        return null;
    }

    public boolean K(Throwable th) {
        return false;
    }

    public final void M(e1 e1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8290b;
        q1 q1Var = q1.f8300a;
        if (e1Var == null) {
            atomicReferenceFieldUpdater.set(this, q1Var);
            return;
        }
        e1Var.start();
        o d10 = e1Var.d(this);
        atomicReferenceFieldUpdater.set(this, d10);
        if (O()) {
            d10.dispose();
            atomicReferenceFieldUpdater.set(this, q1Var);
        }
    }

    public final o0 N(boolean z9, i1 i1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        q1 q1Var;
        boolean z10;
        boolean d10;
        i1Var.f8267m = this;
        loop0: while (true) {
            atomicReferenceFieldUpdater = f8289a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z11 = obj instanceof q0;
            q1Var = q1.f8300a;
            z10 = true;
            if (!z11) {
                if (!(obj instanceof b1)) {
                    z10 = false;
                    break;
                }
                b1 b1Var = (b1) obj;
                o1 c9 = b1Var.c();
                if (c9 == null) {
                    Y((i1) obj);
                } else {
                    if (i1Var.j()) {
                        l1 l1Var = b1Var instanceof l1 ? (l1) b1Var : null;
                        Throwable d11 = l1Var != null ? l1Var.d() : null;
                        if (d11 == null) {
                            d10 = c9.d(i1Var, 5);
                        } else if (z9) {
                            i1Var.k(d11);
                            return q1Var;
                        }
                    } else {
                        d10 = c9.d(i1Var, 1);
                    }
                    if (d10) {
                        break;
                    }
                }
            } else {
                q0 q0Var = (q0) obj;
                if (q0Var.f8299a) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, i1Var)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                X(q0Var);
            }
        }
        if (z10) {
            return i1Var;
        }
        if (z9) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            u uVar = obj2 instanceof u ? (u) obj2 : null;
            i1Var.k(uVar != null ? uVar.f8315a : null);
        }
        return q1Var;
    }

    public final boolean O() {
        return !(f8289a.get(this) instanceof b1);
    }

    public boolean P() {
        return this instanceof f;
    }

    public final boolean Q(Object obj) {
        Object b02;
        do {
            b02 = b0(f8289a.get(this), obj);
            if (b02 == c0.f8246d) {
                return false;
            }
            if (b02 == c0.f8247e) {
                return true;
            }
        } while (b02 == c0.f);
        t(b02);
        return true;
    }

    public final Object R(Object obj) {
        Object b02;
        do {
            b02 = b0(f8289a.get(this), obj);
            if (b02 == c0.f8246d) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                u uVar = obj instanceof u ? (u) obj : null;
                throw new IllegalStateException(str, uVar != null ? uVar.f8315a : null);
            }
        } while (b02 == c0.f);
        return b02;
    }

    public String S() {
        return getClass().getSimpleName();
    }

    public final void U(o1 o1Var, Throwable th) {
        o1Var.d(new t7.h(4), 4);
        Object obj = t7.j.f10338a.get(o1Var);
        obj.getClass();
        a1.b bVar = null;
        for (t7.j jVar = (t7.j) obj; !jVar.equals(o1Var); jVar = jVar.g()) {
            if ((jVar instanceof i1) && ((i1) jVar).j()) {
                try {
                    ((i1) jVar).k(th);
                } catch (Throwable th2) {
                    if (bVar != null) {
                        p6.a.a(bVar, th2);
                    } else {
                        bVar = new a1.b("Exception in completion handler " + jVar + " for " + this, th2);
                    }
                }
            }
        }
        if (bVar != null) {
            L(bVar);
        }
        z(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [o7.a1] */
    public final void X(q0 q0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        o1 o1Var = new o1();
        if (!q0Var.f8299a) {
            o1Var = new a1(o1Var);
        }
        do {
            atomicReferenceFieldUpdater = f8289a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, q0Var, o1Var)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == q0Var);
    }

    public final void Y(i1 i1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        o1 o1Var = new o1();
        i1Var.getClass();
        t7.j.f10339b.set(o1Var, i1Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = t7.j.f10338a;
        atomicReferenceFieldUpdater2.set(o1Var, i1Var);
        loop0: while (true) {
            if (atomicReferenceFieldUpdater2.get(i1Var) == i1Var) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(i1Var, i1Var, o1Var)) {
                    if (atomicReferenceFieldUpdater2.get(i1Var) != i1Var) {
                        break;
                    }
                }
                o1Var.f(i1Var);
                break loop0;
            }
            break;
        }
        t7.j g = i1Var.g();
        do {
            atomicReferenceFieldUpdater = f8289a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, i1Var, g)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == i1Var);
    }

    public final int Z(Object obj) {
        boolean z9 = obj instanceof q0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8289a;
        if (z9) {
            if (((q0) obj).f8299a) {
                return 0;
            }
            q0 q0Var = c0.j;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, q0Var)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            W();
            return 1;
        }
        if (!(obj instanceof a1)) {
            return 0;
        }
        o1 o1Var = ((a1) obj).f8230a;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, o1Var)) {
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                return -1;
            }
        }
        W();
        return 1;
    }

    @Override // o7.e1
    public boolean b() {
        Object obj = f8289a.get(this);
        return (obj instanceof b1) && ((b1) obj).b();
    }

    public final Object b0(Object obj, Object obj2) {
        if (!(obj instanceof b1)) {
            return c0.f8246d;
        }
        if (((obj instanceof q0) || (obj instanceof i1)) && !(obj instanceof p) && !(obj2 instanceof u)) {
            b1 b1Var = (b1) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8289a;
            Object c1Var = obj2 instanceof b1 ? new c1((b1) obj2) : obj2;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, b1Var, c1Var)) {
                if (atomicReferenceFieldUpdater.get(this) != b1Var) {
                    return c0.f;
                }
            }
            V(obj2);
            C(b1Var, obj2);
            return obj2;
        }
        b1 b1Var2 = (b1) obj;
        o1 J = J(b1Var2);
        if (J == null) {
            return c0.f;
        }
        l1 l1Var = b1Var2 instanceof l1 ? (l1) b1Var2 : null;
        if (l1Var == null) {
            l1Var = new l1(J, null);
        }
        synchronized (l1Var) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = l1.f8283b;
            if (atomicIntegerFieldUpdater.get(l1Var) != 0) {
                return c0.f8246d;
            }
            atomicIntegerFieldUpdater.set(l1Var, 1);
            if (l1Var != b1Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f8289a;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, b1Var2, l1Var)) {
                    if (atomicReferenceFieldUpdater2.get(this) != b1Var2) {
                        return c0.f;
                    }
                }
            }
            boolean e10 = l1Var.e();
            u uVar = obj2 instanceof u ? (u) obj2 : null;
            if (uVar != null) {
                l1Var.a(uVar.f8315a);
            }
            Throwable d10 = e10 ? null : l1Var.d();
            if (d10 != null) {
                U(J, d10);
            }
            p T = T(J);
            if (T != null && c0(l1Var, T, obj2)) {
                return c0.f8247e;
            }
            J.d(new t7.h(2), 2);
            p T2 = T(J);
            return (T2 == null || !c0(l1Var, T2, obj2)) ? E(l1Var, obj2) : c0.f8247e;
        }
    }

    @Override // o7.e1
    public void c(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new f1(A(), null, this);
        }
        y(cancellationException);
    }

    public final boolean c0(l1 l1Var, p pVar, Object obj) {
        while (c0.r(pVar.f8295n, false, new k1(this, l1Var, pVar, obj)) == q1.f8300a) {
            pVar = T(pVar);
            if (pVar == null) {
                return false;
            }
        }
        return true;
    }

    @Override // o7.e1
    public final o d(m1 m1Var) {
        p pVar = new p(m1Var);
        pVar.f8267m = this;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8289a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof q0) {
                q0 q0Var = (q0) obj;
                if (q0Var.f8299a) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, pVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    break loop0;
                }
                X(q0Var);
            } else {
                boolean z9 = obj instanceof b1;
                q1 q1Var = q1.f8300a;
                if (!z9) {
                    Object obj2 = atomicReferenceFieldUpdater.get(this);
                    u uVar = obj2 instanceof u ? (u) obj2 : null;
                    pVar.k(uVar != null ? uVar.f8315a : null);
                    return q1Var;
                }
                o1 c9 = ((b1) obj).c();
                if (c9 == null) {
                    Y((i1) obj);
                } else if (!c9.d(pVar, 7)) {
                    boolean d10 = c9.d(pVar, 3);
                    Object obj3 = atomicReferenceFieldUpdater.get(this);
                    if (obj3 instanceof l1) {
                        r4 = ((l1) obj3).d();
                    } else {
                        u uVar2 = obj3 instanceof u ? (u) obj3 : null;
                        if (uVar2 != null) {
                            r4 = uVar2.f8315a;
                        }
                    }
                    pVar.k(r4);
                    if (d10) {
                        break loop0;
                    }
                    return q1Var;
                }
            }
        }
        return pVar;
    }

    public Object f() {
        return F();
    }

    @Override // t6.h
    public final Object fold(Object obj, d7.p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // t6.h
    public final t6.f get(t6.g gVar) {
        return a.a.z(this, gVar);
    }

    @Override // t6.f
    public final t6.g getKey() {
        return x.f8327b;
    }

    @Override // o7.e1
    public final o0 h(d7.l lVar) {
        return N(true, new p0(lVar, 1));
    }

    @Override // o7.e1
    public final boolean isCancelled() {
        Object obj = f8289a.get(this);
        if (obj instanceof u) {
            return true;
        }
        return (obj instanceof l1) && ((l1) obj).e();
    }

    @Override // o7.e1
    public final CancellationException j() {
        CancellationException cancellationException;
        Object obj = f8289a.get(this);
        if (obj instanceof l1) {
            Throwable d10 = ((l1) obj).d();
            if (d10 == null) {
                com.google.gson.internal.a.m(this, "Job is still new or active: ");
                return null;
            }
            String concat = getClass().getSimpleName().concat(" is cancelling");
            cancellationException = d10 instanceof CancellationException ? (CancellationException) d10 : null;
            return cancellationException == null ? new f1(concat, d10, this) : cancellationException;
        }
        if (obj instanceof b1) {
            com.google.gson.internal.a.m(this, "Job is still new or active: ");
            return null;
        }
        if (!(obj instanceof u)) {
            return new f1(getClass().getSimpleName().concat(" has completed normally"), null, this);
        }
        Throwable th = ((u) obj).f8315a;
        cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        return cancellationException == null ? new f1(A(), th, this) : cancellationException;
    }

    @Override // t6.h
    public final t6.h minusKey(t6.g gVar) {
        return a.a.K(this, gVar);
    }

    @Override // t6.h
    public final t6.h plus(t6.h hVar) {
        return a.a.L(this, hVar);
    }

    @Override // o7.e1
    public final Object r(t6.c cVar) {
        Object obj;
        p6.x xVar;
        do {
            obj = f8289a.get(this);
            boolean z9 = obj instanceof b1;
            xVar = p6.x.f8463a;
            if (!z9) {
                c0.k(cVar.getContext());
                return xVar;
            }
        } while (Z(obj) < 0);
        l lVar = new l(1, d0.b.I(cVar));
        lVar.s();
        lVar.v(new h(c0.r(this, true, new n(lVar, 1)), 2));
        Object r9 = lVar.r();
        u6.a aVar = u6.a.f10762a;
        if (r9 != aVar) {
            r9 = xVar;
        }
        return r9 == aVar ? r9 : xVar;
    }

    public Object s(v6.i iVar) {
        return w(iVar);
    }

    @Override // o7.e1
    public final boolean start() {
        int Z;
        do {
            Z = Z(f8289a.get(this));
            if (Z == 0) {
                return false;
            }
        } while (Z != 1);
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(S() + '{' + a0(f8289a.get(this)) + '}');
        sb.append('@');
        sb.append(c0.o(this));
        return sb.toString();
    }

    @Override // o7.e1
    public final o0 u(boolean z9, boolean z10, h1 h1Var) {
        return N(z10, z9 ? new d1(h1Var) : new p0(h1Var, 1));
    }

    public void v(Object obj) {
        t(obj);
    }

    public final Object w(t6.c cVar) {
        Object obj;
        do {
            obj = f8289a.get(this);
            if (!(obj instanceof b1)) {
                if (obj instanceof u) {
                    throw ((u) obj).f8315a;
                }
                return c0.A(obj);
            }
        } while (Z(obj) < 0);
        j1 j1Var = new j1(d0.b.I(cVar), this);
        j1Var.s();
        j1Var.v(new h(c0.r(this, true, new p0(j1Var, 2)), 2));
        return j1Var.r();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
    
        if (r0 == o7.c0.f8247e) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean x(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.m1.x(java.lang.Object):boolean");
    }

    public void y(CancellationException cancellationException) {
        x(cancellationException);
    }

    public final boolean z(Throwable th) {
        if (P()) {
            return true;
        }
        boolean z9 = th instanceof CancellationException;
        o oVar = (o) f8290b.get(this);
        return (oVar == null || oVar == q1.f8300a) ? z9 : oVar.a(th) || z9;
    }

    public void W() {
    }

    public void L(a1.b bVar) {
        throw bVar;
    }

    public void V(Object obj) {
    }

    public void t(Object obj) {
    }
}
