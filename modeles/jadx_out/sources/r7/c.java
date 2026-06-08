package r7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends d {

    /* renamed from: o, reason: collision with root package name */
    public final v6.i f8962o;

    /* JADX WARN: Multi-variable type inference failed */
    public c(d7.p pVar, t6.h hVar, int i, q7.a aVar) {
        super(pVar, hVar, i, aVar);
        this.f8962o = (v6.i) pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // r7.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(q7.s r5, t6.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof r7.b
            if (r0 == 0) goto L13
            r0 = r6
            r7.b r0 = (r7.b) r0
            int r1 = r0.f8961m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8961m = r1
            goto L1a
        L13:
            r7.b r0 = new r7.b
            v6.c r6 = (v6.c) r6
            r0.<init>(r4, r6)
        L1a:
            java.lang.Object r6 = r0.f8959b
            int r1 = r0.f8961m
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            q7.s r5 = r0.f8958a
            p6.a.e(r6)
            goto L40
        L29:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
        L2e:
            r5 = 0
            return r5
        L30:
            p6.a.e(r6)
            r0.f8958a = r5
            r0.f8961m = r2
            java.lang.Object r6 = super.c(r5, r0)
            u6.a r0 = u6.a.f10762a
            if (r6 != r0) goto L40
            return r0
        L40:
            q7.r r5 = (q7.r) r5
            q7.e r5 = r5.f8779m
            boolean r5 = r5.x()
            if (r5 == 0) goto L4d
            p6.x r5 = p6.x.f8463a
            return r5
        L4d:
            java.lang.String r5 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: r7.c.c(q7.s, t6.c):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [d7.p, v6.i] */
    @Override // r7.d
    public final d d(t6.h hVar, int i, q7.a aVar) {
        return new c(this.f8962o, hVar, i, aVar);
    }
}
