package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import d7.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TypedArrayKt {
    private static final void checkAttribute(TypedArray typedArray, @StyleableRes int i) {
        if (typedArray.hasValue(i)) {
            return;
        }
        com.google.gson.internal.a.p("Attribute not defined in set.");
    }

    public static final boolean getBooleanOrThrow(TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getBoolean(i, false);
    }

    @ColorInt
    public static final int getColorOrThrow(TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getColor(i, 0);
    }

    public static final ColorStateList getColorStateListOrThrow(TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        ColorStateList colorStateList = typedArray.getColorStateList(i);
        if (colorStateList != null) {
            return colorStateList;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Attribute value was not a color or color state list.");
        return null;
    }

    public static final float getDimensionOrThrow(TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getDimension(i, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getDimensionPixelOffset(i, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getDimensionPixelSize(i, 0);
    }

    public static final Drawable getDrawableOrThrow(TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        Drawable drawable = typedArray.getDrawable(i);
        drawable.getClass();
        return drawable;
    }

    public static final float getFloatOrThrow(TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getFloat(i, 0.0f);
    }

    @RequiresApi(26)
    public static final Typeface getFontOrThrow(TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return TypedArrayApi26ImplKt.getFont(typedArray, i);
    }

    public static final int getIntOrThrow(TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getInt(i, 0);
    }

    public static final int getIntegerOrThrow(TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getInteger(i, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getResourceId(i, 0);
    }

    public static final String getStringOrThrow(TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        String string = typedArray.getString(i);
        if (string != null) {
            return string;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Attribute value could not be coerced to String.");
        return null;
    }

    public static final CharSequence[] getTextArrayOrThrow(TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        return typedArray.getTextArray(i);
    }

    public static final CharSequence getTextOrThrow(TypedArray typedArray, @StyleableRes int i) {
        checkAttribute(typedArray, i);
        CharSequence text = typedArray.getText(i);
        if (text != null) {
            return text;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Attribute value could not be coerced to CharSequence.");
        return null;
    }

    public static final <R> R use(TypedArray typedArray, l lVar) {
        R r9 = (R) lVar.invoke(typedArray);
        typedArray.recycle();
        return r9;
    }
}
