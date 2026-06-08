package c4;

import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f9 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1599a;

    /* renamed from: b, reason: collision with root package name */
    public int f1600b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Context f1601l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f1602m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ g9 f1603n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f9(Context context, String str, g9 g9Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f1599a = i;
        this.f1601l = context;
        this.f1602m = str;
        this.f1603n = g9Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1599a) {
            case 0:
                return new f9(this.f1601l, this.f1602m, this.f1603n, cVar, 0);
            default:
                return new f9(this.f1601l, this.f1602m, this.f1603n, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1599a) {
        }
        return ((f9) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1599a) {
            case 0:
                int i = this.f1600b;
                if (i == 0) {
                    p6.a.e(obj);
                    this.f1600b = 1;
                    obj = x4.w2.f11430z.d(this.f1601l, this.f1602m, this);
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
                r7.o0 o0Var = this.f1603n.g;
                j5.r rVar = new j5.r((x4.v2) obj);
                o0Var.getClass();
                o0Var.g(null, rVar);
                break;
            default:
                int i6 = this.f1600b;
                if (i6 == 0) {
                    p6.a.e(obj);
                    this.f1600b = 1;
                    obj = x4.w2.f11430z.j(this.f1601l, this.f1602m, this);
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
                r7.o0 o0Var2 = this.f1603n.g;
                j5.r rVar2 = new j5.r((x4.v2) obj);
                o0Var2.getClass();
                o0Var2.g(null, rVar2);
                break;
        }
        return p6.x.f8463a;
    }
}
