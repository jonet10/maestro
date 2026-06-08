package o5;

import com.uptodown.workers.PreRegisterWorker;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.x;
import x4.x1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public int f8194a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PreRegisterWorker f8195b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f8196l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ x1 f8197m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ x4.g f8198n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f8199o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(int i, PreRegisterWorker preRegisterWorker, String str, t6.c cVar, x4.g gVar, x1 x1Var) {
        super(2, cVar);
        this.f8195b = preRegisterWorker;
        this.f8196l = str;
        this.f8197m = x1Var;
        this.f8198n = gVar;
        this.f8199o = i;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new m(this.f8199o, this.f8195b, this.f8196l, cVar, this.f8198n, this.f8197m);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((m) create((a0) obj, (t6.c) obj2)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f8194a;
        x xVar = x.f8463a;
        if (i != 0) {
            if (i == 1) {
                p6.a.e(obj);
                return xVar;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        this.f8194a = 1;
        v7.e eVar = m0.f8288a;
        Object C = c0.C(new b.m(this.f8199o, this.f8195b, this.f8196l, (t6.c) null, this.f8198n, this.f8197m), v7.d.f10884a, this);
        u6.a aVar = u6.a.f10762a;
        if (C != aVar) {
            C = xVar;
        }
        return C == aVar ? aVar : xVar;
    }
}
