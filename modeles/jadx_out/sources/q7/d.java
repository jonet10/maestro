package q7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f8739a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f8740b;

    /* renamed from: l, reason: collision with root package name */
    public int f8741l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, v6.c cVar) {
        super(cVar);
        this.f8740b = eVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f8739a = obj;
        this.f8741l |= Integer.MIN_VALUE;
        Object D = this.f8740b.D(null, 0, 0L, this);
        return D == u6.a.f10762a ? D : new l(D);
    }
}
