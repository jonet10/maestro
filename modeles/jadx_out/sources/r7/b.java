package r7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public q7.s f8958a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f8959b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ c f8960l;

    /* renamed from: m, reason: collision with root package name */
    public int f8961m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, v6.c cVar2) {
        super(cVar2);
        this.f8960l = cVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f8959b = obj;
        this.f8961m |= Integer.MIN_VALUE;
        return this.f8960l.c(null, this);
    }
}
