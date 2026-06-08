package u4;

import androidx.fragment.app.FragmentActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x1 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10658a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z1 f10659b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x1(z1 z1Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f10658a = i;
        this.f10659b = z1Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f10658a) {
            case 0:
                return new x1(this.f10659b, cVar, 0);
            default:
                return new x1(this.f10659b, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f10658a) {
            case 0:
                x1 x1Var = (x1) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                x1Var.invokeSuspend(xVar);
                return xVar;
            default:
                x1 x1Var2 = (x1) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                x1Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f10658a;
        p6.x xVar = p6.x.f8463a;
        z1 z1Var = this.f10659b;
        switch (i) {
            case 0:
                p6.a.e(obj);
                FragmentActivity activity = z1Var.getActivity();
                activity.getClass();
                String string = z1Var.getString(2131951998);
                string.getClass();
                ((c4.k0) activity).A(string);
                break;
            default:
                p6.a.e(obj);
                FragmentActivity activity2 = z1Var.getActivity();
                activity2.getClass();
                String string2 = z1Var.getString(2131951998);
                string2.getClass();
                ((c4.k0) activity2).A(string2);
                break;
        }
        return xVar;
    }
}
