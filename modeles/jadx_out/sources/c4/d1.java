package c4;

import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.Updates;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d1 extends v6.i implements d7.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1498a;

    /* renamed from: b, reason: collision with root package name */
    public int f1499b;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ String f1500l;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ long f1501m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ k0 f1502n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d1(k0 k0Var, t6.c cVar, int i) {
        super(3, cVar);
        this.f1498a = i;
        this.f1502n = k0Var;
    }

    @Override // d7.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        String str = (String) obj;
        Number number = (Number) obj2;
        switch (this.f1498a) {
            case 0:
                long longValue = number.longValue();
                d1 d1Var = new d1((FreeUpSpaceActivity) this.f1502n, (t6.c) obj3, 0);
                d1Var.f1500l = str;
                d1Var.f1501m = longValue;
                return d1Var.invokeSuspend(p6.x.f8463a);
            case 1:
                long longValue2 = number.longValue();
                d1 d1Var2 = new d1((MyApps) this.f1502n, (t6.c) obj3, 1);
                d1Var2.f1500l = str;
                d1Var2.f1501m = longValue2;
                return d1Var2.invokeSuspend(p6.x.f8463a);
            default:
                long longValue3 = number.longValue();
                d1 d1Var3 = new d1((Updates) this.f1502n, (t6.c) obj3, 2);
                d1Var3.f1500l = str;
                d1Var3.f1501m = longValue3;
                return d1Var3.invokeSuspend(p6.x.f8463a);
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f1498a;
        p6.x xVar = p6.x.f8463a;
        k0 k0Var = this.f1502n;
        u6.a aVar = u6.a.f10762a;
        String str = this.f1500l;
        long j = this.f1501m;
        switch (i) {
            case 0:
                int i6 = this.f1499b;
                if (i6 == 0) {
                    p6.a.e(obj);
                    v7.e eVar = o7.m0.f8288a;
                    p7.c cVar = t7.n.f10348a;
                    c1 c1Var = new c1((FreeUpSpaceActivity) k0Var, str, j, null, 0);
                    this.f1500l = null;
                    this.f1501m = j;
                    this.f1499b = 1;
                    if (o7.c0.C(c1Var, cVar, this) == aVar) {
                        break;
                    }
                } else if (i6 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    break;
                }
                break;
            case 1:
                int i10 = this.f1499b;
                if (i10 == 0) {
                    p6.a.e(obj);
                    v7.e eVar2 = o7.m0.f8288a;
                    p7.c cVar2 = t7.n.f10348a;
                    c1 c1Var2 = new c1((MyApps) k0Var, str, j, null, 1);
                    this.f1500l = null;
                    this.f1501m = j;
                    this.f1499b = 1;
                    if (o7.c0.C(c1Var2, cVar2, this) == aVar) {
                        break;
                    }
                } else if (i10 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    break;
                }
                break;
            default:
                int i11 = this.f1499b;
                if (i11 == 0) {
                    p6.a.e(obj);
                    v7.e eVar3 = o7.m0.f8288a;
                    p7.c cVar3 = t7.n.f10348a;
                    c1 c1Var3 = new c1((Updates) k0Var, str, j, null, 2);
                    this.f1500l = null;
                    this.f1501m = j;
                    this.f1499b = 1;
                    if (o7.c0.C(c1Var3, cVar3, this) == aVar) {
                        break;
                    }
                } else if (i11 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    break;
                }
                break;
        }
        return aVar;
    }
}
