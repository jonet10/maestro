package o7;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p1 extends t6.a implements e1 {

    /* renamed from: a, reason: collision with root package name */
    public static final p1 f8298a = new p1(x.f8327b);

    @Override // o7.e1
    public final boolean b() {
        return true;
    }

    @Override // o7.e1
    public final o d(m1 m1Var) {
        return q1.f8300a;
    }

    @Override // o7.e1
    public final o0 h(d7.l lVar) {
        return q1.f8300a;
    }

    @Override // o7.e1
    public final boolean isCancelled() {
        return false;
    }

    @Override // o7.e1
    public final CancellationException j() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // o7.e1
    public final Object r(t6.c cVar) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // o7.e1
    public final boolean start() {
        return false;
    }

    public final String toString() {
        return "NonCancellable";
    }

    @Override // o7.e1
    public final o0 u(boolean z9, boolean z10, h1 h1Var) {
        return q1.f8300a;
    }

    @Override // o7.e1
    public final void c(CancellationException cancellationException) {
    }
}
