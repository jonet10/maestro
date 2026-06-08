package androidx.privacysandbox.ads.adservices.internal;

import android.content.Context;
import android.util.Log;
import d7.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class BackCompatManager {
    public static final BackCompatManager INSTANCE = new BackCompatManager();

    private BackCompatManager() {
    }

    public final <T> T getManager(Context context, String str, l lVar) {
        context.getClass();
        str.getClass();
        lVar.getClass();
        try {
            return (T) lVar.invoke(context);
        } catch (NoClassDefFoundError unused) {
            Log.d(str, "Unable to find adservices code, check manifest for uses-library tag, versionS=" + AdServicesInfo.INSTANCE.extServicesVersionS());
            return null;
        }
    }
}
