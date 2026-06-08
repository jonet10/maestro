package r7;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9008a;

    /* renamed from: b, reason: collision with root package name */
    public int f9009b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ m f9010l;

    /* renamed from: m, reason: collision with root package name */
    public Object f9011m;

    /* renamed from: n, reason: collision with root package name */
    public i f9012n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(m mVar, t6.c cVar) {
        super(cVar);
        this.f9010l = mVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9008a = obj;
        this.f9009b |= Integer.MIN_VALUE;
        return this.f9010l.collect(null, this);
    }
}
