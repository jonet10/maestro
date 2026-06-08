package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public int f1402a;

    /* renamed from: b, reason: collision with root package name */
    public int f1403b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ k0 f1404l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(k0 k0Var, t6.c cVar) {
        super(2, cVar);
        this.f1404l = k0Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new b0(this.f1404l, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((b0) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0045, code lost:
    
        if (o7.c0.j(androidx.lifecycle.CoroutineLiveDataKt.DEFAULT_TIMEOUT, r7) == r6) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x002a, code lost:
    
        if (o7.c0.j(androidx.lifecycle.CoroutineLiveDataKt.DEFAULT_TIMEOUT, r7) == r6) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0045 -> B:6:0x0048). Please report as a decompilation issue!!! */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            int r0 = r7.f1403b
            r1 = 5000(0x1388, double:2.4703E-320)
            r3 = 2
            r4 = 1
            c4.k0 r5 = r7.f1404l
            u6.a r6 = u6.a.f10762a
            if (r0 == 0) goto L21
            if (r0 == r4) goto L1d
            if (r0 != r3) goto L16
            int r0 = r7.f1402a
            p6.a.e(r8)
            goto L48
        L16:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r8)
            r8 = 0
            return r8
        L1d:
            p6.a.e(r8)
            goto L2d
        L21:
            p6.a.e(r8)
            r7.f1403b = r4
            java.lang.Object r8 = o7.c0.j(r1, r7)
            if (r8 != r6) goto L2d
            goto L47
        L2d:
            float r8 = com.uptodown.UptodownApp.I
            androidx.work.WorkInfo$State r8 = b4.d.j(r5)
            r0 = 0
        L34:
            r4 = 5
            if (r0 >= r4) goto L4f
            androidx.work.WorkInfo$State r4 = androidx.work.WorkInfo.State.ENQUEUED
            if (r8 != r4) goto L4f
            int r0 = r0 + 1
            r7.f1402a = r0
            r7.f1403b = r3
            java.lang.Object r8 = o7.c0.j(r1, r7)
            if (r8 != r6) goto L48
        L47:
            return r6
        L48:
            float r8 = com.uptodown.UptodownApp.I
            androidx.work.WorkInfo$State r8 = b4.d.j(r5)
            goto L34
        L4f:
            float r8 = com.uptodown.UptodownApp.I
            java.lang.String r8 = "downloadApkWorker"
            boolean r8 = b4.d.p(r5, r8)
            if (r8 != 0) goto La7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            e1.c0 r0 = j5.g.D
            j5.g r0 = r0.l(r5)
            r0.b()
            java.util.ArrayList r1 = r0.P()
            java.util.Iterator r1 = r1.iterator()
            r1.getClass()
        L72:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L8b
            java.lang.Object r2 = r1.next()
            r2.getClass()
            x4.r r2 = (x4.r) r2
            boolean r3 = r2.m()
            if (r3 == 0) goto L72
            r8.add(r2)
            goto L72
        L8b:
            r0.c()
            boolean r0 = r8.isEmpty()
            if (r0 != 0) goto La7
            java.lang.Object r0 = q6.l.q0(r8)
            x4.r r0 = (x4.r) r0
            int r0 = r0.f11354a
            java.lang.Object r8 = q6.l.q0(r8)
            x4.r r8 = (x4.r) r8
            java.lang.String r8 = r8.f11366w
            r5.o0(r0, r8)
        La7:
            p6.x r8 = p6.x.f8463a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.b0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
