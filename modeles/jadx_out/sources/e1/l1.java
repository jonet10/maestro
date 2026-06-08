package e1;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class l1 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4088a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4089b;

    public /* synthetic */ l1(m1 m1Var) {
        this.f4089b = m1Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4088a) {
            case 0:
                return new com.google.android.gms.internal.measurement.k4(((m1) this.f4089b).f4112t);
            default:
                c2 c2Var = (c2) this.f4089b;
                c2Var.i.B();
                a1 a1Var = c2Var.i.f4312q;
                u4.U(a1Var);
                a1Var.g();
                throw new IllegalStateException("Unexpected call on client side");
        }
    }

    public l1(c2 c2Var, u uVar, String str) {
        this.f4089b = c2Var;
    }
}
