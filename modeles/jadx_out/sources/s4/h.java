package s4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9206a;

    /* renamed from: b, reason: collision with root package name */
    public int f9207b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ y2.s f9208l;

    /* renamed from: m, reason: collision with root package name */
    public j5.v f9209m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(j5.v vVar, y2.s sVar, t6.c cVar) {
        super(2, cVar);
        this.f9206a = 6;
        this.f9209m = vVar;
        this.f9208l = sVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f9206a) {
            case 0:
                return new h(this.f9208l, this.f9209m, cVar, 0);
            case 1:
                return new h(this.f9208l, this.f9209m, cVar, 1);
            case 2:
                return new h(this.f9208l, this.f9209m, cVar, 2);
            case 3:
                return new h(this.f9208l, this.f9209m, cVar, 3);
            case 4:
                return new h(this.f9208l, this.f9209m, cVar, 4);
            case 5:
                return new h(this.f9208l, cVar);
            case 6:
                return new h(this.f9209m, this.f9208l, cVar);
            case 7:
                return new h(this.f9208l, this.f9209m, cVar, 7);
            default:
                return new h(this.f9208l, this.f9209m, cVar, 8);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f9206a) {
        }
        return ((h) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x031f, code lost:
    
        if (r1 == r12) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0322, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02f7, code lost:
    
        if (o7.c0.C(r6, r5, r22) == r12) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02e2, code lost:
    
        if (t0.f.J(r6, r6, r5) == r12) goto L109;
     */
    /* JADX WARN: Removed duplicated region for block: B:193:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e4  */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 1210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.h.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(y2.s sVar, j5.v vVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f9206a = i;
        this.f9208l = sVar;
        this.f9209m = vVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(y2.s sVar, t6.c cVar) {
        super(2, cVar);
        this.f9206a = 5;
        this.f9208l = sVar;
    }
}
