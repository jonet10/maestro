package android.support.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface c extends IInterface {

    /* renamed from: a, reason: collision with root package name */
    public static final String f219a = "android$support$customtabs$ICustomTabsCallback".replace('$', '.');

    void extraCallback(String str, Bundle bundle);

    Bundle extraCallbackWithResult(String str, Bundle bundle);

    void onActivityLayout(int i, int i6, int i10, int i11, int i12, Bundle bundle);

    void onActivityResized(int i, int i6, Bundle bundle);

    void onMessageChannelReady(Bundle bundle);

    void onMinimized(Bundle bundle);

    void onNavigationEvent(int i, Bundle bundle);

    void onPostMessage(String str, Bundle bundle);

    void onRelationshipValidationResult(int i, Uri uri, boolean z9, Bundle bundle);

    void onUnminimized(Bundle bundle);

    void onWarmupCompleted(Bundle bundle);
}
