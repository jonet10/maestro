package o7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j0 extends t7.r {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f8268n = AtomicIntegerFieldUpdater.newUpdater(j0.class, "_decision$volatile");
    private volatile /* synthetic */ int _decision$volatile;

    @Override // t7.r, o7.m1
    public final void t(Object obj) {
        v(obj);
    }

    @Override // t7.r, o7.m1
    public final void v(Object obj) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = f8268n;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("Already resumed");
                    return;
                } else {
                    t7.a.h(c0.u(obj), d0.b.I(this.f10353m));
                    return;
                }
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }
}
