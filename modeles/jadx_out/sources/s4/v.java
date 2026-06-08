package s4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9303a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f9304b;

    /* renamed from: l, reason: collision with root package name */
    public int f9305l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(e eVar, v6.c cVar) {
        super(cVar);
        this.f9304b = eVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9303a = obj;
        this.f9305l |= Integer.MIN_VALUE;
        Object b7 = this.f9304b.b(this);
        return b7 == u6.a.f10762a ? b7 : new p6.k(b7);
    }
}
