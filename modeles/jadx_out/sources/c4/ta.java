package c4;

import com.uptodown.activities.Updates;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ta extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2134a;

    /* renamed from: b, reason: collision with root package name */
    public int f2135b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Updates f2136l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ta(Updates updates, int i, t6.c cVar) {
        super(2, cVar);
        this.f2134a = 2;
        this.f2136l = updates;
        this.f2135b = i;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2134a) {
            case 0:
                return new ta(this.f2136l, cVar, 0);
            case 1:
                return new ta(this.f2136l, cVar, 1);
            default:
                return new ta(this.f2136l, this.f2135b, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2134a) {
            case 0:
                ((ta) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                return u6.a.f10762a;
            case 1:
                ((ta) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                return u6.a.f10762a;
            default:
                ta taVar = (ta) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                taVar.invokeSuspend(xVar);
                return xVar;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f2134a;
        u6.a aVar = u6.a.f10762a;
        Updates updates = this.f2136l;
        switch (i) {
            case 0:
                int i6 = this.f2135b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                r7.d0 d0Var = a5.a.f192b;
                sa saVar = new sa(updates, 0);
                this.f2135b = 1;
                d0Var.f8968a.collect(saVar, this);
                return aVar;
            case 1:
                int i10 = this.f2135b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i11 = Updates.n0;
                r7.o0 o0Var = updates.U0().f1567b;
                sa saVar2 = new sa(updates, 1);
                this.f2135b = 1;
                o0Var.collect(saVar2, this);
                return aVar;
            default:
                p6.a.e(obj);
                int i12 = Updates.n0;
                if (updates.T0().f10252q.isRefreshing()) {
                    updates.T0().f10252q.setRefreshing(false);
                }
                updates.R = false;
                updates.X0(false);
                if (((Boolean) updates.U0().f1568c.getValue()).booleanValue()) {
                    int i13 = this.f2135b;
                    if (i13 <= 0) {
                        String string = updates.getString(2131952385);
                        string.getClass();
                        updates.A(string);
                    } else if (i13 == 1) {
                        String string2 = updates.getString(2131952378);
                        string2.getClass();
                        updates.A(string2);
                    } else {
                        String string3 = updates.getString(2131952379);
                        string3.getClass();
                        updates.A(string3);
                    }
                    r7.o0 o0Var2 = updates.U0().f1568c;
                    Boolean bool = Boolean.FALSE;
                    o0Var2.getClass();
                    o0Var2.g(null, bool);
                }
                e4.x0 x0Var = updates.f3356c0;
                if (x0Var != null) {
                    x0Var.notifyItemChanged(new Integer(x0Var.i).intValue());
                }
                return p6.x.f8463a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ta(Updates updates, t6.c cVar, int i) {
        super(2, cVar);
        this.f2134a = i;
        this.f2136l = updates;
    }
}
