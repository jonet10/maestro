package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f353a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Executor f354b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f355l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f356m;

    public /* synthetic */ f(Object obj, Executor executor, Object obj2, int i) {
        this.f353a = i;
        this.f355l = obj;
        this.f354b = executor;
        this.f356m = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f353a) {
            case 0:
                ((LocationManagerCompat.GnssMeasurementsTransport) this.f355l).lambda$onGnssMeasurementsReceived$0(this.f354b, (GnssMeasurementsEvent) this.f356m);
                break;
            case 1:
                ((LocationManagerCompat.GpsStatusTransport) this.f355l).lambda$onGpsStatusChanged$3(this.f354b, (GnssStatusCompat) this.f356m);
                break;
            default:
                ((LocationManagerCompat.PreRGnssStatusTransport) this.f355l).lambda$onSatelliteStatusChanged$3(this.f354b, (GnssStatus) this.f356m);
                break;
        }
    }
}
