package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class ColorUtils {
    static final double[][] SRGB_TO_XYZ = {new double[]{0.41233895d, 0.35762064d, 0.18051042d}, new double[]{0.2126d, 0.7152d, 0.0722d}, new double[]{0.01932141d, 0.11916382d, 0.95034478d}};
    static final double[][] XYZ_TO_SRGB = {new double[]{3.2413774792388685d, -1.5376652402851851d, -0.49885366846268053d}, new double[]{-0.9691452513005321d, 1.8758853451067872d, 0.04156585616912061d}, new double[]{0.05562093689691305d, -0.20395524564742123d, 1.0571799111220335d}};
    static final double[] WHITE_POINT_D65 = {95.047d, 100.0d, 108.883d};

    private ColorUtils() {
    }

    public static int alphaFromArgb(int i) {
        return (i >> 24) & 255;
    }

    public static int argbFromLab(double d10, double d11, double d12) {
        double[] dArr = WHITE_POINT_D65;
        double d13 = (d10 + 16.0d) / 116.0d;
        double d14 = d13 - (d12 / 200.0d);
        return argbFromXyz(labInvf((d11 / 500.0d) + d13) * dArr[0], labInvf(d13) * dArr[1], labInvf(d14) * dArr[2]);
    }

    public static int argbFromLinrgb(double[] dArr) {
        return argbFromRgb(delinearized(dArr[0]), delinearized(dArr[1]), delinearized(dArr[2]));
    }

    public static int argbFromLstar(double d10) {
        int delinearized = delinearized(yFromLstar(d10));
        return argbFromRgb(delinearized, delinearized, delinearized);
    }

    public static int argbFromRgb(int i, int i6, int i10) {
        return ((i & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((i6 & 255) << 8) | (i10 & 255);
    }

    public static int argbFromXyz(double d10, double d11, double d12) {
        double[][] dArr = XYZ_TO_SRGB;
        double[] dArr2 = dArr[0];
        double d13 = (dArr2[2] * d12) + (dArr2[1] * d11) + (dArr2[0] * d10);
        double[] dArr3 = dArr[1];
        double d14 = (dArr3[2] * d12) + (dArr3[1] * d11) + (dArr3[0] * d10);
        double[] dArr4 = dArr[2];
        return argbFromRgb(delinearized(d13), delinearized(d14), delinearized((dArr4[2] * d12) + (dArr4[1] * d11) + (dArr4[0] * d10)));
    }

    public static int blueFromArgb(int i) {
        return i & 255;
    }

    public static int delinearized(double d10) {
        double d11 = d10 / 100.0d;
        return MathUtils.clampInt(0, 255, (int) Math.round((d11 <= 0.0031308d ? d11 * 12.92d : (Math.pow(d11, 0.4166666666666667d) * 1.055d) - 0.055d) * 255.0d));
    }

    public static int greenFromArgb(int i) {
        return (i >> 8) & 255;
    }

    public static boolean isOpaque(int i) {
        return alphaFromArgb(i) >= 255;
    }

    public static double labF(double d10) {
        return d10 > 0.008856451679035631d ? Math.pow(d10, 0.3333333333333333d) : ((d10 * 903.2962962962963d) + 16.0d) / 116.0d;
    }

    public static double[] labFromArgb(int i) {
        double linearized = linearized(redFromArgb(i));
        double linearized2 = linearized(greenFromArgb(i));
        double linearized3 = linearized(blueFromArgb(i));
        double[][] dArr = SRGB_TO_XYZ;
        double[] dArr2 = dArr[0];
        double d10 = (dArr2[2] * linearized3) + (dArr2[1] * linearized2) + (dArr2[0] * linearized);
        double[] dArr3 = dArr[1];
        double d11 = (dArr3[2] * linearized3) + (dArr3[1] * linearized2) + (dArr3[0] * linearized);
        double[] dArr4 = dArr[2];
        double d12 = (dArr4[2] * linearized3) + (dArr4[1] * linearized2) + (dArr4[0] * linearized);
        double[] dArr5 = WHITE_POINT_D65;
        double d13 = d10 / dArr5[0];
        double d14 = d11 / dArr5[1];
        double d15 = d12 / dArr5[2];
        double labF = labF(d13);
        double labF2 = labF(d14);
        return new double[]{(116.0d * labF2) - 16.0d, (labF - labF2) * 500.0d, (labF2 - labF(d15)) * 200.0d};
    }

    public static double labInvf(double d10) {
        double d11 = d10 * d10 * d10;
        return d11 > 0.008856451679035631d ? d11 : ((d10 * 116.0d) - 16.0d) / 903.2962962962963d;
    }

    public static double linearized(int i) {
        double d10 = i / 255.0d;
        return (d10 <= 0.040449936d ? d10 / 12.92d : Math.pow((d10 + 0.055d) / 1.055d, 2.4d)) * 100.0d;
    }

    public static double lstarFromArgb(int i) {
        return (labF(xyzFromArgb(i)[1] / 100.0d) * 116.0d) - 16.0d;
    }

    public static double lstarFromY(double d10) {
        return (labF(d10 / 100.0d) * 116.0d) - 16.0d;
    }

    public static int redFromArgb(int i) {
        return (i >> 16) & 255;
    }

    public static double[] whitePointD65() {
        return WHITE_POINT_D65;
    }

    public static double[] xyzFromArgb(int i) {
        return MathUtils.matrixMultiply(new double[]{linearized(redFromArgb(i)), linearized(greenFromArgb(i)), linearized(blueFromArgb(i))}, SRGB_TO_XYZ);
    }

    public static double yFromLstar(double d10) {
        return labInvf((d10 + 16.0d) / 116.0d) * 100.0d;
    }
}
