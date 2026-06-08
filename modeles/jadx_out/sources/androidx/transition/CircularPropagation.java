package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class CircularPropagation extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;

    private static float distance(float f, float f10, float f11, float f12) {
        float f13 = f11 - f;
        float f14 = f12 - f10;
        return (float) Math.sqrt((f14 * f14) + (f13 * f13));
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(@NonNull ViewGroup viewGroup, @NonNull Transition transition, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i;
        int round;
        int i6;
        if (transitionValues == null && transitionValues2 == null) {
            return 0L;
        }
        if (transitionValues2 == null || getViewVisibility(transitionValues) == 0) {
            i = -1;
        } else {
            transitionValues = transitionValues2;
            i = 1;
        }
        int viewX = getViewX(transitionValues);
        int viewY = getViewY(transitionValues);
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            i6 = epicenter.centerX();
            round = epicenter.centerY();
        } else {
            viewGroup.getLocationOnScreen(new int[2]);
            int round2 = Math.round(viewGroup.getTranslationX() + (viewGroup.getWidth() / 2) + r5[0]);
            round = Math.round(viewGroup.getTranslationY() + (viewGroup.getHeight() / 2) + r5[1]);
            i6 = round2;
        }
        float distance = distance(viewX, viewY, i6, round) / distance(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return Math.round(((duration * i) / this.mPropagationSpeed) * distance);
    }

    public void setPropagationSpeed(float f) {
        if (f != 0.0f) {
            this.mPropagationSpeed = f;
        } else {
            com.google.gson.internal.a.p("propagationSpeed may not be 0");
        }
    }
}
