package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f534a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f535b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f536l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d7.a f537m;

    public /* synthetic */ b(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, d7.a aVar, int i) {
        this.f534a = i;
        this.f535b = atomicBoolean;
        this.f536l = completer;
        this.f537m = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f534a) {
            case 0:
                ListenableFutureKt.executeAsync$lambda$4$lambda$3(this.f535b, this.f536l, this.f537m);
                break;
            default:
                WorkerKt.future$lambda$2$lambda$1(this.f535b, this.f536l, this.f537m);
                break;
        }
    }
}
