package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a1 extends g1 {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f2485n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f2486o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ k1 f2487p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a1(k1 k1Var, String str, int i) {
        super(k1Var, true);
        this.f2485n = i;
        this.f2486o = str;
        this.f2487p = k1Var;
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public final void a() {
        switch (this.f2485n) {
            case 0:
                k0 k0Var = this.f2487p.f;
                k0.y.g(k0Var);
                k0Var.beginAdUnitExposure(this.f2486o, this.f2593b);
                break;
            default:
                k0 k0Var2 = this.f2487p.f;
                k0.y.g(k0Var2);
                k0Var2.endAdUnitExposure(this.f2486o, this.f2593b);
                break;
        }
    }
}
