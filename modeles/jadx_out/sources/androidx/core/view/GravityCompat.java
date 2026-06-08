package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    private GravityCompat() {
    }

    public static void apply(int i, int i6, int i10, @NonNull Rect rect, @NonNull Rect rect2, int i11) {
        Gravity.apply(i, i6, i10, rect, rect2, i11);
    }

    public static void applyDisplay(int i, @NonNull Rect rect, @NonNull Rect rect2, int i6) {
        Gravity.applyDisplay(i, rect, rect2, i6);
    }

    public static int getAbsoluteGravity(int i, int i6) {
        return Gravity.getAbsoluteGravity(i, i6);
    }

    public static void apply(int i, int i6, int i10, @NonNull Rect rect, int i11, int i12, @NonNull Rect rect2, int i13) {
        Gravity.apply(i, i6, i10, rect, i11, i12, rect2, i13);
    }
}
