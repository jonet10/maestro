package androidx.constraintlayout.widget;

import a3.b;
import a4.x;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ConstraintAttribute {
    private static final boolean DEBUG = false;
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

    public ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        this.mMethod = false;
        this.mName = constraintAttribute.mName;
        this.mType = constraintAttribute.mType;
        setValue(obj);
    }

    private static int clamp(int i) {
        int i6 = (i & (~(i >> 31))) - 255;
        return (i6 & (i6 >> 31)) + 255;
    }

    public static HashMap<String, ConstraintAttribute> extractAttributes(HashMap<String, ConstraintAttribute> hashMap, View view) {
        HashMap<String, ConstraintAttribute> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    hashMap2.put(str, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    hashMap2.put(str, new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + str, null).invoke(view, null)));
                }
            } catch (IllegalAccessException e10) {
                StringBuilder v = x.v(" Custom Attribute \"", str, "\" not found on ");
                v.append(cls.getName());
                Log.e(TAG, v.toString(), e10);
            } catch (NoSuchMethodException e11) {
                Log.e(TAG, cls.getName() + " must have a method " + str, e11);
            } catch (InvocationTargetException e12) {
                StringBuilder v9 = x.v(" Custom Attribute \"", str, "\" not found on ");
                v9.append(cls.getName());
                Log.e(TAG, v9.toString(), e12);
            }
        }
        return hashMap2;
    }

    public static void parse(Context context, XmlPullParser xmlPullParser, HashMap<String, ConstraintAttribute> hashMap) {
        AttributeType attributeType;
        Object valueOf;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        AttributeType attributeType2 = null;
        boolean z9 = false;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == R.styleable.CustomAttribute_methodName) {
                str = obtainStyledAttributes.getString(index);
                z9 = true;
            } else if (index == R.styleable.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                attributeType2 = AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == R.styleable.CustomAttribute_customColorValue) {
                    attributeType = AttributeType.COLOR_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customColorDrawableValue) {
                    attributeType = AttributeType.COLOR_DRAWABLE_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customPixelDimension) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    valueOf = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == R.styleable.CustomAttribute_customDimension) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.CustomAttribute_customFloatValue) {
                    attributeType = AttributeType.FLOAT_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R.styleable.CustomAttribute_customIntegerValue) {
                    attributeType = AttributeType.INT_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == R.styleable.CustomAttribute_customStringValue) {
                    attributeType = AttributeType.STRING_TYPE;
                    valueOf = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.CustomAttribute_customReference) {
                    attributeType = AttributeType.REFERENCE_TYPE;
                    int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    valueOf = Integer.valueOf(resourceId);
                }
                Object obj2 = valueOf;
                attributeType2 = attributeType;
                obj = obj2;
            }
        }
        if (str != null && obj != null) {
            hashMap.put(str, new ConstraintAttribute(str, attributeType2, obj, z9));
        }
        obtainStyledAttributes.recycle();
    }

    public static void setAttributes(View view, HashMap<String, ConstraintAttribute> hashMap) {
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(str);
            String j = !constraintAttribute.mMethod ? x.j("set", str) : str;
            try {
                int ordinal = constraintAttribute.mType.ordinal();
                Class<?> cls2 = Float.TYPE;
                Class<?> cls3 = Integer.TYPE;
                switch (ordinal) {
                    case 0:
                        cls.getMethod(j, cls3).invoke(view, Integer.valueOf(constraintAttribute.mIntegerValue));
                        break;
                    case 1:
                        cls.getMethod(j, cls2).invoke(view, Float.valueOf(constraintAttribute.mFloatValue));
                        break;
                    case 2:
                        cls.getMethod(j, cls3).invoke(view, Integer.valueOf(constraintAttribute.mColorValue));
                        break;
                    case 3:
                        Method method = cls.getMethod(j, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.mColorValue);
                        method.invoke(view, colorDrawable);
                        break;
                    case 4:
                        cls.getMethod(j, CharSequence.class).invoke(view, constraintAttribute.mStringValue);
                        break;
                    case 5:
                        cls.getMethod(j, Boolean.TYPE).invoke(view, Boolean.valueOf(constraintAttribute.mBooleanValue));
                        break;
                    case 6:
                        cls.getMethod(j, cls2).invoke(view, Float.valueOf(constraintAttribute.mFloatValue));
                        break;
                    case 7:
                        cls.getMethod(j, cls3).invoke(view, Integer.valueOf(constraintAttribute.mIntegerValue));
                        break;
                }
            } catch (IllegalAccessException e10) {
                StringBuilder v = x.v(" Custom Attribute \"", str, "\" not found on ");
                v.append(cls.getName());
                Log.e(TAG, v.toString(), e10);
            } catch (NoSuchMethodException e11) {
                Log.e(TAG, cls.getName() + " must have a method " + j, e11);
            } catch (InvocationTargetException e12) {
                StringBuilder v9 = x.v(" Custom Attribute \"", str, "\" not found on ");
                v9.append(cls.getName());
                Log.e(TAG, v9.toString(), e12);
            }
        }
    }

    public void applyCustom(View view) {
        Class<?> cls = view.getClass();
        String str = this.mName;
        String j = !this.mMethod ? x.j("set", str) : str;
        try {
            int ordinal = this.mType.ordinal();
            Class<?> cls2 = Integer.TYPE;
            Class<?> cls3 = Float.TYPE;
            switch (ordinal) {
                case 0:
                case 7:
                    cls.getMethod(j, cls2).invoke(view, Integer.valueOf(this.mIntegerValue));
                    break;
                case 1:
                    cls.getMethod(j, cls3).invoke(view, Float.valueOf(this.mFloatValue));
                    break;
                case 2:
                    cls.getMethod(j, cls2).invoke(view, Integer.valueOf(this.mColorValue));
                    break;
                case 3:
                    Method method = cls.getMethod(j, Drawable.class);
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(this.mColorValue);
                    method.invoke(view, colorDrawable);
                    break;
                case 4:
                    cls.getMethod(j, CharSequence.class).invoke(view, this.mStringValue);
                    break;
                case 5:
                    cls.getMethod(j, Boolean.TYPE).invoke(view, Boolean.valueOf(this.mBooleanValue));
                    break;
                case 6:
                    cls.getMethod(j, cls3).invoke(view, Float.valueOf(this.mFloatValue));
                    break;
            }
        } catch (IllegalAccessException e10) {
            StringBuilder v = x.v(" Custom Attribute \"", str, "\" not found on ");
            v.append(cls.getName());
            Log.e(TAG, v.toString(), e10);
        } catch (NoSuchMethodException e11) {
            Log.e(TAG, cls.getName() + " must have a method " + j, e11);
        } catch (InvocationTargetException e12) {
            StringBuilder v9 = x.v(" Custom Attribute \"", str, "\" not found on ");
            v9.append(cls.getName());
            Log.e(TAG, v9.toString(), e12);
        }
    }

    public boolean diff(ConstraintAttribute constraintAttribute) {
        AttributeType attributeType;
        if (constraintAttribute != null && (attributeType = this.mType) == constraintAttribute.mType) {
            switch (attributeType) {
                case INT_TYPE:
                case REFERENCE_TYPE:
                    if (this.mIntegerValue == constraintAttribute.mIntegerValue) {
                        return true;
                    }
                    break;
                case FLOAT_TYPE:
                    return this.mFloatValue == constraintAttribute.mFloatValue;
                case COLOR_TYPE:
                case COLOR_DRAWABLE_TYPE:
                    return this.mColorValue == constraintAttribute.mColorValue;
                case STRING_TYPE:
                    return this.mIntegerValue == constraintAttribute.mIntegerValue;
                case BOOLEAN_TYPE:
                    return this.mBooleanValue == constraintAttribute.mBooleanValue;
                case DIMENSION_TYPE:
                    return this.mFloatValue == constraintAttribute.mFloatValue;
                default:
                    return false;
            }
        }
        return false;
    }

    public int getColorValue() {
        return this.mColorValue;
    }

    public float getFloatValue() {
        return this.mFloatValue;
    }

    public int getIntegerValue() {
        return this.mIntegerValue;
    }

    public String getName() {
        return this.mName;
    }

    public String getStringValue() {
        return this.mStringValue;
    }

    public AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (this.mType) {
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                b.n("Color does not have a single color to interpolate");
                break;
            case STRING_TYPE:
                b.n("Cannot interpolate String");
                break;
            case BOOLEAN_TYPE:
                if (this.mBooleanValue) {
                }
                break;
        }
        return 0.0f;
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

    public boolean isBooleanValue() {
        return this.mBooleanValue;
    }

    public boolean isContinuous() {
        int ordinal = this.mType.ordinal();
        return (ordinal == 4 || ordinal == 5 || ordinal == 7) ? false : true;
    }

    public boolean isMethod() {
        return this.mMethod;
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
                int HSVToColor = Color.HSVToColor(fArr);
                this.mColorValue = HSVToColor;
                this.mColorValue = (clamp((int) (fArr[3] * 255.0f)) << 24) | (HSVToColor & ViewCompat.MEASURED_SIZE_MASK);
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

    public ConstraintAttribute(String str, AttributeType attributeType, Object obj, boolean z9) {
        this.mName = str;
        this.mType = attributeType;
        this.mMethod = z9;
        setValue(obj);
    }

    public ConstraintAttribute(String str, AttributeType attributeType) {
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
