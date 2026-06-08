package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1657a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1658b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ k0 f1659l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(k0 k0Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f1657a = i;
        this.f1659l = k0Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1657a) {
            case 0:
                h0 h0Var = new h0(this.f1659l, cVar, 0);
                h0Var.f1658b = obj;
                return h0Var;
            case 1:
                h0 h0Var2 = new h0(this.f1659l, cVar, 1);
                h0Var2.f1658b = obj;
                return h0Var2;
            default:
                h0 h0Var3 = new h0(this.f1659l, cVar, 2);
                h0Var3.f1658b = obj;
                return h0Var3;
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1657a) {
            case 0:
                h0 h0Var = (h0) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar = p6.x.f8463a;
                h0Var.invokeSuspend(xVar);
                return xVar;
            case 1:
                h0 h0Var2 = (h0) create((x4.p1) obj, (t6.c) obj2);
                p6.x xVar2 = p6.x.f8463a;
                h0Var2.invokeSuspend(xVar2);
                return xVar2;
            default:
                h0 h0Var3 = (h0) create((x4.m1) obj, (t6.c) obj2);
                p6.x xVar3 = p6.x.f8463a;
                h0Var3.invokeSuspend(xVar3);
                return xVar3;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f1657a;
        t6.c cVar = null;
        p6.x xVar = p6.x.f8463a;
        k0 k0Var = this.f1659l;
        switch (i) {
            case 0:
                o7.a0 a0Var = (o7.a0) this.f1658b;
                p6.a.e(obj);
                o7.c0.s(a0Var, null, null, new f0(k0Var, cVar, 0), 3);
                o7.c0.s(a0Var, null, null, new f0(k0Var, cVar, 1), 3);
                o7.c0.s(a0Var, null, null, new f0(k0Var, cVar, 2), 3);
                o7.c0.s(a0Var, null, null, new f0(k0Var, cVar, 3), 3);
                break;
            case 1:
                x4.p1 p1Var = (x4.p1) this.f1658b;
                p6.a.e(obj);
                int i6 = k0.N;
                if (!(p1Var instanceof x4.o1)) {
                    if (!(p1Var instanceof x4.n1)) {
                        com.google.gson.internal.a.b();
                        break;
                    } else {
                        k0Var.g0();
                    }
                } else {
                    k0Var.h0(((x4.o1) p1Var).f11306a);
                }
                break;
            default:
                x4.m1 m1Var = (x4.m1) this.f1658b;
                p6.a.e(obj);
                int i10 = k0.N;
                if (!(m1Var instanceof x4.k1)) {
                    if (!(m1Var instanceof x4.l1)) {
                        if (!(m1Var instanceof x4.h1)) {
                            if (!(m1Var instanceof x4.j1)) {
                                if (!(m1Var instanceof x4.i1)) {
                                    com.google.gson.internal.a.b();
                                    break;
                                } else {
                                    k0Var.Z(((x4.i1) m1Var).f11217a);
                                }
                            } else {
                                k0Var.a0(((x4.j1) m1Var).f11243a);
                            }
                        } else {
                            k0Var.Y(((x4.h1) m1Var).f11210a);
                        }
                    } else {
                        x4.l1 l1Var = (x4.l1) m1Var;
                        k0Var.f0(l1Var.f11274a, l1Var.f11275b);
                    }
                } else {
                    k0Var.e0(((x4.k1) m1Var).f11256a);
                }
                break;
        }
        return null;
    }
}
