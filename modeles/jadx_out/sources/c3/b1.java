package c3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b1 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1197a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1198b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ d1 f1199l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b1(d1 d1Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f1197a = i;
        this.f1199l = d1Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1197a) {
            case 0:
                b1 b1Var = new b1(this.f1199l, cVar, 0);
                b1Var.f1198b = obj;
                return b1Var;
            default:
                b1 b1Var2 = new b1(this.f1199l, cVar, 1);
                b1Var2.f1198b = obj;
                return b1Var2;
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        i0 i0Var = (i0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1197a) {
        }
        return ((b1) create(i0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x00a2  */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.b1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
