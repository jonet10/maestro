package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import o7.c0;
import o7.e1;
import o7.m0;
import o7.x;
import t7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    private final t6.h coroutineContext;
    private final Lifecycle lifecycle;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, t6.h hVar) {
        e1 e1Var;
        lifecycle.getClass();
        hVar.getClass();
        this.lifecycle = lifecycle;
        this.coroutineContext = hVar;
        if (getLifecycle$lifecycle_common().getCurrentState() != Lifecycle.State.DESTROYED || (e1Var = (e1) getCoroutineContext().get(x.f8327b)) == null) {
            return;
        }
        e1Var.c(null);
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope, o7.a0
    public t6.h getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    public Lifecycle getLifecycle$lifecycle_common() {
        return this.lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        lifecycleOwner.getClass();
        event.getClass();
        if (getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle$lifecycle_common().removeObserver(this);
            e1 e1Var = (e1) getCoroutineContext().get(x.f8327b);
            if (e1Var != null) {
                e1Var.c(null);
            }
        }
    }

    public final void register() {
        v7.e eVar = m0.f8288a;
        c0.s(this, n.f10348a.f8468l, null, new LifecycleCoroutineScopeImpl$register$1(this, null), 2);
    }
}
