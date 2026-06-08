package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class Contrast {
    private static final double CONTRAST_RATIO_EPSILON = 0.04d;
    private static final double LUMINANCE_GAMUT_MAP_TOLERANCE = 0.4d;
    public static final double RATIO_30 = 3.0d;
    public static final double RATIO_45 = 4.5d;
    public static final double RATIO_70 = 7.0d;
    public static final double RATIO_MAX = 21.0d;
    public static final double RATIO_MIN = 1.0d;

    private Contrast() {
    }

    public static double darker(double d10, double d11) {
        if (d10 >= 0.0d && d10 <= 100.0d) {
            double yFromLstar = ColorUtils.yFromLstar(d10);
            double d12 = ((yFromLstar + 5.0d) / d11) - 5.0d;
            if (d12 >= 0.0d && d12 <= 100.0d) {
                double ratioOfYs = ratioOfYs(yFromLstar, d12);
                double abs = Math.abs(ratioOfYs - d11);
                if (ratioOfYs < d11 && abs > CONTRAST_RATIO_EPSILON) {
                    return -1.0d;
                }
                double lstarFromY = ColorUtils.lstarFromY(d12) - LUMINANCE_GAMUT_MAP_TOLERANCE;
                if (lstarFromY >= 0.0d && lstarFromY <= 100.0d) {
                    return lstarFromY;
                }
            }
        }
        return -1.0d;
    }

    public static double darkerUnsafe(double d10, double d11) {
        return Math.max(0.0d, darker(d10, d11));
    }

    public static double lighter(double d10, double d11) {
        if (d10 >= 0.0d && d10 <= 100.0d) {
            double yFromLstar = ColorUtils.yFromLstar(d10);
            double d12 = ((yFromLstar + 5.0d) * d11) - 5.0d;
            if (d12 >= 0.0d && d12 <= 100.0d) {
                double ratioOfYs = ratioOfYs(d12, yFromLstar);
                double abs = Math.abs(ratioOfYs - d11);
                if (ratioOfYs < d11 && abs > CONTRAST_RATIO_EPSILON) {
                    return -1.0d;
                }
                double lstarFromY = ColorUtils.lstarFromY(d12) + LUMINANCE_GAMUT_MAP_TOLERANCE;
                if (lstarFromY >= 0.0d && lstarFromY <= 100.0d) {
                    return lstarFromY;
                }
            }
        }
        return -1.0d;
    }

    public static double lighterUnsafe(double d10, double d11) {
        double lighter = lighter(d10, d11);
        if (lighter < 0.0d) {
            return 100.0d;
        }
        return lighter;
    }

    public static double ratioOfTones(double d10, double d11) {
        return ratioOfYs(ColorUtils.yFromLstar(d10), ColorUtils.yFromLstar(d11));
    }

    public static double ratioOfYs(double d10, double d11) {
        double max = Math.max(d10, d11);
        if (max != d11) {
            d10 = d11;
        }
        return (max + 5.0d) / (d10 + 5.0d);
    }
}
