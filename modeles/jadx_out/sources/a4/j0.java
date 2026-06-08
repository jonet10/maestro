package a4;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j0 extends ThreadPoolExecutor {
    public final void a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable) {
        i0 i0Var = new i0((h) runnable);
        execute(i0Var);
        return i0Var;
    }
}
