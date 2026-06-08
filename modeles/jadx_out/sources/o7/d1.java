package o7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d1 extends i1 {

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f8252o = AtomicIntegerFieldUpdater.newUpdater(d1.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;

    /* renamed from: n, reason: collision with root package name */
    public final h1 f8253n;

    public d1(h1 h1Var) {
        this.f8253n = h1Var;
    }

    @Override // o7.i1
    public final boolean j() {
        return true;
    }

    @Override // o7.i1
    public final void k(Throwable th) {
        if (f8252o.compareAndSet(this, 0, 1)) {
            this.f8253n.invoke(th);
        }
    }
}
