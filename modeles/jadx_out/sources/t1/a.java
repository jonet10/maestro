package t1;

import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements ThreadFactory {

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadFactory f9501e = Executors.defaultThreadFactory();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicLong f9502a = new AtomicLong();

    /* renamed from: b, reason: collision with root package name */
    public final String f9503b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9504c;

    /* renamed from: d, reason: collision with root package name */
    public final StrictMode.ThreadPolicy f9505d;

    public a(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        this.f9503b = str;
        this.f9504c = i;
        this.f9505d = threadPolicy;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = f9501e.newThread(new androidx.browser.trusted.c(22, this, runnable));
        Locale locale = Locale.ROOT;
        newThread.setName(this.f9503b + " Thread #" + this.f9502a.getAndIncrement());
        return newThread;
    }
}
