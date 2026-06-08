package c4;

import com.uptodown.activities.MyApps;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h4 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1674a;

    /* renamed from: b, reason: collision with root package name */
    public int f1675b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ MyApps f1676l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h4(MyApps myApps, t6.c cVar, int i) {
        super(2, cVar);
        this.f1674a = i;
        this.f1676l = myApps;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1674a) {
            case 0:
                return new h4(this.f1676l, cVar, 0);
            default:
                return new h4(this.f1676l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1674a) {
            case 0:
                ((h4) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            default:
                ((h4) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
        }
        return u6.a.f10762a;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f1674a;
        u6.a aVar = u6.a.f10762a;
        MyApps myApps = this.f1676l;
        switch (i) {
            case 0:
                int i6 = this.f1675b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                r7.d0 d0Var = a5.a.f192b;
                g4 g4Var = new g4(myApps, 0);
                this.f1675b = 1;
                d0Var.f8968a.collect(g4Var, this);
                return aVar;
            default:
                int i10 = this.f1675b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i11 = MyApps.f3328g0;
                r7.o0 o0Var = myApps.R0().f2342b;
                g4 g4Var2 = new g4(myApps, 1);
                this.f1675b = 1;
                o0Var.collect(g4Var2, this);
                return aVar;
        }
    }
}
