package c3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s0 {
    public static final double f = Math.random();
    public static final /* synthetic */ int g = 0;

    /* renamed from: a, reason: collision with root package name */
    public final n1.f f1319a;

    /* renamed from: b, reason: collision with root package name */
    public final t2.d f1320b;

    /* renamed from: c, reason: collision with root package name */
    public final f3.j f1321c;

    /* renamed from: d, reason: collision with root package name */
    public final l f1322d;

    /* renamed from: e, reason: collision with root package name */
    public final t6.h f1323e;

    public s0(n1.f fVar, t2.d dVar, f3.j jVar, l lVar, t6.h hVar) {
        fVar.getClass();
        dVar.getClass();
        jVar.getClass();
        lVar.getClass();
        hVar.getClass();
        this.f1319a = fVar;
        this.f1320b = dVar;
        this.f1321c = jVar;
        this.f1322d = lVar;
        this.f1323e = hVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
    
        if (r7.b(r0) == r5) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0085, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0048, code lost:
    
        if (r7 == r5) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(c3.s0 r6, v6.c r7) {
        /*
            boolean r0 = r7 instanceof c3.r0
            if (r0 == 0) goto L13
            r0 = r7
            c3.r0 r0 = (c3.r0) r0
            int r1 = r0.f1315m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1315m = r1
            goto L18
        L13:
            c3.r0 r0 = new c3.r0
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f1313b
            int r1 = r0.f1315m
            r2 = 2
            r3 = 1
            java.lang.String r4 = "FirebaseSessions"
            u6.a r5 = u6.a.f10762a
            if (r1 == 0) goto L3b
            if (r1 == r3) goto L35
            if (r1 != r2) goto L2e
            c3.s0 r6 = r0.f1312a
            p6.a.e(r7)
            goto L86
        L2e:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            r6 = 0
            return r6
        L35:
            c3.s0 r6 = r0.f1312a
            p6.a.e(r7)
            goto L4b
        L3b:
            p6.a.e(r7)
            d3.c r7 = d3.c.f3551a
            r0.f1312a = r6
            r0.f1315m = r3
            java.lang.Object r7 = r7.b(r0)
            if (r7 != r5) goto L4b
            goto L85
        L4b:
            java.util.Map r7 = (java.util.Map) r7
            java.util.Collection r7 = r7.values()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            boolean r1 = r7 instanceof java.util.Collection
            if (r1 == 0) goto L61
            r1 = r7
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L61
            goto Lc2
        L61:
            java.util.Iterator r7 = r7.iterator()
        L65:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto Lc2
            java.lang.Object r1 = r7.next()
            y1.i r1 = (y1.i) r1
            y1.t r1 = r1.f11625a
            boolean r1 = r1.a()
            if (r1 == 0) goto L65
            f3.j r7 = r6.f1321c
            r0.f1312a = r6
            r0.f1315m = r2
            java.lang.Object r7 = r7.b(r0)
            if (r7 != r5) goto L86
        L85:
            return r5
        L86:
            f3.j r7 = r6.f1321c
            f3.o r0 = r7.f4857a
            java.lang.Boolean r0 = r0.a()
            if (r0 == 0) goto L95
            boolean r3 = r0.booleanValue()
            goto La1
        L95:
            f3.o r7 = r7.f4858b
            java.lang.Boolean r7 = r7.a()
            if (r7 == 0) goto La1
            boolean r3 = r7.booleanValue()
        La1:
            if (r3 != 0) goto Lab
            java.lang.String r6 = "Sessions SDK disabled through settings API. Events will not be sent."
            android.util.Log.d(r4, r6)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        Lab:
            f3.j r6 = r6.f1321c
            double r6 = r6.a()
            double r0 = c3.s0.f
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 > 0) goto Lba
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            return r6
        Lba:
            java.lang.String r6 = "Sessions SDK has dropped this session due to sampling."
            android.util.Log.d(r4, r6)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        Lc2:
            java.lang.String r6 = "Sessions SDK disabled through data collection. Events will not be sent."
            android.util.Log.d(r4, r6)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.s0.a(c3.s0, v6.c):java.lang.Object");
    }
}
