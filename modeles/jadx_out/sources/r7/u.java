package r7;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9062a;

    /* renamed from: b, reason: collision with root package name */
    public int f9063b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ o f9064l;

    /* renamed from: m, reason: collision with root package name */
    public c4.a0 f9065m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(o oVar, t6.c cVar) {
        super(cVar);
        this.f9064l = oVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9062a = obj;
        this.f9063b |= Integer.MIN_VALUE;
        return this.f9064l.collect(null, this);
    }
}
