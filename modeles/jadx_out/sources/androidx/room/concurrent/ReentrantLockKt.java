package androidx.room.concurrent;

import d7.a;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ReentrantLockKt {
    public static final <T> T withLock(ReentrantLock reentrantLock, a aVar) {
        reentrantLock.getClass();
        aVar.getClass();
        reentrantLock.lock();
        try {
            return (T) aVar.invoke();
        } finally {
            reentrantLock.unlock();
        }
    }
}
