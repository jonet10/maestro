package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f357a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Executor f358b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f359l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f360m;

    public /* synthetic */ g(Object obj, Executor executor, int i, int i6) {
        this.f357a = i6;
        this.f360m = obj;
        this.f358b = executor;
        this.f359l = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f357a) {
            case 0:
                ((LocationManagerCompat.GnssMeasurementsTransport) this.f360m).lambda$onStatusChanged$1(this.f358b, this.f359l);
                break;
            case 1:
                ((LocationManagerCompat.GpsStatusTransport) this.f360m).lambda$onGpsStatusChanged$2(this.f358b, this.f359l);
                break;
            default:
                ((LocationManagerCompat.PreRGnssStatusTransport) this.f360m).lambda$onFirstFix$2(this.f358b, this.f359l);
                break;
        }
    }
}
