package s4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b0 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9173a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b5.m f9174b;

    /* renamed from: l, reason: collision with root package name */
    public int f9175l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(b5.m mVar, v6.c cVar) {
        super(cVar);
        this.f9174b = mVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9173a = obj;
        this.f9175l |= Integer.MIN_VALUE;
        Object t9 = b5.m.t(this.f9174b, null, this);
        return t9 == u6.a.f10762a ? t9 : new p6.k(t9);
    }
}
