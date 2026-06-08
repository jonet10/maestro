package o7;

import java.util.concurrent.ScheduledFuture;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n0 implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f8293a;

    public n0(ScheduledFuture scheduledFuture) {
        this.f8293a = scheduledFuture;
    }

    @Override // o7.o0
    public final void dispose() {
        this.f8293a.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.f8293a + ']';
    }
}
