package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ActivityCompatHelperApi30 {
    public static final ActivityCompatHelperApi30 INSTANCE = new ActivityCompatHelperApi30();

    private ActivityCompatHelperApi30() {
    }

    public final Rect currentWindowBounds(Activity activity) {
        activity.getClass();
        Rect bounds = activity.getWindowManager().getCurrentWindowMetrics().getBounds();
        bounds.getClass();
        return bounds;
    }

    public final Rect maximumWindowBounds(Activity activity) {
        activity.getClass();
        Rect bounds = activity.getWindowManager().getMaximumWindowMetrics().getBounds();
        bounds.getClass();
        return bounds;
    }
}
