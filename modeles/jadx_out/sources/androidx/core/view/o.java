package androidx.core.view;

import android.graphics.RenderNode;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract /* synthetic */ class o {
    public static /* synthetic */ RenderNode a() {
        return new RenderNode("BlurViewNode");
    }

    public static /* synthetic */ WindowInsets.Builder b() {
        return new WindowInsets.Builder();
    }

    public static /* synthetic */ WindowInsets.Builder c(WindowInsets windowInsets) {
        return new WindowInsets.Builder(windowInsets);
    }

    public static /* synthetic */ AccessibilityNodeInfo.TouchDelegateInfo d(Map map) {
        return new AccessibilityNodeInfo.TouchDelegateInfo(map);
    }
}
