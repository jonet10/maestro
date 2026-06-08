package u4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v1 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10643a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10644b;

    /* renamed from: l, reason: collision with root package name */
    public int f10645l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ z1 f10646m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ x4.g f10647n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v1(z1 z1Var, x4.g gVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f10643a = i;
        this.f10646m = z1Var;
        this.f10647n = gVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f10643a) {
            case 0:
                return new v1(this.f10646m, this.f10647n, cVar, 0);
            case 1:
                return new v1(this.f10646m, this.f10647n, cVar, 1);
            default:
                return new v1(this.f10646m, this.f10647n, cVar, 2);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f10643a) {
        }
        return ((v1) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x01cb, code lost:
    
        if (r13 == r5) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0045, code lost:
    
        if (r13 == r5) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x016a, code lost:
    
        if (o7.c0.C(r1, r13, r12) == r5) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0115, code lost:
    
        if (o7.c0.C(r4, r13, r12) == r5) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00f6, code lost:
    
        if (r13 == r5) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x014b, code lost:
    
        if (r13 == r5) goto L75;
     */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.v1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
