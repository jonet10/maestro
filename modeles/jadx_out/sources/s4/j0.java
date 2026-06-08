package s4;

import e1.v4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j0 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9221a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v4 f9222b;

    /* renamed from: l, reason: collision with root package name */
    public int f9223l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(v4 v4Var, v6.c cVar) {
        super(cVar);
        this.f9222b = v4Var;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9221a = obj;
        this.f9223l |= Integer.MIN_VALUE;
        Object c9 = this.f9222b.c(0, 0, this);
        return c9 == u6.a.f10762a ? c9 : new p6.k(c9);
    }
}
