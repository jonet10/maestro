package androidx.constraintlayout.core.motion;

import a3.b;
import a4.x;
import androidx.core.view.ViewCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class CustomAttribute {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    private boolean mMethod;
    String mName;
    private String mStringValue;
    private AttributeType mType;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public CustomAttribute(CustomAttribute customAttribute, Object obj) {
        this.mMethod = false;
        this.mName = customAttribute.mName;
        this.mType = customAttribute.mType;
        setValue(obj);
    }

    private static int clamp(int i) {
        int i6 = (i & (~(i >> 31))) - 255;
        return (i6 & (i6 >> 31)) + 255;
    }

    public static int hsvToRgb(float f, float f10, float f11) {
        float f12 = f * 6.0f;
        int i = (int) f12;
        float f13 = f12 - i;
        float f14 = f11 * 255.0f;
        int f15 = (int) x.f(1.0f, f10, f14, 0.5f);
        int i6 = (int) (((1.0f - (f13 * f10)) * f14) + 0.5f);
        int i10 = (int) (((1.0f - ((1.0f - f13) * f10)) * f14) + 0.5f);
        int i11 = (int) (f14 + 0.5f);
        if (i == 0) {
            return ((i11 << 16) + (i10 << 8) + f15) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i == 1) {
            return ((i6 << 16) + (i11 << 8) + f15) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i == 2) {
            return ((f15 << 16) + (i11 << 8) + i10) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i == 3) {
            return ((f15 << 16) + (i6 << 8) + i11) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i == 4) {
            return ((i10 << 16) + (f15 << 8) + i11) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i != 5) {
            return 0;
        }
        return ((i11 << 16) + (f15 << 8) + i6) | ViewCompat.MEASURED_STATE_MASK;
    }

    public boolean diff(CustomAttribute customAttribute) {
        AttributeType attributeType;
        if (customAttribute != null && (attributeType = this.mType) == customAttribute.mType) {
            switch (attributeType) {
                case INT_TYPE:
                case REFERENCE_TYPE:
                    if (this.mIntegerValue == customAttribute.mIntegerValue) {
                        return true;
                    }
                    break;
                case FLOAT_TYPE:
                    return this.mFloatValue == customAttribute.mFloatValue;
                case COLOR_TYPE:
                case COLOR_DRAWABLE_TYPE:
                    return this.mColorValue == customAttribute.mColorValue;
                case STRING_TYPE:
                    return this.mIntegerValue == customAttribute.mIntegerValue;
                case BOOLEAN_TYPE:
                    return this.mBooleanValue == customAttribute.mBooleanValue;
                case DIMENSION_TYPE:
                    return this.mFloatValue == customAttribute.mFloatValue;
                default:
                    return false;
            }
        }
        return false;
    }

    public AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (this.mType) {
            case INT_TYPE:
                return this.mIntegerValue;
            case FLOAT_TYPE:
                return this.mFloatValue;
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                b.n("Color does not have a single color to interpolate");
                return 0.0f;
            case STRING_TYPE:
                b.n("Cannot interpolate String");
                return 0.0f;
            case BOOLEAN_TYPE:
                return this.mBooleanValue ? 1.0f : 0.0f;
            case DIMENSION_TYPE:
                return this.mFloatValue;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        switch (this.mType) {
            case INT_TYPE:
                fArr[0] = this.mIntegerValue;
                break;
            case FLOAT_TYPE:
                fArr[0] = this.mFloatValue;
                break;
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                int i = (this.mColorValue >> 24) & 255;
                float pow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float pow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = pow3;
                fArr[3] = i / 255.0f;
                break;
            case STRING_TYPE:
                b.n("Color does not have a single color to interpolate");
                break;
            case BOOLEAN_TYPE:
                fArr[0] = this.mBooleanValue ? 1.0f : 0.0f;
                break;
            case DIMENSION_TYPE:
                fArr[0] = this.mFloatValue;
                break;
        }
    }

    public boolean isContinuous() {
        int ordinal = this.mType.ordinal();
        return (ordinal == 4 || ordinal == 5 || ordinal == 7) ? false : true;
    }

    public int numberOfInterpolatedValues() {
        int ordinal = this.mType.ordinal();
        return (ordinal == 2 || ordinal == 3) ? 4 : 1;
    }

    public void setColorValue(int i) {
        this.mColorValue = i;
    }

    public void setFloatValue(float f) {
        this.mFloatValue = f;
    }

    public void setIntValue(int i) {
        this.mIntegerValue = i;
    }

    public void setStringValue(String str) {
        this.mStringValue = str;
    }

    public void setValue(float[] fArr) {
        switch (this.mType) {
            case INT_TYPE:
            case REFERENCE_TYPE:
                this.mIntegerValue = (int) fArr[0];
                break;
            case FLOAT_TYPE:
                this.mFloatValue = fArr[0];
                break;
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                int hsvToRgb = hsvToRgb(fArr[0], fArr[1], fArr[2]);
                this.mColorValue = hsvToRgb;
                this.mColorValue = (clamp((int) (fArr[3] * 255.0f)) << 24) | (hsvToRgb & ViewCompat.MEASURED_SIZE_MASK);
                break;
            case STRING_TYPE:
                b.n("Color does not have a single color to interpolate");
                break;
            case BOOLEAN_TYPE:
                this.mBooleanValue = ((double) fArr[0]) > 0.5d;
                break;
            case DIMENSION_TYPE:
                this.mFloatValue = fArr[0];
                break;
        }
    }

    public CustomAttribute(String str, AttributeType attributeType, Object obj, boolean z9) {
        this.mName = str;
        this.mType = attributeType;
        this.mMethod = z9;
        setValue(obj);
    }

    public CustomAttribute(String str, AttributeType attributeType) {
        this.mMethod = false;
        this.mName = str;
        this.mType = attributeType;
    }

    public void setValue(Object obj) {
        switch (this.mType) {
            case INT_TYPE:
            case REFERENCE_TYPE:
                this.mIntegerValue = ((Integer) obj).intValue();
                break;
            case FLOAT_TYPE:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                this.mColorValue = ((Integer) obj).intValue();
                break;
            case STRING_TYPE:
                this.mStringValue = (String) obj;
                break;
            case BOOLEAN_TYPE:
                this.mBooleanValue = ((Boolean) obj).booleanValue();
                break;
            case DIMENSION_TYPE:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
        }
    }
}
