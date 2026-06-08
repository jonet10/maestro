package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int CUSTOM = 7;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double[] mArea;
    MonotonicCurveFit mCustomCurve;
    String mCustomType;
    int mType;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    double mPI2 = 6.283185307179586d;
    private boolean mNormalized = false;

    public void addPoint(double d10, float f) {
        int length = this.mPeriod.length + 1;
        int binarySearch = Arrays.binarySearch(this.mPosition, d10);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.mPosition[binarySearch] = d10;
        this.mPeriod[binarySearch] = f;
        this.mNormalized = false;
    }

    public double getDP(double d10) {
        if (d10 <= 0.0d) {
            return 0.0d;
        }
        if (d10 >= 1.0d) {
            return 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d10);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        float[] fArr = this.mPeriod;
        float f = fArr[binarySearch];
        int i = binarySearch - 1;
        float f10 = fArr[i];
        double d11 = f - f10;
        double[] dArr = this.mPosition;
        double d12 = dArr[binarySearch];
        double d13 = dArr[i];
        double d14 = d11 / (d12 - d13);
        return (f10 - (d14 * d13)) + (d10 * d14);
    }

    public double getP(double d10) {
        if (d10 <= 0.0d) {
            return 0.0d;
        }
        if (d10 >= 1.0d) {
            return 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d10);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        float[] fArr = this.mPeriod;
        float f = fArr[binarySearch];
        int i = binarySearch - 1;
        float f10 = fArr[i];
        double d11 = f - f10;
        double[] dArr = this.mPosition;
        double d12 = dArr[binarySearch];
        double d13 = dArr[i];
        double d14 = d11 / (d12 - d13);
        return ((((d10 * d10) - (d13 * d13)) * d14) / 2.0d) + ((d10 - d13) * (f10 - (d14 * d13))) + this.mArea[i];
    }

    public double getSlope(double d10, double d11, double d12) {
        double d13;
        double signum;
        double p10 = getP(d10) + d11;
        double dp = getDP(d10) + d12;
        switch (this.mType) {
            case 1:
                return 0.0d;
            case 2:
                d13 = dp * 4.0d;
                signum = Math.signum((((p10 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return dp * 2.0d;
            case 4:
                return (-dp) * 2.0d;
            case 5:
                double d14 = this.mPI2;
                return Math.sin(d14 * p10) * (-d14) * dp;
            case 6:
                return ((((p10 * 4.0d) + 2.0d) % 4.0d) - 2.0d) * dp * 4.0d;
            case 7:
                return this.mCustomCurve.getSlope(p10 % 1.0d, 0);
            default:
                double d15 = this.mPI2;
                d13 = dp * d15;
                signum = Math.cos(d15 * p10);
                break;
        }
        return signum * d13;
    }

    public double getValue(double d10, double d11) {
        double abs;
        double p10 = getP(d10) + d11;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (p10 % 1.0d));
            case 2:
                abs = Math.abs((((p10 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((p10 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((p10 * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos((d11 + p10) * this.mPI2);
            case 6:
                double abs2 = 1.0d - Math.abs(((p10 * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            case 7:
                return this.mCustomCurve.getPos(p10 % 1.0d, 0);
            default:
                return Math.sin(this.mPI2 * p10);
        }
        return 1.0d - abs;
    }

    public void normalize() {
        double d10 = 0.0d;
        int i = 0;
        while (true) {
            if (i >= this.mPeriod.length) {
                break;
            }
            d10 += r6[i];
            i++;
        }
        double d11 = 0.0d;
        int i6 = 1;
        while (true) {
            float[] fArr = this.mPeriod;
            if (i6 >= fArr.length) {
                break;
            }
            int i10 = i6 - 1;
            float f = (fArr[i10] + fArr[i6]) / 2.0f;
            double[] dArr = this.mPosition;
            d11 += (dArr[i6] - dArr[i10]) * f;
            i6++;
        }
        int i11 = 0;
        while (true) {
            float[] fArr2 = this.mPeriod;
            if (i11 >= fArr2.length) {
                break;
            }
            fArr2[i11] = fArr2[i11] * ((float) (d10 / d11));
            i11++;
        }
        this.mArea[0] = 0.0d;
        int i12 = 1;
        while (true) {
            float[] fArr3 = this.mPeriod;
            if (i12 >= fArr3.length) {
                this.mNormalized = true;
                return;
            }
            int i13 = i12 - 1;
            float f10 = (fArr3[i13] + fArr3[i12]) / 2.0f;
            double[] dArr2 = this.mPosition;
            double d12 = dArr2[i12] - dArr2[i13];
            double[] dArr3 = this.mArea;
            dArr3[i12] = (d12 * f10) + dArr3[i13];
            i12++;
        }
    }

    public void setType(int i, String str) {
        this.mType = i;
        this.mCustomType = str;
        if (str != null) {
            this.mCustomCurve = MonotonicCurveFit.buildWave(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
