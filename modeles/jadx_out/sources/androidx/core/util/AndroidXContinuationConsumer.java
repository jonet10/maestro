package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class AndroidXContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {
    private final c continuation;

    public AndroidXContinuationConsumer(c cVar) {
        super(false);
        this.continuation = cVar;
    }

    @Override // androidx.core.util.Consumer
    public void accept(T t9) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(t9);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
