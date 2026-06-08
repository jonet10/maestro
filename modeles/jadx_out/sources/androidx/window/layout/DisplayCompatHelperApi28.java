package androidx.window.layout;

import android.view.DisplayCutout;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(28)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DisplayCompatHelperApi28 {
    public static final DisplayCompatHelperApi28 INSTANCE = new DisplayCompatHelperApi28();

    private DisplayCompatHelperApi28() {
    }

    public final int safeInsetBottom(DisplayCutout displayCutout) {
        displayCutout.getClass();
        return displayCutout.getSafeInsetBottom();
    }

    public final int safeInsetLeft(DisplayCutout displayCutout) {
        displayCutout.getClass();
        return displayCutout.getSafeInsetLeft();
    }

    public final int safeInsetRight(DisplayCutout displayCutout) {
        displayCutout.getClass();
        return displayCutout.getSafeInsetRight();
    }

    public final int safeInsetTop(DisplayCutout displayCutout) {
        displayCutout.getClass();
        return displayCutout.getSafeInsetTop();
    }
}
