package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import d7.p;
import o7.c0;
import o7.m0;
import t7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PausingDispatcherKt {
    public static final <T> Object whenCreated(LifecycleOwner lifecycleOwner, p pVar, t6.c cVar) {
        return whenCreated(lifecycleOwner.getLifecycle(), pVar, cVar);
    }

    public static final <T> Object whenResumed(LifecycleOwner lifecycleOwner, p pVar, t6.c cVar) {
        return whenResumed(lifecycleOwner.getLifecycle(), pVar, cVar);
    }

    public static final <T> Object whenStarted(LifecycleOwner lifecycleOwner, p pVar, t6.c cVar) {
        return whenStarted(lifecycleOwner.getLifecycle(), pVar, cVar);
    }

    public static final <T> Object whenStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, p pVar, t6.c cVar) {
        v7.e eVar = m0.f8288a;
        return c0.C(new PausingDispatcherKt$whenStateAtLeast$2(lifecycle, state, pVar, null), n.f10348a.f8468l, cVar);
    }

    public static final <T> Object whenCreated(Lifecycle lifecycle, p pVar, t6.c cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, pVar, cVar);
    }

    public static final <T> Object whenResumed(Lifecycle lifecycle, p pVar, t6.c cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, pVar, cVar);
    }

    public static final <T> Object whenStarted(Lifecycle lifecycle, p pVar, t6.c cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, pVar, cVar);
    }
}
