package androidx.constraintlayout.core.motion.utils;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        this.mTotalLength = Double.NaN;
        int length = dArr2[0].length;
        this.mSlopeTemp = new double[length];
        this.mT = dArr;
        this.mY = dArr2;
        if (length <= 2) {
            return;
        }
        int i = 0;
        double d10 = 0.0d;
        while (true) {
            double d11 = d10;
            if (i >= dArr.length) {
                this.mTotalLength = 0.0d;
                return;
            }
            double d12 = dArr2[i][0];
            if (i > 0) {
                Math.hypot(d12 - d10, d12 - d11);
            }
            i++;
            d10 = d12;
        }
    }

    private double getLength2D(double d10) {
        if (Double.isNaN(this.mTotalLength)) {
            return 0.0d;
        }
        double[] dArr = this.mT;
        int length = dArr.length;
        if (d10 <= dArr[0]) {
            return 0.0d;
        }
        int i = length - 1;
        if (d10 >= dArr[i]) {
            return this.mTotalLength;
        }
        double d11 = 0.0d;
        double d12 = 0.0d;
        double d13 = 0.0d;
        int i6 = 0;
        while (i6 < i) {
            double[] dArr2 = this.mY[i6];
            double d14 = dArr2[0];
            double d15 = dArr2[1];
            if (i6 > 0) {
                d11 += Math.hypot(d14 - d12, d15 - d13);
            }
            double[] dArr3 = this.mT;
            double d16 = dArr3[i6];
            if (d10 == d16) {
                return d11;
            }
            int i10 = i6 + 1;
            double d17 = dArr3[i10];
            if (d10 < d17) {
                double d18 = (d10 - d16) / (d17 - d16);
                double[][] dArr4 = this.mY;
                double[] dArr5 = dArr4[i6];
                double d19 = dArr5[0];
                double[] dArr6 = dArr4[i10];
                double d20 = dArr6[0];
                double d21 = 1.0d - d18;
                return Math.hypot(d15 - ((dArr6[1] * d18) + (dArr5[1] * d21)), d14 - ((d20 * d18) + (d19 * d21))) + d11;
            }
            i6 = i10;
            d12 = d14;
            d13 = d15;
        }
        return 0.0d;
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
                double d15 = (d10 - d14) / (d13 - d14);
                while (i < length2) {
                    double[][] dArr3 = this.mY;
                    fArr[i] = (float) ((dArr3[i15][i] * d15) + ((1.0d - d15) * dArr3[i13][i]));
                    i++;
                }
                return;
            }
            i13 = i15;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0017, code lost:
    
        if (r13 >= r4) goto L4;
     */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void getSlope(double r13, double[] r15) {
        /*
            r12 = this;
            double[] r0 = r12.mT
            int r1 = r0.length
            double[][] r2 = r12.mY
            r3 = 0
            r2 = r2[r3]
            int r2 = r2.length
            r4 = r0[r3]
            int r6 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r6 > 0) goto L11
        Lf:
            r13 = r4
            goto L1a
        L11:
            int r4 = r1 + (-1)
            r4 = r0[r4]
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 < 0) goto L1a
            goto Lf
        L1a:
            r0 = r3
        L1b:
            int r4 = r1 + (-1)
            if (r0 >= r4) goto L41
            double[] r4 = r12.mT
            int r5 = r0 + 1
            r6 = r4[r5]
            int r8 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r8 > 0) goto L3f
            r13 = r4[r0]
            double r6 = r6 - r13
        L2c:
            if (r3 >= r2) goto L41
            double[][] r13 = r12.mY
            r14 = r13[r0]
            r8 = r14[r3]
            r13 = r13[r5]
            r10 = r13[r3]
            double r10 = r10 - r8
            double r10 = r10 / r6
            r15[r3] = r10
            int r3 = r3 + 1
            goto L2c
        L3f:
            r0 = r5
            goto L1b
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.getSlope(double, double[]):void");
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0012, code lost:
    
        if (r8 >= r3) goto L4;
     */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double getSlope(double r8, int r10) {
        /*
            r7 = this;
            double[] r0 = r7.mT
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 >= 0) goto Lc
        La:
            r8 = r3
            goto L15
        Lc:
            int r3 = r1 + (-1)
            r3 = r0[r3]
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L15
            goto La
        L15:
            int r0 = r1 + (-1)
            if (r2 >= r0) goto L35
            double[] r0 = r7.mT
            int r3 = r2 + 1
            r4 = r0[r3]
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 > 0) goto L33
            r8 = r0[r2]
            double r4 = r4 - r8
            double[][] r8 = r7.mY
            r9 = r8[r2]
            r0 = r9[r10]
            r8 = r8[r3]
            r9 = r8[r10]
            double r9 = r9 - r0
            double r9 = r9 / r4
            return r9
        L33:
            r2 = r3
            goto L15
        L35:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.getSlope(double, int):double");
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
                double d15 = (d10 - d14) / (d13 - d14);
                while (i < length2) {
                    double[][] dArr4 = this.mY;
                    dArr[i] = (dArr4[i15][i] * d15) + ((1.0d - d15) * dArr4[i13][i]);
                    i++;
                }
                return;
            }
            i13 = i15;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d10, int i) {
        double d11;
        double d12;
        double slope;
        double[] dArr = this.mT;
        int length = dArr.length;
        int i6 = 0;
        if (this.mExtrapolate) {
            double d13 = dArr[0];
            if (d10 <= d13) {
                d11 = this.mY[0][i];
                d12 = d10 - d13;
                slope = getSlope(d13, i);
            } else {
                int i10 = length - 1;
                double d14 = dArr[i10];
                if (d10 >= d14) {
                    d11 = this.mY[i10][i];
                    d12 = d10 - d14;
                    slope = getSlope(d14, i);
                }
            }
            return (slope * d12) + d11;
        }
        if (d10 <= dArr[0]) {
            return this.mY[0][i];
        }
        int i11 = length - 1;
        if (d10 >= dArr[i11]) {
            return this.mY[i11][i];
        }
        while (i6 < length - 1) {
            double[] dArr2 = this.mT;
            double d15 = dArr2[i6];
            if (d10 == d15) {
                return this.mY[i6][i];
            }
            int i12 = i6 + 1;
            double d16 = dArr2[i12];
            if (d10 < d16) {
                double d17 = (d10 - d15) / (d16 - d15);
                double[][] dArr3 = this.mY;
                return (dArr3[i12][i] * d17) + ((1.0d - d17) * dArr3[i6][i]);
            }
            i6 = i12;
        }
        return 0.0d;
    }
}
