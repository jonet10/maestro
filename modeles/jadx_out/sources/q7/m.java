package q7;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m extends t7.s {

    /* renamed from: e, reason: collision with root package name */
    public final e f8773e;
    public final /* synthetic */ AtomicReferenceArray f;

    public m(long j, m mVar, e eVar, int i) {
        super(j, mVar, i);
        this.f8773e = eVar;
        this.f = new AtomicReferenceArray(g.f8754b * 2);
    }

    @Override // t7.s
    public final int g() {
        return g.f8754b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0047, code lost:
    
        n(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x004a, code lost:
    
        if (r0 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x004c, code lost:
    
        r2.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x004f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
    
        return;
     */
    @Override // t7.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(int r5, t6.h r6) {
        /*
            r4 = this;
            int r6 = q7.g.f8754b
            if (r5 < r6) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r5 = r5 - r6
        La:
            int r6 = r5 * 2
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r4.f
            r1.get(r6)
        L11:
            java.lang.Object r6 = r4.l(r5)
            boolean r1 = r6 instanceof o7.c2
            q7.e r2 = r4.f8773e
            r3 = 0
            if (r1 != 0) goto L50
            boolean r1 = r6 instanceof q7.v
            if (r1 == 0) goto L21
            goto L50
        L21:
            f8.w r1 = q7.g.j
            if (r6 == r1) goto L47
            f8.w r1 = q7.g.f8758k
            if (r6 != r1) goto L2a
            goto L47
        L2a:
            f8.w r1 = q7.g.g
            if (r6 == r1) goto L11
            f8.w r1 = q7.g.f
            if (r6 != r1) goto L33
            goto L11
        L33:
            f8.w r5 = q7.g.i
            if (r6 == r5) goto L6a
            f8.w r5 = q7.g.f8756d
            if (r6 != r5) goto L3c
            goto L6a
        L3c:
            f8.w r5 = q7.g.f8759l
            if (r6 != r5) goto L41
            goto L6a
        L41:
            java.lang.String r5 = "unexpected state: "
            com.google.gson.internal.a.m(r6, r5)
            return
        L47:
            r4.n(r5, r3)
            if (r0 == 0) goto L6a
            r2.getClass()
            return
        L50:
            if (r0 == 0) goto L55
            f8.w r1 = q7.g.j
            goto L57
        L55:
            f8.w r1 = q7.g.f8758k
        L57:
            boolean r6 = r4.k(r5, r6, r1)
            if (r6 == 0) goto L11
            r4.n(r5, r3)
            r6 = r0 ^ 1
            r4.m(r5, r6)
            if (r0 == 0) goto L6a
            r2.getClass()
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.m.h(int, t6.h):void");
    }

    public final boolean k(int i, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        int i6 = (i * 2) + 1;
        do {
            atomicReferenceArray = this.f;
            if (atomicReferenceArray.compareAndSet(i6, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i6) == obj);
        return false;
    }

    public final Object l(int i) {
        return this.f.get((i * 2) + 1);
    }

    public final void m(int i, boolean z9) {
        if (z9) {
            e eVar = this.f8773e;
            eVar.getClass();
            eVar.J((this.f10355c * g.f8754b) + i);
        }
        i();
    }

    public final void n(int i, Object obj) {
        this.f.set(i * 2, obj);
    }

    public final void o(int i, Object obj) {
        this.f.set((i * 2) + 1, obj);
    }
}
