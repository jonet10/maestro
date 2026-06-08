package c4;

import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w7 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2265a;

    /* renamed from: b, reason: collision with root package name */
    public int f2266b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Context f2267l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f2268m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ y7 f2269n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w7(Context context, String str, y7 y7Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f2265a = i;
        this.f2267l = context;
        this.f2268m = str;
        this.f2269n = y7Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2265a) {
            case 0:
                return new w7(this.f2267l, this.f2268m, this.f2269n, cVar, 0);
            default:
                return new w7(this.f2267l, this.f2268m, this.f2269n, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2265a) {
        }
        return ((w7) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f2265a) {
            case 0:
                int i = this.f2266b;
                if (i == 0) {
                    p6.a.e(obj);
                    this.f2266b = 1;
                    obj = x4.w2.f11430z.d(this.f2267l, this.f2268m, this);
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
                x4.v2 v2Var = (x4.v2) obj;
                int i6 = v2Var.f11425d;
                y7 y7Var = this.f2269n;
                if (i6 == 1) {
                    y7Var.i++;
                }
                r7.o0 o0Var = y7Var.g;
                j5.r rVar = new j5.r(v2Var);
                o0Var.getClass();
                o0Var.g(null, rVar);
                break;
            default:
                int i10 = this.f2266b;
                if (i10 == 0) {
                    p6.a.e(obj);
                    this.f2266b = 1;
                    obj = x4.w2.f11430z.j(this.f2267l, this.f2268m, this);
                    u6.a aVar2 = u6.a.f10762a;
                    if (obj == aVar2) {
                        break;
                    }
                } else if (i10 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                x4.v2 v2Var2 = (x4.v2) obj;
                int i11 = v2Var2.f11425d;
                y7 y7Var2 = this.f2269n;
                if (i11 == 0) {
                    y7Var2.i--;
                }
                r7.o0 o0Var2 = y7Var2.g;
                j5.r rVar2 = new j5.r(v2Var2);
                o0Var2.getClass();
                o0Var2.g(null, rVar2);
                break;
        }
        return p6.x.f8463a;
    }
}
