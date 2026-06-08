package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mSlopeTemp = new double[length2];
        int i = length - 1;
        Class cls = Double.TYPE;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) cls, i, length2);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        for (int i6 = 0; i6 < length2; i6++) {
            int i10 = 0;
            while (i10 < i) {
                int i11 = i10 + 1;
                double d10 = dArr[i11] - dArr[i10];
                double[] dArr5 = dArr3[i10];
                double d11 = (dArr2[i11][i6] - dArr2[i10][i6]) / d10;
                dArr5[i6] = d11;
                if (i10 == 0) {
                    dArr4[i10][i6] = d11;
                } else {
                    dArr4[i10][i6] = (dArr3[i10 - 1][i6] + d11) * 0.5d;
                }
                i10 = i11;
            }
            dArr4[i][i6] = dArr3[length - 2][i6];
        }
        for (int i12 = 0; i12 < i; i12++) {
            for (int i13 = 0; i13 < length2; i13++) {
                double d12 = dArr3[i12][i13];
                if (d12 == 0.0d) {
                    dArr4[i12][i13] = 0.0d;
                    dArr4[i12 + 1][i13] = 0.0d;
                } else {
                    double d13 = dArr4[i12][i13] / d12;
                    int i14 = i12 + 1;
                    double d14 = dArr4[i14][i13] / d12;
                    double hypot = Math.hypot(d13, d14);
                    if (hypot > 9.0d) {
                        double d15 = 3.0d / hypot;
                        double[] dArr6 = dArr4[i12];
                        double[] dArr7 = dArr3[i12];
                        dArr6[i13] = d13 * d15 * dArr7[i13];
                        dArr4[i14][i13] = d15 * d14 * dArr7[i13];
                    }
                }
            }
        }
        this.mT = dArr;
        this.mY = dArr2;
        this.mTangent = dArr4;
    }

    private static MonotonicCurveFit buildWave(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d10 = 1.0d / length2;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i = 0; i < dArr.length; i++) {
            double d11 = dArr[i];
            int i6 = i + length2;
            dArr2[i6][0] = d11;
            double d12 = i * d10;
            dArr3[i6] = d12;
            if (i > 0) {
                int i10 = (length2 * 2) + i;
                dArr2[i10][0] = d11 + 1.0d;
                dArr3[i10] = d12 + 1.0d;
                int i11 = i - 1;
                dArr2[i11][0] = (d11 - 1.0d) - d10;
                dArr3[i11] = (d12 - 1.0d) - d10;
            }
        }
        return new MonotonicCurveFit(dArr3, dArr2);
    }

    private static double diff(double d10, double d11, double d12, double d13, double d14, double d15) {
        double d16 = d11 * d11;
        double d17 = d11 * 6.0d;
        double d18 = 6.0d * d16 * d12;
        double d19 = (d18 + ((d17 * d13) + (((-6.0d) * d16) * d13))) - (d17 * d12);
        double d20 = 3.0d * d10;
        return (d10 * d14) + (((((d20 * d14) * d16) + (((d20 * d15) * d16) + d19)) - (((2.0d * d10) * d15) * d11)) - (((4.0d * d10) * d14) * d11));
    }

    private static double interpolate(double d10, double d11, double d12, double d13, double d14, double d15) {
        double d16 = d11 * d11;
        double d17 = d16 * d11;
        double d18 = 3.0d * d16;
        double d19 = d17 * 2.0d * d12;
        double d20 = ((d19 + ((d18 * d13) + (((-2.0d) * d17) * d13))) - (d18 * d12)) + d12;
        double d21 = d10 * d15;
        double d22 = (d21 * d17) + d20;
        double d23 = d10 * d14;
        return (d23 * d11) + ((((d17 * d23) + d22) - (d21 * d16)) - (((d10 * 2.0d) * d14) * d16));
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d10, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d11 = dArr[0];
            if (d10 <= d11) {
                getSlope(d11, this.mSlopeTemp);
                for (int i6 = 0; i6 < length2; i6++) {
                    fArr[i6] = (float) (((d10 - this.mT[0]) * this.mSlopeTemp[i6]) + this.mY[0][i6]);
                }
                return;
            }
            int i10 = length - 1;
            double d12 = dArr[i10];
            if (d10 >= d12) {
                getSlope(d12, this.mSlopeTemp);
                while (i < length2) {
                    fArr[i] = (float) (((d10 - this.mT[i10]) * this.mSlopeTemp[i]) + this.mY[i10][i]);
                    i++;
                }
                return;
            }
        } else {
            if (d10 <= dArr[0]) {
                for (int i11 = 0; i11 < length2; i11++) {
                    fArr[i11] = (float) this.mY[0][i11];
                }
                return;
            }
            int i12 = length - 1;
            if (d10 >= dArr[i12]) {
                while (i < length2) {
                    fArr[i] = (float) this.mY[i12][i];
                    i++;
                }
                return;
            }
        }
        int i13 = 0;
        while (i13 < length - 1) {
            if (d10 == this.mT[i13]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    fArr[i14] = (float) this.mY[i13][i14];
                }
            }
            double[] dArr2 = this.mT;
            int i15 = i13 + 1;
            double d13 = dArr2[i15];
            if (d10 < d13) {
                double d14 = dArr2[i13];
                double d15 = d13 - d14;
                double d16 = (d10 - d14) / d15;
                while (i < length2) {
                    double[][] dArr3 = this.mY;
                    double d17 = dArr3[i13][i];
                    double d18 = dArr3[i15][i];
                    double[][] dArr4 = this.mTangent;
                    fArr[i] = (float) interpolate(d15, d16, d17, d18, dArr4[i13][i], dArr4[i15][i]);
                    i++;
                }
                return;
            }
            i13 = i15;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d10, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        double d11 = dArr2[0];
        if (d10 > d11) {
            d11 = dArr2[length - 1];
            if (d10 < d11) {
                d11 = d10;
            }
        }
        int i = 0;
        while (i < length - 1) {
            double[] dArr3 = this.mT;
            int i6 = i + 1;
            double d12 = dArr3[i6];
            if (d11 <= d12) {
                double d13 = dArr3[i];
                double d14 = d12 - d13;
                double d15 = (d11 - d13) / d14;
                for (int i10 = 0; i10 < length2; i10++) {
                    double[][] dArr4 = this.mY;
                    double d16 = dArr4[i][i10];
                    double d17 = dArr4[i6][i10];
                    double[][] dArr5 = this.mTangent;
                    dArr[i10] = diff(d14, d15, d16, d17, dArr5[i][i10], dArr5[i6][i10]) / d14;
                }
                return;
            }
            i = i6;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    public static MonotonicCurveFit buildWave(String str) {
        double[] dArr = new double[str.length() / 2];
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(44, indexOf);
        int i = 0;
        while (indexOf2 != -1) {
            dArr[i] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(44, indexOf);
            i++;
        }
        dArr[i] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
        return buildWave(Arrays.copyOf(dArr, i + 1));
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d10, int i) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i6 = 0;
        double d11 = dArr[0];
        if (d10 >= d11) {
            d11 = dArr[length - 1];
            if (d10 < d11) {
                d11 = d10;
            }
        }
        while (i6 < length - 1) {
            double[] dArr2 = this.mT;
            int i10 = i6 + 1;
            double d12 = dArr2[i10];
            if (d11 <= d12) {
                double d13 = dArr2[i6];
                double d14 = d12 - d13;
                double[][] dArr3 = this.mY;
                double d15 = dArr3[i6][i];
                double d16 = dArr3[i10][i];
                double[][] dArr4 = this.mTangent;
                return diff(d14, (d11 - d13) / d14, d15, d16, dArr4[i6][i], dArr4[i10][i]) / d14;
            }
            i6 = i10;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d10, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i = 0;
        int length2 = this.mY[0].length;
        if (this.mExtrapolate) {
            double d11 = dArr2[0];
            if (d10 <= d11) {
                getSlope(d11, this.mSlopeTemp);
                for (int i6 = 0; i6 < length2; i6++) {
                    dArr[i6] = ((d10 - this.mT[0]) * this.mSlopeTemp[i6]) + this.mY[0][i6];
                }
                return;
            }
            int i10 = length - 1;
            double d12 = dArr2[i10];
            if (d10 >= d12) {
                getSlope(d12, this.mSlopeTemp);
                while (i < length2) {
                    dArr[i] = ((d10 - this.mT[i10]) * this.mSlopeTemp[i]) + this.mY[i10][i];
                    i++;
                }
                return;
            }
        } else {
            if (d10 <= dArr2[0]) {
                for (int i11 = 0; i11 < length2; i11++) {
                    dArr[i11] = this.mY[0][i11];
                }
                return;
            }
            int i12 = length - 1;
            if (d10 >= dArr2[i12]) {
                while (i < length2) {
                    dArr[i] = this.mY[i12][i];
                    i++;
                }
                return;
            }
        }
        int i13 = 0;
        while (i13 < length - 1) {
            if (d10 == this.mT[i13]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    dArr[i14] = this.mY[i13][i14];
                }
            }
            double[] dArr3 = this.mT;
            int i15 = i13 + 1;
            double d13 = dArr3[i15];
            if (d10 < d13) {
                double d14 = dArr3[i13];
                double d15 = d13 - d14;
                double d16 = (d10 - d14) / d15;
                while (i < length2) {
                    double[][] dArr4 = this.mY;
                    double d17 = dArr4[i13][i];
                    double d18 = dArr4[i15][i];
                    double[][] dArr5 = this.mTangent;
                    dArr[i] = interpolate(d15, d16, d17, d18, dArr5[i13][i], dArr5[i15][i]);
                    i++;
                }
                return;
            }
            i13 = i15;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d10, int i) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i6 = 0;
        if (this.mExtrapolate) {
            double d11 = dArr[0];
            if (d10 <= d11) {
                return (getSlope(d11, i) * (d10 - d11)) + this.mY[0][i];
            }
            int i10 = length - 1;
            double d12 = dArr[i10];
            if (d10 >= d12) {
                return (getSlope(d12, i) * (d10 - d12)) + this.mY[i10][i];
            }
        } else {
            if (d10 <= dArr[0]) {
                return this.mY[0][i];
            }
            int i11 = length - 1;
            if (d10 >= dArr[i11]) {
                return this.mY[i11][i];
            }
        }
        while (i6 < length - 1) {
            double[] dArr2 = this.mT;
            double d13 = dArr2[i6];
            if (d10 == d13) {
                return this.mY[i6][i];
            }
            int i12 = i6 + 1;
            double d14 = dArr2[i12];
            if (d10 < d14) {
                double d15 = d14 - d13;
                double d16 = (d10 - d13) / d15;
                double[][] dArr3 = this.mY;
                double d17 = dArr3[i6][i];
                double d18 = dArr3[i12][i];
                double[][] dArr4 = this.mTangent;
                return interpolate(d15, d16, d17, d18, dArr4[i6][i], dArr4[i12][i]);
            }
            i6 = i12;
        }
        return 0.0d;
    }
}
