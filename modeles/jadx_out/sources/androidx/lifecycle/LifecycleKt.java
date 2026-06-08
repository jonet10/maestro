package androidx.lifecycle;

import o7.c0;
import o7.m0;
import o7.u1;
import r7.k0;
import t7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        lifecycle.getClass();
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.getInternalScopeRef().get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            u1 d10 = c0.d();
            v7.e eVar = m0.f8288a;
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, a.a.L(d10, n.f10348a.f8468l));
        } while (!lifecycle.getInternalScopeRef().compareAndSet(null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.register();
        return lifecycleCoroutineScopeImpl;
    }

    public static final r7.h getEventFlow(Lifecycle lifecycle) {
        lifecycle.getClass();
        r7.c e10 = k0.e(new LifecycleKt$eventFlow$1(lifecycle, null));
        v7.e eVar = m0.f8288a;
        return k0.l(e10, n.f10348a.f8468l);
    }
}
