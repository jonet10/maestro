package f3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final o f4857a;

    /* renamed from: b, reason: collision with root package name */
    public final o f4858b;

    public j(o oVar, o oVar2) {
        oVar.getClass();
        oVar2.getClass();
        this.f4857a = oVar;
        this.f4858b = oVar2;
    }

    public final double a() {
        Double d10 = this.f4857a.d();
        if (d10 != null) {
            double doubleValue = d10.doubleValue();
            if (0.0d <= doubleValue && doubleValue <= 1.0d) {
                return doubleValue;
            }
        }
        Double d11 = this.f4858b.d();
        if (d11 != null) {
            double doubleValue2 = d11.doubleValue();
            if (0.0d <= doubleValue2 && doubleValue2 <= 1.0d) {
                return doubleValue2;
            }
        }
        return 1.0d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
    
        if (r6.c(r0) != r4) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(v6.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof f3.i
            if (r0 == 0) goto L13
            r0 = r6
            f3.i r0 = (f3.i) r0
            int r1 = r0.f4856m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4856m = r1
            goto L18
        L13:
            f3.i r0 = new f3.i
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f4854b
            int r1 = r0.f4856m
            r2 = 2
            r3 = 1
            u6.a r4 = u6.a.f10762a
            if (r1 == 0) goto L37
            if (r1 == r3) goto L31
            if (r1 != r2) goto L2a
            p6.a.e(r6)
            goto L56
        L2a:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            r6 = 0
            return r6
        L31:
            f3.j r1 = r0.f4853a
            p6.a.e(r6)
            goto L48
        L37:
            p6.a.e(r6)
            r0.f4853a = r5
            r0.f4856m = r3
            f3.o r6 = r5.f4857a
            java.lang.Object r6 = r6.c(r0)
            if (r6 != r4) goto L47
            goto L55
        L47:
            r1 = r5
        L48:
            f3.o r6 = r1.f4858b
            r1 = 0
            r0.f4853a = r1
            r0.f4856m = r2
            java.lang.Object r6 = r6.c(r0)
            if (r6 != r4) goto L56
        L55:
            return r4
        L56:
            p6.x r6 = p6.x.f8463a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.j.b(v6.c):java.lang.Object");
    }
}
