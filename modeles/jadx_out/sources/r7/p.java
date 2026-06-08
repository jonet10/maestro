package r7;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9036a;

    /* renamed from: b, reason: collision with root package name */
    public int f9037b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ o f9038l;

    /* renamed from: m, reason: collision with root package name */
    public o f9039m;

    /* renamed from: n, reason: collision with root package name */
    public i f9040n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, t6.c cVar) {
        super(cVar);
        this.f9038l = oVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9036a = obj;
        this.f9037b |= Integer.MIN_VALUE;
        return this.f9038l.collect(null, this);
    }
}
