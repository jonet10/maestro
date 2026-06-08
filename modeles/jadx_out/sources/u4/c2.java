package u4;

import android.content.Context;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c2 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10442a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d2 f10443b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Context f10444l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ x4.j f10445m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c2(d2 d2Var, Context context, x4.j jVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f10442a = i;
        this.f10443b = d2Var;
        this.f10444l = context;
        this.f10445m = jVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f10442a) {
            case 0:
                return new c2(this.f10443b, this.f10444l, this.f10445m, cVar, 0);
            default:
                return new c2(this.f10443b, this.f10444l, this.f10445m, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f10442a) {
            case 0:
                c2 c2Var = (c2) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                c2Var.invokeSuspend(xVar);
                return xVar;
            default:
                c2 c2Var2 = (c2) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                c2Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f10442a) {
            case 0:
                p6.a.e(obj);
                d2 d2Var = this.f10443b;
                d2Var.f10462e = true;
                d2Var.h = 0;
                x4.j jVar = this.f10445m;
                Context context = this.f10444l;
                p2 a8 = d2.a(d2Var, context, jVar);
                r7.o0 o0Var = d2Var.f10458a;
                j5.r rVar = new j5.r(new a2(a8, true));
                o0Var.getClass();
                o0Var.g(null, rVar);
                x4.j jVar2 = a8.f11329a;
                if (jVar2.f11227m) {
                    d2Var.c(context, jVar2.f11224a);
                }
                break;
            default:
                p6.a.e(obj);
                d2 d2Var2 = this.f10443b;
                d2Var2.f10462e = true;
                p2 a10 = d2.a(d2Var2, this.f10444l, this.f10445m);
                if (a10.f11330b.isEmpty()) {
                    d2Var2.f = true;
                }
                r7.o0 o0Var2 = d2Var2.f10458a;
                j5.r rVar2 = new j5.r(new a2(a10, false));
                o0Var2.getClass();
                o0Var2.g(null, rVar2);
                break;
        }
        return p6.x.f8463a;
    }
}
