package androidx.collection.internal;

import d7.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LockExtKt {
    /* renamed from: synchronized, reason: not valid java name */
    public static final <T> T m32synchronized(Lock lock, a aVar) {
        T t9;
        lock.getClass();
        aVar.getClass();
        synchronized (lock) {
            t9 = (T) aVar.invoke();
        }
        return t9;
    }
}
