package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ANTICIPATE = "cubic(0.36, 0, 0.66, -0.56)";
    private static final String ANTICIPATE_NAME = "anticipate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String OVERSHOOT = "cubic(0.34, 1.56, 0.64, 1)";
    private static final String OVERSHOOT_NAME = "overshoot";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    String mStr = "identity";
    static Easing sDefault = new Easing();
    private static final String STANDARD_NAME = "standard";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = {STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        if (str.startsWith("spline")) {
            return new StepCurve(str);
        }
        if (str.startsWith("Schlick")) {
            return new Schlick(str);
        }
        switch (str) {
            case "accelerate":
                return new CubicEasing(ACCELERATE);
            case "decelerate":
                return new CubicEasing(DECELERATE);
            case "anticipate":
                return new CubicEasing(ANTICIPATE);
            case "linear":
                return new CubicEasing(LINEAR);
            case "overshoot":
                return new CubicEasing(OVERSHOOT);
            case "standard":
                return new CubicEasing(STANDARD);
            default:
                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
                return sDefault;
        }
    }

    public double getDiff(double d10) {
        return 1.0d;
    }

    public String toString() {
        return this.mStr;
    }

    public double get(double d10) {
        return d10;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class CubicEasing extends Easing {
        private static double sDError = 1.0E-4d;
        private static double sError = 0.01d;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        public CubicEasing(String str) {
            this.mStr = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.mX1 = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i);
            this.mY1 = Double.parseDouble(str.substring(i, indexOf3).trim());
            int i6 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i6);
            this.mX2 = Double.parseDouble(str.substring(i6, indexOf4).trim());
            int i10 = indexOf4 + 1;
            this.mY2 = Double.parseDouble(str.substring(i10, str.indexOf(41, i10)).trim());
        }

        private double getDiffX(double d10) {
            double d11 = 1.0d - d10;
            double d12 = this.mX1;
            double d13 = d11 * 3.0d * d11 * d12;
            double d14 = this.mX2;
            return ((1.0d - d14) * 3.0d * d10 * d10) + ((d14 - d12) * d11 * 6.0d * d10) + d13;
        }

        private double getDiffY(double d10) {
            double d11 = 1.0d - d10;
            double d12 = this.mY1;
            double d13 = d11 * 3.0d * d11 * d12;
            double d14 = this.mY2;
            return ((1.0d - d14) * 3.0d * d10 * d10) + ((d14 - d12) * d11 * 6.0d * d10) + d13;
        }

        private double getX(double d10) {
            double d11 = 1.0d - d10;
            double d12 = 3.0d * d11;
            double d13 = d11 * d12 * d10;
            double d14 = d12 * d10 * d10;
            return (this.mX2 * d14) + (this.mX1 * d13) + (d10 * d10 * d10);
        }

        private double getY(double d10) {
            double d11 = 1.0d - d10;
            double d12 = 3.0d * d11;
            double d13 = d11 * d12 * d10;
            double d14 = d12 * d10 * d10;
            return (this.mY2 * d14) + (this.mY1 * d13) + (d10 * d10 * d10);
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double get(double d10) {
            if (d10 <= 0.0d) {
                return 0.0d;
            }
            if (d10 >= 1.0d) {
                return 1.0d;
            }
            double d11 = 0.5d;
            double d12 = 0.5d;
            while (d11 > sError) {
                d11 *= 0.5d;
                d12 = getX(d12) < d10 ? d12 + d11 : d12 - d11;
            }
            double d13 = d12 - d11;
            double x3 = getX(d13);
            double d14 = d12 + d11;
            double x9 = getX(d14);
            double y9 = getY(d13);
            return (((d10 - x3) * (getY(d14) - y9)) / (x9 - x3)) + y9;
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double getDiff(double d10) {
            double d11 = 0.5d;
            double d12 = 0.5d;
            while (d11 > sDError) {
                d11 *= 0.5d;
                d12 = getX(d12) < d10 ? d12 + d11 : d12 - d11;
            }
            double d13 = d12 - d11;
            double d14 = d12 + d11;
            return (getY(d14) - getY(d13)) / (getX(d14) - getX(d13));
        }

        public void setup(double d10, double d11, double d12, double d13) {
            this.mX1 = d10;
            this.mY1 = d11;
            this.mX2 = d12;
            this.mY2 = d13;
        }

        public CubicEasing(double d10, double d11, double d12, double d13) {
            setup(d10, d11, d12, d13);
        }
    }
}
