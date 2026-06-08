package o7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a2 extends t7.r {

    /* renamed from: n, reason: collision with root package name */
    public final ThreadLocal f8231n;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a2(t6.c r3, t6.h r4) {
        /*
            r2 = this;
            o7.b2 r0 = o7.b2.f8238a
            t6.f r1 = r4.get(r0)
            if (r1 != 0) goto Ld
            t6.h r0 = r4.plus(r0)
            goto Le
        Ld:
            r0 = r4
        Le:
            r2.<init>(r3, r0)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f8231n = r0
            t6.h r3 = r3.getContext()
            t6.d r0 = t6.d.f10313a
            t6.f r3 = r3.get(r0)
            boolean r3 = r3 instanceof o7.w
            if (r3 != 0) goto L31
            r3 = 0
            java.lang.Object r3 = t7.a.l(r4, r3)
            t7.a.g(r4, r3)
            r2.h0(r4, r3)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.a2.<init>(t6.c, t6.h):void");
    }

    public final boolean g0() {
        boolean z9 = this.threadLocalIsSet && this.f8231n.get() == null;
        this.f8231n.remove();
        return !z9;
    }

    public final void h0(t6.h hVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f8231n.set(new p6.i(hVar, obj));
    }

    @Override // t7.r, o7.m1
    public final void v(Object obj) {
        if (this.threadLocalIsSet) {
            p6.i iVar = (p6.i) this.f8231n.get();
            if (iVar != null) {
                t7.a.g((t6.h) iVar.f8441a, iVar.f8442b);
            }
            this.f8231n.remove();
        }
        Object u7 = c0.u(obj);
        t6.c cVar = this.f10353m;
        t6.h context = cVar.getContext();
        Object l10 = t7.a.l(context, null);
        a2 B = l10 != t7.a.f10318d ? c0.B(cVar, context, l10) : null;
        try {
            this.f10353m.resumeWith(u7);
            if (B == null || B.g0()) {
                t7.a.g(context, l10);
            }
        } catch (Throwable th) {
            if (B == null || B.g0()) {
                t7.a.g(context, l10);
            }
            throw th;
        }
    }
}
