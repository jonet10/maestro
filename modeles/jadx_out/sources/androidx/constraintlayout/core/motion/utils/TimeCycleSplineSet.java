package androidx.constraintlayout.core.motion.utils;

import a4.x;
import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class TimeCycleSplineSet {
    protected static final int CURVE_OFFSET = 2;
    protected static final int CURVE_PERIOD = 1;
    protected static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    protected static float sVal2PI = 6.2831855f;
    protected int mCount;
    protected CurveFit mCurveFit;
    protected long mLastTime;
    protected String mType;
    protected int mWaveShape = 0;
    protected int[] mTimePoints = new int[10];
    protected float[][] mValues = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);
    protected float[] mCache = new float[3];
    protected boolean mContinue = false;
    protected float mLastCycle = Float.NaN;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class Sort {
        public static void doubleQuickSort(int[] iArr, float[][] fArr, int i, int i6) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i6;
            iArr2[1] = i;
            int i10 = 2;
            while (i10 > 0) {
                int i11 = iArr2[i10 - 1];
                int i12 = i10 - 2;
                int i13 = iArr2[i12];
                if (i11 < i13) {
                    int partition = partition(iArr, fArr, i11, i13);
                    iArr2[i12] = partition - 1;
                    iArr2[i10 - 1] = i11;
                    int i14 = i10 + 1;
                    iArr2[i10] = i13;
                    i10 += 2;
                    iArr2[i14] = partition + 1;
                } else {
                    i10 = i12;
                }
            }
        }

        private static int partition(int[] iArr, float[][] fArr, int i, int i6) {
            int i10 = iArr[i6];
            int i11 = i;
            while (i < i6) {
                if (iArr[i] <= i10) {
                    swap(iArr, fArr, i11, i);
                    i11++;
                }
                i++;
            }
            swap(iArr, fArr, i11, i6);
            return i11;
        }

        private static void swap(int[] iArr, float[][] fArr, int i, int i6) {
            int i10 = iArr[i];
            iArr[i] = iArr[i6];
            iArr[i6] = i10;
            float[] fArr2 = fArr[i];
            fArr[i] = fArr[i6];
            fArr[i6] = fArr2;
        }
    }

    public float calcWave(float f) {
        float abs;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f * sVal2PI);
            case 2:
                abs = Math.abs(f);
                break;
            case 3:
                return (((f * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f * sVal2PI);
            case 6:
                float abs2 = 1.0f - Math.abs(((f * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin(f * sVal2PI);
        }
        return 1.0f - abs;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i, float f, float f10, int i6, float f11) {
        int[] iArr = this.mTimePoints;
        int i10 = this.mCount;
        iArr[i10] = i;
        float[] fArr = this.mValues[i10];
        fArr[0] = f;
        fArr[1] = f10;
        fArr[2] = f11;
        this.mWaveShape = Math.max(this.mWaveShape, i6);
        this.mCount++;
    }

    public void setStartTime(long j) {
        this.mLastTime = j;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i) {
        int i6;
        int i10 = this.mCount;
        if (i10 == 0) {
            System.err.println("Error no points added to " + this.mType);
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i10 - 1);
        int i11 = 1;
        int i12 = 0;
        while (true) {
            int[] iArr = this.mTimePoints;
            if (i11 >= iArr.length) {
                break;
            }
            if (iArr[i11] != iArr[i11 - 1]) {
                i12++;
            }
            i11++;
        }
        if (i12 == 0) {
            i12 = 1;
        }
        double[] dArr = new double[i12];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i12, 3);
        int i13 = 0;
        for (0; i6 < this.mCount; i6 + 1) {
            if (i6 > 0) {
                int[] iArr2 = this.mTimePoints;
                i6 = iArr2[i6] == iArr2[i6 - 1] ? i6 + 1 : 0;
            }
            dArr[i13] = this.mTimePoints[i6] * 0.01d;
            double[] dArr3 = dArr2[i13];
            float[] fArr = this.mValues[i6];
            dArr3[0] = fArr[0];
            dArr3[1] = fArr[1];
            dArr3[2] = fArr[2];
            i13++;
        }
        this.mCurveFit = CurveFit.get(i, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.mCount; i++) {
            StringBuilder u7 = x.u(str, "[");
            u7.append(this.mTimePoints[i]);
            u7.append(" , ");
            u7.append(decimalFormat.format(this.mValues[i]));
            u7.append("] ");
            str = u7.toString();
        }
        return str;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        KeyFrameArray.CustomArray mConstraintAttributeList;
        float[] mCustomCache;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties = new KeyFrameArray.FloatArray();

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customArray;
        }

        public void setPoint(int i, CustomAttribute customAttribute, float f, int i6, float f10) {
            this.mConstraintAttributeList.append(i, customAttribute);
            this.mWaveProperties.append(i, new float[]{f, f10});
            this.mWaveShape = Math.max(this.mWaveShape, i6);
        }

        public boolean setProperty(MotionWidget motionWidget, float f, long j, KeyCache keyCache) {
            this.mCurveFit.getPos(f, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f10 = fArr[fArr.length - 2];
            float f11 = fArr[fArr.length - 1];
            long j6 = j - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(motionWidget, this.mAttributeName, 0);
                this.mLastCycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.mLastCycle = 0.0f;
                }
            }
            float f12 = (float) ((((j6 * 1.0E-9d) * f10) + this.mLastCycle) % 1.0d);
            this.mLastCycle = f12;
            this.mLastTime = j;
            float calcWave = calcWave(f12);
            this.mContinue = false;
            int i = 0;
            while (true) {
                float[] fArr2 = this.mCustomCache;
                if (i >= fArr2.length) {
                    break;
                }
                boolean z9 = this.mContinue;
                float f13 = this.mTempValues[i];
                this.mContinue = z9 | (((double) f13) != 0.0d);
                fArr2[i] = (f13 * calcWave) + f11;
                i++;
            }
            motionWidget.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), this.mCustomCache);
            if (f10 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i6 = numberOfInterpolatedValues + 2;
            this.mTempValues = new float[i6];
            this.mCustomCache = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i6);
            for (int i10 = 0; i10 < size; i10++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i10);
                CustomAttribute valueAt = this.mConstraintAttributeList.valueAt(i10);
                float[] valueAt2 = this.mWaveProperties.valueAt(i10);
                dArr[i10] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i11 = 0;
                while (true) {
                    if (i11 < this.mTempValues.length) {
                        dArr2[i10][i11] = r8[i11];
                        i11++;
                    }
                }
                double[] dArr3 = dArr2[i10];
                dArr3[numberOfInterpolatedValues] = valueAt2[0];
                dArr3[numberOfInterpolatedValues + 1] = valueAt2[1];
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i, float f, float f10, int i6, float f11) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class CustomVarSet extends TimeCycleSplineSet {
        String mAttributeName;
        KeyFrameArray.CustomVar mConstraintAttributeList;
        float[] mCustomCache;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties = new KeyFrameArray.FloatArray();

        public CustomVarSet(String str, KeyFrameArray.CustomVar customVar) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customVar;
        }

        public void setPoint(int i, CustomVariable customVariable, float f, int i6, float f10) {
            this.mConstraintAttributeList.append(i, customVariable);
            this.mWaveProperties.append(i, new float[]{f, f10});
            this.mWaveShape = Math.max(this.mWaveShape, i6);
        }

        public boolean setProperty(MotionWidget motionWidget, float f, long j, KeyCache keyCache) {
            this.mCurveFit.getPos(f, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f10 = fArr[fArr.length - 2];
            float f11 = fArr[fArr.length - 1];
            long j6 = j - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(motionWidget, this.mAttributeName, 0);
                this.mLastCycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.mLastCycle = 0.0f;
                }
            }
            float f12 = (float) ((((j6 * 1.0E-9d) * f10) + this.mLastCycle) % 1.0d);
            this.mLastCycle = f12;
            this.mLastTime = j;
            float calcWave = calcWave(f12);
            this.mContinue = false;
            int i = 0;
            while (true) {
                float[] fArr2 = this.mCustomCache;
                if (i >= fArr2.length) {
                    break;
                }
                boolean z9 = this.mContinue;
                float f13 = this.mTempValues[i];
                this.mContinue = z9 | (((double) f13) != 0.0d);
                fArr2[i] = (f13 * calcWave) + f11;
                i++;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(motionWidget, this.mCustomCache);
            if (f10 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i6 = numberOfInterpolatedValues + 2;
            this.mTempValues = new float[i6];
            this.mCustomCache = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i6);
            for (int i10 = 0; i10 < size; i10++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i10);
                CustomVariable valueAt = this.mConstraintAttributeList.valueAt(i10);
                float[] valueAt2 = this.mWaveProperties.valueAt(i10);
                dArr[i10] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i11 = 0;
                while (true) {
                    if (i11 < this.mTempValues.length) {
                        dArr2[i10][i11] = r8[i11];
                        i11++;
                    }
                }
                double[] dArr3 = dArr2[i10];
                dArr3[numberOfInterpolatedValues] = valueAt2[0];
                dArr3[numberOfInterpolatedValues + 1] = valueAt2[1];
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i, float f, float f10, int i6, float f11) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }
    }
}
