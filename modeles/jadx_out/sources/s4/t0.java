package s4;

import e1.v4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t0 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9294a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v4 f9295b;

    /* renamed from: l, reason: collision with root package name */
    public int f9296l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(v4 v4Var, v6.c cVar) {
        super(cVar);
        this.f9295b = v4Var;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9294a = obj;
        this.f9296l |= Integer.MIN_VALUE;
        Object a8 = this.f9295b.a(0L, this);
        return a8 == u6.a.f10762a ? a8 : new p6.k(a8);
    }
}
