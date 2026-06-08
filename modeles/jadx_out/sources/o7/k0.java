package o7;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class k0 extends v7.h {

    /* renamed from: l, reason: collision with root package name */
    public int f8272l;

    public k0(int i) {
        super(0L, false);
        this.f8272l = i;
    }

    public abstract t6.c c();

    public Throwable d(Object obj) {
        u uVar = obj instanceof u ? (u) obj : null;
        if (uVar != null) {
            return uVar.f8315a;
        }
        return null;
    }

    public final void f(Throwable th) {
        c0.q(new c7.a("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th), c().getContext());
    }

    public abstract Object h();

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        r4 = (o7.e1) r5.get(o7.x.f8327b);
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r11 = this;
            t6.c r0 = r11.c()     // Catch: java.lang.Throwable -> L1f
            r0.getClass()     // Catch: java.lang.Throwable -> L1f
            t7.f r0 = (t7.f) r0     // Catch: java.lang.Throwable -> L1f
            t6.c r1 = r0.f10327n     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r0 = r0.f10329p     // Catch: java.lang.Throwable -> L1f
            t6.h r2 = r1.getContext()     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r0 = t7.a.l(r2, r0)     // Catch: java.lang.Throwable -> L1f
            f8.w r3 = t7.a.f10318d     // Catch: java.lang.Throwable -> L1f
            r4 = 0
            if (r0 == r3) goto L22
            o7.a2 r3 = o7.c0.B(r1, r2, r0)     // Catch: java.lang.Throwable -> L1f
            goto L23
        L1f:
            r0 = move-exception
            goto L8b
        L22:
            r3 = r4
        L23:
            t6.h r5 = r1.getContext()     // Catch: java.lang.Throwable -> L46
            java.lang.Object r6 = r11.h()     // Catch: java.lang.Throwable -> L46
            java.lang.Throwable r7 = r11.d(r6)     // Catch: java.lang.Throwable -> L46
            if (r7 != 0) goto L48
            int r8 = r11.f8272l     // Catch: java.lang.Throwable -> L46
            r9 = 1
            if (r8 == r9) goto L3b
            r10 = 2
            if (r8 != r10) goto L3a
            goto L3b
        L3a:
            r9 = 0
        L3b:
            if (r9 == 0) goto L48
            o7.x r4 = o7.x.f8327b     // Catch: java.lang.Throwable -> L46
            t6.f r4 = r5.get(r4)     // Catch: java.lang.Throwable -> L46
            o7.e1 r4 = (o7.e1) r4     // Catch: java.lang.Throwable -> L46
            goto L48
        L46:
            r1 = move-exception
            goto L7f
        L48:
            if (r4 == 0) goto L5f
            boolean r5 = r4.b()     // Catch: java.lang.Throwable -> L46
            if (r5 != 0) goto L5f
            java.util.concurrent.CancellationException r4 = r4.j()     // Catch: java.lang.Throwable -> L46
            r11.b(r4)     // Catch: java.lang.Throwable -> L46
            p6.j r4 = p6.a.b(r4)     // Catch: java.lang.Throwable -> L46
            r1.resumeWith(r4)     // Catch: java.lang.Throwable -> L46
            goto L71
        L5f:
            if (r7 == 0) goto L6a
            p6.j r4 = new p6.j     // Catch: java.lang.Throwable -> L46
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L46
            r1.resumeWith(r4)     // Catch: java.lang.Throwable -> L46
            goto L71
        L6a:
            java.lang.Object r4 = r11.e(r6)     // Catch: java.lang.Throwable -> L46
            r1.resumeWith(r4)     // Catch: java.lang.Throwable -> L46
        L71:
            if (r3 == 0) goto L7b
            boolean r1 = r3.g0()     // Catch: java.lang.Throwable -> L1f
            if (r1 == 0) goto L7a
            goto L7b
        L7a:
            return
        L7b:
            t7.a.g(r2, r0)     // Catch: java.lang.Throwable -> L1f
            return
        L7f:
            if (r3 == 0) goto L87
            boolean r3 = r3.g0()     // Catch: java.lang.Throwable -> L1f
            if (r3 == 0) goto L8a
        L87:
            t7.a.g(r2, r0)     // Catch: java.lang.Throwable -> L1f
        L8a:
            throw r1     // Catch: java.lang.Throwable -> L1f
        L8b:
            r11.f(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.k0.run():void");
    }

    public void b(CancellationException cancellationException) {
    }

    public Object e(Object obj) {
        return obj;
    }
}
