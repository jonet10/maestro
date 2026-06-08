package c4;

import com.uptodown.activities.MyApps;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j4 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1755a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MyApps f1756b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j4(MyApps myApps, t6.c cVar, int i) {
        super(2, cVar);
        this.f1755a = i;
        this.f1756b = myApps;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1755a) {
            case 0:
                return new j4(this.f1756b, cVar, 0);
            default:
                return new j4(this.f1756b, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1755a) {
            case 0:
                j4 j4Var = (j4) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                j4Var.invokeSuspend(xVar);
                return xVar;
            default:
                j4 j4Var2 = (j4) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                j4Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f1755a;
        p6.x xVar = p6.x.f8463a;
        MyApps myApps = this.f1756b;
        switch (i) {
            case 0:
                p6.a.e(obj);
                int i6 = MyApps.f3328g0;
                myApps.P0().f10221l.setVisibility(0);
                break;
            default:
                p6.a.e(obj);
                myApps.S0(false);
                break;
        }
        return xVar;
    }
}
