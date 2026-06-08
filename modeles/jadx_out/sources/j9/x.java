package j9;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final i9.b f6827a;

    /* renamed from: b, reason: collision with root package name */
    public final l9.a f6828b;

    /* renamed from: c, reason: collision with root package name */
    public final i9.i f6829c;

    /* renamed from: d, reason: collision with root package name */
    public final g5.f f6830d;

    /* renamed from: e, reason: collision with root package name */
    public final String f6831e;

    public x(i9.b bVar, l9.a aVar, i9.i iVar, g5.f fVar, String str, String str2) {
        bVar.getClass();
        aVar.getClass();
        iVar.getClass();
        str.getClass();
        str2.getClass();
        this.f6827a = bVar;
        this.f6828b = aVar;
        this.f6829c = iVar;
        this.f6830d = fVar;
        this.f6831e = String.format(kotlin.jvm.internal.l.g("configs/users/v2/%s/%s/config?sdkVersion=%s", "https://choice.inmobi.com/"), Arrays.copyOf(new Object[]{str2, str, "p-a-2.4.1"}, 3));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.String r5, v6.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof j9.v
            if (r0 == 0) goto L13
            r0 = r6
            j9.v r0 = (j9.v) r0
            int r1 = r0.f6822l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6822l = r1
            goto L18
        L13:
            j9.v r0 = new j9.v
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f6820a
            int r1 = r0.f6822l
            r2 = 1
            if (r1 == 0) goto L2c
            if (r1 != r2) goto L25
            p6.a.e(r6)     // Catch: r5.a -> L55
            goto L44
        L25:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            r5 = 0
            return r5
        L2c:
            p6.a.e(r6)
            i9.b r6 = r4.f6827a     // Catch: r5.a -> L55
            boolean r6 = r6.a()     // Catch: r5.a -> L55
            if (r6 == 0) goto L47
            i9.i r6 = r4.f6829c     // Catch: r5.a -> L55
            r0.f6822l = r2     // Catch: r5.a -> L55
            java.lang.Object r6 = r6.d(r5, r0)     // Catch: r5.a -> L55
            u6.a r5 = u6.a.f10762a
            if (r6 != r5) goto L44
            return r5
        L44:
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6     // Catch: r5.a -> L55
            return r6
        L47:
            com.inmobi.cmp.ChoiceCmp r5 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch: r5.a -> L55
            com.inmobi.cmp.ChoiceCmpCallback r5 = r5.getCallback()     // Catch: r5.a -> L55
            if (r5 != 0) goto L50
            goto L55
        L50:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch: r5.a -> L55
            r5.onCmpError(r6)     // Catch: r5.a -> L55
        L55:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j9.x.a(java.lang.String, v6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(v6.c r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof j9.w
            if (r0 == 0) goto L13
            r0 = r7
            j9.w r0 = (j9.w) r0
            int r1 = r0.f6826m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6826m = r1
            goto L18
        L13:
            j9.w r0 = new j9.w
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f6824b
            int r1 = r0.f6826m
            r2 = 0
            r4 = 1
            r5 = 21
            if (r1 == 0) goto L32
            if (r1 != r4) goto L2b
            j9.x r0 = r0.f6823a
            p6.a.e(r7)     // Catch: r5.a -> L6e
            goto L4f
        L2b:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r7)
            r7 = 0
            return r7
        L32:
            p6.a.e(r7)
            i9.b r7 = r6.f6827a     // Catch: r5.a -> L6d
            boolean r7 = r7.a()     // Catch: r5.a -> L6d
            if (r7 == 0) goto L52
            i9.i r7 = r6.f6829c     // Catch: r5.a -> L6d
            java.lang.String r1 = r6.f6831e     // Catch: r5.a -> L6d
            r0.f6823a = r6     // Catch: r5.a -> L6d
            r0.f6826m = r4     // Catch: r5.a -> L6d
            java.lang.Object r7 = r7.c(r1, r0)     // Catch: r5.a -> L6d
            u6.a r0 = u6.a.f10762a
            if (r7 != r0) goto L4e
            return r0
        L4e:
            r0 = r6
        L4f:
            i9.a r7 = (i9.a) r7     // Catch: r5.a -> L6e
            goto L79
        L52:
            com.inmobi.cmp.ChoiceCmp r7 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch: r5.a -> L6d
            com.inmobi.cmp.ChoiceCmpCallback r7 = r7.getCallback()     // Catch: r5.a -> L6d
            if (r7 != 0) goto L5b
            goto L60
        L5b:
            com.inmobi.cmp.model.ChoiceError r0 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch: r5.a -> L6d
            r7.onCmpError(r0)     // Catch: r5.a -> L6d
        L60:
            i9.a r7 = new i9.a     // Catch: r5.a -> L6d
            l9.a r0 = r6.f6828b     // Catch: r5.a -> L6d
            java.lang.String r0 = r0.j(r5)     // Catch: r5.a -> L6d
            r7.<init>(r2, r0)     // Catch: r5.a -> L6d
            r0 = r6
            goto L79
        L6d:
            r0 = r6
        L6e:
            i9.a r7 = new i9.a
            l9.a r1 = r0.f6828b
            java.lang.String r1 = r1.j(r5)
            r7.<init>(r2, r1)
        L79:
            l9.a r1 = r0.f6828b
            java.lang.String r2 = r7.f5706a
            r1.f(r5, r2)
            g5.f r0 = r0.f6830d
            java.lang.String r1 = r7.f5706a
            java.lang.Object r0 = r0.k(r1)
            l8.n r0 = (l8.n) r0
            long r1 = r7.f5707b
            r0.f7238m = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j9.x.b(v6.c):java.lang.Object");
    }
}
