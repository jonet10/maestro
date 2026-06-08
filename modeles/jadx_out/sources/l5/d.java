package l5;

import android.view.animation.Interpolator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        return (float) ((Math.cos(10.0d * f) * Math.pow(2.718281828459045d, (-f) / 0.2d) * (-1)) + 1);
    }
}
