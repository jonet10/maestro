package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f367a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f368b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f369l;

    public /* synthetic */ j(LocationManagerCompat.LocationListenerTransport locationListenerTransport, Object obj, int i) {
        this.f367a = i;
        this.f368b = locationListenerTransport;
        this.f369l = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f367a) {
            case 0:
                this.f368b.lambda$onLocationChanged$1((List) this.f369l);
                break;
            default:
                this.f368b.lambda$onLocationChanged$0((Location) this.f369l);
                break;
        }
    }
}
