package android.support.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface f extends IInterface {

    /* renamed from: b, reason: collision with root package name */
    public static final String f220b = "android$support$customtabs$ICustomTabsService".replace('$', '.');

    Bundle extraCommand(String str, Bundle bundle);

    boolean isEngagementSignalsApiAvailable(c cVar, Bundle bundle);

    boolean mayLaunchUrl(c cVar, Uri uri, Bundle bundle, List list);

    boolean newSession(c cVar);

    boolean newSessionWithExtras(c cVar, Bundle bundle);

    int postMessage(c cVar, String str, Bundle bundle);

    boolean receiveFile(c cVar, Uri uri, int i, Bundle bundle);

    boolean requestPostMessageChannel(c cVar, Uri uri);

    boolean requestPostMessageChannelWithExtras(c cVar, Uri uri, Bundle bundle);

    boolean setEngagementSignalsCallback(c cVar, IBinder iBinder, Bundle bundle);

    boolean updateVisuals(c cVar, Bundle bundle);

    boolean validateRelationship(c cVar, int i, Uri uri, Bundle bundle);

    boolean warmup(long j);
}
