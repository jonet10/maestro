package androidx.core.view;

import android.content.Context;
import android.view.ContentInfo;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.core.view.DifferentialMotionFlingController;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class c implements DifferentialMotionFlingController.FlingVelocityThresholdCalculator, DifferentialMotionFlingController.DifferentialVelocityProvider {
    public static /* bridge */ /* synthetic */ ContentInfo a(Object obj) {
        return (ContentInfo) obj;
    }

    @Override // androidx.core.view.DifferentialMotionFlingController.FlingVelocityThresholdCalculator
    public void calculateFlingVelocityThresholds(Context context, int[] iArr, MotionEvent motionEvent, int i) {
        DifferentialMotionFlingController.calculateFlingVelocityThresholds(context, iArr, motionEvent, i);
    }

    @Override // androidx.core.view.DifferentialMotionFlingController.DifferentialVelocityProvider
    public float getCurrentVelocity(VelocityTracker velocityTracker, MotionEvent motionEvent, int i) {
        float currentVelocity;
        currentVelocity = DifferentialMotionFlingController.getCurrentVelocity(velocityTracker, motionEvent, i);
        return currentVelocity;
    }
}
