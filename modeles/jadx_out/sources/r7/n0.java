package r7;

import o7.e1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n0 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public o0 f9023a;

    /* renamed from: b, reason: collision with root package name */
    public i f9024b;

    /* renamed from: l, reason: collision with root package name */
    public p0 f9025l;

    /* renamed from: m, reason: collision with root package name */
    public e1 f9026m;

    /* renamed from: n, reason: collision with root package name */
    public Object f9027n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f9028o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ o0 f9029p;

    /* renamed from: q, reason: collision with root package name */
    public int f9030q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(o0 o0Var, t6.c cVar) {
        super(cVar);
        this.f9029p = o0Var;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9028o = obj;
        this.f9030q |= Integer.MIN_VALUE;
        this.f9029p.collect(null, this);
        return u6.a.f10762a;
    }
}
