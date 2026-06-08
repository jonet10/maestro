package androidx.constraintlayout.core.motion.utils;

import a4.x;
import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.state.WidgetFrame;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int mCount;
    protected CurveFit mCurveFit;
    private String mType;
    protected int[] mTimePoints = new int[10];
    protected float[] mValues = new float[10];

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class CoreSpline extends SplineSet {
        long mStart;
        String mType;

        public CoreSpline(String str, long j) {
            this.mType = str;
            this.mStart = j;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setProperty(TypedValues typedValues, float f) {
            typedValues.setValue(typedValues.getId(this.mType), get(f));
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class Sort {
        private Sort() {
        }

        public static void doubleQuickSort(int[] iArr, float[] fArr, int i, int i6) {
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

        private static int partition(int[] iArr, float[] fArr, int i, int i6) {
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

        private static void swap(int[] iArr, float[] fArr, int i, int i6) {
            int i10 = iArr[i];
            iArr[i] = iArr[i6];
            iArr[i6] = i10;
            float f = fArr[i];
            fArr[i] = fArr[i6];
            fArr[i6] = f;
        }
    }

    public static SplineSet makeCustomSpline(String str, KeyFrameArray.CustomArray customArray) {
        return new CustomSet(str, customArray);
    }

    public static SplineSet makeCustomSplineSet(String str, KeyFrameArray.CustomVar customVar) {
        return new CustomSpline(str, customVar);
    }

    public static SplineSet makeSpline(String str, long j) {
        return new CoreSpline(str, j);
    }

    public float get(float f) {
        return (float) this.mCurveFit.getPos(f, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f) {
        return (float) this.mCurveFit.getSlope(f, 0);
    }

    public void setPoint(int i, float f) {
        int[] iArr = this.mTimePoints;
        if (iArr.length < this.mCount + 1) {
            this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValues;
            this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTimePoints;
        int i6 = this.mCount;
        iArr2[i6] = i;
        this.mValues[i6] = f;
        this.mCount = i6 + 1;
    }

    public void setProperty(TypedValues typedValues, float f) {
        typedValues.setValue(x.c(this.mType), get(f));
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i) {
        int i6;
        int i10 = this.mCount;
        if (i10 == 0) {
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i10 - 1);
        int i11 = 1;
        for (int i12 = 1; i12 < this.mCount; i12++) {
            int[] iArr = this.mTimePoints;
            if (iArr[i12 - 1] != iArr[i12]) {
                i11++;
            }
        }
        double[] dArr = new double[i11];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i11, 1);
        int i13 = 0;
        for (0; i6 < this.mCount; i6 + 1) {
            if (i6 > 0) {
                int[] iArr2 = this.mTimePoints;
                i6 = iArr2[i6] == iArr2[i6 - 1] ? i6 + 1 : 0;
            }
            dArr[i13] = this.mTimePoints[i6] * 0.01d;
            dArr2[i13][0] = this.mValues[i6];
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
    public static class CustomSet extends SplineSet {
        String mAttributeName;
        KeyFrameArray.CustomArray mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setProperty(WidgetFrame widgetFrame, float f) {
            this.mCurveFit.getPos(f, this.mTempValues);
            widgetFrame.setCustomValue(this.mConstraintAttributeList.valueAt(0), this.mTempValues);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setup(int i) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, numberOfInterpolatedValues);
            for (int i6 = 0; i6 < size; i6++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i6);
                CustomAttribute valueAt = this.mConstraintAttributeList.valueAt(i6);
                dArr[i6] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i10 = 0;
                while (true) {
                    if (i10 < this.mTempValues.length) {
                        dArr2[i6][i10] = r6[i10];
                        i10++;
                    }
                }
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }

        public void setPoint(int i, CustomAttribute customAttribute) {
            this.mConstraintAttributeList.append(i, customAttribute);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class CustomSpline extends SplineSet {
        String mAttributeName;
        KeyFrameArray.CustomVar mConstraintAttributeList;
        float[] mTempValues;

        public CustomSpline(String str, KeyFrameArray.CustomVar customVar) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setProperty(MotionWidget motionWidget, float f) {
            this.mCurveFit.getPos(f, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(motionWidget, this.mTempValues);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setup(int i) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, numberOfInterpolatedValues);
            for (int i6 = 0; i6 < size; i6++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i6);
                CustomVariable valueAt = this.mConstraintAttributeList.valueAt(i6);
                dArr[i6] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.mTempValues);
                int i10 = 0;
                while (true) {
                    if (i10 < this.mTempValues.length) {
                        dArr2[i6][i10] = r6[i10];
                        i10++;
                    }
                }
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }

        public void setPoint(int i, CustomVariable customVariable) {
            this.mConstraintAttributeList.append(i, customVariable);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setProperty(TypedValues typedValues, float f) {
            setProperty((MotionWidget) typedValues, f);
        }
    }
}
