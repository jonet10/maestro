package t2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9539a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f9540b;

    public /* synthetic */ b(c cVar, int i) {
        this.f9539a = i;
        this.f9540b = cVar;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r7 = this;
            int r0 = r7.f9539a
            switch(r0) {
                case 0: goto L90;
                case 1: goto L8a;
                default: goto L5;
            }
        L5:
            t2.c r0 = r7.f9540b
            java.lang.Object r1 = t2.c.f9541m
            monitor-enter(r1)
            n1.f r2 = r0.f9542a     // Catch: java.lang.Throwable -> L21
            r2.a()     // Catch: java.lang.Throwable -> L21
            android.content.Context r2 = r2.f7908a     // Catch: java.lang.Throwable -> L21
            m8.q r2 = m8.q.b(r2)     // Catch: java.lang.Throwable -> L21
            m8.q r3 = r0.f9544c     // Catch: java.lang.Throwable -> L81
            u2.b r3 = r3.o()     // Catch: java.lang.Throwable -> L81
            if (r2 == 0) goto L24
            r2.r()     // Catch: java.lang.Throwable -> L21
            goto L24
        L21:
            r0 = move-exception
            goto L88
        L24:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L21
            int r1 = r3.f10405b     // Catch: t2.e -> L45
            r2 = 0
            r4 = 5
            r5 = 1
            if (r1 != r4) goto L2e
            r6 = r5
            goto L2f
        L2e:
            r6 = r2
        L2f:
            if (r6 != 0) goto L47
            r6 = 3
            if (r1 != r6) goto L35
            r2 = r5
        L35:
            if (r2 == 0) goto L38
            goto L47
        L38:
            t2.j r1 = r0.f9545d     // Catch: t2.e -> L45
            boolean r1 = r1.a(r3)     // Catch: t2.e -> L45
            if (r1 == 0) goto L80
            u2.b r1 = r0.c(r3)     // Catch: t2.e -> L45
            goto L4b
        L45:
            r1 = move-exception
            goto L7d
        L47:
            u2.b r1 = r0.i(r3)     // Catch: t2.e -> L45
        L4b:
            r0.f(r1)
            r0.m(r3, r1)
            int r2 = r1.f10405b
            r3 = 4
            if (r2 != r3) goto L5b
            java.lang.String r2 = r1.f10404a
            r0.l(r2)
        L5b:
            int r2 = r1.f10405b
            if (r2 != r4) goto L68
            t2.e r1 = new t2.e
            r1.<init>()
            r0.j(r1)
            goto L80
        L68:
            r3 = 2
            if (r2 == r3) goto L72
            if (r2 != r5) goto L6e
            goto L72
        L6e:
            r0.k(r1)
            goto L80
        L72:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."
            r1.<init>(r2)
            r0.j(r1)
            goto L80
        L7d:
            r0.j(r1)
        L80:
            return
        L81:
            r0 = move-exception
            if (r2 == 0) goto L87
            r2.r()     // Catch: java.lang.Throwable -> L21
        L87:
            throw r0     // Catch: java.lang.Throwable -> L21
        L88:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L21
            throw r0
        L8a:
            t2.c r0 = r7.f9540b
            r0.b()
            return
        L90:
            t2.c r0 = r7.f9540b
            r0.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.b.run():void");
    }
}
