package n4;

import e1.c0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public int f7940a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f7941b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ c0 f7942l;

    /* renamed from: m, reason: collision with root package name */
    public int f7943m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c0 c0Var, v6.c cVar) {
        super(cVar);
        this.f7942l = c0Var;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f7941b = obj;
        this.f7943m |= Integer.MIN_VALUE;
        return this.f7942l.i(null, null, null, null, this);
    }
}
