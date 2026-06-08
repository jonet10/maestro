package s4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9262a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f9263b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ x4.j f9264l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ j5.v f9265m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ j5.g f9266n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(s sVar, x4.j jVar, j5.v vVar, j5.g gVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f9262a = i;
        this.f9263b = sVar;
        this.f9264l = jVar;
        this.f9265m = vVar;
        this.f9266n = gVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f9262a) {
            case 0:
                return new q(this.f9263b, this.f9264l, this.f9265m, this.f9266n, cVar, 0);
            default:
                return new q(this.f9263b, this.f9264l, this.f9265m, this.f9266n, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f9262a) {
        }
        return ((q) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f9262a) {
            case 0:
                p6.a.e(obj);
                return s.a(this.f9263b, this.f9264l, this.f9265m, this.f9266n);
            default:
                p6.a.e(obj);
                return s.a(this.f9263b, this.f9264l, this.f9265m, this.f9266n);
        }
    }
}
