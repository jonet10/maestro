package android.support.v4.media;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.session.m;
import android.util.Log;
import androidx.media.MediaBrowserProtocol;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f238a;

    /* renamed from: b, reason: collision with root package name */
    public WeakReference f239b;

    public a(d dVar) {
        this.f238a = new WeakReference(dVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        WeakReference weakReference = this.f239b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        WeakReference weakReference2 = this.f238a;
        if (weakReference2.get() == null) {
            return;
        }
        Bundle data = message.getData();
        m.a(data);
        d dVar = (d) weakReference2.get();
        Messenger messenger = (Messenger) this.f239b.get();
        try {
            int i = message.what;
            if (i == 1) {
                m.a(data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS));
                data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID);
                dVar.getClass();
                return;
            }
            if (i == 2) {
                dVar.getClass();
                return;
            }
            if (i != 3) {
                Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                return;
            }
            m.a(data.getBundle(MediaBrowserProtocol.DATA_OPTIONS));
            m.a(data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS));
            String string = data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID);
            data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST);
            if (dVar.g != messenger) {
                return;
            }
            if (dVar.f244e.get(string) != null) {
                throw new ClassCastException();
            }
            if (h.f249b) {
                Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + string);
            }
        } catch (BadParcelableException unused) {
            Log.e("MediaBrowserCompat", "Could not unparcel the data.");
            if (message.what == 1) {
                dVar.getClass();
            }
        }
    }
}
