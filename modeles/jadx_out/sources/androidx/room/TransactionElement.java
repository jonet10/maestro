package androidx.room;

import d7.p;
import java.util.concurrent.atomic.AtomicInteger;
import t6.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TransactionElement implements t6.f {
    public static final Key Key = new Key(null);
    private final AtomicInteger referenceCount;
    private final t6.e transactionDispatcher;

    public TransactionElement(t6.e eVar) {
        eVar.getClass();
        this.transactionDispatcher = eVar;
        this.referenceCount = new AtomicInteger(0);
    }

    public final void acquire() {
        this.referenceCount.incrementAndGet();
    }

    @Override // t6.h
    public <R> R fold(R r9, p pVar) {
        return (R) a.a.x(this, r9, pVar);
    }

    @Override // t6.h
    public <E extends t6.f> E get(t6.g gVar) {
        return (E) a.a.z(this, gVar);
    }

    @Override // t6.f
    public t6.g getKey() {
        return Key;
    }

    public final t6.e getTransactionDispatcher$room_runtime_release() {
        return this.transactionDispatcher;
    }

    @Override // t6.h
    public h minusKey(t6.g gVar) {
        return a.a.K(this, gVar);
    }

    @Override // t6.h
    public h plus(h hVar) {
        return a.a.L(this, hVar);
    }

    public final void release() {
        if (this.referenceCount.decrementAndGet() >= 0) {
            return;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Transaction was never started or was already released.");
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Key implements t6.g {
        public /* synthetic */ Key(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Key() {
        }
    }
}
