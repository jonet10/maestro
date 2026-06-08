package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import r7.k0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FlowExtKt {
    public static final <T> r7.h flowWithLifecycle(r7.h hVar, Lifecycle lifecycle, Lifecycle.State state) {
        hVar.getClass();
        lifecycle.getClass();
        state.getClass();
        return k0.e(new FlowExtKt$flowWithLifecycle$1(lifecycle, state, hVar, null));
    }

    public static /* synthetic */ r7.h flowWithLifecycle$default(r7.h hVar, Lifecycle lifecycle, Lifecycle.State state, int i, Object obj) {
        if ((i & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return flowWithLifecycle(hVar, lifecycle, state);
    }
}
