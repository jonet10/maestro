package androidx.lifecycle.viewmodel.internal;

import o7.a0;
import o7.e1;
import o7.x;
import t6.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CloseableCoroutineScope implements AutoCloseable, a0 {
    private final h coroutineContext;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CloseableCoroutineScope(a0 a0Var) {
        this(a0Var.getCoroutineContext());
        a0Var.getClass();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        e1 e1Var = (e1) getCoroutineContext().get(x.f8327b);
        if (e1Var != null) {
            e1Var.c(null);
        }
    }

    @Override // o7.a0
    public h getCoroutineContext() {
        return this.coroutineContext;
    }

    public CloseableCoroutineScope(h hVar) {
        hVar.getClass();
        this.coroutineContext = hVar;
    }
}
