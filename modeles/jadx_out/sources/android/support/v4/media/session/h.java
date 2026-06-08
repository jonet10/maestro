package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final MediaController f282a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f283b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f284c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f285d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final MediaSessionCompat$Token f286e;

    public h(Context context, MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.f286e = mediaSessionCompat$Token;
        MediaController mediaController = new MediaController(context, (MediaSession.Token) mediaSessionCompat$Token.f257a);
        this.f282a = mediaController;
        if (mediaSessionCompat$Token.f258b == null) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver mediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver = new MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver(null);
            mediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver.f252a = new WeakReference(this);
            mediaController.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, mediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver);
        }
    }

    public final void a() {
        MediaSessionCompat$Token mediaSessionCompat$Token = this.f286e;
        if (mediaSessionCompat$Token.f258b == null) {
            return;
        }
        ArrayList arrayList = this.f284c;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            f fVar = (f) obj;
            g gVar = new g(fVar);
            this.f285d.put(fVar, gVar);
            fVar.mIControllerCallback = gVar;
            try {
                b bVar = (b) mediaSessionCompat$Token.f258b;
                bVar.getClass();
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeStrongBinder(gVar);
                    bVar.i.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    fVar.postToHandler(13, null, null);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", e10);
            }
        }
        arrayList.clear();
    }
}
