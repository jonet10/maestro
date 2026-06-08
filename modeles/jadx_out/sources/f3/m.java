package f3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f4863a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f4864b;

    /* renamed from: l, reason: collision with root package name */
    public int f4865l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar, v6.c cVar) {
        super(cVar);
        this.f4864b = nVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f4863a = obj;
        this.f4865l |= Integer.MIN_VALUE;
        return this.f4864b.c(null, this);
    }
}
