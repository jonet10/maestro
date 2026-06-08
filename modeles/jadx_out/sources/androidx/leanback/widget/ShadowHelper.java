package androidx.leanback.widget;

import android.view.View;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class ShadowHelper {
    private ShadowHelper() {
    }

    public static Object addDynamicShadow(View view, float f, float f10, int i) {
        return ShadowHelperApi21.addDynamicShadow(view, f, f10, i);
    }

    public static void setShadowFocusLevel(Object obj, float f) {
        ShadowHelperApi21.setShadowFocusLevel(obj, f);
    }

    public static boolean supportsDynamicShadow() {
        return true;
    }
}
