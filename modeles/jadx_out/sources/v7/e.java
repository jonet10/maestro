package v7;

import java.util.concurrent.Executor;
import o7.w;
import o7.x0;
import t7.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends x0 {

    /* renamed from: b, reason: collision with root package name */
    public static final e f10886b;

    /* renamed from: a, reason: collision with root package name */
    public c f10887a;

    static {
        int i = j.f10894c;
        int i6 = j.f10895d;
        long j = j.f10896e;
        String str = j.f10892a;
        e eVar = new e();
        eVar.f10887a = new c(i, i6, j, str);
        f10886b = eVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // o7.w
    public final void dispatch(t6.h hVar, Runnable runnable) {
        c.d(this.f10887a, runnable, 6);
    }

    @Override // o7.w
    public final void dispatchYield(t6.h hVar, Runnable runnable) {
        c.d(this.f10887a, runnable, 2);
    }

    @Override // o7.w
    public final w limitedParallelism(int i, String str) {
        t7.a.a(i);
        return i >= j.f10894c ? str != null ? new o(this, str) : this : super.limitedParallelism(i, str);
    }

    @Override // o7.w
    public final String toString() {
        return "Dispatchers.Default";
    }

    @Override // o7.x0
    public final Executor y() {
        return this.f10887a;
    }
}
