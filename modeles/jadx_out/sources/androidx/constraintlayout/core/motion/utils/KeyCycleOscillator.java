package androidx.constraintlayout.core.motion.utils;

import a4.x;
import androidx.constraintlayout.core.motion.MotionWidget;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    private CycleOscillator mCycleOscillator;
    private String mType;
    private int mWaveShape = 0;
    private String mWaveString = null;
    public int mVariesBy = 0;
    ArrayList<WavePoint> mWavePoints = new ArrayList<>();

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class CoreSpline extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        public CoreSpline(String str) {
            this.mType = str;
            this.mTypeId = x.d(str);
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f) {
            motionWidget.setValue(this.mTypeId, get(f));
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        CurveFit mCurveFit;
        float[] mOffsetArr;
        private final int mOffst;
        Oscillator mOscillator;
        float mPathLength;
        float[] mPeriod;
        private final int mPhase;
        float[] mPhaseArr;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        private final int mValue;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;

        public CycleOscillator(int i, String str, int i6, int i10) {
            Oscillator oscillator = new Oscillator();
            this.mOscillator = oscillator;
            this.mOffst = 0;
            this.mPhase = 1;
            this.mValue = 2;
            this.mWaveShape = i;
            this.mVariesBy = i6;
            oscillator.setType(i, str);
            this.mValues = new float[i10];
            this.mPosition = new double[i10];
            this.mPeriod = new float[i10];
            this.mOffsetArr = new float[i10];
            this.mPhaseArr = new float[i10];
            this.mScale = new float[i10];
        }

        public double getLastPhase() {
            return this.mSplineValueCache[1];
        }

        public double getSlope(float f) {
            CurveFit curveFit = this.mCurveFit;
            double[] dArr = this.mSplineSlopeCache;
            if (curveFit != null) {
                double d10 = f;
                curveFit.getSlope(d10, dArr);
                this.mCurveFit.getPos(d10, this.mSplineValueCache);
            } else {
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d11 = f;
            double value = this.mOscillator.getValue(d11, this.mSplineValueCache[1]);
            double slope = this.mOscillator.getSlope(d11, this.mSplineValueCache[1], this.mSplineSlopeCache[1]);
            double[] dArr2 = this.mSplineSlopeCache;
            return (slope * this.mSplineValueCache[2]) + (value * dArr2[2]) + dArr2[0];
        }

        public double getValues(float f) {
            CurveFit curveFit = this.mCurveFit;
            double[] dArr = this.mSplineValueCache;
            if (curveFit != null) {
                curveFit.getPos(f, dArr);
            } else {
                dArr[0] = this.mOffsetArr[0];
                dArr[1] = this.mPhaseArr[0];
                dArr[2] = this.mValues[0];
            }
            double[] dArr2 = this.mSplineValueCache;
            return (this.mOscillator.getValue(f, dArr2[1]) * this.mSplineValueCache[2]) + dArr2[0];
        }

        public void setPoint(int i, int i6, float f, float f10, float f11, float f12) {
            this.mPosition[i] = i6 / 100.0d;
            this.mPeriod[i] = f;
            this.mOffsetArr[i] = f10;
            this.mPhaseArr[i] = f11;
            this.mValues[i] = f12;
        }

        public void setup(float f) {
            this.mPathLength = f;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.mPosition.length, 3);
            float[] fArr = this.mValues;
            this.mSplineValueCache = new double[fArr.length + 2];
            this.mSplineSlopeCache = new double[fArr.length + 2];
            if (this.mPosition[0] > 0.0d) {
                this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
            }
            double[] dArr2 = this.mPosition;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
            }
            for (int i = 0; i < dArr.length; i++) {
                double[] dArr3 = dArr[i];
                dArr3[0] = this.mOffsetArr[i];
                dArr3[1] = this.mPhaseArr[i];
                dArr3[2] = this.mValues[i];
                this.mOscillator.addPoint(this.mPosition[i], this.mPeriod[i]);
            }
            this.mOscillator.normalize();
            double[] dArr4 = this.mPosition;
            if (dArr4.length > 1) {
                this.mCurveFit = CurveFit.get(0, dArr4, dArr);
            } else {
                this.mCurveFit = null;
            }
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class PathRotateSet extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        public PathRotateSet(String str) {
            this.mType = str;
            this.mTypeId = x.d(str);
        }

        public void setPathRotate(MotionWidget motionWidget, float f, double d10, double d11) {
            motionWidget.setRotationZ(get(f) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f) {
            motionWidget.setValue(this.mTypeId, get(f));
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class WavePoint {
        float mOffset;
        float mPeriod;
        float mPhase;
        int mPosition;
        float mValue;

        public WavePoint(int i, float f, float f10, float f11, float f12) {
            this.mPosition = i;
            this.mValue = f12;
            this.mOffset = f10;
            this.mPeriod = f;
            this.mPhase = f11;
        }
    }

    public static KeyCycleOscillator makeWidgetCycle(String str) {
        return str.equals("pathRotate") ? new PathRotateSet(str) : new CoreSpline(str);
    }

    public float get(float f) {
        return (float) this.mCycleOscillator.getValues(f);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f) {
        return (float) this.mCycleOscillator.getSlope(f);
    }

    public void setPoint(int i, int i6, String str, int i10, float f, float f10, float f11, float f12, Object obj) {
        this.mWavePoints.add(new WavePoint(i, f, f10, f11, f12));
        if (i10 != -1) {
            this.mVariesBy = i10;
        }
        this.mWaveShape = i6;
        setCustom(obj);
        this.mWaveString = str;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(float f) {
        int size = this.mWavePoints.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.mWavePoints, new Comparator<WavePoint>() { // from class: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.1
            @Override // java.util.Comparator
            public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
            }
        });
        double[] dArr = new double[size];
        char c9 = 2;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mWaveString, this.mVariesBy, size);
        ArrayList<WavePoint> arrayList = this.mWavePoints;
        int size2 = arrayList.size();
        int i = 0;
        int i6 = 0;
        while (i < size2) {
            int i10 = i + 1;
            WavePoint wavePoint = arrayList.get(i);
            float f10 = wavePoint.mPeriod;
            dArr[i6] = f10 * 0.01d;
            double[] dArr3 = dArr2[i6];
            float f11 = wavePoint.mValue;
            dArr3[0] = f11;
            float f12 = wavePoint.mOffset;
            char c10 = c9;
            dArr3[1] = f12;
            float f13 = wavePoint.mPhase;
            dArr3[c10] = f13;
            this.mCycleOscillator.setPoint(i6, wavePoint.mPosition, f10, f12, f13, f11);
            i6++;
            i = i10;
            c9 = c10;
            dArr2 = dArr2;
        }
        this.mCycleOscillator.setup(f);
        this.mCurveFit = CurveFit.get(0, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        ArrayList<WavePoint> arrayList = this.mWavePoints;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            WavePoint wavePoint = arrayList.get(i);
            i++;
            StringBuilder u7 = x.u(str, "[");
            u7.append(wavePoint.mPosition);
            u7.append(" , ");
            u7.append(decimalFormat.format(r5.mValue));
            u7.append("] ");
            str = u7.toString();
        }
        return str;
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }

    public void setCustom(Object obj) {
    }

    public void setPoint(int i, int i6, String str, int i10, float f, float f10, float f11, float f12) {
        this.mWavePoints.add(new WavePoint(i, f, f10, f11, f12));
        if (i10 != -1) {
            this.mVariesBy = i10;
        }
        this.mWaveShape = i6;
        this.mWaveString = str;
    }

    public void setProperty(MotionWidget motionWidget, float f) {
    }
}
