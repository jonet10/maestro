package r7;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9050a;

    /* renamed from: b, reason: collision with root package name */
    public int f9051b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ o f9052l;

    /* renamed from: m, reason: collision with root package name */
    public o f9053m;

    /* renamed from: n, reason: collision with root package name */
    public i f9054n;

    /* renamed from: o, reason: collision with root package name */
    public Throwable f9055o;

    /* renamed from: p, reason: collision with root package name */
    public long f9056p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(o oVar, t6.c cVar) {
        super(cVar);
        this.f9052l = oVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9050a = obj;
        this.f9051b |= Integer.MIN_VALUE;
        return this.f9052l.collect(null, this);
    }
}
