package s4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9257a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f9258b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ArrayList f9259l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(s sVar, ArrayList arrayList, t6.c cVar, int i) {
        super(2, cVar);
        this.f9257a = i;
        this.f9258b = sVar;
        this.f9259l = arrayList;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f9257a) {
            case 0:
                return new p(this.f9258b, this.f9259l, cVar, 0);
            default:
                return new p(this.f9258b, this.f9259l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f9257a) {
            case 0:
                p pVar = (p) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                pVar.invokeSuspend(xVar);
                return xVar;
            default:
                p pVar2 = (p) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                pVar2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f9257a) {
            case 0:
                p6.a.e(obj);
                ((w4.i) this.f9258b.f9287d).e(this.f9259l);
                break;
            default:
                p6.a.e(obj);
                ((w4.i) this.f9258b.f9287d).j(this.f9259l);
                break;
        }
        return p6.x.f8463a;
    }
}
