package q7;

import f8.w;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import o7.c0;
import o7.f1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r extends o7.a implements s, i {

    /* renamed from: m, reason: collision with root package name */
    public final e f8779m;

    public r(t6.h hVar, e eVar) {
        super(hVar, true);
        this.f8779m = eVar;
    }

    @Override // q7.i
    public final Object a() {
        return this.f8779m.a();
    }

    @Override // o7.m1, o7.e1
    public final void c(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new f1(A(), null, this);
        }
        y(cancellationException);
    }

    @Override // o7.a
    public final void d0(boolean z9, Throwable th) {
        if (this.f8779m.h(false, th) || z9) {
            return;
        }
        c0.q(th, this.f8229l);
    }

    @Override // q7.u
    public final Object e(Object obj, t6.c cVar) {
        return this.f8779m.e(obj, cVar);
    }

    @Override // o7.a
    public final void e0(Object obj) {
        this.f8779m.m(null);
    }

    public final void g0(q qVar) {
        e eVar = this.f8779m;
        eVar.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e.f8750s;
        while (!atomicReferenceFieldUpdater.compareAndSet(eVar, null, qVar)) {
            if (atomicReferenceFieldUpdater.get(eVar) != null) {
                while (true) {
                    Object obj = atomicReferenceFieldUpdater.get(eVar);
                    w wVar = g.f8764q;
                    if (obj != wVar) {
                        if (obj == g.f8765r) {
                            androidx.privacysandbox.ads.adservices.customaudience.a.i("Another handler was already registered and successfully invoked");
                            return;
                        } else {
                            com.google.gson.internal.a.m(obj, "Another handler is already registered: ");
                            return;
                        }
                    }
                    w wVar2 = g.f8765r;
                    while (!atomicReferenceFieldUpdater.compareAndSet(eVar, wVar, wVar2)) {
                        if (atomicReferenceFieldUpdater.get(eVar) != wVar) {
                            break;
                        }
                    }
                    qVar.invoke(eVar.q());
                    return;
                }
            }
        }
    }

    @Override // q7.i
    public final b iterator() {
        e eVar = this.f8779m;
        eVar.getClass();
        return new b(eVar);
    }

    @Override // q7.i
    public final Object k(s7.g gVar) {
        e eVar = this.f8779m;
        eVar.getClass();
        return e.C(eVar, gVar);
    }

    @Override // q7.i
    public final Object l(t6.c cVar) {
        return this.f8779m.l(cVar);
    }

    @Override // q7.u
    public final boolean m(Throwable th) {
        return this.f8779m.h(false, th);
    }

    @Override // q7.u
    public final Object p(Object obj) {
        return this.f8779m.p(obj);
    }

    @Override // o7.m1
    public final void y(CancellationException cancellationException) {
        this.f8779m.h(true, cancellationException);
        x(cancellationException);
    }
}
