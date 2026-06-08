package n4;

import o7.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8017a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g4.v f8018b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.w f8019l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(g4.v vVar, kotlin.jvm.internal.w wVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f8017a = i;
        this.f8018b = vVar;
        this.f8019l = wVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f8017a) {
            case 0:
                return new u(this.f8018b, this.f8019l, cVar, 0);
            case 1:
                return new u(this.f8018b, this.f8019l, cVar, 1);
            case 2:
                return new u(this.f8018b, this.f8019l, cVar, 2);
            default:
                return new u(this.f8018b, this.f8019l, cVar, 3);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f8017a) {
            case 0:
                u uVar = (u) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                uVar.invokeSuspend(xVar);
                return xVar;
            case 1:
                u uVar2 = (u) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                uVar2.invokeSuspend(xVar2);
                return xVar2;
            case 2:
                u uVar3 = (u) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                uVar3.invokeSuspend(xVar3);
                return xVar3;
            default:
                u uVar4 = (u) create(a0Var, cVar);
                p6.x xVar4 = p6.x.f8463a;
                uVar4.invokeSuspend(xVar4);
                return xVar4;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f8017a) {
            case 0:
                p6.a.e(obj);
                this.f8018b.i(this.f8019l.f7023a);
                break;
            case 1:
                p6.a.e(obj);
                this.f8018b.i(this.f8019l.f7023a);
                break;
            case 2:
                p6.a.e(obj);
                this.f8018b.i(this.f8019l.f7023a);
                break;
            default:
                p6.a.e(obj);
                this.f8018b.i(this.f8019l.f7023a);
                break;
        }
        return p6.x.f8463a;
    }
}
