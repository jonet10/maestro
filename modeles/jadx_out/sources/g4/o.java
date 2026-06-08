package g4;

import com.uptodown.core.activities.FileExplorerActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5230a;

    /* renamed from: b, reason: collision with root package name */
    public int f5231b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f5232l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(FileExplorerActivity fileExplorerActivity, int i, t6.c cVar) {
        super(2, cVar);
        this.f5230a = 3;
        this.f5232l = fileExplorerActivity;
        this.f5231b = i;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f5230a) {
            case 0:
                return new o(this.f5232l, cVar, 0);
            case 1:
                return new o(this.f5232l, cVar, 1);
            case 2:
                return new o(this.f5232l, cVar, 2);
            case 3:
                return new o(this.f5232l, this.f5231b, cVar);
            default:
                return new o(this.f5232l, cVar, 4);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f5230a) {
            case 0:
                return ((o) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 1:
                return ((o) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 2:
                return ((o) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 3:
                o oVar = (o) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                oVar.invokeSuspend(xVar);
                return xVar;
            default:
                return ((o) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f5230a) {
            case 0:
                int i = this.f5231b;
                if (i == 0) {
                    p6.a.e(obj);
                    this.f5231b = 1;
                    Object I = FileExplorerActivity.I(this.f5232l, this);
                    u6.a aVar = u6.a.f10762a;
                    if (I == aVar) {
                        break;
                    }
                } else if (i != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
            case 1:
                int i6 = this.f5231b;
                if (i6 == 0) {
                    p6.a.e(obj);
                    this.f5231b = 1;
                    Object K = FileExplorerActivity.K(this.f5232l, this);
                    u6.a aVar2 = u6.a.f10762a;
                    if (K == aVar2) {
                        break;
                    }
                } else if (i6 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
            case 2:
                int i10 = this.f5231b;
                if (i10 == 0) {
                    p6.a.e(obj);
                    this.f5231b = 1;
                    Object L = FileExplorerActivity.L(this.f5232l, this);
                    u6.a aVar3 = u6.a.f10762a;
                    if (L == aVar3) {
                        break;
                    }
                } else if (i10 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
            case 3:
                p6.a.e(obj);
                i4.b bVar = this.f5232l.V;
                bVar.getClass();
                bVar.notifyItemRemoved(this.f5231b);
                break;
            default:
                int i11 = this.f5231b;
                if (i11 == 0) {
                    p6.a.e(obj);
                    this.f5231b = 1;
                    Object O = FileExplorerActivity.O(this.f5232l, this);
                    u6.a aVar4 = u6.a.f10762a;
                    if (O == aVar4) {
                        break;
                    }
                } else if (i11 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
        }
        return p6.x.f8463a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(FileExplorerActivity fileExplorerActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f5230a = i;
        this.f5232l = fileExplorerActivity;
    }
}
