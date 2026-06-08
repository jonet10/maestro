package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import p6.a;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(31)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver {
    private final c continuation;

    public ContinuationOutcomeReceiver(c cVar) {
        super(false);
        this.continuation = cVar;
    }

    public void onError(E e10) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(a.b(e10));
        }
    }

    public void onResult(R r9) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(r9);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
