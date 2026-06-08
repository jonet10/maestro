package s4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9320a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b5.m f9321b;

    /* renamed from: l, reason: collision with root package name */
    public int f9322l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(b5.m mVar, t6.c cVar) {
        super(cVar);
        this.f9321b = mVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9320a = obj;
        this.f9322l |= Integer.MIN_VALUE;
        Object D = this.f9321b.D(this);
        return D == u6.a.f10762a ? D : new p6.k(D);
    }
}
