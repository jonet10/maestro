package o7;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends i1 {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8239q = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_disposer$volatile");
    private volatile /* synthetic */ Object _disposer$volatile;

    /* renamed from: n, reason: collision with root package name */
    public final l f8240n;

    /* renamed from: o, reason: collision with root package name */
    public o0 f8241o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ e f8242p;

    public c(e eVar, l lVar) {
        this.f8242p = eVar;
        this.f8240n = lVar;
    }

    @Override // o7.i1
    public final boolean j() {
        return false;
    }

    @Override // o7.i1
    public final void k(Throwable th) {
        l lVar = this.f8240n;
        if (th != null) {
            lVar.getClass();
            f8.w E = lVar.E(new u(false, th), null);
            if (E != null) {
                lVar.q(E);
                d dVar = (d) f8239q.get(this);
                if (dVar != null) {
                    dVar.b();
                    return;
                }
                return;
            }
            return;
        }
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = e.f8255b;
        e eVar = this.f8242p;
        if (atomicIntegerFieldUpdater.decrementAndGet(eVar) == 0) {
            f0[] f0VarArr = eVar.f8256a;
            ArrayList arrayList = new ArrayList(f0VarArr.length);
            for (f0 f0Var : f0VarArr) {
                arrayList.add(f0Var.f());
            }
            lVar.resumeWith(arrayList);
        }
    }
}
