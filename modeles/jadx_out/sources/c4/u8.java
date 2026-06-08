package c4;

import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u8 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2170a;

    /* renamed from: b, reason: collision with root package name */
    public int f2171b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Context f2172l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f2173m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ v8 f2174n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u8(Context context, String str, v8 v8Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f2170a = i;
        this.f2172l = context;
        this.f2173m = str;
        this.f2174n = v8Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2170a) {
            case 0:
                return new u8(this.f2172l, this.f2173m, this.f2174n, cVar, 0);
            default:
                return new u8(this.f2172l, this.f2173m, this.f2174n, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2170a) {
        }
        return ((u8) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f2170a) {
            case 0:
                int i = this.f2171b;
                if (i == 0) {
                    p6.a.e(obj);
                    this.f2171b = 1;
                    obj = x4.w2.f11430z.d(this.f2172l, this.f2173m, this);
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
                r7.o0 o0Var = this.f2174n.i;
                j5.r rVar = new j5.r((x4.v2) obj);
                o0Var.getClass();
                o0Var.g(null, rVar);
                break;
            default:
                int i6 = this.f2171b;
                if (i6 == 0) {
                    p6.a.e(obj);
                    this.f2171b = 1;
                    obj = x4.w2.f11430z.j(this.f2172l, this.f2173m, this);
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
                r7.o0 o0Var2 = this.f2174n.i;
                j5.r rVar2 = new j5.r((x4.v2) obj);
                o0Var2.getClass();
                o0Var2.g(null, rVar2);
                break;
        }
        return p6.x.f8463a;
    }
}
