package v7;

import java.util.concurrent.Executor;
import o7.w;
import o7.x0;
import t7.u;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends x0 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public static final d f10884a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final w f10885b;

    static {
        k kVar = k.f10897a;
        int i = u.f10357a;
        if (64 >= i) {
            i = 64;
        }
        f10885b = w.limitedParallelism$default(kVar, t7.a.j(i, 12, "kotlinx.coroutines.io.parallelism"), null, 2, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // o7.w
    public final void dispatch(t6.h hVar, Runnable runnable) {
        f10885b.dispatch(hVar, runnable);
    }

    @Override // o7.w
    public final void dispatchYield(t6.h hVar, Runnable runnable) {
        f10885b.dispatchYield(hVar, runnable);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        dispatch(t6.i.f10314a, runnable);
    }

    @Override // o7.w
    public final w limitedParallelism(int i, String str) {
        return k.f10897a.limitedParallelism(i, str);
    }

    @Override // o7.w
    public final String toString() {
        return "Dispatchers.IO";
    }

    @Override // o7.x0
    public final Executor y() {
        return this;
    }
}
