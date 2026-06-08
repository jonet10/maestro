package c4;

import androidx.lifecycle.LifecycleOwnerKt;
import java.io.File;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e0 implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1540a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k0 f1541b;

    public /* synthetic */ e0(k0 k0Var, int i) {
        this.f1540a = i;
        this.f1541b = k0Var;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        x4.r a8;
        File g;
        int i = this.f1540a;
        k0 k0Var = this.f1541b;
        p6.x xVar = p6.x.f8463a;
        switch (i) {
            case 0:
                int i6 = k0.N;
                k0Var.c0((x4.i0) obj);
                break;
            case 1:
                x4.d0 d0Var = (x4.d0) obj;
                int i10 = k0.N;
                if (d0Var instanceof x4.z) {
                    String string = k0Var.getString(2131952001);
                    string.getClass();
                    k0Var.A(string);
                } else if ((d0Var instanceof x4.x) && k0Var.s0()) {
                    x4.p1 p1Var = (x4.p1) a5.d.f201a.getValue();
                    if ((p1Var instanceof x4.o1 ? ((x4.o1) p1Var).f11306a : null) == null && (a8 = d0Var.a()) != null && (g = a8.g()) != null) {
                        k0Var.W(g, null);
                    }
                }
                k0Var.b0(d0Var);
                break;
            default:
                x4.u0 u0Var = (x4.u0) obj;
                int i11 = k0.N;
                boolean z9 = u0Var instanceof x4.o0;
                k0 k0Var2 = this.f1541b;
                if (z9) {
                    String string2 = k0Var2.getString(2131952001);
                    string2.getClass();
                    k0Var2.A(string2);
                } else if ((u0Var instanceof x4.s0) && k0Var2.s0()) {
                    x4.p1 p1Var2 = (x4.p1) a5.d.f201a.getValue();
                    t6.c cVar2 = null;
                    if ((p1Var2 instanceof x4.o1 ? ((x4.o1) p1Var2).f11306a : null) == null && u0Var.a() != null) {
                        x4.r a10 = u0Var.a();
                        a10.getClass();
                        File g3 = a10.g();
                        if (g3 != null) {
                            o7.c0.s(LifecycleOwnerKt.getLifecycleScope(k0Var2), null, null, new b.m(a10, k0Var2, g3, cVar2, 2), 3);
                        }
                    }
                }
                k0Var2.d0(u0Var);
                break;
        }
        return xVar;
    }
}
