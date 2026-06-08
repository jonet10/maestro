package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class CustomTabsCallback {
    public static final int ACTIVITY_LAYOUT_STATE_BOTTOM_SHEET = 1;
    public static final int ACTIVITY_LAYOUT_STATE_BOTTOM_SHEET_MAXIMIZED = 2;
    public static final int ACTIVITY_LAYOUT_STATE_FULL_SCREEN = 5;
    public static final int ACTIVITY_LAYOUT_STATE_SIDE_SHEET = 3;
    public static final int ACTIVITY_LAYOUT_STATE_SIDE_SHEET_MAXIMIZED = 4;
    public static final int ACTIVITY_LAYOUT_STATE_UNKNOWN = 0;
    public static final int NAVIGATION_ABORTED = 4;
    public static final int NAVIGATION_FAILED = 3;
    public static final int NAVIGATION_FINISHED = 2;
    public static final int NAVIGATION_STARTED = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String ONLINE_EXTRAS_KEY = "online";
    public static final int TAB_HIDDEN = 6;
    public static final int TAB_SHOWN = 5;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ActivityLayoutState {
    }

    @Nullable
    public Bundle extraCallbackWithResult(@NonNull String str, @Nullable Bundle bundle) {
        return null;
    }

    public void onMessageChannelReady(@Nullable Bundle bundle) {
    }

    @ExperimentalMinimizationCallback
    public void onMinimized(@NonNull Bundle bundle) {
    }

    @ExperimentalMinimizationCallback
    public void onUnminimized(@NonNull Bundle bundle) {
    }

    public void onWarmupCompleted(@NonNull Bundle bundle) {
    }

    public void extraCallback(@NonNull String str, @Nullable Bundle bundle) {
    }

    public void onNavigationEvent(int i, @Nullable Bundle bundle) {
    }

    public void onPostMessage(@NonNull String str, @Nullable Bundle bundle) {
    }

    public void onActivityResized(@Dimension(unit = 1) int i, @Dimension(unit = 1) int i6, @NonNull Bundle bundle) {
    }

    public void onRelationshipValidationResult(int i, @NonNull Uri uri, boolean z9, @Nullable Bundle bundle) {
    }

    public void onActivityLayout(@Dimension(unit = 1) int i, @Dimension(unit = 1) int i6, @Dimension(unit = 1) int i10, @Dimension(unit = 1) int i11, int i12, @NonNull Bundle bundle) {
    }
}
