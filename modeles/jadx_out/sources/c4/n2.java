package c4;

import com.uptodown.activities.LoginActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n2 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1889a;

    /* renamed from: b, reason: collision with root package name */
    public int f1890b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ LoginActivity f1891l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n2(LoginActivity loginActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f1889a = i;
        this.f1891l = loginActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1889a) {
            case 0:
                return new n2(this.f1891l, cVar, 0);
            default:
                return new n2(this.f1891l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1889a) {
            case 0:
                ((n2) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            default:
                ((n2) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
        }
        return u6.a.f10762a;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f1889a;
        u6.a aVar = u6.a.f10762a;
        LoginActivity loginActivity = this.f1891l;
        int i6 = 1;
        switch (i) {
            case 0:
                int i10 = this.f1890b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i11 = LoginActivity.W;
                r7.o0 o0Var = loginActivity.H0().f2290b;
                m2 m2Var = new m2(loginActivity, 0);
                this.f1890b = 1;
                o0Var.collect(m2Var, this);
                return aVar;
            default:
                int i12 = this.f1890b;
                if (i12 != 0) {
                    if (i12 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i13 = LoginActivity.W;
                r7.o0 o0Var2 = loginActivity.H0().f2292d;
                m2 m2Var2 = new m2(loginActivity, i6);
                this.f1890b = 1;
                o0Var2.collect(m2Var2, this);
                return aVar;
        }
    }
}
