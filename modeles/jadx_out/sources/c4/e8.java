package c4;

import com.uptodown.activities.RecommendedActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e8 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1558a;

    /* renamed from: b, reason: collision with root package name */
    public int f1559b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ RecommendedActivity f1560l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e8(RecommendedActivity recommendedActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f1558a = i;
        this.f1560l = recommendedActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1558a) {
            case 0:
                return new e8(this.f1560l, cVar, 0);
            default:
                return new e8(this.f1560l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1558a) {
            case 0:
                ((e8) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            default:
                ((e8) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
        }
        return u6.a.f10762a;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f1558a;
        u6.a aVar = u6.a.f10762a;
        RecommendedActivity recommendedActivity = this.f1560l;
        switch (i) {
            case 0:
                int i6 = this.f1559b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i10 = RecommendedActivity.f3338g0;
                r7.o0 o0Var = recommendedActivity.O0().f1726b;
                d8 d8Var = new d8(recommendedActivity, 0);
                this.f1559b = 1;
                o0Var.collect(d8Var, this);
                return aVar;
            default:
                int i11 = this.f1559b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i12 = RecommendedActivity.f3338g0;
                r7.o0 o0Var2 = recommendedActivity.O0().f1728d;
                d8 d8Var2 = new d8(recommendedActivity, 1);
                this.f1559b = 1;
                o0Var2.collect(d8Var2, this);
                return aVar;
        }
    }
}
