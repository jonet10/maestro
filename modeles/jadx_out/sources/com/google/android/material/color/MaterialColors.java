package com.google.android.material.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.color.utilities.Blend;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.resources.MaterialAttributes;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;
    private static final int CHROMA_NEUTRAL = 6;
    private static final int TONE_ACCENT_CONTAINER_DARK = 30;
    private static final int TONE_ACCENT_CONTAINER_LIGHT = 90;
    private static final int TONE_ACCENT_DARK = 80;
    private static final int TONE_ACCENT_LIGHT = 40;
    private static final int TONE_ON_ACCENT_CONTAINER_DARK = 90;
    private static final int TONE_ON_ACCENT_CONTAINER_LIGHT = 10;
    private static final int TONE_ON_ACCENT_DARK = 20;
    private static final int TONE_ON_ACCENT_LIGHT = 100;
    private static final int TONE_SURFACE_CONTAINER_DARK = 12;
    private static final int TONE_SURFACE_CONTAINER_HIGH_DARK = 17;
    private static final int TONE_SURFACE_CONTAINER_HIGH_LIGHT = 92;
    private static final int TONE_SURFACE_CONTAINER_LIGHT = 94;

    private MaterialColors() {
    }

    @ColorInt
    public static int compositeARGBWithAlpha(@ColorInt int i, @IntRange(from = 0, to = 255) int i6) {
        return ColorUtils.setAlphaComponent(i, (Color.alpha(i) * i6) / 255);
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i) {
        return resolveColor(view.getContext(), MaterialAttributes.resolveTypedValueOrThrow(view, i));
    }

    @Nullable
    @ColorInt
    public static Integer getColorOrNull(@NonNull Context context, @AttrRes int i) {
        TypedValue resolve = MaterialAttributes.resolve(context, i);
        if (resolve != null) {
            return Integer.valueOf(resolveColor(context, resolve));
        }
        return null;
    }

    @ColorInt
    private static int getColorRole(@ColorInt int i, @IntRange(from = 0, to = 100) int i6, int i10) {
        Hct fromInt = Hct.fromInt(getColorRole(i, i6));
        fromInt.setChroma(i10);
        return fromInt.toInt();
    }

    @NonNull
    public static ColorRoles getColorRoles(@ColorInt int i, boolean z9) {
        return z9 ? new ColorRoles(getColorRole(i, 40), getColorRole(i, 100), getColorRole(i, 90), getColorRole(i, 10)) : new ColorRoles(getColorRole(i, TONE_ACCENT_DARK), getColorRole(i, 20), getColorRole(i, 30), getColorRole(i, 90));
    }

    @NonNull
    public static ColorStateList getColorStateList(@NonNull Context context, @AttrRes int i, @NonNull ColorStateList colorStateList) {
        TypedValue resolve = MaterialAttributes.resolve(context, i);
        ColorStateList resolveColorStateList = resolve != null ? resolveColorStateList(context, resolve) : null;
        return resolveColorStateList == null ? colorStateList : resolveColorStateList;
    }

    @Nullable
    public static ColorStateList getColorStateListOrNull(@NonNull Context context, @AttrRes int i) {
        TypedValue resolve = MaterialAttributes.resolve(context, i);
        if (resolve == null) {
            return null;
        }
        int i6 = resolve.resourceId;
        if (i6 != 0) {
            return ContextCompat.getColorStateList(context, i6);
        }
        int i10 = resolve.data;
        if (i10 != 0) {
            return ColorStateList.valueOf(i10);
        }
        return null;
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int getSurfaceContainerFromSeed(@NonNull Context context, @ColorInt int i) {
        return getColorRole(i, isLightTheme(context) ? TONE_SURFACE_CONTAINER_LIGHT : 12, 6);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int getSurfaceContainerHighFromSeed(@NonNull Context context, @ColorInt int i) {
        return getColorRole(i, isLightTheme(context) ? TONE_SURFACE_CONTAINER_HIGH_LIGHT : 17, 6);
    }

    @ColorInt
    public static int harmonize(@ColorInt int i, @ColorInt int i6) {
        return Blend.harmonize(i, i6);
    }

    @ColorInt
    public static int harmonizeWithPrimary(@NonNull Context context, @ColorInt int i) {
        return harmonize(i, getColor(context, R.attr.colorPrimary, MaterialColors.class.getCanonicalName()));
    }

    public static boolean isColorLight(@ColorInt int i) {
        return i != 0 && ColorUtils.calculateLuminance(i) > 0.5d;
    }

    public static boolean isLightTheme(@NonNull Context context) {
        return MaterialAttributes.resolveBoolean(context, R.attr.isLightTheme, true);
    }

    @ColorInt
    public static int layer(@ColorInt int i, @ColorInt int i6, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return layer(i, ColorUtils.setAlphaComponent(i6, Math.round(Color.alpha(i6) * f)));
    }

    private static int resolveColor(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i = typedValue.resourceId;
        return i != 0 ? ContextCompat.getColor(context, i) : typedValue.data;
    }

    private static ColorStateList resolveColorStateList(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i = typedValue.resourceId;
        return i != 0 ? ContextCompat.getColorStateList(context, i) : ColorStateList.valueOf(typedValue.data);
    }

    @ColorInt
    public static int getColor(Context context, @AttrRes int i, String str) {
        return resolveColor(context, MaterialAttributes.resolveTypedValueOrThrow(context, i, str));
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i, @ColorInt int i6) {
        return getColor(view.getContext(), i, i6);
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @AttrRes int i, @ColorInt int i6) {
        Integer colorOrNull = getColorOrNull(context, i);
        return colorOrNull != null ? colorOrNull.intValue() : i6;
    }

    @ColorInt
    private static int getColorRole(@ColorInt int i, @IntRange(from = 0, to = 100) int i6) {
        Hct fromInt = Hct.fromInt(i);
        fromInt.setTone(i6);
        return fromInt.toInt();
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i, @AttrRes int i6, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return layer(getColor(view, i), getColor(view, i6), f);
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i, @AttrRes int i6) {
        return layer(view, i, i6, 1.0f);
    }

    @ColorInt
    public static int layer(@ColorInt int i, @ColorInt int i6) {
        return ColorUtils.compositeColors(i6, i);
    }

    @NonNull
    public static ColorRoles getColorRoles(@NonNull Context context, @ColorInt int i) {
        return getColorRoles(i, isLightTheme(context));
    }
}
