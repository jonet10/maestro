package n4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public int f7944a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f7945b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ h f7946l;

    /* renamed from: m, reason: collision with root package name */
    public int f7947m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, v6.c cVar) {
        super(cVar);
        this.f7946l = hVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f7945b = obj;
        this.f7947m |= Integer.MIN_VALUE;
        return h.a(this.f7946l, 0, this);
    }
}
