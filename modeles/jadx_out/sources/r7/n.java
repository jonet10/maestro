package r7;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9017a;

    /* renamed from: b, reason: collision with root package name */
    public int f9018b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ o f9019l;

    /* renamed from: m, reason: collision with root package name */
    public o f9020m;

    /* renamed from: n, reason: collision with root package name */
    public i f9021n;

    /* renamed from: o, reason: collision with root package name */
    public s7.l f9022o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(o oVar, t6.c cVar) {
        super(cVar);
        this.f9019l = oVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9017a = obj;
        this.f9018b |= Integer.MIN_VALUE;
        return this.f9019l.collect(null, this);
    }
}
