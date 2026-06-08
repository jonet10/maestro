package b5;

import d7.p;
import j5.v;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends v6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1022a;

    /* renamed from: b, reason: collision with root package name */
    public int f1023b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ m f1024l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ v f1025m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(int i, m mVar, v vVar, t6.c cVar) {
        super(2, cVar);
        this.f1022a = i;
        this.f1024l = mVar;
        this.f1025m = vVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1022a) {
            case 0:
                return new g(0, this.f1024l, this.f1025m, cVar);
            case 1:
                return new g(1, this.f1024l, this.f1025m, cVar);
            case 2:
                return new g(2, this.f1024l, this.f1025m, cVar);
            default:
                return new g(3, this.f1024l, this.f1025m, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1022a) {
        }
        return ((g) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f1022a;
        v vVar = this.f1025m;
        m mVar = this.f1024l;
        u6.a aVar = u6.a.f10762a;
        switch (i) {
            case 0:
                int i6 = this.f1023b;
                if (i6 == 0) {
                    p6.a.e(obj);
                    this.f1023b = 1;
                    v7.e eVar = m0.f8288a;
                    Object C = c0.C(new f(0, mVar, vVar, null), v7.d.f10884a, this);
                    if (C == aVar) {
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
                int i10 = this.f1023b;
                if (i10 == 0) {
                    p6.a.e(obj);
                    this.f1023b = 1;
                    v7.e eVar2 = m0.f8288a;
                    Object C2 = c0.C(new f(1, mVar, vVar, null), v7.d.f10884a, this);
                    if (C2 == aVar) {
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
            case 2:
                int i11 = this.f1023b;
                if (i11 == 0) {
                    p6.a.e(obj);
                    this.f1023b = 1;
                    v7.e eVar3 = m0.f8288a;
                    Object C3 = c0.C(new k(vVar, mVar, (t6.c) null), v7.d.f10884a, this);
                    if (C3 == aVar) {
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
            default:
                int i12 = this.f1023b;
                if (i12 == 0) {
                    p6.a.e(obj);
                    this.f1023b = 1;
                    v7.e eVar4 = m0.f8288a;
                    Object C4 = c0.C(new k(mVar, vVar, (t6.c) null), v7.d.f10884a, this);
                    if (C4 == aVar) {
                        break;
                    }
                } else if (i12 != 1) {
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
