package o7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n extends i1 {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f8291n;

    /* renamed from: o, reason: collision with root package name */
    public final l f8292o;

    public /* synthetic */ n(l lVar, int i) {
        this.f8291n = i;
        this.f8292o = lVar;
    }

    @Override // o7.i1
    public final boolean j() {
        switch (this.f8291n) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    @Override // o7.i1
    public final void k(Throwable th) {
        switch (this.f8291n) {
            case 0:
                m1 i = i();
                l lVar = this.f8292o;
                Throwable p10 = lVar.p(i);
                if (lVar.w()) {
                    t7.f fVar = (t7.f) lVar.f8280m;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = t7.f.f10325q;
                    while (true) {
                        Object obj = atomicReferenceFieldUpdater.get(fVar);
                        f8.w wVar = t7.a.f10317c;
                        if (kotlin.jvm.internal.l.a(obj, wVar)) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(fVar, wVar, p10)) {
                                if (atomicReferenceFieldUpdater.get(fVar) != wVar) {
                                    break;
                                }
                            }
                            break;
                        } else if (obj instanceof Throwable) {
                            break;
                        } else {
                            while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, null)) {
                                if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                                    break;
                                }
                            }
                        }
                    }
                }
                lVar.o(p10);
                if (!lVar.w()) {
                    lVar.m();
                    break;
                }
                break;
            default:
                this.f8292o.resumeWith(p6.x.f8463a);
                break;
        }
    }
}
