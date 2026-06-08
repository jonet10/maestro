package u4;

import androidx.fragment.app.FragmentActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u1 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10618a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f10619b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ z1 f10620l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u1(Throwable th, z1 z1Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f10618a = i;
        this.f10619b = th;
        this.f10620l = z1Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f10618a) {
            case 0:
                return new u1(this.f10619b, this.f10620l, cVar, 0);
            default:
                return new u1(this.f10619b, this.f10620l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f10618a) {
            case 0:
                u1 u1Var = (u1) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                u1Var.invokeSuspend(xVar);
                return xVar;
            default:
                u1 u1Var2 = (u1) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                u1Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f10618a;
        p6.x xVar = p6.x.f8463a;
        z1 z1Var = this.f10620l;
        Throwable th = this.f10619b;
        switch (i) {
            case 0:
                p6.a.e(obj);
                int i6 = s4.y0.f9323l;
                if (!d0.b.J(th)) {
                    if (z1Var.getActivity() instanceof c4.k0) {
                        FragmentActivity activity = z1Var.getActivity();
                        activity.getClass();
                        String string = z1Var.getString(2131951694);
                        string.getClass();
                        ((c4.k0) activity).A(string);
                        break;
                    }
                } else if (z1Var.getActivity() instanceof c4.k0) {
                    FragmentActivity activity2 = z1Var.getActivity();
                    activity2.getClass();
                    ((c4.k0) activity2).J();
                    break;
                }
                break;
            default:
                p6.a.e(obj);
                int i10 = s4.y0.f9323l;
                if (!d0.b.J(th)) {
                    if (z1Var.getActivity() instanceof c4.k0) {
                        FragmentActivity activity3 = z1Var.getActivity();
                        activity3.getClass();
                        String string2 = z1Var.getString(2131951998);
                        string2.getClass();
                        ((c4.k0) activity3).N(string2);
                        break;
                    }
                } else if (z1Var.getActivity() instanceof c4.k0) {
                    FragmentActivity activity4 = z1Var.getActivity();
                    activity4.getClass();
                    ((c4.k0) activity4).J();
                    break;
                }
                break;
        }
        return xVar;
    }
}
