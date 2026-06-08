package androidx.core.util;

import androidx.annotation.RequiresApi;
import j$.util.function.Consumer$CC;
import java.util.concurrent.atomic.AtomicBoolean;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(24)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class ContinuationConsumer<T> extends AtomicBoolean implements java.util.function.Consumer<T> {
    private final c continuation;

    public ContinuationConsumer(c cVar) {
        super(false);
        this.continuation = cVar;
    }

    @Override // java.util.function.Consumer
    public void accept(T t9) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(t9);
        }
    }

    public /* synthetic */ java.util.function.Consumer andThen(java.util.function.Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
