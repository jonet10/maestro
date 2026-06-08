package j4;

import a2.t;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6655a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f6656b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(t tVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f6655a = i;
        this.f6656b = tVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f6655a) {
            case 0:
                return new p(this.f6656b, cVar, 0);
            default:
                return new p(this.f6656b, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f6655a) {
            case 0:
                p pVar = (p) create(a0Var, cVar);
                x xVar = x.f8463a;
                pVar.invokeSuspend(xVar);
                return xVar;
            default:
                p pVar2 = (p) create(a0Var, cVar);
                x xVar2 = x.f8463a;
                pVar2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f6655a) {
            case 0:
                p6.a.e(obj);
                ((k4.c) this.f6656b.f55d).t();
                break;
            default:
                p6.a.e(obj);
                ((k4.c) this.f6656b.f55d).z();
                break;
        }
        return x.f8463a;
    }
}
