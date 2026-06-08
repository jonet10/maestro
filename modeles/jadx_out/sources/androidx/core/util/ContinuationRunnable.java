package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import p6.x;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class ContinuationRunnable extends AtomicBoolean implements Runnable {
    private final c continuation;

    public ContinuationRunnable(c cVar) {
        super(false);
        this.continuation = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(x.f8463a);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
