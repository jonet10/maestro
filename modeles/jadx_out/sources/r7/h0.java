package r7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h0 implements o7.o0 {

    /* renamed from: a, reason: collision with root package name */
    public final j0 f8978a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8979b;

    /* renamed from: l, reason: collision with root package name */
    public final Object f8980l;

    /* renamed from: m, reason: collision with root package name */
    public final o7.l f8981m;

    public h0(j0 j0Var, long j, Object obj, o7.l lVar) {
        this.f8978a = j0Var;
        this.f8979b = j;
        this.f8980l = obj;
        this.f8981m = lVar;
    }

    @Override // o7.o0
    public final void dispose() {
        j0 j0Var = this.f8978a;
        synchronized (j0Var) {
            if (this.f8979b < j0Var.l()) {
                return;
            }
            Object[] objArr = j0Var.f8997o;
            objArr.getClass();
            long j = this.f8979b;
            if (objArr[((int) j) & (objArr.length - 1)] != this) {
                return;
            }
            k0.d(objArr, j, k0.f9005a);
            j0Var.g();
        }
    }
}
