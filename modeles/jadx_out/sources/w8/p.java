package w8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class p implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final e0 f10986a;

    public p(e0 e0Var) {
        e0Var.getClass();
        this.f10986a = e0Var;
    }

    @Override // w8.e0
    public final i0 a() {
        return this.f10986a.a();
    }

    @Override // w8.e0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f10986a.close();
    }

    @Override // w8.e0, java.io.Flushable
    public void flush() {
        this.f10986a.flush();
    }

    @Override // w8.e0
    public void l(h hVar, long j) {
        this.f10986a.l(hVar, j);
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.f10986a + ')';
    }
}
