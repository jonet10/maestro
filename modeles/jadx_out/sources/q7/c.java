package q7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f8736a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f8737b;

    /* renamed from: l, reason: collision with root package name */
    public int f8738l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, v6.c cVar) {
        super(cVar);
        this.f8737b = eVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f8736a = obj;
        this.f8738l |= Integer.MIN_VALUE;
        Object C = e.C(this.f8737b, this);
        return C == u6.a.f10762a ? C : new l(C);
    }
}
