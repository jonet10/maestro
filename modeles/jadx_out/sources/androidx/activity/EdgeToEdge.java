package androidx.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.activity.SystemBarStyle;
import androidx.annotation.VisibleForTesting;
import d7.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class EdgeToEdge {
    private static EdgeToEdgeImpl Impl;
    private static final int DefaultLightScrim = Color.argb(230, 255, 255, 255);
    private static final int DefaultDarkScrim = Color.argb(128, 27, 27, 27);

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2) {
        componentActivity.getClass();
        systemBarStyle.getClass();
        systemBarStyle2.getClass();
        View decorView = componentActivity.getWindow().getDecorView();
        decorView.getClass();
        l detectDarkMode$activity_release = systemBarStyle.getDetectDarkMode$activity_release();
        Resources resources = decorView.getResources();
        resources.getClass();
        boolean booleanValue = ((Boolean) detectDarkMode$activity_release.invoke(resources)).booleanValue();
        l detectDarkMode$activity_release2 = systemBarStyle2.getDetectDarkMode$activity_release();
        Resources resources2 = decorView.getResources();
        resources2.getClass();
        boolean booleanValue2 = ((Boolean) detectDarkMode$activity_release2.invoke(resources2)).booleanValue();
        EdgeToEdgeImpl edgeToEdgeImpl = Impl;
        if (edgeToEdgeImpl == null) {
            int i = Build.VERSION.SDK_INT;
            edgeToEdgeImpl = i >= 29 ? new EdgeToEdgeApi29() : i >= 26 ? new EdgeToEdgeApi26() : new EdgeToEdgeApi23();
        }
        EdgeToEdgeImpl edgeToEdgeImpl2 = edgeToEdgeImpl;
        Window window = componentActivity.getWindow();
        window.getClass();
        edgeToEdgeImpl2.setUp(systemBarStyle, systemBarStyle2, window, decorView, booleanValue, booleanValue2);
    }

    public static /* synthetic */ void enable$default(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            systemBarStyle = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, 0, 0, null, 4, null);
        }
        if ((i & 2) != 0) {
            systemBarStyle2 = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, DefaultLightScrim, DefaultDarkScrim, null, 4, null);
        }
        enable(componentActivity, systemBarStyle, systemBarStyle2);
    }

    public static final int getDefaultDarkScrim() {
        return DefaultDarkScrim;
    }

    public static final int getDefaultLightScrim() {
        return DefaultLightScrim;
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultDarkScrim$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultLightScrim$annotations() {
    }

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle systemBarStyle) {
        componentActivity.getClass();
        systemBarStyle.getClass();
        enable$default(componentActivity, systemBarStyle, null, 2, null);
    }

    public static final void enable(ComponentActivity componentActivity) {
        componentActivity.getClass();
        enable$default(componentActivity, null, null, 3, null);
    }
}
