package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ViewingConditions {
    public static final ViewingConditions DEFAULT = defaultWithBackgroundLstar(50.0d);
    private final double aw;

    /* renamed from: c, reason: collision with root package name */
    private final double f2979c;
    private final double fl;
    private final double flRoot;

    /* renamed from: n, reason: collision with root package name */
    private final double f2980n;
    private final double nbb;
    private final double nc;
    private final double ncb;
    private final double[] rgbD;

    /* renamed from: z, reason: collision with root package name */
    private final double f2981z;

    private ViewingConditions(double d10, double d11, double d12, double d13, double d14, double d15, double[] dArr, double d16, double d17, double d18) {
        this.f2980n = d10;
        this.aw = d11;
        this.nbb = d12;
        this.ncb = d13;
        this.f2979c = d14;
        this.nc = d15;
        this.rgbD = dArr;
        this.fl = d16;
        this.flRoot = d17;
        this.f2981z = d18;
    }

    public static ViewingConditions defaultWithBackgroundLstar(double d10) {
        return make(ColorUtils.whitePointD65(), (ColorUtils.yFromLstar(50.0d) * 63.66197723675813d) / 100.0d, d10, 2.0d, false);
    }

    public static ViewingConditions make(double[] dArr, double d10, double d11, double d12, boolean z9) {
        double max = Math.max(0.1d, d11);
        double[][] dArr2 = Cam16.XYZ_TO_CAM16RGB;
        double d13 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d14 = dArr3[0] * d13;
        double d15 = dArr[1];
        double d16 = (dArr3[1] * d15) + d14;
        double d17 = dArr[2];
        double d18 = (dArr3[2] * d17) + d16;
        double[] dArr4 = dArr2[1];
        double d19 = (dArr4[2] * d17) + (dArr4[1] * d15) + (dArr4[0] * d13);
        double[] dArr5 = dArr2[2];
        double d20 = (d17 * dArr5[2]) + (d15 * dArr5[1]) + (d13 * dArr5[0]);
        double d21 = (d12 / 10.0d) + 0.8d;
        double lerp = d21 >= 0.9d ? MathUtils.lerp(0.59d, 0.69d, (d21 - 0.9d) * 10.0d) : MathUtils.lerp(0.525d, 0.59d, (d21 - 0.8d) * 10.0d);
        double clampDouble = MathUtils.clampDouble(0.0d, 1.0d, z9 ? 1.0d : (1.0d - (Math.exp(((-d10) - 42.0d) / 92.0d) * 0.2777777777777778d)) * d21);
        double[] dArr6 = {(((100.0d / d18) * clampDouble) + 1.0d) - clampDouble, (((100.0d / d19) * clampDouble) + 1.0d) - clampDouble, (((100.0d / d20) * clampDouble) + 1.0d) - clampDouble};
        double d22 = 5.0d * d10;
        double d23 = 1.0d / (d22 + 1.0d);
        double d24 = d23 * d23 * d23 * d23;
        double d25 = 1.0d - d24;
        double cbrt = (Math.cbrt(d22) * 0.1d * d25 * d25) + (d24 * d10);
        double yFromLstar = ColorUtils.yFromLstar(max) / dArr[1];
        double sqrt = Math.sqrt(yFromLstar) + 1.48d;
        double pow = 0.725d / Math.pow(yFromLstar, 0.2d);
        double[] dArr7 = {Math.pow(((dArr6[0] * cbrt) * d18) / 100.0d, 0.42d), Math.pow(((dArr6[1] * cbrt) * d19) / 100.0d, 0.42d), Math.pow(((dArr6[2] * cbrt) * d20) / 100.0d, 0.42d)};
        double d26 = dArr7[0];
        double d27 = (d26 * 400.0d) / (d26 + 27.13d);
        double d28 = dArr7[1];
        double d29 = (d28 * 400.0d) / (d28 + 27.13d);
        double d30 = dArr7[2];
        double[] dArr8 = {d27, d29, (400.0d * d30) / (d30 + 27.13d)};
        return new ViewingConditions(yFromLstar, ((dArr8[2] * 0.05d) + (dArr8[0] * 2.0d) + dArr8[1]) * pow, pow, pow, lerp, d21, dArr6, cbrt, Math.pow(cbrt, 0.25d), sqrt);
    }

    public double getAw() {
        return this.aw;
    }

    public double getC() {
        return this.f2979c;
    }

    public double getFl() {
        return this.fl;
    }

    public double getFlRoot() {
        return this.flRoot;
    }

    public double getN() {
        return this.f2980n;
    }

    public double getNbb() {
        return this.nbb;
    }

    public double getNc() {
        return this.nc;
    }

    public double getNcb() {
        return this.ncb;
    }

    public double[] getRgbD() {
        return this.rgbD;
    }

    public double getZ() {
        return this.f2981z;
    }
}
