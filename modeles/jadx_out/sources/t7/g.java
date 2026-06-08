package t7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import o7.e0;
import o7.h0;
import o7.o0;
import o7.x1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends o7.w implements h0 {

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10330p = AtomicIntegerFieldUpdater.newUpdater(g.class, "runningWorkers$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f10331a;

    /* renamed from: b, reason: collision with root package name */
    public final o7.w f10332b;

    /* renamed from: l, reason: collision with root package name */
    public final int f10333l;

    /* renamed from: m, reason: collision with root package name */
    public final String f10334m;

    /* renamed from: n, reason: collision with root package name */
    public final k f10335n;

    /* renamed from: o, reason: collision with root package name */
    public final Object f10336o;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX WARN: Multi-variable type inference failed */
    public g(o7.w wVar, int i, String str) {
        h0 h0Var = wVar instanceof h0 ? (h0) wVar : null;
        this.f10331a = h0Var == null ? e0.f8257a : h0Var;
        this.f10332b = wVar;
        this.f10333l = i;
        this.f10334m = str;
        this.f10335n = new k();
        this.f10336o = new Object();
    }

    @Override // o7.w
    public final void dispatch(t6.h hVar, Runnable runnable) {
        Runnable y9;
        this.f10335n.a(runnable);
        if (f10330p.get(this) >= this.f10333l || !z() || (y9 = y()) == null) {
            return;
        }
        this.f10332b.dispatch(this, new m4.a(5, this, y9));
    }

    @Override // o7.w
    public final void dispatchYield(t6.h hVar, Runnable runnable) {
        Runnable y9;
        this.f10335n.a(runnable);
        if (f10330p.get(this) >= this.f10333l || !z() || (y9 = y()) == null) {
            return;
        }
        this.f10332b.dispatchYield(this, new m4.a(5, this, y9));
    }

    @Override // o7.h0
    public final o0 e(long j, x1 x1Var, t6.h hVar) {
        return this.f10331a.e(j, x1Var, hVar);
    }

    @Override // o7.h0
    public final void i(long j, o7.l lVar) {
        this.f10331a.i(j, lVar);
    }

    @Override // o7.w
    public final o7.w limitedParallelism(int i, String str) {
        a.a(i);
        return i >= this.f10333l ? str != null ? new o(this, str) : this : super.limitedParallelism(i, str);
    }

    @Override // o7.w
    public final String toString() {
        String str = this.f10334m;
        if (str != null) {
            return str;
        }
        return this.f10332b + ".limitedParallelism(" + this.f10333l + ')';
    }

    public final Runnable y() {
        while (true) {
            Runnable runnable = (Runnable) this.f10335n.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f10336o) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f10330p;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f10335n.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean z() {
        synchronized (this.f10336o) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f10330p;
            if (atomicIntegerFieldUpdater.get(this) >= this.f10333l) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }
}
