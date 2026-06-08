package c4;

import com.uptodown.activities.FeedActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2004a;

    /* renamed from: b, reason: collision with root package name */
    public int f2005b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ FeedActivity f2006l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q0(FeedActivity feedActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f2004a = i;
        this.f2006l = feedActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2004a) {
            case 0:
                return new q0(this.f2006l, cVar, 0);
            case 1:
                return new q0(this.f2006l, cVar, 1);
            default:
                return new q0(this.f2006l, cVar, 2);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2004a) {
            case 0:
                ((q0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                return u6.a.f10762a;
            case 1:
                ((q0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                return u6.a.f10762a;
            default:
                return ((q0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f2004a;
        FeedActivity feedActivity = this.f2006l;
        u6.a aVar = u6.a.f10762a;
        t6.c cVar = null;
        int i6 = 1;
        switch (i) {
            case 0:
                int i10 = this.f2005b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i11 = FeedActivity.S;
                r7.o0 o0Var = feedActivity.z0().f2106b;
                p0 p0Var = new p0(feedActivity);
                this.f2005b = 1;
                o0Var.collect(p0Var, this);
                return aVar;
            case 1:
                int i12 = this.f2005b;
                if (i12 != 0) {
                    if (i12 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i13 = FeedActivity.S;
                r7.o0 o0Var2 = feedActivity.z0().f2108d;
                c3.y0 y0Var = new c3.y0(feedActivity, i6);
                this.f2005b = 1;
                o0Var2.collect(y0Var, this);
                return aVar;
            default:
                int i14 = this.f2005b;
                p6.x xVar = p6.x.f8463a;
                if (i14 == 0) {
                    p6.a.e(obj);
                    r.k kVar = new r.k(feedActivity);
                    this.f2005b = 1;
                    v7.e eVar = o7.m0.f8288a;
                    Object C = o7.c0.C(new g(kVar, cVar, 23), v7.d.f10884a, this);
                    if (C != aVar) {
                        C = xVar;
                    }
                    if (C == aVar) {
                        return aVar;
                    }
                } else {
                    if (i14 != 1) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    p6.a.e(obj);
                }
                return xVar;
        }
    }
}
