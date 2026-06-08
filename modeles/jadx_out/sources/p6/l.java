package p6;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l implements f, Serializable {

    /* renamed from: l, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f8445l = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "b");

    /* renamed from: a, reason: collision with root package name */
    public volatile d7.a f8446a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f8447b;

    @Override // p6.f
    public final Object getValue() {
        Object obj = this.f8447b;
        u uVar = u.f8460a;
        if (obj != uVar) {
            return obj;
        }
        d7.a aVar = this.f8446a;
        if (aVar != null) {
            Object invoke = aVar.invoke();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8445l;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, uVar, invoke)) {
                if (atomicReferenceFieldUpdater.get(this) != uVar) {
                }
            }
            this.f8446a = null;
            return invoke;
        }
        return this.f8447b;
    }

    @Override // p6.f
    public final boolean isInitialized() {
        return this.f8447b != u.f8460a;
    }

    public final String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
