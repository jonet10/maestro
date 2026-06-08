package r7;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public c4.a0 f9066a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f9067b;

    /* renamed from: l, reason: collision with root package name */
    public int f9068l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c4.a0 f9069m;

    /* renamed from: n, reason: collision with root package name */
    public Object f9070n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(c4.a0 a0Var, t6.c cVar) {
        super(cVar);
        this.f9069m = a0Var;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9067b = obj;
        this.f9068l |= Integer.MIN_VALUE;
        return this.f9069m.emit(null, this);
    }
}
