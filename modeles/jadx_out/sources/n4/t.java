package n4;

import o7.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8015a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g4.v f8016b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(g4.v vVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f8015a = i;
        this.f8016b = vVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f8015a) {
            case 0:
                return new t(this.f8016b, cVar, 0);
            case 1:
                return new t(this.f8016b, cVar, 1);
            case 2:
                return new t(this.f8016b, cVar, 2);
            case 3:
                return new t(this.f8016b, cVar, 3);
            case 4:
                return new t(this.f8016b, cVar, 4);
            case 5:
                return new t(this.f8016b, cVar, 5);
            case 6:
                return new t(this.f8016b, cVar, 6);
            default:
                return new t(this.f8016b, cVar, 7);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f8015a) {
            case 0:
                t tVar = (t) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                tVar.invokeSuspend(xVar);
                return xVar;
            case 1:
                t tVar2 = (t) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                tVar2.invokeSuspend(xVar2);
                return xVar2;
            case 2:
                t tVar3 = (t) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                tVar3.invokeSuspend(xVar3);
                return xVar3;
            case 3:
                t tVar4 = (t) create(a0Var, cVar);
                p6.x xVar4 = p6.x.f8463a;
                tVar4.invokeSuspend(xVar4);
                return xVar4;
            case 4:
                t tVar5 = (t) create(a0Var, cVar);
                p6.x xVar5 = p6.x.f8463a;
                tVar5.invokeSuspend(xVar5);
                return xVar5;
            case 5:
                t tVar6 = (t) create(a0Var, cVar);
                p6.x xVar6 = p6.x.f8463a;
                tVar6.invokeSuspend(xVar6);
                return xVar6;
            case 6:
                t tVar7 = (t) create(a0Var, cVar);
                p6.x xVar7 = p6.x.f8463a;
                tVar7.invokeSuspend(xVar7);
                return xVar7;
            default:
                t tVar8 = (t) create(a0Var, cVar);
                p6.x xVar8 = p6.x.f8463a;
                tVar8.invokeSuspend(xVar8);
                return xVar8;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f8015a) {
            case 0:
                p6.a.e(obj);
                this.f8016b.c();
                break;
            case 1:
                p6.a.e(obj);
                this.f8016b.c();
                break;
            case 2:
                p6.a.e(obj);
                this.f8016b.h();
                break;
            case 3:
                p6.a.e(obj);
                this.f8016b.h();
                break;
            case 4:
                p6.a.e(obj);
                this.f8016b.c();
                break;
            case 5:
                p6.a.e(obj);
                this.f8016b.c();
                break;
            case 6:
                p6.a.e(obj);
                this.f8016b.h();
                break;
            default:
                p6.a.e(obj);
                this.f8016b.h();
                break;
        }
        return p6.x.f8463a;
    }
}
