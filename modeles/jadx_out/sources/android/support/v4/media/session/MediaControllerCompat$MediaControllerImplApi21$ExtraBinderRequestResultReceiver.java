package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.ResultReceiver;
import androidx.core.app.BundleCompat;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver extends ResultReceiver {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference f252a;

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        d dVar;
        h hVar = (h) this.f252a.get();
        if (hVar == null || bundle == null) {
            return;
        }
        synchronized (hVar.f283b) {
            MediaSessionCompat$Token mediaSessionCompat$Token = hVar.f286e;
            IBinder binder = BundleCompat.getBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER");
            int i6 = c.i;
            if (binder == null) {
                dVar = null;
            } else {
                IInterface queryLocalInterface = binder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                    b bVar = new b();
                    bVar.i = binder;
                    dVar = bVar;
                } else {
                    dVar = (d) queryLocalInterface;
                }
            }
            mediaSessionCompat$Token.f258b = dVar;
            MediaSessionCompat$Token mediaSessionCompat$Token2 = hVar.f286e;
            bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE");
            mediaSessionCompat$Token2.getClass();
            hVar.a();
        }
    }
}
