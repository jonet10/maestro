package t7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import o7.c0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10338a = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_next$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10339b = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_prev$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10340l = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    public final boolean d(j jVar, int i) {
        while (true) {
            j e10 = e();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10339b;
            if (e10 == null) {
                Object obj = atomicReferenceFieldUpdater.get(this);
                while (true) {
                    e10 = (j) obj;
                    if (!e10.h()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(e10);
                }
            }
            if (e10 instanceof h) {
                return (((h) e10).f10337m & i) == 0 && e10.d(jVar, i);
            }
            atomicReferenceFieldUpdater.set(jVar, e10);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f10338a;
            atomicReferenceFieldUpdater2.set(jVar, this);
            while (!atomicReferenceFieldUpdater2.compareAndSet(e10, this, jVar)) {
                if (atomicReferenceFieldUpdater2.get(e10) != this) {
                    break;
                }
            }
            jVar.f(this);
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        r6 = ((t7.p) r6).f10352a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        if (r5.compareAndSet(r4, r3, r6) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        if (r5.get(r4) == r3) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x001c, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final t7.j e() {
        /*
            r9 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = t7.j.f10339b
            java.lang.Object r1 = r0.get(r9)
            t7.j r1 = (t7.j) r1
            r2 = 0
            r3 = r1
        La:
            r4 = r2
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = t7.j.f10338a
            java.lang.Object r6 = r5.get(r3)
            if (r6 != r9) goto L24
            if (r1 != r3) goto L16
            goto L1c
        L16:
            boolean r2 = r0.compareAndSet(r9, r1, r3)
            if (r2 == 0) goto L1d
        L1c:
            return r3
        L1d:
            java.lang.Object r2 = r0.get(r9)
            if (r2 == r1) goto L16
            goto L0
        L24:
            boolean r7 = r9.h()
            if (r7 == 0) goto L2b
            return r2
        L2b:
            boolean r7 = r6 instanceof t7.p
            if (r7 == 0) goto L4b
            if (r4 == 0) goto L44
            t7.p r6 = (t7.p) r6
            t7.j r6 = r6.f10352a
        L35:
            boolean r7 = r5.compareAndSet(r4, r3, r6)
            if (r7 == 0) goto L3d
            r3 = r4
            goto La
        L3d:
            java.lang.Object r7 = r5.get(r4)
            if (r7 == r3) goto L35
            goto L0
        L44:
            java.lang.Object r3 = r0.get(r3)
            t7.j r3 = (t7.j) r3
            goto Lb
        L4b:
            r6.getClass()
            r4 = r6
            t7.j r4 = (t7.j) r4
            r8 = r4
            r4 = r3
            r3 = r8
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.j.e():t7.j");
    }

    public final void f(j jVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10339b;
            j jVar2 = (j) atomicReferenceFieldUpdater.get(jVar);
            if (f10338a.get(this) != jVar) {
                return;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(jVar, jVar2, this)) {
                if (atomicReferenceFieldUpdater.get(jVar) != jVar2) {
                    break;
                }
            }
            if (h()) {
                jVar.e();
                return;
            }
            return;
        }
    }

    public final j g() {
        Object obj = f10338a.get(this);
        p pVar = obj instanceof p ? (p) obj : null;
        if (pVar != null) {
            return pVar.f10352a;
        }
        obj.getClass();
        return (j) obj;
    }

    public boolean h() {
        return f10338a.get(this) instanceof p;
    }

    public String toString() {
        return new i(this, c0.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1) + '@' + c0.o(this);
    }
}
