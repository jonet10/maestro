package o7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d implements i {

    /* renamed from: a, reason: collision with root package name */
    public final c[] f8249a;

    public d(c[] cVarArr) {
        this.f8249a = cVarArr;
    }

    @Override // o7.i
    public final void a(Throwable th) {
        b();
    }

    public final void b() {
        for (c cVar : this.f8249a) {
            o0 o0Var = cVar.f8241o;
            if (o0Var == null) {
                kotlin.jvm.internal.l.i("handle");
                throw null;
            }
            o0Var.dispose();
        }
    }

    public final String toString() {
        return "DisposeHandlersOnCancel[" + this.f8249a + ']';
    }
}
