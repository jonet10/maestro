package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class Blend {
    private Blend() {
    }

    public static int cam16Ucs(int i, int i6, double d10) {
        Cam16 fromInt = Cam16.fromInt(i);
        Cam16 fromInt2 = Cam16.fromInt(i6);
        double jstar = fromInt.getJstar();
        double astar = fromInt.getAstar();
        double bstar = fromInt.getBstar();
        return Cam16.fromUcs(((fromInt2.getJstar() - jstar) * d10) + jstar, ((fromInt2.getAstar() - astar) * d10) + astar, ((fromInt2.getBstar() - bstar) * d10) + bstar).toInt();
    }

    public static int harmonize(int i, int i6) {
        Hct fromInt = Hct.fromInt(i);
        Hct fromInt2 = Hct.fromInt(i6);
        double min = Math.min(MathUtils.differenceDegrees(fromInt.getHue(), fromInt2.getHue()) * 0.5d, 15.0d);
        return Hct.from(MathUtils.sanitizeDegreesDouble((MathUtils.rotationDirection(fromInt.getHue(), fromInt2.getHue()) * min) + fromInt.getHue()), fromInt.getChroma(), fromInt.getTone()).toInt();
    }

    public static int hctHue(int i, int i6, double d10) {
        return Hct.from(Cam16.fromInt(cam16Ucs(i, i6, d10)).getHue(), Cam16.fromInt(i).getChroma(), ColorUtils.lstarFromArgb(i)).toInt();
    }
}
