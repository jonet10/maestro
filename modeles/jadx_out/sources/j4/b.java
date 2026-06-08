package j4;

import a2.t;
import c4.w4;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6570a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f6571b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ l4.b f6572l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(t tVar, l4.b bVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f6570a = i;
        this.f6571b = tVar;
        this.f6572l = bVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f6570a) {
            case 0:
                return new b(this.f6571b, this.f6572l, cVar, 0);
            case 1:
                return new b(this.f6571b, this.f6572l, cVar, 1);
            case 2:
                return new b(this.f6571b, this.f6572l, cVar, 2);
            case 3:
                return new b(this.f6571b, this.f6572l, cVar, 3);
            default:
                return new b(this.f6571b, this.f6572l, cVar, 4);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f6570a) {
            case 0:
                b bVar = (b) create(a0Var, cVar);
                x xVar = x.f8463a;
                bVar.invokeSuspend(xVar);
                return xVar;
            case 1:
                b bVar2 = (b) create(a0Var, cVar);
                x xVar2 = x.f8463a;
                bVar2.invokeSuspend(xVar2);
                return xVar2;
            case 2:
                b bVar3 = (b) create(a0Var, cVar);
                x xVar3 = x.f8463a;
                bVar3.invokeSuspend(xVar3);
                return xVar3;
            case 3:
                b bVar4 = (b) create(a0Var, cVar);
                x xVar4 = x.f8463a;
                bVar4.invokeSuspend(xVar4);
                return xVar4;
            default:
                b bVar5 = (b) create(a0Var, cVar);
                x xVar5 = x.f8463a;
                bVar5.invokeSuspend(xVar5);
                return xVar5;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f6570a;
        l4.b bVar = this.f6572l;
        x xVar = x.f8463a;
        t tVar = this.f6571b;
        switch (i) {
            case 0:
                p6.a.e(obj);
                a3.d dVar = (a3.d) tVar.f54c;
                bVar.getClass();
                w4 w4Var = (w4) dVar.f63b;
                w4Var.i(w4Var.getString(2131951742));
                break;
            case 1:
                p6.a.e(obj);
                a3.d dVar2 = (a3.d) tVar.f54c;
                bVar.getClass();
                w4 w4Var2 = (w4) dVar2.f63b;
                w4Var2.i(w4Var2.getString(2131951742));
                break;
            case 2:
                p6.a.e(obj);
                a3.d dVar3 = (a3.d) tVar.f54c;
                bVar.getClass();
                w4 w4Var3 = (w4) dVar3.f63b;
                w4Var3.i(w4Var3.getString(2131951877));
                break;
            case 3:
                p6.a.e(obj);
                w4 w4Var4 = (w4) ((a3.d) tVar.f54c).f63b;
                w4Var4.i(w4Var4.getString(2131951742));
                break;
            default:
                p6.a.e(obj);
                w4 w4Var5 = (w4) ((a3.d) tVar.f54c).f63b;
                w4Var5.i(w4Var5.getString(2131951877));
                break;
        }
        return xVar;
    }
}
