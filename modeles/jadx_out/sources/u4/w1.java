package u4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w1 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10652a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z1 f10653b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ x4.g f10654l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w1(z1 z1Var, x4.g gVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f10652a = i;
        this.f10653b = z1Var;
        this.f10654l = gVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f10652a) {
            case 0:
                return new w1(this.f10653b, this.f10654l, cVar, 0);
            case 1:
                return new w1(this.f10653b, this.f10654l, cVar, 1);
            default:
                return new w1(this.f10653b, this.f10654l, cVar, 2);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f10652a) {
            case 0:
                w1 w1Var = (w1) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                w1Var.invokeSuspend(xVar);
                return xVar;
            case 1:
                w1 w1Var2 = (w1) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                w1Var2.invokeSuspend(xVar2);
                return xVar2;
            default:
                w1 w1Var3 = (w1) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                w1Var3.invokeSuspend(xVar3);
                return xVar3;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f10652a) {
            case 0:
                p6.a.e(obj);
                e4.q0 q0Var = this.f10653b.f10685o;
                if (q0Var != null) {
                    q0Var.b(this.f10654l);
                }
                break;
            case 1:
                p6.a.e(obj);
                e4.q0 q0Var2 = this.f10653b.f10685o;
                if (q0Var2 != null) {
                    q0Var2.b(this.f10654l);
                }
                break;
            default:
                p6.a.e(obj);
                z1 z1Var = this.f10653b;
                e4.q0 q0Var3 = z1Var.f10685o;
                q0Var3.getClass();
                q0Var3.notifyItemChanged(z1Var.c(this.f10654l.F));
                break;
        }
        return p6.x.f8463a;
    }
}
