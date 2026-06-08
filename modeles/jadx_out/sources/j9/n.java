package j9;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final i9.b f6783a;

    /* renamed from: b, reason: collision with root package name */
    public final l9.a f6784b;

    /* renamed from: c, reason: collision with root package name */
    public final i9.i f6785c;

    /* renamed from: d, reason: collision with root package name */
    public final g5.f f6786d;

    public n(i9.b bVar, l9.a aVar, i9.i iVar, g5.f fVar) {
        bVar.getClass();
        aVar.getClass();
        iVar.getClass();
        this.f6783a = bVar;
        this.f6784b = aVar;
        this.f6785c = iVar;
        this.f6786d = fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(v6.c r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof j9.m
            if (r0 == 0) goto L13
            r0 = r15
            j9.m r0 = (j9.m) r0
            int r1 = r0.f6782m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6782m = r1
            goto L18
        L13:
            j9.m r0 = new j9.m
            r0.<init>(r14, r15)
        L18:
            java.lang.Object r15 = r0.f6780b
            int r1 = r0.f6782m
            r2 = 86400000(0x5265c00, double:4.2687272E-316)
            r4 = 0
            r5 = 0
            java.lang.String r7 = "googleVendorLastUpdate"
            r8 = 1
            r9 = 29
            if (r1 == 0) goto L38
            if (r1 != r8) goto L31
            j9.n r0 = r0.f6779a
            p6.a.e(r15)     // Catch: r5.a -> L92
            goto L7a
        L31:
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r15)
            r15 = 0
            return r15
        L38:
            p6.a.e(r15)
            i9.b r15 = r14.f6783a     // Catch: r5.a -> L91
            boolean r15 = r15.a()     // Catch: r5.a -> L91
            l9.a r1 = r14.f6784b
            if (r15 == 0) goto L7d
            r1.getClass()     // Catch: r5.a -> L91
            android.content.SharedPreferences r15 = r1.f7262a     // Catch: r5.a -> L91
            long r10 = r15.getLong(r7, r5)     // Catch: r5.a -> L91
            long r12 = java.lang.System.currentTimeMillis()     // Catch: r5.a -> L91
            long r12 = r12 - r10
            long r12 = r12 / r2
            long r10 = (long) r4     // Catch: r5.a -> L91
            int r15 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r15 < 0) goto L7d
            long r10 = java.lang.System.currentTimeMillis()     // Catch: r5.a -> L91
            r15 = 30
            r1.d(r15, r10)     // Catch: r5.a -> L91
            i9.i r15 = r14.f6785c     // Catch: r5.a -> L91
            java.lang.String r1 = "https://cmp.inmobi.com/"
            java.lang.String r10 = "tcfv2/google-atp-list.json"
            java.lang.String r1 = kotlin.jvm.internal.l.g(r10, r1)     // Catch: r5.a -> L91
            r0.f6779a = r14     // Catch: r5.a -> L91
            r0.f6782m = r8     // Catch: r5.a -> L91
            java.lang.Object r15 = r15.b(r1, r0)     // Catch: r5.a -> L91
            u6.a r0 = u6.a.f10762a
            if (r15 != r0) goto L79
            return r0
        L79:
            r0 = r14
        L7a:
            java.lang.String r15 = (java.lang.String) r15     // Catch: r5.a -> L92
            goto Lb1
        L7d:
            com.inmobi.cmp.ChoiceCmp r15 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch: r5.a -> L91
            com.inmobi.cmp.ChoiceCmpCallback r15 = r15.getCallback()     // Catch: r5.a -> L91
            if (r15 != 0) goto L86
            goto L8b
        L86:
            com.inmobi.cmp.model.ChoiceError r0 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch: r5.a -> L91
            r15.onCmpError(r0)     // Catch: r5.a -> L91
        L8b:
            java.lang.String r15 = r1.j(r9)     // Catch: r5.a -> L91
            r0 = r14
            goto Lb1
        L91:
            r0 = r14
        L92:
            l9.a r15 = r0.f6784b
            r15.getClass()
            android.content.SharedPreferences r15 = r15.f7262a
            long r5 = r15.getLong(r7, r5)
            long r7 = java.lang.System.currentTimeMillis()
            long r7 = r7 - r5
            long r7 = r7 / r2
            long r1 = (long) r4
            int r15 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r15 < 0) goto Lab
            java.lang.String r15 = ""
            goto Lb1
        Lab:
            l9.a r15 = r0.f6784b
            java.lang.String r15 = r15.j(r9)
        Lb1:
            l9.a r1 = r0.f6784b
            r1.f(r9, r15)
            g5.f r0 = r0.f6786d
            java.lang.Object r15 = r0.k(r15)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: j9.n.a(v6.c):java.lang.Object");
    }
}
