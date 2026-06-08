package s4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9238a;

    /* renamed from: b, reason: collision with root package name */
    public int f9239b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ s f9240l;

    /* renamed from: m, reason: collision with root package name */
    public j5.v f9241m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(s sVar, j5.v vVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f9238a = i;
        this.f9240l = sVar;
        this.f9241m = vVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f9238a) {
            case 0:
                return new m(this.f9240l, this.f9241m, cVar, 0);
            case 1:
                return new m(this.f9240l, this.f9241m, cVar, 1);
            case 2:
                return new m(this.f9240l, this.f9241m, cVar, 2);
            case 3:
                return new m(this.f9240l, this.f9241m, cVar, 3);
            case 4:
                return new m(this.f9240l, this.f9241m, cVar, 4);
            case 5:
                return new m(this.f9240l, cVar);
            case 6:
                return new m(this.f9240l, this.f9241m, cVar, 6);
            case 7:
                return new m(this.f9240l, this.f9241m, cVar, 7);
            case 8:
                return new m(this.f9240l, this.f9241m, cVar, 8);
            default:
                return new m(this.f9240l, this.f9241m, cVar, 9);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f9238a) {
        }
        return ((m) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x048e, code lost:
    
        if (r1 == r14) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0473, code lost:
    
        if (r3 == r14) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0456, code lost:
    
        if (r3 == r14) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0437, code lost:
    
        if (o7.c0.C(r7, r6, r22) == r14) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x041f, code lost:
    
        if (t0.f.J(r7, r7, r6) == r14) goto L152;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ce  */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13, types: [j5.v, t6.c] */
    /* JADX WARN: Type inference failed for: r13v14 */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 1606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.m.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(s sVar, t6.c cVar) {
        super(2, cVar);
        this.f9238a = 5;
        this.f9240l = sVar;
    }
}
