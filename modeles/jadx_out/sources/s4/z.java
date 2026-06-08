package s4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9326a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b5.m f9327b;

    /* renamed from: l, reason: collision with root package name */
    public int f9328l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(b5.m mVar, v6.c cVar) {
        super(cVar);
        this.f9327b = mVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9326a = obj;
        this.f9328l |= Integer.MIN_VALUE;
        Object l10 = b5.m.l(this.f9327b, null, this);
        return l10 == u6.a.f10762a ? l10 : new p6.k(l10);
    }
}
