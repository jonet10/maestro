package e6;

import a4.d0;
import d6.f;
import f0.i;
import f6.b;
import f6.c;
import f6.d;
import f6.e;
import f6.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4756a;

    public /* synthetic */ a(int i) {
        this.f4756a = i;
    }

    public final Object a(d0 d0Var, i iVar) {
        switch (this.f4756a) {
            case 0:
                return new f6.a((f) d0Var.f81b, 0);
            case 1:
                return new c((f) d0Var.f81b);
            case 2:
                return new j5.f((f) d0Var.f81b, 2);
            case 3:
                return new d(0);
            case 4:
                return new e((f) d0Var.f81b, ((Integer) d6.e.f3609d.a(iVar)).intValue());
            case 5:
                return new f6.f((f) d0Var.f81b, (String) d6.e.f3610e.a(iVar), (q2.e) d0Var.f83m);
            case 6:
                f fVar = (f) d0Var.f81b;
                return d6.d.f3603a == d6.e.f3606a.a(iVar) ? new b(fVar, ((Integer) d6.e.f3607b.a(iVar)).intValue()) : new h(fVar, String.valueOf(d6.e.f3608c.a(iVar)).concat(". "));
            case 7:
                return new d(1);
            default:
                return new f6.a((f) d0Var.f81b, 1);
        }
    }
}
