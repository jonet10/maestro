package androidx.leanback.widget;

import android.view.View;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class RoundedRectHelper {
    private RoundedRectHelper() {
    }

    public static void setClipToRoundedOutline(View view, boolean z9) {
        RoundedRectHelperApi21.setClipToRoundedOutline(view, z9, view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_rounded_rect_corner_radius));
    }

    public static boolean supportsRoundedCorner() {
        return true;
    }

    public static void setClipToRoundedOutline(View view, boolean z9, int i) {
        RoundedRectHelperApi21.setClipToRoundedOutline(view, z9, i);
    }
}
