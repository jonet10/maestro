package c4;

import com.uptodown.activities.FreeUpSpaceActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e1 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1542a;

    /* renamed from: b, reason: collision with root package name */
    public int f1543b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ FreeUpSpaceActivity f1544l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e1(FreeUpSpaceActivity freeUpSpaceActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f1542a = i;
        this.f1544l = freeUpSpaceActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1542a) {
            case 0:
                return new e1(this.f1544l, cVar, 0);
            default:
                return new e1(this.f1544l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1542a) {
            case 0:
                return ((e1) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            default:
                ((e1) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                return u6.a.f10762a;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f1542a;
        u6.a aVar = u6.a.f10762a;
        FreeUpSpaceActivity freeUpSpaceActivity = this.f1544l;
        t6.c cVar = null;
        switch (i) {
            case 0:
                int i6 = this.f1543b;
                p6.x xVar = p6.x.f8463a;
                if (i6 == 0) {
                    p6.a.e(obj);
                    d1 d1Var = new d1(freeUpSpaceActivity, cVar, 0);
                    this.f1543b = 1;
                    v7.e eVar = o7.m0.f8288a;
                    Object C = o7.c0.C(new s4.a(freeUpSpaceActivity, d1Var, null), v7.d.f10884a, this);
                    if (C != aVar) {
                        C = xVar;
                    }
                    if (C == aVar) {
                        return aVar;
                    }
                } else {
                    if (i6 != 1) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    p6.a.e(obj);
                }
                return xVar;
            default:
                int i10 = this.f1543b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i11 = FreeUpSpaceActivity.T;
                r7.o0 o0Var = ((m1) freeUpSpaceActivity.P.getValue()).f1852b;
                c3.y0 y0Var = new c3.y0(freeUpSpaceActivity, 3);
                this.f1543b = 1;
                o0Var.collect(y0Var, this);
                return aVar;
        }
    }
}
