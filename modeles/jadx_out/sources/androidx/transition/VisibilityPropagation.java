package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class VisibilityPropagation extends TransitionPropagation {
    private static final String PROPNAME_VISIBILITY = "android:visibilityPropagation:visibility";
    private static final String PROPNAME_VIEW_CENTER = "android:visibilityPropagation:center";
    private static final String[] VISIBILITY_PROPAGATION_VALUES = {PROPNAME_VISIBILITY, PROPNAME_VIEW_CENTER};

    private static int getViewCoordinate(@Nullable TransitionValues transitionValues, int i) {
        int[] iArr;
        if (transitionValues == null || (iArr = (int[]) transitionValues.values.get(PROPNAME_VIEW_CENTER)) == null) {
            return -1;
        }
        return iArr[i];
    }

    @Override // androidx.transition.TransitionPropagation
    public void captureValues(@NonNull TransitionValues transitionValues) {
        View view = transitionValues.view;
        Integer num = (Integer) transitionValues.values.get("android:visibility:visibility");
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        transitionValues.values.put(PROPNAME_VISIBILITY, num);
        int[] iArr = {r5, 0};
        view.getLocationOnScreen(iArr);
        int round = Math.round(view.getTranslationX()) + iArr[0];
        iArr[0] = (view.getWidth() / 2) + round;
        int round2 = Math.round(view.getTranslationY()) + iArr[1];
        iArr[1] = round2;
        iArr[1] = (view.getHeight() / 2) + round2;
        transitionValues.values.put(PROPNAME_VIEW_CENTER, iArr);
    }

    @Override // androidx.transition.TransitionPropagation
    @Nullable
    public String[] getPropagationProperties() {
        return VISIBILITY_PROPAGATION_VALUES;
    }

    public int getViewVisibility(@Nullable TransitionValues transitionValues) {
        Integer num;
        if (transitionValues == null || (num = (Integer) transitionValues.values.get(PROPNAME_VISIBILITY)) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int getViewX(@Nullable TransitionValues transitionValues) {
        return getViewCoordinate(transitionValues, 0);
    }

    public int getViewY(@Nullable TransitionValues transitionValues) {
        return getViewCoordinate(transitionValues, 1);
    }
}
