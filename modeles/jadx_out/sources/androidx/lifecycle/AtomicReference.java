package androidx.lifecycle;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AtomicReference<V> {
    private final java.util.concurrent.atomic.AtomicReference<V> base;

    public AtomicReference(V v) {
        this.base = new java.util.concurrent.atomic.AtomicReference<>(v);
    }

    public final boolean compareAndSet(V v, V v9) {
        java.util.concurrent.atomic.AtomicReference<V> atomicReference = this.base;
        while (!atomicReference.compareAndSet(v, v9)) {
            if (atomicReference.get() != v) {
                return false;
            }
        }
        return true;
    }

    public final V get() {
        return this.base.get();
    }
}
