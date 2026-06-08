package q0;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final String f8629a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadFactory f8630b = Executors.defaultThreadFactory();

    public a(String str) {
        this.f8629a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f8630b.newThread(new b(runnable, 0));
        newThread.setName(this.f8629a);
        return newThread;
    }
}
