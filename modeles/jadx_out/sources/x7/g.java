package x7;

import f8.w;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.a0;
import o7.c0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends l implements a {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f11527q = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "owner$volatile");
    private volatile /* synthetic */ Object owner$volatile;

    public g(boolean z9) {
        super(1, z9 ? 1 : 0);
        this.owner$volatile = z9 ? null : h.f11528a;
        new o7.k(this, 1);
    }

    @Override // x7.a
    public final w7.a getOnLock() {
        a0.b(3, e.f11525a);
        a0.b(3, f.f11526a);
        return new q1.a(13);
    }

    @Override // x7.a
    public final boolean holdsLock(Object obj) {
        char c9;
        while (true) {
            if (!isLocked()) {
                c9 = 0;
                break;
            }
            Object obj2 = f11527q.get(this);
            if (obj2 != h.f11528a) {
                c9 = obj2 == obj ? (char) 1 : (char) 2;
            }
        }
        return c9 == 1;
    }

    @Override // x7.a
    public final boolean isLocked() {
        return Math.max(l.f11536p.get(this), 0) == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0022, code lost:
    
        r6 = x7.g.f11527q;
        r2 = r0.f11521l;
        r6.set(r2, r0.f11520b);
        r0.f11519a.A(new androidx.work.impl.model.a(11, r2, r0), r1);
     */
    @Override // x7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object lock(java.lang.Object r6, t6.c r7) {
        /*
            r5 = this;
            boolean r0 = r5.tryLock(r6)
            p6.x r1 = p6.x.f8463a
            if (r0 == 0) goto L9
            goto L4b
        L9:
            t6.c r7 = d0.b.I(r7)
            o7.l r7 = o7.c0.p(r7)
            x7.c r0 = new x7.c     // Catch: java.lang.Throwable -> L4c
            r0.<init>(r5, r7, r6)     // Catch: java.lang.Throwable -> L4c
        L16:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = x7.l.f11536p     // Catch: java.lang.Throwable -> L4c
            int r6 = r6.getAndDecrement(r5)     // Catch: java.lang.Throwable -> L4c
            int r2 = r5.f11537a     // Catch: java.lang.Throwable -> L4c
            if (r6 > r2) goto L16
            if (r6 <= 0) goto L38
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = x7.g.f11527q     // Catch: java.lang.Throwable -> L4c
            x7.g r2 = r0.f11521l     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r3 = r0.f11520b     // Catch: java.lang.Throwable -> L4c
            r6.set(r2, r3)     // Catch: java.lang.Throwable -> L4c
            o7.l r6 = r0.f11519a     // Catch: java.lang.Throwable -> L4c
            androidx.work.impl.model.a r3 = new androidx.work.impl.model.a     // Catch: java.lang.Throwable -> L4c
            r4 = 11
            r3.<init>(r4, r2, r0)     // Catch: java.lang.Throwable -> L4c
            r6.A(r3, r1)     // Catch: java.lang.Throwable -> L4c
            goto L3e
        L38:
            boolean r6 = r5.a(r0)     // Catch: java.lang.Throwable -> L4c
            if (r6 == 0) goto L16
        L3e:
            java.lang.Object r6 = r7.r()
            u6.a r7 = u6.a.f10762a
            if (r6 != r7) goto L47
            goto L48
        L47:
            r6 = r1
        L48:
            if (r6 != r7) goto L4b
            return r6
        L4b:
            return r1
        L4c:
            r6 = move-exception
            r7.z()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: x7.g.lock(java.lang.Object, t6.c):java.lang.Object");
    }

    public final String toString() {
        return "Mutex@" + c0.o(this) + "[isLocked=" + isLocked() + ",owner=" + f11527q.get(this) + ']';
    }

    @Override // x7.a
    public final boolean tryLock(Object obj) {
        int i;
        char c9;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = l.f11536p;
            int i6 = atomicIntegerFieldUpdater.get(this);
            int i10 = this.f11537a;
            if (i6 > i10) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i > i10) {
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i10));
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11527q;
                if (i6 <= 0) {
                    if (obj == null) {
                        break;
                    }
                    while (true) {
                        if (!isLocked()) {
                            c9 = 0;
                            break;
                        }
                        Object obj2 = atomicReferenceFieldUpdater.get(this);
                        if (obj2 != h.f11528a) {
                            c9 = obj2 == obj ? (char) 1 : (char) 2;
                        }
                    }
                    if (c9 == 1) {
                        com.google.gson.internal.a.m(obj, "This mutex is already locked by the specified owner: ");
                        return false;
                    }
                    if (c9 == 2) {
                        break;
                    }
                } else if (atomicIntegerFieldUpdater.compareAndSet(this, i6, i6 - 1)) {
                    atomicReferenceFieldUpdater.set(this, obj);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // x7.a
    public final void unlock(Object obj) {
        while (isLocked()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11527q;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            w wVar = h.f11528a;
            if (obj2 != wVar) {
                if (obj2 == obj || obj == null) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, wVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            break;
                        }
                    }
                    b();
                    return;
                }
                throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
            }
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("This mutex is not locked");
    }
}
