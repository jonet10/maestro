package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat$Token;
import androidx.collection.ArrayMap;
import androidx.media.MediaBrowserProtocol;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f240a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaBrowser f241b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f242c;

    /* renamed from: d, reason: collision with root package name */
    public final a f243d = new a(this);

    /* renamed from: e, reason: collision with root package name */
    public final ArrayMap f244e = new ArrayMap();
    public g f;
    public Messenger g;
    public MediaSessionCompat$Token h;

    public d(Context context, ComponentName componentName, c cVar) {
        this.f240a = context;
        Bundle bundle = new Bundle();
        this.f242c = bundle;
        bundle.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
        cVar.setInternalConnectionCallback(this);
        this.f241b = new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback) cVar.mConnectionCallbackObj, bundle);
    }
}
