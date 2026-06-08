package f3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public j f4853a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4854b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ j f4855l;

    /* renamed from: m, reason: collision with root package name */
    public int f4856m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, v6.c cVar) {
        super(cVar);
        this.f4855l = jVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f4854b = obj;
        this.f4856m |= Integer.MIN_VALUE;
        return this.f4855l.b(this);
    }
}
