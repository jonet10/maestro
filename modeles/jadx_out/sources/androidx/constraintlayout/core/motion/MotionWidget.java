package androidx.constraintlayout.core.motion;

import a4.x;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class MotionWidget implements TypedValues {
    public static final int FILL_PARENT = -1;
    public static final int GONE_UNSET = Integer.MIN_VALUE;
    private static final int INTERNAL_MATCH_CONSTRAINT = -3;
    private static final int INTERNAL_MATCH_PARENT = -1;
    private static final int INTERNAL_WRAP_CONTENT = -2;
    private static final int INTERNAL_WRAP_CONTENT_CONSTRAINED = -4;
    public static final int INVISIBLE = 0;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int MATCH_PARENT = -1;
    public static final int PARENT_ID = 0;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    public static final int UNSET = -1;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 4;
    public static final int WRAP_CONTENT = -2;
    Motion mMotion;
    private float mProgress;
    PropertySet mPropertySet;
    float mTransitionPathRotate;
    WidgetFrame mWidgetFrame;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class Motion {
        private static final int INTERPOLATOR_REFERENCE_ID = -2;
        private static final int INTERPOLATOR_UNDEFINED = -3;
        private static final int SPLINE_STRING = -1;
        public String mAnimateRelativeTo = null;
        public int mAnimateCircleAngleTo = 0;
        public String mTransitionEasing = null;
        public int mPathMotionArc = -1;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public int mPolarRelativeTo = -1;
        public float mPathRotate = Float.NaN;
        public float mQuantizeMotionPhase = Float.NaN;
        public int mQuantizeMotionSteps = -1;
        public String mQuantizeInterpolatorString = null;
        public int mQuantizeInterpolatorType = -3;
        public int mQuantizeInterpolatorID = -1;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class PropertySet {
        public int visibility = 4;
        public int mVisibilityMode = 0;
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;
    }

    public MotionWidget(WidgetFrame widgetFrame) {
        this.mWidgetFrame = new WidgetFrame();
        this.mMotion = new Motion();
        this.mPropertySet = new PropertySet();
        this.mWidgetFrame = widgetFrame;
    }

    public MotionWidget findViewById(int i) {
        return null;
    }

    public float getAlpha() {
        return this.mWidgetFrame.alpha;
    }

    public int getBottom() {
        return this.mWidgetFrame.bottom;
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.mWidgetFrame.getCustomAttribute(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.mWidgetFrame.getCustomAttributeNames();
    }

    public int getHeight() {
        WidgetFrame widgetFrame = this.mWidgetFrame;
        return widgetFrame.bottom - widgetFrame.top;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        char c9;
        int c10 = x.c(str);
        if (c10 != -1) {
            return c10;
        }
        switch (str.hashCode()) {
            case -2033446275:
                if (str.equals(TypedValues.MotionType.S_ANIMATE_CIRCLEANGLE_TO)) {
                    c9 = 0;
                    break;
                }
                c9 = 65535;
                break;
            case -1532277420:
                if (str.equals(TypedValues.MotionType.S_QUANTIZE_MOTION_PHASE)) {
                    c9 = 1;
                    break;
                }
                c9 = 65535;
                break;
            case -1529145600:
                if (str.equals(TypedValues.MotionType.S_QUANTIZE_MOTIONSTEPS)) {
                    c9 = 2;
                    break;
                }
                c9 = 65535;
                break;
            case -1498310144:
                if (str.equals(TypedValues.MotionType.S_PATH_ROTATE)) {
                    c9 = 3;
                    break;
                }
                c9 = 65535;
                break;
            case -1030753096:
                if (str.equals(TypedValues.MotionType.S_QUANTIZE_INTERPOLATOR)) {
                    c9 = 4;
                    break;
                }
                c9 = 65535;
                break;
            case -762370135:
                if (str.equals(TypedValues.MotionType.S_DRAW_PATH)) {
                    c9 = 5;
                    break;
                }
                c9 = 65535;
                break;
            case -232872051:
                if (str.equals(TypedValues.MotionType.S_STAGGER)) {
                    c9 = 6;
                    break;
                }
                c9 = 65535;
                break;
            case 1138491429:
                if (str.equals(TypedValues.MotionType.S_POLAR_RELATIVETO)) {
                    c9 = 7;
                    break;
                }
                c9 = 65535;
                break;
            case 1539234834:
                if (str.equals(TypedValues.MotionType.S_QUANTIZE_INTERPOLATOR_TYPE)) {
                    c9 = '\b';
                    break;
                }
                c9 = 65535;
                break;
            case 1583722451:
                if (str.equals(TypedValues.MotionType.S_QUANTIZE_INTERPOLATOR_ID)) {
                    c9 = '\t';
                    break;
                }
                c9 = 65535;
                break;
            case 1639368448:
                if (str.equals(TypedValues.MotionType.S_EASING)) {
                    c9 = '\n';
                    break;
                }
                c9 = 65535;
                break;
            case 1900899336:
                if (str.equals(TypedValues.MotionType.S_ANIMATE_RELATIVE_TO)) {
                    c9 = 11;
                    break;
                }
                c9 = 65535;
                break;
            case 2109694967:
                if (str.equals(TypedValues.MotionType.S_PATHMOTION_ARC)) {
                    c9 = '\f';
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
                return TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO;
            case 1:
                return TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE;
            case 2:
                return TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS;
            case 3:
                return 601;
            case 4:
                return TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR;
            case 5:
                return TypedValues.MotionType.TYPE_DRAW_PATH;
            case 6:
                return 600;
            case 7:
                return TypedValues.MotionType.TYPE_POLAR_RELATIVETO;
            case '\b':
                return TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE;
            case '\t':
                return TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID;
            case '\n':
                return TypedValues.MotionType.TYPE_EASING;
            case 11:
                return TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO;
            case '\f':
                return TypedValues.MotionType.TYPE_PATHMOTION_ARC;
            default:
                return -1;
        }
    }

    public int getLeft() {
        return this.mWidgetFrame.left;
    }

    public String getName() {
        return this.mWidgetFrame.getId();
    }

    public MotionWidget getParent() {
        return null;
    }

    public float getPivotX() {
        return this.mWidgetFrame.pivotX;
    }

    public float getPivotY() {
        return this.mWidgetFrame.pivotY;
    }

    public int getRight() {
        return this.mWidgetFrame.right;
    }

    public float getRotationX() {
        return this.mWidgetFrame.rotationX;
    }

    public float getRotationY() {
        return this.mWidgetFrame.rotationY;
    }

    public float getRotationZ() {
        return this.mWidgetFrame.rotationZ;
    }

    public float getScaleX() {
        return this.mWidgetFrame.scaleX;
    }

    public float getScaleY() {
        return this.mWidgetFrame.scaleY;
    }

    public int getTop() {
        return this.mWidgetFrame.top;
    }

    public float getTranslationX() {
        return this.mWidgetFrame.translationX;
    }

    public float getTranslationY() {
        return this.mWidgetFrame.translationY;
    }

    public float getTranslationZ() {
        return this.mWidgetFrame.translationZ;
    }

    public float getValueAttributes(int i) {
        switch (i) {
            case 303:
                return this.mWidgetFrame.alpha;
            case 304:
                return this.mWidgetFrame.translationX;
            case 305:
                return this.mWidgetFrame.translationY;
            case 306:
                return this.mWidgetFrame.translationZ;
            case 307:
            default:
                return Float.NaN;
            case 308:
                return this.mWidgetFrame.rotationX;
            case 309:
                return this.mWidgetFrame.rotationY;
            case 310:
                return this.mWidgetFrame.rotationZ;
            case 311:
                return this.mWidgetFrame.scaleX;
            case 312:
                return this.mWidgetFrame.scaleY;
            case 313:
                return this.mWidgetFrame.pivotX;
            case 314:
                return this.mWidgetFrame.pivotY;
            case 315:
                return this.mProgress;
            case TypedValues.AttributesType.TYPE_PATH_ROTATE /* 316 */:
                return this.mTransitionPathRotate;
        }
    }

    public int getVisibility() {
        return this.mPropertySet.visibility;
    }

    public WidgetFrame getWidgetFrame() {
        return this.mWidgetFrame;
    }

    public int getWidth() {
        WidgetFrame widgetFrame = this.mWidgetFrame;
        return widgetFrame.right - widgetFrame.left;
    }

    public int getX() {
        return this.mWidgetFrame.left;
    }

    public int getY() {
        return this.mWidgetFrame.top;
    }

    public void layout(int i, int i6, int i10, int i11) {
        setBounds(i, i6, i10, i11);
    }

    public void setBounds(int i, int i6, int i10, int i11) {
        if (this.mWidgetFrame == null) {
            this.mWidgetFrame = new WidgetFrame((ConstraintWidget) null);
        }
        WidgetFrame widgetFrame = this.mWidgetFrame;
        widgetFrame.top = i6;
        widgetFrame.left = i;
        widgetFrame.right = i10;
        widgetFrame.bottom = i11;
    }

    public void setCustomAttribute(String str, int i, float f) {
        this.mWidgetFrame.setCustomAttribute(str, i, f);
    }

    public void setInterpolatedValue(CustomAttribute customAttribute, float[] fArr) {
        this.mWidgetFrame.setCustomAttribute(customAttribute.mName, TypedValues.Custom.TYPE_FLOAT, fArr[0]);
    }

    public void setPivotX(float f) {
        this.mWidgetFrame.pivotX = f;
    }

    public void setPivotY(float f) {
        this.mWidgetFrame.pivotY = f;
    }

    public void setRotationX(float f) {
        this.mWidgetFrame.rotationX = f;
    }

    public void setRotationY(float f) {
        this.mWidgetFrame.rotationY = f;
    }

    public void setRotationZ(float f) {
        this.mWidgetFrame.rotationZ = f;
    }

    public void setScaleX(float f) {
        this.mWidgetFrame.scaleX = f;
    }

    public void setScaleY(float f) {
        this.mWidgetFrame.scaleY = f;
    }

    public void setTranslationX(float f) {
        this.mWidgetFrame.translationX = f;
    }

    public void setTranslationY(float f) {
        this.mWidgetFrame.translationY = f;
    }

    public void setTranslationZ(float f) {
        this.mWidgetFrame.translationZ = f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (i != 605) {
            return setValueMotion(i, str);
        }
        this.mMotion.mAnimateRelativeTo = str;
        return true;
    }

    public boolean setValueAttributes(int i, float f) {
        switch (i) {
            case 303:
                this.mWidgetFrame.alpha = f;
                return true;
            case 304:
                this.mWidgetFrame.translationX = f;
                return true;
            case 305:
                this.mWidgetFrame.translationY = f;
                return true;
            case 306:
                this.mWidgetFrame.translationZ = f;
                return true;
            case 307:
            default:
                return false;
            case 308:
                this.mWidgetFrame.rotationX = f;
                return true;
            case 309:
                this.mWidgetFrame.rotationY = f;
                return true;
            case 310:
                this.mWidgetFrame.rotationZ = f;
                return true;
            case 311:
                this.mWidgetFrame.scaleX = f;
                return true;
            case 312:
                this.mWidgetFrame.scaleY = f;
                return true;
            case 313:
                this.mWidgetFrame.pivotX = f;
                return true;
            case 314:
                this.mWidgetFrame.pivotY = f;
                return true;
            case 315:
                this.mProgress = f;
                return true;
            case TypedValues.AttributesType.TYPE_PATH_ROTATE /* 316 */:
                this.mTransitionPathRotate = f;
                return true;
        }
    }

    public boolean setValueMotion(int i, int i6) {
        switch (i) {
            case TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO /* 606 */:
                this.mMotion.mAnimateCircleAngleTo = i6;
                return true;
            case TypedValues.MotionType.TYPE_PATHMOTION_ARC /* 607 */:
                this.mMotion.mPathMotionArc = i6;
                return true;
            case TypedValues.MotionType.TYPE_DRAW_PATH /* 608 */:
                this.mMotion.mDrawPath = i6;
                return true;
            case TypedValues.MotionType.TYPE_POLAR_RELATIVETO /* 609 */:
                this.mMotion.mPolarRelativeTo = i6;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS /* 610 */:
                this.mMotion.mQuantizeMotionSteps = i6;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE /* 611 */:
                this.mMotion.mQuantizeInterpolatorType = i6;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID /* 612 */:
                this.mMotion.mQuantizeInterpolatorID = i6;
                return true;
            default:
                return false;
        }
    }

    public void setVisibility(int i) {
        this.mPropertySet.visibility = i;
    }

    public String toString() {
        return this.mWidgetFrame.left + ", " + this.mWidgetFrame.top + ", " + this.mWidgetFrame.right + ", " + this.mWidgetFrame.bottom;
    }

    public void updateMotion(TypedValues typedValues) {
        if (this.mWidgetFrame.getMotionProperties() != null) {
            this.mWidgetFrame.getMotionProperties().applyDelta(typedValues);
        }
    }

    public void setCustomAttribute(String str, int i, int i6) {
        this.mWidgetFrame.setCustomAttribute(str, i, i6);
    }

    public void setCustomAttribute(String str, int i, boolean z9) {
        this.mWidgetFrame.setCustomAttribute(str, i, z9);
    }

    public void setCustomAttribute(String str, int i, String str2) {
        this.mWidgetFrame.setCustomAttribute(str, i, str2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i6) {
        if (setValueAttributes(i, i6)) {
            return true;
        }
        return setValueMotion(i, i6);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (setValueAttributes(i, f)) {
            return true;
        }
        return setValueMotion(i, f);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, boolean z9) {
        return false;
    }

    public MotionWidget() {
        this.mWidgetFrame = new WidgetFrame();
        this.mMotion = new Motion();
        this.mPropertySet = new PropertySet();
    }

    public boolean setValueMotion(int i, String str) {
        if (i == 603) {
            this.mMotion.mTransitionEasing = str;
            return true;
        }
        if (i != 604) {
            return false;
        }
        this.mMotion.mQuantizeInterpolatorString = str;
        return true;
    }

    public boolean setValueMotion(int i, float f) {
        switch (i) {
            case 600:
                this.mMotion.mMotionStagger = f;
                return true;
            case 601:
                this.mMotion.mPathRotate = f;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE /* 602 */:
                this.mMotion.mQuantizeMotionPhase = f;
                return true;
            default:
                return false;
        }
    }
}
