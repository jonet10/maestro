package j4;

import a2.t;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6584a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f6585b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f6586l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(t tVar, int i, t6.c cVar, int i6) {
        super(2, cVar);
        this.f6584a = i6;
        this.f6585b = tVar;
        this.f6586l = i;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f6584a) {
            case 0:
                return new d(this.f6585b, this.f6586l, cVar, 0);
            default:
                return new d(this.f6585b, this.f6586l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f6584a) {
            case 0:
                d dVar = (d) create(a0Var, cVar);
                x xVar = x.f8463a;
                dVar.invokeSuspend(xVar);
                return xVar;
            default:
                d dVar2 = (d) create(a0Var, cVar);
                x xVar2 = x.f8463a;
                dVar2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f6584a) {
            case 0:
                p6.a.e(obj);
                ((a3.d) this.f6585b.f54c).E(this.f6586l);
                break;
            default:
                p6.a.e(obj);
                ((a3.d) this.f6585b.f54c).E(this.f6586l);
                break;
        }
        return x.f8463a;
    }
}
