package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_ABOVE = 5;
    public static final int ARC_BELOW = 4;
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int DOWN_ARC = 4;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    private static final int UP_ARC = 5;
    Arc[] mArcs;
    private boolean mExtrapolate = true;
    private final double[] mTime;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] sOurPercent = new double[91];
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        boolean mLinear;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        public Arc(int i, double d10, double d11, double d12, double d13, double d14, double d15) {
            this.mLinear = false;
            double d16 = d14 - d12;
            double d17 = d15 - d13;
            if (i == 1) {
                this.mVertical = true;
            } else if (i == 4) {
                this.mVertical = d17 > 0.0d;
            } else if (i != 5) {
                this.mVertical = false;
            } else {
                this.mVertical = d17 < 0.0d;
            }
            this.mTime1 = d10;
            this.mTime2 = d11;
            this.mOneOverDeltaTime = 1.0d / (d11 - d10);
            if (3 == i) {
                this.mLinear = true;
            }
            if (!this.mLinear && Math.abs(d16) >= EPSILON && Math.abs(d17) >= EPSILON) {
                this.mLut = new double[TypedValues.TYPE_TARGET];
                boolean z9 = this.mVertical;
                this.mEllipseA = d16 * (z9 ? -1 : 1);
                this.mEllipseB = d17 * (z9 ? 1 : -1);
                this.mEllipseCenterX = z9 ? d14 : d12;
                this.mEllipseCenterY = z9 ? d13 : d15;
                buildTable(d12, d13, d14, d15);
                this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                return;
            }
            this.mLinear = true;
            this.mX1 = d12;
            this.mX2 = d14;
            this.mY1 = d13;
            this.mY2 = d15;
            double hypot = Math.hypot(d17, d16);
            this.mArcDistance = hypot;
            this.mArcVelocity = hypot * this.mOneOverDeltaTime;
            double d18 = this.mTime2;
            double d19 = this.mTime1;
            this.mEllipseCenterX = d16 / (d18 - d19);
            this.mEllipseCenterY = d17 / (d18 - d19);
        }

        private void buildTable(double d10, double d11, double d12, double d13) {
            double d14 = d12 - d10;
            double d15 = d11 - d13;
            int i = 0;
            double d16 = 0.0d;
            double d17 = 0.0d;
            double d18 = 0.0d;
            while (true) {
                if (i >= sOurPercent.length) {
                    break;
                }
                int i6 = i;
                double radians = Math.toRadians((i * 90.0d) / (r15.length - 1));
                double sin = Math.sin(radians) * d14;
                double cos = Math.cos(radians) * d15;
                if (i6 > 0) {
                    d16 += Math.hypot(sin - d17, cos - d18);
                    sOurPercent[i6] = d16;
                }
                i = i6 + 1;
                d17 = sin;
                d18 = cos;
            }
            this.mArcDistance = d16;
            int i10 = 0;
            while (true) {
                double[] dArr = sOurPercent;
                if (i10 >= dArr.length) {
                    break;
                }
                dArr[i10] = dArr[i10] / d16;
                i10++;
            }
            int i11 = 0;
            while (true) {
                if (i11 >= this.mLut.length) {
                    return;
                }
                double length = i11 / (r1.length - 1);
                int binarySearch = Arrays.binarySearch(sOurPercent, length);
                if (binarySearch >= 0) {
                    this.mLut[i11] = binarySearch / (sOurPercent.length - 1);
                } else if (binarySearch == -1) {
                    this.mLut[i11] = 0.0d;
                } else {
                    int i12 = -binarySearch;
                    int i13 = i12 - 2;
                    double[] dArr2 = sOurPercent;
                    double d19 = dArr2[i13];
                    this.mLut[i11] = (((length - d19) / (dArr2[i12 - 1] - d19)) + i13) / (dArr2.length - 1);
                }
                i11++;
            }
        }

        public double getDX() {
            double d10 = this.mEllipseA * this.mTmpCosAngle;
            double hypot = this.mArcVelocity / Math.hypot(d10, (-this.mEllipseB) * this.mTmpSinAngle);
            return this.mVertical ? (-d10) * hypot : d10 * hypot;
        }

        public double getDY() {
            double d10 = this.mEllipseA * this.mTmpCosAngle;
            double d11 = (-this.mEllipseB) * this.mTmpSinAngle;
            double hypot = this.mArcVelocity / Math.hypot(d10, d11);
            return this.mVertical ? (-d11) * hypot : d11 * hypot;
        }

        public double getLinearDX(double d10) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d10) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d10) {
            double d11 = (d10 - this.mTime1) * this.mOneOverDeltaTime;
            double d12 = this.mX1;
            return ((this.mX2 - d12) * d11) + d12;
        }

        public double getLinearY(double d10) {
            double d11 = (d10 - this.mTime1) * this.mOneOverDeltaTime;
            double d12 = this.mY1;
            return ((this.mY2 - d12) * d11) + d12;
        }

        public double getX() {
            return (this.mEllipseA * this.mTmpSinAngle) + this.mEllipseCenterX;
        }

        public double getY() {
            return (this.mEllipseB * this.mTmpCosAngle) + this.mEllipseCenterY;
        }

        public double lookup(double d10) {
            if (d10 <= 0.0d) {
                return 0.0d;
            }
            if (d10 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = d10 * (dArr.length - 1);
            int i = (int) length;
            double d11 = length - i;
            double d12 = dArr[i];
            return ((dArr[i + 1] - d12) * d11) + d12;
        }

        public void setPoint(double d10) {
            double lookup = lookup((this.mVertical ? this.mTime2 - d10 : d10 - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(lookup);
            this.mTmpCosAngle = Math.cos(lookup);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        if (r5 == 1) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ArcCurveFit(int[] r24, double[] r25, double[][] r26) {
        /*
            r23 = this;
            r0 = r23
            r1 = r25
            r0.<init>()
            r2 = 1
            r0.mExtrapolate = r2
            r0.mTime = r1
            int r3 = r1.length
            int r3 = r3 - r2
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc[] r3 = new androidx.constraintlayout.core.motion.utils.ArcCurveFit.Arc[r3]
            r0.mArcs = r3
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        L16:
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc[] r7 = r0.mArcs
            int r8 = r7.length
            if (r4 >= r8) goto L5b
            r8 = r24[r4]
            r9 = 3
            if (r8 == 0) goto L38
            if (r8 == r2) goto L36
            r10 = 2
            if (r8 == r10) goto L34
            if (r8 == r9) goto L2f
            r9 = 4
            if (r8 == r9) goto L38
            r9 = 5
            if (r8 == r9) goto L38
            r9 = r6
            goto L38
        L2f:
            if (r5 != r2) goto L36
            goto L34
        L32:
            r9 = r5
            goto L38
        L34:
            r5 = r10
            goto L32
        L36:
            r5 = r2
            goto L32
        L38:
            androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc r8 = new androidx.constraintlayout.core.motion.utils.ArcCurveFit$Arc
            r10 = r1[r4]
            int r6 = r4 + 1
            r12 = r1[r6]
            r14 = r26[r4]
            r15 = r14[r3]
            r17 = r14[r2]
            r14 = r26[r6]
            r19 = r14[r3]
            r21 = r14[r2]
            r14 = r15
            r16 = r17
            r18 = r19
            r20 = r21
            r8.<init>(r9, r10, r12, r14, r16, r18, r20)
            r7[r4] = r8
            r4 = r6
            r6 = r9
            goto L16
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.ArcCurveFit.<init>(int[], double[], double[][]):void");
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d10, double[] dArr) {
        boolean z9 = this.mExtrapolate;
        Arc[] arcArr = this.mArcs;
        if (z9) {
            Arc arc = arcArr[0];
            double d11 = arc.mTime1;
            if (d10 < d11) {
                double d12 = d10 - d11;
                if (arc.mLinear) {
                    dArr[0] = (this.mArcs[0].getLinearDX(d11) * d12) + arc.getLinearX(d11);
                    dArr[1] = (d12 * this.mArcs[0].getLinearDY(d11)) + this.mArcs[0].getLinearY(d11);
                    return;
                }
                arc.setPoint(d11);
                dArr[0] = (this.mArcs[0].getDX() * d12) + this.mArcs[0].getX();
                dArr[1] = (d12 * this.mArcs[0].getDY()) + this.mArcs[0].getY();
                return;
            }
            if (d10 > arcArr[arcArr.length - 1].mTime2) {
                double d13 = arcArr[arcArr.length - 1].mTime2;
                double d14 = d10 - d13;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.mLinear) {
                    dArr[0] = (this.mArcs[length].getLinearDX(d13) * d14) + arc2.getLinearX(d13);
                    dArr[1] = (d14 * this.mArcs[length].getLinearDY(d13)) + this.mArcs[length].getLinearY(d13);
                    return;
                }
                arc2.setPoint(d10);
                dArr[0] = (this.mArcs[length].getDX() * d14) + this.mArcs[length].getX();
                dArr[1] = (d14 * this.mArcs[length].getDY()) + this.mArcs[length].getY();
                return;
            }
        } else {
            double d15 = arcArr[0].mTime1;
            if (d10 < d15) {
                d10 = d15;
            }
            if (d10 > arcArr[arcArr.length - 1].mTime2) {
                d10 = arcArr[arcArr.length - 1].mTime2;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i >= arcArr2.length) {
                return;
            }
            Arc arc3 = arcArr2[i];
            if (d10 <= arc3.mTime2) {
                if (arc3.mLinear) {
                    dArr[0] = arc3.getLinearX(d10);
                    dArr[1] = this.mArcs[i].getLinearY(d10);
                    return;
                } else {
                    arc3.setPoint(d10);
                    dArr[0] = this.mArcs[i].getX();
                    dArr[1] = this.mArcs[i].getY();
                    return;
                }
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d10, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        double d11 = arcArr[0].mTime1;
        if (d10 < d11) {
            d10 = d11;
        } else if (d10 > arcArr[arcArr.length - 1].mTime2) {
            d10 = arcArr[arcArr.length - 1].mTime2;
        }
        int i = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i >= arcArr2.length) {
                return;
            }
            Arc arc = arcArr2[i];
            if (d10 <= arc.mTime2) {
                if (arc.mLinear) {
                    dArr[0] = arc.getLinearDX(d10);
                    dArr[1] = this.mArcs[i].getLinearDY(d10);
                    return;
                } else {
                    arc.setPoint(d10);
                    dArr[0] = this.mArcs[i].getDX();
                    dArr[1] = this.mArcs[i].getDY();
                    return;
                }
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d10, int i) {
        Arc[] arcArr = this.mArcs;
        int i6 = 0;
        double d11 = arcArr[0].mTime1;
        if (d10 < d11) {
            d10 = d11;
        }
        if (d10 > arcArr[arcArr.length - 1].mTime2) {
            d10 = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i6 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i6];
            if (d10 <= arc.mTime2) {
                if (arc.mLinear) {
                    if (i == 0) {
                        return arc.getLinearDX(d10);
                    }
                    return arc.getLinearDY(d10);
                }
                arc.setPoint(d10);
                Arc[] arcArr3 = this.mArcs;
                if (i == 0) {
                    return arcArr3[i6].getDX();
                }
                return arcArr3[i6].getDY();
            }
            i6++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d10, float[] fArr) {
        boolean z9 = this.mExtrapolate;
        Arc[] arcArr = this.mArcs;
        if (z9) {
            Arc arc = arcArr[0];
            double d11 = arc.mTime1;
            if (d10 < d11) {
                double d12 = d10 - d11;
                if (arc.mLinear) {
                    fArr[0] = (float) ((this.mArcs[0].getLinearDX(d11) * d12) + arc.getLinearX(d11));
                    fArr[1] = (float) ((d12 * this.mArcs[0].getLinearDY(d11)) + this.mArcs[0].getLinearY(d11));
                    return;
                }
                arc.setPoint(d11);
                fArr[0] = (float) ((this.mArcs[0].getDX() * d12) + this.mArcs[0].getX());
                fArr[1] = (float) ((d12 * this.mArcs[0].getDY()) + this.mArcs[0].getY());
                return;
            }
            if (d10 > arcArr[arcArr.length - 1].mTime2) {
                double d13 = arcArr[arcArr.length - 1].mTime2;
                double d14 = d10 - d13;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.mLinear) {
                    fArr[0] = (float) ((this.mArcs[length].getLinearDX(d13) * d14) + arc2.getLinearX(d13));
                    fArr[1] = (float) ((d14 * this.mArcs[length].getLinearDY(d13)) + this.mArcs[length].getLinearY(d13));
                    return;
                }
                arc2.setPoint(d10);
                fArr[0] = (float) this.mArcs[length].getX();
                fArr[1] = (float) this.mArcs[length].getY();
                return;
            }
        } else {
            double d15 = arcArr[0].mTime1;
            if (d10 < d15) {
                d10 = d15;
            } else if (d10 > arcArr[arcArr.length - 1].mTime2) {
                d10 = arcArr[arcArr.length - 1].mTime2;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i >= arcArr2.length) {
                return;
            }
            Arc arc3 = arcArr2[i];
            if (d10 <= arc3.mTime2) {
                if (arc3.mLinear) {
                    fArr[0] = (float) arc3.getLinearX(d10);
                    fArr[1] = (float) this.mArcs[i].getLinearY(d10);
                    return;
                } else {
                    arc3.setPoint(d10);
                    fArr[0] = (float) this.mArcs[i].getX();
                    fArr[1] = (float) this.mArcs[i].getY();
                    return;
                }
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d10, int i) {
        boolean z9 = this.mExtrapolate;
        Arc[] arcArr = this.mArcs;
        int i6 = 0;
        if (z9) {
            Arc arc = arcArr[0];
            double d11 = arc.mTime1;
            if (d10 < d11) {
                double d12 = d10 - d11;
                if (arc.mLinear) {
                    if (i == 0) {
                        return (d12 * this.mArcs[0].getLinearDX(d11)) + arc.getLinearX(d11);
                    }
                    return (d12 * this.mArcs[0].getLinearDY(d11)) + arc.getLinearY(d11);
                }
                arc.setPoint(d11);
                Arc[] arcArr2 = this.mArcs;
                if (i == 0) {
                    return (d12 * this.mArcs[0].getDX()) + arcArr2[0].getX();
                }
                return (d12 * this.mArcs[0].getDY()) + arcArr2[0].getY();
            }
            if (d10 > arcArr[arcArr.length - 1].mTime2) {
                double d13 = arcArr[arcArr.length - 1].mTime2;
                double d14 = d10 - d13;
                int length = arcArr.length - 1;
                if (i == 0) {
                    return (d14 * this.mArcs[length].getLinearDX(d13)) + arcArr[length].getLinearX(d13);
                }
                return (d14 * this.mArcs[length].getLinearDY(d13)) + arcArr[length].getLinearY(d13);
            }
        } else {
            double d15 = arcArr[0].mTime1;
            if (d10 < d15) {
                d10 = d15;
            } else if (d10 > arcArr[arcArr.length - 1].mTime2) {
                d10 = arcArr[arcArr.length - 1].mTime2;
            }
        }
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i6 >= arcArr3.length) {
                return Double.NaN;
            }
            Arc arc2 = arcArr3[i6];
            if (d10 <= arc2.mTime2) {
                if (arc2.mLinear) {
                    if (i == 0) {
                        return arc2.getLinearX(d10);
                    }
                    return arc2.getLinearY(d10);
                }
                arc2.setPoint(d10);
                Arc[] arcArr4 = this.mArcs;
                if (i == 0) {
                    return arcArr4[i6].getX();
                }
                return arcArr4[i6].getY();
            }
            i6++;
        }
    }
}
