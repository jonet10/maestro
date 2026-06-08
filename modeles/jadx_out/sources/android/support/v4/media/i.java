package android.support.v4.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserProtocol;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class i extends MediaBrowser.ConnectionCallback {

    /* renamed from: a, reason: collision with root package name */
    public final a3.d f251a;

    public i(a3.d dVar) {
        this.f251a = dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnected() {
        android.support.v4.media.session.d dVar;
        c cVar = (c) this.f251a.f63b;
        b bVar = cVar.mConnectionCallbackInternal;
        if (bVar != null) {
            d dVar2 = (d) bVar;
            a aVar = dVar2.f243d;
            MediaBrowser mediaBrowser = dVar2.f241b;
            Bundle extras = mediaBrowser.getExtras();
            if (extras != null) {
                int i = 0;
                Object[] objArr = 0;
                extras.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                IBinder binder = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                if (binder != null) {
                    Bundle bundle = dVar2.f242c;
                    g gVar = new g(i, (boolean) (objArr == true ? 1 : 0));
                    gVar.f247b = new Messenger(binder);
                    gVar.f248l = bundle;
                    dVar2.f = gVar;
                    Messenger messenger = new Messenger(aVar);
                    dVar2.g = messenger;
                    aVar.getClass();
                    aVar.f239b = new WeakReference(messenger);
                    try {
                        g gVar2 = dVar2.f;
                        Context context = dVar2.f240a;
                        Messenger messenger2 = dVar2.g;
                        gVar2.getClass();
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
                        bundle2.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, (Bundle) gVar2.f248l);
                        Message obtain = Message.obtain();
                        obtain.what = 6;
                        obtain.arg1 = 1;
                        obtain.setData(bundle2);
                        obtain.replyTo = messenger2;
                        ((Messenger) gVar2.f247b).send(obtain);
                    } catch (RemoteException unused) {
                        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                    }
                }
                IBinder binder2 = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER);
                int i6 = android.support.v4.media.session.c.i;
                if (binder2 == null) {
                    dVar = null;
                } else {
                    IInterface queryLocalInterface = binder2.queryLocalInterface("android.support.v4.media.session.IMediaSession");
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof android.support.v4.media.session.d)) {
                        android.support.v4.media.session.b bVar2 = new android.support.v4.media.session.b();
                        bVar2.i = binder2;
                        dVar = bVar2;
                    } else {
                        dVar = (android.support.v4.media.session.d) queryLocalInterface;
                    }
                }
                if (dVar != null) {
                    dVar2.h = MediaSessionCompat$Token.a(mediaBrowser.getSessionToken(), dVar);
                }
            }
        }
        cVar.onConnected();
    }

    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnectionFailed() {
        ((c) this.f251a.f63b).onConnectionFailed();
    }

    @Override // android.media.browse.MediaBrowser.ConnectionCallback
    public final void onConnectionSuspended() {
        c cVar = (c) this.f251a.f63b;
        b bVar = cVar.mConnectionCallbackInternal;
        if (bVar != null) {
            d dVar = (d) bVar;
            dVar.f = null;
            dVar.g = null;
            dVar.h = null;
            a aVar = dVar.f243d;
            aVar.getClass();
            aVar.f239b = new WeakReference(null);
        }
        cVar.onConnectionSuspended();
    }
}
