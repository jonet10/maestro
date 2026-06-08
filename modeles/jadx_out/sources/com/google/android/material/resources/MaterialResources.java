package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class MaterialResources {
    private static final float FONT_SCALE_1_3 = 1.3f;
    private static final float FONT_SCALE_2_0 = 2.0f;

    private MaterialResources() {
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i) {
        int resourceId;
        ColorStateList colorStateList;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateList;
    }

    private static int getComplexUnit(TypedValue typedValue) {
        return typedValue.getComplexUnit();
    }

    public static int getDimensionPixelSize(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i, int i6) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i, i6);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i6);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i) {
        int resourceId;
        Drawable drawable;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawable = AppCompatResources.getDrawable(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawable;
    }

    public static float getFontScale(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale;
    }

    @StyleableRes
    public static int getIndexWithValue(@NonNull TypedArray typedArray, @StyleableRes int i, @StyleableRes int i6) {
        return typedArray.hasValue(i) ? i : i6;
    }

    @Nullable
    public static TextAppearance getTextAppearance(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return new TextAppearance(context, resourceId);
    }

    public static int getUnscaledLineHeight(@NonNull Context context, @StyleRes int i, int i6) {
        if (i != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.MaterialTextAppearance);
            TypedValue typedValue = new TypedValue();
            boolean value = obtainStyledAttributes.getValue(R.styleable.MaterialTextAppearance_lineHeight, typedValue);
            if (!value) {
                value = obtainStyledAttributes.getValue(R.styleable.MaterialTextAppearance_android_lineHeight, typedValue);
            }
            obtainStyledAttributes.recycle();
            if (value) {
                int complexUnit = getComplexUnit(typedValue);
                int i10 = typedValue.data;
                return complexUnit == 2 ? Math.round(TypedValue.complexToFloat(i10) * context.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(i10, context.getResources().getDisplayMetrics());
            }
        }
        return i6;
    }

    public static int getUnscaledTextSize(@NonNull Context context, @StyleRes int i, int i6) {
        if (i != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, androidx.appcompat.R.styleable.TextAppearance);
            TypedValue typedValue = new TypedValue();
            boolean value = obtainStyledAttributes.getValue(androidx.appcompat.R.styleable.TextAppearance_android_textSize, typedValue);
            obtainStyledAttributes.recycle();
            if (value) {
                int complexUnit = getComplexUnit(typedValue);
                int i10 = typedValue.data;
                return complexUnit == 2 ? Math.round(TypedValue.complexToFloat(i10) * context.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(i10, context.getResources().getDisplayMetrics());
            }
        }
        return i6;
    }

    public static boolean isFontScaleAtLeast1_3(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale >= FONT_SCALE_1_3;
    }

    public static boolean isFontScaleAtLeast2_0(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale >= FONT_SCALE_2_0;
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context context, @NonNull TintTypedArray tintTypedArray, @StyleableRes int i) {
        int resourceId;
        ColorStateList colorStateList;
        return (!tintTypedArray.hasValue(i) || (resourceId = tintTypedArray.getResourceId(i, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) ? tintTypedArray.getColorStateList(i) : colorStateList;
    }
}
