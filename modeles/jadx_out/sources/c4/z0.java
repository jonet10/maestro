package c4;

import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2377a;

    /* renamed from: b, reason: collision with root package name */
    public int f2378b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ b1 f2379l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Context f2380m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f2381n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z0(b1 b1Var, Context context, String str, t6.c cVar, int i) {
        super(2, cVar);
        this.f2377a = i;
        this.f2379l = b1Var;
        this.f2380m = context;
        this.f2381n = str;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2377a) {
            case 0:
                return new z0(this.f2379l, this.f2380m, this.f2381n, cVar, 0);
            default:
                return new z0(this.f2379l, this.f2380m, this.f2381n, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2377a) {
        }
        return ((z0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f2377a) {
            case 0:
                r7.o0 o0Var = this.f2379l.f1407c;
                int i = this.f2378b;
                if (i == 0) {
                    p6.a.e(obj);
                    o0Var.getClass();
                    o0Var.g(null, j5.q.f6706a);
                    this.f2378b = 1;
                    obj = x4.w2.f11430z.d(this.f2380m, this.f2381n, this);
                    u6.a aVar = u6.a.f10762a;
                    if (obj == aVar) {
                        break;
                    }
                } else if (i != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                j5.r rVar = new j5.r((x4.v2) obj);
                o0Var.getClass();
                o0Var.g(null, rVar);
                break;
            default:
                r7.o0 o0Var2 = this.f2379l.f1407c;
                int i6 = this.f2378b;
                if (i6 == 0) {
                    p6.a.e(obj);
                    o0Var2.getClass();
                    o0Var2.g(null, j5.q.f6706a);
                    this.f2378b = 1;
                    obj = x4.w2.f11430z.j(this.f2380m, this.f2381n, this);
                    u6.a aVar2 = u6.a.f10762a;
                    if (obj == aVar2) {
                        break;
                    }
                } else if (i6 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                j5.r rVar2 = new j5.r((x4.v2) obj);
                o0Var2.getClass();
                o0Var2.g(null, rVar2);
                break;
        }
        return p6.x.f8463a;
    }
}
