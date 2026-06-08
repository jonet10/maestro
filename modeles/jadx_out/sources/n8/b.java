package n8;

import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f8112a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f8113b;

    public b(String str, boolean z9) {
        this.f8112a = str;
        this.f8113b = z9;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f8112a);
        thread.setDaemon(this.f8113b);
        return thread;
    }
}
