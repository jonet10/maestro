package c4;

import com.uptodown.activities.SearchActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u9 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2175a;

    /* renamed from: b, reason: collision with root package name */
    public int f2176b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f2177l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u9(SearchActivity searchActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f2175a = i;
        this.f2177l = searchActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2175a) {
            case 0:
                return new u9(this.f2177l, cVar, 0);
            default:
                return new u9(this.f2177l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2175a) {
            case 0:
                ((u9) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            default:
                ((u9) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
        }
        return u6.a.f10762a;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f2175a;
        u6.a aVar = u6.a.f10762a;
        SearchActivity searchActivity = this.f2177l;
        switch (i) {
            case 0:
                int i6 = this.f2176b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i10 = SearchActivity.Y;
                r7.o0 o0Var = searchActivity.A0().f1475b;
                t9 t9Var = new t9(searchActivity);
                this.f2176b = 1;
                o0Var.collect(t9Var, this);
                return aVar;
            default:
                int i11 = this.f2176b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i12 = SearchActivity.Y;
                r7.o0 o0Var2 = searchActivity.A0().f1477d;
                v9 v9Var = new v9(searchActivity);
                this.f2176b = 1;
                o0Var2.collect(v9Var, this);
                return aVar;
        }
    }
}
