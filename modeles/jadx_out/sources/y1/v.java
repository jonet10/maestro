package y1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicLong f11686a;

    public v(AtomicLong atomicLong) {
        this.f11686a = atomicLong;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = Executors.defaultThreadFactory().newThread(new u(runnable, 0));
        newThread.setName("awaitEvenIfOnMainThread task continuation executor" + this.f11686a.getAndIncrement());
        return newThread;
    }
}
