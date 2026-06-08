package m8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends w8.q {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o8.e f7704b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(w8.g0 g0Var, o8.e eVar) {
        super(g0Var);
        this.f7704b = eVar;
    }

    @Override // w8.q, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f7704b.close();
        super.close();
    }
}
