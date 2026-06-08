package r7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l0 extends s7.d {

    /* renamed from: a, reason: collision with root package name */
    public long f9013a;

    /* renamed from: b, reason: collision with root package name */
    public o7.l f9014b;

    @Override // s7.d
    public final boolean a(s7.b bVar) {
        j0 j0Var = (j0) bVar;
        if (this.f9013a >= 0) {
            return false;
        }
        long j = j0Var.f8998p;
        if (j < j0Var.f8999q) {
            j0Var.f8999q = j;
        }
        this.f9013a = j;
        return true;
    }

    @Override // s7.d
    public final t6.c[] b(s7.b bVar) {
        long j = this.f9013a;
        this.f9013a = -1L;
        this.f9014b = null;
        return ((j0) bVar).s(j);
    }
}
