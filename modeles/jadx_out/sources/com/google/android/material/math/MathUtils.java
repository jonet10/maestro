package com.google.android.material.math;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    private MathUtils() {
    }

    public static boolean areAllElementsEqual(@NonNull float[] fArr) {
        if (fArr.length <= 1) {
            return true;
        }
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (fArr[i] != f) {
                return false;
            }
        }
        return true;
    }

    public static float dist(float f, float f10, float f11, float f12) {
        return (float) Math.hypot(f11 - f, f12 - f10);
    }

    public static float distanceToFurthestCorner(float f, float f10, float f11, float f12, float f13, float f14) {
        return max(dist(f, f10, f11, f12), dist(f, f10, f13, f12), dist(f, f10, f13, f14), dist(f, f10, f11, f14));
    }

    public static float floorMod(float f, int i) {
        float f10 = i;
        int i6 = (int) (f / f10);
        if (Math.signum(f) * f10 < 0.0f && i6 * i != f) {
            i6--;
        }
        return f - (i6 * i);
    }

    public static boolean geq(float f, float f10, float f11) {
        return f + f11 >= f10;
    }

    public static float lerp(float f, float f10, float f11) {
        return (f11 * f10) + ((1.0f - f11) * f);
    }

    private static float max(float f, float f10, float f11, float f12) {
        return (f <= f10 || f <= f11 || f <= f12) ? (f10 <= f11 || f10 <= f12) ? f11 > f12 ? f11 : f12 : f10 : f;
    }

    public static int floorMod(int i, int i6) {
        int i10 = i / i6;
        if ((i ^ i6) < 0 && i10 * i6 != i) {
            i10--;
        }
        return i - (i10 * i6);
    }
}
