package q7;

import a4.x;
import kotlin.jvm.internal.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o extends e {

    /* renamed from: t, reason: collision with root package name */
    public final a f8774t;

    public o(int i, a aVar) {
        super(i);
        this.f8774t = aVar;
        if (aVar == a.f8729a) {
            androidx.core.view.contentcapture.a.q(y.a(e.class).c(), "This implementation does not support suspension for senders, use ", " instead");
            throw null;
        }
        if (i >= 1) {
            return;
        }
        s1.o.o(x.g(i, "Buffered channel capacity must be at least 1, but ", " was specified"));
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b5, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object K(java.lang.Object r16, boolean r17) {
        /*
            r15 = this;
            q7.a r1 = r15.f8774t
            q7.a r2 = q7.a.f8731l
            p6.x r8 = p6.x.f8463a
            if (r1 != r2) goto L17
            java.lang.Object r1 = super.p(r16)
            boolean r2 = r1 instanceof q7.k
            if (r2 == 0) goto L16
            boolean r2 = r1 instanceof q7.j
            if (r2 == 0) goto L15
            goto L16
        L15:
            return r8
        L16:
            return r1
        L17:
            f8.w r6 = q7.g.f8756d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = q7.e.f8746o
            java.lang.Object r1 = r1.get(r15)
            q7.m r1 = (q7.m) r1
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = q7.e.f8742b
            long r2 = r2.getAndIncrement(r15)
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r4 = r4 & r2
            r7 = 0
            boolean r7 = r15.v(r2, r7)
            int r9 = q7.g.f8754b
            long r10 = (long) r9
            long r2 = r4 / r10
            long r12 = r4 % r10
            int r12 = (int) r12
            long r13 = r1.f10355c
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 == 0) goto L53
            q7.m r2 = q7.e.b(r15, r2, r1)
            if (r2 != 0) goto L52
            if (r7 == 0) goto L21
            java.lang.Throwable r1 = r15.s()
            q7.j r2 = new q7.j
            r2.<init>(r1)
            return r2
        L52:
            r1 = r2
        L53:
            r0 = r15
            r3 = r16
            r2 = r12
            int r12 = q7.e.f(r0, r1, r2, r3, r4, r6, r7)
            if (r12 == 0) goto Lb6
            r3 = 1
            if (r12 == r3) goto Lb5
            r3 = 2
            if (r12 == r3) goto L8f
            r2 = 3
            if (r12 == r2) goto L88
            r2 = 4
            if (r12 == r2) goto L71
            r2 = 5
            if (r12 == r2) goto L6d
            goto L21
        L6d:
            r1.b()
            goto L21
        L71:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = q7.e.f8743l
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L7e
            r1.b()
        L7e:
            java.lang.Throwable r1 = r15.s()
            q7.j r2 = new q7.j
            r2.<init>(r1)
            return r2
        L88:
            java.lang.String r1 = "unexpected"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r1)
            r1 = 0
            return r1
        L8f:
            if (r7 == 0) goto L9e
            r1.i()
            java.lang.Throwable r1 = r15.s()
            q7.j r2 = new q7.j
            r2.<init>(r1)
            return r2
        L9e:
            boolean r3 = r6 instanceof o7.c2
            if (r3 == 0) goto La5
            o7.c2 r6 = (o7.c2) r6
            goto La6
        La5:
            r6 = 0
        La6:
            if (r6 == 0) goto Lad
            int r12 = r2 + r9
            r6.a(r1, r12)
        Lad:
            long r3 = r1.f10355c
            long r3 = r3 * r10
            long r1 = (long) r2
            long r3 = r3 + r1
            r15.j(r3)
        Lb5:
            return r8
        Lb6:
            r1.b()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.o.K(java.lang.Object, boolean):java.lang.Object");
    }

    @Override // q7.e, q7.u
    public final Object e(Object obj, t6.c cVar) {
        if (K(obj, true) instanceof j) {
            throw s();
        }
        return p6.x.f8463a;
    }

    @Override // q7.e, q7.u
    public final Object p(Object obj) {
        return K(obj, false);
    }

    @Override // q7.e
    public final boolean y() {
        return this.f8774t == a.f8730b;
    }
}
