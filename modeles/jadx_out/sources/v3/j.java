package v3;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f10848a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f10849b = new ConcurrentHashMap();

    public j() {
        new AtomicLong(0L);
    }

    @JavascriptInterface
    public final void sendBooleanValue(final long j, final boolean z9) {
        this.f10848a.post(new Runnable(j, z9) { // from class: v3.i

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f10847b;

            @Override // java.lang.Runnable
            public final void run() {
                if (j.this.f10849b.remove(Long.valueOf(this.f10847b)) == null) {
                    return;
                }
                com.google.gson.internal.a.o();
            }
        });
    }
}
