package androidx.constraintlayout.core.motion;

import a3.b;
import a4.x;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.transition.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class CustomVariable {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private float mFloatValue;
    private int mIntegerValue;
    String mName;
    private String mStringValue;
    private int mType;

    public CustomVariable(CustomVariable customVariable) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = customVariable.mName;
        this.mType = customVariable.mType;
        this.mIntegerValue = customVariable.mIntegerValue;
        this.mFloatValue = customVariable.mFloatValue;
        this.mStringValue = customVariable.mStringValue;
        this.mBooleanValue = customVariable.mBooleanValue;
    }

    private static int clamp(int i) {
        int i6 = (i & (~(i >> 31))) - 255;
        return (i6 & (i6 >> 31)) + 255;
    }

    public static String colorString(int i) {
        return "#".concat(("00000000" + Integer.toHexString(i)).substring(r2.length() - 8));
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

    public static int rgbaTocColor(float f, float f10, float f11, float f12) {
        int clamp = clamp((int) (f * 255.0f));
        int clamp2 = clamp((int) (f10 * 255.0f));
        return (clamp << 16) | (clamp((int) (f12 * 255.0f)) << 24) | (clamp2 << 8) | clamp((int) (f11 * 255.0f));
    }

    public void applyToWidget(MotionWidget motionWidget) {
        int i = this.mType;
        switch (i) {
            case 900:
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                motionWidget.setCustomAttribute(this.mName, i, this.mIntegerValue);
                break;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                motionWidget.setCustomAttribute(this.mName, i, this.mFloatValue);
                break;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                motionWidget.setCustomAttribute(this.mName, i, this.mStringValue);
                break;
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                motionWidget.setCustomAttribute(this.mName, i, this.mBooleanValue);
                break;
        }
    }

    public CustomVariable copy() {
        return new CustomVariable(this);
    }

    public boolean diff(CustomVariable customVariable) {
        int i;
        if (customVariable != null && (i = this.mType) == customVariable.mType) {
            switch (i) {
                case 900:
                case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                    if (this.mIntegerValue == customVariable.mIntegerValue) {
                        return true;
                    }
                    break;
                case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                    return this.mFloatValue == customVariable.mFloatValue;
                case TypedValues.Custom.TYPE_COLOR /* 902 */:
                    return this.mIntegerValue == customVariable.mIntegerValue;
                case TypedValues.Custom.TYPE_STRING /* 903 */:
                    return this.mIntegerValue == customVariable.mIntegerValue;
                case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                    return this.mBooleanValue == customVariable.mBooleanValue;
                case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                    return this.mFloatValue == customVariable.mFloatValue;
                default:
                    return false;
            }
        }
        return false;
    }

    public boolean getBooleanValue() {
        return this.mBooleanValue;
    }

    public int getColorValue() {
        return this.mIntegerValue;
    }

    public float getFloatValue() {
        return this.mFloatValue;
    }

    public int getIntegerValue() {
        return this.mIntegerValue;
    }

    public int getInterpolatedColor(float[] fArr) {
        return (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public String getName() {
        return this.mName;
    }

    public String getStringValue() {
        return this.mStringValue;
    }

    public int getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (this.mType) {
            case 900:
                return this.mIntegerValue;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                return this.mFloatValue;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                b.n("Color does not have a single color to interpolate");
                return 0.0f;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                b.n("Cannot interpolate String");
                return 0.0f;
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                return this.mBooleanValue ? 1.0f : 0.0f;
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                return this.mFloatValue;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        switch (this.mType) {
            case 900:
                fArr[0] = this.mIntegerValue;
                break;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                fArr[0] = this.mFloatValue;
                break;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                int i = (this.mIntegerValue >> 24) & 255;
                float pow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float pow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = pow3;
                fArr[3] = i / 255.0f;
                break;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                b.n("Cannot interpolate String");
                break;
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                fArr[0] = this.mBooleanValue ? 1.0f : 0.0f;
                break;
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                fArr[0] = this.mFloatValue;
                break;
        }
    }

    public boolean isContinuous() {
        int i = this.mType;
        return (i == 903 || i == 904 || i == 906) ? false : true;
    }

    public int numberOfInterpolatedValues() {
        return this.mType != 902 ? 1 : 4;
    }

    public void setBooleanValue(boolean z9) {
        this.mBooleanValue = z9;
    }

    public void setFloatValue(float f) {
        this.mFloatValue = f;
    }

    public void setIntValue(int i) {
        this.mIntegerValue = i;
    }

    public void setInterpolatedValue(MotionWidget motionWidget, float[] fArr) {
        int i = this.mType;
        switch (i) {
            case 900:
                motionWidget.setCustomAttribute(this.mName, i, (int) fArr[0]);
                break;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                motionWidget.setCustomAttribute(this.mName, i, fArr[0]);
                break;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                motionWidget.setCustomAttribute(this.mName, this.mType, (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f)));
                break;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                c.a(this.mName, "unable to interpolate ");
                break;
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                motionWidget.setCustomAttribute(this.mName, i, fArr[0] > 0.5f);
                break;
        }
    }

    public void setStringValue(String str) {
        this.mStringValue = str;
    }

    public void setValue(float[] fArr) {
        switch (this.mType) {
            case 900:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                this.mIntegerValue = (int) fArr[0];
                break;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                this.mFloatValue = fArr[0];
                break;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                this.mIntegerValue = ((Math.round(fArr[3] * 255.0f) & 255) << 24) | ((Math.round(((float) Math.pow(fArr[0], 0.5d)) * 255.0f) & 255) << 16) | ((Math.round(((float) Math.pow(fArr[1], 0.5d)) * 255.0f) & 255) << 8) | (Math.round(((float) Math.pow(fArr[2], 0.5d)) * 255.0f) & 255);
                break;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                b.n("Cannot interpolate String");
                break;
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                this.mBooleanValue = ((double) fArr[0]) > 0.5d;
                break;
        }
    }

    public String toString() {
        String m10 = x.m(new StringBuilder(), this.mName, ':');
        switch (this.mType) {
            case 900:
                StringBuilder t9 = x.t(m10);
                t9.append(this.mIntegerValue);
                return t9.toString();
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                StringBuilder t10 = x.t(m10);
                t10.append(this.mFloatValue);
                return t10.toString();
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                StringBuilder t11 = x.t(m10);
                t11.append(colorString(this.mIntegerValue));
                return t11.toString();
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                StringBuilder t12 = x.t(m10);
                t12.append(this.mStringValue);
                return t12.toString();
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                StringBuilder t13 = x.t(m10);
                t13.append(Boolean.valueOf(this.mBooleanValue));
                return t13.toString();
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                StringBuilder t14 = x.t(m10);
                t14.append(this.mFloatValue);
                return t14.toString();
            default:
                return m10.concat("????");
        }
    }

    public CustomVariable(String str, int i, String str2) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mName = str;
        this.mType = i;
        this.mStringValue = str2;
    }

    public CustomVariable(String str, int i, int i6) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i;
        if (i == 901) {
            this.mFloatValue = i6;
        } else {
            this.mIntegerValue = i6;
        }
    }

    public CustomVariable(String str, int i, float f) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i;
        this.mFloatValue = f;
    }

    public CustomVariable(String str, int i, boolean z9) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i;
        this.mBooleanValue = z9;
    }

    public CustomVariable(String str, int i) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i;
    }

    public CustomVariable(String str, int i, Object obj) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = str;
        this.mType = i;
        setValue(obj);
    }

    public CustomVariable(CustomVariable customVariable, Object obj) {
        this.mIntegerValue = Integer.MIN_VALUE;
        this.mFloatValue = Float.NaN;
        this.mStringValue = null;
        this.mName = customVariable.mName;
        this.mType = customVariable.mType;
        setValue(obj);
    }

    public void setValue(Object obj) {
        switch (this.mType) {
            case 900:
            case TypedValues.Custom.TYPE_REFERENCE /* 906 */:
                this.mIntegerValue = ((Integer) obj).intValue();
                break;
            case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
            case TypedValues.Custom.TYPE_COLOR /* 902 */:
                this.mIntegerValue = ((Integer) obj).intValue();
                break;
            case TypedValues.Custom.TYPE_STRING /* 903 */:
                this.mStringValue = (String) obj;
                break;
            case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                this.mBooleanValue = ((Boolean) obj).booleanValue();
                break;
            case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
        }
    }
}
