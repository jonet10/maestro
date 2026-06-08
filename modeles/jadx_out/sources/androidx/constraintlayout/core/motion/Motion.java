package androidx.constraintlayout.core.motion;

import a4.x;
import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyTrigger;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.motion.utils.ViewState;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class Motion implements TypedValues {
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int INTERPOLATOR_UNDEFINED = -3;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    String[] mAttributeTable;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    public String mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private MotionKeyTrigger[] mKeyTriggers;
    Motion mRelativeMotion;
    private CurveFit[] mSpline;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    MotionWidget mView;
    Rect mTempRect = new Rect();
    private int mCurveFitType = 0;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    float mMotionStagger = Float.NaN;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private int mMaxDimension = 4;
    private float[] mValuesBuff = new float[4];
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private float[] mVelocity = new float[1];
    private ArrayList<MotionKey> mKeyList = new ArrayList<>();
    private int mPathMotionArc = -1;
    private int mTransformPivotTarget = -1;
    private MotionWidget mTransformPivotView = null;
    private int mQuantizeMotionSteps = -1;
    private float mQuantizeMotionPhase = Float.NaN;
    private DifferentialInterpolator mQuantizeMotionInterpolator = null;
    private boolean mNoMovement = false;

    public Motion(MotionWidget motionWidget) {
        setView(motionWidget);
    }

    private float getAdjustedPosition(float f, float[] fArr) {
        float f10 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f11 = this.mStaggerScale;
            if (f11 != 1.0d) {
                float f12 = this.mStaggerOffset;
                if (f < f12) {
                    f = 0.0f;
                }
                if (f > f12 && f < 1.0d) {
                    f = Math.min((f - f12) * f11, 1.0f);
                }
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        float f13 = Float.NaN;
        int i = 0;
        while (i < size) {
            MotionPaths motionPaths = arrayList.get(i);
            i++;
            MotionPaths motionPaths2 = motionPaths;
            Easing easing2 = motionPaths2.mKeyFrameEasing;
            if (easing2 != null) {
                float f14 = motionPaths2.mTime;
                if (f14 < f) {
                    easing = easing2;
                    f10 = f14;
                } else if (Float.isNaN(f13)) {
                    f13 = motionPaths2.mTime;
                }
            }
        }
        if (easing != null) {
            float f15 = (Float.isNaN(f13) ? 1.0f : f13) - f10;
            double d10 = (f - f10) / f15;
            f = (((float) easing.get(d10)) * f15) + f10;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d10);
            }
        }
        return f;
    }

    private static DifferentialInterpolator getInterpolator(int i, String str, int i6) {
        if (i != -1) {
            return null;
        }
        final Easing interpolator = Easing.getInterpolator(str);
        return new DifferentialInterpolator() { // from class: androidx.constraintlayout.core.motion.Motion.1
            float mX;

            @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
            public float getInterpolation(float f) {
                this.mX = f;
                return (float) Easing.this.get(f);
            }

            @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
            public float getVelocity() {
                return (float) Easing.this.getDiff(this.mX);
            }
        };
    }

    private float getPreCycleDistance() {
        float[] fArr = new float[2];
        float f = 1.0f / 99;
        double d10 = 0.0d;
        double d11 = 0.0d;
        int i = 0;
        float f10 = 0.0f;
        while (i < 100) {
            float f11 = i * f;
            double d12 = f11;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f12 = Float.NaN;
            int i6 = 0;
            float f13 = 0.0f;
            while (i6 < size) {
                MotionPaths motionPaths = arrayList.get(i6);
                i6++;
                MotionPaths motionPaths2 = motionPaths;
                float f14 = f;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    float f15 = motionPaths2.mTime;
                    if (f15 < f11) {
                        f13 = f15;
                        easing = easing2;
                    } else if (Float.isNaN(f12)) {
                        f12 = motionPaths2.mTime;
                    }
                }
                f = f14;
            }
            float f16 = f;
            if (easing != null) {
                if (Float.isNaN(f12)) {
                    f12 = 1.0f;
                }
                d12 = (((float) easing.get((f11 - f13) / r17)) * (f12 - f13)) + f13;
            }
            double d13 = d12;
            this.mSpline[0].getPos(d13, this.mInterpolateData);
            int i10 = i;
            this.mStartMotionPath.getCenter(d13, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i10 > 0) {
                f10 += (float) Math.hypot(d11 - fArr[1], d10 - fArr[0]);
            }
            d10 = fArr[0];
            d11 = fArr[1];
            i = i10 + 1;
            f = f16;
        }
        return f10;
    }

    private void insertKey(MotionPaths motionPaths) {
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        MotionPaths motionPaths2 = null;
        int i = 0;
        while (i < size) {
            MotionPaths motionPaths3 = arrayList.get(i);
            i++;
            MotionPaths motionPaths4 = motionPaths3;
            if (motionPaths.mPosition == motionPaths4.mPosition) {
                motionPaths2 = motionPaths4;
            }
        }
        if (motionPaths2 != null) {
            this.mMotionPaths.remove(motionPaths2);
        }
        if (Collections.binarySearch(this.mMotionPaths, motionPaths) == 0) {
            Utils.loge(TAG, " KeyPath position \"" + motionPaths.mPosition + "\" outside of range");
        }
        this.mMotionPaths.add((-r0) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds(this.mView.getX(), this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    private void setupRelative() {
        Motion motion = this.mRelativeMotion;
        if (motion == null) {
            return;
        }
        this.mStartMotionPath.setupRelative(motion, motion.mStartMotionPath);
        MotionPaths motionPaths = this.mEndMotionPath;
        Motion motion2 = this.mRelativeMotion;
        motionPaths.setupRelative(motion2, motion2.mEndMotionPath);
    }

    public void addKey(MotionKey motionKey) {
        this.mKeyList.add(motionKey);
    }

    public void addKeys(ArrayList<MotionKey> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    public void buildBounds(float[] fArr, int i) {
        float f = 1.0f;
        float f10 = 1.0f / (i - 1);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 != null) {
            hashMap2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 != null) {
            hashMap3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            hashMap4.get("translationY");
        }
        int i6 = 0;
        while (i6 < i) {
            float f11 = i6 * f10;
            float f12 = this.mStaggerScale;
            float f13 = 0.0f;
            if (f12 != f) {
                float f14 = this.mStaggerOffset;
                if (f11 < f14) {
                    f11 = 0.0f;
                }
                if (f11 > f14 && f11 < 1.0d) {
                    f11 = Math.min((f11 - f14) * f12, f);
                }
            }
            double d10 = f11;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f15 = Float.NaN;
            int i10 = 0;
            while (i10 < size) {
                MotionPaths motionPaths = arrayList.get(i10);
                i10++;
                MotionPaths motionPaths2 = motionPaths;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    float f16 = motionPaths2.mTime;
                    if (f16 < f11) {
                        easing = easing2;
                        f13 = f16;
                    } else if (Float.isNaN(f15)) {
                        f15 = motionPaths2.mTime;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f15)) {
                    f15 = 1.0f;
                }
                d10 = (((float) easing.get((f11 - f13) / r13)) * (f15 - f13)) + f13;
            }
            this.mSpline[0].getPos(d10, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d10, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i6 * 2);
            i6++;
            f = 1.0f;
        }
    }

    public int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            int i = 0;
            int i6 = 0;
            while (i6 < size) {
                MotionPaths motionPaths = arrayList.get(i6);
                i6++;
                iArr[i] = motionPaths.mMode;
                i++;
            }
        }
        int i10 = 0;
        for (double d10 : timePoints) {
            this.mSpline[0].getPos(d10, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i10);
            i10 += 2;
        }
        return i10 / 2;
    }

    public int buildKeyFrames(float[] fArr, int[] iArr, int[] iArr2) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            int i = 0;
            int i6 = 0;
            while (i6 < size) {
                MotionPaths motionPaths = arrayList.get(i6);
                i6++;
                iArr[i] = motionPaths.mMode;
                i++;
            }
        }
        if (iArr2 != null) {
            ArrayList<MotionPaths> arrayList2 = this.mMotionPaths;
            int size2 = arrayList2.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size2) {
                MotionPaths motionPaths2 = arrayList2.get(i11);
                i11++;
                iArr2[i10] = (int) (motionPaths2.mPosition * 100.0f);
                i10++;
            }
        }
        int i12 = 0;
        for (int i13 = 0; i13 < timePoints.length; i13++) {
            this.mSpline[0].getPos(timePoints[i13], this.mInterpolateData);
            this.mStartMotionPath.getCenter(timePoints[i13], this.mInterpolateVariables, this.mInterpolateData, fArr, i12);
            i12 += 2;
        }
        return i12 / 2;
    }

    public void buildPath(float[] fArr, int i) {
        int i6 = i;
        float f = 1.0f;
        float f10 = 1.0f / (i6 - 1);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        SplineSet splineSet = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator = hashMap3 == null ? null : hashMap3.get("translationX");
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = hashMap4 != null ? hashMap4.get("translationY") : null;
        int i10 = 0;
        while (i10 < i6) {
            float f11 = i10 * f10;
            float f12 = this.mStaggerScale;
            float f13 = 0.0f;
            if (f12 != f) {
                float f14 = this.mStaggerOffset;
                if (f11 < f14) {
                    f11 = 0.0f;
                }
                if (f11 > f14 && f11 < 1.0d) {
                    f11 = Math.min((f11 - f14) * f12, f);
                }
            }
            double d10 = f11;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f15 = Float.NaN;
            int i11 = 0;
            while (i11 < size) {
                MotionPaths motionPaths = arrayList.get(i11);
                i11++;
                MotionPaths motionPaths2 = motionPaths;
                float f16 = f10;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    float f17 = motionPaths2.mTime;
                    if (f17 < f11) {
                        f13 = f17;
                        easing = easing2;
                    } else if (Float.isNaN(f15)) {
                        f15 = motionPaths2.mTime;
                    }
                }
                f10 = f16;
            }
            float f18 = f10;
            if (easing != null) {
                if (Float.isNaN(f15)) {
                    f15 = 1.0f;
                }
                d10 = (((float) easing.get((f11 - f13) / r17)) * (f15 - f13)) + f13;
            }
            this.mSpline[0].getPos(d10, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d10, dArr);
                }
            }
            int i12 = i10 * 2;
            this.mStartMotionPath.getCenter(d10, this.mInterpolateVariables, this.mInterpolateData, fArr, i12);
            if (keyCycleOscillator != null) {
                fArr[i12] = keyCycleOscillator.get(f11) + fArr[i12];
            } else if (splineSet != null) {
                fArr[i12] = splineSet.get(f11) + fArr[i12];
            }
            if (keyCycleOscillator2 != null) {
                int i13 = i12 + 1;
                fArr[i13] = keyCycleOscillator2.get(f11) + fArr[i13];
            } else if (splineSet2 != null) {
                int i14 = i12 + 1;
                fArr[i14] = splineSet2.get(f11) + fArr[i14];
            }
            i10++;
            i6 = i;
            f10 = f18;
            f = 1.0f;
        }
    }

    public void buildRect(float f, float[] fArr, int i) {
        this.mSpline[0].getPos(getAdjustedPosition(f, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i);
    }

    public void buildRectangles(float[] fArr, int i) {
        float f = 1.0f / (i - 1);
        for (int i6 = 0; i6 < i; i6++) {
            this.mSpline[0].getPos(getAdjustedPosition(i6 * f, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i6 * 8);
        }
    }

    public String getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    public int getAttributeValues(String str, float[] fArr, int i) {
        SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i6 = 0; i6 < fArr.length; i6++) {
            fArr[i6] = splineSet.get(i6 / (fArr.length - 1));
        }
        return fArr.length;
    }

    public void getCenter(double d10, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.mSpline[0].getPos(d10, dArr);
        this.mSpline[0].getSlope(d10, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.mStartMotionPath.getCenter(d10, this.mInterpolateVariables, dArr, fArr, dArr2, fArr2);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    public void getDpDt(float f, float f10, float f11, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i = 0;
        if (curveFitArr == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f12 = motionPaths.mX;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f13 = f12 - motionPaths2.mX;
            float f14 = motionPaths.mY - motionPaths2.mY;
            float f15 = motionPaths.mWidth - motionPaths2.mWidth;
            float f16 = (motionPaths.mHeight - motionPaths2.mHeight) + f14;
            fArr[0] = ((f15 + f13) * f10) + ((1.0f - f10) * f13);
            fArr[1] = (f16 * f11) + ((1.0f - f11) * f14);
            return;
        }
        double d10 = adjustedPosition;
        curveFitArr[0].getSlope(d10, this.mInterpolateVelocity);
        this.mSpline[0].getPos(d10, this.mInterpolateData);
        float f17 = this.mVelocity[0];
        while (true) {
            dArr = this.mInterpolateVelocity;
            if (i >= dArr.length) {
                break;
            }
            dArr[i] = dArr[i] * f17;
            i++;
        }
        CurveFit curveFit = this.mArcSpline;
        if (curveFit == null) {
            this.mStartMotionPath.setDpDt(f10, f11, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        double[] dArr2 = this.mInterpolateData;
        if (dArr2.length > 0) {
            curveFit.getPos(d10, dArr2);
            this.mArcSpline.getSlope(d10, this.mInterpolateVelocity);
            this.mStartMotionPath.setDpDt(f10, f11, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        }
    }

    public int getDrawPath() {
        int i = this.mStartMotionPath.mDrawPath;
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            MotionPaths motionPaths = arrayList.get(i6);
            i6++;
            i = Math.max(i, motionPaths.mDrawPath);
        }
        return Math.max(i, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.mHeight;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.mWidth;
    }

    public float getFinalX() {
        return this.mEndMotionPath.mX;
    }

    public float getFinalY() {
        return this.mEndMotionPath.mY;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return 0;
    }

    public MotionPaths getKeyFrame(int i) {
        return this.mMotionPaths.get(i);
    }

    public int getKeyFrameInfo(int i, int[] iArr) {
        float[] fArr = new float[2];
        ArrayList<MotionKey> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i6 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i6 < size) {
            int i12 = i6 + 1;
            MotionKey motionKey = arrayList.get(i6);
            int i13 = motionKey.mType;
            if (i13 == i || i != -1) {
                iArr[i11] = 0;
                iArr[i11 + 1] = i13;
                int i14 = motionKey.mFramePosition;
                iArr[i11 + 2] = i14;
                double d10 = i14 / 100.0f;
                this.mSpline[0].getPos(d10, this.mInterpolateData);
                this.mStartMotionPath.getCenter(d10, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i11 + 3] = Float.floatToIntBits(fArr[0]);
                int i15 = i11 + 4;
                iArr[i15] = Float.floatToIntBits(fArr[1]);
                if (motionKey instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
                    iArr[i11 + 5] = motionKeyPosition.mPositionType;
                    iArr[i11 + 6] = Float.floatToIntBits(motionKeyPosition.mPercentX);
                    i15 = i11 + 7;
                    iArr[i15] = Float.floatToIntBits(motionKeyPosition.mPercentY);
                }
                int i16 = i15 + 1;
                iArr[i11] = i16 - i11;
                i10++;
                i11 = i16;
            }
            i6 = i12;
        }
        return i10;
    }

    public float getKeyFrameParameter(int i, float f, float f10) {
        MotionPaths motionPaths = this.mEndMotionPath;
        float f11 = motionPaths.mX;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f12 = motionPaths2.mX;
        float f13 = f11 - f12;
        float f14 = motionPaths.mY;
        float f15 = motionPaths2.mY;
        float f16 = f14 - f15;
        float f17 = (motionPaths2.mWidth / 2.0f) + f12;
        float f18 = (motionPaths2.mHeight / 2.0f) + f15;
        float hypot = (float) Math.hypot(f13, f16);
        if (hypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f19 = f - f17;
        float f20 = f10 - f18;
        if (((float) Math.hypot(f19, f20)) == 0.0f) {
            return 0.0f;
        }
        float f21 = (f20 * f16) + (f19 * f13);
        if (i == 0) {
            return f21 / hypot;
        }
        if (i == 1) {
            return (float) Math.sqrt((hypot * hypot) - (f21 * f21));
        }
        if (i == 2) {
            return f19 / f13;
        }
        if (i == 3) {
            return f20 / f13;
        }
        if (i == 4) {
            return f19 / f16;
        }
        if (i != 5) {
            return 0.0f;
        }
        return f20 / f16;
    }

    public int getKeyFramePositions(int[] iArr, float[] fArr) {
        ArrayList<MotionKey> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i = 0;
        int i6 = 0;
        int i10 = 0;
        while (i6 < size) {
            int i11 = i6 + 1;
            MotionKey motionKey = arrayList.get(i6);
            int i12 = motionKey.mFramePosition;
            iArr[i] = (motionKey.mType * 1000) + i12;
            double d10 = i12 / 100.0f;
            this.mSpline[0].getPos(d10, this.mInterpolateData);
            this.mStartMotionPath.getCenter(d10, this.mInterpolateVariables, this.mInterpolateData, fArr, i10);
            i10 += 2;
            i6 = i11;
            i++;
        }
        return i;
    }

    public float getMotionStagger() {
        return this.mMotionStagger;
    }

    public double[] getPos(double d10) {
        this.mSpline[0].getPos(d10, this.mInterpolateData);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                curveFit.getPos(d10, dArr);
            }
        }
        return this.mInterpolateData;
    }

    public MotionKeyPosition getPositionKeyframe(int i, int i6, float f, float f10) {
        int i10;
        int i11;
        float f11;
        float f12;
        FloatRect floatRect = new FloatRect();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f13 = motionPaths.mX;
        floatRect.left = f13;
        float f14 = motionPaths.mY;
        floatRect.top = f14;
        floatRect.right = f13 + motionPaths.mWidth;
        floatRect.bottom = f14 + motionPaths.mHeight;
        FloatRect floatRect2 = new FloatRect();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f15 = motionPaths2.mX;
        floatRect2.left = f15;
        float f16 = motionPaths2.mY;
        floatRect2.top = f16;
        floatRect2.right = f15 + motionPaths2.mWidth;
        floatRect2.bottom = f16 + motionPaths2.mHeight;
        ArrayList<MotionKey> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            int i13 = i12 + 1;
            MotionKey motionKey = arrayList.get(i12);
            if (motionKey instanceof MotionKeyPosition) {
                MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
                i10 = i;
                i11 = i6;
                f11 = f;
                f12 = f10;
                if (motionKeyPosition.intersects(i10, i11, floatRect, floatRect2, f11, f12)) {
                    return motionKeyPosition;
                }
            } else {
                i10 = i;
                i11 = i6;
                f11 = f;
                f12 = f10;
            }
            i = i10;
            i6 = i11;
            f = f11;
            f10 = f12;
            i12 = i13;
        }
        return null;
    }

    public void getPostLayoutDvDp(float f, int i, int i6, float f10, float f11, float[] fArr) {
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        SplineSet splineSet = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
        SplineSet splineSet3 = hashMap3 == null ? null : hashMap3.get("rotationZ");
        HashMap<String, SplineSet> hashMap4 = this.mAttributesMap;
        SplineSet splineSet4 = hashMap4 == null ? null : hashMap4.get("scaleX");
        HashMap<String, SplineSet> hashMap5 = this.mAttributesMap;
        SplineSet splineSet5 = hashMap5 == null ? null : hashMap5.get("scaleY");
        HashMap<String, KeyCycleOscillator> hashMap6 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator = hashMap6 == null ? null : hashMap6.get("translationX");
        HashMap<String, KeyCycleOscillator> hashMap7 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = hashMap7 == null ? null : hashMap7.get("translationY");
        HashMap<String, KeyCycleOscillator> hashMap8 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator3 = hashMap8 == null ? null : hashMap8.get("rotationZ");
        HashMap<String, KeyCycleOscillator> hashMap9 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator4 = hashMap9 == null ? null : hashMap9.get("scaleX");
        HashMap<String, KeyCycleOscillator> hashMap10 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator5 = hashMap10 != null ? hashMap10.get("scaleY") : null;
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d10 = adjustedPosition;
                curveFit.getPos(d10, dArr);
                this.mArcSpline.getSlope(d10, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f10, f11, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f10, f11, i, i6, fArr);
            return;
        }
        int i10 = 0;
        if (this.mSpline == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f12 = motionPaths.mX;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f13 = f12 - motionPaths2.mX;
            float f14 = motionPaths.mY - motionPaths2.mY;
            float f15 = motionPaths.mWidth - motionPaths2.mWidth;
            float f16 = f14 + (motionPaths.mHeight - motionPaths2.mHeight);
            fArr[0] = ((f15 + f13) * f10) + ((1.0f - f10) * f13);
            fArr[1] = (f16 * f11) + ((1.0f - f11) * f14);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
            velocityMatrix.applyTransform(f10, f11, i, i6, fArr);
            return;
        }
        double adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
        this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
        this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
        float f17 = this.mVelocity[0];
        while (true) {
            double[] dArr2 = this.mInterpolateVelocity;
            if (i10 >= dArr2.length) {
                this.mStartMotionPath.setDpDt(f10, f11, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                velocityMatrix.applyTransform(f10, f11, i, i6, fArr);
                return;
            } else {
                dArr2[i10] = dArr2[i10] * f17;
                i10++;
            }
        }
    }

    public float getStartHeight() {
        return this.mStartMotionPath.mHeight;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.mWidth;
    }

    public float getStartX() {
        return this.mStartMotionPath.mX;
    }

    public float getStartY() {
        return this.mStartMotionPath.mY;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public MotionWidget getView() {
        return this.mView;
    }

    public boolean interpolate(MotionWidget motionWidget, float f, long j, KeyCache keyCache) {
        MotionWidget motionWidget2 = motionWidget;
        float adjustedPosition = getAdjustedPosition(f, null);
        int i = this.mQuantizeMotionSteps;
        if (i != -1) {
            float f10 = 1.0f / i;
            float floor = ((float) Math.floor(adjustedPosition / f10)) * f10;
            float f11 = (adjustedPosition % f10) / f10;
            if (!Float.isNaN(this.mQuantizeMotionPhase)) {
                f11 = (f11 + this.mQuantizeMotionPhase) % 1.0f;
            }
            DifferentialInterpolator differentialInterpolator = this.mQuantizeMotionInterpolator;
            adjustedPosition = ((differentialInterpolator != null ? differentialInterpolator.getInterpolation(f11) : ((double) f11) > 0.5d ? 1.0f : 0.0f) * f10) + floor;
        }
        float f12 = adjustedPosition;
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            Iterator<SplineSet> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().setProperty(motionWidget2, f12);
            }
        }
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d10 = f12;
            curveFitArr[0].getPos(d10, this.mInterpolateData);
            this.mSpline[0].getSlope(d10, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d10, dArr);
                    this.mArcSpline.getSlope(d10, this.mInterpolateVelocity);
                }
            }
            if (!this.mNoMovement) {
                this.mStartMotionPath.setView(f12, motionWidget2, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
                f12 = f12;
                motionWidget2 = motionWidget2;
            }
            if (this.mTransformPivotTarget != -1) {
                if (this.mTransformPivotView == null) {
                    this.mTransformPivotView = motionWidget2.getParent().findViewById(this.mTransformPivotTarget);
                }
                if (this.mTransformPivotView != null) {
                    float bottom = (this.mTransformPivotView.getBottom() + r1.getTop()) / 2.0f;
                    float right = (this.mTransformPivotView.getRight() + this.mTransformPivotView.getLeft()) / 2.0f;
                    if (motionWidget2.getRight() - motionWidget2.getLeft() > 0 && motionWidget2.getBottom() - motionWidget2.getTop() > 0) {
                        motionWidget2.setPivotX(right - motionWidget2.getLeft());
                        motionWidget2.setPivotY(bottom - motionWidget2.getTop());
                    }
                }
            }
            int i6 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i6 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i6].getPos(d10, this.mValuesBuff);
                this.mStartMotionPath.mCustomAttributes.get(this.mAttributeNames[i6 - 1]).setInterpolatedValue(motionWidget2, this.mValuesBuff);
                i6++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (f12 <= 0.0f) {
                    motionWidget2.setVisibility(motionConstrainedPoint.mVisibility);
                } else {
                    MotionConstrainedPoint motionConstrainedPoint2 = this.mEndPoint;
                    if (f12 >= 1.0f) {
                        motionWidget2.setVisibility(motionConstrainedPoint2.mVisibility);
                    } else if (motionConstrainedPoint2.mVisibility != motionConstrainedPoint.mVisibility) {
                        motionWidget2.setVisibility(4);
                    }
                }
            }
            if (this.mKeyTriggers != null) {
                int i10 = 0;
                while (true) {
                    MotionKeyTrigger[] motionKeyTriggerArr = this.mKeyTriggers;
                    if (i10 >= motionKeyTriggerArr.length) {
                        break;
                    }
                    motionKeyTriggerArr[i10].conditionallyFire(f12, motionWidget2);
                    i10++;
                }
            }
        } else {
            MotionPaths motionPaths = this.mStartMotionPath;
            float f13 = motionPaths.mX;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float f14 = x.f(motionPaths2.mX, f13, f12, f13);
            float f15 = motionPaths.mY;
            float f16 = x.f(motionPaths2.mY, f15, f12, f15);
            float f17 = motionPaths.mWidth;
            float f18 = x.f(motionPaths2.mWidth, f17, f12, f17);
            float f19 = motionPaths.mHeight;
            float f20 = f14 + 0.5f;
            float f21 = f16 + 0.5f;
            motionWidget2.layout((int) f20, (int) f21, (int) (f20 + f18), (int) (f21 + x.f(motionPaths2.mHeight, f19, f12, f19)));
        }
        HashMap<String, KeyCycleOscillator> hashMap2 = this.mCycleMap;
        if (hashMap2 != null) {
            for (KeyCycleOscillator keyCycleOscillator : hashMap2.values()) {
                if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                    double[] dArr2 = this.mInterpolateVelocity;
                    ((KeyCycleOscillator.PathRotateSet) keyCycleOscillator).setPathRotate(motionWidget2, f12, dArr2[0], dArr2[1]);
                } else {
                    keyCycleOscillator.setProperty(motionWidget2, f12);
                }
            }
        }
        return false;
    }

    public String name() {
        return this.mView.getName();
    }

    public void positionKeyframe(MotionWidget motionWidget, MotionKeyPosition motionKeyPosition, float f, float f10, String[] strArr, float[] fArr) {
        FloatRect floatRect = new FloatRect();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f11 = motionPaths.mX;
        floatRect.left = f11;
        float f12 = motionPaths.mY;
        floatRect.top = f12;
        floatRect.right = f11 + motionPaths.mWidth;
        floatRect.bottom = f12 + motionPaths.mHeight;
        FloatRect floatRect2 = new FloatRect();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f13 = motionPaths2.mX;
        floatRect2.left = f13;
        float f14 = motionPaths2.mY;
        floatRect2.top = f14;
        floatRect2.right = f13 + motionPaths2.mWidth;
        floatRect2.bottom = f14 + motionPaths2.mHeight;
        motionKeyPosition.positionAttributes(motionWidget, floatRect, floatRect2, f, f10, strArr, fArr);
    }

    public void rotate(Rect rect, Rect rect2, int i, int i6, int i10) {
        if (i == 1) {
            int i11 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i10 - ((rect.height() + i11) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i == 2) {
            int i12 = rect.left + rect.right;
            rect2.left = i6 - ((rect.width() + (rect.top + rect.bottom)) / 2);
            rect2.top = (i12 - rect.height()) / 2;
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i == 3) {
            int i13 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i13 / 2);
            rect2.top = i10 - ((rect.height() + i13) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i != 4) {
            return;
        }
        int i14 = rect.left + rect.right;
        rect2.left = i6 - ((rect.width() + (rect.bottom + rect.top)) / 2);
        rect2.top = (i14 - rect.height()) / 2;
        rect2.right = rect.width() + rect2.left;
        rect2.bottom = rect.height() + rect2.top;
    }

    public void setBothStates(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        this.mNoMovement = true;
        motionPaths.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mEndMotionPath.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mStartPoint.setState(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setDrawPath(int i) {
        this.mStartMotionPath.mDrawPath = i;
    }

    public void setEnd(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mEndMotionPath;
        motionPaths.mTime = 1.0f;
        motionPaths.mPosition = 1.0f;
        readView(motionPaths);
        this.mEndMotionPath.setBounds(motionWidget.getLeft(), motionWidget.getTop(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mEndMotionPath.applyParameters(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setIdString(String str) {
        this.mId = str;
        this.mStartMotionPath.mId = str;
    }

    public void setPathMotionArc(int i) {
        this.mPathMotionArc = i;
    }

    public void setStaggerOffset(float f) {
        this.mStaggerOffset = f;
    }

    public void setStaggerScale(float f) {
        this.mStaggerScale = f;
    }

    public void setStart(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        motionPaths.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mStartMotionPath.applyParameters(motionWidget);
        this.mStartPoint.setState(motionWidget);
        TypedBundle motionProperties = motionWidget.getWidgetFrame().getMotionProperties();
        if (motionProperties != null) {
            motionProperties.applyDelta(this);
        }
    }

    public void setStartState(ViewState viewState, MotionWidget motionWidget, int i, int i6, int i10) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        Rect rect = new Rect();
        if (i == 1) {
            int i11 = viewState.left + viewState.right;
            rect.left = ((viewState.top + viewState.bottom) - viewState.width()) / 2;
            rect.top = i6 - ((viewState.height() + i11) / 2);
            rect.right = viewState.width() + rect.left;
            rect.bottom = viewState.height() + rect.top;
        } else if (i == 2) {
            int i12 = viewState.left + viewState.right;
            rect.left = i10 - ((viewState.width() + (viewState.top + viewState.bottom)) / 2);
            rect.top = (i12 - viewState.height()) / 2;
            rect.right = viewState.width() + rect.left;
            rect.bottom = viewState.height() + rect.top;
        }
        this.mStartMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        this.mStartPoint.setState(rect, motionWidget, i, viewState.rotation);
    }

    public void setTransformPivotTarget(int i) {
        this.mTransformPivotTarget = i;
        this.mTransformPivotView = null;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (705 == i || 611 == i) {
            this.mQuantizeMotionInterpolator = getInterpolator(-1, str, 0);
            return true;
        }
        if (605 != i) {
            return false;
        }
        this.mStartMotionPath.mAnimateRelativeTo = str;
        return true;
    }

    public void setView(MotionWidget motionWidget) {
        this.mView = motionWidget;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setup(int i, int i6, float f, long j) {
        ArrayList arrayList;
        HashSet<String> hashSet;
        HashSet<String> hashSet2;
        int i10;
        String[] strArr;
        int i11;
        int i12;
        CustomVariable customVariable;
        SplineSet makeSpline;
        CustomVariable customVariable2;
        Integer num;
        HashSet<String> hashSet3;
        HashSet<String> hashSet4;
        int i13;
        SplineSet makeSpline2;
        CustomVariable customVariable3;
        new HashSet();
        HashSet<String> hashSet5 = new HashSet<>();
        HashSet<String> hashSet6 = new HashSet<>();
        HashSet<String> hashSet7 = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        setupRelative();
        int i14 = this.mPathMotionArc;
        if (i14 != -1) {
            MotionPaths motionPaths = this.mStartMotionPath;
            if (motionPaths.mPathMotionArc == -1) {
                motionPaths.mPathMotionArc = i14;
            }
        }
        this.mStartPoint.different(this.mEndPoint, hashSet6);
        ArrayList<MotionKey> arrayList2 = this.mKeyList;
        int i15 = 0;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i16 = 0;
            arrayList = null;
            while (i16 < size) {
                MotionKey motionKey = arrayList2.get(i16);
                i16++;
                MotionKey motionKey2 = motionKey;
                if (motionKey2 instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey2;
                    insertKey(new MotionPaths(i, i6, motionKeyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i17 = motionKeyPosition.mCurveFit;
                    if (i17 != -1) {
                        this.mCurveFitType = i17;
                    }
                } else if (motionKey2 instanceof MotionKeyCycle) {
                    motionKey2.getAttributeNames(hashSet7);
                } else if (motionKey2 instanceof MotionKeyTimeCycle) {
                    motionKey2.getAttributeNames(hashSet5);
                } else if (motionKey2 instanceof MotionKeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((MotionKeyTrigger) motionKey2);
                } else {
                    motionKey2.setInterpolation(hashMap);
                    motionKey2.getAttributeNames(hashSet6);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mKeyTriggers = (MotionKeyTrigger[]) arrayList.toArray(new MotionKeyTrigger[0]);
        }
        int i18 = 1;
        if (hashSet6.isEmpty()) {
            hashSet = hashSet5;
            hashSet2 = hashSet7;
            i10 = 1;
        } else {
            this.mAttributesMap = new HashMap<>();
            Iterator<String> it = hashSet6.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.startsWith("CUSTOM,")) {
                    KeyFrameArray.CustomVar customVar = new KeyFrameArray.CustomVar();
                    String str = next.split(",")[i18];
                    i13 = i18;
                    ArrayList<MotionKey> arrayList3 = this.mKeyList;
                    int size2 = arrayList3.size();
                    while (i15 < size2) {
                        MotionKey motionKey3 = arrayList3.get(i15);
                        i15++;
                        HashSet<String> hashSet8 = hashSet5;
                        MotionKey motionKey4 = motionKey3;
                        HashSet<String> hashSet9 = hashSet7;
                        HashMap<String, CustomVariable> hashMap2 = motionKey4.mCustom;
                        if (hashMap2 != null && (customVariable3 = hashMap2.get(str)) != null) {
                            customVar.append(motionKey4.mFramePosition, customVariable3);
                        }
                        hashSet7 = hashSet9;
                        hashSet5 = hashSet8;
                    }
                    hashSet3 = hashSet5;
                    hashSet4 = hashSet7;
                    makeSpline2 = SplineSet.makeCustomSplineSet(next, customVar);
                } else {
                    hashSet3 = hashSet5;
                    hashSet4 = hashSet7;
                    i13 = i18;
                    makeSpline2 = SplineSet.makeSpline(next, j);
                }
                if (makeSpline2 != null) {
                    makeSpline2.setType(next);
                    this.mAttributesMap.put(next, makeSpline2);
                }
                i18 = i13;
                hashSet7 = hashSet4;
                hashSet5 = hashSet3;
                i15 = 0;
            }
            hashSet = hashSet5;
            hashSet2 = hashSet7;
            i10 = i18;
            ArrayList<MotionKey> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                int size3 = arrayList4.size();
                int i19 = 0;
                while (i19 < size3) {
                    MotionKey motionKey5 = arrayList4.get(i19);
                    i19++;
                    MotionKey motionKey6 = motionKey5;
                    if (motionKey6 instanceof MotionKeyAttributes) {
                        motionKey6.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str2 : this.mAttributesMap.keySet()) {
                int intValue = (!hashMap.containsKey(str2) || (num = hashMap.get(str2)) == null) ? 0 : num.intValue();
                SplineSet splineSet = this.mAttributesMap.get(str2);
                if (splineSet != null) {
                    splineSet.setup(intValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            Iterator<String> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (!this.mTimeCycleAttributesMap.containsKey(next2)) {
                    if (next2.startsWith("CUSTOM,")) {
                        KeyFrameArray.CustomVar customVar2 = new KeyFrameArray.CustomVar();
                        String str3 = next2.split(",")[i10];
                        ArrayList<MotionKey> arrayList5 = this.mKeyList;
                        int size4 = arrayList5.size();
                        int i20 = 0;
                        while (i20 < size4) {
                            MotionKey motionKey7 = arrayList5.get(i20);
                            i20++;
                            MotionKey motionKey8 = motionKey7;
                            HashMap<String, CustomVariable> hashMap3 = motionKey8.mCustom;
                            if (hashMap3 != null && (customVariable2 = hashMap3.get(str3)) != null) {
                                customVar2.append(motionKey8.mFramePosition, customVariable2);
                            }
                        }
                        makeSpline = SplineSet.makeCustomSplineSet(next2, customVar2);
                    } else {
                        makeSpline = SplineSet.makeSpline(next2, j);
                    }
                    if (makeSpline != null) {
                        makeSpline.setType(next2);
                    }
                }
            }
            ArrayList<MotionKey> arrayList6 = this.mKeyList;
            if (arrayList6 != null) {
                int size5 = arrayList6.size();
                int i21 = 0;
                while (i21 < size5) {
                    MotionKey motionKey9 = arrayList6.get(i21);
                    i21++;
                    MotionKey motionKey10 = motionKey9;
                    if (motionKey10 instanceof MotionKeyTimeCycle) {
                        ((MotionKeyTimeCycle) motionKey10).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String str4 : this.mTimeCycleAttributesMap.keySet()) {
                this.mTimeCycleAttributesMap.get(str4).setup(hashMap.containsKey(str4) ? hashMap.get(str4).intValue() : 0);
            }
        }
        int size6 = this.mMotionPaths.size();
        int i22 = size6 + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[i22];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[size6 + 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == MotionKey.UNSET) {
            this.mCurveFitType = 0;
        }
        ArrayList<MotionPaths> arrayList7 = this.mMotionPaths;
        int size7 = arrayList7.size();
        int i23 = i10;
        int i24 = 0;
        while (i24 < size7) {
            MotionPaths motionPaths2 = arrayList7.get(i24);
            i24++;
            motionPathsArr[i23] = motionPaths2;
            i23++;
        }
        HashSet hashSet10 = new HashSet();
        for (String str5 : this.mEndMotionPath.mCustomAttributes.keySet()) {
            if (this.mStartMotionPath.mCustomAttributes.containsKey(str5)) {
                if (!hashSet6.contains("CUSTOM," + str5)) {
                    hashSet10.add(str5);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet10.toArray(new String[0]);
        this.mAttributeNames = strArr2;
        this.mAttributeInterpolatorCount = new int[strArr2.length];
        int i25 = 0;
        while (true) {
            strArr = this.mAttributeNames;
            if (i25 >= strArr.length) {
                break;
            }
            String str6 = strArr[i25];
            this.mAttributeInterpolatorCount[i25] = 0;
            int i26 = 0;
            while (true) {
                if (i26 >= i22) {
                    break;
                }
                if (motionPathsArr[i26].mCustomAttributes.containsKey(str6) && (customVariable = motionPathsArr[i26].mCustomAttributes.get(str6)) != null) {
                    int[] iArr = this.mAttributeInterpolatorCount;
                    iArr[i25] = customVariable.numberOfInterpolatedValues() + iArr[i25];
                    break;
                }
                i26++;
            }
            i25++;
        }
        boolean z9 = motionPathsArr[0].mPathMotionArc != -1 ? i10 : 0;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i27 = i10; i27 < i22; i27++) {
            motionPathsArr[i27].different(motionPathsArr[i27 - 1], zArr, this.mAttributeNames, z9);
        }
        int i28 = 0;
        for (int i29 = i10; i29 < length; i29++) {
            if (zArr[i29]) {
                i28++;
            }
        }
        this.mInterpolateVariables = new int[i28];
        int i30 = 2;
        int max = Math.max(2, i28);
        this.mInterpolateData = new double[max];
        this.mInterpolateVelocity = new double[max];
        int i31 = 0;
        for (int i32 = i10; i32 < length; i32++) {
            if (zArr[i32]) {
                this.mInterpolateVariables[i31] = i32;
                i31++;
            }
        }
        int[] iArr2 = new int[2];
        iArr2[i10] = this.mInterpolateVariables.length;
        iArr2[0] = i22;
        Class cls = Double.TYPE;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls, iArr2);
        double[] dArr2 = new double[i22];
        for (int i33 = 0; i33 < i22; i33++) {
            motionPathsArr[i33].fillStandard(dArr[i33], this.mInterpolateVariables);
            dArr2[i33] = motionPathsArr[i33].mTime;
        }
        int i34 = 0;
        while (true) {
            int[] iArr3 = this.mInterpolateVariables;
            if (i34 >= iArr3.length) {
                break;
            }
            if (iArr3[i34] < MotionPaths.sNames.length) {
                String n10 = x.n(new StringBuilder(), MotionPaths.sNames[this.mInterpolateVariables[i34]], " [");
                for (int i35 = 0; i35 < i22; i35++) {
                    StringBuilder t9 = x.t(n10);
                    t9.append(dArr[i35][i34]);
                    n10 = t9.toString();
                }
            }
            i34++;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i36 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i36 >= strArr3.length) {
                break;
            }
            String str7 = strArr3[i36];
            int i37 = 0;
            int i38 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i37 < i22) {
                if (motionPathsArr[i37].hasCustomData(str7)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i22];
                        int[] iArr4 = new int[i30];
                        iArr4[i10] = motionPathsArr[i37].getCustomDataCount(str7);
                        i12 = 0;
                        iArr4[0] = i22;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) cls, iArr4);
                    } else {
                        i12 = 0;
                    }
                    MotionPaths motionPaths3 = motionPathsArr[i37];
                    i11 = i36;
                    dArr3[i38] = motionPaths3.mTime;
                    motionPaths3.getCustomData(str7, dArr4[i38], i12);
                    i38++;
                } else {
                    i11 = i36;
                }
                i37++;
                i36 = i11;
                i30 = 2;
            }
            int i39 = i36 + 1;
            this.mSpline[i39] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i38), (double[][]) Arrays.copyOf(dArr4, i38));
            i36 = i39;
            i30 = 2;
        }
        int i40 = 0;
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != -1) {
            int[] iArr5 = new int[i22];
            double[] dArr5 = new double[i22];
            int[] iArr6 = new int[2];
            iArr6[i10] = 2;
            iArr6[0] = i22;
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) cls, iArr6);
            for (int i41 = 0; i41 < i22; i41++) {
                iArr5[i41] = motionPathsArr[i41].mPathMotionArc;
                dArr5[i41] = r6.mTime;
                double[] dArr7 = dArr6[i41];
                dArr7[0] = r6.mX;
                dArr7[i10] = r6.mY;
            }
            i40 = 0;
            this.mArcSpline = CurveFit.getArc(iArr5, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator<String> it3 = hashSet2.iterator();
            float f10 = Float.NaN;
            while (it3.hasNext()) {
                String next3 = it3.next();
                KeyCycleOscillator makeWidgetCycle = KeyCycleOscillator.makeWidgetCycle(next3);
                if (makeWidgetCycle != null) {
                    if (makeWidgetCycle.variesByPath() && Float.isNaN(f10)) {
                        f10 = getPreCycleDistance();
                    }
                    makeWidgetCycle.setType(next3);
                    this.mCycleMap.put(next3, makeWidgetCycle);
                }
            }
            ArrayList<MotionKey> arrayList8 = this.mKeyList;
            int size8 = arrayList8.size();
            int i42 = i40;
            while (i42 < size8) {
                MotionKey motionKey11 = arrayList8.get(i42);
                i42++;
                MotionKey motionKey12 = motionKey11;
                if (motionKey12 instanceof MotionKeyCycle) {
                    ((MotionKeyCycle) motionKey12).addCycleValues(this.mCycleMap);
                }
            }
            Iterator<KeyCycleOscillator> it4 = this.mCycleMap.values().iterator();
            while (it4.hasNext()) {
                it4.next().setup(f10);
            }
        }
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.mX + " y: " + this.mStartMotionPath.mY + " end: x: " + this.mEndMotionPath.mX + " y: " + this.mEndMotionPath.mY;
    }

    public void endTrigger(boolean z9) {
    }

    public void setupRelative(Motion motion) {
        this.mRelativeMotion = motion;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i6) {
        if (i == 509) {
            setPathMotionArc(i6);
            return true;
        }
        if (i != 610) {
            return i == 704;
        }
        this.mQuantizeMotionSteps = i6;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (602 == i) {
            this.mQuantizeMotionPhase = f;
            return true;
        }
        if (600 != i) {
            return false;
        }
        this.mMotionStagger = f;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, boolean z9) {
        return false;
    }
}
