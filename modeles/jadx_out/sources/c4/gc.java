package c4;

import com.uptodown.activities.UserDeviceDetailsActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class gc extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1649a;

    /* renamed from: b, reason: collision with root package name */
    public int f1650b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ UserDeviceDetailsActivity f1651l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ gc(UserDeviceDetailsActivity userDeviceDetailsActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f1649a = i;
        this.f1651l = userDeviceDetailsActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1649a) {
            case 0:
                return new gc(this.f1651l, cVar, 0);
            case 1:
                return new gc(this.f1651l, cVar, 1);
            default:
                return new gc(this.f1651l, cVar, 2);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1649a) {
            case 0:
                ((gc) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            case 1:
                ((gc) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            default:
                ((gc) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
        }
        return u6.a.f10762a;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1649a) {
            case 0:
                int i = this.f1650b;
                if (i != 0) {
                    if (i == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                UserDeviceDetailsActivity userDeviceDetailsActivity = this.f1651l;
                r7.o0 o0Var = userDeviceDetailsActivity.z0().f1921c;
                fc fcVar = new fc(userDeviceDetailsActivity, 0);
                this.f1650b = 1;
                o0Var.collect(fcVar, this);
                return u6.a.f10762a;
            case 1:
                int i6 = this.f1650b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                UserDeviceDetailsActivity userDeviceDetailsActivity2 = this.f1651l;
                r7.o0 o0Var2 = userDeviceDetailsActivity2.z0().f1923e;
                fc fcVar2 = new fc(userDeviceDetailsActivity2, 1);
                this.f1650b = 1;
                o0Var2.collect(fcVar2, this);
                return u6.a.f10762a;
            default:
                int i10 = this.f1650b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                UserDeviceDetailsActivity userDeviceDetailsActivity3 = this.f1651l;
                r7.o0 o0Var3 = userDeviceDetailsActivity3.z0().g;
                fc fcVar3 = new fc(userDeviceDetailsActivity3, 2);
                this.f1650b = 1;
                o0Var3.collect(fcVar3, this);
                return u6.a.f10762a;
        }
    }
}
