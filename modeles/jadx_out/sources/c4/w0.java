package c4;

import com.uptodown.activities.FollowListActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2245a;

    /* renamed from: b, reason: collision with root package name */
    public int f2246b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ FollowListActivity f2247l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w0(FollowListActivity followListActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f2245a = i;
        this.f2247l = followListActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2245a) {
            case 0:
                return new w0(this.f2247l, cVar, 0);
            default:
                return new w0(this.f2247l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2245a) {
            case 0:
                ((w0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            default:
                ((w0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
        }
        return u6.a.f10762a;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f2245a;
        u6.a aVar = u6.a.f10762a;
        FollowListActivity followListActivity = this.f2247l;
        switch (i) {
            case 0:
                int i6 = this.f2246b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i10 = FollowListActivity.S;
                r7.o0 o0Var = followListActivity.z0().f1406b;
                v0 v0Var = new v0(followListActivity);
                this.f2246b = 1;
                o0Var.collect(v0Var, this);
                return aVar;
            default:
                int i11 = this.f2246b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i12 = FollowListActivity.S;
                r7.o0 o0Var2 = followListActivity.z0().f1408d;
                c3.y0 y0Var = new c3.y0(followListActivity, 2);
                this.f2246b = 1;
                o0Var2.collect(y0Var, this);
                return aVar;
        }
    }
}
