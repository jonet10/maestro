package o7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class i1 extends t7.j implements o0, b1 {

    /* renamed from: m, reason: collision with root package name */
    public m1 f8267m;

    @Override // o7.b1
    public final boolean b() {
        return true;
    }

    @Override // o7.b1
    public final o1 c() {
        return null;
    }

    @Override // o7.o0
    public final void dispose() {
        m1 i = i();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m1.f8289a;
            Object obj = atomicReferenceFieldUpdater.get(i);
            if (obj instanceof i1) {
                if (obj != this) {
                    return;
                }
                q0 q0Var = c0.j;
                while (!atomicReferenceFieldUpdater.compareAndSet(i, obj, q0Var)) {
                    if (atomicReferenceFieldUpdater.get(i) != obj) {
                        break;
                    }
                }
                return;
            }
            if (!(obj instanceof b1) || ((b1) obj).c() == null) {
                return;
            }
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = t7.j.f10338a;
                Object obj2 = atomicReferenceFieldUpdater2.get(this);
                if (obj2 instanceof t7.p) {
                    return;
                }
                if (obj2 == this) {
                    return;
                }
                obj2.getClass();
                t7.j jVar = (t7.j) obj2;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = t7.j.f10340l;
                t7.p pVar = (t7.p) atomicReferenceFieldUpdater3.get(jVar);
                if (pVar == null) {
                    pVar = new t7.p(jVar);
                    atomicReferenceFieldUpdater3.set(jVar, pVar);
                }
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, pVar)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                        break;
                    }
                }
                jVar.e();
                return;
            }
        }
    }

    public e1 getParent() {
        return i();
    }

    public final m1 i() {
        m1 m1Var = this.f8267m;
        if (m1Var != null) {
            return m1Var;
        }
        kotlin.jvm.internal.l.i("job");
        throw null;
    }

    public abstract boolean j();

    public abstract void k(Throwable th);

    @Override // t7.j
    public final String toString() {
        return getClass().getSimpleName() + '@' + c0.o(this) + "[job@" + c0.o(i()) + ']';
    }
}
