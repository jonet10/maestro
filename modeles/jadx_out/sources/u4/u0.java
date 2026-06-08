package u4;

import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f10615a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f10616b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f10617l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(Context context, long j, boolean z9, t6.c cVar) {
        super(2, cVar);
        this.f10615a = context;
        this.f10616b = j;
        this.f10617l = z9;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new u0(this.f10615a, this.f10616b, this.f10617l, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        u0 u0Var = (u0) create((o7.a0) obj, (t6.c) obj2);
        p6.x xVar = p6.x.f8463a;
        u0Var.invokeSuspend(xVar);
        return xVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        p6.a.e(obj);
        j5.g l10 = j5.g.D.l(this.f10615a);
        l10.b();
        long j = this.f10616b;
        if (l10.U(j) != null) {
            if (this.f10617l) {
                l10.s0(1, j);
            } else {
                l10.s0(0, j);
            }
        }
        l10.c();
        return p6.x.f8463a;
    }
}
