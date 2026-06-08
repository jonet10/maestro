package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.CamColor;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.utilities.Contrast;
import com.google.gson.internal.a;
import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static Color compositeColors(Color color, Color color2) {
            if (!Objects.equals(color.getModel(), color2.getModel())) {
                StringBuilder sb = new StringBuilder("Color models must match (");
                sb.append(color.getModel());
                ColorSpace.Model model = color2.getModel();
                sb.append(" vs. ");
                sb.append(model);
                sb.append(")");
                throw new IllegalArgumentException(sb.toString());
            }
            if (!Objects.equals(color2.getColorSpace(), color.getColorSpace())) {
                color = color.convert(color2.getColorSpace());
            }
            float[] components = color.getComponents();
            float[] components2 = color2.getComponents();
            float alpha = color.alpha();
            float alpha2 = (1.0f - alpha) * color2.alpha();
            int componentCount = color2.getComponentCount() - 1;
            float f = alpha + alpha2;
            components2[componentCount] = f;
            if (f > 0.0f) {
                alpha /= f;
                alpha2 /= f;
            }
            for (int i = 0; i < componentCount; i++) {
                components2[i] = (components2[i] * alpha2) + (components[i] * alpha);
            }
            return Color.valueOf(components2, color2.getColorSpace());
        }
    }

    private ColorUtils() {
    }

    @ColorInt
    public static int HSLToColor(@NonNull float[] fArr) {
        int round;
        int round2;
        int round3;
        float f = fArr[0];
        float f10 = fArr[1];
        float f11 = fArr[2];
        float abs = (1.0f - Math.abs((f11 * 2.0f) - 1.0f)) * f10;
        float f12 = f11 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f) / 60) {
            case 0:
                round = Math.round((abs + f12) * 255.0f);
                round2 = Math.round((abs2 + f12) * 255.0f);
                round3 = Math.round(f12 * 255.0f);
                break;
            case 1:
                round = Math.round((abs2 + f12) * 255.0f);
                round2 = Math.round((abs + f12) * 255.0f);
                round3 = Math.round(f12 * 255.0f);
                break;
            case 2:
                round = Math.round(f12 * 255.0f);
                round2 = Math.round((abs + f12) * 255.0f);
                round3 = Math.round((abs2 + f12) * 255.0f);
                break;
            case 3:
                round = Math.round(f12 * 255.0f);
                round2 = Math.round((abs2 + f12) * 255.0f);
                round3 = Math.round((abs + f12) * 255.0f);
                break;
            case 4:
                round = Math.round((abs2 + f12) * 255.0f);
                round2 = Math.round(f12 * 255.0f);
                round3 = Math.round((abs + f12) * 255.0f);
                break;
            case 5:
            case 6:
                round = Math.round((abs + f12) * 255.0f);
                round2 = Math.round(f12 * 255.0f);
                round3 = Math.round((abs2 + f12) * 255.0f);
                break;
            default:
                round3 = 0;
                round = 0;
                round2 = 0;
                break;
        }
        return Color.rgb(constrain(round, 0, 255), constrain(round2, 0, 255), constrain(round3, 0, 255));
    }

    @ColorInt
    public static int LABToColor(@FloatRange(from = 0.0d, to = 100.0d) double d10, @FloatRange(from = -128.0d, to = 127.0d) double d11, @FloatRange(from = -128.0d, to = 127.0d) double d12) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d10, d11, d12, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static void LABToXYZ(@FloatRange(from = 0.0d, to = 100.0d) double d10, @FloatRange(from = -128.0d, to = 127.0d) double d11, @FloatRange(from = -128.0d, to = 127.0d) double d12, @NonNull double[] dArr) {
        double d13 = (d10 + 16.0d) / 116.0d;
        double d14 = (d11 / 500.0d) + d13;
        double d15 = d13 - (d12 / 200.0d);
        double pow = Math.pow(d14, 3.0d);
        if (pow <= XYZ_EPSILON) {
            pow = ((d14 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        double pow2 = d10 > 7.9996247999999985d ? Math.pow(d13, 3.0d) : d10 / XYZ_KAPPA;
        double pow3 = Math.pow(d15, 3.0d);
        if (pow3 <= XYZ_EPSILON) {
            pow3 = ((d15 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        dArr[0] = pow * XYZ_WHITE_REFERENCE_X;
        dArr[1] = pow2 * XYZ_WHITE_REFERENCE_Y;
        dArr[2] = pow3 * XYZ_WHITE_REFERENCE_Z;
    }

    @ColorInt
    public static int M3HCTToColor(@FloatRange(from = 0.0d, to = 360.0d, toInclusive = false) float f, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f10, @FloatRange(from = 0.0d, to = 100.0d) float f11) {
        return CamColor.toColor(f, f10, f11);
    }

    public static void RGBToHSL(@IntRange(from = 0, to = 255) int i, @IntRange(from = 0, to = 255) int i6, @IntRange(from = 0, to = 255) int i10, @NonNull float[] fArr) {
        float f;
        float abs;
        float f10 = i / 255.0f;
        float f11 = i6 / 255.0f;
        float f12 = i10 / 255.0f;
        float max = Math.max(f10, Math.max(f11, f12));
        float min = Math.min(f10, Math.min(f11, f12));
        float f13 = max - min;
        float f14 = (max + min) / 2.0f;
        if (max == min) {
            f = 0.0f;
            abs = 0.0f;
        } else {
            f = max == f10 ? ((f11 - f12) / f13) % 6.0f : max == f11 ? ((f12 - f10) / f13) + 2.0f : 4.0f + ((f10 - f11) / f13);
            abs = f13 / (1.0f - Math.abs((2.0f * f14) - 1.0f));
        }
        float f15 = (f * 60.0f) % 360.0f;
        if (f15 < 0.0f) {
            f15 += 360.0f;
        }
        fArr[0] = constrain(f15, 0.0f, 360.0f);
        fArr[1] = constrain(abs, 0.0f, 1.0f);
        fArr[2] = constrain(f14, 0.0f, 1.0f);
    }

    public static void RGBToLAB(@IntRange(from = 0, to = 255) int i, @IntRange(from = 0, to = 255) int i6, @IntRange(from = 0, to = 255) int i10, @NonNull double[] dArr) {
        RGBToXYZ(i, i6, i10, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(@IntRange(from = 0, to = 255) int i, @IntRange(from = 0, to = 255) int i6, @IntRange(from = 0, to = 255) int i10, @NonNull double[] dArr) {
        if (dArr.length != 3) {
            a.p("outXyz must have a length of 3.");
            return;
        }
        double d10 = i / 255.0d;
        double pow = d10 < 0.04045d ? d10 / 12.92d : Math.pow((d10 + 0.055d) / 1.055d, 2.4d);
        double d11 = i6 / 255.0d;
        double pow2 = d11 < 0.04045d ? d11 / 12.92d : Math.pow((d11 + 0.055d) / 1.055d, 2.4d);
        double d12 = i10 / 255.0d;
        double pow3 = d12 < 0.04045d ? d12 / 12.92d : Math.pow((d12 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.1805d * pow3) + (0.3576d * pow2) + (0.4124d * pow)) * XYZ_WHITE_REFERENCE_Y;
        dArr[1] = ((0.0722d * pow3) + (0.7152d * pow2) + (0.2126d * pow)) * XYZ_WHITE_REFERENCE_Y;
        dArr[2] = ((pow3 * 0.9505d) + (pow2 * 0.1192d) + (pow * 0.0193d)) * XYZ_WHITE_REFERENCE_Y;
    }

    @ColorInt
    public static int XYZToColor(@FloatRange(from = 0.0d, to = 95.047d) double d10, @FloatRange(from = 0.0d, to = 100.0d) double d11, @FloatRange(from = 0.0d, to = 108.883d) double d12) {
        double d13 = (((-0.4986d) * d12) + (((-1.5372d) * d11) + (3.2406d * d10))) / XYZ_WHITE_REFERENCE_Y;
        double d14 = ((0.0415d * d12) + ((1.8758d * d11) + ((-0.9689d) * d10))) / XYZ_WHITE_REFERENCE_Y;
        double d15 = ((1.057d * d12) + (((-0.204d) * d11) + (0.0557d * d10))) / XYZ_WHITE_REFERENCE_Y;
        return Color.rgb(constrain((int) Math.round((d13 > 0.0031308d ? (Math.pow(d13, 0.4166666666666667d) * 1.055d) - 0.055d : d13 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d14 > 0.0031308d ? (Math.pow(d14, 0.4166666666666667d) * 1.055d) - 0.055d : d14 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d15 > 0.0031308d ? (Math.pow(d15, 0.4166666666666667d) * 1.055d) - 0.055d : d15 * 12.92d) * 255.0d), 0, 255));
    }

    public static void XYZToLAB(@FloatRange(from = 0.0d, to = 95.047d) double d10, @FloatRange(from = 0.0d, to = 100.0d) double d11, @FloatRange(from = 0.0d, to = 108.883d) double d12, @NonNull double[] dArr) {
        if (dArr.length != 3) {
            a.p("outLab must have a length of 3.");
            return;
        }
        double pivotXyzComponent = pivotXyzComponent(d10 / XYZ_WHITE_REFERENCE_X);
        double pivotXyzComponent2 = pivotXyzComponent(d11 / XYZ_WHITE_REFERENCE_Y);
        double pivotXyzComponent3 = pivotXyzComponent(d12 / XYZ_WHITE_REFERENCE_Z);
        dArr[0] = Math.max(0.0d, (116.0d * pivotXyzComponent2) - 16.0d);
        dArr[1] = (pivotXyzComponent - pivotXyzComponent2) * 500.0d;
        dArr[2] = (pivotXyzComponent2 - pivotXyzComponent3) * 200.0d;
    }

    @ColorInt
    public static int blendARGB(@ColorInt int i, @ColorInt int i6, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        float f10 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i6) * f) + (Color.alpha(i) * f10)), (int) ((Color.red(i6) * f) + (Color.red(i) * f10)), (int) ((Color.green(i6) * f) + (Color.green(i) * f10)), (int) ((Color.blue(i6) * f) + (Color.blue(i) * f10)));
    }

    public static void blendHSL(@NonNull float[] fArr, @NonNull float[] fArr2, @FloatRange(from = 0.0d, to = 1.0d) float f, @NonNull float[] fArr3) {
        if (fArr3.length != 3) {
            a.p("result must have a length of 3.");
            return;
        }
        float f10 = 1.0f - f;
        fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f);
        fArr3[1] = (fArr2[1] * f) + (fArr[1] * f10);
        fArr3[2] = (fArr2[2] * f) + (fArr[2] * f10);
    }

    public static void blendLAB(@NonNull double[] dArr, @NonNull double[] dArr2, @FloatRange(from = 0.0d, to = 1.0d) double d10, @NonNull double[] dArr3) {
        if (dArr3.length != 3) {
            a.p("outResult must have a length of 3.");
            return;
        }
        double d11 = 1.0d - d10;
        dArr3[0] = (dArr2[0] * d10) + (dArr[0] * d11);
        dArr3[1] = (dArr2[1] * d10) + (dArr[1] * d11);
        dArr3[2] = (dArr2[2] * d10) + (dArr[2] * d11);
    }

    public static double calculateContrast(@ColorInt int i, @ColorInt int i6) {
        if (Color.alpha(i6) != 255) {
            androidx.privacysandbox.ads.adservices.customaudience.a.r(Integer.toHexString(i6), "background can not be translucent: #");
            return 0.0d;
        }
        if (Color.alpha(i) < 255) {
            i = compositeColors(i, i6);
        }
        double calculateLuminance = calculateLuminance(i) + 0.05d;
        double calculateLuminance2 = calculateLuminance(i6) + 0.05d;
        return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public static double calculateLuminance(@ColorInt int i) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i, tempDouble3Array);
        return tempDouble3Array[1] / XYZ_WHITE_REFERENCE_Y;
    }

    public static int calculateMinimumAlpha(@ColorInt int i, @ColorInt int i6, float f) {
        int i10 = 255;
        if (Color.alpha(i6) != 255) {
            androidx.privacysandbox.ads.adservices.customaudience.a.r(Integer.toHexString(i6), "background can not be translucent: #");
            return 0;
        }
        double d10 = f;
        if (calculateContrast(setAlphaComponent(i, 255), i6) < d10) {
            return -1;
        }
        int i11 = 0;
        for (int i12 = 0; i12 <= 10 && i10 - i11 > 1; i12++) {
            int i13 = (i11 + i10) / 2;
            if (calculateContrast(setAlphaComponent(i, i13), i6) < d10) {
                i11 = i13;
            } else {
                i10 = i13;
            }
        }
        return i10;
    }

    @VisibleForTesting
    public static float circularInterpolate(float f, float f10, float f11) {
        if (Math.abs(f10 - f) > 180.0f) {
            if (f10 > f) {
                f += 360.0f;
            } else {
                f10 += 360.0f;
            }
        }
        return (((f10 - f) * f11) + f) % 360.0f;
    }

    public static void colorToHSL(@ColorInt int i, @NonNull float[] fArr) {
        RGBToHSL(Color.red(i), Color.green(i), Color.blue(i), fArr);
    }

    public static void colorToLAB(@ColorInt int i, @NonNull double[] dArr) {
        RGBToLAB(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    public static void colorToM3HCT(@ColorInt int i, @NonNull @Size(3) float[] fArr) {
        CamColor.getM3HCTfromColor(i, fArr);
    }

    public static void colorToXYZ(@ColorInt int i, @NonNull double[] dArr) {
        RGBToXYZ(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    private static int compositeAlpha(int i, int i6) {
        return 255 - (((255 - i) * (255 - i6)) / 255);
    }

    public static int compositeColors(@ColorInt int i, @ColorInt int i6) {
        int alpha = Color.alpha(i6);
        int alpha2 = Color.alpha(i);
        int compositeAlpha = compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, compositeComponent(Color.red(i), alpha2, Color.red(i6), alpha, compositeAlpha), compositeComponent(Color.green(i), alpha2, Color.green(i6), alpha, compositeAlpha), compositeComponent(Color.blue(i), alpha2, Color.blue(i6), alpha, compositeAlpha));
    }

    private static int compositeComponent(int i, int i6, int i10, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        return (((255 - i6) * (i10 * i11)) + ((i * 255) * i6)) / (i12 * 255);
    }

    private static float constrain(float f, float f10, float f11) {
        return f < f10 ? f10 : Math.min(f, f11);
    }

    public static double distanceEuclidean(@NonNull double[] dArr, @NonNull double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[2] - dArr2[2], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[0] - dArr2[0], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> threadLocal = TEMP_ARRAY;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    private static double pivotXyzComponent(double d10) {
        return d10 > XYZ_EPSILON ? Math.pow(d10, 0.3333333333333333d) : ((d10 * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    @ColorInt
    public static int setAlphaComponent(@ColorInt int i, @IntRange(from = 0, to = 255) int i6) {
        if (i6 >= 0 && i6 <= 255) {
            return (i & ViewCompat.MEASURED_SIZE_MASK) | (i6 << 24);
        }
        a.p("alpha must be between 0 and 255.");
        return 0;
    }

    private static int constrain(int i, int i6, int i10) {
        return i < i6 ? i6 : Math.min(i, i10);
    }

    @NonNull
    @RequiresApi(26)
    public static Color compositeColors(@NonNull Color color, @NonNull Color color2) {
        return Api26Impl.compositeColors(color, color2);
    }
}
