package androidx.datastore.core;

import d7.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MutexUtilsKt {
    public static final <R> R withTryLock(x7.a aVar, Object obj, l lVar) {
        aVar.getClass();
        lVar.getClass();
        boolean tryLock = aVar.tryLock(obj);
        try {
            return (R) lVar.invoke(Boolean.valueOf(tryLock));
        } finally {
            if (tryLock) {
                aVar.unlock(obj);
            }
        }
    }

    public static /* synthetic */ Object withTryLock$default(x7.a aVar, Object obj, l lVar, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        aVar.getClass();
        lVar.getClass();
        boolean tryLock = aVar.tryLock(obj);
        try {
            return lVar.invoke(Boolean.valueOf(tryLock));
        } finally {
            if (tryLock) {
                aVar.unlock(obj);
            }
        }
    }
}
