package c4;

import com.uptodown.activities.UserActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class lb extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1837a;

    /* renamed from: b, reason: collision with root package name */
    public int f1838b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ UserActivity f1839l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ lb(UserActivity userActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f1837a = i;
        this.f1839l = userActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1837a) {
            case 0:
                return new lb(this.f1839l, cVar, 0);
            case 1:
                return new lb(this.f1839l, cVar, 1);
            default:
                return new lb(this.f1839l, cVar, 2);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1837a) {
            case 0:
                ((lb) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            case 1:
                ((lb) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            default:
                ((lb) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
        }
        return u6.a.f10762a;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1837a) {
            case 0:
                int i = this.f1838b;
                if (i != 0) {
                    if (i == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                UserActivity userActivity = this.f1839l;
                r7.o0 o0Var = userActivity.A0().f2409b;
                kb kbVar = new kb(userActivity, 0);
                this.f1838b = 1;
                o0Var.collect(kbVar, this);
                return u6.a.f10762a;
            case 1:
                int i6 = this.f1838b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                UserActivity userActivity2 = this.f1839l;
                r7.o0 o0Var2 = userActivity2.A0().f2411d;
                kb kbVar2 = new kb(userActivity2, 1);
                this.f1838b = 1;
                o0Var2.collect(kbVar2, this);
                return u6.a.f10762a;
            default:
                int i10 = this.f1838b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                UserActivity userActivity3 = this.f1839l;
                r7.o0 o0Var3 = userActivity3.A0().f;
                kb kbVar3 = new kb(userActivity3, 2);
                this.f1838b = 1;
                o0Var3.collect(kbVar3, this);
                return u6.a.f10762a;
        }
    }
}
