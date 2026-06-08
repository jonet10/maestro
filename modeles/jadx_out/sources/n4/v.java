package n4;

import o7.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8020a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g4.v f8021b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.v f8022l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(g4.v vVar, kotlin.jvm.internal.v vVar2, t6.c cVar, int i) {
        super(2, cVar);
        this.f8020a = i;
        this.f8021b = vVar;
        this.f8022l = vVar2;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f8020a) {
            case 0:
                return new v(this.f8021b, this.f8022l, cVar, 0);
            case 1:
                return new v(this.f8021b, this.f8022l, cVar, 1);
            case 2:
                return new v(this.f8021b, this.f8022l, cVar, 2);
            default:
                return new v(this.f8021b, this.f8022l, cVar, 3);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f8020a) {
            case 0:
                v vVar = (v) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                vVar.invokeSuspend(xVar);
                return xVar;
            case 1:
                v vVar2 = (v) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                vVar2.invokeSuspend(xVar2);
                return xVar2;
            case 2:
                v vVar3 = (v) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                vVar3.invokeSuspend(xVar3);
                return xVar3;
            default:
                v vVar4 = (v) create(a0Var, cVar);
                p6.x xVar4 = p6.x.f8463a;
                vVar4.invokeSuspend(xVar4);
                return xVar4;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f8020a) {
            case 0:
                p6.a.e(obj);
                this.f8021b.b(this.f8022l.f7022a);
                break;
            case 1:
                p6.a.e(obj);
                this.f8021b.b(this.f8022l.f7022a);
                break;
            case 2:
                p6.a.e(obj);
                this.f8021b.b(this.f8022l.f7022a);
                break;
            default:
                p6.a.e(obj);
                this.f8021b.b(this.f8022l.f7022a);
                break;
        }
        return p6.x.f8463a;
    }
}
