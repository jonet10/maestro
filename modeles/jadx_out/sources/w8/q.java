package w8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class q implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public final g0 f10987a;

    public q(g0 g0Var) {
        g0Var.getClass();
        this.f10987a = g0Var;
    }

    @Override // w8.g0
    public final i0 a() {
        return this.f10987a.a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f10987a.close();
    }

    @Override // w8.g0
    public long p(h hVar, long j) {
        hVar.getClass();
        return this.f10987a.p(hVar, j);
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.f10987a + ')';
    }
}
