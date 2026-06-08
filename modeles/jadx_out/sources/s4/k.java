package s4;

import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9224a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y2.s f9225b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ p2 f9226l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(y2.s sVar, p2 p2Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f9224a = i;
        this.f9225b = sVar;
        this.f9226l = p2Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f9224a) {
            case 0:
                return new k(this.f9225b, this.f9226l, cVar, 0);
            case 1:
                return new k(this.f9225b, this.f9226l, cVar, 1);
            default:
                return new k(this.f9225b, this.f9226l, cVar, 2);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f9224a) {
            case 0:
                k kVar = (k) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                kVar.invokeSuspend(xVar);
                return xVar;
            case 1:
                k kVar2 = (k) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                kVar2.invokeSuspend(xVar2);
                return xVar2;
            default:
                k kVar3 = (k) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                kVar3.invokeSuspend(xVar3);
                return xVar3;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f9224a) {
            case 0:
                p6.a.e(obj);
                u4.y0 y0Var = (u4.y0) this.f9225b.f11756l;
                y0Var.getClass();
                y0Var.f10664a.f10673n = this.f9226l;
                break;
            case 1:
                p6.a.e(obj);
                u4.y0 y0Var2 = (u4.y0) this.f9225b.f11756l;
                y0Var2.getClass();
                y0Var2.f10664a.f10674o = this.f9226l;
                break;
            default:
                p6.a.e(obj);
                y2.s sVar = this.f9225b;
                if (((x4.j) sVar.f11757m).f11224a != 523) {
                    u4.y0 y0Var3 = (u4.y0) sVar.f11756l;
                    y0Var3.getClass();
                    p2 p2Var = this.f9226l;
                    p2Var.getClass();
                    e4.h hVar = y0Var3.f10664a.f10670b;
                    if (hVar != null) {
                        hVar.b(p2Var);
                    }
                }
                break;
        }
        return p6.x.f8463a;
    }
}
