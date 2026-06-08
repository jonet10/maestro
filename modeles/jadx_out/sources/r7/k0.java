package r7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class k0 {

    /* renamed from: a, reason: collision with root package name */
    public static final f8.w f9005a = new f8.w("NO_VALUE");

    /* renamed from: b, reason: collision with root package name */
    public static final f8.w f9006b = new f8.w("NONE");

    /* renamed from: c, reason: collision with root package name */
    public static final f8.w f9007c = new f8.w("PENDING");

    public static final j0 a(int i, int i6) {
        if (i < 0) {
            s1.o.o(androidx.lifecycle.l.u(i, "replay cannot be negative, but was "));
            return null;
        }
        if (i6 < 0) {
            s1.o.o(androidx.lifecycle.l.u(i6, "extraBufferCapacity cannot be negative, but was "));
            return null;
        }
        int i10 = i6 + i;
        if (i10 < 0) {
            i10 = Integer.MAX_VALUE;
        }
        return new j0(i, i10);
    }

    public static final o0 b(Object obj) {
        if (obj == null) {
            obj = s7.c.f9349b;
        }
        return new o0(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(r7.q0 r4, d7.q r5, java.lang.Throwable r6, v6.c r7) {
        /*
            boolean r0 = r7 instanceof r7.k
            if (r0 == 0) goto L13
            r0 = r7
            r7.k r0 = (r7.k) r0
            int r1 = r0.f9004l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9004l = r1
            goto L18
        L13:
            r7.k r0 = new r7.k
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f9003b
            int r1 = r0.f9004l
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            java.lang.Throwable r6 = r0.f9002a
            p6.a.e(r7)     // Catch: java.lang.Throwable -> L27
            goto L40
        L27:
            r4 = move-exception
            goto L43
        L29:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r4)
            r4 = 0
            return r4
        L30:
            p6.a.e(r7)
            r0.f9002a = r6     // Catch: java.lang.Throwable -> L27
            r0.f9004l = r2     // Catch: java.lang.Throwable -> L27
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L27
            u6.a r5 = u6.a.f10762a
            if (r4 != r5) goto L40
            return r5
        L40:
            p6.x r4 = p6.x.f8463a
            return r4
        L43:
            if (r6 == 0) goto L4a
            if (r6 == r4) goto L4a
            p6.a.a(r4, r6)
        L4a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: r7.k0.c(r7.q0, d7.q, java.lang.Throwable, v6.c):java.lang.Object");
    }

    public static final void d(Object[] objArr, long j, Object obj) {
        objArr[((int) j) & (objArr.length - 1)] = obj;
    }

    public static final c e(d7.p pVar) {
        return new c(pVar, t6.i.f10314a, -2, q7.a.f8729a);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.Serializable f(r7.h r4, r7.i r5, v6.c r6) {
        /*
            boolean r0 = r6 instanceof r7.q
            if (r0 == 0) goto L13
            r0 = r6
            r7.q r0 = (r7.q) r0
            int r1 = r0.f9044l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9044l = r1
            goto L18
        L13:
            r7.q r0 = new r7.q
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f9043b
            int r1 = r0.f9044l
            r2 = 1
            if (r1 == 0) goto L30
            if (r1 != r2) goto L29
            kotlin.jvm.internal.x r4 = r0.f9042a
            p6.a.e(r6)     // Catch: java.lang.Throwable -> L27
            goto L4a
        L27:
            r5 = move-exception
            goto L4e
        L29:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r4)
            r4 = 0
            return r4
        L30:
            p6.a.e(r6)
            kotlin.jvm.internal.x r6 = new kotlin.jvm.internal.x
            r6.<init>()
            r7.f r1 = new r7.f     // Catch: java.lang.Throwable -> L4c
            r1.<init>(r5, r6)     // Catch: java.lang.Throwable -> L4c
            r0.f9042a = r6     // Catch: java.lang.Throwable -> L4c
            r0.f9044l = r2     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r4 = r4.collect(r1, r0)     // Catch: java.lang.Throwable -> L4c
            u6.a r5 = u6.a.f10762a
            if (r4 != r5) goto L4a
            return r5
        L4a:
            r4 = 0
            return r4
        L4c:
            r5 = move-exception
            r4 = r6
        L4e:
            java.lang.Object r4 = r4.f7024a
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            if (r4 == 0) goto L5a
            boolean r6 = r4.equals(r5)
            if (r6 != 0) goto L7c
        L5a:
            t6.h r6 = r0.getContext()
            o7.x r0 = o7.x.f8327b
            t6.f r6 = r6.get(r0)
            o7.e1 r6 = (o7.e1) r6
            if (r6 == 0) goto L7d
            boolean r0 = r6.isCancelled()
            if (r0 != 0) goto L6f
            goto L7d
        L6f:
            java.util.concurrent.CancellationException r6 = r6.j()
            if (r6 == 0) goto L7d
            boolean r6 = r6.equals(r5)
            if (r6 != 0) goto L7c
            goto L7d
        L7c:
            throw r5
        L7d:
            if (r4 != 0) goto L80
            return r5
        L80:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L88
            p6.a.a(r4, r5)
            throw r4
        L88:
            p6.a.a(r5, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: r7.k0.f(r7.h, r7.i, v6.c):java.io.Serializable");
    }

    public static final h g(h hVar) {
        boolean z9 = hVar instanceof s7.i;
        q7.a aVar = q7.a.f8730b;
        return z9 ? s7.c.a((s7.i) hVar, null, 0, aVar, 1) : new d(hVar, (t6.h) null, 0, aVar, 2);
    }

    public static final h h(h hVar) {
        return hVar instanceof m0 ? hVar : hVar instanceof g ? hVar : new g(hVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
    
        if (r1.emit(r10, r0) == r5) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #1 {all -> 0x0035, blocks: (B:12:0x002f, B:14:0x0055, B:20:0x006a, B:22:0x0072, B:32:0x0046, B:35:0x0051), top: B:7:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0084 -> B:13:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object i(r7.i r7, q7.i r8, boolean r9, v6.c r10) {
        /*
            boolean r0 = r10 instanceof r7.j
            if (r0 == 0) goto L13
            r0 = r10
            r7.j r0 = (r7.j) r0
            int r1 = r0.f8994o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8994o = r1
            goto L18
        L13:
            r7.j r0 = new r7.j
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f8993n
            int r1 = r0.f8994o
            r2 = 0
            r3 = 2
            r4 = 1
            u6.a r5 = u6.a.f10762a
            if (r1 == 0) goto L4a
            if (r1 == r4) goto L3e
            if (r1 != r3) goto L37
            boolean r9 = r0.f8992m
            q7.b r7 = r0.f8991l
            q7.i r8 = r0.f8990b
            r7.i r1 = r0.f8989a
            p6.a.e(r10)     // Catch: java.lang.Throwable -> L35
        L32:
            r10 = r7
            r7 = r1
            goto L55
        L35:
            r7 = move-exception
            goto L8f
        L37:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r7)
            r7 = 0
            return r7
        L3e:
            boolean r9 = r0.f8992m
            q7.b r7 = r0.f8991l
            q7.i r8 = r0.f8990b
            r7.i r1 = r0.f8989a
            p6.a.e(r10)     // Catch: java.lang.Throwable -> L35
            goto L6a
        L4a:
            p6.a.e(r10)
            boolean r10 = r7 instanceof r7.q0
            if (r10 != 0) goto Laa
            q7.b r10 = r8.iterator()     // Catch: java.lang.Throwable -> L35
        L55:
            r0.f8989a = r7     // Catch: java.lang.Throwable -> L35
            r0.f8990b = r8     // Catch: java.lang.Throwable -> L35
            r0.f8991l = r10     // Catch: java.lang.Throwable -> L35
            r0.f8992m = r9     // Catch: java.lang.Throwable -> L35
            r0.f8994o = r4     // Catch: java.lang.Throwable -> L35
            java.lang.Object r1 = r10.b(r0)     // Catch: java.lang.Throwable -> L35
            if (r1 != r5) goto L66
            goto L86
        L66:
            r6 = r1
            r1 = r7
            r7 = r10
            r10 = r6
        L6a:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L35
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L35
            if (r10 == 0) goto L87
            java.lang.Object r10 = r7.c()     // Catch: java.lang.Throwable -> L35
            r0.f8989a = r1     // Catch: java.lang.Throwable -> L35
            r0.f8990b = r8     // Catch: java.lang.Throwable -> L35
            r0.f8991l = r7     // Catch: java.lang.Throwable -> L35
            r0.f8992m = r9     // Catch: java.lang.Throwable -> L35
            r0.f8994o = r3     // Catch: java.lang.Throwable -> L35
            java.lang.Object r10 = r1.emit(r10, r0)     // Catch: java.lang.Throwable -> L35
            if (r10 != r5) goto L32
        L86:
            return r5
        L87:
            if (r9 == 0) goto L8c
            r8.c(r2)
        L8c:
            p6.x r7 = p6.x.f8463a
            return r7
        L8f:
            throw r7     // Catch: java.lang.Throwable -> L90
        L90:
            r10 = move-exception
            if (r9 == 0) goto La9
            boolean r9 = r7 instanceof java.util.concurrent.CancellationException
            if (r9 == 0) goto L9a
            r2 = r7
            java.util.concurrent.CancellationException r2 = (java.util.concurrent.CancellationException) r2
        L9a:
            if (r2 != 0) goto La6
            java.util.concurrent.CancellationException r2 = new java.util.concurrent.CancellationException
            java.lang.String r9 = "Channel was consumed, consumer had failed"
            r2.<init>(r9)
            r2.initCause(r7)
        La6:
            r8.c(r2)
        La9:
            throw r10
        Laa:
            r7.q0 r7 = (r7.q0) r7
            java.lang.Throwable r7 = r7.f9045a
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: r7.k0.i(r7.i, q7.i, boolean, v6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object j(r7.h r5, v6.c r6) {
        /*
            f8.w r0 = s7.c.f9349b
            boolean r1 = r6 instanceof r7.y
            if (r1 == 0) goto L15
            r1 = r6
            r7.y r1 = (r7.y) r1
            int r2 = r1.f9077m
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f9077m = r2
            goto L1a
        L15:
            r7.y r1 = new r7.y
            r1.<init>(r6)
        L1a:
            java.lang.Object r6 = r1.f9076l
            int r2 = r1.f9077m
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2d
            r7.x r5 = r1.f9075b
            kotlin.jvm.internal.x r1 = r1.f9074a
            p6.a.e(r6)     // Catch: s7.a -> L2b
            goto L5d
        L2b:
            r6 = move-exception
            goto L59
        L2d:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
        L32:
            r5 = 0
            return r5
        L34:
            p6.a.e(r6)
            kotlin.jvm.internal.x r6 = new kotlin.jvm.internal.x
            r6.<init>()
            r6.f7024a = r0
            r7.x r2 = new r7.x
            r4 = 0
            r2.<init>(r6, r4)
            r1.f9074a = r6     // Catch: s7.a -> L55
            r1.f9075b = r2     // Catch: s7.a -> L55
            r1.f9077m = r3     // Catch: s7.a -> L55
            java.lang.Object r5 = r5.collect(r2, r1)     // Catch: s7.a -> L55
            u6.a r1 = u6.a.f10762a
            if (r5 != r1) goto L53
            return r1
        L53:
            r1 = r6
            goto L5d
        L55:
            r5 = move-exception
            r1 = r6
            r6 = r5
            r5 = r2
        L59:
            java.lang.Object r2 = r6.f9344a
            if (r2 != r5) goto L68
        L5d:
            java.lang.Object r5 = r1.f7024a
            if (r5 == r0) goto L62
            return r5
        L62:
            java.lang.String r5 = "Expected at least one element"
            androidx.privacysandbox.ads.adservices.customaudience.a.s(r5)
            goto L32
        L68:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: r7.k0.j(r7.h, v6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object k(r7.h r4, v6.c r5) {
        /*
            boolean r0 = r5 instanceof r7.z
            if (r0 == 0) goto L13
            r0 = r5
            r7.z r0 = (r7.z) r0
            int r1 = r0.f9081m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9081m = r1
            goto L18
        L13:
            r7.z r0 = new r7.z
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f9080l
            int r1 = r0.f9081m
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2b
            r7.x r4 = r0.f9079b
            kotlin.jvm.internal.x r0 = r0.f9078a
            p6.a.e(r5)     // Catch: s7.a -> L29
            goto L59
        L29:
            r5 = move-exception
            goto L55
        L2b:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r4)
            r4 = 0
            return r4
        L32:
            p6.a.e(r5)
            kotlin.jvm.internal.x r5 = new kotlin.jvm.internal.x
            r5.<init>()
            r7.x r1 = new r7.x
            r3 = 1
            r1.<init>(r5, r3)
            r0.f9078a = r5     // Catch: s7.a -> L51
            r0.f9079b = r1     // Catch: s7.a -> L51
            r0.f9081m = r2     // Catch: s7.a -> L51
            java.lang.Object r4 = r4.collect(r1, r0)     // Catch: s7.a -> L51
            u6.a r0 = u6.a.f10762a
            if (r4 != r0) goto L4f
            return r0
        L4f:
            r0 = r5
            goto L59
        L51:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r1
        L55:
            java.lang.Object r1 = r5.f9344a
            if (r1 != r4) goto L5c
        L59:
            java.lang.Object r4 = r0.f7024a
            return r4
        L5c:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: r7.k0.k(r7.h, v6.c):java.lang.Object");
    }

    public static final h l(h hVar, o7.w wVar) {
        if (wVar.get(o7.x.f8327b) != null) {
            androidx.core.content.pm.a.i(wVar, "Flow context cannot contain job in it. Had ");
            return null;
        }
        if (wVar.equals(t6.i.f10314a)) {
            return hVar;
        }
        if (hVar instanceof s7.i) {
            return s7.c.a((s7.i) hVar, wVar, 0, null, 6);
        }
        return new d(hVar, (t6.h) wVar, 0, (q7.a) null, 12);
    }

    public static final h m(g0 g0Var, t6.h hVar, int i, q7.a aVar) {
        return ((i == 0 || i == -3) && aVar == q7.a.f8729a) ? g0Var : new d((Object) g0Var, hVar, i, aVar, 1);
    }

    public static final void n(o oVar, o7.a0 a0Var) {
        o7.c0.s(a0Var, null, null, new p9.c(oVar, (t6.c) null, 3), 3);
    }
}
