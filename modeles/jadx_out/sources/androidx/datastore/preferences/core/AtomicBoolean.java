package androidx.datastore.preferences.core;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AtomicBoolean {
    private final java.util.concurrent.atomic.AtomicBoolean delegate;

    public AtomicBoolean(boolean z9) {
        this.delegate = new java.util.concurrent.atomic.AtomicBoolean(z9);
    }

    public final boolean get() {
        return this.delegate.get();
    }

    public final void set(boolean z9) {
        this.delegate.set(z9);
    }
}
