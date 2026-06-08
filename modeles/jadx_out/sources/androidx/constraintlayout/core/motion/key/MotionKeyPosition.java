package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class MotionKeyPosition extends MotionKey {
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    protected static final float SELECTION_SLOPE = 20.0f;
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    public float mAltPercentX;
    public float mAltPercentY;
    private float mCalculatedPositionX;
    private float mCalculatedPositionY;
    public int mCurveFit;
    public int mDrawPath;
    public int mPathMotionArc;
    public float mPercentHeight;
    public float mPercentWidth;
    public float mPercentX;
    public float mPercentY;
    public int mPositionType;
    public String mTransitionEasing;

    public MotionKeyPosition() {
        int i = MotionKey.UNSET;
        this.mCurveFit = i;
        this.mTransitionEasing = null;
        this.mPathMotionArc = i;
        this.mDrawPath = 0;
        this.mPercentWidth = Float.NaN;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = Float.NaN;
        this.mPercentY = Float.NaN;
        this.mAltPercentX = Float.NaN;
        this.mAltPercentY = Float.NaN;
        this.mPositionType = 0;
        this.mCalculatedPositionX = Float.NaN;
        this.mCalculatedPositionY = Float.NaN;
        this.mType = 2;
    }

    private void calcCartesianPosition(float f, float f10, float f11, float f12) {
        float f13 = f11 - f;
        float f14 = f12 - f10;
        float f15 = Float.isNaN(this.mPercentX) ? 0.0f : this.mPercentX;
        float f16 = Float.isNaN(this.mAltPercentY) ? 0.0f : this.mAltPercentY;
        float f17 = Float.isNaN(this.mPercentY) ? 0.0f : this.mPercentY;
        this.mCalculatedPositionX = (int) (((Float.isNaN(this.mAltPercentX) ? 0.0f : this.mAltPercentX) * f14) + (f15 * f13) + f);
        this.mCalculatedPositionY = (int) ((f14 * f17) + (f13 * f16) + f10);
    }

    private void calcPathPosition(float f, float f10, float f11, float f12) {
        float f13 = f11 - f;
        float f14 = f12 - f10;
        float f15 = this.mPercentX;
        float f16 = (f13 * f15) + f;
        float f17 = this.mPercentY;
        this.mCalculatedPositionX = ((-f14) * f17) + f16;
        this.mCalculatedPositionY = (f13 * f17) + (f14 * f15) + f10;
    }

    private void calcScreenPosition(int i, int i6) {
        float f = this.mPercentX;
        float f10 = 0;
        this.mCalculatedPositionX = (i * f) + f10;
        this.mCalculatedPositionY = (i6 * f) + f10;
    }

    public void calcPosition(int i, int i6, float f, float f10, float f11, float f12) {
        int i10 = this.mPositionType;
        if (i10 == 1) {
            calcPathPosition(f, f10, f11, f12);
        } else if (i10 != 2) {
            calcCartesianPosition(f, f10, f11, f12);
        } else {
            calcScreenPosition(i, i6);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* renamed from: clone */
    public MotionKey mo33clone() {
        return new MotionKeyPosition().copy(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
        this.mTransitionEasing = motionKeyPosition.mTransitionEasing;
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mPercentWidth = motionKeyPosition.mPercentWidth;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = motionKeyPosition.mPercentX;
        this.mPercentY = motionKeyPosition.mPercentY;
        this.mAltPercentX = motionKeyPosition.mAltPercentX;
        this.mAltPercentY = motionKeyPosition.mAltPercentY;
        this.mCalculatedPositionX = motionKeyPosition.mCalculatedPositionX;
        this.mCalculatedPositionY = motionKeyPosition.mCalculatedPositionY;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        char c9;
        str.getClass();
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c9 = 0;
                    break;
                }
                c9 = 65535;
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c9 = 1;
                    break;
                }
                c9 = 65535;
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c9 = 2;
                    break;
                }
                c9 = 65535;
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c9 = 3;
                    break;
                }
                c9 = 65535;
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c9 = 4;
                    break;
                }
                c9 = 65535;
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    c9 = 5;
                    break;
                }
                c9 = 65535;
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    c9 = 6;
                    break;
                }
                c9 = 65535;
                break;
            default:
                c9 = 65535;
                break;
        }
        switch (c9) {
            case 0:
                return TypedValues.PositionType.TYPE_TRANSITION_EASING;
            case 1:
                return TypedValues.PositionType.TYPE_PERCENT_WIDTH;
            case 2:
                return TypedValues.PositionType.TYPE_PERCENT_HEIGHT;
            case 3:
                return TypedValues.PositionType.TYPE_DRAWPATH;
            case 4:
                return TypedValues.PositionType.TYPE_SIZE_PERCENT;
            case 5:
                return TypedValues.PositionType.TYPE_PERCENT_X;
            case 6:
                return TypedValues.PositionType.TYPE_PERCENT_Y;
            default:
                return -1;
        }
    }

    public float getPositionX() {
        return this.mCalculatedPositionX;
    }

    public float getPositionY() {
        return this.mCalculatedPositionY;
    }

    public boolean intersects(int i, int i6, FloatRect floatRect, FloatRect floatRect2, float f, float f10) {
        calcPosition(i, i6, floatRect.centerX(), floatRect.centerY(), floatRect2.centerX(), floatRect2.centerY());
        return Math.abs(f - this.mCalculatedPositionX) < SELECTION_SLOPE && Math.abs(f10 - this.mCalculatedPositionY) < SELECTION_SLOPE;
    }

    public void positionAttributes(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f, float f10, String[] strArr, float[] fArr) {
        int i = this.mPositionType;
        if (i == 1) {
            positionPathAttributes(floatRect, floatRect2, f, f10, strArr, fArr);
        } else if (i != 2) {
            positionCartAttributes(floatRect, floatRect2, f, f10, strArr, fArr);
        } else {
            positionScreenAttributes(motionWidget, floatRect, floatRect2, f, f10, strArr, fArr);
        }
    }

    public void positionCartAttributes(FloatRect floatRect, FloatRect floatRect2, float f, float f10, String[] strArr, float[] fArr) {
        float centerX = floatRect.centerX();
        float centerY = floatRect.centerY();
        float centerX2 = floatRect2.centerX() - centerX;
        float centerY2 = floatRect2.centerY() - centerY;
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = (f - centerX) / centerX2;
            strArr[1] = "percentY";
            fArr[1] = (f10 - centerY) / centerY2;
            return;
        }
        if ("percentX".equals(str)) {
            fArr[0] = (f - centerX) / centerX2;
            fArr[1] = (f10 - centerY) / centerY2;
        } else {
            fArr[1] = (f - centerX) / centerX2;
            fArr[0] = (f10 - centerY) / centerY2;
        }
    }

    public void positionPathAttributes(FloatRect floatRect, FloatRect floatRect2, float f, float f10, String[] strArr, float[] fArr) {
        float centerX = floatRect.centerX();
        float centerY = floatRect.centerY();
        float centerX2 = floatRect2.centerX() - centerX;
        float centerY2 = floatRect2.centerY() - centerY;
        float hypot = (float) Math.hypot(centerX2, centerY2);
        if (hypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f11 = centerX2 / hypot;
        float f12 = centerY2 / hypot;
        float f13 = f10 - centerY;
        float f14 = f - centerX;
        float f15 = ((f11 * f13) - (f14 * f12)) / hypot;
        float f16 = ((f12 * f13) + (f11 * f14)) / hypot;
        String str = strArr[0];
        if (str != null) {
            if ("percentX".equals(str)) {
                fArr[0] = f16;
                fArr[1] = f15;
                return;
            }
            return;
        }
        strArr[0] = "percentX";
        strArr[1] = "percentY";
        fArr[0] = f16;
        fArr[1] = f15;
    }

    public void positionScreenAttributes(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f, float f10, String[] strArr, float[] fArr) {
        floatRect.centerX();
        floatRect.centerY();
        floatRect2.centerX();
        floatRect2.centerY();
        MotionWidget parent = motionWidget.getParent();
        int width = parent.getWidth();
        int height = parent.getHeight();
        String str = strArr[0];
        if (str == null) {
            strArr[0] = "percentX";
            fArr[0] = f / width;
            strArr[1] = "percentY";
            fArr[1] = f10 / height;
            return;
        }
        if ("percentX".equals(str)) {
            fArr[0] = f / width;
            fArr[1] = f10 / height;
        } else {
            fArr[1] = f / width;
            fArr[0] = f10 / height;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        switch (i) {
            case TypedValues.PositionType.TYPE_PERCENT_WIDTH /* 503 */:
                this.mPercentWidth = f;
                return true;
            case TypedValues.PositionType.TYPE_PERCENT_HEIGHT /* 504 */:
                this.mPercentHeight = f;
                return true;
            case TypedValues.PositionType.TYPE_SIZE_PERCENT /* 505 */:
                this.mPercentWidth = f;
                this.mPercentHeight = f;
                return true;
            case TypedValues.PositionType.TYPE_PERCENT_X /* 506 */:
                this.mPercentX = f;
                return true;
            case TypedValues.PositionType.TYPE_PERCENT_Y /* 507 */:
                this.mPercentY = f;
                return true;
            default:
                return super.setValue(i, f);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i6) {
        if (i == 100) {
            this.mFramePosition = i6;
            return true;
        }
        if (i == 508) {
            this.mCurveFit = i6;
            return true;
        }
        if (i != 510) {
            return super.setValue(i, i6);
        }
        this.mPositionType = i6;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (i != 501) {
            return super.setValue(i, str);
        }
        this.mTransitionEasing = str.toString();
        return true;
    }
}
