package b;

import o7.c0;
import o7.g0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class i extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f679a;

    /* renamed from: b, reason: collision with root package name */
    public int f680b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ g0 f681l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(g0 g0Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f679a = i;
        this.f681l = g0Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f679a) {
            case 0:
                return new i(this.f681l, cVar, 0);
            case 1:
                return new i(this.f681l, cVar, 1);
            case 2:
                return new i(this.f681l, cVar, 2);
            default:
                return new i(this.f681l, cVar, 3);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        t6.c cVar = (t6.c) obj2;
        switch (this.f679a) {
            case 0:
                return new i(this.f681l, cVar, 0).invokeSuspend(x.f8463a);
            case 1:
                return new i(this.f681l, cVar, 1).invokeSuspend(x.f8463a);
            case 2:
                return new i(this.f681l, cVar, 2).invokeSuspend(x.f8463a);
            default:
                return new i(this.f681l, cVar, 3).invokeSuspend(x.f8463a);
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f679a) {
            case 0:
                int i = this.f680b;
                if (i != 0) {
                    if (i == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                this.f680b = 1;
                Object w2 = this.f681l.w(this);
                u6.a aVar = u6.a.f10762a;
                return w2 == aVar ? aVar : w2;
            case 1:
                int i6 = this.f680b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                i iVar = new i(this.f681l, null, 0);
                this.f680b = 1;
                Object E = c0.E(500L, iVar, this);
                u6.a aVar2 = u6.a.f10762a;
                return E == aVar2 ? aVar2 : E;
            case 2:
                int i10 = this.f680b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                this.f680b = 1;
                Object w9 = this.f681l.w(this);
                u6.a aVar3 = u6.a.f10762a;
                return w9 == aVar3 ? aVar3 : w9;
            default:
                int i11 = this.f680b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                i iVar2 = new i(this.f681l, null, 2);
                this.f680b = 1;
                Object E2 = c0.E(500L, iVar2, this);
                u6.a aVar4 = u6.a.f10762a;
                return E2 == aVar4 ? aVar4 : E2;
        }
    }
}
