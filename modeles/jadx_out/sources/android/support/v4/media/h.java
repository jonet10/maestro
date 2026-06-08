package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f249b = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: a, reason: collision with root package name */
    public final d f250a;

    public h(Context context, ComponentName componentName, c cVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f250a = new e(context, componentName, cVar);
        } else {
            this.f250a = new d(context, componentName, cVar);
        }
    }
}
