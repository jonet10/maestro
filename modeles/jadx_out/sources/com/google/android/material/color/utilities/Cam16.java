package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class Cam16 {
    private final double astar;
    private final double bstar;
    private final double chroma;
    private final double hue;
    private final double j;
    private final double jstar;

    /* renamed from: m, reason: collision with root package name */
    private final double f2966m;

    /* renamed from: q, reason: collision with root package name */
    private final double f2967q;

    /* renamed from: s, reason: collision with root package name */
    private final double f2968s;
    private final double[] tempArray = {0.0d, 0.0d, 0.0d};
    static final double[][] XYZ_TO_CAM16RGB = {new double[]{0.401288d, 0.650173d, -0.051461d}, new double[]{-0.250268d, 1.204414d, 0.045854d}, new double[]{-0.002079d, 0.048952d, 0.953127d}};
    static final double[][] CAM16RGB_TO_XYZ = {new double[]{1.8620678d, -1.0112547d, 0.14918678d}, new double[]{0.38752654d, 0.62144744d, -0.00897398d}, new double[]{-0.0158415d, -0.03412294d, 1.0499644d}};

    private Cam16(double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18) {
        this.hue = d10;
        this.chroma = d11;
        this.j = d12;
        this.f2967q = d13;
        this.f2966m = d14;
        this.f2968s = d15;
        this.jstar = d16;
        this.astar = d17;
        this.bstar = d18;
    }

    public static Cam16 fromInt(int i) {
        return fromIntInViewingConditions(i, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromIntInViewingConditions(int i, ViewingConditions viewingConditions) {
        double linearized = ColorUtils.linearized((16711680 & i) >> 16);
        double linearized2 = ColorUtils.linearized((65280 & i) >> 8);
        double linearized3 = ColorUtils.linearized(i & 255);
        return fromXyzInViewingConditions((0.18051042d * linearized3) + (0.35762064d * linearized2) + (0.41233895d * linearized), (0.0722d * linearized3) + (0.7152d * linearized2) + (0.2126d * linearized), (linearized3 * 0.95034478d) + (linearized2 * 0.11916382d) + (linearized * 0.01932141d), viewingConditions);
    }

    public static Cam16 fromJch(double d10, double d11, double d12) {
        return fromJchInViewingConditions(d10, d11, d12, ViewingConditions.DEFAULT);
    }

    private static Cam16 fromJchInViewingConditions(double d10, double d11, double d12, ViewingConditions viewingConditions) {
        double d13 = d10 / 100.0d;
        double flRoot = viewingConditions.getFlRoot() * (viewingConditions.getAw() + 4.0d) * Math.sqrt(d13) * (4.0d / viewingConditions.getC());
        double flRoot2 = viewingConditions.getFlRoot() * d11;
        double sqrt = Math.sqrt((viewingConditions.getC() * (d11 / Math.sqrt(d13))) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
        double radians = Math.toRadians(d12);
        double d14 = (1.7000000000000002d * d10) / ((0.007d * d10) + 1.0d);
        double log1p = Math.log1p(0.0228d * flRoot2) * 43.859649122807014d;
        return new Cam16(d12, d11, d10, flRoot, flRoot2, sqrt, d14, Math.cos(radians) * log1p, Math.sin(radians) * log1p);
    }

    public static Cam16 fromUcs(double d10, double d11, double d12) {
        return fromUcsInViewingConditions(d10, d11, d12, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromUcsInViewingConditions(double d10, double d11, double d12, ViewingConditions viewingConditions) {
        double expm1 = (Math.expm1(Math.hypot(d11, d12) * 0.0228d) / 0.0228d) / viewingConditions.getFlRoot();
        double atan2 = Math.atan2(d12, d11) * 57.29577951308232d;
        if (atan2 < 0.0d) {
            atan2 += 360.0d;
        }
        return fromJchInViewingConditions(d10 / (1.0d - ((d10 - 100.0d) * 0.007d)), expm1, atan2, viewingConditions);
    }

    public static Cam16 fromXyzInViewingConditions(double d10, double d11, double d12, ViewingConditions viewingConditions) {
        double[][] dArr = XYZ_TO_CAM16RGB;
        double[] dArr2 = dArr[0];
        double d13 = (dArr2[2] * d12) + (dArr2[1] * d11) + (dArr2[0] * d10);
        double[] dArr3 = dArr[1];
        double d14 = (dArr3[2] * d12) + (dArr3[1] * d11) + (dArr3[0] * d10);
        double[] dArr4 = dArr[2];
        double d15 = (dArr4[2] * d12) + (dArr4[1] * d11) + (dArr4[0] * d10);
        double d16 = viewingConditions.getRgbD()[0] * d13;
        double d17 = viewingConditions.getRgbD()[1] * d14;
        double d18 = viewingConditions.getRgbD()[2] * d15;
        double pow = Math.pow((Math.abs(d16) * viewingConditions.getFl()) / 100.0d, 0.42d);
        double pow2 = Math.pow((Math.abs(d17) * viewingConditions.getFl()) / 100.0d, 0.42d);
        double pow3 = Math.pow((Math.abs(d18) * viewingConditions.getFl()) / 100.0d, 0.42d);
        double signum = ((Math.signum(d16) * 400.0d) * pow) / (pow + 27.13d);
        double signum2 = ((Math.signum(d17) * 400.0d) * pow2) / (pow2 + 27.13d);
        double signum3 = ((Math.signum(d18) * 400.0d) * pow3) / (pow3 + 27.13d);
        double d19 = ((((-12.0d) * signum2) + (signum * 11.0d)) + signum3) / 11.0d;
        double d20 = ((signum + signum2) - (signum3 * 2.0d)) / 9.0d;
        double d21 = signum2 * 20.0d;
        double d22 = ((21.0d * signum3) + ((signum * 20.0d) + d21)) / 20.0d;
        double d23 = (((signum * 40.0d) + d21) + signum3) / 20.0d;
        double degrees = Math.toDegrees(Math.atan2(d20, d19));
        if (degrees < 0.0d) {
            degrees += 360.0d;
        } else if (degrees >= 360.0d) {
            degrees -= 360.0d;
        }
        double d24 = degrees;
        double radians = Math.toRadians(d24);
        double pow4 = Math.pow((viewingConditions.getNbb() * d23) / viewingConditions.getAw(), viewingConditions.getZ() * viewingConditions.getC()) * 100.0d;
        double d25 = pow4 / 100.0d;
        double flRoot = viewingConditions.getFlRoot() * (viewingConditions.getAw() + 4.0d) * Math.sqrt(d25) * (4.0d / viewingConditions.getC());
        double pow5 = Math.pow((Math.hypot(d19, d20) * (viewingConditions.getNcb() * (viewingConditions.getNc() * (((Math.cos(Math.toRadians(d24 < 20.14d ? d24 + 360.0d : d24) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d)))) / (d22 + 0.305d), 0.9d) * Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d);
        double sqrt = Math.sqrt(d25) * pow5;
        double flRoot2 = viewingConditions.getFlRoot() * sqrt;
        double sqrt2 = Math.sqrt((viewingConditions.getC() * pow5) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
        double d26 = (1.7000000000000002d * pow4) / ((0.007d * pow4) + 1.0d);
        double log1p = Math.log1p(0.0228d * flRoot2) * 43.859649122807014d;
        return new Cam16(d24, sqrt, pow4, flRoot, flRoot2, sqrt2, d26, Math.cos(radians) * log1p, Math.sin(radians) * log1p);
    }

    public double distance(@NonNull Cam16 cam16) {
        double jstar = getJstar() - cam16.getJstar();
        double astar = getAstar() - cam16.getAstar();
        double bstar = getBstar() - cam16.getBstar();
        return Math.pow(Math.sqrt((bstar * bstar) + (astar * astar) + (jstar * jstar)), 0.63d) * 1.41d;
    }

    public double getAstar() {
        return this.astar;
    }

    public double getBstar() {
        return this.bstar;
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public double getJ() {
        return this.j;
    }

    public double getJstar() {
        return this.jstar;
    }

    public double getM() {
        return this.f2966m;
    }

    public double getQ() {
        return this.f2967q;
    }

    public double getS() {
        return this.f2968s;
    }

    public int toInt() {
        return viewed(ViewingConditions.DEFAULT);
    }

    public int viewed(ViewingConditions viewingConditions) {
        double[] xyzInViewingConditions = xyzInViewingConditions(viewingConditions, this.tempArray);
        return ColorUtils.argbFromXyz(xyzInViewingConditions[0], xyzInViewingConditions[1], xyzInViewingConditions[2]);
    }

    public double[] xyzInViewingConditions(ViewingConditions viewingConditions, double[] dArr) {
        double pow = Math.pow(((getChroma() == 0.0d || getJ() == 0.0d) ? 0.0d : getChroma() / Math.sqrt(getJ() / 100.0d)) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double radians = Math.toRadians(getHue());
        double cos = (Math.cos(2.0d + radians) + 3.8d) * 0.25d;
        double pow2 = Math.pow(getJ() / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ()) * viewingConditions.getAw();
        double ncb = viewingConditions.getNcb() * viewingConditions.getNc() * cos * 3846.153846153846d;
        double nbb = pow2 / viewingConditions.getNbb();
        double sin = Math.sin(radians);
        double cos2 = Math.cos(radians);
        double d10 = (((0.305d + nbb) * 23.0d) * pow) / (((pow * 108.0d) * sin) + (((11.0d * pow) * cos2) + (ncb * 23.0d)));
        double d11 = cos2 * d10;
        double d12 = d10 * sin;
        double d13 = nbb * 460.0d;
        double d14 = ((288.0d * d12) + ((451.0d * d11) + d13)) / 1403.0d;
        double d15 = ((d13 - (891.0d * d11)) - (261.0d * d12)) / 1403.0d;
        double d16 = ((d13 - (d11 * 220.0d)) - (d12 * 6300.0d)) / 1403.0d;
        double pow3 = Math.pow(Math.max(0.0d, (Math.abs(d14) * 27.13d) / (400.0d - Math.abs(d14))), 2.380952380952381d) * (100.0d / viewingConditions.getFl()) * Math.signum(d14);
        double pow4 = Math.pow(Math.max(0.0d, (Math.abs(d15) * 27.13d) / (400.0d - Math.abs(d15))), 2.380952380952381d) * (100.0d / viewingConditions.getFl()) * Math.signum(d15);
        double pow5 = Math.pow(Math.max(0.0d, (Math.abs(d16) * 27.13d) / (400.0d - Math.abs(d16))), 2.380952380952381d) * (100.0d / viewingConditions.getFl()) * Math.signum(d16);
        double d17 = pow3 / viewingConditions.getRgbD()[0];
        double d18 = pow4 / viewingConditions.getRgbD()[1];
        double d19 = pow5 / viewingConditions.getRgbD()[2];
        double[][] dArr2 = CAM16RGB_TO_XYZ;
        double[] dArr3 = dArr2[0];
        double d20 = (dArr3[2] * d19) + (dArr3[1] * d18) + (dArr3[0] * d17);
        double[] dArr4 = dArr2[1];
        double d21 = (dArr4[2] * d19) + (dArr4[1] * d18) + (dArr4[0] * d17);
        double[] dArr5 = dArr2[2];
        double d22 = (d19 * dArr5[2]) + (d18 * dArr5[1]) + (d17 * dArr5[0]);
        if (dArr == null) {
            return new double[]{d20, d21, d22};
        }
        dArr[0] = d20;
        dArr[1] = d21;
        dArr[2] = d22;
        return dArr;
    }
}
