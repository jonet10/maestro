package r7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public s7.l f8949a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f8950b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ f0 f8951l;

    /* renamed from: m, reason: collision with root package name */
    public int f8952m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(f0 f0Var, t6.c cVar) {
        super(cVar);
        this.f8951l = f0Var;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f8950b = obj;
        this.f8952m |= Integer.MIN_VALUE;
        return this.f8951l.collect(null, this);
    }
}
