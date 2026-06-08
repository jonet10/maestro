package e1;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4229a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.m0 f4230b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f4231l;

    public /* synthetic */ r1(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.m0 m0Var, int i) {
        this.f4229a = i;
        this.f4230b = m0Var;
        this.f4231l = appMeasurementDynamiteService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4229a) {
            case 0:
                w3 p10 = this.f4231l.i.p();
                com.google.android.gms.internal.measurement.m0 m0Var = this.f4230b;
                p10.g();
                p10.h();
                p10.u(new x1((Object) p10, p10.w(false), (Object) m0Var, 6));
                break;
            default:
                AppMeasurementDynamiteService appMeasurementDynamiteService = this.f4231l;
                a5 a5Var = appMeasurementDynamiteService.i.f4267r;
                t1.k(a5Var);
                t1 t1Var = appMeasurementDynamiteService.i;
                a5Var.T(this.f4230b, t1Var.H != null && t1Var.H.booleanValue());
                break;
        }
    }
}
