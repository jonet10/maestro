package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import d7.p;
import o7.c0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RepeatOnLifecycleKt {
    public static final Object repeatOnLifecycle(Lifecycle lifecycle, Lifecycle.State state, p pVar, t6.c cVar) {
        if (state == Lifecycle.State.INITIALIZED) {
            com.google.gson.internal.a.p("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
            return null;
        }
        Lifecycle.State currentState = lifecycle.getCurrentState();
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        x xVar = x.f8463a;
        if (currentState == state2) {
            return xVar;
        }
        Object i = c0.i(new RepeatOnLifecycleKt$repeatOnLifecycle$3(lifecycle, state, pVar, null), cVar);
        return i == u6.a.f10762a ? i : xVar;
    }

    public static final Object repeatOnLifecycle(LifecycleOwner lifecycleOwner, Lifecycle.State state, p pVar, t6.c cVar) {
        Object repeatOnLifecycle = repeatOnLifecycle(lifecycleOwner.getLifecycle(), state, pVar, cVar);
        return repeatOnLifecycle == u6.a.f10762a ? repeatOnLifecycle : x.f8463a;
    }
}
