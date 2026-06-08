package f3;

import d7.p;
import o7.a0;
import p6.x;
import r7.k0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l extends v6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4860a;

    /* renamed from: b, reason: collision with root package name */
    public int f4861b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ n f4862l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(n nVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f4860a = i;
        this.f4862l = nVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f4860a) {
            case 0:
                return new l(this.f4862l, cVar, 0);
            default:
                return new l(this.f4862l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f4860a) {
        }
        return ((l) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f4860a) {
            case 0:
                int i = this.f4861b;
                if (i == 0) {
                    p6.a.e(obj);
                    n nVar = this.f4862l;
                    r7.h data = nVar.f4867b.getData();
                    k kVar = new k(nVar.f4868c);
                    this.f4861b = 1;
                    Object collect = data.collect(kVar, this);
                    u6.a aVar = u6.a.f10762a;
                    if (collect == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    p6.a.e(obj);
                }
                return x.f8463a;
            default:
                int i6 = this.f4861b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                r7.h data2 = this.f4862l.f4867b.getData();
                this.f4861b = 1;
                Object j = k0.j(data2, this);
                u6.a aVar2 = u6.a.f10762a;
                return j == aVar2 ? aVar2 : j;
        }
    }
}
