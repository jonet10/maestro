package s4;

import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9250a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f9251b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ p2 f9252l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(s sVar, p2 p2Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f9250a = i;
        this.f9251b = sVar;
        this.f9252l = p2Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f9250a) {
            case 0:
                return new o(this.f9251b, this.f9252l, cVar, 0);
            case 1:
                return new o(this.f9251b, this.f9252l, cVar, 1);
            default:
                return new o(this.f9251b, this.f9252l, cVar, 2);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f9250a) {
            case 0:
                o oVar = (o) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                oVar.invokeSuspend(xVar);
                return xVar;
            case 1:
                o oVar2 = (o) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                oVar2.invokeSuspend(xVar2);
                return xVar2;
            default:
                o oVar3 = (o) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                oVar3.invokeSuspend(xVar3);
                return xVar3;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f9250a) {
            case 0:
                p6.a.e(obj);
                ((w4.i) this.f9251b.f9287d).b(this.f9252l);
                break;
            case 1:
                p6.a.e(obj);
                ((w4.i) this.f9251b.f9287d).i(this.f9252l);
                break;
            default:
                p6.a.e(obj);
                ((w4.i) this.f9251b.f9287d).h(this.f9252l);
                break;
        }
        return p6.x.f8463a;
    }
}
