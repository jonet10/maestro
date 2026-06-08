package c4;

import com.uptodown.activities.UserCommentsActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class xb extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2315a;

    /* renamed from: b, reason: collision with root package name */
    public int f2316b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ UserCommentsActivity f2317l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ xb(UserCommentsActivity userCommentsActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f2315a = i;
        this.f2317l = userCommentsActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2315a) {
            case 0:
                return new xb(this.f2317l, cVar, 0);
            default:
                return new xb(this.f2317l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2315a) {
            case 0:
                ((xb) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            default:
                ((xb) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
        }
        return u6.a.f10762a;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f2315a;
        u6.a aVar = u6.a.f10762a;
        UserCommentsActivity userCommentsActivity = this.f2317l;
        switch (i) {
            case 0:
                int i6 = this.f2316b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i10 = UserCommentsActivity.S;
                r7.o0 o0Var = userCommentsActivity.z0().f1434b;
                wb wbVar = new wb(userCommentsActivity);
                this.f2316b = 1;
                o0Var.collect(wbVar, this);
                return aVar;
            default:
                int i11 = this.f2316b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i12 = UserCommentsActivity.S;
                r7.o0 o0Var2 = userCommentsActivity.z0().f1436d;
                c3.y0 y0Var = new c3.y0(userCommentsActivity, 13);
                this.f2316b = 1;
                o0Var2.collect(y0Var, this);
                return aVar;
        }
    }
}
