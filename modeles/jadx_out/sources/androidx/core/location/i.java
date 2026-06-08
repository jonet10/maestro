package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f364a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f365b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f366l;

    public /* synthetic */ i(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str, int i) {
        this.f364a = i;
        this.f365b = locationListenerTransport;
        this.f366l = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f364a) {
            case 0:
                this.f365b.lambda$onProviderEnabled$4(this.f366l);
                break;
            default:
                this.f365b.lambda$onProviderDisabled$5(this.f366l);
                break;
        }
    }
}
