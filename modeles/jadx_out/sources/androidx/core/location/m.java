package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f376a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f377b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Executor f378l;

    public /* synthetic */ m(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i) {
        this.f376a = i;
        this.f377b = preRGnssStatusTransport;
        this.f378l = executor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f376a) {
            case 0:
                this.f377b.lambda$onStopped$1(this.f378l);
                break;
            default:
                this.f377b.lambda$onStarted$0(this.f378l);
                break;
        }
    }
}
