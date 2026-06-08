package o7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class w extends t6.a implements t6.e {
    public static final v Key = new v(t6.d.f10313a, new androidx.room.f(29));

    public w() {
        super(t6.d.f10313a);
    }

    public static /* synthetic */ w limitedParallelism$default(w wVar, int i, String str, int i6, Object obj) {
        if (obj != null) {
            a3.b.r("Super calls with default arguments not supported in this target, function: limitedParallelism");
            return null;
        }
        if ((i6 & 2) != 0) {
            str = null;
        }
        return wVar.limitedParallelism(i, str);
    }

    public abstract void dispatch(t6.h hVar, Runnable runnable);

    public void dispatchYield(t6.h hVar, Runnable runnable) {
        dispatch(hVar, runnable);
    }

    @Override // t6.a, t6.h
    public <E extends t6.f> E get(t6.g gVar) {
        E e10;
        gVar.getClass();
        if (!(gVar instanceof v)) {
            if (t6.d.f10313a == gVar) {
                return this;
            }
            return null;
        }
        v vVar = (v) gVar;
        t6.g key = getKey();
        key.getClass();
        if ((key == vVar || vVar.f8319b == key) && (e10 = (E) vVar.f8318a.invoke(this)) != null) {
            return e10;
        }
        return null;
    }

    @Override // t6.e
    public final <T> t6.c interceptContinuation(t6.c cVar) {
        return new t7.f(this, cVar);
    }

    public boolean isDispatchNeeded(t6.h hVar) {
        return !(this instanceof z1);
    }

    public w limitedParallelism(int i, String str) {
        t7.a.a(i);
        return new t7.g(this, i, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if (((t6.f) r3.f8318a.invoke(r2)) != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        return t6.i.f10314a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        if (t6.d.f10313a == r3) goto L15;
     */
    @Override // t6.a, t6.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public t6.h minusKey(t6.g r3) {
        /*
            r2 = this;
            r3.getClass()
            boolean r0 = r3 instanceof o7.v
            if (r0 == 0) goto L23
            o7.v r3 = (o7.v) r3
            t6.g r0 = r2.getKey()
            r0.getClass()
            if (r0 == r3) goto L18
            t6.g r1 = r3.f8319b
            if (r1 != r0) goto L17
            goto L18
        L17:
            return r2
        L18:
            d7.l r3 = r3.f8318a
            java.lang.Object r3 = r3.invoke(r2)
            t6.f r3 = (t6.f) r3
            if (r3 == 0) goto L2a
            goto L27
        L23:
            t6.d r0 = t6.d.f10313a
            if (r0 != r3) goto L2a
        L27:
            t6.i r3 = t6.i.f10314a
            return r3
        L2a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.w.minusKey(t6.g):t6.h");
    }

    @Override // t6.e
    public final void releaseInterceptedContinuation(t6.c cVar) {
        cVar.getClass();
        t7.f fVar = (t7.f) cVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = t7.f.f10325q;
        while (atomicReferenceFieldUpdater.get(fVar) == t7.a.f10317c) {
        }
        Object obj = atomicReferenceFieldUpdater.get(fVar);
        l lVar = obj instanceof l ? (l) obj : null;
        if (lVar != null) {
            lVar.m();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + c0.o(this);
    }

    public /* synthetic */ w limitedParallelism(int i) {
        return limitedParallelism(i, null);
    }

    public final w plus(w wVar) {
        return wVar;
    }
}
