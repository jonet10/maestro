package c3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u implements e3.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1328a;

    public /* synthetic */ u(int i) {
        this.f1328a = i;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(2:3|(7:5|6|7|(1:(1:(6:11|12|13|(1:15)|16|17)(2:20|21))(2:22|23))(6:30|31|32|33|(1:35)|28)|24|25|26))|43|6|7|(0)(0)|24|25|26|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0085, code lost:
    
        if (r10 != r6) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0044, code lost:
    
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0032, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008f, code lost:
    
        android.util.Log.w("FirebaseSessions", "Error getting Firebase installation id .", r10);
        r9 = r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v20, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(t2.d r9, v6.c r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof c3.w
            if (r0 == 0) goto L13
            r0 = r10
            c3.w r0 = (c3.w) r0
            int r1 = r0.f1340m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1340m = r1
            goto L18
        L13:
            c3.w r0 = new c3.w
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f1338b
            int r1 = r0.f1340m
            java.lang.String r2 = "FirebaseSessions"
            r3 = 2
            r4 = 1
            java.lang.String r5 = ""
            u6.a r6 = u6.a.f10762a
            if (r1 == 0) goto L46
            if (r1 == r4) goto L3c
            if (r1 != r3) goto L35
            java.lang.Object r9 = r0.f1337a
            java.lang.String r9 = (java.lang.String) r9
            p6.a.e(r10)     // Catch: java.lang.Exception -> L32
            goto L88
        L32:
            r10 = move-exception
            goto L8f
        L35:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r9)
            r9 = 0
            return r9
        L3c:
            java.lang.Object r9 = r0.f1337a
            t2.d r9 = (t2.d) r9
            p6.a.e(r10)     // Catch: java.lang.Exception -> L44
            goto L61
        L44:
            r10 = move-exception
            goto L6d
        L46:
            p6.a.e(r10)
            r10 = r9
            t2.c r10 = (t2.c) r10     // Catch: java.lang.Exception -> L44
            j1.p r9 = r10.e()     // Catch: java.lang.Exception -> L44
            r9.getClass()     // Catch: java.lang.Exception -> L69
            r0.f1337a = r10     // Catch: java.lang.Exception -> L69
            r0.f1340m = r4     // Catch: java.lang.Exception -> L69
            java.lang.Object r9 = d0.b.n(r9, r0)     // Catch: java.lang.Exception -> L69
            if (r9 != r6) goto L5e
            goto L87
        L5e:
            r7 = r10
            r10 = r9
            r9 = r7
        L61:
            t2.a r10 = (t2.a) r10     // Catch: java.lang.Exception -> L44
            java.lang.String r10 = r10.f9536a     // Catch: java.lang.Exception -> L44
            r7 = r10
            r10 = r9
            r9 = r7
            goto L74
        L69:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L6d:
            java.lang.String r1 = "Error getting authentication token."
            android.util.Log.w(r2, r1, r10)
            r10 = r9
            r9 = r5
        L74:
            t2.c r10 = (t2.c) r10     // Catch: java.lang.Exception -> L32
            j1.p r10 = r10.d()     // Catch: java.lang.Exception -> L32
            r10.getClass()     // Catch: java.lang.Exception -> L32
            r0.f1337a = r9     // Catch: java.lang.Exception -> L32
            r0.f1340m = r3     // Catch: java.lang.Exception -> L32
            java.lang.Object r10 = d0.b.n(r10, r0)     // Catch: java.lang.Exception -> L32
            if (r10 != r6) goto L88
        L87:
            return r6
        L88:
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Exception -> L32
            if (r10 != 0) goto L8d
            goto L94
        L8d:
            r5 = r10
            goto L94
        L8f:
            java.lang.String r0 = "Error getting Firebase installation id ."
            android.util.Log.w(r2, r0, r10)
        L94:
            c3.x r10 = new c3.x
            r10.<init>(r5, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.u.a(t2.d, v6.c):java.lang.Object");
    }

    @Override // m6.a
    public Object get() {
        switch (this.f1328a) {
            case 0:
                return h1.f1255a;
            default:
                return i1.f1271a;
        }
    }
}
