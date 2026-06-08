package t1;

import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends AbstractResolvableFuture implements ScheduledFuture {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f9526a;

    public h(g gVar) {
        this.f9526a = gVar.a(new g5.g(this, 12));
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public final void afterDone() {
        this.f9526a.cancel(wasInterrupted());
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        return this.f9526a.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.f9526a.getDelay(timeUnit);
    }
}
