package android.support.customtabs;

import android.os.Bundle;
import android.os.IInterface;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface i extends IInterface {

    /* renamed from: c, reason: collision with root package name */
    public static final String f221c = "android$support$customtabs$IEngagementSignalsCallback".replace('$', '.');

    void onGreatestScrollPercentageIncreased(int i, Bundle bundle);

    void onSessionEnded(boolean z9, Bundle bundle);

    void onVerticalScrollEvent(boolean z9, Bundle bundle);
}
