package c4;

import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m3 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1856a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1857b;

    /* renamed from: l, reason: collision with root package name */
    public int f1858l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MainActivity f1859m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f1860n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m3(MainActivity mainActivity, String str, t6.c cVar, int i) {
        super(2, cVar);
        this.f1856a = i;
        this.f1859m = mainActivity;
        this.f1860n = str;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1856a) {
            case 0:
                return new m3(this.f1859m, this.f1860n, cVar, 0);
            default:
                return new m3(this.f1859m, this.f1860n, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1856a) {
        }
        return ((m3) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        if (r11 == r4) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ab, code lost:
    
        if (o7.c0.C(r3, r2, r10) == r4) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008f, code lost:
    
        if (r11 == r4) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            int r0 = r10.f1856a
            p6.x r1 = p6.x.f8463a
            java.lang.String r2 = r10.f1860n
            java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
            u6.a r4 = u6.a.f10762a
            r5 = 1
            r6 = 2
            com.uptodown.activities.MainActivity r7 = r10.f1859m
            r8 = 0
            switch(r0) {
                case 0: goto L5a;
                default: goto L12;
            }
        L12:
            int r0 = r10.f1858l
            if (r0 == 0) goto L2b
            if (r0 == r5) goto L23
            if (r0 != r6) goto L1e
            p6.a.e(r11)
            goto L59
        L1e:
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r3)
            r1 = r8
            goto L59
        L23:
            p6.a.e(r11)
            p6.k r11 = (p6.k) r11
            java.lang.Object r11 = r11.f8444a
            goto L3c
        L2b:
            p6.a.e(r11)
            s4.e r11 = new s4.e
            r11.<init>(r7, r2)
            r10.f1858l = r5
            java.lang.Object r11 = r11.b(r10)
            if (r11 != r4) goto L3c
            goto L58
        L3c:
            boolean r0 = r11 instanceof p6.j
            if (r0 != 0) goto L59
            r0 = r11
            x4.g r0 = (x4.g) r0
            v7.e r2 = o7.m0.f8288a
            p7.c r2 = t7.n.f10348a
            b6.a r3 = new b6.a
            r5 = 8
            r3.<init>(r7, r0, r8, r5)
            r10.f1857b = r11
            r10.f1858l = r6
            java.lang.Object r11 = o7.c0.C(r3, r2, r10)
            if (r11 != r4) goto L59
        L58:
            r1 = r4
        L59:
            return r1
        L5a:
            int r0 = r10.f1858l
            r9 = 3
            if (r0 == 0) goto L7d
            if (r0 == r5) goto L74
            if (r0 == r6) goto L6e
            if (r0 != r9) goto L69
            p6.a.e(r11)
            goto Lc9
        L69:
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r3)
            r1 = r8
            goto Lc9
        L6e:
            java.lang.Object r0 = r10.f1857b
            p6.a.e(r11)
            goto Lae
        L74:
            p6.a.e(r11)
            p6.k r11 = (p6.k) r11
            java.lang.Object r11 = r11.f8444a
        L7b:
            r0 = r11
            goto L92
        L7d:
            p6.a.e(r11)
            s4.e r11 = new s4.e
            r11.<init>()
            r11.f9190a = r7
            r11.f9191b = r2
            r10.f1858l = r5
            java.lang.Object r11 = r11.a(r10)
            if (r11 != r4) goto L7b
            goto Lc8
        L92:
            boolean r11 = r0 instanceof p6.j
            if (r11 != 0) goto Lae
            r11 = r0
            s4.c r11 = (s4.c) r11
            v7.e r2 = o7.m0.f8288a
            p7.c r2 = t7.n.f10348a
            b6.a r3 = new b6.a
            r5 = 7
            r3.<init>(r7, r11, r8, r5)
            r10.f1857b = r0
            r10.f1858l = r6
            java.lang.Object r11 = o7.c0.C(r3, r2, r10)
            if (r11 != r4) goto Lae
            goto Lc8
        Lae:
            java.lang.Throwable r11 = p6.k.a(r0)
            if (r11 == 0) goto Lc9
            v7.e r11 = o7.m0.f8288a
            p7.c r11 = t7.n.f10348a
            c4.j3 r2 = new c4.j3
            r3 = 5
            r2.<init>(r7, r8, r3)
            r10.f1857b = r0
            r10.f1858l = r9
            java.lang.Object r11 = o7.c0.C(r2, r11, r10)
            if (r11 != r4) goto Lc9
        Lc8:
            r1 = r4
        Lc9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.m3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
