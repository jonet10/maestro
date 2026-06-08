package e1;

import j$.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u1 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4297a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4298b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4299c;

    public u1(u4 u4Var, c5 c5Var) {
        this.f4297a = 2;
        this.f4299c = c5Var;
        Objects.requireNonNull(u4Var);
        this.f4298b = u4Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4297a) {
            case 0:
                c2 c2Var = (c2) this.f4298b;
                c2Var.i.B();
                m mVar = c2Var.i.f4307l;
                u4.U(mVar);
                return mVar.b0((String) this.f4299c);
            case 1:
                c2 c2Var2 = (c2) this.f4298b;
                c2Var2.i.B();
                return new i(c2Var2.i.p0(((c5) this.f4299c).f3850a));
            default:
                c5 c5Var = (c5) this.f4299c;
                String str = c5Var.f3850a;
                k0.y.g(str);
                u4 u4Var = (u4) this.f4298b;
                j2 d10 = u4Var.d(str);
                i2 i2Var = i2.ANALYTICS_STORAGE;
                if (d10.i(i2Var) && j2.c(100, c5Var.B).i(i2Var)) {
                    return u4Var.c0(c5Var).E();
                }
                u4Var.a().f4346w.b("Analytics storage consent denied. Returning null app instance id");
                return null;
        }
    }

    public /* synthetic */ u1(c2 c2Var, Object obj, int i) {
        this.f4297a = i;
        this.f4299c = obj;
        this.f4298b = c2Var;
    }
}
