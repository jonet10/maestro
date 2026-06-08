package c0;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f1176a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1177b;

    /* renamed from: l, reason: collision with root package name */
    public final CountDownLatch f1178l = new CountDownLatch(1);

    /* renamed from: m, reason: collision with root package name */
    public boolean f1179m = false;

    public d(b bVar, long j) {
        this.f1176a = new WeakReference(bVar);
        this.f1177b = j;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        b bVar;
        WeakReference weakReference = this.f1176a;
        try {
            if (this.f1178l.await(this.f1177b, TimeUnit.MILLISECONDS) || (bVar = (b) weakReference.get()) == null) {
                return;
            }
            bVar.b();
            this.f1179m = true;
        } catch (InterruptedException unused) {
            b bVar2 = (b) weakReference.get();
            if (bVar2 != null) {
                bVar2.b();
                this.f1179m = true;
            }
        }
    }
}
