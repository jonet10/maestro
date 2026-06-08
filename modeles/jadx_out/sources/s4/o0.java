package s4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o0 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public x7.g f9253a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f9254b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ p0 f9255l;

    /* renamed from: m, reason: collision with root package name */
    public int f9256m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(p0 p0Var, v6.c cVar) {
        super(cVar);
        this.f9255l = p0Var;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f9254b = obj;
        this.f9256m |= Integer.MIN_VALUE;
        return p0.a(this.f9255l, this);
    }
}
