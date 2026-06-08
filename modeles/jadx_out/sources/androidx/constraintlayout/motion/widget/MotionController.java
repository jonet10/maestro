package androidx.constraintlayout.motion.widget;

import a4.x;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.motion.utils.CustomSupport;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class MotionController {
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
    private HashMap<String, ViewSpline> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private HashMap<String, ViewOscillator> mCycleMap;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private KeyTrigger[] mKeyTriggers;
    private boolean mNoMovement;
    private int mPathMotionArc;
    private Interpolator mQuantizeMotionInterpolator;
    private float mQuantizeMotionPhase;
    private int mQuantizeMotionSteps;
    private CurveFit[] mSpline;
    private HashMap<String, ViewTimeCycle> mTimeCycleAttributesMap;
    private int mTransformPivotTarget;
    private View mTransformPivotView;
    View mView;
    Rect mTempRect = new Rect();
    boolean mForceMeasure = false;
    private int mCurveFitType = -1;
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
    private ArrayList<Key> mKeyList = new ArrayList<>();

    public MotionController(View view) {
        int i = Key.UNSET;
        this.mPathMotionArc = i;
        this.mTransformPivotTarget = i;
        this.mTransformPivotView = null;
        this.mQuantizeMotionSteps = i;
        this.mQuantizeMotionPhase = Float.NaN;
        this.mQuantizeMotionInterpolator = null;
        this.mNoMovement = false;
        setView(view);
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

    private static Interpolator getInterpolator(Context context, int i, String str, int i6) {
        if (i == -2) {
            return AnimationUtils.loadInterpolator(context, i6);
        }
        if (i == -1) {
            final Easing interpolator = Easing.getInterpolator(str);
            return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionController.1
                @Override // android.animation.TimeInterpolator
                public float getInterpolation(float f) {
                    return (float) Easing.this.get(f);
                }
            };
        }
        if (i == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i == 1) {
            return new AccelerateInterpolator();
        }
        if (i == 2) {
            return new DecelerateInterpolator();
        }
        if (i == 4) {
            return new BounceInterpolator();
        }
        if (i != 5) {
            return null;
        }
        return new OvershootInterpolator();
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
        if (Collections.binarySearch(this.mMotionPaths, motionPaths) == 0) {
            Log.e(TAG, " KeyPath position \"" + motionPaths.mPosition + "\" outside of range");
        }
        this.mMotionPaths.add((-r0) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(Key key) {
        this.mKeyList.add(key);
    }

    public void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    public void buildBounds(float[] fArr, int i) {
        float f = 1.0f;
        float f10 = 1.0f / (i - 1);
        HashMap<String, ViewSpline> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            hashMap.get("translationX");
        }
        HashMap<String, ViewSpline> hashMap2 = this.mAttributesMap;
        if (hashMap2 != null) {
            hashMap2.get("translationY");
        }
        HashMap<String, ViewOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 != null) {
            hashMap3.get("translationX");
        }
        HashMap<String, ViewOscillator> hashMap4 = this.mCycleMap;
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

    public int buildKeyFrames(float[] fArr, int[] iArr) {
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
        for (int i11 = 0; i11 < timePoints.length; i11++) {
            this.mSpline[0].getPos(timePoints[i11], this.mInterpolateData);
            this.mStartMotionPath.getCenter(timePoints[i11], this.mInterpolateVariables, this.mInterpolateData, fArr, i10);
            i10 += 2;
        }
        return i10 / 2;
    }

    public void buildPath(float[] fArr, int i) {
        int i6 = i;
        float f = 1.0f;
        float f10 = 1.0f / (i6 - 1);
        HashMap<String, ViewSpline> hashMap = this.mAttributesMap;
        ViewSpline viewSpline = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, ViewSpline> hashMap2 = this.mAttributesMap;
        ViewSpline viewSpline2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, ViewOscillator> hashMap3 = this.mCycleMap;
        ViewOscillator viewOscillator = hashMap3 == null ? null : hashMap3.get("translationX");
        HashMap<String, ViewOscillator> hashMap4 = this.mCycleMap;
        ViewOscillator viewOscillator2 = hashMap4 != null ? hashMap4.get("translationY") : null;
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
            if (viewOscillator != null) {
                fArr[i12] = viewOscillator.get(f11) + fArr[i12];
            } else if (viewSpline != null) {
                fArr[i12] = viewSpline.get(f11) + fArr[i12];
            }
            if (viewOscillator2 != null) {
                int i13 = i12 + 1;
                fArr[i13] = viewOscillator2.get(f11) + fArr[i13];
            } else if (viewSpline2 != null) {
                int i14 = i12 + 1;
                fArr[i14] = viewSpline2.get(f11) + fArr[i14];
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

    public void endTrigger(boolean z9) {
        if (!"button".equals(Debug.getName(this.mView)) || this.mKeyTriggers == null) {
            return;
        }
        int i = 0;
        while (true) {
            KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
            if (i >= keyTriggerArr.length) {
                return;
            }
            keyTriggerArr[i].conditionallyFire(z9 ? -100.0f : 100.0f, this.mView);
            i++;
        }
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    public int getAttributeValues(String str, float[] fArr, int i) {
        ViewSpline viewSpline = this.mAttributesMap.get(str);
        if (viewSpline == null) {
            return -1;
        }
        for (int i6 = 0; i6 < fArr.length; i6++) {
            fArr[i6] = viewSpline.get(i6 / (fArr.length - 1));
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

    public MotionPaths getKeyFrame(int i) {
        return this.mMotionPaths.get(i);
    }

    public int getKeyFrameInfo(int i, int[] iArr) {
        float[] fArr = new float[2];
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i6 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i6 < size) {
            int i12 = i6 + 1;
            Key key = arrayList.get(i6);
            int i13 = key.mType;
            if (i13 == i || i != -1) {
                iArr[i11] = 0;
                iArr[i11 + 1] = i13;
                int i14 = key.mFramePosition;
                iArr[i11 + 2] = i14;
                double d10 = i14 / 100.0f;
                this.mSpline[0].getPos(d10, this.mInterpolateData);
                this.mStartMotionPath.getCenter(d10, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i11 + 3] = Float.floatToIntBits(fArr[0]);
                int i15 = i11 + 4;
                iArr[i15] = Float.floatToIntBits(fArr[1]);
                if (key instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) key;
                    iArr[i11 + 5] = keyPosition.mPositionType;
                    iArr[i11 + 6] = Float.floatToIntBits(keyPosition.mPercentX);
                    i15 = i11 + 7;
                    iArr[i15] = Float.floatToIntBits(keyPosition.mPercentY);
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
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i = 0;
        int i6 = 0;
        int i10 = 0;
        while (i6 < size) {
            int i11 = i6 + 1;
            Key key = arrayList.get(i6);
            int i12 = key.mFramePosition;
            iArr[i] = (key.mType * 1000) + i12;
            double d10 = i12 / 100.0f;
            this.mSpline[0].getPos(d10, this.mInterpolateData);
            this.mStartMotionPath.getCenter(d10, this.mInterpolateVariables, this.mInterpolateData, fArr, i10);
            i10 += 2;
            i6 = i11;
            i++;
        }
        return i;
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

    public KeyPositionBase getPositionKeyframe(int i, int i6, float f, float f10) {
        int i10;
        int i11;
        float f11;
        float f12;
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f13 = motionPaths.mX;
        rectF.left = f13;
        float f14 = motionPaths.mY;
        rectF.top = f14;
        rectF.right = f13 + motionPaths.mWidth;
        rectF.bottom = f14 + motionPaths.mHeight;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f15 = motionPaths2.mX;
        rectF2.left = f15;
        float f16 = motionPaths2.mY;
        rectF2.top = f16;
        rectF2.right = f15 + motionPaths2.mWidth;
        rectF2.bottom = f16 + motionPaths2.mHeight;
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            int i13 = i12 + 1;
            Key key = arrayList.get(i12);
            if (key instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) key;
                i10 = i;
                i11 = i6;
                f11 = f;
                f12 = f10;
                if (keyPositionBase.intersects(i10, i11, rectF, rectF2, f11, f12)) {
                    return keyPositionBase;
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
        HashMap<String, ViewSpline> hashMap = this.mAttributesMap;
        ViewSpline viewSpline = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, ViewSpline> hashMap2 = this.mAttributesMap;
        ViewSpline viewSpline2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, ViewSpline> hashMap3 = this.mAttributesMap;
        ViewSpline viewSpline3 = hashMap3 == null ? null : hashMap3.get(Key.ROTATION);
        HashMap<String, ViewSpline> hashMap4 = this.mAttributesMap;
        ViewSpline viewSpline4 = hashMap4 == null ? null : hashMap4.get("scaleX");
        HashMap<String, ViewSpline> hashMap5 = this.mAttributesMap;
        ViewSpline viewSpline5 = hashMap5 == null ? null : hashMap5.get("scaleY");
        HashMap<String, ViewOscillator> hashMap6 = this.mCycleMap;
        ViewOscillator viewOscillator = hashMap6 == null ? null : hashMap6.get("translationX");
        HashMap<String, ViewOscillator> hashMap7 = this.mCycleMap;
        ViewOscillator viewOscillator2 = hashMap7 == null ? null : hashMap7.get("translationY");
        HashMap<String, ViewOscillator> hashMap8 = this.mCycleMap;
        ViewOscillator viewOscillator3 = hashMap8 == null ? null : hashMap8.get(Key.ROTATION);
        HashMap<String, ViewOscillator> hashMap9 = this.mCycleMap;
        ViewOscillator viewOscillator4 = hashMap9 == null ? null : hashMap9.get("scaleX");
        HashMap<String, ViewOscillator> hashMap10 = this.mCycleMap;
        ViewOscillator viewOscillator5 = hashMap10 != null ? hashMap10.get("scaleY") : null;
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(viewSpline3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(viewSpline, viewSpline2, adjustedPosition);
        velocityMatrix.setScaleVelocity(viewSpline4, viewSpline5, adjustedPosition);
        velocityMatrix.setRotationVelocity(viewOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(viewOscillator, viewOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(viewOscillator4, viewOscillator5, adjustedPosition);
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
            velocityMatrix.setRotationVelocity(viewSpline3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(viewSpline, viewSpline2, adjustedPosition);
            velocityMatrix.setScaleVelocity(viewSpline4, viewSpline5, adjustedPosition);
            velocityMatrix.setRotationVelocity(viewOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(viewOscillator, viewOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(viewOscillator4, viewOscillator5, adjustedPosition);
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

    public View getView() {
        return this.mView;
    }

    public boolean interpolate(View view, float f, long j, KeyCache keyCache) {
        ViewTimeCycle.PathRotate pathRotate;
        boolean z9;
        View view2;
        View view3;
        float f10;
        float f11;
        double d10;
        View view4 = view;
        float adjustedPosition = getAdjustedPosition(f, null);
        int i = this.mQuantizeMotionSteps;
        if (i != Key.UNSET) {
            float f12 = 1.0f / i;
            float floor = ((float) Math.floor(adjustedPosition / f12)) * f12;
            float f13 = (adjustedPosition % f12) / f12;
            if (!Float.isNaN(this.mQuantizeMotionPhase)) {
                f13 = (f13 + this.mQuantizeMotionPhase) % 1.0f;
            }
            Interpolator interpolator = this.mQuantizeMotionInterpolator;
            adjustedPosition = ((interpolator != null ? interpolator.getInterpolation(f13) : ((double) f13) > 0.5d ? 1.0f : 0.0f) * f12) + floor;
        }
        HashMap<String, ViewSpline> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            Iterator<ViewSpline> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().setProperty(view4, adjustedPosition);
            }
        }
        HashMap<String, ViewTimeCycle> hashMap2 = this.mTimeCycleAttributesMap;
        if (hashMap2 != null) {
            ViewTimeCycle.PathRotate pathRotate2 = null;
            boolean z10 = false;
            for (ViewTimeCycle viewTimeCycle : hashMap2.values()) {
                if (viewTimeCycle instanceof ViewTimeCycle.PathRotate) {
                    pathRotate2 = (ViewTimeCycle.PathRotate) viewTimeCycle;
                } else {
                    z10 |= viewTimeCycle.setProperty(view4, adjustedPosition, j, keyCache);
                    view4 = view;
                }
            }
            z9 = z10;
            pathRotate = pathRotate2;
        } else {
            pathRotate = null;
            z9 = false;
        }
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d11 = adjustedPosition;
            curveFitArr[0].getPos(d11, this.mInterpolateData);
            this.mSpline[0].getSlope(d11, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d11, dArr);
                    this.mArcSpline.getSlope(d11, this.mInterpolateVelocity);
                }
            }
            if (this.mNoMovement) {
                view3 = view;
                f10 = 1.0f;
                f11 = 0.0f;
                d10 = d11;
            } else {
                float f14 = adjustedPosition;
                f10 = 1.0f;
                d10 = d11;
                f11 = 0.0f;
                this.mStartMotionPath.setView(f14, view, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null, this.mForceMeasure);
                adjustedPosition = f14;
                view3 = view;
                this.mForceMeasure = false;
            }
            if (this.mTransformPivotTarget != Key.UNSET) {
                if (this.mTransformPivotView == null) {
                    this.mTransformPivotView = ((View) view3.getParent()).findViewById(this.mTransformPivotTarget);
                }
                if (this.mTransformPivotView != null) {
                    float bottom = (this.mTransformPivotView.getBottom() + r1.getTop()) / 2.0f;
                    float right = (this.mTransformPivotView.getRight() + this.mTransformPivotView.getLeft()) / 2.0f;
                    if (view3.getRight() - view3.getLeft() > 0 && view3.getBottom() - view3.getTop() > 0) {
                        view3.setPivotX(right - view3.getLeft());
                        view3.setPivotY(bottom - view3.getTop());
                    }
                }
            }
            HashMap<String, ViewSpline> hashMap3 = this.mAttributesMap;
            if (hashMap3 != null) {
                for (ViewSpline viewSpline : hashMap3.values()) {
                    if (viewSpline instanceof ViewSpline.PathRotate) {
                        double[] dArr2 = this.mInterpolateVelocity;
                        if (dArr2.length > 1) {
                            ((ViewSpline.PathRotate) viewSpline).setPathRotate(view3, adjustedPosition, dArr2[0], dArr2[1]);
                        }
                    }
                    view3 = view;
                }
            }
            if (pathRotate != null) {
                double[] dArr3 = this.mInterpolateVelocity;
                view2 = view;
                float f15 = adjustedPosition;
                adjustedPosition = f15;
                z9 |= pathRotate.setPathRotate(view2, keyCache, f15, j, dArr3[0], dArr3[1]);
            } else {
                view2 = view;
            }
            int i6 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i6 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i6].getPos(d10, this.mValuesBuff);
                CustomSupport.setInterpolatedValue(this.mStartMotionPath.mAttributes.get(this.mAttributeNames[i6 - 1]), view2, this.mValuesBuff);
                i6++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (adjustedPosition <= f11) {
                    view2.setVisibility(motionConstrainedPoint.mVisibility);
                } else {
                    MotionConstrainedPoint motionConstrainedPoint2 = this.mEndPoint;
                    if (adjustedPosition >= f10) {
                        view2.setVisibility(motionConstrainedPoint2.mVisibility);
                    } else if (motionConstrainedPoint2.mVisibility != motionConstrainedPoint.mVisibility) {
                        view2.setVisibility(0);
                    }
                }
            }
            if (this.mKeyTriggers != null) {
                int i10 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
                    if (i10 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i10].conditionallyFire(adjustedPosition, view2);
                    i10++;
                }
            }
        } else {
            view2 = view;
            MotionPaths motionPaths = this.mStartMotionPath;
            float f16 = motionPaths.mX;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float f17 = x.f(motionPaths2.mX, f16, adjustedPosition, f16);
            float f18 = motionPaths.mY;
            float f19 = x.f(motionPaths2.mY, f18, adjustedPosition, f18);
            float f20 = motionPaths.mWidth;
            float f21 = motionPaths2.mWidth;
            float f22 = x.f(f21, f20, adjustedPosition, f20);
            float f23 = motionPaths.mHeight;
            float f24 = motionPaths2.mHeight;
            float f25 = f17 + 0.5f;
            int i11 = (int) f25;
            float f26 = f19 + 0.5f;
            int i12 = (int) f26;
            int i13 = (int) (f25 + f22);
            int f27 = (int) (f26 + x.f(f24, f23, adjustedPosition, f23));
            int i14 = i13 - i11;
            int i15 = f27 - i12;
            if (f21 != f20 || f24 != f23 || this.mForceMeasure) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(i14, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(i15, BasicMeasure.EXACTLY));
                this.mForceMeasure = false;
            }
            view2.layout(i11, i12, i13, f27);
        }
        HashMap<String, ViewOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            for (ViewOscillator viewOscillator : hashMap4.values()) {
                if (viewOscillator instanceof ViewOscillator.PathRotateSet) {
                    double[] dArr4 = this.mInterpolateVelocity;
                    ((ViewOscillator.PathRotateSet) viewOscillator).setPathRotate(view2, adjustedPosition, dArr4[0], dArr4[1]);
                } else {
                    viewOscillator.setProperty(view2, adjustedPosition);
                }
            }
        }
        return z9;
    }

    public String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    public void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f, float f10, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f11 = motionPaths.mX;
        rectF.left = f11;
        float f12 = motionPaths.mY;
        rectF.top = f12;
        rectF.right = f11 + motionPaths.mWidth;
        rectF.bottom = f12 + motionPaths.mHeight;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f13 = motionPaths2.mX;
        rectF2.left = f13;
        float f14 = motionPaths2.mY;
        rectF2.top = f14;
        rectF2.right = f13 + motionPaths2.mWidth;
        rectF2.bottom = f14 + motionPaths2.mHeight;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f, f10, strArr, fArr);
    }

    public void remeasure() {
        this.mForceMeasure = true;
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

    public void setBothStates(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        this.mNoMovement = true;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mEndMotionPath.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
        this.mEndPoint.setState(view);
    }

    public void setDrawPath(int i) {
        this.mStartMotionPath.mDrawPath = i;
    }

    public void setEndState(Rect rect, ConstraintSet constraintSet, int i, int i6) {
        MotionController motionController;
        int i10 = constraintSet.mRotate;
        if (i10 != 0) {
            motionController = this;
            motionController.rotate(rect, this.mTempRect, i10, i, i6);
            rect = motionController.mTempRect;
        } else {
            motionController = this;
        }
        MotionPaths motionPaths = motionController.mEndMotionPath;
        motionPaths.mTime = 1.0f;
        motionPaths.mPosition = 1.0f;
        readView(motionPaths);
        motionController.mEndMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        motionController.mEndMotionPath.applyParameters(constraintSet.getParameters(motionController.mId));
        motionController.mEndPoint.setState(rect, constraintSet, i10, motionController.mId);
    }

    public void setPathMotionArc(int i) {
        this.mPathMotionArc = i;
    }

    public void setStartCurrentState(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
    }

    public void setStartState(ViewState viewState, View view, int i, int i6, int i10) {
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
        this.mStartPoint.setState(rect, view, i, viewState.rotation);
    }

    public void setTransformPivotTarget(int i) {
        this.mTransformPivotTarget = i;
        this.mTransformPivotView = null;
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setup(int i, int i6, float f, long j) {
        ArrayList arrayList;
        int i10;
        String[] strArr;
        int i11;
        int i12;
        ConstraintAttribute constraintAttribute;
        ViewTimeCycle makeSpline;
        ConstraintAttribute constraintAttribute2;
        Integer num;
        int i13;
        ViewSpline makeSpline2;
        ConstraintAttribute constraintAttribute3;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        int i14 = this.mPathMotionArc;
        if (i14 != Key.UNSET) {
            this.mStartMotionPath.mPathMotionArc = i14;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet2);
        ArrayList<Key> arrayList2 = this.mKeyList;
        int i15 = 0;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i16 = 0;
            arrayList = null;
            while (i16 < size) {
                Key key = arrayList2.get(i16);
                i16++;
                Key key2 = key;
                if (key2 instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) key2;
                    insertKey(new MotionPaths(i, i6, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i17 = keyPosition.mCurveFit;
                    if (i17 != Key.UNSET) {
                        this.mCurveFitType = i17;
                    }
                } else if (key2 instanceof KeyCycle) {
                    key2.getAttributeNames(hashSet3);
                } else if (key2 instanceof KeyTimeCycle) {
                    key2.getAttributeNames(hashSet);
                } else if (key2 instanceof KeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((KeyTrigger) key2);
                } else {
                    key2.setInterpolation(hashMap);
                    key2.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mKeyTriggers = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        int i18 = 1;
        if (hashSet2.isEmpty()) {
            i10 = 1;
        } else {
            this.mAttributesMap = new HashMap<>();
            Iterator<String> it = hashSet2.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str = next.split(",")[i18];
                    ArrayList<Key> arrayList3 = this.mKeyList;
                    int size2 = arrayList3.size();
                    int i19 = i15;
                    while (i19 < size2) {
                        Key key3 = arrayList3.get(i19);
                        i19++;
                        int i20 = i18;
                        Key key4 = key3;
                        HashMap<String, ConstraintAttribute> hashMap2 = key4.mCustomConstraints;
                        if (hashMap2 != null && (constraintAttribute3 = hashMap2.get(str)) != null) {
                            sparseArray.append(key4.mFramePosition, constraintAttribute3);
                        }
                        i18 = i20;
                    }
                    i13 = i18;
                    makeSpline2 = ViewSpline.makeCustomSpline(next, (SparseArray<ConstraintAttribute>) sparseArray);
                } else {
                    i13 = i18;
                    makeSpline2 = ViewSpline.makeSpline(next);
                }
                if (makeSpline2 != null) {
                    makeSpline2.setType(next);
                    this.mAttributesMap.put(next, makeSpline2);
                }
                i18 = i13;
                i15 = 0;
            }
            i10 = i18;
            ArrayList<Key> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                int size3 = arrayList4.size();
                int i21 = 0;
                while (i21 < size3) {
                    Key key5 = arrayList4.get(i21);
                    i21++;
                    Key key6 = key5;
                    if (key6 instanceof KeyAttributes) {
                        key6.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str2 : this.mAttributesMap.keySet()) {
                int intValue = (!hashMap.containsKey(str2) || (num = hashMap.get(str2)) == null) ? 0 : num.intValue();
                ViewSpline viewSpline = this.mAttributesMap.get(str2);
                if (viewSpline != null) {
                    viewSpline.setup(intValue);
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
                        SparseArray sparseArray2 = new SparseArray();
                        String str3 = next2.split(",")[i10];
                        ArrayList<Key> arrayList5 = this.mKeyList;
                        int size4 = arrayList5.size();
                        int i22 = 0;
                        while (i22 < size4) {
                            Key key7 = arrayList5.get(i22);
                            i22++;
                            Key key8 = key7;
                            HashMap<String, ConstraintAttribute> hashMap3 = key8.mCustomConstraints;
                            if (hashMap3 != null && (constraintAttribute2 = hashMap3.get(str3)) != null) {
                                sparseArray2.append(key8.mFramePosition, constraintAttribute2);
                            }
                        }
                        makeSpline = ViewTimeCycle.makeCustomSpline(next2, sparseArray2);
                    } else {
                        makeSpline = ViewTimeCycle.makeSpline(next2, j);
                    }
                    if (makeSpline != null) {
                        makeSpline.setType(next2);
                        this.mTimeCycleAttributesMap.put(next2, makeSpline);
                    }
                }
            }
            ArrayList<Key> arrayList6 = this.mKeyList;
            if (arrayList6 != null) {
                int size5 = arrayList6.size();
                int i23 = 0;
                while (i23 < size5) {
                    Key key9 = arrayList6.get(i23);
                    i23++;
                    Key key10 = key9;
                    if (key10 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) key10).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String str4 : this.mTimeCycleAttributesMap.keySet()) {
                this.mTimeCycleAttributesMap.get(str4).setup(hashMap.containsKey(str4) ? hashMap.get(str4).intValue() : 0);
            }
        }
        int size6 = this.mMotionPaths.size();
        int i24 = size6 + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[i24];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[size6 + 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        ArrayList<MotionPaths> arrayList7 = this.mMotionPaths;
        int size7 = arrayList7.size();
        int i25 = i10;
        int i26 = 0;
        while (i26 < size7) {
            MotionPaths motionPaths = arrayList7.get(i26);
            i26++;
            motionPathsArr[i25] = motionPaths;
            i25++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str5 : this.mEndMotionPath.mAttributes.keySet()) {
            if (this.mStartMotionPath.mAttributes.containsKey(str5)) {
                if (!hashSet2.contains("CUSTOM," + str5)) {
                    hashSet4.add(str5);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.mAttributeNames = strArr2;
        this.mAttributeInterpolatorCount = new int[strArr2.length];
        int i27 = 0;
        while (true) {
            strArr = this.mAttributeNames;
            if (i27 >= strArr.length) {
                break;
            }
            String str6 = strArr[i27];
            this.mAttributeInterpolatorCount[i27] = 0;
            int i28 = 0;
            while (true) {
                if (i28 >= i24) {
                    break;
                }
                if (motionPathsArr[i28].mAttributes.containsKey(str6) && (constraintAttribute = motionPathsArr[i28].mAttributes.get(str6)) != null) {
                    int[] iArr = this.mAttributeInterpolatorCount;
                    iArr[i27] = constraintAttribute.numberOfInterpolatedValues() + iArr[i27];
                    break;
                }
                i28++;
            }
            i27++;
        }
        boolean z9 = motionPathsArr[0].mPathMotionArc != Key.UNSET ? i10 : 0;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i29 = i10; i29 < i24; i29++) {
            motionPathsArr[i29].different(motionPathsArr[i29 - 1], zArr, this.mAttributeNames, z9);
        }
        int i30 = 0;
        for (int i31 = i10; i31 < length; i31++) {
            if (zArr[i31]) {
                i30++;
            }
        }
        this.mInterpolateVariables = new int[i30];
        int i32 = 2;
        int max = Math.max(2, i30);
        this.mInterpolateData = new double[max];
        this.mInterpolateVelocity = new double[max];
        int i33 = 0;
        for (int i34 = i10; i34 < length; i34++) {
            if (zArr[i34]) {
                this.mInterpolateVariables[i33] = i34;
                i33++;
            }
        }
        int[] iArr2 = new int[2];
        iArr2[i10] = this.mInterpolateVariables.length;
        iArr2[0] = i24;
        Class cls = Double.TYPE;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls, iArr2);
        double[] dArr2 = new double[i24];
        for (int i35 = 0; i35 < i24; i35++) {
            motionPathsArr[i35].fillStandard(dArr[i35], this.mInterpolateVariables);
            dArr2[i35] = motionPathsArr[i35].mTime;
        }
        int i36 = 0;
        while (true) {
            int[] iArr3 = this.mInterpolateVariables;
            if (i36 >= iArr3.length) {
                break;
            }
            if (iArr3[i36] < MotionPaths.sNames.length) {
                String n10 = x.n(new StringBuilder(), MotionPaths.sNames[this.mInterpolateVariables[i36]], " [");
                for (int i37 = 0; i37 < i24; i37++) {
                    StringBuilder t9 = x.t(n10);
                    t9.append(dArr[i37][i36]);
                    n10 = t9.toString();
                }
            }
            i36++;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i38 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i38 >= strArr3.length) {
                break;
            }
            String str7 = strArr3[i38];
            int i39 = 0;
            int i40 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i39 < i24) {
                if (motionPathsArr[i39].hasCustomData(str7)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i24];
                        int[] iArr4 = new int[i32];
                        iArr4[i10] = motionPathsArr[i39].getCustomDataCount(str7);
                        i12 = 0;
                        iArr4[0] = i24;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) cls, iArr4);
                    } else {
                        i12 = 0;
                    }
                    MotionPaths motionPaths2 = motionPathsArr[i39];
                    i11 = i38;
                    dArr3[i40] = motionPaths2.mTime;
                    motionPaths2.getCustomData(str7, dArr4[i40], i12);
                    i40++;
                } else {
                    i11 = i38;
                }
                i39++;
                i38 = i11;
                i32 = 2;
            }
            int i41 = i38 + 1;
            this.mSpline[i41] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i40), (double[][]) Arrays.copyOf(dArr4, i40));
            i38 = i41;
            i32 = 2;
        }
        int i42 = 0;
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
            int[] iArr5 = new int[i24];
            double[] dArr5 = new double[i24];
            int[] iArr6 = new int[2];
            iArr6[i10] = 2;
            iArr6[0] = i24;
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) cls, iArr6);
            for (int i43 = 0; i43 < i24; i43++) {
                iArr5[i43] = motionPathsArr[i43].mPathMotionArc;
                dArr5[i43] = r8.mTime;
                double[] dArr7 = dArr6[i43];
                dArr7[0] = r8.mX;
                dArr7[i10] = r8.mY;
            }
            i42 = 0;
            this.mArcSpline = CurveFit.getArc(iArr5, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator<String> it3 = hashSet3.iterator();
            float f10 = Float.NaN;
            while (it3.hasNext()) {
                String next3 = it3.next();
                ViewOscillator makeSpline3 = ViewOscillator.makeSpline(next3);
                if (makeSpline3 != null) {
                    if (makeSpline3.variesByPath() && Float.isNaN(f10)) {
                        f10 = getPreCycleDistance();
                    }
                    makeSpline3.setType(next3);
                    this.mCycleMap.put(next3, makeSpline3);
                }
            }
            ArrayList<Key> arrayList8 = this.mKeyList;
            int size8 = arrayList8.size();
            int i44 = i42;
            while (i44 < size8) {
                Key key11 = arrayList8.get(i44);
                i44++;
                Key key12 = key11;
                if (key12 instanceof KeyCycle) {
                    ((KeyCycle) key12).addCycleValues(this.mCycleMap);
                }
            }
            Iterator<ViewOscillator> it4 = this.mCycleMap.values().iterator();
            while (it4.hasNext()) {
                it4.next().setup(f10);
            }
        }
    }

    public void setupRelative(MotionController motionController) {
        this.mStartMotionPath.setupRelative(motionController, motionController.mStartMotionPath);
        this.mEndMotionPath.setupRelative(motionController, motionController.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.mX + " y: " + this.mStartMotionPath.mY + " end: x: " + this.mEndMotionPath.mX + " y: " + this.mEndMotionPath.mY;
    }

    public void setStartState(Rect rect, ConstraintSet constraintSet, int i, int i6) {
        MotionController motionController;
        Rect rect2;
        int i10 = constraintSet.mRotate;
        if (i10 != 0) {
            motionController = this;
            rect2 = rect;
            motionController.rotate(rect2, this.mTempRect, i10, i, i6);
        } else {
            motionController = this;
            rect2 = rect;
        }
        MotionPaths motionPaths = motionController.mStartMotionPath;
        motionPaths.mTime = 0.0f;
        motionPaths.mPosition = 0.0f;
        readView(motionPaths);
        motionController.mStartMotionPath.setBounds(rect2.left, rect2.top, rect2.width(), rect2.height());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(motionController.mId);
        motionController.mStartMotionPath.applyParameters(parameters);
        motionController.mMotionStagger = parameters.motion.mMotionStagger;
        motionController.mStartPoint.setState(rect2, constraintSet, i10, motionController.mId);
        motionController.mTransformPivotTarget = parameters.transform.transformPivotTarget;
        ConstraintSet.Motion motion = parameters.motion;
        motionController.mQuantizeMotionSteps = motion.mQuantizeMotionSteps;
        motionController.mQuantizeMotionPhase = motion.mQuantizeMotionPhase;
        Context context = motionController.mView.getContext();
        ConstraintSet.Motion motion2 = parameters.motion;
        motionController.mQuantizeMotionInterpolator = getInterpolator(context, motion2.mQuantizeInterpolatorType, motion2.mQuantizeInterpolatorString, motion2.mQuantizeInterpolatorID);
    }
}
