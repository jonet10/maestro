package n4;

import o7.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7986a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k4.c f7987b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(int i, k4.c cVar, t6.c cVar2) {
        super(2, cVar2);
        this.f7986a = i;
        this.f7987b = cVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f7986a) {
            case 0:
                return new o(0, this.f7987b, cVar);
            case 1:
                return new o(1, this.f7987b, cVar);
            default:
                return new o(2, this.f7987b, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f7986a) {
        }
        return ((o) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f7986a;
        p6.x xVar = p6.x.f8463a;
        k4.c cVar = this.f7987b;
        switch (i) {
            case 0:
                p6.a.e(obj);
                if (cVar != null) {
                    cVar.w();
                    break;
                }
                break;
            case 1:
                p6.a.e(obj);
                if (cVar != null) {
                    cVar.v();
                    break;
                }
                break;
            default:
                p6.a.e(obj);
                if (cVar != null) {
                    cVar.e(100);
                    break;
                }
                break;
        }
        return xVar;
    }
}
