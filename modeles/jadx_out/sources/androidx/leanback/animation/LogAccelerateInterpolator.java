package androidx.leanback.animation;

import android.animation.TimeInterpolator;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class LogAccelerateInterpolator implements TimeInterpolator {
    int mBase;
    int mDrift;
    final float mLogScale;

    public LogAccelerateInterpolator(int i, int i6) {
        this.mBase = i;
        this.mDrift = i6;
        this.mLogScale = 1.0f / computeLog(1.0f, i, i6);
    }

    public static float computeLog(float f, int i, int i6) {
        return (i6 * f) + ((float) (-Math.pow(i, -f))) + 1.0f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return 1.0f - (computeLog(1.0f - f, this.mBase, this.mDrift) * this.mLogScale);
    }
}
