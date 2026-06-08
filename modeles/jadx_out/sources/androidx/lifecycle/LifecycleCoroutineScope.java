package androidx.lifecycle;

import d7.p;
import o7.a0;
import o7.c0;
import o7.e1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class LifecycleCoroutineScope implements a0 {
    @Override // o7.a0
    public abstract /* synthetic */ t6.h getCoroutineContext();

    public abstract Lifecycle getLifecycle$lifecycle_common();

    public final e1 launchWhenCreated(p pVar) {
        pVar.getClass();
        return c0.s(this, null, null, new LifecycleCoroutineScope$launchWhenCreated$1(this, pVar, null), 3);
    }

    public final e1 launchWhenResumed(p pVar) {
        pVar.getClass();
        return c0.s(this, null, null, new LifecycleCoroutineScope$launchWhenResumed$1(this, pVar, null), 3);
    }

    public final e1 launchWhenStarted(p pVar) {
        pVar.getClass();
        return c0.s(this, null, null, new LifecycleCoroutineScope$launchWhenStarted$1(this, pVar, null), 3);
    }
}
