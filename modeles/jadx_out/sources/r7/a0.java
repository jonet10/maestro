package r7;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a0 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f8953a;

    /* renamed from: b, reason: collision with root package name */
    public int f8954b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ c4.a0 f8955l;

    /* renamed from: m, reason: collision with root package name */
    public Object f8956m;

    /* renamed from: n, reason: collision with root package name */
    public i f8957n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(c4.a0 a0Var, t6.c cVar) {
        super(cVar);
        this.f8955l = a0Var;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f8953a = obj;
        this.f8954b |= Integer.MIN_VALUE;
        return this.f8955l.emit(null, this);
    }
}
