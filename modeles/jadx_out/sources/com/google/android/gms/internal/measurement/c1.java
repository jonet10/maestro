package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c1 extends g1 {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f2524n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ h0 f2525o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ k1 f2526p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c1(k1 k1Var, h0 h0Var, int i) {
        super(k1Var, true);
        this.f2524n = i;
        this.f2525o = h0Var;
        this.f2526p = k1Var;
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public final void a() {
        switch (this.f2524n) {
            case 0:
                k0 k0Var = this.f2526p.f;
                k0.y.g(k0Var);
                k0Var.getGmpAppId(this.f2525o);
                break;
            case 1:
                k0 k0Var2 = this.f2526p.f;
                k0.y.g(k0Var2);
                k0Var2.getCachedAppInstanceId(this.f2525o);
                break;
            case 2:
                k0 k0Var3 = this.f2526p.f;
                k0.y.g(k0Var3);
                k0Var3.generateEventId(this.f2525o);
                break;
            case 3:
                k0 k0Var4 = this.f2526p.f;
                k0.y.g(k0Var4);
                k0Var4.getCurrentScreenName(this.f2525o);
                break;
            default:
                k0 k0Var5 = this.f2526p.f;
                k0.y.g(k0Var5);
                k0Var5.getCurrentScreenClass(this.f2525o);
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.g1
    public final void b() {
        switch (this.f2524n) {
            case 0:
                this.f2525o.t(null);
                break;
            case 1:
                this.f2525o.t(null);
                break;
            case 2:
                this.f2525o.t(null);
                break;
            case 3:
                this.f2525o.t(null);
                break;
            default:
                this.f2525o.t(null);
                break;
        }
    }
}
