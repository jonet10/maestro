package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class HyperSpline {
    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class Cubic {
        double mA;
        double mB;
        double mC;
        double mD;

        public Cubic(double d10, double d11, double d12, double d13) {
            this.mA = d10;
            this.mB = d11;
            this.mC = d12;
            this.mD = d13;
        }

        public double eval(double d10) {
            return (((((this.mD * d10) + this.mC) * d10) + this.mB) * d10) + this.mA;
        }

        public double vel(double d10) {
            return (((this.mC * 2.0d) + (this.mD * 3.0d * d10)) * d10) + this.mB;
        }
    }

    public HyperSpline(double[][] dArr) {
        setup(dArr);
    }

    public static Cubic[] calcNaturalCubic(int i, double[] dArr) {
        double[] dArr2 = new double[i];
        double[] dArr3 = new double[i];
        double[] dArr4 = new double[i];
        int i6 = i - 1;
        int i10 = 0;
        dArr2[0] = 0.5d;
        int i11 = 1;
        for (int i12 = 1; i12 < i6; i12++) {
            dArr2[i12] = 1.0d / (4.0d - dArr2[i12 - 1]);
        }
        int i13 = i - 2;
        dArr2[i6] = 1.0d / (2.0d - dArr2[i13]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (i11 < i6) {
            int i14 = i11 + 1;
            int i15 = i11 - 1;
            dArr3[i11] = (((dArr[i14] - dArr[i15]) * 3.0d) - dArr3[i15]) * dArr2[i11];
            i11 = i14;
        }
        double d10 = (((dArr[i6] - dArr[i13]) * 3.0d) - dArr3[i13]) * dArr2[i6];
        dArr3[i6] = d10;
        dArr4[i6] = d10;
        while (i13 >= 0) {
            dArr4[i13] = dArr3[i13] - (dArr2[i13] * dArr4[i13 + 1]);
            i13--;
        }
        Cubic[] cubicArr = new Cubic[i6];
        while (i10 < i6) {
            double d11 = dArr[i10];
            double d12 = dArr4[i10];
            int i16 = i10 + 1;
            double d13 = dArr[i16];
            double d14 = dArr4[i16];
            cubicArr[i10] = new Cubic((float) d11, d12, (((d13 - d11) * 3.0d) - (d12 * 2.0d)) - d14, ((d11 - d13) * 2.0d) + d12 + d14);
            i10 = i16;
        }
        return cubicArr;
    }

    public double approxLength(Cubic[] cubicArr) {
        int i;
        int length = cubicArr.length;
        double[] dArr = new double[length];
        double d10 = 0.0d;
        double d11 = 0.0d;
        double d12 = 0.0d;
        while (true) {
            i = 0;
            if (d11 >= 1.0d) {
                break;
            }
            double d13 = 0.0d;
            while (i < length) {
                double d14 = dArr[i];
                double eval = cubicArr[i].eval(d11);
                dArr[i] = eval;
                double d15 = d14 - eval;
                d13 += d15 * d15;
                i++;
            }
            if (d11 > 0.0d) {
                d12 += Math.sqrt(d13);
            }
            d11 += 0.1d;
        }
        while (i < length) {
            double d16 = dArr[i];
            double eval2 = cubicArr[i].eval(1.0d);
            dArr[i] = eval2;
            double d17 = d16 - eval2;
            d10 += d17 * d17;
            i++;
        }
        return Math.sqrt(d10) + d12;
    }

    public void getPos(double d10, float[] fArr) {
        double d11 = d10 * this.mTotalLength;
        int i = 0;
        while (true) {
            double[] dArr = this.mCurveLength;
            if (i >= dArr.length - 1) {
                break;
            }
            double d12 = dArr[i];
            if (d12 >= d11) {
                break;
            }
            d11 -= d12;
            i++;
        }
        for (int i6 = 0; i6 < fArr.length; i6++) {
            fArr[i6] = (float) this.mCurve[i6][i].eval(d11 / this.mCurveLength[i]);
        }
    }

    public void getVelocity(double d10, double[] dArr) {
        double d11 = d10 * this.mTotalLength;
        int i = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i >= dArr2.length - 1) {
                break;
            }
            double d12 = dArr2[i];
            if (d12 >= d11) {
                break;
            }
            d11 -= d12;
            i++;
        }
        for (int i6 = 0; i6 < dArr.length; i6++) {
            dArr[i6] = this.mCurve[i6][i].vel(d11 / this.mCurveLength[i]);
        }
    }

    public void setup(double[][] dArr) {
        int i;
        int length = dArr[0].length;
        this.mDimensionality = length;
        int length2 = dArr.length;
        this.mPoints = length2;
        this.mCtl = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length2);
        this.mCurve = new Cubic[this.mDimensionality][];
        for (int i6 = 0; i6 < this.mDimensionality; i6++) {
            for (int i10 = 0; i10 < this.mPoints; i10++) {
                this.mCtl[i6][i10] = dArr[i10][i6];
            }
        }
        int i11 = 0;
        while (true) {
            i = this.mDimensionality;
            if (i11 >= i) {
                break;
            }
            Cubic[][] cubicArr = this.mCurve;
            double[] dArr2 = this.mCtl[i11];
            cubicArr[i11] = calcNaturalCubic(dArr2.length, dArr2);
            i11++;
        }
        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = 0.0d;
        Cubic[] cubicArr2 = new Cubic[i];
        for (int i12 = 0; i12 < this.mCurveLength.length; i12++) {
            for (int i13 = 0; i13 < this.mDimensionality; i13++) {
                cubicArr2[i13] = this.mCurve[i13][i12];
            }
            double d10 = this.mTotalLength;
            double[] dArr3 = this.mCurveLength;
            double approxLength = approxLength(cubicArr2);
            dArr3[i12] = approxLength;
            this.mTotalLength = d10 + approxLength;
        }
    }

    public HyperSpline() {
    }

    public void getPos(double d10, double[] dArr) {
        double d11 = d10 * this.mTotalLength;
        int i = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i >= dArr2.length - 1) {
                break;
            }
            double d12 = dArr2[i];
            if (d12 >= d11) {
                break;
            }
            d11 -= d12;
            i++;
        }
        for (int i6 = 0; i6 < dArr.length; i6++) {
            dArr[i6] = this.mCurve[i6][i].eval(d11 / this.mCurveLength[i]);
        }
    }

    public double getPos(double d10, int i) {
        double[] dArr;
        double d11 = d10 * this.mTotalLength;
        int i6 = 0;
        while (true) {
            dArr = this.mCurveLength;
            if (i6 >= dArr.length - 1) {
                break;
            }
            double d12 = dArr[i6];
            if (d12 >= d11) {
                break;
            }
            d11 -= d12;
            i6++;
        }
        return this.mCurve[i][i6].eval(d11 / dArr[i6]);
    }
}
