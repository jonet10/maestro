package androidx.browser.customtabs;

import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface EngagementSignalsCallback {
    void onGreatestScrollPercentageIncreased(@IntRange(from = 1, to = 100) int i, @NonNull Bundle bundle);

    void onSessionEnded(boolean z9, @NonNull Bundle bundle);

    void onVerticalScrollEvent(boolean z9, @NonNull Bundle bundle);
}
